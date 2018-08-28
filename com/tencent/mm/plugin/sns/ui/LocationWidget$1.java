package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;

class LocationWidget$1 implements OnClickListener {
    final /* synthetic */ int eaH;
    final /* synthetic */ LocationWidget nOH;

    LocationWidget$1(LocationWidget locationWidget, int i) {
        this.nOH = locationWidget;
        this.eaH = i;
    }

    public final void onClick(View view) {
        if (LocationWidget.a(this.nOH) == this.eaH + 1) {
            LocationWidget.b(this.nOH);
        } else {
            LocationWidget.a(this.nOH, this.eaH + 1);
        }
        LocationWidget.c(this.nOH);
    }
}
