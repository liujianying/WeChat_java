package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.n$d;

class am$9 implements n$d {
    final /* synthetic */ bd dAs;
    final /* synthetic */ Context val$context;

    am$9(bd bdVar, Context context) {
        this.dAs = bdVar;
        this.val$context = context;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        String str;
        String str2 = menuItem.getTitle();
        String str3 = an.YJ(this.dAs.field_content).bKg;
        if (str3 == null || str3.endsWith("-1")) {
            str = this.dAs.field_imgPath;
        } else {
            str = str3;
        }
        if (str == null) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: filePath is null");
            return;
        }
        x.i("MicroMsg.LongClickBrandServiceHelper", "connector click[emoji]: to[%s] filePath[%s]", new Object[]{str2, str});
        if (((c) g.n(c.class)).getEmojiMgr().o(this.val$context, str2, str)) {
            h.mEJ.h(10424, new Object[]{Integer.valueOf(47), Integer.valueOf(64), str2});
            com.tencent.mm.ui.base.h.bA(this.val$context, "");
        }
        h.mEJ.h(10424, new Object[]{Integer.valueOf(47), Integer.valueOf(64), str2});
        com.tencent.mm.ui.base.h.bA(this.val$context, this.val$context.getString(R.l.app_saved));
    }
}
