package org.a.a.a;

import java.io.File;

public final class a {
    public static final String vKi = Character.toString('.');
    private static final char vKj;
    private static final char vKk;

    static {
        char c = File.separatorChar;
        vKj = c;
        if ((c == '\\' ? 1 : null) != null) {
            vKk = '/';
        } else {
            vKk = '\\';
        }
    }

    private static boolean isSeparator(char c) {
        return c == '/' || c == '\\';
    }

    private static String adO(String str) {
        char c = vKj;
        if (str == null) {
            return null;
        }
        adR(str);
        int length = str.length();
        if (length == 0) {
            return str;
        }
        int adP = adP(str);
        if (adP < 0) {
            return null;
        }
        int i;
        int i2;
        Object obj = new char[(length + 2)];
        str.getChars(0, str.length(), obj, 0);
        char c2 = c == vKj ? vKk : vKj;
        for (i = 0; i < obj.length; i++) {
            if (obj[i] == c2) {
                obj[i] = c;
            }
        }
        if (obj[length - 1] != c) {
            i = length + 1;
            obj[length] = c;
            i2 = 0;
        } else {
            i2 = 1;
            i = length;
        }
        length = adP + 1;
        while (length < i) {
            if (obj[length] == c && obj[length - 1] == c) {
                System.arraycopy(obj, length, obj, length - 1, i - length);
                i--;
                length--;
            }
            length++;
        }
        length = adP + 1;
        while (length < i) {
            if (obj[length] == c && obj[length - 1] == '.' && (length == adP + 1 || obj[length - 2] == c)) {
                if (length == i - 1) {
                    i2 = 1;
                }
                System.arraycopy(obj, length + 1, obj, length - 1, i - length);
                i -= 2;
                length--;
            }
            length++;
        }
        length = adP + 2;
        while (length < i) {
            if (obj[length] == c && obj[length - 1] == '.' && obj[length - 2] == '.' && (length == adP + 2 || obj[length - 3] == c)) {
                if (length == adP + 2) {
                    return null;
                }
                if (length == i - 1) {
                    i2 = 1;
                }
                for (int i3 = length - 4; i3 >= adP; i3--) {
                    if (obj[i3] == c) {
                        System.arraycopy(obj, length + 1, obj, i3 + 1, i - length);
                        i -= length - i3;
                        length = i3 + 1;
                        break;
                    }
                }
                System.arraycopy(obj, length + 1, obj, adP, i - length);
                i -= (length + 1) - adP;
                length = adP + 1;
            }
            length++;
        }
        if (i <= 0) {
            return "";
        }
        if (i <= adP) {
            return new String(obj, 0, i);
        }
        return i2 != 0 ? new String(obj, 0, i) : new String(obj, 0, i - 1);
    }

    public static String gB(String str, String str2) {
        int adP = adP(str2);
        if (adP < 0) {
            return null;
        }
        if (adP > 0) {
            return adO(str2);
        }
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return adO(str2);
        }
        if (isSeparator(str.charAt(length - 1))) {
            return adO(str + str2);
        }
        return adO(str + '/' + str2);
    }

    private static int adP(String str) {
        if (str == null) {
            return -1;
        }
        int length = str.length();
        if (length == 0) {
            return 0;
        }
        char charAt = str.charAt(0);
        if (charAt == ':') {
            return -1;
        }
        int indexOf;
        int indexOf2;
        if (length == 1) {
            if (charAt == '~') {
                return 2;
            }
            if (isSeparator(charAt)) {
                return 1;
            }
            return 0;
        } else if (charAt == '~') {
            indexOf = str.indexOf(47, 1);
            indexOf2 = str.indexOf(92, 1);
            if (indexOf == -1 && indexOf2 == -1) {
                return length + 1;
            }
            if (indexOf == -1) {
                indexOf = indexOf2;
            }
            if (indexOf2 == -1) {
                indexOf2 = indexOf;
            }
            return Math.min(indexOf, indexOf2) + 1;
        } else {
            char charAt2 = str.charAt(1);
            if (charAt2 == ':') {
                char toUpperCase = Character.toUpperCase(charAt);
                if (toUpperCase < 'A' || toUpperCase > 'Z') {
                    if (toUpperCase == '/') {
                        return 1;
                    }
                    return -1;
                } else if (length == 2 || !isSeparator(str.charAt(2))) {
                    return 2;
                } else {
                    return 3;
                }
            } else if (isSeparator(charAt) && isSeparator(charAt2)) {
                int indexOf3 = str.indexOf(47, 2);
                indexOf2 = str.indexOf(92, 2);
                if ((indexOf3 == -1 && indexOf2 == -1) || indexOf3 == 2 || indexOf2 == 2) {
                    return -1;
                }
                if (indexOf3 == -1) {
                    indexOf = indexOf2;
                } else {
                    indexOf = indexOf3;
                }
                if (indexOf2 == -1) {
                    indexOf2 = indexOf;
                }
                return Math.min(indexOf, indexOf2) + 1;
            } else if (isSeparator(charAt)) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    private static int adQ(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    public static String getName(String str) {
        if (str == null) {
            return null;
        }
        adR(str);
        return str.substring(adQ(str) + 1);
    }

    private static void adR(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == 0) {
                throw new IllegalArgumentException("Null byte present in file/path name. There are no known legitimate use cases for such data, but several injection attacks may use it");
            }
        }
    }

    public static String adS(String str) {
        if (str == null) {
            return null;
        }
        int i;
        if (str == null) {
            i = -1;
        } else {
            i = str.lastIndexOf(46);
            if (adQ(str) > i) {
                i = -1;
            }
        }
        if (i == -1) {
            return "";
        }
        return str.substring(i + 1);
    }
}
