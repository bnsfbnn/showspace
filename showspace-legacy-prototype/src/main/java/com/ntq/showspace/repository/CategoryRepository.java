package com.ntq.showspace.repository;

import com.ntq.showspace.entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Category save(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(category);
        return category;
    }

    public Category findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Category.class, id);
    }

    public void update(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(category);
    }

    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Category category = session.get(Category.class, id);
        if (category != null) {
            session.remove(category);
        }
    }

}
