package com.redmath.news.core;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class NewsService {
    private final NewsRepository repository;

    public NewsService(NewsRepository repository) {
        this.repository = repository;
        //this.Createdata();
    }

//    public void Createdata()
//    {
//      for(int i=0; i<3 ;i++){
//      News news = new News();news.setId(Long.valueOf(i));
//      news.setTitle("Title: "+ news.getId());
//      news.setDetails("Details: "+ news.getId());
//      news.setTags("Tags: "+ news.getId());
//      news.setReportedAt(LocalDateTime.now());
//      repository.save(news);
//
//        }
    //  }

    public List<News> findAll() {
        return repository.findAll();
    }


    public Optional<News> findById(Long id) {
        return repository.findById(id);
    }

    public News create(News news) {
        if (news.getId() != null && repository.existsById(news.getId())) {
            return null;
        }
        news.setId(System.currentTimeMillis());
        news.setReportedAt(LocalDateTime.now());
        return repository.save(news);
    }
    public Optional<Void> delete(News news){
        if (news.getId() != null && repository.existsById(news.getId())) {
            repository.delete(news);
            return Optional.empty();
        }

        return null;
    }
    public News updateNews(Long id, News updatedNews) {
        Optional<News> optionalNews = repository.findById(id);

        if (optionalNews.isPresent()) {
            News existingNews = optionalNews.get();
            // Update the existingNews object with the data from updatedNews

            existingNews.setTags(updatedNews.getTags());
            existingNews.setTitle(updatedNews.getTitle());
            existingNews.setDetails(updatedNews.getDetails());

            return repository.save(existingNews);
        } else {
            return null;
        }
    }
}
