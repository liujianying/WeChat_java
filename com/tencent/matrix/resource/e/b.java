package com.tencent.matrix.resource.e;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.os.Debug;
import com.tencent.matrix.resource.CanaryWorkerService;
import com.tencent.matrix.resource.analyzer.model.DestroyedActivityInfo;
import com.tencent.matrix.resource.c;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

public final class b extends com.tencent.matrix.c.a {
    final int brw;
    public final com.tencent.matrix.resource.e.e.a bsA;
    public final c bss;
    public final e bst;
    private final d bsu;
    final c bsv;
    final com.tencent.matrix.resource.e.c.a bsw;
    final ConcurrentLinkedQueue<DestroyedActivityInfo> bsx;
    final AtomicLong bsy;
    public final ActivityLifecycleCallbacks bsz;

    public static class a {
        protected d az(Context context) {
            return new d(context);
        }

        protected c a(Context context, d dVar) {
            return new c(context, dVar);
        }

        protected com.tencent.matrix.resource.e.c.a a(final Context context, com.tencent.matrix.resource.b.a aVar) {
            return new com.tencent.matrix.resource.e.c.a() {
                public final void a(com.tencent.matrix.resource.analyzer.model.a aVar) {
                    CanaryWorkerService.a(context, aVar);
                }
            };
        }
    }

    public b(Application application, final c cVar) {
        this(application, cVar, new a() {
            protected final d az(Context context) {
                if (cVar.brq.brx) {
                    return super.az(context);
                }
                return null;
            }

            protected final c a(Context context, d dVar) {
                if (cVar.brq.brx) {
                    return super.a(context, dVar);
                }
                return null;
            }

            protected final com.tencent.matrix.resource.e.c.a a(Context context, com.tencent.matrix.resource.b.a aVar) {
                if (aVar.brx) {
                    return super.a(context, aVar);
                }
                return null;
            }
        });
    }

    private b(Application application, c cVar, a aVar) {
        super(application, "memory", cVar);
        this.bsz = new a() {
            public final void onActivityCreated(Activity activity, Bundle bundle) {
                b.this.bsy.incrementAndGet();
            }

            public final void onActivityDestroyed(Activity activity) {
                b bVar = b.this;
                String name = activity.getClass().getName();
                if (bVar.cb(name)) {
                    com.tencent.matrix.d.b.d("Matrix.ActivityRefWatcher", "activity leak with name %s had published, just ignore", name);
                    return;
                }
                UUID randomUUID = UUID.randomUUID();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("MATRIX_RESCANARY_REFKEY_").append(name).append('_').append(Long.toHexString(randomUUID.getMostSignificantBits())).append(Long.toHexString(randomUUID.getLeastSignificantBits()));
                bVar.bsx.add(new DestroyedActivityInfo(stringBuilder.toString(), activity, name, bVar.bsy.get()));
            }
        };
        this.bsA = new com.tencent.matrix.resource.e.e.a() {
            public final int tB() {
                if (Debug.isDebuggerConnected()) {
                    com.tencent.matrix.d.b.w("Matrix.ActivityRefWatcher", "debugger is connected, to avoid fake result, detection was delayed.", new Object[0]);
                    return com.tencent.matrix.resource.e.e.a.a.bsQ;
                } else if (b.this.bsx.isEmpty()) {
                    return com.tencent.matrix.resource.e.e.a.a.bsQ;
                } else {
                    WeakReference weakReference = new WeakReference(new Object());
                    com.tencent.matrix.d.b.v("Matrix.ActivityRefWatcher", "triggering gc...", new Object[0]);
                    Runtime.getRuntime().gc();
                    Runtime.getRuntime().runFinalization();
                    com.tencent.matrix.d.b.v("Matrix.ActivityRefWatcher", "gc was triggered.", new Object[0]);
                    if (weakReference.get() != null) {
                        com.tencent.matrix.d.b.d("Matrix.ActivityRefWatcher", "system ignore our gc request, wait for next detection.", new Object[0]);
                        return com.tencent.matrix.resource.e.e.a.a.bsQ;
                    }
                    Iterator it = b.this.bsx.iterator();
                    while (it.hasNext()) {
                        DestroyedActivityInfo destroyedActivityInfo = (DestroyedActivityInfo) it.next();
                        if (b.this.cb(destroyedActivityInfo.mActivityName)) {
                            com.tencent.matrix.d.b.v("Matrix.ActivityRefWatcher", "activity with key [%s] was already published.", destroyedActivityInfo.mActivityName);
                            it.remove();
                        } else if (destroyedActivityInfo.mActivityRef.get() == null) {
                            com.tencent.matrix.d.b.v("Matrix.ActivityRefWatcher", "activity with key [%s] was already recycled.", destroyedActivityInfo.mKey);
                            it.remove();
                        } else {
                            destroyedActivityInfo.mDetectedCount++;
                            long j = b.this.bsy.get() - destroyedActivityInfo.mLastCreatedActivityCount;
                            if (destroyedActivityInfo.mDetectedCount < b.this.brw || j < 2) {
                                com.tencent.matrix.d.b.i("Matrix.ActivityRefWatcher", "activity with key [%s] should be recycled but actually still \nexists in %s times detection with %s created activities during destroy, wait for next detection to confirm.", destroyedActivityInfo.mKey, Integer.valueOf(destroyedActivityInfo.mDetectedCount), Long.valueOf(j));
                            } else {
                                com.tencent.matrix.d.b.i("Matrix.ActivityRefWatcher", "activity with key [%s] was suspected to be a leaked instance.", destroyedActivityInfo.mKey);
                                if (b.this.bsv != null) {
                                    File tC = b.this.bsv.tC();
                                    if (tC != null) {
                                        b.this.ca(destroyedActivityInfo.mActivityName);
                                        b.this.bsw.a(new com.tencent.matrix.resource.analyzer.model.a(tC, destroyedActivityInfo.mKey, destroyedActivityInfo.mActivityName));
                                        it.remove();
                                    } else {
                                        com.tencent.matrix.d.b.i("Matrix.ActivityRefWatcher", "heap dump for further analyzing activity with key [%s] was failed, just ignore.", destroyedActivityInfo.mKey);
                                        it.remove();
                                    }
                                } else {
                                    com.tencent.matrix.d.b.i("Matrix.ActivityRefWatcher", "lightweight mode, just report leaked activity name.", new Object[0]);
                                    b.this.ca(destroyedActivityInfo.mActivityName);
                                    if (b.this.bss != null) {
                                        JSONObject jSONObject = new JSONObject();
                                        try {
                                            jSONObject.put("activity", destroyedActivityInfo.mActivityName);
                                        } catch (Throwable e) {
                                            com.tencent.matrix.d.b.printErrStackTrace("Matrix.ActivityRefWatcher", e, "unexpected exception.", new Object[0]);
                                        }
                                        b.this.bss.a(new com.tencent.matrix.c.b(jSONObject));
                                    }
                                }
                            }
                        }
                    }
                    return com.tencent.matrix.resource.e.e.a.a.bsQ;
                }
            }
        };
        this.bss = cVar;
        com.tencent.matrix.resource.b.a aVar2 = cVar.brq;
        this.bst = new e(aVar2.brv, com.tencent.matrix.d.a.tJ());
        this.brw = aVar2.brw;
        this.bsu = aVar.az(application);
        this.bsv = aVar.a((Context) application, this.bsu);
        this.bsw = aVar.a((Context) application, aVar2);
        this.bsx = new ConcurrentLinkedQueue();
        this.bsy = new AtomicLong(0);
    }

    public final void tA() {
        Application application = this.bss.application;
        if (application != null) {
            application.unregisterActivityLifecycleCallbacks(this.bsz);
            e eVar = this.bst;
            eVar.bsK.removeCallbacksAndMessages(null);
            eVar.mMainHandler.removeCallbacksAndMessages(null);
            this.bsx.clear();
            this.bsy.set(0);
        }
    }
}
