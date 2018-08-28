package com.tencent.mm.plugin.location.ui.impl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.g.a.cc;
import com.tencent.mm.plugin.location.ui.impl.i.2;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class i$2$1 implements OnClickListener {
    final /* synthetic */ 2 kKz;

    i$2$1(2 2) {
        this.kKz = 2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        long longExtra = this.kKz.kKy.activity.getIntent().getLongExtra("kFavInfoLocalId", -1);
        cc ccVar = new cc();
        ccVar.bJy.bJA = longExtra;
        a.sFg.m(ccVar);
        x.d("MicroMsg.ViewMapUI", "do del fav voice, local id %d, result %B", new Object[]{Long.valueOf(longExtra), Boolean.valueOf(bi.a(Boolean.valueOf(ccVar.bJz.bJm), false))});
        if (bi.a(Boolean.valueOf(ccVar.bJz.bJm), false)) {
            this.kKz.kKy.activity.finish();
        }
    }
}
