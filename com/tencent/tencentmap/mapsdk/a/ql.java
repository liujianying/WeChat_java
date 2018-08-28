package com.tencent.tencentmap.mapsdk.a;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Polygon;
import java.util.List;

public class ql implements Polygon {
    private pd a;

    public ql(pd pdVar) {
        this.a = pdVar;
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
            this.a.a(qo.b((List) list));
        }
    }

    public List<LatLng> getPoints() {
        if (this.a != null) {
            return qo.a(this.a.c());
        }
        return null;
    }

    public void setStrokeWidth(float f) {
        if (this.a != null) {
            pd pdVar = this.a;
            if (f < 0.0f) {
                f = 0.0f;
            }
            pdVar.a(f / qi.a());
        }
    }

    public float getStrokeWidth() {
        if (this.a != null) {
            return this.a.d() * qi.a();
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
            this.a.c((int) f);
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
            return this.a.a(qo.a(latLng));
        }
        return false;
    }
}
