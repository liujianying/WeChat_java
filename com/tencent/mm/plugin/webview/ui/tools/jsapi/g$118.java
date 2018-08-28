package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.modeltools.d.a;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class g$118 implements a {
    final /* synthetic */ g qiK;
    final /* synthetic */ i qjj;

    g$118(g gVar, i iVar) {
        this.qiK = gVar;
        this.qjj = iVar;
    }

    public final void a(String str, JSONObject jSONObject, Bitmap bitmap) {
        if (bitmap == null) {
            g.a(this.qiK, this.qjj, "chooseIdCard:fail", null);
            return;
        }
        try {
            String str2 = e.duN + "tmpScanLicense/";
            x.d("MicroMsg.MsgHandler", "tmpSaveCardBitmapDir: %s", new Object[]{str2});
            if (FileOp.cn(str2)) {
                FileOp.I(str2, true);
            }
            FileOp.mL(str2);
            FileOp.mN(str2);
            str2 = str2 + System.currentTimeMillis() + ".jpg";
            x.d("MicroMsg.MsgHandler", "tmpSaveCardBitmapPath: %s", new Object[]{str2});
            c.a(bitmap, 100, CompressFormat.JPEG, str2, true);
            WebViewJSSDKFileItem Qn = WebViewJSSDKFileItem.Qn(str2);
            com.tencent.mm.plugin.webview.modeltools.e.bUX().b(Qn);
            Map hashMap = new HashMap();
            hashMap.put("sourceType", "scan");
            hashMap.put("localId", Qn.bNH);
            g.a(this.qiK, this.qjj, "chooseIdCard:ok", hashMap);
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "save scan license error: %s", new Object[]{e.getMessage()});
            g.a(this.qiK, this.qjj, "chooseIdCard:fail", null);
        }
    }

    public final void QK(String str) {
        g.a(this.qiK, this.qjj, "chooseIdCard:cancel", null);
    }

    public final void MY(String str) {
        g.a(this.qiK, this.qjj, "chooseIdCard:fail", null);
    }
}
