package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.balance.a;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.plugin.wallet_core.model.aa;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.j;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.k.10;
import com.tencent.mm.plugin.wallet_core.ui.k.7;
import com.tencent.mm.plugin.wallet_core.ui.k.8;
import com.tencent.mm.plugin.wallet_core.ui.k.9;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.c.q;
import com.tencent.mm.wallet_core.c.v;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class WalletBalanceManagerUI extends WalletBaseUI implements j {
    protected int fdx;
    protected TextView oZM;
    protected TextView pan;
    protected Button pao;
    protected View pap;
    protected View paq;
    protected TextView par;
    protected ViewGroup pas;
    protected CdnImageView pat;
    protected TextView pau;
    protected TextView pav;
    protected Bankcard paw;

    static /* synthetic */ void c(WalletBalanceManagerUI walletBalanceManagerUI) {
        Bundle bundle = new Bundle();
        walletBalanceManagerUI.sy.get("key_pay_info");
        PayInfo payInfo = new PayInfo();
        payInfo.bVY = 21;
        bundle.putParcelable("key_pay_info", payInfo);
        bundle.putInt("key_scene", 21);
        bundle.putInt("key_bind_scene", 0);
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putInt("key_bind_scene", 0);
        bundle.putBoolean("key_is_bind_bankcard", true);
        bundle.putInt("from_bind_ui", a.oYw);
        com.tencent.mm.wallet_core.a.a((Activity) walletBalanceManagerUI, a.class, bundle, null);
    }

    protected final int getLayoutId() {
        return g.wallet_balance_manager_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        lF(getResources().getColor(c.normal_actionbar_color));
        cqh();
        ((b) com.tencent.mm.kernel.g.l(b.class)).a(this, null);
        setBackBtn(new 1(this), h.actionbar_icon_dark_back);
        this.fdx = getIntent().getIntExtra("key_scene_balance_manager", 0);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("key_inc_bal_amt_flag");
        ECardInfo eCardInfo = (ECardInfo) intent.getParcelableExtra("key_ecard_info");
        if ("3".equals(stringExtra)) {
            if (eCardInfo != null) {
                View inflate = LayoutInflater.from(this).inflate(g.wallet_inc_balance_amt_dialog, null);
                ImageView imageView = (ImageView) inflate.findViewById(f.close_icon);
                int b = BackwardSupportUtil.b.b(this, 15.0f);
                bi.j(imageView, b, b, b, b);
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(f.main_tip_wording);
                Button button = (Button) inflate.findViewById(f.upload_btn);
                TextView textView = (TextView) inflate.findViewById(f.main_protocol_wording);
                CheckBox checkBox = (CheckBox) inflate.findViewById(f.checkbox);
                TextView textView2 = (TextView) inflate.findViewById(f.checkbox_protocal_tv);
                ((TextView) inflate.findViewById(f.main_title)).setText(eCardInfo.title);
                linearLayout.removeAllViews();
                Iterator it = eCardInfo.pnf.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    View inflate2 = LayoutInflater.from(this).inflate(g.wallet_id_card_wordingtip, null);
                    ((TextView) inflate2.findViewById(f.wording_tip)).setText(str);
                    linearLayout.addView(inflate2);
                }
                b = eCardInfo.pni.length();
                int length = (eCardInfo.pni + eCardInfo.pnj).length();
                CharSequence spannableString = new SpannableString(eCardInfo.pni + eCardInfo.pnj);
                spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(c.wallet_offline_link_color)), b, length, 33);
                textView.setText(spannableString);
                textView.setOnClickListener(new k$6(eCardInfo, this));
                Dialog dialog = new Dialog(this, com.tencent.mm.plugin.wxpay.a.j.mmalertdialog);
                dialog.setContentView(inflate);
                dialog.setTitle(null);
                dialog.setOnCancelListener(new 7(dialog));
                imageView.setOnClickListener(new 8(dialog));
                button.setOnClickListener(new 9(eCardInfo, this, dialog));
                if (eCardInfo.pmZ == 1) {
                    checkBox.setOnCheckedChangeListener(new 10(button));
                    if (eCardInfo.pna == 1) {
                        checkBox.setChecked(true);
                    } else {
                        checkBox.setChecked(false);
                        button.setEnabled(false);
                        button.setClickable(false);
                    }
                } else {
                    checkBox.setVisibility(8);
                }
                int length2 = eCardInfo.pnb.length();
                length = (eCardInfo.pnb + eCardInfo.pnc).length();
                CharSequence spannableString2 = new SpannableString(eCardInfo.pnb + eCardInfo.pnc);
                spannableString2.setSpan(new ForegroundColorSpan(getResources().getColor(c.wallet_offline_link_color)), length2, length, 33);
                textView2.setText(spannableString2);
                textView2.setOnClickListener(new k$2(eCardInfo, this));
                dialog.show();
            } else {
                x.w("MicroMsg.WalletBalanceManagerUI", "ecard info is null");
            }
        }
        jr(621);
        o.bPd();
        aa.a(this);
        initView();
        q.fu(2, 0);
        com.tencent.mm.plugin.report.service.h.mEJ.h(11850, new Object[]{Integer.valueOf(6), Integer.valueOf(0)});
        e.He(10);
    }

    public void bMV() {
        boolean z;
        p.bNp();
        if (p.bNq().paw == null) {
            z = true;
        } else {
            z = false;
        }
        a(new y(null, 10), z, false);
    }

    public void onDestroy() {
        js(621);
        o.bPd();
        aa.b(this);
        super.onDestroy();
    }

    public void bMW() {
        L(WalletBalanceSaveUI.class);
    }

    protected final void initView() {
        boolean fU;
        setMMTitle(i.wallet_balance_manager_title);
        this.pan = (TextView) findViewById(f.wallet_balance_total);
        this.oZM = (TextView) findViewById(f.wallet_balance_manager_banner);
        ((Button) findViewById(f.next_btn)).setOnClickListener(new 7(this));
        this.pao = (Button) findViewById(f.wallet_balance_manager_fetch_btn);
        this.pao.setOnClickListener(new 8(this));
        TextView textView = (TextView) findViewById(f.wallet_balance_manager_qanda);
        if (w.chP().equals("zh_CN")) {
            fU = bi.fU(ad.getContext());
        } else {
            fU = true;
        }
        if (fU) {
            textView.setVisibility(8);
        } else {
            textView.setOnClickListener(new 9(this));
            textView.setVisibility(0);
        }
        ((TextView) findViewById(f.wallet_support_info)).setText(v.cDl());
        this.pap = findViewById(f.licaitong_layout);
        this.par = (TextView) findViewById(f.licaitong_tips);
        this.paq = findViewById(f.licaitong_icon);
        this.pas = (ViewGroup) findViewById(f.lqt_cell_entry);
        this.pat = (CdnImageView) findViewById(f.lqt_cell_icon);
        this.pat.setUseSdcardCache(true);
        this.pav = (TextView) findViewById(f.lqt_cell_wording);
        this.pau = (TextView) findViewById(f.lqt_cell_title);
        final sy syVar = new sy();
        syVar.cdO.buF = "2";
        syVar.bJX = new Runnable() {
            public final void run() {
                if (!bi.oW(syVar.cdP.cdQ)) {
                    e.a(WalletBalanceManagerUI.this.oZM, syVar.cdP.cdQ, syVar.cdP.content, syVar.cdP.url);
                }
            }
        };
        com.tencent.mm.sdk.b.a.sFg.m(syVar);
    }

    public void onResume() {
        aL();
        bMV();
        super.onResume();
        b bVar = (b) com.tencent.mm.kernel.g.l(b.class);
        bVar.a(this, bVar.bRo(), null);
    }

    public final void aL() {
        boolean z;
        int i;
        String str = null;
        p.bNp();
        this.paw = p.bNq().paw;
        if (this.paw != null) {
            if (this.paw.plV >= 0.0d) {
                this.pan.setText(e.B(this.paw.plV));
            } else {
                this.pan.setText(getString(i.wallet_index_ui_default_balance));
            }
            p.bNp();
            if ((p.bNq().bPw().prx & 4) > 0) {
                z = true;
            } else {
                z = false;
            }
            x.i("MicroMsg.WalletSwitchConfig", "isBalanceFetchOn, ret = %s switchBit %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(p.bNq().bPw().prx)});
            i = (!z || this.paw.plV <= 0.0d) ? 0 : 1;
            if (i != 0) {
                this.pao.setVisibility(0);
            } else {
                this.pao.setVisibility(8);
            }
            bMX();
        }
        View findViewById = findViewById(f.lqt_red_dot);
        com.tencent.mm.kernel.g.Ek();
        if (((Integer) com.tencent.mm.kernel.g.Ei().DT().get(com.tencent.mm.storage.aa.a.sXO, Integer.valueOf(-1))).intValue() == 1) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        if ((new ae().prx & 32768) > 0) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.WalletSwitchConfig", "isShowRealnameGuide, ret = %s switchBit %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(new ae().prx)});
        if (z) {
            com.tencent.mm.kernel.g.Ek();
            String str2 = (String) com.tencent.mm.kernel.g.Ei().DT().get(com.tencent.mm.storage.aa.a.sTk, getString(i.realname_mgr_title));
            this.pap.setVisibility(0);
            this.par.setTextColor(getResources().getColor(c.wallet_balance_manager_realname_tip));
            this.par.setText(str2);
            this.paq.setVisibility(8);
            this.pap.setOnClickListener(new 11(this));
            return;
        }
        CharSequence charSequence;
        CharSequence charSequence2;
        p.bNp();
        ag bNq = p.bNq();
        z = (bNq.prA != null ? bNq.prA.field_lqt_cell_is_show : 0) == 1;
        p.bNp();
        ag bNq2 = p.bNq();
        if (bNq2.prA != null) {
            charSequence = bNq2.prA.field_lqt_cell_lqt_title;
        } else {
            charSequence = null;
        }
        p.bNp();
        ag bNq3 = p.bNq();
        if (bNq3.prA != null) {
            charSequence2 = bNq3.prA.field_lqt_cell_lqt_wording;
        } else {
            charSequence2 = null;
        }
        x.i("MicroMsg.WalletBalanceManagerUI", "isShowLqtCell:%s lqtCellTitle:%s lqtCellWording:%s", new Object[]{Boolean.valueOf(z), charSequence, charSequence2});
        if (!z || (bi.oW(charSequence) && bi.oW(charSequence2))) {
            this.pas.setVisibility(8);
            p.bNp();
            if (p.bNq().bPC()) {
                this.pap.setVisibility(0);
                this.pap.setOnClickListener(new 14(this));
                TextView textView = this.par;
                p.bNp();
                textView.setText(p.bNq().bPz());
                this.paq.setVisibility(0);
                return;
            }
            p.bNp();
            bNq2 = p.bNq();
            if (bNq2 != null) {
                if ((bNq2.bPw().prx & 1024) > 0) {
                    z = true;
                } else {
                    z = false;
                }
                x.i("MicroMsg.WalletSwitchConfig", "isSupportLCT, ret = %s switchBit %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(bNq2.bPw().prx)});
                if (!(!z || TextUtils.isEmpty(bNq2.bPz()) || TextUtils.isEmpty(bNq2.bPA()))) {
                    this.pap.setVisibility(0);
                    this.par.setText(bNq2.bPz());
                    this.paq.setVisibility(0);
                    this.pap.setOnClickListener(new 2(this, bNq2));
                    return;
                }
            }
            this.pap.setVisibility(8);
            return;
        }
        this.pap.setVisibility(8);
        p.bNp();
        bNq = p.bNq();
        if (bNq.prA != null) {
            str = bNq.prA.field_lqt_cell_icon;
        }
        if (bi.oW(str)) {
            this.pat.setVisibility(8);
        } else {
            this.pat.setUrl(str);
            this.pat.setVisibility(0);
        }
        this.pau.setText(charSequence);
        this.pav.setText(charSequence2);
        p.bNp();
        bNq = p.bNq();
        if (bNq.prA != null) {
            i = bNq.prA.field_lqt_cell_is_open_lqt;
        } else {
            i = 0;
        }
        if (i == 1) {
            this.pav.setTextColor(getResources().getColor(c.black));
            this.pas.setOnClickListener(new 12(this));
        } else {
            this.pav.setTextColor(getResources().getColor(c.grey_text_color));
            this.pas.setOnClickListener(new 13(this));
        }
        this.pas.setVisibility(0);
    }

    private void bMX() {
        String str;
        JSONObject jSONObject;
        Throwable e;
        this.mController.removeAllOptionMenu();
        JSONObject jSONObject2 = null;
        boolean z;
        try {
            str = (String) com.tencent.mm.kernel.g.Ei().DT().get(com.tencent.mm.storage.aa.a.sZr, "");
            if (bi.oW(str)) {
                z = false;
                jSONObject = null;
            } else {
                jSONObject = new JSONObject(str);
                try {
                    z = jSONObject.optBoolean("is_show_menu", false);
                } catch (JSONException e2) {
                    e = e2;
                    jSONObject2 = jSONObject;
                }
            }
        } catch (JSONException e3) {
            e = e3;
            x.printErrStackTrace("MicroMsg.WalletBalanceManagerUI", e, "", new Object[0]);
            z = false;
            jSONObject = jSONObject2;
            if (jSONObject == null) {
            }
            x.i("MicroMsg.WalletBalanceManagerUI", "go old menu logic");
            p.bNp();
            p.bNq();
            str = this.paw.field_bindSerial;
            if (!bi.oW(this.paw.plY)) {
                a(getString(i.wallet_balance_manager_option_detail), (OnMenuItemClickListener) new 4(this), s.b.tng);
            }
        }
        if (jSONObject == null && z) {
            x.i("MicroMsg.WalletBalanceManagerUI", "go new menu logic");
            addIconOptionMenu(0, h.actionbar_icon_dark_more, new 3(this, jSONObject, new ArrayList()));
            return;
        }
        x.i("MicroMsg.WalletBalanceManagerUI", "go old menu logic");
        p.bNp();
        p.bNq();
        str = this.paw.field_bindSerial;
        if (!bi.oW(this.paw.plY)) {
            a(getString(i.wallet_balance_manager_option_detail), (OnMenuItemClickListener) new 4(this), s.b.tng);
        }
    }

    public boolean d(int i, int i2, String str, l lVar) {
        if (i == 0 && i2 == 0 && !(lVar instanceof com.tencent.mm.plugin.wallet.bind.a.b) && (lVar instanceof y)) {
            aL();
        }
        return false;
    }

    public final void ss(int i) {
        p.bNp();
        this.paw = p.bNq().paw;
        if (this.paw != null) {
            if (this.paw.plV >= 0.0d) {
                this.pan.setText(e.B(this.paw.plV));
            } else {
                this.pan.setText(getString(i.wallet_index_ui_default_balance));
            }
            bMX();
        }
    }

    protected void onNewIntent(Intent intent) {
        x.i("MicroMsg.WalletBalanceManagerUI", "jumpFethProcess from bind ui flag:" + intent.getIntExtra("from_bind_ui", 0));
        if (intent.getIntExtra("from_bind_ui", 0) == a.oYw) {
            com.tencent.mm.wallet_core.a.a((Activity) this, com.tencent.mm.plugin.wallet.balance.b.class, null, null);
            e.He(15);
        }
    }
}
