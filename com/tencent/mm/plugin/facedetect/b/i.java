package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.protocal.c.aai;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.e;

public final class i {

    public static class b extends e implements c {
        public aai iMq = new aai();

        public final int G(byte[] bArr) {
            this.iMq = (aai) new aai().aG(bArr);
            k.a(this, this.iMq.six);
            return this.iMq.six.rfn;
        }

        public final int getCmdId() {
            return 0;
        }
    }
}
