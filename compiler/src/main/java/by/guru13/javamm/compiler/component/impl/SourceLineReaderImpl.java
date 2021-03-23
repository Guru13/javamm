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
import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import by.guru13.javamm.code.fragment.SourceCode;
import by.guru13.javamm.code.fragment.SourceLine;
import by.guru13.javamm.compiler.component.SourceLineReader;
import by.guru13.javamm.compiler.component.TokenParser;
import by.guru13.javamm.compiler.model.TokenParserResult;

public class SourceLineReaderImpl implements SourceLineReader {

    private final TokenParser tokenParser;

    public SourceLineReaderImpl(final TokenParser tokenParser) {

        this.tokenParser = requireNonNull(tokenParser);
    }

    @Override
    public List<SourceLine> read(final SourceCode sourceCode) {
        final List<SourceLine> list = new ArrayList<>();
        final String moduleName = sourceCode.getModuleName();
        int number = 1;
        boolean multilineCommentStarted = false;
        for (final String line : sourceCode.getLines()) {
            TokenParserResult tokenParserResult = tokenParser.parseLine(line, multilineCommentStarted);
            multilineCommentStarted = tokenParserResult.isMultilineCommentStarted();
            if (tokenParserResult.isNotEmpty()) {
                list.add(new SourceLine(moduleName, number, tokenParserResult.getTokens()));
            }
            number++;
        }
        return Collections.unmodifiableList(list);
    }
}
