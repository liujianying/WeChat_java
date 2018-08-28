package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

class q$1 implements a {
    final /* synthetic */ l fCl;
    final /* synthetic */ q fFy;

    q$1(q qVar, l lVar) {
        this.fFy = qVar;
        this.fCl = lVar;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i != 1) {
            return;
        }
        if (i2 == -1) {
            if (intent == null) {
                this.fCl.E(this.fFy.fFw, this.fFy.f("fail", null));
                x.e("MicroMsg.JsApiAddCard", "location result is empty!");
                return;
            }
            Object jSONArray;
            Map hashMap = new HashMap();
            x.d("MicroMsg.JsApiAddCard", "mmSetOnActivityResultCallback cardList:%s", new Object[]{intent.getStringExtra("card_list")});
            try {
                jSONArray = new JSONArray(intent.getStringExtra("card_list"));
            } catch (Throwable e) {
                x.e("MicroMsg.JsApiAddCard", "parse fail result:%s", new Object[]{bi.i(e)});
                jSONArray = null;
            }
            if (jSONArray != null) {
                hashMap.put("cardList", jSONArray);
                this.fCl.E(this.fFy.fFw, this.fFy.f("ok", hashMap));
                return;
            }
            this.fCl.E(this.fFy.fFw, this.fFy.f("fail: cardList is empty", hashMap));
            x.e("MicroMsg.JsApiAddCard", "add card result is fail! cardList is empty");
        } else if (i2 == 0) {
            this.fCl.E(this.fFy.fFw, this.fFy.f("cancel", null));
            x.e("MicroMsg.JsApiAddCard", "add card result is cancel!");
        } else {
            int intExtra;
            if (intent != null) {
                intExtra = intent.getIntExtra("result_code", 2);
            } else {
                intExtra = 2;
            }
            x.i("MicroMsg.JsApiAddCard", "mmSetOnActivityResultCallback ret_code:%d", new Object[]{Integer.valueOf(intExtra)});
            if (intExtra == 2) {
                this.fCl.E(this.fFy.fFw, this.fFy.f("fail", null));
            } else {
                this.fCl.E(this.fFy.fFw, this.fFy.f("cancel", null));
            }
        }
    }
}
