package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.tools.MMGestureGallery;

public class GetHdHeadImageGalleryView extends MMGestureGallery {
    private String mQq;
    private o qFg;
    private Bitmap qFh;
    private Bitmap qFi;
    private a qFj;
    private String username;

    public GetHdHeadImageGalleryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public GetHdHeadImageGalleryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.qFj = new a(this, (byte) 0);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalFadingEdgeEnabled(false);
        setAdapter(this.qFj);
        setSelection(0);
        setSingleClickOverListener(new c(this, (byte) 0));
        setLongClickOverListener(new b(this, (byte) 0));
    }

    public void setParentWindow(o oVar) {
        this.qFg = oVar;
    }

    public void setHdHeadImagePath(String str) {
        this.mQq = str;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public void setThumbImage(Bitmap bitmap) {
        this.qFh = bitmap;
        this.qFj.notifyDataSetChanged();
    }

    public void setHdHeadImage(Bitmap bitmap) {
        this.qFi = bitmap;
        this.qFj.notifyDataSetChanged();
    }
}
