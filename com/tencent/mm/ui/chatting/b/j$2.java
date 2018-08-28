package com.tencent.mm.ui.chatting.b;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.b.b.g;

class j$2 implements OnClickListener {
    final /* synthetic */ j tOS;

    j$2(j jVar) {
        this.tOS = jVar;
    }

    public final void onClick(View view) {
        g gVar = (g) this.tOS.bAG.O(g.class);
        if (gVar.boX() == 0) {
            x.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
            return;
        }
        Context context = this.tOS.bAG.tTq.getContext();
        h.a(context, context.getString(R.l.confirm_delete), "", context.getString(R.l.delete_message), context.getString(R.l.app_cancel), new 1(this, context, gVar), null, R.e.alert_btn_color_warn);
    }
}
