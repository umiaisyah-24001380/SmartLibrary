//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    // In the main menu handler, add validation:

// Validate ISBN is a number
    public static int safeReadISBN(Scanner sc) {
        while (true) {
            System.out.print("Enter ISBN (numbers only): ");
            if (sc.hasNextInt()) {
                int isbn = sc.nextInt();
                if (isbn > 0) return isbn;
                else System.out.println("ISBN must be positive!");
            } else {
                System.out.println("Invalid! ISBN must be a number.");
                sc.next(); // clear bad input
            }
        }
    }

// Validate title/author not empty
    public static String safeReadString(Scanner sc, String prompt) {
        String input = "";
        while (input.trim().isEmpty()) {
            System.out.print(prompt);
            input = sc.nextLine();
            if (input.trim().isEmpty()) {
                System.out.println("This field cannot be empty!");
            }
        }
        return input.trim();
    }
}
