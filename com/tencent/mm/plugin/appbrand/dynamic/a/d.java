package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.modelappbrand.j;
import com.tencent.mm.modelappbrand.j.a;
import com.tencent.mm.plugin.appbrand.appcache.d$a;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.b;
import com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetDebugUI;
import com.tencent.mm.plugin.appbrand.wxawidget.console.e;

public final class d implements j {
    boolean fvq;

    public final void d(Context context, Bundle bundle) {
        Intent intent = new Intent(context, WxaWidgetDebugUI.class);
        String bh = WxaWidgetInitializer.bh(bundle.getString("app_id"), bundle.getString("msg_id"));
        intent.putExtras(bundle);
        intent.putExtra("id", bh);
        context.startActivity(intent);
    }

    public final void bI(Context context) {
        e.cP(context);
    }

    public final boolean ho(int i) {
        return d$a.ho(i);
    }

    public final boolean a(String str, a aVar) {
        return b.c(str, aVar);
    }

    public final boolean b(String str, a aVar) {
        return b.d(str, aVar);
    }

    public final void bx(boolean z) {
        this.fvq = z;
    }

    public final boolean JP() {
        return this.fvq;
    }

    public final boolean JQ() {
        return com.tencent.mm.sdk.a.b.chp();
    }
}
