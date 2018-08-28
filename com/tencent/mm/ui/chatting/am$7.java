package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n.d;

class am$7 implements d {
    final /* synthetic */ String tMX;
    final /* synthetic */ Context val$context;

    am$7(String str, Context context) {
        this.tMX = str;
        this.val$context = context;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        x.i("MicroMsg.LongClickBrandServiceHelper", "connector click[location]: to[%s] content[%s]", new Object[]{menuItem.getTitle(), this.tMX});
        au.DF().a(new i(r0, this.tMX, 48), 0);
        h.mEJ.h(10424, new Object[]{Integer.valueOf(48), Integer.valueOf(16), r0});
        com.tencent.mm.ui.base.h.bA(this.val$context, this.val$context.getString(R.l.app_saved));
    }
}
