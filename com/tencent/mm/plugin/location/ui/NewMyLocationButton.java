package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.modelgeo.a$a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.map.a$e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.plugin.r.d;

public class NewMyLocationButton extends FrameLayout {
    private a$a cXs = new 1(this);
    private Context context;
    private ImageButton kEF;
    private LinearLayout kEG;
    private d kEH;
    private boolean kEI = true;

    public NewMyLocationButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        init();
    }

    public NewMyLocationButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init();
    }

    public void setAnimToSelf(boolean z) {
        this.kEI = z;
    }

    private void init() {
        View inflate = View.inflate(this.context, f.new_my_location_btn, this);
        this.kEF = (ImageButton) inflate.findViewById(a$e.new_locate_btn);
        this.kEG = (LinearLayout) inflate.findViewById(a$e.new_progress_bar);
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
}
