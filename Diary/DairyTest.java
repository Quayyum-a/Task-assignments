import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DairyTest {
    @Test
    public void create_Diary_WithInitialValues() {
        Diary diary = new Diary("username", "password");
        assertEquals("username", diary.getUsername());
        assertTrue(diary.isLocked());
    }

    @Test
    public void unlockDiary_WithValidPassword() {
        Diary diary = new Diary("username", "password");
        assertTrue(diary.isLocked());
        diary.unlockDiary("password");
        assertFalse(diary.isLocked());
    }

    @Test
    public void unlockDiary_WithInvalidPassword() {
        Diary diary = new Diary("username", "password");
        assertTrue(diary.isLocked());
        diary.unlockDiary("wrong password");
        assertTrue(diary.isLocked());
    }

    @Test
    public void lockDiary() {
        Diary diary = new Diary("username", "password");
        assertTrue(diary.isLocked());
        diary.unlockDiary("password");
        assertFalse(diary.isLocked());
        diary.lockDiary();
        assertTrue(diary.isLocked());
    }

    @Test
    public void createEntry_WithValidValues() {
        Diary diary = new Diary("username", "password");
        diary.unlockDiary("password");
        diary.createEntry(1, "My First Entry", "This is the content of my first entry.");
        assertEquals(1, diary.getEntries().size());
        assertEquals("My First Entry", diary.getEntries().getFirst().getTitle());

    }

    @Test
    public void deleteEntry_WithValidId() {
        Diary diary = new Diary("username", "password");
        diary.unlockDiary("password");
        diary.createEntry(1, "My First Entry", "This is the content of my first entry.");
        diary.createEntry(2, "My Second Entry", "This is the content of my second entry.");
        assertEquals(2, diary.getEntries().size());
        diary.deleteEntry(1);
        assertEquals(1, diary.getEntries().size());
        assertEquals("My Second Entry", diary.getEntries().getFirst().getTitle());
    }

    @Test
    public void deleteEntry_WhenLocked() {
        Diary diary = new Diary("username", "password");
        diary.unlockDiary("password");
        diary.createEntry(1, "My First Entry", "This is the content of my first entry.");
        diary.lockDiary();
        diary.deleteEntry(1);
        diary.unlockDiary("password");
        assertEquals(1, diary.getEntries().size());
    }

    @Test
    public void findEntry_WithValidId() {
        Diary diary = new Diary("username", "password");
        diary.unlockDiary("password");
        diary.createEntry(1, "My First Entry", "This is the content of my first entry.");
        diary.createEntry(2, "My Second Entry", "This is the content of my second entry.");
        Entry foundEntry = diary.findEntryById(1);
        assertEquals("My First Entry", foundEntry.getTitle());
    }


    @Test
    public void updateEntry() {
        Diary diary = new Diary("username", "password");
        diary.unlockDiary("password");
        diary.createEntry(1, "My First Entry", "This is the content of my first entry.");
        diary.createEntry(2, "My Second Entry", "This is the content of my second entry.");
        assertTrue(diary.updateEntry(1, "Updated Title", "Updated content."));
        assertEquals("Updated Title", diary.getEntries().get(0).getTitle());
        assertEquals("Updated content.", diary.getEntries().get(0).getBody());
    }

    @Test
    public void updateEntry_WhenLocked() {
        Diary diary = new Diary("username", "password");
        diary.unlockDiary("password");
        diary.createEntry(1, "My First Entry", "This is the content of my first entry.");
        diary.lockDiary();
        assertFalse(diary.updateEntry(1, "Updated Title", "Updated content."));
        diary.unlockDiary("password");
        assertEquals("My First Entry", diary.getEntries().get(0).getTitle());
    }
}