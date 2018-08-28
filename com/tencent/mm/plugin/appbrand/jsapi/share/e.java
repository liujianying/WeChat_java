package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.page.o;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import org.json.JSONObject;

public final class e extends a {
    public static final int CTRL_INDEX = 74;
    public static final String NAME = "shareTimeline";
    private static boolean fYS = false;

    public final void a(l lVar, JSONObject jSONObject, int i) {
        if (fYS) {
            fYS = false;
            if (jSONObject != null) {
                AppBrandSysConfig appBrandSysConfig = lVar.fdO.fcu;
                MMActivity c = c(lVar);
                if (c == null) {
                    lVar.E(i, f("fail", null));
                    return;
                }
                String str;
                try {
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        str = (String) keys.next();
                        x.i("MicroMsg.JsApiShareTimeline", "%s, %s", new Object[]{str, jSONObject.get(str)});
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.JsApiShareTimeline", e, "", new Object[0]);
                }
                String optString = jSONObject.optString("path");
                String str2 = lVar.mAppId;
                str = jSONObject.optString("desc");
                String optString2 = jSONObject.optString("title");
                String str3 = appBrandSysConfig.bGy;
                String optString3 = jSONObject.optString("imgUrl");
                String qz = n.qz(lVar.mAppId);
                String str4 = appBrandSysConfig.fqJ;
                x.i("MicroMsg.JsApiShareTimeline", "doSendMessage, title = %s, description = %s ,username = %s , path = %s ,thumbIconUrl = %s", new Object[]{optString2, str, str3, optString, optString3});
                x.i("MicroMsg.JsApiShareTimeline", "doTimeline, errorUrl:[%s]", new Object[]{qz});
                x.i("MicroMsg.JsApiShareTimeline", "doTimeline, init intent");
                Intent intent = new Intent();
                intent.putExtra("Ksnsupload_link", qz);
                intent.putExtra("Ksnsupload_title", optString2);
                intent.putExtra("Ksnsupload_contentattribute", 0);
                if (s.fj(optString3, "http://") || s.fj(optString3, "https://")) {
                    intent.putExtra("Ksnsupload_imgurl", optString3);
                } else {
                    Bitmap j = o.j(lVar.fdO, optString3);
                    byte[] bArr = new byte[0];
                    if (j == null || j.isRecycled()) {
                        x.e("MicroMsg.JsApiShareTimeline", "thumb image is null");
                    } else {
                        x.i("MicroMsg.JsApiShareTimeline", "thumb image is not null");
                        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        j.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                        bArr = byteArrayOutputStream.toByteArray();
                    }
                    intent.putExtra("Ksnsupload_imgbuf", bArr);
                }
                intent.putExtra("ksnsis_appbrand", true);
                intent.putExtra("Ksnsupload_source", 1);
                intent.putExtra("Ksnsupload_type", 1);
                intent.putExtra("KsnsUpload_BrandUsername", str3);
                intent.putExtra("KsnsUpload_BrandPath", optString);
                x.d("MicroMsg.JsApiShareTimeline", "report, appId : %s, path: %s", new Object[]{str2, optString});
                str = u.ic("wxapp_" + str2 + optString);
                u.Hx().v(str, true).p("prePublishId", "wxapp_" + str2 + optString);
                intent.putExtra("reportSessionId", str);
                x.i("MicroMsg.JsApiShareTimeline", "doTimeline, start activity");
                if (c instanceof MMActivity) {
                    intent.putExtra("need_result", true);
                    c.geJ = new 1(this, c, str2, optString, lVar, i);
                    d.a(c, "sns", ".ui.SnsUploadUI", intent, 0, false);
                    return;
                }
                return;
            }
            x.i("MicroMsg.JsApiShareTimeline", "data is null");
            lVar.E(i, f("fail", null));
            return;
        }
        lVar.E(i, f("fail", null));
    }

    public static void ajC() {
        fYS = true;
    }
}
