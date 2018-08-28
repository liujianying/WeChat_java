package com.tencent.mm.plugin.c;

import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;

public final class a {
    public static void pT(String str) {
        ad.getContext().getSharedPreferences(ad.chY(), 0).edit().putString("reg_last_exit_ui", str).commit();
    }

    public static String Zu() {
        return ad.getContext().getSharedPreferences(ad.chY(), 0).getString("reg_last_exit_ui", "");
    }

    public static void pU(String str) {
        ad.getContext().getSharedPreferences(ad.chY(), 0).edit().putString("reg_next_enter_ui", str).commit();
    }

    public static void pV(String str) {
        f.mDy.a(10645, str + "," + bi.VF() + "," + Zu(), true, true);
    }

    public static void d(boolean z, String str) {
        String str2;
        if (z) {
            str2 = str + "," + bi.VF() + "," + Zu();
        } else {
            str2 = str + "," + bi.VF() + "," + ad.getContext().getSharedPreferences(ad.chY(), 0).getString("reg_next_enter_ui", "");
        }
        f.mDy.a(10645, str2, true, true);
    }
}
