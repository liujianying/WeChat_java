package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;

public class ShowCommentImageView extends ImageView {
    private static Bitmap nRd;
    private static Bitmap nRe;
    private static Field nRf;
    private static Field nRg;
    private static boolean nRh = false;
    private boolean nRc = false;

    public ShowCommentImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ShowCommentImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private static void init() {
        if (nRf == null || nRg == null) {
            try {
                nRf = View.class.getDeclaredField("mDrawingCache");
                nRg = View.class.getDeclaredField("mUnscaledDrawingCache");
                nRf.setAccessible(true);
                nRg.setAccessible(true);
                nRh = true;
            } catch (Exception e) {
                x.e("MicroMsg.ShowCommentImageView", "init error: %s", new Object[]{e.getMessage()});
                nRh = false;
            }
        }
    }

    public void buildDrawingCache(boolean z) {
        if (nRh) {
            if (this.nRc) {
                D(z, true);
            } else if (in(z)) {
                super.buildDrawingCache(z);
                return;
            } else {
                Bitmap bitmap = z ? nRe : nRd;
                if (bitmap == null || bitmap.isRecycled()) {
                    Field field;
                    super.buildDrawingCache(z);
                    if (z) {
                        try {
                            field = nRf;
                        } catch (Exception e) {
                            x.e("MicroMsg.ShowCommentImageView", "getStaticDrawingCache error: %s", new Object[]{e.getMessage()});
                            return;
                        }
                    }
                    field = nRg;
                    bitmap = (Bitmap) field.get(this);
                    String str = "MicroMsg.ShowCommentImageView";
                    String str2 = "getStaticDrawingCache, autoScale: %s, cache==null: %s";
                    Object[] objArr = new Object[2];
                    objArr[0] = Boolean.valueOf(z);
                    objArr[1] = Boolean.valueOf(bitmap == null);
                    x.d(str, str2, objArr);
                    if (bitmap == null) {
                        return;
                    }
                    if (z) {
                        nRe = bitmap;
                        return;
                    } else {
                        nRd = bitmap;
                        return;
                    }
                }
                D(z, false);
                return;
            }
        }
        super.buildDrawingCache(z);
    }

    private boolean in(boolean z) {
        if (!nRh) {
            return false;
        }
        Field field;
        if (z) {
            try {
                field = nRf;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ShowCommentImageView", e, "", new Object[0]);
                x.e("MicroMsg.ShowCommentImageView", "checkIfCanReuseDrawingCache error: %s", new Object[]{e.getMessage()});
                return false;
            }
        }
        field = nRg;
        return ((Bitmap) field.get(this)) != null;
    }

    private void D(boolean z, boolean z2) {
        Field field;
        if (z) {
            try {
                field = nRf;
            } catch (Exception e) {
                x.e("MicroMsg.ShowCommentImageView", "setDrawingCache error: %s", new Object[]{e.getMessage()});
                return;
            }
        }
        field = nRg;
        if (z2) {
            field.set(this, null);
            return;
        }
        Object obj;
        boolean z3;
        if (z) {
            obj = nRe;
        } else {
            Bitmap obj2 = nRd;
        }
        String str = "MicroMsg.ShowCommentImageView";
        String str2 = "setDrawingCache, autoScale: %s, cache==null: %s";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(z);
        if (obj2 == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        objArr[1] = Boolean.valueOf(z3);
        x.d(str, str2, objArr);
        if (obj2 != null) {
            field.set(this, obj2);
        }
    }

    protected void onDetachedFromWindow() {
        try {
            nRf.set(this, null);
            nRg.set(this, null);
        } catch (Exception e) {
            x.e("MicroMsg.ShowCommentImageView", "setDrawingCache error: %s", new Object[]{e.getMessage()});
        }
        super.onDetachedFromWindow();
    }

    public void destroyDrawingCache() {
        super.destroyDrawingCache();
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        super.setOnClickListener(new 1(this, onClickListener));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            postDelayed(new 2(this), 100);
        } else {
            this.nRc = true;
        }
        return super.onTouchEvent(motionEvent);
    }
}
