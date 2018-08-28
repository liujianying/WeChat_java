package com.tencent.mm.modelvoiceaddr;

import com.tencent.mm.a.e;
import com.tencent.mm.e.b.g;
import com.tencent.mm.modelvoiceaddr.a.c.a;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b;
import com.tencent.mm.sdk.platformtools.x;

class f$2 implements a {
    final /* synthetic */ f eqI;
    byte[] eqJ;

    f$2(f fVar) {
        this.eqI = fVar;
    }

    public final void b(short[] sArr, int i) {
        if (sArr != null) {
            int i2;
            if (this.eqJ == null || this.eqJ.length < i * 2) {
                this.eqJ = new byte[(i * 2)];
            }
            for (i2 = 0; i2 < i; i2++) {
                this.eqJ[i2 * 2] = (byte) (sArr[i2] & b.CTRL_BYTE);
                this.eqJ[(i2 * 2) + 1] = (byte) ((sArr[i2] & 65280) >> 8);
            }
            if (f.b(this.eqI) != null) {
                i2 = f.b(this.eqI).a(new g.a(this.eqJ, i * 2), 0, true);
            } else {
                i2 = -1;
            }
            if (-1 == i2) {
                this.eqI.bs(4, -1);
                x.e("MicroMsg.SceneVoiceInputAddr", "write to file failed");
                return;
            }
            f.a(this.eqI, i2 + f.f(this.eqI));
            if (!f.g(this.eqI) && f.f(this.eqI) > 200 && !f.h(this.eqI)) {
                com.tencent.mm.kernel.g.Em().H(new 1(this));
                f.j(this.eqI);
            }
        }
    }

    public final void Ub() {
        x.i("MicroMsg.SceneVoiceInputAddr", "onSpeakToSilent");
        if (f.i(this.eqI) instanceof b) {
            try {
                ((b) f.i(this.eqI)).iI(e.cm(f.Ua()));
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", e, "cutShortSentence error", new Object[0]);
                this.eqI.bs(6, -1);
            }
        }
    }

    public final void Uc() {
        x.i("MicroMsg.SceneVoiceInputAddr", "onSilentToSpeak");
        if (f.i(this.eqI) instanceof b) {
            try {
                g gVar = ((b) f.i(this.eqI)).eqa;
                x.i("MicroMsg.ShortSentenceContainer", "createNewShortSentence");
                gVar.eqN.writeLock().lock();
                g$a g_a = new g$a(gVar);
                gVar.eqM.put(g_a.eqP, g_a);
                gVar.eqN.writeLock().unlock();
                if (!f.b(this.eqI).wB()) {
                    this.eqI.bs(5, -1);
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", e, "createShortSentence error", new Object[0]);
                this.eqI.bs(6, -1);
            }
        }
    }

    public final void vU() {
        x.i("MicroMsg.SceneVoiceInputAddr", "Silent enough to finish time %s", new Object[]{Long.valueOf(System.currentTimeMillis())});
        this.eqI.aJ(false);
    }
}
