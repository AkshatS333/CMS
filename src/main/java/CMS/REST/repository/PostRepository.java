package CMS.REST.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import CMS.REST.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
