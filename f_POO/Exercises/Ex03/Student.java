package Exercises.Ex03;

public class Student {

    private String name;
    private double grade1;
    private double grade2;
    private double grade3;

    public Student(String name, double grade1, double grade2, double grade3) {
        this.name = name;
        this.grade1 = grade1 * 0.30; // 30%
        this.grade2 = grade2 * 0.35; // 35%
        this.grade3 = grade3 * 0.35;
    }

    private double getFinalGrade() {
        return this.grade1 + this.grade2 + this.grade3;
    }

    @Override
    public String toString() {
        double fg = getFinalGrade();
        String formatedString = String.format(
                "%s RESULTS:\nFINAL GRADE: %.2f\n",
                this.name.toUpperCase(), fg);

        if (fg < 60) {
            formatedString = formatedString.concat(
                    String.format("%s\n\033[31mFAILED\nMISSING %.2f POINTS\033[m",
                            "=".repeat(30), 60 - fg));

        } else {
            formatedString = formatedString.concat(
                    String.format("%s\n\033[32mPASSED\033[m\n",
                            "=".repeat(30)));
        }

        return formatedString;

    }

}
