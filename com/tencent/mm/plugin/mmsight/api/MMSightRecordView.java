package com.tencent.mm.plugin.mmsight.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class MMSightRecordView extends FrameLayout {
    public static b leC;
    public d leB;

    public interface f {
        void cN(boolean z);
    }

    public MMSightRecordView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public MMSightRecordView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public MMSightRecordView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.leB = leC.ZR();
        this.leB.b(context, this);
    }

    public void setInitErrorCallback(c cVar) {
        this.leB.setInitErrorCallback(cVar);
    }

    public void setDisplayRatio(float f) {
        this.leB.setDisplayRatio(f);
    }

    public void setPreviewSizeLimit(int i) {
        this.leB.setPreviewSizeLimit(i);
    }

    public final void setVideoPara$2e715812(int i) {
        this.leB.setVideoPara$2e715812(i);
    }

    public void setVideoFilePath(String str) {
        this.leB.setVideoFilePath(str);
    }

    public String getVideoFilePath() {
        return this.leB.getVideoFilePath();
    }

    public final void a(f fVar) {
        this.leB.a(fVar);
    }

    public final void a(e eVar, boolean z) {
        this.leB.a(eVar, z);
    }

    public void setUseBackCamera(boolean z) {
        this.leB.setUseBackCamera(z);
    }

    public Point getPictureSize() {
        return this.leB.getPictureSize();
    }

    public Point getVideoSize() {
        return this.leB.getVideoSize();
    }

    public void setFrameDataCallback(a aVar) {
        this.leB.setFrameDataCallback(aVar);
    }

    public int getCameraRotation() {
        return this.leB.getCameraRotation();
    }

    public void setClipVideoSize(boolean z) {
        this.leB.setClipVideoSize(z);
    }

    public void setClipPictureSize(boolean z) {
        this.leB.setClipPictureSize(z);
    }

    public void setFlashMode(int i) {
        this.leB.setFlashMode(i);
    }

    public int getFlashMode() {
        return this.leB.getFlashMode();
    }

    public void setEnableDragZoom(boolean z) {
        this.leB.setEnableDragZoom(z);
    }

    public void setEnableTouchFocus(boolean z) {
        this.leB.setEnableTouchFocus(z);
    }

    public Bitmap getCurrentFramePicture() {
        return this.leB.getCurrentFramePicture();
    }
}
