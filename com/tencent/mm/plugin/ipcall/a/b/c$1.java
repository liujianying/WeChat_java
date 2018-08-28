package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.mm.e.b.c.a;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements a {
    final /* synthetic */ c kqs;

    c$1(c cVar) {
        this.kqs = cVar;
    }

    public final void s(byte[] bArr, int i) {
        int i2 = 0;
        synchronized (this.kqs.kqm) {
            int bJu;
            c cVar = this.kqs;
            if (cVar.kqn <= 10) {
                cVar.kqn = 92;
            }
            a aVar = i.aXs().kqb;
            if (aVar.kpV != null) {
                bJu = aVar.kpV.bJu();
            } else {
                bJu = 0;
            }
            cVar.kqn = ((bJu + 24) + (cVar.kqn * 3)) / 4;
            if (cVar.kqo) {
                x.i("MicroMsg.IPCallRecorder", "preprocessForEcho FirstRefEcho");
                aVar = i.aXs().kqb;
                if (aVar.kpV != null) {
                    i2 = aVar.kpV.bJr();
                }
                cVar.kqp = i2;
                if (cVar.kqp >= cVar.kqn) {
                    cVar.kqp -= cVar.kqn;
                }
                cVar.kqn = cVar.kqp;
                cVar.kqo = false;
            } else {
                cVar.kqn = 0;
            }
            if (i.aXt().mCurrentState == 5) {
                if (this.kqs.kqq) {
                    x.i("MicroMsg.IPCallRecorder", "isFirstRecordCallback");
                    this.kqs.kqq = false;
                }
                i.aXq().kqx.recordCallback(bArr, i, this.kqs.kqn);
            }
        }
    }

    public final void aN(int i, int i2) {
    }
}
