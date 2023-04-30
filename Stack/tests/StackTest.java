import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Stack.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {
    private Stack stack;

    @BeforeEach
    void setUp() {
        stack = new Stack();
    }

    @Test
    public void newStack_isEmpty() throws Exception {
        assertTrue(this.stack.isEmpty());
    }

    @Test
    public void afterOnePush_isNotEmpty() throws Exception {
        this.stack.push(0);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void popOnEmptyStack_throwsUnderflowException() throws Exception {
        Stack.UnderflowException thrown = Assertions.assertThrows(Stack.UnderflowException.class, () -> {
            this.stack.pop();
        });
    }

    @Test
    public void afterOnePushAndOnePop_stackIsEmpty() throws Exception {
        this.stack.push(0);
        this.stack.pop();
        assertTrue(this.stack.isEmpty());
    }

    @Test
    public void afterTwoPushesAndOnePop_stackIsNotEmpty() throws Exception {
        this.stack.push(0);
        this.stack.push(0);
        this.stack.pop();
        assertFalse(this.stack.isEmpty());
    }

    @Test
    public void afterPushingX_willPopX() throws Exception {
        this.stack.push(4);
        assertEquals(4, this.stack.pop());
        this.stack.push(5);
        assertEquals(5, this.stack.pop());
    }

    @Test
    public void peekEmptyStack_throwsUnderflowException() throws Exception {
        Stack.UnderflowException thrown = Assertions.assertThrows(Stack.UnderflowException.class, () -> {
            this.stack.peek();
        });
    }

    @Test
    public void afterPushThenPeek_stackIsNotEmpty() throws Exception {
        this.stack.push(0);
        this.stack.peek();
        assertFalse(this.stack.isEmpty());
    }

    @Test
    public void afterPushingX_willPeekX() throws Exception {
        this.stack.push(4);
        assertEquals(4, this.stack.peek());
    }

    @Test
    public void afterPushingXthenY_willPopYThenX() throws Exception {
        this.stack.push(4);
        this.stack.push(5);
        assertEquals(5, this.stack.pop());
        assertEquals(4, this.stack.pop());
    }

    @Test
    public void afterPush_twoPeeksAreEqual() throws Exception {
        this.stack.push(5);
        assertEquals(this.stack.peek(), this.stack.peek());
    }
}
