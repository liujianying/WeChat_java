package com.tencent.mm.ui.contact;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.ui.voicesearch.b;

class ChatroomContactUI$13 implements OnTouchListener {
    final /* synthetic */ ChatroomContactUI uiv;

    ChatroomContactUI$13(ChatroomContactUI chatroomContactUI) {
        this.uiv = chatroomContactUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.uiv.YC();
                ChatroomContactUI.a(this.uiv, (int) motionEvent.getRawX());
                ChatroomContactUI.b(this.uiv, (int) motionEvent.getRawY());
                break;
        }
        if (ChatroomContactUI.f(this.uiv) != null) {
            d f = ChatroomContactUI.f(this.uiv);
            if (f.eKg != null) {
                f.eKg.onTouchEvent(motionEvent);
            }
        }
        if (ChatroomContactUI.d(this.uiv) != null) {
            b d = ChatroomContactUI.d(this.uiv);
            if (d.eKg != null) {
                d.eKg.onTouchEvent(motionEvent);
            }
        }
        return false;
    }
}
