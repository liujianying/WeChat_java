package com.tencent.mm.pluginsdk.ui.chat;

import android.os.Message;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.sdk.platformtools.ag;

class ChatFooter$24 extends ag {
    final /* synthetic */ ChatFooter qMv;

    ChatFooter$24(ChatFooter chatFooter) {
        this.qMv = chatFooter;
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 4097:
                ChatFooter.f(this.qMv, true);
                LayoutParams layoutParams = ChatFooter.m(this.qMv).getLayoutParams();
                int bottom = ChatFooter.m(this.qMv).getBottom() - ChatFooter.m(this.qMv).getTop();
                if (this.qMv.ceI()) {
                    if (ChatFooter.n(this.qMv) != null) {
                        ChatFooter.n(this.qMv).setVisibility(8);
                    }
                    this.qMv.setAppPanelVisible(8);
                    ChatFooter.m(this.qMv).setVisibility(4);
                }
                if (bottom <= 3) {
                    ChatFooter.f(this.qMv, false);
                    ChatFooter.m(this.qMv).setVisibility(8);
                    ChatFooter.c(this.qMv, this.qMv.getKeyBordHeightPX());
                    return;
                }
                layoutParams.height = Math.max(bottom - 60, 1);
                ChatFooter.m(this.qMv).setLayoutParams(layoutParams);
                ChatFooter.J(this.qMv);
                return;
            default:
                return;
        }
    }
}
