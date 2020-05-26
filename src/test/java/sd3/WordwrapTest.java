package sd3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class WordwrapTest {

    @Test
    public void wrapsTextAtSpecifiedLength(){
        String input = "aaaaaaaaaa aaaaaaaaaa";
        Wordwrap wordwrap = new Wordwrap(input, 10);

        String output = wordwrap.wrap();

        String expectedOutput = "aaaaaaaaaa" + System.lineSeparator() + "aaaaaaaaaa";
        assertEquals(output, expectedOutput);
    }

    @Test
    public void wrapsTextWithoutSplittingWordWhenWordsAreShorterThanLinelength(){
        String input = "An owl and a pussycat";
        Wordwrap wordwrap = new Wordwrap(input, 15);

        String output = wordwrap.wrap();

        String expectedOutput = "An owl and a" + System.lineSeparator() + "pussycat";
        assertEquals(output, expectedOutput);
    }

    @Test
    public void wrapsTextSplittingWordWhenWordIsLongerThanLineLength(){
        String input = "aaabbb cc dd";
        Wordwrap wordwrap = new Wordwrap(input, 3);

        String output = wordwrap.wrap();

        String expectedOutput = "aaa" + System.lineSeparator() + "bbb"  + System.lineSeparator() + "cc"  + System.lineSeparator() + "dd";
        assertEquals(output, expectedOutput);
    }

    @Test
    public void wrapsTextSplittingMultipleWordsWhenWordsAreLongerThanLineLength(){
        String input = "aaabbb cccddd";
        Wordwrap wordwrap = new Wordwrap(input, 3);

        String output = wordwrap.wrap();

        String expectedOutput = "aaa" + System.lineSeparator() + "bbb"  + System.lineSeparator() + "ccc"  + System.lineSeparator() + "ddd";
        assertEquals(output, expectedOutput);
    }

    @Test
    public void wrapsTextWhenLineLengthIs40Characters(){
        String input = "By browsing this site you accept cookies used to improve and personalise our services and marketing, and for social activity. Read our privacy policy for more about what we do with your data, as well as your rights and choices – including how to manage cookies.";
        Wordwrap wordwrap = new Wordwrap(input, 80);

        String output = wordwrap.wrap();

        String expectedOutput = "By browsing this site you accept cookies used to improve and personalise our" + System.lineSeparator() +
                "services and marketing, and for social activity. Read our privacy policy for" + System.lineSeparator() +
                "more about what we do with your data, as well as your rights and choices –" + System.lineSeparator() +
                "including how to manage cookies.";
        assertEquals(output, expectedOutput);
    }

    @Test
    public void returnsIfStringHasWhitespace(){
        String input = "  ";
        Wordwrap wordwrap = new Wordwrap(input, 15);

        String output = wordwrap.wrap();

        String expectedOutput = "";
        assertEquals(output, expectedOutput);
    }

    @Test
    public void returnsIfStringIsNull(){
        String input = null;
        Wordwrap wordwrap = new Wordwrap(input, 15);

        String output = wordwrap.wrap();

        String expectedOutput = "";
        assertEquals(output, expectedOutput);
    }

    @Test
    public void returnsIfStringNullOrEmpty(){
        String input = "";
        Wordwrap wordwrap = new Wordwrap(input, 15);

        String output = wordwrap.wrap();

        String expectedOutput = "";
        assertEquals(output, expectedOutput);
    }
}
