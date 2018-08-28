package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.plugin.r.d;

public final class g extends FrameLayout {
    public boolean kES = false;
    private ImageView kFk;
    public d kFl;
    private Context mContext;

    public g(Context context, d dVar) {
        super(context);
        this.kFl = dVar;
        this.mContext = context;
        this.kFk = (ImageView) View.inflate(this.mContext, f.poi_point, this).findViewById(e.point_iv);
    }

    public final void remove() {
        if (this.kES) {
            this.kFl.removeView(this);
        }
        this.kES = false;
    }
}
