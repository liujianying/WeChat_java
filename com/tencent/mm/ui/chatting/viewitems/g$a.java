package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.viewitems.b.a;
import com.tencent.mm.ui.widget.MMTextView;

final class g$a extends a {
    View ern;
    MMTextView uaW;
    ImageView uai;

    g$a() {
    }

    public final a q(View view, boolean z) {
        super.dx(view);
        this.hrs = (TextView) view.findViewById(R.h.chatting_time_tv);
        this.mQc = (TextView) view.findViewById(R.h.chatting_user_tv);
        this.uaW = (MMTextView) view.findViewById(R.h.chatting_content_itv);
        this.jBR = (CheckBox) view.findViewById(R.h.chatting_checkbox);
        this.gFD = view.findViewById(R.h.chatting_maskview);
        this.ern = view.findViewById(R.h.chatting_content_area);
        if (!z) {
            this.uai = (ImageView) view.findViewById(R.h.chatting_status_tick);
            this.tZv = (ImageView) view.findViewById(R.h.chatting_state_iv);
            this.mgA = (ProgressBar) view.findViewById(R.h.uploading_pb);
        }
        return this;
    }
}
