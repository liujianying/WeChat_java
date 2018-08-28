package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd.a;
import com.tencent.mm.ui.base.n.d;

class am$8 implements d {
    final /* synthetic */ String tMY;
    final /* synthetic */ Context val$context;

    am$8(String str, Context context) {
        this.tMY = str;
        this.val$context = context;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        int i2 = 66;
        String str = menuItem.getTitle();
        x.i("MicroMsg.LongClickBrandServiceHelper", "connector click[location]: to[%s] content[%s]", new Object[]{str, this.tMY});
        a YV = a.YV(this.tMY);
        au.DF().a(new i(str, this.tMY, ab.XR(YV.otZ) ? 66 : 42), 0);
        h hVar = h.mEJ;
        Object[] objArr = new Object[3];
        if (!ab.XR(YV.otZ)) {
            i2 = 42;
        }
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(32);
        objArr[2] = str;
        hVar.h(10424, objArr);
        com.tencent.mm.ui.base.h.bA(this.val$context, this.val$context.getString(R.l.app_saved));
    }
}
