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
                new Flight("FL001", "35A"),
                new Flight("FL002", "36B"),
                new Flight("FL003", "35C"),
                new Flight("FL004", "36D"),
                new Flight("FL005", "31A"),
                new Flight("FL006", "32A"),
                new Flight("FL007", "31D"),
                new Flight("FL008", "34A"),
                new Flight("FL009", "37C"),
                new Flight("FL010", "31B"),
                new Flight("FL011", "32B"),
                new Flight("FL012", "33C"),
                new Flight("FL013", "34B"),
                new Flight("FL014", "35B"),
                new Flight("FL015", "31C"),
                new Flight("FL016", "32C"),
                new Flight("FL017", "35D"),
                new Flight("FL018", "32D"),
                new Flight("FL019", "36C"),
                new Flight("FL020", "34C")
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
