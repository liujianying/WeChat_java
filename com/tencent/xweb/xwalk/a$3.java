package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.xweb.k;

class a$3 implements OnClickListener {
    final /* synthetic */ a vEm;
    final /* synthetic */ Button vEn;

    a$3(a aVar, Button button) {
        this.vEm = aVar;
        this.vEn = button;
    }

    public final void onClick(View view) {
        boolean z = !k.cIn().vAr;
        k.cIn().mV(z);
        this.vEm.a(z, this.vEn, true);
    }
}
