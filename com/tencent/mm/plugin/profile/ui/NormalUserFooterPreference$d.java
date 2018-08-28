package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.model.s;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a;
import junit.framework.Assert;

class NormalUserFooterPreference$d extends a {
    final /* synthetic */ NormalUserFooterPreference lXw;

    public NormalUserFooterPreference$d(NormalUserFooterPreference normalUserFooterPreference) {
        this.lXw = normalUserFooterPreference;
        super(normalUserFooterPreference);
    }

    protected final void bnC() {
    }

    protected final void bnA() {
        Assert.assertTrue(s.hr(NormalUserFooterPreference.a(this.lXw).field_username));
        NormalUserFooterPreference.r(this.lXw).setVisibility(8);
        NormalUserFooterPreference.s(this.lXw).setVisibility(8);
        NormalUserFooterPreference.t(this.lXw).setVisibility(8);
        NormalUserFooterPreference.f(this.lXw).setVisibility(0);
        NormalUserFooterPreference.g(this.lXw).setVisibility(8);
        NormalUserFooterPreference.h(this.lXw).setVisibility(8);
        NormalUserFooterPreference.k(this.lXw).setVisibility(8);
        NormalUserFooterPreference.q(this.lXw).setVisibility(8);
    }
}
