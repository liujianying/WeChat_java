package com.tencent.mm.plugin.remittance.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ab.l;
import com.tencent.mm.bk.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.remittance.model.BusiRemittanceResp;
import com.tencent.mm.plugin.remittance.model.j;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.ch;
import com.tencent.mm.protocal.c.kd;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import d.a.a.c;
import java.util.List;

@a(19)
public class RemittanceBusiResultUI extends WalletBaseUI {
    private TextView gsY;
    private int kTw;
    private Button klJ;
    private String lJJ;
    private String mAa;
    private b mAb;
    private boolean mAc = false;
    private String mAd;
    private BusiRemittanceResp mAe;
    private ch mAf = new ch();
    private int mAg;
    private c mAh;
    private WalletSuccPageAwardWidget mAi;
    private CdnImageView mAj;
    private TextView mAk;
    private View mAl;
    private TextView mAm;
    private ViewGroup mAn;
    private ViewGroup mAo;
    private ViewGroup mAp;
    private TextView mAq;
    private int mwN;
    private String mwO;
    private String myR;
    private TextView mzG;
    private TextView mzH;
    private TextView mzI;
    private CdnImageView mzJ;
    private TextView mzK;
    private TextView mzL;
    private Button mzM;
    private ViewGroup mzN;
    private ViewGroup mzO;
    private ViewGroup mzP;
    private View mzQ;
    private String mzR;
    private String mzS;
    private String mzT;
    private double mzU;
    private String mzV;
    private String mzW;
    private String mzX;
    private int mzY;
    private String mzZ;
    private String mzp;

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        jr(1537);
        jr(1680);
        jr(2504);
        if (d.fR(21)) {
            if (d.fR(23)) {
                getWindow().setStatusBarColor(-1);
                getWindow().getDecorView().setSystemUiVisibility(8192);
            } else {
                getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
            }
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setBackBtn(null);
        showHomeBtn(false);
        enableBackMenu(false);
        this.myR = getIntent().getStringExtra("key_mch_name");
        this.mAe = (BusiRemittanceResp) getIntent().getParcelableExtra("BusiRemittanceResp");
        this.mzU = getIntent().getDoubleExtra("key_money", 0.0d);
        this.mzT = getIntent().getStringExtra("key_rcver_name");
        this.mAd = getIntent().getStringExtra("key_rcver_true_name");
        this.mzR = getIntent().getStringExtra("key_rcv_desc");
        this.mzS = getIntent().getStringExtra("key_pay_desc");
        this.mzV = getIntent().getStringExtra("key_f2f_id");
        this.lJJ = getIntent().getStringExtra("key_trans_id");
        this.mzp = getIntent().getStringExtra("key_rcvr_open_id");
        this.mAa = getIntent().getStringExtra("key_check_sign");
        this.mzW = getIntent().getStringExtra("key_pay_desc");
        this.mzX = getIntent().getStringExtra("key_rcv_desc");
        this.mzY = getIntent().getIntExtra("key_scan_sceen", 0);
        this.kTw = getIntent().getIntExtra("key_channel", 0);
        this.mzZ = getIntent().getStringExtra("key_succ_page_extend");
        try {
            this.mAf.aG(getIntent().getByteArrayExtra("AfterPlaceOrderCommReq"));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.RemittanceBusiResultUI", e, "", new Object[0]);
        }
        this.mAg = getIntent().getIntExtra("key_succ_show_avatar_type", 0);
        this.mwN = getIntent().getIntExtra("key_succ_show_avatar_show", 0);
        this.mwO = getIntent().getStringExtra("key_succ_show_avatar_url");
        this.mAc = false;
        x.i("MicroMsg.RemittanceBusiResultUI", "fetch data");
        a(new j(this.mAf, this.mzZ), true, true);
        initView();
    }

    protected final void initView() {
        CharSequence string;
        this.gsY = (TextView) findViewById(f.rbru_title_tv);
        this.mzG = (TextView) findViewById(f.rbru_money_tv);
        this.mzH = (TextView) findViewById(f.rbru_rcv_desc_tv);
        this.mzI = (TextView) findViewById(f.rbru_pay_desc_tv);
        this.mzN = (LinearLayout) findViewById(f.rbru_rcv_desc_layout);
        this.mzO = (LinearLayout) findViewById(f.rbru_pay_desc_layout);
        this.mzJ = (CdnImageView) findViewById(f.rbru_app_logo_iv);
        this.mzK = (TextView) findViewById(f.rbru_app_title_tv);
        this.mzL = (TextView) findViewById(f.rbru_app_subtitle_tv);
        this.mzM = (Button) findViewById(f.rbru_app_btn);
        this.mzP = (ViewGroup) findViewById(f.rbru_app_layout);
        this.klJ = (Button) findViewById(f.rbru_finish_btn);
        this.mzQ = findViewById(f.single_line_view);
        this.mzG.setText(e.A(this.mzU));
        String dx;
        Object string2;
        if (bi.oW(this.myR)) {
            dx = e.dx(e.gT(this.mzT), 6);
            if (!bi.oW(this.mAd)) {
                string2 = getString(i.remittance_collect_block, new Object[]{dx, this.mAd});
            }
            string2 = dx;
        } else {
            dx = e.dx(this.myR, 6);
            if (!bi.oW(this.mAd)) {
                string2 = getString(i.remittance_collect_block, new Object[]{dx, this.mAd});
            }
            string2 = dx;
        }
        if (bi.oW(this.mzR)) {
            this.mzN.setVisibility(8);
        } else {
            this.mzH.setText(this.mzR);
            this.mzN.setVisibility(0);
        }
        if (bi.oW(this.mzS)) {
            this.mzO.setVisibility(8);
        } else {
            this.mzI.setText(this.mzS);
            this.mzO.setVisibility(0);
        }
        this.klJ.setOnClickListener(new 1(this));
        this.mAi = (WalletSuccPageAwardWidget) findViewById(f.award_widget);
        this.mAn = (ViewGroup) findViewById(f.discount_info_list_layout);
        this.mAo = (ViewGroup) findViewById(f.discount_desc_list_layout);
        this.mAp = (ViewGroup) findViewById(f.original_feeinfo_layout);
        this.mAq = (TextView) findViewById(f.origin_fee_tv);
        this.mAj = (CdnImageView) findViewById(f.remittance_busi_logo);
        this.mAk = (TextView) findViewById(f.rbru_rcvr_tv);
        this.mAl = findViewById(f.layout_money_really);
        this.mAm = (TextView) findViewById(f.rbru_rcvr_money_tv);
        this.mAk.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this, string2));
        this.mAj.setVisibility(0);
        if (!bi.oW(this.mwO)) {
            if (this.mAg == 1) {
                this.mAj.setRoundCorner(true);
            }
            this.mAj.setUrl(this.mwO);
        } else if (this.mAg == 1) {
            com.tencent.mm.pluginsdk.ui.a.b.n(this.mAj, this.mzT);
        } else {
            com.tencent.mm.pluginsdk.ui.a.b.a(this.mAj, this.mzT);
        }
        this.mAl.setVisibility(8);
        this.mAm.setVisibility(8);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (lVar instanceof j) {
            j jVar = (j) lVar;
            if (i != 0 || i2 != 0) {
                x.e("MicroMsg.RemittanceBusiResultUI", "net error: %s", new Object[]{jVar});
            } else if (jVar.mxm.hwV == 0) {
                x.i("MicroMsg.RemittanceBusiResultUI", "exposure info: %s", new Object[]{jVar.mxm.pqb});
                this.mAh = jVar.mxm.pqb;
                if (WalletSuccPageAwardWidget.a(this.mAh)) {
                    x.i("MicroMsg.RemittanceBusiResultUI", "setAwardWidget, mTransId: %s", new Object[]{this.lJJ});
                    this.mAi.a(this, this.mAh, this.lJJ, true, (ImageView) findViewById(f.background));
                    this.mAi.init();
                    this.mAi.setVisibility(0);
                    ImageView imageView = (ImageView) findViewById(f.background);
                    imageView.post(new 2(this, imageView));
                    this.mAi.post(new 3(this));
                } else {
                    this.mAi.setVisibility(8);
                }
                this.mAo.setVisibility(8);
                this.mAn.setVisibility(8);
                this.mAp.setVisibility(8);
                if (jVar.mxm.rlc == 1) {
                    this.mAl.setVisibility(0);
                    this.mAm.setVisibility(0);
                    this.mAm.setText(e.B(((double) jVar.mxm.rkZ) / 100.0d));
                } else {
                    this.mAl.setVisibility(8);
                    this.mAm.setVisibility(8);
                }
                if (!(jVar == null || jVar.mxm == null || jVar.mxm.rla.size() <= 0)) {
                    int size;
                    List list = jVar.mxm.rla;
                    String str2 = "MicroMsg.RemittanceBusiResultUI";
                    String str3 = "discountInfoList: %s, size: %s received_amount: %s";
                    Object[] objArr = new Object[3];
                    objArr[0] = list;
                    if (list != null) {
                        size = list.size();
                    } else {
                        size = 0;
                    }
                    objArr[1] = Integer.valueOf(size);
                    objArr[2] = Long.valueOf(jVar.mxm.rkZ);
                    x.i(str2, str3, objArr);
                    if (list != null && list.size() > 0) {
                        this.mAo.removeAllViews();
                        size = 0;
                        while (true) {
                            int i3 = size;
                            if (i3 >= list.size()) {
                                break;
                            }
                            String str4 = (String) list.get(i3);
                            View textView = new TextView(this.mController.tml);
                            LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams.bottomMargin = com.tencent.mm.bp.a.fromDPToPix(this, 6);
                            textView.setLayoutParams(layoutParams);
                            textView.setTextSize(1, 12.0f);
                            textView.setTextColor(Color.parseColor("#FA962A"));
                            textView.setText(str4);
                            this.mAo.addView(textView);
                            size = i3 + 1;
                        }
                        this.mAo.setVisibility(0);
                        this.mAn.setVisibility(0);
                    }
                    if (jVar.mxm.rkZ > 0) {
                        this.mAq.setText(e.B(((double) jVar.mxm.rkZ) / 100.0d));
                        this.mAq.getPaint().setFlags(16);
                        this.mAp.setVisibility(0);
                    }
                }
            } else {
                x.e("MicroMsg.RemittanceBusiResultUI", "result response: %s, %s", new Object[]{Integer.valueOf(jVar.mxm.hwV), jVar.mxm.hwW});
            }
        } else if (lVar instanceof com.tencent.mm.plugin.remittance.model.f) {
            com.tencent.mm.plugin.remittance.model.f fVar = (com.tencent.mm.plugin.remittance.model.f) lVar;
            if (i != 0 || i2 != 0) {
                x.e("MicroMsg.RemittanceBusiResultUI", "net error: %s", new Object[]{fVar});
            } else if (fVar.mwZ.hwV == 0) {
                kd kdVar = fVar.mwZ.rks;
                if (kdVar != null) {
                    this.mzJ.setUrl(kdVar.bWP);
                    this.mzK.setText(kdVar.title);
                    this.mzL.setText(kdVar.poH);
                    this.mzM.setText(kdVar.pwk);
                    this.mzM.setOnClickListener(new 4(this, kdVar));
                    this.mzM.setBackgroundResource(com.tencent.mm.plugin.wxpay.a.e.remittance_busi_app_disable_bg);
                    this.mzM.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.white_text_color_disabled));
                    this.mzP.setVisibility(0);
                } else {
                    x.i("MicroMsg.RemittanceBusiResultUI", "app info is null");
                    this.mzP.setVisibility(8);
                }
            } else {
                x.e("MicroMsg.RemittanceBusiResultUI", "qry response: %s, %s", new Object[]{Integer.valueOf(fVar.mwZ.hwV), fVar.mwZ.hwW});
                Toast.makeText(this, fVar.mwZ.hwW, 1).show();
            }
        }
        boolean z = false;
        if (this.mAh != null) {
            z = this.mAi.d(i, i2, str, lVar);
        }
        if (cu(this.mzN) && cu(this.mzO) && cu(this.mAp) && cu(this.mAn)) {
            this.mzQ.setVisibility(8);
        } else {
            this.mzQ.setVisibility(0);
        }
        return z;
    }

    private static boolean cu(View view) {
        if (view == null || view.getVisibility() == 8) {
            return true;
        }
        return false;
    }

    public void onResume() {
        super.onResume();
        if (this.mAc) {
            x.i("MicroMsg.RemittanceBusiResultUI", "do act qry");
            a(new com.tencent.mm.plugin.remittance.model.f(this.mzV, this.lJJ, this.mzp, (int) Math.round(this.mzU * 100.0d), this.mAb, this.mAa), false, false);
            this.mAc = false;
        }
        if (this.mAh != null) {
            this.mAi.onResume();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        js(1537);
        js(1680);
        js(2504);
        if (this.mAh != null) {
            this.mAi.onDestroy();
        }
    }

    protected final int getLayoutId() {
        return g.remittance_busi_result_ui;
    }

    public final void ux(int i) {
        this.mController.contentView.setVisibility(i);
    }
}
