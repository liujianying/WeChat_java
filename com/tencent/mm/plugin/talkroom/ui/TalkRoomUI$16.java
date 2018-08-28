package com.tencent.mm.plugin.talkroom.ui;

import android.view.View;
import android.view.View.OnClickListener;

class TalkRoomUI$16 implements OnClickListener {
    final /* synthetic */ TalkRoomUI oxW;

    TalkRoomUI$16(TalkRoomUI talkRoomUI) {
        this.oxW = talkRoomUI;
    }

    public final void onClick(View view) {
        this.oxW.onBackPressed();
    }
}
