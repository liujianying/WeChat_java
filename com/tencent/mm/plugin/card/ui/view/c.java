package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.base.b;

public final class c extends i {
    private View hHs;
    private TextView hHt;

    public final void initView() {
    }

    public final void update() {
        if (this.hHs == null) {
            this.hHs = ((ViewStub) findViewById(d.card_ad_title_layout_stub)).inflate();
            this.hHt = (TextView) this.hHs.findViewById(d.card_ad_title_tv);
        }
        this.hHs.setVisibility(0);
        this.hHs.setOnClickListener(this.hHF.ayy());
        b ayu = this.hHF.ayu();
        if (TextUtils.isEmpty(ayu.awm().rnY.rvA)) {
            this.hHt.setText(getString(g.card_membership_right_see_default_wording));
        } else {
            this.hHt.setText(ayu.awm().rnY.rvA);
        }
    }

    public final void azI() {
        if (this.hHs != null) {
            this.hHs.setVisibility(8);
        }
    }
}
