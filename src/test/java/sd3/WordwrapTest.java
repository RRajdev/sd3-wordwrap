package sd3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static sd3.Wordwrap.wrap;

public class WordwrapTest {

    @Test
    public void wrapsTextAtSpecifiedLength(){
        String input = "aaaaaaaaaa aaaaaaaaaa";

        String output = wrap(input, 10);

        String expectedOutput = "aaaaaaaaaa" + System.lineSeparator() + "aaaaaaaaaa";
        assertEquals(output, expectedOutput);
    }

    @Test
    public void wrapsTextWithoutSplittingWordWhenWordsAreShorterThanLinelength(){
        String input = "An owl and a pussycat";

        String output = wrap(input, 15);

        String expectedOutput = "An owl and a" + System.lineSeparator() + "pussycat";
        assertEquals(output, expectedOutput);
    }

    @Test
    public void wrapsTextSplittingWordWhenWordIsLongerThanLineLength(){
        String input = "aaabbb cc dd";

        String output = wrap(input, 3);

        String expectedOutput = "aaa" + System.lineSeparator() + "bbb"  + System.lineSeparator() + "cc"  + System.lineSeparator() + "dd";
        assertEquals(output, expectedOutput);
    }

    @Test
    public void wrapsTextSplittingWordsWhenWordsAreLongerThanLineLength(){
        String input = "aaabbb cccddd";

        String output = wrap(input, 3);

        String expectedOutput = "aaa" + System.lineSeparator() + "bbb"  + System.lineSeparator() + "ccc"  + System.lineSeparator() + "ddd";
        assertEquals(output, expectedOutput);
    }

    @Test
    public void wrapsTextWhenLineLengthIs40Characters(){
        String input = "By browsing this site you accept cookies used to improve and personalise our services and marketing, and for social activity. Read our privacy policy for more about what we do with your data, as well as your rights and choices – including how to manage cookies.";
        String output = wrap(input, 80);

        String expectedOutput = "By browsing this site you accept cookies used to improve and personalise our" + System.lineSeparator() +
                "services and marketing, and for social activity. Read our privacy policy for" + System.lineSeparator() +
                "more about what we do with your data, as well as your rights and choices –" + System.lineSeparator() +
                "including how to manage cookies.";
        assertEquals(output, expectedOutput);
    }

    @Test
    public void returnsIfStringHasWhitespace(){
        String input = "  ";
        String output = wrap(input, 15);

        String expectedOutput = "";
        assertEquals(output, expectedOutput);
    }

    @Test
    public void returnsIfStringIsNull(){
        String input = null;
        String output = wrap(input, 15);

        String expectedOutput = "";
        assertEquals(output, expectedOutput);
    }

    @Test
    public void returnsIfStringNullOrEmpty(){
        String input = "";
        String output = wrap(input, 15);

        String expectedOutput = "";
        assertEquals(output, expectedOutput);
    }
}
