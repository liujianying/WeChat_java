package com.tencent.mm.plugin.pwdgroup.ui.widget;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;

class MMCallBackScrollView$1 extends ag {
    final /* synthetic */ MMCallBackScrollView maE;

    MMCallBackScrollView$1(MMCallBackScrollView mMCallBackScrollView) {
        this.maE = mMCallBackScrollView;
    }

    public final void handleMessage(Message message) {
        int scrollY = this.maE.getScrollY();
        if (scrollY == MMCallBackScrollView.a(this.maE)) {
            MMCallBackScrollView.a(this.maE, 0);
            return;
        }
        MMCallBackScrollView.b(this.maE, scrollY);
        MMCallBackScrollView.b(this.maE).sendMessageDelayed(MMCallBackScrollView.b(this.maE).obtainMessage(), 5);
        MMCallBackScrollView.a(this.maE, 1);
    }
}
