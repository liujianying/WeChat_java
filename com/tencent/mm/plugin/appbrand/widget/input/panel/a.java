package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.view.View;

public abstract class a {
    Context gKE;
    protected c gKF;
    int gKG = 0;

    public abstract int aqc();

    public abstract int aqd();

    public abstract int aqe();

    public abstract int getPageCount();

    public abstract int getRowCount();

    public abstract int getRowSpacing();

    public abstract View mk(int i);

    public final void setPanelManager(c cVar) {
        this.gKF = cVar;
    }

    a() {
    }
}
