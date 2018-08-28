package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiSendAppMessage.SendAppMessageTask;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.h;
import org.json.JSONObject;

class GameJsApiSendAppMessage$1 implements a {
    final /* synthetic */ int doP;
    final /* synthetic */ JSONObject fHi;
    final /* synthetic */ d jGF;
    final /* synthetic */ GameJsApiSendAppMessage jHs;

    GameJsApiSendAppMessage$1(GameJsApiSendAppMessage gameJsApiSendAppMessage, JSONObject jSONObject, d dVar, int i) {
        this.jHs = gameJsApiSendAppMessage;
        this.fHi = jSONObject;
        this.jGF = dVar;
        this.doP = i;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i == 1) {
            String str;
            String optString = this.fHi.optString("appid");
            if (this.jHs.jGp == null || !bi.oW(optString)) {
                str = optString;
            } else {
                str = this.jHs.jGp.getString("jsapi_args_appid");
            }
            switch (i2) {
                case -1:
                    if (intent == null) {
                        optString = null;
                    } else {
                        optString = intent.getStringExtra("Select_Conv_User");
                    }
                    if (optString == null || optString.length() == 0) {
                        x.e("MicroMsg.GameJsApiSendAppMessage", "mmOnActivityResult fail, toUser is null");
                        this.jGF.E(this.doP, com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("send_app_msg:fail", null));
                        return;
                    }
                    SendAppMessageTask sendAppMessageTask = new SendAppMessageTask(this.jGF.getPageActivity());
                    sendAppMessageTask.scene = GameJsApiSendAppMessage.cfQ;
                    sendAppMessageTask.appId = str;
                    sendAppMessageTask.toUser = optString;
                    sendAppMessageTask.thumbUrl = (String) this.fHi.opt("img_url");
                    sendAppMessageTask.bZG = (String) this.fHi.opt("src_username");
                    sendAppMessageTask.jHt = (String) this.fHi.opt("src_displayname");
                    sendAppMessageTask.fYU = intent.getStringExtra("custom_send_text");
                    sendAppMessageTask.title = this.fHi.optString("title");
                    sendAppMessageTask.description = this.fHi.optString("desc");
                    sendAppMessageTask.jHu = this.jGF.Dp(this.fHi.optString("link"));
                    sendAppMessageTask.cbP = this.jGF.getRawUrl();
                    sendAppMessageTask.gsE = this.jGF.getCurrentURL();
                    sendAppMessageTask.verifyAppId = this.jGF.getCacheAppId();
                    sendAppMessageTask.extInfo = this.fHi.optString("review_data");
                    sendAppMessageTask.aNI();
                    h.bA(this.jGF.getPageActivity(), this.jGF.getResources().getString(R.l.app_shared));
                    this.jGF.E(this.doP, com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("send_app_msg:ok", null));
                    return;
                default:
                    return;
            }
        }
    }
}
