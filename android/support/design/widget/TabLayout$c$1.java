package android.support.design.widget;

import android.support.design.widget.TabLayout.c;

class TabLayout$c$1 implements u$c {
    final /* synthetic */ int hR;
    final /* synthetic */ int hS;
    final /* synthetic */ int hT;
    final /* synthetic */ int hU;
    final /* synthetic */ c hV;

    TabLayout$c$1(c cVar, int i, int i2, int i3, int i4) {
        this.hV = cVar;
        this.hR = i;
        this.hS = i2;
        this.hT = i3;
        this.hU = i4;
    }

    public final void a(u uVar) {
        float animatedFraction = uVar.iO.getAnimatedFraction();
        c.a(this.hV, a.a(this.hR, this.hS, animatedFraction), a.a(this.hT, this.hU, animatedFraction));
    }
}
