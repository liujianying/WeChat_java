package com.tencent.mm.plugin.sns.ui.b;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.data.b;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.storage.a.b.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.sdk.platformtools.x;

class b$26 implements OnItemClickListener {
    final /* synthetic */ b olf;

    b$26(b bVar) {
        this.olf = bVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view.getTag() != null && (view.getTag() instanceof b)) {
            b bVar = (b) view.getTag();
            if (i < bVar.nkH.ohp.nyo.bzl().size() && !bVar.nkH.ohp.nys) {
                a aVar = (a) bVar.nkH.ohp.nyo.bzl().get(i);
                x.i("MicroMsg.TimelineClickListener", "unlike item click, reason=%s, id=%s", new Object[]{aVar.nyy, Integer.valueOf(aVar.nyB)});
                n Nl = af.byo().Nl(bVar.bKW);
                if (Nl != null) {
                    aVar.nkJ = bVar.nkJ;
                    aVar.nyC = System.currentTimeMillis();
                    r rVar = new r(Nl.field_snsId, 8, aVar);
                    g.Ek();
                    g.Eh().dpP.a(rVar, 0);
                    this.olf.cJ(view);
                }
            }
        }
    }
}
