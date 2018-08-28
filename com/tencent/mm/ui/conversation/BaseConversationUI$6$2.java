package com.tencent.mm.ui.conversation;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.conversation.BaseConversationUI.6;
import com.tencent.mm.ui.tools.TestTimeForChatting.a;

class BaseConversationUI$6$2 implements a {
    final /* synthetic */ 6 uno;

    BaseConversationUI$6$2(6 6) {
        this.uno = 6;
    }

    public final void cqP() {
        x.i("MicroMsg.BaseConversationUI", "[onDrawed]");
        this.uno.start = System.currentTimeMillis();
        if (BaseConversationUI.access$100(this.uno.unn).getSwipeBackLayout() != null) {
            BaseConversationUI.access$100(this.uno.unn).getSwipeBackLayout().startAnimation(BaseConversationUI.access$700(this.uno.unn));
        } else {
            BaseConversationUI.access$100(this.uno.unn).getView().startAnimation(BaseConversationUI.access$700(this.uno.unn));
        }
        BaseConversationUI.access$200(this.uno.unn).setOndispatchDraw(null);
    }
}
