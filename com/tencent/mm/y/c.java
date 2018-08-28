package com.tencent.mm.y;

import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.g.a;
import java.util.Map;

public class c extends d {
    public String dwg;
    public String dwh;
    public String dwi;

    public final d FD() {
        return new c();
    }

    public final void a(StringBuilder stringBuilder, a aVar, String str, keep_SceneResult keep_sceneresult, int i, int i2) {
    }

    public final void a(Map<String, String> map, a aVar) {
        if (aVar.type == 2001) {
            this.dwg = bi.oV((String) map.get(".msg.appmsg.wcpayinfo.locallogoicon"));
            this.dwh = bi.oV((String) map.get(".msg.appmsg.wcpayinfo.localbubbleicon"));
            this.dwi = bi.oV((String) map.get(".msg.appmsg.wcpayinfo.effectresource"));
            x.i("MicroMsg.AppContentC2cMsgPiece", "locallogoicon: %s, localbubbleicon: %s, effectResource: %s", new Object[]{this.dwg, this.dwh, this.dwi});
        }
    }
}
