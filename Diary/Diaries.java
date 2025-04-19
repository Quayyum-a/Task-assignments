import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Diaries {
    private List<Diary> diaries = new ArrayList<>();

    public void add(String username, String password) {
        Diary diary = new Diary(username, password);
        diaries.add(diary);
    }


    public Collection<Diary> getDiaries() {
        return new ArrayList<>(diaries);
    }

    public Diary findByUsername(String username) {
        for (Diary diary : diaries) {
            if (diary.getUsername().equals(username)) {
                return diary;
            }
        }
        return null;
    }

    public void delete(String username) {
        for (int count = 0; count < diaries.size(); count++) {
            if (diaries.get(count).getUsername().equals(username)) {
                diaries.remove(count);
                break;
            }
        }
    }
}