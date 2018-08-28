package com.tencent.mm.ui.conversation;

import android.content.Intent;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.g;

class BaseConversationUI$8 implements Runnable {
    final /* synthetic */ BaseConversationUI unn;

    BaseConversationUI$8(BaseConversationUI baseConversationUI) {
        this.unn = baseConversationUI;
    }

    public final void run() {
        this.unn.mChattingClosed = false;
        if (!this.unn.isFinishing()) {
            boolean z;
            String str = "MicroMsg.BaseConversationUI";
            String str2 = "ashutest::startChatting, ishow:%b";
            Object[] objArr = new Object[1];
            if (BaseConversationUI.access$200(this.unn) == null) {
                z = false;
            } else {
                z = BaseConversationUI.access$200(this.unn).isShown();
            }
            objArr[0] = Boolean.valueOf(z);
            x.i(str, str2, objArr);
            Intent putExtra = new Intent().putExtra("Chat_User", this.unn.pendingUser);
            if (this.unn.pendingBundle != null) {
                putExtra.putExtras(this.unn.pendingBundle);
            }
            putExtra.putExtra("img_gallery_enter_from_chatting_ui", true);
            BaseConversationUI.access$300(this.unn, putExtra, false);
            BaseConversationUI.access$1200(this.unn).setOnChattingLayoutChangedListener(BaseConversationUI.access$1400(this.unn));
            BaseConversationUI.access$200(this.unn).setTranslationX((this.unn.getWindow().getDecorView().getWidth() == 0 ? (float) this.unn.getResources().getDisplayMetrics().widthPixels : (float) this.unn.getWindow().getDecorView().getWidth()) - 0.1f);
            BaseConversationUI.access$200(this.unn).setVisibility(0);
            this.unn.pauseMainFragment();
            if (BaseConversationUI.access$100(this.unn).isSupportNavigationSwipeBack()) {
                g.a(this.unn);
            }
            e.post(new 1(this), "directReport_startChattingRunnable");
            BaseConversationUI.access$402(this.unn, bi.VE());
        }
    }

    public final String toString() {
        return super.toString() + "|startChattingRunnable";
    }
}
