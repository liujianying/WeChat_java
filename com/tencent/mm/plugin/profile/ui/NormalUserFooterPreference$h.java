package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.R;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a;

class NormalUserFooterPreference$h extends a {
    final /* synthetic */ NormalUserFooterPreference lXw;

    public NormalUserFooterPreference$h(NormalUserFooterPreference normalUserFooterPreference) {
        this.lXw = normalUserFooterPreference;
        super(normalUserFooterPreference);
    }

    protected final void bnC() {
    }

    protected final void bnA() {
        NormalUserFooterPreference.r(this.lXw).setVisibility(8);
        NormalUserFooterPreference.f(this.lXw).setVisibility(0);
        if (this.lXw.bnx() || NormalUserFooterPreference.a(this.lXw).field_username.equals(q.GF()) || s.hO(NormalUserFooterPreference.a(this.lXw).field_username) || s.hH(NormalUserFooterPreference.a(this.lXw).field_username)) {
            NormalUserFooterPreference.h(this.lXw).setVisibility(8);
        } else {
            NormalUserFooterPreference.h(this.lXw).setVisibility(0);
        }
        NormalUserFooterPreference.f(this.lXw).setText(R.l.contact_info_send_privatemsg);
        NormalUserFooterPreference.t(this.lXw).setVisibility(8);
        NormalUserFooterPreference.s(this.lXw).setVisibility(8);
        NormalUserFooterPreference.q(this.lXw).setVisibility(8);
    }
}
