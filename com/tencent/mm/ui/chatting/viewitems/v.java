package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.viewitems.b.a;

public final class v {

    static class b extends a {
        TextView eVw;
        TextView ubY;
        TextView ucQ;
        View ucR;
        ImageView ucS;
        ImageView ucT;
        TextView ucU;
        TextView ucV;

        b() {
        }

        public final a dG(View view) {
            super.dx(view);
            this.hrs = (TextView) view.findViewById(R.h.chatting_time_tv);
            this.ubY = (TextView) view.findViewById(R.h.chatting_type_tv);
            this.eVw = (TextView) view.findViewById(R.h.chatting_username_tv);
            this.ucQ = (TextView) view.findViewById(R.h.chatting_content_itv);
            this.hrH = view.findViewById(R.h.chatting_click_area);
            this.ucV = (TextView) view.findViewById(R.h.chatting_mobliename_tv);
            this.ucR = view.findViewById(R.h.chatting_from_message_add_layout);
            this.ucS = (ImageView) view.findViewById(R.h.chatfrom_bg_fmessage_okicon_iv);
            this.ucT = (ImageView) view.findViewById(R.h.chatting_from_message_add_plus);
            this.ucU = (TextView) view.findViewById(R.h.chatfrom_bg_fmessage_okicon_tv);
            this.jBR = (CheckBox) view.findViewById(R.h.chatting_checkbox);
            this.gFD = view.findViewById(R.h.chatting_maskview);
            return this;
        }
    }
}
