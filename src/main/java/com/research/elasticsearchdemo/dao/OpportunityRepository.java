package com.research.elasticsearchdemo.dao;

import com.research.elasticsearchdemo.model.Opportunity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpportunityRepository extends ElasticsearchRepository<Opportunity, String> {

    Page<Opportunity> findByResearchField(String fieldName);

    @Query("{\"bool\": {\"must\": [{\"match\": {\"authors.name\": \"?0\"}}]}}")
    Page<Opportunity> findByResearchFieldNameUsingCustomQuery(String fieldName, Pageable pageable);
}
