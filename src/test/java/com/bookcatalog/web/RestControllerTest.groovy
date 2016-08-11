package com.bookcatalog.web

import com.bookcatalog.Application
import com.bookcatalog.model.Book
import com.bookcatalog.repositories.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification

import static org.hamcrest.Matchers.hasSize
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup

@ContextConfiguration(loader = SpringApplicationContextLoader.class, classes = Application.class)
@WebAppConfiguration
class RestControllerTest extends Specification {
    @Autowired
    WebApplicationContext wac

    MockMvc mockMvc

    @Autowired
    RestController restController

    BookRepository bookRepository = Stub(BookRepository)

    void setup() {
        mockMvc = webAppContextSetup(wac).build()
        restController.setBookRepository(bookRepository)
    }

    def 'testGettingBooks'() {
        given: 'Repository that returns any two books'
        bookRepository.findAll() >> Arrays.asList(new Book(), new Book())

        when: 'REST API is accessed'
        def response = mockMvc.perform(get('/api/books'))

        then: 'Books are returned in JSON'
        response.andExpect(status().isOk())
                .andExpect(jsonPath('$[*].@id').exists())
                .andExpect(jsonPath('$', hasSize(2)))
    }
}
