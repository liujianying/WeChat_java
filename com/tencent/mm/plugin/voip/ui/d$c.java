package com.tencent.mm.plugin.voip.ui;

import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

protected class d$c {
    al eOf = new al(new a() {
        public final boolean vD() {
            int i = d$c.this.oQE[d$c.this.oQG % d$c.this.oQE.length];
            if (d$c.this.ih != null) {
                if (-1 == i) {
                    d$c.this.ih.setText(null);
                } else {
                    d$c.this.ih.setText(i);
                }
            }
            d$c d_c = d$c.this;
            d_c.oQG++;
            return true;
        }
    }, true);
    TextView ih;
    int[] oQE;
    private int oQF;
    int oQG;

    protected d$c() {
    }

    public final void a(TextView textView, int[] iArr) {
        if (iArr == null || textView == null) {
            x.e("MicroMsg.DynamicTextWrap", "textList or tv is null");
            return;
        }
        bLJ();
        this.oQG = 0;
        this.oQE = iArr;
        this.ih = textView;
        this.oQF = 500;
        if (this.eOf != null) {
            long j = (long) this.oQF;
            this.eOf.J(j, j);
        }
        x.k("MicroMsg.DynamicTextWrap", "start textview:" + textView, new Object[0]);
    }

    public final void bLJ() {
        if (this.eOf != null) {
            this.eOf.SO();
        }
        x.k("MicroMsg.DynamicTextWrap", "stop textview: " + this.ih, new Object[0]);
        this.ih = null;
    }
}
