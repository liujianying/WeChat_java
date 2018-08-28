package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.al;
import com.tencent.mm.g.a.io;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am;
import com.tencent.mm.model.am.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.n;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.c.z;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a$b;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.c.q;
import com.tencent.mm.wallet_core.ui.e;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@a(3)
public class WalletOrderInfoOldUI extends WalletOrderInfoUI {
    protected boolean bHS = true;
    protected boolean bHT = false;
    protected boolean bHU = false;
    protected String gtX = null;
    protected String lJJ;
    private c lLY = new 5(this);
    protected String lPn = null;
    protected String mAppId = "";
    private String mBW;
    protected PayInfo mCn;
    public Orders pfb;
    protected boolean ptd = false;
    private HashMap<String, b> pti = new HashMap();
    protected String ptj;
    public Set<String> pvK = null;
    public List<Commodity> pvL = null;
    private boolean pwA = false;
    public b.a pwB = new 6(this);
    private OnLongClickListener pwC = new 11(this);
    private c pwg = new 3(this);
    protected LinearLayout pwr = null;
    protected TextView pws = null;
    protected TextView pwt = null;
    public a pwu = null;
    protected String pwv = null;
    protected HashMap<String, TextView> pww = new HashMap();
    protected c pwx;
    protected Map<Long, String> pwy = new HashMap();
    private d pwz;

    protected final int getLayoutId() {
        return a$g.wallet_order_info;
    }

    private void Wj() {
        int i = 1;
        com.tencent.mm.wallet_core.c af = com.tencent.mm.wallet_core.a.af(this);
        this.mCn = (PayInfo) this.sy.getParcelable("key_pay_info");
        this.lJJ = this.sy.getString("key_trans_id");
        this.sy.getInt("key_pay_type", -1);
        x.i("MicroMsg.WalletOrderInfoOldUI", "mTransId %s", new Object[]{this.lJJ});
        this.pfb = bQo();
        if (this.pfb != null) {
            ux(0);
            c(this.pfb);
            if (!(af == null || this.pfb == null || this.mCn == null)) {
                boolean z;
                this.mAppId = this.mCn.appId;
                boolean cCT = af.cCT();
                com.tencent.mm.plugin.wallet_core.e.c.b(this, this.sy, 7);
                int i2 = this.sy.getInt("key_support_bankcard", 1) == 2 ? 2 : 1;
                h hVar = h.mEJ;
                Object[] objArr = new Object[7];
                objArr[0] = Integer.valueOf(this.mCn.bVY);
                if (this.mCn.bVY == 3) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[1] = Boolean.valueOf(z);
                if (!cCT) {
                    i = 2;
                }
                objArr[2] = Integer.valueOf(i);
                objArr[3] = Integer.valueOf(q.cDg());
                objArr[4] = Integer.valueOf((int) (this.pfb.mBj * 100.0d));
                objArr[5] = this.pfb.lNV;
                objArr[6] = Integer.valueOf(i2);
                hVar.h(10691, objArr);
            }
            if (!((o.bOW().bPs() || af == null || !af.cCT()) && com.tencent.mm.model.q.GO())) {
                com.tencent.mm.model.q.GP();
            }
            if (this.pfb == null || this.pfb.ppf == null || this.pfb.ppf.size() <= 0) {
                x.l("MicroMsg.WalletOrderInfoOldUI", "mOrders info is Illegal!", new Object[0]);
                com.tencent.mm.ui.base.h.a(this.mController.tml, i.wallet_order_info_err, 0, new 1(this));
            } else {
                this.pvL = this.pfb.ppf;
                this.lJJ = ((Commodity) this.pvL.get(0)).bOe;
                if (!(this.mCn == null || af == null || (!af.cCS() && !af.cCT()))) {
                    bQp();
                }
            }
            if (this.lJJ == null) {
                boolean booleanValue;
                Object obj = g.Ei().DT().get(aa.a.sQv, Boolean.valueOf(false));
                if (obj != null) {
                    booleanValue = ((Boolean) obj).booleanValue();
                } else {
                    booleanValue = false;
                }
                if (booleanValue) {
                    x.i("MicroMsg.WalletOrderInfoOldUI", "has show the finger print auth guide!");
                    return;
                }
                com.tencent.mm.wallet_core.c af2 = com.tencent.mm.wallet_core.a.af(this);
                Bundle bundle = new Bundle();
                if (af2 != null) {
                    bundle = af2.jfZ;
                }
                if (TextUtils.isEmpty(bundle.getString("key_pwd1"))) {
                    x.i("MicroMsg.WalletOrderInfoOldUI", "pwd is empty, not show the finger print auth guide!");
                    return;
                }
                this.pwA = false;
                if (af2 != null) {
                    af2.a(this, "fingerprint", ".ui.FingerPrintAuthTransparentUI", bundle);
                    return;
                }
                return;
            }
            return;
        }
        x.l("MicroMsg.WalletOrderInfoOldUI", "mOrders info is Illegal!", new Object[0]);
        com.tencent.mm.ui.base.h.a(this.mController.tml, i.wallet_order_info_err, 0, new 4(this));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ux(4);
        this.pvK = new HashSet();
        Wj();
        initView();
        jr(1979);
        com.tencent.mm.sdk.b.a.sFg.b(this.pwg);
        com.tencent.mm.sdk.b.a.sFg.b(this.lLY);
        this.pwA = false;
    }

    protected final boolean brH() {
        return false;
    }

    public Orders bQo() {
        return (Orders) this.sy.getParcelable("key_orders");
    }

    public void bQp() {
        a(new y(bNs(), 21), true, true);
    }

    public void Pt(String str) {
        a(new z(str), true, true);
    }

    protected final void cr(String str, int i) {
        a(new z(str, i), true, true);
    }

    protected final void a(Promotions promotions) {
        a(new n(promotions, bNs(), this.lJJ, promotions.poF), true, false);
    }

    private void c(Orders orders) {
        this.pvK.clear();
        if (orders == null || orders.ppf == null) {
            x.w("MicroMsg.WalletOrderInfoOldUI", "hy: orders is null");
            return;
        }
        for (Commodity commodity : orders.ppf) {
            if (commodity.poW == 2 && !bi.oW(commodity.ppx)) {
                x.d("MicroMsg.WalletOrderInfoOldUI", "hy: has username and is force recommend");
                this.pvK.add(commodity.ppx);
            }
        }
    }

    protected final void initView() {
        setMMTitle(i.wallet_order_info_ui_title);
        showHomeBtn(false);
        enableBackMenu(false);
        String string = getString(i.app_finish);
        if (this.mCn == null || this.mCn.bVY != 2) {
            if (!(this.pfb == null || bi.oW(this.pfb.ppq))) {
                string = this.pfb.ppq;
            }
        } else if (!bi.oW(this.mCn.pCO)) {
            string = getString(i.app_back) + this.mCn.pCO;
        } else if (!(bi.oW(this.mCn.appId) || bi.oW(com.tencent.mm.pluginsdk.model.app.g.q(this, this.mCn.appId)))) {
            string = getString(i.app_back) + com.tencent.mm.pluginsdk.model.app.g.q(this, this.mCn.appId);
        }
        addTextOptionMenu(0, string, new 7(this));
        this.pwr = (LinearLayout) findViewById(a$f.wallet_order_info_result_ll);
        this.pws = (TextView) findViewById(a$f.wallet_order_info_result);
        this.pwt = (TextView) findViewById(a$f.wallet_order_info_link_act);
        MaxListView maxListView = (MaxListView) findViewById(a$f.wallet_order_info);
        this.pwu = new a(this);
        maxListView.setAdapter(this.pwu);
        bQq();
        bQr();
        ((ScrollView) findViewById(a$f.wallet_sv)).pageScroll(33);
    }

    public final void bQq() {
        if (this.pfb != null) {
            int i;
            this.pvL = this.pfb.ppf;
            for (Commodity commodity : this.pvL) {
                if ("1".equals(commodity.lNO)) {
                    i = 0;
                    break;
                }
            }
            i = 1;
            this.pwr.setVisibility(0);
            this.pws.setVisibility(0);
            if (i == 0) {
                this.pws.setText(i.wallet_order_info_result_wait);
            } else if (!bi.oW(this.pfb.poY) && !bi.oW(this.pfb.poY.trim())) {
                this.pws.setText(this.pfb.poY);
            } else if (this.pfb.pjA != 1) {
                this.pws.setText(i.wallet_order_info_result_success_international);
            } else {
                this.pws.setText(i.wallet_order_info_result_success);
            }
        }
    }

    protected final void a(String str, d dVar) {
        bQb();
        this.pwz = dVar;
        e.r(this, str, 1);
        this.pwA = false;
    }

    protected final void Ps(String str) {
        bQb();
        e.l(this, str, false);
        this.pwA = false;
    }

    public final void bQb() {
        int i = 0;
        if (!this.ptd) {
            io ioVar = new io();
            ioVar.bRY.bRZ = 4;
            io.a aVar = ioVar.bRY;
            if (this.sy.getBoolean("intent_pay_end", false)) {
                i = -1;
            }
            aVar.bjW = i;
            com.tencent.mm.sdk.b.a.sFg.m(ioVar);
            this.ptd = true;
        }
    }

    public final void M(ab abVar) {
        if (abVar != null && ((int) abVar.dhP) != 0) {
            String BK = abVar.BK();
            x.d("MicroMsg.WalletOrderInfoOldUI", "call back from contactServer nickName " + BK + " username: " + abVar.field_username);
            if (this.pvL != null && this.pvL.size() > 0) {
                for (Commodity commodity : this.pvL) {
                    commodity.lNW = BK;
                }
                this.pwu.notifyDataSetChanged();
            }
            this.gtX = abVar.field_username;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.b.a.sFg.c(this.pwg);
        com.tencent.mm.sdk.b.a.sFg.c(this.lLY);
        js(1979);
    }

    public void done() {
        if (this.sy.containsKey("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) this.sy.getParcelable("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".ui.WalletOrderInfoOldUI");
                bundle.putString("realname_verify_process_jump_plugin", "wallet_core");
                boolean b = realnameGuideHelper.b(this, bundle, new 8(this));
                this.sy.remove("key_realname_guide_helper");
                if (!b) {
                    bQn();
                    return;
                }
                return;
            }
            return;
        }
        bQn();
    }

    public final void bQn() {
        bQb();
        this.pwA = false;
        al alVar = new al();
        alVar.bHN.bHO = true;
        com.tencent.mm.sdk.b.a.sFg.m(alVar);
        Bundle bundle = new Bundle();
        bundle.putInt("intent_pay_end_errcode", this.sy.getInt("intent_pay_end_errcode"));
        bundle.putString("intent_pay_app_url", this.sy.getString("intent_pay_app_url"));
        bundle.putBoolean("intent_pay_end", this.sy.getBoolean("intent_pay_end"));
        x.i("MicroMsg.WalletOrderInfoOldUI", "pay done...feedbackData errCode:" + this.sy.getInt("intent_pay_end_errcode"));
        for (String str : this.pvK) {
            if (!bi.oW(str)) {
                x.i("MicroMsg.WalletOrderInfoOldUI", "hy: doing netscene subscribe...appName: %s", new Object[]{str});
                if (this.pfb == null || this.mCn == null) {
                    g.Eh().dpP.a(new j(str), 0);
                } else {
                    g.Eh().dpP.a(new j(str, this.pfb.bOd, this.pfb.ppf.size() > 0 ? ((Commodity) this.pfb.ppf.get(0)).bOe : "", this.mCn.bVY, this.mCn.bVU, this.pfb.poW), 0);
                }
            }
            h.mEJ.h(13033, new Object[]{Integer.valueOf(2), str, "", "", ""});
        }
        com.tencent.mm.wallet_core.a.j(this, bundle);
        if (this.pfb != null && !bi.oW(this.pfb.ixy)) {
            String e = e(this.pfb.ixy, this.pfb.bOd, this.pfb.ppf.size() > 0 ? ((Commodity) this.pfb.ppf.get(0)).bOe : "", this.mCn.hvl, this.mCn.fky);
            x.d("MicroMsg.WalletOrderInfoOldUI", "url = " + e);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", e);
            intent.putExtra("showShare", false);
            intent.putExtra("geta8key_username", com.tencent.mm.model.q.GF());
            intent.putExtra("stastic_scene", 8);
            d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        done();
        return true;
    }

    @Deprecated
    protected Dialog onCreateDialog(int i) {
        return com.tencent.mm.ui.base.h.a(this.mController.tml, getString(i.wallet_order_info_phone), getResources().getStringArray(a$b.wallet_phone_call), "", new 9(this));
    }

    public void onResume() {
        super.onResume();
        x.i("MicroMsg.WalletOrderInfoOldUI", "onResume, isClickActivityTinyApp: %s", new Object[]{Boolean.valueOf(this.pwA)});
        if (this.pwA) {
            a(new com.tencent.mm.plugin.wallet_core.c.aa(this.pwz.pjF, this.pwz.pwm, this.pwz.pwn, this.pwz.pwo, this.pwz.bQa, this.pwz.myq, this.pwz.pqh), true, true);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.WalletOrderInfoOldUI", "onActivityResult %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 1) {
            a(new com.tencent.mm.plugin.wallet_core.c.aa(this.pwz.pjF, this.pwz.pwm, this.pwz.pwn, this.pwz.pwo, this.pwz.bQa, this.pwz.myq, this.pwz.pqh), true, true);
        }
    }

    private void bQr() {
        if (this.pfb == null || this.pfb.ppf == null || this.pfb.ppf.size() <= 0 || ((Commodity) this.pfb.ppf.get(0)).ppH == null || bi.oW(((Commodity) this.pfb.ppf.get(0)).ppH.text) || bi.oW(((Commodity) this.pfb.ppf.get(0)).ppH.url)) {
            x.i("MicroMsg.WalletOrderInfoOldUI", "hy: no commodity or no link act or link act is illegal!");
            this.pwt.setVisibility(8);
            return;
        }
        this.pwt.setVisibility(0);
        this.pwt.setText(((Commodity) this.pfb.ppf.get(0)).ppH.text);
        this.pwt.setOnClickListener(new 10(this));
    }

    public boolean d(int i, int i2, String str, l lVar) {
        if ((lVar instanceof com.tencent.mm.plugin.wallet_core.c.aa) && i == 0 && i2 == 0) {
            com.tencent.mm.plugin.wallet_core.c.aa aaVar = (com.tencent.mm.plugin.wallet_core.c.aa) lVar;
            b bVar = new b(this, aaVar.fFc);
            boolean z = (bi.oW(bVar.url) || bi.oW(bVar.bSc)) ? false : true;
            if (z) {
                this.pti.put(aaVar.pjF, bVar);
            }
            this.pwu.notifyDataSetChanged();
        }
        if (lVar instanceof z) {
            if (i == 0 && i2 == 0) {
                ux(0);
                this.pfb = ((z) lVar).pjG;
                if (this.pfb != null) {
                    this.pvL = this.pfb.ppf;
                }
                c(this.pfb);
                x.d("MicroMsg.WalletOrderInfoOldUI", "Coomdity:" + this.pvL);
                if (!(this.pvL == null || this.pvL.size() == 0)) {
                    Commodity commodity = (Commodity) this.pvL.get(0);
                    this.lJJ = commodity.bOe;
                    x.d("MicroMsg.WalletOrderInfoOldUI", "Coomdity:" + commodity.toString());
                    ab Yg = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Yg(commodity.lNW);
                    if (Yg == null || ((int) Yg.dhP) == 0) {
                        am.a.dBr.a(commodity.lNW, "", this.pwB);
                    } else {
                        M(Yg);
                    }
                    this.pwu.notifyDataSetChanged();
                    bQq();
                }
            }
            if (this.pwu != null) {
                this.pwu.notifyDataSetChanged();
            }
            bQr();
            return true;
        }
        if (lVar instanceof n) {
            if (i == 0 && i2 == 0) {
                n nVar = (n) lVar;
                String str2 = nVar.pjp;
                this.pwy.put(Long.valueOf(nVar.pjs.pji), str2);
                nVar.pjs.poG = nVar.hKX;
                if (!"-1".equals(str2) && !"0".equals(str2) && !bi.oW(nVar.pjq)) {
                    com.tencent.mm.ui.base.h.b(this, nVar.pjq, "", true);
                } else if ("0".equals(str2)) {
                    CharSequence string;
                    if (bi.oW(nVar.pjq)) {
                        string = getString(i.wallet_pay_award_got);
                    } else {
                        string = nVar.pjq;
                    }
                    Toast.makeText(this, string, 0).show();
                }
                this.pwu.notifyDataSetChanged();
                return true;
            } else if (lVar instanceof n) {
                if (bi.oW(str)) {
                    str = getString(i.wallet_unknown_err);
                }
                com.tencent.mm.ui.base.h.a(this, str, null, false, new 2(this));
                return true;
            }
        }
        return false;
    }

    public final String fx(long j) {
        if (this.pwy.containsKey(Long.valueOf(j))) {
            return (String) this.pwy.get(Long.valueOf(j));
        }
        return "-1";
    }
}
