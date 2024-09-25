/*
 * Copyright 2002-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * you may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import io.rollout.rox.server.Rox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import io.rollout.rox.server.Rox;

import java.util.concurrent.ExecutionException;

@SpringBootApplication
@EnableAdminServer
@EnableDiscoveryClient
public class SpringBootAdminApplication {


    private static final Logger log = LoggerFactory.getLogger(SpringBootAdminApplication.class);

    public static void main(String[] args) {
        try {
            // Initialize the Rox SDK with the feature management environment key
            Rox.setup("6e3b0d18-4288-4d77-4843-b5a51a72e24b").get();

            // Initialize and register Flags
            Flags.register();

            // Print the value of the boolean enableTutorial flag
            log.info("enableTutorial value is %s%n", Flags.enableTutorial.isEnabled() ? "true" : "false");
            System.out.printf("enableTutorial value is %s%n", Flags.enableTutorial.isEnabled() ? "true" : "false");

            // Start the Spring Boot application
            SpringApplication.run(SpringBootAdminApplication.class, args);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
