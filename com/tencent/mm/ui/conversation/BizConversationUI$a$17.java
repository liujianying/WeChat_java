package com.tencent.mm.ui.conversation;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.ui.conversation.BizConversationUI.a;

class BizConversationUI$a$17 implements OnTouchListener {
    final /* synthetic */ a unz;

    BizConversationUI$a$17(a aVar) {
        this.unz = aVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                a.b(this.unz, (int) motionEvent.getRawX());
                a.c(this.unz, (int) motionEvent.getRawY());
                break;
        }
        return false;
    }
}
