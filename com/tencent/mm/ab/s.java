package com.tencent.mm.ab;

import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.plugin.zero.a.e;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.c.asr;
import com.tencent.mm.protocal.c.en;
import com.tencent.mm.protocal.g.a;
import com.tencent.mm.protocal.i;
import com.tencent.mm.protocal.i.c;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.q;
import com.tencent.mm.protocal.u;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;

public final class s extends a {
    private static e dJX;
    private d dIT;
    private byte[] dJY;
    private int type;

    public static void a(e eVar) {
        dJX = eVar;
    }

    public s(d dVar, int i) {
        this.dIT = dVar;
        this.type = i;
    }

    public static boolean a(byte[] bArr, byte[] bArr2, byte[] bArr3, d dVar, ByteArrayOutputStream byteArrayOutputStream, boolean z) {
        if (bi.bC(bArr)) {
            String str = "MicroMsg.RemoteReq";
            String str2 = "reqToBufNoRSA session is null :%d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            x.e(str, str2, objArr);
            return false;
        }
        PByteArray pByteArray = new PByteArray();
        try {
            b bVar = (b) dVar;
            byte[] Ie = bVar.Ie();
            if (Ie == null) {
                return false;
            }
            if (bVar.cgo()) {
                byteArrayOutputStream.write(Ie);
                return true;
            }
            y cgr = y.cgr();
            int i = 6;
            if (z) {
                i = 7;
            }
            if (!MMProtocalJni.pack(Ie, pByteArray, bArr, bArr2, dVar.qWv, dVar.qWs, bVar.If(), cgr.ver, cgr.qXe.getBytes(), cgr.qXf.getBytes(), bArr3, i)) {
                return false;
            }
            x.d("MicroMsg.RemoteReq", "reqToBuf using protobuf ok, len:%d, flag:%d", Integer.valueOf(pByteArray.value.length), Integer.valueOf(i));
            byteArrayOutputStream.write(pByteArray.value);
            return true;
        } catch (Throwable e) {
            x.e("MicroMsg.RemoteReq", "protobuf build exception, check now! :" + e.getMessage());
            x.printErrStackTrace("MicroMsg.RemoteReq", e, "", new Object[0]);
            return false;
        }
    }

    public final boolean a(int i, byte[] bArr, byte[] bArr2, byte[] bArr3, int i2, boolean z) {
        PByteArray pByteArray = new PByteArray();
        x.d("MicroMsg.RemoteReq", "reqToBuf jType: %d, stack: %s", Integer.valueOf(i), bi.cjd());
        switch (i) {
            case 268369922:
                try {
                    this.dJY = ((b) this.dIT).Ie();
                    this.dIT.bufferSize = (long) this.dJY.length;
                    return true;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.RemoteReq", e, "", new Object[0]);
                    return false;
                }
            default:
                if (this.dIT instanceof b) {
                    try {
                        b bVar = (b) this.dIT;
                        byte[] Ie = bVar.Ie();
                        if (Ie == null) {
                            return false;
                        }
                        if (bVar.cgo()) {
                            this.dJY = Ie;
                            this.dIT.bufferSize = (long) this.dJY.length;
                            return true;
                        }
                        long j;
                        int i3;
                        int i4;
                        Object obj;
                        long j2 = (long) this.dIT.qWs;
                        if (com.tencent.mm.sdk.a.b.chp() && j2 == 0) {
                            j = com.tencent.mm.protocal.d.qVM;
                        } else {
                            j = j2;
                        }
                        y yVar = this.dIT.qWA;
                        if (!yVar.cgu()) {
                            bArr = new byte[0];
                        }
                        byte[][] bArr4 = null;
                        int obj2;
                        switch (i) {
                            case HardCoderJNI.SCENE_SNS_SCROLL /*701*/:
                                asr asr = ((i.d) this.dIT).qWk;
                                bArr4 = a(j, asr.rUY, asr.rUZ);
                                obj2 = 1;
                                break;
                            case HardCoderJNI.SCENE_ALBUM_SCROLL /*702*/:
                                x.d("MicroMsg.RemoteReq", "summerauth reqToBuf rsaReqData uin[%d]", Long.valueOf(j));
                                if (j == 0) {
                                    if (c.a.qWj == null) {
                                        i3 = -1;
                                    } else {
                                        i3 = c.a.qWj.Ia();
                                    }
                                    g.Ek();
                                    g.Eg();
                                    x.w("MicroMsg.RemoteReq", "summerauth autoauth uin[%d] is invalid! uinForProtocal[%d] accountUin[%d]", Long.valueOf(j), Integer.valueOf(i3), Integer.valueOf(com.tencent.mm.kernel.a.Df()));
                                    f.mDy.a(148, 54, 1, true);
                                    if (i3 != 0) {
                                        f.mDy.a(148, 55, 1, true);
                                    }
                                    if (i4 != 0) {
                                        f.mDy.a(148, 56, 1, true);
                                    }
                                }
                                en enVar = ((i.a) this.dIT).qWi;
                                bArr4 = a(j, enVar.reW, enVar.reX);
                                obj2 = 1;
                                break;
                            default:
                                obj2 = null;
                                break;
                        }
                        i3 = 6;
                        if (z) {
                            i3 = 7;
                        }
                        if (obj2 != null) {
                            if (yVar.cgu() && bi.bC(bArr)) {
                                x.e("MicroMsg.RemoteReq", "dksession jType %d session should not null", Integer.valueOf(i));
                                return false;
                            } else if (bArr4 == null) {
                                return false;
                            } else {
                                byte[] bArr5 = bArr4[0];
                                byte[] bArr6 = bArr4[1];
                                switch (i) {
                                    case HardCoderJNI.SCENE_ALBUM_SCROLL /*702*/:
                                        if (MMProtocalJni.packDoubleHybrid(pByteArray, bArr2, this.dIT.qWv, (int) j, bVar.If(), yVar.ver, bArr5, bArr6, yVar.qXe.getBytes(), yVar.qXf.getBytes(), Lz(), i3)) {
                                            x.d("MicroMsg.RemoteReq", "summer reqToBuf packDoubleHybrid AutoAuth using protobuf ok, len:%d, flag:%d", Integer.valueOf(pByteArray.value.length), Integer.valueOf(i3));
                                            this.dJY = pByteArray.value;
                                            break;
                                        }
                                        break;
                                    default:
                                        if (MMProtocalJni.packHybrid(pByteArray, bArr2, this.dIT.qWv, (int) j, bVar.If(), yVar.ver, bArr5, bArr6, yVar.qXe.getBytes(), yVar.qXf.getBytes(), Lz(), i3)) {
                                            x.d("MicroMsg.RemoteReq", "MMEncryptCheckResUpdate reqToBuf packHybrid EncryptCheckResUpdate using protobuf ok, len:%d, flag:%d", Integer.valueOf(pByteArray.value.length), Integer.valueOf(i3));
                                            this.dJY = pByteArray.value;
                                            break;
                                        }
                                        break;
                                }
                                this.dIT.bufferSize = (long) this.dJY.length;
                            }
                        } else if (this.dIT.qWy != null) {
                            int i5 = 6;
                            if (z) {
                                i5 = 7;
                            }
                            if (this.dIT.qWy.a(pByteArray, i, bArr2, bArr3, i5)) {
                                this.dJY = pByteArray.value;
                                this.dIT.bufferSize = (long) this.dJY.length;
                                x.d("MicroMsg.RemoteReq", "reqToBuf using req.getReqPackControl() ok, len:%d", Integer.valueOf(pByteArray.value.length));
                            }
                            return true;
                        } else if (i != 775 && yVar.cgu() && bi.bC(bArr)) {
                            x.e("MicroMsg.RemoteReq", "dksession jType %d session should not null", Integer.valueOf(i));
                            return false;
                        } else {
                            if (i == 775) {
                                i4 = (i3 & -3) & -5;
                            } else {
                                i4 = i3;
                            }
                            x.d("MicroMsg.RemoteReq", "dkrsa use session :%s  type:%d, flag:%d, ecdh:[%s]", bArr, Integer.valueOf(i), Integer.valueOf(i4), bi.bB(bArr3));
                            if (MMProtocalJni.pack(Ie, pByteArray, bArr, bArr2, this.dIT.qWv, (int) j, bVar.If(), yVar.ver, yVar.qXe.getBytes(), yVar.qXf.getBytes(), bArr3, i4)) {
                                x.d("MicroMsg.RemoteReq", "reqToBuf using protobuf ok, len:%d, flag:%d", Integer.valueOf(pByteArray.value.length), Integer.valueOf(i4));
                                this.dJY = pByteArray.value;
                            }
                            this.dIT.bufferSize = (long) this.dJY.length;
                        }
                        return true;
                    } catch (Throwable e2) {
                        x.e("MicroMsg.RemoteReq", "protobuf build exception, check now! :" + e2.getMessage());
                        x.printErrStackTrace("MicroMsg.RemoteReq", e2, "", new Object[0]);
                        return false;
                    }
                }
                x.f("MicroMsg.RemoteReq", "all protocal should implemented with protobuf");
                return false;
        }
    }

    public static byte[][] a(long j, com.tencent.mm.bk.a aVar, com.tencent.mm.bk.a aVar2) {
        byte[] toByteArray;
        if (j == 0) {
            x.w("MicroMsg.RemoteReq", "summerauth toRsaAesByteArray autoauth uin is invalid!");
        }
        try {
            toByteArray = aVar.toByteArray();
        } catch (Throwable e) {
            x.e("MicroMsg.RemoteReq", "summerauth toRsaAesByteArray reqToBuf rsaReqData toProtoBuf exception:%s", bi.i(e));
            toByteArray = null;
        }
        if (bi.bC(toByteArray)) {
            x.e("MicroMsg.RemoteReq", "summerauth toRsaAesByteArray reqToBuf rsaReqDataBuf is null and ret false");
            return null;
        }
        byte[] toByteArray2;
        try {
            toByteArray2 = aVar2.toByteArray();
        } catch (Throwable e2) {
            x.e("MicroMsg.RemoteReq", "summerauth toRsaAesByteArray reqToBuf aesReqData toProtoBuf exception:%s", bi.i(e2));
            toByteArray2 = null;
        }
        if (bi.bC(toByteArray2)) {
            x.e("MicroMsg.RemoteReq", "summerauth toRsaAesByteArray reqToBuf aesReqDataBuf is null and ret false");
            return null;
        }
        return new byte[][]{toByteArray, toByteArray2};
    }

    public final byte[] Lv() {
        return this.dJY;
    }

    public final void J(byte[] bArr) {
        d dVar = this.dIT;
        if (bArr == null) {
            bArr = new byte[0];
        }
        dVar.bjP = bArr;
    }

    public final byte[] DE() {
        return this.dIT.bjP;
    }

    public final void eK(int i) {
        this.dIT.eK(i);
    }

    public final int Df() {
        return this.dIT.qWs;
    }

    public final void hq(int i) {
        this.dIT.qWt = i;
    }

    public final int getClientVersion() {
        return this.dIT.qWt;
    }

    public final void ki(String str) {
        this.dIT.qWu = str;
    }

    public final String Lw() {
        return this.dIT.qWu;
    }

    public final String Lx() {
        return this.dIT.qWv;
    }

    public final void kj(String str) {
        this.dIT.qWv = str;
    }

    public final void hr(int i) {
        this.dIT.qWw = i;
    }

    public final int Ly() {
        return this.dIT.qWw;
    }

    public final byte[] Lz() {
        x.d("MicroMsg.RemoteReq", "dkrsa getpass type:%d", Integer.valueOf(this.type));
        switch (this.type) {
            case 126:
                return ((u.a) this.dIT).qWY.rhB.siK.toByteArray();
            case 381:
                return ((q.a) this.dIT).qWS.rhB.siK.toByteArray();
            case HardCoderJNI.SCENE_SNS_SCROLL /*701*/:
                return ((i.d) this.dIT).qWk.rUY.rhB.siK.toByteArray();
            case HardCoderJNI.SCENE_ALBUM_SCROLL /*702*/:
                return ((i.a) this.dIT).qWi.reW.reY.siK.toByteArray();
            default:
                if (dJX != null) {
                    byte[] a = dJX.a(this.dIT, this.type);
                    if (a != null) {
                        return a;
                    }
                }
                if (this.dIT.qWz != null) {
                    return this.dIT.qWz;
                }
                return DE();
        }
    }

    public final String getPassword() {
        switch (this.type) {
            case 126:
                return ((u.a) this.dIT).qWY.rhI;
            case HardCoderJNI.SCENE_SNS_SCROLL /*701*/:
                return ((i.d) this.dIT).qWk.rUY.rhI;
            default:
                return "";
        }
    }

    public final String LA() {
        switch (this.type) {
            case HardCoderJNI.SCENE_SNS_SCROLL /*701*/:
                return ((i.d) this.dIT).qWk.rUY.rhU;
            default:
                return "";
        }
    }

    public final String getUserName() {
        switch (this.type) {
            case 126:
                return ((u.a) this.dIT).qWY.hbL;
            case HardCoderJNI.SCENE_SNS_SCROLL /*701*/:
                return ((i.d) this.dIT).qWk.rUY.hbL;
            case HardCoderJNI.SCENE_ALBUM_SCROLL /*702*/:
                return ((i.a) this.dIT).username;
            default:
                return "";
        }
    }

    public final int getCmdId() {
        return this.dIT.getCmdId();
    }

    public final boolean LB() {
        return this.dIT.LB();
    }
}
