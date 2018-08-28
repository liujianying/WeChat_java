package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.remittance.a.b;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.lr;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import d.a.a.c;

@a(19)
public class RemittanceResultNewUI extends RemittanceResultUI {
    private c mAh;
    private WalletSuccPageAwardWidget mAi;
    private Orders mCZ;
    private String mDa;
    private boolean mDc;
    private TextView mDd;
    private ViewGroup mDe;
    private TextView mDf;
    private WalletTextView mDg;
    private ViewGroup mDh;
    private ViewGroup mDi;
    private ViewGroup mDj;
    private TextView mDk;
    private TextView mDl;
    private WalletTextView mDm;
    private lr mDn;
    private Button mDo;
    private PayInfo mpb;
    private int myU;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
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
        this.mCZ = (Orders) this.sy.getParcelable("key_orders");
        this.mpb = (PayInfo) this.sy.getParcelable("key_pay_info");
        if (this.mpb == null) {
            x.e("MicroMsg.RemittanceResultNewUI", "payInfo is null!!!");
            finish();
            return;
        }
        String str = "";
        String str2 = "";
        if (this.mpb.qUL != null) {
            this.mDc = this.mpb.qUL.getBoolean("extinfo_key_4");
            str = this.mpb.qUL.getString("extinfo_key_1");
            str2 = this.mpb.qUL.getString("extinfo_key_16");
        }
        this.myU = this.mpb.bVY;
        this.mDa = str;
        x.i("MicroMsg.RemittanceResultNewUI", "payScene: %s", new Object[]{Integer.valueOf(r2)});
        initView();
        if (this.myU == 31) {
            x.i("MicroMsg.RemittanceResultNewUI", "transId: %s", new Object[]{str2});
            b.bqQ().bqT().en(str2, this.mDa);
        }
    }

    protected final int getLayoutId() {
        return g.remittance_result_new_ui;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            brF();
        }
        return super.onKeyUp(i, keyEvent);
    }

    protected final void initView() {
        boolean z = false;
        setBackBtn(null);
        showHomeBtn(false);
        enableBackMenu(false);
        this.mDd = (TextView) findViewById(f.pay_succ_wording_tv);
        this.mDe = (ViewGroup) findViewById(f.f2f_transfer_result_money_layout);
        this.mDf = (TextView) findViewById(f.f2f_money_unit_tv);
        this.mDg = (WalletTextView) findViewById(f.f2f_money_amount_tv);
        this.mDh = (ViewGroup) findViewById(f.f2f_transfer_detail_layout);
        this.mDi = (ViewGroup) findViewById(f.f2f_transfer_detail_list_layout);
        this.mDj = (ViewGroup) findViewById(f.normal_transfer_result_money_layout);
        this.mDk = (TextView) findViewById(f.normal_transfer_desc_tv);
        this.mDl = (TextView) findViewById(f.normal_money_unit_tv);
        this.mDm = (WalletTextView) findViewById(f.normal_money_amount_tv);
        this.mDo = (Button) findViewById(f.transfer_finish_button);
        this.mDo.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                RemittanceResultNewUI.this.brF();
            }
        });
        this.mAi = (WalletSuccPageAwardWidget) findViewById(f.award_widget);
        String gT = e.gT(this.mDa);
        if (this.myU == 31 || this.myU == 5) {
            this.mDl.setText(e.abW(this.mCZ.lNV));
            this.mDm.setText(e.A(this.mCZ.mBj));
            if (this.myU == 31) {
                CharSequence string = getString(i.remittance_result_receiver_desc, new Object[]{gT});
                if (bi.oW(string)) {
                    this.mDk.setVisibility(8);
                } else {
                    this.mDk.setText(j.a(this, string, this.mDk.getTextSize()));
                }
            } else {
                boolean z2;
                if (this.mpb.qUL == null || !this.mpb.qUL.getBoolean("extinfo_key_10")) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                x.i("MicroMsg.RemittanceResultNewUI", "isEmojiReward: %s", new Object[]{Boolean.valueOf(z2)});
                if (z2) {
                    this.mDk.setText(getString(i.remittance_emoji_reward_desc));
                } else if (!(this.mCZ.ppf == null || this.mCZ.ppf.get(0) == null || TextUtils.isEmpty(((Commodity) this.mCZ.ppf.get(0)).lNK))) {
                    this.mDk.setText(((Commodity) this.mCZ.ppf.get(0)).lNK);
                }
            }
            this.mDj.setVisibility(0);
            if (this.mCZ.mxE > 0.0d) {
                brE();
                ((MarginLayoutParams) this.mDh.getLayoutParams()).topMargin = com.tencent.mm.bp.a.fromDPToPix(this, 20);
                this.mDh.setVisibility(0);
                this.mDi.setVisibility(0);
            }
        } else {
            byte[] byteArray = this.sy.getByteArray("key_succpage_resp");
            if (byteArray != null) {
                this.mDn = new lr();
                try {
                    this.mDn.aG(byteArray);
                    this.mAh = this.mDn.pqb;
                } catch (Throwable e) {
                    this.mDn = null;
                    this.mAh = null;
                    x.printErrStackTrace("MicroMsg.RemittanceResultNewUI", e, "parse f2FPaySucPageResp error: %s", new Object[]{e.getMessage()});
                }
            }
            gT = e.gT(this.mDa);
            this.mDf.setText(e.abW(this.mCZ.lNV));
            this.mDg.setText(e.A(this.mCZ.mBj));
            this.mDi.removeAllViews();
            if (this.myU == 32 || this.myU == 33 || this.myU == 48) {
                CharSequence charSequence;
                ViewGroup viewGroup;
                TextView textView;
                String str = "";
                if (this.mpb.qUL != null) {
                    str = this.mpb.qUL.getString("extinfo_key_2");
                }
                if (gT != null && gT.length() > 10) {
                    gT = gT.substring(0, 10) + "...";
                }
                Object charSequence2;
                if (bi.oW(str)) {
                    charSequence2 = gT;
                } else if (bi.oW(gT)) {
                    charSequence2 = str;
                } else {
                    charSequence2 = gT + "(" + e.abZ(str) + ")";
                }
                x.i("MicroMsg.RemittanceResultNewUI", "setF2FNameView");
                ViewGroup viewGroup2 = (ViewGroup) getLayoutInflater().inflate(g.f2f_transfer_new_detail_item, this.mDi, false);
                TextView textView2 = (TextView) viewGroup2.findViewById(f.rbru_rcvr_tv);
                com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) viewGroup2.findViewById(f.remittance_busi_logo), this.mDa, 0.06f, false);
                textView2.setText(charSequence2);
                this.mDi.addView(viewGroup2);
                x.i("MicroMsg.RemittanceResultNewUI", "setF2FReceiverRemarkView");
                CharSequence string2 = this.mpb.qUL.getString("extinfo_key_3");
                CharSequence string3 = this.mpb.qUL.getString("extinfo_key_8");
                if (!bi.oW(string2)) {
                    viewGroup = (ViewGroup) getLayoutInflater().inflate(g.f2f_transfer_detail_item_2, this.mDi, false);
                    textView2 = (TextView) viewGroup.findViewById(f.title_tv);
                    textView = (TextView) viewGroup.findViewById(f.desc_tv);
                    if (bi.oW(string3)) {
                        textView2.setText(getString(i.collect_create_qrcode_receiver_msg_title));
                    } else {
                        textView2.setText(string3);
                    }
                    textView.setText(string2);
                    this.mDi.addView(viewGroup);
                }
                x.i("MicroMsg.RemittanceResultNewUI", "setF2FPayerRemarkView");
                string2 = this.mpb.qUL.getString("extinfo_key_6");
                string3 = this.mpb.qUL.getString("extinfo_key_7");
                if (!bi.oW(string3)) {
                    viewGroup = (ViewGroup) getLayoutInflater().inflate(g.f2f_transfer_detail_item_2, this.mDi, false);
                    textView2 = (TextView) viewGroup.findViewById(f.title_tv);
                    textView = (TextView) viewGroup.findViewById(f.desc_tv);
                    if (bi.oW(string2)) {
                        textView2.setText(getString(i.collect_create_qrcode_payer_msg_title));
                    } else {
                        textView2.setText(string2);
                    }
                    textView.setText(string3);
                    this.mDi.addView(viewGroup);
                }
                brE();
                this.mDh.setVisibility(0);
                this.mDi.setVisibility(0);
                View findViewById;
                if (WalletSuccPageAwardWidget.a(this.mAh)) {
                    String str2 = "";
                    if (this.mCZ.ppf.size() > 0) {
                        str2 = ((Commodity) this.mCZ.ppf.get(0)).bOe;
                    }
                    x.i("MicroMsg.RemittanceResultNewUI", "transId: %s", new Object[]{str2});
                    this.mAi.a(this, this.mAh, str2, true, (ImageView) findViewById(f.background));
                    this.mAi.init();
                    this.mAi.setVisibility(0);
                    if (viewGroup2 != null) {
                        findViewById = viewGroup2.findViewById(f.rbru_rcvr_tv_v2_layout);
                        if (findViewById != null && findViewById.getVisibility() == 8) {
                            findViewById = findViewById(f.split_line);
                            if (findViewById != null) {
                                findViewById.setVisibility(8);
                            }
                        }
                    }
                } else {
                    this.mAi.setVisibility(8);
                    if (this.mDi.getChildCount() == 1) {
                        LayoutParams layoutParams = (LayoutParams) this.mDh.getLayoutParams();
                        layoutParams.topMargin = BackwardSupportUtil.b.b(this, 78.0f);
                        this.mDh.setLayoutParams(layoutParams);
                        View findViewById2 = viewGroup2.findViewById(f.remittance_layout_line2);
                        layoutParams = (LayoutParams) findViewById2.getLayoutParams();
                        layoutParams.topMargin = BackwardSupportUtil.b.b(this, 24.0f);
                        layoutParams.bottomMargin = 0;
                        findViewById2.setLayoutParams(layoutParams);
                        ImageView imageView = (ImageView) viewGroup2.findViewById(f.remittance_busi_logo);
                        ((TextView) viewGroup2.findViewById(f.rbru_rcvr_tv)).setVisibility(8);
                        findViewById(f.rbru_rcvr_tv_v2_layout).setVisibility(0);
                        ((TextView) findViewById(f.rbru_rcvr_tv_v2)).setText(charSequence2);
                        LayoutParams layoutParams2 = (LayoutParams) imageView.getLayoutParams();
                        int b = BackwardSupportUtil.b.b(this, 52.0f);
                        layoutParams2.width = b;
                        layoutParams2.height = b;
                        imageView.setLayoutParams(layoutParams2);
                        this.mDg.setTextSize(1, 42.0f);
                        this.mDf.setTextSize(1, 42.0f);
                        ((TextView) findViewById(f.rec_name_tip)).setTextSize(1, 16.0f);
                        imageView = (ImageView) findViewById(f.wxpay_succes_page_logo_iv);
                        layoutParams2 = (LayoutParams) imageView.getLayoutParams();
                        layoutParams2.width = BackwardSupportUtil.b.b(this, 26.0f);
                        layoutParams2.height = BackwardSupportUtil.b.b(this, 22.0f);
                        imageView.setLayoutParams(layoutParams2);
                        findViewById = findViewById(f.split_line);
                        if (findViewById != null) {
                            findViewById.setVisibility(8);
                        }
                    }
                }
            }
            this.mDe.setVisibility(0);
        }
        com.tencent.mm.kernel.g.Ek();
        Object obj = com.tencent.mm.kernel.g.Ei().DT().get(aa.a.sQv, Boolean.valueOf(false));
        if (obj != null) {
            z = ((Boolean) obj).booleanValue();
        }
        if (z) {
            x.i("MicroMsg.RemittanceResultNewUI", "has show the finger print auth guide!");
            return;
        }
        com.tencent.mm.wallet_core.c af = com.tencent.mm.wallet_core.a.af(this);
        Bundle bundle = new Bundle();
        if (af != null) {
            bundle = af.jfZ;
        }
        if (TextUtils.isEmpty(bundle.getString("key_pwd1"))) {
            x.i("MicroMsg.RemittanceResultNewUI", "pwd is empty, not show the finger print auth guide!");
        } else if (af != null) {
            af.a((Activity) this, "fingerprint", ".ui.FingerPrintAuthTransparentUI", bundle);
        }
    }

    private void brE() {
        boolean z = true;
        if (this.mCZ != null) {
            String str = "MicroMsg.RemittanceResultNewUI";
            String str2 = "need set charge fee: %s";
            Object[] objArr = new Object[1];
            if (this.mCZ.mxE <= 0.0d) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.i(str, str2, objArr);
            if (this.mCZ.mxE > 0.0d) {
                CharSequence string = getString(i.remittance_result_charge_fee_wording);
                CharSequence e = e.e(this.mCZ.mxE, this.mCZ.lNV);
                ViewGroup viewGroup = (ViewGroup) getLayoutInflater().inflate(g.f2f_transfer_detail_item, this.mDi, false);
                ImageView imageView = (ImageView) viewGroup.findViewById(f.avatar_iv);
                TextView textView = (TextView) viewGroup.findViewById(f.desc_tv);
                ((TextView) viewGroup.findViewById(f.title_tv)).setText(string);
                imageView.setVisibility(8);
                textView.setText(e);
                this.mDi.addView(viewGroup);
            }
        }
    }

    private void brF() {
        x.i("MicroMsg.RemittanceResultNewUI", "endRemittance");
        if (this.sy.containsKey("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) this.sy.getParcelable("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".ui.RemittanceResultUI");
                bundle.putString("realname_verify_process_jump_plugin", "remittance");
                realnameGuideHelper.b(this, bundle, new 2(this));
                realnameGuideHelper.a(this, bundle, new 3(this));
                this.sy.remove("key_realname_guide_helper");
                return;
            }
            return;
        }
        brG();
    }

    private void brG() {
        x.i("MicroMsg.RemittanceResultNewUI", "doEndRemittance");
        cDK().b(this, this.sy);
        new ag().postDelayed(new 4(this), 100);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (WalletSuccPageAwardWidget.a(this.mAh)) {
            return this.mAi.d(i, i2, str, lVar);
        }
        return super.d(i, i2, str, lVar);
    }

    public final void ux(int i) {
        this.mController.contentView.setVisibility(i);
    }

    protected final boolean brH() {
        return false;
    }

    public void onResume() {
        super.onResume();
        if (WalletSuccPageAwardWidget.a(this.mAh)) {
            this.mAi.onResume();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (WalletSuccPageAwardWidget.a(this.mAh)) {
            this.mAi.onDestroy();
        }
    }
}
