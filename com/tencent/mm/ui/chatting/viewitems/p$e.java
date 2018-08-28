package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.viewitems.p.b;

class p$e extends b {
    ImageView gwj;
    View hrL;
    ImageView hro;
    ImageView mof;
    ImageView mog;

    p$e() {
    }

    public final void cn(View view) {
        if (this.hri == null) {
            ViewStub viewStub = (ViewStub) view.findViewById(R.h.viewstub_top_pic_slot);
            if (viewStub != null) {
                viewStub.inflate();
                this.hri = view.findViewById(R.h.chatting_item_biz_pic);
                this.hro = (ImageView) this.hri.findViewById(R.h.cover);
                this.hrq = (ImageView) this.hri.findViewById(R.h.cover_mask_iv);
                this.mog = (ImageView) this.hri.findViewById(R.h.press_mask_iv);
                this.eGX = (TextView) this.hri.findViewById(R.h.title);
                this.mof = (ImageView) this.hri.findViewById(R.h.cover_shadow_mask_iv);
                this.gwj = (ImageView) this.hri.findViewById(R.h.pic_icon);
                this.hrL = this.hri.findViewById(R.h.chatting_pic_cover_ll);
            }
        }
    }
}
