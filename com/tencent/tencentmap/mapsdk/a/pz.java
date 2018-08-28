package com.tencent.tencentmap.mapsdk.a;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Polygon;
import java.util.List;

public class pz implements Polygon {
    private ra a;

    public pz(ra raVar) {
        this.a = raVar;
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

    public void setPoints(List<LatLng> list) {
        if (this.a != null) {
            this.a.a(qc.b(list));
        }
    }

    public List<LatLng> getPoints() {
        if (this.a != null) {
            return qc.a(this.a.c());
        }
        return null;
    }

    public void setStrokeWidth(float f) {
        if (this.a != null) {
            ra raVar = this.a;
            if (f < 0.0f) {
                f = 0.0f;
            }
            raVar.a(f);
        }
    }

    public float getStrokeWidth() {
        if (this.a != null) {
            return this.a.d();
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
            return this.a.e();
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
            return this.a.f();
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
            return (float) ((int) this.a.g());
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
            return this.a.h();
        }
        return false;
    }

    public boolean contains(LatLng latLng) {
        if (this.a != null) {
            return this.a.a(qc.a(latLng));
        }
        return false;
    }
}
