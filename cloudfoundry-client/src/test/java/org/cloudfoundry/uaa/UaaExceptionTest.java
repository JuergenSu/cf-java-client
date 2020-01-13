/*
 * Copyright 2013-2020 the original author or authors.
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

package org.cloudfoundry.uaa;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public final class UaaExceptionTest {

    @Test
    public void test() {
        assertThat(new UaaException(-1, "test-error", "test-error-description"))
            .hasNoCause()
            .hasMessage("test-error: test-error-description")
            .extracting("statusCode", "error", "errorDescription").containsExactly(-1, "test-error", "test-error-description");
    }

}
