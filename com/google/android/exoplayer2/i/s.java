package com.google.android.exoplayer2.i;

import android.net.Uri;
import android.text.TextUtils;

public final class s {
    public static Uri k(String str, String str2) {
        CharSequence str3;
        String stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        if (str3 == null) {
            str3 = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        int[] az = az(str2);
        if (az[0] != -1) {
            stringBuilder2.append(str2);
            a(stringBuilder2, az[1], az[2]);
            stringBuilder = stringBuilder2.toString();
        } else {
            int[] az2 = az(str3);
            int i;
            if (az[3] == 0) {
                stringBuilder = stringBuilder2.append(str3, 0, az2[3]).append(str2).toString();
            } else if (az[2] == 0) {
                stringBuilder = stringBuilder2.append(str3, 0, az2[2]).append(str2).toString();
            } else if (az[1] != 0) {
                i = az2[0] + 1;
                stringBuilder2.append(str3, 0, i).append(str2);
                stringBuilder = a(stringBuilder2, az[1] + i, i + az[2]);
            } else if (str2.charAt(az[1]) == '/') {
                stringBuilder2.append(str3, 0, az2[1]).append(str2);
                stringBuilder = a(stringBuilder2, az2[1], az[2] + az2[1]);
            } else if (az2[0] + 2 >= az2[1] || az2[1] != az2[2]) {
                i = str3.lastIndexOf(47, az2[2] - 1);
                i = i == -1 ? az2[1] : i + 1;
                stringBuilder2.append(str3, 0, i).append(str2);
                stringBuilder = a(stringBuilder2, az2[1], i + az[2]);
            } else {
                stringBuilder2.append(str3, 0, az2[1]).append('/').append(str2);
                stringBuilder = a(stringBuilder2, az2[1], (az[2] + az2[1]) + 1);
            }
        }
        return Uri.parse(stringBuilder);
    }

    private static String a(StringBuilder stringBuilder, int i, int i2) {
        if (i >= i2) {
            return stringBuilder.toString();
        }
        if (stringBuilder.charAt(i) == '/') {
            i++;
        }
        int i3 = i;
        int i4 = i;
        while (i3 <= i2) {
            int i5;
            if (i3 == i2) {
                i5 = i3;
            } else if (stringBuilder.charAt(i3) == '/') {
                i5 = i3 + 1;
            } else {
                i3++;
            }
            int lastIndexOf;
            if (i3 == i4 + 1 && stringBuilder.charAt(i4) == '.') {
                stringBuilder.delete(i4, i5);
                i2 -= i5 - i4;
                i3 = i4;
            } else if (i3 == i4 + 2 && stringBuilder.charAt(i4) == '.' && stringBuilder.charAt(i4 + 1) == '.') {
                lastIndexOf = stringBuilder.lastIndexOf("/", i4 - 2) + 1;
                if (lastIndexOf > i) {
                    i3 = lastIndexOf;
                } else {
                    i3 = i;
                }
                stringBuilder.delete(i3, i5);
                i2 -= i5 - i3;
                i3 = lastIndexOf;
                i4 = lastIndexOf;
            } else {
                lastIndexOf = i3 + 1;
                i3 = lastIndexOf;
                i4 = lastIndexOf;
            }
        }
        return stringBuilder.toString();
    }

    private static int[] az(String str) {
        int[] iArr = new int[4];
        if (TextUtils.isEmpty(str)) {
            iArr[0] = -1;
            return iArr;
        }
        int length = str.length();
        int indexOf = str.indexOf(35);
        if (indexOf != -1) {
            length = indexOf;
        }
        indexOf = str.indexOf(63);
        if (indexOf == -1 || indexOf > length) {
            indexOf = length;
        }
        int indexOf2 = str.indexOf(47);
        if (indexOf2 == -1 || indexOf2 > indexOf) {
            indexOf2 = indexOf;
        }
        int indexOf3 = str.indexOf(58);
        if (indexOf3 > indexOf2) {
            indexOf3 = -1;
        }
        indexOf2 = (indexOf3 + 2 < indexOf && str.charAt(indexOf3 + 1) == '/' && str.charAt(indexOf3 + 2) == '/') ? 1 : 0;
        if (indexOf2 != 0) {
            indexOf2 = str.indexOf(47, indexOf3 + 3);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                indexOf2 = indexOf;
            }
        } else {
            indexOf2 = indexOf3 + 1;
        }
        iArr[0] = indexOf3;
        iArr[1] = indexOf2;
        iArr[2] = indexOf;
        iArr[3] = length;
        return iArr;
    }
}
