package com.tencent.mm.plugin.location.ui.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.plugin.map.a.h;

public class PickPoi extends RelativeLayout {
    private Context context;
    Animation kEu;
    View kEv;
    protected b kHU;
    public a kIb = new 1(this);
    private double kJi;
    private double kJj;
    private f kJk = new f();
    boolean kJl = true;
    private e kJm = null;

    public PickPoi(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public PickPoi(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init();
    }

    public PickPoi(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        init();
    }

    public void setAdapter(e eVar) {
        this.kJm = eVar;
    }

    private void init() {
        this.kHU = b.Oz();
        this.kEu = AnimationUtils.loadAnimation(this.context, com.tencent.mm.plugin.map.a.a.translate_map);
        this.kEv = LayoutInflater.from(this.context).inflate(f.location_poi_pick, this, true).findViewById(e.location_here);
    }

    public final void m(double d, double d2) {
        this.kJi = d;
        this.kJj = d2;
        this.kJk = new f();
        this.kJk.type = 3;
        this.kJk.mName = this.context.getResources().getString(h.location_selected);
        this.kJk.bhC = d;
        this.kJk.bhD = d2;
        this.kJk.kJu = "";
        this.kHU.a(this.kIb);
        this.kHU.a(d, d2, this.kIb);
        this.kJl = true;
    }

    public f getPoi() {
        return this.kJk;
    }

    public void setLocationArrow(int i) {
        ((ImageView) this.kEv).setImageResource(i);
    }
}
