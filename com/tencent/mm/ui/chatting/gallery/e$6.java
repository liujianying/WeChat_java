package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mm.sdk.platformtools.at.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.WxImageView;
import java.lang.ref.WeakReference;

class e$6 implements a {
    final /* synthetic */ String fXW;
    private Bitmap jDx = null;
    final /* synthetic */ e tVi;
    private boolean tVl = false;
    final /* synthetic */ int tVm;

    e$6(e eVar, String str, int i) {
        this.tVi = eVar;
        this.fXW = str;
        this.tVm = i;
    }

    public final boolean Ks() {
        e.d(this.tVi);
        if (!this.tVl) {
            int intValue;
            if (e.e(this.tVi).containsKey(this.fXW)) {
                intValue = ((Integer) e.e(this.tVi).get(this.fXW)).intValue();
                if (e.f(this.tVi)) {
                    e.a(this.tVi, intValue, this.jDx);
                } else {
                    e.g(this.tVi).put(intValue, this.jDx);
                }
            }
            this.tVi.u(this.fXW, this.jDx);
            this.tVi.b(this.tVm, this.jDx);
            String str = "MicroMsg.ImageGalleryLazyLoader";
            String str2 = "bmp size : %s";
            Object[] objArr = new Object[1];
            Bitmap bitmap = this.jDx;
            if (bitmap == null || bitmap.isRecycled()) {
                intValue = 0;
            } else {
                intValue = VERSION.SDK_INT >= 12 ? bitmap.getByteCount() : bitmap.getRowBytes() * bitmap.getHeight();
                if (intValue < 0) {
                    throw new IllegalStateException("Negative size: " + bitmap);
                }
            }
            objArr[0] = Integer.valueOf(intValue);
            x.i(str, str2, objArr);
            this.jDx = null;
        }
        e.h(this.tVi);
        return false;
    }

    public final boolean Kr() {
        if (e.b(this.tVi) == null || TextUtils.isEmpty(this.fXW)) {
            return false;
        }
        try {
            if (e.e(this.tVi).containsKey(this.fXW)) {
                int intValue = ((Integer) e.e(this.tVi).get(this.fXW)).intValue();
                WeakReference weakReference = (WeakReference) e.i(this.tVi).get(intValue);
                if (weakReference != null) {
                    View view = (View) weakReference.get();
                    if (view != null && (view instanceof WxImageView)) {
                        String str = (String) e.j(this.tVi).get(intValue);
                        this.tVl = true;
                        e.c(this.tVi).post(new 1(this, view, str));
                        return true;
                    }
                }
            }
            this.jDx = e.b(this.tVi).aaw(this.fXW);
            return true;
        } catch (Exception e) {
            x.w("MicroMsg.ImageGalleryLazyLoader", "try to load Bmp fail: %s", new Object[]{e.getMessage()});
            this.jDx = null;
            return false;
        }
    }
}
