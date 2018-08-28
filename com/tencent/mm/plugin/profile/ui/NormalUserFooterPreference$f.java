package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.l.a;

class NormalUserFooterPreference$f extends NormalUserFooterPreference$a {
    final /* synthetic */ NormalUserFooterPreference lXw;

    public NormalUserFooterPreference$f(NormalUserFooterPreference normalUserFooterPreference) {
        this.lXw = normalUserFooterPreference;
        super(normalUserFooterPreference);
    }

    protected final void bnC() {
        if (NormalUserFooterPreference.a(this.lXw) == null || !a.gd(NormalUserFooterPreference.a(this.lXw).field_type)) {
            z(false, true);
        } else {
            bnB();
        }
    }

    protected final void bnA() {
        NormalUserFooterPreference.r(this.lXw).setVisibility(8);
        NormalUserFooterPreference.s(this.lXw).setVisibility(0);
        NormalUserFooterPreference.t(this.lXw).setVisibility(8);
        NormalUserFooterPreference.f(this.lXw).setVisibility(8);
        NormalUserFooterPreference.g(this.lXw).setVisibility(8);
        NormalUserFooterPreference.h(this.lXw).setVisibility(8);
        NormalUserFooterPreference.k(this.lXw).setVisibility(8);
        NormalUserFooterPreference.q(this.lXw).setVisibility(8);
        NormalUserFooterPreference.A(this.lXw).setOnClickListener(new 1(this));
    }
}
