package com.research.elasticsearchdemo.services;

import com.research.elasticsearchdemo.dao.OpportunityRepository;
import com.research.elasticsearchdemo.model.Criteria;
import com.research.elasticsearchdemo.model.Opportunity;
import lombok.val;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class OpportunitySearchServiceTest {

    @Mock
    OpportunityRepository opportunityRepository;

    OpportunitySearchService opportunitySearchService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        opportunitySearchService = new OpportunitySearchService(opportunityRepository);
    }

    @Test
    public void findOpportunityByResearchFieldNotFoundTest() {
        Criteria criteria = Criteria.builder().researchField("Biology").build();

        Opportunity opportunity = Opportunity.builder().researchField("Biology").build();

        List<Opportunity> content = Arrays.asList(opportunity);

        Page<Opportunity> returnedByRepo = new PageImpl<>(content);

        Mockito.when(opportunityRepository.findByResearchField("Biology")).thenReturn(returnedByRepo);

        val result = opportunitySearchService.findOpportunityByResearchField(criteria);

        assertNotNull(result);

        assertEquals(1, result.size());

        assertEquals("Biology", result.get(0).getResearchField() );
    }
}