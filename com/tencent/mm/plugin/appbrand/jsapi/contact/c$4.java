package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.share.k;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

class c$4 implements Runnable {
    final /* synthetic */ p fIY;
    final /* synthetic */ c fPu;
    final /* synthetic */ a fPv;
    final /* synthetic */ JsApiChattingTask fPy;
    final /* synthetic */ WxaExposedParams.a fPz;

    c$4(c cVar, JsApiChattingTask jsApiChattingTask, WxaExposedParams.a aVar, p pVar, a aVar2) {
        this.fPu = cVar;
        this.fPy = jsApiChattingTask;
        this.fPz = aVar;
        this.fIY = pVar;
        this.fPv = aVar2;
    }

    public final void run() {
        x.i("MicroMsg.JsApiEnterContact", "go to the chattingUI");
        Intent intent = new Intent();
        intent.setFlags(67108864);
        intent.putExtra("Chat_User", this.fPy.username);
        intent.putExtra("app_brand_chatting_from_scene", 2);
        intent.putExtra("app_brand_chatting_expose_params", this.fPz.aeo());
        intent.putExtra("key_temp_session_from", this.fPy.sessionFrom);
        intent.putExtra("finish_direct", true);
        intent.putExtra("key_need_send_video", false);
        if (c.a(this.fPu)) {
            intent.putExtra("sendMessageTitle", c.b(this.fPu));
            intent.putExtra("sendMessagePath", c.c(this.fPu));
            intent.putExtra("sendMessageImg", c.d(this.fPu));
            intent.putExtra("sendMessageLocalImg", k.tZ(c.e(this.fPu)));
            intent.putExtra("needDelThumb", c.f(this.fPu));
        }
        intent.putExtra("showMessageCard", c.a(this.fPu));
        MMActivity mMActivity = (MMActivity) this.fIY.mContext;
        if (mMActivity == null) {
            if (this.fPv != null) {
                this.fPv.a(false, "fail", null);
            }
            x.e("MicroMsg.JsApiEnterContact", "mmActivity is null, invoke fail!");
            return;
        }
        mMActivity.geJ = new 1(this);
        d.b(mMActivity, ".ui.chatting.AppBrandServiceChattingUI", intent, 1);
        if (c.fIS > 0) {
            c.fIS--;
            this.fIY.fdO.aav();
        }
        if (c.fIS == 0) {
            c.fIS++;
            this.fIY.fdO.aau();
        }
        e.a(this.fIY.mAppId, new 2(this));
        x.i("MicroMsg.JsApiEnterContact", "doEnterChatting lockCount:%d", Integer.valueOf(c.fIS));
    }
}
