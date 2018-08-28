package com.tencent.mm.plugin.game.e;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.a;
import android.widget.ImageView;
import com.tencent.mm.a.f;
import com.tencent.mm.a.g;
import com.tencent.mm.ak.o;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.game.f.d;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.lang.ref.WeakReference;

public class e {
    private static final String kdl = (b.bnE + "Game/Image/");
    private static e kdm;
    private f<String, Bitmap> jTI = new f(6);
    private f<String, Bitmap> kax = new f(15);
    private ColorDrawable kdn = new ColorDrawable(a.g(ad.getContext(), com.tencent.mm.plugin.game.f.b.game_default_background));
    private Bitmap kdo;
    private Bitmap kdp;

    static /* synthetic */ Bitmap A(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return bitmap;
        }
        int width = bitmap.getHeight() > bitmap.getWidth() ? bitmap.getWidth() : bitmap.getHeight();
        return c.a(bitmap, width, width, false);
    }

    static /* synthetic */ Bitmap b(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width == i && height == i2) {
            return bitmap;
        }
        int i3;
        Bitmap createBitmap;
        int i4;
        float f = ((float) height) / ((float) i2);
        float f2 = ((float) width) / ((float) i);
        if (f < f2) {
            i3 = (int) (f * ((float) i));
            createBitmap = Bitmap.createBitmap(bitmap, (width - i3) / 2, 0, i3, height);
            i4 = height;
        } else {
            i4 = (int) (((float) i2) * f2);
            createBitmap = Bitmap.createBitmap(bitmap, 0, (height - i4) / 2, width, i4);
            i3 = width;
        }
        x.d("MicroMsg.GameImageUtil", "resizeBitmap, bitmapW = %d, bitmapH = %d, newWidth = %d, newHeight = %d", Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(i3), Integer.valueOf(i4));
        return createBitmap;
    }

    public static e aVj() {
        if (kdm == null) {
            synchronized (e.class) {
                if (kdm == null) {
                    kdm = new e();
                }
            }
        }
        return kdm;
    }

    private e() {
        try {
            this.kdo = BackwardSupportUtil.b.a(ad.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bp.a.getDensity(null));
            if (!(this.kdo == null || this.kdo.isRecycled())) {
                this.kdp = c.a(this.kdo, false, 0.5f * ((float) this.kdo.getWidth()));
            }
        } catch (Exception e) {
            x.i("MicroMsg.GameImageUtil", e.getMessage());
        }
        com.tencent.mm.plugin.ac.a.bmf().c(new 1(this));
    }

    public final void g(ImageView imageView, String str) {
        a(imageView, str, null, null);
    }

    public final void a(ImageView imageView, String str, a aVar) {
        a(imageView, str, aVar, null);
    }

    public final void a(ImageView imageView, String str, a aVar, b bVar) {
        if (!bi.oW(str)) {
            Object obj;
            if (aVar == null) {
                aVar = new a().aVk();
            }
            if (!aVar.dXw || aVar.kdC) {
                obj = null;
            } else {
                if (this.kax.bb(str)) {
                    Bitmap bitmap = (Bitmap) this.kax.get(str);
                    if (!(bitmap == null || bitmap.isRecycled())) {
                        if (imageView != null) {
                            imageView.setImageBitmap(bitmap);
                        }
                        if (bVar != null) {
                            bVar.a(imageView, bitmap);
                        }
                        obj = 1;
                    }
                }
                obj = null;
            }
            if (obj == null) {
                b(imageView, str, aVar, bVar);
            }
        }
    }

    private void b(ImageView imageView, String str, a aVar, b bVar) {
        com.tencent.mm.ak.a.a.c.a aVar2 = new com.tencent.mm.ak.a.a.c.a();
        aVar2.dXw = !aVar.kdC;
        File file = new File(kdl);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                File parentFile = file.getParentFile();
                File file2 = new File(parentFile.getAbsolutePath() + System.currentTimeMillis());
                if (file2.mkdir()) {
                    file2.renameTo(parentFile);
                } else {
                    x.e("MicroMsg.GameImageUtil", "mkdir error, %s", parentFile.getAbsolutePath());
                }
            }
            if (!(file.mkdir() && file.isDirectory())) {
                x.e("MicroMsg.GameImageUtil", "mkdir error. %s", r0);
            }
        }
        String str2 = kdl + g.u(str.getBytes());
        aVar2.dXy = aVar.dXy;
        if (aVar.kdC) {
            aVar2.dXy = false;
            com.tencent.mm.pluginsdk.g.a.d.a.Tr(str2);
        } else {
            aVar2.dXA = str2;
        }
        aVar2.dXW = aVar.dXW;
        aVar2.dXV = false;
        if (imageView != null && aVar.kdB) {
            if (aVar.kdD == 0) {
                imageView.setImageDrawable(this.kdn);
            } else {
                imageView.setImageResource(aVar.kdD);
            }
        }
        o.Pj().a(str, null, aVar2.Pt(), new 2(this, bVar, aVar, imageView));
    }

    public final void a(ImageView imageView, String str, int i, int i2, int i3) {
        3 3 = new 3(this, imageView, i2, i, i3);
        x.d("MicroMsg.GameImageUtil", "getBitmapWithWH, start");
        Bitmap bitmap = (Bitmap) this.kax.get(str);
        if (bitmap == null || bitmap.isRecycled()) {
            b(null, str, new a().aVk(), new 4(this, 3, i, i2, str));
        } else {
            3.a(null, bitmap);
        }
    }

    public final Bitmap h(ImageView imageView, String str) {
        Bitmap a = com.tencent.mm.aa.c.a(str, false, -1);
        if (a == null || a.isRecycled()) {
            if (this.kdo == null || this.kdo.isRecycled()) {
                try {
                    this.kdo = BackwardSupportUtil.b.a(ad.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bp.a.getDensity(null));
                } catch (Exception e) {
                }
            }
            if (!(this.kdo == null || this.kdo.isRecycled() || imageView == null)) {
                imageView.setImageBitmap(this.kdo);
            }
            return this.kdo;
        } else if (imageView == null) {
            return a;
        } else {
            imageView.setImageBitmap(a);
            return a;
        }
    }

    public final void a(ImageView imageView, String str, float f) {
        if (imageView != null && !bi.oW(str)) {
            Bitmap bitmap;
            if (this.jTI.bb(str)) {
                bitmap = (Bitmap) this.jTI.get(str);
                if (!(bitmap == null || bitmap.isRecycled())) {
                    imageView.setImageBitmap(bitmap);
                    return;
                }
            }
            bitmap = com.tencent.mm.pluginsdk.model.app.g.b(str, 1, f);
            if (bitmap == null || bitmap.isRecycled()) {
                imageView.setImageResource(d.game_default_icon);
                com.tencent.mm.plugin.ac.a.bmf().c(new 5(this, str, f, new WeakReference(imageView)));
                return;
            }
            imageView.setImageBitmap(bitmap);
            this.jTI.put(str, bitmap);
        }
    }
}
