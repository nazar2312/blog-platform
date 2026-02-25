package com.portfolio.blog.controllers;

import com.portfolio.blog.domain.dto.tag.TagRequest;
import com.portfolio.blog.domain.dto.tag.TagResponse;
import com.portfolio.blog.services.impl.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService service;

    @GetMapping
    public ResponseEntity<List<TagResponse>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<TagResponse> create(@RequestBody TagRequest request) {
        return ResponseEntity.ok(service.create(request));
    }
}
