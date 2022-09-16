/*
 * Copyright (c) 2020-2022 Brendan Grieve (bundabrg) - MIT License
 *
 *  Permission is hereby granted, free of charge, to any person obtaining
 *  a copy of this software and associated documentation files (the
 *  "Software"), to deal in the Software without restriction, including
 *  without limitation the rights to use, copy, modify, merge, publish,
 *  distribute, sublicense, and/or sell copies of the Software, and to
 *  permit persons to whom the Software is furnished to do so, subject to
 *  the following conditions:
 *
 *  The above copyright notice and this permission notice shall be
 *  included in all copies or substantial portions of the Software.
 *
 *   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *  MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 *  LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 *  OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 *  WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package au.com.grieve.bcf.impl.parser;

import au.com.grieve.bcf.CompletionCandidateGroup;
import au.com.grieve.bcf.ParsedLine;
import au.com.grieve.bcf.exception.EndOfLineException;
import au.com.grieve.bcf.impl.completion.DefaultCompletionCandidate;
import au.com.grieve.bcf.impl.completion.DefaultCompletionCandidateGroup;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@ToString(callSuper = true)
public class IntegerParser extends BaseParser<Integer> {
    public IntegerParser(Map<String, String> parameters) {
        super(parameters);
    }

    @Override
    protected Integer doParse(ParsedLine line) throws EndOfLineException, IllegalArgumentException {
        int result = Integer.parseInt(line.next());
        if (getParameters().get("max") != null && result > Integer.parseInt(getParameters().get("max"))) {
            throw new IllegalArgumentException("Value larger than max");
        }

        if (getParameters().get("min") != null && result < Integer.parseInt(getParameters().get("min"))) {
            throw new IllegalArgumentException("Value smaller than min");
        }

        return result;
    }

    @Override
    protected void doComplete(ParsedLine line, List<CompletionCandidateGroup> candidates) throws EndOfLineException {
        String input = line.getCurrentWord();

        // Show a number range if both min and max defined
        if (getParameters().containsKey("min") && getParameters().containsKey("max")) {
            int min = Integer.parseInt(getParameters().get("min"));
            int max = Integer.parseInt(getParameters().get("max"));

            DefaultCompletionCandidateGroup group = new DefaultCompletionCandidateGroup(getParameters().get("description"));
            group.getCompletionCandidates().addAll(
                    IntStream.rangeClosed(min, max)
                            .mapToObj(String::valueOf)
                            .filter(s -> s.startsWith(input))
                            .limit(20)
                            .map(DefaultCompletionCandidate::new)
                            .collect(Collectors.toList())
            );
            candidates.add(group);
        }

        line.next();
    }
}
