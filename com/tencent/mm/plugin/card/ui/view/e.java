package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.c.kz;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends i {
    private View hHx;

    public final void initView() {
    }

    public final void update() {
        b ayu = this.hHF.ayu();
        kz kzVar = ayu.awm().rnU;
        if (kzVar != null) {
            x.i("MicroMsg.CardAnnoucementView", "card tp annoucement  endtime: " + kzVar.mXw);
            x.i("MicroMsg.CardAnnoucementView", "card tp annoucement  text: " + kzVar.text);
            x.i("MicroMsg.CardAnnoucementView", "card tp annoucement  thumb_url: " + kzVar.rnt);
        }
        if (kzVar != null && !TextUtils.isEmpty(kzVar.text) && ayu.awk()) {
            if (this.hHx == null) {
                this.hHx = ((ViewStub) findViewById(d.card_annoucement_layout_stub)).inflate();
            }
            ((TextView) this.hHx.findViewById(d.public_notice)).setText(kzVar.text);
            this.hHx.setOnClickListener(this.hHF.ayy());
        } else if (this.hHx != null) {
            this.hHx.setVisibility(8);
        }
    }

    public final void azI() {
        if (this.hHx != null) {
            this.hHx.setVisibility(8);
        }
    }
}
