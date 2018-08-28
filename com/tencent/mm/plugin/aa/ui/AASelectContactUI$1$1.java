package com.tencent.mm.plugin.aa.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.aa.ui.AASelectContactUI.1;
import java.util.List;

class AASelectContactUI$1$1 implements OnClickListener {
    final /* synthetic */ List eCx;
    final /* synthetic */ 1 eCy;

    AASelectContactUI$1$1(1 1, List list) {
        this.eCy = 1;
        this.eCx = list;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        AASelectContactUI.a(this.eCy.eCw, this.eCx);
    }
}
