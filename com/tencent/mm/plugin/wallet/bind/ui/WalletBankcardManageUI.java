package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.b.b;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;

public class WalletBankcardManageUI extends WalletBaseUI {
    private ListView CU = null;
    private OnItemClickListener PY = new 9(this);
    private OnClickListener eZF = new 8(this);
    private q kZX = new q();
    public ArrayList<Bankcard> pcZ = new ArrayList();
    private ArrayList<Bankcard> pda = new ArrayList();
    protected ag pdb = null;
    private ListView pdc = null;
    private a pdd = null;
    private a pde = null;
    private TextView pdf;
    private View pdg;
    private View pdh;
    private View pdi;
    private CdnImageView pdj;
    private TextView pdk;
    private k pdl;

    protected final int getLayoutId() {
        return g.wallet_bankcard_manage_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ux(4);
        x.i("MicroMsg.WalletBankcardManageUI", "index Oncreate");
        p.bNp();
        this.pdb = p.bNq();
        setMMTitle(i.wallet_index_ui_title);
        lF(this.mController.tml.getResources().getColor(c.dark_actionbar_color));
        cqh();
        initView();
        com.tencent.mm.wallet_core.c.q.fu(5, 0);
        e.He(27);
        this.pdl = o.bOW().prD;
        this.kZX.pzb = new 1(this);
    }

    public void onResume() {
        if (this.pdb.bPr()) {
            jk(true);
        } else {
            this.pdb.f(this.pcZ, this.pda);
            if (this.pdb.paw != null) {
                ux(0);
            }
            jk(false);
        }
        this.kZX.onResume();
        aL();
        super.onResume();
    }

    public void onPause() {
        super.onPause();
        this.kZX.onPause();
    }

    public void jk(boolean z) {
        if (z) {
            a(new y(null, 12), true, false);
        } else {
            a(new y(null, 12), false, false);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1) {
            return;
        }
        if (i2 == -1) {
            this.kZX.bcc();
        } else {
            this.kZX.cancel();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.pdd.pcA.destory();
        this.pde.pcA.destory();
    }

    protected final void initView() {
        setBackBtn(new 3(this));
        this.pdf = (TextView) findViewById(f.wallet_add_bankcard_for_empty);
        this.pdf.setOnClickListener(new 4(this));
        this.CU = (ListView) findViewById(f.bankcard_list);
        this.pdd = bNi();
        this.CU.setAdapter(this.pdd);
        this.CU.setOnItemClickListener(this.PY);
        this.pdc = (ListView) findViewById(f.virtual_bankcard_list);
        this.pde = new a(this, this.pda);
        this.pdc.setAdapter(this.pde);
        this.pdc.setOnItemClickListener(this.PY);
        this.pdg = findViewById(f.wallet_entrance_add_bankcard);
        this.pdg.setOnClickListener(this.eZF);
        this.pdh = findViewById(f.wallet_entrance_loan);
        this.pdh.setOnClickListener(this.eZF);
        this.pdi = findViewById(f.wallet_entrance_apply_credit);
        this.pdj = (CdnImageView) findViewById(f.wallet_entrance_apply_credit_icon_iv);
        this.pdk = (TextView) findViewById(f.wallet_entrance_applay_credit_text_tv);
        bNh();
        findViewById(f.bank_card_help).setOnClickListener(this.eZF);
        sy syVar = new sy();
        syVar.cdO.buF = "4";
        syVar.bJX = new 5(this, syVar);
        a.sFg.m(syVar);
    }

    private void bNh() {
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.plugin.wallet_core.model.f OU = com.tencent.mm.plugin.wallet_core.model.f.OU((String) com.tencent.mm.kernel.g.Ei().DT().get(aa.a.USERINFO_WALLET_BIND_CARD_MENU_STRING_SYNC, (Object) ""));
        if (!(OU == null || bi.oW(OU.pmy))) {
            if (!bi.oW(OU.pmz)) {
                this.pdj.setUrl(OU.pmz);
            }
            this.pdk.setText(OU.pmy);
            if (OU.pmu == 1) {
                this.pdi.setOnClickListener(new 6(this, OU));
                this.pdi.setVisibility(0);
                return;
            } else if (OU.pmu == 2) {
                this.pdi.setOnClickListener(new 7(this, OU));
                this.pdi.setVisibility(0);
                return;
            } else {
                x.w("MicroMsg.WalletBankcardManageUI", "unknown type: %d", Integer.valueOf(OU.pmu));
            }
        }
        this.pdi.setVisibility(8);
    }

    public a bNi() {
        return new a(this, this.pcZ);
    }

    public final void b(Bankcard bankcard) {
        com.tencent.mm.kernel.g.Ek();
        String str = (String) com.tencent.mm.kernel.g.Ei().DT().get(aa.a.USERINFO_WALLET_BANKCARD_DETAIL_URL_STRING_SYNC, (Object) "");
        if (bi.oW(str)) {
            x.e("MicroMsg.WalletBankcardManageUI", "jumpToH5BankDetail :: url is null");
            return;
        }
        x.i("MicroMsg.WalletBankcardManageUI", "jumpToH5BankDetail :: url is not null");
        Intent intent = new Intent();
        String format = String.format("bank_type=%s&card_tail=%s&bind_serial=%s", new Object[]{bankcard.field_bankcardType, bankcard.field_bankcardTail, bankcard.field_bindSerial});
        if (str.contains("?")) {
            str = str + "&" + format;
        } else {
            str = str + "?" + format;
        }
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("disable_bounce_scroll", true);
        d.b(this, "webview", ".ui.tools.WebViewUI", intent);
    }

    public void c(Bankcard bankcard) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_bankcard", bankcard);
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.bind.a.class, bundle, null);
    }

    private void aL() {
        if (this.pdb.bPr()) {
            this.pdf.setEnabled(false);
        } else {
            this.pdb.bPp();
            this.pdf.setEnabled(true);
        }
        if (this.pcZ == null || this.pcZ.size() <= 0) {
            this.CU.setVisibility(8);
        } else {
            this.CU.setVisibility(0);
        }
        if (this.pda == null || this.pda.size() <= 0) {
            this.pdc.setVisibility(8);
        } else {
            this.pdc.setVisibility(0);
        }
        if (this.pdl == null || this.pdl.field_is_show_entry != 1) {
            this.pdh.setVisibility(8);
        } else {
            boolean z;
            ((TextView) this.pdh.findViewById(f.wallet_entrance_loan_text)).setText(this.pdl.field_title);
            k kVar = this.pdl;
            TextView textView = (TextView) findViewById(f.wallet_load_red_point);
            int i = kVar.field_red_dot_index;
            com.tencent.mm.kernel.g.Ek();
            if (((Integer) com.tencent.mm.kernel.g.Ei().DT().get(aa.a.USERINFO_LOAN_ENTRANCE_RED_POINT_INT, Integer.valueOf(-1))).intValue() >= i || i <= 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                x.i("MicroMsg.WalletBankcardManageUI", "red point update");
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
            textView = (TextView) findViewById(f.wallet_entrance_loan_credits_tip);
            if (kVar.field_is_overdue == 1) {
                x.i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.is_overdue = true");
                textView.setText(i.wallet_bankcard_manager_ui_loan_overdue);
                textView.setTextColor(getResources().getColor(c.red));
            } else if (!bi.oW(kVar.field_tips)) {
                x.i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.tips not null");
                textView.setText(kVar.field_tips);
            } else if (bi.oW(kVar.field_available_otb)) {
                textView.setVisibility(8);
                this.pdh.setVisibility(0);
            } else {
                x.i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.available_otb not null");
                i = kVar.field_available_otb.indexOf(".");
                String str = kVar.field_available_otb;
                if (i > 0) {
                    str = str.substring(0, i);
                }
                textView.setText(getString(i.wallet_bankcard_manager_ui_loan_available_otb, new Object[]{str}));
            }
            textView.setVisibility(0);
            this.pdh.setVisibility(0);
        }
        this.pdd.P(this.pcZ);
        this.pdd.notifyDataSetChanged();
        this.pde.P(this.pda);
        this.pde.notifyDataSetChanged();
        this.pdf.setEnabled(true);
    }

    public void bNj() {
        final Bundle bundle = new Bundle();
        this.kZX.a(new 2(this, new Runnable() {
            public final void run() {
                bundle.putInt("key_bind_scene", 15);
                bundle.putBoolean("key_bind_show_change_card", true);
                com.tencent.mm.wallet_core.a.a(WalletBankcardManageUI.this, b.class, bundle, null);
            }
        }), new ae().bPo());
    }

    public final void bNk() {
        ux(0);
        this.pdb.f(this.pcZ, this.pda);
        aL();
        bNh();
    }

    public boolean d(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.WalletBankcardManageUI", "onSceneEnd");
        if (i != 0 || i2 != 0 || !(lVar instanceof y)) {
            return false;
        }
        this.pdl = o.bOW().prD;
        bNk();
        return true;
    }

    public final boolean bbU() {
        return false;
    }

    public void finish() {
        if (!getIntent().getBooleanExtra("intent_finish_self", false)) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            d.b(this, "mall", ".ui.MallIndexUI", intent);
        }
        super.finish();
    }
}
