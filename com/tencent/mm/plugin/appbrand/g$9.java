package com.tencent.mm.plugin.appbrand;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.a;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

class g$9 extends a {
    final /* synthetic */ g fdd;
    private boolean fdf = false;

    g$9(g gVar) {
        this.fdd = gVar;
    }

    public final void aay() {
        if (this.fdf) {
            g gVar = this.fdd;
            x.i("MicroMsg.AppBrandRuntime", "onReconnected: %s", new Object[]{gVar.mAppId});
            gVar.fcF.aM(gVar.mAppId, gVar.fct.fig);
            MMToClientEvent.tg(gVar.mAppId);
            e.qk(gVar.mAppId);
            if (!(gVar.dti || gVar.fcU)) {
                x.e("MicroMsg.AppBrandRuntime", "Main Process Restarted, start prepare again");
                gVar.aas();
            }
        }
        this.fdf = false;
    }

    public final void aaz() {
        this.fdf = true;
        long j = this.fdd.fcF.gtu;
        SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(ad.getContext(), "pref_appbrand_process", 4);
        Editor edit = sharedPreferences.edit();
        if (sharedPreferences.getLong("on_wxa_process_connected_time", 0) == j) {
            edit.remove("on_wxa_process_connected_time");
            edit.commit();
            f.mDy.a(365, 1, 1, false);
            x.v("MicroMsg.AppBrandReporter", "delete timestamp(%s) and report(%d)", new Object[]{Long.valueOf(j), Integer.valueOf(365)});
            return;
        }
        x.v("MicroMsg.AppBrandReporter", "do not need to report(%d), timestamp(cur : %s, sp : %s)", new Object[]{Long.valueOf(j), Integer.valueOf(365), Long.valueOf(j), Long.valueOf(sharedPreferences.getLong("on_wxa_process_connected_time", 0))});
    }
}
