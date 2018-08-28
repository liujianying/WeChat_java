package com.tencent.mm.plugin.card.ui.a;

import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.ui.MMActivity;

public final class e extends a {
    public e(MMActivity mMActivity) {
        super(mMActivity);
    }

    public final boolean azp() {
        if (!this.htQ.avT() || l.ob(this.hCv.hop) || !this.htQ.awi() || this.hHc) {
            return true;
        }
        return false;
    }

    public final boolean azt() {
        return this.htQ.avT() && !l.ob(this.hCv.hop) && this.htQ.awi() && !this.hHc;
    }

    public final boolean azu() {
        return this.hHc;
    }

    public final boolean azx() {
        return super.azx() || (this.htQ.awi() && !this.hHc && (aze() || azf()));
    }

    public final boolean azG() {
        return (!this.htQ.avT() || this.htQ.awm().rnY == null || !this.htQ.awi() || this.hHc || aze() || azf()) ? false : true;
    }

    public final boolean azC() {
        return this.htQ.awi() && super.azC() && !azw();
    }

    public final boolean azh() {
        return (!super.azh() || !this.htQ.awi() || this.hHc || aze() || azf()) ? false : true;
    }

    public final boolean azw() {
        return this.htQ.awm() != null && this.htQ.awm().rom;
    }
}
