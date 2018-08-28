package com.tencent.mm.plugin.recharge.ui;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.recharge.model.b;
import com.tencent.mm.plugin.recharge.model.f;
import com.tencent.mm.plugin.recharge.ui.form.InstantAutoCompleteTextView;
import com.tencent.mm.plugin.recharge.ui.form.MallFormView;
import com.tencent.mm.plugin.recharge.ui.form.c$b;
import com.tencent.mm.plugin.recharge.ui.form.c$b.1;
import com.tencent.mm.plugin.recharge.ui.form.c$b.2;
import com.tencent.mm.plugin.recharge.ui.form.c$b.3;
import com.tencent.mm.plugin.recharge.ui.form.c$b.4;
import com.tencent.mm.plugin.recharge.ui.form.c$b.5;
import com.tencent.mm.plugin.recharge.ui.form.d.a;
import com.tencent.mm.plugin.wallet.a.d;
import com.tencent.mm.plugin.wallet.a.m;
import com.tencent.mm.plugin.wallet.a.n;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.y;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PhoneRechargeUI extends MMActivity implements e, a {
    private String Yy = "";
    private String desc = "";
    protected Dialog eXG = null;
    private int errCode = 0;
    private boolean lSF = false;
    private c lSI = new 14(this);
    private String mAppId = "";
    private ArrayList<n> moR = null;
    private ArrayList<n> moS = null;
    private d moT = null;
    private d moU = null;
    private d moV = null;
    private d moW = null;
    private d moX = null;
    private View mpB = null;
    private ImageView mpC = null;
    private TextView mpD = null;
    private MallFormView mpE = null;
    private TextView mpF = null;
    private TextView mpG = null;
    private GridView mpH = null;
    private GridView mpI = null;
    private TextView mpJ = null;
    private TextView mpK = null;
    private TextView mpL = null;
    private TextView mpM = null;
    private TextView mpN = null;
    private TextView mpO = null;
    private b mpP = null;
    private b mpQ = null;
    private MallFunction mpR = null;
    private String mpS = "";
    private int mpT;
    private String mpU = "";
    private String mpV = "";
    private c$b mpW = null;
    private m mpX = null;
    private boolean mpY = false;
    private List<String[]> mpZ;

    static /* synthetic */ void Kp(String str) {
        x.i("MicroMsg.PhoneRechargeUI", "do scene: %s", new Object[]{str});
        g.DF().a(new f(str), 0);
    }

    static /* synthetic */ boolean a(PhoneRechargeUI phoneRechargeUI, String str, String str2) {
        if (bi.oW(str) || bi.oW(str2)) {
            return false;
        }
        CharSequence charSequence = "";
        CharSequence charSequence2 = "";
        CharSequence charSequence3 = "";
        if (!(phoneRechargeUI.mpW == null || phoneRechargeUI.mpW.mph == null || bi.oW(phoneRechargeUI.mpW.mph.name))) {
            com.tencent.mm.plugin.recharge.model.a aVar = phoneRechargeUI.mpW.mph;
            charSequence = aVar.mov;
            charSequence2 = aVar.name;
            charSequence3 = aVar.bJt == 3 ? "1" : "0";
        }
        x.i("MicroMsg.PhoneRechargeUI", "weappID: %s, weappPath: %s", new Object[]{str, str2.replace("{phone}", charSequence).replace("{remark}", charSequence2).replace("{isbind}", charSequence3)});
        qu quVar = new qu();
        quVar.cbq.userName = str;
        quVar.cbq.cbs = bi.aG(r0, "");
        quVar.cbq.scene = 1098;
        quVar.cbq.cbt = 0;
        com.tencent.mm.sdk.b.a.sFg.m(quVar);
        return true;
    }

    static /* synthetic */ void d(PhoneRechargeUI phoneRechargeUI, String str) {
        phoneRechargeUI.c(new com.tencent.mm.plugin.recharge.model.g(phoneRechargeUI.mAppId, phoneRechargeUI.mpR.moy, str, "mobile=" + b.pK(phoneRechargeUI.mpE.getText()) + "&markup=" + (phoneRechargeUI.mpW.mph != null ? phoneRechargeUI.mpW.mph.name : "")), true);
    }

    static /* synthetic */ void g(PhoneRechargeUI phoneRechargeUI) {
        if (phoneRechargeUI.mpX != null) {
            String str = (String) g.Ei().DT().get(aa.a.sPE, "");
            g.Ei().DT().a(aa.a.sPE, bi.oW(str) ? String.valueOf(phoneRechargeUI.mpX.id) : str + ";" + phoneRechargeUI.mpX.id);
            g.Ei().DT().lm(true);
        }
    }

    private void bqb() {
        this.mAppId = "";
        bqc();
        this.errCode = 0;
        this.Yy = "";
        this.desc = "";
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.DF().a(1571, this);
        g.DF().a(498, this);
        this.mpR = (MallFunction) getIntent().getParcelableExtra("key_func_info");
        if (this.mpR == null) {
            x.e("MicroMsg.PhoneRechargeUI", "hy: function info is null");
            s.makeText(this, "function info is null", 1).show();
            finish();
        }
        bqc();
        setMMTitle(this.mpR.cbR);
        setBackBtn(new 1(this));
        this.moX = new d();
        this.moX.name = getString(i.wallet_recharge_hardcode_head_name);
        this.moX.url = getString(i.wallet_recharge_hardcode_head_url);
        this.mpB = findViewById(com.tencent.mm.plugin.wxpay.a.f.phone_recharge_banner_rl);
        this.mpC = (ImageView) findViewById(com.tencent.mm.plugin.wxpay.a.f.news_close);
        this.mpD = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.news_wording);
        this.mpE = (MallFormView) findViewById(com.tencent.mm.plugin.wxpay.a.f.recharge_content_input_view);
        com.tencent.mm.plugin.recharge.ui.form.c.b(this.mpE);
        this.mpW = new c$b(this.mpE);
        c$b c_b = this.mpW;
        x.d(com.tencent.mm.plugin.recharge.ui.form.c.bP(), "hy: setMobileEditTv");
        MallFormView mallFormView = c_b.mqP;
        1 1 = new 1(c_b);
        if (mallFormView.mqV != null) {
            mallFormView.mqV.addTextChangedListener(1);
        }
        InstantAutoCompleteTextView instantAutoCompleteTextView = (InstantAutoCompleteTextView) c_b.mqP.getContentEditText();
        c_b.mpg = com.tencent.mm.pluginsdk.a.cz(c_b.mqP.getContext());
        c_b.mqQ = new com.tencent.mm.plugin.recharge.ui.form.d(c_b.mqP, c_b.mpg);
        c_b.mqQ.mrD = new 2(c_b);
        c_b.mqQ.mrE = this;
        c_b.hn(true);
        instantAutoCompleteTextView.setShowAlways(true);
        instantAutoCompleteTextView.setAdapter(c_b.mqQ);
        instantAutoCompleteTextView.setOnItemClickListener(new 3(c_b, instantAutoCompleteTextView));
        c_b.mqP.setOnFocusChangeListener(new 4(c_b, instantAutoCompleteTextView));
        instantAutoCompleteTextView.setOnClickListener(new 5(c_b, instantAutoCompleteTextView));
        this.mpH = (GridView) findViewById(com.tencent.mm.plugin.wxpay.a.f.recharge_phone_grid);
        this.mpJ = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.recharge_remind);
        this.mpK = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.recharge_weSim);
        this.mpL = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.recharge_buy_card);
        this.mpM = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.recharge_hall);
        this.mpF = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.recharge_product_1_title);
        this.mpG = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.recharge_product_2_title);
        this.mpI = (GridView) findViewById(com.tencent.mm.plugin.wxpay.a.f.recharge_dataflow_grid);
        this.mpN = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.recharge_product_1_lack_alert);
        this.mpO = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.recharge_product_2_lack_alert);
        this.mpE.setOnInputValidChangeListener(new 12(this));
        this.mpE.getInfoIv().setOnClickListener(new 15(this));
        this.mpP = new b();
        this.mpP.mpw = new 16(this);
        this.mpQ = new b();
        this.mpQ.mpw = new 17(this);
        this.mpH.setAdapter(this.mpP);
        this.mpI.setAdapter(this.mpQ);
        this.mpC.setOnClickListener(new 18(this));
        this.mpD.setOnClickListener(new 19(this));
        this.mpE.bql();
        int fk = (com.tencent.mm.bp.a.fk(this) / 4) - 20;
        x.i("MicroMsg.PhoneRechargeUI", "max width: %s", new Object[]{Integer.valueOf(fk)});
        this.mpJ.setMaxWidth(fk);
        this.mpK.setMaxWidth(fk);
        this.mpL.setMaxWidth(fk);
        this.mpM.setMaxWidth(fk);
        this.mpT = getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.normal_text_color);
        if (!(this.mpW.mph == null || bi.oW(this.mpW.mph.name))) {
            this.desc = this.mpW.mph.name;
        }
        this.mpE.getContentEditText().setHintTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.recharge_no_phone_hint_text_color));
        if (bi.oW(this.mpE.getText())) {
            c(new f(""), false);
        } else {
            c(new f(this.mpE.getText()), false);
        }
    }

    private String Kn(String str) {
        String str2;
        try {
            str2 = "";
            if (!(this.mpW == null || this.mpW.mph == null || bi.oW(this.mpW.mph.name))) {
                str2 = this.mpW.mph.name;
            }
            if (str2.equals(getString(i.wallet_recharge_me))) {
                str2 = "WeChatAccountBindNumber";
            }
            CharSequence text = this.mpE.getText();
            CharSequence encode = URLEncoder.encode(URLEncoder.encode(str2, "utf-8"), "utf-8");
            if (str.startsWith("http://") || str.startsWith("https://")) {
                x.i("MicroMsg.PhoneRechargeUI", "new url");
                if (str.indexOf("%7Bphone%7D") > 0) {
                    str = str.replace("%7Bphone%7D", text);
                } else {
                    str = str.replace("{phone}", text);
                }
                if (str.indexOf("%7Bremark%7D") > 0) {
                    return str.replace("%7Bremark%7D", encode);
                }
                return str.replace("{remark}", encode);
            }
            x.i("MicroMsg.PhoneRechargeUI", "old url");
            return URLDecoder.decode(str, "utf-8") + String.format("?phone=%s&remark=%s", new Object[]{text, encode});
        } catch (Throwable e) {
            str2 = str;
            x.printErrStackTrace("MicroMsg.PhoneRechargeUI", e, "", new Object[0]);
            return str2;
        }
    }

    private void m(l lVar) {
        if (this.eXG != null && this.eXG.isShowing() && lVar.getType() != 497) {
            this.eXG.dismiss();
            this.eXG = null;
        }
    }

    private void c(l lVar, boolean z) {
        if (this.eXG == null || !(this.eXG == null || this.eXG.isShowing())) {
            if (z) {
                this.eXG = com.tencent.mm.wallet_core.ui.g.a(this.mController.tml, true, new 21(this, lVar));
            } else {
                this.eXG = com.tencent.mm.wallet_core.ui.g.b(this.mController.tml, true, new 2(this, lVar));
            }
        }
        g.DF().a(lVar, 0);
    }

    protected void onResume() {
        super.onResume();
        A(false, true);
    }

    protected void onDestroy() {
        super.onDestroy();
        g.DF().b(1571, this);
        g.DF().b(498, this);
        com.tencent.mm.sdk.b.a.sFg.c(this.lSI);
    }

    private void A(boolean z, boolean z2) {
        boolean z3;
        TextView textView;
        CharSequence string;
        MallFunction mallFunction;
        if (this.mpX != null) {
            if (this.mpX != null) {
                String str = (String) g.Ei().DT().get(aa.a.sPE, "");
                if (bi.oW(str)) {
                    x.i("MicroMsg.PhoneRechargeUI", "hy: no banner before, show");
                    z3 = false;
                } else {
                    String[] split = str.split(";");
                    if (split != null) {
                        for (String str2 : split) {
                            if (str2 != null && str2.equals(String.valueOf(this.mpX.id))) {
                                x.i("MicroMsg.PhoneRechargeUI", "hy: found closed. ");
                                z3 = true;
                                break;
                            }
                        }
                    }
                    x.i("MicroMsg.PhoneRechargeUI", "hy: not found closed banner.");
                    z3 = false;
                }
            } else {
                x.e("MicroMsg.PhoneRechargeUI", "hy: no banner");
                z3 = true;
            }
            if (!z3) {
                this.mpB.setVisibility(0);
                this.mpD.setText(this.mpX.name);
                x.d("MicroMsg.PhoneRechargeUI", "hy: Show banner!");
                com.tencent.mm.protocal.f.eA(6, 0);
                this.mpP.mpv = this.moR;
                this.mpP.notifyDataSetChanged();
                this.mpQ.mpv = this.moS;
                this.mpQ.notifyDataSetChanged();
                if (z) {
                    this.mpN.setVisibility(8);
                } else {
                    Iterator it = this.moR.iterator();
                    while (it.hasNext()) {
                        if (((n) it.next()).status != 0) {
                            z3 = false;
                            break;
                        }
                    }
                    z3 = true;
                    if (z3) {
                        this.mpN.setVisibility(0);
                    } else {
                        this.mpN.setVisibility(8);
                    }
                    it = this.moS.iterator();
                    while (it.hasNext()) {
                        if (((n) it.next()).status != 0) {
                            z3 = false;
                            break;
                        }
                    }
                    z3 = true;
                    if (z3) {
                        this.mpO.setVisibility(0);
                        if (z2) {
                            addTextOptionMenu(0, this.moX.name, new 3(this));
                        }
                        textView = this.mpF;
                        string = (this.moR != null || this.moR.size() <= 0 || bi.oW(((n) this.moR.get(0)).peu)) ? getString(i.wallet_recharge_fee_title) : ((n) this.moR.get(0)).peu;
                        textView.setText(string);
                        textView = this.mpG;
                        string = (this.moS != null || this.moS.size() <= 0 || bi.oW(((n) this.moS.get(0)).peu)) ? getString(i.wallet_recharge_flow_title) : ((n) this.moS.get(0)).peu;
                        textView.setText(string);
                        if (this.moW != null || bi.oW(this.moW.name)) {
                            this.mpK.setVisibility(8);
                        } else {
                            this.mpK.setVisibility(0);
                            this.mpK.setText(this.moW.name);
                            this.mpK.setOnClickListener(new 4(this));
                        }
                        if (this.moT != null || bi.oW(this.moT.name) || bi.oW(this.moT.url)) {
                            this.mpJ.setVisibility(8);
                        } else {
                            this.mpJ.setVisibility(0);
                            this.mpJ.setText(this.moT.name);
                            this.mpJ.setOnClickListener(new OnClickListener() {
                                public final void onClick(View view) {
                                    if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.this.moT.pdR, PhoneRechargeUI.this.moT.dzE)) {
                                        x.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[]{PhoneRechargeUI.this.Kn(PhoneRechargeUI.this.moT.url)});
                                        PhoneRechargeUI.c(PhoneRechargeUI.this, r0);
                                    }
                                }
                            });
                        }
                        if (this.moU != null || bi.oW(this.moU.name) || bi.oW(this.moU.url)) {
                            this.mpL.setVisibility(8);
                        } else {
                            this.mpL.setVisibility(0);
                            this.mpL.setText(this.moU.name);
                            this.mpL.setOnClickListener(new OnClickListener() {
                                public final void onClick(View view) {
                                    if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.this.moU.pdR, PhoneRechargeUI.this.moU.dzE)) {
                                        x.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[]{PhoneRechargeUI.this.Kn(PhoneRechargeUI.this.moU.url)});
                                        PhoneRechargeUI.c(PhoneRechargeUI.this, r0);
                                    }
                                }
                            });
                        }
                        if (this.moV != null || bi.oW(this.moV.name) || bi.oW(this.moV.url)) {
                            this.mpM.setVisibility(8);
                        } else {
                            this.mpM.setVisibility(0);
                            this.mpM.setText(this.moV.name);
                            this.mpM.setOnClickListener(new OnClickListener() {
                                public final void onClick(View view) {
                                    if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.this.moV.pdR, PhoneRechargeUI.this.moV.dzE)) {
                                        x.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[]{PhoneRechargeUI.this.Kn(PhoneRechargeUI.this.moV.url)});
                                        PhoneRechargeUI.c(PhoneRechargeUI.this, r0);
                                    }
                                }
                            });
                        }
                        mallFunction = this.mpR;
                        if (mallFunction.prU == null && mallFunction.prU.ppS == 1 && !bi.oW(mallFunction.prU.psk)) {
                            g.Ek();
                            z3 = !((Boolean) g.Ei().DT().get(aa.a.sTt, Boolean.valueOf(false))).booleanValue();
                        } else {
                            z3 = false;
                        }
                        if (!z3) {
                            g.Ek();
                            g.Ei().DT().a(aa.a.sTt, Boolean.valueOf(true));
                            x.d("MicroMsg.PhoneRechargeUI", this.mpR.prU.toString());
                            h.a(this.mController.tml, getString(i.wallet_recharge_unicom_message_title), y.gq(this).inflate(com.tencent.mm.plugin.wxpay.a.g.recharge_remind_dialog, null), getString(i.wallet_recharge_unicom_message_yes), getString(i.wallet_recharge_unicom_message_no), new 8(this, this.mpR.prU.psk), new 9(this));
                        }
                    }
                }
                this.mpO.setVisibility(8);
                if (z2) {
                    addTextOptionMenu(0, this.moX.name, new 3(this));
                }
                textView = this.mpF;
                if (this.moR != null) {
                }
                textView.setText(string);
                textView = this.mpG;
                if (this.moS != null) {
                }
                textView.setText(string);
                if (this.moW != null) {
                }
                this.mpK.setVisibility(8);
                if (this.moT != null) {
                }
                this.mpJ.setVisibility(8);
                if (this.moU != null) {
                }
                this.mpL.setVisibility(8);
                if (this.moV != null) {
                }
                this.mpM.setVisibility(8);
                mallFunction = this.mpR;
                if (mallFunction.prU == null) {
                }
                z3 = false;
                if (!z3) {
                    g.Ek();
                    g.Ei().DT().a(aa.a.sTt, Boolean.valueOf(true));
                    x.d("MicroMsg.PhoneRechargeUI", this.mpR.prU.toString());
                    h.a(this.mController.tml, getString(i.wallet_recharge_unicom_message_title), y.gq(this).inflate(com.tencent.mm.plugin.wxpay.a.g.recharge_remind_dialog, null), getString(i.wallet_recharge_unicom_message_yes), getString(i.wallet_recharge_unicom_message_no), new 8(this, this.mpR.prU.psk), new 9(this));
                }
            }
        }
        this.mpB.setVisibility(8);
        x.d("MicroMsg.PhoneRechargeUI", "hy: dismiss banner!");
        this.mpP.mpv = this.moR;
        this.mpP.notifyDataSetChanged();
        this.mpQ.mpv = this.moS;
        this.mpQ.notifyDataSetChanged();
        if (z) {
            Iterator it2 = this.moR.iterator();
            while (it2.hasNext()) {
                if (((n) it2.next()).status != 0) {
                    z3 = false;
                    break;
                }
            }
            z3 = true;
            if (z3) {
                this.mpN.setVisibility(0);
            } else {
                this.mpN.setVisibility(8);
            }
            it2 = this.moS.iterator();
            while (it2.hasNext()) {
                if (((n) it2.next()).status != 0) {
                    z3 = false;
                    break;
                }
            }
            z3 = true;
            if (z3) {
                this.mpO.setVisibility(0);
                if (z2) {
                    addTextOptionMenu(0, this.moX.name, new 3(this));
                }
                textView = this.mpF;
                string = (this.moR != null || this.moR.size() <= 0 || bi.oW(((n) this.moR.get(0)).peu)) ? getString(i.wallet_recharge_fee_title) : ((n) this.moR.get(0)).peu;
                textView.setText(string);
                textView = this.mpG;
                string = (this.moS != null || this.moS.size() <= 0 || bi.oW(((n) this.moS.get(0)).peu)) ? getString(i.wallet_recharge_flow_title) : ((n) this.moS.get(0)).peu;
                textView.setText(string);
                if (this.moW != null || bi.oW(this.moW.name)) {
                    this.mpK.setVisibility(8);
                } else {
                    this.mpK.setVisibility(0);
                    this.mpK.setText(this.moW.name);
                    this.mpK.setOnClickListener(new 4(this));
                }
                if (this.moT != null || bi.oW(this.moT.name) || bi.oW(this.moT.url)) {
                    this.mpJ.setVisibility(8);
                } else {
                    this.mpJ.setVisibility(0);
                    this.mpJ.setText(this.moT.name);
                    this.mpJ.setOnClickListener(/* anonymous class already generated */);
                }
                if (this.moU != null || bi.oW(this.moU.name) || bi.oW(this.moU.url)) {
                    this.mpL.setVisibility(8);
                } else {
                    this.mpL.setVisibility(0);
                    this.mpL.setText(this.moU.name);
                    this.mpL.setOnClickListener(/* anonymous class already generated */);
                }
                if (this.moV != null || bi.oW(this.moV.name) || bi.oW(this.moV.url)) {
                    this.mpM.setVisibility(8);
                } else {
                    this.mpM.setVisibility(0);
                    this.mpM.setText(this.moV.name);
                    this.mpM.setOnClickListener(/* anonymous class already generated */);
                }
                mallFunction = this.mpR;
                if (mallFunction.prU == null && mallFunction.prU.ppS == 1 && !bi.oW(mallFunction.prU.psk)) {
                    g.Ek();
                    z3 = !((Boolean) g.Ei().DT().get(aa.a.sTt, Boolean.valueOf(false))).booleanValue();
                } else {
                    z3 = false;
                }
                if (!z3) {
                    g.Ek();
                    g.Ei().DT().a(aa.a.sTt, Boolean.valueOf(true));
                    x.d("MicroMsg.PhoneRechargeUI", this.mpR.prU.toString());
                    h.a(this.mController.tml, getString(i.wallet_recharge_unicom_message_title), y.gq(this).inflate(com.tencent.mm.plugin.wxpay.a.g.recharge_remind_dialog, null), getString(i.wallet_recharge_unicom_message_yes), getString(i.wallet_recharge_unicom_message_no), new 8(this, this.mpR.prU.psk), new 9(this));
                }
            }
        }
        this.mpN.setVisibility(8);
        this.mpO.setVisibility(8);
        if (z2) {
            addTextOptionMenu(0, this.moX.name, new 3(this));
        }
        textView = this.mpF;
        if (this.moR != null) {
        }
        textView.setText(string);
        textView = this.mpG;
        if (this.moS != null) {
        }
        textView.setText(string);
        if (this.moW != null) {
        }
        this.mpK.setVisibility(8);
        if (this.moT != null) {
        }
        this.mpJ.setVisibility(8);
        if (this.moU != null) {
        }
        this.mpL.setVisibility(8);
        if (this.moV != null) {
        }
        this.mpM.setVisibility(8);
        mallFunction = this.mpR;
        if (mallFunction.prU == null) {
        }
        z3 = false;
        if (!z3) {
            g.Ek();
            g.Ei().DT().a(aa.a.sTt, Boolean.valueOf(true));
            x.d("MicroMsg.PhoneRechargeUI", this.mpR.prU.toString());
            h.a(this.mController.tml, getString(i.wallet_recharge_unicom_message_title), y.gq(this).inflate(com.tencent.mm.plugin.wxpay.a.g.recharge_remind_dialog, null), getString(i.wallet_recharge_unicom_message_yes), getString(i.wallet_recharge_unicom_message_no), new 8(this, this.mpR.prU.psk), new 9(this));
        }
    }

    private void bqc() {
        this.moR = new ArrayList();
        n nVar = new n();
        nVar.name = getString(i.wallet_recharge_default_item_0);
        nVar.status = 0;
        n nVar2 = new n();
        nVar2.name = getString(i.wallet_recharge_default_item_1);
        nVar2.status = 0;
        n nVar3 = new n();
        nVar3.name = getString(i.wallet_recharge_default_item_2);
        nVar3.status = 0;
        n nVar4 = new n();
        nVar4.name = getString(i.wallet_recharge_default_item_3);
        nVar4.status = 0;
        n nVar5 = new n();
        nVar5.name = getString(i.wallet_recharge_default_item_4);
        nVar5.status = 0;
        n nVar6 = new n();
        nVar6.name = getString(i.wallet_recharge_default_item_5);
        nVar6.status = 0;
        this.moR.add(nVar);
        this.moR.add(nVar2);
        this.moR.add(nVar3);
        this.moR.add(nVar4);
        this.moR.add(nVar5);
        this.moR.add(nVar6);
        this.moS = new ArrayList();
        nVar = new n();
        nVar.name = getString(i.wallet_recharge_default_item_6);
        nVar.status = 0;
        nVar2 = new n();
        nVar2.name = getString(i.wallet_recharge_default_item_7);
        nVar2.status = 0;
        nVar3 = new n();
        nVar3.name = getString(i.wallet_recharge_default_item_8);
        nVar3.status = 0;
        this.moS.add(nVar);
        this.moS.add(nVar2);
        this.moS.add(nVar3);
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.phone_recharge_ui;
    }

    private void Ko(String str) {
        h.a(this, str, "", false, new 10(this));
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar instanceof f) {
            f fVar = (f) lVar;
            if (fVar.cmdId != 0) {
                x.i("MicroMsg.PhoneRechargeUI", "do delete phone number");
            } else if (bi.oW(fVar.eTa) || fVar.eTa.equals(this.mpE.getText())) {
                m(lVar);
                if (fVar.moQ) {
                    x.e("MicroMsg.PhoneRechargeUI", "hy: cgi failed.");
                    Ko(fVar.Yy);
                    bqb();
                    return;
                }
                boolean z;
                boolean z2;
                this.mAppId = fVar.appId;
                this.moR = fVar.moR;
                this.moT = fVar.moT;
                this.moU = fVar.moU;
                this.moV = fVar.moV;
                this.moW = fVar.moW;
                this.errCode = fVar.errCode;
                this.Yy = fVar.Yy;
                this.mpS = fVar.desc;
                x.i("MicroMsg.PhoneRechargeUI", "desc: %s, mobile: %s", new Object[]{this.mpS, this.mpE.getText()});
                if (bi.oW(this.mpS)) {
                    this.desc = "";
                    this.mpT = getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.normal_text_color);
                } else if (this.mpW.mph != null && this.mpW.mph.mov.trim().equals(this.mpE.getText())) {
                    this.mpW.mph.mow = this.mpS;
                    this.mpW.setInput(this.mpW.mph);
                }
                this.mpX = fVar.moY;
                this.moS = fVar.moS;
                if (this.moS != null) {
                    for (int size = this.moS.size() - 1; size >= 0; size--) {
                        n nVar = (n) this.moS.get(size);
                        if (nVar.name.isEmpty()) {
                            this.moS.remove(nVar);
                        }
                    }
                }
                if (fVar.moX == null || (fVar.moX.name.equals(this.moX.name) && fVar.moX.url.equals(this.moX.url) && fVar.moX.pdR.equals(this.moX.pdR) && fVar.moX.dzE.equals(this.moX.dzE))) {
                    z = false;
                } else {
                    x.i("MicroMsg.PhoneRechargeUI", "need to update head");
                    this.moX = fVar.moX;
                    z = true;
                }
                if (this.mpS.equals("")) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                A(z2, z);
                List list = fVar.moZ;
                if (list != null) {
                    x.d("MicroMsg.PhoneRechargeUI", "update record history");
                    com.tencent.mm.plugin.recharge.a.a.bpV().bP(list);
                    if (this.mpW != null) {
                        if (fVar.mpa) {
                            this.mpW.hn(true);
                        } else {
                            this.mpW.hn(false);
                        }
                    }
                }
                this.mpE.postDelayed(new 11(this), 300);
            } else {
                x.i("MicroMsg.PhoneRechargeUI", "hy: mobiel num not match.abourt, %s, %s", new Object[]{fVar.eTa, this.mpE.getText()});
            }
        } else if (lVar instanceof com.tencent.mm.plugin.recharge.model.g) {
            m(lVar);
            if (i == 0 && i2 == 0) {
                PayInfo payInfo = ((com.tencent.mm.plugin.recharge.model.g) lVar).mpb;
                payInfo.bVY = 6;
                payInfo.qUI = 100;
                payInfo.hvl = this.mpE.getText();
                payInfo.fky = this.mpW.mph != null ? this.mpW.mph.name : "";
                com.tencent.mm.pluginsdk.wallet.h.a(this, payInfo, 2);
                com.tencent.mm.sdk.b.a.sFg.b(this.lSI);
                return;
            }
            if (bi.oW(str)) {
                str = getString(i.wallet_unknown_err);
            }
            Ko(str);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        String str = null;
        switch (i) {
            case 1:
                if (i2 == -1) {
                    this.mpY = true;
                    List arrayList = new ArrayList();
                    Uri data = intent.getData();
                    if (data != null) {
                        if (android.support.v4.content.a.f(this, "android.permission.READ_CONTACTS") == 0) {
                            try {
                                Cursor query = getContentResolver().query(data, null, null, null, null);
                                if (query != null && query.getCount() > 0) {
                                    query.moveToFirst();
                                    int columnIndex = query.getColumnIndex("has_phone_number");
                                    if (columnIndex <= 0 || query.getInt(columnIndex) > 0) {
                                        String string = query.getString(query.getColumnIndex("_id"));
                                        Cursor query2 = getContentResolver().query(Phone.CONTENT_URI, null, "contact_id = " + string, null, null);
                                        if (query2 != null && query2.moveToFirst()) {
                                            String str2 = null;
                                            while (!query2.isAfterLast()) {
                                                columnIndex = query2.getColumnIndex("data1");
                                                int columnIndex2 = query2.getColumnIndex("display_name");
                                                String string2 = query2.getString(columnIndex);
                                                str2 = query2.getString(columnIndex2);
                                                x.d("MicroMsg.PhoneRechargeUI", "hy: username : " + str2);
                                                if (string2 != null) {
                                                    x.d("MicroMsg.PhoneRechargeUI", "hy: phoneNumber : " + string2);
                                                    string = b.pK(string2);
                                                    x.d("MicroMsg.PhoneRechargeUI", "hy: phoneNumber : " + string);
                                                    if (PhoneNumberUtils.isGlobalPhoneNumber(string) && string.length() == 11) {
                                                        arrayList.add(string);
                                                    }
                                                    x.d("MicroMsg.PhoneRechargeUI", "hy: phoneResult : " + string);
                                                }
                                                query2.moveToNext();
                                            }
                                            str = str2;
                                        }
                                        if (query2 != null) {
                                            query2.close();
                                        }
                                    }
                                }
                                if (!(query == null || query.isClosed())) {
                                    query.close();
                                }
                                if (arrayList.size() <= 1) {
                                    if (arrayList.size() != 1) {
                                        h.b(this, getString(i.mall_recharge_pick_contact_error), "", true);
                                        break;
                                    }
                                    this.mpW.setInput(new com.tencent.mm.plugin.recharge.model.a((String) arrayList.get(0), str, 1));
                                    bqd();
                                    break;
                                }
                                com.tencent.mm.ui.widget.a.c a = h.a(this, getString(i.wallet_recharge_pick_phone_number), arrayList, -1, new 13(this, arrayList, str));
                                if (a != null) {
                                    a.setCanceledOnTouchOutside(true);
                                    break;
                                }
                            } catch (SecurityException e) {
                                x.e("MicroMsg.PhoneRechargeUI", "hy: permission denied: %s", new Object[]{e.toString()});
                                h.b(this, getString(i.mall_recharge_read_contact_error), "", true);
                                break;
                            }
                        }
                        x.e("MicroMsg.PhoneRechargeUI", "no contact permission");
                        return;
                    }
                    x.e("MicroMsg.PhoneRechargeUI", "hy: uri == null");
                    return;
                }
                break;
            case 2:
                if (i2 == -1) {
                    if (!this.lSF) {
                        x.i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : ok");
                        com.tencent.mm.plugin.recharge.a.a.bpV().a(new com.tencent.mm.plugin.recharge.model.a(this.mpE.getText(), this.mpE.getTipsTv().getText().toString(), 0));
                        finish();
                        this.lSF = true;
                        break;
                    }
                }
                x.i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : cancel");
                break;
                break;
        }
        super.onActivityResult(i, i2, intent);
    }

    private void bqd() {
        g.DF().a(new f(this.mpE.getText()), 0);
    }

    public final void bqe() {
        g.DF().a(new f("", 1), 0);
    }
}
