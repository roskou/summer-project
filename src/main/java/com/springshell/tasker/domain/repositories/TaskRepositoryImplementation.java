package com.springshell.tasker.domain.repositories;

import com.springshell.tasker.domain.entities.TaskEntity;
import com.springshell.tasker.domain.entities.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepositoryImplementation implements TaskRepository{
    private static SessionFactory connectionDB;

    public TaskRepositoryImplementation() {

        try {
            Configuration config = new Configuration();
            config.addAnnotatedClass(UserEntity.class);
            config.configure();
            connectionDB = config.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Fallo al crear el objeto" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }


    public List<TaskEntity> findAll()  {
        Session session = connectionDB.openSession();
        List<TaskEntity> tasks = new ArrayList<>();
        try {
            tasks = session.createQuery("select t FROM TaskEntity t", TaskEntity.class).getResultList();
        } catch (Throwable ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return tasks;
    }
    public TaskEntity findById(long id)  {
        Session session = connectionDB.openSession();
        TaskEntity task = null;
        try {
            task = session.createQuery("select t FROM TaskEntity t WHERE t.id = id", TaskEntity.class).getSingleResult();
        } catch (Throwable ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return task;
    }


    public void insert(TaskEntity object){
        Session session = connectionDB.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(object);
            transaction.commit();
        } catch (Throwable ex) {
            if (transaction != null) transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }
}