package me.wonwoo.textsearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by wonwoo on 2016. 1. 22..
 */

@RepositoryRestController
public class TextSearchController {

    @Autowired
    private PostRepository postRepository;


    @RequestMapping(method = RequestMethod.GET, value = "/posts/search/findAllBy")
    public @ResponseBody ResponseEntity<?> getText(String text, Pageable pageable) {
        TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingPhrase(text);
        Page<Post> posts = postRepository.findAllBy(criteria,pageable);

        Resources<Post> resources = new Resources<>(posts);
        resources.add(linkTo(methodOn(TextSearchController.class).getText(text,pageable)).withSelfRel());
        return ResponseEntity.ok(resources);
    }
}
