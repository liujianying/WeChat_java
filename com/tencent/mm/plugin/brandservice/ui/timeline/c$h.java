package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.c.c;
import com.tencent.mm.ui.widget.MMNeatTextView;

class c$h extends c {
    ImageView gwj;
    MMNeatTextView hrI;
    View hrL;
    TextView hrM;
    ImageView hro;

    c$h() {
    }

    public final void cn(View view) {
        if (this.hri == null) {
            ViewStub viewStub = (ViewStub) view.findViewById(d.viewstub_top_pic_slot);
            if (viewStub != null) {
                viewStub.inflate();
                this.hri = view.findViewById(d.chatting_item_biz_pic);
                avh();
                this.hro = (ImageView) this.hri.findViewById(d.cover);
                this.hrq = (ImageView) this.hri.findViewById(d.cover_mask_iv);
                this.hrM = (TextView) this.hri.findViewById(d.count_tv);
                this.gwj = (ImageView) this.hri.findViewById(d.pic_icon);
                this.hrL = this.hri.findViewById(d.chatting_pic_cover_ll);
                this.hrI = (MMNeatTextView) this.hri.findViewById(d.title_tv);
            }
        }
    }
}
