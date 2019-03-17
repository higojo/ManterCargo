package br.com.higojo.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 
 * @author higojo
 * Singleton Conection.
 * Classe para inicialização e gerenciamento 
 * da Unidade de Persistência.
 *
 */
@WebListener
public class Manager implements ServletContextListener {
    private static EntityManagerFactory emf;
    @Override
    public void contextInitialized(ServletContextEvent event) {
        emf = Persistence.createEntityManagerFactory("mantercargo");
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        emf.close();
    }
    
    public static EntityManager createEntityManager() {
        if (emf == null) {
            throw new IllegalStateException("Contexto não foi inicializado.");
        }
        return emf.createEntityManager();
    }
}