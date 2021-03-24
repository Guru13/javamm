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

import java.util.List;
import static java.util.Objects.requireNonNull;
import by.guru13.javamm.code.fragment.ByteCode;
import by.guru13.javamm.code.fragment.SourceCode;
import by.guru13.javamm.code.fragment.SourceLine;
import by.guru13.javamm.code.fragment.operation.Block;
import by.guru13.javamm.compiler.Compiler;
import by.guru13.javamm.compiler.JavammSyntaxError;
import by.guru13.javamm.compiler.component.BlockOperationReader;
import by.guru13.javamm.compiler.component.SourceLineReader;

public class CompilerImpl implements Compiler {

    private final SourceLineReader sourceLineReader;

    private final BlockOperationReader blockOperationReader;

    public CompilerImpl(final SourceLineReader sourceLineReader, final BlockOperationReader blockOperationReader) {
        this.sourceLineReader = requireNonNull(sourceLineReader);
        this.blockOperationReader = requireNonNull(blockOperationReader);
    }


    @Override
    public ByteCode compile(final SourceCode... sourceCodes) throws JavammSyntaxError {
       final List<SourceLine> sourceLines = sourceLineReader.read(sourceCodes[0]);
       final Block block = blockOperationReader.read(SourceLine.EMPTY_SOURCE_LINE, sourceLines.listIterator());
       return () -> block;
    }
}
