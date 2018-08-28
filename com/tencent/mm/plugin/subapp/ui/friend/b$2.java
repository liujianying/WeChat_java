package com.tencent.mm.plugin.subapp.ui.friend;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.az.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.ui.applet.a;
import com.tencent.mm.pluginsdk.ui.preference.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;

class b$2 implements OnClickListener {
    final /* synthetic */ b orO;

    b$2(b bVar) {
        this.orO = bVar;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof b) {
            x.d("MicroMsg.FMessageConversationUI", "addOnClick onClick");
            final b bVar = (b) view.getTag();
            if (bVar == null || bi.oW(bVar.username)) {
                x.e("MicroMsg.FMessageConversationUI", "cpan add contact failed. username is null.");
                return;
            }
            final ab a = b.a(d.SE().YO(bVar.username));
            a aVar = new a(b.a(this.orO), new a.a() {
                public final void a(boolean z, boolean z2, String str, String str2) {
                    if (z) {
                        au.HU();
                        ab Yg = c.FR().Yg(bVar.username);
                        if (((int) Yg.dhP) == 0) {
                            Yg = a;
                            au.HU();
                            if (!c.FR().T(Yg)) {
                                x.e("MicroMsg.FMessageConversationUI", "canAddContact fail, insert fail");
                                return;
                            }
                        }
                        s.p(Yg);
                        d.SF().db(bVar.username, 1);
                        h.bA(b.a(b$2.this.orO), b.a(b$2.this.orO).getString(R.l.app_added));
                        b.a(b$2.this.orO, bVar.username);
                    } else if (z2) {
                        d.SF().db(bVar.username, 2);
                    } else {
                        x.e("MicroMsg.FMessageConversationUI", "canAddContact fail, username = " + bVar.username);
                        return;
                    }
                    b$2.this.orO.notifyDataSetChanged();
                }
            });
            x.d("MicroMsg.FMessageConversationUI", "try to addcontact, username = " + bVar.username + ", opcode = MM_VERIFYUSER_ADDCONTACT");
            LinkedList linkedList = new LinkedList();
            linkedList.add(Integer.valueOf(bVar.mZZ));
            aVar.TC(a.cta);
            aVar.b(bVar.username, linkedList, true);
        }
    }
}
