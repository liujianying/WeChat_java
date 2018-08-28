package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.r.d;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends ImageView {
    private static int kEU;
    private final String TAG = "MicroMsg.MyPoiPoint";
    private boolean bgH;
    private double bhG;
    public a cXs = new 1(this);
    private a kEL;
    private Bitmap kEM;
    private boolean kEN;
    private double kEO;
    private double kEP;
    public c kEQ;
    private d kER;
    private boolean kES = false;
    private final int kET = 689208551;
    private boolean kEV = false;
    private Activity mActivity;

    public e(Activity activity, int i, d dVar) {
        super(activity);
        this.kER = dVar;
        this.kEL = null;
        this.mActivity = activity;
        this.kEM = com.tencent.mm.sdk.platformtools.c.CV(i);
        this.bgH = false;
        this.kEN = false;
        this.kEQ = c.OB();
        kEU = b.b(activity, 80.0f);
        setImageResource(i);
        setScaleType(ScaleType.FIT_CENTER);
        x.d("MicroMsg.MyPoiPoint", "enableLocation");
        this.bgH = true;
        this.kEQ.a(this.cXs);
    }

    protected final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        x.d("MicroMsg.MyPoiPoint", "onDraw");
    }
}
