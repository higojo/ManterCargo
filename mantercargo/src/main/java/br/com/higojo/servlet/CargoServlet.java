package br.com.higojo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.higojo.enumeration.CBOEnum;
import br.com.higojo.enumeration.SituacaoEnum;
import br.com.higojo.model.Cargo;
import br.com.higojo.model.Categoria;
import br.com.higojo.model.Subcategoria;
import br.com.higojo.repository.ManterCargoRepository;
import br.com.higojo.util.StringUtil;
/**
 * 
 * Controller do sistema
 * @author higojo
 *
 */
@WebServlet(urlPatterns="/cargoServlet")
public class CargoServlet extends HttpServlet {

	private static final long serialVersionUID = -8720094171603113486L;
	// Constante
	private static final String TEXTO_SELECIONE = "Selecione...";
	// Injetando repository
	ManterCargoRepository repository = new ManterCargoRepository();
	
    public CargoServlet() {
        super();
    }

    // Método acessado quando for disparada requisição GET
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		Cargo cargo = inicializaObjeto();
		// Gerenciamento da requisição GET
		if(StringUtil.ok(request.getParameter("acao")) && request.getParameter("acao").equalsIgnoreCase("novo")) {
			// Quando a requisição for de Adicionar Novo
			// Redireciona para tela de cadastro em modo inclusão
			dispatcher = request.getRequestDispatcher("adicionar-cargo.jsp");
			// Recupera todas categorias, envia pro frontend e popula o combo
			List<Categoria> categorias = repository.buscarTodasCategorias();
			request.setAttribute("listaCategorias", categorias);
			request.getSession().removeAttribute("idCargoParaEdicao");
		} else if (StringUtil.ok(request.getParameter("acao")) && request.getParameter("acao").equalsIgnoreCase("editar")) {
			// Quando a requisição for de Edição
			if(StringUtil.ok(request.getParameter("idEdit"))) {
				// Carrega objeto cargo do banco
				cargo = repository.getEntityManager().find(Cargo.class, new Integer(request.getParameter("idEdit")));
				// Redireciona para tela de cadastro em modo edição
				dispatcher = request.getRequestDispatcher("adicionar-cargo.jsp");
				// Recupera todas categorias, envia pro frontend e popula o combo
				List<Categoria> categorias = repository.buscarTodasCategorias();
				request.setAttribute("listaCategorias", categorias);
				request.getSession().setAttribute("idCargoParaEdicao", request.getParameter("idEdit"));
			}
		} else if (StringUtil.ok(request.getParameter("acao")) && request.getParameter("acao").equalsIgnoreCase("excluir")) {
			// Quando a requisição for de Exclusão
			// Recupera cargo, exclui, retorna para tela inicial e carrega tabela de cargos sem filtragem
			if(StringUtil.ok(request.getParameter("idExc"))) {
				cargo = repository.getEntityManager().find(Cargo.class, new Integer(request.getParameter("idExc")));
				repository.excluir(cargo);
				dispatcher = request.getRequestDispatcher("index.jsp");
				List<Cargo> cargos = repository.pesquisarCargos(null, null, null, null);
				request.setAttribute("listaCargos", cargos);
			}
		} else {
			// Página inicial
			// Recupera valores digitados nos campos de filtro
			String nomeFiltro = request.getParameter("nomeFiltro");
			String cboFiltro = request.getParameter("cboFiltro");
			String codFolhaFiltro = request.getParameter("codFolhaFiltro");
			String opcoesFiltro = request.getParameter("opcoesFiltro");
			dispatcher = request.getRequestDispatcher("index.jsp");
			// Carrega tabela de cargos com filtragem
			List<Cargo> cargos = repository.pesquisarCargos(nomeFiltro, cboFiltro, codFolhaFiltro, opcoesFiltro);
			request.setAttribute("listaCargos", cargos);
		}
		request.setAttribute("cargoEdicao", cargo);
		// Retorna o request e o response para o frontend
		dispatcher.forward(request, response);
	}

	// Método acessado quando for disparada requisição POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Cargo cargo;
			String idCargo = "";
			if(request.getSession().getAttribute("idCargoParaEdicao") != null) {
				idCargo = request.getSession().getAttribute("idCargoParaEdicao").toString();
			}
					
			if(StringUtil.ok(idCargo)) {
				// Quando for Edição
				cargo = repository.getEntityManager().find(Cargo.class, new Integer(idCargo));
				cargo = atualizaObjeto(request, cargo);
				repository.edit(cargo);
			} else {
				// Quando for Novo
				cargo = new Cargo();
				cargo = atualizaObjeto(request, cargo);
				repository.save(cargo);				
			}
			// Retorna para tela inicial e carrega tabela de cargos sem filtragem
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			List<Cargo> cargos = repository.pesquisarCargos(null, null, null, null);
			request.setAttribute("listaCargos", cargos);
			dispatcher.forward(request, response);
    	} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Método para montar e/ou atualizar o objeto cargo para transação
	 * @param request
	 * @param cargo
	 * @return Cargo
	 */
	private Cargo atualizaObjeto(HttpServletRequest request, Cargo cargo) {
		if(StringUtil.ok(request.getParameter("nome"))) {
			cargo.setNome(request.getParameter("nome"));
		}
		if(StringUtil.ok(request.getParameter("descricao"))) {
		cargo.setDescricao(request.getParameter("descricao"));
		}
		if(StringUtil.ok(request.getParameter("cbo"))) {
			CBOEnum cbo = null;
			for(CBOEnum item : CBOEnum.values()) {
				if(item.toString().equals(request.getParameter("cbo"))) {
					cbo = item;
					break;
				}
			}
			cargo.setCbo(cbo);
		}
		if(StringUtil.ok(request.getParameter("codFolha"))) {
			cargo.setCodFolha(Long.parseLong(request.getParameter("codFolha")));
		}
		if(StringUtil.ok(request.getParameter("vlHora"))) {
			cargo.setVlHora(Double.parseDouble(request.getParameter("vlHora")));
		}
		if(StringUtil.ok(request.getParameter("hrSemana"))) {
			cargo.setHrSemana(Long.parseLong(request.getParameter("hrSemana")));
		}
		if((StringUtil.ok(request.getParameter("categoria"))) && !(request.getParameter("categoria").equals(TEXTO_SELECIONE))) {
			Categoria categoria = repository.getEntityManager().find(Categoria.class, Integer.parseInt(request.getParameter("categoria")));
			cargo.setCategoria(categoria);
		}
		if(StringUtil.ok(request.getParameter("subcategoria"))) {
			Subcategoria subcategoria = repository.getEntityManager().find(Subcategoria.class, Integer.parseInt(request.getParameter("subcategoria")));
			cargo.setSubcategoria(subcategoria);
		}
		if(StringUtil.ok(request.getParameter("situacao"))) {
			SituacaoEnum situacao = null;
			for(SituacaoEnum item : SituacaoEnum.values()) {
				if(item.toString().equalsIgnoreCase(request.getParameter("situacao"))) {
					situacao = item;
					break;
				}
			}	
			cargo.setSituacao(situacao);
		}
		return cargo;
	}
	
	/**
	 * Método para inicializaçã do objeto Cargo
	 * @return Cargo
	 */
	private Cargo inicializaObjeto() {
		Cargo cargo = new Cargo();
		cargo.setCategoria(new Categoria());
		cargo.setCbo(null);
		cargo.setCodFolha(null);
		cargo.setDescricao("");
		cargo.setHrSemana(null);
		cargo.setNome("");
		cargo.setSituacao(null);
		cargo.setSubcategoria(new Subcategoria());
		cargo.setVlHora(null);
		return cargo;
	}

}
