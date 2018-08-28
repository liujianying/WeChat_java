package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.g.a.mu;
import com.tencent.mm.model.au;
import com.tencent.mm.model.m;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.y.g.a;
import java.net.URLEncoder;

class al$2 extends c<mu> {
    final /* synthetic */ al qAD;

    al$2(al alVar) {
        this.qAD = alVar;
        this.sFo = mu.class.getName().hashCode();
    }

    private boolean a(mu muVar) {
        if (muVar.bXK.filePath.equals(this.qAD.qAe.field_fileFullPath)) {
            String str = "";
            try {
                str = URLEncoder.encode(muVar.bXK.result, "UTF-8");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneUploadAppAttach", e, "", new Object[0]);
            }
            if (this.qAD.dlT == 1) {
                au.HU();
                bd dW = com.tencent.mm.model.c.FT().dW(this.qAD.qAe.field_msgInfoId);
                d dVar = new d();
                dVar.r("20toUser", this.qAD.toUser + ",");
                dVar.r("21source", "4,");
                dVar.r("22qrUrl", str + ",");
                dVar.r("23md5", (this.qAD.dlU == null ? "" : this.qAD.dlU.field_filemd5) + ",");
                dVar.r("24cdnFileId", (this.qAD.dlU == null ? "" : this.qAD.dlU.field_fileId) + ",");
                dVar.r("25cdnAesKey", (this.qAD.dlU == null ? "" : this.qAD.dlU.field_aesKey) + ",");
                str = "";
                if (dW.aQm()) {
                    a gp = a.gp(dW.field_content);
                    if (gp != null) {
                        str = gp.appId;
                    }
                }
                dVar.r("26appip", str + ",");
                dVar.r("27toUsersCount", m.gK(this.qAD.toUser) + ",");
                dVar.r("28codeType", Integer.valueOf(muVar.bXK.bJr));
                x.i("MicroMsg.NetSceneUploadAppAttach", "report qrCodeImgChatting(13628): " + dVar.wF());
                o.u(13628, dVar.toString());
            }
            com.tencent.mm.sdk.b.a.sFg.c(this.qAD.dlW);
        }
        return false;
    }
}
