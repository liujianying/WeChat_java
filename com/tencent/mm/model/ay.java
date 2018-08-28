package com.tencent.mm.model;

import com.tencent.mm.protocal.c.ajn;
import com.tencent.mm.protocal.c.ajo;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.platformtools.bi;

public final class ay {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public ajn dBS = new ajn();

        public final byte[] Ie() {
            this.qWA = y.cgr();
            this.dBS.rhB = new bhy().bq(bi.ciV());
            this.dBS.shX = k.a(this);
            return this.dBS.toByteArray();
        }

        public final int If() {
            return 616;
        }

        public final int getCmdId() {
            return 0;
        }
    }

    public static class b extends e implements c {
        public ajo dBT = new ajo();

        public final int G(byte[] bArr) {
            this.dBT = (ajo) new ajo().aG(bArr);
            k.a(this, this.dBT.six);
            return this.dBT.six.rfn;
        }

        public final int getCmdId() {
            return 0;
        }
    }
}
