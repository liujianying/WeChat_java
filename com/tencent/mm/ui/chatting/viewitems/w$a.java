package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.viewitems.b.a;

final class w$a extends a {
    protected TextView ucY;
    protected TextView ucZ;
    protected TextView uda;
    protected TextView udb;
    protected TextView udc;
    protected TextView udd;
    protected ImageView ude;
    final /* synthetic */ w udf;

    w$a(w wVar) {
        this.udf = wVar;
    }

    public final w$a dH(View view) {
        super.dx(view);
        this.ucY = (TextView) view.findViewById(R.h.step_number);
        this.uda = (TextView) view.findViewById(R.h.rank_number);
        this.ucZ = (TextView) view.findViewById(R.h.step_number_tip);
        this.udb = (TextView) view.findViewById(R.h.rank_number_tip);
        this.udc = (TextView) view.findViewById(R.h.view_rank_tip);
        this.udd = (TextView) view.findViewById(R.h.hard_device_spilter);
        this.jBR = (CheckBox) view.findViewById(R.h.chatting_checkbox);
        this.ude = (ImageView) view.findViewById(R.h.view_avatar);
        return this;
    }
}
