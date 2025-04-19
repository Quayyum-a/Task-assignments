import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiariesTest {
    @Test
    public void addDiary_ToDiariesList() {
        Diaries diaries = new Diaries();
        diaries.add("username", "password");
        diaries.add("username2", "password2");
        assertEquals(2, diaries.getDiaries().size());
        }

        @Test
        public void findByUsername() {
            Diaries diaries = new Diaries();
            diaries.add("username", "password");
            diaries.add("username2", "password2");
            Diary foundDiary = diaries.findByUsername("username");
            assertEquals("username", foundDiary.getUsername());
        }

        @Test
        public void deleteDiary() {
            Diaries diaries = new Diaries();
            diaries.add("username", "password");
            diaries.add("username2", "password2");
            diaries.delete("username");
            assertEquals(1, diaries.getDiaries().size());
        }

        @Test
            public void findByUsername_ReturnsNull_WhenUsernameNotFound() {
                Diaries diaries = new Diaries();
                diaries.add("username", "password");
                Diary foundDiary = diaries.findByUsername("nonexistent");
                assertEquals(null, foundDiary);
            }

            @Test
            public void deleteDiary_DoesNothing_WhenUsernameNotFound() {
                Diaries diaries = new Diaries();
                diaries.add("username", "password");
                diaries.add("username2", "password2");
                diaries.delete("nonexistent");
                assertEquals(2, diaries.getDiaries().size());
            }
        }

