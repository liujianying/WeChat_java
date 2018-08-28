package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.wenote.b.c;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.a.j;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public final class m extends h {
    public ImageView qvP;
    public MMPinProgressBtn qvQ;
    public ImageView qvR;
    private ImageView qvS;

    public m(View view, k kVar) {
        super(view, kVar);
        this.qvP = (ImageView) view.findViewById(R.h.status_btn);
        this.qvQ = (MMPinProgressBtn) view.findViewById(R.h.video_progress);
        this.qvR = (ImageView) view.findViewById(R.h.video_thumb);
        this.qvP.setImageResource(R.k.shortvideo_play_btn);
        this.qvS = (ImageView) view.findViewById(R.h.video_mask);
        this.eRj.setVisibility(8);
        this.qvq.setVisibility(8);
        this.qvS.setVisibility(8);
        this.qvu.setTag(this);
        this.qvu.setOnClickListener(this.jXR);
    }

    public final void a(b bVar, int i, int i2) {
        Bitmap bitmap;
        j jVar = (j) bVar;
        Bitmap Sq = c.Sq(jVar.bOX);
        if (Sq == null && e.cn(jVar.bVd)) {
            Sq = com.tencent.mm.plugin.fav.ui.c.By(jVar.bVd);
            if (Sq != null) {
                try {
                    if (e.cn(jVar.bOX)) {
                        e.deleteFile(jVar.bOX);
                    }
                    com.tencent.mm.pluginsdk.i.e.a(Sq, CompressFormat.JPEG, jVar.bOX);
                    bitmap = Sq;
                } catch (Exception e) {
                }
                if (bitmap == null) {
                    LayoutParams layoutParams = this.qvR.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.qvR.setLayoutParams(layoutParams);
                    this.qvR.setImageBitmap(bitmap);
                    this.qvR.setBackground(null);
                } else {
                    DisplayMetrics displayMetrics = this.qvR.getResources().getDisplayMetrics();
                    float f = (displayMetrics.density * 40.0f) + 0.5f;
                    LayoutParams layoutParams2 = this.qvR.getLayoutParams();
                    layoutParams2.width = displayMetrics.widthPixels - ((int) f);
                    layoutParams2.height = (layoutParams2.width * 52) / 68;
                    this.qvR.setLayoutParams(layoutParams2);
                }
                if (bVar.qoO) {
                    this.qvS.setVisibility(8);
                } else {
                    this.qvS.setVisibility(0);
                }
                super.a(bVar, i, i2);
            }
        }
        bitmap = Sq;
        if (bitmap == null) {
            DisplayMetrics displayMetrics2 = this.qvR.getResources().getDisplayMetrics();
            float f2 = (displayMetrics2.density * 40.0f) + 0.5f;
            LayoutParams layoutParams22 = this.qvR.getLayoutParams();
            layoutParams22.width = displayMetrics2.widthPixels - ((int) f2);
            layoutParams22.height = (layoutParams22.width * 52) / 68;
            this.qvR.setLayoutParams(layoutParams22);
        } else {
            LayoutParams layoutParams3 = this.qvR.getLayoutParams();
            layoutParams3.width = -1;
            layoutParams3.height = -1;
            this.qvR.setLayoutParams(layoutParams3);
            this.qvR.setImageBitmap(bitmap);
            this.qvR.setBackground(null);
        }
        if (bVar.qoO) {
            this.qvS.setVisibility(8);
        } else {
            this.qvS.setVisibility(0);
        }
        super.a(bVar, i, i2);
    }

    public final int caZ() {
        return 6;
    }
}
