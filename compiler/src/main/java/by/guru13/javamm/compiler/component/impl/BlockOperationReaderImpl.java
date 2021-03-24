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

package by.guru13.javamm.compiler.component.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import by.guru13.javamm.code.fragment.Operation;
import by.guru13.javamm.code.fragment.SourceLine;
import by.guru13.javamm.code.fragment.operation.Block;
import by.guru13.javamm.compiler.component.BlockOperationReader;
import by.guru13.javamm.compiler.component.OperationReader;
import by.guru13.javamm.compiler.component.impl.error.JavammLineSyntaxError;

public class BlockOperationReaderImpl implements BlockOperationReader {

    private final Collection<OperationReader> operationReaders;

    public BlockOperationReaderImpl(final Collection<OperationReader> operationReaders) {
        this.operationReaders = List.copyOf(operationReaders);
    }


    @Override
    public Block read(final SourceLine sourceLine, final ListIterator<SourceLine> iterator) {
        final List<Operation> operations = new ArrayList<>();
        readBlockOperations(operations, iterator);
        return new Block(operations, sourceLine);
    }

    private void readBlockOperations(final List<Operation> operations, final ListIterator<SourceLine> iterator) {
        while (iterator.hasNext()) {
            final SourceLine sourceLine = iterator.next();
                final Optional<OperationReader> optionalOperationReader = findOperationReader(sourceLine);
                if(optionalOperationReader.isPresent()) {
                    operations.add(optionalOperationReader.get().read(sourceLine, iterator));
                } else {
                    //FIXME Replace by expression resolver
                    throw new JavammLineSyntaxError("Unsupported operation: " + sourceLine.getCommand(), sourceLine);
                }
        }
    }

    private Optional<OperationReader> findOperationReader(final SourceLine sourceLine) {
        for (final OperationReader operationReader : operationReaders) {
            if (operationReader.canRead(sourceLine)) {
                return Optional.of(operationReader);
            }
        }
        return Optional.empty();
    }
}
