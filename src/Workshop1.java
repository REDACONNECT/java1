
void main() {

    // Leximi i PIN-it
    System.out.print("PIN-i i ri (4 shifra): ");
    String pin = IO.readln().trim();

    // Kontrollimi i gjatesise
    if (pin.length() == 4) {

        // Kontrollimi i shenjave + dhe -
        if (pin.charAt(0) != '+' && pin.charAt(0) != '-') {

            // Konvertimi i PIN-it ne numer
            int pinNumber = Integer.parseInt(pin);

            // Kontrollimi i PIN-eve te dobeta
            if (pin.equals("1234") || pin.equals("0000")
                    || pin.equals("1111") || pin.equals("1212")) {

                System.out.println("I dobet: ky PIN provohet i pari.");

            } else {

                // Llogaritja e pikeve
                int points = 0;

                // Kontrollimi nese PIN-i duket si vit
                if (pinNumber < 1950 || pinNumber > 2026) {
                    points++;
                }

                // Kontrollimi i dy shifrave te para
                if (pin.charAt(0) != pin.charAt(1)) {
                    points++;
                }

                // Kontrollimi i dy shifrave te fundit
                if (pin.charAt(2) != pin.charAt(3)) {
                    points++;
                }

                // Percaktimi i nivelit me switch
                var level = switch (points) {
                    case 3 -> "I forte";
                    case 2 -> "Mesatar";
                    default -> "I dobet";
                };

                // Shfaqja e rezultatit me dy shifra pas presjes
                System.out.printf("%s: %.2f %%\n",
                        level, points * 100.0 / 3);

                // Vendimi perfundimtar me ternary
                String decision = points == 3
                        ? "PIN-i pranohet."
                        : "Zgjidhni PIN tjeter.";

                System.out.println(decision);
            }

        } else {
            System.out.println("PIN-i ka vetem shifra, pa + ose -.");
        }

    } else {
        System.out.println("PIN-i duhet te kete saktesisht 4 shifra.");
    }
}
