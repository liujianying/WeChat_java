package com.tencent.mm.plugin.game.gamewebview.ui;

import android.graphics.Color;
import android.webkit.ValueCallback;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class d$25 implements Runnable {
    final /* synthetic */ d jJO;

    public d$25(d dVar) {
        this.jJO = dVar;
    }

    public final void run() {
        d.n(this.jJO).evaluateJavascript("javascript:(function(){return window.getComputedStyle(document.body,null).backgroundColor})()", new ValueCallback<String>() {
            public final /* synthetic */ void onReceiveValue(Object obj) {
                String str = (String) obj;
                x.d("MicroMsg.GameWebPageView", "get background color s = %s", new Object[]{str});
                if (!bi.oW(str)) {
                    int color = d.t(d$25.this.jJO).getResources().getColor(R.e.webview_logo_bg_color);
                    String[] split;
                    if (d.aSV().matcher(str).matches()) {
                        split = str.replaceAll("\"", "").replaceFirst("rgba", "").replaceFirst("\\(", "").replaceFirst("\\)", "").split(",");
                        if (split.length == 4) {
                            try {
                                color = Color.argb(bi.getInt(bi.oV(split[3]).trim(), 0), bi.getInt(bi.oV(split[0]).trim(), 0), bi.getInt(bi.oV(split[1]).trim(), 0), bi.getInt(bi.oV(split[2]).trim(), 0));
                            } catch (Exception e) {
                                x.e("MicroMsg.GameWebPageView", "handle bgColor from html, bgColor = %s, exception = %s", new Object[]{str, e});
                                return;
                            }
                        }
                        return;
                    } else if (d.aSW().matcher(str).matches()) {
                        split = str.replaceAll("\"", "").replaceFirst("rgb", "").replaceFirst("\\(", "").replaceFirst("\\)", "").split(",");
                        if (split.length == 3) {
                            try {
                                color = Color.argb(255, bi.getInt(bi.oV(split[0]).trim(), 0), bi.getInt(bi.oV(split[1]).trim(), 0), bi.getInt(bi.oV(split[2]).trim(), 0));
                            } catch (Exception e2) {
                                x.e("MicroMsg.GameWebPageView", "handle bgColor from html, bgColor = %s, exception = %s", new Object[]{str, e2});
                                return;
                            }
                        }
                        return;
                    } else {
                        x.d("MicroMsg.GameWebPageView", "handle bgColor from html, bgColor = %s, can not match", new Object[]{str});
                    }
                    d.h(d$25.this.jJO).AH(color);
                    d.h(d$25.this.jJO).bVU();
                }
            }
        });
    }
}
