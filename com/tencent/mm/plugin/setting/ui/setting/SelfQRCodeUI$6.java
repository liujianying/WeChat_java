package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.ac.f;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

class SelfQRCodeUI$6 implements c {
    final /* synthetic */ SelfQRCodeUI mQy;

    SelfQRCodeUI$6(SelfQRCodeUI selfQRCodeUI) {
        this.mQy = selfQRCodeUI;
    }

    public final void a(l lVar) {
        boolean fq = s.fq(SelfQRCodeUI.c(this.mQy));
        boolean kM = f.kM(SelfQRCodeUI.c(this.mQy));
        if (!(kM || fq)) {
            lVar.eR(2, i.self_qrcode_change);
        }
        lVar.eR(1, i.self_qrcode_save);
        if (!kM) {
            lVar.eR(3, i.self_qrcode_to_scan);
        }
        if (SelfQRCodeUI.d(this.mQy)) {
            lVar.eR(4, i.self_qrcode_to_revoke);
        }
    }
}
