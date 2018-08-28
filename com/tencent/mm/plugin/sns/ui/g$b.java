package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;

abstract class g$b {
    OnClickListener nKO = new 1(this);
    OnClickListener nKP = new 2(this);
    OnClickListener nKQ = new OnClickListener() {
        public final void onClick(View view) {
            g$b.this.nKR = (a) view.getTag();
            g$b.this.xf(g$b.this.nKR.position);
        }
    };
    public a nKR = new a();

    public abstract void xf(int i);
}
