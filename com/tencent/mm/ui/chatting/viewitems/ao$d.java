package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.viewitems.b.a;

class ao$d extends a {
    TextView ucQ;

    ao$d() {
    }

    public final a dG(View view) {
        super.dx(view);
        this.hrs = (TextView) view.findViewById(R.h.chatting_time_tv);
        this.ucQ = (TextView) view.findViewById(R.h.chatting_voip_tv);
        this.hrH = view.findViewById(R.h.chatting_click_area);
        this.tZv = (ImageView) view.findViewById(R.h.chatting_state_iv);
        this.jBR = (CheckBox) view.findViewById(R.h.chatting_checkbox);
        this.gFD = view.findViewById(R.h.chatting_maskview);
        return this;
    }
}
