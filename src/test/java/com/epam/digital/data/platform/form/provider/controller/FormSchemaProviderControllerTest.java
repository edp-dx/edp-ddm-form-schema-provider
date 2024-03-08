/*
 * Copyright 2022 EPAM Systems.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.epam.digital.data.platform.form.provider.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.epam.digital.data.platform.form.provider.model.FormSchema;
import com.epam.digital.data.platform.form.provider.service.impl.FormSchemaProviderServiceImpl;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import lombok.SneakyThrows;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import util.TestUtils;

@ControllerTest(FormSchemaProviderController.class)
class FormSchemaProviderControllerTest {

  static final String BASE_URL = "/api/forms";
  static final String VISIBLE_CARDS_URL = "/api/cards/visible";

  @Autowired
  MockMvc mockMvc;

  @MockBean
  FormSchemaProviderServiceImpl formSchemaProviderService;

  private JSONObject validForm;

  @BeforeEach
  void setUp() {
    validForm = (JSONObject) JSONValue.parse(TestUtils.getContent("valid-form.json").getBytes(StandardCharsets.UTF_8));
  }

  @Test
  @SneakyThrows
  void saveForm() {
    mockMvc.perform(post(BASE_URL)
            .content(validForm.toJSONString())
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
        .andExpectAll(
            status().isCreated());
  }

  @Test
  @SneakyThrows
  void getForm() {
    when(formSchemaProviderService.getFormByKey(any())).thenReturn(validForm);

    mockMvc.perform(get(BASE_URL + "/{key}", validForm.getAsString("name")))
        .andExpectAll(
            status().isOk(),
            content().contentType(MediaType.APPLICATION_JSON),
            content().json(validForm.toJSONString()));
  }

  @Test
  @SneakyThrows
  void updateForm() {
    when(formSchemaProviderService.getFormByKey(any())).thenReturn(validForm);

    mockMvc.perform(put(BASE_URL + "/{key}", validForm.getAsString("name"))
            .content(validForm.toJSONString())
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
        .andExpectAll(
            status().isOk());
  }

  @Test
  @SneakyThrows
  void deleteFormByKey() {
    mockMvc.perform(delete(BASE_URL + "/{key}", "test-key"))
        .andExpectAll(
            status().isNoContent());
  }

  @Test
  @WithMockUser(roles = "USER")
  @SneakyThrows
  void getVisibleCardsAsUser() {
    List<FormSchema> visibleForms = Arrays.asList(new FormSchema("userForm1"), new FormSchema("userForm2"));
    when(formSchemaProviderService.getVisibleCards(any())).thenReturn(visibleForms);

    mockMvc.perform(get(VISIBLE_CARDS_URL))
        .andExpectAll(
            status().isOk(),
            content().contentType(MediaType.APPLICATION_JSON),
            jsonPath("$[0].name").value("userForm1"),
            jsonPath("$[1].name").value("userForm2"));
  }

  @Test
  @WithMockUser(roles = "ADMIN")
  @SneakyThrows
  void getVisibleCardsAsAdmin() {
    List<FormSchema> visibleForms = Arrays.asList(new FormSchema("adminForm1"), new FormSchema("adminForm2"));
    when(formSchemaProviderService.getVisibleCards(any())).thenReturn(visibleForms);

    mockMvc.perform(get(VISIBLE_CARDS_URL))
        .andExpectAll(
            status().isOk(),
            content().contentType(MediaType.APPLICATION_JSON),
            jsonPath("$[0].name").value("adminForm1"),
            jsonPath("$[1].name").value("adminForm2"));
  }
}