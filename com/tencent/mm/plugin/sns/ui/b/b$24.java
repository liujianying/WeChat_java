package com.tencent.mm.plugin.sns.ui.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.a.b.c;
import com.tencent.mm.plugin.sns.data.b;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;

class b$24 implements OnClickListener {
    final /* synthetic */ b olf;

    b$24(b bVar) {
        this.olf = bVar;
    }

    public final void onClick(View view) {
        this.olf.cI(view);
        if (view.getTag() != null && (view.getTag() instanceof b)) {
            b bVar = (b) view.getTag();
            n Nl = af.byo().Nl(bVar.bKW);
            if (Nl != null && Nl.xb(32)) {
                bVar.nkJ = System.currentTimeMillis();
                c cVar = new c(Nl.bBn(), 20, this.olf.scene == 0 ? 1 : 2, "", Nl.bBr(), Nl.bAK());
                g.Ek();
                g.Eh().dpP.a(cVar, 0);
            }
        }
    }
}
