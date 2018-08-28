package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.c;
import java.util.UnknownFormatConversionException;

public class g {
    static int a = 5;
    static int b = 16;
    static char[] c = new char[16];
    static String d = "dex2oat-cmdline";
    static long e = 4096;

    public static String a(Context context, String str) {
        boolean z = true;
        c cVar = new c(str);
        cVar.a(c);
        if (c[a] != 1) {
            z = false;
        }
        cVar.a(z);
        cVar.a(e);
        return a(new String(a(cVar)));
    }

    private static String a(String str) {
        String[] split = str.split(new String("\u0000"));
        int i = 0;
        while (i < split.length) {
            int i2 = i + 1;
            String str2 = split[i];
            i = i2 + 1;
            String str3 = split[i2];
            if (str2.equals(d)) {
                return str3;
            }
        }
        return "";
    }

    public static char[] a(c cVar) {
        char[] cArr = new char[4];
        char[] cArr2 = new char[4];
        cVar.a(cArr);
        if (cArr[0] == 'o' && cArr[1] == 'a' && cArr[2] == 't') {
            cVar.a(cArr2);
            cVar.a();
            cVar.a();
            cVar.a();
            cVar.a();
            cVar.a();
            cVar.a();
            cVar.a();
            cVar.a();
            if (cArr2[1] <= '4') {
                cVar.a();
                cVar.a();
                cVar.a();
            }
            cVar.a();
            cVar.a();
            cVar.a();
            cVar.a();
            cVar.a();
            cVar.a();
            cVar.a();
            cArr = new char[cVar.a()];
            cVar.a(cArr);
            return cArr;
        }
        throw new UnknownFormatConversionException(String.format("Invalid art magic %c%c%c", new Object[]{Character.valueOf(cArr[0]), Character.valueOf(cArr[1]), Character.valueOf(cArr[2])}));
    }
}
