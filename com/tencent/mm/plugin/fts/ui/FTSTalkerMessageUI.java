package com.tencent.mm.plugin.fts.ui;

import android.os.Bundle;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.n.e;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.fts.ui.widget.a.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public class FTSTalkerMessageUI extends FTSBaseUI {
    private String bWm;
    private int jsZ;
    private String jsp;
    private l jxs;

    private class a implements b {
        private String daA;

        private a() {
        }

        /* synthetic */ a(FTSTalkerMessageUI fTSTalkerMessageUI, byte b) {
            this();
        }

        public final String getTagName() {
            return this.daA;
        }

        public final int compareTo(Object obj) {
            return 0;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ((n) g.n(n.class)).getFTSImageLoader().aPO();
        a aVar = new a(this, (byte) 0);
        aVar.daA = this.jsp;
        List arrayList = new ArrayList();
        arrayList.add(aVar);
        i(this.bWm, arrayList);
        aQy();
    }

    protected final void aQB() {
        super.aQB();
        this.jsp = getIntent().getStringExtra("key_talker_query");
        this.bWm = getIntent().getStringExtra("key_query");
        this.jsZ = getIntent().getIntExtra("Search_Scene", 0);
        x.i("MicroMsg.FTS.FTSTalkerMessageUI", "initSearchData query=%s talkerQuery=%s", new Object[]{this.bWm, this.jsp});
    }

    protected final d a(e eVar) {
        if (this.jxs == null) {
            this.jxs = new l(this, this.jsp, this.jsZ);
        }
        return this.jxs;
    }

    protected final int getLayoutId() {
        return e.fts_talker_message_ui;
    }

    protected void onDestroy() {
        this.jxs.finish();
        ((n) g.n(n.class)).getFTSImageLoader().aPM();
        super.onDestroy();
    }

    public final void a(String str, String str2, List<b> list, FTSEditTextView.b bVar) {
        super.a(str2, str2, list, bVar);
    }
}
