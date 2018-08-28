package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.b.c$a;
import com.tencent.mm.plugin.card.b.d$a;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.ui.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.pr;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;

public class CardConsumeCodeUI extends DrawStatusBarActivity implements OnClickListener, c$a, d$a {
    private final String TAG = "MicroMsg.CardConsumeCodeUI";
    private Vibrator hni;
    private int hop = 3;
    private b htQ;
    private String hyZ;
    private int hza = 3;
    private int hzb = 0;
    private a hzc;
    private TextView hzd;
    private TextView hze;
    private LinearLayout hzf;
    private ImageView hzg;
    private View hzh;
    private LinearLayout hzi;
    private View hzj;
    private TextView hzk;
    private TextView hzl;
    private TextView hzm;
    private boolean hzn = false;

    protected final int getLayoutId() {
        return e.card_consume_code_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.CardConsumeCodeUI", "onCreate()");
        setResult(0);
        this.htQ = (b) getIntent().getParcelableExtra("key_card_info_data");
        this.hop = getIntent().getIntExtra("key_from_scene", 3);
        this.hza = getIntent().getIntExtra("key_previous_scene", 3);
        this.hyZ = getIntent().getStringExtra("key_mark_user");
        this.hzb = getIntent().getIntExtra("key_from_appbrand_type", 0);
        if (this.htQ == null || this.htQ.awm() == null || this.htQ.awn() == null) {
            x.e("MicroMsg.CardConsumeCodeUI", "mCardInfo == null or mCardInfo.getCardTpInfo() == null or mCardInfo.getDataInfo() == null");
            finish();
            return;
        }
        initView();
        am.axo().p("", "", 3);
    }

    protected final void initView() {
        a aVar;
        if (this.htQ.avT()) {
            if (TextUtils.isEmpty(this.htQ.awm().hwg)) {
                setMMTitle(getString(g.card_consume_code_ui_title, new Object[]{getString(g.card_membership)}));
            } else {
                setMMTitle(getString(g.card_consume_code_ui_title, new Object[]{this.htQ.awm().hwg}));
            }
        }
        setBackBtn(new 1(this));
        if (this.hzc == null) {
            this.hzc = new a(this, this.mController.contentView);
            aVar = this.hzc;
            aVar.hyW = aVar.gKS.getWindow().getAttributes().screenBrightness;
            a aVar2 = this.hzc;
            aVar2.hyP = (TextView) aVar2.hyK.findViewById(d.card_notice);
            aVar2.hyQ = (TextView) aVar2.hyK.findViewById(d.card_pay_and_qrcode_notice);
            aVar2.hyR = (CheckBox) aVar2.hyK.findViewById(d.notify_checkbox);
            aVar2.hyR.setChecked(true);
            aVar2.hyR.setOnClickListener(aVar2.eZF);
            if (aVar2.hyW < 0.8f) {
                aVar2.ag(0.8f);
            }
            this.hzc.hyV = new a() {
                public final void nO(int i) {
                    am.axu().H(CardConsumeCodeUI.this.htQ.awq(), i, 1);
                }
            };
        }
        this.hzc.htQ = this.htQ;
        this.hzc.hyU = true;
        if (this.htQ.avS()) {
            aVar = this.hzc;
            String str = this.hyZ;
            aVar.hyT = 1;
            aVar.hyS = str;
        }
        this.hni = (Vibrator) getSystemService("vibrator");
        this.hzd = (TextView) findViewById(d.brand_name);
        this.hze = (TextView) findViewById(d.title);
        this.hzf = (LinearLayout) findViewById(d.app_logo_layout);
        this.hzg = (ImageView) findViewById(d.app_logo);
        this.hzh = findViewById(d.dash_line);
        this.hzi = (LinearLayout) findViewById(d.code_layout);
        if (this.htQ.avT()) {
            findViewById(d.card_consumed_code_ui).setBackgroundColor(getResources().getColor(com.tencent.mm.plugin.card.a.a.card_bg_color));
            m.d(this);
            com.tencent.mm.ui.statusbar.a.c(this.mController.contentView, -1, true);
        } else {
            int xV = l.xV(this.htQ.awm().dxh);
            findViewById(d.card_consumed_code_ui).setBackgroundColor(xV);
            m.a(this, this.htQ);
            com.tencent.mm.ui.statusbar.a.c(this.mController.contentView, xV, true);
        }
        if (!this.htQ.avT() || TextUtils.isEmpty(this.htQ.awm().huW)) {
            this.hzd.setText(this.htQ.awm().hwh);
            this.hze.setText(this.htQ.awm().title);
        } else {
            this.hzf.setVisibility(0);
            this.hzd.setVisibility(8);
            this.hze.setVisibility(8);
            this.hzh.setVisibility(8);
            m.a(this.hzg, this.htQ.awm().huW, getResources().getDimensionPixelSize(com.tencent.mm.plugin.card.a.b.card_coupon_widget_logo_size), c.my_card_package_defaultlogo, true);
        }
        if (this.htQ.awm().rok != null) {
            pr prVar = this.htQ.awm().rok;
            if (!TextUtils.isEmpty(prVar.title)) {
                if (this.hzj == null) {
                    this.hzj = ((ViewStub) findViewById(d.card_pay_and_qrcode_stub)).inflate();
                }
                this.hzj.setOnClickListener(this);
                this.hzk = (TextView) this.hzj.findViewById(d.card_pay_and_qrcode_title);
                this.hzl = (TextView) this.hzj.findViewById(d.card_pay_and_qrcode_sub_title);
                this.hzm = (TextView) this.hzj.findViewById(d.card_pay_and_qrcode_aux_title);
                this.hzk.setVisibility(0);
                this.hzk.setText(prVar.title);
                Drawable drawable = getResources().getDrawable(c.card_continue_arrow);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                drawable.setColorFilter(l.xV(this.htQ.awm().dxh), Mode.SRC_IN);
                this.hzk.setCompoundDrawables(null, null, drawable, null);
                this.hzk.setTextColor(l.xV(this.htQ.awm().dxh));
                this.hzk.setOnClickListener(this);
                if (TextUtils.isEmpty(prVar.huX)) {
                    this.hzl.setVisibility(0);
                    this.hzl.setText(getString(g.card_membership_continue_tip));
                } else {
                    this.hzl.setVisibility(0);
                    this.hzl.setText(prVar.huX);
                }
                if (!TextUtils.isEmpty(prVar.huY)) {
                    this.hzm.setVisibility(0);
                    this.hzm.setText(prVar.huY);
                }
                LayoutParams layoutParams = this.hzg.getLayoutParams();
                layoutParams.height = getResources().getDimensionPixelSize(com.tencent.mm.plugin.card.a.b.card_coupon_widget_small_logo_size);
                layoutParams.width = getResources().getDimensionPixelSize(com.tencent.mm.plugin.card.a.b.card_coupon_widget_small_logo_size);
                this.hzg.setLayoutParams(layoutParams);
                layoutParams = this.hzf.getLayoutParams();
                layoutParams.height = com.tencent.mm.bp.a.fromDPToPix(this, 54);
                layoutParams.width = com.tencent.mm.bp.a.fromDPToPix(this, 54);
                this.hzf.setLayoutParams(layoutParams);
                m.a(this.hzg, this.htQ.awm().huW, getResources().getDimensionPixelSize(com.tencent.mm.plugin.card.a.b.card_coupon_widget_small_logo_size), c.my_card_package_defaultlogo, true);
                this.hzi.setPadding(0, com.tencent.mm.bp.a.fromDPToPix(this, 10), 0, com.tencent.mm.bp.a.fromDPToPix(this, 30));
            }
        }
        am.axt().a(this);
        if (this.htQ.awg()) {
            am.axv().a(this);
            if (am.axv().isEmpty()) {
                x.i("MicroMsg.CardConsumeCodeUI", "registerListener doGetCardCodes");
                am.axv().xc(this.htQ.awq());
                return;
            }
            am.axv().awC();
        }
    }

    protected void onResume() {
        this.hzc.axM();
        am.axt().a(this, true);
        super.onResume();
    }

    protected void onPause() {
        am.axt().a(this, false);
        super.onPause();
    }

    protected void onDestroy() {
        a aVar = this.hzc;
        aVar.ag(aVar.hyW);
        l.x(aVar.eZA);
        l.x(aVar.hyO);
        aVar.hyV = null;
        aVar.gKS = null;
        am.axt().c(this);
        am.axt().b(this);
        if (this.htQ.awg()) {
            am.axv().b(this);
            am.axv().awD();
        }
        this.hni.cancel();
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            x.e("MicroMsg.CardConsumeCodeUI", "onKeyDown finishUI");
            setResult(-1);
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final void f(b bVar) {
        x.i("MicroMsg.CardConsumeCodeUI", "onDataChange");
        if (bVar != null && bVar.awq() != null && bVar.awq().equals(this.htQ.awq())) {
            this.htQ = bVar;
            this.hzc.htQ = this.htQ;
            this.hzc.axM();
        }
    }

    public final void awJ() {
        this.hni.vibrate(300);
    }

    public final void awK() {
        x.i("MicroMsg.CardConsumeCodeUI", "onFinishUI");
        finish();
    }

    public final void xe(String str) {
        x.i("MicroMsg.CardConsumeCodeUI", "onStartConsumedSuccUI");
        if (this.hzn) {
            x.e("MicroMsg.CardConsumeCodeUI", "has start CardConsumeSuccessUI!");
            return;
        }
        x.i("MicroMsg.CardConsumeCodeUI", "startConsumedSuccUI() ");
        this.hzn = true;
        Intent intent = new Intent(this, CardConsumeSuccessUI.class);
        intent.putExtra("KEY_CARD_ID", this.htQ.awq());
        intent.putExtra("KEY_CARD_CONSUMED_JSON", str);
        intent.putExtra("KEY_CARD_COLOR", this.htQ.awm().dxh);
        intent.putExtra("key_stastic_scene", this.hop);
        intent.putExtra("key_from_scene", 0);
        startActivity(intent);
    }

    public final void awE() {
        this.hzc.axM();
    }

    public final void xb(String str) {
        com.tencent.mm.plugin.card.d.d.a(this, str, true);
    }

    public final void onSuccess() {
        this.hzc.axM();
    }

    public void onClick(View view) {
        if (view.getId() == d.card_pay_and_qrcode_title || view.getId() == d.card_pay_and_qrcode) {
            if (this.htQ.awf()) {
                j.b bVar = new j.b();
                com.tencent.mm.plugin.card.d.b.a(this, bVar.huK, bVar.huL, false, this.htQ);
            } else {
                pr prVar = this.htQ.awm().rok;
                if (!(com.tencent.mm.plugin.card.d.b.a(this.htQ.awq(), prVar, this.hza, this.hzb) || prVar == null || TextUtils.isEmpty(prVar.url))) {
                    com.tencent.mm.plugin.card.d.b.a(this, l.x(prVar.url, prVar.roL), 1);
                    h.mEJ.h(11941, new Object[]{Integer.valueOf(9), this.htQ.awq(), this.htQ.awr(), "", prVar.title});
                    if (l.a(prVar, this.htQ.awq())) {
                        String awq = this.htQ.awq();
                        String str = prVar.title;
                        l.yb(awq);
                        com.tencent.mm.plugin.card.d.b.a(this, this.htQ.awm().hwh);
                    }
                }
            }
            finish();
        }
    }
}
