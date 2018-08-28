package com.tencent.mm.plugin.appbrand.game.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.game.a.a.b;
import com.tencent.mm.plugin.fts.a.a.d;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.a.a$a;
import com.tencent.mm.plugin.fts.a.f;

public final class c extends com.tencent.mm.plugin.fts.a.d.a.a {
    public k fAG;
    public b fAH;
    private b fAI = new b(this);
    a fAJ = new a();
    public l fyJ;
    public CharSequence fyL;

    public class a extends a$a {
        public View contentView;
        public ImageView eCl;
        public TextView eCm;
        public TextView fAK;
        public TextView fyO;
        public TextView fyP;

        public a() {
            super(c.this);
        }
    }

    public c(int i) {
        super(20, i);
    }

    public final void a(Context context, a$a a_a, Object... objArr) {
        boolean z = true;
        boolean z2 = false;
        this.fAG = i.sP(this.fyJ.jrv);
        this.fAH = i.sO(this.fyJ.jrv);
        if (this.fAH != null) {
            boolean z3;
            switch (this.fyJ.jru) {
                case 2:
                    break;
                case 3:
                    z2 = true;
                    break;
                default:
                    z = false;
                    z3 = false;
                    break;
            }
            z3 = z2;
            this.fyL = f.a(d.a(this.fAH.field_AppName, this.jrx, z, z3)).jrO;
            this.info = this.fAH.field_AppId;
        }
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a.b BV() {
        return this.fAI;
    }

    protected final a$a afD() {
        return this.fAJ;
    }

    public final String afE() {
        if (this.fAH == null) {
            return ":";
        }
        return String.format("%s:%s", new Object[]{this.fAH.field_AppId, this.fAH.field_AppName});
    }

    public final int afF() {
        return this.fyJ.jsJ;
    }
}
