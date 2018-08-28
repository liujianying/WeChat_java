package com.tencent.map.lib.util;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.tencent.map.lib.gl.model.GLIcon;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class StringUtil {
    private static SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean isMatched(String str, String str2) {
        if (str2 == null || str == null || str2.indexOf(str) != 0) {
            return false;
        }
        return true;
    }

    public static boolean isContains(String str, String str2) {
        if (str2 == null || str == null) {
            return false;
        }
        return str2.contains(str);
    }

    public static CharSequence buildMulColorText(String[] strArr, int[] iArr) {
        CharSequence spannableStringBuilder = new SpannableStringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            CharSequence spannableStringBuilder2 = new SpannableStringBuilder(strArr[i]);
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(iArr[i]), 0, spannableStringBuilder2.length(), 33);
            spannableStringBuilder.append(spannableStringBuilder2);
        }
        return spannableStringBuilder;
    }

    public static String toUTF8(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (Exception e) {
            return "";
        }
    }

    public static String fromUTF8(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (Exception e) {
            return "";
        }
    }

    public static String toGBK(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "gbk");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public static String bytesToHexString(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(GLIcon.TOP);
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(toHexString);
        }
        return stringBuilder.toString();
    }

    public static boolean isWordLikeMyLocation(String str) {
        if (isEmpty(str)) {
            return false;
        }
        if (str.equals("我的位置") || str.equals("当前位置") || str.equals("我在哪") || str.equals("我在哪儿") || str.equals("我在的位置") || str.equals("我的位置在哪") || str.equals("我的位置在哪儿")) {
            return true;
        }
        return false;
    }

    public static boolean isNumber(String str) {
        try {
            return Pattern.compile("[0-9]*").matcher(str).matches();
        } catch (Exception e) {
            return false;
        }
    }

    public static int compareVersion(String str, String str2) {
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int i = 0;
        while (true) {
            if (i < (split.length > split2.length ? split2.length : split.length)) {
                int intValue = Integer.valueOf(split[i]).intValue();
                int intValue2 = Integer.valueOf(split2[i]).intValue();
                if (intValue - intValue2 != 0) {
                    return intValue - intValue2;
                }
                i++;
            } else if (split.length != split2.length) {
                return split.length - split2.length;
            } else {
                return 0;
            }
        }
    }

    public static String toDateFormat(long j) {
        return a.format(Long.valueOf(j));
    }
}
