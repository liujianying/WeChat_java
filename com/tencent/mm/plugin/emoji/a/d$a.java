package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;

public class d$a extends a {
    final /* synthetic */ d idA;

    public d$a(d dVar, Context context, View view) {
        this.idA = dVar;
        super(context, view);
    }

    protected final void aDj() {
        this.idb.setVisibility(8);
        this.idd.setVisibility(8);
        this.idc.setVisibility(0);
        this.ide.setVisibility(8);
        this.idi.setVisibility(8);
        this.idj.setVisibility(8);
        this.ida.setVisibility(0);
        this.gsY.setVisibility(0);
        this.idg.setVisibility(0);
        this.idf.setVisibility(0);
        this.idf.setBackgroundDrawable(null);
        this.idh.setVisibility(0);
    }

    protected final int[] aDk() {
        int ad = a.ad(this.mContext, R.f.emoji_paid_item_icon_height);
        return new int[]{ad, ad};
    }

    protected final int aDl() {
        return a.ad(this.mContext, R.f.emoji_paid_item_min_height);
    }

    protected final boolean aDr() {
        return true;
    }
}
