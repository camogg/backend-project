package io.oggier.backendproject;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EndpointsTests {
    @Autowired
    private MockMvc mockMvc;

    // Testing that we have courses with id
    @Test
    @WithMockUser(username = "student", password = "student", roles = "STUDENT")
    public void testCourses() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/courses")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].id").exists());
    }

    // Testing that we have enrollments with id
    @Test
    @WithMockUser(username = "student", password = "student", roles = "STUDENT")
    public void testEnrollments() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/enrollments")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].id").exists());
    }

}
