package com.tencent.mm.plugin.qqmail.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.2;

class MailAddrsViewControl$2$1 implements OnTouchListener {
    final /* synthetic */ 2 mhd;

    MailAddrsViewControl$2$1(2 2) {
        this.mhd = 2;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (!(MailAddrsViewControl.c(this.mhd.mhb) == null || MailAddrsViewControl.c(this.mhd.mhb) == view || !MailAddrsViewControl.c(this.mhd.mhb).isSelected())) {
            MailAddrsViewControl.c(this.mhd.mhb).setSelected(false);
            MailAddrsViewControl.a(this.mhd.mhb, null);
        }
        MailAddrsViewControl.a(this.mhd.mhb, view);
        if (this.mhd.mhb.mgU != null && motionEvent.getAction() == 0) {
            this.mhd.mhc.setSelected(!this.mhd.mhc.isSelected());
            this.mhd.mhb.mgU.setVisibility(0);
            this.mhd.mhb.mgU.requestFocus();
            ((InputMethodManager) this.mhd.mhb.getContext().getSystemService("input_method")).toggleSoftInput(0, 1);
        }
        return MailAddrsViewControl.d(this.mhd.mhb).onTouchEvent(motionEvent);
    }
}
