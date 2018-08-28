package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.plugin.sns.ui.a.h;
import com.tencent.mm.plugin.sns.ui.a.h.5;
import com.tencent.mm.plugin.sns.ui.a.h.a;
import com.tencent.mm.plugin.sns.ui.b.b;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.bon;
import com.tencent.mm.protocal.c.boy;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.platformtools.ag;

class j$1 extends b {
    final /* synthetic */ j nMb;

    j$1(j jVar, Activity activity, ae aeVar) {
        this.nMb = jVar;
        super(0, activity, aeVar);
    }

    public final void b(View view, int i, int i2, int i3) {
        if (i2 < 0) {
            new 1(this, i, i2, i3, view).run();
        }
    }

    public final void bS(Object obj) {
        this.nMb.nLP.a((View) obj, 1, this.nMb.nLK);
    }

    public final void bBS() {
        if (this.nMb.nuc != null) {
            this.nMb.nuc.bDS();
        }
    }

    public final void cE(View view) {
        int i = 0;
        c cVar = (c) view.getTag();
        if (this.nMb.nuc.bDP() != null) {
            this.nMb.nuc.bDP().bCa();
            n nVar = new n();
            n xi = this.nMb.nuc.xi(cVar.position);
            if (xi.isValid()) {
                com.tencent.mm.modelsns.b io = com.tencent.mm.modelsns.b.io(741);
                boy n = aj.n(xi);
                com.tencent.mm.modelsns.b ir = io.nb(i.g(xi)).ir(xi.field_type).bP(xi.xb(32)).nb(xi.bBo()).nb(xi.field_userName).ir(n == null ? 0 : n.smJ);
                if (n != null) {
                    i = n.smM;
                }
                ir.ir(i);
                io.RD();
                this.nMb.a(cVar, xi, "", new bon());
                bon bon = new bon();
            }
        }
    }

    public final void cF(View view) {
        int i = 0;
        if (view.getTag() instanceof c) {
            c cVar = (c) view.getTag();
            if (this.nMb.nuc.bDP() != null) {
                this.nMb.nuc.bDP().bCa();
                n nVar = new n();
                n xi = this.nMb.nuc.xi(cVar.position);
                if (xi.isValid()) {
                    com.tencent.mm.modelsns.b io = com.tencent.mm.modelsns.b.io(741);
                    boy n = aj.n(xi);
                    com.tencent.mm.modelsns.b ir = io.nb(i.g(xi)).ir(xi.field_type).bP(xi.xb(32)).nb(xi.bBo()).nb(xi.field_userName).ir(n == null ? 0 : n.smJ);
                    if (n != null) {
                        i = n.smM;
                    }
                    ir.ir(i);
                    io.RD();
                    this.nMb.a(cVar, xi, new bon());
                }
            }
        }
    }

    public final void cG(View view) {
        if (this.nMb.nuc != null) {
            this.nMb.nuc.cL(view);
        }
    }

    public final void cH(View view) {
        c cVar = (c) view.getTag();
        n Nl = af.byo().Nl(cVar.bKW);
        if (Nl != null && !Nl.bxX() && !j.a(this.nMb)) {
            int i = 0;
            if (Nl.xb(32) && Nl.bAJ().sqc.ruz == 27 && (cVar.ojP instanceof h)) {
                h hVar = (h) cVar.ojP;
                a aVar = cVar.ojK;
                if (aVar.oko != null) {
                    c cVar2 = aVar.okn;
                    n nVar = aVar.nSE;
                    bsu bsu = cVar2.ojM;
                    a aVar2 = cVar2.ojK;
                    if (bsu.sqc.ruz == 27 && bsu.sqc.ruA.size() >= 2) {
                        int i2;
                        int i3;
                        int i4 = 0;
                        if (nVar.field_likeFlag == 1) {
                            i4 = 1;
                            i = 0;
                        } else {
                            i = 1;
                        }
                        ate ate = (ate) bsu.sqc.ruA.get(i4);
                        bsu.sqc.ruA.get(i);
                        View view2 = cVar2.ojI;
                        View i5 = h.i(cVar2.ojI, i4, ate.hcE);
                        View i6 = h.i(cVar2.ojI, i, 2);
                        int[] iArr = new int[2];
                        view2.getLocationOnScreen(iArr);
                        view2.setPivotY((float) ((hVar.mScreenHeight / 2) - iArr[1]));
                        view2.setCameraDistance(8000.0f);
                        float width = ((float) view2.getWidth()) / 2.0f;
                        float height = ((float) view2.getHeight()) / 2.0f;
                        if (nVar.field_likeFlag == 1) {
                            i2 = -90;
                            i3 = 90;
                        } else {
                            i2 = 90;
                            i3 = -90;
                        }
                        com.tencent.mm.plugin.sns.ui.widget.a aVar3 = new com.tencent.mm.plugin.sns.ui.widget.a(view2.getContext(), 0.0f, (float) i3, width, height, true);
                        aVar3.setDuration(187);
                        aVar3.setInterpolator(new AccelerateInterpolator());
                        aVar3.setFillAfter(true);
                        aVar3.setAnimationListener(new 5(hVar, i6, i5, aVar2, view2, i2, width, height));
                        view2.startAnimation(aVar3);
                        i = 374;
                        if (Nl.field_likeFlag == 0) {
                            this.nMb.nLJ.ez(cVar.oiF);
                        }
                        if (Nl.bAJ().sqc.ruA.size() > cVar.ojK.index && ((ate) Nl.bAJ().sqc.ruA.get(cVar.ojK.index)).hcE == 6) {
                            this.nMb.nLJ.r(cVar.oiF, cVar.ojK.index <= 0);
                        }
                        j.a(this.nMb, true);
                    }
                }
                i = 0;
                if (Nl.field_likeFlag == 0) {
                    this.nMb.nLJ.ez(cVar.oiF);
                }
                if (cVar.ojK.index <= 0) {
                }
                this.nMb.nLJ.r(cVar.oiF, cVar.ojK.index <= 0);
                j.a(this.nMb, true);
            }
            new ag().postDelayed(new 2(this, Nl, cVar, view), (long) i);
        }
    }

    public final void cI(View view) {
        this.nMb.nLU.bCa();
        this.nMb.nLV.nAK = true;
        this.nMb.nLV.cD(view);
    }

    public final void bBT() {
        this.nMb.nLV.bBH();
    }

    public final void cJ(View view) {
        this.nMb.nLV.bzf();
        if (view.getTag() != null) {
            com.tencent.mm.plugin.sns.data.b bVar = (com.tencent.mm.plugin.sns.data.b) view.getTag();
            this.nMb.nLJ.t(bVar.position, bVar.bKW, bVar.fvT);
        }
    }
}
