package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.p;

public class MMWebViewWithJsApi extends MMWebView {
    private i qlb;
    private boolean qlc;

    public MMWebViewWithJsApi(Context context) {
        this(context, null);
    }

    public MMWebViewWithJsApi(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMWebViewWithJsApi(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qlc = true;
        cAw();
        getSettings().setJavaScriptEnabled(true);
        getSettings().cIx();
        setWebChromeClient(new g(this));
        setWebViewClient(new i(this));
        String userAgentString = getSettings().getUserAgentString();
        if (!s.Uc(userAgentString)) {
            getSettings().setUserAgentString(s.aV(getContext(), userAgentString));
        }
    }

    public void setWebViewClient(p pVar) {
        super.setWebViewClient(pVar);
        if (pVar instanceof i) {
            this.qlb = (i) pVar;
        } else {
            this.qlb = null;
        }
    }

    public void setCleanOnDetached(boolean z) {
        this.qlc = z;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.qlb != null && this.qlc) {
            this.qlb.cleanup();
        }
    }

    public void loadData(String str, String str2, String str3) {
        if (this.qlb != null) {
            this.qlb.qkP = true;
            this.qlb.RB("");
        }
        super.loadData(str, str2, str3);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (this.qlb != null) {
            this.qlb.qkP = true;
            this.qlb.RB("");
        }
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public void loadUrl(String str) {
        if (this.qlb != null) {
            this.qlb.qkP = false;
            if (this.qlb.RB(str)) {
                return;
            }
        }
        super.loadUrl(str);
    }
}
