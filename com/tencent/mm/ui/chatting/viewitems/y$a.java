package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.viewitems.b.a;

final class y$a extends a {
    protected ImageView eKk;
    protected TextView udi;
    final /* synthetic */ y udj;

    y$a(y yVar) {
        this.udj = yVar;
    }

    public final y$a dJ(View view) {
        super.dx(view);
        this.jBR = (CheckBox) view.findViewById(R.h.chatting_checkbox);
        this.eKk = (ImageView) view.findViewById(R.h.push_avatar);
        this.udi = (TextView) view.findViewById(R.h.tip_msg);
        return this;
    }
}
