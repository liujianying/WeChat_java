package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.ui.g.b;
import com.tencent.mm.plugin.sns.ui.g.b.a;

class g$b$2 implements OnClickListener {
    final /* synthetic */ b nKS;

    g$b$2(b bVar) {
        this.nKS = bVar;
    }

    public final void onClick(View view) {
        this.nKS.nKR = (a) view.getTag();
        this.nKS.xf(this.nKS.nKR.position);
    }
}
