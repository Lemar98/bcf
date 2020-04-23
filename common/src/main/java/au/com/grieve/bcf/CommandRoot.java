/*
 * Copyright (c) 2020-2020 Brendan Grieve (bundabrg) - MIT License
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

import au.com.grieve.bcf.utils.ReflectUtils;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommandRoot {
    @Getter
    final BaseCommand command;

    @Getter
    final CommandManager manager;

    @Getter
    final List<BaseCommand> subCommands = new ArrayList<>();

    CommandRoot(CommandManager manager, BaseCommand command) {
        this.manager = manager;
        this.command = command;
    }

    /**
     * Add sub command
     *
     * @param cmd
     */
    public void addSubCommand(BaseCommand cmd) {
        // Lookup all parent classes till it reaches our command
        List<Class<?>> parents = new ArrayList<>();
        for (Class<?> parent : ReflectUtils.getAllSuperClasses(cmd.getClass())) {
            parents.add(parent);
            if (parent == this.getClass()) {
                break;
            }
        }
        Collections.reverse(parents);

        ParserNode node;

        // Add a parser for each parent class
        for (Class<?> parent : parents) {

        }


    }

    /**
     * Parse the arguments and return an executor
     */
    CommandExecute parseExecute(String[] args, CommandContext context) {


    }

    List<String> parseComplete(String[] args, CommandContext context) {

    }
}
