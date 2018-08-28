package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.modelappbrand.q;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.viewitems.s.1;

class s$1$2 implements d {
    final /* synthetic */ bd dAs;
    final /* synthetic */ int fuS;
    final /* synthetic */ View gvo;
    final /* synthetic */ String qiU;
    final /* synthetic */ 1 uco;
    final /* synthetic */ int ucp;

    s$1$2(1 1, View view, String str, int i, int i2, bd bdVar) {
        this.uco = 1;
        this.gvo = view;
        this.qiU = str;
        this.ucp = i;
        this.fuS = i2;
        this.dAs = bdVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        x.d("MicroMsg.ChattingItemDyeingTemplate", "on menu(id : %d, index : %d) item selected.", new Object[]{Integer.valueOf(menuItem.getItemId()), Integer.valueOf(i)});
        switch (menuItem.getItemId()) {
            case 2:
                au.DF().a(1198, new 1(this));
                q qVar = new q(this.dAs.field_content);
                s sVar = this.uco.ucn;
                Context context = this.gvo.getContext();
                this.gvo.getResources().getString(R.l.app_tip);
                s.a(sVar, h.a(context, this.gvo.getResources().getString(R.l.app_waiting), true, new 2(this, qVar)));
                au.DF().a(qVar, 0);
                s.C(4, s.c(this.uco.ucn), s.d(this.uco.ucn));
                return;
            default:
                return;
        }
    }
}
