package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.webview.model.r;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;
import java.util.Map;

class g$17 implements e {
    final /* synthetic */ String bAd;
    final /* synthetic */ Intent heh;
    final /* synthetic */ g qiK;

    g$17(g gVar, Intent intent, String str) {
        this.qiK = gVar;
        this.heh = intent;
        this.bAd = str;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (g.l(this.qiK) != null && g.l(this.qiK).isShowing()) {
            g.l(this.qiK).dismiss();
            g.a(this.qiK, null);
        }
        au.DF().b(1177, this);
        if (i == 0 && i2 == 0) {
            x.i("MicroMsg.MsgHandler", "mmOnActivityResult, MMFunc_Biz_Jsapi_Getuseropendid success");
            r rVar = (r) lVar;
            Map hashMap = new HashMap();
            hashMap.put("openid", rVar.pRp);
            hashMap.put("headImgUrl", rVar.pRq);
            hashMap.put("nickName", rVar.pRr);
            x.d("MicroMsg.MsgHandler", "opnid:%s, nick_name:%s", new Object[]{rVar.pRp, rVar.pRr});
            g.a(this.qiK, null, "", this.bAd, (String) g.k(this.qiK).mcy.get("img_url"), (String) g.k(this.qiK).mcy.get("src_username"), (String) g.k(this.qiK).mcy.get("src_displayname"), this.heh == null ? null : this.heh.getStringExtra("custom_send_text"), null);
            if (g.j(this.qiK) != null) {
                h.bA(g.j(this.qiK), g.j(this.qiK).getResources().getString(R.l.app_shared));
            }
            g.a(this.qiK, g.k(this.qiK), "sendSingleAppMessage:ok", hashMap);
            return;
        }
        x.e("MicroMsg.MsgHandler", "mmOnActivityResult, MMFunc_Biz_Jsapi_Getuseropendid fail");
        g.a(this.qiK, g.k(this.qiK), "sendSingleAppMessage:fail", null);
    }
}
