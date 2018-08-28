package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.c.c;
import com.tencent.mm.ui.widget.MMNeatTextView;

class c$g extends c {
    MMNeatTextView hrI;
    TextView hrJ;
    ImageView hrK;
    ImageView hro;
    ImageView hrp;

    c$g() {
    }

    public final void cn(View view) {
        if (this.hri == null) {
            ViewStub viewStub = (ViewStub) view.findViewById(d.viewstub_top_music_slot);
            if (viewStub != null) {
                viewStub.inflate();
                this.hri = view.findViewById(d.chatting_item_biz_music);
                avh();
                this.hro = (ImageView) this.hri.findViewById(d.cover);
                this.hrI = (MMNeatTextView) this.hri.findViewById(d.title_tv);
                this.hrJ = (TextView) this.hri.findViewById(d.player_tv);
                this.hrp = (ImageView) this.hri.findViewById(d.play_icon);
                this.hrK = (ImageView) this.hri.findViewById(d.watermark_iv);
                this.hrq = (ImageView) this.hri.findViewById(d.cover_mask_iv);
            }
        }
    }
}
