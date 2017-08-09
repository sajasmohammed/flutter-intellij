/*
 * Copyright 2017 The Chromium Authors. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the LICENSE file.
 */
package io.flutter.sdk;

import com.intellij.openapi.util.text.StringUtil;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class FlutterCreateAdditionalSettings {
  @Nullable
  private Boolean includeDriverTest;
  @Nullable
  private Boolean generatePlugin;
  @Nullable
  private String description;
  @Nullable
  private String org;
  @Nullable
  private Boolean swift;
  @Nullable
  private Boolean kotlin;
  private FlutterCreateAdditionalSettings(@Nullable Boolean includeDriverTest,
                                          @Nullable Boolean generatePlugin,
                                          @Nullable String description,
                                          @Nullable String org,
                                          @Nullable Boolean swift,
                                          @Nullable Boolean kotlin) {
    this.includeDriverTest = includeDriverTest;
    this.generatePlugin = generatePlugin;
    this.description = description;
    this.org = org;
    this.swift = swift;
    this.kotlin = kotlin;
  }

  public List<String> getArgs() {
    final List<String> args = new ArrayList<>();

    if (Boolean.TRUE.equals(includeDriverTest)) {
      args.add("--with-driver-test");
    }

    if (Boolean.TRUE.equals(generatePlugin)) {
      args.add("--plugin");
    }

    if (!StringUtil.isEmptyOrSpaces(description)) {
      args.add("--description");
      args.add(description);
    }

    if (!StringUtil.isEmptyOrSpaces(org)) {
      args.add("--org");
      args.add(org);
    }

    if (Boolean.TRUE.equals(swift)) {
      args.add("--ios-language");
      args.add("swift");
    }

    if (Boolean.TRUE.equals(kotlin)) {
      args.add("--android-language");
      args.add("kotlin");
    }

    return args;
  }

  public static class Builder {
    @Nullable
    private Boolean includeDriverTest;
    @Nullable
    private Boolean generatePlugin;
    @Nullable
    private String description;
    @Nullable
    private String org;
    @Nullable
    private Boolean swift;
    @Nullable
    private Boolean kotlin;

    public Builder() {
    }

    public Builder setIncludeDriverTest(@Nullable Boolean includeDriverTest) {
      this.includeDriverTest = includeDriverTest;
      return this;
    }

    public Builder setGeneratePlugin(@Nullable Boolean generatePlugin) {
      this.generatePlugin = generatePlugin;
      return this;
    }

    public Builder setDescription(@Nullable String description) {
      this.description = description;
      return this;
    }

    public Builder setOrg(@Nullable String org) {
      this.org = org;
      return this;
    }

    public Builder setSwift(@Nullable Boolean swift) {
      this.swift = swift;
      return this;
    }

    public Builder setKotlin(@Nullable Boolean kotlin) {
      this.kotlin = kotlin;
      return this;
    }

    public FlutterCreateAdditionalSettings build() {
      return new FlutterCreateAdditionalSettings(includeDriverTest, generatePlugin, description, org, swift, kotlin);
    }
  }
}