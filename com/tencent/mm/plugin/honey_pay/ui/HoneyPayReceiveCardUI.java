package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.honey_pay.a.e;
import com.tencent.mm.plugin.honey_pay.a.m;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.amp;
import com.tencent.mm.protocal.c.bdk;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h$a;
import com.tencent.mm.wallet_core.c.v;
import com.tencent.mm.wallet_core.ui.WalletTextView;

public class HoneyPayReceiveCardUI extends HoneyPayBaseUI {
    private int fdx;
    private String kkc;
    private ImageView klP;
    private TextView klQ;
    private WalletTextView klR;
    private TextView klS;
    private TextView klT;
    private TextView klU;
    private TextView klV;
    private TextView klW;
    private TextView klX;
    private TextView klY;
    private LinearLayout klZ;
    private CdnImageView kma;
    private g kmb = new 1(this);

    static /* synthetic */ void b(HoneyPayReceiveCardUI honeyPayReceiveCardUI) {
        x.i(honeyPayReceiveCardUI.TAG, "go to honey pay card detail");
        Intent intent = new Intent(honeyPayReceiveCardUI, HoneyPayCardDetailUI.class);
        intent.putExtra("key_scene", 0);
        intent.putExtra("key_card_no", honeyPayReceiveCardUI.kkc);
        honeyPayReceiveCardUI.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        this.kjV = c.honey_pay_grey_bg_2;
        super.onCreate(bundle);
        j.a(this.kmb);
        jr(2613);
        jr(1983);
        this.kkc = getIntent().getStringExtra("key_card_no");
        this.fdx = getIntent().getIntExtra("key_scene", 0);
        initView();
        if (this.fdx == 1) {
            bdk bdk = new bdk();
            try {
                bdk.aG(getIntent().getByteArrayExtra("key_qry_response"));
                a(bdk);
                if (bdk.rIz != null) {
                    setMMTitle(bdk.rIz.hwg);
                    return;
                }
                return;
            } catch (Throwable e) {
                x.printErrStackTrace(this.TAG, e, "", new Object[0]);
                aWf();
                return;
            }
        }
        aWf();
    }

    protected final void initView() {
        this.klP = (ImageView) findViewById(f.hprc_avatar_iv);
        this.klQ = (TextView) findViewById(f.hprc_payer_name_tv);
        this.klW = (TextView) findViewById(f.hprc_user_name_tv);
        this.klR = (WalletTextView) findViewById(f.hprc_quota_tv);
        this.klS = (TextView) findViewById(f.hprc_quota_desc_tv);
        this.klT = (TextView) findViewById(f.hprc_check_payway_tv);
        this.klU = (TextView) findViewById(f.hprc_receive_btn);
        this.klV = (TextView) findViewById(f.hprc_receive_tip_tv);
        this.klZ = (LinearLayout) findViewById(f.hprc_quota_layout);
        this.klX = (TextView) findViewById(f.hprc_wishing_tv);
        this.klY = (TextView) findViewById(f.hprc_explain_tv);
        this.kma = (CdnImageView) findViewById(f.hprc_quota_logo_1_iv);
        this.klR.setPrefix(v.cDm());
        this.klU.setOnClickListener(new 2(this));
    }

    public void onDestroy() {
        super.onDestroy();
        j.b(this.kmb);
        js(2613);
        js(1983);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (lVar instanceof m) {
            final m mVar = (m) lVar;
            mVar.a(new h$a() {
                public final void g(int i, int i2, String str, l lVar) {
                    HoneyPayReceiveCardUI.this.a(mVar.kjN);
                }
            }).b(new 4(this)).c(new 3(this));
        } else if (lVar instanceof e) {
            e eVar = (e) lVar;
            eVar.a(new 8(this, eVar)).b(new 7(this, eVar)).c(new 6(this));
        }
        return true;
    }

    protected final int getLayoutId() {
        return a.g.honey_pay_receive_card_ui;
    }

    private void a(bdk bdk) {
        if (bdk.rIz != null) {
            amp amp = bdk.rIz;
            this.klV.setText(amp.rPn);
            this.klX.setText(j.a(this.mController.tml, amp.kLf, this.klX.getTextSize()));
            Bundle bundle = new Bundle();
            bundle.putBoolean("click_help", true);
            this.klY.setText(j.a(this.mController.tml, amp.muD, (int) this.klY.getTextSize(), bundle));
            this.klY.setClickable(true);
            this.klY.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m(this));
            if (bi.oW(bdk.sda)) {
                x.d(this.TAG, "no help url");
                this.klT.setVisibility(8);
            } else {
                com.tencent.mm.plugin.wallet_core.ui.m mVar = new com.tencent.mm.plugin.wallet_core.ui.m(new 9(this, bdk));
                CharSequence spannableString = new SpannableString(bdk.sda);
                spannableString.setSpan(mVar, 0, spannableString.length(), 18);
                this.klT.setText(spannableString);
                this.klT.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m(this));
                this.klT.setClickable(true);
            }
            this.klR.setText(com.tencent.mm.plugin.honey_pay.model.c.dK(amp.rPl));
            b.a(this.klP, amp.qYy, 0.06f, false);
            com.tencent.mm.wallet_core.ui.e.f(this.klQ, amp.qYy);
            this.klW.setText(j.a(this, com.tencent.mm.wallet_core.ui.e.dx(q.GH(), 16), this.klW.getTextSize()));
            CdnImageView cdnImageView;
            int i;
            if (bi.oW(amp.lMY)) {
                cdnImageView = this.kma;
                i = amp.huV;
                cdnImageView.setImageResource(com.tencent.mm.plugin.honey_pay.model.c.aWc());
                return;
            }
            cdnImageView = this.kma;
            String str = amp.lMY;
            i = amp.huV;
            cdnImageView.cS(str, com.tencent.mm.plugin.honey_pay.model.c.aWc());
        }
    }

    private void aWf() {
        x.i(this.TAG, "qry user detail");
        l mVar = new m(this.kkc);
        mVar.m(this);
        a(mVar, true, false);
    }
}
