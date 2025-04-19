import javax.swing.JOptionPane;

public class MainApplication {
    private static Diaries diaries = new Diaries();
    private static Diary currentDiary = null;

    public static void main(String[] args) {
        showWelcomeMessage();
        handleMainMenu();
    }

    private static void showWelcomeMessage() {
        JOptionPane.showMessageDialog(null,
                "Yo, welcome to your Sassy Student Notebook 📓\nTime to jot down the drama or homework. Let's roll!",
                "Student Notebook", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void handleMainMenu() {
        while (true) {
            String choice = getInput("Main Menu:\n1. Create new diary\n2. Select diary\n3. Check diary mood\n4. Exit\nEnter choice:");

            if (shouldExit(choice)) {
                showExitMessage();
                break;
            }

            if (isValidChoice(choice)) {
                showInvalidInputMessage();
                continue;
            }

            switch (Integer.parseInt(choice.trim())) {
                case 1 -> createNewDiary();
                case 2 -> selectDiary();
                case 3 -> checkDiaryMood();
                default -> showInvalidChoiceMessage();
            }
        }
    }

    private static void createNewDiary() {
        String username = getInput("Gimme a diary name, don't be lame:");
        if (isInvalidInput(username)) {
            showNoNameMessage();
            return;
        }

        String password = getInput("Set a password, make it good:");
        if (isInvalidInput(password)) {
            showNoPasswordMessage();
            return;
        }

        diaries.add(username.trim(), password.trim());
        showSuccessMessage("Diary '" + username.trim() + "' created. Nice one!");
    }

    private static void selectDiary() {
        String username = getInput("Diary name, what's it called?:");
        if (isInvalidInput(username)) {
            showLostMessage();
            return;
        }

        currentDiary = diaries.findByUsername(username.trim());
        if (currentDiary == null) {
            showDiaryNotFoundMessage(username);
            return;
        }

        String password = getInput("Password for '" + username.trim() + "':");
        if (isInvalidInput(password)) {
            showNoPasswordMessage();
            return;
        }

        currentDiary.unlockDiary(password.trim());
        if (currentDiary.isLocked()) {
            showWrongPasswordMessage();
            return;
        }

        showSuccessMessage("Diary '" + username.trim() + "' unlocked. Let's do this!");
        manageDiary(currentDiary);
    }

    private static void checkDiaryMood() {
        if (currentDiary == null || currentDiary.isLocked()) {
            showNoDiaryMessage();
            return;
        }

        int entryCount = currentDiary.getEntries().size();
        String mood = getMoodMessage(entryCount);
        showMessage("Diary Mood: " + mood, "Diary Mood");
    }

    private static void manageDiary(Diary diary) {
        while (true) {
            String choice = getInput("Diary '" + diary.getUsername() + "' Menu:\n1. Add entry\n2. View entry\n3. Update entry\n4. Delete entry\n5. Lock diary\n6. Back\nEnter choice:");

            if (shouldGoBack(choice)) {
                return;
            }

            if (isValidChoice(choice)) {
                showInvalidInputMessage();
                continue;
            }

            switch (Integer.parseInt(choice.trim())) {
                case 1 -> addEntry(diary);
                case 2 -> viewEntry(diary);
                case 3 -> updateEntry(diary);
                case 4 -> deleteEntry(diary);
                case 5 -> lockDiary(diary);
                default -> showInvalidChoiceMessage();
            }
        }
    }

    private static void addEntry(Diary diary) {
        int id = getValidId("Entry ID (positive number):");
        if (id <= 0) return;

        String title = getInput("Entry title, make it pop:");
        if (isInvalidInput(title)) {
            showNoTitleMessage();
            return;
        }

        String body = getInput("What's the tea? Write it:");
        if (isInvalidInput(body)) {
            showEmptyEntryMessage();
            return;
        }

        if (diary.createEntry(id, title.trim(), body.trim())) {
            showSuccessMessage("Entry '" + title.trim() + "' added. You're on fire!");
        } else {
            showErrorMessage("Entry failed. ID might be taken or diary's locked!");
        }
    }

    private static void viewEntry(Diary diary) {
        int id = getValidId("Entry ID to view:");
        if (id <= 0) return;

        Entry entry = diary.findEntryById(id);
        if (entry == null) {
            showEntryNotFoundMessage(id);
            return;
        }

        showMessage("Title: " + entry.getTitle() + "\nDate: " + entry.getDateCreated() + "\n\n" + entry.getBody(), "Entry Details");
    }

    private static void updateEntry(Diary diary) {
        int id = getValidId("Entry ID to update:");
        if (id <= 0) return;

        Entry entry = diary.findEntryById(id);
        if (entry == null) {
            showEntryNotFoundMessage(id);
            return;
        }

        String newTitle = getInput("New title for '" + entry.getTitle() + "':");
        if (isInvalidInput(newTitle)) {
            showNoTitleMessage();
            return;
        }

        String newBody = getInput("New content for '" + entry.getTitle() + "':");
        if (isInvalidInput(newBody)) {
            showEmptyEntryMessage();
            return;
        }

        if (diary.updateEntry(id, newTitle.trim(), newBody.trim())) {
            showSuccessMessage("Entry ID '" + id + "' updated. Solid move!");
        } else {
            showErrorMessage("Update failed. Diary might be locked!");
        }
    }

    private static void deleteEntry(Diary diary) {
        int id = getValidId("Entry ID to delete:");
        if (id <= 0) return;

        if (diary.deleteEntry(id)) {
            showSuccessMessage("Entry ID '" + id + "' deleted. Poof, gone!");
        } else {
            showEntryNotFoundMessage(id);
        }
    }

    private static void lockDiary(Diary diary) {
        diary.lockDiary();
        showSuccessMessage("Diary '" + diary.getUsername() + "' locked. Safe and sound!");
    }

    private static String getInput(String message) {
        return JOptionPane.showInputDialog(null, message, "Student Notebook", JOptionPane.QUESTION_MESSAGE);
    }

    private static void showMessage(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    private static void showSuccessMessage(String message) {
        showMessage(message, "Success");
    }

    private static void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private static boolean shouldExit(String choice) {
        return choice == null || choice.trim().equals("4");
    }

    private static boolean shouldGoBack(String choice) {
        return choice == null || choice.trim().equals("6");
    }

    private static boolean isValidChoice(String choice) {
        return choice.trim().isEmpty() || !choice.matches("\\d+");
    }

    private static boolean isInvalidInput(String input) {
        return input == null || input.trim().isEmpty();
    }

    private static int getValidId(String prompt) {
        String idStr = getInput(prompt);
        try {
            int id = Integer.parseInt(idStr);
            if (id <= 0) {
                showInvalidIdMessage();
                return -1;
            }
            return id;
        } catch (NumberFormatException e) {
            showNotANumberMessage();
            return -1;
        }
    }

    private static String getMoodMessage(int entryCount) {
        if (entryCount == 0) {
            return "LONELY - This diary's empty. Write something, slacker!";
        } else if (entryCount <= 3) {
            return "CURIOUS - A few entries. Got more to say?";
        }
        return "HAPPY - Diary's thriving, you're killing it!";
    }

    private static void showExitMessage() {
        showMessage("Catch ya later, notebook's chilling!", "Student Notebook");
    }

    private static void showInvalidInputMessage() {
        showErrorMessage("Bruh, pick a number, not whatever that was!");
    }

    private static void showInvalidChoiceMessage() {
        showErrorMessage("Invalid choice. Numbers 1-4, c'mon!");
    }

    private static void showNoNameMessage() {
        showErrorMessage("No name? You serious? Try again.");
    }

    private static void showNoPasswordMessage() {
        showErrorMessage("No password? Anyone could read this!");
    }

    private static void showLostMessage() {
        showErrorMessage("No name? You lost already?");
    }

    private static void showDiaryNotFoundMessage(String username) {
        showErrorMessage("Diary '" + username.trim() + "' doesn't exist, dude.");
    }

    private static void showWrongPasswordMessage() {
        showErrorMessage("Wrong password. You locked out, fam!");
    }

    private static void showNoDiaryMessage() {
        showErrorMessage("No diary open or it's locked. Unlock one first!");
    }

    private static void showNoTitleMessage() {
        showErrorMessage("No title? You're killing me!");
    }

    private static void showEmptyEntryMessage() {
        showErrorMessage("Empty entry? Nah, do better.");
    }

    private static void showEntryNotFoundMessage(int id) {
        showErrorMessage("Entry ID '" + id + "' not found. You good?");
    }

    private static void showInvalidIdMessage() {
        showErrorMessage("ID gotta be positive, fam!");
    }

    private static void showNotANumberMessage() {
        showErrorMessage("That's not a number, dude!");
    }
}