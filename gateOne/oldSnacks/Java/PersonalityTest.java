import java.util.Scanner;

public class PersonalityTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your full name: ");
        String fullName = scanner.nextLine();
        System.out.println("Hello " + fullName + "! Welcome to the MBTI Personality Test. Please take your time and choose the option that best describes you. ");

        char[] answers = new char[20];
        String[] questions = {
            "A. Tough-minded, just   B. Tender-hearted, merciful",
            "A. Candid, straightforward, frank   B. Tactful, kind, encouraging",
            "A. Logical, analytical   B. Emotional, empathetic",
            "A. Decisive, goal-oriented   B. Open-ended, flexible",
            "A. Reserved, introverted   B. Outgoing, extroverted",
            "A. Structured, organized   B. Spontaneous, carefree",
            "A. Realistic, practical   B. Imaginative, creative",
            "A. Focused on details   B. Big-picture thinker",
            "A. Independent, self-reliant   B. Team-oriented, cooperative",
            "A. Calm, level-headed   B. Passionate, energetic",
            "A. Fact-based, factual   B. Possibility-based, speculative",
            "A. Task-focused   B. People-focused",
            "A. Confident, assertive   B. Agreeable, accommodating",
            "A. Like to plan ahead   B. Prefer to be spontaneous",
            "A. Focused on logic   B. Focused on emotions",
            "A. Direct and to the point   B. Diplomatic and considerate",
            "A. Prefer routine   B. Enjoy variety",
            "A. Prefer solitude   B. Enjoy being around people",
            "A. Value consistency   B. Value flexibility",
            "A. Practical and realistic   B. Imaginative and visionary"
        };

        for (int questionIndex = 0; questionIndex < questions.length; questionIndex++) {
            System.out.println("\nQuestion " + (questionIndex + 1) + ": " + questions[questionIndex]);
            System.out.print("Please choose A or B for this question: ");
            char answerInput = scanner.next().toUpperCase().charAt(0);
            while (answerInput != 'A' && answerInput != 'B') {
                System.out.print("Oops! That wasn't A or B. Please choose A or B: ");
                answerInput = scanner.next().toUpperCase().charAt(0);
            }
            answers[questionIndex] = answerInput;
        }

        System.out.println("\nThank you, " + fullName + "! You selected:");
        for (int answerIndex = 0; answerIndex < answers.length; answerIndex++) {
            if (answers[answerIndex] == 'A') {
                switch (answerIndex) {
                    case 0: System.out.println("A. Tough-minded, just"); break;
                    case 1: System.out.println("A. Candid, straightforward, frank"); break;
                    case 2: System.out.println("A. Logical, analytical"); break;
                    case 3: System.out.println("A. Decisive, goal-oriented"); break;
                    case 4: System.out.println("A. Reserved, introverted"); break;
                    case 5: System.out.println("A. Structured, organized"); break;
                    case 6: System.out.println("A. Realistic, practical"); break;
                    case 7: System.out.println("A. Focused on details"); break;
                    case 8: System.out.println("A. Independent, self-reliant"); break;
                    case 9: System.out.println("A. Calm, level-headed"); break;
                    case 10: System.out.println("A. Fact-based, factual"); break;
                    case 11: System.out.println("A. Task-focused"); break;
                    case 12: System.out.println("A. Confident, assertive"); break;
                    case 13: System.out.println("A. Like to plan ahead"); break;
                    case 14: System.out.println("A. Focused on logic"); break;
                    case 15: System.out.println("A. Direct and to the point"); break;
                    case 16: System.out.println("A. Prefer routine"); break;
                    case 17: System.out.println("A. Prefer solitude"); break;
                    case 18: System.out.println("A. Value consistency"); break;
                    case 19: System.out.println("A. Practical and realistic"); break;
                }
            } else {
                switch (answerIndex) {
                    case 0: System.out.println("B. Tender-hearted, merciful"); break;
                    case 1: System.out.println("B. Tactful, kind, encouraging"); break;
                    case 2: System.out.println("B. Emotional, empathetic"); break;
                    case 3: System.out.println("B. Open-ended, flexible"); break;
                    case 4: System.out.println("B. Outgoing, extroverted"); break;
                    case 5: System.out.println("B. Spontaneous, carefree"); break;
                    case 6: System.out.println("B. Imaginative, creative"); break;
                    case 7: System.out.println("B. Big-picture thinker"); break;
                    case 8: System.out.println("B. Team-oriented, cooperative"); break;
                    case 9: System.out.println("B. Passionate, energetic"); break;
                    case 10: System.out.println("B. Possibility-based, speculative"); break;
                    case 11: System.out.println("B. People-focused"); break;
                    case 12: System.out.println("B. Agreeable, accommodating"); break;
                    case 13: System.out.println("B. Prefer to be spontaneous"); break;
                    case 14: System.out.println("B. Focused on emotions"); break;
                    case 15: System.out.println("B. Diplomatic and considerate"); break;
                    case 16: System.out.println("B. Enjoy variety"); break;
                    case 17: System.out.println("B. Enjoy being around people"); break;
                    case 18: System.out.println("B. Value flexibility"); break;
                    case 19: System.out.println("B. Imaginative and visionary"); break;
                }
            }
        }

        int thinkingCount = 0, feelingCount = 0;
        int introversionCount = 0, extraversionCount = 0;
        int sensingCount = 0, intuitionCount = 0;
        int judgingCount = 0, perceivingCount = 0;
        String[] dimensionsMapping = {
            "TF", "TF", "TF", "JP", "EI", "JP", "SN", "SN", "TF", "TF",
            "SN", "TF", "TF", "JP", "TF", "TF", "JP", "EI", "JP", "SN"
        };

        for (int answerIndex = 0; answerIndex < answers.length; answerIndex++) {
            String currentDimension = dimensionsMapping[answerIndex];
            if (currentDimension.equals("TF")) {
                if (answers[answerIndex] == 'A') {
                    thinkingCount++;
                } else {
                    feelingCount++;
                }
            } else if (currentDimension.equals("EI")) {
                if (answers[answerIndex] == 'A') {
                    introversionCount++;
                } else {
                    extraversionCount++;
                }
            } else if (currentDimension.equals("SN")) {
                if (answers[answerIndex] == 'A') {
                    sensingCount++;
                } else {
                    intuitionCount++;
                }
            } else if (currentDimension.equals("JP")) {
                if (answers[answerIndex] == 'A') {
                    judgingCount++;
                } else {
                    perceivingCount++;
                }
            }
        }

        char personalityLetter1 = (introversionCount >= extraversionCount ? 'I' : 'E');
        char personalityLetter2 = (sensingCount >= intuitionCount ? 'S' : 'N');
        char personalityLetter3 = (thinkingCount >= feelingCount ? 'T' : 'F');
        char personalityLetter4 = (judgingCount >= perceivingCount ? 'J' : 'P');
        String personalityType = "" + personalityLetter1 + personalityLetter2 + personalityLetter3 + personalityLetter4;

        if (personalityType.equals("ISTJ")) {
            System.out.println("\nYour personality type is ISTJ.");
            System.out.println("They are known as the Logistician.");
            System.out.println("ISTJs are very practical, responsible, and love order. They work hard, follow rules, and make sure everything is done right.");
        } else if (personalityType.equals("ISFJ")) {
            System.out.println("\nYour personality type is ISFJ.");
            System.out.println("They are known as the Defender.");
            System.out.println("ISFJs are very caring, helpful, and gentle. They always try to make sure others are safe and happy, and they pay attention to small details.");
        } else if (personalityType.equals("INFJ")) {
            System.out.println("\nYour personality type is INFJ.");
            System.out.println("They are known as the Advocate.");
            System.out.println("INFJs are kind, creative, and always try to help others. They look deep into situations and have a strong sense of what is right.");
        } else if (personalityType.equals("INTJ")) {
            System.out.println("\nYour personality type is INTJ.");
            System.out.println("They are known as the Architect.");
            System.out.println("INTJs are very smart and thoughtful. They love solving puzzles and planning for the future, always thinking about how to improve things.");
        } else if (personalityType.equals("ISTP")) {
            System.out.println("\nYour personality type is ISTP.");
            System.out.println("They are known as the Virtuoso.");
            System.out.println("ISTPs are brave, clever, and love to fix things. They enjoy trying new activities and learning by doing, always ready for an adventure.");
        } else if (personalityType.equals("ISFP")) {
            System.out.println("\nYour personality type is ISFP.");
            System.out.println("They are known as the Adventurer.");
            System.out.println("ISFPs are gentle and creative, and they love making art and exploring new ideas. They take life as it comes and enjoy every moment.");
        } else if (personalityType.equals("INFP")) {
            System.out.println("\nYour personality type is INFP.");
            System.out.println("They are known as the Healer.");
            System.out.println("INFPs are dreamy and kind. They have big imaginations and always try to make the world a better place with their creative ideas.");
        } else if (personalityType.equals("INTP")) {
            System.out.println("\nYour personality type is INTP.");
            System.out.println("They are known as the Logician.");
            System.out.println("INTPs are very curious and love to think about big ideas. They ask lots of questions and enjoy figuring out how things work.");
        } else if (personalityType.equals("ESTP")) {
            System.out.println("\nYour personality type is ESTP.");
            System.out.println("They are known as the Entrepreneur.");
            System.out.println("ESTPs are fun, active, and love excitement. They make quick decisions and are always ready to jump into new adventures.");
        } else if (personalityType.equals("ESFP")) {
            System.out.println("\nYour personality type is ESFP.");
            System.out.println("They are known as the Entertainer.");
            System.out.println("ESFPs are cheerful and playful. They love making people laugh, enjoy being around others, and always try to make life fun.");
        } else if (personalityType.equals("ENFP")) {
            System.out.println("\nYour personality type is ENFP.");
            System.out.println("They are known as the Campaigner.");
            System.out.println("ENFPs are very friendly and creative. They love to explore new ideas and make new friends, always bringing energy and joy to any room.");
        } else if (personalityType.equals("ENTP")) {
            System.out.println("\nYour personality type is ENTP.");
            System.out.println("They are known as the Debater.");
            System.out.println("ENTPs are inventive and love to discuss new ideas. They enjoy debating and thinking outside the box to solve problems in fun ways.");
        } else if (personalityType.equals("ESTJ")) {
            System.out.println("\nYour personality type is ESTJ.");
            System.out.println("They are known as the Executive.");
            System.out.println("ESTJs are very organized and strong. They like to take charge, plan carefully, and make sure everything is in its proper place.");
        } else if (personalityType.equals("ESFJ")) {
            System.out.println("\nYour personality type is ESFJ.");
            System.out.println("They are known as the Consul.");
            System.out.println("ESFJs are friendly and caring. They always look out for their friends and family, making sure everyone feels included and valued.");
        } else if (personalityType.equals("ENFJ")) {
            System.out.println("\nYour personality type is ENFJ.");
            System.out.println("They are known as the Protagonist.");
            System.out.println("ENFJs are warm and inspiring. They naturally lead others, making everyone feel important and encouraging people to be their best.");
        } else if (personalityType.equals("ENTJ")) {
            System.out.println("\nYour personality type is ENTJ.");
            System.out.println("They are known as the Commander.");
            System.out.println("ENTJs are bold and strong leaders. They plan big, work hard, and always push themselves and others to achieve great goals.");
        } else {
            System.out.println("\nUnknown Type");
        }
        scanner.close();
    }
}
