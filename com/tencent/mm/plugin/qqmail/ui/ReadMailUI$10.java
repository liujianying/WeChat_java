package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.plugin.qqmail.ui.ReadMailUI.c;
import com.tencent.mm.plugin.webview.ui.tools.widget.i;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;

class ReadMailUI$10 extends i {
    final /* synthetic */ ReadMailUI miD;

    ReadMailUI$10(ReadMailUI readMailUI, MMWebView mMWebView) {
        this.miD = readMailUI;
        super(mMWebView, true);
    }

    public final boolean Ke(String str) {
        x.d("MicroMsg.ReadMailUI", "url:%s", new Object[]{str});
        Intent intent;
        if (str != null && str.startsWith("mailto:")) {
            String replace = str.trim().replace("mailto:", "");
            Intent intent2 = new Intent(this.miD, ComposeUI.class);
            intent2.putExtra("composeType", 4);
            intent2.putExtra("toList", new String[]{replace + " " + replace});
            this.miD.startActivity(intent2);
            return true;
        } else if (str != null && str.startsWith("tel:")) {
            intent = new Intent("android.intent.action.DIAL", Uri.parse(str));
            intent.addFlags(268435456);
            this.miD.startActivity(intent);
            return true;
        } else if (str == null || str.startsWith("data:")) {
            return false;
        } else {
            if (ReadMailUI.g(this.miD).mhB) {
                ReadMailUI.g(this.miD).mhB = false;
                return true;
            } else if (!str.startsWith("http")) {
                return false;
            } else {
                intent = new Intent();
                intent.putExtra("rawUrl", str);
                d.b(this.miD, "webview", ".ui.tools.WebViewUI", intent);
                return true;
            }
        }
    }

    public final void f(WebView webView, String str) {
        x.d("MicroMsg.ReadMailUI", "load res:%s", new Object[]{str});
    }

    public final void e(WebView webView, String str) {
        webView.evaluateJavascript("javascript:var meta = document.createElement(\"meta\");meta.name=\"viewport\";meta.id=\"viewport\";meta.content=\"initial-scale=1,user-scalable=yes,maximum-scale=3.0\";document.head.appendChild(meta);", null);
        webView.evaluateJavascript("javascript:" + ReadMailUI.bpm(), null);
        webView.evaluateJavascript("javascript:" + ReadMailUI.bpn(), null);
        webView.evaluateJavascript("javascript:" + ReadMailUI.bpo(), null);
        if (ReadMailUI.l(this.miD).isConnected()) {
            if (!ReadMailUI.t(this.miD)) {
                ReadMailUI.u(this.miD);
            }
            ReadMailUI.a(this.miD, new ReadMailProxy(ReadMailUI.l(this.miD), null, new ReadMailUI$b(this.miD), new c(this.miD)));
            ReadMailUI.v(this.miD).REMOTE_CALL("addDownloadCallback", new Object[0]);
        }
        new ag(this.miD.getMainLooper()).postDelayed(new 1(this), 200);
        new ag(this.miD.getMainLooper()).postDelayed(new 2(this), 400);
    }
}
