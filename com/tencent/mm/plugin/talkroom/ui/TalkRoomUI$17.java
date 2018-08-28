package com.tencent.mm.plugin.talkroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bi;

class TalkRoomUI$17 implements OnDismissListener {
    final /* synthetic */ TalkRoomUI oxW;

    TalkRoomUI$17(TalkRoomUI talkRoomUI) {
        this.oxW = talkRoomUI;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        au.HU();
        int a = bi.a((Integer) c.DT().get(144641, null), 0) + 1;
        au.HU();
        c.DT().set(144641, Integer.valueOf(a));
        this.oxW.onBackPressed();
    }
}
