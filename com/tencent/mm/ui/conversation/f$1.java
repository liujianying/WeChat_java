package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.ac.f;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.modelsimple.z;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.conversation.b.5;
import com.tencent.mm.ui.conversation.b.6;

class f$1 implements d {
    final /* synthetic */ f uoF;

    f$1(f fVar) {
        this.uoF = fVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        int i2 = 4;
        switch (menuItem.getItemId()) {
            case 4:
                if (s.fq(f.a(this.uoF))) {
                    h.mEJ.h(14553, new Object[]{Integer.valueOf(1), Integer.valueOf(1), f.a(this.uoF)});
                } else {
                    h.mEJ.h(14553, new Object[]{Integer.valueOf(0), Integer.valueOf(1), f.a(this.uoF)});
                }
                if (f.b(this.uoF).tay != null) {
                    x.i("MicroMsg.ConversationClickListener", "summerdel talker[%s] activity[%s] username[%s] latestInsertMsg[%s, %s, %s]", new Object[]{f.a(this.uoF), f.c(this.uoF), f.b(this.uoF).field_username, Long.valueOf(f.b(this.uoF).tay.field_msgId), f.b(this.uoF).tay.field_content, Long.valueOf(f.b(this.uoF).tay.field_createTime)});
                } else {
                    x.i("MicroMsg.ConversationClickListener", "summerdel talker[%s] activity[%s] username[%s] latestInsertMsg is null", new Object[]{f.a(this.uoF), f.c(this.uoF), f.b(this.uoF).field_username});
                }
                b.a(f.a(this.uoF), f.c(this.uoF), f.b(this.uoF), null, true, false);
                i2 = 1;
                break;
            case 5:
                x.d("MicroMsg.ConversationClickListener", "placed to the top");
                s.t(f.a(this.uoF), true);
                au.HU();
                ab Yg = c.FR().Yg(f.a(this.uoF));
                if (Yg != null && Yg.ckW()) {
                    h.mEJ.h(13307, new Object[]{Yg.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1)});
                }
                com.tencent.mm.ui.base.h.bA(f.c(this.uoF), f.c(this.uoF).getString(R.l.main_conversation_placedtop_tips));
                b.ehL.c(true, f.a(this.uoF), true);
                break;
            case 6:
                x.d("MicroMsg.ConversationClickListener", "unplaced to the top");
                s.u(f.a(this.uoF), true);
                au.HU();
                ab Yg2 = c.FR().Yg(f.a(this.uoF));
                if (Yg2 != null && Yg2.ckW()) {
                    h.mEJ.h(13307, new Object[]{Yg2.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1)});
                }
                com.tencent.mm.ui.base.h.bA(f.c(this.uoF), f.c(this.uoF).getString(R.l.main_conversation_unplacedtop_tips));
                b.ehL.c(true, f.a(this.uoF), false);
                i2 = 5;
                break;
            case 7:
                x.d("MicroMsg.ConversationClickListener", "jacks mark read: %s", new Object[]{f.a(this.uoF)});
                au.HU();
                c.FW().Ys(f.a(this.uoF));
                MMAppMgr.cancelNotification(f.a(this.uoF));
                z.S(f.a(this.uoF), 1);
                b.ehL.K(f.a(this.uoF), false);
                i2 = 3;
                break;
            case 8:
                x.d("MicroMsg.ConversationClickListener", "jacks set unread: %s", new Object[]{f.a(this.uoF)});
                au.HU();
                c.FW().Yt(f.a(this.uoF));
                b.ehL.K(f.a(this.uoF), true);
                i2 = 2;
                break;
            case 9:
                x.d("MicroMsg.ConversationClickListener", "jacks clear history: %s", new Object[]{f.a(this.uoF)});
                f.a(this.uoF).endsWith("@chatroom");
                String a = f.a(this.uoF);
                Context c = f.c(this.uoF);
                PBool pBool = new PBool();
                pBool.value = false;
                c.getString(R.l.app_tip);
                bd.a(a, new 6(pBool, com.tencent.mm.ui.base.h.a(c, c.getString(R.l.app_waiting), true, new 5(pBool))));
                i2 = -1;
                break;
            case 10:
                x.d("MicroMsg.ConversationClickListener", "delete biz service: %s", new Object[]{f.a(this.uoF)});
                au.HU();
                com.tencent.mm.ui.tools.b.a(f.kH(f.a(this.uoF)), f.c(this.uoF), c.FR().Yg(f.a(this.uoF)), 1);
                break;
        }
        i2 = -1;
        if (i2 > 0) {
            h.mEJ.h(11090, new Object[]{Integer.valueOf(i2)});
            x.d("MicroMsg.ConversationClickListener", "jacks kv long click: %d", new Object[]{Integer.valueOf(i2)});
        }
    }
}
