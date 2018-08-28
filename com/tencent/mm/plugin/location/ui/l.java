package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.map.a$h;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;

public final class l {
    public c ftY = null;
    public a kGO;
    public Context mContext;
    public Resources mResources;

    /* renamed from: com.tencent.mm.plugin.location.ui.l$8 */
    class AnonymousClass8 implements OnClickListener {
        final /* synthetic */ int bpX;

        public AnonymousClass8(int i) {
            this.bpX = i;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            if (l.this.kGO != null) {
                l.this.kGO.rS(this.bpX);
            }
        }
    }

    public l(Context context, a aVar) {
        this.mContext = context;
        this.kGO = aVar;
        this.mResources = this.mContext.getResources();
    }

    public final void aZM() {
        if (!rQ(67590)) {
            h.a(this.mContext, this.mResources.getString(a$h.location_sharing_go_on_tips), "", false, new 4(this), new 5(this));
            rR(67590);
        } else if (this.kGO != null) {
            this.kGO.aZN();
        }
    }

    public static boolean rQ(int i) {
        Object obj = g.Ei().DT().get(i, null);
        if (obj == null) {
            return false;
        }
        return ((Boolean) obj).booleanValue();
    }

    public static void rR(int i) {
        g.Ei().DT().set(i, Boolean.valueOf(true));
    }
}
