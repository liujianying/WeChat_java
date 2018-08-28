package com.tencent.mm.ui.conversation;

import android.os.Bundle;
import android.support.annotation.Keep;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a;
import com.tencent.mm.ui.y;

@Keep
public final class AppBrandServiceConversationUI extends BaseConversationUI {
    private static final String TAG = "MicroMsg.AppBrandServiceConversationUI";
    private View contentView;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.contentView = y.gq(this).inflate(R.i.bizconversation_activity_container, null);
        setContentView(this.contentView);
        this.conversationFm = new AppBrandServiceConversationFmUI();
        getSupportFragmentManager().bk().a(R.h.mm_root_view, this.conversationFm).commit();
        e.a(this, this.contentView);
    }

    public final void finish() {
        super.finish();
    }

    protected final com.tencent.mm.ui.chatting.y getChattingUIFragment() {
        return new a();
    }
}
