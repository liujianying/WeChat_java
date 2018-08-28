package com.tencent.mm.ipcinvoker;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class b {
    private static volatile b dmk;
    Map<String, Class<?>> dml = new HashMap();
    Map<String, a> dmm = new ConcurrentHashMap();
    private volatile boolean dmn;
    private Handler mHandler;

    private static class a {
        com.tencent.mm.ipcinvoker.b.a dms;
        ServiceConnection dmt;
        volatile boolean dmu;
        Runnable dmv;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public static b Cq() {
        if (dmk == null) {
            synchronized (b.class) {
                if (dmk == null) {
                    dmk = new b();
                }
            }
        }
        return dmk;
    }

    private b() {
        HandlerThread handlerThread = new HandlerThread("IPCBridgeThread#" + hashCode());
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper());
    }

    public final com.tencent.mm.ipcinvoker.b.a fA(String str) {
        a aVar = (a) this.dmm.get(str);
        if (aVar == null) {
            if (this.dmn) {
                com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "build IPCBridge(process : %s) failed, locked.", new Object[]{str});
                return null;
            } else if (Looper.getMainLooper() == Looper.myLooper()) {
                com.tencent.mm.ipcinvoker.h.b.w("IPC.IPCBridgeManager", "getIPCBridge failed, can not create bridge on Main thread.", new Object[0]);
                return null;
            } else {
                Class cls = (Class) this.dml.get(str);
                if (cls == null) {
                    com.tencent.mm.ipcinvoker.h.b.w("IPC.IPCBridgeManager", "getServiceClass by '%s', got null.", new Object[]{str});
                    return null;
                }
                a aVar2 = new a();
                synchronized (this.dmm) {
                    this.dmm.put(str, aVar2);
                }
                synchronized (aVar2) {
                    aVar2.dmu = true;
                }
                Context context = e.getContext();
                aVar2.dmt = new 1(this, aVar2, context, str);
                try {
                    com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "bindService(bw : %s, tid : %s, intent : %s)", new Object[]{Integer.valueOf(aVar2.hashCode()), Long.valueOf(Thread.currentThread().getId()), new Intent(context, cls)});
                    context.bindService(r4, aVar2.dmt, 33);
                    aVar2.dmv = new 2(this, aVar2, str);
                    this.mHandler.postDelayed(aVar2.dmv, Looper.myLooper() == Looper.getMainLooper() ? 3000 : 10000);
                    synchronized (aVar2) {
                        if (aVar2.dmu) {
                            aVar2.wait();
                        }
                    }
                    synchronized (aVar2) {
                        aVar2.dmu = false;
                    }
                    aVar = aVar2;
                } catch (InterruptedException e) {
                    try {
                        com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCBridgeManager", "%s", new Object[]{e});
                        synchronized (this.dmm) {
                            this.dmm.remove(str);
                            synchronized (aVar2) {
                                aVar2.dmu = false;
                                return null;
                            }
                        }
                    } catch (Throwable th) {
                        synchronized (aVar2) {
                            aVar2.dmu = false;
                        }
                    }
                } catch (Throwable e2) {
                    com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCBridgeManager", "bindService error : %s", new Object[]{Log.getStackTraceString(e2)});
                    synchronized (this.dmm) {
                        this.dmm.remove(str);
                        synchronized (aVar2) {
                            aVar2.dmu = false;
                            return null;
                        }
                    }
                }
            }
        } else if (aVar.dmu) {
            try {
                synchronized (aVar) {
                    if (aVar.dmu) {
                        aVar.wait();
                    }
                }
            } catch (InterruptedException e3) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCBridgeManager", "%s", new Object[]{e3});
            }
        }
        return aVar.dms;
    }

    public final void fB(String str) {
        if (e.fC(str)) {
            com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "the same process(%s), do not need to release IPCBridge.", new Object[]{str});
            return;
        }
        a aVar;
        synchronized (this.dmm) {
            aVar = (a) this.dmm.get(str);
        }
        if (aVar == null) {
            com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "releaseIPCBridge(%s) failed, IPCBridgeWrapper is null.", new Object[]{str});
            return;
        }
        if (aVar.dmu) {
            synchronized (aVar) {
                aVar.dmu = false;
                aVar.notifyAll();
            }
        }
        if (aVar.dmt == null) {
            com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "releaseIPCBridge(%s) failed, ServiceConnection is null.", new Object[]{str});
            return;
        }
        this.mHandler.post(new 3(this, aVar, str));
    }

    public final synchronized void Cr() {
        this.dmn = true;
    }
}
