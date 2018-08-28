package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

class f$2 implements OnClickListener {
    final /* synthetic */ p fJO;
    final /* synthetic */ f fKA;

    f$2(f fVar, p pVar) {
        this.fKA = fVar;
        this.fJO = pVar;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "do know the auth auto fill data protocol");
        String str = this.fJO.mContext.getString(j.app_brand_auth_user_auto_fill_data_url) + w.chP();
        x.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "do open url:" + str);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        d.b(this.fJO.mContext, "webview", ".ui.tools.WebViewUI", intent);
    }
}
