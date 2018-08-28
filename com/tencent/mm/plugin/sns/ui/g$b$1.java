package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.ui.g.b;

class g$b$1 implements OnClickListener {
    final /* synthetic */ b nKS;

    g$b$1(b bVar) {
        this.nKS = bVar;
    }

    public final void onClick(View view) {
        this.nKS.nKR = (g$b$a) view.getTag();
        this.nKS.xf(this.nKS.nKR.position);
    }
}
