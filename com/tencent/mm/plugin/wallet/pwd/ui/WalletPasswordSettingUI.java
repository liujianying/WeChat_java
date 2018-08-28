package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.ab.e;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.bq;
import com.tencent.mm.g.b.a.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.z;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.l;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

@a(19)
public class WalletPasswordSettingUI extends MMPreference implements e {
    private boolean dlV;
    private f eOE;
    private Dialog eXG;
    private ag handler = new ag(new ag.a() {
        public final boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    h.a(WalletPasswordSettingUI.this, false, WalletPasswordSettingUI.this.getResources().getString(a$i.fingerprint_close), "", WalletPasswordSettingUI.this.getResources().getString(a$i.app_ok), WalletPasswordSettingUI.this.getResources().getString(a$i.app_cancel), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            bq bqVar = new bq();
                            bqVar.bJX = new 1(this, bqVar);
                            com.tencent.mm.sdk.b.a.sFg.a(bqVar, WalletPasswordSettingUI.this.getMainLooper());
                        }
                    }, new 6(WalletPasswordSettingUI.this));
                    break;
                case 2:
                    WalletPasswordSettingUI.b(WalletPasswordSettingUI.this);
                    break;
            }
            return false;
        }
    });
    c pdx = new 2(this);
    CheckBoxPreference phV;
    private IconPreference phW;
    private Preference phX;
    private String phY;
    private String phZ;
    private String pia;
    private z pib;
    private boolean pic = false;
    private int pie = 0;

    static /* synthetic */ void b(WalletPasswordSettingUI walletPasswordSettingUI) {
        walletPasswordSettingUI.jq(false);
        k kVar = (k) g.l(k.class);
        h.a(walletPasswordSettingUI, walletPasswordSettingUI.getResources().getString(a$i.wallet_password_setting_ui_set_sys_fp_guide_text), "", walletPasswordSettingUI.getResources().getString(kVar.aNl() ? a$i.wallet_password_setting_ui_set_sys_fp_guide_btn : a$i.app_ok), walletPasswordSettingUI.getString(a$i.app_cancel), true, new 7(walletPasswordSettingUI, kVar), new 8(walletPasswordSettingUI));
    }

    static /* synthetic */ void e(WalletPasswordSettingUI walletPasswordSettingUI) {
        k kVar = (k) g.l(k.class);
        if (walletPasswordSettingUI.phV.isChecked() != kVar.aNa()) {
            walletPasswordSettingUI.jq(kVar.aNa());
        }
    }

    public final int Ys() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.Ek();
        g.Eh().dpP.a(385, this);
        com.tencent.mm.sdk.b.a.sFg.b(this.pdx);
        this.dlV = getIntent().getBooleanExtra("key_is_from_system", false);
        if (this.dlV) {
            x.i("MicroMsg.WalletPasswordSettingUI", "hy: enter password setting from system setting");
            ((b) g.l(b.class)).a(this, null);
        }
        initView();
        if (com.tencent.mm.plugin.wallet.pwd.a.c.bFZ()) {
            jr(false);
        } else {
            z zVar;
            g.Ek();
            this.phZ = (String) g.Ei().DT().get(aa.a.sTf, "");
            com.tencent.mm.plugin.wallet_core.d.h bOV = o.bOV();
            if (!bi.oW("wallet_open_auto_pay")) {
                Cursor b = bOV.diF.b("select * from WalletPrefInfo where pref_key=?", new String[]{r2}, 2);
                if (b != null) {
                    if (b.moveToFirst()) {
                        zVar = new z();
                        zVar.d(b);
                    } else {
                        zVar = null;
                    }
                    b.close();
                    this.pib = zVar;
                    if (this.pib == null && this.pib.field_is_show == 1 && !bi.oW(this.pib.field_pref_url)) {
                        x.i("MicroMsg.WalletPasswordSettingUI", "deduct info from cache is not null");
                        this.phY = this.pib.field_pref_url;
                        fc(this.pib.field_pref_title, this.pib.field_pref_url);
                    } else if (this.pib != null) {
                        x.i("MicroMsg.WalletPasswordSettingUI", "deduct info from cache is null");
                    } else {
                        x.i("MicroMsg.WalletPasswordSettingUI", "mOpenAutoPayPrefInfo.field_is_show = " + this.pib.field_is_show + " and mOpenAutoPayPrefInfo.field_pref_url is null?" + bi.oW(this.pib.field_pref_url));
                    }
                }
            }
            zVar = null;
            this.pib = zVar;
            if (this.pib == null) {
            }
            if (this.pib != null) {
                x.i("MicroMsg.WalletPasswordSettingUI", "mOpenAutoPayPrefInfo.field_is_show = " + this.pib.field_is_show + " and mOpenAutoPayPrefInfo.field_pref_url is null?" + bi.oW(this.pib.field_pref_url));
            } else {
                x.i("MicroMsg.WalletPasswordSettingUI", "deduct info from cache is null");
            }
        }
        g.Ek();
        this.pie = ((Integer) g.Ei().DT().get(aa.a.sVo, Integer.valueOf(0))).intValue();
        g.Ek();
        this.pia = (String) g.Ei().DT().get(aa.a.sVj, "");
        if (bi.oW(this.pia)) {
            ae.a(true, null);
        } else {
            this.phX.setTitle(this.pia);
            ae.a(false, null);
        }
        if (this.pie == 0) {
            this.eOE.bw("wallet_delay_transfer_date", true);
        }
    }

    private void fc(String str, String str2) {
        this.phW.setTitle(str);
        if (bi.oW(str2)) {
            this.eOE.bw("wallet_open_auto_pay", true);
            x.e("MicroMsg.WalletPasswordSettingUI", "deduct_url is null");
            return;
        }
        this.eOE.bw("wallet_open_auto_pay", false);
    }

    private void bOc() {
        g.Ek();
        String str = (String) g.Ei().DT().get(aa.a.sYH, "");
        g.Ek();
        x.i("MicroMsg.WalletPasswordSettingUI", "updateUnRegPref unreg_title %s unreg_url %s", new Object[]{str, (String) g.Ei().DT().get(aa.a.sYI, "")});
        if (bi.oW(str) || bi.oW(r1)) {
            this.eOE.bw("wallet_password_setting_un_reg", true);
        } else {
            this.eOE.bw("wallet_password_setting_un_reg", false);
        }
    }

    protected void onResume() {
        super.onResume();
        if (((b) g.l(b.class)).bRq()) {
            finish();
        } else {
            bOg();
        }
    }

    protected final void initView() {
        setMMTitle(q.GS() ? getString(a$i.wallet_password_setting_ui_title_payu) : getString(a$i.wallet_password_setting_ui_title));
        com.tencent.mm.wallet_core.ui.e.cDN();
        this.eOE = this.tCL;
        this.eOE.addPreferencesFromResource(bOd());
        this.phW = (IconPreference) this.eOE.ZZ("wallet_open_auto_pay");
        this.phX = this.eOE.ZZ("wallet_delay_transfer_date");
        g.Ek();
        if (!((Boolean) g.Ei().DT().get(aa.a.sSW, Boolean.valueOf(false))).booleanValue()) {
            this.phW.dl("new", com.tencent.mm.plugin.wxpay.a.e.unread_count_shape);
            this.phW.Es(0);
            g.Ek();
            g.Ei().DT().a(aa.a.sSW, Boolean.valueOf(true));
        }
        this.phV = (CheckBoxPreference) this.eOE.ZZ("wallet_fingerprint_switch");
        bOg();
        this.eOE.bw("nfc_idpay", true);
        this.eOE.bw("wallet_open_auto_pay", true);
        bOc();
        setBackBtn(new 3(this));
    }

    public int bOd() {
        return l.wallet_password_setting_pref;
    }

    public void bOe() {
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.pwd.b.class, null, null);
    }

    public void bOf() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_is_paymanager", true);
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.pwd.a.class, bundle, null);
    }

    private void jq(boolean z) {
        this.duR.edit().putBoolean("wallet_fingerprint_switch", z).commit();
        this.phV.qpJ = z;
        this.eOE.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        String str;
        Bundle bundle;
        Intent intent;
        if ("wallet_modify_password".equals(preference.mKey)) {
            bOe();
            com.tencent.mm.wallet_core.ui.e.He(24);
            return true;
        } else if ("wallet_forget_password".equals(preference.mKey)) {
            g.Ek();
            str = (String) g.Ei().DT().get(aa.a.sTf, "");
            j jVar;
            if (bi.oW(str)) {
                bOf();
                jVar = new j();
                jVar.cip = 2;
                jVar.ciq = 1;
                jVar.RD();
                com.tencent.mm.wallet_core.ui.e.He(25);
                return true;
            }
            x.i("MicroMsg.WalletPasswordSettingUI", "jump to forget_url %s", new Object[]{str});
            Intent intent2 = new Intent();
            intent2.putExtra("rawUrl", str);
            intent2.putExtra("showShare", false);
            d.b(this, "webview", ".ui.tools.WebViewUI", intent2);
            jVar = new j();
            jVar.cip = 2;
            jVar.ciq = 2;
            jVar.RD();
            return true;
        } else if ("wallet_realname_verify".equals(preference.mKey)) {
            if (!o.bOW().bPs()) {
                x.i("MicroMsg.WalletPasswordSettingUI", "go to RealNameVerifyProcess");
                bundle = new Bundle();
                bundle.putInt("real_name_verify_mode", 0);
                bundle.putString("realname_verify_process_jump_plugin", "wallet");
                bundle.putString("realname_verify_process_jump_activity", ".pwd.ui.WalletPasswordSettingUI");
                com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.id_verify.a.class, bundle, new 4(this));
            } else if (bi.oW(this.phZ)) {
                x.e("MicroMsg.WalletPasswordSettingUI", "mRealnameUrl is null");
            } else {
                x.i("MicroMsg.WalletPasswordSettingUI", "jump to mRealnameUrl");
                intent = new Intent();
                intent.putExtra("rawUrl", this.phZ);
                intent.putExtra("showShare", false);
                d.b(this, "webview", ".ui.tools.WebViewUI", intent);
            }
            return true;
        } else if ("wallet_fingerprint_switch".equals(preference.mKey)) {
            g.Ek();
            g.Ei().DT().a(aa.a.sQo, Boolean.valueOf(true));
            if (this.phV.isChecked()) {
                if (this.dlV) {
                    com.tencent.mm.plugin.soter.c.a.xO(2);
                } else {
                    com.tencent.mm.plugin.soter.c.a.xO(1);
                }
                k kVar = (k) g.l(k.class);
                if (kVar == null || !kVar.aNb()) {
                    this.handler.obtainMessage(2).sendToTarget();
                } else {
                    bundle = new Bundle();
                    bundle.putInt("open_scene", 1);
                    com.tencent.mm.wallet_core.a.b(this, "FingerprintAuth", bundle);
                }
            } else {
                this.handler.obtainMessage(1).sendToTarget();
            }
            return true;
        } else {
            if ("wallet_open_auto_pay".equals(preference.mKey)) {
                if (bi.oW(this.phY)) {
                    x.e("MicroMsg.WalletPasswordSettingUI", "mDeductUrl is null");
                } else {
                    x.i("MicroMsg.WalletPasswordSettingUI", "mDeductUrl is not null,jump!");
                    intent = new Intent();
                    intent.putExtra("rawUrl", this.phY);
                    intent.putExtra("showShare", false);
                    d.b(this, "webview", ".ui.tools.WebViewUI", intent);
                    this.phW.Es(8);
                    return true;
                }
            }
            if ("wallet_digitalcert".equals(preference.mKey)) {
                if (!this.pic) {
                    com.tencent.mm.plugin.wallet.pwd.a.c cVar = new com.tencent.mm.plugin.wallet.pwd.a.c();
                    g.Ek();
                    g.Eh().dpP.a(cVar, 0);
                }
                d.b(this, "wallet", ".pwd.ui.WalletDigitalCertUI", new Intent());
                return true;
            } else if ("wallet_delay_transfer_date".equals(preference.mKey)) {
                startActivity(new Intent(this, WalletDelayTransferSettingUI.class));
                return true;
            } else {
                if ("wallet_password_setting_un_reg".equals(preference.mKey)) {
                    g.Ek();
                    str = (String) g.Ei().DT().get(aa.a.sYI, "");
                    Intent intent3 = new Intent();
                    intent3.putExtra("rawUrl", str);
                    intent3.putExtra("showShare", false);
                    d.b(this, "webview", ".ui.tools.WebViewUI", intent3);
                }
                return false;
            }
        }
    }

    public void bOg() {
        if (o.bOW().bPp() || o.bOW().bPt()) {
            this.eOE.bw("wallet_modify_password", true);
            this.eOE.bw("wallet_forget_password", true);
            this.eOE.bw("wallet_fingerprint_switch", true);
            this.eOE.bw("wallet_realname_verify", false);
            this.eOE.ZZ("wallet_realname_verify").setSummary(a$i.wallet_password_setting_ui_go_realname_verify_now);
        } else if (o.bOW().bPs()) {
            this.eOE.bw("wallet_modify_password", false);
            this.eOE.bw("wallet_forget_password", false);
            this.eOE.bw("wallet_fingerprint_switch", false);
            this.eOE.bw("wallet_realname_verify", false);
            this.eOE.ZZ("wallet_realname_verify").setSummary(a$i.wallet_password_setting_ui_realname_verify_done);
        } else {
            x.e("MicroMsg.WalletPasswordSettingUI", "unknow reg state");
        }
        this.eOE.bw("wallet_digitalcert", true);
        if (!d.QS("fingerprint")) {
            x.e("MicroMsg.WalletPasswordSettingUI", "plugin fingerprinthad not been installed");
            this.eOE.bw("wallet_fingerprint_switch", true);
        } else if (com.tencent.mm.plugin.wallet.b.a.bOh()) {
            boolean booleanValue;
            x.i("MicroMsg.WalletPasswordSettingUI", "isSupportFingeprint is true");
            p.bNp();
            if (p.bNq() == null || !((k) g.l(k.class)).aNa()) {
                this.phV.qpJ = false;
                this.phV.tDr = false;
            } else {
                this.phV.qpJ = true;
                this.phV.tDr = false;
            }
            this.phV.setSummary(a$i.wallet_password_setting_ui_fingerprint_off_summary);
            this.eOE.bw("wallet_fingerprint_switch", false);
            g.Ek();
            g.Ei().DT().a(aa.a.sQm, Boolean.valueOf(true));
            g.Ek();
            g.Ei().DT().a(aa.a.sQn, Boolean.valueOf(true));
            g.Ek();
            Object obj = g.Ei().DT().get(aa.a.sQo, Boolean.valueOf(false));
            if (obj != null) {
                booleanValue = ((Boolean) obj).booleanValue();
            } else {
                booleanValue = false;
            }
            if (booleanValue) {
                this.phV.zi(8);
            } else {
                this.phV.cq(getString(a$i.app_new), com.tencent.mm.plugin.wxpay.a.e.unread_count_shape);
                this.phV.zi(0);
            }
        } else {
            this.eOE.bw("wallet_fingerprint_switch", true);
        }
        g.Ek();
        long longValue = ((Long) g.Ei().DT().get(147457, Long.valueOf(0))).longValue();
        int i = a$i.wallet_delay_transfer_setting_realtime_text;
        if ((16 & longValue) != 0) {
            i = a$i.wallet_delay_transfer_setting_2h_text;
        } else if ((longValue & 32) != 0) {
            i = a$i.wallet_delay_transfer_setting_24h_text;
        }
        this.eOE.ZZ("wallet_delay_transfer_date").setSummary(i);
        this.eOE.notifyDataSetChanged();
    }

    private void jr(boolean z) {
        com.tencent.mm.plugin.wallet.pwd.a.c cVar = new com.tencent.mm.plugin.wallet.pwd.a.c();
        g.Ek();
        g.Eh().dpP.a(cVar, 0);
        this.pic = true;
        if (z) {
            this.eXG = com.tencent.mm.wallet_core.ui.g.a(this, false, new 9(this));
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        if (i == 0 && i2 == 0) {
            if (lVar instanceof com.tencent.mm.plugin.wallet.pwd.a.c) {
                bOg();
                com.tencent.mm.plugin.wallet.pwd.a.c cVar = (com.tencent.mm.plugin.wallet.pwd.a.c) lVar;
                x.i("MicroMsg.WalletPasswordSettingUI", "isShowDeduct=" + cVar.phg);
                this.phZ = cVar.phk;
                if (cVar.phg == 1) {
                    this.phY = cVar.phh;
                    fc(bi.aG(cVar.phj, getString(a$i.wallet_pay_deduct_checkbox_label)), cVar.phh);
                } else {
                    this.eOE.bw("wallet_open_auto_pay", true);
                }
                bOc();
                if (this.eXG != null) {
                    this.eXG.dismiss();
                }
            } else if (lVar instanceof ae) {
                this.pia = ((ae) lVar).pjK;
                this.pie = ((ae) lVar).pjP;
                if (this.pie == 0) {
                    this.eOE.bw("wallet_delay_transfer_date", true);
                    return;
                }
                if (bi.oW(this.pia)) {
                    x.i("MicroMsg.WalletPasswordSettingUI", "use hardcode wording");
                } else {
                    this.phX.setTitle(this.pia);
                }
                this.eOE.bw("wallet_delay_transfer_date", false);
            }
        } else if (lVar instanceof ae) {
            x.i("MicroMsg.WalletPasswordSettingUI", "net error, use hardcode wording");
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.b.a.sFg.c(this.pdx);
        g.Ek();
        g.Eh().dpP.b(385, this);
    }
}
