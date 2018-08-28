package com.tencent.mm.plugin.account.friend.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.plugin.account.friend.a.i;

class FindMContactInviteUI$9 implements OnTouchListener {
    final /* synthetic */ FindMContactInviteUI eLY;

    FindMContactInviteUI$9(FindMContactInviteUI findMContactInviteUI) {
        this.eLY = findMContactInviteUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (FindMContactInviteUI.b(this.eLY) != null) {
            i b = FindMContactInviteUI.b(this.eLY);
            if (b.eKg != null) {
                b.eKg.onTouchEvent(motionEvent);
            }
        }
        return false;
    }
}
