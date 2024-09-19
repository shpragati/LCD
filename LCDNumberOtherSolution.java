import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LCDChar {

    private static final Map<Character, int[]> charPatterns = new HashMap<>();

    static {

        // [Top, Top-left, Top-right, Middle, Bottom-left, Bottom-right, Bottom]
        charPatterns.put('0', new int[] { 1, 1, 1, 0, 1, 1, 1 });
        charPatterns.put('1', new int[] { 0, 0, 1, 0, 0, 1, 0 });
        charPatterns.put('2', new int[] { 1, 0, 1, 1, 1, 0, 1 });
        charPatterns.put('3', new int[] { 1, 0, 1, 1, 0, 1, 1 });
        charPatterns.put('4', new int[] { 0, 1, 1, 1, 0, 1, 0 });
        charPatterns.put('5', new int[] { 1, 1, 0, 1, 0, 1, 1 });
        charPatterns.put('6', new int[] { 1, 1, 0, 1, 1, 1, 1 });
        charPatterns.put('7', new int[] { 1, 0, 1, 0, 0, 1, 0 });
        charPatterns.put('8', new int[] { 1, 1, 1, 1, 1, 1, 1 });
        charPatterns.put('9', new int[] { 1, 1, 1, 1, 0, 1, 1 });

    }

    public static void printLCD(String input, int width, int height) {
        String space = " ";
        String hirizontalLine = "-";
        String verticalLine = "|";

        StringBuilder top = new StringBuilder();
        StringBuilder middle = new StringBuilder();
        StringBuilder bottom = new StringBuilder();

        StringBuilder[] upperVertical = new StringBuilder[height];
        StringBuilder[] lowerVertical = new StringBuilder[height];

        for (int i = 0; i < height; i++) {
            upperVertical[i] = new StringBuilder();
            lowerVertical[i] = new StringBuilder();
        }

        for (char character : input.toUpperCase().toCharArray()) {
            int[] segments = charPatterns.getOrDefault(character, new int[] { 0, 0, 0, 0, 0, 0, 0 }); // Default for unknown chars

            // Append top row
            top.append(segments[0] == 1 ? space + hirizontalLine.repeat(width) + space : space.repeat(width + 2))
                    .append(space);

            // Append upper vertical segments
            for (int i = 0; i < height; i++) {
                upperVertical[i].append((segments[1] == 1 ? verticalLine : space) + space.repeat(width)
                        + (segments[2] == 1 ? verticalLine : space)).append(space);
            }

            // Append middle row
            middle.append(segments[3] == 1 ? space + hirizontalLine.repeat(width) + space : space.repeat(width + 2))
                    .append(space);

            // Append lower vertical segments
            for (int i = 0; i < height; i++) {
                lowerVertical[i].append((segments[4] == 1 ? verticalLine : space) + space.repeat(width)
                        + (segments[5] == 1 ? verticalLine : space)).append(space);
            }

            // Append bottom row
            bottom.append(segments[6] == 1 ? space + hirizontalLine.repeat(width) + space : space.repeat(width + 2))
                    .append(space);

        }

        System.out.println(top.toString());
        for (StringBuilder row : upperVertical)
            System.out.println(row.toString());

        System.out.println(middle.toString());

        for (StringBuilder row : lowerVertical)
            System.out.println(row.toString());

        System.out.println(bottom.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for height, width and characters
        System.out.print("Enter height: ");
        int height = scanner.nextInt();

        System.out.print("Enter width: ");
        int width = scanner.nextInt();

        System.out.print("Enter string to display: ");
        String input = scanner.next();

        printLCD(input, width, height);
    }
}
