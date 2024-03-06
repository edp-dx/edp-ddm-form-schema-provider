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

import com.epam.digital.data.platform.form.provider.service.impl.FormSchemaProviderServiceImpl;
import net.minidev.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/forms")
public class FormSchemaProviderController {

  private final FormSchemaProviderServiceImpl formSchemaProviderServiceImpl;

  public FormSchemaProviderController(FormSchemaProviderServiceImpl formSchemaProviderServiceImpl) {
    this.formSchemaProviderServiceImpl = formSchemaProviderServiceImpl;
  import com.epam.digital.data.platform.form.provider.service.FormSchemaProviderService;
//... existing imports ...

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.minidev.json.JSONObject;

@RestController
@RequestMapping("/api/forms")
public class FormSchemaProviderController {

  private final FormSchemaProviderServiceImpl formSchemaProviderServiceImpl;

  public FormSchemaProviderController(FormSchemaProviderServiceImpl formSchemaProviderServiceImpl) {
    this.formSchemaProviderServiceImpl = formSchemaProviderServiceImpl;
  }

  @PostMapping
  public ResponseEntity<Void> saveForm(@RequestBody String formData) {
    formSchemaProviderServiceImpl.saveForm(formData);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @GetMapping("/{key}")
  public ResponseEntity<JSONObject> getForm(@PathVariable("key") String key) {
    return ResponseEntity.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(formSchemaProviderServiceImpl.getFormByKey(key));
  }

  @PutMapping("/{key}")
  public ResponseEntity<Void> updateForm(@PathVariable("key") String key,
      @RequestBody String formSchemaData) {
    formSchemaProviderServiceImpl.updateForm(key, formSchemaData);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @DeleteMapping("/{key}")
  public ResponseEntity<Void> deleteFormByKey(@PathVariable("key") String key) {
    formSchemaProviderServiceImpl.deleteFormByKey(key);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @GetMapping("/cards")
  public ResponseEntity<List<JSONObject>> getVisibleCards() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    Set<String> roles = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet());
    List<JSONObject> cards = formSchemaProviderServiceImpl.getVisibleCardsForUserRoles(roles);
    return ResponseEntity.ok(cards);
  }
}

  @PostMapping
  public ResponseEntity<Void> saveForm(@RequestBody String formData) {
    formSchemaProviderServiceImpl.saveForm(formData);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  import com.epam.digital.data.platform.form.provider.service.FormSchemaProviderService;
//... existing imports ...

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.minidev.json.JSONObject;

@RestController
@RequestMapping("/api/forms")
public class FormSchemaProviderController {

  private final FormSchemaProviderServiceImpl formSchemaProviderServiceImpl;

  public FormSchemaProviderController(FormSchemaProviderServiceImpl formSchemaProviderServiceImpl) {
    this.formSchemaProviderServiceImpl = formSchemaProviderServiceImpl;
  }

  @PostMapping
  public ResponseEntity<Void> saveForm(@RequestBody String formData) {
    formSchemaProviderServiceImpl.saveForm(formData);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @GetMapping("/{key}")
  public ResponseEntity<JSONObject> getForm(@PathVariable("key") String key) {
    return ResponseEntity.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(formSchemaProviderServiceImpl.getFormByKey(key));
  }

  @PutMapping("/{key}")
  public ResponseEntity<Void> updateForm(@PathVariable("key") String key,
      @RequestBody String formSchemaData) {
    formSchemaProviderServiceImpl.updateForm(key, formSchemaData);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @DeleteMapping("/{key}")
  public ResponseEntity<Void> deleteFormByKey(@PathVariable("key") String key) {
    formSchemaProviderServiceImpl.deleteFormByKey(key);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @GetMapping("/cards")
  public ResponseEntity<List<JSONObject>> getVisibleCards() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    Set<String> roles = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet());
    List<JSONObject> cards = formSchemaProviderServiceImpl.getVisibleCardsForUserRoles(roles);
    return ResponseEntity.ok(cards);
  }
}

  @GetMapping("/{keyimport com.epam.digital.data.platform.form.provider.service.FormSchemaProviderService;
//... existing imports ...

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.minidev.json.JSONObject;

@RestController
@RequestMapping("/api/forms")
public class FormSchemaProviderController {

  private final FormSchemaProviderServiceImpl formSchemaProviderServiceImpl;

  public FormSchemaProviderController(FormSchemaProviderServiceImpl formSchemaProviderServiceImpl) {
    this.formSchemaProviderServiceImpl = formSchemaProviderServiceImpl;
  }

  @PostMapping
  public ResponseEntity<Void> saveForm(@RequestBody String formData) {
    formSchemaProviderServiceImpl.saveForm(formData);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @GetMapping("/{key}")
  public ResponseEntity<JSONObject> getForm(@PathVariable("key") String key) {
    return ResponseEntity.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(formSchemaProviderServiceImpl.getFormByKey(key));
  }

  @PutMapping("/{key}")
  public ResponseEntity<Void> updateForm(@PathVariable("key") String key,
      @RequestBody String formSchemaData) {
    formSchemaProviderServiceImpl.updateForm(key, formSchemaData);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @DeleteMapping("/{key}")
  public ResponseEntity<Void> deleteFormByKey(@PathVariable("key") String key) {
    formSchemaProviderServiceImpl.deleteFormByKey(key);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @GetMapping("/cards")
  public ResponseEntity<List<JSONObject>> getVisibleCards() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    Set<String> roles = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet());
    List<JSONObject> cards = formSchemaProviderServiceImpl.getVisibleCardsForUserRoles(roles);
    return ResponseEntity.ok(cards);
  }
}")
  public ResponseEntity<JSONObject> getForm(@PathVariable("key") String key) {
    return ResponseEntity.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(formSchemaProviderServiceImpl.getFormByKey(key));
  import com.epam.digital.data.platform.form.provider.service.FormSchemaProviderService;
//... existing imports ...

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.minidev.json.JSONObject;

@RestController
@RequestMapping("/api/forms")
public class FormSchemaProviderController {

  private final FormSchemaProviderServiceImpl formSchemaProviderServiceImpl;

  public FormSchemaProviderController(FormSchemaProviderServiceImpl formSchemaProviderServiceImpl) {
    this.formSchemaProviderServiceImpl = formSchemaProviderServiceImpl;
  }

  @PostMapping
  public ResponseEntity<Void> saveForm(@RequestBody String formData) {
    formSchemaProviderServiceImpl.saveForm(formData);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @GetMapping("/{key}")
  public ResponseEntity<JSONObject> getForm(@PathVariable("key") String key) {
    return ResponseEntity.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(formSchemaProviderServiceImpl.getFormByKey(key));
  }

  @PutMapping("/{key}")
  public ResponseEntity<Void> updateForm(@PathVariable("key") String key,
      @RequestBody String formSchemaData) {
    formSchemaProviderServiceImpl.updateForm(key, formSchemaData);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @DeleteMapping("/{key}")
  public ResponseEntity<Void> deleteFormByKey(@PathVariable("key") String key) {
    formSchemaProviderServiceImpl.deleteFormByKey(key);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @GetMapping("/cards")
  public ResponseEntity<List<JSONObject>> getVisibleCards() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    Set<String> roles = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet());
    List<JSONObject> cards = formSchemaProviderServiceImpl.getVisibleCardsForUserRoles(roles);
    return ResponseEntity.ok(cards);
  }
}

  @PutMapping("/{keyimport com.epam.digital.data.platform.form.provider.service.FormSchemaProviderService;
//... existing imports ...

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.minidev.json.JSONObject;

@RestController
@RequestMapping("/api/forms")
public class FormSchemaProviderController {

  private final FormSchemaProviderServiceImpl formSchemaProviderServiceImpl;

  public FormSchemaProviderController(FormSchemaProviderServiceImpl formSchemaProviderServiceImpl) {
    this.formSchemaProviderServiceImpl = formSchemaProviderServiceImpl;
  }

  @PostMapping
  public ResponseEntity<Void> saveForm(@RequestBody String formData) {
    formSchemaProviderServiceImpl.saveForm(formData);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @GetMapping("/{key}")
  public ResponseEntity<JSONObject> getForm(@PathVariable("key") String key) {
    return ResponseEntity.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(formSchemaProviderServiceImpl.getFormByKey(key));
  }

  @PutMapping("/{key}")
  public ResponseEntity<Void> updateForm(@PathVariable("key") String key,
      @RequestBody String formSchemaData) {
    formSchemaProviderServiceImpl.updateForm(key, formSchemaData);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @DeleteMapping("/{key}")
  public ResponseEntity<Void> deleteFormByKey(@PathVariable("key") String key) {
    formSchemaProviderServiceImpl.deleteFormByKey(key);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @GetMapping("/cards")
  public ResponseEntity<List<JSONObject>> getVisibleCards() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    Set<String> roles = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet());
    List<JSONObject> cards = formSchemaProviderServiceImpl.getVisibleCardsForUserRoles(roles);
    return ResponseEntity.ok(cards);
  }
}")
  public ResponseEntity<Void> updateForm(@PathVariable("key") String key,
      @RequestBody String formSchemaData) {
    formSchemaProviderServiceImpl.updateForm(key, formSchemaData);
    return ResponseEntity.status(HttpStatus.OK).build();
  import com.epam.digital.data.platform.form.provider.service.FormSchemaProviderService;
//... existing imports ...

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.minidev.json.JSONObject;

@RestController
@RequestMapping("/api/forms")
public class FormSchemaProviderController {

  private final FormSchemaProviderServiceImpl formSchemaProviderServiceImpl;

  public FormSchemaProviderController(FormSchemaProviderServiceImpl formSchemaProviderServiceImpl) {
    this.formSchemaProviderServiceImpl = formSchemaProviderServiceImpl;
  }

  @PostMapping
  public ResponseEntity<Void> saveForm(@RequestBody String formData) {
    formSchemaProviderServiceImpl.saveForm(formData);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @GetMapping("/{key}")
  public ResponseEntity<JSONObject> getForm(@PathVariable("key") String key) {
    return ResponseEntity.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(formSchemaProviderServiceImpl.getFormByKey(key));
  }

  @PutMapping("/{key}")
  public ResponseEntity<Void> updateForm(@PathVariable("key") String key,
      @RequestBody String formSchemaData) {
    formSchemaProviderServiceImpl.updateForm(key, formSchemaData);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @DeleteMapping("/{key}")
  public ResponseEntity<Void> deleteFormByKey(@PathVariable("key") String key) {
    formSchemaProviderServiceImpl.deleteFormByKey(key);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @GetMapping("/cards")
  public ResponseEntity<List<JSONObject>> getVisibleCards() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    Set<String> roles = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet());
    List<JSONObject> cards = formSchemaProviderServiceImpl.getVisibleCardsForUserRoles(roles);
    return ResponseEntity.ok(cards);
  }
}

  @DeleteMapping("/{keyimport com.epam.digital.data.platform.form.provider.service.FormSchemaProviderService;
//... existing imports ...

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.minidev.json.JSONObject;

@RestController
@RequestMapping("/api/forms")
public class FormSchemaProviderController {

  private final FormSchemaProviderServiceImpl formSchemaProviderServiceImpl;

  public FormSchemaProviderController(FormSchemaProviderServiceImpl formSchemaProviderServiceImpl) {
    this.formSchemaProviderServiceImpl = formSchemaProviderServiceImpl;
  }

  @PostMapping
  public ResponseEntity<Void> saveForm(@RequestBody String formData) {
    formSchemaProviderServiceImpl.saveForm(formData);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @GetMapping("/{key}")
  public ResponseEntity<JSONObject> getForm(@PathVariable("key") String key) {
    return ResponseEntity.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(formSchemaProviderServiceImpl.getFormByKey(key));
  }

  @PutMapping("/{key}")
  public ResponseEntity<Void> updateForm(@PathVariable("key") String key,
      @RequestBody String formSchemaData) {
    formSchemaProviderServiceImpl.updateForm(key, formSchemaData);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @DeleteMapping("/{key}")
  public ResponseEntity<Void> deleteFormByKey(@PathVariable("key") String key) {
    formSchemaProviderServiceImpl.deleteFormByKey(key);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @GetMapping("/cards")
  public ResponseEntity<List<JSONObject>> getVisibleCards() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    Set<String> roles = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet());
    List<JSONObject> cards = formSchemaProviderServiceImpl.getVisibleCardsForUserRoles(roles);
    return ResponseEntity.ok(cards);
  }
}")
  public ResponseEntity<Void> deleteFormByKey(@PathVariable("key") String key) {
    formSchemaProviderServiceImpl.deleteFormByKey(key);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  import com.epam.digital.data.platform.form.provider.service.FormSchemaProviderService;
//... existing imports ...

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.minidev.json.JSONObject;

@RestController
@RequestMapping("/api/forms")
public class FormSchemaProviderController {

  private final FormSchemaProviderServiceImpl formSchemaProviderServiceImpl;

  public FormSchemaProviderController(FormSchemaProviderServiceImpl formSchemaProviderServiceImpl) {
    this.formSchemaProviderServiceImpl = formSchemaProviderServiceImpl;
  }

  @PostMapping
  public ResponseEntity<Void> saveForm(@RequestBody String formData) {
    formSchemaProviderServiceImpl.saveForm(formData);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @GetMapping("/{key}")
  public ResponseEntity<JSONObject> getForm(@PathVariable("key") String key) {
    return ResponseEntity.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(formSchemaProviderServiceImpl.getFormByKey(key));
  }

  @PutMapping("/{key}")
  public ResponseEntity<Void> updateForm(@PathVariable("key") String key,
      @RequestBody String formSchemaData) {
    formSchemaProviderServiceImpl.updateForm(key, formSchemaData);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @DeleteMapping("/{key}")
  public ResponseEntity<Void> deleteFormByKey(@PathVariable("key") String key) {
    formSchemaProviderServiceImpl.deleteFormByKey(key);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @GetMapping("/cards")
  public ResponseEntity<List<JSONObject>> getVisibleCards() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    Set<String> roles = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet());
    List<JSONObject> cards = formSchemaProviderServiceImpl.getVisibleCardsForUserRoles(roles);
    return ResponseEntity.ok(cards);
  }
}
import com.epam.digital.data.platform.form.provider.service.FormSchemaProviderService;
//... existing imports ...

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.minidev.json.JSONObject;

@RestController
@RequestMapping("/api/forms")
public class FormSchemaProviderController {

  private final FormSchemaProviderServiceImpl formSchemaProviderServiceImpl;

  public FormSchemaProviderController(FormSchemaProviderServiceImpl formSchemaProviderServiceImpl) {
    this.formSchemaProviderServiceImpl = formSchemaProviderServiceImpl;
  }

  @PostMapping
  public ResponseEntity<Void> saveForm(@RequestBody String formData) {
    formSchemaProviderServiceImpl.saveForm(formData);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @GetMapping("/{key}")
  public ResponseEntity<JSONObject> getForm(@PathVariable("key") String key) {
    return ResponseEntity.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(formSchemaProviderServiceImpl.getFormByKey(key));
  }

  @PutMapping("/{key}")
  public ResponseEntity<Void> updateForm(@PathVariable("key") String key,
      @RequestBody String formSchemaData) {
    formSchemaProviderServiceImpl.updateForm(key, formSchemaData);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @DeleteMapping("/{key}")
  public ResponseEntity<Void> deleteFormByKey(@PathVariable("key") String key) {
    formSchemaProviderServiceImpl.deleteFormByKey(key);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @GetMapping("/cards")
  public ResponseEntity<List<JSONObject>> getVisibleCards() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    Set<String> roles = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet());
    List<JSONObject> cards = formSchemaProviderServiceImpl.getVisibleCardsForUserRoles(roles);
    return ResponseEntity.ok(cards);
  }
}