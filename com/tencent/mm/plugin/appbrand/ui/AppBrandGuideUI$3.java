package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.appbrand.report.a.o;
import com.tencent.mm.plugin.appbrand.report.a.o.a;

class AppBrandGuideUI$3 implements OnClickListener {
    final /* synthetic */ AppBrandGuideUI guv;

    AppBrandGuideUI$3(AppBrandGuideUI appBrandGuideUI) {
        this.guv = appBrandGuideUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.guv.startActivity(new Intent(this.guv, AppBrandLauncherUI.class).putExtra("extra_enter_scene", 11));
        o.a(a.gsy, "");
        this.guv.finish();
    }
}
