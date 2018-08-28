package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.a$g;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.e$a;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.ui.MMActivity;

public final class o extends i {
    private View hHW;
    private ImageView hHX;
    private TextView hHY;
    private TextView hHZ;

    public final void initView() {
        this.hHW = findViewById(d.from_username_layout);
        this.hHX = (ImageView) findViewById(d.from_username_avatar);
        this.hHY = (TextView) findViewById(d.from_username_tv);
        this.hHZ = (TextView) findViewById(d.from_username_tips);
        this.hHW.setVisibility(8);
    }

    public final void update() {
        b ayu = this.hHF.ayu();
        MMActivity ayx = this.hHF.ayx();
        e$a ayB = this.hHF.ayB();
        this.hHW.setVisibility(0);
        this.hHY.setText(j.a(ayx, ((i) g.l(i.class)).FR().Yg(ayB.hBD).BK(), this.hHY.getTextSize()));
        if (ayu.awo() != null && !TextUtils.isEmpty(ayu.awo().sli)) {
            this.hHZ.setText(j.a(ayx, ayu.awo().sli, this.hHZ.getTextSize()));
        } else if (TextUtils.isEmpty(ayu.awm().hwg)) {
            this.hHZ.setText(ayx.getString(a$g.card_gift_tips, new Object[]{this.hHF.ayC().getTitle()}));
        } else {
            this.hHZ.setText(ayx.getString(a$g.card_gift_tips, new Object[]{ayu.awm().hwg}));
        }
        a.b.a(this.hHX, ayB.hBD);
        this.hHX.setOnClickListener(this.hHF.ayy());
    }

    public final void azI() {
        this.hHW.setVisibility(8);
    }
}
