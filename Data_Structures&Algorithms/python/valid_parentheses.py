class Solution:
    def isValid(self, s: str) -> bool:
        # ALGO:
        # Declare a map for brancket with opening ones as key
        # Declare a stack list
        # Iterate on string
        # If opening bracket is encountered, insert associated closing brancket to stack
        # If closing bracket is encountered, check if stack's top element == current bracket from string
        # If not => string is invalid
        # End of iteration
        # If any brancket is left in stack that means some bracket is never closed =>  string is invalid
        # Else: Valid string
        
        d = {"{": "}", "[": "]", "(": ")"}
        stack = []
        for element in s:
            if element in d:
                stack.append(d[element])
            else:
                if not stack or element != stack.pop():
                    return False
        if stack:
            return False
        return True
