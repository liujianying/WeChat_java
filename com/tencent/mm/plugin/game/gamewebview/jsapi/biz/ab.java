package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Intent;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.GameWebViewUI;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class ab extends a {
    public static final int CTRL_BYTE = 256;
    public static final String NAME = "openCustomWebview";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        GameWebViewUI pageActivity = dVar.getPageActivity();
        if (pageActivity == null) {
            x.i("MicroMsg.GameJsApiOpenCustomWebView", "activity is null");
            return;
        }
        String optString = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (bi.oW(optString)) {
            dVar.E(i, a.f("openCunstonWebview:fail_invalid_url", null));
            return;
        }
        dVar.getRawUrl().startsWith("http://game.weixin.qq.com/cgi-bin/h5/static/gameloading/index.html?appid=");
        String optString2 = jSONObject.optString("orientation");
        int i2 = -1;
        if (!bi.oW(optString2)) {
            if (optString2.equals("horizontal")) {
                i2 = 0;
            } else if (optString2.equals("vertical")) {
                i2 = 1;
            }
        }
        boolean optBoolean = jSONObject.optBoolean("fullscreen");
        String optString3 = jSONObject.optString("top_title");
        String optString4 = jSONObject.optString("top_url");
        boolean equals = jSONObject.optString("finish_recent_webview").equals("1");
        boolean equals2 = jSONObject.optString("disable_swipe_back").equals("1");
        String optString5 = jSONObject.optString("username");
        Intent intent = new Intent();
        intent.putExtra("rawUrl", optString);
        intent.putExtra("screen_orientation", i2);
        intent.putExtra("show_full_screen", optBoolean);
        intent.putExtra("disable_swipe_back", equals2);
        intent.putExtra("shortcut_user_name", optString5);
        intent.putExtra("finish_recent_page", equals);
        if (!(bi.oW(optString4) || bi.oW(optString3))) {
            intent.putExtra("custom_keep_top_url", optString4);
            intent.putExtra("custom_keep_top_title", optString3);
        }
        if (equals && dVar.jIT.aSG()) {
            intent.putExtra("is_from_keep_top", true);
        }
        intent.putExtra("game_hv_menu_appid", bi.oV(jSONObject.optString("gameAppid")));
        pageActivity.L(intent);
        dVar.E(i, a.f("openCunstonWebview:ok", null));
    }
}
