package com.tencent.mm.ui.conversation;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class BaseConversationUI$9 implements AnimationListener {
    final /* synthetic */ BaseConversationUI unn;

    BaseConversationUI$9(BaseConversationUI baseConversationUI) {
        this.unn = baseConversationUI;
    }

    public final void onAnimationStart(Animation animation) {
        au.Em().cii();
        ah.Db(-8);
        x.i("MicroMsg.BaseConversationUI", "klem pop out onAnimationStart");
        this.unn.onSettle(true, 0);
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        au.Em().cik();
        ah.Db(0);
        BaseConversationUI.access$600(this.unn);
        x.i("MicroMsg.BaseConversationUI", "klem pop out onAnimationEnd");
    }
}
