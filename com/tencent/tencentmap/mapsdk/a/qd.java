package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.map.UiSettings;

public class qd implements UiSettings {
    private ub a;

    public qd(ub ubVar) {
        this.a = ubVar;
    }

    public boolean isAnimationEnabled() {
        if (this.a != null) {
            return this.a.a();
        }
        return false;
    }

    public void setAnimationEnabled(boolean z) {
        if (this.a != null) {
            this.a.a(z);
        }
    }

    public void setScaleControlsEnabled(boolean z) {
        if (this.a != null) {
            this.a.b(z);
        }
    }

    public void setScrollGesturesEnabled(boolean z) {
        if (this.a != null) {
            this.a.c(z);
        }
    }

    public void setZoomGesturesEnabled(boolean z) {
        if (this.a != null) {
            this.a.d(z);
        }
    }

    public void setAllGesturesEnabled(boolean z) {
        if (this.a != null) {
            this.a.c(z);
            this.a.d(z);
        }
    }

    public void setLogoPosition(int i) {
        if (this.a != null) {
            this.a.a(i);
        }
    }

    public void setScaleViewPosition(int i) {
        if (this.a != null) {
            this.a.b(i);
        }
    }

    public boolean isScaleControlsEnabled() {
        if (this.a != null) {
            return this.a.b();
        }
        return false;
    }

    public boolean isTiltGesturesEnabled() {
        return false;
    }

    public boolean isRotateGesturesEnabled() {
        return false;
    }

    public void setTiltGesturesEnabled(boolean z) {
    }

    public void setRotateGesturesEnabled(boolean z) {
    }
}
