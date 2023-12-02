package com.example.fighting.presistence;

import com.example.fighting.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//  @PersistenceContext
//  private EntityManager em;
//
//  public void save(User user) {
//    em.persist(user);
//  }
//
//  public User findOne(Long id) {
//    return em.find(User.class, id);
//  }

  boolean existsByUsername(final String username);

  boolean existsByNickname(final String nickname);
}
