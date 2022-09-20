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

package au.com.grieve.bcf;

import au.com.grieve.bcf.exception.EndOfLineException;
import au.com.grieve.bcf.exception.ParserSyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.ToString;

/**
 * Converts input into objects based upon what the parser is expecting. Also provides completion by
 * providing candidates.
 */
@Getter
@ToString
public abstract class Parser<RT> {

  private final Map<String, String> parameters = new HashMap<>();

  public Parser(Map<String, String> parameters) {
    this.parameters.putAll(parameters);
  }

  /**
   * Provide completion candidates for the input
   *
   * @param context The context
   * @param candidates List of candidates
   */
  public abstract void complete(
      Context context, ParsedLine line, List<CompletionCandidateGroup> candidates)
      throws EndOfLineException;

  /**
   * Return a concrete object for the parsed input
   *
   * @param context The context
   * @return returned object
   */
  public abstract RT parse(Context context, ParsedLine line)
      throws EndOfLineException, ParserSyntaxException;
}
