package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import android.view.View;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.xweb.p;

public class WebViewTestUI extends MMActivity {
    private p fwL = new 1(this);
    MMWebViewWithJsApi pXy;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("rawUrl");
        this.pXy = a.eC(this);
        this.pXy.setWebViewClient(this.fwL);
        setContentView((View) this.pXy);
        this.pXy.loadUrl(stringExtra);
    }

    protected final int getLayoutId() {
        return -1;
    }
}
