package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.n.g;
import com.tencent.mm.sdk.platformtools.bi;

public final class i extends a {
    public String jso;
    public boolean jym;
    public CharSequence jyn;
    private b jyo;
    private a jyp;

    public i(int i) {
        super(19, i);
        this.jyo = new b(this);
        this.jyp = new a(this);
        this.jtj = false;
    }

    public final void a(Context context, a.a aVar, Object... objArr) {
        CharSequence ellipsize = TextUtils.ellipsize(this.jrx.jrY[0], c.jvz, 200.0f, TruncateAt.MIDDLE);
        CharSequence ellipsize2 = TextUtils.ellipsize(this.jrx.jrY[1], c.jvz, 400.0f, TruncateAt.MIDDLE);
        if (bi.oW(this.jso)) {
            this.jyn = TextUtils.concat(new CharSequence[]{context.getString(g.search_talker_message_info_1), f.d(ellipsize, ellipsize.length()), context.getString(g.search_talker_message_info_2), f.d(ellipsize2, ellipsize2.length()), context.getString(g.search_talker_message_info_3)});
            return;
        }
        this.jyn = TextUtils.concat(new CharSequence[]{context.getString(g.search_talker_message_info_4), f.d(ellipsize, ellipsize.length()), context.getString(g.search_talker_message_info_2), f.d(ellipsize2, ellipsize2.length()), context.getString(g.search_talker_message_info_3)});
    }

    public final b BV() {
        return this.jyo;
    }

    protected final a.a afD() {
        return this.jyp;
    }
}
