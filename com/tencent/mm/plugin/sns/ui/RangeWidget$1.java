package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class RangeWidget$1 implements OnClickListener {
    final /* synthetic */ RangeWidget nQS;

    RangeWidget$1(RangeWidget rangeWidget) {
        this.nQS = rangeWidget;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(RangeWidget.a(this.nQS), SnsLabelUI.class);
        intent.putExtra("KLabel_range_index", RangeWidget.b(this.nQS));
        intent.putExtra("Klabel_name_list", RangeWidget.c(this.nQS));
        intent.putExtra("Kother_user_name_list", RangeWidget.d(this.nQS));
        intent.putExtra("k_sns_label_ui_style", this.nQS.style);
        RangeWidget.a(this.nQS).startActivityForResult(intent, 5);
    }
}
