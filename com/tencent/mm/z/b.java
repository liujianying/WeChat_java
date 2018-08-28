package com.tencent.mm.z;

import com.tencent.mm.g.a.s;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;

public final class b {
    public static String Km() {
        return "audio" + ac.ce(System.nanoTime());
    }

    public static boolean jD(String str) {
        s sVar = new s();
        sVar.bGU.action = 7;
        sVar.bGU.bGW = str;
        a.sFg.m(sVar);
        return sVar.bGV.bGZ;
    }

    public static a jE(String str) {
        s sVar = new s();
        sVar.bGU.action = 16;
        sVar.bGU.bGW = str;
        a.sFg.m(sVar);
        return sVar.bGU.bGY;
    }
}
