package com.tencent.mm.plugin.soter.c;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.d.a.a;
import com.tencent.d.a.c.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    public static c bFh() {
        SharedPreferences chZ = ad.chZ();
        if (chZ == null) {
            return new c();
        }
        String string = chZ.getString("cpu_id", "");
        String string2 = chZ.getString("uid", "");
        if (bi.oW(string) || bi.oW(string2)) {
            x.w("MicroMsg.SoterDeviceInfoManager", "hy: no cpu id and uid retrieved. load again");
            h cFE = a.cFE();
            if (cFE != null) {
                string = cFE.onE;
                string2 = String.valueOf(cFE.uid);
                if (!(bi.oW(string) || bi.oW(string2))) {
                    eQ(string, string2);
                    return new c(string, string2);
                }
            }
            return new c();
        }
        x.i("MicroMsg.SoterDeviceInfoManager", "hy:device info exists in preference. directly return");
        return new c(string, string2);
    }

    public static void eQ(String str, String str2) {
        SharedPreferences chZ = ad.chZ();
        if (chZ != null) {
            x.i("MicroMsg.SoterDeviceInfoManager", "hy: save device info");
            Editor edit = chZ.edit();
            edit.putString("cpu_id", str);
            edit.putString("uid", str2);
            edit.apply();
        }
    }
}
