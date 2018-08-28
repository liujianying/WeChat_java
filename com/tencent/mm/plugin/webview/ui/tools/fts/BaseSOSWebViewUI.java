package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.widget.ImageButton;
import com.tencent.mm.R;
import com.tencent.mm.modelappbrand.s;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.a;
import com.tencent.mm.plugin.webview.fts.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.fts.widget.SOSEditTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseSOSWebViewUI extends BaseSearchWebViewUI implements a {
    protected ImageButton lAV;
    protected View mPT;
    private boolean qcL;
    View qdi;
    protected SOSEditTextView qdj;
    private List<c> qdk;
    protected int qdl = 0;
    private b qdm;
    boolean qdn;
    boolean qdo;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getSupportActionBar().hide();
        this.qdm = new b(this.mController.tml, this.mhH);
    }

    protected void ant() {
        super.ant();
        this.qcL = getIntent().getBooleanExtra("ftsneedkeyboard", false);
        this.qdi = findViewById(R.h.search_input_layout);
        this.qdj = (SOSEditTextView) findViewById(R.h.sos_edittext);
        this.qdj.setFtsEditTextListener(this);
        this.qdj.setHint(getHint());
        this.mPT = findViewById(R.h.cancel_btn);
        this.mPT.setOnClickListener(new 1(this));
        this.lAV = (ImageButton) findViewById(R.h.back_btn);
        this.lAV.setOnClickListener(new 10(this));
        this.mhH.setWebViewClient(new b(this, (byte) 0));
        this.mhH.setOnTouchListener(new 11(this));
        if (this.pZr != null) {
            this.pZr.jY(true);
        }
        this.mhH.setOnLongClickListener(new 12(this));
        this.qdm.pNV = this.pNV;
    }

    protected void onResume() {
        super.onResume();
        this.qdm.onResume();
    }

    protected void onPause() {
        super.onPause();
        this.qdm.onPause();
    }

    public final String getSessionId() {
        return this.bJK;
    }

    protected final void bXd() {
        YC();
        if (this.qdk != null && this.qdk.size() > 1) {
            this.qdk.remove(0);
            c cVar = (c) this.qdk.get(0);
            this.qdj.j(cVar.qdx, cVar.jzp);
            this.handler.post(new 13(this, cVar));
        } else if (this.qdn) {
            bXg();
        } else {
            finish();
        }
    }

    protected void bXe() {
    }

    protected void bXf() {
    }

    protected void bXg() {
        this.qdj.j("", null);
        YC();
        this.handler.post(new 14(this));
        this.qdk = null;
        this.qdn = false;
        this.qdm.onDestroy();
    }

    protected final boolean bWr() {
        return true;
    }

    public final void aQC() {
        if (!this.qdj.jzo.hasFocus()) {
            this.qdj.aQU();
            showVKB();
        }
    }

    protected final boolean bWh() {
        return false;
    }

    protected final int getType() {
        return this.type;
    }

    protected final int aUM() {
        return this.scene;
    }

    public void a(String str, String str2, List<com.tencent.mm.plugin.fts.ui.widget.a.b> list, FTSEditTextView.b bVar) {
        x.i("MicroMsg.FTS.BaseSOSWebViewUI", "onEditTextChange %s %s %s", new Object[]{str, str2, bVar});
        if (bVar == FTSEditTextView.b.jzB || bVar == FTSEditTextView.b.jzC) {
            this.handler.post(new 15(this));
        }
    }

    public void fg(boolean z) {
        if (z && !bi.oW(getTotalQuery())) {
            this.handler.post(new 16(this));
        }
    }

    public void onClickClearTextBtn(View view) {
        if (this.qdj != null) {
            if (!this.qdj.jzo.hasFocus()) {
                this.qdj.aQU();
                showVKB();
            }
            this.qdj.setHint(getHint());
        }
    }

    public String getHint() {
        return null;
    }

    public boolean anx() {
        this.qdj.jzo.clearFocus();
        YC();
        if (getTotalQuery().length() > 0) {
            this.handler.post(new 17(this));
            YC();
            this.qdn = true;
        }
        return true;
    }

    protected void bXh() {
    }

    protected String bXi() {
        return "";
    }

    protected int bXj() {
        return 0;
    }

    public final SOSEditTextView bXk() {
        return this.qdj;
    }

    protected static boolean bXl() {
        return true;
    }

    protected static boolean bXm() {
        return true;
    }

    protected final boolean bWx() {
        return false;
    }

    protected final void bWc() {
        bXd();
    }

    public void onDestroy() {
        try {
            if (this.gcO != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("webview_id", hashCode());
                this.gcO.j(1, bundle);
            }
            this.qdm.onDestroy();
        } catch (RemoteException e) {
        }
        YC();
        super.onDestroy();
    }

    protected void j(int i, Bundle bundle) {
        int i2 = 0;
        String string;
        switch (i) {
            case s$l.AppCompatTheme_popupMenuStyle /*60*/:
                b.bTF();
                s.jp("");
                if (bXq()) {
                    this.qdm.a(bundle, this.scene);
                    return;
                } else {
                    x.w("MicroMsg.FTS.BaseSOSWebViewUI", "current state is not search");
                    return;
                }
            case s$l.AppCompatTheme_popupWindowStyle /*61*/:
                this.qdm.N(bundle);
                return;
            case s$l.AppCompatTheme_editTextColor /*62*/:
                this.qdm.O(bundle);
                return;
            case 119:
                String string2 = bundle.getString("fts_key_json_data");
                String string3 = bundle.getString("fts_key_req_id");
                boolean z = bundle.getBoolean("fts_key_new_query", true);
                this.handler.post(new 3(this, bundle.getBundle("fts_key_data"), string2, z, string3));
                return;
            case 120:
                this.handler.post(new 5(this, bundle.getInt("fts_key_ret", 0), bundle.getString("fts_key_data")));
                return;
            case 121:
                string = bundle.getString("fts_key_json_data");
                this.handler.post(new 6(this, bundle.getInt("fts_key_teach_request_type", 0), string, bundle.getInt("fts_key_is_cache_data", 0)));
                return;
            case 122:
                string = bundle.getString("fts_key_new_query");
                String string4 = bundle.getString("fts_key_custom_query");
                boolean z2 = bundle.getBoolean("fts_key_need_keyboard", false);
                String string5 = bundle.getString("fts_key_tag_list");
                x.i("MicroMsg.FTS.BaseSOSWebViewUI", "onFTSSearchQueryChange: totalQuery: %s isInputChange %b", new Object[]{string, Boolean.valueOf(z2)});
                List arrayList = new ArrayList();
                try {
                    if (!bi.oW(string5)) {
                        JSONArray jSONArray = new JSONArray(string5);
                        while (i2 < jSONArray.length()) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i2);
                            a aVar = new a(this);
                            aVar.qdu = jSONObject.getString("tagName");
                            aVar.qdv = jSONObject.getInt("tagType");
                            aVar.userName = jSONObject.getString("userName");
                            arrayList.add(aVar);
                            i2++;
                        }
                    }
                } catch (Exception e) {
                }
                if (this.qdj != null) {
                    if (arrayList.size() > 0) {
                        this.qdj.j(string4, arrayList);
                    } else {
                        this.qdj.j(string, arrayList);
                        this.qdj.aQY();
                    }
                }
                if (z2) {
                    this.handler.post(new 7(this));
                    if (this.qdj != null) {
                        this.qdj.aQU();
                    }
                    bWz();
                } else if (this.qdj != null) {
                    this.qdj.jzo.clearFocus();
                }
                com.tencent.mm.plugin.webview.fts.b.a.a.bTN();
                com.tencent.mm.plugin.webview.fts.b.a.a.Qg(getTotalQuery());
                return;
            case 124:
                this.handler.post(new 8(this, bundle.getString("fts_key_json_data")));
                return;
            case 125:
                this.handler.post(new 9(this, bundle.getString("fts_key_sns_id"), bundle.getInt("fts_key_status", 0)));
                return;
            case 128:
                bundle.getString("fts_key_json_data");
                bundle.getBoolean("fts_key_new_query", true);
                Map hashMap = new HashMap();
                for (String str : bundle.keySet()) {
                    hashMap.put(str, bundle.get(str));
                }
                this.handler.post(new 2(this, hashMap));
                return;
            case 138:
                string = bundle.getString("fts_key_data");
                if (bi.oW(string)) {
                    this.qdl = 0;
                    return;
                } else if ("index".equals(string)) {
                    this.qdl = 1;
                    return;
                } else if ("result".equals(string)) {
                    this.qdl = 2;
                    return;
                } else if ("suggestion".equals(string)) {
                    this.qdl = 3;
                    return;
                } else if ("teach".equals(string)) {
                    this.qdl = 4;
                    return;
                } else if ("local".equals(string)) {
                    this.qdl = 5;
                    return;
                } else {
                    this.qdl = 0;
                    return;
                }
            case 143:
                this.handler.post(new 4(this, bundle.getString("data")));
                return;
            case 144:
                b.bTF();
                s.jo(bundle.getString("appid"));
                return;
            case 100001:
                this.qdm.M(bundle);
                return;
            default:
                super.j(i, bundle);
                return;
        }
    }

    protected final b bXn() {
        return this.qdm;
    }

    protected final String getTotalQuery() {
        return this.qdj != null ? this.qdj.getTotalQuery() : "";
    }

    protected final int bXo() {
        return this.qdD;
    }

    protected final String getInEditTextQuery() {
        return this.qdj.getInEditTextQuery();
    }

    public final JSONArray bXp() {
        List<com.tencent.mm.plugin.fts.ui.widget.a.b> tagList = this.qdj.getTagList();
        JSONArray jSONArray = new JSONArray();
        for (com.tencent.mm.plugin.fts.ui.widget.a.b bVar : tagList) {
            a aVar = (a) bVar;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("tagName", aVar.qdu);
                jSONObject.put("tagType", aVar.qdv);
                jSONObject.put("userName", aVar.userName);
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
            }
        }
        return jSONArray;
    }

    public void onBackPressed() {
        bXd();
    }

    protected final void b(int i, String str, Map<String, Object> map) {
        c cVar;
        x.v("MicroMsg.FTS.BaseSOSWebViewUI", "adding history cgi params type %d, inEditQuery %s, params %s", new Object[]{Integer.valueOf(i), str, map});
        if (this.qdk == null) {
            this.qdk = new ArrayList();
        }
        if (getTotalQuery().length() > 0) {
            cVar = new c(this);
            cVar.type = this.qdD;
            cVar.jzp = new ArrayList(this.qdj.getTagList());
            cVar.qdx = this.qdj.getInEditTextQuery();
            cVar.qdw = this.qdj.getTotalQuery();
            if (this.qdk.size() == 0) {
                this.qdk.add(cVar);
            } else if (!cVar.equals((c) this.qdk.get(0))) {
                this.qdk.add(0, cVar);
            }
        }
        if (this.qdk != null && !this.qdk.isEmpty()) {
            c cVar2 = (c) this.qdk.get(0);
            cVar = new c(this);
            cVar.type = i;
            cVar.qdw = str;
            cVar.qdy = map;
            if (cVar2 != null) {
                int i2;
                if (cVar2 == cVar) {
                    i2 = 1;
                } else {
                    cVar = cVar;
                    i2 = (cVar.type == cVar2.type && cVar.qdw.trim().equals(cVar2.qdw.trim())) ? 1 : 0;
                }
                if (i2 != 0) {
                    cVar2.qdy = map;
                }
            }
        }
    }

    protected boolean bXq() {
        return true;
    }

    public final String AT(int i) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("key", "educationTab");
            Bundle p = this.gcO.p(2, bundle);
            String string = p.getString("result");
            String string2 = p.getString("result_1");
            if (string2 != null) {
                string = string2;
            }
            JSONArray optJSONArray = new JSONObject(string).optJSONArray("items");
            if (optJSONArray == null) {
                return "";
            }
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject.optInt("businessType") == i) {
                    return optJSONObject.optString("hotword");
                }
            }
            return "";
        } catch (Exception e) {
        }
    }
}
