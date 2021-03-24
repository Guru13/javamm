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

package by.guru13.javamm.compiler.component.impl.operation;

import java.util.ListIterator;
import java.util.Optional;
import by.guru13.javamm.code.fragment.Operation;
import by.guru13.javamm.code.fragment.SourceLine;
import by.guru13.javamm.compiler.component.OperationReader;

public abstract class AbstractOperationReader<T extends Operation> implements OperationReader {

    @Override
    public boolean canRead(final SourceLine sourceLine) {
        final Optional<String> keywordOptional = getOperationKeyword();
        return keywordOptional.isPresent() && keywordOptional.get().equals(sourceLine.getFirst());
    }

    protected Optional<String> getOperationKeyword() {
        return Optional.empty();
    }

    @Override
    public Operation read(final SourceLine sourceLine, final ListIterator<SourceLine> iterator) {
        validate(sourceLine);
        return get(sourceLine, iterator);
    }

    protected void validate(final SourceLine sourceLine) {
        //do nothing
    }

    protected abstract T get(SourceLine sourceLine, ListIterator<SourceLine> iterator);
}