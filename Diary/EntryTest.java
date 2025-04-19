import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class EntryTest {
    @Test
    public void create_NewEntry_WithDate() {
        Entry entry = new Entry(1, "hair", "body");
        assertEquals(1, entry.getId());
        assertEquals("hair", entry.getTitle());
        assertEquals("body", entry.getBody());
        assertTrue(entry.getDateCreated().isBefore(LocalDateTime.now().plusSeconds(1)));
        assertTrue(entry.getDateCreated().isAfter(LocalDateTime.now().minusSeconds(1)));
    }

    @Test
    public void create_Entry_WithEmptyTitle() {
        Entry entry = new Entry(2, "", "body");
        assertEquals(2, entry.getId());
        assertEquals("Title cannot be empty", entry.getTitle());
        assertEquals("body", entry.getBody());
        assertNotNull(entry.getDateCreated());
    }

    @Test
    public void create_Entry_WithEmptyBody() {
        Entry entry = new Entry(3, "title", "");
        assertEquals(3, entry.getId());
        assertEquals("title", entry.getTitle());
        assertEquals("Body cannot be empty", entry.getBody());
        assertNotNull(entry.getDateCreated());
    }

    @Test
    public void create_Entry_WithInvalidId() {
        Entry entry = new Entry(-1, "title", "body");
        assertEquals(-1, entry.getId());
        assertEquals("title", entry.getTitle());
        assertEquals("body", entry.getBody());
    }

    @Test
    public void setTitle_WithEmptyValue() {
        Entry entry = new Entry(1, "title", "body");
        assertFalse(entry.setTitle(""));
        assertEquals("title", entry.getTitle());
    }

    @Test
    public void setBody_WithEmptyValue() {
        Entry entry = new Entry(1, "title", "body");
        assertFalse(entry.setBody(""));
        assertEquals("body", entry.getBody());
    }
}