package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.modelappbrand.s;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView$a;
import com.tencent.mm.plugin.fts.ui.widget.a.a;
import com.tencent.mm.plugin.webview.fts.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FTSBaseWebViewUI extends BaseSearchWebViewUI implements FTSEditTextView$a, a {
    public com.tencent.mm.plugin.fts.ui.widget.a jwl;
    private boolean qcL;
    private boolean qdH;
    private b qdm;
    int scene;
    int type;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.qdm = new b(this.mController.tml, this.mhH);
        lF(this.mController.tml.getResources().getColor(R.e.normal_actionbar_color));
    }

    public void ant() {
        super.ant();
        String trim = bi.aG(getIntent().getStringExtra("ftsQuery"), "").trim();
        this.type = getIntent().getIntExtra("ftsType", 0);
        this.scene = getIntent().getIntExtra("ftsbizscene", 0);
        this.qcL = getIntent().getBooleanExtra("ftsneedkeyboard", false);
        this.qdH = getIntent().getBooleanExtra("ftscaneditable", true);
        this.mhH.setWebViewClient(new b(this, (byte) 0));
        this.mhH.setOnTouchListener(new 1(this));
        if (this.qdH) {
            this.jwl = new com.tencent.mm.plugin.fts.ui.widget.a(this);
            this.jwl.setSearchViewListener(this);
            this.jwl.getFtsEditText().setHint(getHint());
            this.jwl.getFtsEditText().setFtsEditTextListener(this);
            getSupportActionBar().setCustomView(this.jwl);
            if (!bi.oW(trim)) {
                this.jwl.getFtsEditText().j(trim, null);
            }
            if (this.qcL) {
                this.jwl.getFtsEditText().aQU();
                this.jwl.getFtsEditText().aQT();
            }
        }
        showOptionMenu(false);
        if (this.pZr != null) {
            this.pZr.jY(true);
        }
        this.mhH.setOnLongClickListener(new 6(this));
        this.qdm.pNV = this.pNV;
    }

    private void bXd() {
        YC();
        finish();
        overridePendingTransition(0, 0);
    }

    protected final int bWg() {
        return R.k.actionbar_icon_dark_back;
    }

    protected final boolean bWr() {
        return true;
    }

    protected final String getTotalQuery() {
        return this.jwl.getFtsEditText().getTotalQuery();
    }

    protected final String getInEditTextQuery() {
        return this.jwl.getFtsEditText().getInEditTextQuery();
    }

    protected final boolean bWh() {
        return false;
    }

    public void onClickBackBtn(View view) {
        bXd();
    }

    public final void aQC() {
        if (!this.jwl.getFtsEditText().jzo.hasFocus()) {
            this.jwl.getFtsEditText().aQU();
            showVKB();
        }
    }

    protected void onResume() {
        super.onResume();
        this.qdm.onResume();
    }

    protected void onPause() {
        super.onPause();
        this.qdm.onPause();
    }

    public void a(String str, String str2, List<com.tencent.mm.plugin.fts.ui.widget.a.b> list, FTSEditTextView.b bVar) {
        x.i("MicroMsg.FTS.FTSBaseWebViewUI", "onEditTextChange %s %s %s", new Object[]{str, str2, bVar});
        if (bVar == FTSEditTextView.b.jzB || bVar == FTSEditTextView.b.jzC) {
            this.handler.post(new 7(this));
        }
    }

    public final void fg(boolean z) {
        if (z) {
            this.handler.post(new 8(this));
        }
    }

    public void onClickClearTextBtn(View view) {
        if (this.jwl != null) {
            if (!this.jwl.getFtsEditText().jzo.hasFocus()) {
                this.jwl.getFtsEditText().aQU();
                showVKB();
            }
            this.jwl.getFtsEditText().setHint(getHint());
        }
    }

    public boolean anx() {
        x.i("MicroMsg.FTS.FTSBaseWebViewUI", "onSearchKeyDown");
        if (getTotalQuery().length() > 0) {
            this.handler.post(new 9(this));
            YC();
        }
        return false;
    }

    public final JSONArray bXp() {
        List<com.tencent.mm.plugin.fts.ui.widget.a.b> tagList = this.jwl.getFtsEditText().getTagList();
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

    public void j(int i, Bundle bundle) {
        int i2 = 0;
        String string;
        String string2;
        switch (i) {
            case 60:
                b.bTF();
                s.jp("");
                this.qdm.a(bundle, this.scene);
                return;
            case 61:
                this.qdm.N(bundle);
                return;
            case 62:
                this.qdm.O(bundle);
                return;
            case 119:
                string = bundle.getString("fts_key_json_data");
                string2 = bundle.getString("fts_key_req_id");
                this.handler.post(new 11(this, string, bundle.getBoolean("fts_key_new_query", true), string2));
                return;
            case 120:
                i2 = bundle.getInt("fts_key_ret", 0);
                string2 = bundle.getString("fts_key_data");
                this.handler.post(new Runnable() {
                    public final void run() {
                        if (FTSBaseWebViewUI.this.pNV != null) {
                            FTSBaseWebViewUI.this.pNV.aV(i2, string2);
                        }
                    }
                });
                return;
            case 121:
                string2 = bundle.getString("fts_key_json_data");
                this.handler.post(new 13(this, bundle.getInt("fts_key_teach_request_type", 0), string2, bundle.getInt("fts_key_is_cache_data", 0)));
                return;
            case 122:
                string2 = bundle.getString("fts_key_new_query");
                String string3 = bundle.getString("fts_key_custom_query");
                boolean z = bundle.getBoolean("fts_key_need_keyboard", false);
                String string4 = bundle.getString("fts_key_tag_list");
                x.i("MicroMsg.FTS.FTSBaseWebViewUI", "onFTSSearchQueryChange: totalQuery: %s isInputChange %b", new Object[]{string2, Boolean.valueOf(z)});
                List arrayList = new ArrayList();
                try {
                    if (!bi.oW(string4)) {
                        JSONArray jSONArray = new JSONArray(string4);
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
                if (this.jwl != null) {
                    if (arrayList.size() > 0) {
                        this.jwl.getFtsEditText().j(string3, arrayList);
                    } else {
                        this.jwl.getFtsEditText().j(string2, arrayList);
                    }
                }
                if (z) {
                    this.handler.post(new 2(this));
                    if (this.jwl != null) {
                        this.jwl.getFtsEditText().aQU();
                    }
                    bWz();
                    return;
                } else if (this.jwl != null) {
                    this.jwl.getFtsEditText().jzo.clearFocus();
                    return;
                } else {
                    return;
                }
            case 124:
                this.handler.post(new 3(this, bundle.getString("fts_key_json_data")));
                return;
            case 125:
                this.handler.post(new 4(this, bundle.getString("fts_key_sns_id"), bundle.getInt("fts_key_status", 0)));
                return;
            case 128:
                bundle.getString("fts_key_json_data");
                bundle.getBoolean("fts_key_new_query", true);
                Map hashMap = new HashMap();
                for (String string5 : bundle.keySet()) {
                    hashMap.put(string5, bundle.get(string5));
                }
                this.handler.post(new 10(this, hashMap));
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

    public String getHint() {
        return null;
    }

    protected final int getLayoutId() {
        return R.i.fts_webview_ui;
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

    public void onClickCancelBtn(View view) {
        this.jwl.getFtsEditText().j("", null);
        this.handler.post(new 5(this));
        this.jwl.getFtsEditText().jzo.clearFocus();
        YC();
    }
}
