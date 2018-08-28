package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.ui.WxaBindBizInfoUI.3;
import com.tencent.mm.protocal.c.akq;
import com.tencent.mm.protocal.c.gv;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class WxaBindBizInfoUI$3$1 implements a {
    final /* synthetic */ 3 gxa;

    WxaBindBizInfoUI$3$1(3 3) {
        this.gxa = 3;
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        if (i == 0 && i2 == 0) {
            akq akq = (akq) bVar.dIE.dIL;
            LinkedList linkedList = akq.rNw;
            boolean z = akq.rNx;
            WxaBindBizInfoUI.a(this.gxa.gwZ, akq.rNv);
            if (z) {
                WxaBindBizInfoUI.c(this.gxa.gwZ).ds(false);
                WxaBindBizInfoUI.d(this.gxa.gwZ).cAH();
                this.gxa.gwZ.gwW.gxc = true;
                WxaBindBizInfoUI.e(this.gxa.gwZ).setVisibility(0);
            }
            if (!(linkedList == null || linkedList.isEmpty())) {
                List linkedList2 = new LinkedList();
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    gv gvVar = (gv) it.next();
                    if (gvVar != null) {
                        WxaEntryInfo wxaEntryInfo = new WxaEntryInfo();
                        wxaEntryInfo.title = gvVar.nickname;
                        wxaEntryInfo.iconUrl = gvVar.lMY;
                        wxaEntryInfo.username = gvVar.username;
                        linkedList2.add(wxaEntryInfo);
                    }
                }
                this.gxa.gwZ.gwW.ap(linkedList2);
            }
        } else {
            x.e("MicroMsg.WxaBindBizInfoUI", "onResp, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        }
        return 0;
    }
}
