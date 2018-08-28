package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Intent;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;

class j$1 implements a {
    final /* synthetic */ int doP;
    final /* synthetic */ d jGF;

    j$1(d dVar, int i) {
        this.jGF = dVar;
        this.doP = i;
    }

    public final void b(int i, int i2, Intent intent) {
        String stringExtra;
        WebViewJSSDKFileItem Db;
        WebViewJSSDKVideoItem webViewJSSDKVideoItem;
        if (i == 45) {
            switch (i2) {
                case -1:
                    stringExtra = intent.getStringExtra("key_pick_local_media_local_id");
                    String stringExtra2 = intent.getStringExtra("key_pick_local_media_thumb_local_id");
                    x.i("MicroMsg.GameJsApiChooseVideo", "localId:%s", new Object[]{stringExtra});
                    x.i("MicroMsg.GameJsApiChooseVideo", "thumbLocalId:%s", new Object[]{stringExtra2});
                    if (bi.oW(stringExtra)) {
                        this.jGF.E(this.doP, com.tencent.mm.plugin.game.gamewebview.a.d.f("recordVideo:fail", null));
                        return;
                    }
                    Db = com.tencent.mm.plugin.game.gamewebview.a.d.Db(stringExtra);
                    if (Db == null || !(Db instanceof WebViewJSSDKVideoItem)) {
                        this.jGF.E(this.doP, com.tencent.mm.plugin.game.gamewebview.a.d.f("recordVideo:fail", null));
                        return;
                    }
                    webViewJSSDKVideoItem = (WebViewJSSDKVideoItem) Db;
                    Map hashMap = new HashMap();
                    hashMap.put("localId", stringExtra);
                    hashMap.put("duration", Integer.valueOf(webViewJSSDKVideoItem.duration));
                    hashMap.put("height", Integer.valueOf(webViewJSSDKVideoItem.height));
                    hashMap.put("size", Integer.valueOf(webViewJSSDKVideoItem.size));
                    hashMap.put("width", Integer.valueOf(webViewJSSDKVideoItem.width));
                    hashMap.put("thumbLocalId", stringExtra2);
                    this.jGF.E(this.doP, com.tencent.mm.plugin.game.gamewebview.a.d.f("recordVideo:ok", hashMap));
                    return;
                case 0:
                    this.jGF.E(this.doP, com.tencent.mm.plugin.game.gamewebview.a.d.f("recordVideo:cancel", null));
                    return;
                default:
                    this.jGF.E(this.doP, com.tencent.mm.plugin.game.gamewebview.a.d.f("recordVideo:fail", null));
                    return;
            }
        } else if (i == 32) {
            switch (i2) {
                case -1:
                    stringExtra = intent.getStringExtra("key_pick_local_media_local_id");
                    if (!bi.oW(stringExtra)) {
                        Db = com.tencent.mm.plugin.game.gamewebview.a.d.Db(stringExtra);
                        if (Db == null || !(Db instanceof WebViewJSSDKVideoItem)) {
                            this.jGF.E(this.doP, com.tencent.mm.plugin.game.gamewebview.a.d.f("chooseVideo:fail", null));
                            return;
                        }
                        webViewJSSDKVideoItem = (WebViewJSSDKVideoItem) Db;
                        Map hashMap2 = new HashMap();
                        hashMap2.put("localId", stringExtra);
                        hashMap2.put("duration", Integer.valueOf(webViewJSSDKVideoItem.duration));
                        hashMap2.put("height", Integer.valueOf(webViewJSSDKVideoItem.height));
                        hashMap2.put("size", Integer.valueOf(webViewJSSDKVideoItem.size));
                        hashMap2.put("width", Integer.valueOf(webViewJSSDKVideoItem.width));
                        this.jGF.E(this.doP, com.tencent.mm.plugin.game.gamewebview.a.d.f("chooseVideo:ok", hashMap2));
                        return;
                    }
                    break;
                case 0:
                    this.jGF.E(this.doP, com.tencent.mm.plugin.game.gamewebview.a.d.f("chooseVideo:cancel", null));
                    return;
            }
            this.jGF.E(this.doP, com.tencent.mm.plugin.game.gamewebview.a.d.f("chooseVideo:fail", null));
        }
    }
}
