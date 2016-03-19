/*
 * Copyright 2013-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.cloudfoundry.client.v2.applications;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Singular;
import org.cloudfoundry.Validatable;
import org.cloudfoundry.ValidationResult;

import java.util.List;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * The request payload for the v2 Create Application request
 */
@Data
public final class CreateApplicationRequest implements Validatable {

    /**
     * Buildpack to build the application
     *
     * @param buildpack to build the application
     * @return buildpack to build the application
     */
    @Getter(onMethod = @__(@JsonProperty("buildpack")))
    private final String buildpack;

    /**
     * The command to start the application after it is staged
     *
     * @param command the command to start the application
     * @return the command to start the application
     */
    @Getter(onMethod = @__(@JsonProperty("command")))
    private final String command;

    /**
     * Open the console port for the application (at $CONSOLE_PORT).
     *
     * @param console whether to open the console port
     * @return whether to open the console port
     */
    @Getter(onMethod = @__({@JsonProperty("console"), @Deprecated}))
    private final Boolean console;

    /**
     * Open the debug port for the application (at $DEBUG_PORT).
     *
     * @param debug whether to open the debug port
     * @return whether to open the debug port
     */
    @Getter(onMethod = @__({@JsonProperty("debug"), @Deprecated}))
    private final Boolean debug;

    /**
     * The command detected by the buildpack during staging
     *
     * @param detectedStartCommand the command detected by the buildpack during staging
     * @return the command detected by the buildpack during staging
     */
    @Getter(onMethod = @__(@JsonProperty("detected_start_command")))
    private final String detectedStartCommand;

    /**
     * Use diego to stage and to run when available.
     *
     * @param diego whether to use diego
     * @return whether to use diego
     */
    @Getter(onMethod = @__(@JsonProperty("diego")))
    private final Boolean diego;

    /**
     * The maximum amount of disk available to an instance of an application. In megabytes.
     *
     * @param diskQuota the maximum amount of disk available to an instance
     * @return the maximum amount of disk available to an instance
     */
    @Getter(onMethod = @__(@JsonProperty("disk_quota")))
    private final Integer diskQuota;

    /**
     * Docker credentials for pulling docker image
     *
     * @param dockerCredentialsJsons docker credentials
     * @return docker credentials
     */
    @Getter(onMethod = @__({@JsonProperty("docker_credentials_json"), @JsonInclude(NON_EMPTY)}))
    private final Map<String, Object> dockerCredentialsJsons;

    /**
     * Name of the Docker image containing the application
     *
     * @param dockerImage name of the Docker image
     * @return name of the Docker image
     */
    @Getter(onMethod = @__(@JsonProperty("docker_image")))
    private final String dockerImage;

    /**
     * Enable SSHing into the application
     *
     * @param enableSsh whether SSH is enabled
     * @return whether SSH is enabled
     */
    @Getter(onMethod = @__(@JsonProperty("enable_ssh")))
    private final Boolean enableSsh;

    /**
     * Key/value pairs of all the environment variables to run in your application. Does not include any system or service variables.
     *
     * @param environmentJsons the environment variables to run in your application
     * @return the environment variables to run in your application
     */
    @Getter(onMethod = @__({@JsonProperty("environment_json"), @JsonInclude(NON_EMPTY)}))
    private final Map<String, Object> environmentJsons;

    /**
     * Timeout for health checking of an staged applcation when starting up
     *
     * @param healthCheckTimeout timeout for health checking
     * @return timeout for health checking
     */
    @Getter(onMethod = @__(@JsonProperty("health_check_timeout")))
    private final Integer healthCheckTimeout;

    /**
     * Type of health check to perform
     *
     * @param healthCheckType type of health check to perform
     * @return type of health check to perform
     */
    @Getter(onMethod = @__(@JsonProperty("health_check_type")))
    private final String healthCheckType;

    /**
     * The number of instances of the application to run. To ensure optimal availability, ensure there are at least 2 instances.
     *
     * @param instances the number of instances to run
     * @return the number of instances to run
     */
    @Getter(onMethod = @__(@JsonProperty("instances")))
    private final Integer instances;

    /**
     * The amount of memory each instance should have. In megabytes.
     *
     * @param memory the amount of memory each instance should have
     * @return the amount of memory each instance should have
     */
    @Getter(onMethod = @__(@JsonProperty("memory")))
    private final Integer memory;

    /**
     * The name of the application
     *
     * @param name the name of the application
     * @return the name of the application
     */
    @Getter(onMethod = @__(@JsonProperty("name")))
    private final String name;

    /**
     * The ports on which application may listen
     *
     * @param ports the ports on which application may listen
     * @return the ports on which application may listen
     */
    @Getter(onMethod = @__({@JsonProperty("ports"), @JsonInclude(NON_EMPTY)}))
    private final List<Integer> ports;

    /**
     * Whether to open the production port
     *
     * @param production whether to open the debug port
     * @return whether to open the debug port
     */
    @Getter(onMethod = @__({@JsonProperty("production"), @Deprecated}))
    private final Boolean production;

    /**
     * The id of the associated space.
     *
     * @param spaceId the id of the associated space
     * @return the id of the associated space
     */
    @Getter(onMethod = @__(@JsonProperty("space_guid")))
    private final String spaceId;

    /**
     * The id of the associated stack.
     *
     * @param stackId the id of the associated stack
     * @return the id of the associated stack
     */
    @Getter(onMethod = @__(@JsonProperty("stack_guid")))
    private final String stackId;

    /**
     * The detailed description for the {@link #stagingFailedReason}
     *
     * @param stagignFailedDescription the detailed description for the {@link #stagingFailedReason}
     * @return the detailed description for the {@link #stagingFailedReason}
     */
    @Getter(onMethod = @__(@JsonProperty("staging_failed_description")))
    private final String stagingFailedDescription;

    /**
     * The eason for application staging failures
     *
     * @param stagingFailedReason the reason for application staging failures
     * @return the reason for application staging failures
     */
    @Getter(onMethod = @__(@JsonProperty("staging_failed_reason")))
    private final String stagingFailedReason;

    /**
     * The current desired state of the application
     *
     * @param state the current desired state of the application
     * @return the current desired state of the application
     */
    @Getter(onMethod = @__(@JsonProperty("state")))
    private final String state;

    @Builder
    CreateApplicationRequest(String buildpack,
                             String command,
                             Boolean console,
                             Boolean debug,
                             String detectedStartCommand, Boolean diego,
                             Integer diskQuota,
                             @Singular Map<String, Object> dockerCredentialsJsons,
                             String dockerImage,
                             Boolean enableSsh, @Singular Map<String, Object> environmentJsons,
                             Integer healthCheckTimeout,
                             String healthCheckType,
                             Integer instances,
                             Integer memory,
                             String name,
                             @Singular List<Integer> ports, Boolean production,
                             String spaceId,
                             String stackId,
                             String stagingFailedDescription, String stagingFailedReason, String state) {
        this.buildpack = buildpack;
        this.command = command;
        this.console = console;
        this.debug = debug;
        this.detectedStartCommand = detectedStartCommand;
        this.diego = diego;
        this.diskQuota = diskQuota;
        this.dockerCredentialsJsons = dockerCredentialsJsons;
        this.dockerImage = dockerImage;
        this.enableSsh = enableSsh;
        this.environmentJsons = environmentJsons;
        this.healthCheckTimeout = healthCheckTimeout;
        this.healthCheckType = healthCheckType;
        this.instances = instances;
        this.memory = memory;
        this.name = name;
        this.ports = ports;
        this.production = production;
        this.spaceId = spaceId;
        this.stackId = stackId;
        this.stagingFailedDescription = stagingFailedDescription;
        this.stagingFailedReason = stagingFailedReason;
        this.state = state;
    }

    @Override
    public ValidationResult isValid() {
        ValidationResult.ValidationResultBuilder builder = ValidationResult.builder();

        if (this.name == null) {
            builder.message("name must be specified");
        }

        if (this.spaceId == null) {
            builder.message("space id must be specified");
        }

        return builder.build();
    }

}
