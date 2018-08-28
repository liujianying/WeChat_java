package com.tencent.mm.ui.contact;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.s;

class MMBaseSelectContactUI$4 implements OnScrollListener {
    final /* synthetic */ MMBaseSelectContactUI ukl;

    MMBaseSelectContactUI$4(MMBaseSelectContactUI mMBaseSelectContactUI) {
        this.ukl = mMBaseSelectContactUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i != 0) {
            this.ukl.YC();
            this.ukl.cyw();
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (!(this.ukl.Wk() || MMBaseSelectContactUI.d(this.ukl) == null)) {
            View childAt = MMBaseSelectContactUI.e(this.ukl).getChildAt(MMBaseSelectContactUI.e(this.ukl).getFirstVisiblePosition());
            if (childAt == null || childAt.getTop() != 0) {
                MMBaseSelectContactUI.f(this.ukl).setVisibility(0);
            } else {
                MMBaseSelectContactUI.f(this.ukl).setVisibility(8);
            }
        }
        if (i >= 2) {
            g.Ek();
            if (!bi.d((Boolean) g.Ei().DT().get(12296, null))) {
                g.Ek();
                g.Ei().DT().set(12296, Boolean.valueOf(true));
                if (MMBaseSelectContactUI.g(this.ukl) != null) {
                    MMBaseSelectContactUI.g(this.ukl).dismiss();
                }
                MMBaseSelectContactUI.a(this.ukl, s.a(this.ukl, this.ukl.getString(h.main_slide_toast), 4000));
            }
        }
    }
}
