package com.tencent.mm.plugin.multitalk.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.multitalk.a.o;
import com.tencent.mm.plugin.multitalk.ui.widget.e;

class MultiTalkMainUI$3 extends BroadcastReceiver {
    final /* synthetic */ MultiTalkMainUI luY;

    MultiTalkMainUI$3(MultiTalkMainUI multiTalkMainUI) {
        this.luY = multiTalkMainUI;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.SCREEN_OFF".equals(intent.getAction()) && o.bgN().lts == e.lvJ) {
            o.bgN().stopRing();
            MultiTalkMainUI.a(this.luY);
        }
    }
}
