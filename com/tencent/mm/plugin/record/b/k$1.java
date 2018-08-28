package com.tencent.mm.plugin.record.b;

import android.os.SystemClock;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.record.a.g;
import com.tencent.mm.plugin.record.b.k.a;
import com.tencent.mm.plugin.record.b.k.d;
import com.tencent.mm.plugin.record.b.k.e;
import com.tencent.mm.sdk.platformtools.x;

class k$1 implements Runnable {
    final /* synthetic */ g msj;
    final /* synthetic */ k msk;

    k$1(k kVar, g gVar) {
        this.msk = kVar;
        this.msj = gVar;
    }

    public final void run() {
        if (this.msj != null) {
            if (((e) this.msk.mrR.get(this.msj.field_localId)) == null) {
                x.d("MicroMsg.RecordMsgSendService", "summerrecord do add job, localid %d, msgid %d", new Object[]{Integer.valueOf(this.msj.field_localId), Long.valueOf(this.msj.field_msgId)});
                this.msk.mrR.put(this.msj.field_localId, new e((byte) 0));
            }
            this.msk.b(this.msj);
        }
        k kVar = this.msk;
        if (kVar.mrO) {
            x.d("MicroMsg.RecordMsgSendService", "summerrecord is working, return");
            return;
        }
        g gVar;
        e eVar;
        if (kVar.mrS.isEmpty()) {
            x.w("MicroMsg.RecordMsgSendService", "summerrecord jobs list size is 0");
            for (g gVar2 : n.bqv().bqq()) {
                au.HU();
                if (c.FT().dW(gVar2.field_msgId).getType() != 49) {
                    x.w("MicroMsg.RecordMsgSendService", "summerrecord record msg not exist, delete record info, localid[%d], msgid[%d]", new Object[]{Integer.valueOf(gVar2.field_localId), Long.valueOf(gVar2.field_msgId)});
                    n.bqv().vl(gVar2.field_localId);
                } else {
                    eVar = (e) kVar.mrR.get(gVar2.field_localId);
                    if (eVar == null) {
                        kVar.mrR.put(gVar2.field_localId, new e((byte) 0));
                    } else if (eVar.ewn >= 0 || SystemClock.elapsedRealtime() - eVar.mrV >= 300000) {
                        if (eVar.ewn < 0) {
                            eVar.ewn = 3;
                        }
                    }
                    x.d("MicroMsg.RecordMsgSendService", "summerrecord do add job from db, localid %d, msgid %d", new Object[]{Integer.valueOf(gVar2.field_localId), Long.valueOf(gVar2.field_msgId)});
                    kVar.b(gVar2);
                }
            }
        }
        if (kVar.mrS.isEmpty()) {
            x.w("MicroMsg.RecordMsgSendService", "try to do job, but job list size is empty, return");
            kVar.finish();
            return;
        }
        boolean z;
        gVar2 = (g) kVar.mrS.removeFirst();
        eVar = (e) kVar.mrR.get(gVar2.field_localId);
        if (eVar == null) {
            eVar = new e((byte) 0);
            kVar.mrR.put(gVar2.field_localId, eVar);
        }
        eVar.ewn--;
        if (eVar.ewn < 0) {
            if (300000 > SystemClock.elapsedRealtime() - eVar.mrV) {
                z = false;
                if (z) {
                    kVar.a(null);
                    return;
                }
                kVar.mrO = true;
                switch (gVar2.field_type) {
                    case 0:
                        com.tencent.mm.sdk.f.e.post(new d(kVar, gVar2), "RecordMsgSendService_normalDataCopy");
                        return;
                    case 1:
                        com.tencent.mm.sdk.f.e.post(new k.c(kVar, gVar2), "RecordMsgSendService_favDataCopy");
                        return;
                    case 2:
                        com.tencent.mm.sdk.f.e.post(new a(kVar, gVar2), "RecordMsgSendService_chatDataCopy");
                        return;
                    case 3:
                        com.tencent.mm.sdk.f.e.post(new k$b(kVar, gVar2), "RecordMsgSendService_chatDataDownLoad");
                        return;
                    default:
                        kVar.mrO = false;
                        return;
                }
            }
            eVar.ewn = 2;
        }
        eVar.mrV = SystemClock.elapsedRealtime();
        z = true;
        if (z) {
            kVar.a(null);
            return;
        }
        kVar.mrO = true;
        switch (gVar2.field_type) {
            case 0:
                com.tencent.mm.sdk.f.e.post(new d(kVar, gVar2), "RecordMsgSendService_normalDataCopy");
                return;
            case 1:
                com.tencent.mm.sdk.f.e.post(new k.c(kVar, gVar2), "RecordMsgSendService_favDataCopy");
                return;
            case 2:
                com.tencent.mm.sdk.f.e.post(new a(kVar, gVar2), "RecordMsgSendService_chatDataCopy");
                return;
            case 3:
                com.tencent.mm.sdk.f.e.post(new k$b(kVar, gVar2), "RecordMsgSendService_chatDataDownLoad");
                return;
            default:
                kVar.mrO = false;
                return;
        }
    }

    public final String toString() {
        return super.toString() + "|run";
    }
}
