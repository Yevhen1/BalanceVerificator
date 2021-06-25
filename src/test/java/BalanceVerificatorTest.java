import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BalanceVerificatorTest {

    private BalanceVerificator balanceVerificator;

    @Before
    public void initTest() {
        balanceVerificator = new BalanceVerificator();
    }

    @Test
    public void bracketsBalanceBalanced1() {
        assertEquals(-1,balanceVerificator.bracketsBalance("([{([{}])}])"));
    }

    @Test
        public void bracketsBalanceBalanced2() {
            assertEquals(-1,balanceVerificator.bracketsBalance("(([])()[{}])"));
        }

    @Test
        public void bracketsBalanceBalanced3() {
            assertEquals(-1,balanceVerificator.bracketsBalance("(()())[[][]]{{}{}}"));
        }

    @Test
        public void bracketsBalanceNotBalanced1() {
            assertEquals(5,balanceVerificator.bracketsBalance("(([{)}]))"));
        }

    @Test
    public void bracketsBalanceNotBalanced2() {
        assertEquals(8,balanceVerificator.bracketsBalance("(([{}])])"));
    }

    @Test(expected = IllegalArgumentException.class)
        public void bracketsBalanceNotBracket() {
            assertEquals(-1,balanceVerificator.bracketsBalance("([R{}])"));
        }
}