package com.tencent.mm.ui.conversation;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.conversation.BaseConversationUI.6;

class BaseConversationUI$6$1 implements AnimationListener {
    final /* synthetic */ 6 uno;

    BaseConversationUI$6$1(6 6) {
        this.uno = 6;
    }

    public final void onAnimationStart(Animation animation) {
        x.i("MicroMsg.BaseConversationUI", "klem onAnimationStart onDrawed->onAnimationStart:%sms", new Object[]{Long.valueOf(System.currentTimeMillis() - this.uno.start)});
        BaseConversationUI.access$802(this.uno.unn, true);
        BaseConversationUI.access$900(this.uno.unn);
        this.uno.unn.onSettle(false, 0);
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        BaseConversationUI.access$802(this.uno.unn, false);
        x.i("MicroMsg.BaseConversationUI", "klem animationEnd");
        BaseConversationUI.access$1000(this.uno.unn);
    }
}
