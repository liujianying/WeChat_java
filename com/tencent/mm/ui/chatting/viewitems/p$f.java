package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.viewitems.p.b;
import com.tencent.mm.ui.widget.MMNeatTextView;

class p$f extends b {
    View eSd;
    View hrL;
    TextView hrN;
    ImageView hro;
    MMNeatTextView moe;
    ImageView mof;
    ImageView mog;

    p$f() {
    }

    public final void cn(View view) {
        if (this.hri == null) {
            ViewStub viewStub = (ViewStub) view.findViewById(R.h.viewstub_top_slot);
            if (viewStub != null) {
                viewStub.inflate();
                this.hri = view.findViewById(R.h.topSlot);
                this.eGX = (TextView) this.hri.findViewById(R.h.title);
                this.hro = (ImageView) this.hri.findViewById(R.h.cover);
                this.hrL = this.hri.findViewById(R.h.cover_container);
                this.eSd = this.hri.findViewById(R.h.bottom_container);
                this.moe = (MMNeatTextView) this.hri.findViewById(R.h.title_textview_in_image);
                this.hrN = (TextView) this.hri.findViewById(R.h.digest);
                this.mog = (ImageView) this.hri.findViewById(R.h.press_mask_iv);
                this.mof = (ImageView) this.hri.findViewById(R.h.cover_shadow_mask_iv);
            }
        }
    }
}
