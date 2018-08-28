package com.tencent.mm.plugin.sns.ui;

import java.util.HashSet;
import java.util.Iterator;

class SnsLabelUI$10 implements Runnable {
    final /* synthetic */ SnsLabelUI nXL;

    SnsLabelUI$10(SnsLabelUI snsLabelUI) {
        this.nXL = snsLabelUI;
    }

    public final void run() {
        SnsLabelUI.a(this.nXL).nXR = SnsLabelUI.k(this.nXL);
        if (SnsLabelUI.j(this.nXL) == null) {
            SnsLabelUI.a(this.nXL, SnsLabelUI.b(this.nXL));
        } else {
            SnsLabelUI.j(this.nXL).addAll(SnsLabelUI.b(this.nXL));
        }
        if (SnsLabelUI.b(this.nXL) != null) {
            Iterator it = SnsLabelUI.b(this.nXL).iterator();
            while (it.hasNext()) {
                SnsLabelUI.a(this.nXL);
                aq.NW((String) it.next());
            }
        }
        Object hashSet = new HashSet(SnsLabelUI.j(this.nXL));
        SnsLabelUI.j(this.nXL).clear();
        SnsLabelUI.j(this.nXL).addAll(hashSet);
        SnsLabelUI.a(this.nXL).O(SnsLabelUI.j(this.nXL));
        SnsLabelUI.a(this.nXL).notifyDataSetChanged();
        SnsLabelUI.g(this.nXL).Gw(SnsLabelUI.a(this.nXL).nXR);
        if (SnsLabelUI.b(this.nXL) != null) {
            SnsLabelUI.b(this.nXL).clear();
        }
        SnsLabelUI.n(this.nXL);
        hashSet.clear();
        if (SnsLabelUI.o(this.nXL) != null && SnsLabelUI.o(this.nXL).isShowing()) {
            SnsLabelUI.o(this.nXL).dismiss();
        }
    }
}
