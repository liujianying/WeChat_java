package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.mm.aa.c;
import com.tencent.mm.aa.q;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.at.a;
import com.tencent.mm.sdk.platformtools.bi;
import java.lang.ref.WeakReference;

public final class d {
    Context context;
    private ag dvh = new ag(Looper.getMainLooper());
    at ktR = new at(5, "IPCallAddressAvatarLoader", 1, Looper.getMainLooper());
    aa<String, WeakReference<Bitmap>> ktS = new aa(50);

    static /* synthetic */ void a(d dVar, final ImageView imageView, final String str, final Bitmap bitmap) {
        if (bitmap != null) {
            dVar.ktS.put(str, new WeakReference(bitmap));
            dVar.dvh.post(new Runnable() {
                public final void run() {
                    if (imageView.getTag() != null && imageView.getTag().equals(str) && bitmap != null && !bitmap.isRecycled()) {
                        imageView.setImageBitmap(bitmap);
                    }
                }
            });
        }
    }

    public d(Context context) {
        this.context = context;
    }

    public final void a(String str, String str2, ImageView imageView) {
        if (!bi.oW(str) && !bi.oW(str2) && imageView != null) {
            String ds = ds(str, str2);
            imageView.setTag(ds);
            if (!d(ds(str, str2), imageView)) {
                this.ktR.c(new 1(this, str, ds, imageView, str2));
            }
        }
    }

    public final void b(final String str, final ImageView imageView) {
        if (!bi.oW(str) && imageView != null) {
            final String Fb = Fb(str);
            imageView.setTag(Fb);
            if (!d(Fb(str), imageView)) {
                this.ktR.c(new a() {
                    public final boolean Kr() {
                        d.a(d.this, imageView, Fb, com.tencent.mm.plugin.ipcall.b.a.ay(d.this.context, str));
                        return true;
                    }

                    public final boolean Ks() {
                        return true;
                    }
                });
            }
        }
    }

    public final void c(final String str, final ImageView imageView) {
        if (!bi.oW(str) && imageView != null) {
            final String Fa = Fa(str);
            imageView.setTag(Fa);
            if (!d(Fa(str), imageView)) {
                this.ktR.c(new a() {
                    public final boolean Kr() {
                        Bitmap a = c.a(str, false, -1);
                        if (a == null) {
                            a = q.Kp().jT(str);
                        }
                        d.a(d.this, imageView, Fa, a);
                        return true;
                    }

                    public final boolean Ks() {
                        return false;
                    }
                });
            }
        }
    }

    private boolean d(String str, ImageView imageView) {
        WeakReference weakReference = (WeakReference) this.ktS.get(str);
        if (weakReference != null) {
            Bitmap bitmap = (Bitmap) weakReference.get();
            if (!(bitmap == null || imageView.getTag() == null || !imageView.getTag().toString().equals(str))) {
                if (!(bitmap == null || bitmap.isRecycled())) {
                    imageView.setImageBitmap(bitmap);
                }
                return true;
            }
        }
        return false;
    }

    private static String Fa(String str) {
        return str + "@username";
    }

    private static String Fb(String str) {
        return str + "@contactId";
    }

    public static String ds(String str, String str2) {
        return str + "@" + str2 + "@contactId@username";
    }
}
