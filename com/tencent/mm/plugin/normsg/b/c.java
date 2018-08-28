package com.tencent.mm.plugin.normsg.b;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.b.b;
import java.util.Map;
import java.util.WeakHashMap;

public final class c {
    private static final Map<View, Class<? extends b>> lGS = new WeakHashMap();
    private static final Map<View, Boolean> lGT = new WeakHashMap();

    public static void a(View view, Class<? extends b> cls) {
        if (view == null) {
            throw new IllegalArgumentException("target is null.");
        } else if (cls == null) {
            throw new IllegalArgumentException("reportEventClass is null.");
        } else {
            OnTouchListener onTouchListener;
            OnClickListener onClickListener;
            Object b = h.b((Object) view, "getListenerInfo", null, new Object[0]);
            if (b != null) {
                onTouchListener = (OnTouchListener) h.g(b, "mOnTouchListener");
                onClickListener = (OnClickListener) h.g(b, "mOnClickListener");
            } else {
                onClickListener = null;
                onTouchListener = null;
            }
            if (onTouchListener == null) {
                view.setOnTouchListener(new b(null));
            } else if (!(onTouchListener instanceof b)) {
                view.setOnTouchListener(new b(onTouchListener));
            }
            if (onClickListener == null) {
                view.setOnClickListener(new a(null));
            } else if (!(onClickListener instanceof a)) {
                view.setOnClickListener(new a(onClickListener));
            }
            synchronized (lGS) {
                lGS.put(view, cls);
            }
        }
    }
}
