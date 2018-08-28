package com.tencent.mm.plugin.sns.f;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsoluteLayout;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.data.b;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.model.u;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements OnClickListener {
    final /* synthetic */ int ntM;
    final /* synthetic */ b ntN;
    final /* synthetic */ View ntO;
    final /* synthetic */ b ntP;
    final /* synthetic */ View val$view;

    b$1(b bVar, int i, b bVar2, View view, View view2) {
        this.ntP = bVar;
        this.ntM = i;
        this.ntN = bVar2;
        this.ntO = view;
        this.val$view = view2;
    }

    public final void onClick(View view) {
        b bVar = this.ntP;
        int i = this.ntM;
        b bVar2 = this.ntN;
        View view2 = this.ntO;
        AbsoluteLayout absoluteLayout = this.ntP.nty;
        x.d("MicroMsg.AdNotLikeAbTestHelper", "processFristButtonClick " + i + " " + bVar2.nkI);
        b.b bVar3 = (b.b) bVar.ntH.get(Long.valueOf(bVar2.nkI));
        if (bVar3 != null) {
            bVar3.MM("1:" + (i == 4 ? 3 : i) + ":" + bVar.mContext.getString(bVar.ntC[i - 1]));
        }
        if (i == 1) {
            n Nl = af.byo().Nl(bVar2.bKW);
            if (Nl != null) {
                if (Nl.xb(32)) {
                    Object obj;
                    a bAH = Nl.bAH();
                    if (bAH == null) {
                        obj = "";
                    } else {
                        String obj2 = bAH.fvT;
                    }
                    ((c) g.l(c.class)).a(11855, Nl.bBq(), new Object[]{Integer.valueOf(3), obj2, Integer.valueOf(Nl.bBq())});
                }
                af.byr().delete(Nl.field_snsId);
                af.byt().fd(Nl.field_snsId);
                i.fc(Nl.field_snsId);
                r rVar = new r(Nl.field_snsId, 8);
                g.Ek();
                g.Eh().dpP.a(rVar, 0);
                bVar.a(bVar3);
                bVar.bzf();
            }
        } else if (i == 2) {
            bVar.a(view2, absoluteLayout, bVar2);
        } else if (i == 3) {
            if (!u.eO(bVar2.nkI)) {
                u.eM(bVar2.nkI);
            }
            bVar.a(bVar3);
            bVar.bzf();
        } else if (i == 4) {
            if (u.eO(bVar2.nkI)) {
                u.eN(bVar2.nkI);
            }
            bVar.a(bVar3);
            bVar.bzf();
        }
    }
}
