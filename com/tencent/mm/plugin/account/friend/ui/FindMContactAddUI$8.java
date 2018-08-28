package com.tencent.mm.plugin.account.friend.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;

class FindMContactAddUI$8 implements OnClickListener {
    final /* synthetic */ FindMContactAddUI eLW;

    FindMContactAddUI$8(FindMContactAddUI findMContactAddUI) {
        this.eLW = findMContactAddUI;
    }

    public final void onClick(View view) {
        StringBuilder stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(a.DA()).append(",").append(this.eLW.getClass().getName()).append(",R300_300_AddAllButton,");
        g.Eg();
        com.tencent.mm.plugin.c.a.pV(stringBuilder.append(a.gd("R300_300_AddAllButton")).append(",3").toString());
        if (FindMContactAddUI.e(this.eLW) == 2) {
            FindMContactAddUI.c(this.eLW).ci(true);
            FindMContactAddUI.c(this.eLW).notifyDataSetChanged();
            FindMContactAddUI.f(this.eLW).setVisibility(8);
            if (FindMContactAddUI.g(this.eLW) != null) {
                FindMContactAddUI.g(this.eLW).setVisibility(0);
            }
        } else if (FindMContactAddUI.e(this.eLW) == 1) {
            FindMContactAddUI.c(this.eLW).ci(true);
            FindMContactAddUI.c(this.eLW).notifyDataSetChanged();
            FindMContactAddUI.i(this.eLW);
        } else {
            FindMContactAddUI.c(this.eLW).ci(true);
            FindMContactAddUI.c(this.eLW).notifyDataSetChanged();
            FindMContactAddUI.f(this.eLW).setVisibility(8);
            if (FindMContactAddUI.g(this.eLW) != null) {
                FindMContactAddUI.g(this.eLW).setVisibility(0);
            }
        }
    }
}
