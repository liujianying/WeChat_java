package com.tencent.mm.plugin.kitchen.ui;

import com.tencent.mm.plugin.kitchen.ui.KvInfoUI.2;
import com.tencent.mm.ui.widget.picker.b;
import com.tencent.mm.ui.widget.picker.b.a;
import java.util.ArrayList;

class KvInfoUI$2$1 implements a {
    final /* synthetic */ b gQT;
    final /* synthetic */ ArrayList kAt;
    final /* synthetic */ 2 kAu;

    KvInfoUI$2$1(2 2, b bVar, ArrayList arrayList) {
        this.kAu = 2;
        this.gQT = bVar;
        this.kAt = arrayList;
    }

    public final void h(boolean z, Object obj) {
        this.gQT.hide();
        KvInfoUI.a(this.kAu.kAs, (String) this.kAt.get(this.gQT.cAP()));
    }
}
