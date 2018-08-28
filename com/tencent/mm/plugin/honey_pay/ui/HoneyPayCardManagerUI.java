package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.honey_pay.a.j;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.f;
import com.tencent.mm.plugin.wallet_core.ui.m;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.c.amo;
import com.tencent.mm.protocal.c.aze;
import com.tencent.mm.protocal.c.bao;
import com.tencent.mm.protocal.c.bdi;
import com.tencent.mm.protocal.c.btd;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.wallet_core.c.v;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HoneyPayCardManagerUI extends HoneyPayBaseUI {
    private int fdx;
    private ImageView hVP;
    private ViewGroup imf;
    private ViewGroup kkA;
    private ViewGroup kkB;
    private TextView kkC;
    private MMSwitchBtn kkD;
    private LinearLayout kkE;
    private TextView kkF;
    private TextView kkG;
    private TextView kkH;
    private View kkI;
    private View kkJ;
    private a kkK;
    private List<aze> kkL = new ArrayList();
    private Bankcard kkM;
    private bao kkN;
    private bao kkO;
    private long kkP;
    private long kkQ;
    private boolean kkR;
    private String kkS;
    private String kkc;
    private btd kkd;
    private TextView kkg;
    private TextView kki;
    private TextView kkj;
    private TextView kkk;
    private TextView kkl;
    private WalletTextView kkw;
    private ListView kkz;

    static /* synthetic */ void e(HoneyPayCardManagerUI honeyPayCardManagerUI) {
        x.i(honeyPayCardManagerUI.TAG, "do modify pay way");
        j jVar = new j(honeyPayCardManagerUI.kkN, honeyPayCardManagerUI.kkc);
        jVar.m(honeyPayCardManagerUI);
        honeyPayCardManagerUI.a(jVar, false, false);
    }

    static /* synthetic */ void f(HoneyPayCardManagerUI honeyPayCardManagerUI) {
        x.i(honeyPayCardManagerUI.TAG, "show select payway dialog");
        List<Bankcard> jl = o.bOW().jl(true);
        List arrayList = new ArrayList();
        for (Bankcard bankcard : jl) {
            if (bankcard.bOw()) {
                x.i(honeyPayCardManagerUI.TAG, "remove honey card %s", new Object[]{bankcard.field_bindSerial});
            } else {
                arrayList.add(bankcard);
            }
        }
        f.a(honeyPayCardManagerUI, arrayList, honeyPayCardManagerUI.kkM, honeyPayCardManagerUI.getString(i.honey_pay_manager_select_first_payway_text), honeyPayCardManagerUI.getString(i.honey_pay_manager_select_first_payway_desc_text), new 6(honeyPayCardManagerUI, arrayList));
        h.mEJ.h(15191, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
    }

    static /* synthetic */ void h(HoneyPayCardManagerUI honeyPayCardManagerUI) {
        x.i(honeyPayCardManagerUI.TAG, "go to quata ui");
        Intent intent = new Intent(honeyPayCardManagerUI, HoneyPayModifyQuotaUI.class);
        intent.putExtra("key_max_credit_line", honeyPayCardManagerUI.kkP);
        intent.putExtra("key_min_credit_line", honeyPayCardManagerUI.kkQ);
        intent.putExtra("key_card_no", honeyPayCardManagerUI.kkc);
        honeyPayCardManagerUI.startActivityForResult(intent, 1);
        h.mEJ.h(15191, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0)});
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        jr(2876);
        jr(2742);
        jr(2941);
        this.kkc = getIntent().getStringExtra("key_card_no");
        this.fdx = getIntent().getIntExtra("key_scene", 0);
        this.kkR = getIntent().getBooleanExtra("key_is_create", false);
        this.kkS = getIntent().getStringExtra("key_card_type");
        initView();
        x.d(this.TAG, "cardtype: %s", new Object[]{this.kkS});
        setMMTitle(i.honey_pay_main_title);
        if (this.fdx == 1) {
            bdi bdi = new bdi();
            try {
                bdi.aG(getIntent().getByteArrayExtra("key_qry_response"));
                a(bdi);
                return;
            } catch (Throwable e) {
                x.printErrStackTrace(this.TAG, e, "", new Object[0]);
                aWg();
                return;
            }
        }
        aWg();
    }

    protected final void initView() {
        this.imf = (ViewGroup) LayoutInflater.from(this).inflate(a$g.honey_pay_card_setting_header_layout, null);
        this.kkD = (MMSwitchBtn) this.imf.findViewById(a$f.hpcs_notify_sb);
        this.kkE = (LinearLayout) this.imf.findViewById(a$f.hpcs_payway_layout);
        this.kkG = (TextView) this.imf.findViewById(a$f.hpcs_payway_tv);
        this.hVP = (ImageView) this.imf.findViewById(a$f.hpcs_avatar_iv);
        this.kkw = (WalletTextView) this.imf.findViewById(a$f.hpcs_quota_tv);
        this.kkF = (TextView) this.imf.findViewById(a$f.hpcs_user_name_tv);
        this.kkC = (TextView) this.imf.findViewById(a$f.hpcs_modify_quota_tv);
        this.kkg = (TextView) this.imf.findViewById(a$f.hpcs_state_tv);
        this.kkH = (TextView) this.imf.findViewById(a$f.hpcs_state_desc_tv);
        this.kki = (TextView) this.imf.findViewById(a$f.hpcs_first_date_title_tv);
        this.kkk = (TextView) this.imf.findViewById(a$f.hpcs_first_date_tv);
        this.kkj = (TextView) this.imf.findViewById(a$f.hpcs_second_date_title_tv);
        this.kkl = (TextView) this.imf.findViewById(a$f.hpcs_second_date_tv);
        this.kkI = this.imf.findViewById(a$f.hpcs_bottom_logo_iv);
        this.kkw.setPrefix(v.cDm());
        this.kkD.setSwitchListener(new a() {
            public final void cf(boolean z) {
                int i = 1;
                x.d(HoneyPayCardManagerUI.this.TAG, "check %s", new Object[]{Boolean.valueOf(z)});
                HoneyPayCardManagerUI honeyPayCardManagerUI = HoneyPayCardManagerUI.this;
                if (!z) {
                    i = 0;
                }
                HoneyPayCardManagerUI.a(honeyPayCardManagerUI, i);
            }
        });
        this.kkE.setOnClickListener(new 4(this));
        Object string = getString(i.honey_pay_max_quota_monthly);
        CharSequence spannableStringBuilder = new SpannableStringBuilder(string);
        spannableStringBuilder.append(getString(i.honey_pay_max_quota_monthly_modify));
        spannableStringBuilder.setSpan(new m(new 5(this)), string.length(), spannableStringBuilder.length(), 18);
        this.kkC.setClickable(true);
        this.kkC.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m(this));
        this.kkC.setText(spannableStringBuilder);
        this.kkA = (ViewGroup) LayoutInflater.from(this).inflate(a$g.honey_pay_card_setting_footer_layout, null);
        this.kkJ = findViewById(a$f.hpcs_block_view);
        this.kkz = (ListView) findViewById(a$f.hpcs_lv);
        this.kkz.addHeaderView(this.imf);
        this.kkz.addFooterView(this.kkA, null, false);
        this.kkK = new a(this, (byte) 0);
        this.kkz.setAdapter(this.kkK);
        this.kkz.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                aze aze = (aze) adapterView.getAdapter().getItem(i);
                if (aze != null && !bi.oW(aze.url)) {
                    x.i(HoneyPayCardManagerUI.this.TAG, "click item: %s, %s", new Object[]{Integer.valueOf(i), Long.valueOf(aze.sbV)});
                    e.l(HoneyPayCardManagerUI.this.mController.tml, aze.url, false);
                    h.mEJ.h(15191, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0)});
                }
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
        js(2876);
        js(2742);
        js(2941);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (lVar instanceof com.tencent.mm.plugin.honey_pay.a.l) {
            com.tencent.mm.plugin.honey_pay.a.l lVar2 = (com.tencent.mm.plugin.honey_pay.a.l) lVar;
            lVar2.a(new 10(this, lVar2)).b(new 9(this)).c(new 8(this));
        } else if (lVar instanceof com.tencent.mm.plugin.honey_pay.a.i) {
            com.tencent.mm.plugin.honey_pay.a.i iVar = (com.tencent.mm.plugin.honey_pay.a.i) lVar;
            iVar.a(new 13(this)).b(new 12(this, iVar)).c(new 11(this, iVar));
        } else if (lVar instanceof j) {
            ((j) lVar).a(new 2(this)).b(new 15(this)).c(new 14(this));
        }
        return true;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            if (i2 == -1 && intent.getBooleanExtra("key_modify_create_line_succ", false)) {
                this.kkw.setText(c.dK(intent.getLongExtra("key_credit_line", 0)));
                setResult(-1);
            }
        } else if (i == 2 && i2 == -1) {
            this.mController.removeAllOptionMenu();
            setResult(-1);
            finish();
        }
        super.onActivityResult(i, i2, intent);
    }

    protected final int getLayoutId() {
        return a$g.honey_pay_card_setting_ui;
    }

    private void aWg() {
        x.i(this.TAG, "do qry detail");
        com.tencent.mm.plugin.honey_pay.a.l lVar = new com.tencent.mm.plugin.honey_pay.a.l(this.kkc);
        lVar.m(this);
        a(lVar, true, false);
    }

    private void a(bdi bdi) {
        this.kkd = bdi.rHg;
        this.kkL.clear();
        this.kkK.notifyDataSetChanged();
        if (bdi.ruX != null) {
            setMMTitle(bdi.ruX.hwg);
            this.kkP = bdi.rrY;
            this.kkQ = bdi.rrX;
            if (bdi.ruX.rPo != null) {
                this.kkM = adW(bdi.ruX.rPo.scY);
                this.kkN = bdi.ruX.rPo;
            }
            amo amo = bdi.ruX;
            this.kkF.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this, e.dy(amo.rrW, 6) + getString(i.honey_pay_max_quota_monthly), this.kkF.getTextSize()));
            b.a(this.hVP, amo.rrW, 0.06f, false);
            this.kkw.setText(c.dK(amo.ruW));
            this.kkD.setCheck(amo.peW != 0);
            aWh();
            int i = bdi.ruX.state;
            x.i(this.TAG, "detail state: %s", new Object[]{Integer.valueOf(i)});
            x.d(this.TAG, "state title: %s", new Object[]{bdi.ruX.rPr});
            if (bi.oW(bdi.ruX.rPr)) {
                this.kkg.setVisibility(8);
            } else {
                this.kkg.setText(bdi.ruX.rPr);
                this.kkg.setVisibility(0);
            }
            if (bi.oW(bdi.ruX.rPn)) {
                this.kkH.setVisibility(8);
            } else {
                this.kkH.setText(bdi.ruX.rPn);
                this.kkH.setVisibility(0);
            }
            if (i == 1) {
                this.kkg.setTextColor(Color.parseColor("#FA9D3B"));
                this.kkw.setTextColor(Color.parseColor("#B2B2B2"));
                findViewById(a$f.hpcs_date_layout).setVisibility(8);
                this.kkz.removeFooterView(this.kkA);
                this.kkA.setVisibility(8);
                this.kkI.setVisibility(8);
                if (this.kkR) {
                    this.kkB = (ViewGroup) LayoutInflater.from(this).inflate(a$g.honey_pay_card_setting_footer_finish_layout, null);
                    ((Button) this.kkB.findViewById(a$f.hpcs_finish_btn)).setOnClickListener(new 7(this));
                    this.kkz.addFooterView(this.kkB);
                    showHomeBtn(false);
                    enableBackMenu(false);
                    setMMTitle("");
                }
            } else if (i == 2) {
                if (!(bdi.qYU == null || bdi.qYU.isEmpty())) {
                    this.kkL = bdi.qYU;
                    this.kkK.notifyDataSetChanged();
                    this.kkz.removeFooterView(this.kkA);
                    this.kkA.setVisibility(8);
                    findViewById(a$f.hpcs_root_view).setBackgroundResource(com.tencent.mm.plugin.wxpay.a.c.honey_pay_grey_bg_1);
                }
                this.kkC.setVisibility(0);
                this.kkw.setVisibility(0);
                this.kkI.setVisibility(0);
                findViewById(a$f.hpcs_date_layout).setVisibility(8);
            } else if (i == 3) {
                findViewById(a$f.hpcs_date_layout).setVisibility(0);
                this.kki.setText(i.honey_pay_create_date_title_text);
                this.kkj.setText(i.honey_pay_return_date_title_text);
                this.kkk.setText(c.dL((long) bdi.ruX.create_time));
                this.kkl.setText(c.dL((long) bdi.ruX.huK));
                this.kkz.removeFooterView(this.kkA);
                this.kkA.setVisibility(8);
                this.kkI.setVisibility(8);
                findViewById(a$f.hpcs_setting_layout).setVisibility(8);
            } else if (i == 4) {
                this.kkC.setVisibility(8);
                findViewById(a$f.hpcs_date_layout).setVisibility(0);
                this.kki.setText(i.honey_pay_release_date_title_text);
                this.kkk.setText(c.dL((long) bdi.ruX.rPp));
                findViewById(a$f.hpcs_second_date_layout).setVisibility(8);
                this.kkz.removeFooterView(this.kkA);
                this.kkA.setVisibility(8);
                this.kkI.setVisibility(8);
                findViewById(a$f.hpcs_setting_layout).setVisibility(8);
                findViewById(a$f.hpcs_root_view).setBackgroundResource(com.tencent.mm.plugin.wxpay.a.c.white);
            } else {
                x.d(this.TAG, "unknown state: %s", new Object[]{Integer.valueOf(i)});
            }
        }
        this.kkJ.setVisibility(8);
        c.a(this, bdi.rPi, this.kkc, 2, this.kkd);
    }

    private static Bankcard adW(String str) {
        Bankcard bankcard;
        Bankcard bankcard2;
        ag bOW = o.bOW();
        if (bOW.pcZ != null) {
            Iterator it = bOW.pcZ.iterator();
            while (it.hasNext()) {
                bankcard = (Bankcard) it.next();
                if (bankcard.field_bindSerial.equals(str)) {
                    bankcard2 = bankcard;
                    break;
                }
            }
        }
        bankcard2 = null;
        if (bankcard2 == null) {
            bankcard = o.bOW().prG;
            if (bankcard != null && bankcard.field_bindSerial.equals(str)) {
                return bankcard;
            }
        }
        return bankcard2;
    }

    private void aWh() {
        if (this.kkN != null) {
            this.kkG.setText(this.kkN.scW);
            if (bi.oW(this.kkN.scX)) {
                this.kkG.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.normal_text_color));
                return;
            } else {
                this.kkG.setTextColor(Color.parseColor(this.kkN.scX));
                return;
            }
        }
        x.i(this.TAG, "reset payway view for null");
        this.kkG.setText("");
        this.kkG.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.normal_text_color));
    }
}
