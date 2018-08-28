package com.tencent.mm.ak;

import com.tencent.mm.ak.n.a;
import com.tencent.mm.ak.n.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.x;

class n$a$1 implements Runnable {
    final /* synthetic */ e dWa;
    final /* synthetic */ a dWb;

    n$a$1(a aVar, e eVar) {
        this.dWb = aVar;
        this.dWa = eVar;
    }

    public final void run() {
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        a.a aVar = new a.a();
        aVar.dWc = new PString();
        aVar.dWd = new PString();
        aVar.dWe = new PString();
        aVar.dWf = new PString();
        aVar.dTV = o.Pf().a(this.dWa.dWk, FileOp.mO(this.dWa.dWk), this.dWa.dTO, true, aVar.dWc, aVar.dWd, aVar.dWe, aVar.dWf, this.dWa.dWm, this.dWa.dWr);
        a.a(this.dWb).lock();
        try {
            this.dWb.dVZ = aVar;
            a.b(this.dWb).signal();
            x.i("MicroMsg.SendImgSpeeder", "notify big file gen prepared %s last %d", new Object[]{this.dWa.dWk, Long.valueOf(System.currentTimeMillis() - valueOf.longValue())});
        } finally {
            a.a(this.dWb).unlock();
        }
    }
}
