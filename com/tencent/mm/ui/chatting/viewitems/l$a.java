package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.wallet.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.chatting.viewitems.b.a;

class l$a extends a {
    public int uau = 0;
    public ImageView ubr;
    public TextView ubs;
    public TextView ubt;

    l$a() {
    }

    public final l$a dD(View view) {
        super.dx(view);
        this.hrs = (TextView) this.jEz.findViewById(R.h.chatting_time_tv);
        this.jBR = (CheckBox) this.jEz.findViewById(R.h.chatting_checkbox);
        this.gFD = this.jEz.findViewById(R.h.chatting_maskview);
        this.mQc = (TextView) this.jEz.findViewById(R.h.chatting_user_tv);
        this.ubr = (ImageView) this.jEz.findViewById(R.h.appmsg_remittance_icon);
        this.ubs = (TextView) this.jEz.findViewById(R.h.appmsg_remittance_title);
        this.ubt = (TextView) this.jEz.findViewById(R.h.appmsg_remittance_desc);
        this.uau = b.gP(ad.getContext());
        this.ubt.setTypeface(((b) g.l(b.class)).dR(this.jEz.getContext()));
        return this;
    }
}
