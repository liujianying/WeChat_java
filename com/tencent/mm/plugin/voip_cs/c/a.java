package com.tencent.mm.plugin.voip_cs.c;

import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public al eOf = new al(new 1(this), true);
    public TextView ih;
    public int[] oQE;
    public int oQF;
    public int oQG;

    public final void bLJ() {
        if (this.eOf != null) {
            this.eOf.SO();
        }
        x.k("MicroMsg.DynamicTextWrap", "stop textview: " + this.ih, new Object[0]);
        this.ih = null;
    }
}
