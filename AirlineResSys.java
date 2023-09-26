import java.util.*;

public class AirlineResSys {
    private static final int nos = 100;
    private static boolean[] seats = new boolean[nos];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Show number of available seats");
            System.out.println("2. Book a seat");
            System.out.println("3. Cancel a booked seat");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    showAvailableSeats();
                    break;
                case 2:
                    book();
                    break;
                case 3:
                    cancel();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    private static void showAvailableSeats() {
        int AvailableSeats = 0;
        for (boolean seat : seats) {
            if (!seat) {
                AvailableSeats++;
            }
        }
        System.out.println("Number of available seats: " + AvailableSeats);
    }

    private static void book() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the seat number you want to book (1-10): ");
        int SeatNumber = sc.nextInt();

        if (SeatNumber < 1 || SeatNumber > 10) {
            System.out.println("Invalid seat number");
            return;
        }

        if (seats[SeatNumber - 1]) {
            System.out.println("Seat already booked");
        } else {
            seats[SeatNumber - 1] = true;
            System.out.println("Seat booked successfully");
        }
    }

    private static void cancel() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the seat number you want to cancel (1-10): ");
        int SeatNumber = sc.nextInt();

        if (SeatNumber < 1 || SeatNumber > 10) {
            System.out.println("Invalid seat number");
            return;
        }

        if (!seats[SeatNumber - 1]) {
            System.out.println("Seat not booked");
        } else {
            seats[SeatNumber - 1] = false;
            System.out.println("Booking cancelled successfully");
        }
    }
}