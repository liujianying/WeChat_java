package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.amn;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.v;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;

public class HoneyPayCardLayout extends LinearLayout {
    private ImageView hVP;
    private String kkc;
    private TextView kku;
    private TextView kkv;
    private WalletTextView kkw;
    private TextView kkx;
    private CdnImageView kky;

    public HoneyPayCardLayout(Context context) {
        super(context);
        init();
    }

    public HoneyPayCardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public HoneyPayCardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        View inflate = inflate(getContext(), a$g.honey_pay_card_layout, this);
        this.hVP = (ImageView) inflate.findViewById(a$f.hpcl_avatar_iv);
        this.kkw = (WalletTextView) inflate.findViewById(a$f.hpcl_quota_tv);
        this.kku = (TextView) inflate.findViewById(a$f.hpcl_username_tv);
        this.kkv = (TextView) inflate.findViewById(a$f.hpcl_remain_tv);
        this.kkx = (TextView) inflate.findViewById(a$f.hpcl_card_type_tv);
        this.kky = (CdnImageView) inflate.findViewById(a$f.hpcl_card_type_iv);
        this.kkw.setPrefix(v.cDm());
    }

    public void setCardRecord(amn amn) {
        long j = 0;
        this.kkc = amn.rIw;
        this.kkx.setText(amn.hwg);
        if (!bi.oW(amn.bWP)) {
            this.kky.cS(amn.bWP, c.rh(amn.huV));
        }
        b.a(this.hVP, amn.rrW, 0.06f, false);
        e.f(this.kku, amn.rrW);
        this.kkw.setText(c.dK(amn.ruW));
        if (amn.rPk == 0) {
            this.kkv.setTextColor(Color.parseColor("#FA9D3B"));
            this.kkv.setText(i.honey_pay_waiting_for_receive);
        } else if (amn.rPk != 1) {
            x.w("MicroMsg.HoneyPayCardLayout", "unknown rcvd: %s", new Object[]{Integer.valueOf(amn.rPk)});
        } else if (amn.rPm == 0) {
            long j2 = amn.rPl;
            if (j2 < 0) {
                x.w("MicroMsg.HoneyPayCardLayout", "unused quota wrong: %s", new Object[]{Long.valueOf(j2)});
            } else {
                j = j2;
            }
            this.kkv.setText(getContext().getString(i.honey_pay_used_month, new Object[]{v.cDm() + c.dK(j)}));
        } else {
            x.i("MicroMsg.HoneyPayCardLayout", "show check detail");
            this.kkv.setText("");
        }
    }
}
