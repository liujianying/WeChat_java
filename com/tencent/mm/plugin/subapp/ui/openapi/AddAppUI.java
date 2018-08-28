package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class AddAppUI extends MMPreference implements e {
    private f eOE;
    private AppPreference osA;
    private AppPreference osz;

    static /* synthetic */ void f(com.tencent.mm.pluginsdk.model.app.f fVar) {
        fVar.field_status = 0;
        fVar.field_modifyTime = System.currentTimeMillis();
        ao.bmf().a(fVar, new String[0]);
    }

    public final int Ys() {
        return R.o.addapp_pref;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected void onResume() {
        super.onResume();
        initView();
        if (this.osz != null) {
            this.osz.onResume();
        }
        if (this.osA != null) {
            this.osA.onResume();
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.osz != null) {
            this.osz.onPause();
        }
        if (this.osA != null) {
            this.osA.onPause();
        }
    }

    protected final void initView() {
        setMMTitle(R.l.addapp_add_app);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AddAppUI.this.finish();
                return true;
            }
        });
        this.eOE = this.tCL;
        this.eOE.removeAll();
        this.eOE.addPreferencesFromResource(R.o.addapp_pref);
        this.osz = (AppPreference) this.eOE.ZZ("addapp_added");
        this.osz.osD = 1;
        this.osz.osG = new 2(this);
        this.osz.osH = new 3(this);
        this.osA = (AppPreference) this.eOE.ZZ("addapp_available");
        this.osA.osD = 0;
        this.osA.osG = new 4(this);
    }

    public final boolean a(f fVar, Preference preference) {
        if (!preference.mKey.equals("addapp_recommend")) {
            return false;
        }
        SharedPreferences sharedPreferences = this.mController.tml.getSharedPreferences(ad.chY(), 0);
        ActionBarActivity actionBarActivity = this.mController.tml;
        String d = w.d(sharedPreferences);
        String string = getString(R.l.addapp_recommend_url, new Object[]{Integer.valueOf(d.qVN), d, w.chO()});
        Intent intent = new Intent();
        intent.putExtra("rawUrl", string);
        com.tencent.mm.bg.d.b(this, "webview", ".ui.tools.WebViewUI", intent);
        return true;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.AddAppUI", "onSceneEnd, errType = " + i + ", errCode = " + i2);
        if (i != 0 || i2 != 0) {
            x.e("MicroMsg.AddAppUI", "onSceneEnd, errType = " + i + ", errCode = " + i2);
        }
    }
}
