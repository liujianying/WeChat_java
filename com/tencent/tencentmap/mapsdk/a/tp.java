package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.util.concurrent.Callable;

public final class tp implements Callable<Bitmap> {
    private a a;
    private Bitmap b = null;
    private td c;
    private boolean d = false;
    private tf e = null;

    public interface a {
        void a(tp tpVar);

        void b(tp tpVar);
    }

    public tp(a aVar, td tdVar) {
        this.a = aVar;
        this.c = tdVar;
    }

    private Bitmap d() {
        if (this.a != null) {
            this.a.b(this);
        }
        try {
            this.b = f();
            Bitmap bitmap = this.b;
            return bitmap;
        } finally {
            e();
        }
    }

    private void e() {
        if (this.a != null) {
            this.a.a(this);
        }
        this.a = null;
        if (!(this.b == null || this.b.isRecycled())) {
            this.b.recycle();
        }
        this.b = null;
    }

    private Bitmap f() {
        Exception e;
        int i = 0;
        Bitmap bitmap = null;
        while (i < 4) {
            try {
                byte[] a = this.c.a(this.d, this.e != null ? this.e.a() : null);
                if (a != null) {
                    if (a.length == 1 && a[0] == (byte) -1 && this.d) {
                        te.a().a(this.c, null, true);
                        if (this.e == null || this.e.b() == null) {
                            return null;
                        }
                        sl.e++;
                        sl.a++;
                        return this.e.b();
                    }
                    Bitmap decodeByteArray;
                    try {
                        decodeByteArray = BitmapFactory.decodeByteArray(a, 0, a.length);
                        if (decodeByteArray != null) {
                            try {
                                if (this.d) {
                                    sl.f++;
                                    sl.c++;
                                }
                                if (a.length < 2097152) {
                                    try {
                                        te.a().a(new tf(a, this.c.l()), this.c);
                                        bitmap = decodeByteArray;
                                    } catch (Throwable th) {
                                        if (tz.n() != null) {
                                            tz.n().a("TileNetFetcher downLoad function occured exception when call CacheManager Put,the downloaded data length-" + a.length + ";tileInfo:x=" + this.c.b() + ",y=" + this.c.c() + "z=" + this.c.d() + "exceptionInfo:" + th.toString());
                                        }
                                        bitmap = decodeByteArray;
                                    }
                                } else if (tz.n() != null) {
                                    tz.n().a("TileNetFetcher downLoad function,the downloaded data length-" + a.length + ";tileInfo:x=" + this.c.b() + ",y=" + this.c.c() + "z=" + this.c.d());
                                }
                            } catch (Exception e2) {
                                e = e2;
                                try {
                                    new StringBuilder("decoder bitmap error:").append(e.getMessage());
                                    bitmap = decodeByteArray;
                                    if (bitmap == null) {
                                        return bitmap;
                                    }
                                    if (i == 0) {
                                        Thread.sleep(300);
                                        new StringBuilder().append(this.c.l()).append(",重试次数：2");
                                        i++;
                                    } else if (i == 1) {
                                        Thread.sleep(500);
                                        new StringBuilder().append(this.c.l()).append(",重试次数3");
                                        i++;
                                    } else {
                                        if (i == 2) {
                                            Thread.sleep(700);
                                            new StringBuilder().append(this.c.l()).append(",重试次数4");
                                        }
                                        i++;
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    bitmap = decodeByteArray;
                                    new StringBuilder("Error occured:").append(e.getMessage());
                                    i++;
                                }
                            }
                        }
                        bitmap = decodeByteArray;
                    } catch (Exception e4) {
                        e = e4;
                        decodeByteArray = bitmap;
                    }
                }
                if (bitmap == null) {
                    return bitmap;
                }
                if (i == 0) {
                    Thread.sleep(300);
                    new StringBuilder().append(this.c.l()).append(",重试次数：2");
                    i++;
                } else if (i == 1) {
                    Thread.sleep(500);
                    new StringBuilder().append(this.c.l()).append(",重试次数3");
                    i++;
                } else {
                    if (i == 2) {
                        Thread.sleep(700);
                        new StringBuilder().append(this.c.l()).append(",重试次数4");
                    }
                    i++;
                }
            } catch (Exception e5) {
                e = e5;
            }
        }
        if (this.c.e().getClass() != tm.class || bitmap != null) {
            return bitmap;
        }
        new StringBuilder().append(this.c.l()).append(",重试4次，仍然失败");
        return bitmap;
    }

    public final Bitmap a() {
        return this.b;
    }

    public final void a(tf tfVar) {
        this.e = tfVar;
    }

    public final void a(boolean z) {
        this.d = z;
    }

    public final String b() {
        return this.c != null ? this.c.toString() : "";
    }

    public final void c() {
        if (this.b != null) {
            this.b.recycle();
        }
        this.b = null;
    }
}
