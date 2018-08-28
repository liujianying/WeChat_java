package com.tencent.mm.ui.conversation;

import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.x;

class d$c implements b {
    final /* synthetic */ d uom;

    public final void a(int i, m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            x.d("MicroMsg.ConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
            return;
        }
        String str = (String) obj;
        if (!d.a(this.uom) && str != null && !str.equals("") && d.b(this.uom) != null && d.b(this.uom).containsKey(Integer.valueOf(i))) {
            d.b(this.uom).remove(Integer.valueOf(i));
            d.c(this.uom);
        }
    }
}
