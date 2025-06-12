package com.practice.java.users.api.controller;

import com.practice.java.users.api.model.User;
import com.practice.java.users.api.respository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    private User sampleUser;

    @BeforeEach
    void setUp() {
        sampleUser = new User();
        sampleUser.setId("684330493365b838a9b214ce");
        sampleUser.setName("Lucian Smith Ulloa");
        sampleUser.setEmail("luciansmith92@gmail.com");
        sampleUser.setAge(33);
        sampleUser.setActive(true);
    }

    @Test
    void testGetAllUsers() throws Exception {
        when(userRepository.findAll()).thenReturn(Arrays.asList(sampleUser));

        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Lucian Smith Ulloa"));
    }

    @Test
    void testGetUserByEmail() throws Exception {
        when(userRepository.findByEmail("luciansmith92@gmail.com")).thenReturn(Optional.of(sampleUser));

        mockMvc.perform(get("/api/users/luciansmith92@gmail.com"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("luciansmith92@gmail.com"));
    }

    @Test
    void testCreateUser() throws Exception {
        when(userRepository.save(any(User.class))).thenReturn(sampleUser);

        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Lucian Smith Ulloa\",\"email\":\"luciansmith92@gmail.com\",\"age\":33,\"active\":true}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Lucian Smith Ulloa"));
    }

    @Test
    void testUpdateUserFound() throws Exception {
        when(userRepository.findById("684330493365b838a9b214ce")).thenReturn(Optional.of(sampleUser));
        when(userRepository.save(any(User.class))).thenReturn(sampleUser);

        mockMvc.perform(put("/api/users/684330493365b838a9b214ce")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"juan\",\"email\":\"juan@example.com\",\"age\":35,\"active\":false}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("juan@example.com"));
    }

    @Test
    void testDeleteUser() throws Exception {
        doNothing().when(userRepository).deleteById("684330493365b838a9b214ce");

        mockMvc.perform(delete("/api/users/684330493365b838a9b214ce"))
                .andExpect(status().isOk());
    }
}