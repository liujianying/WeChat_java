package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.23.44;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

class WebViewUI$23$44$1 implements OnMenuItemClickListener {
    final /* synthetic */ 44 qam;

    WebViewUI$23$44$1(44 44) {
        this.qam = 44;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        x.d("MicroMsg.WebViewUI", "click item: %s", Integer.valueOf(menuItem.getItemId()));
        d dVar = this.qam.pZM.pZJ.pNV;
        if (dVar.qhq) {
            x.i("MicroMsg.JsApiHandler", "onNavigationBarRightButtonClick success, ready");
            dVar.qhk.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a.a("onNavigationBarRightButtonClick", new HashMap(), dVar.qhs, dVar.qht) + ")", null);
        } else {
            x.e("MicroMsg.JsApiHandler", "onNavigationBarRightButtonClick fail, not ready");
        }
        return false;
    }
}
