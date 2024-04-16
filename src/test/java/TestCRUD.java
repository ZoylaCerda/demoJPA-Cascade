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
//        crearEstudiante();
        crearCredencial();

    }
    private static void crearEstudiante(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory ("EstudiantePU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
            EstudianteEntity estudiante = new EstudianteEntity ("RA101621", "Marvin", "Ramos");

        em.persist (estudiante);
        tx.commit();
        log.debug("Objeto: " + estudiante);
        em.close();
    }
    private static void crearCredencial(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory ("EstudiantePU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        CredencialEntity credencial = new CredencialEntity ("doudy","password",true,1);

        em.persist (credencial);
        tx.commit();
        log.debug("Objeto: " + credencial);
        em.close();
    }
}
