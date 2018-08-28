package com.tencent.mm.compatible.i;

import android.content.SharedPreferences;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.e.u;
import com.tencent.mm.compatible.f.b;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    private static int dga = 0;

    public static boolean zX() {
        if (b.zU()) {
            boolean z;
            u uVar = q.deR;
            if (!ad.cic()) {
                uVar.dfp = MultiProcessSharedPreferences.getSharedPreferences(ad.getContext(), "system_config_prefs", 4).getInt("update_swip_back_status", 0);
            }
            if (uVar.dfp == 1) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return false;
            }
        }
        if (dga == 0) {
            SharedPreferences chZ = ad.chZ();
            if (chZ == null || !chZ.getBoolean("settings_support_swipe", true)) {
                dga = 2;
            } else {
                dga = 1;
            }
        }
        if (dga == 1) {
            return true;
        }
        return false;
    }

    public static void bf(boolean z) {
        SharedPreferences chZ = ad.chZ();
        if (chZ.getBoolean("settings_support_swipe", true) != z) {
            chZ.edit().putBoolean("settings_support_swipe", z).commit();
        }
        x.i("MicroMsg.StyleUtil", "switchSwipebackMode, from %B to %B", Boolean.valueOf(r1), Boolean.valueOf(z));
    }
}
