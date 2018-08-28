package com.tencent.mm.plugin.normsg.b;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.mm.sdk.platformtools.x;
import java.io.FileDescriptor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class b {
    private static final ClassLoader lFW = b.class.getClassLoader();
    private static final String lFX = d.IO("\u001f~\u0010t\u0006i\u0000dJ<U0Gi\bk\bm\u001em\u0004f\u000fc\n~\u0007)`!B!D7D-O&J#W.c\u0002l\rj\u000f}Y\n~\u000bi");
    private static final String lFY = d.IO("\u0011p\u001ez\bg\u000ejD+Xv%@2D-N+f\u0007i\bo\nx");
    private static final String lFZ = d.IO("\u0007t7V5]8");
    private static final String lGa = d.IO("\u0017v\u0005L\"V3A'F%@");
    private static final String lGb = d.IO("\ng$E)E'F%N");
    private static final String lGc = d.IO("\u000ec5\\9N\u001cs\u001ch!L<P");
    private static final String lGd = d.IO("Ñ°ÞºÈ§Îªòþ§Æ¥Æ£Ð£Ê¨Á­Ä°Éç®ïïùãèíà©Ç³Ö¤Å¦Ò»Ôºùøóäâ");
    private static final String lGe = d.IO("Ù¸Ü¸ùùïõþûö¿Ñ¥À²Ó°Ä­Â¬ïîåòô");
    private static final String lGf = d.IO("éëÞ½Þ»È»Ò°ÙµÜ¨ÑöçôãåÈ§É½Ï Ì Å·");
    private static final String lGg = d.IO("\u001ak\u001e{\tp<S0Q=t\u001an\u000by\u001f~\u001dx");
    private static final String lGh = d.IO("?Y0^:l\u0005`\u0017U,m\u000em\b{\ba\u0003j\u0006o\u001bb+O");
    private static final String lGi = d.IO("+M$J.o\fo\ny\nc\u0001h\u0004m\u0019`.A%@\tg\u0001n,U\u0014w\u0014q\u0002q\u0018z\u0013\u0016b\u001bR6");
    private static final String lGj = d.IO("!G.@$e\u0006e\u0000s\u0000i\u000bb\u000eg\u0013j$K/J\u0003m\u000bd&_\t`\u0005r;_");
    private static final String lGk = d.IO("÷ðÕ¶Õ°Ã°Ù»Ò¾×£Úûú³Ý»Ô§åÊ£Æ±ø");
    private static final String lGl = d.IO("±×¾Ð´õõãùò÷ú´Û¿ÚýôÅ¼èõ");
    private static final String lGm = d.IO("\rk\u0002l\bN!B7D");
    private static final String lGn = d.IO("\"D+H=N\u001dx\u0019k\b`");
    private static final String lGo = d.IO("m\u001dx\nl\u0003q\u001c]>]8K8Q3Z6_+R\u0013p\u0004m\u0002l");
    private static final String lGp = d.IO("Ì¿Ú®èïÊ©Ê¯Ü¯Æ¤Í¡È¼Åäå¬Â¤Ëüúâ");
    private static final String lGq = d.IO("¬ßºÎáëªÉªÏ¼Ï¦Ä­Á¨Ü¥ëàÌ¢Ä«Øïéñ");
    private static final String lGr = d.IO("îøÜ¹Ë­Â°Ýÿùùò÷êÒ±Å¬Ã­ÿéð");
    private volatile boolean dti;
    public final Queue<g> lGs;
    private final Map<Object, IBinder> lGt;
    private final Map<IBinder, Integer> lGu;
    private final Handler lGv;
    private IInterface lGw;

    private class e implements InvocationHandler {
        protected final IInterface lGM;

        e(IInterface iInterface) {
            this.lGM = iInterface;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            try {
                if ("asBinder".equals(method.getName())) {
                    return asBinder();
                }
                return method.invoke(this.lGM, objArr);
            } catch (InvocationTargetException e) {
                Throwable targetException = e.getTargetException();
                if (targetException instanceof RuntimeException) {
                    throw targetException;
                }
                Class[] exceptionTypes = method.getExceptionTypes();
                if (exceptionTypes != null && exceptionTypes.length > 0) {
                    for (Class isAssignableFrom : method.getExceptionTypes()) {
                        if (isAssignableFrom.isAssignableFrom(targetException.getClass())) {
                            throw targetException;
                        }
                    }
                }
                b.a(b.this, targetException);
                return b.b(method);
            } catch (Throwable th) {
                b.a(b.this, th);
                return b.b(method);
            }
        }

        public IBinder asBinder() {
            return this.lGM.asBinder();
        }
    }

    public static class f extends Exception {
        f(String str) {
            super(str);
        }

        f(Throwable th) {
            super(th);
        }
    }

    public interface g {
        void a(int i, View view, List<AccessibilityNodeInfo> list);

        boolean a(int i, int i2, View view);

        void f(Throwable th);
    }

    private static final class h {
        static final b lGN = new b();
    }

    private final class i implements IBinder {
        private final Class<?> lGO;
        private a<String> lGP = null;
        private String lGQ = null;

        i(Class<?> cls) {
            this.lGO = cls;
        }

        public final synchronized SparseArray<String> bjZ() {
            SparseArray<String> sparseArray;
            if (this.lGP != null) {
                sparseArray = this.lGP;
            } else {
                this.lGP = new a(this, (byte) 0);
                try {
                    IInterface iInterface = (IInterface) h.b(this.lGO, "asInterface", h.b(IBinder.class), this);
                    for (Class cls : this.lGO.getInterfaces()) {
                        if (IInterface.class.isAssignableFrom(cls)) {
                            for (Method method : cls.getDeclaredMethods()) {
                                if (!"asBinder".equals(method.getName())) {
                                    this.lGQ = method.getName();
                                    if (!method.isAccessible()) {
                                        method.setAccessible(true);
                                    }
                                    Class[] parameterTypes = method.getParameterTypes();
                                    int length = parameterTypes.length;
                                    Object[] objArr = new Object[length];
                                    for (int i = 0; i < length; i++) {
                                        Class cls2 = parameterTypes[i];
                                        if (cls2.isPrimitive()) {
                                            if (Boolean.TYPE.isAssignableFrom(cls2)) {
                                                objArr[i] = Boolean.valueOf(false);
                                            } else {
                                                objArr[i] = Integer.valueOf(0);
                                            }
                                        } else if (Number.class.isAssignableFrom(cls2)) {
                                            objArr[i] = Integer.valueOf(0);
                                        } else if (Character.class.isAssignableFrom(cls2)) {
                                            objArr[i] = Character.valueOf(0);
                                        } else if (Boolean.class.isAssignableFrom(cls2)) {
                                            objArr[i] = Boolean.valueOf(false);
                                        } else {
                                            objArr[i] = null;
                                        }
                                    }
                                    method.invoke(iInterface, objArr);
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    x.printErrStackTrace("MicroMsg.AED", th, "unexpected exception.", new Object[0]);
                    b.a(b.this, th);
                    this.lGP.clear();
                }
                sparseArray = this.lGP;
            }
            return sparseArray;
        }

        public final String getInterfaceDescriptor() {
            return null;
        }

        public final boolean pingBinder() {
            return false;
        }

        public final boolean isBinderAlive() {
            return false;
        }

        public final IInterface queryLocalInterface(String str) {
            return null;
        }

        public final void dump(FileDescriptor fileDescriptor, String[] strArr) {
        }

        public final void dumpAsync(FileDescriptor fileDescriptor, String[] strArr) {
        }

        public final boolean transact(int i, Parcel parcel, Parcel parcel2, int i2) {
            synchronized (this) {
                if (this.lGP != null) {
                    this.lGP.put(i, this.lGQ);
                }
            }
            return false;
        }

        public final void linkToDeath(DeathRecipient deathRecipient, int i) {
        }

        public final boolean unlinkToDeath(DeathRecipient deathRecipient, int i) {
            return false;
        }
    }

    /* synthetic */ b(byte b) {
        this();
    }

    static /* synthetic */ void a(b bVar, Throwable th) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            bVar.h(th);
            return;
        }
        Object obj = new boolean[]{null};
        bVar.lGv.post(new 3(bVar, th, obj));
        synchronized (obj) {
            while (!obj[0]) {
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public static b bjN() {
        return h.lGN;
    }

    public final synchronized void initialize(Context context) {
        f fVar;
        if (!this.dti) {
            if (VERSION.SDK_INT < 15) {
                throw new f("unsupported system, api: " + VERSION.SDK_INT);
            }
            try {
                IBinder iBinder = (IBinder) h.a(lFY, "getService", h.b(String.class), "accessibility");
                IInterface iInterface = (IInterface) h.a(lFX, lGa, h.b(IBinder.class), iBinder);
                this.lGw = (IInterface) Proxy.newProxyInstance(lFW, iInterface.getClass().getInterfaces(), new c(this, iInterface));
                ((Map) h.eb(lFY, lFZ)).put("accessibility", this.lGw.asBinder());
                try {
                    Object g;
                    Object b = h.b(AccessibilityManager.class, "getInstance", h.b(Context.class), context);
                    try {
                        g = h.g(b, "mLock");
                    } catch (Throwable th) {
                        g = null;
                    }
                    if (g != null) {
                        synchronized (g) {
                            h.a(b, "mService", this.lGw);
                        }
                    } else {
                        h.a(b, "mService", this.lGw);
                    }
                    this.dti = true;
                } catch (Throwable th2) {
                    fVar = new f(th2);
                }
            } catch (Throwable th22) {
                fVar = new f(th22);
            }
        }
    }

    public final synchronized void Ff() {
        if (!this.dti) {
            throw new IllegalStateException("you must call initialize first.");
        }
    }

    private void b(int i, View view, List<AccessibilityNodeInfo> list) {
        for (g a : this.lGs) {
            a.a(i, view, (List) list);
        }
    }

    private boolean b(int i, int i2, View view) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return c(i, i2, view);
        }
        Object obj = new boolean[]{true, false};
        this.lGv.post(new 2(this, obj, i, i2, view));
        synchronized (obj) {
            while (!obj[1]) {
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                }
            }
        }
        return obj[0];
    }

    private boolean c(int i, int i2, View view) {
        for (g a : this.lGs) {
            if (!a.a(i, i2, view)) {
                return false;
            }
        }
        return true;
    }

    private void h(Throwable th) {
        for (g f : this.lGs) {
            f.f(th);
        }
    }

    private b() {
        this.lGs = new ConcurrentLinkedQueue();
        this.lGt = new WeakHashMap();
        this.lGu = new ConcurrentHashMap();
        this.lGv = new Handler(Looper.getMainLooper());
        this.lGw = null;
        this.dti = false;
    }
}
