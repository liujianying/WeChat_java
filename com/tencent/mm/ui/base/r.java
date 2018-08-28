package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.Environment;
import android.os.StatFs;
import android.util.Base64;
import android.util.StringBuilderPrinter;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@TargetApi(16)
final class r extends SurfaceTexture {
    public SurfaceTexture iSV = null;

    public r() {
        super(0);
    }

    public final void setOnFrameAvailableListener(OnFrameAvailableListener onFrameAvailableListener) {
        x.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, setOnFrameAvailableListener");
        this.iSV.setOnFrameAvailableListener(onFrameAvailableListener);
    }

    public final void setDefaultBufferSize(int i, int i2) {
        x.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, setDefaultBufferSize");
        this.iSV.setDefaultBufferSize(i, i2);
    }

    public final void updateTexImage() {
        x.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, updateTexImage");
        this.iSV.updateTexImage();
    }

    public final void detachFromGLContext() {
        boolean z;
        String str;
        x.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, detachFromGLContext");
        try {
            this.iSV.detachFromGLContext();
            z = false;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", e, "%s", new Object[]{"detect texture problem, RuntimeException detachFromGLContext"});
            z = true;
        }
        if (z) {
            String str2;
            try {
                Method declaredMethod = SurfaceTexture.class.getDeclaredMethod("nativeDetachFromGLContext", new Class[0]);
                declaredMethod.setAccessible(true);
                str2 = JB() + " detect texture problem error code = " + ((Integer) declaredMethod.invoke(this.iSV, new Object[0])).intValue() + ", detach = true, and error = " + z;
                b.A(Base64.encodeToString(str2.getBytes(), 2), "DetachFromGLContext");
                x.w("MicroMsg.MMSurfaceTextureWrap", str2);
                x.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", new Object[]{Integer.valueOf(r0), Boolean.valueOf(true), Boolean.valueOf(z)});
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", e2, "%s", new Object[]{"detect texture problem, IllegalArgumentException"});
                str = JB() + " detect texture problem error code = 0, detach = false, and error = " + z;
                b.A(Base64.encodeToString(str.getBytes(), 2), "DetachFromGLContext");
                x.w("MicroMsg.MMSurfaceTextureWrap", str);
                x.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", new Object[]{Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(z)});
            } catch (Throwable e22) {
                x.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", e22, "%s", new Object[]{"detect texture problem, IllegalAccessException"});
                str = JB() + " detect texture problem error code = 0, detach = false, and error = " + z;
                b.A(Base64.encodeToString(str.getBytes(), 2), "DetachFromGLContext");
                x.w("MicroMsg.MMSurfaceTextureWrap", str);
                x.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", new Object[]{Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(z)});
            } catch (Throwable e222) {
                x.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", e222, "%s", new Object[]{"detect texture problem, InvocationTargetException"});
                str = JB() + " detect texture problem error code = 0, detach = false, and error = " + z;
                b.A(Base64.encodeToString(str.getBytes(), 2), "DetachFromGLContext");
                x.w("MicroMsg.MMSurfaceTextureWrap", str);
                x.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", new Object[]{Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(z)});
            } catch (Throwable e2222) {
                x.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", e2222, "%s", new Object[]{"detect texture problem, NoSuchMethodException"});
                str = JB() + " detect texture problem error code = 0, detach = false, and error = " + z;
                b.A(Base64.encodeToString(str.getBytes(), 2), "DetachFromGLContext");
                x.w("MicroMsg.MMSurfaceTextureWrap", str);
                x.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", new Object[]{Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(z)});
            } catch (Throwable e22222) {
                x.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", e22222, "%s", new Object[]{"detect texture problem, Exception"});
                str = JB() + " detect texture problem error code = 0, detach = false, and error = " + z;
                b.A(Base64.encodeToString(str.getBytes(), 2), "DetachFromGLContext");
                x.w("MicroMsg.MMSurfaceTextureWrap", str);
                x.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", new Object[]{Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(z)});
            } catch (Throwable th) {
                str2 = JB() + " detect texture problem error code = 0, detach = false, and error = " + z;
                b.A(Base64.encodeToString(str2.getBytes(), 2), "DetachFromGLContext");
                x.w("MicroMsg.MMSurfaceTextureWrap", str2);
                x.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", new Object[]{Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(z)});
            }
        }
    }

    private static String JB() {
        String format;
        StringBuilder stringBuilder = new StringBuilder(256);
        StringBuilderPrinter stringBuilderPrinter = new StringBuilderPrinter(stringBuilder);
        Context context = ad.getContext();
        stringBuilderPrinter.println("#accinfo.revision=" + d.REV);
        stringBuilderPrinter.println("#accinfo.build=" + d.TIME + ":" + d.HOSTNAME + ":" + e.bxk);
        stringBuilderPrinter.println("#accinfo.env=" + (b.foreground ? "f" : "b") + ":" + Thread.currentThread().getName() + ":" + b.sFc);
        String str = "";
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            StatFs statFs2 = new StatFs(com.tencent.mm.compatible.util.e.bnC);
            format = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[]{Integer.valueOf(((ActivityManager) context.getSystemService("activity")).getMemoryClass()), r5.getAbsolutePath(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()), com.tencent.mm.compatible.util.e.bnC, Integer.valueOf(statFs2.getBlockSize()), Integer.valueOf(statFs2.getBlockCount()), Integer.valueOf(statFs2.getAvailableBlocks())});
        } catch (Exception e) {
            x.e("MicroMsg.MMSurfaceTextureWrap", "check data size failed :%s", new Object[]{e.getMessage()});
            format = str;
        }
        stringBuilderPrinter.println("#accinfo.data=" + format);
        stringBuilderPrinter.println("#accinfo.crashTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(new Date()));
        stringBuilderPrinter.println("#crashContent=");
        return stringBuilder.toString();
    }

    public final void attachToGLContext(int i) {
        x.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, attachToGLContext");
        this.iSV.attachToGLContext(i);
    }

    public final void getTransformMatrix(float[] fArr) {
        x.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, getTransformMatrix");
        this.iSV.getTransformMatrix(fArr);
    }

    public final long getTimestamp() {
        x.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, getTimestamp");
        return this.iSV.getTimestamp();
    }

    public final void release() {
        super.release();
        x.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, release");
        this.iSV.release();
    }

    public final boolean equals(Object obj) {
        return this.iSV.equals(obj);
    }

    public final int hashCode() {
        return this.iSV.hashCode();
    }

    public final String toString() {
        return this.iSV.toString();
    }

    @TargetApi(19)
    public final void releaseTexImage() {
        x.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, releaseTexImage");
        this.iSV.releaseTexImage();
    }
}
