package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.a.b.g;
import com.tencent.mm.sdk.platformtools.x;

public class SightPlayAutoSizeImageView extends ImageView implements a {
    private b ndx;

    public SightPlayAutoSizeImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ndx = new a(this);
    }

    public SightPlayAutoSizeImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public String getVideoPath() {
        return this.ndx.nck;
    }

    public final void clear() {
        this.ndx.clear();
    }

    public final void aO(String str, boolean z) {
        this.ndx.aO(str, z);
    }

    public final boolean bvF() {
        return this.ndx.bvI();
    }

    public void setPosition(int i) {
        this.ndx.position = i;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        x.i("MicroMsg.SightPlayAutoSizeImageView", "#0x%x clear, on deattached to window", new Object[]{Integer.valueOf(hashCode())});
        this.ndx.clear();
        com.tencent.mm.sdk.b.a.sFg.c(this.ndx.bvK());
    }

    protected void onAttachedToWindow() {
        x.d("MicroMsg.SightPlayAutoSizeImageView", "#0x%x on attached from window", new Object[]{Integer.valueOf(hashCode())});
        super.onAttachedToWindow();
        com.tencent.mm.sdk.b.a.sFg.b(this.ndx.bvK());
    }

    public void setDrawableWidth(int i) {
    }

    public void setThumbBmp(Bitmap bitmap) {
        setImageBitmap(bitmap);
    }

    public final void bvE() {
        setImageBitmap(null);
        setImageResource(R.g.nosdcard_chatting_bg);
    }

    public void setMaskID(int i) {
    }

    public void setTagObject(Object obj) {
        setTag(obj);
    }

    public Object getTagObject() {
        return getTag();
    }

    public Context getUIContext() {
        return getContext();
    }

    public final void dt(int i, int i2) {
    }

    public void setCanPlay(boolean z) {
        this.ndx.ncF = z;
    }

    public void setOnCompletionListener(e eVar) {
        this.ndx.ncQ = eVar;
    }

    public void setOnSightCompletionAction(g gVar) {
    }

    public void setThumbBgView(View view) {
        this.ndx.setThumbBgView(view);
    }

    public void setIsWhatsNew(boolean z) {
        this.ndx.ncI = z;
    }

    public void setSightInfoView(TextView textView) {
        this.ndx.setSightInfoView(textView);
    }

    public void setForceRecordState(boolean z) {
        this.ndx.ncO = z;
    }

    public void setOnDecodeDurationListener(f fVar) {
        this.ndx.ncR = fVar;
    }
}
