package com.tencent.mm.view.e;

import android.text.TextUtils;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.x;

class a$4 implements a {
    final /* synthetic */ a uWa;

    a$4(a aVar) {
        this.uWa = aVar;
    }

    public final void a(String str, l lVar) {
        if (!TextUtils.isEmpty(str)) {
            if (str.equals("event_update_group") || str.equalsIgnoreCase("productID")) {
                x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "modify emoji group .");
                this.uWa.cCw();
            }
        }
    }
}
