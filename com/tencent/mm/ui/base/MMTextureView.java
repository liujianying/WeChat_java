package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.TextureView;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;

@TargetApi(14)
public class MMTextureView extends TextureView {
    private Field tyk;

    public MMTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MMTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MMTextureView(Context context) {
        super(context);
    }

    @TargetApi(14)
    public void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMTextureView", e, "unkown error", new Object[0]);
        }
    }

    public final void crS() {
        if (d.fS(16)) {
            x.i("MicroMsg.MMTextureView", "current API Level %d, do not do sly", new Object[]{Integer.valueOf(VERSION.SDK_INT)});
        } else if (d.fT(20)) {
            x.i("MicroMsg.MMTextureView", "current API Level %d, do not do sly", new Object[]{Integer.valueOf(VERSION.SDK_INT)});
        } else if (q.deW.deo == 2) {
            x.i("MicroMsg.MMTextureView", "do not do sly textureView, config ERROR");
        } else {
            x.i("MicroMsg.MMTextureView", "detect texture problem, sly");
            try {
                if (this.tyk == null) {
                    this.tyk = TextureView.class.getDeclaredField("mSurface");
                    this.tyk.setAccessible(true);
                }
                SurfaceTexture surfaceTexture = (SurfaceTexture) this.tyk.get(this);
                if (surfaceTexture == null) {
                    x.i("MicroMsg.MMTextureView", "detect texture problem, no wrap");
                } else if (surfaceTexture instanceof r) {
                    x.i("MicroMsg.MMTextureView", "detect texture problem, wrapped");
                } else {
                    r rVar = new r();
                    rVar.iSV = surfaceTexture;
                    this.tyk.set(this, rVar);
                    x.i("MicroMsg.MMTextureView", "detect texture problem, wrap");
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMTextureView", e, "", new Object[0]);
                x.e("MicroMsg.MMTextureView", "detect texture problem, NoSuchFieldException");
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.MMTextureView", e2, "", new Object[0]);
                x.e("MicroMsg.MMTextureView", "detect texture problem, IllegalArgumentException");
            } catch (Throwable e22) {
                x.printErrStackTrace("MicroMsg.MMTextureView", e22, "", new Object[0]);
                x.e("MicroMsg.MMTextureView", "detect texture problem, IllegalAccessException");
            }
        }
    }

    @TargetApi(16)
    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        super.setSurfaceTexture(surfaceTexture);
        crS();
    }
}
