package com.tencent.mm.ui.conversation;

import android.os.Bundle;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.ui.y;

public class EnterpriseConversationUI extends BaseConversationUI {
    private View contentView;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.contentView = y.gq(this).inflate(R.i.bizconversation_activity_container, null);
        setContentView(this.contentView);
        this.conversationFm = new a();
        getSupportFragmentManager().bk().a(R.h.mm_root_view, this.conversationFm).commit();
        e.a(this, this.contentView);
    }

    public void finish() {
        if (this.conversationFm != null && (this.conversationFm instanceof a)) {
            ((a) this.conversationFm).eiC = System.currentTimeMillis() / 1000;
        }
        super.finish();
    }
}
