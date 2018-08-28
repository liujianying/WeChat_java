package com.tencent.mm.plugin.fts.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.ui.n.e;
import com.tencent.mm.plugin.fts.ui.n.g;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.fts.ui.widget.a.b;
import java.util.ArrayList;
import java.util.List;

public class FTSConvMessageUI extends FTSBaseUI {
    private String bWm;
    private int jsZ;
    private String jso;
    private g jwx;

    private class a implements b {
        private String daA;

        private a() {
        }

        /* synthetic */ a(FTSConvMessageUI fTSConvMessageUI, byte b) {
            this();
        }

        public final String getTagName() {
            return this.daA;
        }

        public final int compareTo(Object obj) {
            return 0;
        }
    }

    protected final void aQB() {
        super.aQB();
        this.jso = getIntent().getStringExtra("key_conv");
        this.bWm = getIntent().getStringExtra("key_query");
        this.jsZ = getIntent().getIntExtra("Search_Scene", 0);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a aVar = new a(this, (byte) 0);
        aVar.daA = d.Bc(this.jso);
        List arrayList = new ArrayList();
        arrayList.add(aVar);
        i(this.bWm, arrayList);
        aQy();
    }

    protected final int getLayoutId() {
        return e.fts_detail_ui;
    }

    protected void onDestroy() {
        this.jwx.finish();
        super.onDestroy();
    }

    protected final d a(e eVar) {
        if (this.jwx == null) {
            this.jwx = new g(eVar, this.jso, this.jsZ);
        }
        return this.jwx;
    }

    public final boolean anx() {
        return false;
    }

    public final String getHint() {
        return getString(g.search_talker_page_hint);
    }

    public final void a(String str, String str2, List<b> list, FTSEditTextView.b bVar) {
        super.a(str2, str2, list, bVar);
    }
}
