package com.tencent.mm.plugin.sns.ui.b;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.s.a.a;
import com.tencent.mm.plugin.sns.lucky.a.b;
import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.bou;
import com.tencent.mm.protocal.c.boy;
import com.tencent.mm.protocal.c.bsu;
import java.util.ArrayList;
import java.util.List;

class b$11 implements OnClickListener {
    final /* synthetic */ b olf;

    b$11(b bVar) {
        this.olf = bVar;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof n) {
            String str;
            n nVar = (n) view.getTag();
            if (nVar.field_type == 21 && q.GF().equals(nVar.field_userName)) {
                str = nVar.bAJ().ksA;
                m.j(nVar);
                m.i(nVar);
                System.currentTimeMillis();
                b.kB(24);
            }
            Intent intent = new Intent();
            intent.putExtra("key_sendid", nVar.bAK());
            intent.putExtra("key_feedid", nVar.bBe());
            intent.setClassName(this.olf.activity, "com.tencent.mm.plugin.sns.lucky.ui.SnsLuckyMoneyDetailUI");
            this.olf.activity.startActivity(intent);
            str = nVar.bBe();
            nVar.bAK();
            Od(str);
        }
    }

    private static void Od(String str) {
        int i = 0;
        n fi = af.byo().fi(af.byo().Nl(str).field_snsId);
        if (fi != null) {
            List list;
            bsu bAJ = fi.bAJ();
            if (bAJ != null) {
                list = bAJ.sqc.ruA;
                if (list.size() > 0) {
                    list.get(0);
                }
            }
            boy n = aj.n(fi);
            list = new ArrayList();
            List list2 = n.smZ.snC;
            if (list2 != null) {
                while (true) {
                    int i2 = i;
                    if (i2 >= list2.size()) {
                        break;
                    }
                    bou bou = (bou) list2.get(i2);
                    a aVar = new a();
                    aVar.gtX = bou.rdS;
                    aVar.kKD = bou.lOH;
                    aVar.kKE = bou.sml;
                    list.add(aVar);
                    i = i2 + 1;
                }
            }
            com.tencent.mm.plugin.s.a.l(str, list);
        }
    }
}
