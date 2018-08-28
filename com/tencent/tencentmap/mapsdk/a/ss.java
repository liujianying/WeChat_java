package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ss implements sx {
    private float a = 90.0f;
    private List<qw> b = new ArrayList();
    private List<qw> c = new ArrayList();
    private sl d;
    private sf e;
    private boolean f = false;
    private qx g = null;
    private boolean h = false;
    private boolean i = true;
    private int j = -16777216;
    private float k = 10.0f;
    private float l = 0.0f;
    private qq m;
    private float n = 0.0f;
    private int o = -983041;
    private String p;

    public ss(sl slVar, rd rdVar) {
        this.d = slVar;
        this.e = slVar.e();
        this.p = j();
        this.j = rdVar.g();
        this.f = rdVar.j();
        this.h = rdVar.k();
        if (this.h || this.f) {
            this.b = rdVar.e();
        }
        b(rdVar.e());
        this.i = rdVar.i();
        this.k = rdVar.f();
        this.l = rdVar.h();
        this.m = rdVar.a();
        this.n = rdVar.b();
        this.o = rdVar.c();
        this.a = rdVar.d();
    }

    private static int a(byte[] bArr, int i) {
        return (((bArr[i + 0] & 255) | ((bArr[i + 1] & 255) << 8)) | ((bArr[i + 2] & 255) << 16)) | ((bArr[i + 3] & 255) << 24);
    }

    protected static Drawable a(Context context, String str) {
        int i;
        int i2;
        Bitmap createBitmap;
        InputStream open = context.getAssets().open(str);
        Bitmap decodeStream = BitmapFactory.decodeStream(open);
        int width = decodeStream.getWidth();
        int height = decodeStream.getHeight();
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (i = 0; i < 32; i++) {
            byteArrayOutputStream.write(0);
        }
        int[] iArr = new int[(width - 2)];
        decodeStream.getPixels(iArr, 0, width, 1, 0, width - 2, 1);
        Object obj = iArr[0] == -16777216 ? 1 : null;
        Object obj2 = iArr[iArr.length + -1] == -16777216 ? 1 : null;
        int i3 = 0;
        int length = iArr.length;
        int i4 = 0;
        for (i2 = 0; i2 < length; i2++) {
            if (i3 != iArr[i2]) {
                i4++;
                a(byteArrayOutputStream, i2);
                i3 = iArr[i2];
            }
        }
        if (obj2 != null) {
            i4++;
            a(byteArrayOutputStream, length);
        }
        int i5 = i4;
        i = i5 + 1;
        if (obj != null) {
            i--;
        }
        int i6 = obj2 != null ? i - 1 : i;
        iArr = new int[(height - 2)];
        decodeStream.getPixels(iArr, 0, 1, 0, 1, 1, height - 2);
        obj = iArr[0] == -16777216 ? 1 : null;
        obj2 = iArr[iArr.length + -1] == -16777216 ? 1 : null;
        i3 = 0;
        length = iArr.length;
        i4 = 0;
        for (i2 = 0; i2 < length; i2++) {
            if (i3 != iArr[i2]) {
                i4++;
                a(byteArrayOutputStream, i2);
                i3 = iArr[i2];
            }
        }
        if (obj2 != null) {
            i4++;
            a(byteArrayOutputStream, length);
        }
        i = i4 + 1;
        if (obj != null) {
            i--;
        }
        if (obj2 != null) {
            i--;
        }
        for (int i7 = 0; i7 < i6 * i; i7++) {
            a(byteArrayOutputStream, 1);
        }
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        toByteArray[0] = (byte) 1;
        toByteArray[1] = (byte) i5;
        toByteArray[2] = (byte) i4;
        toByteArray[3] = (byte) (i * i6);
        a(decodeStream, toByteArray);
        if (NinePatch.isNinePatchChunk(toByteArray)) {
            createBitmap = Bitmap.createBitmap(decodeStream, 1, 1, decodeStream.getWidth() - 2, decodeStream.getHeight() - 2);
            decodeStream.recycle();
            Field declaredField = createBitmap.getClass().getDeclaredField("mNinePatchChunk");
            declaredField.setAccessible(true);
            declaredField.set(createBitmap, toByteArray);
        } else {
            createBitmap = decodeStream;
        }
        open.close();
        if (createBitmap.getNinePatchChunk() == null) {
            return new BitmapDrawable(createBitmap);
        }
        Rect rect = new Rect();
        byte[] ninePatchChunk = createBitmap.getNinePatchChunk();
        rect.left = a(ninePatchChunk, 12);
        rect.right = a(ninePatchChunk, 16);
        rect.top = a(ninePatchChunk, 20);
        rect.bottom = a(ninePatchChunk, 24);
        return new NinePatchDrawable(context.getResources(), createBitmap, createBitmap.getNinePatchChunk(), rect, null);
    }

    private static void a(Bitmap bitmap, byte[] bArr) {
        int i;
        int i2 = 0;
        int[] iArr = new int[(bitmap.getWidth() - 2)];
        bitmap.getPixels(iArr, 0, iArr.length, 1, bitmap.getHeight() - 1, iArr.length, 1);
        for (i = 0; i < iArr.length; i++) {
            if (-16777216 == iArr[i]) {
                a(bArr, 12, i);
                break;
            }
        }
        for (i = iArr.length - 1; i >= 0; i--) {
            if (-16777216 == iArr[i]) {
                a(bArr, 16, (iArr.length - i) - 2);
                break;
            }
        }
        int[] iArr2 = new int[(bitmap.getHeight() - 2)];
        bitmap.getPixels(iArr2, 0, 1, bitmap.getWidth() - 1, 0, 1, iArr2.length);
        while (i2 < iArr2.length) {
            if (-16777216 == iArr2[i2]) {
                a(bArr, 20, i2);
                break;
            }
            i2++;
        }
        for (i = iArr2.length - 1; i >= 0; i--) {
            if (-16777216 == iArr2[i]) {
                a(bArr, 24, (iArr2.length - i) - 2);
                return;
            }
        }
    }

    private void a(Canvas canvas, List<PointF> list) {
        if (list != null && list.size() != 0 && this.m != null && this.m.b() != null) {
            int c = this.m.c();
            int d = this.m.d();
            double b = (double) (b() / ((float) d));
            double d2 = (double) ((((float) c) * this.k) / (((float) d) * this.a));
            double d3 = -((((double) c) * b) / 2.0d);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size() - 1) {
                    PointF pointF = (PointF) list.get(i2);
                    PointF pointF2 = (PointF) list.get(i2 + 1);
                    double sqrt = (pointF == null || pointF2 == null) ? 0.0d : Math.sqrt(Math.pow((double) (pointF.x - pointF2.x), 2.0d) + Math.pow((double) (pointF.y - pointF2.y), 2.0d));
                    if (sqrt + d3 < ((double) this.a)) {
                        d3 += sqrt;
                    } else {
                        double d4 = sqrt / ((double) this.a);
                        double d5 = (((double) this.a) - d3) / ((double) this.a);
                        sqrt = (Math.acos(((double) (pointF2.x - pointF.x)) / sqrt) * 180.0d) / 3.141592653589793d;
                        if (pointF2.x <= pointF.x && pointF2.y >= pointF.y) {
                            sqrt = (180.0d - sqrt) + 180.0d;
                        } else if (pointF2.x >= pointF.x && pointF2.y >= pointF.y) {
                            sqrt = 360.0d - sqrt;
                        }
                        while (d5 <= d4) {
                            if (i2 != list.size() - 2 || d5 + d2 <= d4) {
                                canvas.save();
                                canvas.translate((float) (((double) pointF.x) + ((((double) (pointF2.x - pointF.x)) * d5) / d4)), (float) (((double) pointF.y) + ((((double) (pointF2.y - pointF.y)) * d5) / d4)));
                                canvas.scale((float) b, (float) b);
                                canvas.rotate((float) (-sqrt));
                                canvas.drawBitmap(this.m.b(), (float) ((-c) / 2), (float) ((-d) / 2), null);
                                canvas.restore();
                                if (1.0d + d5 > d4) {
                                    d3 = (d4 - d5) * ((double) this.a);
                                }
                                d5 += 1.0d;
                            } else {
                                return;
                            }
                        }
                        continue;
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private static void a(OutputStream outputStream, int i) {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    private static void a(List<qw> list, List<qw> list2, double d) {
        if (list.size() == 3) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 <= 10) {
                    float f = ((float) i2) / 10.0f;
                    double c = ((((1.0d - ((double) f)) * (1.0d - ((double) f))) * ((qw) list.get(0)).c()) + (((((double) (2.0f * f)) * (1.0d - ((double) f))) * ((qw) list.get(1)).c()) * d)) + (((double) (f * f)) * ((qw) list.get(2)).c());
                    double d2 = (((1.0d - ((double) f)) * (1.0d - ((double) f))) + ((((double) (2.0f * f)) * (1.0d - ((double) f))) * d)) + ((double) (f * f));
                    List<qw> list3 = list2;
                    list3.add(new qw((((((1.0d - ((double) f)) * (1.0d - ((double) f))) * ((qw) list.get(0)).b()) + (((((double) (2.0f * f)) * (1.0d - ((double) f))) * ((qw) list.get(1)).b()) * d)) + (((double) (f * f)) * ((qw) list.get(2)).b())) / (((double) (f * f)) + (((1.0d - ((double) f)) * (1.0d - ((double) f))) + ((((double) (2.0f * f)) * (1.0d - ((double) f))) * d))), c / d2));
                    i = (int) (((float) i2) + 1.0f);
                } else {
                    return;
                }
            }
        }
    }

    private static void a(byte[] bArr, int i, int i2) {
        bArr[i + 0] = (byte) (i2 >> 0);
        bArr[i + 1] = (byte) (i2 >> 8);
        bArr[i + 2] = (byte) (i2 >> 16);
        bArr[i + 3] = (byte) (i2 >> 24);
    }

    private void b(List<qw> list) {
        if (list != null && list.size() != 0) {
            qx$a a = qx.a();
            this.c.clear();
            if (list != null) {
                qw qwVar = null;
                for (qw qwVar2 : list) {
                    if (!(qwVar2 == null || qwVar2.equals(qwVar))) {
                        if (!this.h) {
                            this.c.add(qwVar2);
                            a.a(qwVar2);
                        } else if (qwVar != null) {
                            if (Math.abs(qwVar2.c() - qwVar.c()) < 0.01d) {
                                this.c.add(qwVar);
                                a.a(qwVar);
                                this.c.add(qwVar2);
                                a.a(qwVar2);
                            } else {
                                List list2 = this.c;
                                double abs = (Math.abs(qwVar.c() - qwVar2.c()) * 3.141592653589793d) / 180.0d;
                                qw qwVar3 = new qw((qwVar2.b() + qwVar.b()) / 2.0d, (qwVar2.c() + qwVar.c()) / 2.0d);
                                a.a(qwVar).a(qwVar3).a(qwVar2);
                                int i = qwVar3.b() > 0.0d ? 1 : -1;
                                double cos = Math.cos(0.5d * abs);
                                double c = qwVar2.c() - qwVar.c();
                                double b = qwVar2.b() - qwVar.b();
                                abs = (double) ((int) ((((Math.tan(abs * 0.5d) * (Math.hypot(qwVar.c() - qwVar2.c(), qwVar.b() - qwVar2.b()) * 0.5d)) * ((double) i)) / Math.sqrt(((b * b) / (c * c)) + 1.0d)) + qwVar3.b()));
                                qw qwVar4 = new qw(abs, (double) ((int) (qwVar3.c() + ((b * (qwVar3.b() - abs)) / c))));
                                List arrayList = new ArrayList();
                                arrayList.add(qwVar);
                                arrayList.add(qwVar4);
                                arrayList.add(qwVar2);
                                a(arrayList, list2, cos);
                            }
                        }
                        qwVar = qwVar2;
                    }
                }
            }
            this.g = a.a();
        }
    }

    public List<qw> a() {
        return (this.h || this.f) ? this.b : this.c;
    }

    public void a(float f) {
        this.k = f;
        this.d.a(false, false);
    }

    public void a(int i) {
        this.j = i;
        this.d.a(false, false);
    }

    public void a(Canvas canvas) {
        List arrayList = new ArrayList();
        if (this.c != null && this.c.size() != 0 && this.k > 0.0f) {
            int i;
            Path path = new Path();
            PointF a = this.d.b().a((qw) this.c.get(0));
            arrayList.add(a);
            path.moveTo(a.x, a.y);
            for (i = 1; i < this.c.size(); i++) {
                a = this.d.b().a((qw) this.c.get(i));
                arrayList.add(a);
                path.lineTo(a.x, a.y);
            }
            Paint paint = new Paint();
            paint.setStyle(Style.STROKE);
            if (this.f) {
                i = (int) b();
                paint.setPathEffect(new DashPathEffect(new float[]{(float) (i * 3), (float) i, (float) (i * 3), (float) i}, 1.0f));
            } else {
                paint.setStrokeJoin(Join.ROUND);
                paint.setStrokeCap(Cap.ROUND);
            }
            paint.setAntiAlias(true);
            if (this.n > 0.0f) {
                paint.setColor(this.o);
                paint.setStrokeWidth(b() + (2.0f * this.n));
                canvas.drawPath(path, paint);
            }
            paint.setColor(e());
            paint.setStrokeWidth(b());
            canvas.drawPath(path, paint);
            if (this.m != null) {
                a(canvas, arrayList);
            }
            arrayList.clear();
        }
    }

    public void a(List<qw> list) {
        if (this.h || this.f) {
            this.b = list;
        }
        b((List) list);
        this.d.a(false, false);
    }

    public void a(boolean z) {
        this.f = z;
        this.d.a(false, false);
    }

    public boolean a(sv svVar) {
        return equals(svVar) || svVar.j().equals(j());
    }

    public float b() {
        return this.k;
    }

    public void b(float f) {
        this.l = f;
        this.e.c();
        this.d.a(false, false);
    }

    public void b(boolean z) {
        this.i = z;
        this.e.c();
        this.d.a(false, false);
    }

    public void c(boolean z) {
        this.h = z;
        this.d.a(false, false);
    }

    public boolean c() {
        return this.f;
    }

    public boolean d() {
        return this.h;
    }

    public int e() {
        return this.j;
    }

    public boolean h() {
        if (this.g == null) {
            return false;
        }
        qx c = this.d.b().c();
        return c == null ? true : c.a(this.g) || this.g.b(c);
    }

    public void i() {
        this.e.b(j());
    }

    public String j() {
        if (this.p == null) {
            this.p = sf.a("Polyline");
        }
        return this.p;
    }

    public float k() {
        return this.l;
    }

    public boolean l() {
        return this.i;
    }

    public int m() {
        return super.hashCode();
    }

    public void n() {
    }
}
