package com.tencent.tencentmap.mapsdk.a;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Polyline;
import java.util.List;

public class qk implements Polyline {
    private pf a;

    public qk(pf pfVar) {
        this.a = pfVar;
    }

    public void remove() {
        if (this.a != null) {
            this.a.b();
        }
    }

    public String getId() {
        if (this.a != null) {
            return this.a.c();
        }
        return null;
    }

    public void setPoints(List<LatLng> list) {
        if (this.a != null) {
            this.a.a(qo.b(list));
        }
    }

    public List<LatLng> getPoints() {
        if (this.a != null) {
            return qo.a(this.a.d());
        }
        return null;
    }

    public void setWidth(float f) {
        if (this.a != null) {
            pf pfVar = this.a;
            if (f < 0.0f) {
                f = 0.0f;
            }
            pfVar.a(f);
        }
    }

    public float getWidth() {
        if (this.a != null) {
            return this.a.e();
        }
        return 0.0f;
    }

    public void setColor(int i) {
        if (this.a != null) {
            this.a.a(i);
        }
    }

    public int getColor() {
        if (this.a != null) {
            return this.a.f();
        }
        return 0;
    }

    public void setZIndex(float f) {
        if (this.a != null) {
            this.a.b((int) f);
        }
    }

    public float getZIndex() {
        if (this.a != null) {
            return (float) this.a.g();
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

    public void setGeodesic(boolean z) {
    }

    public boolean isGeodesic() {
        return false;
    }

    public void setDottedLine(boolean z) {
    }

    public boolean isDottedLine() {
        return false;
    }
}
