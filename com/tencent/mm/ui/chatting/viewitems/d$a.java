package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.chatting.viewitems.b.a;

class d$a extends a {
    public int maxSize = 0;
    public ImageView uaI;
    public TextView uaJ;
    public TextView uaK;
    public TextView uaL;
    public int uaM = 0;
    public int uau = 0;

    d$a() {
    }

    public final d$a dy(View view) {
        super.dx(view);
        this.hrs = (TextView) this.jEz.findViewById(R.h.chatting_time_tv);
        this.jBR = (CheckBox) this.jEz.findViewById(R.h.chatting_checkbox);
        this.gFD = this.jEz.findViewById(R.h.chatting_maskview);
        this.mQc = (TextView) this.jEz.findViewById(R.h.chatting_user_tv);
        this.uaI = (ImageView) this.jEz.findViewById(R.h.appmsg_c2c_icon);
        this.uaJ = (TextView) this.jEz.findViewById(R.h.appmsg_c2c_title);
        this.uaK = (TextView) this.jEz.findViewById(R.h.appmsg_c2c_desc);
        this.uaL = (TextView) this.jEz.findViewById(R.h.appmsg_c2c_tmpl_title);
        this.hrH = (LinearLayout) this.jEz.findViewById(R.h.chatting_click_area);
        this.uau = b.gP(ad.getContext());
        this.uaM = com.tencent.mm.bp.a.ad(ad.getContext(), R.f.ChatLucyTitleTextSize);
        this.maxSize = (int) (((float) com.tencent.mm.bp.a.ae(ad.getContext(), R.f.ChatLucyTitleTextSize)) * 1.45f);
        return this;
    }
}
