package com.tencent.mm.plugin.game.gamewebview.model;

import android.text.TextUtils;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiSendAppMessage;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public final class h {
    public static void c(d dVar) {
        dVar.Dr(GameJsApiSendAppMessage.NAME);
        if (dVar.bs(GameJsApiSendAppMessage.NAME, 89)) {
            dVar.cW("menu:share:appmessage", "");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            String shareUrl = dVar.getShareUrl();
            jSONObject.put("link", shareUrl);
            jSONObject.put("desc", shareUrl);
            jSONObject.put("title", dVar.getTitle());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.GameWebViewShareController", e, "", new Object[0]);
        }
        dVar.cX(GameJsApiSendAppMessage.NAME, jSONObject.toString());
    }

    public static void a(d dVar, JSONObject jSONObject) {
        int i;
        String substring;
        int i2 = 1;
        String optString = jSONObject.optString("link");
        c.d preVerifyExtInfo = dVar.getPreVerifyExtInfo();
        if (TextUtils.isEmpty(optString) || preVerifyExtInfo == null || preVerifyExtInfo.qhi == null || preVerifyExtInfo.qhi.size() <= 0) {
            i = 0;
        } else {
            List<String> linkedList = new LinkedList();
            int indexOf = optString.indexOf("://");
            String substring2 = optString.substring((indexOf == -1 ? 1 : 3) + indexOf);
            for (String substring3 : preVerifyExtInfo.qhi) {
                if (!TextUtils.isEmpty(substring3)) {
                    int i3;
                    int indexOf2 = substring3.indexOf("://");
                    if (indexOf2 == -1) {
                        i3 = 1;
                    } else {
                        i3 = 3;
                    }
                    substring3 = substring3.substring(i3 + indexOf2);
                    if (substring2.startsWith(substring3)) {
                        i2 = 0;
                        break;
                    } else if (!substring3.contains("/")) {
                        linkedList.add(substring3);
                    }
                }
            }
            if (!(i2 == 0 || linkedList.isEmpty())) {
                String host = URI.create(optString).getHost();
                for (String substring32 : linkedList) {
                    if (host.endsWith(substring32)) {
                        i = 0;
                        break;
                    }
                }
            }
            i = i2;
        }
        if (i != 0) {
            try {
                substring32 = dVar.getShareUrl();
                jSONObject.put("img_url", "");
                jSONObject.put("link", substring32);
                jSONObject.put("desc", substring32);
                jSONObject.put("title", dVar.getTitle());
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.GameWebViewShareController", e, "", new Object[0]);
            }
        }
    }
}
