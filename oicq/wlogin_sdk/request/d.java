package oicq.wlogin_sdk.request;

import com.tencent.wcdb.FileUtils;
import java.lang.reflect.Array;
import oicq.wlogin_sdk.a.a;
import oicq.wlogin_sdk.a.ab;
import oicq.wlogin_sdk.a.ac;
import oicq.wlogin_sdk.a.ad;
import oicq.wlogin_sdk.a.af;
import oicq.wlogin_sdk.a.ah;
import oicq.wlogin_sdk.a.ai;
import oicq.wlogin_sdk.a.ak;
import oicq.wlogin_sdk.a.al;
import oicq.wlogin_sdk.a.am;
import oicq.wlogin_sdk.a.ap;
import oicq.wlogin_sdk.a.e;
import oicq.wlogin_sdk.a.f;
import oicq.wlogin_sdk.a.g;
import oicq.wlogin_sdk.a.h;
import oicq.wlogin_sdk.a.j;
import oicq.wlogin_sdk.a.l;
import oicq.wlogin_sdk.a.m;
import oicq.wlogin_sdk.a.n;
import oicq.wlogin_sdk.a.o;
import oicq.wlogin_sdk.a.p;
import oicq.wlogin_sdk.a.q;
import oicq.wlogin_sdk.a.s;
import oicq.wlogin_sdk.a.t;
import oicq.wlogin_sdk.a.u;
import oicq.wlogin_sdk.a.v;
import oicq.wlogin_sdk.a.w;
import oicq.wlogin_sdk.a.x;
import oicq.wlogin_sdk.a.z;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

public class d {
    protected static int vIh = 0;
    int vHZ = 4096;
    int vIa = 0;
    int vIb = 27;
    int vIc = 0;
    public int vId = 15;
    protected int vIe = 0;
    protected byte[] vIf = new byte[this.vHZ];
    protected int vIg = 8001;
    protected int vIi = 0;
    protected int vIj = 0;
    protected int vIk = 0;
    protected int vIl = 0;
    protected int vIm = 0;
    byte vIn;
    protected i vIo;

    public final void a(int i, int i2, long j, int i3, int i4, int i5, int i6, byte[] bArr) {
        int length = bArr.length;
        int i7 = vIh + 1;
        vIh = i7;
        this.vIa = 0;
        util.A(this.vIf, this.vIa, 2);
        this.vIa++;
        util.B(this.vIf, this.vIa, (this.vIb + 2) + length);
        this.vIa += 2;
        util.B(this.vIf, this.vIa, i);
        this.vIa += 2;
        util.B(this.vIf, this.vIa, i2);
        this.vIa += 2;
        util.B(this.vIf, this.vIa, i7);
        this.vIa += 2;
        util.C(this.vIf, this.vIa, (int) j);
        this.vIa += 4;
        util.A(this.vIf, this.vIa, 3);
        this.vIa++;
        util.A(this.vIf, this.vIa, 0);
        this.vIa++;
        util.A(this.vIf, this.vIa, i3);
        this.vIa++;
        util.C(this.vIf, this.vIa, i4);
        this.vIa += 4;
        util.C(this.vIf, this.vIa, i5);
        this.vIa += 4;
        util.C(this.vIf, this.vIa, i6);
        this.vIa += 4;
        if ((this.vIa + length) + 1 > this.vHZ) {
            this.vHZ = ((this.vIa + length) + 1) + FileUtils.S_IWUSR;
            Object obj = new byte[this.vHZ];
            System.arraycopy(this.vIf, 0, obj, 0, this.vIa);
            this.vIf = obj;
        }
        System.arraycopy(bArr, 0, this.vIf, this.vIa, length);
        this.vIa = length + this.vIa;
        util.A(this.vIf, this.vIa, 3);
        this.vIa++;
    }

    public final int X(byte[] bArr, int i) {
        int i2 = 0;
        if (i <= this.vId + 2) {
            return -1009;
        }
        this.vIe = (i - this.vId) - 2;
        if (i > this.vHZ) {
            this.vHZ = i + FileUtils.S_IWUSR;
            this.vIf = new byte[this.vHZ];
        }
        this.vIa = i;
        System.arraycopy(bArr, 0, this.vIf, 0, i);
        int i3 = this.vId + 1;
        Object decrypt = oicq.wlogin_sdk.tools.d.decrypt(this.vIf, i3, this.vIe, this.vIo.vIs);
        if (decrypt == null) {
            i2 = -1002;
        } else {
            this.vIe = decrypt.length;
            if ((decrypt.length + this.vId) + 2 > this.vHZ) {
                this.vHZ = (decrypt.length + this.vId) + 2;
                Object obj = new byte[this.vHZ];
                System.arraycopy(this.vIf, 0, obj, 0, this.vIa);
                this.vIf = obj;
            }
            this.vIa = 0;
            System.arraycopy(decrypt, 0, this.vIf, i3, decrypt.length);
            this.vIa = (decrypt.length + (this.vId + 2)) + this.vIa;
        }
        if (i2 >= 0) {
            return x(this.vIf, this.vId + 1, this.vIe);
        }
        return -1002;
    }

    public final byte[] cKa() {
        Object obj = new byte[this.vIa];
        System.arraycopy(this.vIf, 0, obj, 0, this.vIa);
        return obj;
    }

    final byte[] v(byte[] bArr, int i, int i2) {
        Object obj = new byte[(bArr.length + 4)];
        util.B(obj, 0, i);
        util.B(obj, 2, i2);
        System.arraycopy(bArr, 0, obj, 4, bArr.length);
        obj = oicq.wlogin_sdk.tools.d.b(obj, obj.length, this.vIo.vIs);
        Object obj2 = new byte[(obj.length + this.vIo.vIs.length)];
        System.arraycopy(this.vIo.vIs, 0, obj2, 0, this.vIo.vIs.length);
        System.arraycopy(obj, 0, obj2, this.vIo.vIs.length, obj.length);
        return obj2;
    }

    public final int Y(byte[] bArr, int i) {
        this.vIn = bArr[i];
        return bArr[i] & 255;
    }

    public final void w(byte[] bArr, int i, int i2) {
        a aiVar = new ai();
        if (aiVar.z(bArr, i, i2) >= 0) {
            ErrMsg errMsg = this.vIo.vIO;
            Object obj = new byte[aiVar.vJD];
            System.arraycopy(aiVar.vIf, aiVar.vIU + 6, obj, 0, aiVar.vJD);
            errMsg.title = new String(obj);
            errMsg = this.vIo.vIO;
            obj = new byte[aiVar.vJE];
            System.arraycopy(aiVar.vIf, (aiVar.vIU + 8) + aiVar.vJD, obj, 0, aiVar.vJE);
            errMsg.message = new String(obj);
            errMsg = this.vIo.vIO;
            obj = new byte[aiVar.vJF];
            System.arraycopy(aiVar.vIf, ((aiVar.vIU + 12) + aiVar.vJD) + aiVar.vJE, obj, 0, aiVar.vJF);
            errMsg.vJM = new String(obj);
            return;
        }
        this.vIo.vIO.cKi();
    }

    public final void cKb() {
        this.vIo.vIO.cKi();
    }

    public final byte[] bV(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[(bArr.length + this.vIo.vIq.length)];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        System.arraycopy(this.vIo.vIq, 0, bArr2, bArr.length, this.vIo.vIq.length);
        return bArr2;
    }

    public final byte[] bW(byte[] bArr) {
        if (bArr == null || bArr.length < 16) {
            return null;
        }
        byte[] bArr2 = (byte[]) bArr.clone();
        int length = bArr2.length - 16;
        Object obj = new byte[length];
        System.arraycopy(bArr2, 0, obj, 0, length);
        this.vIo.vIq = new byte[16];
        System.arraycopy(bArr2, length, this.vIo.vIq, 0, 16);
        return obj;
    }

    private int a(s sVar) {
        long j = 4294967295L;
        a oVar = new o();
        a pVar = new p();
        a lVar = new l();
        a qVar = new q();
        a eVar = new e();
        a tVar = new t();
        a dVar = new oicq.wlogin_sdk.a.d();
        a mVar = new m();
        a uVar = new u();
        a wVar = new w();
        a xVar = new x();
        a jVar = new j();
        a hVar = new h();
        a nVar = new n();
        a zVar = new z();
        a vVar = new v();
        a adVar = new ad();
        a abVar = new ab();
        a afVar = new af();
        a apVar = new ap();
        a akVar = new ak();
        a alVar = new al();
        a amVar = new am();
        byte[] bArr = null;
        byte[] bArr2 = null;
        byte[] bArr3 = null;
        byte[] bArr4 = null;
        byte[] bArr5 = null;
        byte[] bArr6 = null;
        byte[] bArr7 = null;
        byte[] bArr8 = null;
        a acVar = new ac();
        byte[] cKd = sVar.cKd();
        int length = cKd.length;
        oVar.z(cKd, 2, length);
        pVar.z(cKd, 2, length);
        lVar.z(cKd, 2, length);
        qVar.z(cKd, 2, length);
        int z = tVar.z(cKd, 2, length);
        if (z < 0) {
            return z;
        }
        Object obj;
        long ad;
        long j2;
        long j3;
        if (eVar.z(cKd, 2, length) >= 0) {
            bArr6 = eVar.cKd();
        }
        if (jVar.z(cKd, 2, length) >= 0) {
            util.a(this.vIo._context, jVar.cKd());
        }
        if (dVar.z(cKd, 2, length) >= 0) {
            bArr = dVar.cKd();
        }
        if (mVar.z(cKd, 2, length) >= 0) {
            bArr2 = mVar.cKd();
        }
        if (uVar.z(cKd, 2, length) >= 0) {
            bArr3 = uVar.cKd();
        }
        if (wVar.z(cKd, 2, length) >= 0) {
            bArr4 = wVar.cKd();
        }
        if (xVar.z(cKd, 2, length) >= 0) {
            bArr5 = xVar.cKd();
        }
        if (zVar.z(cKd, 2, length) >= 0) {
            bArr7 = new byte[zVar.vJt];
            System.arraycopy(zVar.vIf, zVar.vIU + 2, bArr7, 0, bArr7.length);
            bArr8 = new byte[zVar.vJu];
            System.arraycopy(zVar.vIf, ((zVar.vIU + 2) + zVar.vJt) + 2, bArr8, 0, bArr8.length);
        }
        if (alVar.z(cKd, 2, length) >= 0) {
            a hVar2 = new h();
            eVar = new n();
            dVar = new am();
            ah ahVar = new ah();
            byte[] cKd2 = alVar.cKd();
            int length2 = cKd2.length;
            if (hVar2.z(cKd2, 2, length2) < 0) {
                obj = null;
            } else if (eVar.z(cKd2, 2, length2) < 0) {
                obj = null;
            } else if (dVar.z(cKd2, 2, length2) < 0) {
                obj = null;
            } else {
                Object cKa = hVar2.cKa();
                obj = eVar.cKa();
                Object cKa2 = dVar.cKa();
                Object cc = ahVar.cc(this.vIo.vIz);
                Object obj2 = new byte[((((cKa.length + 3) + obj.length) + cKa2.length) + cc.length)];
                obj2[0] = (byte) 64;
                util.B(obj2, 1, 4);
                System.arraycopy(cKa, 0, obj2, 3, cKa.length);
                int length3 = cKa.length + 3;
                System.arraycopy(obj, 0, obj2, length3, obj.length);
                int length4 = obj.length + length3;
                System.arraycopy(cKa2, 0, obj2, length4, cKa2.length);
                System.arraycopy(cc, 0, obj2, length4 + cKa2.length, cc.length);
                obj = obj2;
            }
            if (obj == null || obj.length <= 0) {
                this.vIo.vIR = new byte[0];
            } else {
                this.vIo.vIR = (byte[]) obj.clone();
                util.gz("fast data:", util.cg(obj));
            }
        }
        byte[][] bArr9 = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{7, 0});
        if (acVar.z(cKd, 2, length) >= 0) {
            bArr9[0] = acVar.cKd();
        }
        z = nVar.z(cKd, 2, length);
        if (hVar.z(cKd, 2, length) >= 0 && z >= 0) {
            this.vIo.vIq = nVar.cKd();
            this.vIo.vIP = bV(hVar.cKd());
            bArr9[1] = (byte[]) this.vIo.vIP.clone();
        }
        if (abVar.z(cKd, 2, length) >= 0) {
            obj = new byte[abVar.vJw];
            System.arraycopy(abVar.vIf, abVar.vIU + 2, obj, 0, obj.length);
            bArr9[2] = obj;
        }
        if (afVar.z(cKd, 2, length) >= 0) {
            bArr9[3] = afVar.cKd();
        }
        if (apVar.z(cKd, 2, length) >= 0) {
            bArr9[4] = apVar.cKd();
        }
        if (akVar.z(cKd, 2, length) >= 0) {
            bArr9[5] = akVar.cKd();
        }
        if (amVar.z(cKd, 2, length) >= 0) {
            bArr9[6] = amVar.cKd();
        }
        if (vVar.z(cKd, 2, length) >= 0) {
            if (this.vIo.vIx == -1) {
                ad = (long) util.ad(vVar.vIf, vVar.vIU);
            } else {
                ad = this.vIo.vIx;
            }
            j = 4294967295L & ((long) util.ad(vVar.vIf, vVar.vIU + 4));
            j2 = ad;
        } else {
            j2 = 3600;
        }
        if (adVar.z(cKd, 2, length) < 0 || adVar.cKh() == 0) {
            ad = 2160000;
        } else {
            ad = (long) adVar.cKh();
        }
        if (ad < j2) {
            j3 = j2;
        } else {
            j3 = ad;
        }
        i iVar = this.vIo;
        long j4 = this.vIo._uin;
        long j5 = this.vIo.vIv;
        long cKc = i.cKc();
        j2 += i.cKc();
        j3 += i.cKc();
        Object obj3 = new byte[2];
        System.arraycopy(tVar.vIf, tVar.vIU, obj3, 0, 2);
        Object obj4 = new byte[1];
        System.arraycopy(tVar.vIf, tVar.vIU + 2, obj4, 0, 1);
        Object obj5 = new byte[1];
        System.arraycopy(tVar.vIf, (tVar.vIU + 2) + 1, obj5, 0, 1);
        Object obj6 = new byte[tVar.vJr];
        System.arraycopy(tVar.vIf, (((tVar.vIU + 2) + 1) + 1) + 1, obj6, 0, tVar.vJr);
        iVar.a(j4, j5, j, cKc, j2, j3, obj3, obj4, obj5, obj6, lVar.cKd(), oVar.cKd(), qVar.cKd(), pVar.cKd(), bArr6, bArr2, bArr, bArr3, bArr4, bArr5, bArr7, bArr8, bArr9);
        return 0;
    }

    public int x(byte[] bArr, int i, int i2) {
        Object obj;
        a fVar = new f();
        a gVar = new g();
        a sVar = new s();
        int obj2;
        if (this.vIl == 2064 && this.vIm == 9) {
            obj2 = null;
        } else if (this.vIl == 2064 && this.vIm == 10) {
            obj2 = 1;
        } else if (this.vIl == 2064 && this.vIm == 2) {
            obj2 = 2;
        } else if (this.vIl != 2064 || this.vIm != 13) {
            return -1012;
        } else {
            obj2 = 4;
        }
        if (i2 < 5) {
            return -1009;
        }
        int Y = Y(bArr, i + 2);
        cKb();
        int i3 = i + 5;
        switch (Y) {
            case 0:
                if (obj2 != 1) {
                    Y = sVar.b(bArr, i3, (this.vIa - i3) - 1, this.vIo.vIq);
                } else if (this.vIo.vIr == null) {
                    return -1006;
                } else {
                    Y = sVar.b(bArr, i3, (this.vIa - i3) - 1, this.vIo.vIr);
                }
                if (Y < 0) {
                    util.adN("119 can not decrypt, ret=" + Y);
                    return Y;
                }
                Y = a(sVar);
                if (Y >= 0) {
                    return 0;
                }
                util.adN("parse 119 failed, ret=" + Y);
                return Y;
            case 1:
                w(bArr, i3, (this.vIa - i3) - 1);
                return Y;
            case 2:
                int z = fVar.z(bArr, i3, (this.vIa - i3) - 1);
                if (z >= 0) {
                    this.vIo.vIt = fVar;
                    z = gVar.z(bArr, i3, (this.vIa - i3) - 1);
                    if (z >= 0) {
                        this.vIo.vIu = gVar;
                        return Y;
                    }
                }
                return z;
            default:
                w(bArr, i3, (this.vIa - i3) - 1);
                return Y;
        }
    }
}
