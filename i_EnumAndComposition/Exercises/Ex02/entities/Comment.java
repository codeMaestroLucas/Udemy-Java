
package i_EnumAndComposition.Exercises.Ex02.entities;


public class Comment {

    private String text;

    public Comment(String text) {
        this.text = text.trim();
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return this.getText();
    }

}
