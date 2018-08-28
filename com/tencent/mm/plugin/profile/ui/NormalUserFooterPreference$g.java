package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.R;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a;
import junit.framework.Assert;

class NormalUserFooterPreference$g extends a {
    final /* synthetic */ NormalUserFooterPreference lXw;

    public NormalUserFooterPreference$g(NormalUserFooterPreference normalUserFooterPreference) {
        this.lXw = normalUserFooterPreference;
        super(normalUserFooterPreference);
    }

    public final void bnC() {
    }

    protected final void bnA() {
        boolean z = true;
        Assert.assertTrue(!q.gQ(NormalUserFooterPreference.a(this.lXw).field_username));
        if (s.hO(NormalUserFooterPreference.a(this.lXw).field_username)) {
            z = false;
        }
        Assert.assertTrue(z);
        NormalUserFooterPreference.r(this.lXw).setVisibility(8);
        NormalUserFooterPreference.s(this.lXw).setVisibility(8);
        NormalUserFooterPreference.f(this.lXw).setText(R.l.contact_info_send_to_room);
        NormalUserFooterPreference.f(this.lXw).setVisibility(0);
        NormalUserFooterPreference.h(this.lXw).setVisibility(8);
        NormalUserFooterPreference.t(this.lXw).setVisibility(8);
        NormalUserFooterPreference.q(this.lXw).setVisibility(8);
    }
}
