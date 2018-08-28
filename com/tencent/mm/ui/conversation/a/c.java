package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.DisplayMetrics;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.platformtools.g;
import com.tencent.mm.pluginsdk.h.a.a;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;
import java.util.Map;
import junit.framework.Assert;

public final class c {
    a urN;

    c(a aVar) {
        this.urN = aVar;
    }

    public final int a(d dVar) {
        boolean z = true;
        Assert.assertTrue(dVar != null);
        if (dVar.urP == null) {
            z = false;
        }
        Assert.assertTrue(z);
        Drawable a = a(this.urN.qDL, dVar.urO.getContext());
        if (a == null) {
            return -1;
        }
        dVar.urO.setBackgroundDrawable(a);
        dVar.urP.setVisibility(this.urN.qDG ? 0 : 8);
        return 0;
    }

    private static Drawable a(Map<String, String> map, Context context) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        String str = (String) map.get(displayMetrics.heightPixels + "x" + displayMetrics.widthPixels);
        if (str == null) {
            g gVar = new g();
            displayMetrics = context.getResources().getDisplayMetrics();
            Configuration configuration = context.getResources().getConfiguration();
            String str2 = "";
            str = displayMetrics.density < 1.0f ? str2 + "LDPI" : displayMetrics.density >= 1.5f ? str2 + "HDPI" : str2 + "MDPI";
            str = (String) map.get(str + (configuration.orientation == 2 ? "_L" : "_P"));
        }
        if (ai.oV(str).length() <= 0) {
            return null;
        }
        a.a Tt = a.Tt(str);
        if (Tt == a.a.qDP) {
            return null;
        }
        str = a.Ts(str);
        if (ai.oV(str).length() <= 0) {
            return null;
        }
        try {
            Bitmap a;
            float density;
            if (Tt == a.a.qDN) {
                InputStream open = context.getAssets().open(str);
                density = com.tencent.mm.bp.a.getDensity(context);
                g gVar2 = new g();
                a = com.tencent.mm.sdk.platformtools.c.a(open, density);
            } else {
                float density2 = com.tencent.mm.bp.a.getDensity(context);
                g gVar3 = new g();
                density = 160.0f * density2;
                a = com.tencent.mm.sdk.platformtools.c.f(str, density2);
                if (a != null) {
                    a.setDensity((int) density);
                }
            }
            if (a == null) {
                x.e("MicroMsg.ADListView.Message", "get Bitmap failed type:" + Tt + " path:" + str);
                return null;
            }
            byte[] ninePatchChunk = a.getNinePatchChunk();
            if (ninePatchChunk != null && NinePatch.isNinePatchChunk(ninePatchChunk)) {
                return new NinePatchDrawable(a, ninePatchChunk, new Rect(), null);
            }
            DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(a, displayMetrics2.widthPixels, (displayMetrics2.widthPixels * a.getHeight()) / a.getWidth(), true);
            if (createScaledBitmap != null) {
                if (a != createScaledBitmap) {
                    x.i("MicroMsg.ADListView.Message", "recycle bitmap:%s", new Object[]{a});
                    a.recycle();
                }
                a = createScaledBitmap;
            }
            Drawable bitmapDrawable = new BitmapDrawable(a);
            bitmapDrawable.setTargetDensity(displayMetrics2);
            return bitmapDrawable;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ADListView.Message", e, "", new Object[0]);
            return null;
        }
    }
}
