package com.dnabrd04.apiserver.service;

import com.dnabrd04.apiserver.model.Resource;
import com.dnabrd04.apiserver.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class will be used to do all the database operations of the Comment class.
 *
 * @author dnabrd04
 */
@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    /**
     * Create and return a resource of the database.
     * @param resource to create.
     * @return the resource created.
     */
    public Resource createResource(Resource resource) {
        return resourceRepository.save(resource);
    }

    /**
     * Get a list with all the resources of a specific post.
     * @param id of the post.
     * @return a list with the resources.
     */
    public List<Resource> getResourcesByPost(Long id) {
        return resourceRepository.getResourcesByPost(id);
    }

    /**
     * Delete a resource of the database.
     * @param id of the resource to delete.
     */
    public void deleteResource(Long id) {
        resourceRepository.deleteById(id);
    }

    /**
     * Delete resources by the post id of the database.
     * @param id of the post.
     */
    public void deleteResourceByPost(Long id) {
        resourceRepository.deleteByPostId(id);
    }
}
