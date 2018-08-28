package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mm.ab.d.a;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am.6;
import com.tencent.mm.plugin.card.sharecard.a.c;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class am$6$1 implements Runnable {
    final /* synthetic */ a dAr;
    final /* synthetic */ String fhM;
    final /* synthetic */ 6 hxZ;

    am$6$1(6 6, String str, a aVar) {
        this.hxZ = 6;
        this.fhM = str;
        this.dAr = aVar;
    }

    public final void run() {
        c axs = am.axs();
        Object obj = this.fhM;
        x.i("MicroMsg.ShareCardMsgMgr", "sharecard onReceiveMsg msgId is " + (this.dAr.dIN.rcq));
        if (!TextUtils.isEmpty(obj)) {
            c.a aVar;
            Map z = bl.z(obj, "sysmsg");
            if (z == null) {
                aVar = null;
            } else {
                c.a aVar2 = new c.a(axs);
                String str = (String) z.get(".sysmsg.notifysharecard.state_flag");
                if (TextUtils.isEmpty(str) || !l.xW(str)) {
                    aVar2.hyk = 0;
                } else {
                    aVar2.hyk = Integer.valueOf(str).intValue();
                }
                aVar2.username = (String) z.get(".sysmsg.notifysharecard.username");
                aVar2.cac = (String) z.get(".sysmsg.notifysharecard.card_id");
                aVar = aVar2;
            }
            if (aVar == null) {
                x.e("MicroMsg.ShareCardMsgMgr", "card msg == null");
                return;
            }
            if (TextUtils.isEmpty(aVar.cac)) {
                x.e("MicroMsg.ShareCardMsgMgr", "card id == null");
            }
            x.i("MicroMsg.ShareCardMsgMgr", "sharecard doSyncNetScene card id is " + aVar.cac);
            am.axp().axD();
            l.azS();
        }
    }
}
