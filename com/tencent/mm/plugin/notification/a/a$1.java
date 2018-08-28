package com.tencent.mm.plugin.notification.a;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ag;

class a$1 extends ag {
    final /* synthetic */ a lHk;

    a$1(a aVar, Looper looper) {
        this.lHk = aVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        au.Em().h(new 1(this, message.getData().getString("com.tencent.mm.notification.observer")), 500);
    }
}
