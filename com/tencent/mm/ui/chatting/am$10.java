package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.n.d;

class am$10 implements d {
    final /* synthetic */ int bpX;
    final /* synthetic */ bd dAs;
    final /* synthetic */ String fhM;
    final /* synthetic */ Context val$context;

    am$10(bd bdVar, String str, int i, Context context) {
        this.dAs = bdVar;
        this.fhM = str;
        this.bpX = i;
        this.val$context = context;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        am.a(menuItem.getTitle(), this.dAs, this.fhM);
        switch (this.bpX) {
            case 128:
                h.mEJ.h(10424, new Object[]{Integer.valueOf(49), Integer.valueOf(128), r0});
                break;
            case ab.CTRL_BYTE /*256*/:
                h.mEJ.h(10424, new Object[]{Integer.valueOf(49), Integer.valueOf(ab.CTRL_BYTE), r0});
                break;
            case WXMediaMessage.TITLE_LENGTH_LIMIT /*512*/:
                h.mEJ.h(10424, new Object[]{Integer.valueOf(49), Integer.valueOf(WXMediaMessage.TITLE_LENGTH_LIMIT), r0});
                break;
        }
        com.tencent.mm.ui.base.h.bA(this.val$context, this.val$context.getString(R.l.app_saved));
    }
}
