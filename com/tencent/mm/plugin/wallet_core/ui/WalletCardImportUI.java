package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.e.c;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import com.tencent.mm.wallet_core.ui.formview.a.b;

public class WalletCardImportUI extends WalletBaseUI implements OnEditorActionListener, a {
    private static final String[] pup = new String[]{"ABC_DEBIT", "ABC_CREDIT", "CITIC_CREDIT", "CMBC_DEBIT", "HSBC_DEBIT"};
    private Button eUb;
    private String kJy;
    private String kJz;
    private Orders mCZ = null;
    private PayInfo mCn = null;
    private ag mHandler = new ag();
    private Dialog nt = null;
    private Authen pfc = new Authen();
    private WalletFormView phM;
    private int phQ = 1;
    private ElementQuery pkA = new ElementQuery();
    private WalletFormView psR;
    private WalletFormView ptJ;
    private WalletFormView ptK;
    private WalletFormView ptL;
    private WalletFormView ptM;
    private WalletFormView ptP;
    private WalletFormView ptQ;
    private WalletFormView ptR;
    private WalletFormView ptS;
    private WalletFormView ptT;
    private WalletFormView ptU;
    private WalletFormView ptV;
    private WalletFormView ptY = null;
    private WalletFormView ptZ;
    private CheckBox pud;
    private String pue;
    private WalletFormView pui;
    private TextView puq;
    private MMScrollView pur;
    private Bankcard pus = null;
    private CheckBox put;
    private BaseAdapter puu = new 9(this);

    static /* synthetic */ void c(WalletFormView walletFormView, int i) {
        b logicDelegate = walletFormView.getLogicDelegate();
        if (logicDelegate instanceof com.tencent.mm.wallet_core.ui.formview.a.a) {
            ((com.tencent.mm.wallet_core.ui.formview.a.a) logicDelegate).Hf(i);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(i.wallet_elment_title);
        this.pkA = (ElementQuery) this.sy.getParcelable("elemt_query");
        this.mCZ = (Orders) this.sy.getParcelable("key_orders");
        this.mCn = (PayInfo) this.sy.getParcelable("key_pay_info");
        this.pus = (Bankcard) this.sy.getParcelable("key_import_bankcard");
        if (this.mCn == null) {
            this.mCn = new PayInfo();
        }
        x.d("MicroMsg.WalletCardElmentUI", "mPayInfo " + this.mCn);
        initView();
        this.pur.pageScroll(33);
        c.b(this, this.sy, 3);
    }

    protected final void initView() {
        this.ptZ = (WalletFormView) findViewById(a$f.wallet_card_forgot_id);
        com.tencent.mm.wallet_core.ui.formview.a.b(this.ptZ);
        this.ptM = (WalletFormView) findViewById(a$f.mobile_et);
        com.tencent.mm.wallet_core.ui.formview.a.c(this, this.ptM);
        this.psR = (WalletFormView) findViewById(a$f.name_et);
        com.tencent.mm.wallet_core.ui.formview.a.e(this, this.psR);
        this.ptL = (WalletFormView) findViewById(a$f.wallet_cre_type);
        this.phM = (WalletFormView) findViewById(a$f.identity_et);
        com.tencent.mm.wallet_core.ui.formview.a.d(this.phM);
        this.pui = (WalletFormView) findViewById(a$f.wallet_card_type);
        this.ptK = (WalletFormView) findViewById(a$f.cvv_et);
        com.tencent.mm.wallet_core.ui.formview.a.b(this, this.ptK);
        this.ptJ = (WalletFormView) findViewById(a$f.date_et);
        com.tencent.mm.wallet_core.ui.formview.a.a(this, this.ptJ);
        this.puq = (TextView) findViewById(a$f.wallet_power_by_tenpay);
        this.ptP = (WalletFormView) findViewById(a$f.first_name_et);
        this.ptQ = (WalletFormView) findViewById(a$f.last_name_et);
        this.ptR = (WalletFormView) findViewById(a$f.area_et);
        this.ptS = (WalletFormView) findViewById(a$f.address_et);
        this.ptT = (WalletFormView) findViewById(a$f.phone_et);
        this.ptU = (WalletFormView) findViewById(a$f.post_et);
        this.ptV = (WalletFormView) findViewById(a$f.email_et);
        com.tencent.mm.wallet_core.ui.formview.a.e(this.ptV);
        this.put = (CheckBox) findViewById(a$f.agree_wx_cb);
        this.pud = (CheckBox) findViewById(a$f.agree_follow_bank_cb);
        this.eUb = (Button) findViewById(a$f.next_btn);
        this.pur = (MMScrollView) findViewById(a$f.wallet_sv);
        MMScrollView mMScrollView = this.pur;
        mMScrollView.a(mMScrollView, mMScrollView);
        this.pur.setOnSizeChangeListener(new 1(this));
        this.psR.setOnInputValidChangeListener(this);
        this.ptZ.setOnInputValidChangeListener(this);
        this.ptL.setOnInputValidChangeListener(this);
        this.phM.setOnInputValidChangeListener(this);
        this.ptM.setOnInputValidChangeListener(this);
        this.ptK.setOnInputValidChangeListener(this);
        this.ptJ.setOnInputValidChangeListener(this);
        this.ptP.setOnInputValidChangeListener(this);
        this.ptQ.setOnInputValidChangeListener(this);
        this.ptR.setOnInputValidChangeListener(this);
        this.ptS.setOnInputValidChangeListener(this);
        this.ptT.setOnInputValidChangeListener(this);
        this.ptU.setOnInputValidChangeListener(this);
        this.ptV.setOnInputValidChangeListener(this);
        this.psR.setOnEditorActionListener(this);
        this.ptZ.setOnEditorActionListener(this);
        this.ptL.setOnEditorActionListener(this);
        this.phM.setOnEditorActionListener(this);
        this.ptM.setOnEditorActionListener(this);
        this.ptK.setOnEditorActionListener(this);
        this.ptJ.setOnEditorActionListener(this);
        this.ptP.setOnEditorActionListener(this);
        this.ptQ.setOnEditorActionListener(this);
        this.ptR.setOnEditorActionListener(this);
        this.ptS.setOnEditorActionListener(this);
        this.ptT.setOnEditorActionListener(this);
        this.ptU.setOnEditorActionListener(this);
        this.ptV.setOnEditorActionListener(this);
        this.pui.setOnClickListener(new 2(this));
        this.ptL.setOnClickListener(new 3(this));
        this.put.setChecked(true);
        this.put.setOnCheckedChangeListener(new 4(this));
        this.pud.setChecked(true);
        findViewById(a$f.agree_btn).setOnClickListener(new 5(this));
        this.ptR.setOnClickListener(new 6(this));
        this.eUb.setOnClickListener(new 7(this));
        aL();
        ZB();
    }

    private void aL() {
        if (this.pus != null) {
            WalletFormView walletFormView;
            WalletFormView walletFormView2;
            findViewById(a$f.wallet_card_safeguard_tip).setVisibility(0);
            if (bi.oW(this.sy.getString("key_bank_username"))) {
                this.pud.setVisibility(8);
            } else {
                CharSequence string = this.sy.getString("key_recommand_desc");
                if (bi.oW(string)) {
                    this.pud.setText(getString(i.wallet_card_follow_bank_tips, new Object[]{this.pus.field_bankName}));
                } else {
                    this.pud.setText(string);
                }
                this.pud.setVisibility(0);
            }
            this.ptP.setVisibility(8);
            this.ptQ.setVisibility(8);
            this.ptR.setVisibility(8);
            this.ptS.setVisibility(8);
            this.ptT.setVisibility(8);
            this.ptU.setVisibility(8);
            this.ptV.setVisibility(8);
            if (bi.oW(this.pus.field_bankcardTail) || !b(this.ptZ, this.pus.plR)) {
                this.ptZ.setVisibility(8);
                walletFormView = null;
                walletFormView2 = null;
            } else {
                WalletFormView walletFormView3 = this.ptZ;
                walletFormView = this.ptZ;
                walletFormView2 = walletFormView3;
            }
            String string2;
            if (this.pus.bOu()) {
                string2 = getString(i.wallet_credit_card);
            } else {
                string2 = getString(i.wallet_deposit_card);
            }
            if (bi.oW(this.pus.field_bankName) || !b(this.pui, this.pus.field_bankName + " " + string2)) {
                this.pui.setVisibility(8);
            } else {
                if (walletFormView2 == null) {
                    walletFormView2 = this.pui;
                }
                walletFormView = this.pui;
            }
            if (b(this.psR, this.pus.field_trueName)) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.psR;
                }
                walletFormView = this.psR;
            }
            if (b(this.ptL, o.bPe().Q(this.mController.tml, this.pus.pll))) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.ptL;
                }
                walletFormView = this.ptL;
            }
            if (b(this.phM, this.pus.plQ)) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.phM;
                }
                walletFormView = this.phM;
            }
            if (b(this.ptM, this.pus.field_mobile)) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.ptM;
                }
                walletFormView = this.ptM;
            }
            if (b(this.ptK, this.pus.pln)) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.ptK;
                }
                walletFormView = this.ptK;
            }
            if (b(this.ptJ, this.pus.plS)) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.ptJ;
                }
                walletFormView = this.ptJ;
            }
            walletFormView2.setBackgroundResource(e.comm_list_item_selector);
            walletFormView.setBackgroundResource(e.comm_list_item_selector);
            if (o.bOW().bPp()) {
                this.eUb.setText(i.wallet_card_import_first);
            } else {
                this.eUb.setText(i.wallet_card_import);
            }
        }
    }

    private static boolean b(WalletFormView walletFormView, String str) {
        if (bi.oW(str)) {
            walletFormView.setVisibility(8);
            return false;
        }
        KeyListener keyListener = walletFormView.getKeyListener();
        walletFormView.setKeyListener(null);
        walletFormView.setEnabled(false);
        walletFormView.setClickable(false);
        walletFormView.setText(str);
        walletFormView.setKeyListener(keyListener);
        walletFormView.setVisibility(0);
        return true;
    }

    private void bQc() {
        if (ZB()) {
            c.bQW();
            this.pfc = new Authen();
            this.sy.putBoolean("key_is_follow_bank_username", this.pud.isChecked());
            if (this.pus == null || bi.oW(this.pus.pmb)) {
                String text;
                boolean z;
                String string = this.sy.getString("key_card_id");
                if (this.ptZ.getVisibility() == 0) {
                    text = this.ptZ.getText();
                } else {
                    text = string;
                }
                this.pfc.mpb = (PayInfo) this.sy.getParcelable("key_pay_info");
                this.pfc.plm = text;
                this.pfc.lMV = this.pkA.lMV;
                this.pfc.pll = this.phQ;
                this.pfc.pli = this.sy.getString("key_pwd1");
                if (!bi.oW(this.ptK.getText())) {
                    this.pfc.pln = this.ptK.getText();
                }
                this.pfc.pjw = this.ptM.getText();
                this.pfc.plr = this.ptP.getText();
                this.pfc.pls = this.ptQ.getText();
                this.pfc.country = this.pue;
                this.pfc.csK = this.kJy;
                this.pfc.csL = this.kJz;
                this.pfc.dRH = this.ptS.getText();
                this.pfc.knG = this.ptT.getText();
                this.pfc.eXM = this.ptU.getText();
                this.pfc.csD = this.ptV.getText();
                this.sy.putString("key_mobile", com.tencent.mm.wallet_core.ui.e.aca(this.pfc.pjw));
                Bundle bundle = this.sy;
                String str = "key_is_oversea";
                if (this.pkA.pjA == 2) {
                    z = true;
                } else {
                    z = false;
                }
                bundle.putBoolean(str, z);
                this.pfc.plk = this.phM.getText();
                this.pfc.plj = this.psR.getText();
                this.pfc.plo = this.ptJ.getText();
                x.d("MicroMsg.WalletCardElmentUI", "payInfo " + this.pfc.mpb + " elemt.bankcardTag : " + this.pkA.pjA);
            } else {
                this.pfc.pcx = this.pus.pmb;
                this.pfc.lMW = this.pus.field_bindSerial;
                this.pfc.lMV = this.pus.field_bankcardType;
                this.pfc.pll = this.pus.pll;
                this.pfc.pli = this.sy.getString("key_pwd1");
                this.pfc.token = this.sy.getString("kreq_token");
            }
            com.tencent.mm.wallet_core.a.af(this);
            if (cDL().m(new Object[]{this.pfc, this.mCZ})) {
                x.i("MicroMsg.WalletCardElmentUI", "process controller deal with!!!");
            } else {
                x.e("MicroMsg.WalletCardElmentUI", "error process in the tenpay!!");
            }
        }
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.WalletCardElmentUI", " errCode: " + i2 + " errMsg :" + str);
        if (i != 0 || i2 != 0) {
            return false;
        }
        Bundle bundle = this.sy;
        x.d("MicroMsg.WalletCardElmentUI", "PayInfo  " + this.mCn);
        if (!(lVar instanceof y)) {
            return false;
        }
        bundle.putBoolean("intent_bind_end", true);
        com.tencent.mm.wallet_core.a.j(this, bundle);
        h.bA(this, getString(i.wallet_bank_card_bind_success_tips));
        return true;
    }

    protected final int getLayoutId() {
        return a$g.wallet_card_import_ui;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.WalletCardElmentUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    this.pkA = (ElementQuery) intent.getParcelableExtra("elemt_query");
                    aL();
                    break;
                case 2:
                    String stringExtra = intent.getStringExtra("CountryName");
                    String stringExtra2 = intent.getStringExtra("Country");
                    this.pue = stringExtra + "|" + stringExtra2;
                    String stringExtra3 = intent.getStringExtra("ProviceName");
                    String stringExtra4 = intent.getStringExtra("CityName");
                    if (!bi.oW(intent.getStringExtra("Contact_City"))) {
                        this.kJy = stringExtra3 + "|" + intent.getStringExtra("Contact_Province");
                        this.kJz = stringExtra4 + "|" + intent.getStringExtra("Contact_City");
                        this.ptR.setText(stringExtra + " " + stringExtra4);
                    } else if (bi.oW(intent.getStringExtra("Contact_Province"))) {
                        this.kJz = this.pue;
                        this.ptR.setText(stringExtra);
                    } else {
                        this.kJz = stringExtra3 + "|" + intent.getStringExtra("Contact_Province");
                        this.ptR.setText(stringExtra + " " + stringExtra3);
                    }
                    if (!"US".equals(stringExtra2) && !"CA".equals(stringExtra2) && !this.pkA.pnG) {
                        this.ptU.setVisibility(8);
                        break;
                    } else {
                        this.ptU.setVisibility(0);
                        break;
                    }
                    break;
            }
            ZB();
        }
    }

    private boolean ZB() {
        boolean z;
        if (this.put.isChecked()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.eUb.setEnabled(true);
            this.eUb.setClickable(true);
        } else {
            this.eUb.setEnabled(false);
            this.eUb.setClickable(false);
        }
        return z;
    }

    public final void fE(boolean z) {
        ZB();
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        x.d("MicroMsg.WalletCardElmentUI", "onEditorAction actionId : " + i);
        switch (i) {
            case 5:
                if (this.ptY == null) {
                    bQc();
                } else if (this.ptY.isEnabled() && !this.ptY.isClickable() && this.ptY.cDT()) {
                    this.ptY.cDV();
                } else {
                    this.ptY.performClick();
                }
                return true;
            default:
                if (this.ptY == null) {
                    bQc();
                }
                return false;
        }
    }

    public void onDestroy() {
        if (this.nt != null && this.nt.isShowing()) {
            this.nt.dismiss();
            this.nt = null;
        }
        super.onDestroy();
    }

    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case 1:
                com.tencent.mm.ui.base.i iVar = new com.tencent.mm.ui.base.i(this, j.SelectorDialog);
                iVar.setContentView(a$g.wallet_list_dialog);
                ListView listView = (ListView) iVar.findViewById(a$f.address_contactlist);
                listView.setAdapter(this.puu);
                listView.setOnItemClickListener(new 8(this));
                return iVar;
            default:
                return super.onCreateDialog(i);
        }
    }
}
