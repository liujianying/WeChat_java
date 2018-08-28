package com.tencent.mm.plugin.appbrand.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.appbrand.q.l;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.Iterator;
import java.util.LinkedList;

public final class c extends FrameLayout {
    public LinearLayout gEg;
    private ImageView gEh;
    public String gEi;
    private int gEj;
    private int gEk;
    public LinkedList<a> gEl = new LinkedList();
    private int gEm = 0;
    private b gEn;
    private int mHeight = 0;

    static /* synthetic */ void b(c cVar, String str, String str2) {
        float fromDPToPix = (float) a.fromDPToPix(cVar.getContext(), 1);
        int i = fromDPToPix / 2.0f > 1.0f ? (int) (fromDPToPix / 2.0f) : 1;
        new GradientDrawable().setColor(j.aO(str, -1));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(0);
        if ("white".equals(str2)) {
            gradientDrawable.setStroke(i, Color.parseColor("#33ffffff"));
        } else {
            gradientDrawable.setStroke(i, Color.parseColor("#33000000"));
        }
        Drawable layerDrawable = new LayerDrawable(new Drawable[]{r2, gradientDrawable});
        if ("top".equals(cVar.gEi)) {
            layerDrawable.setLayerInset(1, -i, -i, -i, -i);
        } else {
            layerDrawable.setLayerInset(1, -i, 0, -i, -i);
        }
        cVar.gEh.setImageDrawable(layerDrawable);
    }

    static /* synthetic */ void c(c cVar) {
        if (cVar.gEn != null) {
            cVar.gEn.N(cVar.gEm, ((a) cVar.gEl.get(cVar.gEm)).mUrl);
        }
    }

    public c(Context context) {
        super(context);
        setLayoutParams(new LayoutParams(-1, -2));
        this.gEh = new ImageView(context);
        this.gEh.setLayoutParams(new LayoutParams(-1, -1));
        addView(this.gEh);
        this.gEg = new LinearLayout(context);
        this.gEg.setOrientation(0);
        this.gEg.setGravity(16);
        this.gEg.setLayoutParams(new LayoutParams(-1, -2));
        addView(this.gEg);
    }

    public final void setPosition(String str) {
        this.gEi = str;
    }

    public final void h(String str, String str2, String str3, String str4) {
        post(new 1(this, str, str2, str3, str4));
    }

    public final void setClickListener(b bVar) {
        this.gEn = bVar;
    }

    public static Bitmap we(String str) {
        byte[] decode = Base64.decode(str, 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    public final void lU(int i) {
        ((a) this.gEl.get(this.gEm)).gEx = false;
        if (i <= 0 || i >= this.gEl.size()) {
            this.gEm = 0;
        } else {
            this.gEm = i;
        }
        ((a) this.gEl.get(this.gEm)).gEx = true;
        a();
    }

    public final void di(final boolean z) {
        if (ah.isMainThread()) {
            int i;
            String str = "translationY";
            float[] fArr = new float[2];
            fArr[0] = 0.0f;
            int height = getHeight();
            if ("top".equals(this.gEi)) {
                i = -1;
            } else {
                i = 1;
            }
            fArr[1] = (float) (i * height);
            Animator ofFloat = ObjectAnimator.ofFloat(this, str, fArr);
            ofFloat.setDuration(z ? 250 : 0);
            a(ofFloat, new 4(this));
            return;
        }
        ah.A(new Runnable() {
            public final void run() {
                c.this.di(z);
            }
        });
    }

    private void a(Animator animator, Runnable runnable) {
        animator.addListener(new 6(this, runnable));
        animator.start();
    }

    /* renamed from: aoV */
    public final void a() {
        post(new Runnable() {
            public final void run() {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < c.this.gEl.size()) {
                        c.this.a(c.this.gEg.getChildAt(i2), (a) c.this.gEl.get(i2));
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        });
    }

    public final void a(View view, a aVar) {
        int i;
        int i2 = 0;
        ImageView imageView = (ImageView) view.findViewById(g.icon);
        TextView textView = (TextView) view.findViewById(g.badge);
        ImageView imageView2 = (ImageView) view.findViewById(g.reddot);
        TextView textView2 = (TextView) view.findViewById(g.text);
        View findViewById = view.findViewById(g.indicator);
        if ("top".equals(this.gEi)) {
            view.setLayoutParams(new LinearLayout.LayoutParams(0, a.fromDPToPix(getContext(), 40), 1.0f));
            imageView.setVisibility(8);
            textView2.setTextSize(1, 14.0f);
            if (aVar.gEx) {
                findViewById.setBackgroundColor(this.gEk);
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(4);
            }
        } else {
            if (aVar.sq != null) {
                if (aVar.gEw != null) {
                    view.setLayoutParams(new LinearLayout.LayoutParams(0, a.fromDPToPix(getContext(), 54), 1.0f));
                    imageView.setVisibility(0);
                    imageView.getLayoutParams().width = a.fromDPToPix(getContext(), 32);
                    imageView.getLayoutParams().height = a.fromDPToPix(getContext(), 28);
                    textView2.setVisibility(0);
                    textView2.setTextSize(1, 12.0f);
                } else {
                    view.setLayoutParams(new LinearLayout.LayoutParams(0, a.fromDPToPix(getContext(), 48), 1.0f));
                    imageView.setVisibility(0);
                    imageView.getLayoutParams().width = a.fromDPToPix(getContext(), 36);
                    imageView.getLayoutParams().height = a.fromDPToPix(getContext(), 36);
                    textView2.setVisibility(8);
                }
            } else if (aVar.sq == null && aVar.gEw != null) {
                view.setLayoutParams(new LinearLayout.LayoutParams(0, a.fromDPToPix(getContext(), 49), 1.0f));
                imageView.setVisibility(8);
                textView2.setVisibility(0);
                textView2.setTextSize(1, 16.0f);
            }
            findViewById.setVisibility(4);
        }
        Drawable background = textView.getBackground();
        if (background != null) {
            background.setColorFilter(aVar.gEA, Mode.SRC_ATOP);
        }
        if (aVar.gEz.isEmpty()) {
            i = 4;
        } else {
            i = 0;
        }
        textView.setVisibility(i);
        textView.setText(aVar.gEz);
        textView.setTextColor(aVar.gEB);
        if (!aVar.gEy) {
            i2 = 4;
        }
        imageView2.setVisibility(i2);
        if (!aVar.gEx || aVar.gEv == null) {
            imageView.setImageBitmap(aVar.sq);
        } else {
            imageView.setImageBitmap(aVar.gEv);
        }
        textView2.setText(aVar.gEw);
        if (aVar.gEx) {
            textView2.setTextColor(this.gEk);
        } else {
            textView2.setTextColor(this.gEj);
        }
    }

    private void setBottomHeightByItem(a aVar) {
        if (aVar.sq != null && aVar.gEw != null) {
            setHeight(54);
        } else if (aVar.sq != null && aVar.gEw == null) {
            setHeight(48);
        } else if (aVar.sq == null && aVar.gEw != null) {
            setHeight(49);
        }
    }

    private void setHeight(int i) {
        if (i > this.mHeight) {
            setLayoutParams(new LayoutParams(-1, a.fromDPToPix(getContext(), i)));
        }
    }

    public final int wf(String str) {
        Object obj;
        LinkedList linkedList = this.gEl;
        String vP = l.vP(str);
        Iterator it = this.gEl.iterator();
        while (it.hasNext()) {
            obj = (a) it.next();
            if (l.vP(obj.mUrl).equals(vP)) {
                break;
            }
        }
        obj = null;
        return linkedList.indexOf(obj);
    }
}
