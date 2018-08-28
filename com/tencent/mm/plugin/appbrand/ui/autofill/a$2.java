package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class a$2 implements OnCheckedChangeListener {
    final /* synthetic */ a gxq;

    a$2(a aVar) {
        this.gxq = aVar;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (a.b(this.gxq) != null) {
            a.b(this.gxq).setEnabled(z);
        }
    }
}
