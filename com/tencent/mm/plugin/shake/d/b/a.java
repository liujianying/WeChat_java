package com.tencent.mm.plugin.shake.d.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.w.b;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.shake.d.a.i;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends BitmapDrawable implements com.tencent.mm.platformtools.y.a {
    private static final Paint dvs;
    private static Bitmap mZd;
    private int kdD;
    private String mZa;
    private ImageView mZb;
    private w mZc;
    private int type;
    private String username;

    private static class a implements w {
        private String mZa;

        public a(String str) {
            this.mZa = str;
        }

        public final String Vv() {
            return a.JC(this.mZa);
        }

        public final String Vw() {
            return this.mZa;
        }

        public final String Vx() {
            return this.mZa;
        }

        public final String getCacheKey() {
            return this.mZa;
        }

        public final boolean Vy() {
            return true;
        }

        public final boolean Vz() {
            return false;
        }

        public final Bitmap VA() {
            return BitmapFactory.decodeResource(ad.getContext().getResources(), R.g.nosdcard_chatting_bg);
        }

        public final Bitmap a(Bitmap bitmap, com.tencent.mm.platformtools.w.a aVar, String str) {
            if (com.tencent.mm.platformtools.w.a.evZ == aVar) {
                try {
                    c.a(bitmap, 100, CompressFormat.PNG, a.JC(this.mZa), false);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.ShakeAvatarDrawable", e, "", new Object[0]);
                    x.w("MicroMsg.ShakeAvatarDrawable", "save bitmap fail");
                }
            }
            x.d("MicroMsg.ShakeAvatarDrawable", "get bitmap, from %s", new Object[]{aVar.toString()});
            return bitmap;
        }

        public final void VB() {
        }

        public final void P(String str, boolean z) {
        }

        public final void a(com.tencent.mm.platformtools.w.a aVar, String str) {
        }

        public final b Vu() {
            return null;
        }
    }

    static {
        Paint paint = new Paint();
        dvs = paint;
        paint.setAntiAlias(true);
        dvs.setFilterBitmap(true);
    }

    public final void draw(Canvas canvas) {
        x.i("MicroMsg.ShakeAvatarDrawable", "album username[%s], url[%s], type[%d], attr[%s]", new Object[]{this.username, this.mZa, Integer.valueOf(this.type), toString()});
        if (4 == this.type || (k.vY(this.type) && 6 != this.type)) {
            Bitmap a;
            if (4 == this.type) {
                this.mZc = new a(this.mZa);
                a = y.a(this.mZc);
            } else if (!k.vY(this.type) || 6 == this.type) {
                a = null;
            } else {
                this.mZc = new com.tencent.mm.plugin.shake.e.b(this.mZa);
                a = y.a(this.mZc);
            }
            if (a == null || a.isRecycled()) {
                x.i("MicroMsg.ShakeAvatarDrawable", "bm is null or recycled, album url[%s]", new Object[]{this.mZa});
                a = F(this.mZb, this.kdD);
            }
            if (a != null) {
                canvas.drawBitmap(a, null, getBounds(), dvs);
            }
        }
    }

    private static Bitmap F(View view, int i) {
        if (view == null) {
            return mZd;
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (mZd == null || mZd.getWidth() != measuredWidth) {
            if (i > 0) {
                try {
                    mZd = c.s(view.getResources().getDrawable(i));
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.ShakeAvatarDrawable", e, "", new Object[0]);
                }
            } else {
                mZd = BackwardSupportUtil.b.a(ad.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bp.a.getDensity(null));
            }
            if (mZd.getWidth() != measuredWidth && measuredWidth > 0 && measuredHeight > 0) {
                mZd = Bitmap.createScaledBitmap(mZd, measuredWidth, measuredHeight, true);
            }
        }
        return mZd;
    }

    public final void m(String str, final Bitmap bitmap) {
        x.i("MicroMsg.ShakeAvatarDrawable", "type[%d] notifyKey[%s] albumUrl[%s]", new Object[]{Integer.valueOf(this.type), str, this.mZa});
        if (this.mZc != null && str.equals(this.mZc.Vx())) {
            if (4 == this.type || (k.vY(this.type) && 6 != this.type)) {
                this.mZb.post(new Runnable() {
                    public final void run() {
                        a.this.mZb.setImageBitmap(bitmap);
                    }
                });
            }
        }
    }

    public static String JC(String str) {
        if (bi.oW(str)) {
            x.w("MicroMsg.ShakeAvatarDrawable", "getStoragePath: but url is null");
            return null;
        }
        if (bi.oW(i.bvg())) {
            x.w("MicroMsg.ShakeAvatarDrawable", "getStoragePath, but save dir is null");
            return null;
        }
        return String.format("%s/%s", new Object[]{i.bvg(), g.u(str.getBytes())});
    }
}
