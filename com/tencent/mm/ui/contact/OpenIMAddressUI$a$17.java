package com.tencent.mm.ui.contact;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.ui.contact.OpenIMAddressUI.a;

class OpenIMAddressUI$a$17 implements OnTouchListener {
    final /* synthetic */ a ulb;

    OpenIMAddressUI$a$17(a aVar) {
        this.ulb = aVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.ulb.hideVKB();
                a.a(this.ulb, (int) motionEvent.getRawX());
                a.b(this.ulb, (int) motionEvent.getRawY());
                break;
        }
        return false;
    }
}
