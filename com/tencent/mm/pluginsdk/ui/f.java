package com.tencent.mm.pluginsdk.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.aa.g;
import com.tencent.mm.aa.q;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.webview.ui.tools.widget.m;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.s;

public final class f {
    private static final Drawable kXh = new ColorDrawable();
    private Activity activity;
    private String fsq;
    public o kXg;
    private GetHdHeadImageGalleryView kXi;
    private g mQp;
    private String qFo;
    private b qFp;
    private int qFq;
    private String username;

    public f(Activity activity, String str) {
        this(activity, str, null);
    }

    public f(Activity activity, String str, String str2) {
        this(activity, str, str2, a.qFt);
    }

    public f(Activity activity, String str, String str2, int i) {
        this(activity, str, str2, i, (byte) 0);
    }

    private f(Activity activity, String str, String str2, int i, byte b) {
        this.qFo = null;
        this.fsq = null;
        this.activity = activity;
        this.username = str;
        this.fsq = str2;
        this.qFp = null;
        this.qFq = i;
    }

    public final void cde() {
        View inflate = LayoutInflater.from(this.activity).inflate(R.i.get_hd_head_image_gallery_view, null);
        this.kXg = new o(inflate, -1, -1);
        switch (3.qFs[this.qFq - 1]) {
            case 1:
                this.kXg.setAnimationStyle(R.m.PopLeftTopAnimation);
                break;
            case 2:
                this.kXg.setAnimationStyle(R.m.PopRightTopAnimation);
                break;
            case 3:
                this.kXg.setAnimationStyle(R.m.PopLeftBottomAnimation);
                break;
        }
        this.kXg.setFocusable(true);
        this.kXg.setOutsideTouchable(true);
        this.kXg.setBackgroundDrawable(kXh);
        this.kXg.showAtLocation(this.activity.getWindow().getDecorView(), 49, 0, 0);
        this.kXg.setOnDismissListener(new 1(this));
        this.kXi = (GetHdHeadImageGalleryView) inflate.findViewById(R.h.gallery);
        this.kXi.setParentWindow(this.kXg);
        this.kXi.setUsername(this.username);
        m.Bk(1);
        au.HU();
        if (c.isSDCardAvailable()) {
            Bitmap d = !bi.oW(this.fsq) ? com.tencent.mm.ac.m.d(this.username, this.fsq, R.g.nosdcard_headimg) : com.tencent.mm.aa.c.a(this.username, true, -1);
            if (d == null) {
                d = BitmapFactory.decodeResource(this.activity.getResources(), R.g.default_avatar);
            }
            if (d == null || d.isRecycled()) {
                x.i("MicroMsg.GetHdHeadImg", "The avatar of %s is not in the cache, use default avatar", new Object[]{this.username});
            } else {
                x.i("MicroMsg.GetHdHeadImg", "The avatar of %s is in the cache", new Object[]{this.username});
                this.kXi.setThumbImage(d);
            }
            if (!bi.oW(this.qFo)) {
                this.username = this.qFo;
            }
            Bitmap jU = q.Kp().jU(this.username);
            if (jU == null || jU.isRecycled()) {
                this.mQp = new g();
                this.mQp.a(this.username, new 2(this, d));
                return;
            }
            x.i("MicroMsg.GetHdHeadImg", "The HDAvatar of %s is already exists", new Object[]{this.username});
            d(jU, q.Kp().c(this.username, true, false));
            return;
        }
        s.gH(this.activity);
        d(q.Kp().bJ(this.activity), null);
    }

    private void d(Bitmap bitmap, String str) {
        try {
            Bitmap createBitmap;
            if (bitmap.getWidth() < 480) {
                float width = (float) (480 / bitmap.getWidth());
                Matrix matrix = new Matrix();
                matrix.postScale(width, width);
                createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            } else {
                createBitmap = bitmap;
            }
            x.d("MicroMsg.GetHdHeadImg", "dkhdbm old[%d %d] new[%d %d]", new Object[]{Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(createBitmap.getWidth()), Integer.valueOf(createBitmap.getHeight())});
            this.kXi.setHdHeadImage(createBitmap);
            this.kXi.setHdHeadImagePath(str);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.GetHdHeadImg", e, "", new Object[0]);
        }
    }
}
