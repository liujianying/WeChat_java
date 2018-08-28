package com.tencent.mm.plugin.sight.encode.ui;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.contact.l;
import com.tencent.mm.ui.contact.o;
import java.util.ArrayList;
import java.util.List;

public final class c extends o {
    public static boolean nfQ = true;
    public static boolean nfR = false;
    List<String> nfO;
    boolean nfP;

    static /* synthetic */ void d(Context context, View view) {
        if (view != null && context != null) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.height = a.ad(context, R.f.sight_item_height);
            layoutParams.rightMargin = 0;
            layoutParams.leftMargin = 0;
            view.setLayoutParams(layoutParams);
            view.setPadding(a.fromDPToPix(context, 10), view.getPaddingTop(), a.fromDPToPix(context, 10), view.getPaddingTop());
        }
    }

    public c(l lVar) {
        super(lVar, new ArrayList(), true, true);
        this.nfP = true;
        this.nfP = true;
        this.nfO = null;
    }

    public final int getCount() {
        return this.nfO == null ? 0 : this.nfO.size();
    }

    protected final com.tencent.mm.ui.contact.a.a iW(int i) {
        if (this.nfO == null) {
            return null;
        }
        if (i < 0 || i >= getCount()) {
            x.e("MicroMsg.MainSightSelectContactAdapter", "create Data Item Error position=%d", new Object[]{Integer.valueOf(i)});
            return null;
        }
        ab abVar;
        a aVar = new a(this, i);
        String str = (String) this.nfO.get(i);
        if (Lr(str)) {
            abVar = new ab("@sns.tencent");
        } else if (Ls(str)) {
            abVar = new ab("@search.tencent");
        } else if (Lt(str)) {
            abVar = new ab("@draft.tencent");
        } else {
            au.HU();
            abVar = com.tencent.mm.model.c.FR().Yg((String) this.nfO.get(i));
        }
        aVar.guS = abVar;
        aVar.ujX = this.nfP;
        return aVar;
    }

    public static boolean Lr(String str) {
        return bi.oW(str) ? false : str.endsWith("@sns.tencent");
    }

    public static boolean Ls(String str) {
        return bi.oW(str) ? false : str.endsWith("@search.tencent");
    }

    public static boolean Lt(String str) {
        return bi.oW(str) ? false : str.endsWith("@draft.tencent");
    }

    public final boolean bwq() {
        return this.nfP;
    }
}
