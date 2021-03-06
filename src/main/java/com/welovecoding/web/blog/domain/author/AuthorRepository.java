package com.welovecoding.web.blog.domain.author;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class AuthorRepository {

  @PersistenceContext(unitName = "WeLoveCodingBlogPersistenceUnit")
  EntityManager em;

  public void save(Author author) {
    em.persist(author);
  }

  public List<Author> getAuthors() {
    TypedQuery<Author> query = em.createNamedQuery(Author.FIND_ALL, Author.class);
    return query.getResultList();
  }

}
