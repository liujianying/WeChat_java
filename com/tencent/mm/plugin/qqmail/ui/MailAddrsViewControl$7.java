package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;

class MailAddrsViewControl$7 implements OnFocusChangeListener {
    final /* synthetic */ MailAddrsViewControl mhb;

    MailAddrsViewControl$7(MailAddrsViewControl mailAddrsViewControl) {
        this.mhb = mailAddrsViewControl;
    }

    public final void onFocusChange(View view, boolean z) {
        if (MailAddrsViewControl.g(this.mhb) != null) {
            MailAddrsViewControl.g(this.mhb).hg(z);
        }
        String obj = this.mhb.mgU.getEditableText().toString();
        if (!z && obj.trim().length() > 0) {
            MailAddrsViewControl.a(this.mhb, obj, false);
        }
        if (MailAddrsViewControl.c(this.mhb) != null && MailAddrsViewControl.c(this.mhb).isSelected()) {
            MailAddrsViewControl.c(this.mhb).setSelected(z);
            MailAddrsViewControl.a(this.mhb, null);
        }
        this.mhb.bpb();
    }
}
