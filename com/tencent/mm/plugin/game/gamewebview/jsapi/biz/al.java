package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.GameWebViewUI;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public final class al extends a {
    public static final int CTRL_BYTE = 252;
    public static final String NAME = "previewVideo";

    public final void a(final d dVar, JSONObject jSONObject, final int i) {
        x.i("MicroMsg.GameJsApiPreviewVideo", "invoke");
        if (jSONObject == null || bi.oW(jSONObject.optString("localId"))) {
            x.i("MicroMsg.GameJsApiPreviewVideo", "data is invalid");
            dVar.E(i, a.f("previewVideo:fail_invalid_data", null));
            return;
        }
        WebViewJSSDKFileItem Db = com.tencent.mm.plugin.game.gamewebview.a.d.Db(jSONObject.optString("localId"));
        if (Db == null || TextUtils.isEmpty(Db.fnM) || !e.cn(Db.fnM)) {
            x.e("MicroMsg.GameJsApiPreviewVideo", "the item is null or the File item not exist for localId: %s", new Object[]{r0});
            dVar.E(i, a.f("previewVideo:fail", null));
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("key_video_path", Db.fnM);
        GameWebViewUI pageActivity = dVar.getPageActivity();
        pageActivity.geJ = new MMActivity.a() {
            public final void b(int i, int i2, Intent intent) {
                if (i == (al.this.hashCode() & 65535)) {
                    switch (i2) {
                        case -1:
                            dVar.E(i, a.f("previewVideo:ok", null));
                            return;
                        case 0:
                            dVar.E(i, a.f("previewVideo:cancel", null));
                            return;
                        default:
                            dVar.E(i, a.f("previewVideo:fail", null));
                            return;
                    }
                }
            }
        };
        com.tencent.mm.bg.d.b(pageActivity, "card", ".ui.CardGiftVideoUI", intent, hashCode() & 65535);
    }
}
