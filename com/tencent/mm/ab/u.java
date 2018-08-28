package com.tencent.mm.ab;

import android.os.Looper;
import com.tencent.mm.g.a.hc;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.c.bem;
import com.tencent.mm.protocal.c.bhp;
import com.tencent.mm.protocal.c.bkc;
import com.tencent.mm.protocal.i.g;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.protocal.q;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class u extends com.tencent.mm.protocal.h.a {
    private static a dKg;
    private byte[] ccH;
    private e dKf;
    private int type;

    public interface a {
        void cW(String str);
    }

    public static void a(a aVar) {
        dKg = aVar;
    }

    public u(e eVar, int i) {
        this.dKf = eVar;
        this.type = i;
    }

    public final boolean a(int i, byte[] bArr, byte[] bArr2) {
        PByteArray pByteArray = new PByteArray();
        if (this.dKf instanceof c) {
            PByteArray pByteArray2 = new PByteArray();
            PInt pInt = new PInt(0);
            c cVar = (c) this.dKf;
            PInt pInt2 = new PInt(0);
            PInt pInt3 = new PInt(0);
            PInt pInt4 = new PInt(255);
            try {
                if (cVar.cgo()) {
                    int G = cVar.G(bArr);
                    x.d("MicroMsg.RemoteResp", "rawData using protobuf ok");
                    this.dKf.qWB = G;
                    if (!bi.oW(af.exp)) {
                        this.dKf.qWD = af.exp;
                    }
                    return true;
                }
                x.i("MicroMsg.RemoteResp", "bufToResp unpack ret[%b], jType[%d], noticeid[%d], headExtFlags[%d]", Boolean.valueOf(MMProtocalJni.unpack(pByteArray2, bArr, bArr2, pByteArray, pInt, pInt2, pInt3, pInt4)), Integer.valueOf(i), Integer.valueOf(pInt3.value), Integer.valueOf(pInt4.value));
                b hcVar;
                boolean m;
                if (MMProtocalJni.unpack(pByteArray2, bArr, bArr2, pByteArray, pInt, pInt2, pInt3, pInt4)) {
                    this.dKf.qWC = pInt4.value;
                    if (i != HardCoderJNI.SCENE_SNS_SCROLL && i != HardCoderJNI.SCENE_ALBUM_SCROLL && 10001 == af.exm && af.exn > 0) {
                        if (af.exn == 2) {
                            y.J("", "", 0);
                        }
                        af.exn = 0;
                        pInt.value = -13;
                        x.w("MicroMsg.RemoteResp", "dkcert dktest set session timeout once !");
                    }
                    if (pInt.value == -13 || pInt.value == -102 || pInt.value == -3001 || pInt.value == -3002 || pInt.value == -3003) {
                        this.dKf.qWB = pInt.value;
                        if (pInt.value == -3002) {
                            try {
                                this.dKf.qWD = new String(pByteArray2.value);
                            } catch (Exception e) {
                                x.e("MicroMsg.RemoteResp", "parse string err while MM_ERR_IDCDISASTER");
                            }
                            x.i("MicroMsg.RemoteResp", "jType [%d], ret value[%d], noticeId[%s], msg[%s]", Integer.valueOf(i), Integer.valueOf(pInt.value), pInt3, this.dKf.qWD);
                        }
                    } else {
                        x.i("MicroMsg.RemoteResp", "bufToResp using protobuf ok jType:%d, enType:%d errCode:%d, len:%d, headExtFlags:%d", Integer.valueOf(i), Integer.valueOf(pInt2.value), Integer.valueOf(cVar.G(pByteArray2.value)), Integer.valueOf(pByteArray2.value.length), Integer.valueOf(this.dKf.qWC));
                        this.dKf.qWB = r1;
                    }
                    this.dKf.bufferSize = (long) bArr.length;
                    this.ccH = pByteArray.value;
                    if (!bi.oW(af.exp)) {
                        this.dKf.qWD = af.exp;
                    }
                    if (pInt3.value != 0) {
                        hcVar = new hc();
                        hcVar.bQo.bQp = pInt3.value;
                        if (i == HardCoderJNI.SCENE_SNS_SCROLL && this.dKf.qWB == 0) {
                            x.i("MicroMsg.RemoteResp", "summerdiz publish GetDisasterInfoEvent MMFunc_ManualAuth ok [%d]", Integer.valueOf(pInt3.value));
                            hcVar.bQo.bQq = true;
                        }
                        m = com.tencent.mm.sdk.b.a.sFg.m(hcVar);
                        x.i("MicroMsg.RemoteResp", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", Integer.valueOf(pInt3.value), Boolean.valueOf(m));
                        pInt3.value = 0;
                    }
                    return true;
                }
                x.e("MicroMsg.RemoteResp", "unpack return false jType[%d]", Integer.valueOf(i));
                if (pInt3.value != 0) {
                    hcVar = new hc();
                    hcVar.bQo.bQp = pInt3.value;
                    m = com.tencent.mm.sdk.b.a.sFg.m(hcVar);
                    x.i("MicroMsg.RemoteResp", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", Integer.valueOf(pInt3.value), Boolean.valueOf(m));
                    pInt3.value = 0;
                }
                return false;
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.RemoteResp", e2, "from Protobuf unbuild exception, check now!", new Object[0]);
                x.e("MicroMsg.RemoteResp", "exception:%s", bi.i(e2));
            }
        } else {
            x.f("MicroMsg.RemoteResp", "all protocal should implemented with protobuf");
            return false;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, PInt pInt, bhp bhp) {
        PByteArray pByteArray = new PByteArray();
        pInt.value = -1;
        PByteArray pByteArray2 = new PByteArray();
        PInt pInt2 = new PInt(0);
        PInt pInt3 = new PInt(0);
        try {
            x.i("MicroMsg.RemoteResp", "bufToRespNoRSA unpack ret[%b], noticeid[%d], headExtFlags[%d]", Boolean.valueOf(MMProtocalJni.unpack(pByteArray2, bArr, bArr2, pByteArray, pInt, pInt2, pInt3, new PInt(255))), Integer.valueOf(pInt3.value), Integer.valueOf(r7.value));
            if (pInt3.value != 0) {
                b hcVar = new hc();
                hcVar.bQo.bQp = pInt3.value;
                boolean m = com.tencent.mm.sdk.b.a.sFg.m(hcVar);
                x.i("MicroMsg.RemoteResp", "summerdiz bufToRespNoRSA publish GetDisasterInfoEvent noticeid[%d] publish[%b]", Integer.valueOf(pInt3.value), Boolean.valueOf(m));
            }
            if (!r1) {
                x.e("MicroMsg.RemoteResp", "unpack failed.");
                return null;
            } else if (pInt.value == -13 || pInt.value == -102 || pInt.value == -3001) {
                x.e("MicroMsg.RemoteResp", "unpack failed. error:%d", Integer.valueOf(pInt.value));
                return null;
            } else if (pInt.value == -3002) {
                try {
                    final String str = new String(pByteArray2.value);
                    x.i("MicroMsg.RemoteResp", "bufToRespNoRSA -3002 ERR_IDCDISASTER, errStr:%s", str);
                    new ag(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            if (!bi.oW(str) && u.dKg != null) {
                                u.dKg.cW(str);
                            }
                        }
                    });
                    return null;
                } catch (Exception e) {
                    x.e("MicroMsg.RemoteResp", "parse string err while MM_ERR_IDCDISASTER");
                }
            } else {
                x.i("MicroMsg.RemoteResp", "fuckwifi bufToRespNoRSA using protobuf ok jtype:%d enType:%d ", Integer.valueOf(110), Integer.valueOf(pInt2.value));
                bhp.aG(pByteArray2.value);
                return pByteArray2.value;
            }
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.RemoteResp", e2, "parseFrom unbuild exception, check now!", new Object[0]);
            x.e("MicroMsg.RemoteResp", "exception:%s", bi.i(e2));
        }
    }

    public final byte[] Lm() {
        return this.ccH;
    }

    public final int LF() {
        return this.dKf.qWC;
    }

    public final String LG() {
        return this.dKf.qWD;
    }

    public final void kl(String str) {
        this.dKf.qWD = str;
    }

    public final int LH() {
        return this.dKf.qWB;
    }

    public final void hs(int i) {
        this.dKf.qWB = i;
    }

    public final byte[] DE() {
        byte[] bArr = new byte[0];
        switch (this.type) {
            case 126:
                return ((com.tencent.mm.protocal.u.b) this.dKf).erT;
            case HardCoderJNI.SCENE_SNS_SCROLL /*701*/:
            case HardCoderJNI.SCENE_ALBUM_SCROLL /*702*/:
                return ((g) this.dKf).erT;
            default:
                return bArr;
        }
    }

    public final byte[] LI() {
        byte[] bArr = new byte[0];
        switch (this.type) {
            case 126:
                bkc bkc = ((com.tencent.mm.protocal.u.b) this.dKf).qWZ.rZo;
                if (bkc == null || bkc.res == null) {
                    x.d("MicroMsg.RemoteResp", "summerauth MMFunc_NewReg SecAuthRegKeySect is null");
                    break;
                }
                return bkc.res.siK.toByteArray();
            case HardCoderJNI.SCENE_SNS_SCROLL /*701*/:
            case HardCoderJNI.SCENE_ALBUM_SCROLL /*702*/:
                if (((g) this.dKf).qWn.srN.res != null) {
                    return ((g) this.dKf).qWn.srN.res.siK.toByteArray();
                }
                break;
        }
        return bArr;
    }

    public final byte[] Lo() {
        byte[] bArr = new byte[0];
        switch (this.type) {
            case 126:
                return ((com.tencent.mm.protocal.u.b) this.dKf).qWo;
            case HardCoderJNI.SCENE_SNS_SCROLL /*701*/:
            case HardCoderJNI.SCENE_ALBUM_SCROLL /*702*/:
                return ((g) this.dKf).qWo;
            default:
                return bArr;
        }
    }

    public final String LJ() {
        if (this.type == 381) {
            bem bem = ((q.b) this.dKf).qWT.rGq;
            if (bem != null) {
                return bi.oV(bem.sge);
            }
        }
        return "";
    }

    public final String LK() {
        if (this.type == 381) {
            bem bem = ((q.b) this.dKf).qWT.rGq;
            if (bem != null) {
                return bi.oV(bem.sgd);
            }
        }
        return "";
    }

    public final int LL() {
        if (this.type == 381) {
            return ((q.b) this.dKf).qWT.rFA;
        }
        return 0;
    }

    public final int Df() {
        switch (this.type) {
            case 126:
                return ((com.tencent.mm.protocal.u.b) this.dKf).qWZ.iwE;
            case HardCoderJNI.SCENE_SNS_SCROLL /*701*/:
            case HardCoderJNI.SCENE_ALBUM_SCROLL /*702*/:
                return ((g) this.dKf).qWn.srN.iwE;
            default:
                return 0;
        }
    }

    public final String LM() {
        switch (this.type) {
            case 126:
                return ((com.tencent.mm.protocal.u.b) this.dKf).qWZ.hbL;
            case HardCoderJNI.SCENE_SNS_SCROLL /*701*/:
            case HardCoderJNI.SCENE_ALBUM_SCROLL /*702*/:
                return ((g) this.dKf).erW;
            default:
                return "";
        }
    }

    public final int getCmdId() {
        return this.dKf.getCmdId();
    }
}
