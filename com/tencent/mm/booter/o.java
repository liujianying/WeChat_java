package com.tencent.mm.booter;

import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Process;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class o {
    static long cXy = 0;

    static /* synthetic */ void eE(String str) {
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences(str, 0);
        String[] split = sharedPreferences.getString("startup_info", "").split("=");
        if (split == null || split.length <= 1) {
            x.i("MicroMsg.ProcessReport", "nothing to reprot");
            return;
        }
        for (int i = 0; i < split.length - 1; i++) {
            x.i("MicroMsg.ProcessReport", "reprot %s: %s", new Object[]{str, split[i]});
            h.mEJ.k(10667, split[i]);
        }
        sharedPreferences.edit().putString("startup_info", split[split.length - 1]).commit();
    }

    public static void onCreate(boolean z) {
        if (z) {
            u("mm_proc_startup", 2);
        } else {
            u("push_proc_startup", 1);
        }
    }

    private static void u(String str, int i) {
        a aVar;
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences(str, 0);
        String[] split = sharedPreferences.getString("startup_info", "").split("=");
        if (split != null && split.length > 0) {
            aVar = new a();
            if (aVar.eF(split[split.length - 1])) {
                aVar.cXE = Process.myPid();
                split[split.length - 1] = aVar.toString();
            }
        }
        aVar = new a();
        aVar.cXA = i;
        aVar.cXC = Process.myPid();
        aVar.cXD = (int) bi.VE();
        String e = e(split);
        String aVar2 = aVar.toString();
        if (e.length() > 0) {
            aVar2 = e + "=" + aVar2;
        }
        x.d("MicroMsg.ProcessReport", "startProc new info %s", new Object[]{aVar2});
        sharedPreferences.edit().putString("startup_info", aVar2).commit();
    }

    public static void vr() {
        eD("mm_proc_startup");
        eD("push_proc_startup");
    }

    private static void eD(String str) {
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences(str, 0);
        String[] split = sharedPreferences.getString("startup_info", "").split("=");
        if (split != null && split.length != 0) {
            a aVar = new a();
            if (aVar.eF(split[split.length - 1])) {
                aVar.cXB = 2;
                split[split.length - 1] = aVar.toString();
            }
            x.d("MicroMsg.ProcessReport", "uerExit new info %s", new Object[]{e(split)});
            sharedPreferences.edit().putString("startup_info", r1).commit();
        }
    }

    public static void xP() {
        if (cXy == 0 || bi.bI(cXy) >= 3600000) {
            int intValue = ((Integer) au.HS().get(37, Integer.valueOf(0))).intValue();
            if (d.qVN != intValue) {
                au.HS().set(37, Integer.valueOf(d.qVN));
                new ag(Looper.getMainLooper()).post(new 1(intValue));
            }
            cXy = bi.VG();
            new ag(Looper.getMainLooper()).post(new 2());
        }
    }

    private static String e(String[] strArr) {
        String str = "";
        Object obj = 1;
        for (String str2 : strArr) {
            if (obj != null) {
                obj = null;
            } else {
                str = str + "=";
            }
            str = str + str2;
        }
        return str;
    }
}
