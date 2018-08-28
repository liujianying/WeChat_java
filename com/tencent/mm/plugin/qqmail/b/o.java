package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.f;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.l.a;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.bvw;
import com.tencent.mm.protocal.c.bvx;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Random;

public final class o extends l implements k {
    private String bWQ;
    private int dHI = 0;
    private int dHJ = 0;
    private f dVg;
    private b diG;
    private e diJ;
    public String filePath = null;

    public o(String str, String str2, f fVar) {
        this.filePath = str;
        this.bWQ = str2 + "_" + System.nanoTime() + "_" + Math.abs(new Random().nextInt() / 2);
        this.dVg = fVar;
        x.i("MicroMsg.NetSceneUploadFie", "msgId: %s, filePath: %s", new Object[]{this.bWQ, this.filePath});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, netId: %d, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            bvx bvx = (bvx) ((b) qVar).dIE.dIL;
            String str2 = bvx.rcc;
            x.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, clientId: %s, totalLen: %d, attachId: %s", new Object[]{bvx.rcc, Integer.valueOf(bvx.rdV), bvx.ruD});
            if (str2.equals(this.bWQ)) {
                this.dHJ = bvx.rdW;
                if (this.dHJ < this.dHI) {
                    x.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, startPos: %d, totalLen: %d, continue to upload", new Object[]{Integer.valueOf(this.dHJ), Integer.valueOf(this.dHI)});
                    if (a(this.dIX, this.diJ) < 0) {
                        x.e("MicroMsg.NetSceneUploadFie", "continue to upload fail");
                        if (this.diJ != null) {
                            this.diJ.a(i2, i3, str, this);
                        }
                        if (this.dVg != null) {
                            this.dVg.a(this.dHJ, this.dHI, this);
                            return;
                        }
                        return;
                    }
                }
                String str3 = bvx.ruD;
                x.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, finish upload, startPos: %d, totalLen: %d, attachId: %s", new Object[]{Integer.valueOf(this.dHJ), Integer.valueOf(this.dHI), str3});
                if (this.diJ != null) {
                    this.diJ.a(i2, i3, str, this);
                }
                if (this.dVg != null) {
                    this.dVg.a(this.dHJ, this.dHI, this);
                }
            }
        } else if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }

    protected final int Cc() {
        return 640;
    }

    protected final int a(q qVar) {
        if (!bi.oW(this.filePath) && com.tencent.mm.a.e.cn(this.filePath)) {
            return l.b.dJm;
        }
        x.e("MicroMsg.NetSceneUploadFie", "securityVerificationChecked failed, file not exist");
        return l.b.dJn;
    }

    protected final void a(a aVar) {
    }

    public final int getType() {
        return 484;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        if (bi.oW(this.filePath)) {
            x.e("MicroMsg.NetSceneUploadFie", "doScene, filePath is null");
            return -1;
        } else if (com.tencent.mm.a.e.cn(this.filePath)) {
            if (this.dHI == 0) {
                this.dHI = com.tencent.mm.a.e.cm(this.filePath);
                x.i("MicroMsg.NetSceneUploadFie", "doScene, totalLen: %d", new Object[]{Integer.valueOf(this.dHI)});
            }
            int min = Math.min(this.dHI - this.dHJ, 32768);
            x.i("MicroMsg.NetSceneUploadFie", "doScene, startPos: %d, dataLen: %d", new Object[]{Integer.valueOf(this.dHJ), Integer.valueOf(min)});
            byte[] e = com.tencent.mm.a.e.e(this.filePath, this.dHJ, min);
            if (e == null) {
                x.e("MicroMsg.NetSceneUploadFie", "doScene, read file buf is null");
                return -1;
            }
            x.i("MicroMsg.NetSceneUploadFie", "doScene, buf.length: %d", new Object[]{Integer.valueOf(e.length)});
            b.a aVar = new b.a();
            aVar.dIG = new bvw();
            aVar.dIH = new bvx();
            aVar.uri = "/cgi-bin/micromsg-bin/uploadfile";
            aVar.dIF = 484;
            aVar.dII = 0;
            aVar.dIJ = 0;
            this.diG = aVar.KT();
            bvw bvw = (bvw) this.diG.dID.dIL;
            bvw.rcc = this.bWQ;
            bvw.rdV = this.dHI;
            bvw.rdW = this.dHJ;
            bvw.rdX = min;
            bvw.rtW = ab.O(e);
            x.i("MicroMsg.NetSceneUploadFie", "doScene, ret: %d", new Object[]{Integer.valueOf(a(eVar, this.diG, this))});
            return a(eVar, this.diG, this);
        } else {
            x.e("MicroMsg.NetSceneUploadFie", "doScene, file: %s not exist", new Object[]{this.filePath});
            return -1;
        }
    }

    public final bvx boq() {
        if (this.diG != null) {
            return (bvx) this.diG.dIE.dIL;
        }
        return null;
    }
}
