import java.util.Scanner;

class Flight {
    String flightNumber;
    int totalSeats;
    int availableSeats;

    public Flight(String flightNumber, int totalSeats) {
        this.flightNumber = flightNumber;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }
}

class ReservationSystem {
    Flight[] flights;

    public ReservationSystem() {
        // Initialize some flights
        flights = new Flight[]{
                flights = new Flight[]{
                new Flight("FL001", 35),
                new Flight("FL002", 36),
                new Flight("FL003", 35),
                new Flight("FL004", 36),
                new Flight("FL005", 31),
                new Flight("FL006", 32),
                new Flight("FL007", 31),
                new Flight("FL008", 34),
                new Flight("FL009", 37),
                new Flight("FL010", 31),
                new Flight("FL011", 32),
                new Flight("FL012", 33),
                new Flight("FL013", 34),
                new Flight("FL014", 35),
                new Flight("FL015", 31),
                new Flight("FL016", 32),
                new Flight("FL017", 35),
                new Flight("FL018", 32),
                new Flight("FL019", 36),
                new Flight("FL020", 34)
        };
    }


    public void displayFlights() {
        System.out.println("Available Flights:");
        for (Flight flight : flights) {
            System.out.println(flight.flightNumber + " - Available Seats: " + flight.availableSeats);
        }
        System.out.println();
    }

    public void bookSeat(String flightNumber, int numSeats) {
        for (Flight flight : flights) {
            if (flight.flightNumber.equals(flightNumber)) {
                if (flight.availableSeats >= numSeats) {
                    flight.availableSeats -= numSeats;
                    System.out.println("Booking successful!");
                    System.out.println("Remaining seats on " + flight.flightNumber + ": " + flight.availableSeats);
                } else {
                    System.out.println("Sorry, not enough seats available on " + flight.flightNumber);
                }
                return;
            }
        }
        System.out.println("Flight not found!");
    }
}

public class airline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReservationSystem reservationSystem = new ReservationSystem();

        while (true) {
            System.out.println("1. Display Flights");
            System.out.println("2. Book a Seat");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    reservationSystem.displayFlights();
                    break;
                case 2:
                    System.out.print("Enter the flight number: ");
                    String flightNumber = scanner.next();
                    System.out.print("Enter the number of seats to book: ");
                    int numSeats = scanner.nextInt();
                    reservationSystem.bookSeat(flightNumber, numSeats);
                    break;
                case 3:
                    System.out.println("Exiting the reservation system. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
