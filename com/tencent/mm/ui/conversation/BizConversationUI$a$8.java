package com.tencent.mm.ui.conversation;

import android.view.MenuItem;
import com.tencent.mm.ac.z;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.n$d;
import com.tencent.mm.ui.conversation.BizConversationUI.a;
import com.tencent.mm.ui.tools.b;

class BizConversationUI$a$8 implements n$d {
    final /* synthetic */ a unz;

    BizConversationUI$a$8(a aVar) {
        this.unz = aVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
                au.HU();
                ab Yg = c.FR().Yg(a.m(this.unz));
                if (Yg == null) {
                    x.e("MicroMsg.BizConversationUI", "changed biz stick status failed, contact is null, talker = " + a.m(this.unz));
                    return;
                } else if (Yg.BG()) {
                    h.mEJ.h(13307, new Object[]{Yg.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(2)});
                    s.u(a.m(this.unz), true);
                    return;
                } else {
                    h.mEJ.h(13307, new Object[]{Yg.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2)});
                    s.t(a.m(this.unz), true);
                    return;
                }
            case 2:
                au.HU();
                b.a(z.MY().kA(a.m(this.unz)), this.unz.thisActivity(), c.FR().Yg(a.m(this.unz)), 2);
                return;
            case 3:
                a.b(this.unz, a.m(this.unz));
                return;
            default:
                return;
        }
    }
}
