package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.model.br;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.transmit.MsgRetransmitUI.a;

class am$6 implements d {
    final /* synthetic */ bd dAs;
    final /* synthetic */ Context val$context;

    am$6(bd bdVar, Context context) {
        this.dAs = bdVar;
        this.val$context = context;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        String str = menuItem.getTitle();
        r nW = t.nW(this.dAs.field_imgPath);
        x.i("MicroMsg.LongClickBrandServiceHelper", "connector click[video]: to[%s] imgPath[%s]", new Object[]{str, this.dAs.field_imgPath});
        final a aVar = new a();
        Context context = this.val$context;
        this.val$context.getResources().getString(R.l.app_tip);
        p a = h.a(context, this.val$context.getResources().getString(R.l.app_sending), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                aVar.uDV = true;
            }
        });
        aVar.context = this.val$context;
        aVar.fileName = this.dAs.field_imgPath;
        aVar.eXG = a;
        aVar.userName = str;
        aVar.uDq = nW.enQ;
        aVar.enM = nW.enM;
        aVar.execute(new Object[0]);
        br.IE().c(br.dDn, null);
        h.bA(this.val$context, this.val$context.getString(R.l.app_saved));
    }
}
