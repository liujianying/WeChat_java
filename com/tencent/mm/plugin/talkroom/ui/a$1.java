package com.tencent.mm.plugin.talkroom.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;

class a$1 extends ag {
    final /* synthetic */ a oxx;

    a$1(a aVar) {
        this.oxx = aVar;
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        a.a(this.oxx).dismiss();
    }
}
