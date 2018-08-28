package com.tencent.mm.insane_statistic;

import com.tencent.mm.g.a.mu;
import com.tencent.mm.insane_statistic.b.a;
import com.tencent.mm.model.m;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bwi;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.g;
import java.net.URLEncoder;

class b$a$1 extends c<mu> {
    final /* synthetic */ a dlY;

    b$a$1(a aVar) {
        this.dlY = aVar;
        this.sFo = mu.class.getName().hashCode();
    }

    private boolean a(mu muVar) {
        if (muVar.bXK.filePath.equals(this.dlY.dlS)) {
            String encode;
            String str = "";
            try {
                encode = URLEncoder.encode(muVar.bXK.result, "UTF-8");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.OnNetSceneUploadMsgImgEnd", e, "", new Object[0]);
                encode = str;
            }
            if (this.dlY.dlV) {
                x.i("MicroMsg.OnNetSceneUploadMsgImgEnd", "androidSystemShareFixed(13717) , imgLocalId:%d, scene.hash:%d, %s, filePath:%s", new Object[]{Long.valueOf(this.dlY.dlN), Integer.valueOf(this.dlY.hashCode()), this.dlY.dlQ + encode, muVar.bXK.filePath});
                h.mEJ.k(13717, str);
            }
            if (this.dlY.dlT == 1) {
                d dVar = new d();
                bwi bwi = (bwi) this.dlY.diG.dID.dIL;
                dVar.r("20toUser", bwi.rck.siM + ",");
                dVar.r("21source", this.dlY.dlO + ",");
                dVar.r("22qrUrl", encode + ",");
                dVar.r("23md5", (this.dlY.dlU == null ? "" : this.dlY.dlU.field_filemd5) + ",");
                dVar.r("24cdnFileId", (this.dlY.dlU == null ? "" : this.dlY.dlU.field_fileId) + ",");
                dVar.r("25cdnAesKey", (this.dlY.dlU == null ? "" : this.dlY.dlU.field_aesKey) + ",");
                encode = "";
                if (this.dlY.bGS.aQm()) {
                    g.a gp = g.a.gp(this.dlY.bGS.field_content);
                    if (gp != null) {
                        encode = gp.appId;
                    }
                }
                dVar.r("26appip", encode + ",");
                dVar.r("27toUsersCount", m.gK(bwi.rck.siM) + ",");
                dVar.r("28codeType", Integer.valueOf(muVar.bXK.bJr));
                x.i("MicroMsg.OnNetSceneUploadMsgImgEnd", "report qrCodeImgChatting(13628): " + dVar.wF());
                o.u(13628, dVar.toString());
            }
            a.a(this.dlY);
        }
        return false;
    }
}
