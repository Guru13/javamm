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

package by.guru13.temp.nullobject;

import java.util.List;
import java.util.Optional;

/**
 * @author Aliaksei Huryanchyk
 */
public class Example01ReturnValue {

    private final String requireObject;

    private final String optionalObject;

    private final List<String> requireList;

    private final List<String> optionalList;

    public Example01ReturnValue(final String requireObject, final String optionalObject, final List<String> requireList,
                                final List<String> optionalList) {
        this.requireObject = requireObject;
        this.optionalObject = optionalObject;
        this.requireList = requireList;
        this.optionalList = optionalList == null ? List.of() : List.copyOf(optionalList);
    }

    public Example01ReturnValue() {
        this("required", null, List.of("required"), null);
    }

    public String getRequireObject() {
        return requireObject;
    }

    public Optional<String> getOptionalObject() {
        return Optional.ofNullable(optionalObject);
    }

    public List<String> getRequireList() {
        return requireList;
    }

    public List<String> getOptionalList() {
        return optionalList;
    }
}
