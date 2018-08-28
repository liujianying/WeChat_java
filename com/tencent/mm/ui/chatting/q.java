package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnHoverListener;
import com.tencent.mm.g.a.su;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;

public final class q {
    public static b tJt = new b();

    static /* synthetic */ void q(Context context, String str, int i) {
        su suVar = new su();
        suVar.cdE.bOh = 5;
        suVar.cdE.talker = str;
        suVar.cdE.context = context;
        suVar.cdE.cdz = i;
        a.sFg.m(suVar);
        h.mEJ.h(11033, new Object[]{Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(0)});
    }

    public static void dq(View view) {
        b bVar = tJt;
        if (view == null || bVar == null) {
            x.w("MicroMsg.OnHoverCompatibleHelper", "view or callback is null.");
        } else if (VERSION.SDK_INT >= 14) {
            ai cui = ai.cui();
            if (VERSION.SDK_INT >= 14 && cui.tMB == null) {
                cui.tMB = new ai.a(bVar);
            }
            Object obj = cui.tMB;
            if (obj != null && VERSION.SDK_INT >= 14 && (obj instanceof OnHoverListener)) {
                view.setOnHoverListener((OnHoverListener) obj);
            }
        }
    }

    public static void dismiss() {
        try {
            if (tJt != null) {
                b.a(tJt);
            }
        } catch (Exception e) {
            x.e("MicroMsg.ChattingItemAvatarOnHoverHelper", "exception in dismiss, %s", new Object[]{e.getMessage()});
        }
    }
}
