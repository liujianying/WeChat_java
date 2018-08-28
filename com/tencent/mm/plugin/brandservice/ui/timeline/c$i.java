package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.c.c;
import com.tencent.mm.ui.widget.MMNeatTextView;

class c$i extends c {
    MMNeatTextView hrI;
    TextView hrN;
    ImageView hro;

    c$i() {
    }

    public final void cn(View view) {
        if (this.hri == null) {
            ViewStub viewStub = (ViewStub) view.findViewById(d.viewstub_top_slot);
            if (viewStub != null) {
                viewStub.inflate();
                this.hri = view.findViewById(d.topSlot);
                avh();
                this.hro = (ImageView) this.hri.findViewById(d.cover_iv);
                this.hrI = (MMNeatTextView) this.hri.findViewById(d.title_tv);
                this.hrN = (TextView) this.hri.findViewById(d.digest_tv);
            }
        }
    }
}
