package com.tencent.mm.plugin.sns;

import com.tencent.mm.g.a.hu;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends c<hu> {
    private n nhc;
    private String nhf;
    private bsu nhg;

    public f() {
        this.sFo = hu.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        hu huVar = (hu) bVar;
        if (huVar instanceof hu) {
            this.nhf = huVar.bRf.bKW;
            this.nhc = af.byo().Nl(this.nhf);
            this.nhg = this.nhc.bAJ();
            if (this.nhg != null) {
                huVar.bRg.bRh = this.nhg;
                return true;
            }
        }
        x.f("MicroMsg.GetSnsObjectDetailListener", "mismatched event");
        return false;
    }
}
