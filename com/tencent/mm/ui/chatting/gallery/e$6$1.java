package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import android.view.View;
import com.davemorrissey.labs.subscaleview.view.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.chatting.gallery.e.6;

class e$6$1 implements Runnable {
    final /* synthetic */ String tVn;
    final /* synthetic */ 6 tVo;
    final /* synthetic */ View val$view;

    e$6$1(6 6, View view, String str) {
        this.tVo = 6;
        this.val$view = view;
        this.tVn = str;
    }

    public final void run() {
        boolean z = true;
        6 6 = this.tVo;
        WxImageView wxImageView = (WxImageView) this.val$view;
        String str = this.tVo.fXW;
        String str2 = this.tVn;
        int i = this.tVo.tVm;
        if (e.b(6.tVi) != null && wxImageView != null && !bi.oW(str)) {
            a S;
            String str3 = "MicroMsg.ImageGalleryLazyLoader";
            String str4 = "alvinluo loadWxImageView position: %d, mLastPosition: %d, previewBitmap == null: %b, recycle: %b";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Integer.valueOf(e.k(6.tVi));
            objArr[2] = Boolean.valueOf(e.l(6.tVi) == null);
            if (e.l(6.tVi) == null || !e.l(6.tVi).isRecycled()) {
                z = false;
            }
            objArr[3] = Boolean.valueOf(z);
            x.i(str3, str4, objArr);
            if (i != e.k(6.tVi) || e.l(6.tVi) == null || e.l(6.tVi).isRecycled()) {
                S = !bi.oW(str2) ? a.S(str2) : null;
            } else {
                Bitmap l = e.l(6.tVi);
                if (l == null) {
                    throw new NullPointerException("Bitmap must not be null");
                }
                S = new a(l);
            }
            e.b(6.tVi).a(wxImageView, str, S);
        }
    }
}
