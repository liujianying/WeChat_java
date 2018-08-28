package com.tencent.mm.plugin.talkroom.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.base.i;

class TalkRoomUI$2 implements OnClickListener {
    final /* synthetic */ i fyw;
    final /* synthetic */ TalkRoomUI oxW;

    TalkRoomUI$2(TalkRoomUI talkRoomUI, i iVar) {
        this.oxW = talkRoomUI;
        this.fyw = iVar;
    }

    public final void onClick(View view) {
        this.fyw.dismiss();
    }
}
