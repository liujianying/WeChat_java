package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.modelvoice.f;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.n$d;

class am$4 implements n$d {
    final /* synthetic */ bd dAs;
    final /* synthetic */ Context val$context;

    am$4(bd bdVar, Context context) {
        this.dAs = bdVar;
        this.val$context = context;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        String str = menuItem.getTitle();
        if (bi.oW(this.dAs.field_imgPath)) {
            x.e("MicroMsg.LongClickBrandServiceHelper", "Transfer fileName erro: fileName null");
            return;
        }
        p ot = q.ot(this.dAs.field_imgPath);
        x.i("MicroMsg.LongClickBrandServiceHelper", "connector click[voice]: to[%s] filePath[%s]", new Object[]{str, q.e(str, this.dAs.field_imgPath, ot == null ? 0 : ot.epI)});
        au.DF().a(new f(r0, 1), 0);
        h.mEJ.h(10424, new Object[]{Integer.valueOf(34), Integer.valueOf(2), str});
        com.tencent.mm.ui.base.h.bA(this.val$context, this.val$context.getString(R.l.app_saved));
    }
}
