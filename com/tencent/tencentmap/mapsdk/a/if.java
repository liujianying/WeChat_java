package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import com.tencent.map.lib.b;
import com.tencent.map.lib.d;
import com.tencent.map.lib.gl.JNICallback.IconImageInfo;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.map.lib.util.SystemUtil;
import com.tencent.map.lib.util.a;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.concurrent.Semaphore;

public class if {
    private WeakReference<Context> a;
    private gy b;
    private ih c;
    private float d = 1.0f;
    private b e;
    private Semaphore f = new Semaphore(1);
    private Semaphore g = new Semaphore(1);

    public if(Context context, gy gyVar, ih ihVar, b bVar) {
        this.a = new WeakReference(context);
        this.b = gyVar;
        this.c = ihVar;
        this.e = bVar;
        this.d = SystemUtil.getDensity(context);
    }

    public IconImageInfo a(String str) {
        IconImageInfo iconImageInfo = new IconImageInfo();
        iconImageInfo.scale = this.d;
        iconImageInfo.anchorPointX1 = 0.5f;
        iconImageInfo.anchorPointY1 = 0.5f;
        iconImageInfo.bitmap = a(str, Config.RGB_565, false);
        return iconImageInfo;
    }

    public IconImageInfo b(String str) {
        if (this.e == null) {
            return null;
        }
        IconImageInfo iconImageInfo = new IconImageInfo();
        iconImageInfo.anchorPointX1 = 0.5f;
        iconImageInfo.anchorPointY1 = 0.5f;
        if (str == null || !str.startsWith("drawRoundRect")) {
            try {
                this.g.acquire();
                Bitmap a = this.e.a(str);
                this.g.release();
                iconImageInfo.scale = this.d;
                iconImageInfo.bitmap = a;
                if (a == null && !str.equals("compass.png")) {
                    d.b("Failed to get texture for: " + str);
                }
                return iconImageInfo;
            } catch (InterruptedException e) {
                return null;
            }
        }
        iconImageInfo.scale = 1.0f;
        iconImageInfo.bitmap = c(str);
        return iconImageInfo;
    }

    public void a() {
        try {
            this.f.acquire();
        } catch (InterruptedException e) {
        }
    }

    public void b() {
        this.f.release();
    }

    public boolean a(String str, byte[] bArr) {
        if (this.c == null) {
            return false;
        }
        return a(new File(this.c.c()), str, bArr, this.f);
    }

    public boolean b(String str, byte[] bArr) {
        if (this.c == null) {
            return false;
        }
        return a(new File(this.c.d()), str, bArr, this.g);
    }

    public void c() {
        this.b.f().a("");
    }

    private Bitmap a(String str, Config config, boolean z) {
        if (!new File(str).exists() || this.a == null || this.a.get() == null) {
            return null;
        }
        Options options = new Options();
        options.inPreferredConfig = config;
        if (z) {
            options.inDensity = 320;
            options.inTargetDensity = ((Context) this.a.get()).getResources().getDisplayMetrics().densityDpi;
        }
        try {
            return BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e) {
            return null;
        }
    }

    private boolean a(File file, String str, byte[] bArr, Semaphore semaphore) {
        if (file == null || StringUtil.isEmpty(str) || bArr == null || bArr.length == 0) {
            return false;
        }
        String str2 = str + "_" + bArr.hashCode();
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str2);
        if (file2.exists()) {
            file2.delete();
        }
        file2.createNewFile();
        OutputStream fileOutputStream = new FileOutputStream(file2);
        fileOutputStream.write(bArr);
        fileOutputStream.flush();
        fileOutputStream.close();
        try {
            if (!a.a(bArr).equals(a.a(file2))) {
                return false;
            }
        } catch (FileNotFoundException e) {
        }
        try {
            File file3 = new File(file, str);
            File file4 = new File(file, str + ".bak");
            if (!file4.exists() || file4.delete()) {
                semaphore.acquire();
                if (file3.exists() && !file3.renameTo(file4)) {
                    if (!file2.delete()) {
                        file2.deleteOnExit();
                    }
                    semaphore.release();
                    return false;
                } else if (file2.renameTo(file3)) {
                    if (!file4.delete()) {
                        file4.deleteOnExit();
                    }
                    semaphore.release();
                    return true;
                } else {
                    file4.renameTo(file3);
                    if (!file2.delete()) {
                        file2.deleteOnExit();
                    }
                    semaphore.release();
                    return false;
                }
            }
            file4.deleteOnExit();
            return false;
        } catch (Exception e2) {
            semaphore.release();
            return false;
        }
    }

    private Bitmap c(String str) {
        String substring = str.substring(14);
        if (StringUtil.isEmpty(substring)) {
            return null;
        }
        String[] split = substring.split(", ");
        if (split == null || split.length < 5) {
            return null;
        }
        int parseInt = Integer.parseInt(split[0]);
        int parseInt2 = Integer.parseInt(split[1]);
        long parseLong = Long.parseLong(split[2]);
        long parseLong2 = Long.parseLong(split[3]);
        float parseFloat = Float.parseFloat(split[4]);
        if (parseInt < 0 || parseInt2 < 0) {
            return null;
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(parseFloat);
        paint.setStyle(Style.STROKE);
        paint.setColor(a((int) parseLong2));
        Bitmap createBitmap = Bitmap.createBitmap(parseInt, parseInt2, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(a((int) parseLong));
        RectF rectF = new RectF();
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.right = (float) parseInt;
        rectF.bottom = (float) parseInt2;
        canvas.drawRoundRect(rectF, (float) (parseInt >> 3), (float) (parseInt2 >> 3), paint);
        return createBitmap;
    }

    private int a(int i) {
        return ((16711680 & i) >> 16) | (((i & WebView.NORMAL_MODE_ALPHA) << 16) | ((-16711681 & i) & -256));
    }
}
