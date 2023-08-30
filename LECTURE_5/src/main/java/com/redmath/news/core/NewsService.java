package com.redmath.news.core;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NewsService {
    private final NewsRepository repository;
    private final Logger logger = LoggerFactory.getLogger(getClass());
    public NewsService(NewsRepository repository) {
        this.repository = repository;
        //this.Createdata();
    }

    public List<News> findAll() {
        logger.debug("Finding All");
        return repository.findAll();
    }


    public Optional<News> findById(Long id) {
        logger.info("Finding by Id {}" ,id);

        return repository.findById(id);
    }

    public News create(News news) {
        if (news.getId() != null && repository.existsById(news.getId())) {
            logger.warn("News with" + news.getId() + "Already Exists");
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
