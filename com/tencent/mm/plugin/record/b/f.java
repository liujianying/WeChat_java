package com.tencent.mm.plugin.record.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.SystemClock;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.pluginsdk.ui.tools.g;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.z;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;

public class f {
    private HashMap<String, String[]> jaP = new HashMap();
    public com.tencent.mm.a.f<String, Bitmap> jaR = new com.tencent.mm.a.f(10);
    public g mse = new 1(this);
    private HashSet<String> msf = new HashSet();
    private HashMap<String, a> msh = new HashMap();

    public final void destory() {
        this.mse.destroy();
        this.jaP.clear();
        this.msf.clear();
        this.mse = null;
        this.jaP = null;
        this.msf = null;
    }

    public final boolean a(vx vxVar, long j) {
        String e = h.e(vxVar.jdM, j, true);
        a aVar = (a) this.msh.get(e);
        if (aVar == null) {
            this.msh.put(e, new a());
            return true;
        } else if (aVar.Ad() <= 30000) {
            return false;
        } else {
            aVar.dgA = SystemClock.elapsedRealtime();
            return true;
        }
    }

    public final Bitmap a(vx vxVar, long j, boolean z) {
        boolean z2 = true;
        if (!com.tencent.mm.compatible.util.f.zZ()) {
            return BitmapFactory.decodeResource(ad.getContext().getResources(), R.g.nosdcard_chatting_bg);
        }
        String f;
        if (z) {
            f = h.f(vxVar, j);
        } else {
            f = h.c(vxVar, j);
        }
        if (bi.oW(f) || !e.cn(f)) {
            x.d("MicroMsg.RecordMsgImgService", "getBitmap file not exist, thumb[%B] path[%s]", new Object[]{Boolean.valueOf(z), f});
            return null;
        }
        Bitmap bitmap = (Bitmap) this.jaR.get(f);
        if (bitmap != null) {
            return bitmap;
        }
        int i;
        int i2;
        int i3;
        int i4;
        x.d("MicroMsg.RecordMsgImgService", "get from cache fail, try to decode from file, path %s", new Object[]{f});
        Options options = new Options();
        options.inJustDecodeBounds = true;
        bitmap = BitmapFactory.decodeFile(f, options);
        if (bitmap != null) {
            x.i("MicroMsg.RecordMsgImgService", "bitmap recycled %s", new Object[]{bitmap});
            bitmap.recycle();
        }
        boolean z3 = z.bv(options.outWidth, options.outHeight) && options.outWidth > 480;
        if (!z.bu(options.outWidth, options.outHeight) || options.outHeight <= 480) {
            z2 = false;
        }
        if (z3 || z2) {
            i = options.outHeight;
            i2 = options.outWidth;
        } else {
            i = 960;
            i2 = 960;
        }
        int VX = ExifHelper.VX(f);
        if (VX == 90 || VX == 270) {
            i3 = i2;
            i4 = i;
        } else {
            i3 = i;
            i4 = i2;
        }
        bitmap = c.e(f, i3, i4, false);
        if (bitmap == null) {
            x.e("MicroMsg.RecordMsgImgService", "extractThumbNail fail, temBmp is null, filePath = " + f);
            return null;
        }
        bitmap = c.b(bitmap, (float) VX);
        this.jaR.put(f, bitmap);
        return bitmap;
    }

    public final Bitmap b(vx vxVar, long j) {
        Bitmap a = a(vxVar, j, true);
        if (a == null) {
            x.d("MicroMsg.RecordMsgImgService", "get thumb fail, try download, can retry:%B", new Object[]{Boolean.valueOf(a(vxVar, j))});
            h.c(vxVar, j, r1);
        }
        return a;
    }

    public final void a(ImageView imageView, vx vxVar, long j, String str, int i, int i2, int i3) {
        String str2 = h.Ba(vxVar.jdM) + "@" + String.valueOf(j);
        if (vxVar.jdM != null) {
            String[] strArr;
            String[] strArr2 = (String[]) this.jaP.get(str2);
            if (strArr2 == null || strArr2.length <= 0) {
                strArr = new String[]{h.f(vxVar, j)};
                this.jaP.put(str2, strArr);
            } else {
                strArr = strArr2;
            }
            this.mse.a(imageView, strArr, str, i, i2, i3);
            if (!this.msf.contains(str2)) {
                this.msf.add(str2);
                if (!new File(strArr[0]).exists()) {
                    if (!bi.oW(vxVar.dwE) || !bi.oW(vxVar.dwv)) {
                        h.c(vxVar, j, a(vxVar, j));
                    }
                }
            }
        }
    }
}
