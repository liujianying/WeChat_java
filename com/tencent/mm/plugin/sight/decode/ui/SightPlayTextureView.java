package com.tencent.mm.plugin.sight.decode.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.a.b.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTextureView;
import java.lang.ref.WeakReference;

@TargetApi(14)
public class SightPlayTextureView extends MMTextureView implements com.tencent.mm.plugin.sight.decode.a.a {
    private Surface mSurface;
    private boolean ndF;
    private int ndK;
    private com.tencent.mm.plugin.sight.decode.a.b ndx;
    private int ndz;
    private int videoHeight;
    private int videoWidth;

    private static final class a implements Runnable {
        Surface ndM;

        private a() {
            this.ndM = null;
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void run() {
            if (this.ndM != null) {
                this.ndM.release();
            }
        }
    }

    private static final class b extends com.tencent.mm.plugin.sight.decode.a.b {
        private WeakReference<SightPlayTextureView> ndN;

        protected final int bvG() {
            return R.a.sight_loop;
        }

        public b(SightPlayTextureView sightPlayTextureView) {
            super(1, sightPlayTextureView);
            this.ndN = new WeakReference(sightPlayTextureView);
        }

        public final void cl(int i, int i2) {
            if (this.ndN.get() == null) {
                x.e("MicroMsg.SightPlayTextureView", "onGetVideoSizeEnd, textureView is null, do clear");
                clear();
                return;
            }
            ((SightPlayTextureView) this.ndN.get()).videoWidth = i;
            ((SightPlayTextureView) this.ndN.get()).videoHeight = i2;
            x.d("MicroMsg.SightPlayTextureView", "on get video size %d*%d, needAutoResizeChatting: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(((SightPlayTextureView) this.ndN.get()).ndF)});
            final LayoutParams layoutParams = ((SightPlayTextureView) this.ndN.get()).getLayoutParams();
            if (((SightPlayTextureView) this.ndN.get()).ndF && i > 0 && i2 > 0) {
                if (i >= i2) {
                    ((SightPlayTextureView) this.ndN.get()).ndz = com.tencent.mm.bp.a.fromDPToPix(((SightPlayTextureView) this.ndN.get()).getContext(), 150);
                } else {
                    ((SightPlayTextureView) this.ndN.get()).ndz = com.tencent.mm.bp.a.fromDPToPix(((SightPlayTextureView) this.ndN.get()).getContext(), 85);
                }
            }
            if (layoutParams.height != (((SightPlayTextureView) this.ndN.get()).ndz * i2) / i) {
                layoutParams.width = ((SightPlayTextureView) this.ndN.get()).ndz;
                layoutParams.height = (((SightPlayTextureView) this.ndN.get()).ndz * i2) / i;
                if (((SightPlayTextureView) this.ndN.get()).ndF && layoutParams.height < com.tencent.mm.bp.a.fromDPToPix(((SightPlayTextureView) this.ndN.get()).getContext(), 50)) {
                    layoutParams.height = com.tencent.mm.bp.a.fromDPToPix(((SightPlayTextureView) this.ndN.get()).getContext(), 50);
                }
                x.i("MicroMsg.SightPlayTextureView", "params width %d height %d", new Object[]{Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height)});
                if (ah.isMainThread()) {
                    ((SightPlayTextureView) this.ndN.get()).setLayoutParams(layoutParams);
                } else {
                    ah.A(new Runnable() {
                        public final void run() {
                            ((SightPlayTextureView) b.this.ndN.get()).setLayoutParams(layoutParams);
                        }
                    });
                }
            }
            this.ncp = com.tencent.mm.plugin.sight.decode.a.b.b(((SightPlayTextureView) this.ndN.get()).getContext(), ((SightPlayTextureView) this.ndN.get()).ndK, ((SightPlayTextureView) this.ndN.get()).ndz, i, i2);
        }

        public final void E(Bitmap bitmap) {
        }
    }

    public SightPlayTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ndF = false;
        setOpaque(false);
        this.ndx = new b(this);
        setSurfaceTextureListener(new 1(this));
    }

    public SightPlayTextureView(Context context, AttributeSet attributeSet) {
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
        x.i("MicroMsg.SightPlayTextureView", "#0x%x clear, on deattached to window", new Object[]{Integer.valueOf(hashCode())});
        this.ndx.clear();
        com.tencent.mm.sdk.b.a.sFg.c(this.ndx.bvK());
    }

    protected void onAttachedToWindow() {
        x.d("MicroMsg.SightPlayTextureView", "#0x%x on attached from window", new Object[]{Integer.valueOf(hashCode())});
        super.onAttachedToWindow();
        com.tencent.mm.sdk.b.a.sFg.b(this.ndx.bvK());
    }

    public void setDrawableWidth(int i) {
        this.ndz = i;
        w(0.75d);
    }

    private void w(double d) {
        final LayoutParams layoutParams = getLayoutParams();
        if (layoutParams.height != ((int) (((double) this.ndz) * d))) {
            layoutParams.width = this.ndz;
            layoutParams.height = (int) (((double) this.ndz) * d);
            if (this.ndF && layoutParams.height < com.tencent.mm.bp.a.fromDPToPix(getContext(), 50)) {
                layoutParams.height = com.tencent.mm.bp.a.fromDPToPix(getContext(), 50);
            }
            x.i("MicroMsg.SightPlayTextureView", "params width %d height %d", new Object[]{Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height)});
            if (ah.isMainThread()) {
                setLayoutParams(layoutParams);
            } else {
                ah.A(new Runnable() {
                    public final void run() {
                        SightPlayTextureView.this.setLayoutParams(layoutParams);
                    }
                });
            }
        }
    }

    public void setThumbBmp(Bitmap bitmap) {
        String str = "MicroMsg.SightPlayTextureView";
        String str2 = "thumb is null? %B, surface is null? %B";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(bitmap == null);
        objArr[1] = Boolean.valueOf(this.mSurface == null);
        x.d(str, str2, objArr);
        if (bitmap != null) {
            x.d("MicroMsg.SightPlayTextureView", "thumb size [%d, %d]", new Object[]{Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())});
            if (this.ndF) {
                if (bitmap.getWidth() >= bitmap.getHeight()) {
                    this.ndz = com.tencent.mm.bp.a.fromDPToPix(getContext(), 150);
                } else {
                    this.ndz = com.tencent.mm.bp.a.fromDPToPix(getContext(), 85);
                }
            }
            Bitmap b = com.tencent.mm.plugin.sight.decode.a.b.b(getContext(), this.ndK, this.ndz, bitmap.getWidth(), bitmap.getHeight());
            w(((double) bitmap.getHeight()) / ((double) bitmap.getWidth()));
            this.ndx.ncp = b;
            this.ndx.D(bitmap);
            return;
        }
        this.ndx.D(null);
    }

    public final void bvE() {
        SightVideoJNI.drawSurfaceThumb(this.mSurface, com.tencent.mm.plugin.sight.decode.a.b.b(getContext(), R.g.nosdcard_chatting_bg, this.ndz, 320, 240), com.tencent.mm.plugin.sight.decode.a.b.b(getContext(), this.ndK, this.ndz, 320, 240));
    }

    public void setMaskID(int i) {
        this.ndK = i;
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
        LayoutParams layoutParams = getLayoutParams();
        this.ndz = i;
        layoutParams.width = this.ndz;
        layoutParams.height = (this.ndz * i2) / i;
        x.i("MicroMsg.SightPlayTextureView", "params width %d height %d", new Object[]{Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height)});
        if (ah.isMainThread()) {
            setLayoutParams(layoutParams);
        } else {
            ah.A(new 3(this, layoutParams));
        }
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
    }

    public void setOnDecodeDurationListener(f fVar) {
        this.ndx.ncR = fVar;
    }
}
