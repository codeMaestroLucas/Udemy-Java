package k_Exceptions.Exercises.Ex01.model.entities;

import k_Exceptions.Exercises.Ex01.model.exceptions.SpecialException;

import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

public class Reservation {

    protected Integer roomNumber;
    protected Date checkIn;
    protected Date checkOut;

    private static Date now = new Date();

    protected DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws SpecialException {

        if (checkIn.before(now) || checkOut.before(now)) {
            throw new SpecialException(
                    "Invalid dates: check-in must be after current date.");
        }

        if (!checkOut.after(checkIn)) {
            throw new SpecialException(
                    "Invalid dates: check-out must be after check-in.");
        }

        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getCheckIn() {
        return this.formatDate(this.checkIn);
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return this.formatDate(this.checkOut);
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    private Integer duration() {
        Duration d = Duration.between(this.checkIn.toInstant(),   // Start
                                      this.checkOut.toInstant()); // End
        return (int) d.toDays();
    }

    public void updateDates(Date newCheckIn, Date newCheckOut) throws SpecialException {

        if (newCheckIn.before(now) || newCheckOut.before(now)) {
            throw new SpecialException(
                    "Invalid dates: check-in must be after current date.");
        }

        if (!newCheckOut.after(newCheckIn)) {
            throw new SpecialException(
                    "Invalid dates: check-out must be after check-in.");
        }

        this.setCheckIn(newCheckIn);
        this.setCheckOut(newCheckOut);
    }

    @Override
    public String toString() {
        return String.format(
                "Reservation: %d, check-in: %s, check-out: %s, %d nights\n",
                this.getRoomNumber(),
                this.getCheckIn(),
                this.getCheckOut(),
                this.duration());
    }

    private String formatDate(Date date) {
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return fmt.format(localDate);
    }
}
