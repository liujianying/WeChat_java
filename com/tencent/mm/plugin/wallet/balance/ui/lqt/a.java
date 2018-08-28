package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import com.tencent.mm.pluginsdk.ui.d.n;

public final class a extends n {
    private a paS;

    public a(a aVar) {
        super(2, null);
        this.paS = aVar;
    }

    public final void onClick(View view) {
        if (this.paS != null) {
            this.paS.We();
        }
    }
}
