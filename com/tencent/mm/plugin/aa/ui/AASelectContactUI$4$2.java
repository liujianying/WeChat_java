package com.tencent.mm.plugin.aa.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.aa.ui.AASelectContactUI.4;
import com.tencent.mm.plugin.report.service.h;

class AASelectContactUI$4$2 implements OnClickListener {
    final /* synthetic */ 4 eCz;

    AASelectContactUI$4$2(4 4) {
        this.eCz = 4;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.eCz.eCw.finish();
        h.mEJ.h(13721, new Object[]{Integer.valueOf(2), Integer.valueOf(10)});
    }
}
