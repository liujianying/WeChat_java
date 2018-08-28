package com.tencent.mm.ui.conversation;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.y;

public class BizConversationUI extends BaseConversationUI {
    private View contentView;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (au.HX()) {
            this.contentView = y.gq(this).inflate(R.i.bizconversation_activity_container, null);
            setContentView(this.contentView);
            this.conversationFm = new a();
            getSupportFragmentManager().bk().a(R.h.mm_root_view, this.conversationFm).commit();
            e.a(this, this.contentView);
            return;
        }
        x.e("MicroMsg.BizConversationUI", "onCreate acc not ready!!!");
        finish();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        e.a(this, this.contentView);
    }
}
