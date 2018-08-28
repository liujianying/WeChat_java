package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.u;
import com.tencent.mm.plugin.appbrand.n.d;
import com.tencent.mm.plugin.appbrand.n.f;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n;

class c$1 implements a {
    final /* synthetic */ c gPw;

    c$1(c cVar) {
        this.gPw = cVar;
    }

    public final boolean a(View view, a aVar, float f, float f2) {
        if (c.a(this.gPw) != null) {
            c.a(this.gPw).a(view, aVar, f, f2);
        }
        if (aVar.type == 0) {
            ((f) g.l(f.class)).x(this.gPw.getContext(), 13);
        } else {
            this.gPw.setLayoutFrozen(true);
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1089;
            ((d) g.l(d.class)).a(this.gPw.getContext(), aVar.gOT.username, null, aVar.gOT.fmv, -1, null, appBrandStatObject);
        }
        return false;
    }

    public final boolean b(View view, final a aVar, float f, float f2) {
        if (c.a(this.gPw) != null) {
            c.a(this.gPw).b(view, aVar, f, f2);
        }
        x.i("MicroMsg.ConversationAppBrandRecentView", "[onItemLongClick] x:%s", new Object[]{Float.valueOf(f)});
        if (aVar.type != 0) {
            new com.tencent.mm.ui.widget.b.a(this.gPw.getContext()).a(view, 0, 0, new 1(this), new n.d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    if (menuItem.getItemId() == 1 && aVar.position >= 0) {
                        c.b(c$1.this.gPw);
                        x.i("MicroMsg.ConversationAppBrandRecentView", "[onItemLongClick] Delete position:%s", new Object[]{Integer.valueOf(aVar.position)});
                        ((u) g.l(u.class)).ap(aVar.gOT.username, aVar.gOT.fmv);
                        c$1.this.gPw.getRecentItemList().remove(aVar.position);
                        c$1.this.gPw.getAdapter().bn(aVar.position);
                    }
                }
            }, (int) f, (int) f2);
        }
        return false;
    }
}
