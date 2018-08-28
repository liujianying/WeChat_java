package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public final class y extends i {
    private MMActivity gKS;
    private View hIo;
    private b htQ;

    public final void initView() {
        this.gKS = this.hHF.ayx();
    }

    public final void update() {
        this.htQ = this.hHF.ayu();
        if (this.hIo == null) {
            this.hIo = ((ViewStub) findViewById(d.card_status_layout_stub)).inflate();
        }
        if (this.htQ.avV()) {
            this.hIo.setBackgroundDrawable(l.A(this.gKS, this.gKS.getResources().getColor(a.card_bottom_container_normal_color)));
        }
        TextView textView = (TextView) this.hIo.findViewById(d.card_status_tv);
        if (this.htQ.awn() == null) {
            x.e("MicroMsg.CardStatusView", "updateState() mCardInfo.getDataInfo() == null");
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setTextColor(this.gKS.getResources().getColor(a.grey_background_text_color));
        if (TextUtils.isEmpty(this.htQ.awm().roe)) {
            m.b(textView, this.htQ.awn().status);
        } else {
            textView.setText(this.htQ.awm().roe);
        }
    }

    public final void azI() {
        if (this.hIo != null) {
            this.hIo.setVisibility(8);
        }
    }
}
