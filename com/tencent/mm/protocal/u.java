package com.tencent.mm.protocal;

import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.awa;
import com.tencent.mm.protocal.c.awb;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.sx;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.x;

public final class u {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public awa qWY = new awa();
        public byte[] qWm;

        public final byte[] Ie() {
            int i = -1;
            this.qWA = y.cgr();
            this.qWY.rhB = new bhy().bq(bi.ciV());
            this.qWY.shX = k.a(this);
            this.qWY.rYW = e.sFz;
            sx sxVar = new sx();
            sxVar.rwf = 713;
            PByteArray pByteArray = new PByteArray();
            PByteArray pByteArray2 = new PByteArray();
            int generateECKey = MMProtocalJni.generateECKey(sxVar.rwf, pByteArray, pByteArray2);
            byte[] bArr = pByteArray.value;
            byte[] bArr2 = pByteArray2.value;
            this.qWm = bArr2 != null ? bArr2 : new byte[0];
            String str = "MicroMsg.MMReg2.Req";
            String str2 = "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s";
            Object[] objArr = new Object[6];
            objArr[0] = Integer.valueOf(sxVar.rwf);
            objArr[1] = Integer.valueOf(generateECKey);
            objArr[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            if (bArr2 != null) {
                i = bArr2.length;
            }
            objArr[3] = Integer.valueOf(i);
            objArr[4] = bi.bB(bArr);
            objArr[5] = bi.bB(bArr2);
            x.d(str, str2, objArr);
            sxVar.reV = new bhy().bq(bArr);
            this.qWY.reZ = sxVar;
            return this.qWY.toByteArray();
        }

        public final int If() {
            return 126;
        }

        public final int getCmdId() {
            return 0;
        }
    }

    public static class b extends k.e implements c {
        public int djx = 0;
        public byte[] erT;
        public awb qWZ = new awb();
        public byte[] qWo;

        public final int G(byte[] bArr) {
            this.djx = 0;
            this.qWZ = (awb) new awb().aG(bArr);
            k.a(this, this.qWZ.six);
            this.djx = 0;
            return this.qWZ.six.rfn;
        }

        public final int getCmdId() {
            return 0;
        }

        public final void bl(byte[] bArr) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            this.erT = bArr;
        }
    }
}
