package com.tencent.mm.ui.chatting.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.chatting.a.b.a;

class b$a$1 implements OnClickListener {
    final /* synthetic */ a tNV;

    b$a$1(a aVar) {
        this.tNV = aVar;
    }

    public final void onClick(View view) {
        if (b.cul() != null) {
            int intValue = ((Integer) view.getTag()).intValue();
            b.cul().a(intValue, b.cum().EZ(intValue));
        }
    }
}
