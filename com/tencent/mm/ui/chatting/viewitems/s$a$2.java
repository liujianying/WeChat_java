package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.modelappbrand.q;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.viewitems.s.a;

class s$a$2 implements d {
    final /* synthetic */ bd dAs;
    final /* synthetic */ View gvo;
    final /* synthetic */ String qiU;
    final /* synthetic */ a ucG;

    s$a$2(a aVar, View view, bd bdVar, String str) {
        this.ucG = aVar;
        this.gvo = view;
        this.dAs = bdVar;
        this.qiU = str;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        x.d("MicroMsg.ChattingItemDyeingTemplate", "on menu(id : %d, index : %d) item selected.", new Object[]{Integer.valueOf(menuItem.getItemId()), Integer.valueOf(i)});
        switch (menuItem.getItemId()) {
            case 1:
                au.DF().a(1198, new 1(this));
                final q qVar = new q(this.dAs.field_content);
                s sVar = this.ucG.ucn;
                Context context = this.gvo.getContext();
                this.gvo.getResources().getString(R.l.app_tip);
                s.a(sVar, h.a(context, this.gvo.getResources().getString(R.l.app_waiting), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        au.DF().c(qVar);
                    }
                }));
                au.DF().a(qVar, 0);
                return;
            default:
                return;
        }
    }
}
