package com.tencent.mm.platformtools;

public final class h {
    public static String oI(String str) {
        if (str == null || "".equals(str.trim())) {
            return str;
        }
        char[] toCharArray = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (char g : toCharArray) {
            String g2 = SpellMap.g(g);
            if (g2 != null) {
                stringBuffer.append(g2);
            }
        }
        return stringBuffer.toString();
    }

    public static String oJ(String str) {
        if (str == null || "".equals(str.trim())) {
            return str;
        }
        char[] toCharArray = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        int length = toCharArray.length;
        for (int i = 0; i < length; i++) {
            if (!Character.isSpace(toCharArray[i])) {
                String g = SpellMap.g(toCharArray[i]);
                if (g != null && g.length() > 0) {
                    stringBuffer.append(g.charAt(0));
                }
            }
        }
        return stringBuffer.toString().toUpperCase();
    }
}
