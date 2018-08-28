package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import com.tencent.mm.pluginsdk.ui.d.n;

public final class a extends n {
    private a eBI;

    public a(a aVar) {
        super(2, null);
        this.eBI = aVar;
    }

    public final void onClick(View view) {
        if (this.eBI != null) {
            this.eBI.We();
        }
    }
}
