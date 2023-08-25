package com.redmath.news.core;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/ver1/news")
public class NewsController {

    private final NewsService service;
    public NewsController(NewsService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<News>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<News> findById(@PathVariable("id") Long id)
    {

        Optional<News> news = service.findById(id);
        if (news.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(news.get());
        }
    }
 @PreAuthorize("hasAuthority('REPORTER')")
    @PostMapping()
    public ResponseEntity<News> create(@RequestBody News news) {
        News created = service.create(news);
        if (created != null) {
            return ResponseEntity.ok(created);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
    @PreAuthorize("hasAuthority('REPORTER')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<News> news = service.findById(id);
        if (news.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        News news1 = news.get();
        service.delete(news1);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<News> updateNews(@PathVariable Long id, @RequestBody News updatedNews) {
        News news = service.updateNews(id, updatedNews);

        if (news != null) {
            return ResponseEntity.ok(news);
        } else {
            return ResponseEntity.notFound().build();

        }
    }



//    @PostMapping("/{id}")
//    public ResponseEntity<News> createpost(@RequestBody News news)
//    {
//        News created = service.create(news);
//    }
//    @PostMapping("/{id}")
//    public void update(News news) {
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(Long id) {
//    }




}
