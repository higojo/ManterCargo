package br.com.higojo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.higojo.repository.ManterCargoRepository;
import br.com.higojo.resource.SubcategoriaResource;
import br.com.higojo.util.StringUtil;

/**
 * 
 * Servlet para chamada Ajax
 * @author higojo
 *
 */
@WebServlet(urlPatterns="/subcategoriaServlet")
public class SubcategoriaServlet extends HttpServlet  {

	private static final long serialVersionUID = -7554290646754084276L;
	ManterCargoRepository repository = new ManterCargoRepository();
	
	// Método para carregamento do combo de subcategorias
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(StringUtil.ok(request.getParameter("idCat"))) {
			// Recupera subcategorias por Categoria selecionada
			List<SubcategoriaResource> subcategorias = repository.buscarSubcategoriasPorIdCategoria(Integer.parseInt(request.getParameter("idCat")));
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			// Transformando lista de subcategorias em JSON e enviando para retorno da função Ajax
			Gson gson = new Gson();
			String json = gson.toJson(subcategorias);
			response.getWriter().write(json);
		}
	}

}
