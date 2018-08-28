package com.tencent.mm.plugin.nearlife.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.report.service.h;

class NearLifeCreatePoiUI$8 implements OnClickListener {
    final /* synthetic */ NearLifeCreatePoiUI lEr;

    NearLifeCreatePoiUI$8(NearLifeCreatePoiUI nearLifeCreatePoiUI) {
        this.lEr = nearLifeCreatePoiUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        h.mEJ.h(11138, new Object[]{"3", "0", NearLifeCreatePoiUI.b(this.lEr)});
        this.lEr.setResult(0, new Intent());
        this.lEr.finish();
    }
}
