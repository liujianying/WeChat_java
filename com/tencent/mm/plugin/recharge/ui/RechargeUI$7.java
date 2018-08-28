package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.ui.ListViewInScrollView;

class RechargeUI$7 implements OnClickListener {
    final /* synthetic */ RechargeUI mqE;
    final /* synthetic */ View mqF;
    final /* synthetic */ TextView mqG;
    final /* synthetic */ int mqH;
    final /* synthetic */ ListViewInScrollView mqI;
    final /* synthetic */ View mqJ;
    final /* synthetic */ TextView mqK;
    final /* synthetic */ int mqL;
    final /* synthetic */ ListViewInScrollView mqM;
    final /* synthetic */ TextView mqN;

    RechargeUI$7(RechargeUI rechargeUI, View view, TextView textView, int i, ListViewInScrollView listViewInScrollView, View view2, TextView textView2, int i2, ListViewInScrollView listViewInScrollView2, TextView textView3) {
        this.mqE = rechargeUI;
        this.mqF = view;
        this.mqG = textView;
        this.mqH = i;
        this.mqI = listViewInScrollView;
        this.mqJ = view2;
        this.mqK = textView2;
        this.mqL = i2;
        this.mqM = listViewInScrollView2;
        this.mqN = textView3;
    }

    public final void onClick(View view) {
        this.mqF.setVisibility(0);
        this.mqG.setTextColor(this.mqH);
        this.mqI.setVisibility(0);
        this.mqJ.setVisibility(8);
        this.mqK.setTextColor(this.mqL);
        this.mqM.setVisibility(8);
        if (RechargeUI.f(this.mqE).getCount() == 0) {
            this.mqN.setVisibility(0);
        } else {
            this.mqN.setVisibility(8);
        }
    }
}
