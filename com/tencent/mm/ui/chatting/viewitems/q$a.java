package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.chatting.viewitems.b.a;

class q$a extends a {
    TextView eTm;
    ImageView uai;
    public int uau;
    ImageView ubX;
    TextView ubY;
    TextView ubZ;

    q$a() {
    }

    public final a q(View view, boolean z) {
        super.dx(view);
        this.ubX = (ImageView) view.findViewById(R.h.chatting_avatar_iv_card);
        this.hrs = (TextView) view.findViewById(R.h.chatting_time_tv);
        this.ubY = (TextView) view.findViewById(R.h.chatting_type_tv);
        this.ubZ = (TextView) view.findViewById(R.h.chatting_username_tv);
        this.eTm = (TextView) view.findViewById(R.h.chatting_nickname_tv);
        this.mQc = (TextView) view.findViewById(R.h.chatting_user_tv);
        this.hrH = view.findViewById(R.h.chatting_click_area);
        this.jBR = (CheckBox) view.findViewById(R.h.chatting_checkbox);
        this.gFD = view.findViewById(R.h.chatting_maskview);
        if (!z) {
            this.tZv = (ImageView) view.findViewById(R.h.chatting_state_iv);
            this.uai = (ImageView) view.findViewById(R.h.chatting_status_tick);
            this.mgA = (ProgressBar) view.findViewById(R.h.uploading_pb);
        }
        this.uau = b.gP(ad.getContext());
        return this;
    }
}
