package com.tencent.mm.plugin.card.ui.view;

import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.protocal.c.pr;

public final class z extends i {
    private View hIp;

    public final void initView() {
    }

    public final void update() {
        if (this.hIp == null) {
            this.hIp = ((ViewStub) findViewById(d.card_third_field_layout_stub)).inflate();
        }
        pr prVar = this.hHF.ayu().awn().rnh;
        if (this.hIp != null) {
            ((TextView) this.hIp.findViewById(d.thid_field_title)).setText(prVar.title);
            ((TextView) this.hIp.findViewById(d.thid_field_sub_title)).setText(prVar.huX);
            int i = (this.hHF.ayz().azb() && this.hHF.ayz().azc()) ? 0 : 1;
            if (i != 0) {
                ((LayoutParams) ((LinearLayout) this.hIp).getLayoutParams()).bottomMargin = 0;
            } else {
                ((LayoutParams) ((LinearLayout) this.hIp).getLayoutParams()).bottomMargin = this.hHF.ayx().getResources().getDimensionPixelSize(b.SettingCatalogPadding);
            }
        }
    }

    public final void azI() {
        if (this.hIp != null) {
            this.hIp.setVisibility(8);
        }
    }
}
