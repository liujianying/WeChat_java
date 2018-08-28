package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;

public final class n extends e {
    final boolean qsT;
    public final boolean qsU;

    public n(int i, int i2, boolean z, boolean z2) {
        super(i, i2);
        this.qsT = z;
        this.qsU = z2;
    }

    public final boolean a(e eVar) {
        if (eVar == null) {
            return false;
        }
        if (eVar.isEmpty()) {
            boolean z;
            if (eVar.Tw < this.Tw || eVar.tK >= this.tK) {
                z = false;
            } else {
                z = true;
            }
            boolean z2;
            if (eVar.Tw < this.Tw || eVar.tK > this.tK) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z || (z2 && this.qsU)) {
                return true;
            }
            return false;
        } else if (Math.max(this.Tw, eVar.Tw) < Math.min(this.tK, eVar.tK)) {
            return true;
        } else {
            return false;
        }
    }

    public final int caK() {
        return Math.abs(this.tK - this.Tw);
    }
}
