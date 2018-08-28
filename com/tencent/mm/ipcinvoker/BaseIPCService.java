package com.tencent.mm.ipcinvoker;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Log;
import com.tencent.mm.ipcinvoker.b.b;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public abstract class BaseIPCService extends Service {
    private volatile boolean dlZ;
    private volatile boolean dma;
    private com.tencent.mm.ipcinvoker.b.a.a dmb = new com.tencent.mm.ipcinvoker.b.a.a() {
        public final void a(Bundle bundle, String str, b bVar) {
            if (str == null || str.length() == 0) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.BaseIPCService", "invokeAsync failed, class is null or nil.", new Object[0]);
            } else if (bundle == null) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.BaseIPCService", "invokeAsync failed, data is null.", new Object[0]);
            } else {
                bundle.setClassLoader(BaseIPCService.class.getClassLoader());
                Parcelable parcelable = bundle.getParcelable("__remote_task_data");
                a aVar = (a) j.d(str, a.class);
                if (aVar == null) {
                    com.tencent.mm.ipcinvoker.h.b.e("IPC.BaseIPCService", "invokeAsync failed, can not newInstance by class %s.", new Object[]{str});
                    return;
                }
                l.post(new 1(this, aVar, parcelable, bVar));
            }
        }

        public final Bundle d(Bundle bundle, String str) {
            if (str == null || str.length() == 0) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.BaseIPCService", "invokeSync failed, class is null or nil.", new Object[0]);
                return null;
            } else if (bundle == null) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.BaseIPCService", "invokeSync failed, data is null.", new Object[0]);
                return null;
            } else {
                i iVar = (i) j.d(str, i.class);
                if (iVar == null) {
                    com.tencent.mm.ipcinvoker.h.b.e("IPC.BaseIPCService", "invokeSync failed, can not newInstance by class %s.", new Object[]{str});
                    return null;
                }
                bundle.setClassLoader(BaseIPCService.class.getClassLoader());
                Parcelable parcelable = bundle.getParcelable("__remote_task_data");
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("__remote_task_result_data", (Parcelable) iVar.av(parcelable));
                return bundle2;
            }
        }
    };

    private static class a implements c<Parcelable>, com.tencent.mm.ipcinvoker.e.a {
        b dmh;
        final List<com.tencent.mm.ipcinvoker.e.b> dmi = new LinkedList();

        private static class a implements Runnable {
            private static final Bundle dmj;
            b dmh;

            static {
                Bundle bundle = new Bundle();
                dmj = bundle;
                bundle.putBoolean("__command_release_ref", true);
            }

            a(b bVar) {
                this.dmh = bVar;
            }

            public final void run() {
                try {
                    com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackProxy", "notify release ref of callback(%s).", new Object[]{Integer.valueOf(this.dmh.hashCode())});
                    this.dmh.i(dmj);
                    com.tencent.mm.ipcinvoker.f.b.az(this.dmh);
                    this.dmh = null;
                } catch (Throwable e) {
                    com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCInvokeCallbackProxy", "notify release ref error, %s", new Object[]{Log.getStackTraceString(e)});
                } catch (Throwable e2) {
                    com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCInvokeCallbackProxy", "notify release ref error, %s\n %s", new Object[]{e2.getMessage(), Log.getStackTraceString(e2)});
                }
            }
        }

        public final /* synthetic */ void at(Object obj) {
            Parcelable parcelable = (Parcelable) obj;
            if (this.dmh != null) {
                com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackProxy", "onCallback(%s)", new Object[]{Integer.valueOf(this.dmh.hashCode())});
                try {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("__remote_task_result_data", parcelable);
                    this.dmh.i(bundle);
                } catch (Throwable e) {
                    com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCInvokeCallbackProxy", "%s", new Object[]{Log.getStackTraceString(e)});
                    if (!this.dmi.isEmpty()) {
                        synchronized (this.dmi) {
                            for (com.tencent.mm.ipcinvoker.e.b d : new LinkedList(this.dmi)) {
                                d.d(r1);
                            }
                        }
                    }
                }
            }
        }

        public a(b bVar) {
            this.dmh = bVar;
            if (bVar != null) {
                com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackProxy", "keep ref of callback(%s)", new Object[]{Integer.valueOf(bVar.hashCode())});
                com.tencent.mm.ipcinvoker.f.b.ay(bVar);
            }
        }

        protected final void finalize() {
            try {
                com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackProxy", "finalize(%s)", new Object[]{Integer.valueOf(hashCode())});
                if (this.dmh != null) {
                    com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackProxy", "finalize, release callback(%s)", new Object[]{Integer.valueOf(this.dmh.hashCode())});
                    l.post(new a(this.dmh));
                    this.dmh = null;
                }
                super.finalize();
            } catch (Throwable th) {
                super.finalize();
            }
        }

        public final void a(com.tencent.mm.ipcinvoker.e.b bVar) {
            if (bVar != null) {
                synchronized (this.dmi) {
                    if (this.dmi.contains(bVar)) {
                        return;
                    }
                    this.dmi.add(bVar);
                }
            }
        }
    }

    public abstract String getProcessName();

    public IBinder onBind(Intent intent) {
        com.tencent.mm.ipcinvoker.h.b.i("IPC.BaseIPCService", "onBind(%s), killSelf(%s)", new Object[]{intent, Boolean.valueOf(this.dlZ)});
        if (this.dlZ) {
            com.tencent.mm.ipcinvoker.h.b.i("IPC.BaseIPCService", "need to kill self, return null Binder object.", new Object[0]);
            return null;
        }
        h Ct = h.Ct();
        String Cs = e.Cs();
        if (!(Cs == null || Cs.length() == 0 || this == null)) {
            Ct.dmG.put(Cs, this);
        }
        this.dma = true;
        return this.dmb;
    }

    public boolean onUnbind(Intent intent) {
        com.tencent.mm.ipcinvoker.h.b.i("IPC.BaseIPCService", "onUnbind(%s)", new Object[]{intent});
        boolean onUnbind = super.onUnbind(intent);
        this.dma = false;
        return onUnbind;
    }

    public final void bp(boolean z) {
        if (!this.dma || z) {
            com.tencent.mm.ipcinvoker.h.b.i("IPC.BaseIPCService", "kill self(%s)", new Object[]{getProcessName()});
            this.dlZ = true;
            b.Cq().Cr();
            b Cq = b.Cq();
            com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "releaseAllIPCBridge", new Object[0]);
            if (!Cq.dmm.isEmpty()) {
                synchronized (Cq.dmm) {
                    if (Cq.dmm.isEmpty()) {
                    } else {
                        Set<String> hashSet = new HashSet(Cq.dmm.keySet());
                        if (!hashSet.isEmpty()) {
                            for (String fB : hashSet) {
                                Cq.fB(fB);
                            }
                        }
                    }
                }
            }
            stopSelf();
            h Ct = h.Ct();
            Ct.dmG.remove(getProcessName());
            l.i(new 2(this));
            return;
        }
        com.tencent.mm.ipcinvoker.h.b.i("IPC.BaseIPCService", "abort kill self(%s), the service was connected by other process.", new Object[]{getProcessName()});
    }
}
