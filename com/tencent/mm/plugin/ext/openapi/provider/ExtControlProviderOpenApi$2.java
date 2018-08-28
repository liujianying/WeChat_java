package com.tencent.mm.plugin.ext.openapi.provider;

import com.tencent.mm.g.a.ew;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class ExtControlProviderOpenApi$2 extends bd<Integer> {
    final /* synthetic */ String[] dhB;
    final /* synthetic */ ExtControlProviderOpenApi iJG;

    ExtControlProviderOpenApi$2(ExtControlProviderOpenApi extControlProviderOpenApi, String[] strArr) {
        this.iJG = extControlProviderOpenApi;
        this.dhB = strArr;
        super(20000, null);
    }

    private Integer UH() {
        try {
            x.d("MicroMsg.ExtControlProviderOpenApi", "syncTaskCur run ");
            final ew ewVar = new ew();
            ewVar.bMD.version = bi.getInt(this.dhB[0], 0);
            ewVar.bMD.ssid = this.dhB[1];
            ewVar.bMD.bssid = this.dhB[2];
            ewVar.bMD.bMF = bi.getInt(this.dhB[3], 0);
            ewVar.bJX = new Runnable() {
                public final void run() {
                    x.i("MicroMsg.ExtControlProviderOpenApi", "connectWifi run");
                    if (ewVar != null && ewVar.bME != null && ewVar.bME.bMG != 0) {
                        x.i("MicroMsg.ExtControlProviderOpenApi", "connectWifi errcode = %s,errmsg = %s", new Object[]{Integer.valueOf(ewVar.bME.bMH), ewVar.bME.bMI});
                        ExtControlProviderOpenApi$2.this.cf(Integer.valueOf(ewVar.bME.bMH));
                    }
                }
            };
            if (!a.sFg.m(ewVar)) {
                x.i("MicroMsg.ExtControlProviderOpenApi", "connectWifi publish getWifiListEvent fail");
                cf(Integer.valueOf(8));
            }
        } catch (Exception e) {
            x.e("MicroMsg.ExtControlProviderOpenApi", "exception in connectWifi syncTaskInt.", new Object[]{e});
            cf(Integer.valueOf(12));
        }
        return Integer.valueOf(0);
    }
}
