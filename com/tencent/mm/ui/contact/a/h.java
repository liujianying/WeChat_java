package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.a.a.d;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.ui.contact.a.a.b;

public final class h extends a {
    private CharSequence jyB;
    private b umO = new b(this);
    a$a umP = new a();

    public class a extends a$a {
        public TextView jye;

        public a() {
            super(h.this);
        }
    }

    public h(int i) {
        super(6, i);
    }

    public final void ck(Context context) {
        this.jyB = f.a(context.getString(com.tencent.mm.plugin.selectcontact.a.h.search_contact_no_result_pre), context.getString(com.tencent.mm.plugin.selectcontact.a.h.search_contact_no_result_post), d.b(this.bWm, this.bWm)).jrO;
    }

    public final b Wg() {
        return this.umO;
    }

    protected final a$a Wh() {
        return this.umP;
    }
}
