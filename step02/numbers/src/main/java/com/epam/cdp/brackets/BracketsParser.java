package com.epam.cdp.brackets;

import com.epam.cdp.brackets.errors.InvalidBracketStateException;
import com.epam.cdp.brackets.errors.NotCorrectBracketException;

import java.util.*;
import java.util.regex.Pattern;

public class BracketsParser {
    private static final Pattern allowed = Pattern.compile("[\\[\\]{}()<>]+");
    private static Hashtable<Character, Character> brackets;
    static {
        brackets = new Hashtable<>();
        brackets.put('[', ']');
        brackets.put('(', ')');
        brackets.put('{', '}');
        brackets.put('<', '>');
    }

    public boolean parse(String string) {
        if (!allowed.matcher(string).matches()) {
            return false;
        }

        return validate(string);
    }

    private boolean validate(String string) {
        Deque<Character> open_brackets = new ArrayDeque<>();

        for (Character bracket : string.toCharArray()) {
            if (brackets.containsKey(bracket)) {
                open_brackets.push(bracket);
            } else {
                if (open_brackets.size() == 0)
                    throw new InvalidBracketStateException("Nothing to close");

                char open_bracket = open_brackets.pop();
                System.out.format("%s - %s\n", open_bracket, bracket);

                if (brackets.get(open_bracket) != bracket) {
                    throw new NotCorrectBracketException(brackets.getOrDefault(open_bracket, '-').toString());
                }
            }
        }

        Optional<Character> opt = Optional.ofNullable(null);
        opt.stream()

        return open_brackets.size() == 0;
    }
}
