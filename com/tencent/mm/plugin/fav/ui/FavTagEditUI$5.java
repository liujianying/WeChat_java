package com.tencent.mm.plugin.fav.ui;

import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.l;
import com.tencent.mm.plugin.fav.ui.a.d;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.protocal.c.wv;
import com.tencent.mm.protocal.c.ww;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTagPanel$a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class FavTagEditUI$5 implements MMTagPanel$a {
    final /* synthetic */ FavTagEditUI jaA;

    FavTagEditUI$5(FavTagEditUI favTagEditUI) {
        this.jaA = favTagEditUI;
    }

    public final void zO(String str) {
        FavTagEditUI.d(this.jaA).removeTag(str);
        FavTagEditUI.f(this.jaA).BF(str);
        if (FavTagEditUI.g(this.jaA) != null) {
            FavTagEditUI.g(this.jaA).bv(str, false);
        }
        FavTagEditUI.c(this.jaA);
    }

    public final void zP(String str) {
    }

    public final void zQ(String str) {
        FavTagEditUI.d(this.jaA).removeTag(str);
        FavTagEditUI.f(this.jaA).BF(str);
        if (FavTagEditUI.g(this.jaA) != null) {
            FavTagEditUI.g(this.jaA).bv(str, false);
        }
        FavTagEditUI.c(this.jaA);
    }

    public final void zR(String str) {
        if (bi.oW(str)) {
            FavTagEditUI.i(this.jaA).setVisibility(8);
            FavTagEditUI.j(this.jaA).setVisibility(0);
        } else {
            d h = FavTagEditUI.h(this.jaA);
            h.jca.clear();
            h.jbZ.clear();
            h.jbY = bi.aG(str, "");
            l favTagSetMgr = ((ae) g.n(ae.class)).getFavTagSetMgr();
            boolean oW = bi.oW(str);
            Collection arrayList = new ArrayList(16);
            Iterator it = favTagSetMgr.iWd.rBV.iterator();
            while (it.hasNext()) {
                Iterator it2 = ((ww) it.next()).rBU.iterator();
                while (it2.hasNext()) {
                    wv wvVar = (wv) it2.next();
                    if (oW || wvVar.qdu.contains(str)) {
                        arrayList.add(wvVar.qdu);
                    }
                }
            }
            h.jbZ.addAll(arrayList);
            h.notifyDataSetChanged();
            FavTagEditUI.i(this.jaA).setVisibility(0);
            FavTagEditUI.j(this.jaA).setVisibility(8);
        }
        FavTagEditUI.c(this.jaA);
    }

    public final void zS(String str) {
        if (bi.oW(str)) {
            x.d("MicroMsg.FavTagEditUI", "on create tag, fail, tag is empty");
            return;
        }
        FavTagEditUI.d(this.jaA).bu(str, true);
        FavTagEditUI.c(this.jaA);
    }

    public final void aGt() {
    }

    public final void i(boolean z, int i) {
        FavTagEditUI.a(this.jaA, z);
        TextView k = FavTagEditUI.k(this.jaA);
        int i2 = (!FavTagEditUI.b(this.jaA) || i <= 0) ? 8 : 0;
        k.setVisibility(i2);
        FavTagEditUI.k(this.jaA).setText(this.jaA.getString(i.favorite_tag_edit_max_length_tips, new Object[]{Integer.valueOf(i)}));
        FavTagEditUI.c(this.jaA);
    }
}
