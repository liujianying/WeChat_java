package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DeductShowInfo;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.util.ArrayList;
import java.util.List;

public class WalletPayDeductUI extends MMPreference implements OnClickListener, e {
    protected Button eWk;
    private Dialog eXG = null;
    protected f gua;
    private String hwH;
    private LinearLayout kkE;
    protected Orders mCZ;
    protected MMSwitchBtn pfU;
    protected ArrayList<Preference> pfV;
    protected TextView pfW;
    private TextView pfX;
    private TextView pfY;
    private String pfZ;
    private String pga;
    private Bankcard pgb;
    protected boolean pgc = false;
    private int pgd = 0;
    private String pge;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gua = this.tCL;
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(c.white)));
        View customView = getSupportActionBar().getCustomView();
        if (customView != null) {
            View findViewById = customView.findViewById(a.f.divider);
            if (findViewById != null) {
                findViewById.setBackgroundColor(getResources().getColor(c.transparent));
            }
            customView = customView.findViewById(16908309);
            if (customView != null && (customView instanceof TextView)) {
                ((TextView) customView).setTextColor(getResources().getColor(c.white));
            }
        }
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            if (d.fR(23)) {
                window.setStatusBarColor(getResources().getColor(c.wallet_deduct_status_bar_bg));
                getWindow().getDecorView().setSystemUiVisibility(8192);
            } else {
                getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
            }
        }
        Intent intent = getIntent();
        if (intent == null) {
            x.e("MicroMsg.WalletPayDeductUI", "intent is null");
            finish();
            return;
        }
        this.mCZ = (Orders) intent.getParcelableExtra("orders");
        if (this.mCZ == null || this.mCZ.ppk == null) {
            x.e("MicroMsg.WalletPayDeductUI", "Orders data or deductInfo is null   : " + this.mCZ);
            finish();
        }
        cC(this.mCZ.ppk.ppJ);
        setResult(0);
        setBackBtn(new 1(this), h.actionbar_icon_dark_back);
        g.Ek();
        g.Eh().dpP.a(385, this);
        initView();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
        g.Ek();
        g.Eh().dpP.b(385, this);
    }

    public final int Ys() {
        return -1;
    }

    protected final void initView() {
        boolean z;
        this.pfW = (TextView) this.mController.contentView.findViewById(a.f.bindcard_tip_tv);
        this.eWk = (Button) this.mController.contentView.findViewById(a.f.next_btn);
        this.kkE = (LinearLayout) findViewById(a.f.pay_way_ll);
        ((TextView) findViewById(a.f.deduct_title)).setText(this.mCZ.ppk.title);
        ((TextView) findViewById(a.f.title)).setText(((Commodity) this.mCZ.ppf.get(0)).desc);
        WalletTextView walletTextView = (WalletTextView) findViewById(a.f.fee_type);
        walletTextView.setTypeface(0);
        walletTextView.setText(com.tencent.mm.wallet_core.ui.e.abX(this.mCZ.lNV));
        ((TextView) findViewById(a.f.fee)).setText(((Commodity) this.mCZ.ppf.get(0)).hUL);
        TextView textView = (TextView) findViewById(a.f.footer_tips);
        TextView textView2 = (TextView) findViewById(a.f.deduct_desc);
        if (bi.oW(this.mCZ.ppk.ppL)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(this.mCZ.ppk.ppL);
            if (!bi.oW(this.mCZ.ppk.ppM)) {
                textView2.setTextColor(Color.parseColor(this.mCZ.ppk.ppM));
            }
        }
        this.pfX = (TextView) findViewById(a.f.default_bankCard_tv);
        this.pfY = (TextView) findViewById(a.f.bankCard_tip_tv);
        if (this.mCZ.ppk.pgM == 1) {
            z = true;
        } else {
            z = false;
        }
        this.pgc = z;
        this.pgd = this.mCZ.ppk.pgd;
        this.hwH = this.mCZ.ppk.hwH;
        this.pge = this.mCZ.ppk.pge;
        x.i("MicroMsg.WalletPayDeductUI", "open: %s, show_type: %s", new Object[]{Boolean.valueOf(this.pgc), Integer.valueOf(this.pgd)});
        if (this.pgd == 0) {
            this.pfU = (MMSwitchBtn) findViewById(a.f.checkbox);
            this.pfU.setCheck(this.pgc);
            this.pfU.setSwitchListener(new 2(this));
            jn(this.pgc);
        } else {
            if (!bi.oW(this.hwH)) {
                this.eWk.setText(this.hwH);
            }
            if (!bi.oW(this.pge)) {
                this.pfW.setText(this.pge);
                this.pfW.setVisibility(0);
            }
            findViewById(a.f.deduct_checkbox_layout).setVisibility(8);
            bNI();
        }
        x.d("MicroMsg.WalletPayDeductUI", "show pay way layout: %d", new Object[]{Integer.valueOf(this.mCZ.ppk.ppK)});
        if (this.mCZ.ppk.ppK == 1) {
            g.Ek();
            this.pga = (String) g.Ei().DT().get(aa.a.sTn, "");
            g.Ek();
            this.pfZ = (String) g.Ei().DT().get(aa.a.sTm, "");
            if (bi.oW(this.pfZ) || bi.oW(this.pfZ)) {
                x.i("MicroMsg.WalletPayDeductUI", "need do pay manager");
                this.eXG = com.tencent.mm.wallet_core.ui.g.a(this.mController.tml, false, null);
                com.tencent.mm.plugin.wallet.pwd.a.c cVar = new com.tencent.mm.plugin.wallet.pwd.a.c();
                g.Ek();
                g.Eh().dpP.a(cVar, 0);
            } else {
                this.pfY.setText(this.pga);
                bNH();
            }
        } else {
            this.kkE.setVisibility(8);
        }
        if (bi.oW(this.mCZ.ppk.ppI)) {
            textView.setVisibility(8);
        } else {
            String string = getString(i.wallet_deduct_foot_tips_part1);
            String string2 = getString(i.wallet_deduct_foot_tips_part2);
            CharSequence a = j.a(this, getString(i.wallet_deduct_foot_tips, new Object[]{string, string2}));
            com.tencent.mm.plugin.wallet_core.ui.h hVar = new com.tencent.mm.plugin.wallet_core.ui.h(this.mController.tml);
            CharSequence spannableString = new SpannableString(a);
            spannableString.setSpan(hVar, a.length() - string2.length(), a.length(), 33);
            textView.setTextColor(getResources().getColor(c.hint_text_color));
            textView.setText(spannableString);
            textView.setOnClickListener(this);
            textView.setVisibility(0);
        }
        this.eWk.setOnClickListener(this);
    }

    private void bNH() {
        p.bNp();
        ag bNq = p.bNq();
        if (this.pgb == null) {
            this.pgb = bNq.a(null, null, true, true, true);
        }
        if (this.pgb == null) {
            x.i("MicroMsg.WalletPayDeductUI", "no bank card!");
            finish();
            return;
        }
        CharSequence spannableString = new SpannableString(this.pgb.field_desc);
        com.tencent.mm.plugin.wallet_core.ui.h hVar = new com.tencent.mm.plugin.wallet_core.ui.h(this.mController.tml);
        hVar.pvm = new 3(this, bNq.jl(true));
        spannableString.setSpan(hVar, 0, spannableString.length(), 18);
        this.pfX.setText(spannableString);
        this.pfX.setMovementMethod(LinkMovementMethod.getInstance());
    }

    protected final void jn(boolean z) {
        if (z) {
            findViewById(16908298).setVisibility(0);
            if (this.mCZ.ppk.ppK == 1) {
                this.kkE.setVisibility(0);
            } else {
                this.kkE.setVisibility(8);
            }
            bNI();
            if (o.bOW().bPs()) {
                this.pfW.setVisibility(8);
                this.eWk.setText(i.wallet_deduct_pay_open_button_txt);
            } else {
                this.pfW.setVisibility(0);
                this.pfW.setText(i.wallet_deduct_pay_need_bind_card_txt);
                this.eWk.setText(i.wallet_deduct_pay_bind_card_button_txt);
            }
        } else {
            if (this.pfV != null && this.pfV.size() > 0) {
                int size = this.pfV.size();
                for (int i = 0; i < size; i++) {
                    this.gua.bw(((Preference) this.pfV.get(i)).mKey, true);
                }
            }
            findViewById(16908298).setVisibility(8);
            this.kkE.setVisibility(8);
            this.pfW.setVisibility(8);
            this.eWk.setText(i.wallet_deduct_pay_button_txt);
        }
        x.i("MicroMsg.WalletPayDeductUI", "isCheck=" + this.pfU.uGQ);
    }

    private void bNI() {
        if (this.pfV != null && this.pfV.size() > 0) {
            int size = this.pfV.size();
            for (int i = 0; i < size; i++) {
                this.gua.bw(((Preference) this.pfV.get(i)).mKey, false);
            }
            this.gua.notifyDataSetChanged();
        }
    }

    private void cC(List<DeductShowInfo> list) {
        if (list == null || list.size() == 0) {
            x.e("MicroMsg.WalletPayDeductUI", "showinfos is null or length is 0");
        } else if (this.pfV == null) {
            int size = list.size();
            this.pfV = new ArrayList();
            for (int i = 0; i < size; i++) {
                DeductShowInfo deductShowInfo = (DeductShowInfo) list.get(i);
                if (!(deductShowInfo == null || bi.oW(deductShowInfo.name))) {
                    com.tencent.mm.plugin.wallet_core.ui.d dVar = new com.tencent.mm.plugin.wallet_core.ui.d(this);
                    dVar.setTitle(deductShowInfo.name);
                    if (deductShowInfo.ppN > 0) {
                        dVar.lQm = getResources().getColor(c.link_color);
                        String str = deductShowInfo.value;
                        4 4 = new 4(this, deductShowInfo);
                        dVar.jNk = str;
                        dVar.jNo = true;
                        dVar.iFK = 4;
                    } else {
                        dVar.jNk = deductShowInfo.value;
                        dVar.jNo = false;
                    }
                    dVar.setKey("deduct_info_" + i);
                    this.pfV.add(dVar);
                    this.gua.a(dVar);
                    this.gua.bw(dVar.mKey, true);
                }
            }
        }
    }

    protected final int getLayoutId() {
        return a.g.wallet_pay_deduct_ui;
    }

    public final boolean a(f fVar, Preference preference) {
        return false;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.next_btn) {
            Intent intent = new Intent();
            if (this.pgd == 0) {
                intent.putExtra("auto_deduct_flag", this.pfU.uGQ ? 1 : 0);
            } else {
                intent.putExtra("auto_deduct_flag", this.mCZ.ppk.pgM);
            }
            if (this.pgb != null) {
                intent.putExtra("deduct_bank_type", this.pgb.field_bankcardType);
                intent.putExtra("deduct_bind_serial", this.pgb.field_bindSerial);
                x.i("MicroMsg.WalletPayDeductUI", "deduct bankType: %s", new Object[]{this.pgb.field_bankcardType});
            }
            setResult(-1, intent);
            finish();
        } else if (id == a.f.footer_tips && !bi.oW(this.mCZ.ppk.ppI)) {
            Intent intent2 = new Intent();
            intent2.putExtra("rawUrl", this.mCZ.ppk.ppI);
            intent2.putExtra("showShare", false);
            com.tencent.mm.bg.d.b(this, "webview", ".ui.tools.WebViewUI", intent2);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.WalletPayDeductUI", "errType: %d, errCode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (!(lVar instanceof com.tencent.mm.plugin.wallet.pwd.a.c)) {
            x.d("MicroMsg.WalletPayDeductUI", "other tenpay scene");
        } else if (i == 0 && i2 == 0) {
            g.Ek();
            this.pga = (String) g.Ei().DT().get(aa.a.sTn, getString(i.wallet_pay_deduct_change_pay_way_tip));
            g.Ek();
            this.pfZ = (String) g.Ei().DT().get(aa.a.sTm, getString(i.wallet_pay_deduct_select_pay_way_label));
            this.pfY.setText(this.pga);
            bNH();
        }
        if (this.eXG != null) {
            this.eXG.dismiss();
        }
    }
}
