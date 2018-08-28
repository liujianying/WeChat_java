package com.tencent.mm.plugin.honey_pay.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wxpay.a$e;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.d.m;
import com.tencent.mm.protocal.c.alp;
import com.tencent.mm.protocal.c.amp;
import com.tencent.mm.protocal.c.bdk;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h.a;

public class HoneyPayCardDetailUI extends HoneyPayBaseUI {
    private int fdx;
    private ImageView hVP;
    private String kkc;
    private TextView kkg;
    private TextView kkh;
    private TextView kki;
    private TextView kkj;
    private TextView kkk;
    private TextView kkl;
    private RelativeLayout kkm;
    private CdnImageView kkn;
    private TextView kko;
    private Button kkp;
    private bdk kkq;
    private alp kkr;

    public void onCreate(Bundle bundle) {
        this.kjV = c.honey_pay_grey_bg_2;
        super.onCreate(bundle);
        jr(2613);
        this.fdx = getIntent().getIntExtra("key_scene", 0);
        this.kkc = getIntent().getStringExtra("key_card_no");
        initView();
        if (this.fdx == 0) {
            aWf();
            return;
        }
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_qry_response");
        try {
            this.kkq = new bdk();
            this.kkq.aG(byteArrayExtra);
            aWe();
        } catch (Throwable e) {
            x.printErrStackTrace(this.TAG, e, "", new Object[0]);
            aWf();
        }
    }

    protected final void initView() {
        this.hVP = (ImageView) findViewById(f.hpcd_top_image_iv);
        this.kkg = (TextView) findViewById(f.hpcd_state_tv);
        this.kkh = (TextView) findViewById(f.hpcd_state_tip_tv);
        this.kkk = (TextView) findViewById(f.hpcd_first_date_tv);
        this.kkl = (TextView) findViewById(f.hpcd_second_date_tv);
        this.kki = (TextView) findViewById(f.hpcd_first_date_title_tv);
        this.kkj = (TextView) findViewById(f.hpcd_second_date_title_tv);
        this.kkm = (RelativeLayout) findViewById(f.hpcd_oper_layout);
        this.kkn = (CdnImageView) findViewById(f.hpcd_oper_icon_iv);
        this.kko = (TextView) findViewById(f.hpcd_oper_desc_tv);
        this.kkp = (Button) findViewById(f.hpcd_oper_btn);
        this.kkh.setClickable(true);
        this.kkh.setOnTouchListener(new m(this));
    }

    public void onDestroy() {
        super.onDestroy();
        js(2613);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (lVar instanceof com.tencent.mm.plugin.honey_pay.a.m) {
            final com.tencent.mm.plugin.honey_pay.a.m mVar = (com.tencent.mm.plugin.honey_pay.a.m) lVar;
            mVar.a(new a() {
                public final void g(int i, int i2, String str, l lVar) {
                    HoneyPayCardDetailUI.this.kkq = mVar.kjN;
                    HoneyPayCardDetailUI.this.aWe();
                }
            }).b(new 2(this)).c(new a() {
                public final void g(int i, int i2, String str, l lVar) {
                }
            });
        }
        return true;
    }

    protected final int getLayoutId() {
        return g.honey_pay_card_detail_ui;
    }

    private void aWe() {
        if (this.kkq.rIz != null) {
            amp amp = this.kkq.rIz;
            setMMTitle(amp.hwg);
            this.kkg.setText(amp.rPr);
            int i = amp.state;
            if (i == 2) {
                this.hVP.setImageResource(a$e.wallet_success);
                if (!bi.oW(amp.rPn)) {
                    amp.rPn = com.tencent.mm.plugin.honey_pay.model.c.dn(amp.rPn, this.kkq.rIz.qYy);
                    this.kkh.setText(j.a(this, amp.rPn, (int) this.kkh.getTextSize(), null));
                }
                findViewById(f.hpcd_divider_view).setVisibility(8);
                findViewById(f.hpcd_first_date_layout).setVisibility(8);
                findViewById(f.hpcd_second_date_layout).setVisibility(8);
                if (this.kkr != null) {
                    this.kkm.setVisibility(0);
                    this.kkn.setUrl(this.kkr.bWP);
                    this.kko.setText(this.kkr.rOe);
                    this.kkp.setText(this.kkr.rOd);
                    this.kkp.setOnClickListener(new 4(this));
                }
            } else if (i == 3) {
                this.hVP.setImageResource(h.remittance_timed_out);
                if (!bi.oW(amp.rPn)) {
                    this.kkh.setText(amp.rPn);
                }
                this.kki.setText(i.honey_pay_receive_date_title_text);
                this.kkj.setText(i.honey_pay_return_date_title_text);
                this.kkk.setText(com.tencent.mm.plugin.honey_pay.model.c.dL((long) this.kkq.rIz.create_time));
                this.kkl.setText(com.tencent.mm.plugin.honey_pay.model.c.dL((long) this.kkq.rIz.huK));
            } else if (i == 4) {
                this.hVP.setImageResource(h.remittance_timed_out);
                i = this.kkq.rIz.rPq;
                if (!bi.oW(amp.rPn)) {
                    this.kkh.setText(j.c(this, amp.rPn, (int) this.kkh.getTextSize()));
                }
                this.kki.setText(i.honey_pay_release_date_title_text);
                this.kkk.setText(com.tencent.mm.plugin.honey_pay.model.c.dL((long) this.kkq.rIz.rPp));
                findViewById(f.hpcd_second_date_layout).setVisibility(8);
            }
        }
    }

    private void aWf() {
        com.tencent.mm.plugin.honey_pay.a.m mVar = new com.tencent.mm.plugin.honey_pay.a.m(this.kkc);
        mVar.m(this);
        a(mVar, true, false);
    }
}
