def main():
    full_name = input("What is your full name: ")
    print(f"Hello {full_name}! Welcome to the MBTI Personality Test. Please take your time and choose the option that best describes you.")

    questions = [
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
    ]

    answers = []
    for index, question in enumerate(questions, 1):
        print(f"\nQuestion {index}: {question}")
        answer = input("Please choose A or B for this question: ").upper()
        while answer not in ['A', 'B']:
            answer = input("Oops! That wasn't A or B. Please choose A or B: ").upper()
        answers.append(answer)

    print(f"\nThank you, {full_name}! You selected:")
    for index, answer in enumerate(answers):
        if answer == 'A':
            print(questions[index].split("   ")[0])
        else:
            print(questions[index].split("   ")[1])

    thinking_count = feeling_count = 0
    introversion_count = extraversion_count = 0
    sensing_count = intuition_count = 0
    judging_count = perceiving_count = 0

    dimensions_mapping = [
        "TF", "TF", "TF", "JP", "EI", "JP", "SN", "SN", "TF", "TF",
        "SN", "TF", "TF", "JP", "TF", "TF", "JP", "EI", "JP", "SN"
    ]

    for index, answer in enumerate(answers):
        current_dimension = dimensions_mapping[index]
        if current_dimension == "TF":
            if answer == 'A':
                thinking_count += 1
            else:
                feeling_count += 1
        elif current_dimension == "EI":
            if answer == 'A':
                introversion_count += 1
            else:
                extraversion_count += 1
        elif current_dimension == "SN":
            if answer == 'A':
                sensing_count += 1
            else:
                intuition_count += 1
        elif current_dimension == "JP":
            if answer == 'A':
                judging_count += 1
            else:
                perceiving_count += 1

    personality_letter1 = 'I' if introversion_count >= extraversion_count else 'E'
    personality_letter2 = 'S' if sensing_count >= intuition_count else 'N'
    personality_letter3 = 'T' if thinking_count >= feeling_count else 'F'
    personality_letter4 = 'J' if judging_count >= perceiving_count else 'P'
    personality_type = personality_letter1 + personality_letter2 + personality_letter3 + personality_letter4

    type_descriptions = {
        "ISTJ": ("Logistician", "They are very practical, responsible, and love order. They work hard, follow rules, and make sure everything is done right."),
        "ISFJ": ("Defender", "They are very caring, helpful, and gentle. They always try to make sure others are safe and happy, and they pay attention to small details."),
        "INFJ": ("Advocate", "They are kind, creative, and always try to help others. They look deep into situations and have a strong sense of what is right."),
        "INTJ": ("Architect", "They are very smart and thoughtful. They love solving puzzles and planning for the future, always thinking about how to improve things."),
        "ISTP": ("Virtuoso", "They are brave, clever, and love to fix things. They enjoy trying new activities and learning by doing, always ready for an adventure."),
        "ISFP": ("Adventurer", "They are gentle and creative, and they love making art and exploring new ideas. They take life as it comes and enjoy every moment."),
        "INFP": ("Healer", "They are dreamy and kind. They have big imaginations and always try to make the world a better place with their creative ideas."),
        "INTP": ("Logician", "They are very curious and love to think about big ideas. They ask lots of questions and enjoy figuring out how things work."),
        "ESTP": ("Entrepreneur", "They are fun, active, and love excitement. They make quick decisions and are always ready to jump into new adventures."),
        "ESFP": ("Entertainer", "They are cheerful and playful. They love making people laugh, enjoy being around others, and always try to make life fun."),
        "ENFP": ("Campaigner", "They are very friendly and creative. They love to explore new ideas and make new friends, always bringing energy and joy to any room."),
        "ENTP": ("Debater", "They are inventive and love to discuss new ideas. They enjoy debating and thinking outside the box to solve problems in fun ways."),
        "ESTJ": ("Executive", "They are very organized and strong. They like to take charge, plan carefully, and make sure everything is in its proper place."),
        "ESFJ": ("Consul", "They are friendly and caring. They always look out for their friends and family, making sure everyone feels included and valued."),
        "ENFJ": ("Protagonist", "They are warm and inspiring. They naturally lead others, making everyone feel important and encouraging people to be their best."),
        "ENTJ": ("Commander", "They are bold and strong leaders. They plan big, work hard, and always push themselves and others to achieve great goals.")
    }

    if personality_type in type_descriptions:
        title, description = type_descriptions[personality_type]
        print(f"\nYour personality type is {personality_type}.")
        print(f"They are known as the {title}.")
        print(description)
    else:
        print("\nUnknown Type")

if __name__ == "__main__":
    main()