package k_Exceptions.Exercises.Ex01.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import k_Exceptions.Exercises.Ex01.model.entities.Reservation;
import k_Exceptions.Exercises.Ex01.model.exceptions.SpecialException;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static Date now = new Date();


    public static Reservation registerReservation() throws SpecialException, ParseException {

        System.out.print("Room Number: ");
        Integer room = sc.nextInt();

        System.out.print("Check-in date (DD/MM/YYYY): ");
        Date checkIn = sdf.parse(sc.next());

        System.out.print("Check-out date (DD/MM/YYYY): ");
        Date checkOut = sdf.parse(sc.next());

        
        if (checkIn.before(now) || checkOut.before(now)) {
            throw new SpecialException(
                "Check-in and check-out dates must be in the future.");
        }

        if (!checkOut.after(checkIn)) {
            throw new SpecialException(
                "Check-out date must be after check-in date.");
        }

        return new Reservation(room, checkIn, checkOut);
    }


    public static void makeUpdateInReservation(Reservation reserv) throws SpecialException, ParseException{
        System.out.println("Updating CHECKIN & CHECKOUT");
        System.out.print("Check-in date (DD/MM/YYYY): ");
        Date newCheckIn = sdf.parse(sc.next());

        System.out.print("Check-out date (DD/MM/YYYY): ");
        Date newCheckOut = sdf.parse(sc.next());
        reserv.updateDates(newCheckIn, newCheckOut);
    }

    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        try {
            Reservation reserv = registerReservation();
            System.out.println(reserv);

            makeUpdateInReservation(reserv);
            System.out.println(reserv);
            
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter the date as DD/MM/YYYY.");

        } catch (SpecialException e) {
            System.out.println("\033[31mError\033[m\n" + e.getMessage());

        } catch (RuntimeException e) {
            System.out.println("\033[31mUnexpected Error\033[m\n" + e.getMessage());
        }


        sc.close();
    }
}
