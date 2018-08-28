package com.tencent.mm.at;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bvo;
import com.tencent.mm.protocal.c.bvp;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import java.io.File;

public final class b extends l implements k {
    private String bSw;
    private String clientId;
    private int dHI;
    private int dHJ;
    private com.tencent.mm.ab.b diG;
    private e diJ;
    public String edD;
    private String username;

    public b(String str, String str2) {
        this(str);
        this.bSw = str2;
    }

    private b(String str) {
        this.username = str;
        this.dHI = 0;
        this.dHJ = 0;
        StringBuilder stringBuilder = new StringBuilder();
        g.Eg();
        this.clientId = stringBuilder.append(a.Df()).append(System.currentTimeMillis()).toString();
    }

    public final int getType() {
        return 575;
    }

    protected final int a(q qVar) {
        if (this.bSw == null || this.bSw.length() == 0) {
            return com.tencent.mm.ab.l.b.dJn;
        }
        return com.tencent.mm.ab.l.b.dJm;
    }

    protected final int Cc() {
        return 100;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        if (this.bSw == null || this.bSw.length() == 0) {
            x.e("MicroMsg.NetSceneUploadCardImg", "imgPath is null or length = 0");
            return -1;
        } else if (com.tencent.mm.a.e.cn(this.bSw)) {
            if (this.dHI == 0) {
                this.dHI = (int) new File(this.bSw).length();
            }
            com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
            aVar.dIG = new bvo();
            aVar.dIH = new bvp();
            aVar.uri = "/cgi-bin/micromsg-bin/uploadcardimg";
            aVar.dIF = 575;
            aVar.dII = 0;
            aVar.dIJ = 0;
            this.diG = aVar.KT();
            byte[] e = com.tencent.mm.a.e.e(this.bSw, this.dHJ, Math.min(this.dHI - this.dHJ, WXMediaMessage.THUMB_LENGTH_LIMIT));
            if (e == null) {
                x.e("MicroMsg.NetSceneUploadCardImg", "readFromFile error");
                return -1;
            }
            x.i("MicroMsg.NetSceneUploadCardImg", "doScene uploadLen:%d, total: %d", new Object[]{Integer.valueOf(e.length), Integer.valueOf(this.dHI)});
            bvo bvo = (bvo) this.diG.dID.dIL;
            bvo.rvx = this.username;
            bvo.rdV = this.dHI;
            bvo.rdW = this.dHJ;
            bvo.rtW = new bhy().bq(e);
            bvo.rdX = bvo.rtW.siI;
            bvo.rcc = this.clientId;
            return a(eVar, this.diG, this);
        } else {
            x.e("MicroMsg.NetSceneUploadCardImg", "The img does not exist, imgPath = " + this.bSw);
            return -1;
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneUploadCardImg", "onGYNetEnd:%s, %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            bvp bvp = (bvp) ((com.tencent.mm.ab.b) qVar).dIE.dIL;
            this.edD = bvp.rXt;
            this.dHJ = bvp.rdW;
            if (this.dHJ < this.dHI) {
                if (a(this.dIX, this.diJ) < 0) {
                    x.e("MicroMsg.NetSceneUploadCardImg", "doScene again failed");
                    this.diJ.a(3, -1, "", this);
                }
                x.d("MicroMsg.NetSceneUploadCardImg", "doScene again");
                return;
            }
            if (!bi.oW(this.edD)) {
                ab Yg = ((i) g.l(i.class)).FR().Yg(this.username);
                if (Yg != null && ((int) Yg.dhP) > 0 && com.tencent.mm.l.a.gd(Yg.field_type)) {
                    Yg.dU(this.edD);
                    ((i) g.l(i.class)).FR().a(this.username, Yg);
                }
            }
            this.diJ.a(i2, i3, str, this);
            return;
        }
        x.e("MicroMsg.NetSceneUploadCardImg", "upload card img error");
        this.diJ.a(i2, i3, str, this);
    }
}
