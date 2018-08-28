package com.tencent.tencentmap.mapsdk.a;

import android.graphics.DashPathEffect;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.LatLng;

public class qh implements Circle {
    private os a;

    public qh(os osVar) {
        this.a = osVar;
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
            this.a.b(qo.a(latLng));
        }
    }

    public LatLng getCenter() {
        if (this.a != null) {
            return qo.a(this.a.c());
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
            os osVar = this.a;
            if (f < 0.0f) {
                f = 0.0f;
            }
            osVar.a(f / qi.a());
        }
    }

    public float getStrokeWidth() {
        if (this.a != null) {
            return this.a.e() * qi.a();
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
            this.a.c((int) f);
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
            return this.a.a(qo.a(latLng));
        }
        return false;
    }

    public void setStrokeDash(boolean z) {
    }

    public void strokeDashPathEffect(DashPathEffect dashPathEffect) {
    }

    public boolean getStrokeDash() {
        return false;
    }

    public DashPathEffect getStrokeDashPathEffect() {
        return null;
    }
}
