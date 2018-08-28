package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.plugin.mmsight.segment.c.b;
import com.tencent.mm.plugin.mmsight.segment.n.a;

class RecyclerThumbSeekBar$6 implements a {
    final /* synthetic */ RecyclerThumbSeekBar llX;

    RecyclerThumbSeekBar$6(RecyclerThumbSeekBar recyclerThumbSeekBar) {
        this.llX = recyclerThumbSeekBar;
    }

    public final void beZ() {
        if (RecyclerThumbSeekBar.p(this.llX) != null && RecyclerThumbSeekBar.m(this.llX) != null) {
            b p = RecyclerThumbSeekBar.p(this.llX);
            this.llX.beM();
            this.llX.beN();
            p.beO();
        }
    }

    public final void bfa() {
        if (RecyclerThumbSeekBar.p(this.llX) != null && RecyclerThumbSeekBar.m(this.llX) != null) {
            RecyclerThumbSeekBar.p(this.llX).L(this.llX.beM(), this.llX.beN());
        }
    }

    public final void gx(boolean z) {
        if (!(RecyclerThumbSeekBar.p(this.llX) == null || RecyclerThumbSeekBar.m(this.llX) == null)) {
            RecyclerThumbSeekBar.p(this.llX).M(this.llX.beM(), this.llX.beN());
        }
        if (z) {
            RecyclerThumbSeekBar.m(this.llX).n(true, RecyclerThumbSeekBar.l(this.llX).getLeftSliderBound());
        } else {
            RecyclerThumbSeekBar.m(this.llX).n(false, RecyclerThumbSeekBar.l(this.llX).getWidth() - RecyclerThumbSeekBar.l(this.llX).getRightSliderBound());
        }
    }
}
