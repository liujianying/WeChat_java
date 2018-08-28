package com.tencent.mm.plugin.sns.ui.b;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.data.b;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.b$a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.d;
import com.tencent.mm.sdk.platformtools.x;

class b$25 implements OnItemClickListener {
    final /* synthetic */ b olf;

    b$25(b bVar) {
        this.olf = bVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        x.i("MicroMsg.TimelineClickListener", "unlike click");
        if (adapterView.getAdapter() instanceof d) {
            b bVar = (b) view.getTag();
            n Nl = af.byo().Nl(bVar.bKW);
            if (Nl == null) {
                return;
            }
            if (i == 0) {
                if (Nl.xb(32)) {
                    Object obj;
                    a bAH = Nl.bAH();
                    if (bAH == null) {
                        obj = "";
                    } else {
                        String obj2 = bAH.fvT;
                    }
                    ((c) g.l(c.class)).a(11855, Nl.bBq(), new Object[]{Integer.valueOf(3), obj2, Integer.valueOf(Nl.bBq())});
                }
                a.b.a aVar;
                r rVar;
                if ((bVar.nkH.ohp.nyo.bzl().size() > 0 ? 1 : null) != null) {
                    d dVar = (d) adapterView.getAdapter();
                    dVar.fHo++;
                    dVar.notifyDataSetChanged();
                    adapterView.setOnItemClickListener(this.olf.okY);
                    this.olf.bBT();
                    aVar = new a.b.a();
                    aVar.nyB = a.b.a.nyx;
                    aVar.nkJ = bVar.nkJ;
                    aVar.nyC = 0;
                    rVar = new r(Nl.field_snsId, 8, aVar);
                    g.Ek();
                    g.Eh().dpP.a(rVar, 0);
                    return;
                } else if (!bVar.nkH.ohp.nys) {
                    this.olf.cJ(view);
                    aVar = new a.b.a();
                    aVar.nkJ = bVar.nkJ;
                    aVar.nyC = System.currentTimeMillis();
                    rVar = new r(Nl.field_snsId, 8, aVar);
                    g.Ek();
                    g.Eh().dpP.a(rVar, 0);
                    return;
                } else {
                    return;
                }
            } else if (bVar.nkH.oho.nzw == null) {
                x.e("MicroMsg.TimelineClickListener", "click feedback item but no report url");
                return;
            } else {
                b$a b_a = bVar.nkH.oho.nzw;
                int i2 = i - 1;
                if (i2 < b_a.list.size()) {
                    String str = ((com.tencent.mm.plugin.sns.storage.b.b) b_a.list.get(i2)).url;
                    try {
                        String[] strArr = new String[4];
                        strArr[0] = String.format("snsid=%s", new Object[]{Nl.bAJ().ksA});
                        strArr[1] = String.format("aid=%s", new Object[]{Nl.bBj()});
                        strArr[2] = String.format("traceid=%s", new Object[]{Nl.bBk()});
                        Object[] objArr = new Object[1];
                        g.Eg();
                        objArr[0] = com.tencent.mm.kernel.a.Dg();
                        strArr[3] = String.format("uin=%s", objArr);
                        str = e.l(str, strArr);
                    } catch (Exception e) {
                    }
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("useJs", true);
                    intent.putExtra("KPublisherId", "sns_" + i.eF(Nl.field_snsId));
                    intent.putExtra("pre_username", Nl.field_userName);
                    intent.putExtra("prePublishId", "sns_" + i.eF(Nl.field_snsId));
                    intent.putExtra("preUsername", Nl.field_userName);
                    com.tencent.mm.plugin.sns.c.a.ezn.j(intent, this.olf.activity);
                    return;
                }
                return;
            }
        }
        x.w("MicroMsg.TimelineClickListener", "unknown unlike adapter click");
    }
}
