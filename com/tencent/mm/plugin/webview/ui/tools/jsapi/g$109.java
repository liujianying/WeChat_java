package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.ui.MMActivity;

class g$109 implements Runnable {
    final /* synthetic */ String fRy;
    final /* synthetic */ g qiK;
    final /* synthetic */ String qjV;

    g$109(g gVar, String str, String str2) {
        this.qiK = gVar;
        this.fRy = str;
        this.qjV = str2;
    }

    public final void run() {
        Intent intent = new Intent();
        intent.putExtra("scene_from", 4);
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("Retr_Msg_Type", 5);
        intent.putExtra("Retr_Msg_thumb_path", this.fRy);
        intent.putExtra("emoji_activity_id", this.qjV);
        intent.putExtra("MMActivity.OverrideEnterAnimation", R.a.fast_faded_in);
        if (g.j(this.qiK) instanceof MMActivity) {
            d.a((MMActivity) g.j(this.qiK), ".ui.transmit.SelectConversationUI", intent, 52, this.qiK);
        }
    }
}
