package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.base.stub.WXEntryActivity.EntryReceiver;
import com.tencent.mm.sdk.platformtools.x;

class WXEntryActivity$EntryReceiver$2 implements Runnable {
    final /* synthetic */ Intent heh;
    final /* synthetic */ EntryReceiver hei;
    final /* synthetic */ Context val$context;

    WXEntryActivity$EntryReceiver$2(EntryReceiver entryReceiver, Context context, Intent intent) {
        this.hei = entryReceiver;
        this.val$context = context;
        this.heh = intent;
    }

    public final void run() {
        long currentTimeMillis = System.currentTimeMillis();
        EntryReceiver.a(this.hei, this.val$context, this.heh);
        x.i("MicroMsg.WXEntryActivity", "cost:%s", new Object[]{(System.currentTimeMillis() - currentTimeMillis)});
    }
}
