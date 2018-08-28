package com.tencent.mm.vending.base;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mm.vending.b.c;
import com.tencent.mm.vending.e.a;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.d;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class Vending<_Struct, _Index, _Change> implements a {
    private static final int MESSAGE_DO_DESTROY = 2;
    private static final int MESSAGE_NOTIFY_DATA_LOADED = 1;
    private static final int MESSAGE_PREPARE_VENDING_DATA = 1;
    private static final int SYNC_MESSAGE_APPLY_CHANGE = 1;
    private static final int SYNC_MESSAGE_CLEAR_RESOLVED_ONLY = 3;
    private static final int SYNC_MESSAGE_PREPARE_DATA_DEGRADE = 2;
    private static final String TAG = "Vending";
    private g<_Index, i<_Struct, _Index>> mArray;
    private byte[] mArrayDataLock;
    private AtomicBoolean mCallDestroyed;
    private volatile c mDataChangedCallback;
    private volatile c mDataResolvedCallback;
    private c<_Index> mDeadlock;
    private boolean mFreezeDataChange;
    private boolean mHasPendingDataChange;
    private f mLoader;
    private byte[] mPendingDataChangeLock;
    private boolean mResolveFromVending;
    private Handler mSubscriberHandler;
    private Looper mSubscriberLooper;
    HashSet<h> mVendingDeferring;
    private Handler mVendingHandler;
    private Looper mVendingLooper;
    private c mVendingSync;

    private interface b {
        void cBx();
    }

    public abstract void applyChangeSynchronized(_Change _change);

    public abstract void destroyAsynchronous();

    public abstract _Change prepareVendingDataAsynchronous();

    public abstract _Struct resolveAsynchronous(_Index _index);

    f<_Index> getLoader() {
        return this.mLoader;
    }

    public void addVendingDataChangedCallback(d dVar) {
        this.mDataChangedCallback.aI(dVar);
    }

    public void addVendingDataResolvedCallback(e eVar) {
        this.mDataResolvedCallback.aI(eVar);
    }

    public Vending() {
        this(Looper.getMainLooper());
    }

    public Vending(Looper looper) {
        this.mCallDestroyed = new AtomicBoolean(false);
        this.mArrayDataLock = new byte[0];
        this.mPendingDataChangeLock = new byte[0];
        this.mHasPendingDataChange = false;
        this.mFreezeDataChange = false;
        this.mDeadlock = new c((byte) 0);
        this.mDataChangedCallback = new 1(this, d.uRC);
        this.mDataResolvedCallback = new c<e>(d.uRC) {
            public final /* synthetic */ void a(Object obj, com.tencent.mm.vending.j.a aVar) {
                ((e) obj).cr(aVar.get(0));
            }
        };
        this.mArray = new g();
        this.mVendingDeferring = new HashSet();
        this.mResolveFromVending = false;
        this.mSubscriberLooper = looper;
        this.mVendingLooper = com.tencent.mm.vending.i.b.cBP().uRM.getLooper();
        this.mArray.uQo = new 3(this);
        this.mVendingSync = new c(this.mSubscriberLooper, this.mVendingLooper);
        this.mVendingSync.uQw = new 4(this);
        this.mSubscriberHandler = new 5(this, this.mSubscriberLooper);
        this.mVendingHandler = new 6(this, this.mVendingLooper);
        this.mLoader = new f(this.mVendingLooper, new 7(this));
    }

    private void notifyDataLoadedIfNeed(i<_Struct, _Index> iVar) {
        if (iVar.uQs) {
            iVar.uQs = false;
        } else {
            this.mSubscriberHandler.sendMessage(this.mSubscriberHandler.obtainMessage(1, iVar));
        }
    }

    protected void synchronizing(int i, Object obj) {
    }

    protected i<_Struct, _Index> getLock(_Index _index) {
        i<_Struct, _Index> iVar;
        synchronized (this.mArrayDataLock) {
            iVar = (i) this.mArray.get(_index);
            if (iVar == null) {
                iVar = new i();
                this.mArray.put(_index, iVar);
            }
        }
        return iVar;
    }

    protected i<_Struct, _Index> peekLock(_Index _index) {
        i<_Struct, _Index> iVar;
        synchronized (this.mArrayDataLock) {
            iVar = (i) this.mArray.get(_index);
        }
        return iVar;
    }

    public h defer(_Index _index) {
        looperCheckForVending();
        if (this.mResolveFromVending) {
            getLock(_index).uPP = true;
            h hVar = new h(this, _index);
            this.mVendingDeferring.add(hVar);
            return hVar;
        }
        com.tencent.mm.vending.f.a.w(TAG, "Please call defer in resolveAsynchronous()", new Object[0]);
        return null;
    }

    private void deferResolved(h hVar, _Index _index, _Struct _struct) {
        if (this.mVendingDeferring.contains(hVar)) {
            i lock = getLock(_index);
            synchronized (lock.dol) {
                lock.uPP = false;
                lockResolved(lock, _index, _struct);
            }
            notifyDataLoadedIfNeed(lock);
        }
    }

    public <T> T peek(_Index _index) {
        if (this.mCallDestroyed.get() || invalidIndex(_index)) {
            return null;
        }
        i peekLock = peekLock(_index);
        if (peekLock == null || peekLock.gu) {
            return null;
        }
        return peekLock.uQq;
    }

    public <T> T get(_Index _index) {
        return getSync(_index);
    }

    private _Struct getSync(_Index _index) {
        Looper myLooper = Looper.myLooper();
        if (myLooper != this.mSubscriberLooper && myLooper != this.mVendingLooper) {
            throw new IllegalAccessError("Call from wrong looper");
        } else if (this.mCallDestroyed.get()) {
            return null;
        } else {
            i lock = getLock(_index);
            if (invalidIndex(_index)) {
                return lock.uQq;
            }
            if (myLooper == this.mSubscriberLooper) {
                return forSubscriberSync(lock, _index).uQq;
            }
            loadFromVending(lock, _index);
            return lock.uQq;
        }
    }

    private void lockResolved(i<_Struct, _Index> iVar, _Index _index, _Struct _struct) {
        iVar.uQq = _struct;
        iVar.uQp = _index;
        iVar.gu = false;
        iVar.uQr = false;
        iVar.dsz = true;
        if (this.mDeadlock.uQf == iVar) {
            iVar.uQs = true;
        }
        iVar.dol.notify();
    }

    private boolean loadFromVending(i<_Struct, _Index> iVar, _Index _index) {
        synchronized (iVar.dol) {
            if (!iVar.dsz || iVar.gu || iVar.uQr) {
                this.mResolveFromVending = true;
                Object resolveAsynchronous = resolveAsynchronous(_index);
                this.mResolveFromVending = false;
                if (iVar.uPP) {
                    return false;
                }
                lockResolved(iVar, _index, resolveAsynchronous);
                return false;
            }
            return true;
        }
    }

    private i<_Struct, _Index> forSubscriberSync(i<_Struct, _Index> iVar, _Index _index) {
        if (com.tencent.mm.vending.i.b.cBP().uRM.isAlive()) {
            synchronized (iVar.dol) {
                boolean requestIndex = requestIndex(iVar, _index);
                if (!iVar.dsz || iVar.gu) {
                    if (requestIndex) {
                        this.mDeadlock.uQe.object = _index;
                        this.mDeadlock.uQf = iVar;
                        com.tencent.mm.vending.f.a.i(TAG, "%s waiting %s", new Object[]{this, _index});
                        long nanoTime = System.nanoTime();
                        try {
                            iVar.dol.wait();
                        } catch (InterruptedException e) {
                        }
                        nanoTime = System.nanoTime() - nanoTime;
                        com.tencent.mm.vending.f.a.i(TAG, "%s waiting duration %s", new Object[]{this, Long.valueOf(nanoTime)});
                        this.mDeadlock.reset();
                    }
                }
            }
        } else {
            com.tencent.mm.vending.f.a.e(TAG, "Vending thread is not running!", new Object[0]);
        }
        return iVar;
    }

    protected boolean invalidIndex(_Index _index) {
        return false;
    }

    private _Struct getAsync(_Index _index) {
        if (invalidIndex(_index)) {
            return null;
        }
        i lock = getLock(_index);
        if (!requestIndex(lock, _index) || lock.gu) {
            return null;
        }
        return lock.uQq;
    }

    public void request(_Index _index) {
        refillImpl(_index, false);
    }

    public void requestConsistent(_Index _index) {
        refillImpl(_index, true);
    }

    private void refillImpl(_Index _index, boolean z) {
        looperCheckBoth();
        if (!this.mCallDestroyed.get()) {
            i lock = getLock(_index);
            synchronized (lock.dol) {
                if (lock.dsz) {
                    if (z) {
                        lock.gu = true;
                    } else {
                        lock.uQr = true;
                    }
                }
            }
            getAsync(_index);
        }
    }

    public void resolvedClear() {
        looperCheckBoth();
        if (!this.mCallDestroyed.get()) {
            this.mVendingSync.l(3, null);
        }
    }

    public void notifyVendingDataChange() {
        notifyVendingDataChange(false);
    }

    public void notifyVendingDataChangeSynchronize() {
        notifyVendingDataChange(true);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void notifyVendingDataChange(boolean r4) {
        /*
        r3 = this;
        r2 = 1;
        r0 = r3.mCallDestroyed;
        r0 = r0.get();
        if (r0 == 0) goto L_0x000a;
    L_0x0009:
        return;
    L_0x000a:
        r0 = android.os.Looper.myLooper();
        r1 = r3.mSubscriberLooper;
        if (r0 == r1) goto L_0x0023;
    L_0x0012:
        r0 = android.os.Looper.myLooper();
        r1 = r3.mVendingLooper;
        if (r0 == r1) goto L_0x0023;
    L_0x001a:
        r0 = new java.lang.IllegalAccessError;
        r1 = "Call from wrong thread";
        r0.<init>(r1);
        throw r0;
    L_0x0023:
        if (r4 == 0) goto L_0x002d;
    L_0x0025:
        r0 = r3.mVendingSync;
        r1 = 2;
        r2 = 0;
        r0.l(r1, r2);
        goto L_0x0009;
    L_0x002d:
        r1 = r3.mPendingDataChangeLock;
        monitor-enter(r1);
        r0 = r3.mFreezeDataChange;	 Catch:{ all -> 0x0039 }
        if (r0 == 0) goto L_0x003c;
    L_0x0034:
        r0 = 1;
        r3.mHasPendingDataChange = r0;	 Catch:{ all -> 0x0039 }
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        goto L_0x0009;
    L_0x0039:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
    L_0x003c:
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        r0 = android.os.Looper.myLooper();
        r1 = r3.mVendingLooper;
        if (r0 != r1) goto L_0x0049;
    L_0x0045:
        r3.callPrepareVendingData();
        goto L_0x0009;
    L_0x0049:
        r0 = r3.mVendingHandler;
        r0.removeMessages(r2);
        r0 = r3.mVendingHandler;
        r1 = r3.mVendingHandler;
        r1 = r1.obtainMessage(r2);
        r0.sendMessage(r1);
        r0 = r3.mVendingHandler;
        r1 = new com.tencent.mm.vending.base.Vending$8;
        r1.<init>(r3);
        r0.post(r1);
        goto L_0x0009;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.vending.base.Vending.notifyVendingDataChange(boolean):void");
    }

    public void freezeDataChange() {
        if (!this.mCallDestroyed.get()) {
            synchronized (this.mPendingDataChangeLock) {
                this.mFreezeDataChange = true;
            }
        }
    }

    public void unfreezeDataChange() {
        if (!this.mCallDestroyed.get()) {
            synchronized (this.mPendingDataChangeLock) {
                this.mFreezeDataChange = false;
                if (this.mHasPendingDataChange) {
                    notifyVendingDataChange();
                    this.mHasPendingDataChange = false;
                }
            }
        }
    }

    protected void loaderClear() {
    }

    private void deadlock() {
        if (this.mDeadlock.uQe.object != null) {
            com.tencent.mm.vending.f.a.e(TAG, "Catch deadlock! Tell Carl! .. " + this.mDeadlock.uQe.object, new Object[0]);
            if (this.mDeadlock.uQf != null) {
                synchronized (this.mDeadlock.uQf.dol) {
                    this.mDeadlock.uQf.dol.notify();
                }
                this.mDeadlock.reset();
            }
        }
    }

    protected void requestIndexImpl(i<_Struct, _Index> iVar, _Index _index) {
    }

    private boolean requestIndex(i<_Struct, _Index> iVar, _Index _index) {
        if (invalidIndex(_index)) {
            return false;
        }
        if (this.mCallDestroyed.get()) {
            com.tencent.mm.vending.f.a.e(TAG, "Vending.destroyed() has called.", new Object[0]);
            return false;
        }
        f fVar = this.mLoader;
        if (!fVar.fjt.get()) {
            synchronized (fVar.uQi) {
                fVar.uQg.put(_index, b.uQl);
            }
            fVar.mVendingHandler.sendMessageAtFrontOfQueue(fVar.mVendingHandler.obtainMessage(0, _index));
        }
        requestIndexImpl(iVar, _index);
        return true;
    }

    private void callPrepareVendingData() {
        if (!this.mCallDestroyed.get()) {
            com.tencent.mm.vending.f.a.i(TAG, "Vending.callPrepareVendingData()", new Object[0]);
            this.mVendingSync.l(1, prepareVendingDataAsynchronous());
        }
    }

    public Looper getLooper() {
        return this.mVendingLooper;
    }

    public final void dead() {
        looperCheckBoth();
        com.tencent.mm.vending.f.a.i(TAG, "Vending.destroy()", new Object[0]);
        this.mCallDestroyed.set(true);
        this.mVendingHandler.removeCallbacksAndMessages(null);
        this.mSubscriberHandler.removeCallbacksAndMessages(null);
        this.mLoader.fjt.set(true);
        this.mLoader.cBA();
        this.mVendingHandler.sendMessage(this.mVendingHandler.obtainMessage(2));
    }

    private void onDataResolved(_Index _index, _Struct _struct) {
        if (!this.mCallDestroyed.get() && this.mDataResolvedCallback != null) {
            this.mDataResolvedCallback.a(g.cy(_index));
        }
    }

    public void looperCheckForVending() {
        if (Looper.myLooper() != this.mVendingLooper) {
            throw new IllegalAccessError("Call from wrong looper");
        }
    }

    protected void looperCheckForSubscriber() {
        if (Looper.myLooper() != this.mSubscriberLooper) {
            throw new IllegalAccessError("Call from wrong looper");
        }
    }

    protected void looperCheckBoth() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != this.mSubscriberLooper && myLooper != this.mVendingLooper) {
            throw new IllegalAccessError("Call from wrong looper");
        }
    }
}
