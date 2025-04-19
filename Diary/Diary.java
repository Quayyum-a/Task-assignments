import java.util.ArrayList;
import java.util.List;

public class Diary {
    private String username;
    private String password;
    private boolean isLocked = true;
    private List<Entry> entries = new ArrayList<>();

    public Diary(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void unlockDiary(String password) {
        if (this.password.equals(password)) {
            isLocked = false;
        }
    }

    public void lockDiary() {
        isLocked = true;
    }

    public boolean createEntry(int id, String title, String body) {
        if (isLocked) {
            return false;
        }
        // Check if ID already exists
        for (Entry entry : entries) {
            if (entry.getId() == id) {
                return false;
            }
        }
        Entry entry = new Entry(id, title, body);
        entries.add(entry);
        return true;
    }

    public List<Entry> getEntries() {
        if (isLocked) {
            return null;
        }
        return entries;
    }

    public boolean deleteEntry(int id) {
        if (isLocked) {
            return false;
        }
        for (int count = 0; count < entries.size(); count++) {
            if (entries.get(count).getId() == id) {
                entries.remove(count);
                return true;
            }
        }
        return false;
    }

    public Entry findEntryById(int id) {
        if (isLocked) {
            return null;
        }
        for (Entry entry : entries) {
            if (entry.getId() == id) {
                return entry;
            }
        }
        return null;
    }

    public boolean updateEntry(int id, String title, String body) {
        if (isLocked) {
            return false;
        }
        for (Entry entry : entries) {
            if (entry.getId() == id) {
                entry.setTitle(title);
                entry.setBody(body);
                return true;
            }
        }
        return false;
    }
}