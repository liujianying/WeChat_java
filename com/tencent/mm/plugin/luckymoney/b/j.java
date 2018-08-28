package com.tencent.mm.plugin.luckymoney.b;

import android.content.Context;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.mm.wallet_core.d.f;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class j implements e, com.tencent.mm.wallet_core.d.e {
    private String dox;
    HashSet<l> eXE = new HashSet();
    HashSet<l> eXF = new HashSet();
    private Set<Integer> eXU = new HashSet();
    private f kQv = null;
    private Context mContext;
    p tipDialog = null;

    public j(Context context, f fVar) {
        this.mContext = context;
        this.kQv = fVar;
    }

    public final void a(l lVar, boolean z) {
        k(lVar);
        this.eXE.add(lVar);
        if (z && (this.tipDialog == null || !(this.tipDialog == null || this.tipDialog.isShowing()))) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
            }
            this.tipDialog = h.a(this.mContext, this.mContext.getString(a$i.loading_tips), false, new 1(this));
        }
        g.Ek();
        g.Eh().dpP.a(lVar, 0);
    }

    public final void b(l lVar, boolean z) {
        x.d("MicroMsg.WalletNetSceneMgr", "isShowProgress " + z);
        k(lVar);
        this.eXF.add(lVar);
        if (z && (this.tipDialog == null || !(this.tipDialog == null || this.tipDialog.isShowing()))) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
            }
            this.tipDialog = h.a(this.mContext, this.mContext.getString(a$i.loading_tips), true, new 2(this));
        }
        g.Ek();
        g.Eh().dpP.a(lVar, 0);
    }

    public final void baT() {
        l lVar;
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        Iterator it = this.eXE.iterator();
        while (it.hasNext()) {
            lVar = (l) it.next();
            g.Ek();
            g.Eh().dpP.c(lVar);
        }
        it = this.eXF.iterator();
        while (it.hasNext()) {
            lVar = (l) it.next();
            g.Ek();
            g.Eh().dpP.c(lVar);
        }
        this.eXE.clear();
        this.eXF.clear();
    }

    public final void jr(int i) {
        this.eXU.add(Integer.valueOf(i));
        g.Ek();
        g.Eh().dpP.a(i, this);
    }

    public final void js(int i) {
        g.Ek();
        g.Eh().dpP.b(i, this);
        this.eXU.remove(Integer.valueOf(i));
        if (this.eXU.isEmpty()) {
            baT();
            this.kQv = null;
            this.mContext = null;
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        Object obj;
        boolean z;
        if (this.eXF.contains(lVar)) {
            this.eXF.remove(lVar);
            x.d("MicroMsg.WalletNetSceneMgr", "has find scene ");
            obj = 1;
        } else if (this.eXE.contains(lVar)) {
            this.eXE.remove(lVar);
            x.d("MicroMsg.WalletNetSceneMgr", "has find forcescenes ");
            int obj2 = 1;
        } else {
            obj2 = null;
        }
        if (this.eXF.isEmpty() && this.eXE.isEmpty()) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            z = true;
        } else {
            z = false;
        }
        if (obj2 != null && this.kQv != null) {
            this.kQv.b(i, i2, str, lVar, z);
        }
    }

    public final boolean baU() {
        if (this.eXF.isEmpty() && this.eXE.isEmpty()) {
            return false;
        }
        return true;
    }

    private void k(l lVar) {
        if (lVar != null && (lVar instanceof m)) {
            ((m) lVar).dox = this.dox;
        }
    }

    public final void baV() {
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
    }
}
