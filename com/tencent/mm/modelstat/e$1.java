package com.tencent.mm.modelstat;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.util.Pair;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.mm.a.o;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelstat.e.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class e$1 implements Runnable {
    final /* synthetic */ int eeg;
    final /* synthetic */ boolean eiZ;
    final /* synthetic */ float eja;
    final /* synthetic */ float ejb;
    final /* synthetic */ boolean ejc;
    final /* synthetic */ int ejd;
    final /* synthetic */ e eje;

    e$1(e eVar, boolean z, float f, float f2, int i, boolean z2, int i2) {
        this.eje = eVar;
        this.eiZ = z;
        this.eja = f;
        this.ejb = f2;
        this.eeg = i;
        this.ejc = z2;
        this.ejd = i2;
    }

    public final void run() {
        try {
            if (g.Eg().Dx()) {
                g.Eg();
                if (!a.Dr()) {
                    long VF = bi.VF();
                    if (e.a(this.eje) == 0 || VF - e.a(this.eje) >= 1800000) {
                        List b;
                        Pair pair;
                        if (this.eiZ) {
                            b = e.b(this.eje);
                        } else {
                            Object b2 = e.c(this.eje);
                        }
                        int i = 0;
                        while (i < b2.size()) {
                            if (e.z(this.eja, ((Float) ((Pair) b2.get(i)).first).floatValue()) && e.z(this.ejb, ((Float) ((Pair) b2.get(i)).second).floatValue())) {
                                pair = (Pair) b2.get(i);
                                break;
                            }
                            i++;
                        }
                        pair = null;
                        if (pair == null) {
                            x.d("MicroMsg.IndoorReporter", "Ignore this report, no hit any Point");
                            return;
                        }
                        int i2;
                        e.a(this.eje, VF);
                        StringBuilder stringBuilder = new StringBuilder();
                        g.Eg();
                        String stringBuilder2 = stringBuilder.append(new o(a.Df()).toString()).append("_").append(e.a(this.eje)).toString();
                        StringBuilder append = new StringBuilder().append(pair.first).append(",").append(pair.second).append(",").append(this.eeg).append(",");
                        int i3 = this.ejc ? 1 : 2;
                        if (this.eiZ) {
                            i2 = 10;
                        } else {
                            i2 = 20;
                        }
                        String stringBuilder3 = append.append(i2 + i3).append(",").append(this.eja).append(",").append(this.ejb).append(",0,").append(this.ejd).append(",").append(e.a(this.eje)).append(",").toString();
                        e$c e_c = new e$c(this.eje);
                        Context context = ad.getContext();
                        i3 = e.d(this.eje);
                        int e = e.e(this.eje);
                        if (e_c.bnh == null) {
                            e_c.bnh = (WifiManager) context.getSystemService(TencentLocationListener.WIFI);
                        }
                        e_c.ejy = i3;
                        e_c.eiW = e;
                        e_c.startTime = bi.VF();
                        e_c.ejz = true;
                        e_c.thread.start();
                        b bVar = new b(this.eje);
                        if (bVar.u(ad.getContext(), e.f(this.eje))) {
                            g.Ek();
                            new al(g.Em().lnJ.getLooper(), new 1(this, bVar, e_c, stringBuilder3, stringBuilder2), true).J(3000, 3000);
                            return;
                        }
                        x.e("MicroMsg.IndoorReporter", "Ignore this report. Error:start wifi:%b sensor:%b  ", new Object[]{Boolean.valueOf(true), Boolean.valueOf(bVar.u(ad.getContext(), e.f(this.eje)))});
                        bVar.RX();
                        e_c.RX();
                        h.mEJ.k(13381, stringBuilder3 + stringBuilder2 + ",-10002,ERROR:StartFailed.");
                        return;
                    }
                    x.e("MicroMsg.IndoorReporter", "Ignore this Report,Another Report is Running & not timeout:%d.", new Object[]{Long.valueOf(VF - e.a(this.eje))});
                }
            }
        } catch (Exception e2) {
            x.e("MicroMsg.IndoorReporter", "reprot Start exception:%s", new Object[]{e2.getMessage()});
        }
    }
}
