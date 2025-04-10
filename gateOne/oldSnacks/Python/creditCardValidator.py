def credit_card_validator():
    print("Hello, kindly enter your card details to verify:")
    card_number = input().strip()

    # Determine card type
    if card_number.startswith('4'):
        card_type = "Visa Card"
    elif card_number.startswith('5'):
        card_type = "MasterCard"
    elif card_number.startswith('37'):
        card_type = "American Express Card"
    elif card_number.startswith('6'):
        card_type = "Discover Card"
    else:
        card_type = "Invalid Card"

    # Validate numeric input
    if not card_number.isdigit():
        print("Invalid input. Please enter numeric characters only.")
        return

    sum1 = 0
    double_digit = False

    # Process digits from right to left
    for ch in reversed(card_number):
        digit = int(ch)

        if double_digit:
            digit *= 2
            if digit > 9:
                digit -= 9
        sum1 += digit

        double_digit = not double_digit

    total = sum1
    validity = "Valid" if total % 10 == 0 else "Invalid"

    print("\nCredit Card Type:", card_type)
    print("Credit Card Number:", card_number)
    print("Credit Card Digit Length:", len(card_number))
    print("Credit Card Validity Status:", validity)


credit_card_validator()