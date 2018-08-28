package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.b.j.6;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;

class j$6$4 implements a {
    final /* synthetic */ bd dAs;
    final /* synthetic */ b tIK;
    final /* synthetic */ 6 tOX;
    final /* synthetic */ HashSet tOY;

    j$6$4(6 6, b bVar, bd bdVar, HashSet hashSet) {
        this.tOX = 6;
        this.tIK = bVar;
        this.dAs = bdVar;
        this.tOY = hashSet;
    }

    public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
        if (i == 0 && keep_progressinfo != null) {
            this.tIK.field_offset = (long) keep_progressinfo.field_finishedLength;
            ao.asF().c(this.tIK, new String[0]);
        }
        if (i == 0 && keep_sceneresult != null && keep_sceneresult.field_retCode == 0) {
            x.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadTpFileAndFav success msgID:%d", new Object[]{Long.valueOf(this.dAs.field_msgId)});
            this.tIK.field_status = 199;
            this.tIK.field_offset = this.tIK.field_totalLen;
            ao.asF().c(this.tIK, new String[0]);
            this.dAs.setStatus(3);
            au.HU();
            c.FT().a(this.dAs.field_msgId, this.dAs);
            this.tOY.remove(Long.valueOf(this.dAs.field_msgId));
            6.a(this.tOX, this.tOY);
        }
        if (!(i == 0 && (keep_sceneresult == null || keep_sceneresult.field_retCode == 0))) {
            String str2 = "MicroMsg.ChattingMoreBtnBarHelper";
            String str3 = "oreh downloadTpFileAndFav success msgID:%d, error(%d,%d)";
            Object[] objArr = new Object[3];
            objArr[0] = Long.valueOf(this.dAs.field_msgId);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(keep_sceneresult == null ? 0 : keep_sceneresult.field_retCode);
            x.i(str2, str3, objArr);
            this.tOY.remove(Long.valueOf(this.dAs.field_msgId));
            6.a(this.tOX, this.tOY);
        }
        return 0;
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] i(String str, byte[] bArr) {
        return new byte[0];
    }
}
