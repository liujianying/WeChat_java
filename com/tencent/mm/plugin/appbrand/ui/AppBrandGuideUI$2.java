package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.appbrand.report.a.o;
import com.tencent.mm.plugin.appbrand.report.a.o$a;

class AppBrandGuideUI$2 implements OnClickListener {
    final /* synthetic */ AppBrandGuideUI guv;

    AppBrandGuideUI$2(AppBrandGuideUI appBrandGuideUI) {
        this.guv = appBrandGuideUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        o.a(o$a.GUIDE_CLOSE, "");
        this.guv.finish();
    }
}
