package com.tencent.mm.plugin.webview.ui.tools.emojistore;

import android.os.Bundle;
import android.view.Menu;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.56;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.tools.o.b;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.HashMap;
import java.util.Map;

public class BaseEmojiStoreSearchWebViewUI extends WebViewUI implements b {
    String bWm;
    private o hol;
    private boolean qcL;
    private boolean qcM = true;
    private int qcN;
    private int type;

    protected final void ant() {
        super.ant();
        this.bWm = getIntent().getStringExtra("keyword");
        this.type = getIntent().getIntExtra(DownloadSettingTable$Columns.TYPE, 0);
        this.qcL = getIntent().getBooleanExtra("showkeyboard", false);
        this.qcN = getIntent().getIntExtra("sence", 0);
        this.mhH.setWebViewClient(new a(this, (byte) 0));
        this.mhH.setOnTouchListener(new 1(this));
        this.hol = new o();
        a(this.hol);
        this.hol.mv(false);
        this.hol.uBw = this;
        showOptionMenu(false);
        if (this.pZr != null) {
            this.pZr.jY(true);
        }
        this.mhH.setOnLongClickListener(new 2(this));
    }

    public final void WX() {
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.hol != null) {
            this.hol.a(this, menu);
            this.hol.setHint(getString(R.l.emoji_search_hit));
        }
        return true;
    }

    public final void WW() {
        finish();
    }

    public final void pk(String str) {
        if (this.qcM && bi.oW(str)) {
            this.qcM = false;
            if (this.qcL) {
                this.hol.czv();
                showVKB();
                return;
            }
            ah.i(new 3(this), 500);
        }
    }

    public final boolean pj(String str) {
        if (str != null) {
            str = str.trim();
        }
        this.bWm = str;
        if (!bi.oW(str)) {
            this.bWm = str;
            this.handler.post(new 4(this));
            Bundle bundle = new Bundle();
            bundle.putInt(DownloadSettingTable$Columns.TYPE, this.type);
            bundle.putString("nextPageBuffer", "");
            bundle.putString("keyword", this.bWm);
            bundle.putInt("webview_instance_id", hashCode());
            bundle.putLong("searchID", this.pNV.bXX());
            try {
                if (this.gcO != null) {
                    this.gcO.r(1, bundle);
                } else {
                    x.e("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "invoker should not be null");
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", e, "doSearch", new Object[0]);
            }
        }
        YC();
        String str2 = "";
        if (!bi.oW(str)) {
            str2 = str.replace(",", " ");
        }
        h.mEJ.h(13054, new Object[]{Integer.valueOf(this.qcN), Integer.valueOf(1), str2});
        return false;
    }

    public final void WY() {
        this.hol.czv();
        showVKB();
    }

    public final void WZ() {
    }

    protected void t(int i, Bundle bundle) {
        x.i("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "handleEmojiStoreAction action:%d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case 80001:
                String string = bundle.getString("emoji_store_json_data");
                boolean z = bundle.getBoolean("emoji_store_new_query", true);
                String string2 = bundle.getString("emoji_store_page_buf");
                long j = bundle.getLong("emoji_store_search_id");
                d dVar = this.pNV;
                if (dVar.qhq) {
                    x.i("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData success, ready");
                    Map hashMap = new HashMap();
                    hashMap.put("json", string);
                    hashMap.put("newQuery", Boolean.valueOf(z));
                    hashMap.put("nextPageBuffer", string2);
                    x.d("MicroMsg.JsApiHandler", "cpan emoji set SearchID:%d", new Object[]{Long.valueOf(j)});
                    dVar.qhC = j;
                    x.i("MicroMsg.JsApiHandler", "event:%s", new Object[]{a.a("getSearchEmotionDataCallBack", hashMap, dVar.qhs, dVar.qht)});
                    ah.A(new 56(dVar, string));
                    return;
                }
                x.e("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData fail, not ready");
                return;
            case 80002:
                this.pNV.bXW();
                return;
            default:
                super.t(i, bundle);
                return;
        }
    }

    protected final void bWc() {
        finish();
    }

    protected final int getLayoutId() {
        return R.i.emoji_webview_ui;
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final boolean bWs() {
        return true;
    }
}
