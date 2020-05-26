package sd3;

public class Wordwrap {
    private String input;
    private int lengthOfWrappedLine;
    private String delimiter = " ";
    private int beginningOfLineIndex;
    private int endOfLineIndex;
    private String nextLine = "";
    private String wrappedText = "";


    public Wordwrap(String input, int lengthOfWrappedLine) {
        this.input = input;
        this.lengthOfWrappedLine = lengthOfWrappedLine;
        this.endOfLineIndex = lengthOfWrappedLine;
        this.beginningOfLineIndex = 0;
    }

    public  String wrap(){
        final String EMPTY_STRING = "";
        if (input == null || input.isEmpty()) return EMPTY_STRING;

        if (lengthOfWrappedLine <= 0 ) {
            throw new IllegalArgumentException("Please specify a line length that is longer than 0 chars");
        }

        while(hasUnparsedContent()) {
            ignoreLeadingSpace();
            nextLine = parseNextLine();
            if (isEndOfText()) {
                writeLine();
                break;
            }
            wrapNextLine();
        }

        return wrappedText.trim();
    }

    private void wrapNextLine() {
        if (hasSplitWord())
            writeLineAddingSeparatorBeforeSplitWord();
        else
            writeLine();
    }

    private boolean hasUnparsedContent() {
        return endOfLineIndex <= input.length();
    }

    private void ignoreLeadingSpace() {
        if (parseNextLine().startsWith(delimiter))
            resetPosition(1);
    }

    private String parseNextLine() {
        return input.substring(beginningOfLineIndex, endOfLineIndex);
    }

    private boolean isEndOfText() {
        return endOfLineIndex == input.length();
    }

    private boolean hasSplitWord() {
        return nextLine.contains(delimiter);
    }

    private void writeLineAddingSeparatorBeforeSplitWord() {
        int lengthOfWrappedLineToDelimiter = nextLine.lastIndexOf(delimiter);
        writeLineToBuffer(nextLine.substring(0, lengthOfWrappedLineToDelimiter).trim());
        resetPosition(lengthOfWrappedLineToDelimiter);
    }

    private void writeLine() {
        writeLineToBuffer(nextLine.trim());
        resetPosition(lengthOfWrappedLine);
    }

    private void resetPosition(int length) {
        beginningOfLineIndex += length;
        endOfLineIndex = Math.min(endOfLineIndex + length, input.length());
    }

    private  void writeLineToBuffer(String newLine){
        wrappedText += newLine + System.lineSeparator();
    }
}