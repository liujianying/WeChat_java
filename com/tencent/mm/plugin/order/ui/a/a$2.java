package com.tencent.mm.plugin.order.ui.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.ui.base.preference.f;

class a$2 implements OnClickListener {
    final /* synthetic */ f gui;
    final /* synthetic */ MallTransactionObject lNC;
    final /* synthetic */ a lQe;
    final /* synthetic */ f lQf;

    a$2(a aVar, MallTransactionObject mallTransactionObject, f fVar, f fVar2) {
        this.lQe = aVar;
        this.lNC = mallTransactionObject;
        this.lQf = fVar;
        this.gui = fVar2;
    }

    public final void onClick(View view) {
        this.lQf.setContent(this.lNC.desc + "\n" + this.lNC.lNL);
        this.gui.notifyDataSetChanged();
    }
}
