package com.tencent.mm.plugin.mmsight.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.ViewGroup;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.c;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.f;

public abstract class MMSightRecordView$d {
    public abstract void ZS();

    public abstract void ZX();

    public abstract void ZY();

    public abstract void a(e eVar, boolean z);

    public abstract void a(f fVar);

    public abstract void b(Context context, ViewGroup viewGroup);

    public abstract int getCameraRotation();

    public abstract Bitmap getCurrentFramePicture();

    public abstract int getFlashMode();

    public abstract Point getPictureSize();

    public abstract String getVideoFilePath();

    public abstract Point getVideoSize();

    public abstract void release();

    public abstract void setClipPictureSize(boolean z);

    public abstract void setClipVideoSize(boolean z);

    public abstract void setDisplayRatio(float f);

    public abstract void setEnableDragZoom(boolean z);

    public abstract void setEnableTouchFocus(boolean z);

    public abstract void setFlashMode(int i);

    public abstract void setFrameDataCallback(MMSightRecordView$a mMSightRecordView$a);

    public abstract void setInitErrorCallback(c cVar);

    public abstract void setPreviewSizeLimit(int i);

    public abstract void setUseBackCamera(boolean z);

    public abstract void setVideoFilePath(String str);

    public abstract void setVideoPara$2e715812(int i);

    public abstract void startPreview();

    public abstract void switchCamera();

    public abstract boolean wn();
}
