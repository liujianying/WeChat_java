package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Intent;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.GameWebViewUI;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.modeltools.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.b;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class w extends a {
    public static final int CTRL_BYTE = 1;
    public static final String NAME = "imagePreview";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiSendAppMessage", "invoke");
        GameWebViewUI pageActivity = dVar.getPageActivity();
        if (pageActivity != null) {
            if (jSONObject == null) {
                x.e("MicroMsg.GameJsApiSendAppMessage", "fail, data is null");
                dVar.E(i, a.f("imagePreview:fail_invalid_data", null));
                return;
            }
            String optString = jSONObject.optString("current");
            JSONArray optJSONArray = jSONObject.optJSONArray("urls");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray == null || optJSONArray.length() == 0) {
                x.e("MicroMsg.GameJsApiSendAppMessage", "fail, urls is null");
                dVar.E(i, a.f("imagePreview:fail_invalid_url", null));
                return;
            }
            String str;
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                Object optString2 = optJSONArray.optString(i2);
                if (bi.oW(optString2) || optString2.equalsIgnoreCase("null")) {
                    x.e("MicroMsg.GameJsApiSendAppMessage", "null url, i = %d", new Object[]{Integer.valueOf(i2)});
                } else {
                    if (bi.oV(optString2).startsWith("weixin://resourceid/")) {
                        WebViewJSSDKFileItem Qq = e.bUX().Qq(optString2);
                        if (Qq != null) {
                            optString2 = Qq.fnM;
                        }
                    }
                    arrayList.add(optString2);
                }
            }
            String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            if (bi.oW(optString)) {
                str = strArr[0];
            } else if (optString.startsWith("weixin://resourceid/")) {
                WebViewJSSDKFileItem Qq2 = e.bUX().Qq(optString);
                str = Qq2 != null ? Qq2.fnM : "";
            } else {
                str = optString;
            }
            Intent intent = new Intent();
            optString = b.cIi().getCookie(dVar.getCurrentURL());
            if (!bi.oW(optString)) {
                intent.putExtra("cookie", optString);
            }
            intent.putExtra("nowUrl", str);
            intent.putExtra("urlList", strArr);
            intent.putExtra("type", -255);
            intent.putExtra("isFromWebView", true);
            com.tencent.mm.bg.d.b(pageActivity, "subapp", ".ui.gallery.GestureGalleryUI", intent);
            dVar.E(i, a.f("imagePreview:ok", null));
        }
    }
}
