package com.tencent.mm.plugin.honey_pay.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.alq;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class HoneyPaySelectCardTypeUI$a {
    public CdnImageView kkn;
    public TextView kkx;
    final /* synthetic */ HoneyPaySelectCardTypeUI kmj;
    public CdnImageView kmk;
    public TextView kml;
    public TextView kmm;
    public ImageView kmn;

    private HoneyPaySelectCardTypeUI$a(HoneyPaySelectCardTypeUI honeyPaySelectCardTypeUI) {
        this.kmj = honeyPaySelectCardTypeUI;
    }

    /* synthetic */ HoneyPaySelectCardTypeUI$a(HoneyPaySelectCardTypeUI honeyPaySelectCardTypeUI, byte b) {
        this(honeyPaySelectCardTypeUI);
    }

    final void a(View view, alq alq) {
        this.kmk = (CdnImageView) view.findViewById(f.hpsc_avatar_iv);
        this.kkx = (TextView) view.findViewById(f.hpsc_card_type_tv);
        this.kml = (TextView) view.findViewById(f.hpsc_card_type_desc_tv);
        this.kmn = (ImageView) view.findViewById(f.hpsc_arrow_iv);
        if (bi.oW(alq.bWP)) {
            this.kmk.setImageResource(c.rh(alq.huV));
        } else {
            this.kmk.cS(alq.bWP, c.rh(alq.huV));
        }
        this.kkx.setText(alq.hwg);
        this.kml.setText(alq.hyz);
        if (alq.rOf) {
            x.i("MicroMsg.HoneyPaySelectCardTypeUI", "disable this card");
            view.setEnabled(false);
            this.kkx.setEnabled(false);
            this.kml.setEnabled(false);
            this.kmn.setVisibility(8);
            return;
        }
        view.setOnClickListener(new 2(this, alq));
    }
}
