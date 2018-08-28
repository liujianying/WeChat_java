package com.tencent.mm.plugin.card.ui.a;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;

public final class f extends a {
    public f(MMActivity mMActivity) {
        super(mMActivity);
    }

    public final boolean azu() {
        return this.hHc;
    }

    public final boolean azv() {
        return this.htQ.awi() && super.azv() && (this.htQ.awg() || !bi.oW(this.htQ.awn().code));
    }

    public final boolean azw() {
        return true;
    }

    public final boolean azz() {
        return this.htQ.awi() && super.azz();
    }
}
