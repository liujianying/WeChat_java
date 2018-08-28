package com.tencent.mm.plugin.fts.ui;

import android.os.Bundle;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.b;
import com.tencent.mm.plugin.fts.ui.widget.a$b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public class FTSConvTalkerMessageUI extends FTSBaseUI {
    private String bWm;
    private int jsZ;
    private String jso;
    private String jsp;
    private h jwA;
    private int showType;
    private String talker;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ((n) g.n(n.class)).getFTSImageLoader().aPO();
        a aVar = new a(this, (byte) 0);
        a.a(aVar, this.jsp);
        a aVar2 = new a(this, (byte) 0);
        a.a(aVar2, ">");
        a aVar3 = new a(this, (byte) 0);
        a.a(aVar3, d.Bc(this.jso));
        List arrayList = new ArrayList();
        if (this.showType == 2) {
            arrayList.add(aVar);
            arrayList.add(aVar2);
            arrayList.add(aVar3);
        } else {
            arrayList.add(aVar3);
            arrayList.add(aVar2);
            arrayList.add(aVar);
        }
        i(this.bWm, arrayList);
        aQy();
    }

    protected final void aQB() {
        super.aQB();
        this.jso = getIntent().getStringExtra("key_conv");
        this.talker = getIntent().getStringExtra("key_talker");
        this.bWm = getIntent().getStringExtra("key_query");
        this.jsp = getIntent().getStringExtra("key_talker_query");
        this.showType = getIntent().getIntExtra("detail_type", 1);
        this.jsZ = getIntent().getIntExtra("Search_Scene", 0);
        x.i("MicroMsg.FTS.FTSConvTalkerMessageUI", "initSearchData query=%s talker=%s conversation=%s showType=%d", new Object[]{this.bWm, this.talker, this.jso, Integer.valueOf(this.showType)});
    }

    protected final d a(e eVar) {
        if (this.jwA == null) {
            this.jwA = new h(this, this.talker, this.jsp, this.jso, this.jsZ, this.showType);
        }
        return this.jwA;
    }

    protected final int getLayoutId() {
        return n$e.fts_talker_message_ui;
    }

    public final void a(String str, String str2, List<a$b> list, b bVar) {
        super.a(str2, str2, list, bVar);
    }
}
