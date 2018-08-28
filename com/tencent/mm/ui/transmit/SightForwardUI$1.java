package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.mm.plugin.sight.encode.ui.b;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.chatting.ChattingUI;

class SightForwardUI$1 implements b {
    final /* synthetic */ SightForwardUI uFa;

    SightForwardUI$1(SightForwardUI sightForwardUI) {
        this.uFa = sightForwardUI;
    }

    public final void Lq(String str) {
        Intent intent = new Intent(this.uFa.mController.tml, ChattingUI.class);
        intent.addFlags(67108864);
        intent.putExtra("Chat_User", str);
        this.uFa.startActivity(intent);
        this.uFa.finish();
    }

    public final void bwp() {
        Intent intent = new Intent();
        intent.setClass(this.uFa.mController.tml, LauncherUI.class).addFlags(67108864);
        this.uFa.startActivity(intent);
        this.uFa.finish();
    }
}
