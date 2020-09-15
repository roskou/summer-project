package com.springshell.tasker.domain.repositories;

import com.springshell.tasker.domain.entities.TasksEntity;
import com.springshell.tasker.domain.entities.UsersEntity;
import com.springshell.tasker.domain.models.TaskModel;
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
            config.addAnnotatedClass(UsersEntity.class);
            config.configure();
            connectionDB = config.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Fallo al crear el objeto" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public List<TasksEntity> findAll()  {
        Session session = connectionDB.openSession();
        List<TasksEntity> tasks = new ArrayList<>();
        try {
            tasks = session.createQuery("select t FROM TasksEntity t", TasksEntity.class).getResultList();
        } catch (Throwable ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return tasks;
    }
    public TasksEntity findById(long id)  {
        Session session = connectionDB.openSession();
        TasksEntity task = null;
        try {
            task = session.get(TasksEntity.class, id);
        } catch (Throwable ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return task;
    }



    public void delete(TasksEntity entity)  {
        Session session = connectionDB.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();

        } catch (Throwable ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }


    public void insertOrUpdate(TasksEntity tasksEntity) {
        Session session = connectionDB.openSession();
        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();
            session.saveOrUpdate(tasksEntity);
            transaction.commit();

        } catch (Throwable ex) {

            ex.printStackTrace();

        } finally {

            session.close();

        }
    }
}