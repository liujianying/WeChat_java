package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.map.a$f;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.r.d;

public class MyLocationButton extends FrameLayout {
    public a cXs = new 1(this);
    private Context context;
    private ImageButton kEF;
    private LinearLayout kEG;
    private d kEH;
    private boolean kEI = true;

    public MyLocationButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        init();
    }

    public MyLocationButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init();
    }

    public void setAnimToSelf(boolean z) {
        this.kEI = z;
    }

    private void init() {
        View inflate = View.inflate(this.context, a$f.my_location_btn, this);
        this.kEF = (ImageButton) inflate.findViewById(e.locate_btn);
        this.kEG = (LinearLayout) inflate.findViewById(e.progress_bar);
    }

    public final void aZy() {
        this.kEF.setImageResource(com.tencent.mm.plugin.map.a.d.poi_mylocation_btn_icon_disable);
    }

    public final void aZz() {
        this.kEF.setImageResource(com.tencent.mm.plugin.map.a.d.poi_mylocation_btn_icon_normal);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.kEF.setOnClickListener(onClickListener);
    }

    public void setProgressBar(d dVar) {
        this.kEH = dVar;
        this.kEG.setVisibility(0);
        this.kEF.setVisibility(8);
        c.OB().b(this.cXs, true);
    }

    public ImageButton getMyLocationBtn() {
        return this.kEF;
    }

    public LinearLayout getProgressBar() {
        return this.kEG;
    }
}
