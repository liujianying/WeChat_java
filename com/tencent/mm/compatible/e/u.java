package com.tencent.mm.compatible.e;

import android.content.SharedPreferences.Editor;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class u {
    public static boolean dfm = false;
    public String dfn = "";
    Map<String, String> dfo = null;
    public int dfp = 0;

    public final void fP(int i) {
        this.dfp = i;
        dfm = true;
        Editor edit = MultiProcessSharedPreferences.getSharedPreferences(ad.getContext(), "system_config_prefs", 4).edit();
        edit.putInt("update_swip_back_status", i);
        edit.commit();
        x.v("MicroMsg.ManuFacturerInfo", "update mSwipBackStatus(%s)", Integer.valueOf(this.dfp));
    }

    public static boolean zP() {
        if (!dfm) {
            return false;
        }
        dfm = false;
        return true;
    }

    public final void fe(String str) {
        this.dfn = str;
    }

    public final void i(Map<String, String> map) {
        this.dfo = map;
    }
}
