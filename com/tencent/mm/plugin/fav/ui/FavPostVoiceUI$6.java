package com.tencent.mm.plugin.fav.ui;

import android.os.Message;
import com.tencent.mm.plugin.fav.ui.m.d;
import com.tencent.mm.sdk.platformtools.ag;

class FavPostVoiceUI$6 extends ag {
    final /* synthetic */ FavPostVoiceUI iZn;

    FavPostVoiceUI$6(FavPostVoiceUI favPostVoiceUI) {
        this.iZn = favPostVoiceUI;
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        this.iZn.aMo();
        FavPostVoiceUI.g(this.iZn).setBackgroundResource(d.record_shape_press);
        FavPostVoiceUI.g(this.iZn).setEnabled(true);
    }
}
