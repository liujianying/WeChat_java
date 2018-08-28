package com.tencent.mm.modelvoiceaddr.ui;

import com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements a {
    final /* synthetic */ b erM;

    b$1(b bVar) {
        this.erM = bVar;
    }

    public final void Ul() {
        if (!com.tencent.mm.p.a.by(ad.getContext()) && !com.tencent.mm.p.a.bw(ad.getContext())) {
            x.d("MicroMsg.VoiceSearchViewHelper", "on voice search start");
            h.mEJ.h(10453, new Object[]{Integer.valueOf(this.erM.erH), Integer.valueOf(3)});
            if (this.erM.erJ != null) {
                this.erM.erJ.Uq();
            }
        }
    }

    public final void Um() {
        x.d("MicroMsg.VoiceSearchViewHelper", "on voice search cancel");
        h.mEJ.h(10453, new Object[]{Integer.valueOf(this.erM.erH), Integer.valueOf(4)});
        if (this.erM.uBv != null) {
            this.erM.uBv.setEditTextEnabled(true);
            this.erM.uBv.setStatusBtnEnabled(true);
        }
        if (this.erM.erJ != null) {
            this.erM.erJ.Ur();
        }
    }

    public final void a(boolean z, String[] strArr, long j) {
        x.d("MicroMsg.VoiceSearchViewHelper", "on voice search return, success %B, voice id %d", new Object[]{Boolean.valueOf(z), Long.valueOf(j)});
        if (this.erM.erJ != null) {
            this.erM.erJ.a(z, strArr, j, this.erM.erI);
        }
    }
}
