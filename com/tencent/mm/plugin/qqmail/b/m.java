package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.a.g;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.f;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.l.a;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.pt;
import com.tencent.mm.protocal.c.pu;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Random;

public final class m extends l implements k {
    private String bSS;
    private String clientId = null;
    private int dHI = 0;
    private int dHJ = 0;
    private f dVg;
    private b diG;
    private e diJ;
    private String mcV = null;
    private String mcW;
    private int mcX = 0;

    public m(String str, String str2, String[] strArr, int i, f fVar) {
        this.mcV = str;
        this.mcX = i;
        this.dVg = fVar;
        if (!bi.oW(str)) {
            this.clientId = g.u(str.getBytes()) + "_" + System.nanoTime() + "_" + new Random().nextInt();
            this.dHI = str.getBytes().length;
            this.dHJ = 0;
        }
        if (!bi.oW(str2)) {
            this.bSS = str2;
        }
        if (strArr != null) {
            this.mcW = "";
            for (String str3 : strArr) {
                this.mcW += str3 + ",";
            }
            this.mcW = this.mcW.substring(0, this.mcW.length() - 1);
        }
        x.i("MicroMsg.NetSceneComposeSend", "NetSceneComposeSend, clientId: %s, totalLen: %d", new Object[]{this.clientId, Integer.valueOf(this.dHI)});
    }

    protected final int Cc() {
        return 100;
    }

    protected final int a(q qVar) {
        if (!bi.oW(this.mcV)) {
            return l.b.dJm;
        }
        x.e("MicroMsg.NetSceneComposeSend", "securityVerificationChecked failed, content is null");
        return l.b.dJn;
    }

    protected final void a(a aVar) {
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneComposeSend", "onGYNetEnd, netId: %d, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            this.dHJ = ((pu) ((b) qVar).dIE.dIL).rdW;
            if (this.diJ != null) {
                this.diJ.a(i2, i3, str, this);
            }
            if (this.dVg != null) {
                this.dVg.a(this.dHJ, this.dHI, this);
            }
            if (this.dHJ < this.dHI) {
                x.i("MicroMsg.NetSceneComposeSend", "onGYNetEnd, startPos: %d, totalLen: %d, continue to upload", new Object[]{Integer.valueOf(this.dHJ), Integer.valueOf(this.dHI)});
                if (a(this.dIX, this.diJ) < 0) {
                    x.e("MicroMsg.NetSceneComposeSend", "continue to upload fail");
                    return;
                }
                return;
            }
            x.i("MicroMsg.NetSceneComposeSend", "finished upload");
        } else if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 485;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        if (bi.oW(this.mcV)) {
            x.e("MicroMsg.NetSceneComposeSend", "doScene, sendContent is null");
            return -1;
        }
        int min = Math.min(this.dHI - this.dHJ, 32768);
        x.i("MicroMsg.NetSceneComposeSend", "doScene, dataLen: %d", new Object[]{Integer.valueOf(min)});
        byte[] bArr = new byte[min];
        byte[] bytes = this.mcV.getBytes();
        int i = 0;
        for (int i2 = this.dHJ; i2 < this.dHJ + min; i2++) {
            bArr[i] = bytes[i2];
            i++;
        }
        if (bi.bC(bArr)) {
            x.e("MicroMsg.NetSceneComposeSend", "doScene, sendData is null");
            return -1;
        }
        b.a aVar = new b.a();
        aVar.dIG = new pt();
        aVar.dIH = new pu();
        aVar.uri = "/cgi-bin/micromsg-bin/composesend";
        aVar.dIF = 485;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        pt ptVar = (pt) this.diG.dID.dIL;
        ptVar.rcc = this.clientId;
        ptVar.rdV = this.dHI;
        ptVar.rdW = this.dHJ;
        ptVar.rdX = min;
        ptVar.rtX = this.bSS;
        ptVar.rtY = this.mcW;
        ptVar.rtZ = (int) (((float) this.dHI) + (((float) this.mcX) * 1.3333334f));
        x.i("MicroMsg.NetSceneComposeSend", "doScene, realSize: %d", new Object[]{Integer.valueOf(ptVar.rtZ)});
        ptVar.rtW = ab.O(bArr);
        x.i("MicroMsg.NetSceneComposeSend", "doScene, ret: %d", new Object[]{Integer.valueOf(a(eVar, this.diG, this))});
        return a(eVar, this.diG, this);
    }
}
