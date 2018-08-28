package com.tencent.mm.plugin.label.ui;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.label.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class ContactLabelEditUI$1 extends ag {
    final /* synthetic */ ContactLabelEditUI kAZ;

    ContactLabelEditUI$1(ContactLabelEditUI contactLabelEditUI, Looper looper) {
        this.kAZ = contactLabelEditUI;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 6001:
                ContactLabelEditUI.a(this.kAZ);
                return;
            case 6002:
                a.ezo.vl();
                return;
            default:
                x.w("MicroMsg.Label.ContactLabelEditUI", "unknow message. what is:%d", new Object[]{Integer.valueOf(message.what)});
                return;
        }
    }
}
