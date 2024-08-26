package i_EnumAndComposition.Exercises.Ex02.entities;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Post {

    private Instant moment;
    private String title;
    private String content;
    private Integer likes;

    private ArrayList<Comment> comments = new ArrayList<>();

    public Post(String title, String content) {
        this.moment = Instant.now();
        this.title = title;
        this.content = content;
        this.likes = 0;
    }

    public void addComment(String textOfComment) {
        this.comments.add(new Comment(textOfComment));
    }

    public void likePost() {
        this.likes++;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss XXX");

        // Convert Instant to ZonedDateTime using the system's default timezone
        ZonedDateTime zonedDateTime = this.moment.atZone(ZoneId.systemDefault());
        String formattedDate = zonedDateTime.format(fmt);

        String stringo = STR."""
        \{this.title.toUpperCase()}
        \{this.likes} Likes - \{formattedDate}
        \{this.content}
        Comments:

        """;

        sb.append(stringo);

        if (this.comments.isEmpty()) {
            sb.append("No comments yet.\n");
        } else {
            for (Comment comment : this.comments) {
                sb.append(comment).append("\n");
            }
        }

        return sb.toString();
    }

}
