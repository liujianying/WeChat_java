package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.viewitems.b.a;

final class bb extends a {
    TextView eCn;

    bb() {
    }

    public final a dN(View view) {
        super.dx(view);
        this.hrs = (TextView) view.findViewById(R.h.chatting_time_tv);
        this.mQc = (TextView) view.findViewById(R.h.chatting_user_tv);
        this.eCn = (TextView) view.findViewById(R.h.chatting_content_itv);
        this.jBR = (CheckBox) view.findViewById(R.h.chatting_checkbox);
        this.gFD = view.findViewById(R.h.chatting_maskview);
        return this;
    }
}
