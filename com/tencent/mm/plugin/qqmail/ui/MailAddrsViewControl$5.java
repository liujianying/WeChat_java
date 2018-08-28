package com.tencent.mm.plugin.qqmail.ui;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.mm.plugin.qqmail.b.i;

class MailAddrsViewControl$5 implements OnKeyListener {
    final /* synthetic */ MailAddrsViewControl mhb;

    MailAddrsViewControl$5(MailAddrsViewControl mailAddrsViewControl) {
        this.mhb = mailAddrsViewControl;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        String obj;
        if (i == 67 && keyEvent.getAction() == 0) {
            obj = this.mhb.mgU.getEditableText().toString();
            if (obj.length() == 0 && MailAddrsViewControl.c(this.mhb) != null && MailAddrsViewControl.c(this.mhb).isSelected()) {
                this.mhb.f((i) MailAddrsViewControl.c(this.mhb).getTag());
                MailAddrsViewControl.a(this.mhb, null);
                this.mhb.bpb();
            } else if (obj.length() == 0 && MailAddrsViewControl.f(this.mhb).size() > 0) {
                int size = MailAddrsViewControl.f(this.mhb).size() - 1;
                View childAt = this.mhb.getChildAt(size);
                if (childAt.isSelected()) {
                    this.mhb.f((i) MailAddrsViewControl.f(this.mhb).get(size));
                    this.mhb.bpb();
                } else {
                    childAt.setSelected(true);
                }
            }
        } else if (i == 66 && keyEvent.getAction() == 0) {
            obj = this.mhb.mgU.getEditableText().toString();
            if (obj != null && obj.length() > 0) {
                MailAddrsViewControl.a(this.mhb, obj, true);
                this.mhb.bpb();
            }
        }
        return false;
    }
}
