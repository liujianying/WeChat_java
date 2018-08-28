package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a$b;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.n$g;

public final class e extends k {
    public int count;
    private a jxO = new a(this);
    b jxP = new b(this);
    public String talker;

    public e(int i) {
        super(i);
    }

    public final void a(Context context, a aVar, Object... objArr) {
        CharSequence ellipsize = TextUtils.ellipsize(d.Bc(this.talker), c.jvz, 500.0f, TruncateAt.MIDDLE);
        this.jyx = context.getString(n$g.search_talker_message_header, new Object[]{ellipsize});
    }

    public final a$b BV() {
        return this.jxO;
    }

    protected final a afD() {
        return this.jxP;
    }
}
