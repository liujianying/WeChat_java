package com.tencent.mm.plugin.subapp.ui.openapi;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import com.tencent.mm.R;
import com.tencent.mm.aq.h;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class AppProfileUI extends MMPreference implements a {
    private f eOE;
    private ag handler = null;
    private com.tencent.mm.pluginsdk.model.app.f jUo;
    private AppHeaderPreference$a osN;

    public final int Ys() {
        return R.o.app_profile;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected void onResume() {
        super.onResume();
        ao.bmf().c(this);
    }

    protected void onPause() {
        ao.bmf().d(this);
        super.onPause();
    }

    protected final void initView() {
        boolean z = true;
        this.osN = new AppHeaderPreference$a() {
            public final String bGw() {
                return g.b(AppProfileUI.this.mController.tml, AppProfileUI.this.jUo, null);
            }

            public final Bitmap bGx() {
                return g.b(AppProfileUI.this.jUo.field_appId, 1, com.tencent.mm.bp.a.getDensity(AppProfileUI.this));
            }

            public final String ix(boolean z) {
                return AppProfileUI.this.mController.tml.getString(z ? R.l.settings_plugins_installed : R.l.settings_plugins_uninstalled);
            }

            public final String getHint() {
                ActionBarActivity actionBarActivity = AppProfileUI.this.mController.tml;
                com.tencent.mm.pluginsdk.model.app.f a = AppProfileUI.this.jUo;
                if (actionBarActivity == null || a == null) {
                    return null;
                }
                String eS = g.eS(actionBarActivity);
                if (eS.equalsIgnoreCase("zh_CN")) {
                    return a.field_appDiscription;
                }
                return (eS.equalsIgnoreCase("zh_TW") || eS.equalsIgnoreCase("zh_HK")) ? bi.oW(a.field_appDiscription_tw) ? a.field_appDiscription : a.field_appDiscription_tw : eS.equalsIgnoreCase("en") ? bi.oW(a.field_appDiscription_en) ? a.field_appDiscription : a.field_appDiscription_en : bi.oW(a.field_appDiscription_en) ? a.field_appDiscription : a.field_appDiscription_en;
            }
        };
        this.jUo = g.bl(getIntent().getStringExtra("AppProfileUI_AppId"), true);
        String str = "initView : appInfo does not exist";
        if (this.jUo == null) {
            z = false;
        }
        Assert.assertTrue(str, z);
        setMMTitle(R.l.app_profile_title);
        this.eOE = this.tCL;
        setBackBtn(new 2(this));
        refresh();
    }

    private void refresh() {
        boolean z;
        boolean z2 = true;
        this.eOE.removeAll();
        this.eOE.addPreferencesFromResource(R.o.app_profile);
        if (this.jUo.field_status == 1) {
            this.eOE.aaa("app_profile_add");
        } else {
            this.eOE.aaa("app_profile_remove");
        }
        AppHeaderPreference appHeaderPreference = (AppHeaderPreference) this.eOE.ZZ("app_profile_header");
        AppHeaderPreference$a appHeaderPreference$a = this.osN;
        if (this.jUo.field_status == 1) {
            z = true;
        } else {
            z = false;
        }
        if (appHeaderPreference$a == null) {
            z2 = false;
        }
        Assert.assertTrue(z2);
        appHeaderPreference.osE = appHeaderPreference$a;
        appHeaderPreference.ccZ = z;
    }

    private void bGy() {
        this.handler = new 3(this);
        this.handler.sendEmptyMessageDelayed(0, 30);
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.mKey;
        x.i("MicroMsg.AppProfileUI", str + " item has been clicked!");
        if (str.equals("app_profile_add")) {
            this.jUo.field_status = 1;
            this.jUo.field_modifyTime = System.currentTimeMillis();
            ao.bmf().a(this.jUo, new String[0]);
            refresh();
            a(this.jUo, true);
            bGy();
            return true;
        } else if (!str.equals("app_profile_remove")) {
            return false;
        } else {
            this.jUo.field_status = 0;
            this.jUo.field_modifyTime = System.currentTimeMillis();
            ao.bmf().a(this.jUo, new String[0]);
            refresh();
            a(this.jUo, false);
            bGy();
            return true;
        }
    }

    public final void a(String str, l lVar) {
        if (str.equals(this.jUo.field_appId)) {
            initView();
        }
    }

    private static void a(com.tencent.mm.pluginsdk.model.app.f fVar, boolean z) {
        List linkedList = new LinkedList();
        linkedList.add(new h.a(10165, fVar.field_appId + "," + (z ? "1" : "2")));
        au.HU();
        c.FQ().b(new h(linkedList));
    }
}
