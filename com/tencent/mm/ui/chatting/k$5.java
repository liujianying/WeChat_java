package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.os.Looper;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelcdntran.i$a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.bd;
import com.tencent.mm.y.g.a;
import java.io.ByteArrayOutputStream;

class k$5 implements i$a {
    final /* synthetic */ bd dAs;
    final /* synthetic */ String dhF;
    final /* synthetic */ a fZg;
    final /* synthetic */ boolean tIH;
    final /* synthetic */ b tIK;
    final /* synthetic */ Context val$context;

    k$5(a aVar, b bVar, Context context, String str, bd bdVar, boolean z) {
        this.fZg = aVar;
        this.tIK = bVar;
        this.val$context = context;
        this.dhF = str;
        this.dAs = bdVar;
        this.tIH = z;
    }

    public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
        if (i == 0 && keep_sceneresult != null && keep_sceneresult.field_retCode == 0) {
            if (!(bi.oW(this.fZg.dwu) || this.tIK == null)) {
                this.tIK.field_status = 199;
                this.tIK.field_offset = this.tIK.field_totalLen;
                ao.asF().c(this.tIK, new String[0]);
                au.HU();
                bd dW = c.FT().dW(this.tIK.field_msgInfoId);
                dW.setStatus(3);
                au.HU();
                c.FT().a(dW.field_msgId, dW);
            }
            new ag(Looper.getMainLooper()).post(new 1(this));
        }
        return 0;
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] i(String str, byte[] bArr) {
        return new byte[0];
    }
}
