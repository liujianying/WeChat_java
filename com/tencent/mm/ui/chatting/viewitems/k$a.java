package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.viewitems.b.a;

class k$a extends a {
    protected TextView ubq;

    k$a() {
    }

    public final k$a dC(View view) {
        super.dx(view);
        this.ubq = (TextView) view.findViewById(R.h.location_share_content);
        this.mQc = (TextView) view.findViewById(R.h.chatting_user_tv);
        this.jBR = (CheckBox) view.findViewById(R.h.chatting_checkbox);
        this.gFD = view.findViewById(R.h.chatting_maskview);
        return this;
    }
}
