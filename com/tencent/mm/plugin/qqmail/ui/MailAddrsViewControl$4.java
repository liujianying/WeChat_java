package com.tencent.mm.plugin.qqmail.ui;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class MailAddrsViewControl$4 implements OnEditorActionListener {
    final /* synthetic */ MailAddrsViewControl mhb;

    MailAddrsViewControl$4(MailAddrsViewControl mailAddrsViewControl) {
        this.mhb = mailAddrsViewControl;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 5) {
            String obj = this.mhb.mgU.getEditableText().toString();
            if (obj != null && obj.length() > 0) {
                MailAddrsViewControl.a(this.mhb, obj, false);
                this.mhb.bpb();
            }
        }
        return true;
    }
}
