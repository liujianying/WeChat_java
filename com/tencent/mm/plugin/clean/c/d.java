package com.tencent.mm.plugin.clean.c;

import com.tencent.mm.plugin.clean.c.a.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashSet;

public final class d {
    private static long hQD = 0;
    private static long hQE = 0;
    private static b hQO;
    private static long hQT = 0;
    private static long hQU = 0;
    private static final ag hRc = new ag();
    private static HashSet<String> hRd;
    private static ArrayList<b> hRe;
    private static int hRf = 0;

    public static void a(b bVar) {
        hQO = bVar;
    }

    public static b aBg() {
        boolean z = true;
        String str = "MicroMsg.CleanLogic";
        String str2 = "getThreadController threadController is null? %b";
        Object[] objArr = new Object[1];
        if (hQO != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.d(str, str2, objArr);
        return hQO;
    }

    public static void b(HashSet<String> hashSet) {
        hRd = hashSet;
    }

    public static HashSet<String> aBh() {
        return hRd;
    }

    public static void m(ArrayList<b> arrayList) {
        boolean z = true;
        String str = "MicroMsg.CleanLogic";
        String str2 = "set analyse data: is null? %b";
        Object[] objArr = new Object[1];
        if (arrayList != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        hRe = arrayList;
    }

    public static ArrayList<b> aBi() {
        return hRe;
    }

    public static void cf(long j) {
        hQU = j;
    }

    public static long aBj() {
        return hQU;
    }

    public static void cg(long j) {
        hQD = j;
    }

    public static long aBk() {
        return hQD;
    }

    public static void ch(long j) {
        if (j <= 0) {
            j = 0;
        }
        hQE = j;
    }

    public static long aBl() {
        return hQE;
    }

    public static void ci(long j) {
        hQT = j;
    }

    public static long aBm() {
        return hQT;
    }

    public static final void aBn() {
        x.i("MicroMsg.CleanLogic", "startCleanDataNow");
        hRc.removeCallbacksAndMessages(null);
        hQU = 0;
        hQT = 0;
        m(null);
        hRf = 0;
    }

    public static final void aBo() {
        x.i("MicroMsg.CleanLogic", "start to post clean runnable!!");
        hRc.removeCallbacksAndMessages(null);
        hRc.postDelayed(new 1(), 300000);
    }

    public static final void aBp() {
        hRf++;
    }

    public static final void aBq() {
        hRf--;
    }
}
