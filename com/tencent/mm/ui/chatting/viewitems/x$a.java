package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.chatting.viewitems.b.a;

final class x$a extends a {
    protected ImageView eKk;
    protected NoMeasuredTextView udg;
    final /* synthetic */ x udh;

    x$a(x xVar) {
        this.udh = xVar;
    }

    public final x$a dI(View view) {
        super.dx(view);
        this.jBR = (CheckBox) view.findViewById(R.h.chatting_checkbox);
        this.eKk = (ImageView) view.findViewById(R.h.like_avatar);
        this.udg = (NoMeasuredTextView) view.findViewById(R.h.tip_msg);
        return this;
    }
}
