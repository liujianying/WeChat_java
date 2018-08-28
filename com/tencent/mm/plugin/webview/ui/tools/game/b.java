package com.tencent.mm.plugin.webview.ui.tools.game;

import android.net.Uri;
import com.tencent.mm.plugin.webview.model.ab;
import com.tencent.mm.plugin.webview.ui.tools.widget.i;
import com.tencent.mm.plugin.webview.ui.tools.widget.i.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;

public class b extends i {
    public b(MMWebView mMWebView) {
        super(mMWebView, false);
        this.qkT = new a(this, (byte) 0);
    }

    public boolean RB(String str) {
        return super.RB(str);
    }

    protected final void bXI() {
        try {
            this.qcA.a(this.qkL, true, null);
        } catch (Exception e) {
            x.w("MicroMsg.GameFloatWebViewClient", "postBinded, jumpToActivity, ex = " + e.getMessage());
        }
        if (!RR(this.qkL)) {
            Uri parse = Uri.parse(this.qkL);
            if (parse.getScheme() == null) {
                this.qkL += "http://";
                parse = Uri.parse(this.qkL);
            }
            if (parse.getScheme().startsWith("http")) {
                x.i("MicroMsg.GameFloatWebViewClient", "uri scheme not startwith http, scheme = " + parse.getScheme());
                this.qkJ = new a(this.qkP ? "" : this.qkL);
                this.qkP = false;
                if (!this.jJw && !this.qhr.has(this.qkL)) {
                    if (Rm(this.qkL)) {
                        Do(this.qkL);
                        this.jJp = this.qkL;
                    }
                    bg(this.qkL, false);
                } else if (!ab.Ql(this.qkL)) {
                    x.f("MicroMsg.GameFloatWebViewClient", "loadInitialUrl, canLoadUrl fail, url = " + this.qkL);
                    RC(this.qkL);
                } else if (Rm(this.qkL)) {
                    Do(this.qkL);
                } else {
                    this.dEn.loadUrl(this.qkL);
                }
            } else if (ab.Ql(this.qkL)) {
                this.dEn.loadUrl(this.qkL);
            } else {
                RC(this.qkL);
            }
        }
    }
}
