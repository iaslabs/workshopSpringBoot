package co.com.ias.projectBird.infrastructure.entrypoint;

import co.com.ias.projectBird.domain.model.bird.Bird;
import co.com.ias.projectBird.domain.model.bird.dto.BirdDTO;
import co.com.ias.projectBird.domain.usecase.BirdUseCase;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BirdEntryPoint.class)
class BirdEntryPointTest {

    @MockBean
    private BirdUseCase birdUseCase;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void get() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/bird")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString("[]")));
    }

    @Test
    void getById() throws Exception {
        BirdDTO birdFound = new BirdDTO(1L,"Piolin","Pajaro");
        when(birdUseCase.findBirdById(1L)).thenReturn(birdFound);
        ObjectMapper mapper = new ObjectMapper();

        mockMvc.perform(MockMvcRequestBuilders.get("/bird/{id}",1L).contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(birdFound)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Save bird")
    void create() throws Exception {
        //Arrange
        BirdDTO birdDTO = new BirdDTO(1L,"Piolin","Pajaro");
        when(birdUseCase.saveBird(any(BirdDTO.class))).thenReturn(birdDTO);
        ObjectMapper mapper = new ObjectMapper();
        //Act && Assert
            mockMvc.perform(MockMvcRequestBuilders.post("/bird")
                    .contentType(MediaType.APPLICATION_JSON)
                            .content(mapper.writeValueAsString(birdDTO)))
                    .andDo(print())
                    .andExpect(status().isCreated())
                    .andExpect(MockMvcResultMatchers.content()
                            .string(Matchers.containsString("Piolin")))
                    .andExpect(MockMvcResultMatchers.content()
                            .string(Matchers.containsString("Pajaro")));

    }

    @Test
    void update() throws Exception{
        //Arrange
            BirdDTO birdDTOUpdated = new BirdDTO(1L,"Piolin","Pajaro");
            when(birdUseCase.updateBird(any(BirdDTO.class))).thenReturn(birdDTOUpdated);
            ObjectMapper mapper = new ObjectMapper();

            //Act && Assert
                mockMvc.perform(MockMvcRequestBuilders.put("/bird")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(birdDTOUpdated)))
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(status().isOk());

    }

    @Test
    void delete() throws Exception {
        //Arrange
        when(birdUseCase.deleteBird(1L)).thenReturn(true);
        //Act && Assert
        mockMvc.perform(MockMvcRequestBuilders.delete("/bird/{id}",1L))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }
}