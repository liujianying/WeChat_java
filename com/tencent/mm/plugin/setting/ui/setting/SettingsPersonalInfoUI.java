package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.aa.o;
import com.tencent.mm.ab.e;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.p.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.a.k;
import com.tencent.mm.plugin.setting.model.g;
import com.tencent.mm.plugin.setting.ui.widget.HeadImgNewPreference;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.io.File;

public class SettingsPersonalInfoUI extends MMPreference implements e, b {
    private boolean eFl;
    private f eOE;
    private g mTg;

    public final int Ys() {
        return k.settings_pref_personal_info_new;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        if (getIntent().getBooleanExtra("intent_set_avatar", false)) {
            this.eFl = getIntent().getBooleanExtra("KEnterFromBanner", false);
            a.ezo.f(this);
        }
        com.tencent.mm.kernel.g.DF().a(1191, this);
    }

    public void onDestroy() {
        x.d("MicroMsg.SettingsPersonalInfoUI", "SettingsPersonalInfoUI.onDestroy()");
        if (com.tencent.mm.kernel.g.Eg().Dx()) {
            com.tencent.mm.kernel.g.Ei().DT().b(this);
        }
        if (this.mTg != null) {
            com.tencent.mm.kernel.g.DF().c(this.mTg);
        }
        com.tencent.mm.kernel.g.DF().b(1191, this);
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(i.settings_personal_info);
        com.tencent.mm.kernel.g.Ei().DT().a(this);
        this.eOE = this.tCL;
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SettingsPersonalInfoUI.this.YC();
                SettingsPersonalInfoUI.this.finish();
                return true;
            }
        });
    }

    public void onResume() {
        btC();
        aut();
        String str = (String) com.tencent.mm.kernel.g.Ei().DT().get(4, null);
        if (str != null && str.length() > 0) {
            this.eOE.ZZ("settings_name").setSummary(j.a(this, str));
        }
        this.eOE.bw("settings_address", bi.fU(this));
        if (bi.d(Boolean.valueOf(com.tencent.mm.kernel.g.Ei().DT().getBoolean(aa.a.sWn, false)))) {
            this.eOE.bw("settings_invoice", false);
        } else {
            this.eOE.bw("settings_invoice", true);
            this.mTg = new g();
            com.tencent.mm.kernel.g.DF().a(this.mTg, 0);
        }
        super.onResume();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.mKey;
        x.d("MicroMsg.SettingsPersonalInfoUI", "key = " + str);
        if (str.equals("settings_change_avatar")) {
            return a.ezo.f(this);
        }
        if (str.equals("settings_username")) {
            if (!bi.oW(q.GG()) || !ab.XU(q.GF())) {
                return true;
            }
            L(SettingsAliasUI.class);
            return true;
        } else if (str.equals("settings_name")) {
            Intent intent = new Intent();
            intent.setClass(this, SettingsModifyNameUI.class);
            startActivity(intent);
            return true;
        } else {
            Intent intent2;
            if (str.equals("settings_qrcode")) {
                h.mEJ.h(11264, new Object[]{Integer.valueOf(2)});
                this.mController.tml.startActivity(new Intent(this, SelfQRCodeUI.class));
            } else if (str.equals("settings_more_info")) {
                startActivity(new Intent(this, SettingsPersonalMoreUI.class));
            } else if (str.equals("settings_address")) {
                intent2 = new Intent();
                intent2.putExtra("launch_from_webview", false);
                d.c(this.mController.tml, "address", ".ui.WalletSelectAddrUI", intent2);
                return true;
            } else if (str.equals("settings_invoice")) {
                h.mEJ.h(14199, new Object[]{Integer.valueOf(1)});
                intent2 = new Intent();
                intent2.putExtra("launch_from_webview", false);
                d.c(this.mController.tml, "address", ".ui.InvoiceListUI", intent2);
                return true;
            }
            return false;
        }
    }

    private void btC() {
        Preference ZZ = this.eOE.ZZ("settings_username");
        CharSequence GG = q.GG();
        CharSequence GF = q.GF();
        if (!bi.oW(GG)) {
            ZZ.setSummary(GG);
        } else if (ab.XT(GF)) {
            ZZ.setSummary(getString(i.settings_notset));
        } else {
            ZZ.setSummary(GF);
        }
    }

    private void aut() {
        HeadImgNewPreference headImgNewPreference = (HeadImgNewPreference) this.eOE.ZZ("settings_change_avatar");
        String GF = q.GF();
        headImgNewPreference.mVR = null;
        if (headImgNewPreference.gwj != null) {
            com.tencent.mm.pluginsdk.ui.a.b.a(headImgNewPreference.gwj, GF);
        } else {
            headImgNewPreference.mVR = GF;
        }
        if (GF == null) {
            headImgNewPreference.mVT = false;
        } else {
            headImgNewPreference.mVT = true;
        }
        headImgNewPreference.mVS = new OnClickListener() {
            public final void onClick(View view) {
                SettingsPersonalInfoUI.this.mController.tml.startActivity(new Intent(SettingsPersonalInfoUI.this, PreviewHdHeadImg.class));
            }
        };
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.SettingsPersonalInfoUI", "onAcvityResult requestCode:%d, resultCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i2 == -1) {
            String d;
            switch (i) {
                case 2:
                    if (intent != null) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("CropImageMode", 1);
                        intent2.putExtra("CropImage_Filter", true);
                        intent2.putExtra("CropImage_OutputPath", com.tencent.mm.aa.q.Kp().c(q.GF() + ".crop", true, false));
                        intent2.putExtra("CropImage_ImgPath", null);
                        com.tencent.mm.plugin.setting.b.ezn.a(this, intent, intent2, c.Gb(), 4, null);
                        return;
                    }
                    return;
                case 3:
                    d = l.d(getApplicationContext(), intent, c.Gb());
                    if (d != null) {
                        Intent intent3 = new Intent();
                        intent3.putExtra("CropImageMode", 1);
                        intent3.putExtra("CropImage_OutputPath", d);
                        intent3.putExtra("CropImage_ImgPath", d);
                        com.tencent.mm.plugin.setting.b.ezn.a(this, intent3, 4);
                        return;
                    }
                    return;
                case 4:
                    new ag(Looper.getMainLooper()).post(new 4(this));
                    if (intent != null) {
                        d = intent.getStringExtra("CropImage_OutputPath");
                        if (d == null) {
                            x.e("MicroMsg.SettingsPersonalInfoUI", "crop picture failed");
                            return;
                        }
                        x.i("MicroMsg.SettingsPersonalInfoUI", "onActivityResult(CONTEXT_MENU_CROP_PICTURE)  file:%s, size:%d", new Object[]{d, Long.valueOf(new File(d).length())});
                        new o(this.mController.tml, d).b(1, new 5(this));
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i == 3 || i == 2 || i == 4) {
            new ag(Looper.getMainLooper()).post(new 3(this));
        }
    }

    public final void a(int i, m mVar, Object obj) {
        x.d("MicroMsg.SettingsPersonalInfoUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(bi.p(obj, 0)), mVar});
        if (mVar != com.tencent.mm.kernel.g.Ei().DT() || r0 <= 0) {
            x.e("MicroMsg.SettingsPersonalInfoUI", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(r0), mVar});
            return;
        }
        btC();
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        if (bi.d(Boolean.valueOf(com.tencent.mm.kernel.g.Ei().DT().getBoolean(aa.a.sWn, false)))) {
            this.eOE.bw("settings_invoice", false);
        } else {
            this.eOE.bw("settings_invoice", true);
        }
    }
}
