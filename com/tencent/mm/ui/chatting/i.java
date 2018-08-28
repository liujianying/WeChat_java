package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.b.j;
import java.util.Set;

public final class i {
    public static void a(Context context, Set<Long> set, ah ahVar) {
        if (context == null) {
            x.w("MicroMsg.ChattingEditModeDelMsg", "do delete msg fail, context is null");
        } else if (set == null || set.isEmpty()) {
            x.w("MicroMsg.ChattingEditModeDelMsg", "do delete msg fail, select ids is empty");
        } else {
            context.getString(R.l.app_tip);
            j.tOP.c(new a(set, h.a(context, context.getString(R.l.deleting_message), false, null), ahVar));
            com.tencent.mm.plugin.report.service.h.mEJ.h(10811, new Object[]{Integer.valueOf(4), Integer.valueOf(set.size())});
        }
    }
}
