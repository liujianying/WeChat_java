package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.b.c;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.sdk.platformtools.bi;

public final class e extends h {
    private int dwJ = 0;
    private ImageView qvj;

    public e(View view, k kVar) {
        super(view, kVar);
        this.bOA.setVisibility(0);
        this.eRj.setVisibility(8);
        this.qvq.setVisibility(8);
        this.bOA.setTag(this);
        this.bOA.setOnClickListener(this.jXR);
        this.qvj = (ImageView) view.findViewById(R.h.image_mask);
        this.qvj.setVisibility(8);
        this.dwJ = k.mScreenWidth - ((int) k.aq(20.0f));
    }

    public final void a(b bVar, int i, int i2) {
        String str;
        String str2 = ((com.tencent.mm.plugin.wenote.model.a.e) bVar).bVd;
        String str3 = ((com.tencent.mm.plugin.wenote.model.a.e) bVar).qpe;
        if (com.tencent.mm.a.e.cn(str2)) {
            str = str2;
        } else if (com.tencent.mm.a.e.cn(str3)) {
            str = str3;
        } else {
            Object str4 = null;
        }
        if (this.qtF.qrC != 3) {
            str3 = str4;
        } else if (!com.tencent.mm.a.e.cn(str3)) {
            str3 = str4;
        }
        Bitmap Sq = bi.oW(str3) ? null : c.Sq(str3);
        this.bOA.setImageBitmap(null);
        LayoutParams layoutParams = this.bOA.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.bOA.setLayoutParams(layoutParams);
        if (Sq != null) {
            this.bOA.setImageBitmap(Sq);
        } else {
            this.bOA.setImageBitmap(null);
            LayoutParams layoutParams2 = this.bOA.getLayoutParams();
            layoutParams2.width = this.dwJ;
            layoutParams2.height = this.dwJ;
            this.bOA.setLayoutParams(layoutParams2);
            this.bOA.setBackgroundColor(Color.parseColor("#f6f6f6"));
        }
        if (bVar.qoO) {
            this.qvj.setVisibility(0);
        } else {
            this.qvj.setVisibility(8);
        }
        super.a(bVar, i, i2);
    }

    public final int caZ() {
        return 2;
    }
}
