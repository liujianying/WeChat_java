package com.tencent.mm.plugin.honey_pay;

import com.tencent.mm.ab.d.a;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URLDecoder;
import java.util.Map;

class a$4 implements n {
    final /* synthetic */ a kjz;

    a$4(a aVar) {
        this.kjz = aVar;
    }

    public final void onNewXmlReceived(String str, Map<String, String> map, a aVar) {
        if (bi.getInt((String) map.get(".sysmsg.paymsg.PayMsgType"), 0) == 35) {
            x.i("MicroMsg.SubCoreHoneyPay", "receive honey pay newxml");
            String str2 = (String) map.get(".sysmsg.paymsg.appmsgcontent");
            String str3 = (String) map.get(".sysmsg.paymsg.fromusername");
            String str4 = (String) map.get(".sysmsg.paymsg.tousername");
            String str5 = (String) map.get(".sysmsg.paymsg.paymsgid");
            String str6 = (String) map.get(".sysmsg.paymsg.systip");
            if (!bi.oW(str2)) {
                x.d("MicroMsg.SubCoreHoneyPay", "appmsg: %s", new Object[]{URLDecoder.decode(str2)});
                c.k(str5, str2, str4, str3);
            }
            if (!bi.oW(str6)) {
                x.d("MicroMsg.SubCoreHoneyPay", "systip: %s", new Object[]{URLDecoder.decode(str6)});
                c.S(str4, str2, str3);
            }
        }
    }
}
