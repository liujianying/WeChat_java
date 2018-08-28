package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.viewitems.p.b;

class p$h extends b {
    ImageView gwj;
    View hrL;
    TextView hrV;
    ImageView hro;
    ImageView mog;

    p$h() {
    }

    public final void cn(View view) {
        if (this.hri == null) {
            ViewStub viewStub = (ViewStub) view.findViewById(R.h.viewstub_top_video_slot);
            if (viewStub != null) {
                viewStub.inflate();
                this.hri = view.findViewById(R.h.chatting_item_biz_video);
                this.hro = (ImageView) this.hri.findViewById(R.h.cover);
                this.hrq = (ImageView) this.hri.findViewById(R.h.cover_mask_iv);
                this.mog = (ImageView) this.hri.findViewById(R.h.press_mask_iv);
                this.gwj = (ImageView) this.hri.findViewById(R.h.video_icon);
                this.eGX = (TextView) this.hri.findViewById(R.h.title);
                this.hrV = (TextView) this.hri.findViewById(R.h.time_tv);
                this.hrL = this.hri.findViewById(R.h.chatting_video_cover_ll);
            }
        }
    }
}
