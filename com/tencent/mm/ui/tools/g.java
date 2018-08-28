package com.tencent.mm.ui.tools;

import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class g implements InputFilter {
    private int gHy;
    private int gHz;

    public enum a {
        ;

        static {
            uzY = 1;
            uzZ = 2;
            uAa = new int[]{uzY, uzZ};
        }
    }

    public g(int i, int i2) {
        this.gHy = i;
        this.gHz = i2;
    }

    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        if (du(spanned.toString(), this.gHz) + du(charSequence.toString(), this.gHz) > this.gHy) {
            return "";
        }
        return charSequence;
    }

    public static int du(String str, int i) {
        if (i == a.uzY) {
            if (bi.oW(str)) {
                return 0;
            }
            return str.length();
        } else if (i == a.uzZ) {
            return abd(str);
        } else {
            return 0;
        }
    }

    public static int abd(String str) {
        int i = 0;
        if (bi.oW(str)) {
            return 0;
        }
        int length = str.length() + abe(str);
        if (!bi.oW(str)) {
            int i2;
            int i3 = 0;
            while (true) {
                i2 = i;
                if (i3 >= str.length()) {
                    break;
                }
                char charAt = str.charAt(i3);
                if (charAt >= 0 && charAt <= 127) {
                    i2++;
                }
                i = i2;
                i3++;
            }
            i = str.length() - (abe(str) + i2);
        }
        return i + length;
    }

    public static int abe(String str) {
        if (bi.oW(str)) {
            return 0;
        }
        Matcher matcher = Pattern.compile("[\\u4e00-\\u9fa5]").matcher(str);
        int i = 0;
        while (matcher.find()) {
            for (int i2 = 0; i2 <= matcher.groupCount(); i2++) {
                i++;
            }
        }
        return i;
    }

    public static int be(int i, String str) {
        if (w.chL()) {
            return Math.round(((float) (i - Math.round((float) abd(str)))) / 2.0f);
        }
        return i - abd(str);
    }

    public static int bf(int i, String str) {
        if (w.chL()) {
            return Math.round(((float) (Math.round((float) abd(str)) - i)) / 2.0f);
        }
        return abd(str) - i;
    }
}
