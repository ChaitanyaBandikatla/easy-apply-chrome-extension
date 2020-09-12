package com.example.easyapply.repositories;

import com.example.easyapply.entities.JobProfileDetailsEntity;
import com.example.easyapply.models.JobProfileModel;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;
import java.util.List;

/**
 * Implementation of custom job profile repository
 */
@Configuration
public class JobProfileCustomImpl implements JobProfileCustom{
    private static SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();

    public List<JobProfileDetailsEntity> findJobProfileByUserId(int userId) {
        Criteria criteria = sessionFactory.openSession().createCriteria(JobProfileDetailsEntity.class);
        criteria.add(Restrictions.eq("userId", userId));
        List result = criteria.list();
        return result;
    }
}
