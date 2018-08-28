package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.be.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;

class h$9 implements OnClickListener {
    final /* synthetic */ h tiG;

    h$9(h hVar) {
        this.tiG = hVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (h.r(this.tiG) != null) {
            au.HU();
            c.DT().set(4104, Boolean.valueOf(!h.r(this.tiG).isChecked()));
        }
        LauncherUI launcherUI = (LauncherUI) this.tiG.getContext();
        if (launcherUI != null) {
            launcherUI.tkn.tjF.ZS("tab_find_friend");
        }
        a.eF(this.tiG.getContext());
    }
}
