package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.ClipData;
import android.content.ClipboardManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.charset.Charset;
import org.json.JSONObject;

public final class JsApiSetClipboardData extends a {
    public static final int CTRL_INDEX = 168;
    public static final String NAME = "setClipboardData";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString(SlookAirButtonFrequentContactAdapter.DATA);
        if (bi.oW(optString)) {
            lVar.E(i, f("fail", null));
            return;
        }
        x.d("MicroMsg.JsApiSetClipboardData", "stevyang dataStr %s", new Object[]{optString});
        ClipboardManager clipboardManager = (ClipboardManager) lVar.getContext().getSystemService("clipboard");
        if (clipboardManager == null) {
            x.i("MicroMsg.JsApiSetClipboardData", "getSystemService(CLIPBOARD_SERVICE) failed.");
            lVar.E(i, f("fail", null));
            return;
        }
        clipboardManager.setPrimaryClip(ClipData.newPlainText("text", optString));
        lVar.E(i, f("ok", null));
        if (!bi.oW(optString)) {
            String str = lVar.mAppId;
            p d = d(lVar);
            AppBrandMainProcessService.a(new ReportClipBoardTask(str, d != null ? d.getURL() : "", optString.getBytes(Charset.forName("UTF-8")).length));
        }
    }
}
