package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.R;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.GameWebViewUI;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class av extends a {
    public static final int CTRL_BYTE = 113;
    public static final String NAME = "setPageTitle";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiSetPageTitle", "invoke");
        if (jSONObject == null) {
            x.i("MicroMsg.GameJsApiSetPageTitle", "data is null");
            dVar.E(i, "setPageTitle:fail");
            return;
        }
        GameWebViewUI pageActivity = dVar.getPageActivity();
        dVar.mHandler.post(new d$23(dVar, jSONObject.optString(FFmpegMetadataRetriever.METADATA_KEY_TITLE), com.tencent.mm.plugin.webview.ui.tools.d.aO(jSONObject.optString("color"), pageActivity.getResources().getColor(R.e.action_bar_tittle_color))));
        dVar.E(i, a.f("setPageTitle:ok", null));
    }
}
