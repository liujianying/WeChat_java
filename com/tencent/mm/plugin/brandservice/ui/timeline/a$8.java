package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ac.z;
import com.tencent.mm.plugin.brandservice.ui.timeline.g.a;
import com.tencent.mm.storage.q;

class a$8 implements OnClickListener {
    final /* synthetic */ a hqX;

    a$8(a aVar) {
        this.hqX = aVar;
    }

    public final void onClick(View view) {
        q qVar = (q) view.getTag();
        qVar.field_isExpand = true;
        z.Ne().d(qVar);
        a aVar = (a) a.h(this.hqX).hsb.get(Long.valueOf(qVar.field_msgId));
        if (aVar != null) {
            aVar.rjq = 1;
            aVar.rjr = aVar.rjo;
        }
    }
}
