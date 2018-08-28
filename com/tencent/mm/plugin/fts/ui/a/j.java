package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.d;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.fts.ui.n$d;
import com.tencent.mm.plugin.fts.ui.n$f;
import com.tencent.mm.plugin.fts.ui.n.e;

public final class j extends a {
    public int actionType = -1;
    public l fyJ;
    public CharSequence jea;
    public String jed;
    public CharSequence jyr;
    public String jys;
    public c jyt;
    private b jyu = new b();
    a jyv = new a(this);

    public class b extends com.tencent.mm.plugin.fts.a.d.a.a.b {
        public b() {
            super(j.this);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(e.fts_contact_item, viewGroup, false);
            a aVar = j.this.jyv;
            aVar.eCl = (ImageView) inflate.findViewById(n$d.avatar_iv);
            aVar.eCm = (TextView) inflate.findViewById(n$d.title_tv);
            aVar.eCn = (TextView) inflate.findViewById(n$d.desc_tv);
            aVar.contentView = inflate.findViewById(n$d.search_item_content_layout);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, a.a aVar, a aVar2, Object... objArr) {
            a aVar3 = (a) aVar;
            j jVar = (j) aVar2;
            m.h(aVar3.contentView, j.this.jtj);
            m.a(j.this.jea, aVar3.eCm);
            m.a(j.this.jyr, aVar3.eCn);
            m.a(context, aVar3.eCl, null, jVar.jed, n$f.fts_default_img);
        }

        public final boolean a(Context context, a aVar) {
            return ((n) g.n(n.class)).getItemClickHandler(j.this.hER).a(context, aVar);
        }
    }

    public j(int i) {
        super(3, i);
    }

    public final void a(Context context, a.a aVar, Object... objArr) {
        boolean z = true;
        this.jyt = (c) this.fyJ.userData;
        if (this.jyt != null) {
            boolean z2;
            this.jea = this.jyt.field_title;
            this.jyr = this.jyt.field_tag;
            this.jed = this.jyt.field_iconPath;
            this.jys = this.jyt.field_androidUrl;
            this.actionType = this.jyt.field_actionType;
            switch (this.fyJ.jru) {
                case 1:
                    z = false;
                    z2 = false;
                    break;
                case 2:
                    z2 = false;
                    break;
                case 3:
                    z2 = true;
                    break;
                case 4:
                    this.jyr = f.a(d.a(this.jyr, this.jrx)).jrO;
                    return;
                default:
                    return;
            }
            this.jea = f.a(d.a(this.jea, this.jrx, z, z2)).jrO;
        }
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a.b BV() {
        return this.jyu;
    }

    protected final a.a afD() {
        return this.jyv;
    }

    public final String afE() {
        return this.jyt.field_title;
    }

    public final int afF() {
        return this.fyJ.jsJ;
    }
}
