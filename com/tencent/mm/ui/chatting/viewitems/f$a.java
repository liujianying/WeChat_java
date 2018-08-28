package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.viewitems.b.a;

class f$a extends a {
    public TextView uaU;

    f$a() {
    }

    public final f$a dA(View view) {
        super.dx(view);
        this.hrs = (TextView) this.jEz.findViewById(R.h.chatting_time_tv);
        this.jBR = (CheckBox) this.jEz.findViewById(R.h.chatting_checkbox);
        this.gFD = this.jEz.findViewById(R.h.chatting_maskview);
        this.mQc = (TextView) this.jEz.findViewById(R.h.chatting_user_tv);
        this.uaU = (TextView) this.jEz.findViewById(R.h.appmsg_c2c_newyear_actiontext);
        return this;
    }
}
