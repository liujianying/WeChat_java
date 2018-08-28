package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import com.tencent.mm.plugin.fav.ui.a.c;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView;
import com.tencent.mm.plugin.report.service.h;

class FavSearchUI$9 extends c {
    final /* synthetic */ FavSearchUI iZQ;

    FavSearchUI$9(FavSearchUI favSearchUI, Context context) {
        this.iZQ = favSearchUI;
        super(context);
    }

    protected final void Bz(String str) {
        FavSearchActionView a = FavSearchUI.a(this.iZQ);
        a.jfy.add(str);
        if (a.jat != null) {
            a.jat.setEditHint("");
            a.jat.bu(str, true);
            if (a.jfA != null) {
                a.BG(a.jat.getEditText());
                a.jfA.a(a.jbK, a.jfz, a.jfy, false);
                h.mEJ.h(11126, new Object[]{Integer.valueOf(2)});
            }
        }
    }

    protected final void BA(String str) {
        FavSearchActionView a = FavSearchUI.a(this.iZQ);
        a.jfy.remove(str);
        if (a.jat != null) {
            if (a.jfy.isEmpty()) {
                a.jat.setEditHint(a.getResources().getString(i.app_search));
            }
            a.jat.removeTag(str);
            if (a.jfA != null) {
                a.BG(a.jat.getEditText());
                a.jfA.a(a.jbK, a.jfz, a.jfy, true);
            }
        }
    }
}
