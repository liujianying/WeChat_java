package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.viewitems.p.b;

class p$d extends b {
    TextView hrJ;
    ImageView hrK;
    ImageView hro;
    ImageView hrp;

    p$d() {
    }

    public final void cn(View view) {
        if (this.hri == null) {
            ViewStub viewStub = (ViewStub) view.findViewById(R.h.viewstub_top_music_slot);
            if (viewStub != null) {
                viewStub.inflate();
                this.hri = view.findViewById(R.h.chatting_item_biz_music);
                this.hro = (ImageView) this.hri.findViewById(R.h.cover);
                this.eGX = (TextView) this.hri.findViewById(R.h.title);
                this.hrJ = (TextView) this.hri.findViewById(R.h.player_tv);
                this.hrp = (ImageView) this.hri.findViewById(R.h.play_icon);
                this.hrK = (ImageView) this.hri.findViewById(R.h.watermark_iv);
                this.hrq = (ImageView) this.hri.findViewById(R.h.cover_mask_iv);
            }
        }
    }
}
