package com.tencent.mm.modelsfs;

import java.util.EnumSet;

final class g {

    public enum a {
        NOESCAPE,
        PATHNAME,
        PERIOD,
        LEADING_DIR,
        CASEFOLD
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean a(java.lang.String r9, int r10, java.lang.String r11, int r12, java.util.EnumSet<com.tencent.mm.modelsfs.g.a> r13) {
        /*
    L_0x0000:
        r0 = r9.length();
        if (r10 < r0) goto L_0x0022;
    L_0x0006:
        r0 = com.tencent.mm.modelsfs.g.a.LEADING_DIR;
        r0 = r13.contains(r0);
        if (r0 == 0) goto L_0x0018;
    L_0x000e:
        r0 = r11.charAt(r12);
        r1 = 47;
        if (r0 != r1) goto L_0x0018;
    L_0x0016:
        r0 = 1;
    L_0x0017:
        return r0;
    L_0x0018:
        r0 = r11.length();
        if (r12 != r0) goto L_0x0020;
    L_0x001e:
        r0 = 1;
        goto L_0x0017;
    L_0x0020:
        r0 = 0;
        goto L_0x0017;
    L_0x0022:
        r0 = r10 + 1;
        r1 = r9.charAt(r10);
        switch(r1) {
            case 42: goto L_0x0223;
            case 63: goto L_0x0034;
            case 91: goto L_0x00e8;
            case 92: goto L_0x01db;
            default: goto L_0x002b;
        };
    L_0x002b:
        r10 = r0;
    L_0x002c:
        r0 = r11.length();
        if (r12 < r0) goto L_0x01f6;
    L_0x0032:
        r0 = 0;
        goto L_0x0017;
    L_0x0034:
        r1 = r11.length();
        if (r12 < r1) goto L_0x003c;
    L_0x003a:
        r0 = 0;
        goto L_0x0017;
    L_0x003c:
        r1 = r11.charAt(r12);
        r2 = 47;
        if (r1 != r2) goto L_0x004e;
    L_0x0044:
        r1 = com.tencent.mm.modelsfs.g.a.PATHNAME;
        r1 = r13.contains(r1);
        if (r1 == 0) goto L_0x004e;
    L_0x004c:
        r0 = 0;
        goto L_0x0017;
    L_0x004e:
        r1 = a(r11, r12, r13);
        if (r1 == 0) goto L_0x0056;
    L_0x0054:
        r0 = 0;
        goto L_0x0017;
    L_0x0056:
        r12 = r12 + 1;
        r10 = r0;
        goto L_0x0000;
    L_0x005a:
        r0 = r9.length();
        if (r10 >= r0) goto L_0x006c;
    L_0x0060:
        r0 = r9.charAt(r10);
        r1 = 42;
        if (r0 != r1) goto L_0x006d;
    L_0x0068:
        r10 = r10 + 1;
        r1 = r0;
        goto L_0x005a;
    L_0x006c:
        r0 = r1;
    L_0x006d:
        r1 = a(r11, r12, r13);
        if (r1 == 0) goto L_0x0075;
    L_0x0073:
        r0 = 0;
        goto L_0x0017;
    L_0x0075:
        r1 = r9.length();
        if (r10 != r1) goto L_0x009b;
    L_0x007b:
        r0 = com.tencent.mm.modelsfs.g.a.PATHNAME;
        r0 = r13.contains(r0);
        if (r0 == 0) goto L_0x0098;
    L_0x0083:
        r0 = com.tencent.mm.modelsfs.g.a.LEADING_DIR;
        r0 = r13.contains(r0);
        if (r0 != 0) goto L_0x0094;
    L_0x008b:
        r0 = 47;
        r0 = r11.indexOf(r0, r12);
        r1 = -1;
        if (r0 != r1) goto L_0x0096;
    L_0x0094:
        r0 = 1;
        goto L_0x0017;
    L_0x0096:
        r0 = 0;
        goto L_0x0017;
    L_0x0098:
        r0 = 1;
        goto L_0x0017;
    L_0x009b:
        r1 = 47;
        if (r0 != r1) goto L_0x00c5;
    L_0x009f:
        r0 = com.tencent.mm.modelsfs.g.a.PATHNAME;
        r0 = r13.contains(r0);
        if (r0 == 0) goto L_0x00c5;
    L_0x00a7:
        r0 = 47;
        r12 = r11.indexOf(r0, r12);
        r0 = -1;
        if (r12 != r0) goto L_0x0000;
    L_0x00b0:
        r0 = 0;
        goto L_0x0017;
    L_0x00b3:
        r0 = r11.charAt(r12);
        r1 = 47;
        if (r0 != r1) goto L_0x00c3;
    L_0x00bb:
        r0 = com.tencent.mm.modelsfs.g.a.PATHNAME;
        r0 = r13.contains(r0);
        if (r0 != 0) goto L_0x00e5;
    L_0x00c3:
        r12 = r12 + 1;
    L_0x00c5:
        r0 = r11.length();
        if (r12 >= r0) goto L_0x00e5;
    L_0x00cb:
        r0 = com.tencent.mm.modelsfs.g.a.PERIOD;
        r0 = r13.contains(r0);
        if (r0 == 0) goto L_0x00dc;
    L_0x00d3:
        r13 = java.util.EnumSet.copyOf(r13);
        r0 = com.tencent.mm.modelsfs.g.a.PERIOD;
        r13.remove(r0);
    L_0x00dc:
        r0 = a(r9, r10, r11, r12, r13);
        if (r0 == 0) goto L_0x00b3;
    L_0x00e2:
        r0 = 1;
        goto L_0x0017;
    L_0x00e5:
        r0 = 0;
        goto L_0x0017;
    L_0x00e8:
        r2 = r11.length();
        if (r12 < r2) goto L_0x00f1;
    L_0x00ee:
        r0 = 0;
        goto L_0x0017;
    L_0x00f1:
        r2 = r11.charAt(r12);
        r3 = 47;
        if (r2 != r3) goto L_0x0104;
    L_0x00f9:
        r2 = com.tencent.mm.modelsfs.g.a.PATHNAME;
        r2 = r13.contains(r2);
        if (r2 == 0) goto L_0x0104;
    L_0x0101:
        r0 = 0;
        goto L_0x0017;
    L_0x0104:
        r2 = a(r11, r12, r13);
        if (r2 == 0) goto L_0x010d;
    L_0x010a:
        r0 = 0;
        goto L_0x0017;
    L_0x010d:
        r3 = r11.charAt(r12);
        r2 = r9.length();
        if (r0 < r2) goto L_0x0120;
    L_0x0117:
        r10 = -1;
    L_0x0118:
        r2 = -1;
        if (r10 == r2) goto L_0x002b;
    L_0x011b:
        if (r10 != 0) goto L_0x01d7;
    L_0x011d:
        r0 = 0;
        goto L_0x0017;
    L_0x0120:
        r2 = r9.charAt(r0);
        r4 = 33;
        if (r2 == r4) goto L_0x012c;
    L_0x0128:
        r4 = 94;
        if (r2 != r4) goto L_0x0148;
    L_0x012c:
        r2 = 1;
        r8 = r2;
    L_0x012e:
        if (r8 == 0) goto L_0x0220;
    L_0x0130:
        r2 = r0 + 1;
    L_0x0132:
        r4 = com.tencent.mm.modelsfs.g.a.CASEFOLD;
        r4 = r13.contains(r4);
        if (r4 == 0) goto L_0x013e;
    L_0x013a:
        r3 = java.lang.Character.toLowerCase(r3);
    L_0x013e:
        r4 = 0;
        r5 = r2;
    L_0x0140:
        r2 = r9.length();
        if (r5 < r2) goto L_0x014b;
    L_0x0146:
        r10 = -1;
        goto L_0x0118;
    L_0x0148:
        r2 = 0;
        r8 = r2;
        goto L_0x012e;
    L_0x014b:
        r10 = r5 + 1;
        r2 = r9.charAt(r5);
        r5 = 93;
        if (r2 == r5) goto L_0x01d2;
    L_0x0155:
        r5 = 92;
        if (r2 != r5) goto L_0x021d;
    L_0x0159:
        r5 = com.tencent.mm.modelsfs.g.a.NOESCAPE;
        r5 = r13.contains(r5);
        if (r5 != 0) goto L_0x021d;
    L_0x0161:
        r5 = r10 + 1;
        r2 = r9.charAt(r10);
    L_0x0167:
        r6 = 47;
        if (r2 != r6) goto L_0x0175;
    L_0x016b:
        r6 = com.tencent.mm.modelsfs.g.a.PATHNAME;
        r6 = r13.contains(r6);
        if (r6 == 0) goto L_0x0175;
    L_0x0173:
        r10 = 0;
        goto L_0x0118;
    L_0x0175:
        r6 = com.tencent.mm.modelsfs.g.a.CASEFOLD;
        r6 = r13.contains(r6);
        if (r6 == 0) goto L_0x0181;
    L_0x017d:
        r2 = java.lang.Character.toLowerCase(r2);
    L_0x0181:
        r6 = r9.charAt(r5);
        r7 = 45;
        if (r6 != r7) goto L_0x01cc;
    L_0x0189:
        r6 = r5 + 1;
        r7 = r9.length();
        if (r6 >= r7) goto L_0x01cc;
    L_0x0191:
        r6 = r5 + 1;
        r7 = r9.charAt(r6);
        r6 = 93;
        if (r7 == r6) goto L_0x01cc;
    L_0x019b:
        r6 = r5 + 2;
        r5 = 92;
        if (r7 != r5) goto L_0x021b;
    L_0x01a1:
        r5 = com.tencent.mm.modelsfs.g.a.NOESCAPE;
        r5 = r13.contains(r5);
        if (r5 != 0) goto L_0x021b;
    L_0x01a9:
        r2 = r9.length();
        if (r6 < r2) goto L_0x01b2;
    L_0x01af:
        r10 = -1;
        goto L_0x0118;
    L_0x01b2:
        r5 = r6 + 1;
        r2 = r9.charAt(r6);
    L_0x01b8:
        r6 = com.tencent.mm.modelsfs.g.a.CASEFOLD;
        r6 = r13.contains(r6);
        if (r6 == 0) goto L_0x0219;
    L_0x01c0:
        r6 = java.lang.Character.toLowerCase(r7);
    L_0x01c4:
        if (r2 > r3) goto L_0x0140;
    L_0x01c6:
        if (r3 > r6) goto L_0x0140;
    L_0x01c8:
        r2 = 1;
        r4 = r2;
        goto L_0x0140;
    L_0x01cc:
        if (r2 != r3) goto L_0x0140;
    L_0x01ce:
        r2 = 1;
        r4 = r2;
        goto L_0x0140;
    L_0x01d2:
        if (r4 != r8) goto L_0x0118;
    L_0x01d4:
        r10 = 0;
        goto L_0x0118;
    L_0x01d7:
        r12 = r12 + 1;
        goto L_0x0000;
    L_0x01db:
        r2 = com.tencent.mm.modelsfs.g.a.NOESCAPE;
        r2 = r13.contains(r2);
        if (r2 != 0) goto L_0x002b;
    L_0x01e3:
        r1 = r9.length();
        if (r0 < r1) goto L_0x01ee;
    L_0x01e9:
        r1 = 92;
        r10 = r0;
        goto L_0x002c;
    L_0x01ee:
        r10 = r0 + 1;
        r1 = r9.charAt(r0);
        goto L_0x002c;
    L_0x01f6:
        r0 = r11.charAt(r12);
        if (r1 == r0) goto L_0x0215;
    L_0x01fc:
        r0 = com.tencent.mm.modelsfs.g.a.CASEFOLD;
        r0 = r13.contains(r0);
        if (r0 == 0) goto L_0x0212;
    L_0x0204:
        r0 = java.lang.Character.toLowerCase(r1);
        r1 = r11.charAt(r12);
        r1 = java.lang.Character.toLowerCase(r1);
        if (r0 == r1) goto L_0x0215;
    L_0x0212:
        r0 = 0;
        goto L_0x0017;
    L_0x0215:
        r12 = r12 + 1;
        goto L_0x0000;
    L_0x0219:
        r6 = r7;
        goto L_0x01c4;
    L_0x021b:
        r5 = r6;
        goto L_0x01b8;
    L_0x021d:
        r5 = r10;
        goto L_0x0167;
    L_0x0220:
        r2 = r0;
        goto L_0x0132;
    L_0x0223:
        r10 = r0;
        goto L_0x005a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelsfs.g.a(java.lang.String, int, java.lang.String, int, java.util.EnumSet):boolean");
    }

    private static boolean a(String str, int i, EnumSet<a> enumSet) {
        if (i > str.length() - 1) {
            return false;
        }
        if ((i == 0 || (enumSet.contains(a.PATHNAME) && str.charAt(i - 1) == '/')) && str.charAt(i) == '.' && enumSet.contains(a.PERIOD)) {
            return true;
        }
        return false;
    }
}
