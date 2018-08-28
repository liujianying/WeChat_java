package com.tencent.mm.plugin.address.c;

import android.app.Dialog;
import android.content.Context;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class b implements e {
    HashSet<l> eXE = new HashSet();
    HashSet<l> eXF = new HashSet();
    Dialog eXG = null;
    private a eXT = null;
    private Set<Integer> eXU = new HashSet();
    private Context mContext;

    public b(Context context, a aVar) {
        this.mContext = context;
        this.eXT = aVar;
    }

    public final void g(l lVar) {
        x.d("MicroMsg.WalletNetSceneMgr", "isShowProgress true");
        this.eXF.add(lVar);
        if (this.eXG == null || !(this.eXG == null || this.eXG.isShowing())) {
            if (this.eXG != null) {
                this.eXG.dismiss();
            }
            this.eXG = h.a(this.mContext, "", true, new 1(this));
        }
        au.DF().a(lVar, 0);
    }

    public final void jr(int i) {
        this.eXU.add(Integer.valueOf(i));
        au.DF().a(i, this);
    }

    public final void js(int i) {
        au.DF().b(i, this);
        this.eXU.remove(Integer.valueOf(i));
        if (this.eXU.isEmpty()) {
            if (this.eXG != null) {
                this.eXG.dismiss();
                this.eXG = null;
            }
            Iterator it = this.eXE.iterator();
            while (it.hasNext()) {
                au.DF().c((l) it.next());
            }
            it = this.eXF.iterator();
            while (it.hasNext()) {
                au.DF().c((l) it.next());
            }
            this.eXE.clear();
            this.eXF.clear();
            this.eXT = null;
            this.mContext = null;
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        Object obj = 1;
        if (this.eXF.contains(lVar)) {
            this.eXF.remove(lVar);
            x.d("MicroMsg.WalletNetSceneMgr", "has find scene ");
        } else if (this.eXE.contains(lVar)) {
            this.eXE.remove(lVar);
            x.d("MicroMsg.WalletNetSceneMgr", "has find forcescenes ");
        } else {
            obj = null;
        }
        if (this.eXF.isEmpty() && this.eXE.isEmpty() && this.eXG != null) {
            this.eXG.dismiss();
            this.eXG = null;
        }
        if (obj != null && this.eXT != null) {
            this.eXT.f(i, i2, str, lVar);
        }
    }
}
