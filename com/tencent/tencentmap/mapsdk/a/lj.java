package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView.ScaleType;
import android.widget.ZoomControls;
import com.tencent.map.lib.d;
import com.tencent.tencentmap.mapsdk.a.ld.b;
import com.tencent.tencentmap.mapsdk.a.ni.a;

public class lj implements ld {
    private Context a;
    private ZoomControls b;
    private lk c = null;
    private ViewGroup d;
    private b e = b.c;
    private a f = null;
    private ks g;
    private int h = 0;

    public lj(Context context, ks ksVar) {
        this.a = context;
        this.g = ksVar;
        a(context);
        c();
    }

    public void a(int i, int i2) {
    }

    public void a() {
        if (this.c != null) {
            this.c.a();
        }
    }

    public boolean a(ViewGroup viewGroup) {
        if (viewGroup == null || this.b == null || this.c == null) {
            return false;
        }
        this.d = viewGroup;
        LayoutParams d = d();
        if (viewGroup.indexOfChild(this.b) < 0) {
            viewGroup.addView(this.b, d);
        } else {
            viewGroup.updateViewLayout(this.b, d);
        }
        d = new FrameLayout.LayoutParams(-2, -2);
        d.gravity = 85;
        d.bottomMargin = this.h + 5;
        d.rightMargin = 5;
        if (viewGroup.indexOfChild(this.c) < 0) {
            viewGroup.addView(this.c, d);
        } else {
            viewGroup.updateViewLayout(this.c, d);
        }
        return true;
    }

    private void a(Context context) {
        this.c = new lk(context);
        this.c.setVisibility(8);
        b();
        try {
            this.b = new ZoomControls(context);
            this.b.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
            this.h = this.b.getMeasuredHeight();
            this.b.setVisibility(8);
        } catch (Exception e) {
        }
    }

    private void b() {
        Bitmap b = kh.b(kh.b(this.a, "location_enable.png"));
        Bitmap b2 = kh.b(kh.b(this.a, "location_state_normal.png"));
        Bitmap b3 = kh.b(kh.b(this.a, "location_state_selected.png"));
        this.c.setScaleType(ScaleType.CENTER);
        this.c.setImageBitmap(b);
        this.c.a(this.a, b2, b3);
    }

    public void a(a aVar) {
        this.f = aVar;
    }

    private void c() {
        if (this.b != null) {
            this.b.setOnZoomInClickListener(new OnClickListener() {
                public void onClick(View view) {
                    lj.this.g.getMap().a(null);
                }
            });
            this.b.setOnZoomOutClickListener(new 2(this));
        }
        this.c.setOnClickListener(new 3(this));
    }

    public void a(boolean z, boolean z2) {
        if (this.b != null) {
            this.b.setIsZoomInEnabled(z);
            this.b.setIsZoomOutEnabled(z2);
        }
    }

    public void a(boolean z) {
        if (this.b != null) {
            this.b.setVisibility(z ? 0 : 4);
        }
    }

    private FrameLayout.LayoutParams d() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        switch (4.a[this.e.ordinal()]) {
            case 1:
                layoutParams.gravity = 83;
                layoutParams.bottomMargin = 5;
                layoutParams.leftMargin = 5;
                break;
            case 2:
                layoutParams.gravity = 81;
                layoutParams.bottomMargin = 5;
                break;
            case 3:
                layoutParams.gravity = 85;
                layoutParams.bottomMargin = 5;
                layoutParams.rightMargin = 5;
                break;
            case 4:
                layoutParams.gravity = 51;
                layoutParams.topMargin = 5;
                layoutParams.leftMargin = 5;
                break;
            case 5:
                layoutParams.gravity = 49;
                layoutParams.topMargin = 5;
                break;
            case 6:
                layoutParams.gravity = 53;
                layoutParams.topMargin = 5;
                layoutParams.rightMargin = 5;
                break;
            default:
                d.b("Unknown position:" + this.e);
                break;
        }
        return layoutParams;
    }
}
