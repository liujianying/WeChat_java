package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.c;
import android.support.v4.content.c.b;
import android.support.v4.e.k;
import com.tencent.wcdb.FileUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

public final class u extends t {
    public static boolean DEBUG = false;
    l mHost;
    boolean mRetaining;
    final String mWho;
    boolean mg;
    final k<a> oX = new k();
    final k<a> oY = new k();
    boolean oZ;

    final class a implements android.support.v4.content.c.a<Object>, b<Object> {
        Object mData;
        final int mId;
        boolean mRetaining;
        boolean mg;
        boolean nY;
        final Bundle pa = null;
        android.support.v4.app.t.a<Object> pb;
        c<Object> pc;
        boolean pd;
        boolean pe;
        boolean pf;
        boolean pg;
        boolean ph;
        a pi;

        public a(int i, Bundle bundle) {
            this.mId = i;
            this.pb = bundle;
        }

        final void start() {
            if (this.mRetaining && this.pf) {
                this.mg = true;
            } else if (!this.mg) {
                this.mg = true;
                if (u.DEBUG) {
                    new StringBuilder("  Starting: ").append(this);
                }
                if (this.pc == null && this.pb != null) {
                    this.pc = this.pb.X(this.mId);
                }
                if (this.pc == null) {
                    return;
                }
                if (!this.pc.getClass().isMemberClass() || Modifier.isStatic(this.pc.getClass().getModifiers())) {
                    c cVar;
                    if (!this.ph) {
                        cVar = this.pc;
                        int i = this.mId;
                        if (cVar.qW != null) {
                            throw new IllegalStateException("There is already a listener registered");
                        }
                        cVar.qW = this;
                        cVar.mId = i;
                        cVar = this.pc;
                        if (cVar.qX != null) {
                            throw new IllegalStateException("There is already a listener registered");
                        }
                        cVar.qX = this;
                        this.ph = true;
                    }
                    cVar = this.pc;
                    cVar.mg = true;
                    cVar.qZ = false;
                    cVar.qY = false;
                    cVar.onStartLoading();
                    return;
                }
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.pc);
            }
        }

        final void stop() {
            if (u.DEBUG) {
                new StringBuilder("  Stopping: ").append(this);
            }
            this.mg = false;
            if (!this.mRetaining && this.pc != null && this.ph) {
                this.ph = false;
                this.pc.a((b) this);
                this.pc.a((android.support.v4.content.c.a) this);
                c cVar = this.pc;
                cVar.mg = false;
                cVar.onStopLoading();
            }
        }

        final void destroy() {
            while (true) {
                android.support.v4.content.c.a this;
                if (u.DEBUG) {
                    new StringBuilder("  Destroying: ").append(this);
                }
                this.nY = true;
                boolean z = this.pe;
                this.pe = false;
                if (this.pb != null && this.pc != null && this.pd && z) {
                    String str;
                    if (u.DEBUG) {
                        new StringBuilder("  Reseting: ").append(this);
                    }
                    if (u.this.mHost != null) {
                        str = u.this.mHost.mFragmentManager.nZ;
                        u.this.mHost.mFragmentManager.nZ = "onLoaderReset";
                    } else {
                        str = null;
                    }
                    if (u.this.mHost != null) {
                        u.this.mHost.mFragmentManager.nZ = str;
                    }
                }
                this.pb = null;
                this.mData = null;
                this.pd = false;
                if (this.pc != null) {
                    if (this.ph) {
                        this.ph = false;
                        this.pc.a((b) this);
                        this.pc.a(this);
                    }
                    c cVar = this.pc;
                    cVar.onReset();
                    cVar.qZ = true;
                    cVar.mg = false;
                    cVar.qY = false;
                    cVar.ra = false;
                    cVar.rb = false;
                }
                if (this.pi != null) {
                    this = this.pi;
                } else {
                    return;
                }
            }
        }

        public final void b(c<Object> cVar, Object obj) {
            if (u.DEBUG) {
                new StringBuilder("onLoadComplete: ").append(this);
            }
            if (!this.nY && u.this.oX.get(this.mId) == this) {
                a aVar = this.pi;
                if (aVar != null) {
                    if (u.DEBUG) {
                        new StringBuilder("  Switching to pending loader: ").append(aVar);
                    }
                    this.pi = null;
                    u.this.oX.put(this.mId, null);
                    destroy();
                    u.this.a(aVar);
                    return;
                }
                if (!(this.mData == obj && this.pd)) {
                    this.mData = obj;
                    this.pd = true;
                    if (this.mg) {
                        c(cVar, obj);
                    }
                }
                aVar = (a) u.this.oY.get(this.mId);
                if (!(aVar == null || aVar == this)) {
                    aVar.pe = false;
                    aVar.destroy();
                    u.this.oY.remove(this.mId);
                }
                if (u.this.mHost != null && !u.this.bq()) {
                    u.this.mHost.mFragmentManager.bl();
                }
            }
        }

        final void c(c<Object> cVar, Object obj) {
            String str;
            if (this.pb != null) {
                if (u.this.mHost != null) {
                    String str2 = u.this.mHost.mFragmentManager.nZ;
                    u.this.mHost.mFragmentManager.nZ = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (u.DEBUG) {
                        StringBuilder append = new StringBuilder("  onLoadFinished in ").append(cVar).append(": ");
                        StringBuilder stringBuilder = new StringBuilder(64);
                        android.support.v4.e.c.a(obj, stringBuilder);
                        stringBuilder.append("}");
                        append.append(stringBuilder.toString());
                    }
                    this.pb.a(cVar, obj);
                    this.pe = true;
                } finally {
                    if (u.this.mHost != null) {
                        u.this.mHost.mFragmentManager.nZ = str;
                    }
                }
            }
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder(64);
            stringBuilder.append("LoaderInfo{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" #");
            stringBuilder.append(this.mId);
            stringBuilder.append(" : ");
            android.support.v4.e.c.a(this.pc, stringBuilder);
            stringBuilder.append("}}");
            return stringBuilder.toString();
        }

        public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            while (true) {
                printWriter.print(str);
                printWriter.print("mId=");
                printWriter.print(this.mId);
                printWriter.print(" mArgs=");
                printWriter.println(this.pa);
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.pb);
                printWriter.print(str);
                printWriter.print("mLoader=");
                printWriter.println(this.pc);
                if (this.pc != null) {
                    this.pc.dump(str + "  ", fileDescriptor, printWriter, strArr);
                }
                if (this.pd || this.pe) {
                    printWriter.print(str);
                    printWriter.print("mHaveData=");
                    printWriter.print(this.pd);
                    printWriter.print("  mDeliveredData=");
                    printWriter.println(this.pe);
                    printWriter.print(str);
                    printWriter.print("mData=");
                    printWriter.println(this.mData);
                }
                printWriter.print(str);
                printWriter.print("mStarted=");
                printWriter.print(this.mg);
                printWriter.print(" mReportNextStart=");
                printWriter.print(this.pg);
                printWriter.print(" mDestroyed=");
                printWriter.println(this.nY);
                printWriter.print(str);
                printWriter.print("mRetaining=");
                printWriter.print(this.mRetaining);
                printWriter.print(" mRetainingStarted=");
                printWriter.print(this.pf);
                printWriter.print(" mListenerRegistered=");
                printWriter.println(this.ph);
                if (this.pi != null) {
                    printWriter.print(str);
                    printWriter.println("Pending Loader ");
                    printWriter.print(this.pi);
                    printWriter.println(":");
                    this = this.pi;
                    str = str + "  ";
                } else {
                    return;
                }
            }
        }
    }

    u(String str, l lVar, boolean z) {
        this.mWho = str;
        this.mHost = lVar;
        this.mg = z;
    }

    private a c(int i, android.support.v4.app.t.a<Object> aVar) {
        a aVar2 = new a(i, aVar);
        aVar2.pc = aVar.X(i);
        return aVar2;
    }

    private a d(int i, android.support.v4.app.t.a<Object> aVar) {
        try {
            this.oZ = true;
            a c = c(i, aVar);
            a(c);
            return c;
        } finally {
            this.oZ = false;
        }
    }

    final void a(a aVar) {
        this.oX.put(aVar.mId, aVar);
        if (this.mg) {
            aVar.start();
        }
    }

    public final <D> c<D> a(int i, android.support.v4.app.t.a<D> aVar) {
        if (this.oZ) {
            throw new IllegalStateException("Called while creating a loader");
        }
        a aVar2 = (a) this.oX.get(i);
        if (DEBUG) {
            new StringBuilder("initLoader in ").append(this).append(": args=").append(null);
        }
        if (aVar2 == null) {
            aVar2 = d(i, aVar);
            if (DEBUG) {
                new StringBuilder("  Created new loader ").append(aVar2);
            }
        } else {
            if (DEBUG) {
                new StringBuilder("  Re-using existing loader ").append(aVar2);
            }
            aVar2.pb = aVar;
        }
        if (aVar2.pd && this.mg) {
            aVar2.c(aVar2.pc, aVar2.mData);
        }
        return aVar2.pc;
    }

    public final <D> c<D> b(int i, android.support.v4.app.t.a<D> aVar) {
        if (this.oZ) {
            throw new IllegalStateException("Called while creating a loader");
        }
        a aVar2 = (a) this.oX.get(i);
        if (DEBUG) {
            new StringBuilder("restartLoader in ").append(this).append(": args=").append(null);
        }
        if (aVar2 != null) {
            a aVar3 = (a) this.oY.get(i);
            if (aVar3 != null) {
                if (aVar2.pd) {
                    if (DEBUG) {
                        new StringBuilder("  Removing last inactive loader: ").append(aVar2);
                    }
                    aVar3.pe = false;
                    aVar3.destroy();
                } else if (aVar2.mg) {
                    if (DEBUG) {
                        new StringBuilder("  Canceling: ").append(aVar2);
                    }
                    if (aVar2.mg && aVar2.pc != null && aVar2.ph) {
                        if (DEBUG) {
                            new StringBuilder("onLoadCanceled: ").append(aVar2);
                        }
                        if (!aVar2.nY && aVar2.pj.oX.get(aVar2.mId) == aVar2) {
                            aVar3 = aVar2.pi;
                            if (aVar3 != null) {
                                if (DEBUG) {
                                    new StringBuilder("  Switching to pending loader: ").append(aVar3);
                                }
                                aVar2.pi = null;
                                aVar2.pj.oX.put(aVar2.mId, null);
                                aVar2.destroy();
                                aVar2.pj.a(aVar3);
                            }
                        }
                    }
                    if (aVar2.pi != null) {
                        if (DEBUG) {
                            new StringBuilder("  Removing pending loader: ").append(aVar2.pi);
                        }
                        aVar2.pi.destroy();
                        aVar2.pi = null;
                    }
                    aVar2.pi = c(i, aVar);
                    return aVar2.pi.pc;
                } else {
                    this.oX.put(i, null);
                    aVar2.destroy();
                }
            } else if (DEBUG) {
                new StringBuilder("  Making last loader inactive: ").append(aVar2);
            }
            aVar2.pc.qY = true;
            this.oY.put(i, aVar2);
        }
        return d(i, aVar).pc;
    }

    public final void destroyLoader(int i) {
        if (this.oZ) {
            throw new IllegalStateException("Called while creating a loader");
        }
        a aVar;
        if (DEBUG) {
            new StringBuilder("destroyLoader in ").append(this).append(" of ").append(i);
        }
        int indexOfKey = this.oX.indexOfKey(i);
        if (indexOfKey >= 0) {
            aVar = (a) this.oX.valueAt(indexOfKey);
            this.oX.removeAt(indexOfKey);
            aVar.destroy();
        }
        indexOfKey = this.oY.indexOfKey(i);
        if (indexOfKey >= 0) {
            aVar = (a) this.oY.valueAt(indexOfKey);
            this.oY.removeAt(indexOfKey);
            aVar.destroy();
        }
        if (this.mHost != null && !bq()) {
            this.mHost.mFragmentManager.bl();
        }
    }

    public final <D> c<D> W(int i) {
        if (this.oZ) {
            throw new IllegalStateException("Called while creating a loader");
        }
        a aVar = (a) this.oX.get(i);
        if (aVar == null) {
            return null;
        }
        if (aVar.pi != null) {
            return aVar.pi.pc;
        }
        return aVar.pc;
    }

    final void br() {
        if (DEBUG) {
            new StringBuilder("Starting in ").append(this);
        }
        if (this.mg) {
            new RuntimeException("here").fillInStackTrace();
            new StringBuilder("Called doStart when already started: ").append(this);
            return;
        }
        this.mg = true;
        for (int size = this.oX.size() - 1; size >= 0; size--) {
            ((a) this.oX.valueAt(size)).start();
        }
    }

    final void bs() {
        if (DEBUG) {
            new StringBuilder("Stopping in ").append(this);
        }
        if (this.mg) {
            for (int size = this.oX.size() - 1; size >= 0; size--) {
                ((a) this.oX.valueAt(size)).stop();
            }
            this.mg = false;
            return;
        }
        new RuntimeException("here").fillInStackTrace();
        new StringBuilder("Called doStop when not started: ").append(this);
    }

    final void bt() {
        if (DEBUG) {
            new StringBuilder("Retaining in ").append(this);
        }
        if (this.mg) {
            this.mRetaining = true;
            this.mg = false;
            for (int size = this.oX.size() - 1; size >= 0; size--) {
                a aVar = (a) this.oX.valueAt(size);
                if (DEBUG) {
                    new StringBuilder("  Retaining: ").append(aVar);
                }
                aVar.mRetaining = true;
                aVar.pf = aVar.mg;
                aVar.mg = false;
                aVar.pb = null;
            }
            return;
        }
        new RuntimeException("here").fillInStackTrace();
        new StringBuilder("Called doRetain when not started: ").append(this);
    }

    final void bu() {
        for (int size = this.oX.size() - 1; size >= 0; size--) {
            ((a) this.oX.valueAt(size)).pg = true;
        }
    }

    final void bv() {
        for (int size = this.oX.size() - 1; size >= 0; size--) {
            a aVar = (a) this.oX.valueAt(size);
            if (aVar.mg && aVar.pg) {
                aVar.pg = false;
                if (aVar.pd) {
                    aVar.c(aVar.pc, aVar.mData);
                }
            }
        }
    }

    final void bw() {
        int size;
        if (!this.mRetaining) {
            if (DEBUG) {
                new StringBuilder("Destroying Active in ").append(this);
            }
            for (size = this.oX.size() - 1; size >= 0; size--) {
                ((a) this.oX.valueAt(size)).destroy();
            }
            this.oX.clear();
        }
        if (DEBUG) {
            new StringBuilder("Destroying Inactive in ").append(this);
        }
        for (size = this.oY.size() - 1; size >= 0; size--) {
            ((a) this.oY.valueAt(size)).destroy();
        }
        this.oY.clear();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(FileUtils.S_IWUSR);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        android.support.v4.e.c.a(this.mHost, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        a aVar;
        int i = 0;
        if (this.oX.size() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i2 = 0; i2 < this.oX.size(); i2++) {
                aVar = (a) this.oX.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.oX.keyAt(i2));
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.dump(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.oY.size() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            while (i < this.oY.size()) {
                aVar = (a) this.oY.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.oY.keyAt(i));
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.dump(str3, fileDescriptor, printWriter, strArr);
                i++;
            }
        }
    }

    public final boolean bq() {
        int size = this.oX.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            int i2;
            a aVar = (a) this.oX.valueAt(i);
            if (!aVar.mg || aVar.pe) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            z |= i2;
        }
        return z;
    }
}
