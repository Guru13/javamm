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

package by.guru13.javamm.compiler;

import java.util.Set;
import by.guru13.javamm.compiler.component.BlockOperationReader;
import by.guru13.javamm.compiler.component.OperationReader;
import by.guru13.javamm.compiler.component.SourceLineReader;
import by.guru13.javamm.compiler.component.TokenParser;
import by.guru13.javamm.compiler.component.impl.BlockOperationReaderImpl;
import by.guru13.javamm.compiler.component.impl.CompilerImpl;
import by.guru13.javamm.compiler.component.impl.SourceLineReaderImpl;
import by.guru13.javamm.compiler.component.impl.TokenParserImpl;
import by.guru13.javamm.compiler.component.impl.operation.simple.PrintlnOperationReader;

public class CompilerConfigurator {

    private TokenParser tokenParser = new TokenParserImpl();

    private SourceLineReader sourceLineReader = new SourceLineReaderImpl(tokenParser);

    private Set<OperationReader> operationReaders = Set.of(new PrintlnOperationReader());

    private BlockOperationReader blockOperationReader = new BlockOperationReaderImpl(operationReaders);

    private Compiler compiler = new CompilerImpl(sourceLineReader, blockOperationReader);

    public Compiler getCompiler() {
        return compiler;
    }

}
