package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bu.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.e;

class WxaWidgetDebugUI$3 implements OnClickListener {
    final /* synthetic */ WxaWidgetDebugUI fxT;

    WxaWidgetDebugUI$3(WxaWidgetDebugUI wxaWidgetDebugUI) {
        this.fxT = wxaWidgetDebugUI;
    }

    public final void onClick(View view) {
        ((e) g.l(e.class)).JM().restart();
        a.j(new 1(this), 1000);
    }
}
