package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.plugin.appbrand.config.a.d;
import com.tencent.mm.plugin.appbrand.g;

public interface l {

    public static class a {
        private static final android.support.v4.e.a<g, Bitmap> gwU = new android.support.v4.e.a();

        public static l b(Context context, g gVar) {
            Bitmap bitmap = (Bitmap) gwU.remove(gVar);
            if (bitmap != null && !bitmap.isRecycled()) {
                return new e(context, gVar, bitmap);
            }
            if (gVar.aap()) {
                return new d(context, gVar);
            }
            if (gVar.aaq()) {
                return new b(context, gVar);
            }
            return new g(context, gVar);
        }

        public static void a(g gVar, Bitmap bitmap) {
            if (gVar != null && bitmap != null && !bitmap.isRecycled()) {
                gwU.put(gVar, bitmap);
            }
        }
    }

    void a(d dVar);

    void anm();

    void ann();

    void bL(String str, String str2);

    View getView();

    void setProgress(int i);
}
