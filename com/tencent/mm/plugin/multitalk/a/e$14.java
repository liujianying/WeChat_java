package com.tencent.mm.plugin.multitalk.a;

import android.content.Intent;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.voip.model.i;
import com.tencent.mm.sdk.platformtools.ad;

class e$14 implements Runnable {
    final /* synthetic */ e ltL;

    e$14(e eVar) {
        this.ltL = eVar;
    }

    public final void run() {
        Intent intent = new Intent();
        intent.setFlags(268435456);
        intent.putExtra("enterMainUiWxGroupId", this.ltL.ltt != null ? this.ltL.ltt.vgo : "");
        intent.setClass(ad.getContext(), MultiTalkMainUI.class);
        intent.putExtra("enterMainUiSource", 1);
        i.bJJ().a(intent, new 1(this));
    }
}
