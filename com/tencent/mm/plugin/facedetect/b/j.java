package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.protocal.c.bfx;
import com.tencent.mm.protocal.c.bfy;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.platformtools.bi;

public final class j {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public bfx iMr = new bfx();

        public final byte[] Ie() {
            this.qWA = y.cgr();
            this.iMr.rhB = new bhy().bq(bi.ciV());
            this.iMr.shX = k.a(this);
            this.qWz = this.iMr.rhB.siK.toByteArray();
            return this.iMr.toByteArray();
        }

        public final int If() {
            return 931;
        }

        public final int getCmdId() {
            return 0;
        }
    }

    public static class b extends e implements c {
        public bfy iMs = new bfy();

        public final int G(byte[] bArr) {
            this.iMs = (bfy) new bfy().aG(bArr);
            k.a(this, this.iMs.six);
            return this.iMs.six.rfn;
        }

        public final int getCmdId() {
            return 0;
        }
    }
}
