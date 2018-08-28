package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n$d;

class am$1 implements n$d {
    final /* synthetic */ String efo;
    final /* synthetic */ Context val$context;

    am$1(String str, Context context) {
        this.efo = str;
        this.val$context = context;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        String str = menuItem.getTitle();
        x.i("MicroMsg.LongClickBrandServiceHelper", "connector click[text]: to[%s] text[%s]", new Object[]{str, this.efo});
        au.DF().a(new i(str, this.efo, s.hQ(str)), 0);
        h.mEJ.h(10424, new Object[]{Integer.valueOf(1), Integer.valueOf(1), str});
        com.tencent.mm.ui.base.h.bA(this.val$context, this.val$context.getString(R.l.app_saved));
    }
}
