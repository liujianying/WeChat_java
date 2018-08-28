package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class ShakeSayHiListUI$1 implements OnClickListener {
    final /* synthetic */ View lCA;
    final /* synthetic */ ShakeSayHiListUI nbq;

    ShakeSayHiListUI$1(ShakeSayHiListUI shakeSayHiListUI, View view) {
        this.nbq = shakeSayHiListUI;
        this.lCA = view;
    }

    public final void onClick(View view) {
        ShakeSayHiListUI.a(this.nbq, ShakeSayHiListUI.a(this.nbq) + 8);
        x.d("MicroMsg.SayHiListUI", "dkfooter more btn:" + ShakeSayHiListUI.a(this.nbq));
        ShakeSayHiListUI.b(this.nbq).vZ(ShakeSayHiListUI.a(this.nbq));
        if (ShakeSayHiListUI.c(this.nbq) <= ShakeSayHiListUI.a(this.nbq)) {
            ShakeSayHiListUI.d(this.nbq).removeFooterView(this.lCA);
            x.d("MicroMsg.SayHiListUI", "dkfooter REMOVE more btn: " + ShakeSayHiListUI.a(this.nbq));
        }
    }
}
