package com.tencent.mm.plugin.recharge.ui.form;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.plugin.recharge.ui.form.c.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class c$b$4 implements OnFocusChangeListener {
    final /* synthetic */ b mqS;
    final /* synthetic */ InstantAutoCompleteTextView mqT;

    public c$b$4(b bVar, InstantAutoCompleteTextView instantAutoCompleteTextView) {
        this.mqS = bVar;
        this.mqT = instantAutoCompleteTextView;
    }

    public final void onFocusChange(View view, boolean z) {
        if (z) {
            this.mqT.setHintTextColor(view.getContext().getResources().getColor(c.confirm_edit_text_color));
            if (this.mqS.mph != null && this.mqS.mph.bJt == 2 && !this.mqS.mqR) {
                x.d(c.bP(), "clear input");
                this.mqS.mqP.bqn();
                this.mqS.mph = null;
            } else if (this.mqS.mqR) {
                this.mqS.mqR = false;
            }
            if (bi.oW(this.mqT.getText().toString())) {
                this.mqT.showDropDown();
            }
        }
    }
}
