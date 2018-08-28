package com.tencent.mm.plugin.record.b;

import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.record.a.f;
import com.tencent.mm.plugin.record.b.d.1;
import com.tencent.mm.pluginsdk.model.app.ab.a;
import com.tencent.mm.sdk.platformtools.x;

class d$1$1 implements a {
    final /* synthetic */ f mrX;
    final /* synthetic */ keep_SceneResult mrY;
    final /* synthetic */ 1 mrZ;

    d$1$1(1 1, f fVar, keep_SceneResult keep_sceneresult) {
        this.mrZ = 1;
        this.mrX = fVar;
        this.mrY = keep_sceneresult;
    }

    public final void ac(String str, int i, int i2) {
        x.i("MicroMsg.RecordMsgCDNService", "summersafecdn NetSceneCheckMd5 callback [%d, %d], [%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 4 && i2 == 102) {
            x.i("MicroMsg.RecordMsgCDNService", "summersafecdn NetSceneCheckMd5 MM_ERR_GET_AESKEY_FAILED old status[%d, %d, %d]", new Object[]{Integer.valueOf(this.mrX.field_status), Integer.valueOf(this.mrX.field_offset), Integer.valueOf(this.mrX.field_totalLen)});
            this.mrX.field_offset = 0;
            this.mrX.field_totalLen = 0;
            this.mrX.field_status = 0;
            n.getRecordMsgCDNStorage().b(this.mrX, "localId");
            this.mrZ.mrW.a(this.mrX, false);
            return;
        }
        this.mrX.field_cdnKey = str;
        this.mrX.field_cdnUrl = this.mrY.field_fileId;
        n.getRecordMsgCDNStorage().b(this.mrX, "localId");
        this.mrZ.mrW.bqt();
    }
}
