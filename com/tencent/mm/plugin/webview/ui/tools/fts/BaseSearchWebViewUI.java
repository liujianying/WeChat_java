package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.modelappbrand.l;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import com.tencent.mm.plugin.websearch.api.o;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.plugin.webview.fts.c.b.a;
import com.tencent.mm.plugin.webview.fts.c.b.b;
import com.tencent.mm.plugin.webview.model.aa;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.32;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.36;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class BaseSearchWebViewUI extends LoadDataWebviewUI implements b {
    protected String bWm;
    protected String fuu;
    private View gmj;
    private com.tencent.mm.plugin.webview.fts.c.b qdA;
    private Set<a> qdB = new HashSet();
    protected int qdC;
    protected int qdD;
    protected String qdE;
    protected List<Runnable> qdF;
    protected boolean qdz;
    protected int scene;
    protected int type;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null) {
            this.qdz = getIntent().getBooleanExtra("jumpto_sns_contact_page", false);
        }
        this.qdA = new com.tencent.mm.plugin.webview.fts.c.b(this.mController.tml, this.mhH, this);
        this.scene = getIntent().getIntExtra("ftsbizscene", 0);
        this.qdC = this.scene;
        this.type = getIntent().getIntExtra("ftsType", 0);
        this.bWm = getIntent().getStringExtra("ftsQuery");
        this.qdE = getIntent().getStringExtra("tabId");
        this.fuu = getIntent().getStringExtra("searchId");
        this.qdD = this.type;
        int i = this.scene;
        String str = this.bJK;
        String str2 = this.bWr;
        boolean z = this.type == 0;
        o.a(1, i, str, str2, this.fuu, 0, z, "", true, this.bWm, this.qdE, this.type, this.qeP);
        if (p.j(this, this.scene)) {
            x.i("BaseSearchWebViewUI", "has location permission");
        } else {
            x.i("BaseSearchWebViewUI", "request for grant location permission");
        }
    }

    protected final void bXr() {
        boolean z;
        super.bXr();
        int i = this.scene;
        String str = this.bJK;
        String str2 = this.bWr;
        if (this.type == 0) {
            z = true;
        } else {
            z = false;
        }
        String str3 = "";
        String str4 = "";
        o.a(12, i, str, str2, str3, 0, z, str4, true, this.bWm, this.qdE, this.type, this.qeP);
    }

    public void ant() {
        super.ant();
        this.qdA.pNV = this.pNV;
        if (this.pNV == null || this.pNV.qhq) {
            bXs();
            x.d("BaseSearchWebViewUI", "jsapi ready");
        } else {
            this.pNV.a(new d.a() {
                public final void onReady() {
                    BaseSearchWebViewUI.this.bXs();
                    x.d("BaseSearchWebViewUI", "jsapi ready");
                    int i = BaseSearchWebViewUI.this.scene;
                    String str = BaseSearchWebViewUI.this.bJK;
                    str = BaseSearchWebViewUI.this.bWr;
                }
            });
        }
        if (this.gcO != null) {
            try {
                this.gcO.g(51, new Bundle());
                return;
            } catch (Throwable e) {
                x.printErrStackTrace("BaseSearchWebViewUI", e, "", new Object[0]);
                return;
            }
        }
        x.i("BaseSearchWebViewUI", "invoker is null, fail to invoke get geo");
    }

    private void bXs() {
        if (this.qdF != null && !this.qdF.isEmpty()) {
            x.i("BaseSearchWebViewUI", "jsapi ready callback, running jsapi count %d", new Object[]{Integer.valueOf(new ArrayList(this.qdF).size())});
            this.qdF.clear();
            for (Runnable runnable : r0) {
                if (runnable != null) {
                    runnable.run();
                }
            }
        }
    }

    public final void a(a aVar) {
        this.qdB.add(aVar);
    }

    protected void b(int i, String str, Map<String, Object> map) {
    }

    public void j(int i, Bundle bundle) {
        com.tencent.mm.plugin.webview.fts.c.b bVar;
        switch (i) {
            case 133:
                Z(bundle);
                return;
            case 134:
                com.tencent.mm.ui.widget.a.d dVar = (com.tencent.mm.ui.widget.a.d) com.tencent.mm.plugin.webview.fts.a.bTE().pNK.remove(Integer.valueOf(bundle.getInt("actionSheetId")));
                if (dVar != null) {
                    dVar.bzW();
                    return;
                }
                return;
            case 135:
                b(bundle.getInt("FTS_KEY_onStartWebSearch_type", 0), bundle.getString("FTS_KEY_onStartWebSearch_query"), (Map) bundle.getSerializable("FTS_KEY_onStartWebSearch_params"));
                return;
            case 137:
                String string = bundle.getString("fts_key_json_data");
                if (this.pNV != null) {
                    try {
                        d dVar2 = this.pNV;
                        ah.A(new 32(dVar2, i.a.a("onGetMatchContactList", new JSONObject(string), dVar2.qhs, dVar2.qht)));
                        return;
                    } catch (Throwable e) {
                        x.printErrStackTrace("BaseSearchWebViewUI", e, "", new Object[0]);
                        return;
                    }
                }
                return;
            case c.CTRL_INDEX /*145*/:
                d dVar3 = this.pNV;
                if (dVar3.qhq) {
                    x.i("MicroMsg.JsApiHandler", "onGetPoiInfo success, ready");
                    Map hashMap = new HashMap();
                    hashMap.put("json", bundle.getString("json"));
                    hashMap.put("searchId", bundle.getString("searchId"));
                    hashMap.put("poiId", bundle.getString("poiId"));
                    ah.A(new 36(dVar3, i.a.a("onGetPoiInfoReturn", hashMap, dVar3.qhs, dVar3.qht)));
                    return;
                }
                x.e("MicroMsg.JsApiHandler", "onGetPoiInfo fail, not ready");
                return;
            case 100002:
                com.tencent.mm.plugin.webview.fts.b bXn = bXn();
                if (bXn != null) {
                    int i2 = bundle.getInt("x", -1);
                    int i3 = bundle.getInt("y", -1);
                    String string2 = bundle.getString("widgetId");
                    String string3 = bundle.getString("eventId");
                    x.v("FTSSearchWidgetMgr", "tapSearchWAWidgetView x %d, y %d, widgetId %s, eventId %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), string2, string3});
                    View view = (View) bXn.pNP.get(string2);
                    if (view != null) {
                        boolean z;
                        l bC = bXn.pNU.bC(view);
                        com.tencent.mm.plugin.webview.fts.a.a.b bVar2 = new com.tencent.mm.plugin.webview.fts.a.a.b(i2, i3, string3);
                        if (bC == null) {
                            x.e("BaseJsapiEvent", "null JSBridgeAccessible ");
                            z = false;
                        } else {
                            z = bC.Y(bVar2.getName(), bVar2.bTM());
                        }
                        if (!z) {
                            x.i("FTSSearchWidgetMgr", "onTap fail: exec js event %s ", new Object[]{string2});
                            bXn.pNV.a(string3, false, "onTap fail: exec js event  " + string2, string2);
                            return;
                        }
                        return;
                    }
                    x.i("FTSSearchWidgetMgr", "onTap fail: can not find Widget by widgetId %s", new Object[]{string2});
                    bXn.pNV.a(string3, false, "onTap fail: can not find Widget by widgetId " + string2, string2);
                    return;
                }
                x.e("BaseSearchWebViewUI", "can not find FTSSearchWidgetMgr to handle tapSearchWAWidgetView");
                this.pNV.a(bundle.getString(""), false, "can not find FTSSearchWidgetMgr to handle tapSearchWAWidgetView", bundle.getString("widgetId"));
                return;
            case 200000:
                bVar = this.qdA;
                if (bVar != null) {
                    bVar.w(Y(bundle), bundle.getString("viewProps"), bundle.getString("videoProps"));
                    return;
                }
                return;
            case 200001:
                bVar = this.qdA;
                if (bVar != null) {
                    bVar.x(Y(bundle), bundle.getString("viewProps"), bundle.getString("videoProps"));
                    return;
                }
                return;
            case 200002:
                bVar = this.qdA;
                if (bVar != null) {
                    bVar.Ak(Y(bundle));
                    return;
                }
                return;
            case 200003:
                bVar = this.qdA;
                if (bVar != null) {
                    bVar.aT(Y(bundle), bundle.getString("type"));
                    return;
                }
                return;
            default:
                super.j(i, bundle);
                return;
        }
    }

    protected com.tencent.mm.plugin.webview.fts.b bXn() {
        return null;
    }

    private static int Y(Bundle bundle) {
        return bi.WU(bundle.getString("playerId"));
    }

    private void Z(Bundle bundle) {
        List arrayList = new ArrayList();
        CharSequence string = bundle.getString("title");
        CharSequence string2 = bundle.getString("desc");
        try {
            JSONArray jSONArray = new JSONArray(bundle.getString("items"));
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    boolean z;
                    aa aaVar = new aa();
                    aaVar.iconUrl = optJSONObject.optString("icon");
                    aaVar.title = optJSONObject.optString("title");
                    if (optJSONObject.optInt("selected") == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    aaVar.eQK = z;
                    aaVar.desc = optJSONObject.optString("desc");
                    arrayList.add(aaVar);
                }
            }
        } catch (Throwable e) {
            x.e("BaseSearchWebViewUI", bi.i(e));
        }
        x.v("BaseSearchWebViewUI", "doShowSearchActionSheet args: title %s,subTitle %s,items %s", new Object[]{string, string2, r7});
        if (!arrayList.isEmpty()) {
            com.tencent.mm.plugin.webview.fts.a bTE = com.tencent.mm.plugin.webview.fts.a.bTE();
            AnonymousClass2 anonymousClass2 = new com.tencent.mm.plugin.webview.fts.a.a() {
                public final void eh(int i, int i2) {
                    if (BaseSearchWebViewUI.this.pNV != null) {
                        d c = BaseSearchWebViewUI.this.pNV;
                        if (c.qhq) {
                            x.i("MicroMsg.JsApiHandler", "onSearchActionSheetClick success, ready");
                            Map hashMap = new HashMap();
                            hashMap.put("index", Integer.valueOf(i));
                            hashMap.put("actionSheetId", Integer.valueOf(i2));
                            ah.A(new d$30(c, i.a.a("onSearchActionSheetClick", hashMap, c.qhs, c.qht)));
                            return;
                        }
                        x.e("MicroMsg.JsApiHandler", "onSearchActionSheetClick fail, not ready");
                    }
                }
            };
            com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(this, 2, true);
            int hashCode = dVar.hashCode();
            dVar.uAx = new a$1(bTE, arrayList);
            dVar.ofp = new a$2(bTE, arrayList, dVar);
            dVar.ofq = new a$3(bTE, anonymousClass2, hashCode);
            dVar.uJQ = new a$4(bTE, anonymousClass2, hashCode);
            View inflate = View.inflate(this, R.i.search_action_sheet_title, null);
            if (TextUtils.isEmpty(string)) {
                inflate.findViewById(R.h.title).setVisibility(8);
            } else {
                ((TextView) inflate.findViewById(R.h.title)).setText(string);
            }
            if (TextUtils.isEmpty(string2)) {
                inflate.findViewById(R.h.sub_title).setVisibility(8);
            } else {
                ((TextView) inflate.findViewById(R.h.sub_title)).setText(string2);
            }
            dVar.uKi = true;
            dVar.dS(inflate);
            dVar.bXO();
            bTE.pNK.put(Integer.valueOf(hashCode), dVar);
            bundle.putInt("actionSheetId", hashCode);
        }
    }

    protected void onResume() {
        super.onResume();
        for (a agL : this.qdB) {
            agL.agL();
        }
    }

    protected void onPause() {
        super.onPause();
        for (a agK : this.qdB) {
            agK.agK();
        }
    }

    public void onDestroy() {
        boolean z;
        super.onDestroy();
        for (a onDestroy : this.qdB) {
            onDestroy.onDestroy();
        }
        this.qdB.clear();
        int i = this.scene;
        String str = this.bJK;
        String str2 = this.bWr;
        if (this.type == 0) {
            z = true;
        } else {
            z = false;
        }
        o.a(14, i, str, str2, "", 0, z, "", true, this.bWm, "", this.type, this.qeP);
        x.d("BaseSearchWebViewUI", "onDestroy");
    }

    public final void k(View view, boolean z) {
        bTT();
        this.gmj = view;
        ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
        viewGroup.addView(view, new LayoutParams(-1, -1));
        view.setX(0.0f);
        view.setY(0.0f);
        if (com.tencent.mm.compatible.util.d.fS(19)) {
            viewGroup.setSystemUiVisibility(2);
        } else {
            viewGroup.setSystemUiVisibility(4098);
        }
        getWindow().addFlags(1024);
        if (z) {
            setRequestedOrientation(0);
        }
    }

    public final void bTT() {
        if (this.gmj != null) {
            ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
            viewGroup.setSystemUiVisibility(0);
            viewGroup.removeView(this.gmj);
            getWindow().clearFlags(1024);
            if (getRequestedOrientation() == 0) {
                setRequestedOrientation(1);
            }
            this.gmj = null;
            for (a ajd : this.qdB) {
                ajd.ajd();
            }
        }
    }

    public void onBackPressed() {
        int i;
        int i2 = 0;
        Iterator it = this.qdB.iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            i2 = ((a) it.next()).agV() | i;
        }
        if (i == 0) {
            super.onBackPressed();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 25) {
            for (a bIu : this.qdB) {
                bIu.bIu();
            }
        } else if (i == 24) {
            for (a bIu2 : this.qdB) {
                bIu2.bTS();
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    protected final void I(Runnable runnable) {
        if (this.pNV == null || !this.pNV.qhq) {
            x.i("BaseSearchWebViewUI", "jsapi not ready, waiting");
            if (this.qdF == null) {
                this.qdF = new ArrayList();
            }
            this.qdF.add(runnable);
            return;
        }
        runnable.run();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("BaseSearchWebViewUI", "onRequestPermissionsResult, granted ? %d", new Object[]{Integer.valueOf(iArr[0])});
    }
}
