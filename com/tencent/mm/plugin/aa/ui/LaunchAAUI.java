package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.aa.a.a;
import com.tencent.mm.plugin.aa.a.c.e;
import com.tencent.mm.plugin.aa.a.d;
import com.tencent.mm.plugin.aa.a.k;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetSetting;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.ui.d.m;
import com.tencent.mm.protocal.c.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LaunchAAUI extends BaseAAPresenterActivity {
    private String chatroomName = null;
    private TextView eBQ;
    private Dialog eBX;
    private TextView eDA;
    private TextView eDB;
    private ViewGroup eDC;
    private ViewGroup eDD;
    private List<String> eDE = new ArrayList();
    private ViewGroup eDF;
    private ViewGroup eDG;
    private TextView eDH;
    private ViewGroup eDI;
    private Map<String, Double> eDJ = new HashMap();
    private Map<String, LaunchAAByPersonNameAmountRow> eDK = new HashMap();
    private Button eDL;
    private TextView eDM;
    private TextView eDN;
    private d eDO = new d();
    private int eDP = 0;
    private int eDQ = 0;
    private boolean eDR = false;
    private boolean eDc = false;
    private e eDs = ((e) t(e.class));
    private boolean eDt = false;
    private MMEditText eDu;
    private TextView eDv;
    private TextView eDw;
    private TextView eDx;
    private TextView eDy;
    private WalletFormView eDz;
    private int mode = a.ezD;
    private long timestamp = 0;

    static /* synthetic */ void a(LaunchAAUI launchAAUI) {
        String obj = launchAAUI.eDu.getText().toString();
        ((h) g.l(h.class)).a(launchAAUI.mController, launchAAUI.chatroomName, launchAAUI.getString(i.aa_dialog_sub_title) + (bi.oW(obj) ? launchAAUI.getString(i.launch_aa_default_title) : obj), launchAAUI.getString(i.aa_dialog_ok_text), new 8(launchAAUI));
    }

    static /* synthetic */ void a(LaunchAAUI launchAAUI, String str, String str2) {
        launchAAUI.eDN.setVisibility(0);
        launchAAUI.eDN.startAnimation(AnimationUtils.loadAnimation(launchAAUI, com.tencent.mm.plugin.wxpay.a.a.in_from_up));
        launchAAUI.eDN.setText(str);
        launchAAUI.eDN.setOnClickListener(new 21(launchAAUI, str2));
    }

    static /* synthetic */ void e(LaunchAAUI launchAAUI) {
        x.i("MicroMsg.LaunchAAUI", "switchMode");
        launchAAUI.eDt = false;
        if (launchAAUI.mode == a.ezD) {
            launchAAUI.mode = a.ezE;
            launchAAUI.eDC.setVisibility(8);
            launchAAUI.eDD.setVisibility(8);
            launchAAUI.eDF.setVisibility(0);
            launchAAUI.eDv.setText(launchAAUI.getString(i.launch_aa_by_person_total_amount_hint, new Object[]{Integer.valueOf(0)}));
            if (launchAAUI.eDJ != null && launchAAUI.eDJ.size() > d.VU()) {
                com.tencent.mm.plugin.report.service.h.mEJ.h(13722, new Object[]{Integer.valueOf(8)});
                launchAAUI.eDt = true;
            }
            if (launchAAUI.eDt) {
                launchAAUI.pg(launchAAUI.getString(i.launch_aa_by_person_number_exceed_limit_alert, new Object[]{Integer.valueOf(d.VU())}));
            } else {
                launchAAUI.Wv();
            }
            com.tencent.mm.plugin.report.service.h.mEJ.h(13721, new Object[]{Integer.valueOf(2), Integer.valueOf(1)});
        } else {
            launchAAUI.mode = a.ezD;
            launchAAUI.eDC.setVisibility(0);
            launchAAUI.eDD.setVisibility(0);
            launchAAUI.eDF.setVisibility(8);
            launchAAUI.eDv.setText(i.launch_aa_by_money_total_amount_hint);
            launchAAUI.eDt = false;
            if (launchAAUI.eDE.size() > d.VV()) {
                com.tencent.mm.plugin.report.service.h.mEJ.h(13722, new Object[]{Integer.valueOf(8)});
                launchAAUI.eDt = true;
            }
            launchAAUI.Wz();
            com.tencent.mm.plugin.report.service.h.mEJ.h(13721, new Object[]{Integer.valueOf(3), Integer.valueOf(1)});
        }
        launchAAUI.Wq();
        launchAAUI.YC();
        launchAAUI.Wu();
        launchAAUI.Wx();
        launchAAUI.Ww();
        launchAAUI.eDy.post(new 4(launchAAUI));
    }

    static /* synthetic */ void i(LaunchAAUI launchAAUI) {
        Intent intent = new Intent(launchAAUI, LaunchAAByPersonAmountSelectUI.class);
        intent.putExtra("chatroom", launchAAUI.chatroomName);
        intent.putExtra("maxPerAmount", d.VW());
        if (launchAAUI.eDJ != null && launchAAUI.eDJ.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : launchAAUI.eDJ.keySet()) {
                arrayList.add(str + "," + ((Double) launchAAUI.eDJ.get(str)).doubleValue());
            }
            intent.putStringArrayListExtra("oldAmountData", arrayList);
        }
        intent.putExtra("maxUserNumber", d.VU());
        launchAAUI.startActivityForResult(intent, JsApiGetSetting.CTRL_INDEX);
        com.tencent.mm.plugin.report.service.h.mEJ.h(13721, new Object[]{Integer.valueOf(3), Integer.valueOf(2)});
    }

    static /* synthetic */ void j(LaunchAAUI launchAAUI) {
        if (launchAAUI.mode != a.ezD) {
            launchAAUI.Wv();
            launchAAUI.Wy();
        } else if (!bi.oW(launchAAUI.eDz.getText()) && launchAAUI.eDE != null && launchAAUI.eDE.size() != 0) {
            launchAAUI.Wv();
            com.tencent.mm.plugin.report.service.h.mEJ.h(13721, new Object[]{Integer.valueOf(2), Integer.valueOf(3)});
            Map hashMap = new HashMap();
            try {
                Object string;
                String obj = launchAAUI.eDu.getText().toString();
                if (bi.oW(obj)) {
                    string = launchAAUI.getString(i.launch_aa_default_title);
                } else {
                    String string2 = obj;
                }
                double d = bi.getDouble(launchAAUI.eDz.getText(), 0.0d);
                hashMap.put(k.eAy, string2);
                hashMap.put(k.eAz, Double.valueOf(100.0d * d));
                hashMap.put(k.eAC, launchAAUI.chatroomName);
                hashMap.put(k.eAF, Long.valueOf(launchAAUI.timestamp));
                if ((launchAAUI.eDE != null ? launchAAUI.eDE.size() : 0) > 0) {
                    long aL = com.tencent.mm.plugin.aa.a.h.aL(launchAAUI.eBQ.getText(), "100");
                    x.d("MicroMsg.LaunchAAUI", "perAmount: %s", new Object[]{Long.valueOf(aL)});
                    if (aL <= 0 || aL > d.VW()) {
                        x.i("MicroMsg.LaunchAAUI", "illegal avgAmount: %s", new Object[]{Long.valueOf(aL)});
                        return;
                    }
                    hashMap.put(k.eAB, Long.valueOf(aL));
                    hashMap.put(k.eAE, launchAAUI.eDE);
                    launchAAUI.eBX = com.tencent.mm.wallet_core.ui.g.b(launchAAUI, false, null);
                    com.tencent.mm.vending.g.g.v(Integer.valueOf(launchAAUI.mode), hashMap).c(launchAAUI.eDs.eBs).f(new 10(launchAAUI)).a(new 9(launchAAUI));
                }
                com.tencent.mm.plugin.report.service.h.mEJ.h(13723, new Object[]{Integer.valueOf(1), com.tencent.mm.plugin.aa.a.h.pb(launchAAUI.chatroomName), Integer.valueOf(r0), Double.valueOf(d * 100.0d), string2});
            } catch (Exception e) {
                x.e("MicroMsg.LaunchAAUI", "launchAAByMoney mode: %s error: %s", new Object[]{Integer.valueOf(launchAAUI.mode), e.getMessage()});
            }
        }
    }

    static /* synthetic */ void l(LaunchAAUI launchAAUI) {
        if (launchAAUI.getIntent().getIntExtra("enter_scene", 1) == 3) {
            launchAAUI.setResult(-1);
            launchAAUI.finish();
            return;
        }
        Intent intent = new Intent();
        intent.setFlags(67108864);
        intent.putExtra("key_should_finish", true);
        com.tencent.mm.bg.d.b(launchAAUI.mController.tml, "offline", ".ui.WalletOfflineCoinPurseUI", intent);
    }

    public void onCreate(Bundle bundle) {
        List F;
        CharSequence spannableString;
        super.onCreate(bundle);
        x.i("MicroMsg.LaunchAAUI", "LaunchAAUI onCreate");
        setBackBtn(new 1(this));
        this.timestamp = System.currentTimeMillis() / 1000;
        setMMTitle(i.launch_aa_title);
        com.tencent.mm.vending.g.g.cBK().c(this.eDs.eBu).f(new 20(this)).a(new 19(this));
        this.chatroomName = getIntent().getStringExtra("chatroom_name");
        if (bi.oW(this.chatroomName)) {
            x.e("MicroMsg.LaunchAAUI", "chatroomName is null!!!");
            this.chatroomName = "";
        }
        String str = this.chatroomName;
        if (!bi.oW(str)) {
            if (!s.fq(str)) {
                F = bi.F(str.split(","));
                if (F != null) {
                    F.remove(q.GF());
                    if (F.size() > 0) {
                        str = (String) F.get(0);
                    }
                }
            }
            this.chatroomName = str;
            this.eCD = findViewById(f.root_container);
            this.eCD.setOnTouchListener(new 12(this));
            this.eDx = (TextView) findViewById(f.launch_aa_switch_mode);
            this.eDx.setClickable(true);
            this.eDx.setOnTouchListener(new m(this));
            Wu();
            this.eDL = (Button) findViewById(f.launch_aa_button);
            this.eDL.setOnClickListener(new 15(this));
            this.eDM = (TextView) findViewById(f.launch_aa_alert_tip_tv);
            this.eDN = (TextView) findViewById(f.launch_aa_warn_tip_tv);
            this.eDu = (MMEditText) findViewById(f.launch_aa_title_edit);
            this.eDv = (TextView) findViewById(f.launch_aa_total_amount_hint);
            this.eBQ = (TextView) findViewById(f.launch_aa_amount);
            this.eDw = (TextView) findViewById(f.launch_aa_amount_unit);
            this.eDv.setText(i.launch_aa_by_money_total_amount_hint);
            this.mode = a.ezD;
            this.eDy = (TextView) findViewById(f.aa_check_record);
            this.eDy.setClickable(true);
            this.eDy.setOnTouchListener(new m());
            spannableString = new SpannableString(getString(i.check_aa_record));
            spannableString.setSpan(new a(new 16(this)), 0, spannableString.length(), 18);
            this.eDy.setText(spannableString);
            this.eDy.setVisibility(8);
            this.eDu.addTextChangedListener(new 17(this));
            this.eDz = (WalletFormView) findViewById(f.launch_aa_total_amount_edit_form);
            this.eDz.a(new 5(this));
            a(this.eDz, 2, false, false);
            this.eDB = (TextView) findViewById(f.launch_aa_by_money_user_select);
            this.eDA = (TextView) findViewById(f.launch_aa_by_money_user_select_hint);
            if (s.fq(this.chatroomName)) {
                x.i("MicroMsg.LaunchAAUI", "is single chat: %s", new Object[]{this.chatroomName});
                F = new ArrayList();
                F.add(q.GF());
                F.add(this.chatroomName);
            } else {
                F = com.tencent.mm.plugin.aa.a.h.pb(this.chatroomName);
            }
            this.eDE = F;
            if (this.eDE.size() > d.VV()) {
                this.eDE.clear();
                this.eDB.setText(getString(i.paylist_aa_by_money_select_group_memeber));
                Ww();
            } else if (s.fq(this.chatroomName)) {
                this.eDB.setText(getString(i.launch_aa_by_money_all_group_member, new Object[]{Integer.valueOf(F.size())}));
            } else {
                this.eDB.setText(getString(i.launch_aa_by_money_usernumber_wording, new Object[]{Integer.valueOf(F.size())}));
            }
            this.eDB.setOnClickListener(new 6(this, F));
            this.eDC = (ViewGroup) findViewById(f.launch_by_money_total_usernumber_content_layout);
            this.eDD = (ViewGroup) findViewById(f.launch_by_money_total_amount_layout);
            this.eDz.requestFocus();
            this.eDt = false;
            this.eDH = (TextView) findViewById(f.launch_aa_by_person_user_select);
            this.eDH.setText(i.launch_aa_by_person_usernumber_default_wording);
            this.eDH.setTextColor(getResources().getColor(c.aa_comm_hint_color));
            this.eDF = (ViewGroup) findViewById(f.launch_by_person_user_layout);
            this.eDG = (ViewGroup) findViewById(f.launch_by_person_user_list_layout);
            this.eDI = (ViewGroup) findViewById(f.launch_aa_by_person_select_header_layout);
            this.eDI.setOnClickListener(new 7(this));
            cd(false);
            com.tencent.mm.plugin.report.service.h.mEJ.h(13721, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
            this.eDy.post(new 18(this));
        }
        str = "";
        this.chatroomName = str;
        this.eCD = findViewById(f.root_container);
        this.eCD.setOnTouchListener(new 12(this));
        this.eDx = (TextView) findViewById(f.launch_aa_switch_mode);
        this.eDx.setClickable(true);
        this.eDx.setOnTouchListener(new m(this));
        Wu();
        this.eDL = (Button) findViewById(f.launch_aa_button);
        this.eDL.setOnClickListener(new 15(this));
        this.eDM = (TextView) findViewById(f.launch_aa_alert_tip_tv);
        this.eDN = (TextView) findViewById(f.launch_aa_warn_tip_tv);
        this.eDu = (MMEditText) findViewById(f.launch_aa_title_edit);
        this.eDv = (TextView) findViewById(f.launch_aa_total_amount_hint);
        this.eBQ = (TextView) findViewById(f.launch_aa_amount);
        this.eDw = (TextView) findViewById(f.launch_aa_amount_unit);
        this.eDv.setText(i.launch_aa_by_money_total_amount_hint);
        this.mode = a.ezD;
        this.eDy = (TextView) findViewById(f.aa_check_record);
        this.eDy.setClickable(true);
        this.eDy.setOnTouchListener(new m());
        spannableString = new SpannableString(getString(i.check_aa_record));
        spannableString.setSpan(new a(new 16(this)), 0, spannableString.length(), 18);
        this.eDy.setText(spannableString);
        this.eDy.setVisibility(8);
        this.eDu.addTextChangedListener(new 17(this));
        this.eDz = (WalletFormView) findViewById(f.launch_aa_total_amount_edit_form);
        this.eDz.a(new 5(this));
        a(this.eDz, 2, false, false);
        this.eDB = (TextView) findViewById(f.launch_aa_by_money_user_select);
        this.eDA = (TextView) findViewById(f.launch_aa_by_money_user_select_hint);
        if (s.fq(this.chatroomName)) {
            x.i("MicroMsg.LaunchAAUI", "is single chat: %s", new Object[]{this.chatroomName});
            F = new ArrayList();
            F.add(q.GF());
            F.add(this.chatroomName);
        } else {
            F = com.tencent.mm.plugin.aa.a.h.pb(this.chatroomName);
        }
        this.eDE = F;
        if (this.eDE.size() > d.VV()) {
            this.eDE.clear();
            this.eDB.setText(getString(i.paylist_aa_by_money_select_group_memeber));
            Ww();
        } else if (s.fq(this.chatroomName)) {
            this.eDB.setText(getString(i.launch_aa_by_money_all_group_member, new Object[]{Integer.valueOf(F.size())}));
        } else {
            this.eDB.setText(getString(i.launch_aa_by_money_usernumber_wording, new Object[]{Integer.valueOf(F.size())}));
        }
        this.eDB.setOnClickListener(new 6(this, F));
        this.eDC = (ViewGroup) findViewById(f.launch_by_money_total_usernumber_content_layout);
        this.eDD = (ViewGroup) findViewById(f.launch_by_money_total_amount_layout);
        this.eDz.requestFocus();
        this.eDt = false;
        this.eDH = (TextView) findViewById(f.launch_aa_by_person_user_select);
        this.eDH.setText(i.launch_aa_by_person_usernumber_default_wording);
        this.eDH.setTextColor(getResources().getColor(c.aa_comm_hint_color));
        this.eDF = (ViewGroup) findViewById(f.launch_by_person_user_layout);
        this.eDG = (ViewGroup) findViewById(f.launch_by_person_user_list_layout);
        this.eDI = (ViewGroup) findViewById(f.launch_aa_by_person_select_header_layout);
        this.eDI.setOnClickListener(new 7(this));
        cd(false);
        com.tencent.mm.plugin.report.service.h.mEJ.h(13721, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
        this.eDy.post(new 18(this));
    }

    protected final boolean Wt() {
        return false;
    }

    private void Wu() {
        Object string;
        CharSequence string2;
        CharSequence spannableStringBuilder;
        if (this.mode == a.ezD) {
            string = getString(i.launch_aa_by_money_title_1);
            string2 = getString(i.launch_aa_by_money_title_2);
            spannableStringBuilder = new SpannableStringBuilder("");
            spannableStringBuilder.append(string);
            spannableStringBuilder.append(string2);
            spannableStringBuilder.setSpan(new a(new a.a() {
                public final void We() {
                    LaunchAAUI.e(LaunchAAUI.this);
                }
            }), string.length(), spannableStringBuilder.length(), 18);
            this.eDx.setText(spannableStringBuilder);
        } else if (this.mode == a.ezE) {
            string = getString(i.launch_aa_by_person_title_1);
            string2 = getString(i.launch_aa_by_person_title_2);
            spannableStringBuilder = new SpannableStringBuilder("");
            spannableStringBuilder.append(string);
            spannableStringBuilder.append(string2);
            spannableStringBuilder.setSpan(new a(new 3(this)), string.length(), spannableStringBuilder.length(), 18);
            this.eDx.setText(spannableStringBuilder);
        }
    }

    private void pg(String str) {
        this.eDR = true;
        this.eDM.setVisibility(0);
        this.eDM.startAnimation(AnimationUtils.loadAnimation(this, com.tencent.mm.plugin.wxpay.a.a.in_from_up));
        this.eDM.setText(str);
    }

    private void Wv() {
        this.eDR = false;
        if (this.eDM.getVisibility() != 8) {
            this.eDM.startAnimation(AnimationUtils.loadAnimation(this, com.tencent.mm.plugin.wxpay.a.a.out_to_up));
            this.eDM.setVisibility(8);
        }
    }

    private void Ww() {
        if (this.mode == a.ezD) {
            if (bi.oW(this.eDz.getText())) {
                cd(false);
                return;
            } else if (this.eDc) {
                cd(false);
                return;
            } else if (this.eDE == null || this.eDE.size() == 0) {
                cd(false);
                return;
            } else if (this.eDE.size() > d.VV() || this.eDt) {
                cd(false);
                return;
            } else {
                x.d("MicroMsg.LaunchAAUI", "b1: %s, b2: %s, avg: %s", new Object[]{this.eDz.getText(), Integer.valueOf(this.eDE.size()), Double.valueOf(com.tencent.mm.plugin.aa.a.h.a(this.eDz.getText(), this.eDE.size(), 5, 4))});
                if (com.tencent.mm.plugin.aa.a.h.a(this.eDz.getText(), this.eDE.size(), 5, 4) < 0.01d) {
                    x.i("MicroMsg.LaunchAAUI", "less than 0.01");
                    cd(false);
                    return;
                }
            }
        } else if (this.eDJ == null || this.eDJ.size() == 0) {
            cd(false);
            return;
        } else if (this.eDJ.size() > d.VV() || this.eDt) {
            cd(false);
            return;
        }
        cd(true);
    }

    private void cd(boolean z) {
        this.eDL.setEnabled(z);
        if (z) {
            this.eDv.setTextColor(getResources().getColor(c.black));
            this.eBQ.setTextColor(getResources().getColor(c.black));
            this.eDw.setTextColor(getResources().getColor(c.black));
            return;
        }
        this.eDv.setTextColor(getResources().getColor(c.aa_launch_amount_disable_color));
        this.eBQ.setTextColor(getResources().getColor(c.aa_launch_amount_disable_color));
        this.eDw.setTextColor(getResources().getColor(c.aa_launch_amount_disable_color));
    }

    private void Wx() {
        double a;
        if (this.mode == a.ezD) {
            if (this.eDE == null || this.eDE.size() <= 0) {
                this.eBQ.setText(getString(i.aa_amount_zero));
            } else {
                a = com.tencent.mm.plugin.aa.a.h.a(this.eDz.getText(), this.eDE.size(), 2, 2);
                this.eBQ.setText(getString(i.aa_amount_format, new Object[]{Double.valueOf(a)}));
            }
            this.eDv.setText(i.launch_aa_by_money_total_amount_hint);
        } else if (this.eDJ == null || this.eDJ.size() == 0) {
            this.eDv.setText(getString(i.launch_aa_by_person_total_amount_hint, new Object[]{Integer.valueOf(0)}));
            this.eBQ.setText(getString(i.aa_amount_zero));
        } else {
            a = 0.0d;
            Iterator it = this.eDJ.values().iterator();
            while (true) {
                double d = a;
                if (it.hasNext()) {
                    a = ((Double) it.next()).doubleValue() + d;
                } else {
                    this.eBQ.setText(getString(i.aa_amount_format, new Object[]{Double.valueOf(d)}));
                    this.eDv.setText(getString(i.launch_aa_by_person_total_amount_hint, new Object[]{Integer.valueOf(this.eDJ.size())}));
                    return;
                }
            }
        }
    }

    private void Wy() {
        com.tencent.mm.plugin.report.service.h.mEJ.h(13721, new Object[]{Integer.valueOf(3), Integer.valueOf(3)});
        Map hashMap = new HashMap();
        try {
            Object string;
            long j;
            String obj = this.eDu.getText().toString();
            if (bi.oW(obj)) {
                string = getString(i.launch_aa_default_title);
            } else {
                String string2 = obj;
            }
            long j2 = 0;
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            Iterator it = this.eDJ.keySet().iterator();
            while (true) {
                j = j2;
                if (!it.hasNext()) {
                    break;
                }
                obj = (String) it.next();
                double doubleValue = ((Double) this.eDJ.get(obj)).doubleValue();
                j jVar = new j();
                jVar.cfh = com.tencent.mm.wallet_core.ui.e.gq(String.valueOf(doubleValue), "100");
                jVar.username = obj;
                arrayList.add(jVar);
                j2 = jVar.cfh + j;
                arrayList2.add(jVar.cfh);
            }
            j jVar2 = new j();
            jVar2.username = q.GF();
            jVar2.cfh = j;
            hashMap.put(k.eAy, string2);
            hashMap.put(k.eAz, Long.valueOf(j));
            hashMap.put(k.eAE, arrayList);
            hashMap.put(k.eAC, this.chatroomName);
            hashMap.put(k.eAF, Long.valueOf(this.timestamp));
            if (this.eBX != null) {
                this.eBX.dismiss();
            }
            this.eBX = com.tencent.mm.wallet_core.ui.g.b(this, false, null);
            com.tencent.mm.vending.g.g.cx(hashMap).c(this.eDs.eBt).f(new 13(this)).a(new 11(this));
            com.tencent.mm.plugin.report.service.h.mEJ.h(13723, new Object[]{Integer.valueOf(2), Integer.valueOf(com.tencent.mm.plugin.aa.a.h.pb(this.chatroomName).size()), Integer.valueOf(arrayList.size() + 1), Long.valueOf(j), string2, bi.c(arrayList2, ",")});
        } catch (Exception e) {
            x.e("MicroMsg.LaunchAAUI", "launchAAByPerson error: %s", new Object[]{e.getMessage()});
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.launch_aa_ui_new;
    }

    protected void onStop() {
        super.onStop();
        if (this.eDK != null) {
            this.eDK.clear();
        }
    }

    private void Wz() {
        if (!this.eDt || this.eDR) {
            if (this.eDc && !this.eDR) {
                pg(getString(i.launch_aa_money_exceed_avg_amount_alert, new Object[]{Float.valueOf(((float) d.VW()) / 100.0f)}));
            } else if (!this.eDt && !this.eDc) {
                Wv();
            }
        } else if (this.mode == a.ezD) {
            pg(getString(i.launch_aa_by_person_number_exceed_limit_alert, new Object[]{Integer.valueOf(d.VV())}));
        } else {
            pg(getString(i.launch_aa_by_person_number_exceed_limit_alert, new Object[]{Integer.valueOf(d.VU())}));
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        String stringExtra;
        String[] split;
        int i3;
        if (i == 233) {
            if (i2 == -1) {
                stringExtra = intent.getStringExtra("Select_Contact");
                if (this.mode == a.ezD) {
                    if (!bi.oW(stringExtra)) {
                        split = stringExtra.split(",");
                        this.eDE.clear();
                        this.eDE.addAll(Arrays.asList(split));
                    }
                    List pb = com.tencent.mm.plugin.aa.a.h.pb(this.chatroomName);
                    TextView textView;
                    Object[] objArr;
                    if (pb == null || this.eDE == null || this.eDE.size() != pb.size() || !s.fq(this.chatroomName)) {
                        textView = this.eDB;
                        i3 = i.launch_aa_by_money_usernumber_wording;
                        objArr = new Object[1];
                        objArr[0] = Integer.valueOf(this.eDE != null ? this.eDE.size() : 0);
                        textView.setText(getString(i3, objArr));
                    } else {
                        textView = this.eDB;
                        i3 = i.launch_aa_by_money_all_group_member;
                        objArr = new Object[1];
                        objArr[0] = Integer.valueOf(this.eDE != null ? this.eDE.size() : 0);
                        textView.setText(getString(i3, objArr));
                    }
                }
                Wv();
                if (this.eDE == null || this.eDE.size() <= d.VV()) {
                    this.eDt = false;
                } else {
                    this.eDt = true;
                }
                double d = bi.getDouble(this.eDz.getText(), 0.0d);
                if (this.eDE == null || (d * 100.0d) / ((double) this.eDE.size()) <= ((double) d.VW())) {
                    this.eDc = false;
                } else {
                    this.eDc = true;
                    com.tencent.mm.plugin.report.service.h.mEJ.h(13722, new Object[]{Integer.valueOf(2)});
                }
                Ww();
                Wx();
                Wz();
            }
        } else if (i == JsApiGetSetting.CTRL_INDEX && i2 == -1) {
            int dimension;
            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("selectUI");
            this.eDJ.clear();
            if (stringArrayListExtra != null) {
                try {
                    if (stringArrayListExtra.size() > 0) {
                        Iterator it = stringArrayListExtra.iterator();
                        while (it.hasNext()) {
                            split = ((String) it.next()).split(",");
                            this.eDJ.put(split[0], Double.valueOf(bi.getDouble(split[1], 0.0d)));
                        }
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.LaunchAAUI", "onActivityResult, SELECT_AMOUNT_SELECT_REQUEST_CODE error: %s", new Object[]{e.getMessage()});
                    return;
                }
            }
            if (this.eDJ == null || this.eDJ.size() <= 0) {
                this.eDH.setText(i.launch_aa_by_person_usernumber_default_wording);
                this.eDH.setTextColor(getResources().getColor(c.aa_comm_hint_color));
                dimension = (int) getResources().getDimension(com.tencent.mm.plugin.wxpay.a.d.aa_launch_content_left_right_margin);
                this.eDI.setPadding(dimension, dimension, dimension, dimension);
                this.eDI.setBackgroundResource(com.tencent.mm.plugin.wxpay.a.e.launch_aa_white_round_corner_bg);
                this.eDG.setVisibility(8);
            } else {
                this.eDH.setText(getString(i.launch_aa_by_person_usernumber_wording, new Object[]{Integer.valueOf(this.eDJ.size())}));
                this.eDH.setTextColor(getResources().getColor(c.black));
                dimension = (int) getResources().getDimension(com.tencent.mm.plugin.wxpay.a.d.aa_launch_content_left_right_margin);
                this.eDI.setPadding(dimension, (int) getResources().getDimension(com.tencent.mm.plugin.wxpay.a.d.aa_launch_by_person_header_margin_large), dimension, (int) getResources().getDimension(com.tencent.mm.plugin.wxpay.a.d.aa_launch_by_person_header_margin_large_bottom));
                this.eDI.setBackgroundResource(com.tencent.mm.plugin.wxpay.a.e.launch_aa_dark_round_corner_bg);
                this.eDG.setVisibility(0);
            }
            this.eDG.removeAllViews();
            this.eDK.clear();
            dimension = 0;
            if (this.eDJ != null && this.eDJ.size() > 0) {
                Iterator it2 = this.eDJ.keySet().iterator();
                while (true) {
                    i3 = dimension;
                    if (!it2.hasNext()) {
                        break;
                    }
                    stringExtra = (String) it2.next();
                    double doubleValue = ((Double) this.eDJ.get(stringExtra)).doubleValue();
                    LaunchAAByPersonNameAmountRow launchAAByPersonNameAmountRow = new LaunchAAByPersonNameAmountRow(this);
                    if (i3 >= this.eDJ.size() - 1) {
                        launchAAByPersonNameAmountRow.setDividerVisible(false);
                    }
                    launchAAByPersonNameAmountRow.eCM.setText(com.tencent.mm.pluginsdk.ui.d.j.a(launchAAByPersonNameAmountRow.getContext(), ((b) g.l(b.class)).getDisplayName(stringExtra, this.chatroomName), launchAAByPersonNameAmountRow.eCM.getTextSize()));
                    launchAAByPersonNameAmountRow.eBQ.setText(launchAAByPersonNameAmountRow.getContext().getString(i.aa_amount_format, new Object[]{Double.valueOf(doubleValue)}));
                    this.eDG.addView(launchAAByPersonNameAmountRow);
                    this.eDK.put(stringExtra, launchAAByPersonNameAmountRow);
                    dimension = i3 + 1;
                }
            }
            if (this.eCD != null) {
                this.eCD.requestLayout();
            }
            this.eDQ = 0;
            this.eDy.post(new 14(this));
            Wx();
            Ww();
        }
    }
}
