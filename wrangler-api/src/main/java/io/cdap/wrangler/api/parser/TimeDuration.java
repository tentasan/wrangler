/*
 * Copyright © 2017-2019 Cask Data, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package io.cdap.wrangler.api.parser;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

public class TimeDuration implements Token {
  private final long milliseconds;
  private final String original;

  public TimeDuration(String value) {
    this.original = value;
    this.milliseconds = parseDuration(value.trim().toLowerCase());
  }

  private long parseDuration(String value) {
    double num = Double.parseDouble(value.replaceAll("[^0-9.]", ""));

    // Check longer suffixes first to avoid conflicts
    if (value.endsWith("milliseconds") || value.endsWith("ms")) {
      return (long) num;
    } else if (value.endsWith("minutes") || value.endsWith("minute") || value.endsWith("min")) {
      return (long) (num * 60 * 1000);
    } else if (value.endsWith("seconds") || value.endsWith("second") || value.endsWith("sec") || value.endsWith("s")) {
      return (long) (num * 1000);
    }

    throw new IllegalArgumentException("Unsupported time unit: " + value);
  }

  @Override
  public Object value() {
    return milliseconds;
  }

  @Override
  public TokenType type() {
    return TokenType.TIME_DURATION;
  }

  @Override
  public JsonElement toJson() {
    return new JsonPrimitive(milliseconds);
  }
}
