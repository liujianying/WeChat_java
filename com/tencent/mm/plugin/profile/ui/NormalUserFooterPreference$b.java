package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.l.a;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;

class NormalUserFooterPreference$b extends c {
    final /* synthetic */ NormalUserFooterPreference lXw;

    public NormalUserFooterPreference$b(NormalUserFooterPreference normalUserFooterPreference) {
        this.lXw = normalUserFooterPreference;
        super(normalUserFooterPreference);
    }

    protected final void bnC() {
        if (NormalUserFooterPreference.a(this.lXw) == null) {
            x.e("MicroMsg.NormalUserFooterPreference", "contact is null in NearByFriendHandler");
        } else if (a.gd(NormalUserFooterPreference.a(this.lXw).field_type) && (!a.gd(NormalUserFooterPreference.a(this.lXw).field_type) || !ab.gY(NormalUserFooterPreference.a(this.lXw).field_username))) {
            bnB();
        } else if (ab.gY(NormalUserFooterPreference.a(this.lXw).field_username)) {
            z(true, true);
        } else {
            z(false, true);
        }
    }

    protected final void bnA() {
        NormalUserFooterPreference.r(this.lXw).setVisibility(8);
        if (!a.gd(NormalUserFooterPreference.a(this.lXw).field_type) || (a.gd(NormalUserFooterPreference.a(this.lXw).field_type) && ab.gY(NormalUserFooterPreference.a(this.lXw).field_username))) {
            NormalUserFooterPreference.s(this.lXw).setVisibility(0);
            NormalUserFooterPreference.f(this.lXw).setVisibility(8);
            NormalUserFooterPreference.g(this.lXw).setVisibility(8);
        } else {
            NormalUserFooterPreference.s(this.lXw).setVisibility(8);
            NormalUserFooterPreference.f(this.lXw).setVisibility(0);
            if (!(this.lXw.bnx() || NormalUserFooterPreference.a(this.lXw).field_username.equals(q.GF()))) {
                NormalUserFooterPreference.h(this.lXw).setVisibility(0);
                NormalUserFooterPreference.t(this.lXw).setVisibility(8);
                NormalUserFooterPreference.k(this.lXw).setVisibility(8);
                NormalUserFooterPreference.q(this.lXw).setVisibility(8);
                if (NormalUserFooterPreference.B(this.lXw)) {
                    NormalUserFooterPreference.s(this.lXw).setVisibility(8);
                    NormalUserFooterPreference.t(this.lXw).setVisibility(0);
                    NormalUserFooterPreference.t(this.lXw).setOnClickListener(new 1(this));
                }
                NormalUserFooterPreference.A(this.lXw).setOnClickListener(new 2(this));
            }
        }
        NormalUserFooterPreference.h(this.lXw).setVisibility(8);
        NormalUserFooterPreference.t(this.lXw).setVisibility(8);
        NormalUserFooterPreference.k(this.lXw).setVisibility(8);
        NormalUserFooterPreference.q(this.lXw).setVisibility(8);
        if (NormalUserFooterPreference.B(this.lXw)) {
            NormalUserFooterPreference.s(this.lXw).setVisibility(8);
            NormalUserFooterPreference.t(this.lXw).setVisibility(0);
            NormalUserFooterPreference.t(this.lXw).setOnClickListener(new 1(this));
        }
        NormalUserFooterPreference.A(this.lXw).setOnClickListener(new 2(this));
    }
}
