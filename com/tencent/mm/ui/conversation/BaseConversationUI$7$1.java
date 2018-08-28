package com.tencent.mm.ui.conversation;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.conversation.BaseConversationUI.7;

class BaseConversationUI$7$1 implements OnApplyWindowInsetsListener {
    final /* synthetic */ 7 unp;

    BaseConversationUI$7$1(7 7) {
        this.unp = 7;
    }

    @TargetApi(20)
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        if (windowInsets != null) {
            x.i("MicroMsg.BaseConversationUI", "OnApplyWindowInsetsListener %s", new Object[]{windowInsets});
            windowInsets.consumeSystemWindowInsets();
            BaseConversationUI.access$1300(this.unp.unn, this.unp.tpu, windowInsets.getSystemWindowInsetTop(), new Rect(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom()), this.unp.tpv);
        }
        return windowInsets;
    }
}
