/*
 * Copyright 2022 EPAM Systems.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.epam.digital.data.platform.form.provider.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Data
@Builder
@RedisHash("bpm-form-schemas")
public class FormSchema {

  @Id
  private String id;
  private String formData;
private String type; // Type of the schema (form or card)
private boolean visibleInUi; // Indicates if the card is visible in UI

// Getters and setters for 'type' and 'visibleInUi'
public String getType() {
  return type;
}

public void setType(String type) {
  this.type = type;
}

public boolean isVisibleInUi() {
  return visibleInUi;
}

public void setVisibleInUi(boolean visibleInUi) {
  this.visibleInUi = visibleInUi;
}
}
