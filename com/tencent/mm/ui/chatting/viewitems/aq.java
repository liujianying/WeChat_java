package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.viewitems.b.a;

final class aq extends a {
    protected TextView eCn;
    protected TextView ufj;
    protected TextView ufk;
    protected Button ufl;
    protected Button ufm;
    protected ImageView ufn;

    aq() {
    }

    public final aq dL(View view) {
        super.dx(view);
        this.eCn = (TextView) view.findViewById(R.h.chatting_appmsg_desc_tv);
        this.ufj = (TextView) view.findViewById(R.h.chatting_appmsg_date_tv);
        this.ufk = (TextView) view.findViewById(R.h.chatting_appmsg_time_tv);
        this.ufl = (Button) view.findViewById(R.h.chatting_item_voiceremind_play);
        this.ufm = (Button) view.findViewById(R.h.chatting_item_voiceremind_del);
        this.ufn = (ImageView) view.findViewById(R.h.chatting_timeout_icon);
        this.jBR = (CheckBox) view.findViewById(R.h.chatting_checkbox);
        this.gFD = view.findViewById(R.h.chatting_maskview);
        return this;
    }
}
