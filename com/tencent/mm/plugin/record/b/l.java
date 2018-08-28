package com.tencent.mm.plugin.record.b;

import com.tencent.mm.g.a.ch;
import com.tencent.mm.g.a.mw;
import com.tencent.mm.pluginsdk.model.g;
import com.tencent.mm.protocal.b.a.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class l extends c<mw> {
    public l() {
        this.sFo = mw.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        mw mwVar = (mw) bVar;
        x.i("MicroMsg.RecordOperationListener", "on record operation listener, %d", new Object[]{Integer.valueOf(mwVar.bXL.type)});
        switch (mwVar.bXL.type) {
            case 0:
                mwVar.bXM.bXV = h.Ks(mwVar.bXL.bXN);
                break;
            case 1:
                x.i("MicroMsg.RecordOperationListener", "get record paths, msg id %d", new Object[]{Long.valueOf(mwVar.bXL.bJC)});
                mwVar.bXM.bXX = h.d(mwVar.bXL.bOz, mwVar.bXL.bJC);
                mwVar.bXM.bXW = h.c(mwVar.bXL.bOz, mwVar.bXL.bJC);
                mwVar.bXM.bXY = h.e(mwVar.bXL.bOz, mwVar.bXL.bJC);
                mwVar.bXM.bOX = h.f(mwVar.bXL.bOz, mwVar.bXL.bJC);
                break;
            case 2:
                x.i("MicroMsg.RecordOperationListener", "send record msg, to %s, thumbPath %s, thumbId %s", new Object[]{mwVar.bXL.toUser, mwVar.bXL.bOX, Integer.valueOf(mwVar.bXL.bXP)});
                h.a(mwVar.bXL.toUser, mwVar.bXL.bXO, mwVar.bXL.title, mwVar.bXL.desc, mwVar.bXL.bOX, mwVar.bXL.bXP, mwVar.bXL.bXT);
                break;
            case 3:
                x.i("MicroMsg.RecordOperationListener", "clear resouces, msg id %d", new Object[]{Long.valueOf(mwVar.bXL.bJC)});
                h.eq(mwVar.bXL.bJC);
                break;
            case 4:
                x.i("MicroMsg.RecordOperationListener", "forward record msg, to %s, msg id %d", new Object[]{mwVar.bXL.toUser, Long.valueOf(mwVar.bXL.bXQ.field_msgId)});
                h.a(mwVar.bXL.toUser, mwVar.bXL.bOR, mwVar.bXL.bXQ);
                break;
            case 5:
                x.i("MicroMsg.RecordOperationListener", "summerrecord forward multi record msg, to %s", new Object[]{mwVar.bXL.toUser});
                h.a(mwVar.bXL.context, mwVar.bXL.toUser, mwVar.bXL.bXS, mwVar.bXL.bXR, mwVar.bXL.bXn, mwVar.bXL.bXU);
                break;
            case 6:
                ch chVar = new ch();
                g.a(mwVar.bXL.context, chVar, mwVar.bXL.bXS, mwVar.bXL.bXR, true, true);
                d a = h.a(mwVar.bXL.context, chVar, mwVar.bXL.bXS);
                mwVar.bXM.bXn = chVar;
                mwVar.bXM.bXU = a;
                break;
            case 8:
                if (!bi.oW(mwVar.bXL.bOX)) {
                    h.c(mwVar.bXL.bOz, mwVar.bXL.bJC, true);
                    break;
                }
                h.b(mwVar.bXL.bOz, mwVar.bXL.bJC, true);
                break;
            case 9:
                mwVar.bXM.bXX = h.g(mwVar.bXL.bOz, mwVar.bXL.bJC);
                break;
        }
        return false;
    }
}
