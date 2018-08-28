package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.viewitems.p.b;

class p$g extends b {
    View hrO;

    p$g() {
    }

    public final void cn(View view) {
        if (this.hri == null) {
            ViewStub viewStub = (ViewStub) view.findViewById(R.h.viewstub_top_text_slot);
            if (viewStub != null) {
                viewStub.inflate();
                this.hri = view.findViewById(R.h.chatting_item_biz_text);
                this.hrO = view.findViewById(R.h.bottom);
                this.eGX = (TextView) this.hri.findViewById(R.h.title);
            }
        }
    }
}
