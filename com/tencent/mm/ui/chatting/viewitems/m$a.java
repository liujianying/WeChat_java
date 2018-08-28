package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.viewitems.b.a;
import com.tencent.mm.ui.widget.MMNeatTextView;

final class m$a extends a {
    protected TextView jet;
    protected ProgressBar mgA;
    protected TextView tZU;
    protected ImageView tZv;
    protected MMNeatTextView uby;

    m$a() {
    }

    public final m$a dE(View view) {
        super.dx(view);
        this.uby = (MMNeatTextView) view.findViewById(R.h.chatting_content_itv);
        this.mgA = (ProgressBar) view.findViewById(R.h.uploading_pb);
        this.tZv = (ImageView) view.findViewById(R.h.chatting_state_iv);
        this.jet = (TextView) view.findViewById(R.h.chatting_appmsg_source_tv);
        this.tZU = (TextView) view.findViewById(R.h.chatting_appmsg_comment_tv);
        this.mQc = (TextView) view.findViewById(R.h.chatting_user_tv);
        this.jBR = (CheckBox) view.findViewById(R.h.chatting_checkbox);
        this.gFD = view.findViewById(R.h.chatting_maskview);
        return this;
    }
}
