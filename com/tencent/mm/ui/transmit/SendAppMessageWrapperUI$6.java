package com.tencent.mm.ui.transmit;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.protocal.c.cgn;
import com.tencent.mm.protocal.c.cgv;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.g;
import java.util.Iterator;
import java.util.LinkedList;

class SendAppMessageWrapperUI$6 implements a {
    final /* synthetic */ WXMediaMessage bAi;
    final /* synthetic */ LinkedList fZf;
    final /* synthetic */ SendAppMessageWrapperUI uEK;
    final /* synthetic */ WxaAttributes uEL;
    final /* synthetic */ WXMiniProgramObject uEM;
    final /* synthetic */ String uEN;

    SendAppMessageWrapperUI$6(SendAppMessageWrapperUI sendAppMessageWrapperUI, LinkedList linkedList, WxaAttributes wxaAttributes, WXMiniProgramObject wXMiniProgramObject, String str, WXMediaMessage wXMediaMessage) {
        this.uEK = sendAppMessageWrapperUI;
        this.fZf = linkedList;
        this.uEL = wxaAttributes;
        this.uEM = wXMiniProgramObject;
        this.uEN = str;
        this.bAi = wXMediaMessage;
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        x.i("MicroMsg.SendAppMessageWrapperUI", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        cgn cgn = (cgn) bVar.dIE.dIL;
        if (i != 0 || i2 != 0 || cgn == null || cgn.sAL == null) {
            Iterator it = this.fZf.iterator();
            while (it.hasNext()) {
                com.tencent.mm.pluginsdk.model.app.l.a(this.bAi, SendAppMessageWrapperUI.e(this.uEK).field_appId, SendAppMessageWrapperUI.e(this.uEK).field_appName, (String) it.next(), 2, null, null);
            }
        } else {
            LinkedList linkedList = cgn.sAL == null ? new LinkedList() : cgn.sAL;
            x.i("MicroMsg.SendAppMessageWrapperUI", "get wxaAppShareInfoList size = %d, toUserList size = %d", new Object[]{Integer.valueOf(linkedList.size()), Integer.valueOf(this.fZf.size())});
            for (int i3 = 0; i3 < this.fZf.size(); i3++) {
                cgv cgv;
                if (i3 < linkedList.size()) {
                    cgv = (cgv) linkedList.get(i3);
                } else {
                    cgv = new cgv();
                }
                g.a aVar = new g.a();
                aVar.appId = SendAppMessageWrapperUI.e(this.uEK).field_appId;
                aVar.dyT = this.uEL.field_appId;
                aVar.dyZ = this.uEM.miniprogramType;
                aVar.appName = SendAppMessageWrapperUI.e(this.uEK).field_appName;
                aVar.dwr = 2;
                aVar.dyY = cgv.slo;
                aVar.dyX = this.uEN;
                com.tencent.mm.pluginsdk.model.app.l.a(aVar, this.bAi, (String) this.fZf.get(i3));
            }
        }
        return 0;
    }
}
