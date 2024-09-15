import java.util.Scanner;

public class LCDNumber {

    public static void printLCD(String number, int width, int height) {
        StringBuilder top = new StringBuilder();
        StringBuilder middle = new StringBuilder();
        StringBuilder bottom = new StringBuilder();

        StringBuilder[] upperVertical = new StringBuilder[height];
        StringBuilder[] lowerVertical = new StringBuilder[height];

        for (int i = 0; i < height; i++) {
            upperVertical[i] = new StringBuilder();
            lowerVertical[i] = new StringBuilder();
        }

        for (char digit : number.toCharArray()) {
            int d = Character.getNumericValue(digit);

            // Append top row
            top.append((d == 1 || d == 4) ? " ".repeat(width + 2) : " " + "-".repeat(width) + " ").append(" ");

            // Append upper vertical segments
            for (int i = 0; i < height; i++) {
                upperVertical[i].append((d == 1 || d == 2 || d == 3 || d == 7) ? " ".repeat(width + 1) + "|"
                        : (d == 5 || d == 6) ? "|" + " ".repeat(width + 1) : "|" + " ".repeat(width) + "|").append(" ");
            }

            // Append middle row
            middle.append((d == 1 || d == 7 || d == 0) ? " ".repeat(width + 2) : " " + "-".repeat(width) + " ")
                    .append(" ");

            // Append lower vertical segments
            for (int i = 0; i < height; i++) {
                lowerVertical[i].append(
                        (d == 2) ? "|" + " ".repeat(width + 1)
                                : (d == 1 || d == 3 || d == 4 || d == 7) ? " ".repeat(width + 1) + "|"
                                        : (d == 5 || d == 9) ? " ".repeat(width + 1) + "|"
                                                : "|" + " ".repeat(width) + "|")
                        .append(" ");
            }

            // Append bottom row
            bottom.append((d == 1 || d == 4 || d == 7) ? " ".repeat(width + 2) : " " + "-".repeat(width) + " ")
                    .append(" ");
        }

        // Print the constructed rows
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

        // Input for height, width and number
        System.out.print("Enter height: ");
        int height = scanner.nextInt();

        System.out.print("Enter width: ");
        int width = scanner.nextInt();

        System.out.print("Enter number to display: ");
        String number = scanner.next();
        
        printLCD(number, width, height);
    }
}
