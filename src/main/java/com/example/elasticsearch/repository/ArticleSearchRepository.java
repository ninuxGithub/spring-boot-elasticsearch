package com.example.elasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.elasticsearch.model.Article;

public interface ArticleSearchRepository extends ElasticsearchRepository<Article, Long> {

}
