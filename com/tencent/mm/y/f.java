package com.tencent.mm.y;

import android.util.Base64;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.protocal.c.bqu;
import com.tencent.mm.protocal.c.bqw;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.g.a;
import java.util.Map;

public final class f extends d {
    public final d FD() {
        return new f();
    }

    public final void a(StringBuilder stringBuilder, a aVar, String str, keep_SceneResult keep_sceneresult, int i, int i2) {
        if (!bi.oW(aVar.appId)) {
            String str2 = aVar.bZN;
            bqw bqw = new bqw();
            if (str2 != null) {
                try {
                    bqw.aG(Base64.decode(str2, 0));
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.AppContentStatExtStrPiece", e, "", new Object[0]);
                }
            }
            bqw.soY = new bqu();
            bqw.soY.jLY = aVar.appId;
            try {
                str2 = Base64.encodeToString(bqw.toByteArray(), 0).replace("\n", "");
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.AppContentStatExtStrPiece", e2, "", new Object[0]);
            }
            aVar.bZN = str2;
        }
        stringBuilder.append("<statextstr>" + bi.WS(aVar.bZN) + "</statextstr>");
    }

    public final void a(Map<String, String> map, a aVar) {
    }
}
