package com.tencent.mm.plugin.normsg.b;

import com.tencent.mm.sdk.platformtools.bi;

final class a$c {
    private a$c() {
    }

    public static boolean isEnabled() {
        StringBuilder stringBuilder = new StringBuilder();
        String stringBuilder2;
        try {
            stringBuilder.append(d.IO("Úà¯ßºÔ"));
            stringBuilder2 = stringBuilder.toString();
            stringBuilder.delete(0, stringBuilder.length());
            stringBuilder.append(((a$c.class.hashCode() >>> 31) | 1) ^ 1);
            if (stringBuilder.toString().equals(a.ea(stringBuilder2, stringBuilder.toString()))) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            stringBuilder2 = stringBuilder.toString();
            stringBuilder.delete(0, stringBuilder.length());
            stringBuilder.append(((a$c.class.hashCode() >>> 31) | 1) ^ 1);
            if (stringBuilder.toString().equals(a.ea(stringBuilder2, stringBuilder.toString()))) {
                return false;
            }
            return true;
        }
    }

    static boolean bjK() {
        StringBuilder stringBuilder = new StringBuilder();
        String stringBuilder2;
        try {
            stringBuilder.append(d.IO("Þä¦Ê¡ã¡"));
            stringBuilder2 = stringBuilder.toString();
            stringBuilder.delete(0, stringBuilder.length());
            stringBuilder.append(((a$c.class.hashCode() >>> 31) | 1) ^ 1);
            if (stringBuilder.toString().equals(a.ea(stringBuilder2, stringBuilder.toString()))) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            stringBuilder2 = stringBuilder.toString();
            stringBuilder.delete(0, stringBuilder.length());
            stringBuilder.append(((a$c.class.hashCode() >>> 31) | 1) ^ 1);
            if (stringBuilder.toString().equals(a.ea(stringBuilder2, stringBuilder.toString()))) {
                return false;
            }
            return true;
        }
    }

    public static int bjL() {
        Throwable th;
        StringBuilder stringBuilder = new StringBuilder();
        int hashCode;
        String stringBuilder2;
        int hashCode2;
        try {
            stringBuilder.append(d.IO("S\u0000D\u000fF(\\\tK"));
            hashCode = (a$c.class.hashCode() >>> 31) | 1;
            stringBuilder2 = stringBuilder.toString();
            if (hashCode == 0) {
                return hashCode;
            }
            try {
                hashCode2 = ((a$c.class.hashCode() >>> 31) | 1) ^ 1;
                try {
                    stringBuilder.delete(0, stringBuilder.length());
                    stringBuilder.append(hashCode2);
                    return bi.getInt(a.ea(stringBuilder2, stringBuilder.toString()), hashCode2);
                } catch (Throwable th2) {
                    th = th2;
                    stringBuilder.append(hashCode2);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                hashCode2 = hashCode;
                stringBuilder.append(hashCode2);
                throw th;
            }
        } catch (Throwable th22) {
            th = th22;
            stringBuilder.append(hashCode2);
            throw th;
        }
    }

    static boolean bjM() {
        StringBuilder stringBuilder = new StringBuilder();
        String stringBuilder2;
        try {
            stringBuilder.append(d.IO("Àú¿ÑÄ"));
            stringBuilder2 = stringBuilder.toString();
            stringBuilder.delete(0, stringBuilder.length());
            stringBuilder.append(((a$c.class.hashCode() >>> 31) | 1) ^ 1);
            if (stringBuilder.toString().equals(a.ea(stringBuilder2, stringBuilder.toString()))) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            stringBuilder2 = stringBuilder.toString();
            stringBuilder.delete(0, stringBuilder.length());
            stringBuilder.append(((a$c.class.hashCode() >>> 31) | 1) ^ 1);
            if (stringBuilder.toString().equals(a.ea(stringBuilder2, stringBuilder.toString()))) {
                return false;
            }
            return true;
        }
    }
}
