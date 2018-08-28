package com.tencent.mm.plugin.luckymoney.appbrand.ui.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.alo;
import com.tencent.mm.protocal.c.ayk;
import com.tencent.mm.protocal.c.bee;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.LinkedList;
import java.util.List;

public class WxaLuckyMoneyDetailUI extends WxaLuckyMoneyBaseUI implements b {
    private View Iq;
    private TextView hVS;
    private TextView hXT;
    private TextView kLF;
    private final a kLL = new d();
    private Intent kLM = null;
    private ListView kLN;
    private ImageView kLO;
    private TextView kLP;
    private ImageView kLQ;
    private View kLR;
    private View kLS;
    private c kLT;
    private OnScrollListener kLU = new 1(this);
    private TextView klp;
    private p tipDialog = null;

    public final MMActivity baA() {
        return this;
    }

    public final void Ga(String str) {
        h.bA(this, str);
    }

    public final void baB() {
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        this.kLL.a(this, getIntent());
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu);
        TextView textView = (TextView) findViewById(f.action_option_text);
        if (textView != null) {
            textView.setTextColor(getResources().getColor(c.lucky_money_goldstyle_envelop_primary_text_color));
        }
        return onCreatePanelMenu;
    }

    public void onBackPressed() {
        if (this.kLM != null) {
            setResult(0, this.kLM);
        } else {
            setResult(-1, null);
        }
        finish();
    }

    protected final void initView() {
        setMMTitle(i.lucky_money_detail);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (WxaLuckyMoneyDetailUI.this.kLM != null) {
                    WxaLuckyMoneyDetailUI.this.setResult(0, WxaLuckyMoneyDetailUI.this.kLM);
                } else {
                    WxaLuckyMoneyDetailUI.this.setResult(-1, null);
                }
                WxaLuckyMoneyDetailUI.this.finish();
                return true;
            }
        });
        this.kLN = (ListView) findViewById(f.lucky_money_detail_record_list);
        this.kLT = new c(this.mController.tml);
        this.Iq = LayoutInflater.from(this).inflate(g.lucky_money_detail_header, null);
        this.kLN.addHeaderView(this.Iq);
        this.kLN.setAdapter(this.kLT);
        this.kLT.kLB = false;
        this.kLN.setOnScrollListener(this.kLU);
        this.kLO = (ImageView) this.Iq.findViewById(f.lucky_money_detail_sender_avatar);
        this.kLP = (TextView) this.Iq.findViewById(f.lucky_money_detail_whose);
        this.kLQ = (ImageView) this.Iq.findViewById(f.lucky_money_detail_group_icon);
        this.klp = (TextView) this.Iq.findViewById(f.lucky_money_detail_wishing);
        this.kLR = this.Iq.findViewById(f.lucky_money_detail_amount_area);
        this.kLF = (TextView) this.Iq.findViewById(f.lucky_money_detail_amount);
        this.kLS = this.Iq.findViewById(f.lucky_money_detail_layout);
        this.hXT = (TextView) this.Iq.findViewById(f.lucky_money_detail_tips);
        this.hVS = (TextView) this.Iq.findViewById(f.lucky_money_detail_desc);
        this.tipDialog = h.a(this.mController.tml, getString(i.loading_tips), true, new 3(this));
        this.tipDialog.show();
    }

    public final void a(ayk ayk) {
        com.tencent.mm.plugin.luckymoney.appbrand.a.i iVar;
        if (ayk == null) {
            iVar = null;
        } else {
            com.tencent.mm.plugin.luckymoney.appbrand.a.i iVar2 = new com.tencent.mm.plugin.luckymoney.appbrand.a.i();
            iVar2.username = ayk.sbj;
            iVar2.kLc = ayk.sbl;
            iVar2.nickname = ayk.sbk;
            iVar2.cfh = ayk.cfh;
            iVar2.kLg = ayk.kLg;
            iVar2.kLh = ayk.kLh;
            iVar2.kLi = ayk.sbn != 0;
            iVar2.kLe = ayk.kLe;
            iVar2.kLd = ayk.kLd;
            iVar2.kLf = ayk.kLf;
            iVar = iVar2;
        }
        a(iVar);
        int i = ayk.sbn;
        LinkedList linkedList = ayk.sbi;
        bu(ayk.sbi);
    }

    public final void a(bee bee) {
        com.tencent.mm.plugin.luckymoney.appbrand.a.i iVar;
        if (bee == null) {
            iVar = null;
        } else {
            com.tencent.mm.plugin.luckymoney.appbrand.a.i iVar2 = new com.tencent.mm.plugin.luckymoney.appbrand.a.i();
            iVar2.username = bee.sbj;
            iVar2.kLc = bee.sbl;
            iVar2.nickname = bee.sbk;
            iVar2.cfh = bee.cfh;
            iVar2.kLg = bee.kLg;
            iVar2.kLh = bee.kLh;
            iVar2.kLi = bee.sbn != 0;
            iVar2.kLe = bee.kLe;
            iVar2.kLd = bee.kLd;
            iVar2.kLf = bee.kLf;
            iVar = iVar2;
        }
        a(iVar);
        int i = bee.sbn;
        LinkedList linkedList = bee.sbi;
        bu(bee.sbi);
    }

    public final void bu(List<alo> list) {
        c cVar = this.kLT;
        if (list == null) {
            cVar.kLz = new LinkedList();
        } else {
            cVar.kLz = list;
        }
        cVar.notifyDataSetChanged();
    }

    public final void P(Intent intent) {
        this.kLM = intent;
    }

    protected final int getLayoutId() {
        return g.lucky_money_detail_ui;
    }

    private void a(com.tencent.mm.plugin.luckymoney.appbrand.a.i iVar) {
        Context context = this.mController.tml;
        o.a(this.kLO, iVar.kLc, iVar.username);
        o.a(context, this.kLP, iVar.nickname);
        o.a(context, this.klp, iVar.kLf);
        if (iVar.kLe == 1) {
            this.kLQ.setVisibility(0);
            this.kLQ.setImageResource(e.lucky_money_group_icon);
        } else {
            this.kLQ.setVisibility(8);
        }
        if (iVar.kLd == 2) {
            this.kLF.setText(com.tencent.mm.wallet_core.ui.e.A(((double) iVar.cfh) / 100.0d));
            this.kLT.kLB = false;
            this.kLR.setVisibility(0);
        } else {
            this.kLR.setVisibility(8);
        }
        if (bi.oW(iVar.kLg)) {
            this.kLS.setVisibility(8);
        } else {
            this.kLS.setVisibility(0);
            this.hXT.setText(iVar.kLg);
            this.hXT.setTextColor(getResources().getColor(c.lucky_money_operation_text_normal_color));
        }
        if (bi.oW(iVar.kLh)) {
            this.hVS.setText(null);
        } else {
            this.hVS.setText(iVar.kLh);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
    }
}
