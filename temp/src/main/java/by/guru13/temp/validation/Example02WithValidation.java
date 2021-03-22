/*
 *     Copyright 2019. http://devonline.academy
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package by.guru13.temp.validation;

import static java.util.Objects.requireNonNull;

/**
 * @author Aliaksei Huryanchyk
 */
public class Example02WithValidation {
    private final String requiredObject;

    public Example02WithValidation(final String requiredObject) {

        this.requiredObject = requireNonNull(requiredObject);
    }

    public String getRequiredObject() {
        return requiredObject;
    }
}
