package com.tencent.mm.memory;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class j extends l {
    private static Bitmap a(InputStream inputStream, Options options, DecodeResultLogger decodeResultLogger) {
        Exception e;
        ByteBuffer byteBuffer;
        Throwable th;
        Object obj;
        Bitmap bitmap = null;
        try {
            ByteBuffer byteBuffer2 = (ByteBuffer) h.dvb.bW();
            try {
                bitmap = a(inputStream, null, a(inputStream, options, byteBuffer2, false, null), decodeResultLogger);
                if (byteBuffer2 == null) {
                    return bitmap;
                }
                h.dvb.j(byteBuffer2);
                return bitmap;
            } catch (Exception e2) {
                e = e2;
                byteBuffer = byteBuffer2;
            } catch (Throwable th2) {
                th = th2;
                byteBuffer = byteBuffer2;
                if (obj != null) {
                    h.dvb.j(obj);
                }
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            obj = bitmap;
            try {
                x.e("MicroMsg.InBitmapFactory", "error decode bitmap %s", new Object[]{e.getMessage()});
                if (obj == null) {
                    return bitmap;
                }
                h.dvb.j(obj);
                return bitmap;
            } catch (Throwable th3) {
                th = th3;
                if (obj != null) {
                    h.dvb.j(obj);
                }
                throw th;
            }
        } catch (Throwable th32) {
            th = th32;
            obj = bitmap;
            if (obj != null) {
                h.dvb.j(obj);
            }
            throw th;
        }
    }

    public final Bitmap a(String str, Options options, DecodeResultLogger decodeResultLogger) {
        Throwable e;
        Bitmap bitmap = null;
        InputStream openRead;
        try {
            openRead = FileOp.openRead(str);
            try {
                bitmap = a(openRead, options, decodeResultLogger);
                e.f(openRead);
            } catch (Exception e2) {
                e = e2;
                try {
                    x.printErrStackTrace("MicroMsg.InBitmapFactory", e, "error decode bitmap %s", new Object[]{e.getMessage()});
                    e.f(openRead);
                    return bitmap;
                } catch (Throwable th) {
                    e = th;
                    e.f(openRead);
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            openRead = bitmap;
        } catch (Throwable th2) {
            e = th2;
            openRead = bitmap;
            e.f(openRead);
            throw e;
        }
        return bitmap;
    }

    public final Bitmap a(String str, Rect rect, Options options, DecodeResultLogger decodeResultLogger) {
        Exception e;
        ByteBuffer byteBuffer;
        Throwable th;
        Object obj;
        InputStream byteBuffer2;
        InputStream inputStream = null;
        InputStream openRead;
        try {
            openRead = FileOp.openRead(str);
            try {
                ByteBuffer byteBuffer3 = (ByteBuffer) h.dvb.bW();
                try {
                    Bitmap a = a(openRead, rect, a(openRead, options, byteBuffer3, true, rect), decodeResultLogger);
                    if (byteBuffer3 != null) {
                        h.dvb.j(byteBuffer3);
                    }
                    e.f(openRead);
                    return a;
                } catch (Exception e2) {
                    e = e2;
                    byteBuffer2 = byteBuffer3;
                } catch (Throwable th2) {
                    th = th2;
                    byteBuffer2 = byteBuffer3;
                    if (obj != null) {
                        h.dvb.j(obj);
                    }
                    e.f(openRead);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                byteBuffer2 = inputStream;
                try {
                    x.e("MicroMsg.InBitmapFactory", "error decode bitmap %s", new Object[]{e.getMessage()});
                    if (obj != null) {
                        h.dvb.j(obj);
                    }
                    e.f(openRead);
                    return inputStream;
                } catch (Throwable th3) {
                    th = th3;
                    if (obj != null) {
                        h.dvb.j(obj);
                    }
                    e.f(openRead);
                    throw th;
                }
            } catch (Throwable th32) {
                th = th32;
                byteBuffer2 = inputStream;
                if (obj != null) {
                    h.dvb.j(obj);
                }
                e.f(openRead);
                throw th;
            }
        } catch (Exception e32) {
            e = e32;
            openRead = inputStream;
            obj = inputStream;
        } catch (Throwable th322) {
            th = th322;
            openRead = inputStream;
            obj = inputStream;
            if (obj != null) {
                h.dvb.j(obj);
            }
            e.f(openRead);
            throw th;
        }
    }

    @TargetApi(19)
    private static Options a(InputStream inputStream, Options options, ByteBuffer byteBuffer, boolean z, Rect rect) {
        if (options == null) {
            options = new Options();
        }
        if (byteBuffer != null) {
            options.inTempStorage = byteBuffer.array();
        }
        options.inJustDecodeBounds = true;
        MMBitmapFactory.decodeStream(inputStream, null, options, 0);
        if (options.outWidth == -1 || options.outHeight == -1) {
            throw new IllegalArgumentException("cannot get the bitmap size!");
        }
        int i;
        Bitmap bitmap;
        boolean z2;
        options.inJustDecodeBounds = false;
        options.inDither = true;
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        if (rect == null) {
            x.i("MicroMsg.InBitmapFactory", "options.outWidth: %s, options.outHeight: %s, sampleSize: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(options.inSampleSize)});
            i = i3;
        } else {
            i2 = rect.right - rect.left;
            x.i("MicroMsg.InBitmapFactory", "region decode, width: %s, height: %s, rect: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(rect.bottom - rect.top), rect});
            i = i3;
        }
        c cVar;
        c cVar2;
        if (z) {
            cVar = c.duT;
            cVar2 = c.duT;
            bitmap = (Bitmap) cVar.c(c.d(Integer.valueOf(i2 * i)));
            if (bitmap != null && d.fR(19)) {
                bitmap.reconfigure(i2, i, Config.ARGB_8888);
            }
        } else {
            cVar = c.duT;
            cVar2 = c.duT;
            bitmap = cVar.e(c.d(Integer.valueOf(i * i2)));
        }
        String str = "MicroMsg.InBitmapFactory";
        String str2 = "bitmapToReuse: %s, isRecycle: %s, isRegionDecode: %s, width: %s, height: %s";
        Object[] objArr = new Object[5];
        objArr[0] = bitmap;
        if (bitmap == null || bitmap.isRecycled()) {
            z2 = true;
        } else {
            z2 = false;
        }
        objArr[1] = Boolean.valueOf(z2);
        objArr[2] = Boolean.valueOf(z);
        if (bitmap != null) {
            i = bitmap.getWidth();
        } else {
            i = 0;
        }
        objArr[3] = Integer.valueOf(i);
        objArr[4] = Integer.valueOf(bitmap != null ? bitmap.getHeight() : 0);
        x.i(str, str2, objArr);
        if (!(bitmap == null || !bitmap.isMutable() || bitmap.isRecycled())) {
            options.inBitmap = bitmap;
        }
        options.inMutable = true;
        c.c(options);
        x.i("MicroMsg.InBitmapFactory", "mimetype: %s", new Object[]{options.outMimeType});
        return options;
    }

    private static Bitmap a(InputStream inputStream, Rect rect, Options options, DecodeResultLogger decodeResultLogger) {
        Bitmap decodeStream;
        Exception e;
        Bitmap bitmap;
        Bitmap bitmap2 = null;
        try {
            l.i(inputStream);
            inputStream.mark(25165824);
            if (rect == null) {
                try {
                    bitmap2 = MMBitmapFactory.decodeStream(inputStream, null, options, decodeResultLogger, 0, new int[0]);
                } catch (Throwable e2) {
                    int height;
                    String str = "MicroMsg.InBitmapFactory";
                    String str2 = "decode with inBitmap error: %s, outWidth: %s, outHeight: %s, sampleSize: %s, reuseBitmapWidth: %s, reuseBitmapHeight: %s";
                    Object[] objArr = new Object[6];
                    objArr[0] = e2.getMessage();
                    objArr[1] = Integer.valueOf(options.outWidth);
                    objArr[2] = Integer.valueOf(options.outHeight);
                    objArr[3] = Integer.valueOf(options.inSampleSize);
                    objArr[4] = Integer.valueOf(options.inBitmap != null ? options.inBitmap.getWidth() : 0);
                    if (options.inBitmap != null) {
                        height = options.inBitmap.getHeight();
                    } else {
                        height = 0;
                    }
                    objArr[5] = Integer.valueOf(height);
                    x.printErrStackTrace(str, e2, str2, objArr);
                }
            } else {
                bitmap2 = MMBitmapFactory.decodeRegion(inputStream, rect, options, decodeResultLogger);
            }
            if (bitmap2 == null) {
                try {
                    x.i("MicroMsg.InBitmapFactory", "decode again");
                    l.i(inputStream);
                    options.inBitmap = null;
                    if (rect == null) {
                        decodeStream = MMBitmapFactory.decodeStream(inputStream, null, options, decodeResultLogger, 0, new int[0]);
                    } else {
                        decodeStream = MMBitmapFactory.decodeRegion(inputStream, rect, options, decodeResultLogger);
                    }
                } catch (Exception e3) {
                    e = e3;
                    bitmap = bitmap2;
                }
            } else {
                decodeStream = bitmap2;
            }
            if (!(rect == null || decodeStream == null)) {
                try {
                    if (decodeStream.getWidth() > rect.right - rect.left && decodeStream.getHeight() > rect.bottom - rect.top) {
                        x.i("MicroMsg.InBitmapFactory", "fuck region decode size not match, clip it, reqWidth: %s, reqHeight: %s, resultWidth: %s, resultHeight: %s", new Object[]{Integer.valueOf(rect.right - rect.left), Integer.valueOf(rect.bottom - rect.top), Integer.valueOf(decodeStream.getWidth()), Integer.valueOf(decodeStream.getHeight())});
                        decodeStream = Bitmap.createBitmap(decodeStream, 0, 0, rect.right - rect.left, rect.bottom - rect.top);
                    }
                } catch (Exception e4) {
                    e = e4;
                    bitmap = decodeStream;
                    x.e("MicroMsg.InBitmapFactory", "decodeInternal error: %s", new Object[]{e.getMessage()});
                    decodeStream = bitmap;
                    if (decodeStream != null) {
                        x.i("MicroMsg.InBitmapFactory", "finish decode, decodedBitmap: %s, width: %s, height: %s", new Object[]{decodeStream, Integer.valueOf(decodeStream.getWidth()), Integer.valueOf(decodeStream.getHeight())});
                    }
                    return decodeStream;
                }
            }
        } catch (Exception e32) {
            e = e32;
            bitmap = bitmap2;
            x.e("MicroMsg.InBitmapFactory", "decodeInternal error: %s", new Object[]{e.getMessage()});
            decodeStream = bitmap;
            if (decodeStream != null) {
                x.i("MicroMsg.InBitmapFactory", "finish decode, decodedBitmap: %s, width: %s, height: %s", new Object[]{decodeStream, Integer.valueOf(decodeStream.getWidth()), Integer.valueOf(decodeStream.getHeight())});
            }
            return decodeStream;
        }
        if (decodeStream != null) {
            x.i("MicroMsg.InBitmapFactory", "finish decode, decodedBitmap: %s, width: %s, height: %s", new Object[]{decodeStream, Integer.valueOf(decodeStream.getWidth()), Integer.valueOf(decodeStream.getHeight())});
        }
        return decodeStream;
    }

    public final void l(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            c.duT.k(bitmap);
        }
    }
}
