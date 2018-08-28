package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ab.e;
import com.tencent.mm.ak.o;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.l;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.c.s;
import org.json.JSONObject;

public class WalletSecuritySettingUI extends MMPreference implements e {
    private f eOE;
    private c piA;
    private b piB;
    private ProgressDialog piC;
    private boolean pir = true;
    private WalletSecuritySettingHeaderPref pis;
    private IconPreference pit;
    private IconPreference piu;
    private IconPreference piv;
    private IconPreference piw;
    private Preference pix;
    private a piy;
    private d piz;

    private class b {
        String desc;
        String lCU;
        String piF;
        String piI;
        String piJ;
        String piK;
        int status;
        String title;

        b(Context context) {
            if (!p.r(context, "com.tencent.qqpimsecure")) {
                this.status = 0;
            } else if (bi.br(context, "com.tencent.server.back.BackEngine")) {
                this.status = 2;
            } else {
                this.status = 1;
            }
        }

        public final String getUrl() {
            if (this.status == 0) {
                return fd("qqpimsecurestatus", "not_installed");
            }
            if (this.status == 1) {
                return fd("qqpimsecurestatus", "not_run");
            }
            return fd("qqpimsecurestatus", "runing");
        }

        private String fd(String str, String str2) {
            return Uri.parse(this.piF).buildUpon().appendQueryParameter(str, str2).build().toString();
        }
    }

    private class d {
        String desc;
        String lCU;
        String piN;
        boolean piO;
        int status;
        String title;

        private d() {
        }

        /* synthetic */ d(WalletSecuritySettingUI walletSecuritySettingUI, byte b) {
            this();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        setBackBtn(new 1(this));
        if (com.tencent.mm.compatible.util.d.fR(23)) {
            getWindow().setStatusBarColor(getResources().getColor(c.white));
            cqc();
        }
    }

    public final int Ys() {
        return -1;
    }

    protected final void initView() {
        super.initView();
        this.eOE = this.tCL;
        if (this.eOE != null) {
            this.eOE.addPreferencesFromResource(l.wallet_security_setting_pref);
        }
        g.Ek();
        String str = (String) g.Ei().DT().get(a.sYG, "");
        if (!bi.oW(str)) {
            try {
                ac(new JSONObject(str));
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WalletSecuritySettingUI", e, "", new Object[0]);
            }
        }
    }

    protected void onResume() {
        String string;
        String string2;
        super.onResume();
        this.pis = (WalletSecuritySettingHeaderPref) this.eOE.ZZ("wallet_security_basic_info");
        if (this.pis != null) {
            boolean z;
            WalletSecuritySettingHeaderPref walletSecuritySettingHeaderPref = this.pis;
            OnClickListener anonymousClass2 = new OnClickListener() {
                public final void onClick(View view) {
                    if (WalletSecuritySettingUI.this.piy != null && bi.oW(WalletSecuritySettingUI.this.piy.piF)) {
                        x.e("MicroMsg.WalletSecuritySettingUI", "alivnluo jump h5 url is null");
                    } else if (WalletSecuritySettingUI.this.piy != null && WalletSecuritySettingUI.this.piy.jumpType == 1 && !bi.oW(WalletSecuritySettingUI.this.piy.piF)) {
                        Intent intent = new Intent();
                        x.i("MicroMsg.WalletSecuritySettingUI", "alvinluo jump url: %s", new Object[]{WalletSecuritySettingUI.this.piy.piF});
                        intent.putExtra("rawUrl", WalletSecuritySettingUI.this.piy.piF);
                        com.tencent.mm.bg.d.b(WalletSecuritySettingUI.this, "webview", ".ui.tools.WebViewUI", intent);
                    } else if (WalletSecuritySettingUI.this.piy != null && WalletSecuritySettingUI.this.piy.jumpType == 2) {
                        bi.oW(WalletSecuritySettingUI.this.piy.piG);
                    }
                }
            };
            String str = "MicroMsg.WalletSecuritySettingHeaderPref";
            String str2 = "alvinluo details == null: %b";
            Object[] objArr = new Object[1];
            if (walletSecuritySettingHeaderPref.pil == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.v(str, str2, objArr);
            walletSecuritySettingHeaderPref.pip = anonymousClass2;
            if (walletSecuritySettingHeaderPref.pil != null) {
                walletSecuritySettingHeaderPref.pil.setOnClickListener(anonymousClass2);
            }
            walletSecuritySettingHeaderPref = this.pis;
            3 3 = new 3(this);
            str = "MicroMsg.WalletSecuritySettingHeaderPref";
            str2 = "alvinluo closeBtn == null: %b";
            objArr = new Object[1];
            objArr[0] = Boolean.valueOf(walletSecuritySettingHeaderPref.gVv == null);
            x.v(str, str2, objArr);
            walletSecuritySettingHeaderPref.piq = 3;
            if (walletSecuritySettingHeaderPref.gVv != null) {
                walletSecuritySettingHeaderPref.gVv.setOnClickListener(3);
            }
        }
        g.Ek();
        g.Eh().dpP.a(385, this);
        if (this.pir) {
            this.piC = h.a(this, getString(i.app_waiting), false, null);
            this.pir = false;
        }
        boolean aNa = ((k) g.l(k.class)).aNa();
        SharedPreferences chZ = ad.chZ();
        if (chZ != null) {
            string = chZ.getString("cpu_id", null);
            string2 = chZ.getString("uid", null);
        } else {
            string2 = null;
            string = null;
        }
        x.i("MicroMsg.WalletSecuritySettingUI", "alvinluo getSecurityInfo isOpenTouchPay: %b", new Object[]{Boolean.valueOf(aNa)});
        g.DF().a(new com.tencent.mm.plugin.wallet.pwd.a.d(aNa, string, string2), 0);
    }

    protected void onPause() {
        super.onPause();
        g.Ek();
        g.Eh().dpP.b(385, this);
    }

    public final boolean a(f fVar, Preference preference) {
        if ("wallet_security_digital_certificate".equals(preference.mKey)) {
            com.tencent.mm.bg.d.b(this, "wallet", ".pwd.ui.WalletDigitalCertUI", new Intent());
            return true;
        } else if ("wallet_security_pay_guard".equals(preference.mKey)) {
            if (this.piB == null) {
                return true;
            }
            x.i("MicroMsg.WalletSecuritySettingUI", "jump url %s ", new Object[]{this.piB.getUrl()});
            com.tencent.mm.wallet_core.ui.e.bF(this, this.piB.getUrl());
            return true;
        } else if ("wallet_security_wallet_lock".equals(preference.mKey)) {
            ((com.tencent.mm.plugin.walletlock.a.b) g.l(com.tencent.mm.plugin.walletlock.a.b.class)).c(this, new Intent());
            return true;
        } else if (!"wallet_security_safety_insurance".equals(preference.mKey)) {
            return false;
        } else {
            if (this.piA == null) {
                return true;
            }
            if (this.piA.jumpType == 2) {
                qu quVar = new qu();
                quVar.cbq.cbu = 0;
                quVar.cbq.userName = this.piA.piM;
                quVar.cbq.cbs = this.piA.piG;
                com.tencent.mm.sdk.b.a.sFg.m(quVar);
            } else {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", this.piA.piF);
                x.d("MicroMsg.WalletSecuritySettingUI", "raw url: %s", new Object[]{intent.getStringExtra("rawUrl")});
                com.tencent.mm.bg.d.b(this, "webview", ".ui.tools.WebViewUI", intent);
            }
            return true;
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        x.v("MicroMsg.WalletSecuritySettingUI", "alvinluo errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (lVar instanceof com.tencent.mm.plugin.wallet.pwd.a.d) {
            x.v("MicroMsg.WalletSecuritySettingUI", "alvinluo json: %s", new Object[]{((com.tencent.mm.plugin.wallet.pwd.a.d) lVar).phm});
            ac(r0);
        }
    }

    private void onError(String str) {
        if (this.piC != null && this.piC.isShowing()) {
            this.piC.dismiss();
        }
        h.a(this, str, "", false, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                WalletSecuritySettingUI.this.finish();
            }
        });
    }

    private void ac(JSONObject jSONObject) {
        if (jSONObject == null) {
            x.e("MicroMsg.WalletSecuritySettingUI", "alvinluo security info json is null");
            onError(getString(i.wallet_security_info_get_error));
            return;
        }
        try {
            JSONObject jSONObject2;
            this.eOE = this.tCL;
            CharSequence string = jSONObject.getString("more_security_title");
            this.pix = this.eOE.ZZ("wallet_security_more_title");
            this.pix.setTitle(string);
            if (jSONObject.has("basic_security_item")) {
                jSONObject2 = jSONObject.getJSONObject("basic_security_item");
                this.piy = new a(this, (byte) 0);
                this.piy.title = jSONObject2.optString("title");
                this.piy.desc = jSONObject2.optString("desc");
                this.piy.lCU = jSONObject2.optString("logo_url");
            }
            if (jSONObject.has("wallet_lock_info")) {
                jSONObject2 = jSONObject.getJSONObject("wallet_lock_info");
                this.piz = new d(this, (byte) 0);
                this.piz.title = jSONObject2.optString("wallet_lock_title");
                this.piz.desc = jSONObject2.optString("wallet_lock_desc");
                this.piz.lCU = jSONObject2.getString("wallet_lock_logo_url");
                this.piz.status = jSONObject2.optInt("wallet_lock_status");
                this.piz.piN = jSONObject2.optString("wallet_lock_status_name");
                this.piz.piO = jSONObject2.optBoolean("is_open_touch_pay", false);
            }
            if (jSONObject.has("property_security_info")) {
                jSONObject2 = jSONObject.getJSONObject("property_security_info");
                this.piA = new c(this, (byte) 0);
                this.piA.title = jSONObject2.optString("title", "");
                this.piA.desc = jSONObject2.optString("desc", "");
                this.piA.lCU = jSONObject2.optString("logo_url", "");
                this.piA.status = jSONObject2.optInt("status", 0);
                this.piA.piL = jSONObject2.optString("status_name");
                this.piA.jumpType = jSONObject2.optInt("jump_type");
                this.piA.piF = jSONObject2.optString("jump_h5_url");
                this.piA.piM = jSONObject2.optString("tinyapp_username");
                this.piA.piG = jSONObject2.optString("tinyapp_path");
            }
            if (jSONObject.has("safe_manager_info")) {
                jSONObject2 = jSONObject.getJSONObject("safe_manager_info");
                this.piB = new b(this);
                this.piB.title = jSONObject2.optString("title", "");
                this.piB.desc = jSONObject2.optString("desc", "");
                this.piB.lCU = jSONObject2.optString("logo_url", "");
                this.piB.piJ = jSONObject2.optString("installed_status_name");
                this.piB.piI = jSONObject2.optString("uninstall_status_name");
                this.piB.piK = jSONObject2.optString("protected_mode_name");
                this.piB.piF = jSONObject2.optString("jump_h5_url");
            }
            s.cDi().aq(jSONObject);
            g.Ek();
            g.Ei().DT().a(a.sYG, jSONObject.toString());
            this.pis = (WalletSecuritySettingHeaderPref) this.eOE.ZZ("wallet_security_basic_info");
            if (this.piy != null) {
                WalletSecuritySettingHeaderPref walletSecuritySettingHeaderPref = this.pis;
                String str = this.piy.title;
                String str2 = this.piy.desc;
                String str3 = this.piy.piH;
                walletSecuritySettingHeaderPref.iRT = str;
                walletSecuritySettingHeaderPref.pim = str2;
                walletSecuritySettingHeaderPref.pio = str3;
                walletSecuritySettingHeaderPref.aL();
                if (bi.oW(this.piy.piH)) {
                    walletSecuritySettingHeaderPref = this.pis;
                    if (walletSecuritySettingHeaderPref.pil != null) {
                        walletSecuritySettingHeaderPref.pil.setVisibility(8);
                    }
                }
            }
            if (this.piz == null) {
                this.eOE.bw("wallet_security_wallet_lock", true);
            } else {
                this.eOE.bw("wallet_security_wallet_lock", false);
                this.piv = (IconPreference) this.eOE.ZZ("wallet_security_wallet_lock");
                a(this.piz.lCU, this.piv);
                this.piv.setTitle(this.piz.title);
                this.piv.setSummary(this.piz.piN);
                this.piv.setDesc(this.piz.desc);
                this.piv.csj();
            }
            this.eOE.bw("wallet_security_digital_certificate", false);
            this.pit = (IconPreference) this.eOE.ZZ("wallet_security_digital_certificate");
            s.cDi();
            g.Ek();
            if ((((Integer) g.Ei().DT().get(a.sUo, Integer.valueOf(0))).intValue() > 0 ? 1 : 0) == 0) {
                this.eOE.bw("wallet_security_digital_certificate", true);
            } else {
                if (s.cDi().cDj()) {
                    if (this.pit != null) {
                        this.pit.setSummary(i.wallet_security_status_installed);
                    }
                } else if (this.pit != null) {
                    this.pit.setSummary(i.wallet_security_status_uninstalled);
                }
                a(s.cDi().uXC, this.pit);
                this.pit.setTitle(s.cDi().uXA);
                this.pit.setSummary(s.cDi().uXB);
                this.pit.setDesc(s.cDi().uXz);
                this.pit.csj();
            }
            this.eOE.bw("wallet_security_pay_guard", false);
            this.piu = (IconPreference) this.eOE.ZZ("wallet_security_pay_guard");
            if (this.piu != null) {
                this.piu.setSummary(i.wallet_security_status_uninstalled);
            }
            if (this.piB == null) {
                this.eOE.bw("wallet_security_pay_guard", true);
            } else {
                a(this.piB.lCU, this.piu);
                this.piu.setTitle(this.piB.title);
                IconPreference iconPreference = this.piu;
                b bVar = this.piB;
                string = bVar.status == 0 ? bVar.piI : bVar.status == 1 ? bVar.piJ : bVar.piK;
                iconPreference.setSummary(string);
                this.piu.setDesc(this.piB.desc);
                this.piu.csj();
            }
            this.eOE = this.tCL;
            this.eOE.bw("wallet_security_safety_insurance", false);
            this.piw = (IconPreference) this.eOE.ZZ("wallet_security_safety_insurance");
            if (this.piw != null) {
                this.piw.setSummary(i.wallet_security_status_unopened);
            }
            if (this.piA == null) {
                this.eOE.bw("wallet_security_safety_insurance", true);
            } else {
                a(this.piA.lCU, this.piw);
                this.piw.setTitle(this.piA.title);
                this.piw.setSummary(this.piA.piL);
                this.piw.setDesc(this.piA.desc);
                this.piw.csj();
            }
            this.eOE.notifyDataSetChanged();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WalletSecuritySettingUI", e, "", new Object[0]);
            onError(getString(i.wallet_security_info_get_error));
        }
        if (this.piC != null && this.piC.isShowing()) {
            this.piC.dismiss();
        }
    }

    private void a(String str, IconPreference iconPreference) {
        if (iconPreference != null) {
            o.Pe();
            Bitmap jz = com.tencent.mm.ak.c.jz(str);
            if (jz != null) {
                iconPreference.drawable = new BitmapDrawable(this.mController.tml.getResources(), jz);
            } else if (!bi.oW(str)) {
                o.Pi().a(str, new 5(this, iconPreference));
            }
        }
    }
}
