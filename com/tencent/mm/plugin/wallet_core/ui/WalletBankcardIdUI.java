package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView$a;
import java.util.List;

@a(19)
public class WalletBankcardIdUI extends WalletBaseUI implements WalletFormView$a {
    private Button eUb;
    private int fdx = -1;
    c pdx = new 1(this);
    c phJ = new 2(this);
    protected WalletFormView psQ;
    protected WalletFormView psR;
    private Bankcard psS;
    private a psT;
    private boolean psU = false;
    private boolean psV;

    static /* synthetic */ void a(WalletBankcardIdUI walletBankcardIdUI) {
        LayoutInflater layoutInflater = (LayoutInflater) walletBankcardIdUI.mController.tml.getSystemService("layout_inflater");
        TextView textView = (TextView) layoutInflater.inflate(g.illustraction_dialog_msg_tv, null);
        textView.setText(walletBankcardIdUI.getString(i.wallet_card_secure_illustraction_detail));
        int dimensionPixelSize = layoutInflater.getContext().getResources().getDimensionPixelSize(d.LargePadding);
        textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        h.a(walletBankcardIdUI.mController.tml, walletBankcardIdUI.getString(i.wallet_card_secure_illustraction), walletBankcardIdUI.getString(i.wallet_i_know_it), textView, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    static /* synthetic */ void a(WalletBankcardIdUI walletBankcardIdUI, String str, String str2, Bitmap bitmap) {
        Bundle bundle = new Bundle();
        bundle.putString("key_bankcard_id", str);
        bundle.putString("key_bankcard_des", str2);
        bundle.putParcelable("key_bankcard_cropimg", bitmap);
        com.tencent.mm.wallet_core.c af = com.tencent.mm.wallet_core.a.af(walletBankcardIdUI);
        if (af != null) {
            af.c(walletBankcardIdUI, WalletConfirmCardIDUI.class, bundle);
        }
    }

    protected final int getLayoutId() {
        return g.wallet_bankcard_id_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(i.wallet_input_card_ui_title);
        initView();
        com.tencent.mm.sdk.b.a.sFg.b(this.pdx);
        com.tencent.mm.sdk.b.a.sFg.b(this.phJ);
        this.fdx = this.sy.getInt("key_bind_scene");
    }

    public void onDestroy() {
        com.tencent.mm.sdk.b.a.sFg.c(this.pdx);
        com.tencent.mm.sdk.b.a.sFg.c(this.phJ);
        super.onDestroy();
    }

    protected final void initView() {
        this.eUb = (Button) findViewById(f.next_btn);
        this.psQ = (WalletFormView) findViewById(f.card_num_et);
        com.tencent.mm.wallet_core.ui.formview.a.b(this.psQ);
        this.psR = (WalletFormView) findViewById(f.name_et);
        if (this.sy.getBoolean("key_bind_show_change_card", false)) {
            com.tencent.mm.wallet_core.ui.formview.a.d(this, this.psR);
        } else {
            com.tencent.mm.wallet_core.ui.formview.a.e(this, this.psR);
        }
        this.psQ.setOnInputValidChangeListener(this);
        this.eUb.setOnClickListener(new 3(this));
        com.tencent.mm.wallet_core.c cDK = cDK();
        if (cDK != null) {
            this.psV = cDK.jfZ.getBoolean("key_is_realname_verify_process", false);
        } else {
            this.psV = false;
        }
        if (this.psV) {
            setMMTitle(i.wallet_real_name_verify_title);
        } else {
            setMMTitle(i.wallet_input_card_ui_title);
        }
        TextView textView = (TextView) findViewById(f.input_tip);
        if (o.bOW().bPp() || o.bOW().bPt()) {
            h hVar = new h(this);
            hVar.pvm = new 4(this);
            String string = getString(i.wallet_input_card_first_bind_tips);
            CharSequence spannableString = new SpannableString(string);
            spannableString.setSpan(hVar, string.length() - 6, string.length(), 33);
            textView.setText(spannableString);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        } else {
            textView.setVisibility(0);
            CharSequence string2 = this.sy.getString("key_custom_bind_tips");
            if (!bi.oW(string2)) {
                textView.setText(string2);
            }
        }
        FavorPayInfo favorPayInfo = (FavorPayInfo) this.sy.getParcelable("key_favor_pay_info");
        Orders orders = (Orders) this.sy.getParcelable("key_orders");
        if (!(favorPayInfo == null || orders == null)) {
            a a = b.psB.a(orders);
            TextView textView2 = (TextView) findViewById(f.wallet_card_favor_tips);
            if (a != null) {
                List Pm = a.Pm(a.Pp(favorPayInfo.pnP));
                if (Pm.size() > 0) {
                    this.psT = new a(this.mController.tml, Pm);
                    textView2.setText(i.wallet_input_card_favor_tips);
                    textView2.setOnClickListener(new 5(this));
                    textView2.setVisibility(0);
                } else {
                    textView2.setVisibility(8);
                }
            } else {
                x.w("Micromsg.WalletInputCardIDUI", "favorlogichelper null");
                textView2.setVisibility(8);
            }
        }
        ag bOW = o.bOW();
        if (!bOW.bPs() || bOW.aCl() == null || bi.oW(bOW.aCl().trim()) || !bOW.bPx()) {
            this.psR.setVisibility(8);
            this.psQ.setHint(getString(i.wallet_input_card_num_hint));
        } else {
            this.psR.setVisibility(0);
            this.psR.setText(bOW.aCl());
            this.psQ.setHint(getString(i.wallet_card_num_hint));
            this.psR.setClickable(false);
            this.psR.setEnabled(false);
        }
        if (this.sy.getInt("key_bind_scene") == 18 || this.sy.getInt("key_bind_scene") == 19) {
            this.psQ.setHint(getString(i.wallet_input_card_only_debit_card_hint));
        }
        com.tencent.mm.kernel.g.Ek();
        String str = (String) com.tencent.mm.kernel.g.Ei().DT().get(aa.a.USERINFO_WALLET_SUPPORT_BANK_WORD_STRING, null);
        if (!bi.oW(str)) {
            this.psQ.setHint(str);
        }
        this.psS = (Bankcard) this.sy.getParcelable("key_history_bankcard");
        if (this.psS != null) {
            this.psQ.setText(this.psS.plR);
            this.psQ.a(new 6(this));
        }
        ZB();
        com.tencent.mm.plugin.wallet_core.e.c.b(this, this.sy, 2);
        d(this.psQ, 0, false);
        this.psQ.setOnInfoIvClickListener(new 7(this));
        if (o.bOW().bPw().bPk()) {
            this.psQ.getInfoIv().setVisibility(0);
            this.psQ.getInfoIv().setImageResource(com.tencent.mm.plugin.wxpay.a.h.wallet_scan_camera);
        }
    }

    protected final void YO() {
        if (cDK() == null) {
            x.e("Micromsg.WalletInputCardIDUI", "WalletBankcardIdUI doNext, process is null");
            return;
        }
        String string = cDK().jfZ.getString("kreq_token");
        int i = this.sy.getInt("entry_scene", -1);
        if (this.psS != null) {
            t tVar = new t(bNs(), null, (PayInfo) this.sy.getParcelable("key_pay_info"), string, this.fdx, i);
            tVar.mwc = this.psS.field_bankcardType;
            this.sy.putParcelable("key_history_bankcard", this.psS);
            a(tVar, true, true);
        } else if (ZB()) {
            a(new t(bNs(), this.psQ.getText(), (PayInfo) this.sy.getParcelable("key_pay_info"), string, this.fdx, i), true, true);
        } else {
            h.i(this, i.wallet_not_exist, i.app_tip);
        }
    }

    protected Dialog onCreateDialog(int i) {
        if (i == 1) {
            View inflate = getLayoutInflater().inflate(g.wallet_list_dialog, null);
            ((ListViewInScrollView) inflate.findViewById(f.address_contactlist)).setAdapter(this.psT);
            com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(this);
            aVar.Gq(i.wallet_input_card_bank_favor_title);
            aVar.dR(inflate);
            aVar.e(null);
            aVar.Gt(i.wallet_i_know_it);
            return aVar.anj();
        } else if (!this.psV || i != 1000) {
            return super.onCreateDialog(i);
        } else {
            int a;
            String string = getString(i.wallet_input_card_finish_confirm);
            com.tencent.mm.wallet_core.c af = com.tencent.mm.wallet_core.a.af(this);
            if (af != null) {
                a = af.a(this, 1);
            } else {
                a = -1;
            }
            if (a != -1) {
                string = getString(a);
            }
            return h.a(this, true, string, "", getString(i.app_yes), getString(i.app_no), new 8(this), new 9(this));
        }
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        x.d("Micromsg.WalletInputCardIDUI", " errCode: " + i2 + " errMsg :" + str);
        Bundle bundle = new Bundle();
        if (i == 0 && i2 == 0) {
            if (lVar instanceof t) {
                t tVar = (t) lVar;
                bundle.putBoolean("key_need_area", tVar.bOl());
                bundle.putBoolean("key_need_profession", tVar.bOm());
                bundle.putParcelableArray("key_profession_list", tVar.pjD);
                if (tVar.pjz == null) {
                    bundle.putString("bank_name", "");
                    bundle.putParcelable("elemt_query", new ElementQuery());
                    bundle.putString("key_card_id", this.psQ.getText());
                    com.tencent.mm.wallet_core.a.j(this, bundle);
                } else if (tVar.pjz.pnr && tVar.pjz.isError()) {
                    h.i(this, i.wallet_bank_broken, i.app_tip);
                    return true;
                } else {
                    bundle.putString("bank_name", tVar.pjz.knE);
                    bundle.putParcelable("elemt_query", tVar.pjz);
                    bundle.putString("key_card_id", this.psQ.getText());
                    com.tencent.mm.wallet_core.a.j(this, bundle);
                    return true;
                }
            }
        } else if (i2 == 1 && (lVar instanceof t)) {
            bundle.putString("bank_name", "");
            bundle.putParcelable("elemt_query", new ElementQuery());
            bundle.putString("key_card_id", this.psQ.getText());
            com.tencent.mm.wallet_core.a.j(this, bundle);
            return true;
        }
        return false;
    }

    private boolean ZB() {
        if (this.psQ.dX(null)) {
            this.eUb.setEnabled(true);
            this.eUb.setClickable(true);
            return true;
        }
        this.eUb.setEnabled(false);
        this.eUb.setClickable(false);
        return false;
    }

    public final void fE(boolean z) {
        if (!z) {
            this.psS = null;
            this.sy.putParcelable("key_history_bankcard", null);
        }
        ZB();
    }

    protected final boolean bND() {
        return true;
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
