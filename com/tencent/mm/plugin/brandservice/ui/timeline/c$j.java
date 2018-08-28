package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.View;
import android.view.ViewStub;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.c.c;
import com.tencent.mm.ui.widget.MMNeatTextView;

class c$j extends c {
    MMNeatTextView hrI;
    View hrO;

    c$j() {
    }

    public final void cn(View view) {
        if (this.hri == null) {
            ViewStub viewStub = (ViewStub) view.findViewById(d.viewstub_top_text_slot);
            if (viewStub != null) {
                viewStub.inflate();
                this.hri = view.findViewById(d.chatting_item_biz_text);
                avh();
                this.hrO = view.findViewById(d.bottom);
                this.hrI = (MMNeatTextView) this.hri.findViewById(d.title_tv);
            }
        }
    }
}
