package com.tencent.mm.av;

import com.tencent.map.swlocation.api.SwEngine;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;

class b$1 implements Runnable {
    final /* synthetic */ int eed;
    final /* synthetic */ float eee;
    final /* synthetic */ float eef;
    final /* synthetic */ int eeg;
    final /* synthetic */ int eeh;
    final /* synthetic */ int eei = 0;
    final /* synthetic */ String eej;
    final /* synthetic */ String eek;
    final /* synthetic */ b eel;

    public b$1(b bVar, int i, float f, float f2, int i2, int i3, String str, String str2) {
        this.eel = bVar;
        this.eed = i;
        this.eee = f;
        this.eef = f2;
        this.eeg = i2;
        this.eeh = i3;
        this.eej = str;
        this.eek = str2;
    }

    public final void run() {
        if (b.a(this.eel)) {
            x.d("MicroMsg.SenseWhereHelper", "it is collection now, do not start sense where sdk.");
        } else if (b.b(this.eel)) {
            b.Qz();
            if (b.c(this.eel).size() == 0 && b.d(this.eel).size() == 0) {
                b.e(this.eel);
            }
            if (b.a(this.eel, this.eed, this.eee, this.eef)) {
                x.i("MicroMsg.SenseWhereHelper", "it begin to start sense where sdk to upload location info.[%d, %f, %f, %d]", new Object[]{Integer.valueOf(this.eed), Float.valueOf(this.eee), Float.valueOf(this.eef), Integer.valueOf(this.eeg)});
                b.a(this.eel, true);
                g.Ei().DT().a(a.sUd, Long.valueOf(bi.VE()));
                com.tencent.mm.sdk.b.a.sFg.b(b.f(this.eel));
                if (b.g(this.eel) != null) {
                    b.g(this.eel).finish();
                }
                b.h(this.eel);
                b.a(this.eel, bi.VG());
                b.a(this.eel, new c(this.eee, this.eef, this.eeh, this.eei, this.eej, this.eek, this.eed, this.eeg));
                SwEngine.setImei(b.QA());
                SwEngine.creatLocationEngine(ad.getContext(), b.g(this.eel));
                SwEngine.startContinousLocationUpdate(b.i(this.eel), this.eel.edR, this.eel.edS, b.j(this.eel), b.k(this.eel));
                b.QB();
                b.a(this.eel, this.eel.edT);
            }
        } else {
            x.d("MicroMsg.SenseWhereHelper", "it do not start sense where sdk by config.");
        }
    }
}
