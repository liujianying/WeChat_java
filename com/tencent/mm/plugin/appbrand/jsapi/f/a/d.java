package com.tencent.mm.plugin.appbrand.jsapi.f.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.appbrand.compat.a.b.h;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.s.g;

public final class d extends LinearLayout {
    private Context context;
    private ImageView fTO;
    double fTP = -1.0d;
    double fTQ = -1.0d;
    double fTR = -1.0d;
    double fTS = -1.0d;
    float fTT = 900.0f;
    float fTU = 900.0f;
    float fTV = 0.0f;
    boolean fTW;
    h fTv;

    public d(Context context) {
        super(context);
        this.context = context;
        this.fTO = (ImageView) View.inflate(this.context, s.h.app_brand_map_location_point, this).findViewById(g.tp_location_point);
        this.fTO.requestFocus();
    }

    public final double getLatitude() {
        return this.fTP;
    }

    public final double getLongitude() {
        return this.fTQ;
    }

    final float getHeading() {
        if (this.fTW) {
            return this.fTT;
        }
        return this.fTV;
    }
}
