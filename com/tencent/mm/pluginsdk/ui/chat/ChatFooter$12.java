package com.tencent.mm.pluginsdk.ui.chat;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;

class ChatFooter$12 extends ag {
    final /* synthetic */ ChatFooter qMv;

    ChatFooter$12(ChatFooter chatFooter) {
        this.qMv = chatFooter;
    }

    @SuppressLint({"NewApi"})
    @TargetApi(11)
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1002:
                if (ChatFooter.a(this.qMv) != null && message.obj != null) {
                    boolean booleanValue = ((Boolean) message.obj).booleanValue();
                    if (booleanValue) {
                        ChatFooter.a(this.qMv).setAlpha(1.0f);
                    } else {
                        ChatFooter.a(this.qMv).setAlpha(0.5f);
                    }
                    ChatFooter.a(this.qMv, booleanValue);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
