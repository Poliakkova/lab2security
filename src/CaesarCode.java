public class CaesarCode {
    public String code(String str, int key) {
        String string = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z') {
                c += key % 26;
                if (c < 'a')
                    c += 26;
                if(c > 'z')
                    c -= 26;
            } else if(c >= 'A' && c <= 'Z') {
                c += key % 26;
                if(c < 'A')
                    c += 26;
                if(c > 'Z')
                    c -= 26;
            }
            string += c;
        }
        return string;
    }

    public String decode(String str, int key) {
        String string = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z') {
                c -= key % 26;
                if (c < 'a')
                    c += 26;
                if(c > 'z')
                    c -= 26;
            } else if(c >= 'A' && c <= 'Z') {
                c -= key % 26;
                if(c < 'A')
                    c += 26;
                if(c > 'Z')
                    c -= 26;
            }
            string += c;
        }
        return string;
    }
}
