package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ak.o;
import com.tencent.mm.modelcdntran.i$a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.pluginsdk.model.app.j.a;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;

class j$2 implements i$a {
    final /* synthetic */ String dUT;
    final /* synthetic */ j qzU;
    final /* synthetic */ a qzV;

    j$2(j jVar, String str, a aVar) {
        this.qzU = jVar;
        this.dUT = str;
        this.qzV = aVar;
    }

    public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
        x.i("MicroMsg.AppMessageExtension", "getThumbByCdn start callback: field_mediaId:%s thumbUrl:%s", new Object[]{str, this.dUT});
        if (i != 0) {
            x.e("MicroMsg.AppMessageExtension", "getThumbByCdn start failed: startRet:%d thumbUrl:%s", new Object[]{Integer.valueOf(i), this.dUT});
            return i;
        } else if (keep_sceneresult == null) {
            return 0;
        } else {
            if (keep_sceneresult.field_retCode != 0) {
                x.e("MicroMsg.AppMessageExtension", "getThumbByCdn failed: sceneResult.field_retCode:%d thumbUrl:%s", new Object[]{Integer.valueOf(keep_sceneresult.field_retCode), this.dUT});
            } else {
                x.i("MicroMsg.AppMessageExtension", "getThumbByCdn finished thumbUrl:%s", new Object[]{this.dUT});
            }
            o.Pf().doNotify();
            if (this.qzV != null) {
                this.qzV.cbR();
            }
            return 0;
        }
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] i(String str, byte[] bArr) {
        return null;
    }
}
