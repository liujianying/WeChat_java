package com.tencent.mm.y;

import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.y.g.a;
import java.util.Map;

public class b extends d {
    public String bXu;
    public String dvN;
    public String dvO;
    public String dvP;
    public String dvQ;
    public String dvR;
    public String dvS;
    public String dvT;
    public String dvU;
    public String dvV;
    public String dvW;
    public String dvX;
    public String dvY;
    public String dvZ;
    public String dwa;
    public String dwb;
    public String dwc;
    public String dwd;
    public String dwe;
    public String dwf;

    public final d FD() {
        return new b();
    }

    public final void a(StringBuilder stringBuilder, a aVar, String str, keep_SceneResult keep_sceneresult, int i, int i2) {
    }

    public final void a(Map<String, String> map, a aVar) {
        if (aVar.type == MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK) {
            this.dvN = e(map, "templateid");
            this.dvO = e(map, "senderurl");
            this.dvP = e(map, "sendernativeurl");
            this.dvQ = e(map, "receiverurl");
            this.dvR = e(map, "receivernativeurl");
            this.dvS = e(map, "iconurl");
            this.dvT = e(map, "miniiconurl");
            this.dvU = e(map, "backgroundurl");
            this.dvV = e(map, "backgroundname");
            this.dvW = e(map, "backgroundcolor");
            this.dvX = e(map, "receivertitle");
            this.dvY = e(map, "sendertitle");
            this.dvZ = e(map, "titlecolor");
            this.dwa = e(map, "senderscenetext");
            this.dwb = e(map, "receiverscenetext");
            this.dwc = e(map, "senderdes");
            this.dwd = e(map, "receiverdes");
            this.dwe = e(map, "descolor");
            this.dwf = e(map, "sceneid");
            this.bXu = e(map, "paymsgid");
        }
    }

    private static String e(Map<String, String> map, String str) {
        return bi.oV((String) map.get(".msg.appmsg.wcpaythirdinfo." + str));
    }
}
