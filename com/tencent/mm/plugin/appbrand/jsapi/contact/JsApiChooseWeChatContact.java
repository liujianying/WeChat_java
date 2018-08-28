package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiChooseWeChatContact extends a {
    public static final int CTRL_INDEX = 195;
    public static final String NAME = "chooseWeChatContact";

    public final void a(final l lVar, JSONObject jSONObject, final int i) {
        MMActivity c = c(lVar);
        if (c == null) {
            x.e("MicroMsg.JsApiChooseWeChatContact", "ChooseWeChatContact context is null, appId is %s", new Object[]{lVar.mAppId});
            lVar.E(i, f("fail", null));
            return;
        }
        x.i("MicroMsg.JsApiChooseWeChatContact", "ChooseWeChatContact appId:%s", new Object[]{lVar.mAppId});
        Intent intent = new Intent();
        String string = c.getString(j.appbrand_select_conversation_wechat_title);
        int i2 = 259;
        int[] iArr = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131075};
        x.i("MicroMsg.JsApiChooseWeChatContact", "ChooseWeChatContact data %s:", new Object[]{jSONObject});
        if (!(jSONObject == null || jSONObject.optJSONArray("contactMode") == null || jSONObject.optJSONArray("contactMode").length() <= 0)) {
            String jSONArray = jSONObject.optJSONArray("contactMode").toString();
            if (jSONArray.contains("singleContact") && !jSONArray.contains("chatroom")) {
                i2 = 263;
                string = c.getString(j.appbrand_select_conversation_friend_title);
                iArr = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
            } else if (jSONArray.contains("chatroom") && !jSONArray.contains("singleContact")) {
                i2 = 275;
                iArr = new int[]{131075};
            }
        }
        intent.putExtra("Select_Conv_Type", i2);
        intent.putExtra("jsapi_select_mode", 1);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("scene_from", 9);
        intent.putExtra("Select_Conv_ui_title", string);
        intent.putExtra("search_range", iArr);
        GetUserDataTask getUserDataTask = new GetUserDataTask("");
        AppBrandMainProcessService.b(getUserDataTask);
        intent.putExtra("Select_block_List", getUserDataTask.fPm);
        d.a(c, ".ui.transmit.SelectConversationUI", intent, 100, new MMActivity.a() {
            public final void b(int i, int i2, Intent intent) {
                if (100 != i) {
                    x.e("MicroMsg.JsApiChooseWeChatContact", "selectSingleContact requestCode not equal, requestCode = %d", new Object[]{Integer.valueOf(i)});
                    lVar.E(i, JsApiChooseWeChatContact.this.f("fail", null));
                } else if (i2 == 0 || i2 == 1) {
                    x.e("MicroMsg.JsApiChooseWeChatContact", "selectSingleContact user cancel, resultCode = %d", new Object[]{Integer.valueOf(i)});
                    lVar.E(i, JsApiChooseWeChatContact.this.f("cancel", null));
                } else if (i2 == -1) {
                    String str;
                    if (intent == null) {
                        str = null;
                    } else {
                        str = intent.getStringExtra("Select_Conv_User");
                    }
                    if (str == null || str.length() == 0) {
                        x.e("MicroMsg.JsApiChooseWeChatContact", "mmOnActivityResult, selectSingleContact fail, user is null");
                        lVar.E(i, JsApiChooseWeChatContact.this.f("fail", null));
                        return;
                    }
                    GetUserDataTask getUserDataTask = new GetUserDataTask(str);
                    AppBrandMainProcessService.b(getUserDataTask);
                    String str2 = getUserDataTask.bgn;
                    String str3 = getUserDataTask.bgo;
                    String str4 = getUserDataTask.eTp;
                    Map hashMap = new HashMap();
                    hashMap.put("avatarUrl", str4);
                    hashMap.put("userName", str);
                    hashMap.put("nickName", str2);
                    hashMap.put("remarkName", str3);
                    x.i("MicroMsg.JsApiChooseWeChatContact", "selectSingleContact: nickName:%s, remarkName:%s", new Object[]{str2, str3});
                    lVar.E(i, JsApiChooseWeChatContact.this.f("ok", hashMap));
                }
            }
        });
    }
}
