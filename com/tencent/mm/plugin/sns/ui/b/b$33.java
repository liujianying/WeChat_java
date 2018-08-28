package com.tencent.mm.plugin.sns.ui.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.sdk.platformtools.x;

class b$33 implements OnClickListener {
    final /* synthetic */ b olf;

    b$33(b bVar) {
        this.olf = bVar;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof c) {
            n Nl = af.byo().Nl(((c) view.getTag()).bKW);
            if (Nl != null && Nl.xb(32)) {
                x.i("MicroMsg.TimelineClickListener", "click the ad tailLink button");
                com.tencent.mm.plugin.sns.a.b.c cVar = new com.tencent.mm.plugin.sns.a.b.c(Nl.bBn(), 24, this.olf.scene == 0 ? 1 : 2, "", Nl.bBr(), Nl.bAK());
                g.Ek();
                g.Eh().dpP.a(cVar, 0);
                this.olf.cF(view);
            }
        }
    }
}
