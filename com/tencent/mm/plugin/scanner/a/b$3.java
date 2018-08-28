package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.g.a.aj;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class b$3 extends c<aj> {
    final /* synthetic */ b mFK;

    b$3(b bVar) {
        this.mFK = bVar;
        this.sFo = aj.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        aj ajVar = (aj) bVar;
        if (ajVar == null || !(ajVar instanceof aj)) {
            x.e("MicroMsg.ExternRequestDealQBarStrHandler", "event is null or not a CancelDealQBarStrEvent instance");
        } else {
            x.i("MicroMsg.ExternRequestDealQBarStrHandler", "cancel deal qbar, activity:%s, str:%s", new Object[]{this.mFK.mActivity, this.mFK.mFE});
            if (ajVar.bHK.activity == this.mFK.mActivity && ajVar.bHK.bHL.equals(this.mFK.mFE)) {
                this.mFK.bsa();
            } else {
                x.e("MicroMsg.ExternRequestDealQBarStrHandler", "not same as string that are dealing");
            }
        }
        return false;
    }
}
