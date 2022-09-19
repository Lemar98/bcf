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
import au.com.grieve.bcf.impl.completion.ParserCompletionCandidateGroup;
import java.util.List;
import java.util.Map;
import lombok.ToString;

@ToString(callSuper = true)
public class FloatParser extends BaseParser<Float> {
  public FloatParser(Map<String, String> parameters) {
    super(parameters);
  }

  @Override
  protected Float doParse(ParsedLine line) throws EndOfLineException, IllegalArgumentException {
    String input = line.next();
    float result;

    try {
      result = Float.parseFloat(input);
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("Not a valid floating point number: '" + input + "'");
    }

    if (getParameters().get("max") != null
        && result > Float.parseFloat(getParameters().get("max"))) {
      throw new IllegalArgumentException(
          "'" + result + "' is larger than the maximum '" + getParameters().get("max") + "'");
    }

    if (getParameters().get("min") != null
        && result < Float.parseFloat(getParameters().get("min"))) {
      throw new IllegalArgumentException(
          "'" + result + "' is smaller than the minimum '" + getParameters().get("min") + "'");
    }

    return result;
  }

  @Override
  protected void doComplete(ParsedLine line, List<CompletionCandidateGroup> candidates)
      throws EndOfLineException {
    String input = line.getCurrentWord();

    ParserCompletionCandidateGroup group = new ParserCompletionCandidateGroup(this, input);
    group
        .getCompletionCandidates()
        .add(
            new DefaultCompletionCandidate(
                "", getParameters().getOrDefault("placeholder", "<float>")));
    candidates.add(group);

    line.next();
  }
}
