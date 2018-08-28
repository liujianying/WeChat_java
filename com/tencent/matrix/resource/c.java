package com.tencent.matrix.resource;

import android.app.Activity;
import android.app.Application;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.b.b;
import com.tencent.matrix.resource.b.a;
import java.lang.reflect.Field;

public class c extends b {
    public final a brq;
    private com.tencent.matrix.resource.e.b brr = null;

    public c(a aVar) {
        this.brq = aVar;
    }

    public static void a(Application application) {
        application.registerActivityLifecycleCallbacks(new com.tencent.matrix.resource.e.a() {
            public final void onActivityDestroyed(Activity activity) {
                long currentTimeMillis = System.currentTimeMillis();
                if (activity != null) {
                    InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
                    if (inputMethodManager != null) {
                        String[] strArr = new String[]{"mCurRootView", "mServedView", "mNextServedView"};
                        for (int i = 0; i < 3; i++) {
                            try {
                                Field declaredField = inputMethodManager.getClass().getDeclaredField(strArr[i]);
                                if (!declaredField.isAccessible()) {
                                    declaredField.setAccessible(true);
                                }
                                Object obj = declaredField.get(inputMethodManager);
                                if (obj instanceof View) {
                                    View view = (View) obj;
                                    if (view.getContext() != activity) {
                                        com.tencent.matrix.d.b.i("Matrix.ActivityLeakFixer", "fixInputMethodManagerLeak break, context is not suitable, get_context=" + view.getContext() + " dest_context=" + activity, new Object[0]);
                                        break;
                                    }
                                    declaredField.set(inputMethodManager, null);
                                } else {
                                    continue;
                                }
                            } catch (Throwable th) {
                                com.tencent.matrix.d.b.e("Matrix.ActivityLeakFixer", "failed to fix InputMethodManagerLeak, %s", th.toString());
                            }
                        }
                    }
                }
                com.tencent.matrix.d.b.i("Matrix.ActivityLeakFixer", "fixInputMethodManagerLeak done, cost: %s ms.", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                currentTimeMillis = System.currentTimeMillis();
                if (activity == null || activity.getWindow() == null || activity.getWindow().peekDecorView() == null) {
                    com.tencent.matrix.d.b.i("Matrix.ActivityLeakFixer", "unbindDrawables, ui or ui's window is null, skip rest works.", new Object[0]);
                } else {
                    View rootView = activity.getWindow().peekDecorView().getRootView();
                    try {
                        a.bA(rootView);
                        if (rootView instanceof ViewGroup) {
                            ((ViewGroup) rootView).removeAllViews();
                        }
                    } catch (Throwable th2) {
                        com.tencent.matrix.d.b.w("Matrix.ActivityLeakFixer", "caught unexpected exception when unbind drawables.", th2);
                    }
                }
                com.tencent.matrix.d.b.i("Matrix.ActivityLeakFixer", "unbindDrawables done, cost: %s ms.", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
        });
    }

    public final void a(Application application, com.tencent.matrix.b.c cVar) {
        super.a(application, cVar);
        if (VERSION.SDK_INT < 14) {
            com.tencent.matrix.d.b.e("Matrix.ResourcePlugin", "API is low Build.VERSION_CODES.ICE_CREAM_SANDWICH(14), ResourcePlugin is not supported", new Object[0]);
            this.brg = false;
            return;
        }
        this.brr = new com.tencent.matrix.resource.e.b(application, this);
    }

    public final void start() {
        super.start();
        if (this.brg) {
            com.tencent.matrix.resource.e.b bVar = this.brr;
            bVar.tA();
            Application application = bVar.bss.application;
            if (application != null) {
                application.registerActivityLifecycleCallbacks(bVar.bsz);
                bVar.bst.a(bVar.bsA, 0);
                com.tencent.matrix.d.b.i("Matrix.ActivityRefWatcher", "watcher is started.", new Object[0]);
                return;
            }
            return;
        }
        com.tencent.matrix.d.b.e("Matrix.ResourcePlugin", "ResourcePlugin start, ResourcePlugin is not supported, just return", new Object[0]);
    }

    public final void stop() {
        super.stop();
        if (this.brg) {
            this.brr.tA();
            com.tencent.matrix.d.b.i("Matrix.ActivityRefWatcher", "watcher is stopped.", new Object[0]);
            return;
        }
        com.tencent.matrix.d.b.e("Matrix.ResourcePlugin", "ResourcePlugin stop, ResourcePlugin is not supported, just return", new Object[0]);
    }

    public final String getTag() {
        return "memory";
    }
}
