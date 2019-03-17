package br.com.higojo.repository;

import javax.persistence.EntityManager;

import br.com.higojo.manager.Manager;

/**
 * Classe genérica para utilização
 * @author higojo
 * @param <Entity>
 */
public class GenericRepository<Entity> {

    private static final EntityManager entityManager;

    // Recuperando o Entity Manager
    static {
        entityManager = Manager.createEntityManager();
    }

    protected GenericRepository() {
    	
    }

    /**
     * Abre transação
     * Salva entidade
     * Fecha transação
     * @param entity
     */
    public void save(Entity entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.flush();
        entityManager.getTransaction().commit();

    }

    /**
     * Abre transação
     * Atualiza entidade
     * Fecha transação
     * @param entity
     */
    public void edit(Entity entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.flush();
        entityManager.getTransaction().commit();

    }

    /**
     * Abre transação
     * Atualiza e exclui entidade
     * Fecha transação
     * @param entity
     */
    public void excluir(Entity entity) {
        entityManager.getTransaction().begin();
        entity = entityManager.merge(entity);
        entityManager.remove(entity);
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}