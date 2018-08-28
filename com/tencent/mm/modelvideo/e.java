package com.tencent.mm.modelvideo;

import android.graphics.BitmapFactory.Options;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.l;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bku;
import com.tencent.mm.protocal.c.bkv;
import com.tencent.mm.protocal.c.btc;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends l implements k {
    private String clientId = "";
    private b diG;
    private com.tencent.mm.ab.e diJ;
    private long emf = -1;
    private r emg = null;
    private keep_SceneResult emh = null;

    public e(long j, r rVar, keep_SceneResult keep_sceneresult, String str) {
        x.i("MicroMsg.NetSceneMassUploadSight", "massSendId %d, clientId %s", new Object[]{Long.valueOf(j), str});
        this.emf = j;
        this.emg = rVar;
        this.emh = keep_sceneresult;
        this.clientId = str;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ab.e eVar2) {
        int i = 0;
        this.diJ = eVar2;
        a aVar = new a();
        aVar.dIG = new bku();
        aVar.dIH = new bkv();
        aVar.uri = "/cgi-bin/micromsg-bin/sendsight";
        aVar.dIF = 245;
        this.diG = aVar.KT();
        bku bku = (bku) this.diG.dID.dIL;
        bku.dwK = this.emh.field_aesKey;
        bku.nuY = this.clientId;
        bku.bKg = this.emg.cas;
        bku.skf = this.emg.enM;
        o.Ta();
        Options VZ = c.VZ(s.nL(this.emg.getFileName()));
        if (VZ != null) {
            bku.dwJ = VZ.outWidth;
            bku.dwI = VZ.outHeight;
        } else {
            x.w("MicroMsg.NetSceneMassUploadSight", "sight send getImageOptions for thumb failed path:%s", new Object[]{r2});
        }
        bku.emx = this.emg.enJ;
        String[] split = bi.aG(this.emg.enU, "").split(",");
        if (split == null || split.length <= 0) {
            x.e("MicroMsg.NetSceneMassUploadSight", "cdn upload video done, massSendId[%d], split username fail", new Object[]{Long.valueOf(this.emf)});
            return -1;
        }
        int length = split.length;
        while (i < length) {
            String str = split[i];
            btc btc = new btc();
            btc.username = str;
            bku.ske.add(btc);
            i++;
        }
        bku.url = this.emh.field_fileId;
        bku.enM = this.emg.dHI;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneMassUploadSight", "cdntra onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " useCdnTransClientId:" + this.clientId + " massSendId " + this.emf);
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 245;
    }
}
