package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mm.plugin.appbrand.report.a.o;
import com.tencent.mm.plugin.appbrand.report.a.o$a;

class AppBrandGuideUI$4 implements OnKeyListener {
    final /* synthetic */ AppBrandGuideUI guv;

    AppBrandGuideUI$4(AppBrandGuideUI appBrandGuideUI) {
        this.guv = appBrandGuideUI;
    }

    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (4 != i) {
            return false;
        }
        if (1 != keyEvent.getAction()) {
            return true;
        }
        o.a(o$a.GUIDE_CLOSE_BY_BACK, "");
        this.guv.finish();
        return true;
    }
}
