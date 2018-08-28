package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Intent;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.model.h;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.Serializable;
import java.util.HashMap;
import org.json.JSONObject;

public final class GameJsApiSendAppMessage extends a {
    public static final int CTRL_BYTE = 6;
    public static final String NAME = "sendAppMessage";
    public static int cfQ;

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiSendAppMessage", "invoke");
        if (jSONObject == null) {
            x.e("MicroMsg.GameJsApiSendAppMessage", "sendAppMessage fail, appmsg is null");
            dVar.E(i, a.f("send_app_msg:fail_null_params", null));
        } else if (bi.oW(jSONObject.optString("link"))) {
            x.e("MicroMsg.GameJsApiSendAppMessage", "link is null");
            dVar.E(i, a.f("send_app_msg:fail_invalid_params", null));
        } else {
            switch (cfQ) {
                case 1:
                    SendAppMessageTask sendAppMessageTask = new SendAppMessageTask(dVar.getPageActivity());
                    sendAppMessageTask.scene = cfQ;
                    sendAppMessageTask.appId = jSONObject.optString("appid");
                    sendAppMessageTask.thumbUrl = jSONObject.optString("img_url");
                    sendAppMessageTask.bZG = jSONObject.optString("src_username");
                    sendAppMessageTask.jHt = jSONObject.optString("src_displayname");
                    sendAppMessageTask.title = jSONObject.optString("title");
                    sendAppMessageTask.description = jSONObject.optString("desc");
                    sendAppMessageTask.jHu = dVar.Dp(jSONObject.optString("link"));
                    sendAppMessageTask.cbP = dVar.getRawUrl();
                    sendAppMessageTask.gsE = dVar.getCurrentURL();
                    sendAppMessageTask.verifyAppId = dVar.getCacheAppId();
                    sendAppMessageTask.extInfo = jSONObject.optString("review_data");
                    sendAppMessageTask.jHw = dVar.getPublishId();
                    sendAppMessageTask.aNI();
                    dVar.E(i, "send_app_msg:ok");
                    break;
                default:
                    h.a(dVar, jSONObject);
                    Serializable hashMap = new HashMap();
                    hashMap.put("img_url", jSONObject.optString("img_url"));
                    hashMap.put("desc", jSONObject.optString("desc"));
                    hashMap.put("title", jSONObject.optString("title"));
                    hashMap.put("url", jSONObject.optString("url"));
                    Intent intent = new Intent();
                    intent.putExtra("Select_Conv_Type", 3);
                    intent.putExtra("scene_from", 2);
                    intent.putExtra("mutil_select_is_ret", true);
                    intent.putExtra("webview_params", hashMap);
                    intent.putExtra("Retr_Msg_Type", 2);
                    com.tencent.mm.bg.d.a(dVar.getPageActivity(), ".ui.transmit.SelectConversationUI", intent, 1, new 1(this, jSONObject, dVar, i));
                    break;
            }
            cfQ = 0;
        }
    }
}
