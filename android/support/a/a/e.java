package android.support.a.a;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.v4.b.a.a;
import android.support.v4.b.a.l;
import android.util.AttributeSet;

@TargetApi(21)
abstract class e extends Drawable implements l {
    Drawable jJ;

    e() {
    }

    static TypedArray a(Resources resources, Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public void setColorFilter(int i, Mode mode) {
        if (this.jJ != null) {
            this.jJ.setColorFilter(i, mode);
        } else {
            super.setColorFilter(i, mode);
        }
    }

    public ColorFilter getColorFilter() {
        if (this.jJ != null) {
            return a.f(this.jJ);
        }
        return null;
    }

    protected boolean onLevelChange(int i) {
        if (this.jJ != null) {
            return this.jJ.setLevel(i);
        }
        return super.onLevelChange(i);
    }

    protected void onBoundsChange(Rect rect) {
        if (this.jJ != null) {
            this.jJ.setBounds(rect);
        } else {
            super.onBoundsChange(rect);
        }
    }

    public void setHotspot(float f, float f2) {
        if (this.jJ != null) {
            a.a(this.jJ, f, f2);
        }
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        if (this.jJ != null) {
            a.a(this.jJ, i, i2, i3, i4);
        }
    }

    public void setFilterBitmap(boolean z) {
        if (this.jJ != null) {
            this.jJ.setFilterBitmap(z);
        }
    }

    public void jumpToCurrentState() {
        if (this.jJ != null) {
            a.b(this.jJ);
        }
    }

    public void setAutoMirrored(boolean z) {
        if (this.jJ != null) {
            a.a(this.jJ, z);
        }
    }

    public boolean isAutoMirrored() {
        if (this.jJ != null) {
            a.c(this.jJ);
        }
        return false;
    }

    public void applyTheme(Theme theme) {
        if (this.jJ != null) {
            a.a(this.jJ, theme);
        }
    }

    public int getLayoutDirection() {
        if (this.jJ != null) {
            a.i(this.jJ);
        }
        return 0;
    }

    public void clearColorFilter() {
        if (this.jJ != null) {
            this.jJ.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    public Drawable getCurrent() {
        if (this.jJ != null) {
            return this.jJ.getCurrent();
        }
        return super.getCurrent();
    }

    public int getMinimumWidth() {
        if (this.jJ != null) {
            return this.jJ.getMinimumWidth();
        }
        return super.getMinimumWidth();
    }

    public int getMinimumHeight() {
        if (this.jJ != null) {
            return this.jJ.getMinimumHeight();
        }
        return super.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        if (this.jJ != null) {
            return this.jJ.getPadding(rect);
        }
        return super.getPadding(rect);
    }

    public int[] getState() {
        if (this.jJ != null) {
            return this.jJ.getState();
        }
        return super.getState();
    }

    public Region getTransparentRegion() {
        if (this.jJ != null) {
            return this.jJ.getTransparentRegion();
        }
        return super.getTransparentRegion();
    }

    public void setChangingConfigurations(int i) {
        if (this.jJ != null) {
            this.jJ.setChangingConfigurations(i);
        } else {
            super.setChangingConfigurations(i);
        }
    }

    public boolean setState(int[] iArr) {
        if (this.jJ != null) {
            return this.jJ.setState(iArr);
        }
        return super.setState(iArr);
    }
}
