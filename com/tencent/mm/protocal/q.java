package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.abt;
import com.tencent.mm.protocal.c.abu;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bi;

public final class q {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public abt qWS = new abt();

        public final byte[] Ie() {
            this.qWA = y.cgt();
            this.qWS.rhB = new bhy().bq(bi.ciV());
            this.qWS.rGp = y.cgr().ver;
            this.qWS.shX = k.a(this);
            return this.qWS.toByteArray();
        }

        public final int If() {
            return 381;
        }

        public final int getCmdId() {
            return 179;
        }
    }

    public static class b extends e implements c {
        public abu qWT = new abu();

        public final int G(byte[] bArr) {
            this.qWT = (abu) new abu().aG(bArr);
            k.a(this, this.qWT.six);
            return this.qWT.six.rfn;
        }

        public final int getCmdId() {
            return 1000000179;
        }
    }
}
