package com.tenpay.ndk;

import com.tencent.smtt.sdk.WebView;

public class MessageDigestUtil {
    private native byte[] doSHA256(byte[] bArr);

    public static String bytesToHex(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & WebView.NORMAL_MODE_ALPHA);
            if (toHexString.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(toHexString.toUpperCase());
        }
        return stringBuilder.toString();
    }

    public String getSHA256Hex(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            byte[] doSHA256 = doSHA256(bArr);
            if (doSHA256 != null) {
                return bytesToHex(doSHA256);
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
