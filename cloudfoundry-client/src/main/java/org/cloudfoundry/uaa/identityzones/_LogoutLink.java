/*
 * Copyright 2013-2021 the original author or authors.
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

package org.cloudfoundry.uaa.identityzones;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.cloudfoundry.Nullable;
import org.immutables.value.Value;

import java.util.List;

/**
 * The request payload for the identity zone logout link
 */
@JsonDeserialize
@Value.Immutable
abstract class _LogoutLink {

    /**
     * Whether or not to allow the redirect parameter on logout.
     */
    @JsonProperty("disableRedirectParameter")
    @Nullable
    abstract Boolean getDisableRedirectParameter();

    /**
     * Changes the name of the redirect parameter.
     */
    @JsonProperty("redirectParameterName")
    @Nullable
    abstract String getRedirectParameterName();

    /**
     * Logout redirect url.
     */
    @JsonProperty("redirectUrl")
    @Nullable
    abstract String getRedirectUrl();

    /**
     * List of allowed whitelist redirects.
     */
    @JsonProperty("whitelist")
    @Nullable
    abstract List<String> getWhitelist();

}
