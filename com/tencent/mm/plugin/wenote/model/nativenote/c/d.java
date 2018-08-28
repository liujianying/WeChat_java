package com.tencent.mm.plugin.wenote.model.nativenote.c;

import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;

public final class d {
    public int dHJ = -1;
    public int endPos = -1;
    public int qsa = -1;
    public int startOffset = -1;

    public d() {
        set(-1, -1, -1, -1);
    }

    public d(int i, int i2, int i3, int i4) {
        set(i, i2, i3, i4);
    }

    public final void set(int i, int i2, int i3, int i4) {
        this.dHJ = i;
        this.startOffset = i2;
        this.endPos = i3;
        this.qsa = i4;
    }

    public final int cao() {
        if (this.dHJ < 0 || this.startOffset < 0 || this.endPos < 0 || this.qsa < 0 || this.dHJ > this.endPos || (this.dHJ == this.endPos && this.startOffset > this.qsa)) {
            return 0;
        }
        b Bv = c.bZD().Bv(this.dHJ);
        b Bv2 = c.bZD().Bv(this.endPos);
        if (Bv == null || Bv2 == null) {
            return 0;
        }
        if (this.dHJ == this.endPos && this.startOffset == this.qsa) {
            return 1;
        }
        if (this.dHJ == this.endPos && Bv.getType() == 1) {
            return 2;
        }
        return 3;
    }
}
