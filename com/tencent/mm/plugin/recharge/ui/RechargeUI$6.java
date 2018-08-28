package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.sdk.platformtools.x;

class RechargeUI$6 implements OnItemClickListener {
    final /* synthetic */ RechargeUI mqE;

    RechargeUI$6(RechargeUI rechargeUI) {
        this.mqE = rechargeUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.mqE.dismissDialog(1);
        x.d("MicroMsg.MallRechargeUI", "onItemClick : " + i);
        RechargeUI.a(this.mqE, RechargeUI.g(this.mqE).vj(i));
        RechargeUI.g(this.mqE).vi(i);
        RechargeUI.g(this.mqE).notifyDataSetChanged();
        RechargeUI.n(this.mqE).remove(RechargeUI.q(RechargeUI.k(this.mqE).moF, RechargeUI.k(this.mqE).bKk, RechargeUI.m(this.mqE)));
        RechargeUI.b(this.mqE);
        RechargeUI.l(this.mqE);
    }
}
