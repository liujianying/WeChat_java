package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;

public class f$a extends a {
    final /* synthetic */ f idL;

    public f$a(f fVar, Context context, View view) {
        this.idL = fVar;
        super(context, view);
    }

    protected final void aDj() {
        this.idb.setVisibility(8);
        aDo();
        this.ide.setVisibility(8);
        this.idi.setVisibility(8);
        this.idj.setVisibility(8);
        this.ida.setVisibility(0);
        this.gsY.setVisibility(0);
        this.idg.setVisibility(0);
        this.idf.setVisibility(0);
        this.idh.setVisibility(0);
    }

    protected final int[] aDk() {
        int ad = a.ad(this.mContext, R.f.emoji_item_store_image_size);
        return new int[]{ad, ad};
    }

    protected final int aDl() {
        return a.ad(this.mContext, R.f.emoji_item_store_height);
    }

    protected final boolean aDr() {
        return f.a(this.idL);
    }
}
