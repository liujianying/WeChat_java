package com.tencent.mm.model;

import com.tencent.mm.sdk.platformtools.bi;

class bl$a {
    public static boolean V(String str, String str2) {
        if (bi.oW(str)) {
            return true;
        }
        String decode = decode(encode(str));
        if (bi.oW(decode) || !decode.equals(str2)) {
            return true;
        }
        return false;
    }

    private static String encode(String str) {
        String str2 = "";
        try {
            for (char c : str.toCharArray()) {
                str2 = str2 + String.format("%02x", new Object[]{Integer.valueOf(c)});
            }
            return str2;
        } catch (Exception e) {
            return "";
        }
    }

    private static String decode(String str) {
        String str2 = "";
        if (bi.oW(str) || str.length() % 2 != 0) {
            return "";
        }
        int i = 0;
        while (i < str.length()) {
            try {
                str2 = str2 + ((char) Integer.parseInt(str.substring(i, i + 2), 16));
                i += 2;
            } catch (Exception e) {
                return "";
            }
        }
        return str2;
    }
}
