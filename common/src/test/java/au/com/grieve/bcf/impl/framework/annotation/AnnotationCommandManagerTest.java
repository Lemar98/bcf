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

package au.com.grieve.bcf.impl.framework.annotation;

import au.com.grieve.bcf.ExecutionCandidate;
import au.com.grieve.bcf.framework.annotation.annotations.Arg;
import au.com.grieve.bcf.framework.annotation.annotations.Command;
import au.com.grieve.bcf.framework.annotation.annotations.Default;
import au.com.grieve.bcf.framework.annotation.annotations.Error;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnnotationCommandManagerTest {

    static class ClassNoCommand extends AnnotationCommand {

    }

    @Command("")
    static class ClassWithEmptyCommand extends AnnotationCommand {

    }

    @Command("cmd1")
    static class ClassWithSingleCommand extends AnnotationCommand {
        @Default
        public void d() {

        }

        @Error
        public void e() {

        }

        @Arg("m_arg1 m_arg2 m_arg3")
        public void m1() {

        }
    }

    @Command("cmd1")
    static class ClassWithSingleCommand2 extends AnnotationCommand {
        @Default
        public void d() {

        }

        @Error
        public void e() {

        }

        @Arg("m_arg1 m_arg2 m_arg3")
        public void m1() {

        }
    }

    @Command("cmd1 c_arg1 c_arg2 c_arg3")
    static class ParentCommand extends AnnotationCommand {
        @Default
        public void d() {

        }

        @Error
        public void e() {

        }

        @Arg("m_arg1 m_arg2 m_arg3")
        public void m1() {

        }
    }


    @Command(value="cmd2 c_arg1 c_arg2 c_arg3", input="c_arg1 c_arg2 c_arg3 child")
    @Arg("child")
    static class ChildCommand extends AnnotationCommand {
        @Default
        public void d() {

        }

        @Error
        public void e() {

        }

        @Arg("m_arg1 m_arg2 m_arg3")
        public void m1() {

        }
    }

    @Command(value="cmd1", input="m_arg1")
    static class ClassWithSingleCommandSingleInput extends AnnotationCommand {
        @Default
        public void d() {

        }

        @Error
        public void e() {

        }

        @Arg("m_arg1 m_arg2 m_arg3")
        public void m1() {

        }
    }

    @Command(value="cmd1", input="m_arg1 m_arg2 m_arg3")
    static class ClassWithSingleCommandMultiInput extends AnnotationCommand {
        @Default
        public void d() {

        }

        @Error
        public void e() {

        }

        @Arg("m_arg1 m_arg2 m_arg3")
        public void m1() {

        }
    }

    @Command("cmd1 c_arg1")
    static class ClassWithSingleCommandSingleParam extends AnnotationCommand {
        @Default
        public void d() {

        }

        @Error
        public void e() {

        }

        @Arg("m_arg1 m_arg2 m_arg3")
        public void m1() {

        }
    }

    @Command(value="cmd1 c_arg1", input="c_arg1")
    static class ClassWithSingleCommandSingleParamSingleInput extends AnnotationCommand {
        @Default
        public void d() {

        }

        @Error
        public void e() {

        }

        @Arg("m_arg1 m_arg2 m_arg3")
        public void m1() {

        }
    }

    @Command(value="cmd1 c_arg1", input="c_arg1 m_arg1 m_arg2")
    static class ClassWithSingleCommandSingleParamMultipleInput extends AnnotationCommand {
        @Default
        public void d() {

        }

        @Error
        public void e() {

        }

        @Arg("m_arg1 m_arg2 m_arg3")
        public void m1() {

        }
    }

    @Command("cmd1 c_arg1 c_arg2 c_arg3")
    static class ClassWithSingleCommandMultiParam extends AnnotationCommand {
        @Default
        public void d() {

        }

        @Error
        public void e() {

        }

        @Arg("m_arg1 m_arg2 m_arg3")
        public void m1() {

        }
    }

    @Command(value="cmd1 c_arg1 c_arg2 c_arg3", input="c_arg1")
    static class ClassWithSingleCommandMultiParamSingleInput extends AnnotationCommand {
        @Default
        public void d() {

        }

        @Error
        public void e() {

        }

        @Arg("m_arg1 m_arg2 m_arg3")
        public void m1() {

        }
    }

    @Command(value="cmd1 c_arg1 c_arg2 c_arg3", input="c_arg1 c_arg2 c_arg3 m_arg1 m_arg2")
    static class ClassWithSingleCommandMultiParamMultiInput extends AnnotationCommand {
        @Default
        public void d() {

        }

        @Error
        public void e() {

        }

        @Arg("m_arg1 m_arg2 m_arg3")
        public void m1() {

        }
    }

    @Command("cmd1|cmd2|cmd3")
    static class ClassWithMultiCommand extends AnnotationCommand {
        @Default
        public void d() {

        }

        @Error
        public void e() {

        }

        @Arg("m_arg1 m_arg2 m_arg3")
        public void m1() {

        }
    }

    @Command("cmd1|cmd2|cmd3 c_arg1")
    static class ClassWithMultiCommandSingleParam extends AnnotationCommand {
        @Default
        public void d() {

        }

        @Error
        public void e() {

        }

        @Arg("m_arg1 m_arg2 m_arg3")
        public void m1() {

        }
    }

    @Command("cmd1|cmd2|cmd3 c_arg1 c_arg2 c_arg3")
    static class ClassWithMultiCommandMultiParam extends AnnotationCommand {
        @Default
        public void d() {

        }

        @Error
        public void e() {

        }

        @Arg("m_arg1 m_arg2 m_arg3")
        public void m1() {

        }
    }

    @Command("cmd1|cmd4|cmd5")
    static class ClassWithOverlappingName extends AnnotationCommand {
        @Default
        public void d() {

        }

        @Error
        public void e() {

        }

        @Arg("m_arg1 m_arg2 m_arg3")
        public void m1() {

        }
    }

    @Command("cmd4|cmd2|cmd5")
    static class ClassWithOverlappingAlias extends AnnotationCommand {
        @Default
        public void d() {

        }

        @Error
        public void e() {

        }

        @Arg("m_arg1 m_arg2 m_arg3")
        public void m1() {

        }
    }

    @Test
    public void registerCommandNoCommand() {
        AnnotationCommandManager manager = new AnnotationCommandManager();
        assertThrows(RuntimeException.class, () -> manager.registerCommand(new ClassNoCommand()));
    }

    @Test
    public void registerCommandEmptyCommand() {
        AnnotationCommandManager manager = new AnnotationCommandManager();
        assertThrows(RuntimeException.class, () -> manager.registerCommand(new ClassWithEmptyCommand()));
    }

    @Test
    public void registerCommandSingle_1() {
        AnnotationCommand c1 = new ClassWithSingleCommand();
        AnnotationCommandManager manager = new AnnotationCommandManager();
        manager.registerCommand(c1);
        ExecutionCandidate e = manager.execute("");

        assertNull(e);
    }

    @Test
    public void registerCommandSingle_2() {
        AnnotationCommand c1 = new ClassWithSingleCommand();
        AnnotationCommandManager manager = new AnnotationCommandManager();
        manager.registerCommand(c1);
        ExecutionCandidate e = manager.execute("bob");

        assertNull(e);
    }

    @Test
    public void registerCommandSingle_3() throws NoSuchMethodException {
        AnnotationCommand c1 = new ClassWithSingleCommand();
        AnnotationCommandManager manager = new AnnotationCommandManager();
        manager.registerCommand(c1);
        ExecutionCandidate e = manager.execute("cmd1");

        assertEquals(c1.getClass().getMethod("d"), e.getMethod());
    }

    @Test
    public void registerCommandSingle_4() throws NoSuchMethodException {
        AnnotationCommand c1 = new ClassWithSingleCommand();
        AnnotationCommandManager manager = new AnnotationCommandManager();
        manager.registerCommand(c1);
        ExecutionCandidate e = manager.execute("cmd1 bob");

        assertEquals(c1.getClass().getMethod("d"), e.getMethod());
    }

    @Test
    public void registerCommandSingle_5() throws NoSuchMethodException {
        AnnotationCommand c1 = new ClassWithSingleCommand();
        AnnotationCommandManager manager = new AnnotationCommandManager();
        manager.registerCommand(c1);
        ExecutionCandidate e = manager.execute("cmd1 m_arg1 m_arg2");

        assertEquals(c1.getClass().getMethod("e"), e.getMethod());

    }

    @Test
    public void registerCommandSingle_6() throws NoSuchMethodException {
        AnnotationCommand c1 = new ClassWithSingleCommand();
        AnnotationCommandManager manager = new AnnotationCommandManager();
        manager.registerCommand(c1);
        ExecutionCandidate e = manager.execute("cmd1 m_arg1 m_arg2 m_arg3");

        assertEquals(c1.getClass().getMethod("m1"), e.getMethod());
    }

    @Test
    public void registerCommandSingle_7() throws NoSuchMethodException {
        AnnotationCommand c1 = new ClassWithSingleCommandSingleInput();
        AnnotationCommandManager manager = new AnnotationCommandManager();
        manager.registerCommand(c1);
        ExecutionCandidate e = manager.execute("cmd1 m_arg1 m_arg2 m_arg3");

        assertEquals(c1.getClass().getMethod("e"), e.getMethod());
    }

    @Test
    public void registerCommandSingle_8() throws NoSuchMethodException {
        AnnotationCommand c1 = new ClassWithSingleCommandSingleInput();
        AnnotationCommandManager manager = new AnnotationCommandManager();
        manager.registerCommand(c1);
        ExecutionCandidate e = manager.execute("cmd1 m_arg2 m_arg3");

        assertEquals(c1.getClass().getMethod("m1"), e.getMethod());
    }

    @Test
    public void registerCommandSingle_9() throws NoSuchMethodException {
        AnnotationCommand c1 = new ClassWithSingleCommandMultiInput();
        AnnotationCommandManager manager = new AnnotationCommandManager();
        manager.registerCommand(c1);
        ExecutionCandidate e = manager.execute("cmd1");

        assertEquals(c1.getClass().getMethod("m1"), e.getMethod());
    }


    @Test
    public void registerCommandSingleParamSingle_1() {
        AnnotationCommand c1 = new ClassWithSingleCommandSingleParam();
        AnnotationCommandManager manager = new AnnotationCommandManager();
        manager.registerCommand(c1);
        ExecutionCandidate e = manager.execute("");

        assertNull(e);
    }

    @Test
    public void registerCommandSingleParamSingle_2() {
        AnnotationCommand c1 = new ClassWithSingleCommandSingleParam();
        AnnotationCommandManager manager = new AnnotationCommandManager();
        manager.registerCommand(c1);
        ExecutionCandidate e = manager.execute("bob");

        assertNull(e);
    }

    @Test
    public void registerCommandSingleParamSingle_3() throws NoSuchMethodException {
        AnnotationCommand c1 = new ClassWithSingleCommandSingleParam();
        AnnotationCommandManager manager = new AnnotationCommandManager();
        manager.registerCommand(c1);
        ExecutionCandidate e = manager.execute("cmd1");

        assertEquals(c1.getClass().getMethod("e"), e.getMethod());
    }

    @Test
    public void registerCommandSingleParamSingle_4() throws NoSuchMethodException {
        AnnotationCommand c1 = new ClassWithSingleCommandSingleParam();
        AnnotationCommandManager manager = new AnnotationCommandManager();
        manager.registerCommand(c1);
        ExecutionCandidate e = manager.execute("cmd1 bob");

        assertEquals(c1.getClass().getMethod("e"), e.getMethod());
    }

    @Test
    public void registerCommandSingleParamSingle_5() throws NoSuchMethodException {
        AnnotationCommand c1 = new ClassWithSingleCommandSingleParam();
        AnnotationCommandManager manager = new AnnotationCommandManager();
        manager.registerCommand(c1);
        ExecutionCandidate e = manager.execute("cmd1 m_arg1 m_arg2");

        assertEquals(c1.getClass().getMethod("e"), e.getMethod());

    }

    @Test
    public void registerCommandSingleParamSingle_6() throws NoSuchMethodException {
        AnnotationCommand c1 = new ClassWithSingleCommandSingleParam();
        AnnotationCommandManager manager = new AnnotationCommandManager();
        manager.registerCommand(c1);
        ExecutionCandidate e = manager.execute("cmd1 m_arg1 m_arg2 m_arg3");

        assertEquals(c1.getClass().getMethod("e"), e.getMethod());
    }

    @Test
    public void registerCommandSingleParamSingle_7() throws NoSuchMethodException {
        AnnotationCommand c1 = new ClassWithSingleCommandSingleParam();
        AnnotationCommandManager manager = new AnnotationCommandManager();
        manager.registerCommand(c1);
        ExecutionCandidate e = manager.execute("cmd1 m_arg2 m_arg3");

        assertEquals(c1.getClass().getMethod("e"), e.getMethod());
    }

    @Test
    public void registerCommandSingleParamSingle_8() throws NoSuchMethodException {
        AnnotationCommand c1 = new ClassWithSingleCommandSingleParam();
        AnnotationCommandManager manager = new AnnotationCommandManager();
        manager.registerCommand(c1);
        ExecutionCandidate e = manager.execute("cmd1 c_arg1 m_arg1 m_arg2 m_arg3");

        assertEquals(c1.getClass().getMethod("m1"), e.getMethod());
    }

    @Test
    public void registerCommandSingleParamSingle_9() throws NoSuchMethodException {
        AnnotationCommand c1 = new ClassWithSingleCommandSingleParamSingleInput();
        AnnotationCommandManager manager = new AnnotationCommandManager();
        manager.registerCommand(c1);
        ExecutionCandidate e = manager.execute("cmd1 m_arg1 m_arg2 m_arg3");

        assertEquals(c1.getClass().getMethod("m1"), e.getMethod());
    }

    @Test
    public void registerCommandSingleParamSingle_10() throws NoSuchMethodException {
        AnnotationCommand c1 = new ClassWithSingleCommandSingleParamMultipleInput();
        AnnotationCommandManager manager = new AnnotationCommandManager();
        manager.registerCommand(c1);
        ExecutionCandidate e = manager.execute("cmd1 m_arg3");

        assertEquals(c1.getClass().getMethod("m1"), e.getMethod());
    }

    @Test
    public void registerCommandSingleParamMulti_1() {
        AnnotationCommand c1 = new ClassWithSingleCommandMultiParam();
        AnnotationCommandManager manager = new AnnotationCommandManager();
        manager.registerCommand(c1);
        ExecutionCandidate e = manager.execute("");

        assertNull(e);
    }

    @Test
    public void registerCommandSingleParamMulti_2() throws NoSuchMethodException {
        AnnotationCommand c1 = new ClassWithSingleCommandMultiParam();
        AnnotationCommandManager manager = new AnnotationCommandManager();
        manager.registerCommand(c1);
        ExecutionCandidate e = manager.execute("cmd1 c_arg1 c_arg2 c_arg3 m_arg1 m_arg2 m_arg3");

        assertEquals(c1.getClass().getMethod("m1"), e.getMethod());
    }

    @Test
    public void registerCommandSingleParamMulti_3() throws NoSuchMethodException {
        AnnotationCommand c1 = new ClassWithSingleCommandMultiParamSingleInput();
        AnnotationCommandManager manager = new AnnotationCommandManager();
        manager.registerCommand(c1);
        ExecutionCandidate e = manager.execute("cmd1 c_arg2 c_arg3 m_arg1 m_arg2 m_arg3");

        assertEquals(c1.getClass().getMethod("m1"), e.getMethod());
    }

    @Test
    public void registerCommandSingleParamMulti_4() throws NoSuchMethodException {
        AnnotationCommand c1 = new ClassWithSingleCommandMultiParamMultiInput();
        AnnotationCommandManager manager = new AnnotationCommandManager();
        manager.registerCommand(c1);
        ExecutionCandidate e = manager.execute("cmd1 m_arg3");

        assertEquals(c1.getClass().getMethod("m1"), e.getMethod());
    }

    @Test
    public void registerCommandMulti_1() throws NoSuchMethodException {
        AnnotationCommand c1 = new ClassWithMultiCommand();
        AnnotationCommandManager manager = new AnnotationCommandManager();
        manager.registerCommand(c1);
        ExecutionCandidate e = manager.execute("cmd1 m_arg1 m_arg2 m_arg3");

        assertEquals(c1.getClass().getMethod("m1"), e.getMethod());
    }

    @Test
    public void registerCommandMulti_2() throws NoSuchMethodException {
        AnnotationCommand c1 = new ClassWithMultiCommand();
        AnnotationCommandManager manager = new AnnotationCommandManager();
        manager.registerCommand(c1);
        ExecutionCandidate e = manager.execute("cmd2 m_arg1 m_arg2 m_arg3");

        assertEquals(c1.getClass().getMethod("m1"), e.getMethod());
    }

    @Test
    public void registerCommandMulti_3() throws NoSuchMethodException {
        AnnotationCommand c1 = new ClassWithMultiCommand();
        AnnotationCommandManager manager = new AnnotationCommandManager();
        manager.registerCommand(c1);
        ExecutionCandidate e = manager.execute("bob m_arg1 m_arg2 m_arg3");

        assertNull(e);
    }

    @Test
    public void registerCommandMultiParamSingle_1() throws NoSuchMethodException {
        AnnotationCommand c1 = new ClassWithMultiCommandSingleParam();
        AnnotationCommandManager manager = new AnnotationCommandManager();
        manager.registerCommand(c1);
        ExecutionCandidate e = manager.execute("cmd1 c_arg1 m_arg1 m_arg2 m_arg3");

        assertEquals(c1.getClass().getMethod("m1"), e.getMethod());
    }

    @Test
    public void registerCommandMultiParamSingle_2() throws NoSuchMethodException {
        AnnotationCommand c1 = new ClassWithMultiCommandSingleParam();
        AnnotationCommandManager manager = new AnnotationCommandManager();
        manager.registerCommand(c1);
        ExecutionCandidate e = manager.execute("cmd2 c_arg1 m_arg1 m_arg2 m_arg3");

        assertEquals(c1.getClass().getMethod("m1"), e.getMethod());
    }

    @Test
    public void registerCommandMultiParamSingle_3() throws NoSuchMethodException {
        AnnotationCommand c1 = new ClassWithMultiCommandSingleParam();
        AnnotationCommandManager manager = new AnnotationCommandManager();
        manager.registerCommand(c1);
        ExecutionCandidate e = manager.execute("bpb c_arg1 m_arg1 m_arg2 m_arg3");

        assertNull(e);
    }

    @Test
    public void registerCommandMultiParamMulti_1() throws NoSuchMethodException {
        AnnotationCommand c1 = new ClassWithMultiCommandMultiParam();
        AnnotationCommandManager manager = new AnnotationCommandManager();
        manager.registerCommand(c1);
        ExecutionCandidate e = manager.execute("cmd1 c_arg1 c_arg2 c_arg3 m_arg1 m_arg2 m_arg3");

        assertEquals(c1.getClass().getMethod("m1"), e.getMethod());
    }

    @Test
    public void registerCommandMultiParamMulti_2() throws NoSuchMethodException {
        AnnotationCommand c1 = new ClassWithMultiCommandMultiParam();
        AnnotationCommandManager manager = new AnnotationCommandManager();
        manager.registerCommand(c1);
        ExecutionCandidate e = manager.execute("cmd2 c_arg1 c_arg2 c_arg3 m_arg1 m_arg2 m_arg3");

        assertEquals(c1.getClass().getMethod("m1"), e.getMethod());
    }

    @Test
    public void registerOverlap_1() throws NoSuchMethodException {
        AnnotationCommand c1 = new ClassWithSingleCommand();
        AnnotationCommand c2 = new ClassWithSingleCommand2();
        AnnotationCommandManager manager = new AnnotationCommandManager();
        manager.registerCommand(c1);
        manager.registerCommand(c2);

        ExecutionCandidate e = manager.execute("cmd1 m_arg1 m_arg2 m_arg3");

        assertEquals(c1.getClass().getMethod("m1"), e.getMethod());
        assertNotEquals(c2.getClass().getMethod("m1"), e.getMethod());
    }

    @Test
    public void registerOverlap_2() throws NoSuchMethodException {
        AnnotationCommand c1 = new ClassWithOverlappingName();
        AnnotationCommand c2 = new ClassWithOverlappingAlias();
        AnnotationCommandManager manager = new AnnotationCommandManager();
        manager.registerCommand(c1);
        manager.registerCommand(c2);

        ExecutionCandidate e = manager.execute("cmd1 m_arg1 m_arg2 m_arg3");

        assertEquals(c1.getClass().getMethod("m1"), e.getMethod());
        assertNotEquals(c2.getClass().getMethod("m1"), e.getMethod());
    }

    @Test
    public void registerOverlap_3() throws NoSuchMethodException {
        AnnotationCommand c1 = new ClassWithOverlappingName();
        AnnotationCommand c2 = new ClassWithOverlappingAlias();
        AnnotationCommandManager manager = new AnnotationCommandManager();
        manager.registerCommand(c1);
        manager.registerCommand(c2);

        ExecutionCandidate e = manager.execute("cmd5 m_arg1 m_arg2 m_arg3");

        assertEquals(c1.getClass().getMethod("m1"), e.getMethod());
        assertNotEquals(c2.getClass().getMethod("m1"), e.getMethod());
    }

    @Test
    public void registerOverlap_4() throws NoSuchMethodException {
        AnnotationCommand c1 = new ClassWithOverlappingName();
        AnnotationCommand c2 = new ClassWithOverlappingAlias();
        AnnotationCommandManager manager = new AnnotationCommandManager();
        manager.registerCommand(c1);
        manager.registerCommand(c2);

        ExecutionCandidate e = manager.execute("cmd4 m_arg1 m_arg2 m_arg3");

        assertEquals(c2.getClass().getMethod("m1"), e.getMethod());
        assertNotEquals(c1.getClass().getMethod("m1"), e.getMethod());
    }

    @Test
    public void childCommand_1() throws NoSuchMethodException {
        AnnotationCommand c1 = new ParentCommand();
        AnnotationCommand c2 = new ChildCommand();
        AnnotationCommandManager manager = new AnnotationCommandManager();
        manager.registerCommand(c1);
        manager.registerCommand(c1.getClass(), c2);

        ExecutionCandidate e = manager.execute("cmd1 c_arg1 c_arg2 c_arg3 m_arg1 m_arg2 m_arg3");

        assertEquals(c1.getClass().getMethod("m1"), e.getMethod());
        assertNotEquals(c2.getClass().getMethod("m1"), e.getMethod());
    }

    @Test
    public void childCommand_2() throws NoSuchMethodException {
        AnnotationCommand c1 = new ParentCommand();
        AnnotationCommand c2 = new ChildCommand();
        AnnotationCommandManager manager = new AnnotationCommandManager();
        manager.registerCommand(c1);
        manager.registerCommand(c1.getClass(), c2);

        ExecutionCandidate e = manager.execute("cmd1 c_arg1 c_arg2 c_arg3 child m_arg1 m_arg2 m_arg3");

        assertEquals(c2.getClass().getMethod("m1"), e.getMethod());
        assertNotEquals(c1.getClass().getMethod("m1"), e.getMethod());
    }

    @Test
    public void childCommand_3() throws NoSuchMethodException {
        AnnotationCommand c1 = new ParentCommand();
        AnnotationCommand c2 = new ChildCommand();
        AnnotationCommandManager manager = new AnnotationCommandManager();
        manager.registerCommand(c1);
        manager.registerCommand(c1.getClass(), c2);

        ExecutionCandidate e = manager.execute("cmd2 m_arg1 m_arg2 m_arg3");

        assertEquals(c2.getClass().getMethod("m1"), e.getMethod());
        assertNotEquals(c1.getClass().getMethod("m1"), e.getMethod());
    }


}