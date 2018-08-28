package com.tencent.mm.plugin.gai;

import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.gai.Plugin.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

class Plugin$1 implements a {
    final /* synthetic */ Plugin jAa;

    Plugin$1(Plugin plugin) {
        this.jAa = plugin;
    }

    public final void CP(String str) {
        ad.getContext().getSharedPreferences(ad.chY() + "_google_aid", 4).edit().putString("getgoogleaid", str).commit();
        String deviceID = q.getDeviceID(ad.getContext());
        String androidId = q.getAndroidId();
        String zB = q.zB();
        String string = ad.getContext().getSharedPreferences(ad.chY(), 0).getString("installreferer", "");
        x.i("MicroMsg.Plugin.gai", "Advertisement MAT rsakv logID:%d val:%s", new Object[]{Integer.valueOf(11238), String.format("%s,%s,%s,%s,%s,%s", new Object[]{"", deviceID, androidId, zB, str, string})});
        h.mEJ.a(11238, r0, true, true);
        ad.getContext().getSharedPreferences(ad.chY() + "_google_aid", 4).edit().putBoolean("already_report_googleaid", true).commit();
    }
}
