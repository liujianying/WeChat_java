package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aw;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.balance.a.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.g;
import com.tencent.mm.plugin.wallet_core.ui.view.c;
import com.tencent.mm.plugin.wxpay.a$e;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.c.q;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.c.v;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;

@a(3)
public class WalletBalanceFetchUI extends WalletBaseUI implements WalletFormView.a {
    private String bOd = null;
    private final int eCE = com.tencent.mm.bp.a.fromDPToPix(ad.getContext(), aw.CTRL_BYTE);
    private Button eWk;
    private View hyK;
    private double myQ;
    private ArrayList<Bankcard> oZG;
    private Bankcard oZH;
    private String oZI;
    private WalletFormView oZJ;
    private LinearLayout oZK;
    private View oZL;
    private TextView oZM;
    private TextView oZN;
    private TextView oZO;
    private TextView oZP;
    private TextView oZQ;
    private int oZR = 0;
    private int oZS = 0;
    private int oZT = 0;
    private double oZU = 0.0d;
    private int oZV = -1;
    private int oZW = 0;
    private DecimalFormat oZX = new DecimalFormat("0.00");
    private boolean oZY = false;
    private boolean oZZ = false;
    private boolean paa = false;
    private boolean pab = false;
    private boolean pac = false;

    static /* synthetic */ void d(WalletBalanceFetchUI walletBalanceFetchUI) {
        walletBalanceFetchUI.myQ = bi.getDouble(walletBalanceFetchUI.oZJ.getText(), 0.0d);
        String str = "";
        if (walletBalanceFetchUI.oZH != null) {
            str = walletBalanceFetchUI.oZH.field_bankcardType;
        } else {
            g bOA = g.bOA();
            if (bOA.aKp()) {
                h.b(walletBalanceFetchUI, bOA.lMX, walletBalanceFetchUI.getString(i.app_tip), true);
                return;
            }
        }
        if (walletBalanceFetchUI.oZH != null && !bi.oW(walletBalanceFetchUI.oZH.field_forbidWord)) {
            s.makeText(walletBalanceFetchUI.mController.tml, walletBalanceFetchUI.oZH.field_forbidWord, 0).show();
        } else if (walletBalanceFetchUI.myQ <= 0.0d || !walletBalanceFetchUI.oZJ.ZF()) {
            s.makeText(walletBalanceFetchUI.mController.tml, i.wallet_balance_save_input_invalid, 0).show();
        } else {
            double d = walletBalanceFetchUI.myQ;
            p.bNp();
            if (d > p.bNq().paw.plV) {
                s.makeText(walletBalanceFetchUI.mController.tml, i.wallet_balance_fetch_input_balance_quota, 0).show();
                return;
            }
            d = walletBalanceFetchUI.myQ;
            p.bNp();
            if (d > p.bNq().paw.plX) {
                s.makeText(walletBalanceFetchUI.mController.tml, i.wallet_balance_fetch_input_day_quota, 0).show();
            } else {
                walletBalanceFetchUI.a(new b(walletBalanceFetchUI.myQ, "CNY", str, walletBalanceFetchUI.oZW), true, true);
            }
        }
    }

    static /* synthetic */ void e(WalletBalanceFetchUI walletBalanceFetchUI) {
        double d;
        if (!(walletBalanceFetchUI.oZH == null || walletBalanceFetchUI.oZR == 0 || ((walletBalanceFetchUI.oZR == 1 && walletBalanceFetchUI.oZH.field_fetch_charge_rate <= 0.0d) || (walletBalanceFetchUI.oZR == 1 && walletBalanceFetchUI.oZH.field_fetch_charge_rate > 0.0d && walletBalanceFetchUI.oZS == 0)))) {
            d = walletBalanceFetchUI.oZU;
            p.bNp();
            if (d < p.bNq().paw.plX) {
                if (walletBalanceFetchUI.oZH != null) {
                    p.bNp();
                    d = p.bNq().paw.plX - walletBalanceFetchUI.oZH.field_full_fetch_charge_fee;
                } else {
                    p.bNp();
                    d = p.bNq().paw.plX;
                }
                if (walletBalanceFetchUI.oZT != 1) {
                    x.i("MicroMsg.WalletBalanceFetchUI", "do fetch direct to pay!");
                    walletBalanceFetchUI.oZW = 1;
                    if (walletBalanceFetchUI.oZH == null || bi.oW(walletBalanceFetchUI.oZH.field_forbidWord)) {
                        String str = "";
                        if (walletBalanceFetchUI.oZH != null) {
                            str = walletBalanceFetchUI.oZH.field_bankcardType;
                        }
                        walletBalanceFetchUI.a(new b(walletBalanceFetchUI.myQ, "CNY", str, walletBalanceFetchUI.oZW), true, true);
                        return;
                    }
                    s.makeText(walletBalanceFetchUI.mController.tml, walletBalanceFetchUI.oZH.field_forbidWord, 0).show();
                }
                walletBalanceFetchUI.oZJ.setText(walletBalanceFetchUI.oZX.format(d));
                walletBalanceFetchUI.bMS();
                walletBalanceFetchUI.oZW = 1;
                x.i("MicroMsg.WalletBalanceFetchUI", "is_full_fetch_direct is 0!");
                return;
            }
        }
        p.bNp();
        d = p.bNq().paw.plX;
        if (walletBalanceFetchUI.oZT != 1) {
            walletBalanceFetchUI.oZJ.setText(walletBalanceFetchUI.oZX.format(d));
            walletBalanceFetchUI.bMS();
            walletBalanceFetchUI.oZW = 1;
            x.i("MicroMsg.WalletBalanceFetchUI", "is_full_fetch_direct is 0!");
            return;
        }
        x.i("MicroMsg.WalletBalanceFetchUI", "do fetch direct to pay!");
        walletBalanceFetchUI.oZW = 1;
        if (walletBalanceFetchUI.oZH == null || bi.oW(walletBalanceFetchUI.oZH.field_forbidWord)) {
            String str2 = "";
            if (walletBalanceFetchUI.oZH != null) {
                str2 = walletBalanceFetchUI.oZH.field_bankcardType;
            }
            walletBalanceFetchUI.a(new b(walletBalanceFetchUI.myQ, "CNY", str2, walletBalanceFetchUI.oZW), true, true);
            return;
        }
        s.makeText(walletBalanceFetchUI.mController.tml, walletBalanceFetchUI.oZH.field_forbidWord, 0).show();
    }

    static /* synthetic */ void g(WalletBalanceFetchUI walletBalanceFetchUI) {
        if (walletBalanceFetchUI.hyK != null) {
            int[] iArr = new int[2];
            walletBalanceFetchUI.eWk.getLocationInWindow(iArr);
            int fl = (com.tencent.mm.bp.a.fl(walletBalanceFetchUI) - r0) - com.tencent.mm.bp.a.fromDPToPix(walletBalanceFetchUI, 30);
            x.d("MicroMsg.WalletBalanceFetchUI", "scrollToFormEditPosAfterShowTenPay, editText locationY: %s, height: %s, diff: %s, hardcodeKeyboardHeight: %s", new Object[]{Integer.valueOf(iArr[1] + walletBalanceFetchUI.eWk.getHeight()), Integer.valueOf(com.tencent.mm.bp.a.fl(walletBalanceFetchUI)), Integer.valueOf(fl), Integer.valueOf(walletBalanceFetchUI.eCE)});
            if (fl > 0 && fl < walletBalanceFetchUI.eCE) {
                x.d("MicroMsg.WalletBalanceFetchUI", "scrollToFormEditPosAfterShowTenPay, scrollDistance: %s", new Object[]{Integer.valueOf(walletBalanceFetchUI.eCE - fl)});
                walletBalanceFetchUI.hyK.post(new 18(walletBalanceFetchUI, r0));
            }
        }
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.wallet_balance_fetch_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ad(getIntent());
        bra();
        this.oZI = getString(i.wallet_balance_save_bind_new_card_to_fetch);
        initView();
        aL();
        q.fu(4, 0);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    private void bra() {
        p.bNp();
        ag bNq = p.bNq();
        if (this.oZY) {
            int i;
            Bankcard bankcard;
            Bankcard bankcard2;
            x.i("MicroMsg.WalletBalanceFetchUI", "is from new bind bankcard");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (this.oZG != null && this.oZG.size() > 0) {
                arrayList.addAll(this.oZG);
            }
            this.oZG = bNq.bPF();
            if (this.oZG != null && this.oZG.size() > 0) {
                arrayList2.addAll(this.oZG);
            }
            if (arrayList.size() > 0 && arrayList2.size() > 0) {
                Collection arrayList3 = new ArrayList();
                for (i = 0; i < arrayList.size(); i++) {
                    bankcard = (Bankcard) arrayList.get(i);
                    for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                        bankcard2 = (Bankcard) arrayList2.get(i2);
                        if (!(bankcard == null || bankcard2 == null || !bankcard.field_bindSerial.equals(bankcard2.field_bindSerial))) {
                            arrayList3.add(bankcard2);
                        }
                    }
                }
                if (arrayList3.size() > 0) {
                    arrayList2.removeAll(arrayList3);
                }
                if (arrayList2.size() > 0) {
                    bankcard = (Bankcard) arrayList2.get(0);
                    if (bankcard != null) {
                        bankcard2 = bNq.a(this.oZG, null, false, true);
                    } else {
                        bankcard2 = bankcard;
                    }
                    i = 0;
                    while (this.oZG != null && i < this.oZG.size()) {
                        bankcard = (Bankcard) this.oZG.get(i);
                        if (bankcard2 == null && bankcard != null && bankcard2.field_bindSerial.equals(bankcard.field_bindSerial)) {
                            this.oZV = i;
                            break;
                        }
                        i++;
                    }
                    this.oZH = bankcard2;
                    this.oZY = false;
                }
            }
            bankcard = null;
            if (bankcard != null) {
                bankcard2 = bankcard;
            } else {
                bankcard2 = bNq.a(this.oZG, null, false, true);
            }
            i = 0;
            while (this.oZG != null) {
                bankcard = (Bankcard) this.oZG.get(i);
                if (bankcard2 == null) {
                }
                i++;
            }
            this.oZH = bankcard2;
            this.oZY = false;
        } else {
            this.oZG = bNq.bPF();
            this.oZH = bNq.a(this.oZG, null, false, true);
        }
        if (bNq.prE != null) {
            this.oZR = bNq.prE.oZR;
            this.oZS = bNq.prE.oZS;
            this.oZU = bNq.prE.oZU;
            this.oZT = bNq.prE.oZT;
        } else {
            x.e("MicroMsg.WalletBalanceFetchUI", "BalanceFetchInfo is null");
        }
        x.i("MicroMsg.WalletBalanceFetchUI", "is_show_charge:" + this.oZR + " is_cal_charge:" + this.oZS + " min_charge_fee:" + this.oZU + " is_full_fetch_direct:" + this.oZT);
    }

    protected final void initView() {
        setMMTitle(i.wallet_balance_fetch_title);
        this.hyK = findViewById(f.fetch_root_view);
        this.oZK = (LinearLayout) findViewById(f.balance_bankcard_layout);
        1 1 = new 1(this);
        this.oZL = findViewById(f.balance_bankcard_layout);
        this.oZL.setOnClickListener(1);
        this.oZK.setOnClickListener(1);
        this.oZJ = (WalletFormView) findViewById(f.balance_fee);
        d(this.oZJ, 2, false);
        com.tencent.mm.wallet_core.ui.formview.a.f(this.oZJ);
        this.oZJ.setOnInputValidChangeListener(this);
        this.eWk = (Button) findViewById(f.next_btn);
        this.eWk.setOnClickListener(new 11(this));
        this.eWk.setEnabled(false);
        this.oZM = (TextView) findViewById(f.wallet_balance_manager_banner);
        this.oZN = (TextView) findViewById(f.balance_fetch_max_tv);
        this.oZO = (TextView) findViewById(f.balance_fetch_arrive_time);
        this.oZP = (TextView) findViewById(f.fetch_desc_tips_tv);
        this.oZQ = (TextView) findViewById(f.fetch_all_tv);
        this.oZQ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                WalletBalanceFetchUI.e(WalletBalanceFetchUI.this);
            }
        });
        this.oZJ.a(new 13(this));
        this.kTx = new 14(this);
        final sy syVar = new sy();
        syVar.cdO.buF = "3";
        syVar.bJX = new Runnable() {
            public final void run() {
                if (bi.oW(syVar.cdP.cdQ)) {
                    x.i("MicroMsg.WalletBalanceFetchUI", "no bulletin data");
                } else {
                    e.a(WalletBalanceFetchUI.this.oZM, syVar.cdP.cdQ, syVar.cdP.content, syVar.cdP.url);
                }
            }
        };
        com.tencent.mm.sdk.b.a.sFg.m(syVar);
    }

    public void onResume() {
        bMT();
        super.onResume();
    }

    private void aL() {
        if (this.oZJ.getTitleTv() != null) {
            this.oZJ.getTitleTv().setText(String.format(getString(i.remittance_fee_tips), new Object[]{v.cDm()}));
        } else {
            x.i("MicroMsg.WalletBalanceFetchUI", "mTotalFeeEHV.getTitleTv() is null");
        }
        ImageView imageView = (ImageView) this.oZK.findViewById(f.bankcard_logo_iv);
        if (this.oZH != null) {
            String str = "";
            com.tencent.mm.plugin.wallet_core.model.e h = com.tencent.mm.plugin.wallet_core.d.b.h(this, this.oZH.field_bankcardType, this.oZH.bOr());
            if (h != null) {
                str = h.lCU;
            }
            imageView.setImageBitmap(null);
            if (this.oZH.bOs()) {
                imageView.setBackgroundResource(a$e.wallet_balance_manager_logo_small);
            } else {
                Bitmap a = y.a(new c(str));
                y.a(new 16(this, imageView));
                if (!(a == null || a == null)) {
                    imageView.setImageBitmap(com.tencent.mm.sdk.platformtools.c.a(a, getResources().getDimensionPixelOffset(d.wallet_offline_bank_logo_width), getResources().getDimensionPixelOffset(d.wallet_offline_bank_logo_width), true, false));
                }
            }
            ((TextView) this.oZK.findViewById(f.balance_bankcard_tv)).setText(getString(i.wallet_balance_save_bankcard_tips, new Object[]{this.oZH.field_bankName, this.oZH.field_bankcardTail}));
            ((TextView) this.oZK.findViewById(f.balance_bankcard_tv)).setVisibility(0);
            if (!bi.oW(this.oZH.field_fetchArriveTimeWording)) {
                ((TextView) this.oZK.findViewById(f.hint_1)).setText(this.oZH.field_fetchArriveTimeWording);
                ((TextView) this.oZK.findViewById(f.hint_1)).setVisibility(0);
                if (this.oZH.field_is_hightlight_pre_arrive_time_wording == 1) {
                    ((TextView) this.oZK.findViewById(f.hint_1)).setTextColor(Color.parseColor("#FA962A"));
                } else {
                    ((TextView) this.oZK.findViewById(f.hint_1)).setTextColor(Color.parseColor("#B2B2B2"));
                }
            }
            this.oZO.setText("");
            this.oZO.setVisibility(8);
        } else {
            imageView.setImageBitmap(null);
            ((TextView) this.oZK.findViewById(f.balance_bankcard_tv)).setText(this.oZI);
            ((TextView) this.oZK.findViewById(f.hint_1)).setText("");
            ((TextView) this.oZK.findViewById(f.hint_1)).setVisibility(8);
            ((ImageView) this.oZK.findViewById(f.bankcard_logo_iv)).setImageBitmap(null);
            this.oZO.setVisibility(8);
        }
        p.bNp();
        CharSequence charSequence = p.bNq().paw.plZ;
        if (bi.oW(charSequence)) {
            this.oZN.setVisibility(8);
        } else {
            this.oZN.setVisibility(0);
            this.oZN.setText(charSequence);
        }
        bMS();
        p.bNp();
        final com.tencent.mm.plugin.wallet_core.model.b bVar = p.bNq().prE;
        this.mController.removeAllOptionMenu();
        if (bVar != null && bVar.plE != null && bVar.plE.plG != null && bVar.plE.plG.length > 0) {
            addIconOptionMenu(0, com.tencent.mm.plugin.wxpay.a.h.actionbar_icon_dark_more, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(WalletBalanceFetchUI.this.mController.tml, 1, false);
                    dVar.ofp = new 1(this);
                    dVar.ofq = new 2(this);
                    dVar.bXO();
                    return true;
                }
            });
        }
    }

    private void bMS() {
        this.myQ = bi.getDouble(this.oZJ.getText(), 0.0d);
        if (this.myQ > 0.0d) {
            this.eWk.setEnabled(true);
        } else {
            this.eWk.setEnabled(false);
        }
        double d = this.myQ;
        p.bNp();
        if (!(d == p.bNq().paw.plX || this.oZH == null)) {
            d = this.myQ;
            p.bNp();
            if (d != p.bNq().paw.plX - this.oZH.field_full_fetch_charge_fee) {
                this.oZW = 0;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        double d2 = this.myQ;
        p.bNp();
        if (d2 > p.bNq().paw.plV) {
            this.oZQ.setVisibility(8);
            this.oZP.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.red));
            stringBuilder.append(getString(i.wallet_balance_input_amount_exceed_balance_tips));
        } else {
            String str;
            if (!(this.oZH == null || this.oZR == 0 || ((this.oZR == 1 && this.oZH.field_fetch_charge_rate <= 0.0d) || (this.oZR == 1 && this.oZH.field_fetch_charge_rate > 0.0d && this.oZS == 0)))) {
                d2 = this.oZU;
                p.bNp();
                if (d2 < p.bNq().paw.plX) {
                    if (this.oZR == 1 && this.oZH.field_fetch_charge_rate > 0.0d && this.oZS == 1 && (this.myQ <= 0.0d || !this.oZJ.ZF())) {
                        this.oZQ.setVisibility(0);
                        this.oZP.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.hint_text_color));
                        p.bNp();
                        str = p.bNq().paw.pma;
                        if (bi.oW(str)) {
                            x.i("MicroMsg.WalletBalanceFetchUI", "hy: wording's missing. use former routine");
                            p.bNp();
                            d2 = p.bNq().paw.plX;
                            stringBuilder.append(getString(i.wallet_balance_fetch_fetch_fee, new Object[]{e.e(d2, "CNY")}));
                        } else {
                            stringBuilder.append(str);
                        }
                        stringBuilder.append("，");
                    } else if (this.oZR == 1 && this.oZH.field_fetch_charge_rate > 0.0d && this.oZS == 1) {
                        this.oZQ.setVisibility(8);
                        this.oZP.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.hint_text_color));
                        d2 = this.myQ;
                        p.bNp();
                        if (d2 != p.bNq().paw.plX - this.oZH.field_full_fetch_charge_fee || this.oZH.field_full_fetch_charge_fee <= 0.0d) {
                            int i = i.wallet_balance_additional_deduction_fee_tips_1;
                            Object[] objArr = new Object[2];
                            double d3 = this.myQ;
                            p.bNp();
                            ag bNq = p.bNq();
                            objArr[0] = e.e(Math.max(((double) Math.round(((d3 - bNq.prE.mxI) * this.oZH.field_fetch_charge_rate) * 100.0d)) / 100.0d, bNq.prE.oZU), "CNY");
                            objArr[1] = (this.oZH.field_fetch_charge_rate * 100.0d) + "%";
                            stringBuilder.append(getString(i, objArr));
                        } else {
                            stringBuilder.append(getString(i.wallet_balance_additional_deduction_fee_tips_1, new Object[]{e.e(this.oZH.field_full_fetch_charge_fee, "CNY"), (this.oZH.field_fetch_charge_rate * 100.0d) + "%"}));
                        }
                    }
                }
            }
            this.oZQ.setVisibility(0);
            this.oZP.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.hint_text_color));
            p.bNp();
            str = p.bNq().paw.pma;
            if (bi.oW(str)) {
                x.i("MicroMsg.WalletBalanceFetchUI", "hy: wording's missing. use former routine");
                p.bNp();
                d2 = p.bNq().paw.plX;
                stringBuilder.append(getString(i.wallet_balance_fetch_fetch_fee, new Object[]{e.e(d2, "CNY")}));
            } else {
                stringBuilder.append(str);
            }
            stringBuilder.append("，");
        }
        this.oZP.setText(stringBuilder.toString());
    }

    private void a(b bVar) {
        if (bi.oW(this.bOd)) {
            x.w("MicroMsg.WalletBalanceFetchUI", "hy: req key is null. abandon");
            return;
        }
        PayInfo payInfo = new PayInfo();
        payInfo.bOd = this.bOd;
        payInfo.bVY = 21;
        this.sy.putParcelable("key_pay_info", payInfo);
        Orders orders = new Orders();
        orders.mBj = bVar.mxP - bVar.mxE;
        orders.poO = bVar.mxP - bVar.mxE;
        orders.ppf.add(new Commodity());
        orders.mxE = bVar.mxE;
        this.sy.putParcelable("key_orders", orders);
        this.sy.putParcelable("key_bankcard", this.oZH);
        if (cDK() == null) {
            com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.balance.b.class, this.sy, null);
            return;
        }
        cDL().m(new Object[]{this.sy});
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (i == 0 && i2 == 0) {
            boolean a;
            if (lVar instanceof b) {
                b bVar = (b) lVar;
                this.oZZ = false;
                if (!this.pac) {
                    this.paa = false;
                }
                this.pab = false;
                this.pac = false;
                if ("1".equals(bVar.ced)) {
                    x.i("MicroMsg.WalletBalanceFetchUI", "need realname verify");
                    Bundle bundle = new Bundle();
                    bundle.putString("realname_verify_process_jump_activity", ".balance.ui.WalletBalanceFetchUI");
                    bundle.putString("realname_verify_process_jump_plugin", "wallet");
                    String str2 = bVar.cee;
                    str2 = bVar.cef;
                    str2 = bVar.ceg;
                    bbR();
                    a = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, bundle, 0);
                } else if ("2".equals(bVar.ced)) {
                    x.i("MicroMsg.WalletBalanceFetchUI", "need upload credit");
                    a = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, bVar.cee, bVar.ceh, bVar.cef, bVar.ceg, bbR(), null);
                } else {
                    x.i("MicroMsg.WalletBalanceFetchUI", "realnameGuideFlag =  " + bVar.ced);
                    a = false;
                }
                if (!a) {
                    u.j(21, bVar.bQa, i2);
                    if (!b(bVar)) {
                        this.bOd = bVar.bQa;
                        a(bVar);
                    }
                }
            } else if (lVar instanceof com.tencent.mm.plugin.wallet_core.c.y) {
                bra();
                aL();
                if (this.oZR != 0) {
                    x.i("MicroMsg.WalletBalanceFetchUI", "showRemainFeeTip is_show_charge =" + this.oZR);
                } else {
                    com.tencent.mm.kernel.g.Ek();
                    a = ((Boolean) com.tencent.mm.kernel.g.Ei().DT().get(aa.a.sSX, Boolean.valueOf(false))).booleanValue();
                    p.bNp();
                    com.tencent.mm.plugin.wallet_core.model.b bVar2 = p.bNq().prE;
                    if (!(bVar2 == null || a)) {
                        double d = bVar2.mxI;
                        h.a((Context) this, getString(i.wallet_pay_fetch_tip_dialog_content, new Object[]{e.B(d)}), getString(i.wallet_pay_fetch_tip_dialog_title), getString(i.wallet_i_know_it), getString(i.wallet_pay_fetch_to_read_charge_rule), new 8(this), new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", WalletBalanceFetchUI.this.getString(i.wallet_fetch_charge_rule_doc));
                                intent.putExtra("showShare", false);
                                com.tencent.mm.bg.d.b(WalletBalanceFetchUI.this, "webview", ".ui.tools.WebViewUI", intent);
                                dialogInterface.dismiss();
                            }
                        }, com.tencent.mm.plugin.wxpay.a.c.wechat_green);
                        com.tencent.mm.kernel.g.Ek();
                        com.tencent.mm.kernel.g.Ei().DT().a(aa.a.sSX, Boolean.valueOf(true));
                    }
                }
            }
        } else if (lVar instanceof b) {
            u.j(21, "", i2);
            bMT();
        }
        return false;
    }

    public final void fE(boolean z) {
        this.oZJ.dX(null);
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i != 1) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 != -1 || intent == null) {
            x.i("MicroMsg.WalletBalanceFetchUI", "onActivityResult cancel select");
        } else {
            int intExtra = intent.getIntExtra("key_select_index", -1);
            int i3 = this.oZV;
            this.oZV = intExtra;
            x.i("MicroMsg.WalletBalanceFetchUI", "onActivityResult select bankcard index is " + intExtra);
            if (this.oZG == null || intExtra < 0 || intExtra >= this.oZG.size()) {
                if (this.oZG == null || intExtra < 0 || intExtra > this.oZG.size()) {
                    this.oZH = null;
                } else {
                    this.oZV = i3;
                }
                bMU();
            } else {
                this.oZH = (Bankcard) this.oZG.get(intExtra);
            }
            aL();
        }
    }

    private boolean b(b bVar) {
        boolean z;
        com.tencent.mm.plugin.wallet_core.model.b bVar2;
        if (this.oZZ) {
            z = false;
        } else if (bVar.oYz) {
            this.oZZ = true;
            h.a((Context) this, false, bVar.oYA, "", getString(i.app_ok), getString(i.app_cancel), new 2(this, bVar), new 3(this));
            z = true;
        } else {
            z = false;
        }
        if (!(z || this.paa)) {
            bVar2 = bVar.oYB;
            if (bVar2 == null || (TextUtils.isEmpty(bVar2.plA) && (bVar2.plB == null || bVar2.plB.size() <= 0))) {
                z = false;
            } else {
                this.paa = true;
                com.tencent.mm.plugin.wallet_core.ui.i.a(this, bVar2, false, new 4(this, bVar), new 5(this));
                z = true;
            }
        }
        if (z || this.pab) {
            return z;
        }
        bVar2 = bVar.oYC;
        if (bVar2 == null || (TextUtils.isEmpty(bVar2.plA) && (bVar2.plB == null || bVar2.plB.size() <= 0))) {
            return false;
        }
        this.pab = true;
        com.tencent.mm.plugin.wallet_core.ui.i.a(this, bVar2, true, new 6(this), new 7(this));
        return true;
    }

    private void bMT() {
        this.oZZ = false;
        this.paa = false;
        this.pab = false;
        this.pac = false;
    }

    protected void onNewIntent(Intent intent) {
        bMT();
        ad(intent);
    }

    private void ad(Intent intent) {
        boolean z = intent != null && intent.getBooleanExtra("intent_bind_end", false);
        this.oZY = z;
        if (this.oZY) {
            x.i("MicroMsg.WalletBalanceFetchUI", "onNewIntent() bind card success");
            PayInfo payInfo = (PayInfo) this.sy.get("key_pay_info");
            if (payInfo == null) {
                payInfo = new PayInfo();
                payInfo.bOd = this.bOd;
                payInfo.bVY = 21;
            }
            if (com.tencent.mm.plugin.wallet.b.a.bOi()) {
                a(new com.tencent.mm.plugin.wallet_core.c.v(payInfo.bOd), true, false);
            } else {
                a(new com.tencent.mm.plugin.wallet_core.c.y(payInfo.bOd, 4), true, false);
            }
        }
    }

    private void bMU() {
        g bOA = g.bOA();
        if (bOA.aKp()) {
            h.b(this, bOA.lMX, getString(i.app_tip), true);
            return;
        }
        Bundle bundle = new Bundle();
        Parcelable parcelable = (PayInfo) this.sy.get("key_pay_info");
        if (parcelable == null) {
            parcelable = new PayInfo();
            parcelable.bOd = this.bOd;
            parcelable.bVY = 21;
        }
        if (parcelable != null) {
            bundle.putParcelable("key_pay_info", parcelable);
        }
        bundle.putInt("key_scene", 21);
        bundle.putInt("key_bind_scene", 0);
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putInt("key_bind_scene", 0);
        bundle.putBoolean("key_is_bind_bankcard", true);
        bundle.putInt("from_bind_ui", com.tencent.mm.plugin.wallet.balance.a.oYx);
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.balance.a.class, bundle, null);
    }
}
