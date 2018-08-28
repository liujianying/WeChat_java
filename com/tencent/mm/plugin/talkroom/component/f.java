package com.tencent.mm.plugin.talkroom.component;

import com.tencent.mm.e.b.c;
import com.tencent.mm.plugin.talkroom.component.d.a;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends a {
    private c bDp;
    private c.a bEs = new c.a() {
        public final void s(byte[] bArr, int i) {
            x.d("MicroMsg.MicRecoder", "pcm len: " + i);
            if (i <= 0) {
                x.e("MicroMsg.MicRecoder", "pcm data too low");
                return;
            }
            f.a(f.this, bArr, i);
            int Send = f.this.ovu.Send(bArr, (short) i);
            if (Send < 0) {
                x.e("MicroMsg.MicRecoder", "send failed, ret: " + Send);
            }
        }

        public final void aN(int i, int i2) {
        }
    };
    private v2engine ovu;
    private short ovv;
    private short ovw;

    static /* synthetic */ void a(f fVar, byte[] bArr, int i) {
        for (int i2 = 0; i2 < i / 2; i2++) {
            short s = (short) ((bArr[i2 * 2] & 255) | (bArr[(i2 * 2) + 1] << 8));
            if (s > fVar.ovv) {
                fVar.ovv = s;
            }
        }
    }

    public f(v2engine v2engine) {
        this.ovu = v2engine;
    }

    public final void bGP() {
        if (this.bDp != null) {
            this.bDp.we();
            this.bDp = null;
        }
    }

    public final void Sn() {
        this.bDp = new c(com.tencent.mm.plugin.talkroom.model.a.ovJ, 1, 2);
        this.bDp.t(8, false);
        this.bDp.bEb = this.bEs;
        this.bDp.ey(20);
        this.bDp.wn();
        this.ovw = (short) 0;
        this.ovv = (short) 0;
    }

    public final int bGQ() {
        if (this.ovw < this.ovv) {
            this.ovw = this.ovv;
        }
        if (this.ovw == (short) 0) {
            return 0;
        }
        short s = (short) ((this.ovv * 100) / this.ovw);
        this.ovv = (short) 0;
        return s;
    }

    public final void start() {
    }

    public final void release() {
        bGP();
    }
}
