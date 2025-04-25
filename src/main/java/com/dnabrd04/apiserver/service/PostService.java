package com.dnabrd04.apiserver.service;

import com.dnabrd04.apiserver.dto.PostDTO;
import com.dnabrd04.apiserver.model.Post;
import com.dnabrd04.apiserver.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class will be used to do all the database operations of the Post class.
 *
 * @author dnabrd04
 */
@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    /**
     * Get all the posts of the database.
     *
     * @return a list with all the posts.
     */
    public List<PostDTO> getPosts() {
        return postRepository.findAllPosts();
    }

    /**
     * Get on post by the id.
     *
     * @param id required to search the post.
     * @return the post.
     */
    public PostDTO getPostDTO(Long id) {
        return postRepository.findPostById(id);
    }

    /**
     * Get on post by the id.
     *
     * @param id required to search the post.
     * @return the post.
     */
    public Post getPost(Long id) {
        return postRepository.getReferenceById(id);
    }

    /**
     * Get a list with all the posts of an user.
     *
     * @param id required to search the post.
     * @return the post.
     */
    public List<PostDTO> getPostsByUser(Long id) {
        return postRepository.findByUser(id);
    }

    /**
     * Create the post with all the information.
     *
     * @param post that will be created.
     * @return the new post.
     */
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    /**
     * Delete a post by the id passed.
     *
     * @param id required to delete a post.
     */
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    /**
     * Update a post by the information passed.
     * 
     * @param post with the new data.
     * @return the post with the new data.
     */
    public Post updatePost(Post post) {
        return postRepository.save(post);
    }
}
