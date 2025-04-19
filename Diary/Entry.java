import java.time.LocalDateTime;

public class Entry {
    private int id;
    private String title;
    private String body;
    private LocalDateTime dateCreated;

    public Entry(int id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.dateCreated = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        if (title == null || title.trim().isEmpty()) {
            return "Title cannot be empty";
        }
        return title;
    }

    public String getBody() {
        if (body == null || body.trim().isEmpty()) {
            return "Body cannot be empty";
        }
        return body;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public boolean setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            return false;
        }
        this.title = title;
        return true;
    }

    public boolean setBody(String body) {
        if (body == null || body.trim().isEmpty()) {
            return false;
        }
        this.body = body;
        return true;
    }
}