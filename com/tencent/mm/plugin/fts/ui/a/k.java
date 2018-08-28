package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class k extends com.tencent.mm.plugin.fts.a.d.a.a {
    public String jyx;
    private b jyy = new b(this);
    private a jyz = new a();

    public class a extends com.tencent.mm.plugin.fts.a.d.a.a.a {
        public View contentView;
        public TextView hRY;
        public View jxR;

        public a() {
            super(k.this);
        }
    }

    public k(int i) {
        super(0, i);
    }

    public void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, Object... objArr) {
        this.jyx = bi.aG(m.qm(this.jtk), "");
        x.i("MicroMsg.FTS.FTSHeaderDataItem", "fillingDataItem: header=%s", new Object[]{this.jyx});
    }

    public b BV() {
        return this.jyy;
    }

    protected com.tencent.mm.plugin.fts.a.d.a.a.a afD() {
        return this.jyz;
    }
}
