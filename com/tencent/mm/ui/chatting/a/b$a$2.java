package com.tencent.mm.ui.chatting.a;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.ui.chatting.a.b.a;

class b$a$2 implements OnLongClickListener {
    final /* synthetic */ a tNV;

    b$a$2(a aVar) {
        this.tNV = aVar;
    }

    public final boolean onLongClick(View view) {
        if (b.cul() != null) {
            int intValue = ((Integer) view.getTag()).intValue();
            b.cul().a(view, intValue, b.cum().EZ(intValue));
        }
        return true;
    }
}
