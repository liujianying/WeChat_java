package com.tencent.mm.pluginsdk.ui.chat;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;

class ChatFooter$9 implements OnKeyListener {
    final /* synthetic */ ChatFooter qMv;

    ChatFooter$9(ChatFooter chatFooter) {
        this.qMv = chatFooter;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        switch (keyEvent.getAction()) {
            case 0:
                if (!((i != 23 && i != 66) || ChatFooter.u(this.qMv) || ChatFooter.t(this.qMv))) {
                    ChatFooter.d(this.qMv, true);
                    ChatFooter.r(this.qMv).setBackgroundDrawable(a.f(this.qMv.getContext(), R.g.record_shape_press));
                    ChatFooter.r(this.qMv).setText(R.l.chatfooter_releasetofinish);
                    if (ChatFooter.j(this.qMv) != null) {
                        ChatFooter.j(this.qMv).bct();
                    }
                    ChatFooter.r(this.qMv).setContentDescription(this.qMv.getContext().getString(R.l.chat_footer_switch_press_btn));
                    break;
                }
            case 1:
                if (i == 23 || i == 66) {
                    ChatFooter.r(this.qMv).setBackgroundDrawable(a.f(this.qMv.getContext(), R.g.record_shape_normal));
                    ChatFooter.r(this.qMv).setText(R.l.chatfooter_presstorcd);
                    if (ChatFooter.j(this.qMv) != null) {
                        ChatFooter.j(this.qMv).bcq();
                    }
                    ChatFooter.d(this.qMv, false);
                    break;
                }
        }
        return false;
    }
}
