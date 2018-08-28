package com.tencent.mm.plugin.recharge.ui.form;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.recharge.ui.form.c.b;

class c$b$5 implements OnClickListener {
    final /* synthetic */ b mqS;
    final /* synthetic */ InstantAutoCompleteTextView mqT;

    public c$b$5(b bVar, InstantAutoCompleteTextView instantAutoCompleteTextView) {
        this.mqS = bVar;
        this.mqT = instantAutoCompleteTextView;
    }

    public final void onClick(View view) {
        this.mqT.requestFocus();
    }
}
