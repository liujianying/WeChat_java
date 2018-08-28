package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnClickListener;

class TalkRoomPopupNav$1 implements OnClickListener {
    final /* synthetic */ TalkRoomPopupNav tBl;

    TalkRoomPopupNav$1(TalkRoomPopupNav talkRoomPopupNav) {
        this.tBl = talkRoomPopupNav;
    }

    public final void onClick(View view) {
        if (TalkRoomPopupNav.a(this.tBl) != null) {
            TalkRoomPopupNav.a(this.tBl).cse();
        }
    }
}
