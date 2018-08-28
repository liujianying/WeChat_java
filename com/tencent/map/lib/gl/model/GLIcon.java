package com.tencent.map.lib.gl.model;

import android.graphics.Bitmap;
import android.graphics.RectF;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.gl.model.a.a;

public class GLIcon extends a implements a {
    public static final int BOTTOM = 16;
    public static final int CENTER = 1;
    public static final int LEFT = 4096;
    public static final int RIGHT = 65536;
    public static final int TOP = 256;
    private float mAlpha;
    private float mAnchorPointX;
    private float mAnchorPointY;
    private boolean mAvoidAnno;
    private float mBottomPartLen;
    private RectF mBounds;
    private int mCurrentState;
    public int mDisplayId;
    private boolean mFastLoad;
    private boolean mFixPos;
    private boolean mFlat;
    private boolean mHasIconChanged;
    private String mIconName;
    public Bitmap[] mIcons;
    private boolean mIsDirty;
    private int mLastIconHei;
    private String mLastIconName;
    private int mLastIconWid;
    private float mLeftPartLen;
    private int mOffsetX;
    private int mOffsetY;
    public double mPositionX;
    public double mPositionY;
    private float mRightPartLen;
    private int mRotateAngle;
    private float mScaleX;
    private float mScaleY;
    private float mTopPartLen;

    public GLIcon(String str, GeoPoint geoPoint, Bitmap... bitmapArr) {
        this(str, geoPoint, 0.5f, 0.5f, 0, 0, bitmapArr);
    }

    public GLIcon(String str, GeoPoint geoPoint, float f, float f2, Bitmap... bitmapArr) {
        this(str, geoPoint, f, f2, 0, 0, bitmapArr);
    }

    public GLIcon(String str, GeoPoint geoPoint, float f, float f2, int i, int i2, Bitmap... bitmapArr) {
        this.mCurrentState = 0;
        this.mAnchorPointX = 0.5f;
        this.mAnchorPointY = 0.5f;
        this.mIsDirty = false;
        this.mLeftPartLen = 0.0f;
        this.mRightPartLen = 0.0f;
        this.mTopPartLen = 0.0f;
        this.mBottomPartLen = 0.0f;
        this.mAlpha = 1.0f;
        this.mRotateAngle = 0;
        this.mScaleX = 1.0f;
        this.mScaleY = 1.0f;
        this.mFixPos = false;
        this.mFlat = true;
        this.mHasIconChanged = false;
        this.mFastLoad = false;
        this.mAvoidAnno = false;
        setAdapter(this);
        this.mAnchorPointX = f;
        this.mAnchorPointY = f2;
        this.mOffsetX = i;
        this.mOffsetY = i2;
        if (geoPoint != null) {
            this.mPositionX = ((double) geoPoint.getLongitudeE6()) / 1000000.0d;
            this.mPositionY = ((double) geoPoint.getLatitudeE6()) / 1000000.0d;
        }
        update(str, bitmapArr);
    }

    protected void build(int i, int i2) {
        if (this.mLastIconWid != i || this.mLastIconHei != i2) {
            this.mLastIconWid = i;
            this.mLastIconHei = i2;
            float f = ((float) this.mOffsetX) / ((float) i);
            float f2 = ((float) this.mOffsetY) / ((float) i2);
            this.mBounds = new RectF(f, -f2, 0.0f, -0.0f);
            this.mAnchorPointX -= f;
            this.mAnchorPointY -= f2;
            this.mLeftPartLen = ((float) (-this.mLastIconWid)) * this.mAnchorPointX;
            this.mRightPartLen = ((float) this.mLastIconWid) + this.mLeftPartLen;
            this.mTopPartLen = ((float) this.mLastIconHei) * this.mAnchorPointY;
            this.mBottomPartLen = this.mTopPartLen - ((float) this.mLastIconHei);
        }
    }

    public void setOffset(int i, int i2) {
        this.mOffsetX = i;
        this.mOffsetY = i2;
        setDirty(true);
    }

    public void setPosition(GeoPoint geoPoint) {
        if (geoPoint != null) {
            double d = this.mFixPos ? 1.0d : 1000000.0d;
            this.mPositionX = ((double) geoPoint.getLongitudeE6()) / d;
            this.mPositionY = ((double) geoPoint.getLatitudeE6()) / d;
            setDirty(true);
        }
    }

    public void setDirty(boolean z) {
        this.mIsDirty = z;
    }

    public boolean isDirty() {
        return this.mIsDirty;
    }

    public void setIconChanged(boolean z) {
        this.mHasIconChanged = z;
        if (!z) {
            this.mLastIconName = this.mIconName;
        }
    }

    public boolean isIconChanged() {
        return this.mHasIconChanged;
    }

    public final synchronized void update(String str, Bitmap... bitmapArr) {
        if (bitmapArr != null) {
            setDirty(true);
            setIconChanged(true);
            this.mIconName = str;
            this.mIcons = bitmapArr;
            if (this.mCurrentState < 0 || this.mCurrentState >= bitmapArr.length) {
                this.mCurrentState = 0;
            }
            if (bitmapArr[this.mCurrentState] != null) {
                build(bitmapArr[this.mCurrentState].getWidth(), bitmapArr[this.mCurrentState].getHeight());
            }
        }
    }

    public String getLastName() {
        return this.mLastIconName;
    }

    public void setAnchor(float f, float f2) {
        this.mAnchorPointX = f;
        this.mAnchorPointY = f2;
        build(this.mLastIconWid, this.mLastIconHei);
        setDirty(true);
    }

    public float getAnchroX() {
        return this.mAnchorPointX;
    }

    public float getAnchorY() {
        return this.mAnchorPointY;
    }

    public void setAlpha(float f) {
        this.mAlpha = f;
        setDirty(true);
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public void setScale(float f, float f2) {
        this.mScaleX = f;
        this.mScaleY = f2;
        setDirty(true);
    }

    public float getScaleX() {
        return this.mScaleX;
    }

    public float getScaleY() {
        return this.mScaleY;
    }

    public void setRotateAngle(int i) {
        this.mRotateAngle = i;
        setDirty(true);
    }

    public float getRotateAngle() {
        return (float) this.mRotateAngle;
    }

    public void setFixPos(boolean z) {
        this.mFixPos = z;
    }

    public boolean isFixPos() {
        return this.mFixPos;
    }

    public void setFastLoad(boolean z) {
        this.mFastLoad = z;
    }

    public boolean isFastLoad() {
        return this.mFastLoad;
    }

    public void setFlat(boolean z) {
        this.mFlat = z;
    }

    public boolean isFlat() {
        return this.mFlat;
    }

    public void setAvoidAnno(boolean z) {
        this.mAvoidAnno = z;
    }

    public boolean isAvoidAnno() {
        return this.mAvoidAnno;
    }

    public synchronized void setState(int i) {
        this.mCurrentState = i;
        setDirty(true);
        setIconChanged(true);
        Bitmap bmByState = getBmByState(i);
        if (bmByState != null) {
            int width = bmByState.getWidth();
            int height = bmByState.getHeight();
            if (!(this.mLastIconWid == width && this.mLastIconHei == height)) {
                build(width, height);
            }
        }
        super.setState(i);
    }

    public RectF getBounds() {
        return new RectF(this.mBounds);
    }

    public boolean hasTexture() {
        return true;
    }

    public String getTextureUID() {
        return this.mIconName;
    }

    public synchronized Bitmap getTextureBm(int i) {
        return getBmByState(getState());
    }

    private Bitmap getBmByState(int i) {
        if (this.mIcons == null) {
            return null;
        }
        if (i < 0 || i >= this.mIcons.length) {
            return this.mIcons[0];
        }
        return this.mIcons[i];
    }

    public String getIconName() {
        return this.mIconName;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof GLIcon) && this.mDisplayId == ((GLIcon) obj).mDisplayId) {
            return true;
        }
        return false;
    }

    public float getLeft() {
        return this.mLeftPartLen;
    }

    public float getRight() {
        return this.mRightPartLen;
    }

    public float getTop() {
        return this.mTopPartLen;
    }

    public float getBottom() {
        return this.mBottomPartLen;
    }
}
