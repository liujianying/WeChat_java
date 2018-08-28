package com.tencent.mm.modelappbrand;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    public static String dFw;
    public static String dFx;

    public static String JK() {
        StringBuilder stringBuilder = new StringBuilder("sid_");
        g.Eg();
        dFw = stringBuilder.append(a.Df()).append("_").append(bi.VF()).toString();
        x.v("MicroMsg.AppBrandReporter", "refreshWeAppSearchSessionId : %s", new Object[]{dFw});
        return dFw;
    }

    public static void ji(String str) {
        SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(ad.getContext(), "pref_appbrand_process", 4);
        String str2 = str + ":start_time";
        Editor edit = sharedPreferences.edit();
        edit.remove(str2);
        edit.commit();
        f.mDy.a(365, 5, 1, false);
        x.v("MicroMsg.AppBrandReporter", "onProcessExit");
    }
}
