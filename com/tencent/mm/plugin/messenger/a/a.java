package com.tencent.mm.plugin.messenger.a;

import android.view.View;
import com.tencent.mm.pluginsdk.ui.d.n;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public abstract class a extends n {
    private long lbJ = -1;

    public abstract void onClickImp(View view);

    public a() {
        super(1, null);
    }

    public void onClick(View view) {
        if (bi.bI(this.lbJ) > 1000) {
            super.onClick(view);
            onClickImp(view);
        } else {
            x.w("MicroMsg.AvoidDuplicatedPressableSpan", "hy: too often click");
            this.lmQ = false;
        }
        this.lbJ = bi.VG();
    }
}
