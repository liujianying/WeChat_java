package com.tencent.mm.wallet_core.f;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class b {
    public static boolean cDu() {
        String stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder(8);
        int i = 0;
        while (i < 6) {
            try {
                stringBuilder2.append((char) ((int) ((57497235128533601L >> ((5 - i) * 8)) & 255)));
                i++;
            } catch (Throwable th) {
                stringBuilder = stringBuilder2.toString();
                stringBuilder2.delete(0, stringBuilder2.length());
                stringBuilder2.append(((b.class.hashCode() >>> 31) | 1) ^ 1);
                if (stringBuilder2.toString().equals(dZ(stringBuilder, stringBuilder2.toString()))) {
                    return false;
                }
                return true;
            }
        }
        stringBuilder = stringBuilder2.toString();
        stringBuilder2.delete(0, stringBuilder2.length());
        stringBuilder2.append(((b.class.hashCode() >>> 31) | 1) ^ 1);
        if (stringBuilder2.toString().equals(dZ(stringBuilder, stringBuilder2.toString()))) {
            return false;
        }
        return true;
    }

    public static boolean cDv() {
        String stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder(8);
        int i = 0;
        while (i < 6) {
            try {
                stringBuilder2.append((char) ((int) ((57778710156427883L >> ((5 - i) * 8)) & 255)));
                i++;
            } catch (Throwable th) {
                stringBuilder = stringBuilder2.toString();
                stringBuilder2.delete(0, stringBuilder2.length());
                stringBuilder2.append(((b.class.hashCode() >>> 31) | 1) ^ 1);
                if (stringBuilder2.toString().equals(dZ(stringBuilder, stringBuilder2.toString()))) {
                    return false;
                }
                return true;
            }
        }
        stringBuilder = stringBuilder2.toString();
        stringBuilder2.delete(0, stringBuilder2.length());
        stringBuilder2.append(((b.class.hashCode() >>> 31) | 1) ^ 1);
        if (stringBuilder2.toString().equals(dZ(stringBuilder, stringBuilder2.toString()))) {
            return false;
        }
        return true;
    }

    public static boolean cDw() {
        String stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder(8);
        int i = 0;
        while (i < 6) {
            try {
                stringBuilder2.append((char) ((int) ((65941484396629365L >> ((5 - i) * 8)) & 255)));
                i++;
            } catch (Throwable th) {
                stringBuilder = stringBuilder2.toString();
                stringBuilder2.delete(0, stringBuilder2.length());
                stringBuilder2.append(((b.class.hashCode() >>> 31) | 1) ^ 1);
                if (stringBuilder2.toString().equals(dZ(stringBuilder, stringBuilder2.toString()))) {
                    return false;
                }
                return true;
            }
        }
        stringBuilder = stringBuilder2.toString();
        stringBuilder2.delete(0, stringBuilder2.length());
        stringBuilder2.append(((b.class.hashCode() >>> 31) | 1) ^ 1);
        if (stringBuilder2.toString().equals(dZ(stringBuilder, stringBuilder2.toString()))) {
            return false;
        }
        return true;
    }

    private static String dZ(String str, String str2) {
        c fJ = com.tencent.mm.model.c.c.Jx().fJ("100327");
        if (fJ.isValid()) {
            Map ckq = fJ.ckq();
            if (ckq == null) {
                x.w("MicroMsg.WalletPayHelper", "check point 2, explained by src code.");
                return str2;
            }
            String str3 = (String) ckq.get(str);
            if (str3 == null || str3.length() <= 0) {
                return str2;
            }
            return str3;
        }
        x.w("MicroMsg.WalletPayHelper", "check point 1, explained by src code.");
        return str2;
    }
}
