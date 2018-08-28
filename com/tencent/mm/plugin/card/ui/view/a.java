package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.b.f;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.ui.MMActivity;

public final class a extends i {
    private View hHm;

    public final void initView() {
        this.hHm = findViewById(d.card_accept_header_layout);
    }

    public final void update() {
        g ayz = this.hHF.ayz();
        b ayu = this.hHF.ayu();
        MMActivity ayx = this.hHF.ayx();
        com.tencent.mm.plugin.card.ui.e.a ayB = this.hHF.ayB();
        f ayC = this.hHF.ayC();
        if (ayz.azs()) {
            this.hHm.setVisibility(0);
            findViewById(d.accept_header_from_username_container).setVisibility(0);
            ImageView imageView = (ImageView) findViewById(d.accept_header_from_username_avatar);
            TextView textView = (TextView) findViewById(d.accept_header_from_username_tv);
            TextView textView2 = (TextView) findViewById(d.accept_ui_title);
            if (ayB.hBD != null) {
                textView.setText(j.a(ayx, ((i) com.tencent.mm.kernel.g.l(i.class)).FR().Yg(ayB.hBD).BK(), textView.getTextSize()));
            }
            if (ayB.hop == 23) {
                if (!TextUtils.isEmpty(ayu.awm().rog)) {
                    textView2.setText(ayu.awm().rog);
                } else if (TextUtils.isEmpty(ayu.awm().hwg)) {
                    textView2.setText(ayx.getString(com.tencent.mm.plugin.card.a.g.card_recommend_tips, new Object[]{ayC.getTitle()}));
                } else {
                    textView2.setText(ayx.getString(com.tencent.mm.plugin.card.a.g.card_recommend_tips, new Object[]{ayu.awm().hwg}));
                }
            } else if (ayu.awo() != null && !TextUtils.isEmpty(ayu.awo().sli)) {
                textView2.setText(ayu.awo().sli);
            } else if (TextUtils.isEmpty(ayu.awm().hwg)) {
                textView2.setText(ayx.getString(com.tencent.mm.plugin.card.a.g.card_gift_tips, new Object[]{ayC.getTitle()}));
            } else {
                textView2.setText(ayx.getString(com.tencent.mm.plugin.card.a.g.card_gift_tips, new Object[]{ayu.awm().hwg}));
            }
            com.tencent.mm.pluginsdk.ui.a.b.a(imageView, ayB.hBD, 0.15f, false);
            imageView.setOnClickListener(this.hHF.ayy());
        } else if (!ayz.azt()) {
            azI();
        } else if (TextUtils.isEmpty(ayu.awm().rog)) {
            this.hHm.setVisibility(8);
        } else {
            this.hHm.setVisibility(0);
            findViewById(d.accept_header_from_username_container).setVisibility(8);
            ((TextView) findViewById(d.accept_ui_title)).setText(ayu.awm().rog);
        }
    }

    public final void azI() {
        this.hHm.setVisibility(8);
    }
}
