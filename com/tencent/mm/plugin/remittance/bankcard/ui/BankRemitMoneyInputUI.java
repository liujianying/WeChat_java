package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.bp.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.remittance.bankcard.a.c;
import com.tencent.mm.plugin.remittance.bankcard.a.n;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.plugin.wallet_core.ui.m;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.wallet_core.c.h$a;
import com.tencent.mm.wallet_core.c.v;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class BankRemitMoneyInputUI extends BankRemitBaseUI {
    private String cZG;
    private final int eCE = a.fromDPToPix(ad.getContext(), 270);
    private Button eWk;
    private ScrollView klj;
    private CdnImageView mux;
    private TextView muz;
    private String mvC;
    private TextView mvQ;
    private WalletFormView mvR;
    private LinearLayout mvS;
    private TextView mvT;
    private TextView mvU;
    private TextView mvV;
    private TextView mvW;
    private BankcardElemParcel mvX;
    private String mvY;
    private String mvZ;
    private String mwa;
    private String mwb;
    private String mwc;
    private int mwd;
    private int mwe;
    private m mwf;
    private long mwg;
    private int mwh;
    private int mwi;

    static /* synthetic */ void a(BankRemitMoneyInputUI bankRemitMoneyInputUI, String str, String str2, String str3, String str4) {
        x.i("MicroMsg.BankRemitMoneyInputUI", "do start pay");
        PayInfo payInfo = new PayInfo();
        payInfo.bOd = str;
        payInfo.bVY = 49;
        String str5 = bankRemitMoneyInputUI.getString(i.bank_remit_select_payee_name_with_remark, new Object[]{str3, str4}) + str2;
        Bundle bundle = new Bundle();
        bundle.putString("extinfo_key_1", str5);
        payInfo.qUL = bundle;
        h.a(bankRemitMoneyInputUI, payInfo, 1);
    }

    static /* synthetic */ void e(BankRemitMoneyInputUI bankRemitMoneyInputUI) {
        x.i("MicroMsg.BankRemitMoneyInputUI", "do request order, money: %s, fee: %s, desc: %s, input: %s, timeScene: %s", new Object[]{Integer.valueOf((int) Math.round(bi.getDouble(bankRemitMoneyInputUI.mvR.getText(), 0.0d) * 100.0d)), Long.valueOf(bankRemitMoneyInputUI.mwg), bankRemitMoneyInputUI.cZG, Integer.valueOf(bankRemitMoneyInputUI.mwe), Integer.valueOf(bankRemitMoneyInputUI.mwd)});
        l nVar = new n(bankRemitMoneyInputUI.mvZ, bankRemitMoneyInputUI.mwa, bankRemitMoneyInputUI.mwc, bankRemitMoneyInputUI.mwd, r5, bankRemitMoneyInputUI.cZG, (int) bankRemitMoneyInputUI.mwg, bankRemitMoneyInputUI.mwe, bankRemitMoneyInputUI.mwb);
        nVar.m(bankRemitMoneyInputUI);
        bankRemitMoneyInputUI.a(nVar, true, true);
    }

    static /* synthetic */ void f(BankRemitMoneyInputUI bankRemitMoneyInputUI) {
        if (bankRemitMoneyInputUI.klj != null) {
            int[] iArr = new int[2];
            bankRemitMoneyInputUI.eWk.getLocationInWindow(iArr);
            int fl = (a.fl(bankRemitMoneyInputUI) - r0) - a.fromDPToPix(bankRemitMoneyInputUI, 30);
            x.d("MicroMsg.BankRemitMoneyInputUI", "scrollToFormEditPosAfterShowTenPay, editText locationY: %s, height: %s, diff: %s, hardcodeKeyboardHeight: %s", new Object[]{Integer.valueOf(iArr[1] + bankRemitMoneyInputUI.eWk.getHeight()), Integer.valueOf(a.fl(bankRemitMoneyInputUI)), Integer.valueOf(fl), Integer.valueOf(bankRemitMoneyInputUI.eCE)});
            if (fl > 0 && fl < bankRemitMoneyInputUI.eCE) {
                x.d("MicroMsg.BankRemitMoneyInputUI", "scrollToFormEditPosAfterShowTenPay, scrollDistance: %s", new Object[]{Integer.valueOf(bankRemitMoneyInputUI.eCE - fl)});
                bankRemitMoneyInputUI.klj.post(new 2(bankRemitMoneyInputUI, r0));
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        cqh();
        jr(1380);
        int intValue = ((Integer) g.Ei().DT().get(aa.a.sZi, Integer.valueOf(10))).intValue();
        if (intValue < 0) {
            intValue = 10;
        }
        this.mwh = intValue;
        intValue = ((Integer) g.Ei().DT().get(aa.a.sZj, Integer.valueOf(5000000))).intValue();
        if (intValue <= 0) {
            intValue = 5000000;
        }
        this.mwi = intValue;
        x.i("MicroMsg.BankRemitMoneyInputUI", "minFee: %s, maxAmount: %s", new Object[]{Integer.valueOf(this.mwh), Integer.valueOf(this.mwi)});
        this.mvX = (BankcardElemParcel) getIntent().getParcelableExtra("key_bank_card_elem_parcel");
        this.mvY = getIntent().getStringExtra("key_payee_name");
        this.mvZ = getIntent().getStringExtra("key_bank_card_seqno");
        this.mwa = getIntent().getStringExtra("key_bank_card_tailno");
        this.mwb = getIntent().getStringExtra("key_encrypt_data");
        this.mwd = getIntent().getIntExtra("key_enter_time_scene", 0);
        this.mwe = getIntent().getIntExtra("key_input_type", 0);
        if (this.mvX == null) {
            x.w("MicroMsg.BankRemitMoneyInputUI", "bankcard elem is null");
            this.mvX = new BankcardElemParcel();
        }
        this.mwc = this.mvX.lMV;
        initView();
        setMMTitle(i.bank_remit_title);
    }

    protected final void initView() {
        this.klj = (ScrollView) findViewById(f.root_view);
        this.mux = (CdnImageView) findViewById(f.brmi_bank_logo_iv);
        this.muz = (TextView) findViewById(f.brmi_bank_name_tv);
        this.mvQ = (TextView) findViewById(f.brmi_payee_tv);
        this.mvR = (WalletFormView) findViewById(f.brmi_bank_money_input_tv);
        this.mvS = (LinearLayout) findViewById(f.brmi_fee_rate_layout);
        this.mvT = (TextView) this.mvS.findViewById(f.brmi_fee_rate_title_tv);
        this.mvU = (TextView) this.mvS.findViewById(f.brmi_fee_tv);
        this.mvV = (TextView) this.mvS.findViewById(f.brmi_total_money_tv);
        this.mvW = (TextView) this.mvS.findViewById(f.brmi_remit_desc_tv);
        this.eWk = (Button) findViewById(f.brmi_next_btn);
        String str = com.tencent.mm.plugin.remittance.bankcard.model.a.el(this.mvX.muh, "100") + "%";
        this.mvT.setText(getString(i.bank_remit_fee_rate_text, new Object[]{str}));
        this.mux.setUrl(this.mvX.mug);
        this.muz.setText(getString(i.bank_remit_select_payee_name_with_remark, new Object[]{this.mvX.knE, this.mwa}));
        this.mvQ.setText(this.mvY);
        this.mvR.setTitleText(v.cDm());
        d(this.mvR, 2, false);
        this.mvR.a(new 1(this));
        this.mvW.setClickable(true);
        this.mvW.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m(this));
        this.mwf = new m(new 8(this));
        brb();
        this.eWk.setOnClickListener(new 3(this));
        bqY();
        this.kTx = new com.tencent.mm.wallet_core.ui.a() {
            public final void fI(boolean z) {
                if (z) {
                    BankRemitMoneyInputUI.f(BankRemitMoneyInputUI.this);
                } else {
                    BankRemitMoneyInputUI.this.klj.scrollTo(0, 0);
                }
            }
        };
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (lVar instanceof n) {
            final n nVar = (n) lVar;
            nVar.a(new h$a() {
                public final void g(int i, int i2, String str, l lVar) {
                    x.i("MicroMsg.BankRemitMoneyInputUI", "reqKey: %s, billId: %s", new Object[]{nVar.muf.kRq, nVar.muf.rlf});
                    x.d("MicroMsg.BankRemitMoneyInputUI", "name: %s, bank: %s", new Object[]{nVar.muf.muC, nVar.muf.knE});
                    BankRemitMoneyInputUI.this.mvC = nVar.muf.rlf;
                    if (!BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this, nVar)) {
                        BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this, nVar.muf.kRq, nVar.muf.muC, nVar.muf.knE, nVar.muf.muB);
                    }
                }
            }).b(new h$a() {
                public final void g(int i, int i2, String str, l lVar) {
                    x.e("MicroMsg.BankRemitMoneyInputUI", "request order error: %s, %s", new Object[]{Integer.valueOf(nVar.muf.hUm), nVar.muf.hUn});
                    BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this, nVar);
                }
            }).c(new h$a() {
                public final void g(int i, int i2, String str, l lVar) {
                    x.e("MicroMsg.BankRemitMoneyInputUI", "net error: %s", new Object[]{lVar});
                }
            });
        }
        return false;
    }

    public void onDestroy() {
        super.onDestroy();
        js(1380);
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.bank_remit_money_input_ui;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        Intent intent2;
        if (i == 1) {
            if (i2 == -1) {
                x.i("MicroMsg.BankRemitMoneyInputUI", "goto detail");
                intent2 = new Intent(this.mController.tml, BankRemitDetailUI.class);
                intent2.putExtra("key_transfer_bill_id", this.mvC);
                intent2.putExtra("key_enter_scene", 0);
                startActivityForResult(intent2, 2);
                String str = "";
                if (intent != null) {
                    str = intent.getStringExtra("key_trans_id");
                }
                x.i("MicroMsg.BankRemitMoneyInputUI", "do business callback: %s, %s", new Object[]{this.mvC, str});
                a(new c(this.mvC, str), false, false);
                return;
            }
            x.i("MicroMsg.BankRemitMoneyInputUI", "pay failed: %d", new Object[]{Integer.valueOf(i2)});
        } else if (i == 2) {
            x.d("MicroMsg.BankRemitMoneyInputUI", "return from detail");
            intent2 = new Intent();
            intent2.addFlags(67108864);
            d.b(this.mController.tml, "offline", ".ui.WalletOfflineCoinPurseUI", intent2);
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    private void brb() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (bi.oW(this.cZG)) {
            spannableStringBuilder.append(getString(i.bank_remit_remittance_desc_text));
            spannableStringBuilder.setSpan(this.mwf, 0, spannableStringBuilder.length(), 18);
        } else {
            spannableStringBuilder.append(j.a(this.mController.tml, this.cZG));
            spannableStringBuilder.append(getString(i.bank_remit_remittance_desc_modify_text));
            spannableStringBuilder.setSpan(this.mwf, this.cZG.length(), spannableStringBuilder.length(), 34);
        }
        this.mvW.setText(spannableStringBuilder);
    }

    private void bqY() {
        if (bi.getDouble(this.mvR.getText(), 0.0d) <= 0.0d || bi.oW(this.mvZ) || bi.oW(this.mwa) || bi.oW(this.mwc) || bi.oW(this.mwb)) {
            x.i("MicroMsg.BankRemitMoneyInputUI", "disable btn: money: %s, seqNo: %s, tail: %s, bankType: %s, encrypt: %s", new Object[]{this.mvR.getText(), Boolean.valueOf(bi.oW(this.mvZ)), Boolean.valueOf(bi.oW(this.mwa)), Boolean.valueOf(bi.oW(this.mwc)), Boolean.valueOf(bi.oW(this.mwb))});
            this.eWk.setEnabled(false);
            return;
        }
        this.eWk.setEnabled(true);
    }
}
