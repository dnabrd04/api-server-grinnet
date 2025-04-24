package com.dnabrd04.apiserver.controller;

import com.dnabrd04.apiserver.model.Resource;
import com.dnabrd04.apiserver.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    /**
     * Creates a resource.
     * @param resource to be created.
     * @return a ResponseEntity with the resource created.
     */
    @PostMapping
    public ResponseEntity<Resource> createResource(@RequestBody Resource resource) {
        return ResponseEntity.ok(resourceService.createResource(resource));
    }

    /**
     * Get a list with all the resources of a post.
     * @param id of the post.
     * @return a ResponseEntity with a list with the resources.
     */
    @GetMapping("/{id}")
    public ResponseEntity<List<Resource>> getResourcesByPost(@RequestParam Long id) {
        return ResponseEntity.ok(resourceService.getResourcesByPost(id));
    }

    /**
     * Delete a resource.
     * @param id of the resource.
     * @return a ResponseEntity without content.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResource(@RequestParam Long id) {
        resourceService.deleteResource(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Delete the resources of a post.
     * @param id of the post.
     * @return a ResponseEntity without content.
     */
    @DeleteMapping("/post/{id}")
    public ResponseEntity<Void> deleteResourceByPost(@RequestParam Long id) {
        resourceService.deleteResourceByPost(id);
        return ResponseEntity.noContent().build();
    }
}
