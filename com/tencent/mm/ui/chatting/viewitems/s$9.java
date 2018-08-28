package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class s$9 implements OnClickListener {
    final /* synthetic */ int eaH;
    final /* synthetic */ Map prf;
    final /* synthetic */ s ucn;

    s$9(s sVar, int i, Map map) {
        this.ucn = sVar;
        this.eaH = i;
        this.prf = map;
    }

    public final void onClick(View view) {
        if (this.eaH == 1) {
            s.b(view.getContext(), (String) this.prf.get(".msg.appmsg.mmreader.category.item.schedule_username"), bi.getLong((String) this.prf.get(".msg.appmsg.mmreader.category.item.schedule_messvrid"), -1));
            h.mEJ.a(795, 2, 1, false);
            x.i("MicroMsg.ChattingItemDyeingTemplate", "[onClick] Remind! username:%s svrMsgId:%s", new Object[]{r0, Long.valueOf(r10)});
        } else if (this.eaH == 2) {
            d.e(view.getContext(), ".ui.AllRemindMsgUI", new Intent());
        }
    }
}
