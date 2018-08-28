package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.c.c;
import com.tencent.mm.ui.widget.MMNeatTextView;

class c$k extends c {
    ImageView gwj;
    MMNeatTextView hrI;
    View hrL;
    TextView hrP;
    ImageView hro;

    c$k() {
    }

    public final void cn(View view) {
        if (this.hri == null) {
            ViewStub viewStub = (ViewStub) view.findViewById(d.viewstub_top_video_slot);
            if (viewStub != null) {
                viewStub.inflate();
                this.hri = view.findViewById(d.chatting_item_biz_video);
                avh();
                this.hro = (ImageView) this.hri.findViewById(d.cover);
                this.hrq = (ImageView) this.hri.findViewById(d.cover_mask_iv);
                this.gwj = (ImageView) this.hri.findViewById(d.video_icon);
                this.hrI = (MMNeatTextView) this.hri.findViewById(d.title_tv);
                this.hrP = (TextView) this.hri.findViewById(d.play_time_tv);
                this.hrL = this.hri.findViewById(d.chatting_video_cover_ll);
            }
        }
    }
}
