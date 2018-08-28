package com.tencent.mm.plugin.appbrand.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mm.modelappbrand.b.b.h;
import com.tencent.mm.plugin.appbrand.q.m;
import com.tencent.mm.plugin.appbrand.widget.g.b;
import java.lang.ref.WeakReference;

class a$2 implements h {
    final /* synthetic */ a gjS;
    final /* synthetic */ WeakReference gjT;
    final /* synthetic */ WeakReference gjU;
    final /* synthetic */ SpannableString gjV;

    a$2(a aVar, WeakReference weakReference, WeakReference weakReference2, SpannableString spannableString) {
        this.gjS = aVar;
        this.gjT = weakReference;
        this.gjU = weakReference2;
        this.gjV = spannableString;
    }

    public final void Kc() {
    }

    public final void n(Bitmap bitmap) {
        TextView textView = (TextView) this.gjT.get();
        Context context = (Context) this.gjU.get();
        if (context != null && textView != null) {
            Drawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
            bitmapDrawable.setBounds(0, 0, m.aos(), m.aos());
            b bVar = new b(bitmapDrawable);
            new SpannableString("@ ").setSpan(bVar, 0, 1, 33);
            textView.setText(TextUtils.concat(new CharSequence[]{r2, this.gjV}));
            textView.invalidate();
        }
    }

    public final void Kd() {
    }

    public final String Ke() {
        return a.class.getSimpleName();
    }
}
