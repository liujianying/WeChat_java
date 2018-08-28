package com.tencent.mm.plugin.label.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ContactLabelManagerUI$11 implements OnTouchListener {
    final /* synthetic */ ContactLabelManagerUI kBk;

    ContactLabelManagerUI$11(ContactLabelManagerUI contactLabelManagerUI) {
        this.kBk = contactLabelManagerUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            ContactLabelManagerUI.a(this.kBk, (int) motionEvent.getRawX());
            ContactLabelManagerUI.b(this.kBk, (int) motionEvent.getRawY());
        }
        return false;
    }
}
