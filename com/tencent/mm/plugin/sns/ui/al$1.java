package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.pn;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class al$1 extends c<pn> {
    final /* synthetic */ al nRJ;

    al$1(al alVar) {
        this.nRJ = alVar;
        this.sFo = pn.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        pn pnVar = (pn) bVar;
        x.i("MicroMsg.SightWidget", "on sight send result callback, type %d", new Object[]{Integer.valueOf(pnVar.cap.type)});
        switch (pnVar.cap.type) {
            case 1:
                x.i("MicroMsg.SightWidget", "come event done");
                this.nRJ.videoPath = pnVar.cap.videoPath;
                this.nRJ.bKg = pnVar.cap.cas;
                if (this.nRJ.eHw != null) {
                    this.nRJ.eHw.dismiss();
                }
                this.nRJ.nRH.aO(this.nRJ.videoPath, false);
                this.nRJ.eVR.setVisibility(8);
                if (pnVar.cap.car && this.nRJ.nOW != null) {
                    this.nRJ.bCC();
                }
                x.i("MicroMsg.SightWidget", "mux finish %B videoPath %s %d md5 %s", new Object[]{Boolean.valueOf(pnVar.cap.car), pnVar.cap.videoPath, Long.valueOf(FileOp.mI(pnVar.cap.videoPath)), this.nRJ.bKg});
                break;
        }
        return false;
    }
}
