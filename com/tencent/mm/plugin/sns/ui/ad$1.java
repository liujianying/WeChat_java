package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.pn;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class ad$1 extends c<pn> {
    final /* synthetic */ ad nPa;

    ad$1(ad adVar) {
        this.nPa = adVar;
        this.sFo = pn.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        pn pnVar = (pn) bVar;
        x.i("MicroMsg.SightWidget", "on sight send result callback, type %d", new Object[]{Integer.valueOf(pnVar.cap.type)});
        switch (pnVar.cap.type) {
            case 1:
                x.i("MicroMsg.SightWidget", "come event done");
                this.nPa.videoPath = pnVar.cap.videoPath;
                this.nPa.bKg = pnVar.cap.cas;
                if (this.nPa.eHw != null) {
                    this.nPa.eHw.dismiss();
                }
                if (pnVar.cap.car && this.nPa.nOW != null) {
                    ad.a(this.nPa);
                }
                x.i("MicroMsg.SightWidget", "mux finish %B videoPath %s %d md5 %s", new Object[]{Boolean.valueOf(pnVar.cap.car), pnVar.cap.videoPath, Long.valueOf(FileOp.mI(pnVar.cap.videoPath)), this.nPa.bKg});
                break;
        }
        return false;
    }
}
