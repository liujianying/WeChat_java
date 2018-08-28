package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.aa.f.c;
import com.tencent.mm.aa.k;
import com.tencent.mm.aa.q;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.fo;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.plugin.remittance.a.b;
import com.tencent.mm.plugin.remittance.model.ab;
import com.tencent.mm.plugin.remittance.model.ac;
import com.tencent.mm.plugin.remittance.model.t;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.c.v;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

@com.tencent.mm.ui.base.a(19)
public abstract class RemittanceBaseUI extends WalletBaseUI implements c {
    public String cYO;
    protected String cZG;
    private final int eCE = com.tencent.mm.bp.a.fromDPToPix(ad.getContext(), 270);
    protected Button eWk;
    public int fdx;
    protected WalletFormView hXD;
    private int kTw;
    protected ScrollView klj;
    private double mxI;
    protected com.tencent.mm.plugin.wallet.a myP = null;
    public double myQ;
    protected String myR;
    protected String myS;
    protected String myT;
    public int myU;
    public String myV;
    protected ImageView myW;
    protected TextView myX;
    protected TextView myY;
    protected TextView myZ;
    protected TextView mza;
    protected TextView mzb;
    private TextView mzc;
    private TextView mzd;
    protected TextView mze;
    private LinearLayout mzf;
    private LinearLayout mzg;
    protected String mzh;
    private String mzi;
    private String mzj;
    protected String mzk;
    protected String mzl = null;
    protected String mzm = null;
    protected int mzn;
    private int mzo;
    protected String mzp;
    private Map<String, a> mzq = new HashMap();
    private String mzr;
    protected boolean mzs = false;
    private boolean mzt = false;
    private boolean mzu = false;
    private boolean mzv = false;
    private boolean mzw = false;
    private com.tencent.mm.sdk.b.c mzx = new 11(this);
    private com.tencent.mm.sdk.b.c<fp> mzy = new 14(this);

    private static class a {
        int amount;
        String bOe;
        String bXz;
        String hTI;
        String hVy;
        String mxN;
        String mxO;
        String mxS;
        long mzF;

        a(String str, String str2, String str3, String str4, int i, String str5, String str6, String str7, long j) {
            this.mxN = str;
            this.hTI = str2;
            this.hVy = str3;
            this.mxO = str4;
            this.amount = i;
            this.bXz = str5;
            this.bOe = str6;
            this.mxS = str7;
            this.mzF = j;
        }
    }

    public abstract void a(String str, String str2, String str3, fo foVar);

    public abstract void brm();

    public abstract void brp();

    public abstract void brs();

    protected int getLayoutId() {
        if (this.myU == 33 || this.myU == 32) {
            return g.remittance_new_ui_f2f;
        }
        return g.remittance_new_ui;
    }

    public void onCreate(Bundle bundle) {
        this.fdx = getIntent().getIntExtra("scene", 0);
        this.myU = getIntent().getIntExtra("pay_scene", 31);
        super.onCreate(bundle);
        this.myP = com.tencent.mm.plugin.wallet.a.ac(getIntent());
        this.myV = getIntent().getStringExtra("scan_remittance_id");
        this.myQ = getIntent().getDoubleExtra("fee", 0.0d);
        this.cYO = getIntent().getStringExtra("receiver_name");
        this.myS = getIntent().getStringExtra("receiver_nick_name");
        this.mzk = getIntent().getStringExtra("receiver_true_name");
        this.myR = getIntent().getStringExtra("mch_name");
        this.myT = getIntent().getStringExtra("mch_info");
        this.kTw = getIntent().getIntExtra("pay_channel", 0);
        this.mzp = bi.aG(getIntent().getStringExtra("rcvr_open_id"), "");
        x.i("MicroMsg.RemittanceBaseUI", "mUserName %s", new Object[]{this.cYO});
        com.tencent.mm.kernel.g.Ek();
        long longValue = ((Long) com.tencent.mm.kernel.g.Ei().DT().get(147457, Long.valueOf(0))).longValue();
        if ((16 & longValue) != 0) {
            this.mzo = 1;
        } else if ((longValue & 32) != 0) {
            this.mzo = 2;
        } else {
            this.mzo = 0;
        }
        brm();
        q.Kp().a(this);
        initView();
        this.mzy.cht();
    }

    public void onDestroy() {
        super.onDestroy();
        q.Kp().b(this);
        this.mzy.dead();
        this.mzx.dead();
    }

    public void brn() {
        t tVar = new t(this.cYO, this.myV);
        tVar.dox = "RemittanceProcess";
        a(tVar, true, true);
    }

    public void bro() {
    }

    protected final void initView() {
        if (this.myU == 33 || this.myU == 32) {
            setMMTitle(i.remittance_busi_pay);
        } else {
            setMMTitle(i.remittance_title);
        }
        setBackBtn(new 1(this));
        this.mKeyboard = (MyKeyboardWindow) findViewById(f.tenpay_num_keyboard);
        this.kMk = findViewById(f.tenpay_keyboard_layout);
        this.klj = (ScrollView) findViewById(f.root_view);
        this.myW = (ImageView) findViewById(f.remittance_receiver_avatar);
        this.myX = (TextView) findViewById(f.remittance_receiver_display_name);
        this.myY = (TextView) findViewById(f.remittance_receiver_display_name_tip);
        this.myY.setVisibility(8);
        this.mzg = (LinearLayout) findViewById(f.remittance_edit_layout);
        this.mzf = (LinearLayout) findViewById(f.remittance_ftf_desc_layout);
        this.mzd = (TextView) findViewById(f.remittance_fixed_amount_fee);
        this.mze = (TextView) findViewById(f.remittance_fixed_amount_fee_currency);
        this.mzc = (TextView) findViewById(f.remittance_fixed_amount_desc);
        brt();
        this.hXD = (WalletFormView) findViewById(f.money_ev);
        if (this.myU == 33) {
            this.mzd.setText(e.A(this.myQ));
            this.mze.setText(v.cDm());
            this.mzh = getIntent().getStringExtra("desc");
            if (bi.oW(this.mzh)) {
                this.mzc.setVisibility(8);
            } else {
                this.mzc.setText(j.a(this.mController.tml, this.mzh, this.mzc.getTextSize()));
                this.mzc.setVisibility(0);
            }
            this.mzf.setVisibility(0);
            this.mzg.setVisibility(8);
        } else {
            this.hXD.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    RemittanceBaseUI.this.Wq();
                }
            });
            this.hXD.getTitleTv().setText(String.format(getString(i.remittance_fee_tips), new Object[]{"¥"}));
            this.hXD.a(new TextWatcher() {
                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void afterTextChanged(Editable editable) {
                    if (editable.toString().startsWith(".")) {
                        editable.insert(0, "0");
                    }
                    String obj = editable.toString();
                    int indexOf = obj.indexOf(".");
                    int length = obj.length();
                    if (indexOf >= 0 && length - indexOf > 2) {
                        editable.delete(indexOf + 3, length);
                    }
                }
            });
            d(this.hXD, 2, false);
            findViewById(f.placeholder);
            findViewById(f.remittance_main_ui).setVisibility(0);
            this.mzf.setVisibility(8);
            this.mzg.setVisibility(0);
            this.kTx = new 2(this);
        }
        this.eWk = (Button) findViewById(f.next_btn);
        this.eWk.setOnClickListener(new 12(this));
        this.mza = (TextView) findViewById(f.remittance_desc);
        this.mzb = (TextView) findViewById(f.add_remittance_desc);
        if (this.fdx == 1 || this.fdx == 6) {
            this.mzb.setText(i.remittance_add_f2f_desc_link);
        } else {
            this.mzb.setText(i.remittance_add_desc_link);
        }
        if (!com.tencent.mm.model.q.GS()) {
            findViewById(f.remittance_desc_container).setOnClickListener(new 15(this));
        }
        if (this.fdx == 1) {
            com.tencent.mm.kernel.g.Ek();
            if (((String) com.tencent.mm.kernel.g.Ei().DT().get(327732, "0")).equals("0")) {
                h.a(this.mController.tml, i.remittance_first_ftf_pay_tips, i.remittance_first_ftf_pay_tips_title, new 16(this));
                com.tencent.mm.kernel.g.Ek();
                com.tencent.mm.kernel.g.Ei().DT().set(327732, "1");
                com.tencent.mm.kernel.g.Ek();
                com.tencent.mm.kernel.g.Ei().DT().lm(true);
            }
        }
        this.myZ = (TextView) findViewById(f.placeholder);
        brr();
        brs();
        brq();
    }

    private void brq() {
        if (!brv() || bi.oW(this.mzm) || this.mzo == 0 || this.mzn != 1) {
            this.mController.removeAllOptionMenu();
        } else {
            addIconOptionMenu(0, com.tencent.mm.plugin.wxpay.a.e.wallet_qanda_icon, new 17(this));
        }
    }

    private void brr() {
        if (bi.oW(this.mzl) || this.mzo == 0) {
            this.myZ.setText("");
            this.myZ.setVisibility(8);
            return;
        }
        int i;
        if (this.mzo == 1) {
            i = 2;
        } else {
            i = 24;
        }
        try {
            this.myZ.setText(String.format(this.mzl, new Object[]{Integer.valueOf(i)}));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.RemittanceBaseUI", e, "", new Object[0]);
            this.myZ.setText(getString(i.remittance_hardcode_tips, new Object[]{Integer.valueOf(i)}));
        }
        this.myZ.setVisibility(0);
    }

    protected final void brt() {
        int i;
        CharSequence dx = e.dx(e.gT(this.cYO), 10);
        if (!bi.oW(this.mzk)) {
            dx = getString(i.remittance_collect_block, new Object[]{dx, this.mzk});
        }
        String stringExtra;
        if (this.fdx == 1) {
            stringExtra = getIntent().getStringExtra("receiver_tips");
            this.myX.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.black));
            this.myY.setVisibility(0);
            if (bi.oW(this.cYO)) {
                dx = getString(i.remittance_collect_pay_wrords_nick_tip_withdout_username, new Object[]{this.mzk});
            } else {
                dx = getString(i.remittance_collect_pay_wrords_nick_tip, new Object[]{e.dx(e.gT(this.cYO), 10), this.mzk});
            }
            this.myY.setText(j.a(this, dx, this.myY.getTextSize()));
            dx = stringExtra;
        } else if (this.fdx == 6) {
            stringExtra = getIntent().getStringExtra("receiver_tips");
            if (bi.oW(stringExtra)) {
                dx = getString(i.remittance_collect_pay_wrords, new Object[]{dx});
            } else {
                dx = bi.q(stringExtra, new Object[]{dx});
            }
        }
        this.myX.setText(j.a(this, dx, this.myX.getTextSize()));
        this.myW.setImageResource(com.tencent.mm.plugin.wxpay.a.e.default_avatar);
        if (com.tencent.mm.kernel.g.Eg().Dx()) {
            k KH = q.KH();
            if (!(KH == null || bi.oW(this.cYO))) {
                com.tencent.mm.aa.j kc = KH.kc(this.cYO);
                if (kc == null || bi.oW(kc.Ky())) {
                    com.tencent.mm.model.am.a.dBr.a(this.cYO, "", new 18(this, bi.VF()));
                    i = 1;
                    if (i == 0) {
                        bru();
                    }
                }
            }
        }
        i = 0;
        if (i == 0) {
            bru();
        }
    }

    private void bru() {
        ah.A(new 19(this));
    }

    public boolean d(int i, int i2, String str, l lVar) {
        if (i == 0 && i2 == 0) {
            if (lVar instanceof com.tencent.mm.plugin.remittance.model.v) {
                com.tencent.mm.plugin.remittance.model.v vVar = (com.tencent.mm.plugin.remittance.model.v) lVar;
                u.j(this.myU, vVar.bQa, i2);
                this.mzj = vVar.mxD;
                if (!bi.oW(vVar.mxM)) {
                    this.mzk = vVar.mxM;
                }
                if (this.myU == 32 || this.myU == 33) {
                    this.mzr = vVar.hTI;
                } else {
                    this.mzr = vVar.bXz;
                }
                if (this.myP != null) {
                    this.myP.i(10000, new Object[]{Integer.valueOf(this.myU), this.cYO, Double.valueOf(vVar.mxP)});
                }
                if (!a(vVar)) {
                    a(vVar.bQa, this.cYO, this.mzk, vVar);
                }
                this.mzq.put(vVar.bQa, new a(vVar.mxN, vVar.hTI, vVar.hVy, vVar.mxO, vVar.amount, vVar.bXz, vVar.bOe, vVar.mxS, bi.getLong(vVar.mxQ, 0)));
            } else if (lVar instanceof com.tencent.mm.plugin.wallet_core.c.ad) {
                com.tencent.mm.plugin.wallet_core.c.ad adVar = (com.tencent.mm.plugin.wallet_core.c.ad) lVar;
                if (!bi.oW(adVar.pjH)) {
                    ((TextView) findViewById(f.remittance_tip)).setText(adVar.pjH);
                    View findViewById = findViewById(f.tip_container);
                    findViewById.setVisibility(0);
                    findViewById.setOnClickListener(new 3(this));
                }
                this.mzi = adVar.mzi;
                this.mxI = adVar.mxI;
                if (this.mxI == 0.0d) {
                    if (this.fdx == 1) {
                        com.tencent.mm.plugin.report.service.h.mEJ.h(12689, new Object[]{Integer.valueOf(14), Integer.valueOf(1)});
                    } else {
                        com.tencent.mm.plugin.report.service.h.mEJ.h(12689, new Object[]{Integer.valueOf(5), Integer.valueOf(1)});
                    }
                }
            } else if (lVar instanceof ae) {
                this.mzl = ((ae) lVar).pjJ;
                this.mzm = ((ae) lVar).pjN;
                this.mzn = ((ae) lVar).pjO;
                brr();
                brq();
            }
            return true;
        }
        if (lVar instanceof ae) {
            x.i("MicroMsg.RemittanceBaseUI", "net error, use hardcode wording");
            this.myZ.setText("");
            this.myZ.setVisibility(8);
        } else if (lVar instanceof com.tencent.mm.plugin.remittance.model.v) {
            u.j(this.myU, "", i2);
            if (b((com.tencent.mm.plugin.remittance.model.v) lVar)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(final com.tencent.mm.plugin.remittance.model.v vVar) {
        String str;
        boolean z = false;
        if (!this.mzt) {
            if (bi.oW(vVar.mxC)) {
                z = false;
            } else {
                this.mzt = true;
                h.a(this, vVar.mxC, getString(i.app_remind), getString(i.remittance_continue), getString(i.app_cancel), new 6(this, vVar), new 7(this));
                z = true;
            }
        }
        if (!(z || this.mzu)) {
            if (vVar.mxB > 0) {
                this.mzu = true;
                h.a(this, getString(i.remittance_remind_desc, new Object[]{Integer.valueOf(vVar.mxB)}), getString(i.app_remind), getString(i.remittance_continue), getString(i.remittance_open_order_history_action), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (!RemittanceBaseUI.this.a(vVar)) {
                            RemittanceBaseUI.this.a(vVar.bQa, RemittanceBaseUI.this.cYO, RemittanceBaseUI.this.mzk, vVar);
                        }
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.wallet_core.a.b(RemittanceBaseUI.this, "ShowOrdersInfoProcess", null);
                    }
                });
                z = true;
            } else {
                z = false;
            }
        }
        if (!(z || this.mzv)) {
            if (vVar.mxH) {
                this.mzv = true;
                int i = this.fdx;
                double d = vVar.mxL / 100.0d;
                str = vVar.mxJ;
                b.a(this, i, d, vVar.mxK / 100.0d, vVar.mxE / 100.0d, vVar.mxG, new 10(this, vVar));
                z = true;
            } else {
                z = false;
            }
        }
        if (!(z || this.mzw)) {
            z = b(vVar);
        }
        if (z || bi.oW(vVar.mxQ) || bi.oW(vVar.mxR)) {
            return z;
        }
        CharSequence string;
        str = e.dx(e.gT(this.cYO), 10);
        if (bi.oW(this.mzk)) {
            Object string2 = str;
        } else {
            string2 = getString(i.remittance_collect_block, new Object[]{str, this.mzk});
        }
        String str2 = vVar.bQa;
        CharSequence charSequence = vVar.mxR;
        String str3 = vVar.mxQ;
        View inflate = LayoutInflater.from(this).inflate(g.remittance_second_alert_ui, null);
        TextView textView = (TextView) inflate.findViewById(f.rsau_payee);
        TextView textView2 = (TextView) inflate.findViewById(f.rsau_money);
        ((TextView) inflate.findViewById(f.rsau_title)).setText(charSequence);
        textView.setText(j.a(this, string2, textView.getTextSize()));
        Double valueOf = Double.valueOf(bi.getDouble(str3, 0.0d));
        textView2.setText(String.format("%s%.2f", new Object[]{v.cDm(), Double.valueOf(valueOf.doubleValue() / 100.0d)}));
        com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(this);
        aVar.mF(false);
        aVar.Gq(i.remittance_second_alert_title);
        aVar.dR(inflate);
        aVar.Gt(i.remittance_continue);
        aVar.Gu(i.button_cancel);
        aVar.a(new 13(this, str2, vVar));
        aVar.anj().show();
        return true;
    }

    private boolean b(com.tencent.mm.plugin.remittance.model.v vVar) {
        if (vVar.cao == null || !vVar.cao.bOq()) {
            return false;
        }
        this.mzw = true;
        h.a(this, vVar.cao.bSc, "", vVar.cao.kRv, vVar.cao.kRu, new 4(this, vVar), new 5(this));
        return true;
    }

    protected final boolean brv() {
        return this.fdx == 0 || this.fdx == 2;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        boolean z = true;
        x.i("MicroMsg.RemittanceBaseUI", "reqcode=" + i + ", resultCode=" + i2 + ", username=" + this.cYO);
        switch (i) {
            case 1:
                if (i2 != -1) {
                    z = false;
                }
                a(z, intent);
                break;
            case 2:
                if (i2 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("Select_Conv_User");
                    if (!bi.oW(stringExtra)) {
                        this.cYO = stringExtra;
                        brt();
                        break;
                    }
                    finish();
                    break;
                }
                finish();
                break;
                break;
            case 5:
                if (i2 != -1) {
                    z = false;
                }
                a(z, intent);
                break;
        }
        super.onActivityResult(i, i2, intent);
    }

    private void a(boolean z, Intent intent) {
        if (z) {
            if (this.mzs) {
                com.tencent.mm.plugin.report.service.h.mEJ.h(15386, new Object[]{Integer.valueOf(3), Integer.valueOf(1)});
            }
            String stringExtra = intent.getStringExtra("key_trans_id");
            if (bi.oW(this.mzr)) {
                this.mzr = stringExtra;
            }
            if (!(this.myU == 33 || this.myU == 32)) {
                String str = this.cYO;
                if (!bi.oW(str)) {
                    stringExtra = ac.brg();
                    x.d("Micromsg.RemittanceLogic", "cur friendsListStr=" + stringExtra);
                    StringBuilder stringBuilder = new StringBuilder();
                    if (!bi.oW(stringExtra)) {
                        String[] split = stringExtra.split(",");
                        if (split != null) {
                            int i = 0;
                            for (int i2 = 0; i2 < split.length; i2++) {
                                if (!str.equals(split[i2])) {
                                    stringBuilder.append(split[i2]);
                                    stringBuilder.append(",");
                                    i++;
                                    if (i >= 4) {
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    stringBuilder.insert(0, ",");
                    stringBuilder.insert(0, str);
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                    x.d("Micromsg.RemittanceLogic", "new friendsListStr=" + stringBuilder.toString());
                    com.tencent.mm.kernel.g.Ek();
                    com.tencent.mm.kernel.g.Ei().DT().set(327733, stringBuilder.toString());
                    com.tencent.mm.kernel.g.Ek();
                    com.tencent.mm.kernel.g.Ei().DT().lm(true);
                }
            }
            if (this.mxI == 0.0d) {
                if (this.fdx == 1) {
                    com.tencent.mm.plugin.report.service.h.mEJ.h(12689, new Object[]{Integer.valueOf(17), Integer.valueOf(1)});
                } else {
                    com.tencent.mm.plugin.report.service.h.mEJ.h(12689, new Object[]{Integer.valueOf(8), Integer.valueOf(1)});
                }
            }
            finish();
        } else if (this.fdx == 1) {
            com.tencent.mm.plugin.report.service.h.mEJ.h(12689, new Object[]{Integer.valueOf(16), Integer.valueOf(1)});
        } else {
            com.tencent.mm.plugin.report.service.h.mEJ.h(12689, new Object[]{Integer.valueOf(7), Integer.valueOf(1)});
        }
    }

    protected final void a(String str, String str2, String str3, com.tencent.mm.plugin.remittance.model.v vVar) {
        boolean z;
        int i;
        if (this.myU == 31) {
            Object obj = this.mzj;
            if (TextUtils.isEmpty(obj)) {
                x.e("MicroMsg.RemittanceBaseUI", "msgxml is null");
            } else {
                String decode = URLDecoder.decode(obj);
                x.i("MicroMsg.RemittanceBaseUI", "helios:" + decode);
                String str4 = (String) bl.z(decode, "msg").get(".msg.appmsg.wcpayinfo.transferid");
                if (TextUtils.isEmpty(str4)) {
                    x.e("MicroMsg.RemittanceBaseUI", "paymsgid count't be null in appmsg");
                } else {
                    ab bqT = b.bqQ().bqT();
                    if (bi.oW(str4) || bi.oW(decode)) {
                        x.e(ab.TAG, "saveMsgContent param error");
                    } else {
                        bqT.myF.put(str4, decode);
                    }
                }
            }
        }
        PayInfo payInfo = new PayInfo();
        payInfo.bOd = str;
        payInfo.bVY = this.myU;
        if (this.kTw > 0) {
            payInfo.bVU = this.kTw;
        }
        if (this.fdx == 2 || this.fdx == 5) {
            z = true;
        } else {
            z = false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("extinfo_key_1", str2);
        bundle.putString("extinfo_key_2", getIntent().getStringExtra("receiver_true_name"));
        bundle.putString("extinfo_key_3", this.mzh);
        bundle.putBoolean("extinfo_key_4", z);
        bundle.putString("extinfo_key_5", getIntent().getStringExtra("receiver_tips"));
        bundle.putString("extinfo_key_6", getIntent().getStringExtra("payer_desc"));
        bundle.putString("extinfo_key_7", this.cZG);
        bundle.putString("extinfo_key_8", getIntent().getStringExtra("rcvr_new_desc"));
        bundle.putString("extinfo_key_16", this.mzr);
        if (vVar != null) {
            bundle.putString("extinfo_key_19", vVar.mxZ);
        }
        if (this.fdx != 1 || vVar == null) {
            i = 0;
        } else {
            bundle.putString("extinfo_key_11", vVar.mxN);
            bundle.putInt("extinfo_key_12", vVar.mxT);
            bundle.putString("extinfo_key_13", vVar.mxU);
            bundle.putString("extinfo_key_14", vVar.mxV);
            bundle.putString("extinfo_key_17", vVar.mxX);
            bundle.putString("extinfo_key_18", vVar.mxY);
            i = vVar.mxW;
        }
        if (vVar != null) {
            bundle.putInt("extinfo_key_15", vVar.amount);
        }
        payInfo.qUL = bundle;
        Intent intent = new Intent();
        x.i("MicroMsg.RemittanceBaseUI", "dynamic code flag: %s", new Object[]{Integer.valueOf(i)});
        if (i == 1) {
            intent.putExtra("key_pay_info", payInfo);
            intent.putExtra("key_rcvr_open_id", this.mzp);
            intent.putExtra("key_mch_info", this.myT);
            intent.putExtra("from_patch_ui", true);
            intent.putExtra("get_dynamic_code_sign", vVar.mxX);
            intent.putExtra("get_dynamic_code_extend", vVar.mxY);
            intent.putExtra("dynamic_code_spam_wording", vVar.mya);
            intent.putExtra("show_paying_wording", vVar.mxZ);
            intent.putExtra("key_transfer_qrcode_id", this.myV);
            com.tencent.mm.plugin.report.service.h.mEJ.h(15386, new Object[]{Integer.valueOf(2), Integer.valueOf(1)});
            this.mzx.cht();
            d.b(this, "wallet_payu", ".create.ui.WalletPayUVerifyCodeUI", intent, 5);
            return;
        }
        com.tencent.mm.plugin.wallet.a.a(this.myP, intent);
        if (vVar.mxl == null || vVar.mxl.bNX.bOb == null) {
            com.tencent.mm.pluginsdk.wallet.h.a(this, false, "", payInfo, str3, intent, 1);
            return;
        }
        com.tencent.mm.pluginsdk.wallet.h.a(vVar.mxl.bNX.bOb, false, "", payInfo, str3, intent, vVar.mxl.bNX.bNZ);
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected void brw() {
        Intent intent = new Intent();
        intent.putExtra("recent_remittance_contact_list", ac.brg());
        intent.setClass(this.mController.tml, SelectRemittanceContactUI.class);
        startActivityForResult(intent, 2);
    }

    public void jX(String str) {
        x.i("MicroMsg.RemittanceBaseUI", "onGet");
        if (bi.oV(str).length() <= 0) {
            x.e("MicroMsg.RemittanceBaseUI", "notifyChanged: user = " + str);
        } else if (str.equals(this.cYO)) {
            bru();
        }
    }
}
