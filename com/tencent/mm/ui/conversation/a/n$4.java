package com.tencent.mm.ui.conversation.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.conversation.a.n.1;
import com.tencent.mm.ui.conversation.a.n.2;

class n$4 implements OnClickListener {
    final /* synthetic */ n usU;

    n$4(n nVar) {
        this.usU = nVar;
    }

    public final void onClick(View view) {
        n nVar;
        n.a(this.usU, this.usU.oDy);
        this.usU.oDy = 1;
        if (this.usU.usS == null) {
            nVar = this.usU;
            nVar.usS = new 1(nVar);
            a.sFg.a(nVar.usS);
        }
        if (this.usU.usR == null) {
            nVar = this.usU;
            nVar.usR = new al(new 2(nVar), true);
            nVar.usR.J(1000, 1000);
        }
    }
}
