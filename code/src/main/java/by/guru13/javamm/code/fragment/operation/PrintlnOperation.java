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

package by.guru13.javamm.code.fragment.operation;

import static java.util.Objects.requireNonNull;
import by.guru13.javamm.code.fragment.Operation;
import by.guru13.javamm.code.fragment.SourceLine;
import by.guru13.javamm.code.fragment.operation.AbstractOperation;

/**
 * @author Aliaksei Huryanchyk
 */
public class PrintlnOperation extends AbstractOperation implements Operation {

    private final String text;

    public PrintlnOperation(final SourceLine sourceLine, final String text) {
        super(sourceLine);
        this.text = requireNonNull(text);
    }

    public String getText() {
        return text;
    }
}
