package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.wallet.balance.a.a.i;
import com.tencent.mm.plugin.wallet.balance.a.a.l;
import com.tencent.mm.plugin.wallet.balance.a.a.m;
import com.tencent.mm.plugin.wallet.balance.a.a.n;
import com.tencent.mm.plugin.wallet.balance.a.a.o;
import com.tencent.mm.plugin.wallet.balance.a.a.o.7;
import com.tencent.mm.plugin.wallet.balance.a.a.o.8;
import com.tencent.mm.plugin.wallet.balance.a.a.o.9;
import com.tencent.mm.plugin.wallet.balance.a.a.p;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.ab;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.arq;
import com.tencent.mm.protocal.c.awx;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class WalletLqtSaveFetchUI extends WalletLqtBasePresenterUI {
    private int accountType;
    private Dialog eBX;
    private HashMap<String, Integer> lMb = new HashMap();
    private int mode;
    private Bankcard oZH;
    private m oZk = ((m) w(m.class));
    private n oZl = ((n) t(n.class));
    private o pbE = new o(this.oZk, this.oZl, this);
    private p pbF = new p(this.pbE);
    private ViewGroup pbG;
    private WalletFormView pbH;
    private TextView pbI;
    private TextView pbJ;
    private Button pbK;
    private ImageView pbL;
    private TextView pbM;
    private TextView pbN;
    private ViewGroup pbO;
    private TextView pbP;
    private CheckBox pbQ;
    private TextView pbR;
    private TextView pbS;
    private TextView pbT;
    private CharSequence pbU;
    private Bankcard pbV;
    private int pbW;
    private String pbX;
    private String pbY;
    private long pbZ = -1;
    private String pca;
    private boolean pcb = false;

    static /* synthetic */ void a(WalletLqtSaveFetchUI walletLqtSaveFetchUI) {
        Bankcard bankcard;
        String str;
        int i;
        int i2;
        View inflate;
        walletLqtSaveFetchUI.lMb.clear();
        d dVar = new d(walletLqtSaveFetchUI, 2, true);
        List jc = i.oYM.jc(walletLqtSaveFetchUI.mode == 1);
        if (jc == null || jc.size() == 0) {
            com.tencent.mm.plugin.wallet.a.p.bNp();
            jc = com.tencent.mm.plugin.wallet.a.p.bNq().bPG();
        }
        List linkedList = new LinkedList();
        if (jc != null) {
            for (Bankcard bankcard2 : jc) {
                if (bankcard2.bOs()) {
                    com.tencent.mm.plugin.wallet.a.p.bNp();
                    if (!com.tencent.mm.plugin.wallet.a.p.bNq().bPp()) {
                        linkedList.add(bankcard2);
                    }
                }
                if (walletLqtSaveFetchUI.mode == 1 && (bankcard2.field_support_lqt_turn_in == 1 || bankcard2.bOs())) {
                    linkedList.add(bankcard2);
                }
                if (walletLqtSaveFetchUI.mode == 2 && (bankcard2.field_support_lqt_turn_out == 1 || bankcard2.bOs())) {
                    linkedList.add(bankcard2);
                }
            }
        }
        String str2 = walletLqtSaveFetchUI.oZH != null ? walletLqtSaveFetchUI.oZH.field_bindSerial : null;
        if (bi.oW(str2)) {
            str2 = walletLqtSaveFetchUI.pca;
            if (bi.oW(walletLqtSaveFetchUI.pca)) {
                g.Ek();
                str = (String) g.Ei().DT().get(a.sZv, "");
                i = 0;
                i2 = 0;
                while (i < linkedList.size()) {
                    bankcard2 = (Bankcard) linkedList.get(i);
                    int i3 = (bi.oW(bankcard2.field_bindSerial) || !str.equals(bankcard2.field_bindSerial)) ? i2 : i;
                    i++;
                    i2 = i3;
                }
                dVar.ofp = new 13(walletLqtSaveFetchUI, linkedList, dVar);
                dVar.ofq = new 14(walletLqtSaveFetchUI, dVar, linkedList);
                inflate = View.inflate(walletLqtSaveFetchUI, com.tencent.mm.plugin.wxpay.a.g.lqt_select_bankcard_header, null);
                if (walletLqtSaveFetchUI.mode != 1) {
                    ((TextView) inflate.findViewById(f.lqt_select_bankcard_title)).setText(com.tencent.mm.plugin.wxpay.a.i.wallet_lqt_save_alert_title);
                    ((TextView) inflate.findViewById(f.lqt_select_bankcard_tip)).setText(com.tencent.mm.plugin.wxpay.a.i.wallet_lqt_save_alert_tip);
                } else {
                    ((TextView) inflate.findViewById(f.lqt_select_bankcard_title)).setText(com.tencent.mm.plugin.wxpay.a.i.wallet_lqt_fetch_alert_title);
                    ((TextView) inflate.findViewById(f.lqt_select_bankcard_tip)).setText(com.tencent.mm.plugin.wxpay.a.i.wallet_lqt_fetch_alert_tip);
                }
                dVar.mqO = true;
                dVar.uKk = i2;
                dVar.uKi = true;
                dVar.dS(inflate);
                dVar.bXO();
            }
        }
        str = str2;
        i = 0;
        i2 = 0;
        while (i < linkedList.size()) {
            bankcard2 = (Bankcard) linkedList.get(i);
            int i32 = (bi.oW(bankcard2.field_bindSerial) || !str.equals(bankcard2.field_bindSerial)) ? i2 : i;
            i++;
            i2 = i32;
        }
        dVar.ofp = new 13(walletLqtSaveFetchUI, linkedList, dVar);
        dVar.ofq = new 14(walletLqtSaveFetchUI, dVar, linkedList);
        inflate = View.inflate(walletLqtSaveFetchUI, com.tencent.mm.plugin.wxpay.a.g.lqt_select_bankcard_header, null);
        if (walletLqtSaveFetchUI.mode != 1) {
            ((TextView) inflate.findViewById(f.lqt_select_bankcard_title)).setText(com.tencent.mm.plugin.wxpay.a.i.wallet_lqt_fetch_alert_title);
            ((TextView) inflate.findViewById(f.lqt_select_bankcard_tip)).setText(com.tencent.mm.plugin.wxpay.a.i.wallet_lqt_fetch_alert_tip);
        } else {
            ((TextView) inflate.findViewById(f.lqt_select_bankcard_title)).setText(com.tencent.mm.plugin.wxpay.a.i.wallet_lqt_save_alert_title);
            ((TextView) inflate.findViewById(f.lqt_select_bankcard_tip)).setText(com.tencent.mm.plugin.wxpay.a.i.wallet_lqt_save_alert_tip);
        }
        dVar.mqO = true;
        dVar.uKk = i2;
        dVar.uKi = true;
        dVar.dS(inflate);
        dVar.bXO();
    }

    static /* synthetic */ void i(WalletLqtSaveFetchUI walletLqtSaveFetchUI) {
        Bundle bundle = new Bundle();
        Parcelable parcelable = (PayInfo) walletLqtSaveFetchUI.sy.get("key_pay_info");
        if (parcelable == null) {
            parcelable = new PayInfo();
            parcelable.bOd = "";
            if (walletLqtSaveFetchUI.mode == 1) {
                if (walletLqtSaveFetchUI.accountType == 0) {
                    parcelable.bVY = 45;
                } else {
                    parcelable.bVY = 52;
                }
            } else if (walletLqtSaveFetchUI.accountType == 0) {
                parcelable.bVY = 51;
            } else {
                parcelable.bVY = 53;
            }
        }
        if (parcelable != null) {
            bundle.putParcelable("key_pay_info", parcelable);
        }
        if (walletLqtSaveFetchUI.mode == 1) {
            if (walletLqtSaveFetchUI.accountType == 0) {
                bundle.putInt("key_scene", 45);
            } else {
                bundle.putInt("key_scene", 52);
            }
            bundle.putInt("key_bind_scene", 16);
        } else {
            if (walletLqtSaveFetchUI.accountType == 0) {
                bundle.putInt("key_scene", 51);
            } else {
                bundle.putInt("key_scene", 53);
            }
            bundle.putInt("key_bind_scene", 17);
        }
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putInt("key_bind_scene", 0);
        bundle.putBoolean("key_is_bind_bankcard", true);
        com.tencent.mm.wallet_core.a.a(walletLqtSaveFetchUI, b.class, bundle, new c.a() {
            public final Intent n(int i, Bundle bundle) {
                x.i("MicroMsg.WalletLqtSaveFetchUI", "feedbackData: %s", new Object[]{bundle});
                return null;
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.WalletLqtSaveFetchUI", "WalletLqtSaveFetchUI onCreate");
        this.pbH = (WalletFormView) findViewById(f.lqt_save_form);
        this.pbK = (Button) findViewById(f.next_btn);
        this.pbL = (ImageView) findViewById(f.bankcard_logo_iv);
        this.pbM = (TextView) findViewById(f.lqt_save_balance_hint);
        this.pbN = (TextView) findViewById(f.lqt_save_balance_hint2);
        this.pbI = (TextView) findViewById(f.lqt_save_hint);
        this.pbJ = (TextView) findViewById(f.lqt_balance_bankcard);
        this.pbT = (TextView) findViewById(f.wallet_title);
        this.pbO = (ViewGroup) findViewById(f.lqt_save_protocal_layout);
        this.pbP = (TextView) findViewById(f.lqt_save_protocol_link_tv);
        this.pbQ = (CheckBox) findViewById(f.lqt_save_protocol_agree_checkbox);
        this.pbG = (ViewGroup) findViewById(f.main_content);
        this.pbR = (TextView) findViewById(f.hint_1);
        this.pbS = (TextView) findViewById(f.hint_2);
        this.mode = getIntent().getIntExtra("lqt_save_fetch_mode", 1);
        this.pbW = getIntent().getIntExtra("lqt_max_redeem_amount", -1);
        this.pbX = getIntent().getStringExtra("lqt_redeem_invalid_amount_hint");
        this.pbY = getIntent().getStringExtra("lqt_profile_wording");
        this.accountType = getIntent().getIntExtra("lqt_account_type", 0);
        if (this.mode == 1) {
            g.Ek();
            this.pca = (String) g.Ei().DT().get(a.sZw, "");
        } else {
            g.Ek();
            this.pca = (String) g.Ei().DT().get(a.sZx, "");
        }
        if (bi.oW(this.pca)) {
            g.Ek();
            this.pca = (String) g.Ei().DT().get(a.sZv, "");
        }
        x.i("MicroMsg.WalletLqtSaveFetchUI", "onCreate, accountType: %s, mode: %s, mCurrentSerial: %s", new Object[]{Integer.valueOf(this.accountType), Integer.valueOf(this.mode), this.pca});
        a(this.pbH, 2, false, false, false);
        if (this.mode == 1) {
            this.pbI.setText(getString(com.tencent.mm.plugin.wxpay.a.i.wallet_lqt_save_amount_hint));
            this.pbK.setText(com.tencent.mm.plugin.wxpay.a.i.wallet_lqt_save_wording);
            this.pbT.setText(getString(com.tencent.mm.plugin.wxpay.a.i.wallet_lqt_save_hint_bank_card_wording));
        } else if (this.mode == 2) {
            this.pbI.setText(getString(com.tencent.mm.plugin.wxpay.a.i.wallet_lqt_fetch_amount_hint));
            this.pbK.setText(com.tencent.mm.plugin.wxpay.a.i.wallet_lqt_fetch_wording);
            this.pbT.setText(getString(com.tencent.mm.plugin.wxpay.a.i.wallet_lqt_fetch_hint_bank_card_wording));
        }
        this.pbH.a(new 6(this));
        this.pbK.setOnClickListener(new 7(this));
        if (!bi.oW(this.pbY)) {
            TextView textView = (TextView) findViewById(f.lqt_profile_wording);
            textView.setText(this.pbY);
            textView.setVisibility(0);
        }
        this.pbM.setText("");
        this.pbM.setClickable(true);
        this.pbM.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m(this));
        jg(false);
        if (this.mode == 1) {
            this.pbG.setVisibility(4);
        }
        if (this.pbJ.findViewById(f.wallet_tips_msg) != null) {
            this.pbJ.findViewById(f.wallet_tips_msg).setVisibility(8);
        }
        1 1 = new 1(this);
        this.pbJ.setOnClickListener(1);
        if (findViewById(f.change_bankcard_layout) != null) {
            findViewById(f.change_bankcard_layout).setOnClickListener(1);
        }
        if (this.mode == 1) {
            i iVar = i.oYM;
            iVar.jf(true);
            arq arq = iVar.oYG;
            this.pbV = arq != null ? ab.a(arq.rTT) : null;
            if (this.pbV == null) {
                com.tencent.mm.plugin.wallet.a.p.bNp();
                this.pbV = com.tencent.mm.plugin.wallet.a.p.bNq().paw;
            }
            if (this.pbV != null) {
                String string = getString(com.tencent.mm.plugin.wxpay.a.i.wallet_lqt_balance_remain_wording_1, new Object[]{Double.valueOf(this.pbV.plV)});
                int length = string.length();
                CharSequence spannableString = new SpannableString(string + getString(com.tencent.mm.plugin.wxpay.a.i.wallet_lqt_balance_remain_wording_2));
                spannableString.setSpan(new a(new 8(this)), length, spannableString.length(), 18);
                this.pbU = spannableString;
                this.pbM.setText(spannableString);
            }
            this.pbG.setVisibility(0);
        }
        bNb();
    }

    private void bNb() {
        Bankcard bankcard;
        int i;
        List jc = i.oYM.jc(this.mode == 1);
        if (jc == null || jc.size() == 0) {
            com.tencent.mm.plugin.wallet.a.p.bNp();
            jc = com.tencent.mm.plugin.wallet.a.p.bNq().bPG();
        }
        List linkedList = new LinkedList();
        if (jc != null) {
            for (Bankcard bankcard2 : jc) {
                if (bankcard2.bOs()) {
                    com.tencent.mm.plugin.wallet.a.p.bNp();
                    if (!com.tencent.mm.plugin.wallet.a.p.bNq().bPp()) {
                        linkedList.add(bankcard2);
                    }
                }
                if (this.mode == 1 && bankcard2.field_support_lqt_turn_in == 1) {
                    linkedList.add(bankcard2);
                }
                if (this.mode == 2 && bankcard2.field_support_lqt_turn_out == 1) {
                    linkedList.add(bankcard2);
                }
            }
        }
        this.oZH = i.oYM.jb(this.mode == 1);
        if (this.oZH == null) {
            com.tencent.mm.plugin.wallet.a.p.bNp();
            this.oZH = com.tencent.mm.plugin.wallet.a.p.bNq().paw;
        }
        String str = "MicroMsg.WalletLqtSaveFetchUI";
        String str2 = "defaultBankcard: %s, save mCurrentSerial: %s";
        Object[] objArr = new Object[2];
        objArr[0] = this.oZH != null ? this.oZH.field_bindSerial : "";
        objArr[1] = this.pca;
        x.i(str, str2, objArr);
        if (!bi.oW(this.pca)) {
            for (i = 0; i < linkedList.size(); i++) {
                bankcard2 = (Bankcard) linkedList.get(i);
                if (!bi.oW(bankcard2.field_bindSerial) && this.pca.equals(bankcard2.field_bindSerial)) {
                    this.oZH = bankcard2;
                }
            }
        }
        if (this.oZH.bOs()) {
            this.pbJ.setText(this.oZH.field_desc);
        } else {
            this.pbJ.setText(getString(com.tencent.mm.plugin.wxpay.a.i.wallet_balance_save_bankcard_tips, new Object[]{this.oZH.field_bankName, this.oZH.field_bankcardTail}));
        }
        this.pbJ.setText(this.oZH.field_desc);
        this.pbJ.setVisibility(0);
        this.pbL.setTag(this.oZH.field_bindSerial);
        if (this.pbL != null) {
            String str3 = "";
            e h = b.h(this, this.oZH.field_bankcardType, this.oZH.bOr());
            if (h != null) {
                str3 = h.lCU;
            }
            this.pbL.setImageBitmap(null);
            if (this.oZH.bOs()) {
                this.pbL.setBackgroundResource(com.tencent.mm.plugin.wxpay.a.e.wallet_balance_manager_logo_small);
            } else {
                Bitmap a = y.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(str3));
                y.a(new 12(this));
                if (!(a == null || a == null)) {
                    this.pbL.setImageBitmap(com.tencent.mm.sdk.platformtools.c.a(a, getResources().getDimensionPixelOffset(com.tencent.mm.plugin.wxpay.a.d.wallet_offline_bank_logo_width), getResources().getDimensionPixelOffset(com.tencent.mm.plugin.wxpay.a.d.wallet_offline_bank_logo_width), true, false));
                }
            }
        }
        this.pbR.setVisibility(8);
        this.pbS.setVisibility(8);
        if (this.mode == 2) {
            if (!this.oZH.bOs() && !bi.oW(this.oZH.field_avail_save_wording)) {
                this.pbR.setText(this.oZH.field_avail_save_wording);
                this.pbR.setVisibility(0);
            } else if (this.oZH.bOs()) {
                boolean z;
                i iVar = i.oYM;
                if (this.mode == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (!bi.oW(iVar.jd(z))) {
                    TextView textView = this.pbR;
                    i iVar2 = i.oYM;
                    if (this.mode == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    textView.setText(iVar2.jd(z));
                    this.pbR.setVisibility(0);
                }
            }
            if (!bi.oW(this.oZH.field_fetchArriveTimeWording)) {
                this.pbS.setText(this.oZH.field_fetchArriveTimeWording);
                this.pbS.setVisibility(0);
            }
        } else if (!(this.mode != 1 || this.oZH.bOs() || bi.oW(this.oZH.field_avail_save_wording))) {
            this.pbR.setText(this.oZH.field_avail_save_wording);
            this.pbR.setVisibility(0);
        }
        String string;
        CharSequence spannableString;
        if (this.mode == 1) {
            setMMTitle(getString(com.tencent.mm.plugin.wxpay.a.i.wallet_lqt_save_wording));
            ArrayList stringArrayListExtra = getIntent().getStringArrayListExtra("lqt_protocol_list");
            boolean booleanExtra = getIntent().getBooleanExtra("lqt_is_show_protocol", false);
            if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0 || !booleanExtra) {
                this.pbO.setVisibility(8);
            } else {
                this.pbO.setVisibility(0);
                this.pbQ.setChecked(getIntent().getBooleanExtra("lqt_is_agree_protocol", false));
                this.pbO.setOnClickListener(new 3(this));
                this.pbQ.setOnCheckedChangeListener(new 4(this));
                string = getString(com.tencent.mm.plugin.wxpay.a.i.wallet_lqt_protocol_agree_prefix);
                i = string.length();
                spannableString = new SpannableString(string + getString(com.tencent.mm.plugin.wxpay.a.i.wallet_lqt_protocol_agree_suffix));
                spannableString.setSpan(new a(new 5(this, stringArrayListExtra)), i, spannableString.length(), 17);
                this.pbP.setText(spannableString);
                this.pbP.setClickable(true);
                this.pbP.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
            }
        } else if (this.mode == 2) {
            findViewById(f.wallet_info_tip).setVisibility(8);
            this.pbO.setVisibility(8);
            setMMTitle(getString(com.tencent.mm.plugin.wxpay.a.i.wallet_lqt_fetch_wording_title));
            this.pbN.setVisibility(8);
            l bMQ = l.bMQ();
            int i2;
            if (this.oZH == null || !this.oZH.bOs()) {
                i2 = bMQ.oZa == null ? 0 : bMQ.oZa.rZW;
                if (af.eyi) {
                    i2 = 100;
                }
                String string2 = getString(com.tencent.mm.plugin.wxpay.a.i.wallet_lqt_fetch_remain_wording_1_2, new Object[]{Double.valueOf(eY(String.valueOf(i2), "100"))});
                int length = string2.length();
                CharSequence spannableString2 = new SpannableString(string2 + getString(com.tencent.mm.plugin.wxpay.a.i.wallet_lqt_fetch_remain_wording_2));
                spannableString2.setSpan(new a(new 10(this, i2)), length, spannableString2.length(), 18);
                this.pbU = spannableString2;
                this.pbM.setText(spannableString2);
                if (bMQ.oZa != null && (bMQ.oZa.rZX > 0 || af.eyi)) {
                    i2 = bMQ.oZa.rZX;
                    this.pbN.setVisibility(0);
                    this.pbN.setText(getString(com.tencent.mm.plugin.wxpay.a.i.wallet_lqt_fetch_remain_real_wording, new Object[]{Double.valueOf(eY(String.valueOf(i2), "100"))}));
                }
                awx awx = bMQ.oZa;
                if (!(awx == null || awx.rZY == null || awx.rZY.size() <= 0)) {
                    findViewById(f.wallet_info_tip).setVisibility(0);
                    findViewById(f.wallet_info_tip).setOnClickListener(new 11(this, awx));
                }
            } else {
                i2 = getIntent().getIntExtra("lqt_balance", 0);
                if (af.eyi) {
                    i2 = 100;
                }
                if (i2 > 0) {
                    string = getString(com.tencent.mm.plugin.wxpay.a.i.wallet_lqt_fetch_remain_wording_1, new Object[]{Double.valueOf(eY(String.valueOf(i2), "100"))});
                    i = string.length();
                    spannableString = new SpannableString(string + getString(com.tencent.mm.plugin.wxpay.a.i.wallet_lqt_fetch_remain_wording_2));
                    spannableString.setSpan(new a(new 9(this, i2)), i, spannableString.length(), 18);
                    this.pbU = spannableString;
                    this.pbM.setText(spannableString);
                }
            }
        }
        if (this.mode == 1) {
            if (this.oZH == null || !this.oZH.bOs()) {
                this.pbM.setText("");
            } else {
                this.pbM.setText(this.pbU);
            }
        }
        this.pbH.setText(this.pbH.getText());
    }

    private List<Bankcard> bNc() {
        List jc = i.oYM.jc(this.mode == 1);
        if (jc == null || jc.size() == 0) {
            com.tencent.mm.plugin.wallet.a.p.bNp();
            jc = com.tencent.mm.plugin.wallet.a.p.bNq().bPG();
        }
        List<Bankcard> linkedList = new LinkedList();
        if (jc != null) {
            for (Bankcard bankcard : jc) {
                if (bankcard.bOs()) {
                    com.tencent.mm.plugin.wallet.a.p.bNp();
                    if (!com.tencent.mm.plugin.wallet.a.p.bNq().bPp()) {
                        linkedList.add(bankcard);
                    }
                }
                if (this.mode == 1 && (bankcard.field_support_lqt_turn_in == 1 || bankcard.bOs())) {
                    linkedList.add(bankcard);
                }
                if (this.mode == 2 && (bankcard.field_support_lqt_turn_out == 1 || bankcard.bOs())) {
                    linkedList.add(bankcard);
                }
            }
        }
        return linkedList;
    }

    protected void onNewIntent(Intent intent) {
        x.i("MicroMsg.WalletLqtSaveFetchUI", "onNewIntent");
        super.onNewIntent(intent);
        List bNc = bNc();
        if (this.mode == 1) {
            this.pbF.oZy.dX(this.mode, this.accountType).f(new 15(this, bNc));
        }
    }

    private void jg(boolean z) {
        if (!z) {
            this.pbK.setEnabled(false);
        } else if (this.pbO.getVisibility() == 0) {
            if (this.pbQ.isChecked() && this.pcb) {
                this.pbK.setEnabled(true);
            } else {
                this.pbK.setEnabled(false);
            }
        } else if (this.pcb) {
            this.pbK.setEnabled(true);
        }
    }

    public void onResume() {
        super.onResume();
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.wallet_lqt_save_ui;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        o oVar = this.pbE;
        if (i == o.oZi && i2 == -1) {
            Orders orders = (Orders) intent.getParcelableExtra("key_orders");
            if (orders != null && orders.ppf != null && orders.ppf.size() > 0) {
                x.i("MicroMsg.LqtSaveFetchLogic", "onActivityResult, doQueryPurchaseResult, accountType: %s", new Object[]{Integer.valueOf(oVar.accountType)});
                oVar.bOe = ((Commodity) orders.ppf.get(0)).bOe;
                x.i("MicroMsg.LqtSaveFetchLogic", "doQueryPurchaseResult");
                oVar.oZm.jh(false);
                com.tencent.mm.vending.g.g.a(oVar.oZn, oVar.bOe, Integer.valueOf(oVar.oZo), Integer.valueOf(oVar.accountType)).c(oVar.oZl.oZe).f(new 7(oVar)).a(new com.tencent.mm.vending.g.d.a() {
                    public final void bd(Object obj) {
                        x.i("MicroMsg.LqtSaveFetchLogic", "doQueryPurchaseResult interrupt: %s", new Object[]{obj});
                        o.this.oZm.bNd();
                        if (o.this.eAc != null) {
                            o.this.eAc.ct(obj);
                        }
                    }
                });
            }
        } else if (i == o.oZj && i2 == -1) {
            String stringExtra = intent.getStringExtra("lqt_fetch_enc_pwd");
            x.i("MicroMsg.LqtSaveFetchLogic", "onActivityResult, doRedeemFund, accountType: %s", new Object[]{Integer.valueOf(oVar.accountType)});
            x.i("MicroMsg.LqtSaveFetchLogic", "doRedeemFund");
            oVar.oZm.jh(true);
            n.c cVar = oVar.oZl.oZf;
            int i3 = oVar.oZp;
            com.tencent.mm.vending.g.g.a(Integer.valueOf(i3), stringExtra, oVar.oZq, Integer.valueOf(oVar.accountType)).c(cVar).f(new 9(oVar)).a(new 8(oVar));
        }
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        o oVar = this.pbE;
        x.i("MicroMsg.LqtSaveFetchLogic", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, lVar});
        if (lVar instanceof com.tencent.mm.plugin.wallet_core.c.y) {
            com.tencent.mm.plugin.wallet.a.p.bNp();
            oVar.oZr = com.tencent.mm.plugin.wallet.a.p.bNq().paw;
            if (oVar.eAc != null) {
                oVar.eAc.v(new Object[]{lVar});
                oVar.eAc.resume();
            }
        }
        return super.d(i, i2, str, lVar);
    }

    public final void jh(boolean z) {
        if (this.eBX != null && this.eBX.isShowing()) {
            return;
        }
        if (z) {
            this.eBX = com.tencent.mm.wallet_core.ui.g.a(this, false, null);
        } else {
            this.eBX = com.tencent.mm.wallet_core.ui.g.b(this, false, null);
        }
    }

    public final void bNd() {
        if (this.eBX != null) {
            this.eBX.dismiss();
        }
    }

    public final void bNe() {
        boolean z;
        int i = 0;
        if (this.mode == 1) {
            g.Ek();
            g.Ei().DT().a(a.sZw, this.pca);
        } else {
            g.Ek();
            g.Ei().DT().a(a.sZx, this.pca);
        }
        i iVar = i.oYM;
        if (this.mode == 1) {
            z = true;
        } else {
            z = false;
        }
        iVar.jf(z);
        arq arq = z ? iVar.oYG : iVar.oYH;
        if (arq != null) {
            x.i("MicroMsg.LqtBindQueryInfoCache", "isReqAgainAfterDeal: %s", new Object[]{Boolean.valueOf(arq.rTV)});
            i = arq.rTV;
        }
        if (i != 0) {
            x.i("MicroMsg.WalletLqtSaveFetchUI", "saveOrfetchDone, req again after deal");
            this.pbF.oZy.dX(this.mode, this.accountType);
        }
    }

    public final void Kk(String str) {
        Toast.makeText(this, str, 1).show();
    }

    public void onDestroy() {
        super.onDestroy();
        this.pbE = null;
        this.pbF = null;
    }

    private static double eY(String str, String str2) {
        try {
            return new BigDecimal(bi.getDouble(str.trim(), 0.0d) == 0.0d ? "0" : str.trim()).divide(new BigDecimal(str2.trim()), 5, 2).doubleValue();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", e, "", new Object[0]);
            return 0.0d;
        }
    }

    private static int eZ(String str, String str2) {
        try {
            double d = bi.getDouble(str, 0.0d);
            double d2 = bi.getDouble(str2, 0.0d);
            if (d == 0.0d) {
                str = "0";
            }
            BigDecimal bigDecimal = new BigDecimal(str);
            if (d2 == 0.0d) {
                str2 = "0";
            }
            return bigDecimal.multiply(new BigDecimal(str2)).intValue();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", e, "", new Object[0]);
            return 0;
        }
    }
}
