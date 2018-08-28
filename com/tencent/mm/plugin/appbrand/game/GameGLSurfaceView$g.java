package com.tencent.mm.plugin.appbrand.game;

import android.opengl.GLException;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.io.IOException;
import java.io.Writer;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGL11;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class GameGLSurfaceView$g implements EGL11 {
    private EGL10 fzi;
    Writer fzj;
    boolean fzk;
    boolean fzl;
    private int fzm;

    public final boolean eglChooseConfig(EGLDisplay eGLDisplay, int[] iArr, EGLConfig[] eGLConfigArr, int i, int[] iArr2) {
        rt("eglChooseConfig");
        a("display", eGLDisplay);
        a("attrib_list", iArr);
        ay("config_size", i);
        end();
        boolean eglChooseConfig = this.fzi.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i, iArr2);
        l("configs", eGLConfigArr);
        a("num_config", iArr2);
        cB(eglChooseConfig);
        checkError();
        return eglChooseConfig;
    }

    public final boolean eglCopyBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface, Object obj) {
        rt("eglCopyBuffers");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        s("native_pixmap", obj);
        end();
        boolean eglCopyBuffers = this.fzi.eglCopyBuffers(eGLDisplay, eGLSurface, obj);
        cB(eglCopyBuffers);
        checkError();
        return eglCopyBuffers;
    }

    public final EGLContext eglCreateContext(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int[] iArr) {
        rt("eglCreateContext");
        a("display", eGLDisplay);
        s("config", eGLConfig);
        a("share_context", eGLContext);
        a("attrib_list", iArr);
        end();
        EGLContext eglCreateContext = this.fzi.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        bi(eglCreateContext);
        checkError();
        return eglCreateContext;
    }

    public final EGLSurface eglCreatePbufferSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int[] iArr) {
        rt("eglCreatePbufferSurface");
        a("display", eGLDisplay);
        s("config", eGLConfig);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePbufferSurface = this.fzi.eglCreatePbufferSurface(eGLDisplay, eGLConfig, iArr);
        bi(eglCreatePbufferSurface);
        checkError();
        return eglCreatePbufferSurface;
    }

    public final EGLSurface eglCreatePixmapSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        rt("eglCreatePixmapSurface");
        a("display", eGLDisplay);
        s("config", eGLConfig);
        s("native_pixmap", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePixmapSurface = this.fzi.eglCreatePixmapSurface(eGLDisplay, eGLConfig, obj, iArr);
        bi(eglCreatePixmapSurface);
        checkError();
        return eglCreatePixmapSurface;
    }

    public final EGLSurface eglCreateWindowSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        rt("eglCreateWindowSurface");
        a("display", eGLDisplay);
        s("config", eGLConfig);
        s("native_window", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreateWindowSurface = this.fzi.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, iArr);
        bi(eglCreateWindowSurface);
        checkError();
        return eglCreateWindowSurface;
    }

    public final boolean eglDestroyContext(EGLDisplay eGLDisplay, EGLContext eGLContext) {
        rt("eglDestroyContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        end();
        boolean eglDestroyContext = this.fzi.eglDestroyContext(eGLDisplay, eGLContext);
        cB(eglDestroyContext);
        checkError();
        return eglDestroyContext;
    }

    public final boolean eglDestroySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        rt("eglDestroySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglDestroySurface = this.fzi.eglDestroySurface(eGLDisplay, eGLSurface);
        cB(eglDestroySurface);
        checkError();
        return eglDestroySurface;
    }

    public final boolean eglGetConfigAttrib(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int[] iArr) {
        rt("eglGetConfigAttrib");
        a("display", eGLDisplay);
        s("config", eGLConfig);
        ay("attribute", i);
        end();
        boolean eglGetConfigAttrib = this.fzi.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, iArr);
        a(DownloadSettingTable$Columns.VALUE, iArr);
        cB(eglGetConfigAttrib);
        checkError();
        return false;
    }

    public final boolean eglGetConfigs(EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr, int i, int[] iArr) {
        rt("eglGetConfigs");
        a("display", eGLDisplay);
        ay("config_size", i);
        end();
        boolean eglGetConfigs = this.fzi.eglGetConfigs(eGLDisplay, eGLConfigArr, i, iArr);
        l("configs", eGLConfigArr);
        a("num_config", iArr);
        cB(eglGetConfigs);
        checkError();
        return eglGetConfigs;
    }

    public final EGLContext eglGetCurrentContext() {
        rt("eglGetCurrentContext");
        end();
        EGLContext eglGetCurrentContext = this.fzi.eglGetCurrentContext();
        bi(eglGetCurrentContext);
        checkError();
        return eglGetCurrentContext;
    }

    public final EGLDisplay eglGetCurrentDisplay() {
        rt("eglGetCurrentDisplay");
        end();
        EGLDisplay eglGetCurrentDisplay = this.fzi.eglGetCurrentDisplay();
        bi(eglGetCurrentDisplay);
        checkError();
        return eglGetCurrentDisplay;
    }

    public final EGLSurface eglGetCurrentSurface(int i) {
        rt("eglGetCurrentSurface");
        ay("readdraw", i);
        end();
        EGLSurface eglGetCurrentSurface = this.fzi.eglGetCurrentSurface(i);
        bi(eglGetCurrentSurface);
        checkError();
        return eglGetCurrentSurface;
    }

    public final EGLDisplay eglGetDisplay(Object obj) {
        rt("eglGetDisplay");
        s("native_display", obj);
        end();
        EGLDisplay eglGetDisplay = this.fzi.eglGetDisplay(obj);
        bi(eglGetDisplay);
        checkError();
        return eglGetDisplay;
    }

    public final int eglGetError() {
        rt("eglGetError");
        end();
        int eglGetError = this.fzi.eglGetError();
        sM(kk(eglGetError));
        return eglGetError;
    }

    public final boolean eglInitialize(EGLDisplay eGLDisplay, int[] iArr) {
        rt("eglInitialize");
        a("display", eGLDisplay);
        end();
        boolean eglInitialize = this.fzi.eglInitialize(eGLDisplay, iArr);
        cB(eglInitialize);
        a("major_minor", iArr);
        checkError();
        return eglInitialize;
    }

    public final boolean eglMakeCurrent(EGLDisplay eGLDisplay, EGLSurface eGLSurface, EGLSurface eGLSurface2, EGLContext eGLContext) {
        rt("eglMakeCurrent");
        a("display", eGLDisplay);
        a("draw", eGLSurface);
        a("read", eGLSurface2);
        a("context", eGLContext);
        end();
        boolean eglMakeCurrent = this.fzi.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface2, eGLContext);
        cB(eglMakeCurrent);
        checkError();
        return eglMakeCurrent;
    }

    public final boolean eglQueryContext(EGLDisplay eGLDisplay, EGLContext eGLContext, int i, int[] iArr) {
        rt("eglQueryContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        ay("attribute", i);
        end();
        boolean eglQueryContext = this.fzi.eglQueryContext(eGLDisplay, eGLContext, i, iArr);
        kj(iArr[0]);
        cB(eglQueryContext);
        checkError();
        return eglQueryContext;
    }

    public final String eglQueryString(EGLDisplay eGLDisplay, int i) {
        rt("eglQueryString");
        a("display", eGLDisplay);
        ay("name", i);
        end();
        String eglQueryString = this.fzi.eglQueryString(eGLDisplay, i);
        sM(eglQueryString);
        checkError();
        return eglQueryString;
    }

    public final boolean eglQuerySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface, int i, int[] iArr) {
        rt("eglQuerySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        ay("attribute", i);
        end();
        boolean eglQuerySurface = this.fzi.eglQuerySurface(eGLDisplay, eGLSurface, i, iArr);
        kj(iArr[0]);
        cB(eglQuerySurface);
        checkError();
        return eglQuerySurface;
    }

    public final boolean eglSwapBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        rt("eglSwapBuffers");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglSwapBuffers = this.fzi.eglSwapBuffers(eGLDisplay, eGLSurface);
        cB(eglSwapBuffers);
        checkError();
        return eglSwapBuffers;
    }

    public final boolean eglTerminate(EGLDisplay eGLDisplay) {
        rt("eglTerminate");
        a("display", eGLDisplay);
        end();
        boolean eglTerminate = this.fzi.eglTerminate(eGLDisplay);
        cB(eglTerminate);
        checkError();
        return eglTerminate;
    }

    public final boolean eglWaitGL() {
        rt("eglWaitGL");
        end();
        boolean eglWaitGL = this.fzi.eglWaitGL();
        cB(eglWaitGL);
        checkError();
        return eglWaitGL;
    }

    public final boolean eglWaitNative(int i, Object obj) {
        rt("eglWaitNative");
        ay("engine", i);
        s("bindTarget", obj);
        end();
        boolean eglWaitNative = this.fzi.eglWaitNative(i, obj);
        cB(eglWaitNative);
        checkError();
        return eglWaitNative;
    }

    private void checkError() {
        int eglGetError = this.fzi.eglGetError();
        if (eglGetError != 12288) {
            String str = "eglError: " + kk(eglGetError);
            sL(str + 10);
            if (this.fzl) {
                throw new GLException(eglGetError, str);
            }
        }
    }

    private void sL(String str) {
        try {
            this.fzj.write(str);
        } catch (IOException e) {
        }
    }

    private void rt(String str) {
        sL(str + '(');
        this.fzm = 0;
    }

    private void bl(String str, String str2) {
        int i = this.fzm;
        this.fzm = i + 1;
        if (i > 0) {
            sL(", ");
        }
        if (this.fzk) {
            sL(str + "=");
        }
        sL(str2);
    }

    private void end() {
        sL(");\n");
        flush();
    }

    private void flush() {
        try {
            this.fzj.flush();
        } catch (IOException e) {
            this.fzj = null;
        }
    }

    private void ay(String str, int i) {
        bl(str, Integer.toString(i));
    }

    private void s(String str, Object obj) {
        bl(str, toString(obj));
    }

    private void a(String str, EGLDisplay eGLDisplay) {
        if (eGLDisplay == EGL10.EGL_DEFAULT_DISPLAY) {
            bl(str, "EGL10.EGL_DEFAULT_DISPLAY");
        } else if (eGLDisplay == EGL_NO_DISPLAY) {
            bl(str, "EGL10.EGL_NO_DISPLAY");
        } else {
            bl(str, toString(eGLDisplay));
        }
    }

    private void a(String str, EGLContext eGLContext) {
        if (eGLContext == EGL10.EGL_NO_CONTEXT) {
            bl(str, "EGL10.EGL_NO_CONTEXT");
        } else {
            bl(str, toString(eGLContext));
        }
    }

    private void a(String str, EGLSurface eGLSurface) {
        if (eGLSurface == EGL10.EGL_NO_SURFACE) {
            bl(str, "EGL10.EGL_NO_SURFACE");
        } else {
            bl(str, toString(eGLSurface));
        }
    }

    private void sM(String str) {
        sL(" returns " + str + ";\n");
        flush();
    }

    private void kj(int i) {
        sM(Integer.toString(i));
    }

    private void cB(boolean z) {
        sM(Boolean.toString(z));
    }

    private void bi(Object obj) {
        sM(toString(obj));
    }

    private static String toString(Object obj) {
        if (obj == null) {
            return "null";
        }
        return obj.toString();
    }

    private void a(String str, int[] iArr) {
        if (iArr == null) {
            bl(str, "null");
            return;
        }
        int length = iArr.length;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\n");
        int length2 = iArr.length;
        for (int i = 0; i < length; i++) {
            int i2 = i + 0;
            stringBuilder.append(" [" + i2 + "] = ");
            if (i2 < 0 || i2 >= length2) {
                stringBuilder.append("out of bounds");
            } else {
                stringBuilder.append(iArr[i2]);
            }
            stringBuilder.append(10);
        }
        stringBuilder.append("}");
        bl(str, stringBuilder.toString());
    }

    private void l(String str, Object[] objArr) {
        if (objArr == null) {
            bl(str, "null");
            return;
        }
        int length = objArr.length;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\n");
        int length2 = objArr.length;
        for (int i = 0; i < length; i++) {
            int i2 = i + 0;
            stringBuilder.append(" [" + i2 + "] = ");
            if (i2 < 0 || i2 >= length2) {
                stringBuilder.append("out of bounds");
            } else {
                stringBuilder.append(objArr[i2]);
            }
            stringBuilder.append(10);
        }
        stringBuilder.append("}");
        bl(str, stringBuilder.toString());
    }

    public static String kk(int i) {
        switch (i) {
            case 12288:
                return "EGL_SUCCESS";
            case 12289:
                return "EGL_NOT_INITIALIZED";
            case 12290:
                return "EGL_BAD_ACCESS";
            case 12291:
                return "EGL_BAD_ALLOC";
            case 12292:
                return "EGL_BAD_ATTRIBUTE";
            case 12293:
                return "EGL_BAD_CONFIG";
            case 12294:
                return "EGL_BAD_CONTEXT";
            case 12295:
                return "EGL_BAD_CURRENT_SURFACE";
            case 12296:
                return "EGL_BAD_DISPLAY";
            case 12297:
                return "EGL_BAD_MATCH";
            case 12298:
                return "EGL_BAD_NATIVE_PIXMAP";
            case 12299:
                return "EGL_BAD_NATIVE_WINDOW";
            case 12300:
                return "EGL_BAD_PARAMETER";
            case 12301:
                return "EGL_BAD_SURFACE";
            case 12302:
                return "EGL_CONTEXT_LOST";
            default:
                return "0x" + Integer.toHexString(i);
        }
    }
}
