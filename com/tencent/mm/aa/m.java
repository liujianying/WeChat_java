package com.tencent.mm.aa;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aeb;
import com.tencent.mm.protocal.c.aec;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import java.io.OutputStream;

final class m extends l implements k {
    private String dHB;
    private int dHF;
    private String dHH;
    private int dHX;
    private OutputStream dHY = null;
    private String dHZ;
    private e diJ;
    private String username;

    public m(String str) {
        this.username = str;
        if (ab.gY(str)) {
            this.username = ab.XV(str);
        }
        x.i("MicroMsg.NetSceneGetHDHeadImg", "init Headimage in_username:" + str + " out_username" + this.username);
        this.dHF = 480;
        this.dHX = 480;
        this.dHH = "jpg";
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        boolean z = false;
        this.diJ = eVar2;
        if (this.username == null || this.username.length() == 0) {
            x.e("MicroMsg.NetSceneGetHDHeadImg", "username is null");
            return -1;
        } else if (this.username.endsWith("@qqim")) {
            x.e("MicroMsg.NetSceneGetHDHeadImg", "never try get qq user hd.");
            return -1;
        } else {
            i KI = q.KI();
            this.dHB = q.Kp().c(this.username, true, false);
            if (FileOp.cn(this.dHB)) {
                x.i("MicroMsg.NetSceneGetHDHeadImg", "The HDAvatar of " + this.username + " is already exists");
                return 0;
            }
            h hVar;
            this.dHZ = this.dHB + ".tmp";
            h ka = KI.ka(this.username);
            if (ka == null) {
                FileOp.deleteFile(this.dHZ);
                ka = new h();
                ka.username = this.username;
                ka.dHH = this.dHH;
                ka.dHF = this.dHF;
                ka.dHG = this.dHX;
                ka.bWA = -1;
                KI.dCZ.insert("hdheadimginfo", "username", ka.wH());
                hVar = ka;
            } else {
                String str = this.dHZ;
                if (ka != null && str != null && str.length() != 0 && ka.Kv().equals(this.dHH) && ka.dHF == this.dHF && ka.dHG == this.dHX && FileOp.mI(str) == ((long) ka.dHJ)) {
                    z = true;
                }
                if (!z) {
                    FileOp.deleteFile(this.dHZ);
                    ka.reset();
                    ka.username = this.username;
                    ka.dHH = this.dHH;
                    ka.dHF = this.dHF;
                    ka.dHG = this.dHX;
                    KI.a(this.username, ka);
                }
                hVar = ka;
            }
            a aVar = new a();
            aVar.dIG = new aeb();
            aVar.dIH = new aec();
            aVar.uri = "/cgi-bin/micromsg-bin/gethdheadimg";
            aVar.dIF = 158;
            aVar.dII = 47;
            aVar.dIJ = 1000000047;
            q KT = aVar.KT();
            aeb aeb = (aeb) KT.dID.dIL;
            if (!ab.gY(this.username)) {
                aeb.hbL = this.username;
                aeb.rIp = 1;
            } else if (this.username.equals(com.tencent.mm.model.q.GF() + "@bottle")) {
                aeb.hbL = com.tencent.mm.model.q.GF();
                aeb.rIp = 2;
            } else {
                aeb.hbL = this.username;
                aeb.rIp = 2;
            }
            x.d("MicroMsg.NetSceneGetHDHeadImg", "inUser:" + this.username + " outUser:" + aeb.hbL + " outType:" + aeb.rIp);
            aeb.rIm = this.dHF;
            aeb.rIn = this.dHX;
            aeb.rIo = this.dHH;
            aeb.rdV = hVar.dHI;
            aeb.rdW = hVar.dHJ;
            return a(eVar, KT, this);
        }
    }

    protected final int a(q qVar) {
        if (this.username == null || this.username.length() == 0) {
            return b.dJn;
        }
        return b.dJm;
    }

    protected final int Cc() {
        return 10;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        aec aec = (aec) ((b) qVar).dIE.dIL;
        x.d("MicroMsg.NetSceneGetHDHeadImg", "errType:" + i2 + " errCode:" + i3);
        if (i2 != 4 && i3 != 0) {
            x.e("MicroMsg.NetSceneGetHDHeadImg", "errType:" + i2 + " errCode:" + i3);
            this.diJ.a(i2, i3, str, this);
            KA();
        } else if (i2 == 4 || i2 == 5) {
            this.diJ.a(i2, i3, str, this);
            x.e("MicroMsg.NetSceneGetHDHeadImg", "ErrType:" + i2);
            KA();
        } else {
            Object obj;
            int i4 = qVar.Id().qWB;
            if (i4 == -4 || i4 == -54 || i4 == -55) {
                x.e("MicroMsg.NetSceneGetHDHeadImg", "retcode == " + i4);
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                x.e("MicroMsg.NetSceneGetHDHeadImg", "handleCertainError");
                this.diJ.a(i2, i3, str, this);
                KA();
                return;
            }
            i4 = -1;
            if (!(aec.rtW == null || aec.rtW.siK == null)) {
                i4 = H(aec.rtW.siK.lR);
            }
            if (i4 < 0) {
                x.e("MicroMsg.NetSceneGetHDHeadImg", "appendBuf fail");
                this.diJ.a(i2, i3, str, this);
                KA();
                return;
            }
            i KI = q.KI();
            h ka = KI.ka(this.username);
            ka.dHJ = i4 + aec.rdW;
            ka.dHI = aec.rdV;
            KI.a(this.username, ka);
            if ((ka.dHJ >= ka.dHI ? 1 : null) == null) {
                x.i("MicroMsg.NetSceneGetHDHeadImg", "%d doScene again info[%s %d %d]", Integer.valueOf(hashCode()), this.username, Integer.valueOf(ka.dHJ), Integer.valueOf(ka.dHI));
                if (a(this.dIX, this.diJ) < 0) {
                    this.diJ.a(3, -1, "", this);
                    return;
                }
                return;
            }
            FileOp.av(this.dHZ, this.dHB);
            ae(this.dHB, this.username);
            KA();
            this.diJ.a(i2, i3, str, this);
        }
    }

    public static void ae(String str, String str2) {
        q.Kp().ad(str, str2);
    }

    protected final void cancel() {
        super.cancel();
        KA();
    }

    public final int getType() {
        return 158;
    }

    private int H(byte[] bArr) {
        try {
            if (this.dHY == null) {
                this.dHY = FileOp.jx(this.dHZ);
            }
            this.dHY.write(bArr);
            return bArr.length;
        } catch (Throwable e) {
            x.e("MicroMsg.NetSceneGetHDHeadImg", "exception:%s", bi.i(e));
            return -1;
        }
    }

    private void KA() {
        try {
            if (this.dHY != null) {
                this.dHY.flush();
                this.dHY.close();
                this.dHY = null;
            }
        } catch (Throwable e) {
            x.e("MicroMsg.NetSceneGetHDHeadImg", "exception:%s", bi.i(e));
        }
    }
}
