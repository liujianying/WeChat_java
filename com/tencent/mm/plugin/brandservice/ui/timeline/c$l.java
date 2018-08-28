package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.c.c;
import com.tencent.mm.ui.widget.MMNeatTextView;

class c$l extends c {
    MMNeatTextView hrI;
    TextView hrQ;
    ImageView hrp;

    c$l() {
    }

    public final void cn(View view) {
        if (this.hri == null) {
            ViewStub viewStub = (ViewStub) view.findViewById(d.viewstub_top_voice_slot);
            if (viewStub != null) {
                viewStub.inflate();
                this.hri = view.findViewById(d.chatting_item_biz_voice);
                avh();
                this.hrI = (MMNeatTextView) this.hri.findViewById(d.title_tv);
                this.hrQ = (TextView) this.hri.findViewById(d.play_time_tv);
                this.hrp = (ImageView) this.hri.findViewById(d.play_icon);
            }
        }
    }
}
