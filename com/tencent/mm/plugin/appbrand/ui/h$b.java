package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

class h$b extends TextView {
    private String cZH;
    final /* synthetic */ h gwP;
    private String mValue;

    static /* synthetic */ void a(h$b h_b, String str) {
        h_b.mValue = str;
        h_b.update();
    }

    static /* synthetic */ void b(h$b h_b, String str) {
        h_b.cZH = str;
        h_b.update();
    }

    public h$b(h hVar, Context context) {
        this.gwP = hVar;
        super(context);
        setLayoutParams(new LayoutParams(-1, -2));
        setTextSize(1, 12.0f);
        setTextColor(-419430401);
    }

    private void update() {
        setText(String.format("%s: %s", new Object[]{this.cZH, this.mValue}));
    }
}
