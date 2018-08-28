package com.tencent.tencentmap.mapsdk.a;

import android.view.View;
import android.view.animation.Animation;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;

public class px implements Marker {
    private qy a;

    public px(qy qyVar) {
        this.a = qyVar;
    }

    public float getAlpha() {
        if (this.a != null) {
            return this.a.a();
        }
        return 0.0f;
    }

    public String getId() {
        if (this.a != null) {
            return this.a.b();
        }
        return null;
    }

    public LatLng getPosition() {
        if (this.a != null) {
            return qc.a(this.a.c());
        }
        return null;
    }

    public float getRotation() {
        if (this.a != null) {
            return this.a.d();
        }
        return 0.0f;
    }

    public String getSnippet() {
        if (this.a != null) {
            return this.a.e();
        }
        return null;
    }

    public String getTitle() {
        if (this.a != null) {
            return this.a.f();
        }
        return null;
    }

    public void hideInfoWindow() {
        if (this.a != null) {
            this.a.g();
        }
    }

    public boolean isDraggable() {
        if (this.a != null) {
            return this.a.h();
        }
        return false;
    }

    public boolean isInfoWindowShown() {
        if (this.a != null) {
            return this.a.i();
        }
        return false;
    }

    public boolean isVisible() {
        if (this.a != null) {
            return this.a.j();
        }
        return false;
    }

    public void remove() {
        if (this.a != null) {
            this.a.k();
        }
    }

    public void setAlpha(float f) {
        if (this.a != null) {
            this.a.a(f);
        }
    }

    public void setAnchor(float f, float f2) {
        if (this.a != null) {
            this.a.a(f, f2);
        }
    }

    public void setDraggable(boolean z) {
        if (this.a != null) {
            this.a.a(z);
        }
    }

    public void setIcon(BitmapDescriptor bitmapDescriptor) {
        if (this.a != null && bitmapDescriptor != null) {
            this.a.a(qr.a(bitmapDescriptor.getBitmap()));
        }
    }

    public void setPosition(LatLng latLng) {
        if (this.a != null) {
            this.a.a(qc.a(latLng));
        }
    }

    public void setRotation(float f) {
        if (this.a != null) {
            this.a.b(f);
        }
    }

    public void setSnippet(String str) {
        if (this.a != null) {
            this.a.a(str);
        }
    }

    public void setTitle(String str) {
        if (this.a != null) {
            this.a.b(str);
        }
    }

    public void setVisible(boolean z) {
        if (this.a != null) {
            this.a.b(z);
        }
    }

    public void showInfoWindow() {
        if (this.a != null) {
            this.a.l();
        }
    }

    public void set2Top() {
        if (this.a != null) {
            this.a.m();
        }
    }

    public View getMarkerView() {
        if (this.a != null) {
            return this.a.n();
        }
        return null;
    }

    public void setMarkerView(View view) {
        if (this.a != null) {
            this.a.a(view);
        }
    }

    public void setInfoWindowHideAnimation(Animation animation) {
        if (this.a != null) {
            this.a.a(animation);
        }
    }

    public void setInfoWindowShowAnimation(Animation animation) {
        if (this.a != null) {
            this.a.b(animation);
        }
    }

    public Object getTag() {
        if (this.a != null) {
            return this.a.o();
        }
        return null;
    }

    public void setTag(Object obj) {
        if (this.a != null) {
            this.a.a(obj);
        }
    }

    public void setZIndex(float f) {
    }

    public float getZIndex() {
        return 0.0f;
    }
}
