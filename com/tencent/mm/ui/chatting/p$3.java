package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.ui.base.n.d;

class p$3 implements d {
    final /* synthetic */ p tJl;
    final /* synthetic */ int tqk;

    p$3(p pVar, int i) {
        this.tJl = pVar;
        this.tqk = i;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
                Intent intent = new Intent();
                h.mEJ.h(13822, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
                l.a(p.e(this.tJl).tTq, new Intent(), this.tJl.getTalkerUserName(), this.tqk);
                return;
            case 5:
                com.tencent.mm.bg.d.b(p.e(this.tJl).tTq.getContext(), "mmsight", ".ui.SightSettingsUI", new Intent());
                return;
            default:
                return;
        }
    }
}
