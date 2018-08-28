package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.webview.model.r;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class g$14 implements e {
    final /* synthetic */ g qiK;

    g$14(g gVar) {
        this.qiK = gVar;
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
            hashMap.put("package", rVar.pRp);
            hashMap.put("sign", rVar.sign);
            hashMap.put("headImgUrl", rVar.pRq);
            hashMap.put("nickName", rVar.pRr);
            hashMap.put("friendRelation", Integer.valueOf(rVar.pRs));
            x.d("MicroMsg.MsgHandler", "select single contact : opnid:%s, sign:%s, nick_name:%s, friend_relation:%d", new Object[]{rVar.pRp, rVar.sign, rVar.pRr, Integer.valueOf(rVar.pRs)});
            g.a(this.qiK, g.k(this.qiK), "selectSingleContact:ok", hashMap);
            return;
        }
        x.e("MicroMsg.MsgHandler", "mmOnActivityResult, MMFunc_Biz_Jsapi_Getuseropendid fail");
        g.a(this.qiK, g.k(this.qiK), "selectSingleContact:fail", null);
    }
}
