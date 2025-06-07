package com.dnabrd04.apiserver.service;

import com.dnabrd04.apiserver.dto.PostDTO;
import com.dnabrd04.apiserver.model.Post;
import com.dnabrd04.apiserver.model.Resource;
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
    public List<PostDTO> getPosts(String currentUser) {
        return postRepository.findAllPostsWithLikeStatus(currentUser);
    }

    /**
     * Get all posts in the database where the user is the user you follow.
     *
     * @param id of the user required to search the post.
     * @param currentUser required to search the post.
     * @return a list with all the posts.
     */
    public List<PostDTO> getPostsDTOFollowed(Long id, String currentUser) {
        return postRepository.findAllPostsWithLikeStatusFollowed(id, currentUser);
    }

    /**
     * Get on post by the id.
     *
     * @param id required to search the post.
     * @return the post.
     */
    public PostDTO getPostDTO(Long id, String currentUser) {
        return postRepository.findPostByIdWithLikeStatus(id, currentUser);
    }

    /**
     * Get a list with all the posts of an user.
     *
     * @param id required to search the post.
     * @return the post.
     */
    public List<PostDTO> getPostsByUser(Long id, String currentUser) {
        return postRepository.findByUserIdWithLikeStatus(id, currentUser);
    }

    /**
     * Create the post with all the information.
     *
     * @param post that will be created.
     * @return the new post.
     */
    public Post createPost(Post post) {
        for (Resource res : post.getResources()) {
            res.setPost(post);
        }
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
