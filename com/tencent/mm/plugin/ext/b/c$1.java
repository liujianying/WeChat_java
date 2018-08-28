package com.tencent.mm.plugin.ext.b;

import android.content.Intent;
import android.support.design.a$i;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ext.a;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.protocal.c.biy;
import com.tencent.mm.protocal.c.bja;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements e {
    final /* synthetic */ c iJv;

    c$1(c cVar) {
        this.iJv = cVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        au.DF().b(a$i.AppCompatTheme_ratingBarStyle, this);
        if (i == 0 && i2 == 0) {
            x.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: searched data.");
            bja bcS = ((f) lVar).bcS();
            x.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: contact count: %d", new Object[]{Integer.valueOf(bcS.rHb)});
            if (bcS.rHb > 0) {
                if (bcS.rHc.isEmpty()) {
                    x.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: no result is retrieved. start to search UI");
                    c.a(this.iJv, bcS);
                }
                if (bcS.rHc.size() > 1) {
                    try {
                        Intent intent = new Intent();
                        intent.putExtra("add_more_friend_search_scene", 3);
                        intent.putExtra("result", bcS.toByteArray());
                        x.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: more than one contact is resolved. starting to ContactSearchResultUI");
                        a.ezn.u(intent, c.a(this.iJv));
                        return;
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.RedirectToChattingByPhoneHelper", e, "", new Object[0]);
                        return;
                    }
                }
                c.a(this.iJv, (biy) bcS.rHc.getFirst());
                return;
            }
            x.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: only one result is retrieved. start to chatting directly");
            c.b(this.iJv, bcS);
            return;
        }
        x.w("MicroMsg.RedirectToChattingByPhoneHelper", "hy: err net.errType: %d, errCode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        c.a(this.iJv, null);
    }
}
