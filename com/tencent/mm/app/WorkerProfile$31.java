package com.tencent.mm.app;

import com.tencent.mm.g.a.po;
import com.tencent.mm.model.au;
import com.tencent.mm.modelmulti.a;
import com.tencent.mm.plugin.bbom.r;
import com.tencent.mm.protocal.c.bz;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class WorkerProfile$31 extends c<po> {
    final /* synthetic */ WorkerProfile bzO;

    WorkerProfile$31(WorkerProfile workerProfile) {
        this.bzO = workerProfile;
        this.sFo = po.class.getName().hashCode();
    }

    private boolean a(po poVar) {
        byte[] bArr = poVar.cav.data;
        if (bArr != null) {
            x.i("MicroMsg.WorkerProfile", "summerbadcr SilenceNotifyEvent callback data len:%d", new Object[]{Integer.valueOf(bArr.length)});
            final bz bzVar = new bz();
            try {
                bzVar.aG(bArr);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WorkerProfile", e, "", new Object[0]);
                x.e("MicroMsg.WorkerProfile", "summerbadcr SilenceNotifyEvent callback parse exception:" + e.getMessage());
            }
            au.Em().H(new Runnable() {
                public final void run() {
                    if (au.HX()) {
                        x.i("MicroMsg.WorkerProfile", "summerbadcr SilenceNotifyEvent processAddMsgDigestList");
                        new a().a(bzVar, new r(true));
                    }
                }
            });
        }
        return false;
    }
}
