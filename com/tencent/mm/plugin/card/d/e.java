package com.tencent.mm.plugin.card.d;

import android.util.Base64;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class e {
    public static String cg(String str, String str2) {
        if (str2 == null || str2.length() <= 0) {
            return null;
        }
        g.Eg();
        try {
            byte[] aj = aj(("CbW9HMPiil38ldOjZp5WkwlIfzvLwiX6_" + a.Df() + "_" + str).getBytes());
            byte[] xM = xM(str2);
            Key secretKeySpec = new SecretKeySpec(aj, "AES");
            Cipher instance = Cipher.getInstance("AES");
            instance.init(2, secretKeySpec);
            return new String(instance.doFinal(xM));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CardDymanicQrcodeOfflineHelper", e, "", new Object[0]);
            return null;
        }
    }

    public static String ch(String str, String str2) {
        String str3 = null;
        if (str2 == null || str2.length() <= 0) {
            return str3;
        }
        g.Eg();
        try {
            byte[] aj = aj(("CbW9HMPiil38ldOjZp5WkwlIfzvLwiX6_" + a.Df() + "_" + str).getBytes());
            byte[] bytes = str2.getBytes();
            Key secretKeySpec = new SecretKeySpec(aj, "AES");
            Cipher instance = Cipher.getInstance("AES");
            instance.init(1, secretKeySpec);
            return ai(instance.doFinal(bytes));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CardDymanicQrcodeOfflineHelper", e, "", new Object[0]);
            return str3;
        }
    }

    private static String ai(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            stringBuilder.append("0123456789ABCDEF".charAt((bArr[i] >> 4) & 15)).append("0123456789ABCDEF".charAt(bArr[i] & 15));
        }
        return stringBuilder.toString();
    }

    private static byte[] xM(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = Integer.valueOf(str.substring(i * 2, (i * 2) + 2), 16).byteValue();
        }
        return bArr;
    }

    private static byte[] aj(byte[] bArr) {
        KeyGenerator instance = KeyGenerator.getInstance("AES");
        SecureRandom instance2 = SecureRandom.getInstance("SHA1PRNG", "Crypto");
        instance2.setSeed(bArr);
        instance.init(128, instance2);
        return instance.generateKey().getEncoded();
    }

    public static String ci(String str, String str2) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("&");
        stringBuilder.append(currentTimeMillis);
        stringBuilder.append("&");
        stringBuilder.append(str2);
        try {
            String cj = cj(stringBuilder.toString(), str2);
            stringBuilder2.append(str);
            stringBuilder2.append("&");
            stringBuilder2.append(currentTimeMillis);
            stringBuilder2.append("&");
            stringBuilder2.append(cj);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CardDymanicQrcodeOfflineHelper", e, "", new Object[0]);
        }
        return stringBuilder2.toString();
    }

    private static String cj(String str, String str2) {
        try {
            Mac instance = Mac.getInstance("HmacSHA256");
            instance.init(new SecretKeySpec(str2.getBytes(), "HmacSHA256"));
            String encodeToString = Base64.encodeToString(instance.doFinal(str.getBytes()), 2);
            x.i("MicroMsg.CardDymanicQrcodeOfflineHelper", "hash is: " + encodeToString);
            return encodeToString;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CardDymanicQrcodeOfflineHelper", e, "", new Object[0]);
            return "";
        }
    }
}
