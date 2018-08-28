package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.sns.ui.VideoAdPlayerUI.3;
import com.tencent.mm.ui.base.h.c;

class VideoAdPlayerUI$3$1 implements c {
    final /* synthetic */ 3 oiA;

    VideoAdPlayerUI$3$1(3 3) {
        this.oiA = 3;
    }

    public final void ju(int i) {
        switch (i) {
            case 0:
                Intent intent = new Intent();
                intent.putExtra("Select_Conv_Type", 3);
                intent.putExtra("select_is_ret", true);
                intent.putExtra("mutil_select_is_ret", true);
                intent.putExtra("ad_video_title", VideoAdPlayerUI.n(this.oiA.oiz));
                intent.putExtra("Retr_Msg_Type", 2);
                d.b(this.oiA.oiz, ".ui.transmit.SelectConversationUI", intent, 4097);
                return;
            case 1:
                VideoAdPlayerUI.o(this.oiA.oiz);
                return;
            case 2:
                VideoAdPlayerUI.p(this.oiA.oiz);
                return;
            default:
                return;
        }
    }
}
