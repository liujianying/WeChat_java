package com.tencent.mm.plugin.webview.ui.tools;

import android.graphics.Color;
import android.webkit.ValueCallback;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$5 implements ValueCallback<String> {
    final /* synthetic */ WebViewUI pZJ;

    WebViewUI$5(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        String str = (String) obj;
        x.d("MicroMsg.WebViewUI", "get background color s = %s", new Object[]{str});
        if (!bi.oW(str)) {
            int color = this.pZJ.getResources().getColor(R.e.webview_logo_bg_color);
            String[] split;
            if (WebViewUI.aSV().matcher(str).matches()) {
                split = str.replaceAll("\"", "").replaceFirst("rgba", "").replaceFirst("\\(", "").replaceFirst("\\)", "").split(",");
                if (split.length == 4) {
                    try {
                        color = Color.argb(bi.getInt(bi.oV(split[3]).trim(), 0), bi.getInt(bi.oV(split[0]).trim(), 0), bi.getInt(bi.oV(split[1]).trim(), 0), bi.getInt(bi.oV(split[2]).trim(), 0));
                    } catch (Exception e) {
                        x.e("MicroMsg.WebViewUI", "handle bgColor from html, bgColor = %s, exception = %s", new Object[]{str, e});
                        return;
                    }
                }
                return;
            } else if (WebViewUI.aSW().matcher(str).matches()) {
                split = str.replaceAll("\"", "").replaceFirst("rgb", "").replaceFirst("\\(", "").replaceFirst("\\)", "").split(",");
                if (split.length == 3) {
                    try {
                        color = Color.argb(255, bi.getInt(bi.oV(split[0]).trim(), 0), bi.getInt(bi.oV(split[1]).trim(), 0), bi.getInt(bi.oV(split[2]).trim(), 0));
                    } catch (Exception e2) {
                        x.e("MicroMsg.WebViewUI", "handle bgColor from html, bgColor = %s, exception = %s", new Object[]{str, e2});
                        return;
                    }
                }
                return;
            } else {
                x.d("MicroMsg.WebViewUI", "handle bgColor from html, bgColor = %s, can not match", new Object[]{str});
            }
            WebViewUI.n(this.pZJ).AH(color);
            WebViewUI.n(this.pZJ).bVU();
        }
    }
}
