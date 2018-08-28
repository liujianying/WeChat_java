package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.sw;
import com.tencent.mm.g.a.td;
import com.tencent.mm.g.a.te;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.pay.a.c.b;
import com.tencent.mm.plugin.wallet.pay.a.c.d;
import com.tencent.mm.plugin.wallet.pay.a.c.e;
import com.tencent.mm.plugin.wallet.pay.a.c.f;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.plugin.wallet_core.ui.j;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import com.tencent.smtt.utils.TbsLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@a(3)
public class WalletPayUI extends WalletBaseUI implements a.a {
    private static boolean pgj = false;
    public String eWo = null;
    public Button mAE;
    private c mBs = new 1(this);
    public Orders mCZ = null;
    public PayInfo mCn = null;
    public int mCount = 0;
    protected com.tencent.mm.plugin.wallet.a myP = null;
    private String mzk;
    public o oZD;
    public ArrayList<Bankcard> oZG = null;
    public Bankcard oZH = null;
    private a pfA;
    com.tencent.mm.plugin.wallet_core.ui.c pfB;
    private com.tencent.mm.plugin.wallet.pay.a.c pfp = null;
    public FavorPayInfo pfz = null;
    private TextView pgA;
    private TextView pgB;
    protected LinearLayout pgC;
    protected a pgD;
    private long pgE = 0;
    private TextView pgF;
    private LinearLayout pgG;
    private boolean pgH = true;
    private boolean pgI = false;
    private boolean pgJ = false;
    private boolean pgK = false;
    private boolean pgL = false;
    private int pgM = -1;
    private boolean pgN = false;
    private boolean pgO = false;
    private e pgP;
    private boolean pgQ = false;
    private boolean pgR = false;
    private long pgS = 0;
    protected com.tencent.mm.plugin.wallet_core.ui.a pgk = null;
    private boolean pgl = false;
    private boolean pgm = false;
    public boolean pgn = false;
    protected boolean pgo = false;
    protected String pgp = "";
    protected boolean pgq = false;
    public Bundle pgr = null;
    protected boolean pgs = false;
    protected TextView pgt;
    protected TextView pgu;
    private TextView pgv;
    protected TextView pgw;
    protected TextView pgx;
    protected TextView pgy;
    protected ImageView pgz;

    static /* synthetic */ void f(WalletPayUI walletPayUI) {
        Bundle bundle = new Bundle();
        if (walletPayUI.mCZ != null) {
            bundle.putString("key_reqKey", walletPayUI.mCZ.bOd);
            if (walletPayUI.mCZ.ppf != null && walletPayUI.mCZ.ppf.size() > 0) {
                bundle.putString("key_TransId", ((Commodity) walletPayUI.mCZ.ppf.get(0)).bOe);
            }
            bundle.putLong("key_SessionId", walletPayUI.pgE);
        }
        if (walletPayUI.mCn != null) {
            bundle.putInt("key_scene", walletPayUI.mCn.bVY);
        }
        if (walletPayUI.mCn == null || walletPayUI.mCn.bVY != 11) {
            bundle.putInt("key_bind_scene", 0);
        } else {
            bundle.putInt("key_bind_scene", 13);
        }
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putInt("key_bind_scene", 0);
        bundle.putBoolean("key_is_bind_bankcard", true);
        bundle.putBoolean("key_is_oversea", !walletPayUI.bNP());
        com.tencent.mm.wallet_core.a.a((Activity) walletPayUI, com.tencent.mm.plugin.wallet.pay.a.class, bundle, null);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (pgj) {
            x.w("MicroMsg.WalletPayUI", "has Undestory WalletPayUI!");
            finish();
        }
        pgj = true;
        if (g.Eg().Dx()) {
            getWindow().getDecorView().postDelayed(new 12(this), 600);
            this.pgS = bi.VF();
            com.tencent.mm.sdk.b.a.sFg.b(this.mBs);
            i.zk(5);
            this.myP = com.tencent.mm.plugin.wallet.a.ac(getIntent());
            setMMTitle(com.tencent.mm.plugin.wxpay.a.i.wallet_pay_ui_title);
            this.mCn = bNW();
            this.pgo = getIntent().getBooleanExtra("key_is_force_use_given_card", false);
            this.pgp = bi.aG(getIntent().getStringExtra("key_force_use_bind_serail"), "");
            this.mzk = getIntent().getStringExtra("key_receiver_true_name");
            if (this.mCn == null || this.mCn.qUN == 0) {
                this.pgE = System.currentTimeMillis();
            } else {
                this.pgE = this.mCn.qUN;
            }
            p.bNp();
            if (!p.bNq().bPs()) {
                u.d(this.mCn == null ? 0 : this.mCn.bVY, this.mCn == null ? "" : this.mCn.bOd, 1, "");
            }
            if (bNJ()) {
                x.i("MicroMsg.WalletPayUI", "hy: pay end on create. finish");
                finish();
                return;
            }
            x.d("MicroMsg.WalletPayUI", "PayInfo = " + this.mCn);
            if (this.mCn == null || bi.oW(this.mCn.bOd)) {
                String string;
                if (this.mCn == null || bi.oW(this.mCn.Yy)) {
                    string = getString(com.tencent.mm.plugin.wxpay.a.i.wallet_pay_orders_illegal);
                } else {
                    string = this.mCn.Yy;
                }
                h.a(this, string, null, false, new 23(this));
            } else {
                bNK();
            }
            initView();
            return;
        }
        x.e("MicroMsg.WalletPayUI", "hy: account not ready. finish now");
        finish();
    }

    private boolean bNJ() {
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("intent_pay_end")) {
            x.i("MicroMsg.WalletPayUI", "hy: pay end. finish the activity");
            if (extras.getBoolean("intent_pay_end", false)) {
                x.d("MicroMsg.WalletPayUI", "pay done... errCode:" + extras.getInt("intent_pay_end_errcode"));
                x.d("MicroMsg.WalletPayUI", "pay done INTENT_PAY_APP_URL:" + extras.getString("intent_pay_app_url"));
                x.d("MicroMsg.WalletPayUI", "pay done INTENT_PAY_END:" + extras.getBoolean("intent_pay_end", false));
                f(-1, getIntent());
                this.pgm = true;
                return true;
            }
            x.d("MicroMsg.WalletPayUI", "pay cancel");
            f(0, getIntent());
            this.pgm = false;
            return true;
        } else if (extras == null || !extras.getBoolean("key_is_realname_verify_process")) {
            x.i("MicroMsg.WalletPayUI", "hy: pay not end");
            return false;
        } else {
            switch (extras.getInt("realname_verify_process_ret", 0)) {
                case -1:
                    return true;
                default:
                    return false;
            }
        }
    }

    public void onDestroy() {
        if (this.pfA != null) {
            this.pfA.bNx();
            this.pfA.release();
        }
        com.tencent.mm.sdk.b.a.sFg.c(this.mBs);
        this.pfB = null;
        pgj = false;
        super.onDestroy();
    }

    public void bNK() {
        m mVar;
        int i = 2;
        com.tencent.mm.plugin.report.service.h.mEJ.h(11850, new Object[]{Integer.valueOf(2), Integer.valueOf(this.mCn.bVY)});
        if (this.mCn.bVY == 11) {
            i = 3;
            if (com.tencent.mm.plugin.wallet.b.a.bOi()) {
                this.mCZ = new Orders();
                Commodity commodity = new Commodity();
                commodity.lNK = getString(com.tencent.mm.plugin.wxpay.a.i.wallet_balance_manager_save);
                this.mCZ.ppf.add(commodity);
                this.mCZ.mBj = this.mCn.qUS;
                this.mCZ.lNV = "CNY";
                jo(true);
                this.pgs = true;
                return;
            }
        }
        PayInfo payInfo = this.mCn;
        if (payInfo == null || bi.oW(payInfo.bOd)) {
            x.i("MicroMsg.CgiManager", "no payInfo or reqKey");
            mVar = null;
        } else {
            String str = payInfo.bOd;
            x.i("MicroMsg.CgiManager", "qrorderinfo reqKey: %s", new Object[]{str});
            x.i("MicroMsg.CgiManager", "qrorderinfo go new split cgi");
            mVar = str.startsWith("sns_aa_") ? new com.tencent.mm.plugin.wallet.pay.a.c.a(payInfo, i) : str.startsWith("sns_tf_") ? new com.tencent.mm.plugin.wallet.pay.a.c.g(payInfo, i) : str.startsWith("sns_ff_") ? new b(payInfo, i) : str.startsWith("ts_") ? new com.tencent.mm.plugin.wallet.pay.a.c.c(payInfo, i) : str.startsWith("sns_") ? new f(payInfo, i) : str.startsWith("offline_") ? new d(payInfo, i) : new e(payInfo, i);
        }
        if (mVar != null) {
            boolean z;
            mVar.dox = "PayProcess";
            mVar.iNJ = this.pgE;
            if (this.mCn.bVY == 6 && this.mCn.qUI == 100) {
                mVar.fdx = 100;
            } else {
                mVar.fdx = this.mCn.bVY;
            }
            if (this.mCn.qUJ) {
                z = true;
            } else {
                z = false;
            }
            a((l) mVar, true, z);
        }
    }

    public void onResume() {
        x.i("MicroMsg.WalletPayUI", "hy: onResume isFromH5RealNameVerify %s", new Object[]{Boolean.valueOf(this.pgQ)});
        if (!this.uYO.baU()) {
            if (this.oZH == null) {
                p.bNp();
                this.oZH = p.bNq().a(null, null, bNz(), false);
            } else {
                p.bNp();
                this.oZH = p.bNq().a(null, this.oZH.field_bindSerial, bNz(), false);
            }
        }
        if (this.pgR) {
            x.i("MicroMsg.WalletPayUI", "onResume isResumePassFinish");
            this.pgR = false;
        } else if (this.pgn && this.mController.contentView.getVisibility() != 0 && (this.oZD == null || !this.oZD.isShowing())) {
            x.i("MicroMsg.WalletPayUI", "hy: has started process and is transparent and no pwd appeared. finish self");
            finish();
        } else if (this.pfB != null) {
            this.pfB.bPW();
        }
        super.onResume();
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.wallet_pay_ui;
    }

    public void finish() {
        int i = false;
        x.i("MicroMsg.WalletPayUI", "finish %s ", new Object[]{bi.cjd().toString()});
        x.i("MicroMsg.WalletPayUI", "finish %s ", new Object[]{bi.cjd().toString()});
        cDH();
        if (!(this.mCZ == null || this.mCZ.ppf.isEmpty())) {
            getIntent().putExtra("key_trans_id", ((Commodity) this.mCZ.ppf.get(0)).bOe);
        }
        if (this.mCn != null) {
            getIntent().putExtra("key_reqKey", this.mCn.bOd);
        }
        if (this.pgm) {
            if (this.mCZ != null) {
                getIntent().putExtra("key_total_fee", this.mCZ.mBj);
            }
            f(-1, getIntent());
            setResult(-1, getIntent());
        } else {
            if (!(this.mCn == null || this.mCn.bVY != 8 || this.mCZ == null)) {
                this.mCn.qUR = 0;
                a(com.tencent.mm.plugin.wallet.pay.a.a.a(bNO(), this.mCZ, true), false, false);
                if (this.mCn.qUL != null) {
                    long j = this.mCn.qUL.getLong("extinfo_key_9");
                    com.tencent.mm.plugin.report.service.h.mEJ.h(13956, new Object[]{Integer.valueOf(3), Long.valueOf(System.currentTimeMillis() - j)});
                }
            }
            f(0, getIntent());
            setResult(0, getIntent());
            p.bNp();
            if (p.bNq().bPp()) {
                u.d(this.mCn == null ? 0 : this.mCn.bVY, this.mCn == null ? "" : this.mCn.bOd, 18, "");
            } else {
                p.bNp();
                if (p.bNq().bPt()) {
                    if (this.mCn != null) {
                        i = this.mCn.bVY;
                    }
                    u.d(i, this.mCn == null ? "" : this.mCn.bOd, 4, "");
                } else {
                    if (this.mCn != null) {
                        i = this.mCn.bVY;
                    }
                    u.d(i, this.mCn == null ? "" : this.mCn.bOd, 7, "");
                }
            }
        }
        super.finish();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        if (this.oZD == null || this.mCn == null || !this.mCn.jNf) {
            YC();
            showDialog(TbsLog.TBSLOG_CODE_SDK_BASE);
        } else {
            finish();
        }
        return true;
    }

    public void onNewIntent(Intent intent) {
        boolean z;
        boolean z2 = true;
        x.v("MicroMsg.WalletPayUI", "onNewIntent");
        setIntent(intent);
        if (!bNJ()) {
            x.w("MicroMsg.WalletPayUI", "hy: pay not end if judge from intent, but should finish this ui, and set cancel event");
            f(0, getIntent());
            this.pgm = false;
        }
        if (intent == null || !intent.getBooleanExtra("intent_bind_end", false)) {
            z = false;
        } else {
            this.pgI = true;
            z = true;
        }
        if (z) {
            x.i("MicroMsg.WalletPayUI", "isFromBindCard is true");
            bNK();
            return;
        }
        if (intent == null || !intent.getBooleanExtra("key_is_realname_verify_process", false)) {
            z2 = false;
        } else {
            this.pgJ = true;
        }
        if (z2) {
            x.i("MicroMsg.WalletPayUI", "isFromRealNameVerify is true");
            finish();
        } else {
            x.e("MicroMsg.WalletPayUI", "isFromBindCard is false,isFromRealNameVerify is false");
        }
        finish();
    }

    private void f(int i, Intent intent) {
        te teVar = new te();
        teVar.ceH.intent = intent;
        teVar.ceH.result = i;
        teVar.ceH.bOd = this.mCn == null ? "" : this.mCn.bOd;
        if (this.mCn != null && i == 0) {
            com.tencent.mm.plugin.wallet.pay.a.b.b.ae(this.mCn.bOd, this.mCn.bVY, this.mCn.bVU);
        }
        com.tencent.mm.sdk.b.a.sFg.m(teVar);
    }

    protected final void initView() {
        MMScrollView mMScrollView = (MMScrollView) findViewById(com.tencent.mm.plugin.wxpay.a.f.wallet_sv);
        mMScrollView.a(mMScrollView, mMScrollView);
        this.mAE = (Button) findViewById(com.tencent.mm.plugin.wxpay.a.f.wallet_pay_pay);
        this.mAE.setClickable(false);
        this.mAE.setEnabled(false);
        this.pgt = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.wallet_order_info_total_fee);
        this.pgu = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.wallet_order_info_total_desc);
        this.pgw = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.wallet_order_info_fee_type);
        this.pgB = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.wallet_order_info_favor);
        this.pgv = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.wallet_order_info_origin_fee);
        this.pgA = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.wallet_pay_anti_trick_tips);
        this.pgv.getPaint().setFlags(16);
        this.pgx = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.wallet_pay_tips);
        this.pgy = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.wallet_pay_bind_bankcard);
        this.pgy.setOnClickListener(new 24(this));
        this.pgz = (ImageView) findViewById(com.tencent.mm.plugin.wxpay.a.f.wallet_order_info_desc_more_btn);
        this.pgz.setOnClickListener(new 25(this));
        this.pgC = (LinearLayout) findViewById(com.tencent.mm.plugin.wxpay.a.f.wallet_order_info_lv);
        this.pgD = new a(this);
        this.mAE.setOnClickListener(new 26(this));
        this.mAE.setText(com.tencent.mm.plugin.wxpay.a.i.wallet_pay);
        this.pgF = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.payment_method_tips);
        this.pgG = (LinearLayout) findViewById(com.tencent.mm.plugin.wxpay.a.f.payment_method_layout);
        aL();
    }

    public final void aL() {
        boolean z;
        LinearLayout linearLayout;
        if (!(this.mCZ == null || this.mCZ.ppf == null || this.mCZ.ppf.size() <= 0)) {
            this.pgt.setText(com.tencent.mm.wallet_core.ui.e.A(this.mCZ.mBj));
            this.pgw.setText(com.tencent.mm.wallet_core.ui.e.abX(this.mCZ.lNV));
            this.pgD.notifyDataSetChanged();
            if (this.mCZ.ppf.size() > 1) {
                this.pgz.setVisibility(0);
                this.pgu.setText(getString(com.tencent.mm.plugin.wxpay.a.i.wallet_pay_ui_title_desc, new Object[]{((Commodity) this.mCZ.ppf.get(0)).desc, this.mCZ.ppf.size()}));
            } else {
                this.pgu.setText(((Commodity) this.mCZ.ppf.get(0)).desc);
                this.pgz.setVisibility(8);
            }
            this.pgq = false;
            int i = this.mCZ.poP;
        }
        if (this.mCn != null && this.mCn.bVY == 48) {
            this.pgu.setText(com.tencent.mm.plugin.wxpay.a.i.qr_reward_grant_btn);
        }
        this.pgx.setVisibility(8);
        this.pgy.setVisibility(8);
        this.pgF.setVisibility(8);
        this.pgG.setVisibility(8);
        this.mAE.setText(com.tencent.mm.plugin.wxpay.a.i.wallet_pay);
        if (this.oZH == null || !this.oZH.bOs()) {
            p.bNp();
            if (p.bNq().bPp()) {
                bNL();
            }
        } else if (bi.oW(this.oZH.field_forbidWord)) {
            p.bNp();
            if (p.bNq().bPt()) {
                bNL();
            }
        } else {
            this.pgx.setText(this.oZH.field_forbidWord);
            this.pgx.setVisibility(4);
            this.pgy.setVisibility(8);
            p.bNp();
            if (p.bNq().bPt()) {
                bNL();
            }
        }
        p.bNp();
        if (!p.bNq().bPt()) {
            p.bNp();
            if (!p.bNq().bPp()) {
                z = false;
                linearLayout = (LinearLayout) findViewById(com.tencent.mm.plugin.wxpay.a.f.wallet_order_info_favor_ll);
                if (z || this.pfz == null || this.pgk == null || !this.pgl || this.mCZ == null) {
                    linearLayout.setVisibility(8);
                } else {
                    bNN();
                    this.pgB.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            u.d(WalletPayUI.this.mCn == null ? 0 : WalletPayUI.this.mCn.bVY, WalletPayUI.this.mCn == null ? "" : WalletPayUI.this.mCn.bOd, 12, "");
                            j.a(WalletPayUI.this.mController.tml, WalletPayUI.this.mCZ, WalletPayUI.this.pfz.pnP, new 1(this));
                        }
                    });
                    linearLayout.setVisibility(0);
                }
                if (this.mCZ != null || this.oZG == null || this.mCn == null) {
                    this.mAE.setClickable(false);
                    this.mAE.setEnabled(false);
                } else {
                    this.mAE.setClickable(true);
                    this.mAE.setEnabled(true);
                }
                if (this.mCZ == null) {
                    this.pgy.setVisibility(8);
                }
            }
        }
        z = true;
        linearLayout = (LinearLayout) findViewById(com.tencent.mm.plugin.wxpay.a.f.wallet_order_info_favor_ll);
        if (z) {
        }
        linearLayout.setVisibility(8);
        if (this.mCZ != null) {
        }
        this.mAE.setClickable(false);
        this.mAE.setEnabled(false);
        if (this.mCZ == null) {
            this.pgy.setVisibility(8);
        }
    }

    private void bNL() {
        if (this.mCZ == null) {
            x.e("MicroMsg.WalletPayUI", "updatePaymentMethodForFavor mOrders is null");
            return;
        }
        boolean z;
        this.pgy.setVisibility(8);
        this.pgx.setVisibility(8);
        this.mAE.setText(com.tencent.mm.plugin.wxpay.a.i.wallet_pay);
        this.pgF.setVisibility(0);
        this.pgG.setVisibility(0);
        View findViewById = this.pgG.findViewById(com.tencent.mm.plugin.wxpay.a.f.balance_layout);
        View findViewById2 = this.pgG.findViewById(com.tencent.mm.plugin.wxpay.a.f.add_bankcard_layout);
        if ("CFT".equals(this.mCZ.ppb)) {
            findViewById2.setVisibility(8);
        } else {
            findViewById2.setVisibility(0);
        }
        CheckedTextView checkedTextView = (CheckedTextView) this.pgG.findViewById(com.tencent.mm.plugin.wxpay.a.f.balance_check);
        CheckedTextView checkedTextView2 = (CheckedTextView) this.pgG.findViewById(com.tencent.mm.plugin.wxpay.a.f.add_bank_check);
        findViewById.setEnabled(true);
        boolean z2;
        if (this.mCZ == null || this.mCZ.ppf == null || this.mCZ.ppf.size() <= 0) {
            z2 = false;
        } else if (this.mCZ.poP == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.oZH == null) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new 28(this, checkedTextView, checkedTextView2));
        }
        findViewById2.setOnClickListener(new 29(this, checkedTextView, checkedTextView2));
        this.pgF.setVisibility(0);
        this.pgG.setVisibility(0);
        if (this.pfz != null) {
            this.pgk = com.tencent.mm.plugin.wallet_core.ui.b.psB.a(this.mCZ);
            com.tencent.mm.plugin.wallet.a.h Pn = this.pgk.Pn(this.pfz.pnP);
            if (Pn != null && Pn.pdX == 0.0d) {
                this.pgG.setVisibility(8);
                this.pgF.setVisibility(8);
                z = true;
                this.pgH = true;
                if (z) {
                    this.pgH = false;
                }
                checkedTextView.setChecked(false);
                checkedTextView2.setChecked(true);
                x.i("MicroMsg.WalletPayUI", "updatePaymentMethodForFavor needbindcardtoshowfavinfo is " + this.mCZ.pph);
                if (this.mCZ.pph != 1) {
                    this.pgG.findViewById(com.tencent.mm.plugin.wxpay.a.f.discount_wording_layout).setVisibility(0);
                    ((TextView) this.pgG.findViewById(com.tencent.mm.plugin.wxpay.a.f.discount_wording)).setText(this.mCZ.ppi);
                    if (TextUtils.isEmpty(this.mCZ.ppj)) {
                        ((TextView) this.pgG.findViewById(com.tencent.mm.plugin.wxpay.a.f.favor_rule_wording)).setText("");
                    } else {
                        ((TextView) this.pgG.findViewById(com.tencent.mm.plugin.wxpay.a.f.favor_rule_wording)).setText(" (" + this.mCZ.ppj + ")");
                    }
                    if (!(this.oZH == null || !this.oZH.bOs() || TextUtils.isEmpty(this.oZH.field_forbidWord))) {
                        findViewById.setEnabled(false);
                        checkedTextView.setVisibility(8);
                        ((TextView) this.pgG.findViewById(com.tencent.mm.plugin.wxpay.a.f.balance_tips)).setText(this.oZH.field_forbidWord);
                    }
                } else {
                    this.pgG.findViewById(com.tencent.mm.plugin.wxpay.a.f.discount_wording_layout).setVisibility(8);
                    if (this.oZH != null && this.oZH.bOs() && !TextUtils.isEmpty(this.oZH.field_forbidWord)) {
                        findViewById.setEnabled(false);
                        checkedTextView.setVisibility(8);
                        ((TextView) this.pgG.findViewById(com.tencent.mm.plugin.wxpay.a.f.balance_tips)).setText(this.oZH.field_forbidWord);
                    } else if (this.oZH != null && this.oZH.bOs() && TextUtils.isEmpty(this.oZH.field_forbidWord) && !z2) {
                        checkedTextView.setChecked(true);
                        checkedTextView2.setChecked(false);
                        this.pgH = false;
                    }
                }
                bNM();
            }
        }
        z = false;
        this.pgH = true;
        if (z) {
            this.pgH = false;
        }
        checkedTextView.setChecked(false);
        checkedTextView2.setChecked(true);
        x.i("MicroMsg.WalletPayUI", "updatePaymentMethodForFavor needbindcardtoshowfavinfo is " + this.mCZ.pph);
        if (this.mCZ.pph != 1) {
            this.pgG.findViewById(com.tencent.mm.plugin.wxpay.a.f.discount_wording_layout).setVisibility(8);
            if (this.oZH != null && this.oZH.bOs() && !TextUtils.isEmpty(this.oZH.field_forbidWord)) {
                findViewById.setEnabled(false);
                checkedTextView.setVisibility(8);
                ((TextView) this.pgG.findViewById(com.tencent.mm.plugin.wxpay.a.f.balance_tips)).setText(this.oZH.field_forbidWord);
            } else if (this.oZH != null && this.oZH.bOs() && TextUtils.isEmpty(this.oZH.field_forbidWord) && !z2) {
                checkedTextView.setChecked(true);
                checkedTextView2.setChecked(false);
                this.pgH = false;
            }
        } else {
            this.pgG.findViewById(com.tencent.mm.plugin.wxpay.a.f.discount_wording_layout).setVisibility(0);
            ((TextView) this.pgG.findViewById(com.tencent.mm.plugin.wxpay.a.f.discount_wording)).setText(this.mCZ.ppi);
            if (TextUtils.isEmpty(this.mCZ.ppj)) {
                ((TextView) this.pgG.findViewById(com.tencent.mm.plugin.wxpay.a.f.favor_rule_wording)).setText("");
            } else {
                ((TextView) this.pgG.findViewById(com.tencent.mm.plugin.wxpay.a.f.favor_rule_wording)).setText(" (" + this.mCZ.ppj + ")");
            }
            if (!(this.oZH == null || !this.oZH.bOs() || TextUtils.isEmpty(this.oZH.field_forbidWord))) {
                findViewById.setEnabled(false);
                checkedTextView.setVisibility(8);
                ((TextView) this.pgG.findViewById(com.tencent.mm.plugin.wxpay.a.f.balance_tips)).setText(this.oZH.field_forbidWord);
            }
        }
        bNM();
    }

    private void bNM() {
        if (this.pgH) {
            this.mAE.setOnClickListener(new 2(this));
        } else {
            this.mAE.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    WalletPayUI.this.bNQ();
                }
            });
        }
    }

    public final void bNN() {
        double d;
        int i;
        com.tencent.mm.plugin.wallet.a.h Pn = this.pgk.Pn(this.pfz.pnP);
        List bPV = this.pgk.bPV();
        com.tencent.mm.plugin.wallet.a.f fVar = this.pgk.psv;
        CharSequence charSequence = "";
        if (Pn != null) {
            d = Pn.pef;
            if (d > 0.0d) {
                charSequence = Pn.peh;
                i = 1;
                if (!bi.oW(Pn.pei)) {
                    charSequence = charSequence + "," + Pn.pei;
                }
            } else {
                i = 0;
            }
        } else {
            i = 0;
            d = 0.0d;
        }
        if (i == 0 && bPV.size() > 0) {
            charSequence = charSequence + this.mController.tml.getString(com.tencent.mm.plugin.wxpay.a.i.wallet_pwd_dialog_more_favors);
        }
        if (d <= 0.0d || fVar == null || fVar.peb != 0) {
            this.pgt.setText(com.tencent.mm.wallet_core.ui.e.A(this.mCZ.mBj));
            this.pgw.setText(com.tencent.mm.wallet_core.ui.e.abX(this.mCZ.lNV));
            this.pgv.setVisibility(8);
        } else {
            if (Pn != null) {
                this.pgt.setText(com.tencent.mm.wallet_core.ui.e.A(Pn.pee));
            }
            this.pgw.setText(com.tencent.mm.wallet_core.ui.e.abX(this.mCZ.lNV));
            this.pgv.setText(com.tencent.mm.wallet_core.ui.e.e(this.mCZ.mBj, this.mCZ.lNV));
            this.pgv.setVisibility(0);
        }
        if (!bi.oW(charSequence)) {
            this.pgB.setText(charSequence);
        }
    }

    public final Authen bNO() {
        Authen authen = new Authen();
        if (bNP()) {
            authen.bWA = 3;
        } else {
            authen.bWA = 6;
        }
        if (!bi.oW(this.eWo)) {
            authen.pli = this.eWo;
        }
        if (this.oZH != null) {
            authen.lMW = this.oZH.field_bindSerial;
            authen.lMV = this.oZH.field_bankcardType;
        }
        if (this.pfz != null) {
            authen.plu = this.pfz.pnP;
            authen.plt = this.pfz.pnS;
        }
        authen.mpb = this.mCn;
        return authen;
    }

    public final boolean bNP() {
        if (this.oZH == null || this.mCZ == null || this.mCZ.pjA != 3) {
            if (this.mCZ == null || Bankcard.zj(this.mCZ.pjA)) {
                return false;
            }
            return true;
        } else if (this.oZH.bOv()) {
            return true;
        } else {
            return false;
        }
    }

    protected final void bNQ() {
        jo(true);
    }

    protected final void jo(boolean z) {
        boolean z2;
        if (z) {
            if (this.mCZ != null && this.mCZ.poX) {
                g.Ek();
                if (((Boolean) g.Ei().DT().get(196614, Boolean.valueOf(true))).booleanValue()) {
                    View inflate = getLayoutInflater().inflate(com.tencent.mm.plugin.wxpay.a.g.wallet_pay_oversea_tip, null);
                    final CheckBox checkBox = (CheckBox) inflate.findViewById(com.tencent.mm.plugin.wxpay.a.f.tips_cb);
                    TextView textView = (TextView) inflate.findViewById(com.tencent.mm.plugin.wxpay.a.f.network_tips_content);
                    textView.setText(Html.fromHtml(String.format(getResources().getString(com.tencent.mm.plugin.wxpay.a.i.wallet_pay_oversea_content), new Object[]{getResources().getString(com.tencent.mm.plugin.wxpay.a.i.wallet_agreen_oversea)})));
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                    ((TextView) inflate.findViewById(com.tencent.mm.plugin.wxpay.a.f.tips_tv)).setOnClickListener(new 19(this, checkBox));
                    com.tencent.mm.ui.widget.a.c a = h.a(this, getString(com.tencent.mm.plugin.wxpay.a.i.wallet_pay_oversea_title), inflate, getString(com.tencent.mm.plugin.wxpay.a.i.wallet_card_wx_check_agree), getString(com.tencent.mm.plugin.wxpay.a.i.wallet_refuse_message), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (checkBox.isChecked()) {
                                g.Ek();
                                g.Ei().DT().set(196614, Boolean.valueOf(false));
                            }
                            WalletPayUI.this.jo(false);
                        }
                    }, new 21(this));
                    a.setCancelable(false);
                    checkBox.setOnCheckedChangeListener(new 22(this, a));
                    z2 = false;
                    if (!z2) {
                        return;
                    }
                }
            }
            z2 = true;
            if (z2) {
                return;
            }
        }
        if (this.pfz != null) {
            this.pgk = com.tencent.mm.plugin.wallet_core.ui.b.psB.a(this.mCZ);
            com.tencent.mm.plugin.wallet.a.h Pn = this.pgk.Pn(this.pfz.pnP);
            if (Pn != null && Pn.pdX == 0.0d) {
                z2 = true;
                if (this.pgP != null) {
                    if (this.pgP.pfo == 0) {
                        x.i("MicroMsg.WalletPayUI", "need real name,stop");
                        a(this.pgP);
                        return;
                    } else if (this.pgP.pfo == 1 && r0) {
                        x.i("MicroMsg.WalletPayUI", "need real name, zero stop");
                        a(this.pgP);
                    }
                }
                if (this.pfp != null) {
                    if (this.pfp.peW == 1 && !bi.oW(this.pfp.kRu) && !bi.oW(this.pfp.kRv) && !bi.oW(this.pfp.peX)) {
                        if (!(this.mCn == null || this.mCZ == null || this.mCZ.ppf == null || this.mCZ.ppf.size() <= 0)) {
                            if (this.mCn.bVY == 8) {
                                com.tencent.mm.plugin.report.service.h.mEJ.h(15368, new Object[]{Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1), ((Commodity) this.mCZ.ppf.get(0)).bOe});
                            } else {
                                com.tencent.mm.plugin.report.service.h.mEJ.h(15368, new Object[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), ((Commodity) this.mCZ.ppf.get(0)).bOe});
                            }
                        }
                        h.a(this.mController.tml, this.pfp.peX, "", this.pfp.kRv, this.pfp.kRu, false, new 4(this), new 5(this));
                        return;
                    } else if (!(this.pfp.peW != 2 || bi.oW(this.pfp.peX) || bi.oW(this.pfp.peY))) {
                        x.i("MicroMsg.WalletPayUI", "pay has been blocked");
                        if (!(this.mCn == null || this.mCZ == null || this.mCZ.ppf == null || this.mCZ.ppf.size() <= 0)) {
                            if (this.mCn.bVY == 8) {
                                com.tencent.mm.plugin.report.service.h.mEJ.h(15368, new Object[]{Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), ((Commodity) this.mCZ.ppf.get(0)).bOe});
                            } else {
                                com.tencent.mm.plugin.report.service.h.mEJ.h(15368, new Object[]{Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), ((Commodity) this.mCZ.ppf.get(0)).bOe});
                            }
                        }
                        h.a(this.mController.tml, this.pfp.peX, "", this.pfp.peY, false, new 6(this));
                        return;
                    }
                }
                bNR();
            }
        }
        z2 = false;
        if (this.pgP != null) {
            if (this.pgP.pfo == 0) {
                x.i("MicroMsg.WalletPayUI", "need real name,stop");
                a(this.pgP);
                return;
            } else if (this.pgP.pfo == 1 && r0) {
                x.i("MicroMsg.WalletPayUI", "need real name, zero stop");
                a(this.pgP);
            }
        }
        if (this.pfp != null) {
            if (this.pfp.peW == 1 && !bi.oW(this.pfp.kRu) && !bi.oW(this.pfp.kRv) && !bi.oW(this.pfp.peX)) {
                if (!(this.mCn == null || this.mCZ == null || this.mCZ.ppf == null || this.mCZ.ppf.size() <= 0)) {
                    if (this.mCn.bVY == 8) {
                        com.tencent.mm.plugin.report.service.h.mEJ.h(15368, new Object[]{Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1), ((Commodity) this.mCZ.ppf.get(0)).bOe});
                    } else {
                        com.tencent.mm.plugin.report.service.h.mEJ.h(15368, new Object[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), ((Commodity) this.mCZ.ppf.get(0)).bOe});
                    }
                }
                h.a(this.mController.tml, this.pfp.peX, "", this.pfp.kRv, this.pfp.kRu, false, new 4(this), new 5(this));
                return;
            } else if (!(this.pfp.peW != 2 || bi.oW(this.pfp.peX) || bi.oW(this.pfp.peY))) {
                x.i("MicroMsg.WalletPayUI", "pay has been blocked");
                if (!(this.mCn == null || this.mCZ == null || this.mCZ.ppf == null || this.mCZ.ppf.size() <= 0)) {
                    if (this.mCn.bVY == 8) {
                        com.tencent.mm.plugin.report.service.h.mEJ.h(15368, new Object[]{Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), ((Commodity) this.mCZ.ppf.get(0)).bOe});
                    } else {
                        com.tencent.mm.plugin.report.service.h.mEJ.h(15368, new Object[]{Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), ((Commodity) this.mCZ.ppf.get(0)).bOe});
                    }
                }
                h.a(this.mController.tml, this.pfp.peX, "", this.pfp.peY, false, new 6(this));
                return;
            }
        }
        bNR();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void bNR() {
        /*
        r12 = this;
        r11 = 5;
        r10 = 3;
        r6 = 2;
        r1 = 1;
        r0 = 0;
        r2 = com.tencent.mm.plugin.report.service.h.mEJ;
        r3 = 13958; // 0x3686 float:1.956E-41 double:6.896E-320;
        r4 = new java.lang.Object[r1];
        r5 = java.lang.Integer.valueOf(r1);
        r4[r0] = r5;
        r2.h(r3, r4);
        r2 = r12.mCn;
        if (r2 == 0) goto L_0x005b;
    L_0x0018:
        r2 = 8;
        r3 = r12.mCn;
        r3 = r3.bVY;
        if (r2 != r3) goto L_0x005b;
    L_0x0020:
        r2 = com.tencent.mm.plugin.report.service.h.mEJ;
        r3 = 13955; // 0x3683 float:1.9555E-41 double:6.8947E-320;
        r4 = new java.lang.Object[r1];
        r5 = java.lang.Integer.valueOf(r6);
        r4[r0] = r5;
        r2.h(r3, r4);
        r2 = r12.mCn;
        r2 = r2.qUL;
        if (r2 == 0) goto L_0x005b;
    L_0x0035:
        r2 = r12.mCn;
        r2 = r2.qUL;
        r3 = "extinfo_key_9";
        r2 = r2.getLong(r3);
        r4 = com.tencent.mm.plugin.report.service.h.mEJ;
        r5 = 13956; // 0x3684 float:1.9557E-41 double:6.895E-320;
        r6 = new java.lang.Object[r6];
        r7 = java.lang.Integer.valueOf(r1);
        r6[r0] = r7;
        r8 = java.lang.System.currentTimeMillis();
        r2 = r8 - r2;
        r2 = java.lang.Long.valueOf(r2);
        r6[r1] = r2;
        r4.h(r5, r6);
    L_0x005b:
        r2 = r12.pfz;
        if (r2 == 0) goto L_0x0268;
    L_0x005f:
        r2 = com.tencent.mm.plugin.wallet_core.ui.b.psB;
        r3 = r12.mCZ;
        r2 = r2.a(r3);
        r12.pgk = r2;
        r2 = r12.pgk;
        r3 = r12.pfz;
        r3 = r3.pnP;
        r2 = r2.Pn(r3);
        if (r2 == 0) goto L_0x0268;
    L_0x0075:
        r2 = r2.pdX;
        r4 = 0;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 != 0) goto L_0x0268;
    L_0x007d:
        if (r1 == 0) goto L_0x00c1;
    L_0x007f:
        com.tencent.mm.plugin.wallet.a.p.bNp();
        r1 = com.tencent.mm.plugin.wallet.a.p.bNq();
        r1 = r1.bPt();
        if (r1 == 0) goto L_0x00b4;
    L_0x008c:
        r1 = "MicroMsg.WalletPayUI";
        r2 = "payWithoutPassword zeroPay";
        com.tencent.mm.sdk.platformtools.x.i(r1, r2);
        r1 = r12.mCn;
        if (r1 != 0) goto L_0x00aa;
    L_0x0099:
        r1 = r12.mCn;
        if (r1 != 0) goto L_0x00af;
    L_0x009d:
        r1 = "";
    L_0x00a0:
        r2 = "";
        com.tencent.mm.wallet_core.c.u.d(r0, r1, r10, r2);
        r12.bNS();
    L_0x00a9:
        return;
    L_0x00aa:
        r0 = r12.mCn;
        r0 = r0.bVY;
        goto L_0x0099;
    L_0x00af:
        r1 = r12.mCn;
        r1 = r1.bOd;
        goto L_0x00a0;
    L_0x00b4:
        r0 = "MicroMsg.WalletPayUI";
        r1 = "has useful bankcard ! payWithOldBankcard zeroPay";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r12.bNC();
        goto L_0x00a9;
    L_0x00c1:
        r1 = r12.pgo;
        if (r1 == 0) goto L_0x013c;
    L_0x00c5:
        r1 = "MicroMsg.WalletPayUI";
        r2 = "hy: start do pay with force use given bankcard";
        com.tencent.mm.sdk.platformtools.x.i(r1, r2);
        r1 = r12.pgp;
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r1 != 0) goto L_0x00e0;
    L_0x00d6:
        r0 = r12.bNU();
        r12.oZH = r0;
        r12.bNC();
        goto L_0x00a9;
    L_0x00e0:
        com.tencent.mm.plugin.wallet.a.p.bNp();
        r1 = com.tencent.mm.plugin.wallet.a.p.bNq();
        r1 = r1.bPp();
        if (r1 == 0) goto L_0x0112;
    L_0x00ed:
        r1 = r12.mCn;
        if (r1 != 0) goto L_0x0108;
    L_0x00f1:
        r1 = r0;
    L_0x00f2:
        r2 = r12.mCn;
        if (r2 != 0) goto L_0x010d;
    L_0x00f6:
        r2 = "";
    L_0x00f9:
        r3 = 17;
        r4 = "";
        com.tencent.mm.wallet_core.c.u.d(r1, r2, r3, r4);
    L_0x0101:
        r1 = "";
        r12.b(r0, r0, r1);
        goto L_0x00a9;
    L_0x0108:
        r1 = r12.mCn;
        r1 = r1.bVY;
        goto L_0x00f2;
    L_0x010d:
        r2 = r12.mCn;
        r2 = r2.bOd;
        goto L_0x00f9;
    L_0x0112:
        com.tencent.mm.plugin.wallet.a.p.bNp();
        r1 = com.tencent.mm.plugin.wallet.a.p.bNq();
        r1 = r1.bPt();
        if (r1 == 0) goto L_0x0101;
    L_0x011f:
        r1 = r12.mCn;
        if (r1 != 0) goto L_0x0132;
    L_0x0123:
        r1 = r0;
    L_0x0124:
        r2 = r12.mCn;
        if (r2 != 0) goto L_0x0137;
    L_0x0128:
        r2 = "";
    L_0x012b:
        r3 = "";
        com.tencent.mm.wallet_core.c.u.d(r1, r2, r11, r3);
        goto L_0x0101;
    L_0x0132:
        r1 = r12.mCn;
        r1 = r1.bVY;
        goto L_0x0124;
    L_0x0137:
        r2 = r12.mCn;
        r2 = r2.bOd;
        goto L_0x012b;
    L_0x013c:
        r1 = r12.getIntent();
        r2 = "key_is_use_default_card";
        r1 = r1.getStringExtra(r2);
        r2 = "";
        r1 = com.tencent.mm.sdk.platformtools.bi.aG(r1, r2);
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r2 != 0) goto L_0x015a;
    L_0x0154:
        r1 = OS(r1);
        r12.oZH = r1;
    L_0x015a:
        r1 = r12.oZH;
        if (r1 != 0) goto L_0x01e3;
    L_0x015e:
        r1 = r12.oZG;
        if (r1 == 0) goto L_0x017d;
    L_0x0162:
        r1 = r12.oZG;
        r1 = r1.size();
        if (r1 <= 0) goto L_0x017d;
    L_0x016a:
        r1 = "MicroMsg.WalletPayUI";
        r2 = " no last pay bankcard ! jump to select bankcard!";
        com.tencent.mm.sdk.platformtools.x.i(r1, r2);
        r1 = 8;
        r2 = "";
        r12.c(r0, r1, r2);
        goto L_0x00a9;
    L_0x017d:
        r1 = "MicroMsg.WalletPayUI";
        r2 = "default bankcard not found! payWithNewBankcard";
        com.tencent.mm.sdk.platformtools.x.i(r1, r2);
        com.tencent.mm.plugin.wallet.a.p.bNp();
        r1 = com.tencent.mm.plugin.wallet.a.p.bNq();
        r1 = r1.bPp();
        if (r1 == 0) goto L_0x01b9;
    L_0x0193:
        r1 = r12.mCn;
        if (r1 != 0) goto L_0x01af;
    L_0x0197:
        r1 = r0;
    L_0x0198:
        r2 = r12.mCn;
        if (r2 != 0) goto L_0x01b4;
    L_0x019c:
        r2 = "";
    L_0x019f:
        r3 = 17;
        r4 = "";
        com.tencent.mm.wallet_core.c.u.d(r1, r2, r3, r4);
    L_0x01a7:
        r1 = "";
        r12.b(r0, r0, r1);
        goto L_0x00a9;
    L_0x01af:
        r1 = r12.mCn;
        r1 = r1.bVY;
        goto L_0x0198;
    L_0x01b4:
        r2 = r12.mCn;
        r2 = r2.bOd;
        goto L_0x019f;
    L_0x01b9:
        com.tencent.mm.plugin.wallet.a.p.bNp();
        r1 = com.tencent.mm.plugin.wallet.a.p.bNq();
        r1 = r1.bPt();
        if (r1 == 0) goto L_0x01a7;
    L_0x01c6:
        r1 = r12.mCn;
        if (r1 != 0) goto L_0x01d9;
    L_0x01ca:
        r1 = r0;
    L_0x01cb:
        r2 = r12.mCn;
        if (r2 != 0) goto L_0x01de;
    L_0x01cf:
        r2 = "";
    L_0x01d2:
        r3 = "";
        com.tencent.mm.wallet_core.c.u.d(r1, r2, r11, r3);
        goto L_0x01a7;
    L_0x01d9:
        r1 = r12.mCn;
        r1 = r1.bVY;
        goto L_0x01cb;
    L_0x01de:
        r2 = r12.mCn;
        r2 = r2.bOd;
        goto L_0x01d2;
    L_0x01e3:
        r1 = r12.oZH;
        r2 = r12.mCZ;
        r2 = r2.pjA;
        r3 = r12.mCZ;
        r1 = r1.a(r2, r3);
        r2 = r12.myP;
        if (r2 == 0) goto L_0x01fd;
    L_0x01f3:
        r2 = r12.myP;
        r3 = 10002; // 0x2712 float:1.4016E-41 double:4.9416E-320;
        r4 = "";
        r2.aM(r3, r4);
    L_0x01fd:
        if (r1 == 0) goto L_0x0224;
    L_0x01ff:
        r2 = "MicroMsg.WalletPayUI";
        r3 = new java.lang.StringBuilder;
        r4 = "main bankcard(";
        r3.<init>(r4);
        r3 = r3.append(r1);
        r4 = ") is useless! jump to select bankcard!";
        r3 = r3.append(r4);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);
        r2 = "";
        r12.c(r0, r1, r2);
        goto L_0x00a9;
    L_0x0224:
        com.tencent.mm.plugin.wallet.a.p.bNp();
        r1 = com.tencent.mm.plugin.wallet.a.p.bNq();
        r1 = r1.bPt();
        if (r1 == 0) goto L_0x025a;
    L_0x0231:
        r1 = "MicroMsg.WalletPayUI";
        r2 = "payWithoutPassword";
        com.tencent.mm.sdk.platformtools.x.i(r1, r2);
        r1 = r12.mCn;
        if (r1 != 0) goto L_0x0250;
    L_0x023e:
        r1 = r12.mCn;
        if (r1 != 0) goto L_0x0255;
    L_0x0242:
        r1 = "";
    L_0x0245:
        r2 = "";
        com.tencent.mm.wallet_core.c.u.d(r0, r1, r10, r2);
        r12.bNS();
        goto L_0x00a9;
    L_0x0250:
        r0 = r12.mCn;
        r0 = r0.bVY;
        goto L_0x023e;
    L_0x0255:
        r1 = r12.mCn;
        r1 = r1.bOd;
        goto L_0x0245;
    L_0x025a:
        r0 = "MicroMsg.WalletPayUI";
        r1 = "has useful bankcard ! payWithOldBankcard";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r12.bNC();
        goto L_0x00a9;
    L_0x0268:
        r1 = r0;
        goto L_0x007d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.bNR():void");
    }

    private void bNS() {
        jp(true);
        com.tencent.mm.plugin.wallet_core.e.c.bQW();
    }

    public void bNC() {
        boolean z = false;
        if (ZB()) {
            x.i("MicroMsg.WalletPayUI", "pay with old bankcard! from statck %s", new Object[]{bi.cjd().toString()});
            u.d(this.mCn == null ? 0 : this.mCn.bVY, this.mCn == null ? "" : this.mCn.bOd, 8, "");
            if (!this.pgo) {
                z = true;
            }
            this.oZD = o.a(this, z, this.mCZ, this.pfz, this.oZH, this.mCn, this.mzk, new 7(this), new 8(this), new 9(this));
            this.pfB = this.oZD;
        }
    }

    public final void b(boolean z, int i, String str) {
        StringBuilder stringBuilder = new StringBuilder("pay with new bankcard! user's wxpay register status :");
        p.bNp();
        x.d("MicroMsg.WalletPayUI", stringBuilder.append(p.bNq().bPs()).append(", need confirm ? ").append(z).toString());
        if (z) {
            String P;
            if (bi.oW(str)) {
                P = Bankcard.P(this, i);
            } else {
                P = str;
            }
            h.a(this, P, "", getString(com.tencent.mm.plugin.wxpay.a.i.wallet_pay_bankcard_add), getString(com.tencent.mm.plugin.wxpay.a.i.app_cancel), new 10(this), new 11(this));
            return;
        }
        bNT();
    }

    public final void c(boolean z, int i, String str) {
        x.d("MicroMsg.WalletPayUI", "pay with select bankcard! need confirm ? " + z);
        if (z) {
            String P;
            if (bi.oW(str)) {
                P = Bankcard.P(this, i);
            } else {
                P = str;
            }
            h.a(this, P, "", getString(com.tencent.mm.plugin.wxpay.a.i.wallet_pay_bankcard_select), getString(com.tencent.mm.plugin.wxpay.a.i.app_cancel), new 13(this, i), new 14(this));
            return;
        }
        W(i, false);
    }

    protected final void bNT() {
        Bundle extras = getIntent().getExtras();
        String str = "key_pay_flag";
        p.bNp();
        extras.putInt(str, p.bNq().bPs() ? 2 : 1);
        extras.putParcelable("key_orders", this.mCZ);
        extras.putParcelable("key_pay_info", this.mCn);
        extras.putParcelable("key_favor_pay_info", this.pfz);
        J(extras);
    }

    protected final void W(int i, boolean z) {
        int i2 = 0;
        com.tencent.mm.plugin.report.service.h.mEJ.h(13958, new Object[]{Integer.valueOf(2)});
        com.tencent.mm.plugin.report.service.h.mEJ.h(13955, new Object[]{Integer.valueOf(4)});
        if (this.mCn != null) {
            i2 = this.mCn.bVY;
        }
        u.d(i2, this.mCn == null ? "" : this.mCn.bOd, 11, "");
        Bundle bundle = this.sy;
        bundle.putInt("key_main_bankcard_state", i);
        bundle.putParcelable("key_orders", this.mCZ);
        bundle.putParcelable("key_pay_info", this.mCn);
        bundle.putParcelable("key_authen", bNO());
        bundle.putString("key_pwd1", this.eWo);
        bundle.putInt("key_pay_flag", 3);
        bundle.putInt("key_err_code", -1004);
        bundle.putParcelable("key_favor_pay_info", this.pfz);
        bundle.putBoolean("key_is_filter_bank_type", z);
        if (this.oZH != null) {
            bundle.putString("key_is_cur_bankcard_bind_serial", this.oZH.field_bindSerial);
        }
        J(bundle);
    }

    public boolean d(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.WalletPayUI", "errorType %s errCode %s, errmsg %s, scene %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, lVar});
        com.tencent.mm.plugin.wallet.pay.a.a.b bVar;
        Bundle bundle;
        Bundle bundle2;
        if (i == 0 && i2 == 0) {
            if (lVar instanceof e) {
                com.tencent.mm.plugin.report.service.h hVar;
                Object[] objArr;
                long j;
                e eVar = (e) lVar;
                x.i("MicroMsg.WalletPayUI", "stopRealname realnameGuideFlag %s guide_type %s", new Object[]{eVar.ced, Integer.valueOf(eVar.pfo)});
                if ("1".equals(eVar.ced) || "2".equals(eVar.ced)) {
                    this.pgP = eVar;
                } else {
                    this.pgP = null;
                }
                this.pfp = eVar.pfp;
                this.pgN = true;
                this.mCZ = ((e) lVar).mCZ;
                this.mCount = this.mCZ != null ? this.mCZ.ppf.size() : 0;
                x.d("MicroMsg.WalletPayUI", "get mOrders! bankcardTag : " + (this.mCZ != null ? Integer.valueOf(this.mCZ.pjA) : ""));
                ZB();
                if (!(this.mCZ == null || this.mCZ.ppg == null)) {
                    this.pgk = com.tencent.mm.plugin.wallet_core.ui.b.psB.a(this.mCZ);
                    if (this.pgk != null) {
                        if (this.pgk.bPV().size() > 0) {
                            this.pgl = true;
                        }
                        this.pfz = this.pgk.Pq(this.mCZ.ppg.pdY);
                        this.pfz.pnP = this.pgk.Pr(this.pfz.pnP);
                        x.i("MicroMsg.WalletPayUI", "onSceneEnd init favInfo id favorComposeId %s selectedFavorCompId %s selectedFavorCompId %s  mFavorPayInfo %s", new Object[]{this.mCZ.ppg.pdY, this.pfz.pnP, this.pfz.pnP, this.pfz.toString()});
                    }
                }
                if (!(this.mCZ == null || this.oZG == null || this.mCn == null)) {
                    com.tencent.mm.plugin.wallet_core.e.c.a(this.mCn, this.mCZ);
                    hVar = com.tencent.mm.plugin.report.service.h.mEJ;
                    objArr = new Object[5];
                    objArr[0] = Integer.valueOf(this.mCn.bVY);
                    objArr[1] = Integer.valueOf(0);
                    p.bNp();
                    objArr[2] = Integer.valueOf(p.bNq().bPs() ? 2 : 1);
                    objArr[3] = Integer.valueOf((int) (this.mCZ.mBj * 100.0d));
                    objArr[4] = this.mCZ.lNV;
                    hVar.h(10690, objArr);
                }
                if (!(this.mCZ == null || this.mCZ.ppf == null)) {
                    LinkedList linkedList = new LinkedList();
                    for (Commodity commodity : this.mCZ.ppf) {
                        linkedList.add(commodity.bOe);
                    }
                    if (linkedList.size() > 0) {
                        td tdVar = new td();
                        tdVar.ceE.ceG = linkedList;
                        com.tencent.mm.sdk.b.a.sFg.m(tdVar);
                        if (this.myP != null) {
                            this.myP.aM(10001, (String) linkedList.get(0));
                        }
                    }
                }
                p.bNp();
                this.oZG = p.bNq().jl(bNz());
                p.bNp();
                this.oZH = p.bNq().a(null, null, bNz(), false);
                String aG = bi.aG(getIntent().getStringExtra("key_is_use_default_card"), "");
                if (!bi.oW(aG)) {
                    this.oZH = OS(aG);
                }
                this.mAE.setClickable(true);
                if (bi.oW(com.tencent.mm.plugin.wallet_core.model.o.bOW().prN)) {
                    this.pgA.setVisibility(8);
                    this.pgA.setText("");
                } else {
                    this.pgA.setVisibility(0);
                    this.pgA.setText(com.tencent.mm.plugin.wallet_core.model.o.bOW().prN);
                }
                if (!(this.mCZ == null || this.oZG == null || this.mCn == null)) {
                    com.tencent.mm.plugin.wallet_core.e.c.a(this.mCn, this.mCZ);
                    hVar = com.tencent.mm.plugin.report.service.h.mEJ;
                    objArr = new Object[5];
                    objArr[0] = Integer.valueOf(this.mCn.bVY);
                    objArr[1] = Integer.valueOf(0);
                    p.bNp();
                    objArr[2] = Integer.valueOf(p.bNq().bPs() ? 2 : 1);
                    objArr[3] = Integer.valueOf((int) (this.mCZ.mBj * 100.0d));
                    objArr[4] = this.mCZ.lNV;
                    hVar.h(10690, objArr);
                }
                if (this.pgI) {
                    W(0, false);
                }
                if (bNW().qUL == null) {
                    j = 0;
                } else {
                    j = bNW().qUL.getLong("wallet_pay_key_check_time");
                }
                if (j > 0) {
                    com.tencent.mm.plugin.report.service.h.mEJ.a(641, 4, 1, true);
                    com.tencent.mm.plugin.report.service.h.mEJ.a(641, 5, bi.bH(j), true);
                }
                if (this.pgS > 0) {
                    com.tencent.mm.plugin.report.service.h.mEJ.a(641, 7, 1, true);
                    com.tencent.mm.plugin.report.service.h.mEJ.a(641, 8, bi.bH(this.pgS), true);
                }
            } else if (lVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
                bVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) lVar;
                bundle = this.sy;
                bundle.putParcelable("key_pay_info", this.mCn);
                bundle.putParcelable("key_bankcard", this.oZH);
                bundle.putString("key_bank_type", this.oZH.field_bankcardType);
                if (!bi.oW(this.eWo)) {
                    bundle.putString("key_pwd1", this.eWo);
                }
                bundle.putString("kreq_token", bVar.token);
                bundle.putParcelable("key_authen", bVar.pfc);
                bundle.putBoolean("key_need_verify_sms", !bVar.pfa);
                bundle.putInt("key_can_verify_tail", bVar.pfg);
                bundle.putString("key_verify_tail_wording", bVar.pfh);
                this.sy.putBoolean("key_block_bind_new_card", bVar.pfi == 1);
                if (bi.oW(bVar.pfd)) {
                    bundle.putString("key_mobile", this.oZH.field_mobile);
                } else {
                    bundle.putString("key_mobile", bVar.pfd);
                }
                bundle.putString("key_QADNA_URL", bVar.pfe);
                if (bVar.pgm) {
                    if (this.myP != null) {
                        this.myP.aM(10003, "");
                        com.tencent.mm.plugin.wallet.a aVar = this.myP;
                        com.tencent.mm.plugin.report.service.h.mEJ.h(13455, new Object[]{aVar.oYu, Long.valueOf(System.currentTimeMillis()), aVar.oYv});
                    }
                    bundle.putParcelable("key_orders", bVar.pfb);
                    if (this.mCn != null) {
                        x.i("MicroMsg.WalletPayUI", "payscene %d", new Object[]{Integer.valueOf(this.mCn.bVY)});
                        if (8 == this.mCn.bVY) {
                            g.Ek();
                            g.Ei().DT().a(aa.a.sUp, Boolean.valueOf(true));
                        }
                    }
                } else {
                    bundle.putParcelable("key_orders", this.mCZ);
                }
                bundle2 = new Bundle();
                bundle2.putString("pwd", this.eWo);
                ((k) g.l(k.class)).a(bVar.bNu(), true, bundle2);
                bundle.putInt("key_pay_flag", 3);
                RealnameGuideHelper realnameGuideHelper = bVar.lJN;
                if (realnameGuideHelper != null) {
                    bundle.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                }
                J(bundle);
                return true;
            }
            aL();
            return true;
        }
        if (lVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
            bundle2 = new Bundle();
            bundle2.putString("pwd", this.eWo);
            ((k) g.l(k.class)).a(this.mCn.pxN == 1, false, bundle2);
            switch (i2) {
                case 402:
                case TbsListener$ErrorCode.INFO_MISS_SDKEXTENSION_JAR /*403*/:
                case TbsListener$ErrorCode.INFO_CAN_NOT_DISABLED_BY_CRASH /*408*/:
                    String string;
                    bVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) lVar;
                    this.pgr = this.sy;
                    this.pgr.putParcelable("key_pay_info", this.mCn);
                    this.pgr.putParcelable("key_bankcard", this.oZH);
                    if (!bi.oW(this.eWo)) {
                        this.pgr.putString("key_pwd1", this.eWo);
                    }
                    this.pgr.putString("kreq_token", bVar.token);
                    this.pgr.putParcelable("key_authen", bVar.pfc);
                    this.pgr.putBoolean("key_need_verify_sms", !bVar.pfa);
                    this.pgr.putString("key_mobile", this.oZH.field_mobile);
                    this.pgr.putInt("key_err_code", i2);
                    this.pgr.putParcelable("key_orders", this.mCZ);
                    if (bi.oW(str)) {
                        string = getString(com.tencent.mm.plugin.wxpay.a.i.wallet_pay_reset_info_tips, new Object[]{this.oZH.field_desc, this.oZH.field_mobile});
                    } else {
                        string = str;
                    }
                    h.a(this, string, "", getString(com.tencent.mm.plugin.wxpay.a.i.wallet_pay_reset_info), getString(com.tencent.mm.plugin.wxpay.a.i.app_cancel), new 15(this), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (WalletPayUI.this.bbR()) {
                                WalletPayUI.this.finish();
                            }
                        }
                    });
                    return true;
                case TbsListener$ErrorCode.INFO_DISABLE_X5 /*404*/:
                    if (!(this.oZH == null || this.mCZ == null)) {
                        this.oZH.plU = this.mCZ.bOd;
                        if (this.oZG == null || this.oZG.size() <= 1) {
                            b(true, 4, str);
                        } else {
                            c(true, 4, str);
                        }
                        return true;
                    }
                    break;
                case 100000:
                case 100001:
                case 100102:
                    this.mCn.qUM = i2;
                    bNC();
                    return true;
                case 100100:
                case 100101:
                    this.mCn.qUM = i2;
                    boolean z = false;
                    if (i2 == 100100) {
                        z = true;
                    }
                    if (this.pfA == null) {
                        this.pfA = new a(this, this);
                    }
                    this.pfA.a(z, this.mCn.bPZ, this.mCn.bOd);
                    x.i("MicroMsg.WalletPayUI", "mRegenFingerPrintRsaKey.genRsaKey isGenRsa is " + z);
                    return true;
            }
        } else if (lVar instanceof e) {
            this.pgN = true;
            bNV();
            if (i2 == 416) {
                x.e("MicroMsg.WalletPayUI", "errCode is 416 need real name verify!");
                this.pgK = true;
                bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".pay.ui.WalletPayUI");
                bundle.putString("realname_verify_process_jump_plugin", "wallet");
                return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, i2, lVar, bundle, this.mCn != null ? this.mCn.bVY : 0);
            }
            x.i("MicroMsg.WalletPayUI", "errCode is %d , not need real name verify!", new Object[]{Integer.valueOf(i2)});
        }
        return false;
    }

    public final boolean bbU() {
        return false;
    }

    public final boolean ZB() {
        if (this.mCZ == null || this.mCZ.ppf == null || this.mCZ.ppf.size() <= 0) {
            x.w("MicroMsg.WalletPayUI", "mOrders info is Illegal!");
            h.a(this.mController.tml, com.tencent.mm.plugin.wxpay.a.i.wallet_order_info_err, 0, new 17(this));
            return false;
        } else if (!this.pgo || bi.oW(this.pgp) || bNU() != null) {
            return true;
        } else {
            x.w("MicroMsg.WalletPayUI", "hy: should use given bankcard, but resolved as null. show error msg and quit");
            h.a(this.mController.tml, com.tencent.mm.plugin.wxpay.a.i.wallet_order_info_err, 0, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    WalletPayUI.this.finish();
                }
            });
            return false;
        }
    }

    private Bankcard bNU() {
        p.bNp();
        ArrayList jl = p.bNq().jl(true);
        if (jl.size() != 0) {
            Iterator it = jl.iterator();
            while (it.hasNext()) {
                Bankcard bankcard = (Bankcard) it.next();
                if (bi.oV(this.pgp).equals(bankcard.field_bindSerial)) {
                    x.i("MicroMsg.WalletPayUI", "hy: get given bankcard");
                    return bankcard;
                }
            }
        }
        return null;
    }

    private static Bankcard OS(String str) {
        p.bNp();
        ArrayList jl = p.bNq().jl(true);
        if (jl.size() != 0) {
            Iterator it = jl.iterator();
            while (it.hasNext()) {
                Bankcard bankcard = (Bankcard) it.next();
                if (bi.oV(str).equals(bankcard.field_bindSerial)) {
                    x.i("MicroMsg.WalletPayUI", "hy: get given bankcard");
                    return bankcard;
                }
            }
        }
        return null;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.WalletPayUI", "onAcvityResult requestCode:" + i + ", resultCode:" + i2);
        switch (i) {
            case 0:
                if (i2 == -1) {
                    if (intent != null) {
                        this.pgM = intent.getIntExtra("auto_deduct_flag", -1);
                        this.mCZ.ppk.pgM = this.pgM;
                        bNW().qUO = this.pgM;
                        if (this.pgM == 1) {
                            bNW().qUP = intent.getStringExtra("deduct_bank_type");
                            bNW().qUQ = intent.getStringExtra("deduct_bind_serial");
                        }
                    }
                    this.pgL = true;
                    aWj();
                } else {
                    finish();
                }
                com.tencent.mm.plugin.report.service.h.mEJ.h(13958, new Object[]{Integer.valueOf(3)});
                return;
            default:
                return;
        }
    }

    protected final boolean aWj() {
        x.i("MicroMsg.WalletPayUI", "onProgressFinish isFromH5RealNameVerify %s", new Object[]{Boolean.valueOf(this.pgQ)});
        com.tencent.mm.sdk.b.a.sFg.m(new sw());
        boolean z = (this.mCZ == null || this.mCZ.ppk == null || this.pgL) ? false : true;
        if (!(z || bNV())) {
            u.d(this.mCn == null ? 0 : this.mCn.bVY, this.mCn == null ? "" : this.mCn.bOd, 2, "");
        }
        if (this.pgQ) {
            jo(true);
            return true;
        } else if (this.pgK) {
            return true;
        } else {
            if (z) {
                Intent intent = new Intent(this, WalletPayDeductUI.class);
                intent.putExtra("orders", this.mCZ);
                startActivityForResult(intent, 0);
                return true;
            } else if (this.mController.contentView.getVisibility() != 0) {
                if (!this.pgs && ZB()) {
                    jo(true);
                    this.pgs = true;
                }
                return true;
            } else if (this.mController.contentView.getVisibility() != 0 || this.mCZ == null || this.mCZ.ppk == null || !this.mAE.isEnabled() || this.pgO) {
                return false;
            } else {
                this.mAE.performClick();
                this.pgO = true;
                return false;
            }
        }
    }

    public final boolean bbR() {
        if (this.pgN) {
            String str = "MicroMsg.WalletPayUI";
            String str2 = "case 1 %s,  stack %s";
            Object[] objArr = new Object[2];
            boolean z = bNW() == null || !bNW().jNf;
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = bi.cjd().toString();
            x.i(str, str2, objArr);
            str = "MicroMsg.WalletPayUI";
            str2 = "case 2 %s,";
            objArr = new Object[1];
            p.bNp();
            if (p.bNq().bPs()) {
                z = false;
            } else {
                z = true;
            }
            objArr[0] = Boolean.valueOf(z);
            x.d(str, str2, objArr);
            str = "MicroMsg.WalletPayUI";
            str2 = "case 3 mBankcardList %s, mDefaultBankcard %s";
            objArr = new Object[2];
            objArr[0] = Integer.valueOf(this.oZG == null ? 0 : this.oZG.size());
            objArr[1] = this.oZH == null ? "" : this.oZH.field_forbidWord;
            x.d(str, str2, objArr);
            if (bNW() == null || !bNW().jNf) {
                x.i("MicroMsg.WalletPayUI", "get isTransparent1");
                return false;
            }
            p.bNp();
            if (!p.bNq().bPs()) {
                x.i("MicroMsg.WalletPayUI", "get isTransparent2");
                return false;
            } else if (this.oZG == null || (this.oZG.size() != 0 && (this.oZH == null || bi.oW(this.oZH.field_forbidWord)))) {
                x.i("MicroMsg.WalletPayUI", "get isTransparent4");
                return true;
            } else {
                str = "MicroMsg.WalletPayUI";
                str2 = "get isTransparent3 1 %s 2 %s";
                objArr = new Object[2];
                z = this.oZG != null && this.oZG.size() == 0;
                objArr[0] = Boolean.valueOf(z);
                z = (this.oZH == null || bi.oW(this.oZH.field_forbidWord)) ? false : true;
                objArr[1] = Boolean.valueOf(z);
                x.i(str, str2, objArr);
                return false;
            }
        }
        x.i("MicroMsg.WalletPayUI", "get isTransparent5");
        return true;
    }

    private boolean bNV() {
        if (bbR()) {
            ux(4);
            return false;
        }
        ux(0);
        return true;
    }

    protected final boolean bND() {
        return true;
    }

    public final void rj(int i) {
        if (i == 0) {
            if (bbR()) {
                finish();
            }
        } else if (i == 1) {
            bNC();
        }
    }

    public void jp(boolean z) {
        l a = com.tencent.mm.plugin.wallet.pay.a.a.a(bNO(), this.mCZ, z);
        if (this.mCZ != null) {
            Bundle bundle = new Bundle();
            bundle.putString("key_reqKey", this.mCZ.bOd);
            if (this.mCZ.ppf != null && this.mCZ.ppf.size() > 0) {
                bundle.putString("key_TransId", ((Commodity) this.mCZ.ppf.get(0)).bOe);
            }
            bundle.putLong("key_SessionId", this.pgE);
            a.dox = "PayProcess";
            a.sy = bundle;
        }
        if (this.mCn != null) {
            if (this.mCn.bVY == 6 && this.mCn.qUI == 100) {
                a.fdx = 100;
            } else {
                a.fdx = this.mCn.bVY;
            }
        }
        a(a, true, true);
        if (this.mCn != null && 8 == this.mCn.bVY && this.mCn.qUL != null) {
            long j = this.mCn.qUL.getLong("extinfo_key_9");
            com.tencent.mm.plugin.report.service.h.mEJ.h(13956, new Object[]{Integer.valueOf(2), Long.valueOf(System.currentTimeMillis() - j)});
        }
    }

    public final boolean bNz() {
        return (this.mCn == null || this.mCn.bVY == 11) ? false : true;
    }

    public final PayInfo bNW() {
        if (this.mCn == null) {
            this.mCn = (PayInfo) getIntent().getParcelableExtra("key_pay_info");
        }
        return this.mCn;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public void J(Bundle bundle) {
        boolean z;
        this.pgn = true;
        if (this.mCZ != null) {
            bundle.putInt("key_support_bankcard", this.mCZ.pjA);
            bundle.putString("key_reqKey", this.mCZ.bOd);
            if (this.mCZ.ppf != null && this.mCZ.ppf.size() > 0) {
                bundle.putString("key_TransId", ((Commodity) this.mCZ.ppf.get(0)).bOe);
            }
            bundle.putLong("key_SessionId", this.pgE);
        }
        if (this.mCn != null) {
            bundle.putInt("key_scene", this.mCn.bVY);
        }
        String str = "key_is_oversea";
        if (bNP()) {
            z = false;
        } else {
            z = true;
        }
        bundle.putBoolean(str, z);
        bundle.putInt("is_deduct_open", this.pgM);
        com.tencent.mm.wallet_core.a.a((Activity) this, com.tencent.mm.plugin.wallet.pay.b.class, bundle, null);
    }

    public final void c(boolean z, String str, String str2) {
        x.i("MicroMsg.WalletPayUI", "onGenFinish callback");
        if (z) {
            x.i("MicroMsg.WalletPayUI", "onGenFinish callback, result.isSuccess is true");
            this.mCn.bQb = str;
            this.mCn.bQc = str2;
            jp(false);
            com.tencent.mm.plugin.wallet_core.e.c.bQW();
            return;
        }
        x.e("MicroMsg.WalletPayUI", "onGenFinish callback, result.isSuccess is false");
        jp(false);
        com.tencent.mm.plugin.wallet_core.e.c.bQW();
    }

    public void onPause() {
        super.onPause();
        if (this.pfB != null) {
            this.pfB.bPX();
        }
    }

    private boolean a(e eVar) {
        int i = 0;
        if ("1".equals(eVar.ced)) {
            x.i("MicroMsg.WalletPayUI", "need realname verify");
            this.pgK = true;
            Bundle bundle = new Bundle();
            bundle.putString("realname_verify_process_jump_activity", ".pay.ui.WalletPayUI");
            bundle.putString("realname_verify_process_jump_plugin", "wallet");
            String str = eVar.cee;
            str = eVar.cef;
            str = eVar.ceg;
            bbR();
            if (this.mCn != null) {
                i = this.mCn.bVY;
            }
            return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, bundle, i);
        } else if ("2".equals(eVar.ced)) {
            x.i("MicroMsg.WalletPayUI", "need upload credit");
            return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, eVar.cee, eVar.ceh, eVar.cef, eVar.ceg, bbR(), null);
        } else {
            x.i("MicroMsg.WalletPayUI", "realnameGuideFlag =  " + eVar.ced);
            return false;
        }
    }
}
