package com.tencent.tencentmap.mapsdk.a;

import android.graphics.DashPathEffect;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.LatLng;

public class pv implements Circle {
    private qt a;

    public pv(qt qtVar) {
        this.a = qtVar;
    }

    public void remove() {
        if (this.a != null) {
            this.a.a();
        }
    }

    public String getId() {
        if (this.a != null) {
            return this.a.b();
        }
        return null;
    }

    public void setCenter(LatLng latLng) {
        if (this.a != null) {
            this.a.a(qc.a(latLng));
        }
    }

    public LatLng getCenter() {
        if (this.a != null) {
            return qc.a(this.a.c());
        }
        return null;
    }

    public void setRadius(double d) {
        if (this.a != null) {
            this.a.a(d);
        }
    }

    public double getRadius() {
        if (this.a != null) {
            return this.a.d();
        }
        return 0.0d;
    }

    public void setStrokeWidth(float f) {
        if (this.a != null) {
            qt qtVar = this.a;
            if (f < 0.0f) {
                f = 0.0f;
            }
            qtVar.a(f);
        }
    }

    public float getStrokeWidth() {
        if (this.a != null) {
            return this.a.e();
        }
        return 0.0f;
    }

    public void setStrokeColor(int i) {
        if (this.a != null) {
            this.a.a(i);
        }
    }

    public int getStrokeColor() {
        if (this.a != null) {
            return this.a.f();
        }
        return 0;
    }

    public void setFillColor(int i) {
        if (this.a != null) {
            this.a.b(i);
        }
    }

    public int getFillColor() {
        if (this.a != null) {
            return this.a.g();
        }
        return 0;
    }

    public void setZIndex(float f) {
        if (this.a != null) {
            this.a.b((float) ((int) f));
        }
    }

    public float getZIndex() {
        if (this.a != null) {
            return (float) ((int) this.a.h());
        }
        return 0.0f;
    }

    public void setVisible(boolean z) {
        if (this.a != null) {
            this.a.a(z);
        }
    }

    public boolean isVisible() {
        if (this.a != null) {
            return this.a.i();
        }
        return false;
    }

    public boolean contains(LatLng latLng) {
        if (this.a != null) {
            return this.a.b(qc.a(latLng));
        }
        return false;
    }

    public void setStrokeDash(boolean z) {
        if (this.a != null) {
            this.a.b(z);
        }
    }

    public void strokeDashPathEffect(DashPathEffect dashPathEffect) {
        if (this.a != null) {
            this.a.a(dashPathEffect);
        }
    }

    public boolean getStrokeDash() {
        if (this.a != null) {
            return this.a.j();
        }
        return false;
    }

    public DashPathEffect getStrokeDashPathEffect() {
        if (this.a != null) {
            return this.a.k();
        }
        return null;
    }
}
