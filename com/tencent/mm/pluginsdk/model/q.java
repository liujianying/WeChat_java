package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.w.b;
import com.tencent.mm.plugin.p.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.w.a.f;

public final class q implements w {
    private boolean bOC;
    private long emk = 0;
    private long eml = 0;
    private String mfQ;
    private boolean qzn;
    private int type;
    private String url;

    public static final class a {
        public int h;
        public int w;
        public int x;
        public int y;

        public final String toString() {
            return String.format("crop area[x=%d,y=%d,h=%d,w=%d]", new Object[]{Integer.valueOf(this.x), Integer.valueOf(this.y), Integer.valueOf(this.h), Integer.valueOf(this.w)});
        }
    }

    public q(String str, int i, String str2) {
        this.url = str;
        this.type = i;
        this.mfQ = str2;
        this.bOC = false;
    }

    public static String v(String str, int i, String str2) {
        if (!g.Eg().Dx()) {
            return "";
        }
        Object[] objArr = new Object[4];
        objArr[0] = c.aWE();
        objArr[1] = Integer.valueOf(i);
        objArr[2] = str2;
        StringBuilder stringBuilder = new StringBuilder();
        g.Eg();
        objArr[3] = com.tencent.mm.a.g.u(stringBuilder.append(com.tencent.mm.kernel.a.Dg()).append(str).toString().getBytes());
        return String.format("%s%d%s_%s", objArr);
    }

    public final String Vv() {
        return v(this.url, this.type, this.mfQ);
    }

    public final String Vw() {
        if (com.tencent.mm.ak.q.Pn()) {
            return com.tencent.mm.ak.q.lX(this.url);
        }
        return this.url;
    }

    public final String Vx() {
        return this.url;
    }

    public final String getCacheKey() {
        return this.url + this.mfQ;
    }

    public final boolean Vy() {
        return false;
    }

    public final boolean Vz() {
        return this.bOC;
    }

    public final Bitmap a(Bitmap bitmap, com.tencent.mm.platformtools.w.a aVar, String str) {
        if (com.tencent.mm.platformtools.w.a.evZ == aVar) {
            int i;
            int i2;
            String str2 = this.mfQ;
            a aVar2 = new a();
            Context context = ad.getContext();
            DisplayMetrics displayMetrics = null;
            if (context != null) {
                Resources resources = context.getResources();
                if (resources != null) {
                    displayMetrics = resources.getDisplayMetrics();
                }
            }
            if (displayMetrics != null) {
                int i3;
                if ("@T".equals(str2)) {
                    i3 = (int) (((float) displayMetrics.widthPixels) - (60.0f * displayMetrics.density));
                    i = (int) (displayMetrics.density * 167.0f);
                    i2 = i3;
                } else {
                    i3 = (int) (displayMetrics.density * 50.0f);
                    i = i3;
                    i2 = i3;
                }
            } else if ("@T".equals(str2)) {
                i = 334;
                i2 = Integer.MAX_VALUE;
            } else {
                i = 100;
                i2 = 100;
            }
            aVar2.w = i2;
            aVar2.h = i;
            x.d("MicroMsg.ReaaderAppGetPicStrategy", aVar2.toString());
            bitmap = com.tencent.mm.sdk.platformtools.c.a(bitmap, aVar2.w, aVar2.h, true);
            try {
                x.d("MicroMsg.ReaaderAppGetPicStrategy", "handlerBitmap, path:%s", new Object[]{Vv()});
                com.tencent.mm.sdk.platformtools.c.a(bitmap, 100, CompressFormat.PNG, Vv(), false);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ReaaderAppGetPicStrategy", e, "", new Object[0]);
                x.e("MicroMsg.ReaaderAppGetPicStrategy", "save image %s fail", new Object[]{this.url});
            }
        }
        return bitmap;
    }

    public final void VB() {
        this.emk = bi.VF();
        if (this.qzn) {
            x.d("MicroMsg.ReaaderAppGetPicStrategy", "beforeGetPicFromNet, from biz msg");
            h.mEJ.a(86, 0, 1, false);
        }
    }

    public final void P(String str, boolean z) {
        this.eml = bi.VF();
        Object obj = null;
        if (com.tencent.mm.ak.q.Pn() && !bi.oW(str) && com.tencent.mm.ak.q.lY(Vw()) && str.equals("image/webp")) {
            obj = 1;
        }
        if (!this.qzn) {
            return;
        }
        if (z) {
            long j = this.eml - this.emk;
            x.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz image success, used %d", new Object[]{Long.valueOf(j)});
            h.mEJ.a(86, 4, j, false);
            if (obj != null) {
                x.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz webp image success");
                h.mEJ.a(86, 17, j, false);
                h.mEJ.a(86, 13, 1, false);
                return;
            }
            return;
        }
        x.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz image failed");
        h.mEJ.a(86, 2, 1, false);
        if (obj != null) {
            x.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz webp image failed");
            h.mEJ.a(86, 15, 1, false);
        }
    }

    public final void a(com.tencent.mm.platformtools.w.a aVar, String str) {
        if (aVar == com.tencent.mm.platformtools.w.a.evZ && this.qzn && com.tencent.mm.ak.q.Pn() && !bi.oW(str) && com.tencent.mm.ak.q.lY(Vw()) && str.equals("image/webp")) {
            x.d("MicroMsg.ReaaderAppGetPicStrategy", "decode download webp picture failed");
            h.mEJ.a(86, 14, 1, false);
        }
    }

    public final Bitmap VA() {
        return BitmapFactory.decodeResource(ad.getContext().getResources(), f.nosdcard_chatting_bg);
    }

    public final b Vu() {
        return null;
    }
}
