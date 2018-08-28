package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ak.a.a.c.a;
import com.tencent.mm.ak.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.protocal.c.sd;

public final class k extends i {
    private View hHG;

    public final void initView() {
    }

    public final void update() {
        if (this.hHG == null) {
            this.hHG = ((ViewStub) findViewById(d.card_detail_field_stub)).inflate();
        }
        this.hHG.setOnClickListener(this.hHF.ayy());
        sd sdVar = this.hHF.ayu().awm().rnY;
        if (TextUtils.isEmpty(sdVar.detail)) {
            findViewById(d.card_detail_desc_layout).setVisibility(8);
        } else {
            ((TextView) findViewById(d.card_detail_desc)).setText(sdVar.detail);
            findViewById(d.card_detail_desc_layout).setVisibility(0);
        }
        ImageView imageView = (ImageView) findViewById(d.card_detail_field_pic);
        if (sdVar.rvz == null || sdVar.rvz.size() <= 0 || TextUtils.isEmpty((CharSequence) sdVar.rvz.get(0))) {
            imageView.setVisibility(8);
            return;
        }
        String str = (String) sdVar.rvz.get(0);
        imageView.setVisibility(0);
        a aVar = new a();
        aVar.dXB = e.bnE;
        o.Pk();
        aVar.dXU = null;
        aVar.dXA = m.xr(str);
        aVar.dXy = true;
        aVar.dXW = false;
        aVar.dXw = true;
        o.Pj().a(str, imageView, aVar.Pt());
    }

    public final void azI() {
        if (this.hHG != null) {
            this.hHG.setVisibility(8);
        }
    }
}
