package sd3;

public class Wordwrap {

    public static String wrap(String input, int lineLength){
        final String EMPTY_STRING = "";
        String delimiter = " ";
        int lengthOfWrappedLine = 0;
        int begIndex = 0;
        int endIndex = lineLength;
        StringBuilder wrappedText = new StringBuilder();

        if (input == null || input.isEmpty()) return EMPTY_STRING;

        while(endIndex <= input.length()) {

            String newLine = input.substring(begIndex, endIndex);
            if (newLine.startsWith(delimiter)){
                begIndex ++;
                endIndex = Math.min(endIndex + 1, input.length());
                newLine = input.substring(begIndex, endIndex);
            }

            if (endIndex != input.length()) {
                if (newLine.contains(delimiter)) {
                    lengthOfWrappedLine = newLine.lastIndexOf(delimiter);
                    wrappedText = addLine(wrappedText, newLine.substring(0, lengthOfWrappedLine).trim());

                    begIndex += lengthOfWrappedLine;
                    endIndex = Math.min(endIndex + lengthOfWrappedLine, input.length());
                }
                else {
                    wrappedText = addLine(wrappedText, newLine);
                    begIndex += lineLength;
                    endIndex = Math.min(endIndex + lineLength, input.length());
                }
            }
            else {
                wrappedText = addLine(wrappedText, newLine.trim());
                endIndex++;
            }

        }
        return wrappedText.toString().trim();
    }

    private static StringBuilder addLine(StringBuilder wrappedText, String newLine){
         wrappedText.append(newLine);
         wrappedText.append(System.lineSeparator());
         return wrappedText;
    }
}
