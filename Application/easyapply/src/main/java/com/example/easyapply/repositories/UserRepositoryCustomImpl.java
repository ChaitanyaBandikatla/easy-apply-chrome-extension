package com.example.easyapply.repositories;

import com.example.easyapply.entities.UserDetailsEntity;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.cfg.Configuration;

import java.util.Optional;
@org.springframework.context.annotation.Configuration
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    /**
     * Finds a user entity with matching user name
     * @param userName
     * @return
     */
    public Optional<UserDetailsEntity> findUserByUserName(String userName){
        Criteria criteria = sessionFactory.openSession().createCriteria(UserDetailsEntity.class);
        UserDetailsEntity userDetailsEntity = (UserDetailsEntity) criteria.add(Restrictions.eq("username", userName)).uniqueResult();
        return Optional.ofNullable(userDetailsEntity);
    }
}
