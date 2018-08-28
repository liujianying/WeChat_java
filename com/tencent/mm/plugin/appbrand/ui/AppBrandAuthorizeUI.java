package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.v;
import com.tencent.mm.g.a.sl;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.config.t;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.s.m;
import com.tencent.mm.protocal.c.atv;
import com.tencent.mm.protocal.c.cgs;
import com.tencent.mm.protocal.c.cgt;
import com.tencent.mm.protocal.c.eb;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.statusbar.b;
import com.tencent.mm.ui.statusbar.d;
import com.tencent.mm.ui.widget.a.c$a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class AppBrandAuthorizeUI extends MMPreference {
    private String gtX;
    List<eb> gtY = new ArrayList();
    private t gtZ;
    protected f gua;
    private boolean gub = false;
    private boolean guc = true;
    private boolean gud = false;
    private b gue = null;
    private String mAppId;

    static /* synthetic */ void a(AppBrandAuthorizeUI appBrandAuthorizeUI, String str, List list) {
        LinkedList linkedList = new LinkedList();
        for (eb ebVar : list) {
            atv atv = new atv();
            atv.mOL = ebVar.scope;
            atv.mOM = ebVar.state;
            linkedList.add(atv);
        }
        a aVar = new a();
        aVar.dIG = new cgs();
        aVar.dIH = new cgt();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp_modauth";
        aVar.dIF = 1188;
        aVar.dII = 0;
        aVar.dIJ = 0;
        cgs cgs = new cgs();
        cgs.appId = str;
        cgs.sAR = linkedList;
        aVar.dIG = cgs;
        v.a(aVar.KT(), new 8(appBrandAuthorizeUI, list), true);
    }

    static /* synthetic */ void b(AppBrandAuthorizeUI appBrandAuthorizeUI, List list) {
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                eb ebVar = (eb) list.get(i);
                if ("scope.subscribemsg".equals(ebVar.scope)) {
                    boolean z = ebVar.state == 2;
                    sl slVar = new sl();
                    slVar.cdl.bGy = appBrandAuthorizeUI.gtX;
                    slVar.cdl.action = z ? 1 : 2;
                    slVar.cdl.cdn = 1;
                    com.tencent.mm.sdk.b.a.sFg.m(slVar);
                    x.i("MicroMsg.AppBrandAuthorizeUI", "updateSubscribeMsgItem banMsg:%b", new Object[]{Boolean.valueOf(z)});
                    return;
                }
            }
        }
    }

    public final int Ys() {
        return m.app_brand_authorize_pref;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setBackBtn(new 1(this));
        setMMTitle(j.app_brand_authorize_settings);
        this.gua = this.tCL;
        String stringExtra = getIntent().getStringExtra("key_username");
        this.gtX = stringExtra;
        if (bi.oW(stringExtra)) {
            finish();
            return;
        }
        this.gud = getIntent().getBooleanExtra("key_app_authorize_jsapi", false);
        this.gtZ = q.rT(this.gtX);
        if (this.gtZ == null) {
            x.e("MicroMsg.AppBrandAuthorizeUI", "AppBrandBizInfo is Null");
            return;
        }
        this.mAppId = this.gtZ.appId;
        c.Em().H(new 3(this));
        lF(this.mController.cqm());
    }

    protected void initSwipeBack() {
        super.initSwipeBack();
        if (getSwipeBackLayout() != null && getSwipeBackLayout().getChildCount() > 0) {
            View childAt = getSwipeBackLayout().getChildAt(0);
            getSwipeBackLayout().removeView(childAt);
            this.gue = new b(this);
            this.gue.addView(childAt, new LayoutParams(-1, -1));
            getSwipeBackLayout().addView(this.gue);
            getSwipeBackLayout().setContentView(this.gue);
        }
    }

    public final void lF(int i) {
        super.lF(i);
        if (VERSION.SDK_INT >= 21 && getWindow() != null && getWindow().getStatusBarColor() != 0) {
            com.tencent.mm.ui.statusbar.a.c(this.mController.contentView, getWindow().getStatusBarColor(), d.c(getWindow()));
        }
    }

    public final boolean a(final f fVar, final Preference preference) {
        x.d("MicroMsg.AppBrandAuthorizeUI", "onPreferenceTreeClcik.(key : %s)", new Object[]{preference.mKey});
        if (this.gtY == null) {
            x.w("MicroMsg.AppBrandAuthorizeUI", "mAuthItem == null");
        } else {
            String str = preference.mKey;
            if (bi.oW(str)) {
                x.e("MicroMsg.AppBrandAuthorizeUI", "key is null");
            } else {
                for (final eb ebVar : this.gtY) {
                    if (str.equals(bi.oV(ebVar.scope))) {
                        this.gub = true;
                        if (((CheckBoxPreference) preference).isChecked()) {
                            ebVar.state = 1;
                        } else if (this.guc) {
                            this.guc = false;
                            c$a c_a = new c$a(this);
                            c_a.abu(getString(j.app_brand_auth_close_tips));
                            c_a.abx(getString(j.app_brand_auth_close_auth));
                            c_a.a(new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    ebVar.state = 2;
                                    x.d("MicroMsg.AppBrandAuthorizeUI", "set authItem.state close");
                                }
                            });
                            c_a.aby(getString(j.app_cancel));
                            c_a.b(new 5(this, ebVar, preference, fVar));
                            c_a.e(new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                    x.d("MicroMsg.AppBrandAuthorizeUI", "on cancel click!");
                                    ebVar.state = 1;
                                    ((CheckBoxPreference) preference).qpJ = true;
                                    fVar.notifyDataSetChanged();
                                }
                            });
                            com.tencent.mm.ui.widget.a.c anj = c_a.anj();
                            anj.setCanceledOnTouchOutside(false);
                            anj.show();
                        } else {
                            ebVar.state = 2;
                        }
                    }
                }
            }
        }
        return false;
    }

    private void da(boolean z) {
        runOnUiThread(new 9(this, z));
    }

    protected void onPause() {
        if (this.gub) {
            x.d("MicroMsg.AppBrandAuthorizeUI", "onPause key change!");
            ah.A(new Runnable() {
                public final void run() {
                    if (AppBrandAuthorizeUI.this.gub) {
                        AppBrandAuthorizeUI.this.gub = false;
                        AppBrandAuthorizeUI.a(AppBrandAuthorizeUI.this, AppBrandAuthorizeUI.this.mAppId, AppBrandAuthorizeUI.this.gtY);
                    }
                }
            });
        }
        super.onPause();
    }

    public void onBackPressed() {
        x.d("MicroMsg.AppBrandAuthorizeUI", "onBackPressed !");
        ank();
        super.onBackPressed();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    private void ank() {
        if (this.gud) {
            JSONArray jSONArray = new JSONArray();
            for (eb ebVar : this.gtY) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("scope", ebVar.scope);
                    jSONObject.put("state", ebVar.state);
                    jSONObject.put("desc", ebVar.rep);
                    jSONArray.put(jSONObject);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.AppBrandAuthorizeUI", e, "", new Object[0]);
                }
            }
            x.d("MicroMsg.AppBrandAuthorizeUI", "authInfo %s", new Object[]{jSONArray});
            Intent intent = new Intent();
            intent.putExtra("key_app_authorize_state", jSONArray.toString());
            setResult(-1, intent);
        }
    }
}
