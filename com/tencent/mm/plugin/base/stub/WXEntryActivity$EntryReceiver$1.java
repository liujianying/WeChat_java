package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.kernel.api.g;
import com.tencent.mm.plugin.base.stub.WXEntryActivity.EntryReceiver;

class WXEntryActivity$EntryReceiver$1 implements g {
    final /* synthetic */ Intent heh;
    final /* synthetic */ EntryReceiver hei;
    final /* synthetic */ Context val$context;

    WXEntryActivity$EntryReceiver$1(EntryReceiver entryReceiver, Context context, Intent intent) {
        this.hei = entryReceiver;
        this.val$context = context;
        this.heh = intent;
    }

    public final void vk() {
        com.tencent.mm.kernel.g.Ek().b(this);
        EntryReceiver.a(this.hei, this.val$context, this.heh);
    }

    public final void aF(boolean z) {
    }
}
