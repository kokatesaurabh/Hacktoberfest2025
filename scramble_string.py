import random

def scramble_string(input_string):
    """
    Scrambles the characters of a given string.

    Args:
        input_string: The string to be scrambled.

    Returns:
        A new string with its characters randomly scrambled.
    """
    char_list = list(input_string)  # Convert the string to a list of characters
    random.shuffle(char_list)      # Shuffle the list of characters in place
    scrambled_string = "".join(char_list) # Join the shuffled characters back into a string
    return scrambled_string

# Example usage:
original_text = "Hello, World!"
scrambled_text = scramble_string(original_text)
print(f"Original string: {original_text}")
print(f"Scrambled string: {scrambled_text}")

original_text_2 = "Python"
scrambled_text_2 = scramble_string(original_text_2)
print(f"Original string: {original_text_2}")
print(f"Scrambled string: {scrambled_text_2}")
