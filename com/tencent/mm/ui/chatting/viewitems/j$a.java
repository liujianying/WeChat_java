package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.viewitems.b.a;

class j$a extends a {
    protected ImageView jBN;
    protected ImageView jBT;
    protected View jck;
    protected TextView jet;
    protected TextView tZU;
    protected TextView ubk;
    protected ImageView ubl;

    j$a() {
    }

    public final j$a dB(View view) {
        super.dx(view);
        this.jBN = (ImageView) view.findViewById(R.h.chatting_appmsg_thumb_iv);
        this.jet = (TextView) view.findViewById(R.h.chatting_appmsg_source_tv);
        this.ubk = (TextView) view.findViewById(R.h.chatting_appmsg_progress);
        this.jck = view.findViewById(R.h.chatting_appmsg_progress_area);
        this.tZU = (TextView) view.findViewById(R.h.chatting_appmsg_comment_tv);
        this.mQc = (TextView) view.findViewById(R.h.chatting_user_tv);
        this.ubl = (ImageView) view.findViewById(R.h.chatting_appmsg_refuse_iv);
        this.jBR = (CheckBox) view.findViewById(R.h.chatting_checkbox);
        this.gFD = view.findViewById(R.h.chatting_maskview);
        this.jBT = (ImageView) view.findViewById(R.h.chatting_content_mask_iv);
        return this;
    }
}
