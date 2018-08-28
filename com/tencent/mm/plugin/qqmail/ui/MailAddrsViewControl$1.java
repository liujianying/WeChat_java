package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;

class MailAddrsViewControl$1 implements OnClickListener {
    final /* synthetic */ MailAddrsViewControl mhb;

    MailAddrsViewControl$1(MailAddrsViewControl mailAddrsViewControl) {
        this.mhb = mailAddrsViewControl;
    }

    public final void onClick(View view) {
        this.mhb.mgU.requestFocus();
        ((InputMethodManager) this.mhb.getContext().getSystemService("input_method")).toggleSoftInput(0, 1);
    }
}
