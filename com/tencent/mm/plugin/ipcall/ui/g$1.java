package com.tencent.mm.plugin.ipcall.ui;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mm.plugin.ipcall.ui.g.2;

class g$1 implements OnGlobalLayoutListener {
    final /* synthetic */ View kwh;
    final /* synthetic */ g kwi;

    g$1(g gVar, View view) {
        this.kwi = gVar;
        this.kwh = view;
    }

    public final void onGlobalLayout() {
        Rect rect = new Rect();
        this.kwh.getWindowVisibleDisplayFrame(rect);
        if (this.kwh.getRootView().getHeight() - (rect.bottom - rect.top) > 100) {
            g gVar = this.kwi;
            gVar.hyK.postDelayed(new 2(gVar), 100);
        }
    }
}
