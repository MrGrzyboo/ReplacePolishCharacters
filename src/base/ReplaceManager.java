package base;

class ReplaceManager {
    private static final char[][] characters = {
            {'ą', 'a'},
            {'ć', 'c'},
            {'ę', 'e'},
            {'ł', 'l'},
            {'ń', 'n'},
            {'ó', 'o'},
            {'ś', 's'},
            {'ż', 'z'},
            {'ź', 'z'}
    };

    static char replaceIfNecessary(char c) {
        for (char[] character : characters) {
            if (character[0] == c)
                return character[1];
        }

        return c;
    }



}
