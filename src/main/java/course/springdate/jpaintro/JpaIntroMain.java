package course.springdate.jpaintro;

import course.springdate.jpaintro.entity.Student;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaIntroMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school_jpa");
        EntityManager em = emf.createEntityManager();
        Student student = new Student("Gimitar Pavlov");

        // CREATE new student into DB
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();

        em.getTransaction().begin();
        Student student1 = em.find(Student.class, 4L);
        em.getTransaction().commit();



        // REMOVE student from DB
//        em.getTransaction().begin();
//        em.remove(student1);
//        em.getTransaction().commit();

//        em.getTransaction().begin();
//        Student student1 = em.find(Student.class, 1L);
//        System.out.println(student1.getName() + student1.getRegistrationDate());
//        em.getTransaction().commit();

//        em.getTransaction().begin();
//        em.createQuery("SELECT s FROM Student s WHERE s.name LIKE ?1")
//                .setParameter(1, "G%")
//                .getResultList().forEach(System.out::println);
//
//        em.getTransaction().commit();


        // UPDATE EXISTING ROW student in DB
        em.getTransaction().begin();
        student1.setName("ALI ZINAL");
       // em.merge(student1);
        em.getTransaction().commit();
        em.close();

    }



}
