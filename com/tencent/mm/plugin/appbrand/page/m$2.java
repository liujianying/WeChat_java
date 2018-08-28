package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.menu.k;
import com.tencent.mm.plugin.appbrand.menu.l;
import com.tencent.mm.plugin.appbrand.menu.m;
import com.tencent.mm.ui.base.n$d;

class m$2 implements n$d {
    final /* synthetic */ m gmG;

    m$2(m mVar) {
        this.gmG = mVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        int ll = l.ll(menuItem.getItemId());
        if (ll != 0) {
            Object obj;
            k e = m.e(this.gmG.gmF, ll - 1);
            Context context = this.gmG.fFv.mContext;
            p pVar = this.gmG.fFv;
            String str = this.gmG.mAppId;
            if (e == null) {
                obj = null;
            } else {
                a aVar = (a) m$a.gjN.gjM.get(Integer.valueOf(e.id));
                if (aVar == null) {
                    obj = null;
                } else {
                    aVar.a(context, pVar, str, e);
                    obj = 1;
                }
            }
            if (obj != null) {
                this.gmG.gmE.bzW();
            }
        }
    }
}
