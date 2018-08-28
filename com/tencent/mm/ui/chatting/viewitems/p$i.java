package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;

class p$i extends p$b {
    ImageView hrp;
    TextView jWm;

    p$i() {
    }

    public final void cn(View view) {
        if (this.hri == null) {
            ViewStub viewStub = (ViewStub) view.findViewById(R.h.viewstub_top_voice_slot);
            if (viewStub != null) {
                viewStub.inflate();
                this.hri = view.findViewById(R.h.chatting_item_biz_voice);
                this.eGX = (TextView) this.hri.findViewById(R.h.title);
                this.jWm = (TextView) this.hri.findViewById(R.h.time_tv);
                this.hrp = (ImageView) this.hri.findViewById(R.h.play_icon);
            }
        }
    }
}
