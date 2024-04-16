import models.CredencialEntity;
import models.EstudianteEntity;
import org.apache.logging.log4j.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestCRUD {
    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        // Ejecutar métodos de ejemplo
//        crearEstudiante();
//        crearCredencial();
//        recuperarPorCarnet("RA101621");
//        recuperarCredencialPorUsername("doudy");
//        actualizarEstudiante("RA101621", "Doudy", "Aragon");
//        actualizarCredencial("doudy", "newPassword");
//        eliminarEstudiante("RA101621");
        eliminarCredencial("doudy");
    }

    private static void crearEstudiante() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EstudiantePU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        EstudianteEntity estudiante = new EstudianteEntity("RA101621", "Marvin", "Ramos");
        em.persist(estudiante);
        tx.commit();
        log.debug("Objeto creado: " + estudiante);
        em.close();
    }

    private static void crearCredencial() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EstudiantePU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        CredencialEntity credencial = new CredencialEntity("doudy", "password", true, 2);
        em.persist(credencial);
        tx.commit();
        log.debug("Objeto creado: " + credencial);
        em.close();
    }

    private static void recuperarPorCarnet(String carnet) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EstudiantePU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        EstudianteEntity estudiante = em.createQuery("SELECT e FROM EstudianteEntity e WHERE e.carnet = :carnet", EstudianteEntity.class)
                .setParameter("carnet", carnet)
                .getSingleResult();

        tx.commit(); //Termina la transaccion
        System.out.println("Objeto: " + estudiante);
        em.close();
    }

    private static void recuperarCredencialPorUsername(String username) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EstudiantePU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        CredencialEntity credencial = em.createQuery("SELECT e FROM CredencialEntity e WHERE e.username = :username", CredencialEntity.class)
                .setParameter("username", username)
                .getSingleResult();

        tx.commit(); //Termina la transaccion
        System.out.println("Objeto: " + credencial);
        em.close();
    }
    private static void actualizarEstudiante(String carnet, String nuevoNombre, String nuevoApellido) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EstudiantePU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        EstudianteEntity estudiante = em.createQuery("SELECT e FROM EstudianteEntity e WHERE e.carnet = :carnet", EstudianteEntity.class)
                .setParameter("carnet", carnet)
                .getSingleResult();

        if (estudiante != null) {
            estudiante.setNombres(nuevoNombre);
            estudiante.setApellidos(nuevoApellido);
            em.merge(estudiante);
            tx.commit();
            System.out.println("Estudiante actualizado correctamente.");
        } else {
            System.out.println("No se encontró ningún estudiante con el carné especificado.");
        }

        em.close();
    }

    private static void actualizarCredencial(String username, String nuevaContraseña) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EstudiantePU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        CredencialEntity credencial = em.createQuery("SELECT e FROM CredencialEntity e WHERE e.username = :username", CredencialEntity.class)
                .setParameter("username", username)
                .getSingleResult();

        if (credencial != null) {
            credencial.setPassword(nuevaContraseña);
            em.merge(credencial);
            tx.commit();
            System.out.println("Credencial actualizada correctamente.");
        } else {
            System.out.println("No se encontró ninguna credencial con el nombre de usuario especificado.");
        }

        em.close();
    }

    private static void eliminarEstudiante(String carnet) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EstudiantePU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        EstudianteEntity estudiante = em.createQuery("SELECT e FROM EstudianteEntity e WHERE e.carnet = :carnet", EstudianteEntity.class)
                .setParameter("carnet", carnet)
                .getSingleResult();

        if (estudiante != null) {
            em.remove(estudiante);
            tx.commit();
            System.out.println("Estudiante eliminado correctamente.");
        } else {
            System.out.println("No se encontró ningún estudiante con el carné especificado.");
        }

        em.close();
    }

    private static void eliminarCredencial(String username) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EstudiantePU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        CredencialEntity credencial = em.createQuery("SELECT e FROM CredencialEntity e WHERE e.username = :username", CredencialEntity.class)
                .setParameter("username", username)
                .getSingleResult();

        if (credencial != null) {
            em.remove(credencial);
            tx.commit();
            System.out.println("Credencial eliminada correctamente.");
        } else {
            System.out.println("No se encontró ninguna credencial con el nombre de usuario especificado.");
        }

        em.close();
    }

}
