package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.nn;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.mall.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.agf;
import com.tencent.mm.protocal.c.azx;
import com.tencent.mm.protocal.c.azy;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class MallIndexMenuUI extends MMPreference implements e {
    private f eOE;
    private int kYc;
    private List<azy> kZu;
    private HashMap<String, azx> kZv = new HashMap();
    private boolean kZw;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kZw = getIntent().getBooleanExtra("key_default_show_currency", false);
        g.Ek();
        g.Ei().DT().a(a.sZo, Boolean.valueOf(false));
        setBackBtn(new 1(this));
        this.eOE = this.tCL;
        setMMTitle(i.mall_menu_ui_title);
        g.DF().a(1754, this);
        g.DF().a(new b(), 0);
    }

    public final int Ys() {
        return -1;
    }

    protected void onDestroy() {
        super.onDestroy();
        g.DF().b(1754, this);
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.mKey;
        x.i("MicroMsg.MallIndexMenuUI", "onPreferenceTreeClick, key: %s", new Object[]{str});
        azx azx = (azx) this.kZv.get(str);
        if (azx != null) {
            JSONObject jSONObject;
            JSONObject jSONObject2 = new JSONObject();
            g.Ek();
            str = (String) g.Ei().DT().get(a.sZn, "");
            if (!bi.oW(str)) {
                boolean z;
                try {
                    jSONObject = new JSONObject(str);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.MallIndexMenuUI", e, "parse redDotConfig json failed: %s", new Object[]{e.getMessage()});
                }
                if (jSONObject.optInt(azx.name, 0) != 1) {
                    jSONObject.remove(azx.name);
                    if (jSONObject.length() <= 0) {
                        g.Ek();
                        g.Ei().DT().a(a.sZn, "");
                    } else {
                        g.Ek();
                        g.Ei().DT().a(a.sZn, jSONObject.toString());
                    }
                    if (preference instanceof IconPreference) {
                        ((IconPreference) preference).Et(8);
                        ((IconPreference) preference).Er(8);
                        ((IconPreference) preference).Es(8);
                        ((IconPreference) preference).lN(false);
                    }
                    z = true;
                } else {
                    z = false;
                }
                h hVar;
                Object[] objArr;
                switch (azx.paB) {
                    case 1:
                        x.i("MicroMsg.MallIndexMenuUI", "jump type h5, url: %s", new Object[]{azx.paC});
                        if (!bi.oW(azx.paC)) {
                            com.tencent.mm.wallet_core.ui.e.l(this, azx.paC, false);
                        }
                        hVar = h.mEJ;
                        objArr = new Object[5];
                        objArr[0] = Integer.valueOf(1);
                        objArr[1] = Integer.valueOf(z ? 1 : 0);
                        objArr[2] = azx.paC;
                        objArr[3] = "";
                        objArr[4] = Integer.valueOf(0);
                        hVar.h(14872, objArr);
                        return true;
                    case 2:
                        x.i("MicroMsg.MallIndexMenuUI", "jump type tiny app, username: %s, path: %s", new Object[]{azx.paD, azx.paD});
                        if (!bi.oW(azx.paD)) {
                            qu quVar = new qu();
                            quVar.cbq.userName = azx.paD;
                            quVar.cbq.cbs = bi.aG(azx.paE, "");
                            quVar.cbq.scene = 1066;
                            quVar.cbq.cbt = 0;
                            com.tencent.mm.sdk.b.a.sFg.m(quVar);
                        }
                        hVar = h.mEJ;
                        objArr = new Object[5];
                        objArr[0] = Integer.valueOf(2);
                        objArr[1] = Integer.valueOf(z ? 1 : 0);
                        objArr[2] = "";
                        objArr[3] = azx.paD;
                        objArr[4] = Integer.valueOf(0);
                        hVar.h(14872, objArr);
                        return true;
                    case 3:
                        x.i("MicroMsg.MallIndexMenuUI", "jump type payment management");
                        d.A(this, "wallet", ".pwd.ui.WalletPasswordSettingUI");
                        hVar = h.mEJ;
                        objArr = new Object[5];
                        objArr[0] = Integer.valueOf(3);
                        objArr[1] = Integer.valueOf(z ? 1 : 0);
                        objArr[2] = "";
                        objArr[3] = "";
                        objArr[4] = Integer.valueOf(0);
                        hVar.h(14872, objArr);
                        return true;
                    case 4:
                        x.i("MicroMsg.MallIndexMenuUI", "jump type payment security");
                        d.A(this, "wallet", ".pwd.ui.WalletSecuritySettingUI");
                        hVar = h.mEJ;
                        objArr = new Object[5];
                        objArr[0] = Integer.valueOf(4);
                        objArr[1] = Integer.valueOf(z ? 1 : 0);
                        objArr[2] = "";
                        objArr[3] = "";
                        objArr[4] = Integer.valueOf(0);
                        hVar.h(14872, objArr);
                        return true;
                    case 5:
                        x.i("MicroMsg.MallIndexMenuUI", "jump type wallet switch");
                        d.c(this, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 1);
                        hVar = h.mEJ;
                        objArr = new Object[5];
                        objArr[0] = Integer.valueOf(5);
                        objArr[1] = Integer.valueOf(z ? 1 : 0);
                        objArr[2] = "";
                        objArr[3] = "";
                        objArr[4] = Integer.valueOf(0);
                        hVar.h(14872, objArr);
                        return true;
                    case 8:
                        x.i("MicroMsg.MallIndexMenuUI", "jump type honey pay");
                        d.A(this, "honey_pay", ".ui.HoneyPayMainUI");
                        hVar = h.mEJ;
                        objArr = new Object[5];
                        objArr[0] = Integer.valueOf(8);
                        objArr[1] = Integer.valueOf(z ? 1 : 0);
                        objArr[2] = "";
                        objArr[3] = "";
                        objArr[4] = Integer.valueOf(0);
                        hVar.h(14872, objArr);
                        return true;
                    default:
                        return true;
                }
            }
            jSONObject = jSONObject2;
            if (jSONObject.optInt(azx.name, 0) != 1) {
                z = false;
            } else {
                jSONObject.remove(azx.name);
                if (jSONObject.length() <= 0) {
                    g.Ek();
                    g.Ei().DT().a(a.sZn, "");
                } else {
                    g.Ek();
                    g.Ei().DT().a(a.sZn, jSONObject.toString());
                }
                if (preference instanceof IconPreference) {
                    ((IconPreference) preference).Et(8);
                    ((IconPreference) preference).Er(8);
                    ((IconPreference) preference).Es(8);
                    ((IconPreference) preference).lN(false);
                }
                z = true;
            }
            switch (azx.paB) {
                case 1:
                    x.i("MicroMsg.MallIndexMenuUI", "jump type h5, url: %s", new Object[]{azx.paC});
                    if (!bi.oW(azx.paC)) {
                        com.tencent.mm.wallet_core.ui.e.l(this, azx.paC, false);
                    }
                    hVar = h.mEJ;
                    objArr = new Object[5];
                    objArr[0] = Integer.valueOf(1);
                    objArr[1] = Integer.valueOf(z ? 1 : 0);
                    objArr[2] = azx.paC;
                    objArr[3] = "";
                    objArr[4] = Integer.valueOf(0);
                    hVar.h(14872, objArr);
                    return true;
                case 2:
                    x.i("MicroMsg.MallIndexMenuUI", "jump type tiny app, username: %s, path: %s", new Object[]{azx.paD, azx.paD});
                    if (!bi.oW(azx.paD)) {
                        qu quVar2 = new qu();
                        quVar2.cbq.userName = azx.paD;
                        quVar2.cbq.cbs = bi.aG(azx.paE, "");
                        quVar2.cbq.scene = 1066;
                        quVar2.cbq.cbt = 0;
                        com.tencent.mm.sdk.b.a.sFg.m(quVar2);
                    }
                    hVar = h.mEJ;
                    objArr = new Object[5];
                    objArr[0] = Integer.valueOf(2);
                    objArr[1] = Integer.valueOf(z ? 1 : 0);
                    objArr[2] = "";
                    objArr[3] = azx.paD;
                    objArr[4] = Integer.valueOf(0);
                    hVar.h(14872, objArr);
                    return true;
                case 3:
                    x.i("MicroMsg.MallIndexMenuUI", "jump type payment management");
                    d.A(this, "wallet", ".pwd.ui.WalletPasswordSettingUI");
                    hVar = h.mEJ;
                    objArr = new Object[5];
                    objArr[0] = Integer.valueOf(3);
                    objArr[1] = Integer.valueOf(z ? 1 : 0);
                    objArr[2] = "";
                    objArr[3] = "";
                    objArr[4] = Integer.valueOf(0);
                    hVar.h(14872, objArr);
                    return true;
                case 4:
                    x.i("MicroMsg.MallIndexMenuUI", "jump type payment security");
                    d.A(this, "wallet", ".pwd.ui.WalletSecuritySettingUI");
                    hVar = h.mEJ;
                    objArr = new Object[5];
                    objArr[0] = Integer.valueOf(4);
                    objArr[1] = Integer.valueOf(z ? 1 : 0);
                    objArr[2] = "";
                    objArr[3] = "";
                    objArr[4] = Integer.valueOf(0);
                    hVar.h(14872, objArr);
                    return true;
                case 5:
                    x.i("MicroMsg.MallIndexMenuUI", "jump type wallet switch");
                    d.c(this, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 1);
                    hVar = h.mEJ;
                    objArr = new Object[5];
                    objArr[0] = Integer.valueOf(5);
                    objArr[1] = Integer.valueOf(z ? 1 : 0);
                    objArr[2] = "";
                    objArr[3] = "";
                    objArr[4] = Integer.valueOf(0);
                    hVar.h(14872, objArr);
                    return true;
                case 8:
                    x.i("MicroMsg.MallIndexMenuUI", "jump type honey pay");
                    d.A(this, "honey_pay", ".ui.HoneyPayMainUI");
                    hVar = h.mEJ;
                    objArr = new Object[5];
                    objArr[0] = Integer.valueOf(8);
                    objArr[1] = Integer.valueOf(z ? 1 : 0);
                    objArr[2] = "";
                    objArr[3] = "";
                    objArr[4] = Integer.valueOf(0);
                    hVar.h(14872, objArr);
                    return true;
                default:
                    return true;
            }
        } else if ("pay_my_msg".equals(str)) {
            if (o.bOW().bPw().bPn()) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", "https://wx.tenpay.com/userroll/readtemplate?t=userroll/index_tmpl");
                d.b(this, "webview", ".ui.tools.WebViewUI", intent);
            } else {
                com.tencent.mm.wallet_core.a.b(this, "ShowOrdersInfoProcess", null);
            }
            com.tencent.mm.wallet_core.ui.e.He(20);
            return true;
        } else if ("pay_manage".equals(str)) {
            if (q.GS()) {
                d.A(this, "wallet_payu", ".pwd.ui.WalletPayUPasswordSettingUI");
            } else {
                d.A(this, "wallet", ".pwd.ui.WalletPasswordSettingUI");
            }
            com.tencent.mm.wallet_core.ui.e.He(21);
            return true;
        } else {
            if ("pay_security".equals(str)) {
                d.A(this, "wallet", ".pwd.ui.WalletSecuritySettingUI");
                com.tencent.mm.wallet_core.ui.e.He(22);
            } else if ("pay_help_center".equals(str)) {
                String str2;
                Intent intent2 = new Intent();
                if (q.GS()) {
                    str2 = "https://wx.tenpay.com/cgi-bin/mmpayweb-bin/readtemplate?t=payu_faq_tmpl";
                } else {
                    str2 = "https://kf.qq.com/touch/scene_product.html?scene_id=kf1";
                }
                intent2.putExtra("rawUrl", str2);
                d.b(this, "webview", ".ui.tools.WebViewUI", intent2);
                com.tencent.mm.wallet_core.ui.e.He(23);
                return true;
            } else if ("pay_wallet_switch".equals(str)) {
                d.c(this, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 1);
                return true;
            }
            return false;
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.MallIndexMenuUI", "onSceneEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0) {
            agf agf = ((b) lVar).kYe;
            String str2 = "MicroMsg.MallIndexMenuUI";
            String str3 = "onGYNetEnd, title: %s, sectors: %s, sectors.size: %s";
            Object[] objArr = new Object[3];
            objArr[0] = agf.title;
            objArr[1] = agf.rJS;
            objArr[2] = Integer.valueOf(agf.rJS != null ? agf.rJS.size() : 0);
            x.i(str2, str3, objArr);
            x.i("MicroMsg.MallIndexMenuUI", "initPayMenuFromResponse: %s", new Object[]{agf});
            if (agf != null) {
                JSONObject jSONObject;
                this.eOE.removeAll();
                if (!bi.oW(agf.title)) {
                    setMMTitle(agf.title);
                }
                JSONObject jSONObject2 = new JSONObject();
                g.Ek();
                String str4 = (String) g.Ei().DT().get(a.sZn, "");
                if (!bi.oW(str4)) {
                    try {
                        jSONObject = new JSONObject(str4);
                    } catch (JSONException e) {
                    }
                    if (agf.rJS != null && agf.rJS.size() > 0) {
                        this.kZu = agf.rJS;
                        Object obj = 1;
                        int i3 = 0;
                        Iterator it = agf.rJS.iterator();
                        while (true) {
                            int i4 = i3;
                            if (it.hasNext()) {
                                azy azy = (azy) it.next();
                                if (azy.scH != null && azy.scH.size() > 0) {
                                    if (obj == null && bi.oW(azy.title)) {
                                        this.eOE.a(new PreferenceSmallCategory(this));
                                    }
                                    if (!bi.oW(azy.title)) {
                                        PreferenceTitleCategory preferenceTitleCategory = new PreferenceTitleCategory(this);
                                        preferenceTitleCategory.setTitle(azy.title);
                                        this.eOE.a(preferenceTitleCategory);
                                    }
                                    Iterator it2 = azy.scH.iterator();
                                    while (it2.hasNext()) {
                                        azx azx = (azx) it2.next();
                                        x.i("MicroMsg.MallIndexMenuUI", "label name: %s", new Object[]{azx.name});
                                        CdnImageIconPreference cdnImageIconPreference = new CdnImageIconPreference(this);
                                        if (!bi.oW(azx.title)) {
                                            cdnImageIconPreference.setTitle(azx.title);
                                        }
                                        if (!bi.oW(azx.desc)) {
                                            cdnImageIconPreference.Es(0);
                                            cdnImageIconPreference.ao(azx.desc, -1, Color.parseColor("#999999"));
                                        }
                                        if (!bi.oW(azx.huW)) {
                                            cdnImageIconPreference.iconUrl = azx.huW;
                                        }
                                        cdnImageIconPreference.setKey(azx.name);
                                        if (jSONObject.optInt(azx.name, 0) == 1) {
                                            if (azx.scG != null) {
                                                if ("1".equals(azx.scG.type)) {
                                                    cdnImageIconPreference.Es(0);
                                                    cdnImageIconPreference.lN(true);
                                                } else if ("2".equals(azx.scG.type)) {
                                                    cdnImageIconPreference.dk(getString(i.app_new), com.tencent.mm.plugin.wxpay.a.e.new_tips_bg);
                                                    cdnImageIconPreference.Er(0);
                                                } else if ("3".equals(azx.scG.type)) {
                                                    cdnImageIconPreference.dk(azx.scG.number, com.tencent.mm.plugin.wxpay.a.e.unread_count_shape);
                                                    cdnImageIconPreference.Er(0);
                                                }
                                                if (!bi.oW(azx.scG.bSc)) {
                                                    x.i("MicroMsg.MallIndexMenuUI", "show red dot wording: %s", new Object[]{azx.scG.bSc});
                                                    cdnImageIconPreference.ao(azx.scG.bSc, -1, Color.parseColor("#999999"));
                                                    cdnImageIconPreference.Es(0);
                                                }
                                            } else {
                                                cdnImageIconPreference.Et(0);
                                            }
                                        }
                                        cdnImageIconPreference.Ew(8);
                                        if (bi.oW(azx.name)) {
                                            this.kZv.put(i4 + azx.name + azx.paB + azx.title, azx);
                                        } else {
                                            this.kZv.put(azx.name, azx);
                                        }
                                        this.eOE.a(cdnImageIconPreference);
                                        int i5 = i4 + 1;
                                        Object obj2 = jSONObject.optInt(azx.name, 0) == 1 ? 1 : null;
                                        h hVar;
                                        Object[] objArr2;
                                        switch (azx.paB) {
                                            case 1:
                                                hVar = h.mEJ;
                                                objArr2 = new Object[5];
                                                objArr2[0] = Integer.valueOf(1);
                                                objArr2[1] = Integer.valueOf(obj2 != null ? 1 : 0);
                                                objArr2[2] = azx.paC;
                                                objArr2[3] = "";
                                                objArr2[4] = Integer.valueOf(1);
                                                hVar.h(14872, objArr2);
                                                i4 = i5;
                                                break;
                                            case 2:
                                                hVar = h.mEJ;
                                                objArr2 = new Object[5];
                                                objArr2[0] = Integer.valueOf(2);
                                                objArr2[1] = Integer.valueOf(obj2 != null ? 1 : 0);
                                                objArr2[2] = "";
                                                objArr2[3] = azx.paD;
                                                objArr2[4] = Integer.valueOf(1);
                                                hVar.h(14872, objArr2);
                                                i4 = i5;
                                                break;
                                            case 3:
                                                hVar = h.mEJ;
                                                objArr2 = new Object[5];
                                                objArr2[0] = Integer.valueOf(3);
                                                objArr2[1] = Integer.valueOf(obj2 != null ? 1 : 0);
                                                objArr2[2] = "";
                                                objArr2[3] = "";
                                                objArr2[4] = Integer.valueOf(1);
                                                hVar.h(14872, objArr2);
                                                i4 = i5;
                                                break;
                                            case 4:
                                                hVar = h.mEJ;
                                                objArr2 = new Object[5];
                                                objArr2[0] = Integer.valueOf(4);
                                                objArr2[1] = Integer.valueOf(obj2 != null ? 1 : 0);
                                                objArr2[2] = "";
                                                objArr2[3] = "";
                                                objArr2[4] = Integer.valueOf(1);
                                                hVar.h(14872, objArr2);
                                                i4 = i5;
                                                break;
                                            case 5:
                                                hVar = h.mEJ;
                                                objArr2 = new Object[5];
                                                objArr2[0] = Integer.valueOf(5);
                                                objArr2[1] = Integer.valueOf(obj2 != null ? 1 : 0);
                                                objArr2[2] = "";
                                                objArr2[3] = "";
                                                objArr2[4] = Integer.valueOf(1);
                                                hVar.h(14872, objArr2);
                                                i4 = i5;
                                                break;
                                            case 8:
                                                hVar = h.mEJ;
                                                objArr2 = new Object[5];
                                                objArr2[0] = Integer.valueOf(8);
                                                objArr2[1] = Integer.valueOf(obj2 != null ? 1 : 0);
                                                objArr2[2] = azx.paC;
                                                objArr2[3] = "";
                                                objArr2[4] = Integer.valueOf(1);
                                                hVar.h(14872, objArr2);
                                                break;
                                        }
                                        i4 = i5;
                                    }
                                    obj = null;
                                }
                                i3 = i4;
                            } else {
                                return;
                            }
                        }
                    }
                    return;
                }
                jSONObject = jSONObject2;
                if (agf.rJS != null) {
                    return;
                }
                return;
            }
            return;
        }
        x.e("MicroMsg.MallIndexMenuUI", "GetPayMenu error!");
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            g.Ek();
            this.kYc = ((Integer) g.Ei().DT().get(a.sTs, Integer.valueOf(0))).intValue();
            if (i2 != -1) {
                return;
            }
            if (q.GT()) {
                finish();
                return;
            }
            finish();
            nn nnVar = new nn();
            nnVar.bYA.context = this.mController.tml;
            com.tencent.mm.sdk.b.a.sFg.m(nnVar);
        }
    }
}
