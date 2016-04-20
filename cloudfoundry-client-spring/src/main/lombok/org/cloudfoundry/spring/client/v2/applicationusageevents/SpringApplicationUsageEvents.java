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

package org.cloudfoundry.spring.client.v2.applicationusageevents;

import lombok.ToString;
import org.cloudfoundry.client.v2.applicationusageevents.ApplicationUsageEvents;
import org.cloudfoundry.client.v2.applicationusageevents.GetApplicationUsageEventRequest;
import org.cloudfoundry.client.v2.applicationusageevents.GetApplicationUsageEventResponse;
import org.cloudfoundry.client.v2.applicationusageevents.ListApplicationUsageEventsRequest;
import org.cloudfoundry.client.v2.applicationusageevents.ListApplicationUsageEventsResponse;
import org.cloudfoundry.client.v2.applicationusageevents.PurgeAndReseedApplicationUsageEventsRequest;
import org.cloudfoundry.spring.util.AbstractSpringOperations;
import org.cloudfoundry.spring.util.QueryBuilder;
import org.springframework.web.client.RestOperations;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

import java.net.URI;

/**
 * The Spring-based implementation of {@link ApplicationUsageEvents}
 */
@ToString(callSuper = true)
public final class SpringApplicationUsageEvents extends AbstractSpringOperations implements ApplicationUsageEvents {

    /**
     * Creates an instance
     *
     * @param restOperations the {@link RestOperations} to use to communicate with the server
     * @param root           the root URI of the server.  Typically something like {@code https://api.run.pivotal.io}.
     * @param schedulerGroup The group to use when making requests
     */
    public SpringApplicationUsageEvents(RestOperations restOperations, URI root, Scheduler schedulerGroup) {
        super(restOperations, root, schedulerGroup);
    }

    @Override
    public Mono<GetApplicationUsageEventResponse> get(GetApplicationUsageEventRequest request) {
        return get(request, GetApplicationUsageEventResponse.class, builder -> builder.pathSegment("v2", "app_usage_events", request.getApplicationUsageEventId()));
    }

    @Override
    public Mono<ListApplicationUsageEventsResponse> list(ListApplicationUsageEventsRequest request) {
        return get(request, ListApplicationUsageEventsResponse.class, builder -> {
            builder.pathSegment("v2", "app_usage_events");
            QueryBuilder.augment(builder, request);
        });
    }

    @Override
    public Mono<Void> purgeAndReseed(PurgeAndReseedApplicationUsageEventsRequest request) {
        return post(request, Void.class, builder -> builder.pathSegment("v2", "app_usage_events", "destructively_purge_all_and_reseed_started_apps"));
    }

}