package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.modelappbrand.q;
import com.tencent.mm.plugin.appbrand.n.c;
import com.tencent.mm.protocal.c.chw;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.viewitems.s.1.2;

class s$1$2$1 implements e {
    final /* synthetic */ 2 ucq;

    s$1$2$1(2 2) {
        this.ucq = 2;
    }

    public final void a(int i, int i2, String str, l lVar) {
        au.DF().b(1198, this);
        x.d("MicroMsg.ChattingItemDyeingTemplate", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(false)});
        if (this.ucq.uco.ucn.tqa != null) {
            this.ucq.uco.ucn.tqa.dismiss();
            this.ucq.uco.ucn.tqa = null;
        }
        if (i == 0 && i2 == 0) {
            chw JV = ((q) lVar).JV();
            if (JV == null) {
                s.makeText(this.ucq.gvo.getContext(), R.l.notify_message_settings_complain_failed, 0).show();
                return;
            }
            String str2 = JV.sBS;
            x.i("MicroMsg.ChattingItemDyeingTemplate", "more view clicked, menu item COMPLAIN_APP_BRAND selected, sync attr username %s", new Object[]{this.ucq.qiU});
            ((c) g.l(c.class)).a(this.ucq.qiU, new 1(this, str2));
            return;
        }
        s.makeText(this.ucq.gvo.getContext(), R.l.notify_message_settings_complain_failed, 0).show();
    }
}
