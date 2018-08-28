package com.tencent.mm.plugin.account.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.mm.plugin.account.a.f;

class a$1 implements OnTouchListener {
    final /* synthetic */ a ePp;

    a$1(a aVar) {
        this.ePp = aVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            ((TextView) view.findViewById(f.alias_tv)).setTextColor(-10395295);
        } else if (motionEvent.getAction() == 1) {
            ((TextView) view.findViewById(f.alias_tv)).setTextColor(-1);
        }
        return false;
    }
}
