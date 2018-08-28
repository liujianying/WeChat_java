package com.google.android.exoplayer2.c;

import com.google.android.exoplayer2.metadata.id3.a.a;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class h {
    public static final a aiH = new 1();
    private static final Pattern aiI = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int aei = -1;
    public int aej = -1;

    public final boolean j(String str, String str2) {
        if (!"iTunSMPB".equals(str)) {
            return false;
        }
        Matcher matcher = aiI.matcher(str2);
        if (!matcher.find()) {
            return false;
        }
        try {
            int parseInt = Integer.parseInt(matcher.group(1), 16);
            int parseInt2 = Integer.parseInt(matcher.group(2), 16);
            if (parseInt <= 0 && parseInt2 <= 0) {
                return false;
            }
            this.aei = parseInt;
            this.aej = parseInt2;
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
