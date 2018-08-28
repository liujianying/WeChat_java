package com.tencent.mm.plugin.wallet_core.id_verify;

import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.plugin.wallet_core.id_verify.model.c;
import com.tencent.mm.plugin.wallet_core.id_verify.model.h;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

class a$2 extends g {
    final /* synthetic */ a pjX;

    a$2(a aVar, MMActivity mMActivity, i iVar) {
        this.pjX = aVar;
        super(mMActivity, iVar);
    }

    public final boolean m(Object... objArr) {
        p pVar = (p) objArr[0];
        String string = a.e(this.pjX).getString("key_real_name_token");
        if (pVar == null || bi.oW(pVar.eJn)) {
            x.e("MicroMsg.RealNameVerifyProcess", "get pwd error");
        } else if (bi.oW(string)) {
            x.e("MicroMsg.RealNameVerifyProcess", "get token error");
        } else {
            this.uXK.a(new c(pVar.eJn, string, this.pjX.jfZ.getInt("entry_scene", -1)), true);
        }
        return true;
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (lVar instanceof c) {
            if (i == 0 && i2 == 0) {
                a.f(this.pjX).putInt("realname_verify_process_ret", -1);
                x.i("MicroMsg.RealNameVerifyProcess", "real name reg succ ,update user info");
                o.bOW().aMk();
                sz szVar = new sz();
                szVar.cdR.scene = 16;
                szVar.bJX = new 1(this);
                a.sFg.m(szVar);
                a.a(this.pjX, this.uXK);
                this.pjX.b(this.fEY, a.g(this.pjX));
                return true;
            }
        } else if (lVar instanceof h) {
            return true;
        }
        return false;
    }
}
