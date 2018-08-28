package com.tencent.mm.plugin.qqmail.ui;

import android.text.Editable;
import android.text.TextWatcher;

class MailAddrsViewControl$6 implements TextWatcher {
    final /* synthetic */ MailAddrsViewControl mhb;

    MailAddrsViewControl$6(MailAddrsViewControl mailAddrsViewControl) {
        this.mhb = mailAddrsViewControl;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String charSequence2 = charSequence.toString();
        if (charSequence2.endsWith("\n") || charSequence2.endsWith(" ")) {
            MailAddrsViewControl.a(this.mhb, charSequence2, true);
        }
        this.mhb.bpb();
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
    }
}
