package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.viewitems.b.a;

public final class ad {

    static class c extends a {
        TextView jet;
        TextView ucQ;

        c() {
        }

        public final a dG(View view) {
            super.dx(view);
            this.hrs = (TextView) view.findViewById(R.h.chatting_time_tv);
            this.mQc = (TextView) view.findViewById(R.h.chatting_user_tv);
            this.ucQ = (TextView) view.findViewById(R.h.chatting_content_itv);
            this.jet = (TextView) view.findViewById(R.h.chatting_qamsg_source_tv);
            this.jBR = (CheckBox) view.findViewById(R.h.chatting_checkbox);
            this.gFD = view.findViewById(R.h.chatting_maskview);
            return this;
        }
    }
}
