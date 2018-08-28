package com.tencent.mm.ui.contact;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.ui.contact.AddressUI.a;

class AddressUI$a$4 implements OnTouchListener {
    final /* synthetic */ a uhE;

    AddressUI$a$4(a aVar) {
        this.uhE = aVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.uhE.hideVKB();
                a.a(this.uhE, (int) motionEvent.getRawX());
                a.b(this.uhE, (int) motionEvent.getRawY());
                break;
        }
        return false;
    }
}
