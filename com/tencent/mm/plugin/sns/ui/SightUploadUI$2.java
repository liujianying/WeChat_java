package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.pn;
import com.tencent.mm.ui.widget.MMEditText.a;

class SightUploadUI$2 implements a {
    final /* synthetic */ SightUploadUI nRw;

    SightUploadUI$2(SightUploadUI sightUploadUI) {
        this.nRw = sightUploadUI;
    }

    public final void bbt() {
        this.nRw.YC();
        pn pnVar = new pn();
        pnVar.cap.type = 0;
        pnVar.cap.car = false;
        com.tencent.mm.sdk.b.a.sFg.m(pnVar);
        this.nRw.finish();
    }
}
