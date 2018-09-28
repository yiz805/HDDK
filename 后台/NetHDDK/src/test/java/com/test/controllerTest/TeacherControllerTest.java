package com.test.controllerTest;

import com.test.base.BaseControllerTest;
import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TeacherControllerTest extends BaseControllerTest {
    @Test
    public void getAllActivity() {
        try {
            mockMvc.perform(
                    MockMvcRequestBuilders.get("/teacher/getAllActivity")
                            ).andExpect(status().isOk())
                    .andDo(MockMvcResultHandlers.print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
