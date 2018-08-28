package com.tencent.mm.pluginsdk.ui.applet;

import android.app.Activity;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.protocal.c.bja;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.base.h;

class b$4 implements e {
    final /* synthetic */ b qIl;

    b$4(b bVar) {
        this.qIl = bVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (this.qIl.eEX != null) {
            this.qIl.eEX.dismiss();
        }
        if (this.qIl.qIj != null) {
            g.Ek();
            g.Eh().dpP.b(106, this.qIl.qIj);
        }
        if (this.qIl.eEX == null) {
            x.e("MicroMsg.AddContactDialog", "has cancel the loading dialog");
            this.qIl.gW(0);
        } else if (i != 0 || i2 != 0) {
            x.e("MicroMsg.AddContactDialog", "searchContact onSceneEnd, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
            this.qIl.gW(-1);
        } else if (this.qIl.mContext == null) {
            x.e("MicroMsg.AddContactDialog", "searchContact, context is null, msghandler has already been detached!");
            this.qIl.gW(-1);
        } else if ((this.qIl.mContext instanceof Activity) && ((Activity) this.qIl.mContext).isFinishing()) {
            x.e("MicroMsg.AddContactDialog", "searchContact, context isFinishing");
            this.qIl.gW(-1);
        } else {
            bja bcS = ((f) lVar).bcS();
            String a = ab.a(bcS.rvi);
            if (bi.oW(a)) {
                x.e("MicroMsg.AddContactDialog", "searchContact, user is null");
                h.bA(this.qIl.mContext, this.qIl.mContext.getResources().getString(R.l.wv_follow_is_not_biz));
                this.qIl.gW(-1);
                return;
            }
            if (this.qIl.gtX == null || !this.qIl.gtX.equals(a)) {
                x.w("MicroMsg.AddContactDialog", "user not the same, %s, %s", this.qIl.gtX, a);
            }
            b bVar = this.qIl;
            g.Ek();
            bVar.ipd = ((i) g.l(i.class)).FR().Yg(a);
            if (this.qIl.ipd == null || ((int) this.qIl.ipd.dhP) == 0) {
                x.i("MicroMsg.AddContactDialog", "searchContact, no contact with username = " + a + ", try get by alias");
                bVar = this.qIl;
                g.Ek();
                bVar.ipd = ((i) g.l(i.class)).FR().Yd(a);
                if (this.qIl.ipd == null || ((int) this.qIl.ipd.dhP) == 0) {
                    x.i("MicroMsg.AddContactDialog", "searchContact, no contact with alias, new Contact");
                    this.qIl.ipd = new com.tencent.mm.storage.ab(a);
                    this.qIl.ipd.du(bcS.eJM);
                    this.qIl.ipd.dx(ab.a(bcS.rQz));
                    this.qIl.ipd.dy(ab.a(bcS.ruT));
                    this.qIl.ipd.dz(ab.a(bcS.ruU));
                    this.qIl.ipd.eJ(bcS.eJH);
                    this.qIl.ipd.dS(RegionCodeDecoder.aq(bcS.eJQ, bcS.eJI, bcS.eJJ));
                    this.qIl.ipd.dM(bcS.eJK);
                    this.qIl.ipd.eF(bcS.rTe);
                    this.qIl.ipd.dR(bcS.rTf);
                    this.qIl.ipd.eE(bcS.rTi);
                    this.qIl.ipd.dA(bcS.rTh);
                    this.qIl.ipd.dQ(bcS.rTg);
                }
            } else {
                x.i("MicroMsg.AddContactDialog", "searchContact, contact in db, %s", a);
            }
            this.qIl.O(this.qIl.ipd);
        }
    }
}
