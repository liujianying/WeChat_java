package com.tencent.mm.ui.chatting;

import android.view.View;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a;
import com.tencent.mm.ui.chatting.viewitems.b;
import com.tencent.mm.ui.chatting.viewitems.b$d;
import com.tencent.mm.y.g;

class AppBrandServiceChattingUI$a$6 extends b$d {
    final /* synthetic */ a tGQ;

    public AppBrandServiceChattingUI$a$6(a aVar, com.tencent.mm.ui.chatting.c.a aVar2, b bVar) {
        this.tGQ = aVar;
        super(aVar2, bVar);
    }

    public final void a(View view, com.tencent.mm.ui.chatting.c.a aVar, bd bdVar) {
        x.d("MicroMsg.AppBrandServiceChattingUI", "clickListener ChattingListClickListener onClick");
        view.getTag();
        if (bdVar.ckA()) {
            super.a(view, aVar, bdVar);
        } else if (bdVar.aQm()) {
            String str = bdVar.field_content;
            if (str != null) {
                g.a gp = g.a.gp(str);
                if (gp == null) {
                    return;
                }
                if (a.b(this.tGQ) == 2 && gp.type == 33 && a.c(this.tGQ).appId.equals(gp.dyT)) {
                    a.a(this.tGQ, gp.dyR);
                } else {
                    super.a(view, aVar, bdVar);
                }
            }
        } else {
            super.a(view, aVar, bdVar);
        }
    }
}
