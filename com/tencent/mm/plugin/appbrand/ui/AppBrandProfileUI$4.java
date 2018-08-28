package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.AppBrandOnOpReportStartEvent;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n.d;
import java.util.Locale;

class AppBrandProfileUI$4 implements d {
    final /* synthetic */ AppBrandProfileUI gvm;

    AppBrandProfileUI$4(AppBrandProfileUI appBrandProfileUI) {
        this.gvm = appBrandProfileUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
                if (AppBrandProfileUI.b(this.gvm) == null) {
                    x.e("MicroMsg.AppBrandProfileUI", "wxaExposedParams is null");
                    return;
                }
                Intent intent = new Intent();
                String a = n.a(AppBrandProfileUI.b(this.gvm));
                x.i("MicroMsg.AppBrandProfileUI", "wxaExposedParams:%s", new Object[]{AppBrandProfileUI.b(this.gvm).toString()});
                x.v("MicroMsg.AppBrandProfileUI", "KRawUrl " + a);
                intent.putExtra("rawUrl", a);
                intent.putExtra("forceHideShare", true);
                com.tencent.mm.bg.d.b(this.gvm, "webview", ".ui.tools.WebViewUI", intent);
                AppBrandProfileUI.a(this.gvm, 7, 1);
                if (AppBrandProfileUI.b(this.gvm).bJu == 3) {
                    AppBrandOnOpReportStartEvent.tV(AppBrandProfileUI.d(this.gvm).appId);
                    return;
                }
                return;
            case 2:
                com.tencent.mm.bg.d.b(this.gvm, "appbrand", ".ui.AppBrandAuthorizeUI", new Intent(this.gvm, AppBrandAuthorizeUI.class).putExtra("key_username", AppBrandProfileUI.e(this.gvm)));
                AppBrandProfileUI.a(this.gvm, 10, 1);
                return;
            case 3:
                com.tencent.mm.bg.d.b(this.gvm, "webview", ".ui.tools.WebViewUI", new Intent().putExtra("rawUrl", String.format(Locale.US, "https://mp.weixin.qq.com/mp/wapreportwxadevlog?action=get_page&appid=%s#wechat_redirect", new Object[]{AppBrandProfileUI.b(this.gvm).appId})).putExtra("forceHideShare", true));
                return;
            default:
                return;
        }
    }
}
