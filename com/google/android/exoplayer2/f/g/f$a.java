package com.google.android.exoplayer2.f.g;

import java.util.Arrays;

final class f$a {
    private static final String[] azH = new String[0];
    public final String azI;
    public final String[] azJ;
    public final String name;
    public final int position;

    private f$a(String str, int i, String str2, String[] strArr) {
        this.position = i;
        this.name = str;
        this.azI = str2;
        this.azJ = strArr;
    }

    public static f$a j(String str, int i) {
        String trim = str.trim();
        if (trim.isEmpty()) {
            return null;
        }
        String str2;
        int indexOf = trim.indexOf(" ");
        if (indexOf == -1) {
            str2 = "";
        } else {
            String trim2 = trim.substring(indexOf).trim();
            trim = trim.substring(0, indexOf);
            str2 = trim2;
        }
        String[] split = trim.split("\\.");
        String str3 = split[0];
        if (split.length > 1) {
            split = (String[]) Arrays.copyOfRange(split, 1, split.length);
        } else {
            split = azH;
        }
        return new f$a(str3, i, str2, split);
    }

    public static f$a lF() {
        return new f$a("", 0, "", new String[0]);
    }
}
