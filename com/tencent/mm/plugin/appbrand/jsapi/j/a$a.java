package com.tencent.mm.plugin.appbrand.jsapi.j;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

enum a$a {
    YEAR(new SimpleDateFormat("yyyy", Locale.US)),
    MONTH(new SimpleDateFormat("yyyy-MM", Locale.US)),
    DAY(new SimpleDateFormat("yyyy-MM-dd", Locale.US));
    
    final DateFormat fXe;

    private a$a(DateFormat dateFormat) {
        this.fXe = dateFormat;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.tencent.mm.plugin.appbrand.jsapi.j.a$a tX(java.lang.String r4) {
        /*
        r0 = 0;
        r1 = r4.length();
        r2 = 5;
        r1 = java.lang.Math.min(r1, r2);
        r1 = java.lang.Math.max(r0, r1);
        r1 = r4.substring(r0, r1);
        r2 = r1.toLowerCase();
        r1 = -1;
        r3 = r2.hashCode();
        switch(r3) {
            case 99228: goto L_0x003a;
            case 3704893: goto L_0x0025;
            case 104080000: goto L_0x002f;
            default: goto L_0x001e;
        };
    L_0x001e:
        r0 = r1;
    L_0x001f:
        switch(r0) {
            case 0: goto L_0x0045;
            case 1: goto L_0x0048;
            case 2: goto L_0x004b;
            default: goto L_0x0022;
        };
    L_0x0022:
        r0 = MONTH;
    L_0x0024:
        return r0;
    L_0x0025:
        r3 = "year";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x001e;
    L_0x002e:
        goto L_0x001f;
    L_0x002f:
        r0 = "month";
        r0 = r2.equals(r0);
        if (r0 == 0) goto L_0x001e;
    L_0x0038:
        r0 = 1;
        goto L_0x001f;
    L_0x003a:
        r0 = "day";
        r0 = r2.equals(r0);
        if (r0 == 0) goto L_0x001e;
    L_0x0043:
        r0 = 2;
        goto L_0x001f;
    L_0x0045:
        r0 = YEAR;
        goto L_0x0024;
    L_0x0048:
        r0 = MONTH;
        goto L_0x0024;
    L_0x004b:
        r0 = DAY;
        goto L_0x0024;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.j.a$a.tX(java.lang.String):com.tencent.mm.plugin.appbrand.jsapi.j.a$a");
    }

    final Date parse(String str) {
        try {
            return this.fXe.parse(str);
        } catch (Exception e) {
            return null;
        }
    }
}
