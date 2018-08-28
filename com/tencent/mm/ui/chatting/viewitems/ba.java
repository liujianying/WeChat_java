package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.viewitems.b.a;

final class ba extends a {
    protected TextView eCn;
    protected ImageView ugA;

    ba() {
    }

    public final ba dM(View view) {
        super.dx(view);
        this.eCn = (TextView) view.findViewById(R.h.chatting_appmsg_desc_tv);
        this.ugA = (ImageView) view.findViewById(R.h.chatting_appmsg_thumb_iv);
        this.jBR = (CheckBox) view.findViewById(R.h.chatting_checkbox);
        this.gFD = view.findViewById(R.h.chatting_maskview);
        return this;
    }
}
