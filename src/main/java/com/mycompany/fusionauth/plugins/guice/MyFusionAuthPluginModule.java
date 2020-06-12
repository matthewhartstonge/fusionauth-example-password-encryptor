/*
 * Copyright (c) 2020, FusionAuth, All Rights Reserved
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 */
package com.mycompany.fusionauth.plugins.guice;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;
import com.mycompany.fusionauth.plugins.ExampleCustomMD5SaltedPasswordEncryptor;
import com.mycompany.fusionauth.plugins.ExamplePBDKF2HMACSHA1PasswordEncryptor;
import com.mycompany.fusionauth.plugins.ExampleSaltedSHA512PasswordEncryptor;
import com.mycompany.fusionauth.plugins.MyExamplePasswordEncryptor;
import io.fusionauth.plugin.spi.PluginModule;
import io.fusionauth.plugin.spi.security.PasswordEncryptor;

/**
 * @author Daniel DeGroff
 */
@PluginModule
public class MyFusionAuthPluginModule extends AbstractModule {
  @Override
  protected void configure() {
    MapBinder<String, PasswordEncryptor> passwordEncryptorMapBinder = MapBinder.newMapBinder(binder(), String.class, PasswordEncryptor.class);

    // TODO :
    //   1. Add one or more bindings here
    //   2. Name your binding. This will be the value you set in the 'encryptionScheme' on the user to utilize this encryptor.
    //   3. Delete any example code you don't use.

    // Start with this example and implement it.
    passwordEncryptorMapBinder.addBinding("example-hash").to(MyExamplePasswordEncryptor.class);

    // Functional examples
    passwordEncryptorMapBinder.addBinding("example-custom-md5").to(ExampleCustomMD5SaltedPasswordEncryptor.class);
    passwordEncryptorMapBinder.addBinding("example-salted-sha512").to(ExampleSaltedSHA512PasswordEncryptor.class);
    // /atg/dynamo/security/PBKDF2PasswordHasher-10000
    passwordEncryptorMapBinder.addBinding("example-salted-pbkdf2-hmac-sha1-10000").to(ExamplePBDKF2HMACSHA1PasswordEncryptor.class);

  }
}
