package com.tencent.mm.protocal;

import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.asr;
import com.tencent.mm.protocal.c.ass;
import com.tencent.mm.protocal.c.bhd;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bup;
import com.tencent.mm.protocal.c.en;
import com.tencent.mm.protocal.c.eo;
import com.tencent.mm.protocal.c.sx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bn;

public final class i {

    public interface c {

        public static class a {
            public static c qWj;
        }

        int Ia();

        void a(f fVar, g gVar, int i, int i2, String str);

        q aZ(int i, int i2);
    }

    public static abstract class f extends com.tencent.mm.protocal.k.d implements com.tencent.mm.protocal.k.b {
        public byte[] qWm;

        public abstract String getUri();

        public final void bk(byte[] bArr) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            this.qWm = bArr;
        }
    }

    public static abstract class g extends com.tencent.mm.protocal.k.e implements com.tencent.mm.protocal.k.c {
        public int djx = 0;
        public byte[] erT;
        public String erW;
        public bup qWn = new bup();
        public byte[] qWo;

        public final void bl(byte[] bArr) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            this.erT = bArr;
        }
    }

    public static class a extends f implements com.tencent.mm.protocal.k.b {
        public en qWi = new en();
        public String username;

        public final byte[] Ie() {
            int i;
            int i2 = -1;
            com.tencent.mm.kernel.a.gb("");
            if (this.qWw == 12) {
                i = 1;
            } else {
                com.tencent.mm.kernel.g.Ek();
                i = com.tencent.mm.kernel.g.Ei().dqk.Di(46);
            }
            x.d("MicroMsg.AutoReq", "summerstatus[%d] clientUpgrade[%d]", Integer.valueOf(r3), Integer.valueOf(i));
            this.qWA = y.cgr();
            if (10002 == af.exm && af.exn > 0) {
                af.exn = 0;
                y.J("", "", 0);
            }
            bhd bhd = this.qWi.reX;
            bhd.shX = k.a(this);
            x.i("MicroMsg.AutoReq", "summerauth autoauth toProtoBuf[%d]", Integer.valueOf(this.qWs));
            bhd.dkY = com.tencent.mm.compatible.e.q.zy();
            bhd.reQ = com.tencent.mm.plugin.normsg.a.b.lFJ.ub(i);
            bhd.reR = 0;
            bhd.reS = com.tencent.mm.kernel.a.DA();
            bhd.eJK = bi.fT(ad.getContext());
            bhd.hbP = d.DEVICE_NAME;
            bhd.reT = bn.cmZ();
            bhd.iwP = w.chP();
            bhd.iwO = bi.ciX();
            bhd.qZe = com.tencent.mm.sdk.platformtools.e.bxk;
            com.tencent.mm.kernel.g.Ek();
            x.d("MicroMsg.AutoReq", "summerecdh ksid:%s, flag:%d", (String) com.tencent.mm.kernel.g.Ei().dqk.get(18), Integer.valueOf(bhd.reP.rgn));
            bhd.reP.rgl.rhZ = new bhy().bq(bi.WP(r0));
            eo eoVar = this.qWi.reW;
            sx sxVar = new sx();
            sxVar.rwf = 713;
            PByteArray pByteArray = new PByteArray();
            PByteArray pByteArray2 = new PByteArray();
            int generateECKey = MMProtocalJni.generateECKey(sxVar.rwf, pByteArray, pByteArray2);
            byte[] bArr = pByteArray.value;
            byte[] bArr2 = pByteArray2.value;
            bk(bArr2);
            String str = "MicroMsg.AutoReq";
            String str2 = "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s";
            Object[] objArr = new Object[6];
            objArr[0] = Integer.valueOf(sxVar.rwf);
            objArr[1] = Integer.valueOf(generateECKey);
            objArr[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            if (bArr2 != null) {
                i2 = bArr2.length;
            }
            objArr[3] = Integer.valueOf(i2);
            objArr[4] = bi.bB(bArr);
            objArr[5] = bi.bB(bArr2);
            x.d(str, str2, objArr);
            sxVar.reV = new bhy().bq(bArr);
            eoVar.reZ = sxVar;
            x.i("MicroMsg.AutoReq", "summerauth auto IMEI:%s SoftType:%s ClientSeqID:%s Signature:%s DeviceName:%s DeviceType:%s Language:%s TimeZone:%s chan[%d,%d,%d]", bhd.dkY, bhd.reQ, bhd.reS, bhd.eJK, bhd.hbP, bhd.reT, bhd.iwP, bhd.iwO, Integer.valueOf(bhd.qZe), Integer.valueOf(com.tencent.mm.sdk.platformtools.e.bxk), Integer.valueOf(com.tencent.mm.sdk.platformtools.e.sFz));
            try {
                return this.qWi.toByteArray();
            } catch (Throwable e) {
                x.e("MicroMsg.AutoReq", "summerauth toProtoBuf :%s", bi.i(e));
                return null;
            }
        }

        public final int If() {
            return HardCoderJNI.SCENE_ALBUM_SCROLL;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/autoauth";
        }
    }

    public static class b extends g implements com.tencent.mm.protocal.k.c {
        public final int G(byte[] bArr) {
            try {
                this.qWn = (bup) this.qWn.aG(bArr);
                k.a(this, this.qWn.six);
                this.djx = 0;
                if (this.qWn.six.rfn == 0 && (this.qWn.srN == null || this.qWn.srN.iwE == 0 || bi.bC(ab.a(this.qWn.srN.rer)))) {
                    x.e("MicroMsg.MMAuth", "retcode 0 but invalid auth sect resp or invalid uin or invalid session");
                    this.qWn.six.rfn = -1;
                }
                x.i("MicroMsg.MMAuth", "summerauthkick auto errmsg[%s]", this.qWD);
                com.tencent.mm.kernel.a.gb(r0);
                return this.qWn.six.rfn;
            } catch (Throwable e) {
                x.e("MicroMsg.MMAuth", "toProtoBuf :%s", bi.i(e));
                this.qWn.six.rfn = -1;
                return -1;
            }
        }
    }

    public static class d extends f implements com.tencent.mm.protocal.k.b {
        public asr qWk = new asr();
        public boolean qWl = false;

        public final byte[] Ie() {
            int i;
            int i2 = -1;
            com.tencent.mm.kernel.a.gb("");
            if (this.qWw == 16) {
                i = 1;
            } else if (this.qWl) {
                i = 3;
            } else {
                com.tencent.mm.kernel.g.Ek();
                i = com.tencent.mm.kernel.g.Ei().dqk.Di(46);
            }
            x.d("MicroMsg.ManualReq", "summerstatus[%d] clientUpgrade[%d]", Integer.valueOf(r4), Integer.valueOf(i));
            if (10002 == af.exm && af.exn > 0) {
                af.exn = 0;
                y.J("", "", 0);
            }
            this.qWA = y.cgr();
            bhd bhd = this.qWk.rUZ;
            bhd.shX = k.a(this);
            bhd.dkY = com.tencent.mm.compatible.e.q.zy();
            bhd.reQ = com.tencent.mm.plugin.normsg.a.b.lFJ.ub(i);
            bhd.reR = 0;
            bhd.reS = com.tencent.mm.kernel.a.DA();
            bhd.eJK = bi.fT(ad.getContext());
            bhd.hbP = d.DEVICE_NAME;
            bhd.reT = bn.cmZ();
            bhd.iwP = w.chP();
            bhd.iwO = bi.ciX();
            bhd.qZe = com.tencent.mm.sdk.platformtools.e.bxk;
            if (10012 == af.exm && af.exn > 0) {
                bhd.qZe = af.exn;
            }
            bhd.rjM = d.qVH;
            bhd.rjL = d.qVI;
            bhd.rUU = d.qVJ;
            bhd.rwh = com.tencent.mm.compatible.e.q.getSimCountryIso();
            com.tencent.mm.kernel.g.Ek();
            x.d("MicroMsg.ManualReq", "summerauth ksid:%s authreq flag:%d", (String) com.tencent.mm.kernel.g.Ei().dqk.get(18), Integer.valueOf(bhd.reP.rgn));
            bhd.reP.rgl.rhZ = new bhy().bq(bi.WP(r0));
            ass ass = this.qWk.rUY;
            ass.rhB = new bhy().bq(bi.ciV());
            sx sxVar = new sx();
            sxVar.rwf = 713;
            PByteArray pByteArray = new PByteArray();
            PByteArray pByteArray2 = new PByteArray();
            int generateECKey = MMProtocalJni.generateECKey(sxVar.rwf, pByteArray, pByteArray2);
            byte[] bArr = pByteArray.value;
            byte[] bArr2 = pByteArray2.value;
            bk(bArr2);
            String str = "MicroMsg.ManualReq";
            String str2 = "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s";
            Object[] objArr = new Object[6];
            objArr[0] = Integer.valueOf(sxVar.rwf);
            objArr[1] = Integer.valueOf(generateECKey);
            objArr[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            if (bArr2 != null) {
                i2 = bArr2.length;
            }
            objArr[3] = Integer.valueOf(i2);
            objArr[4] = bi.bB(bArr);
            objArr[5] = bi.bB(bArr2);
            x.d(str, str2, objArr);
            sxVar.reV = new bhy().bq(bArr);
            ass.reZ = sxVar;
            x.i("MicroMsg.ManualReq", "summerauth manual IMEI:%s SoftType:%s ClientSeqID:%s Signature:%s DeviceName:%s DeviceType:%s Language:%s TimeZone:%s chan[%d,%d,%d] DeviceBrand:%s DeviceModel:%s OSType:%s RealCountry:%s", bhd.dkY, bhd.reQ, bhd.reS, bhd.eJK, bhd.hbP, bhd.reT, bhd.iwP, bhd.iwO, Integer.valueOf(bhd.qZe), Integer.valueOf(com.tencent.mm.sdk.platformtools.e.bxk), Integer.valueOf(com.tencent.mm.sdk.platformtools.e.sFz), bhd.rjM, bhd.rjL, bhd.rUU, bhd.rwh);
            try {
                return this.qWk.toByteArray();
            } catch (Throwable e) {
                x.e("MicroMsg.ManualReq", "summerauth toProtoBuf :%s", bi.i(e));
                return null;
            }
        }

        public final int If() {
            return HardCoderJNI.SCENE_SNS_SCROLL;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/manualauth";
        }
    }

    public static class e extends g implements com.tencent.mm.protocal.k.c {
        public final int G(byte[] bArr) {
            try {
                this.qWn = (bup) this.qWn.aG(bArr);
                k.a(this, this.qWn.six);
                this.djx = 0;
                if (this.qWn.six.rfn == 0 && (this.qWn.srN == null || this.qWn.srN.iwE == 0 || bi.bC(ab.a(this.qWn.srN.rer)))) {
                    x.e("MicroMsg.MMAuth", "retcode 0 but invalid auth sect resp or invalid uin or invalid session");
                    this.qWn.six.rfn = -1;
                }
                x.i("MicroMsg.MMAuth", "summerauthkick manual errmsg[%s]", this.qWD);
                com.tencent.mm.kernel.a.gb(r0);
                return this.qWn.six.rfn;
            } catch (Throwable e) {
                x.e("MicroMsg.MMAuth", "toProtoBuf :%s", bi.i(e));
                this.qWn.six.rfn = -1;
                return -1;
            }
        }
    }
}
