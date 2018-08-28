package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.g.b;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.ui.base.MultiTouchImageView.a;

class SnsInfoFlip$6 implements a {
    final /* synthetic */ SnsInfoFlip nXg;

    SnsInfoFlip$6(SnsInfoFlip snsInfoFlip) {
        this.nXg = snsInfoFlip;
    }

    public final void bDv() {
        if (SnsInfoFlip.g(this.nXg).getSelectedItem() != null && SnsInfoFlip.d(this.nXg) != null) {
            int selectedItemPosition = SnsInfoFlip.g(this.nXg).getSelectedItemPosition();
            n Nl = af.byo().Nl(((b) SnsInfoFlip.g(this.nXg).getSelectedItem()).nuP);
            if (Nl != null) {
                ax.d(Nl, selectedItemPosition);
            }
        }
    }

    public final void bDw() {
        if (SnsInfoFlip.g(this.nXg).getSelectedItem() != null && SnsInfoFlip.d(this.nXg) != null) {
            int selectedItemPosition = SnsInfoFlip.g(this.nXg).getSelectedItemPosition();
            n Nl = af.byo().Nl(((b) SnsInfoFlip.g(this.nXg).getSelectedItem()).nuP);
            if (Nl != null) {
                ax.e(Nl, selectedItemPosition);
            }
        }
    }
}
