package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Intent;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.GameWebViewUI;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import org.json.JSONObject;

public final class af extends a {
    public static final int CTRL_BYTE = 173;
    public static final String NAME = "openUrlWithExtraWebview";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        GameWebViewUI pageActivity = dVar.getPageActivity();
        if (pageActivity == null) {
            x.i("MicroMsg.GameJsApiOpenUrlWithExtraWebView", "activity is null");
            return;
        }
        String optString = jSONObject.optString(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL);
        if (bi.oW(optString)) {
            dVar.E(i, a.f("openUrlWithExtraWebview:fail_invalid_url", null));
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", optString);
        x.d("MicroMsg.GameJsApiOpenUrlWithExtraWebView", "openUrlWithExtraWebview: " + System.currentTimeMillis());
        pageActivity.L(intent);
        dVar.E(i, a.f("openUrlWithExtraWebview:ok", null));
    }
}
