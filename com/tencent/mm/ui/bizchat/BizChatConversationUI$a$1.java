package com.tencent.mm.ui.bizchat;

import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.ac.b;
import com.tencent.mm.ac.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.bizchat.BizChatConversationUI.a;

class BizChatConversationUI$a$1 implements IdleHandler {
    final /* synthetic */ a tEC;

    BizChatConversationUI$a$1(a aVar) {
        this.tEC = aVar;
    }

    public final boolean queueIdle() {
        a.a(this.tEC, z.MY().kA(a.a(this.tEC)).Mg());
        int intExtra = this.tEC.thisActivity().getIntent().getIntExtra("biz_chat_from_scene", 7);
        int i = -1;
        if (a.b(this.tEC) != null) {
            i = a.b(this.tEC).getCount();
        }
        b kn = z.Nh().kn(a.c(this.tEC));
        int i2 = kn != null ? kn.field_qyUin : 0;
        int i3 = kn != null ? kn.field_userUin : 0;
        int kp = z.Nh().kp(a.a(this.tEC));
        long j = kn != null ? kn.field_wwCorpId : 0;
        long j2 = kn != null ? kn.field_wwUserVid : 0;
        h.mEJ.h(12648, new Object[]{a.c(this.tEC), a.a(this.tEC), Integer.valueOf(intExtra), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(kp), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2)});
        x.d("MicroMsg.BizChatConversationFmUI", "bizchat report belong:%s,brandUserName:%s,fromScene:%s,itemCount:%s,fatherUin:%d,childUin:%d,userUin:%d,wwCorpId:%l,wwUserVidL%l", new Object[]{a.c(this.tEC), a.a(this.tEC), Integer.valueOf(intExtra), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(kp), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2)});
        return false;
    }
}
