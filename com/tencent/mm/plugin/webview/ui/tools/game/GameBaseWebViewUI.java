package com.tencent.mm.plugin.webview.ui.tools.game;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.i;
import com.tencent.xweb.WebView;

public class GameBaseWebViewUI extends WebViewUI {
    private c jJI = new 1(this);
    protected a qfD;

    protected class a extends i {
        protected a() {
            super(GameBaseWebViewUI.this);
        }

        public void b(WebView webView, String str, Bitmap bitmap) {
            GameBaseWebViewUI.this.jJI.qfW.bXJ();
            super.b(webView, str, bitmap);
        }

        public void a(WebView webView, String str) {
            super.a(webView, str);
            GameBaseWebViewUI.this.jJI.qfW.bXK();
        }
    }

    protected final void setGamePageReportData(Bundle bundle) {
        this.jJI.qfW.ab(bundle);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected void onResume() {
        this.jJI.qfW.onResume();
        if (this.qfD != null) {
            this.qfD.jJI.qfW.onResume();
        }
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
        this.jJI.qfW.onPause();
        if (this.qfD != null) {
            this.qfD.jJI.qfW.onPause();
        }
    }

    public void onDestroy() {
        c.a(this.jJI.qfW.qfX);
        if (this.qfD != null) {
            this.qfD.onDestroy();
        }
        super.onDestroy();
    }

    protected final boolean anv() {
        return true;
    }
}
