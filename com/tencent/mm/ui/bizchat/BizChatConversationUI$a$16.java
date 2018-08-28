package com.tencent.mm.ui.bizchat;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.ui.bizchat.BizChatConversationUI.a;

class BizChatConversationUI$a$16 implements OnTouchListener {
    final /* synthetic */ a tEC;

    BizChatConversationUI$a$16(a aVar) {
        this.tEC = aVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            a.a(this.tEC, (int) motionEvent.getRawX());
            a.b(this.tEC, (int) motionEvent.getRawY());
        }
        return false;
    }
}
