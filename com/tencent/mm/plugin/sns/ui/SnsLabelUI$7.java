package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.label.a.a;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.ArrayList;

class SnsLabelUI$7 implements Runnable {
    final /* synthetic */ SnsLabelUI nXL;
    final /* synthetic */ String nXO;

    SnsLabelUI$7(SnsLabelUI snsLabelUI, String str) {
        this.nXL = snsLabelUI;
        this.nXO = str;
    }

    public final void run() {
        SnsLabelUI.a(this.nXL, (ArrayList) a.aYK().aYF());
        if (SnsLabelUI.j(this.nXL) == null) {
            SnsLabelUI.a(this.nXL, new ArrayList());
        }
        int i;
        if (bi.oW(this.nXO)) {
            i = -1;
        } else {
            if (!SnsLabelUI.j(this.nXL).contains(this.nXO)) {
                SnsLabelUI.j(this.nXL).add(this.nXO);
            }
            i = SnsLabelUI.j(this.nXL).indexOf(this.nXO);
        }
        SnsLabelUI.a(this.nXL).O(SnsLabelUI.j(this.nXL));
        SnsLabelUI.a(this.nXL).nXR = SnsLabelUI.k(this.nXL);
        if (!bi.oW(this.nXO) && i != -1) {
            if (SnsLabelUI.k(this.nXL) == 2) {
                SnsLabelUI.a(this.nXL).nXT.add(this.nXO);
                SnsLabelUI.a(this.nXL).nXV.clear();
            } else if (SnsLabelUI.k(this.nXL) == 3) {
                SnsLabelUI.a(this.nXL).nXU.add(this.nXO);
                SnsLabelUI.a(this.nXL).nXW.clear();
            }
            SnsLabelUI.a(this.nXL).notifyDataSetChanged();
            SnsLabelUI.g(this.nXL).expandGroup(SnsLabelUI.k(this.nXL));
        }
    }
}
