package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.selectcontact.a$c;
import com.tencent.mm.pluginsdk.ui.d.j;

public class e extends a {
    public CharSequence eCh;
    public CharSequence umC;
    public int umD = 0;
    private b umE = new b(this);
    a umF = new a();
    public String username;

    public class a extends a$a {
        public ImageView eCl;
        public TextView eCn;
        public CheckBox eCo;
        public TextView eTm;

        public a() {
            super(e.this);
        }
    }

    public e(int i) {
        super(4, i);
    }

    public void ck(Context context) {
        if (this.umD != 0 && this.umC != null) {
            return;
        }
        if (this.guS == null) {
            this.eCh = "";
            this.username = "";
            return;
        }
        this.eCh = j.a(context, ((b) g.l(b.class)).c(this.guS), com.tencent.mm.bp.a.ad(context, a$c.NormalTextSize));
        this.username = this.guS.field_username;
    }

    public final a.b Wg() {
        return this.umE;
    }

    protected final a$a Wh() {
        return this.umF;
    }
}
