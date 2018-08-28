package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.lucky.ui.a;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.protocal.c.bon;
import com.tencent.mm.protocal.c.boy;

public class j$a implements OnClickListener {
    private String daA;
    private c nLr;
    final /* synthetic */ j nMb;
    private CharSequence nMi = "";
    private bon noe;

    public j$a(j jVar, bon bon, String str, CharSequence charSequence, c cVar) {
        this.nMb = jVar;
        this.daA = str;
        this.noe = bon;
        this.nLr = cVar;
        this.nMi = charSequence;
    }

    public final void onClick(View view) {
        int i = 0;
        if (v.NG(this.nLr.bSZ)) {
            this.nLr.ojc = view;
            if (this.noe == null || this.noe.rdS == null || !this.noe.rdS.equals(this.nMb.cXR)) {
                n nVar = new n();
                n xi = this.nMb.nuc.xi(this.nLr.position);
                if (!xi.bxX()) {
                    if (m.h(xi)) {
                        b io = b.io(742);
                        boy n = aj.n(xi);
                        b ir = io.nb(i.g(xi)).ir(xi.field_type).bP(xi.xb(32)).nb(xi.bBo()).nb(this.noe.smh == 0 ? this.noe.smk : this.noe.smh).nb(this.noe.rdS).ir(n == null ? 0 : n.smJ);
                        if (n != null) {
                            i = n.smM;
                        }
                        ir.ir(i);
                        io.RD();
                        this.nMb.a(this.nLr, xi, j.c(this.nMb).getString(j.sns_reply) + this.daA, this.noe);
                        return;
                    }
                    a.e(this.nLr.oji.getContext(), this.nLr.oji.xm(0));
                    return;
                }
                return;
            }
            if (this.nMb.nLO.ohS) {
                this.nMb.bBQ();
                this.nMb.nLO.ohS = false;
            }
            com.tencent.mm.ui.widget.b.a aVar = new com.tencent.mm.ui.widget.b.a(j.c(this.nMb));
            1 1 = new 1(this);
            2 2 = new 2(this);
            int[] iArr = new int[2];
            if (view.getTag(f.touch_loc) instanceof int[]) {
                iArr = (int[]) view.getTag(f.touch_loc);
            }
            aVar.a(view, 1, 2, iArr[0], iArr[1]);
        }
    }
}
