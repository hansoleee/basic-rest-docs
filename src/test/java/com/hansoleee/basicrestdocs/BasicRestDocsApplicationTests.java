package com.hansoleee.basicrestdocs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.MimeType;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
class BasicRestDocsApplicationTests {

    MockMvc mockMvc;

    @BeforeEach
    void setUp(WebApplicationContext webApplicationContext,
               RestDocumentationContextProvider restDocumentation) {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(documentationConfiguration(restDocumentation))
                .build();
    }

    @Test
    @DisplayName("accept가 text/csv일 경우")
    void acceptTextCsv() throws Exception {
        this.mockMvc.perform(get("/v1/devices/smgw").accept(MediaType.asMediaType(MimeType.valueOf("text/csv"))))
                .andExpect(status().isOk())
                .andDo(document("v1-devices-smgw-csv"));
    }

    @Test
    @DisplayName("accept가 application/json일 경우")
    void acceptApplicationJson() throws Exception {
        this.mockMvc.perform(get("/v1/devices/smgw").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(document("v1-devices-smgw-json"));
    }

}
