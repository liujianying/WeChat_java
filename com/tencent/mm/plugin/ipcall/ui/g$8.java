package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.ipcall.a.e.d;

class g$8 implements OnClickListener {
    final /* synthetic */ g kwi;

    g$8(g gVar) {
        this.kwi = gVar;
    }

    public final void onClick(View view) {
        this.kwi.dismiss();
        Intent intent = new Intent();
        intent.putExtra("IPCallShareCouponCardUI_KFrom", 2);
        intent.setClass(g.i(this.kwi), IPCallShareCouponCardUI.class);
        g.i(this.kwi).startActivity(intent);
        d.a(1, -1, g.h(this.kwi), g.b(this.kwi, g.h(this.kwi)), 1, 1, -1, g.e(this.kwi), g.f(this.kwi));
    }
}
