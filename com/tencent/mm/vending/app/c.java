package com.tencent.mm.vending.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.mm.vending.e.b;
import com.tencent.mm.vending.f.a;
import junit.framework.Assert;

public final class c implements b {
    private com.tencent.mm.vending.e.c uPF = new com.tencent.mm.vending.e.c();
    private b uPX = b.cBv();
    private a uPY;
    private com.tencent.mm.vending.c.b<? extends a> uPZ;
    private int uQa = 0;

    private synchronized <T extends com.tencent.mm.vending.c.b<? extends a>> T S(Class<? extends com.tencent.mm.vending.c.b<? extends a>> cls) {
        T t;
        if (this.uPZ == null) {
            try {
                this.uPZ = (com.tencent.mm.vending.c.b) cls.newInstance();
                if (this.uPY == null) {
                    this.uPY = (a) this.uPZ.VT();
                }
                cBw();
                t = this.uPZ;
            } catch (IllegalAccessException e) {
                throw new InternalError("Could not create interactor api instance : " + cls.toString());
            } catch (InstantiationException e2) {
                throw new InternalError("Could not create interactor api instance : " + cls.toString());
            }
        } else if (cls.isInstance(this.uPZ)) {
            t = this.uPZ;
        } else {
            throw new IllegalAccessError("Only one interactor pair with one presenter! duplicate pairWith : " + cls.toString());
        }
        return t;
    }

    private synchronized <T extends a> T T(Class<? extends a> cls) {
        T t;
        if (this.uPZ != null) {
            t = (a) this.uPZ.VT();
        } else if (this.uPY == null) {
            try {
                this.uPY = (a) cls.newInstance();
                cBw();
                t = this.uPY;
            } catch (InstantiationException e) {
            } catch (IllegalAccessException e2) {
            }
        } else if (cls.isInstance(this.uPY)) {
            t = this.uPY;
        } else {
            throw new IllegalAccessError("Only one interactor pair with one presenter! duplicate pairWith : " + cls.toString());
        }
        return t;
        throw new InternalError("Could not create interactor instance : " + cls.toString());
    }

    private void cBw() {
        if (this.uPX != null) {
            b bVar = this.uPX;
            a aVar = this.uPY;
            if (bVar.uPT.containsKey(this)) {
                a.e("Vending.InteractorManager", "duplicate activity and interactor.", new Object[0]);
                return;
            }
            bVar.uPT.put(this, aVar);
            a.i("Vending.InteractorManager", "presenter %s hash %s interactor %s looper %s", new Object[]{this, Integer.valueOf(hashCode()), aVar, Looper.myLooper()});
            int i = bVar.uPU.get(hashCode(), 0);
            if (i > 0 && i < 4) {
                if (i > 0) {
                    bVar.uPV.sendMessage(bVar.uPV.obtainMessage(1, aVar));
                }
                if (i >= 2) {
                    bVar.uPV.sendMessage(bVar.uPV.obtainMessage(2, aVar));
                }
                if (i >= 3) {
                    bVar.uPV.sendMessage(bVar.uPV.obtainMessage(3, aVar));
                }
                if (i >= 4) {
                    bVar.uPV.sendMessage(bVar.uPV.obtainMessage(4, aVar));
                }
            }
        }
    }

    private synchronized void z(Intent intent, Context context) {
        Assert.assertNotNull("You must pair this presenter with a interactor!", this.uPY);
        this.uPY.mContext = context;
        this.uPY.uPN = new com.tencent.mm.vending.d.a(intent);
    }

    public final synchronized a EW() {
        if (this.uPY == null && this.uPX != null) {
            this.uPY = (a) this.uPX.uPT.get(this);
        }
        Assert.assertNotNull("You must pair this presenter with a interactor!", this.uPY);
        return this.uPY;
    }

    public final <T extends com.tencent.mm.vending.c.b<? extends a>> T a(Activity activity, Class<? extends com.tencent.mm.vending.c.b<? extends a>> cls) {
        if (!activity.isFinishing() && (VERSION.SDK_INT < 17 || !activity.isDestroyed())) {
            return S(cls);
        }
        a.e("Vending.Presenter", "Activity %s is finished! This is invalid!", new Object[]{activity});
        return null;
    }

    public final <T extends a> T b(Activity activity, Class<? extends a> cls) {
        if (!activity.isFinishing() && (VERSION.SDK_INT < 17 || !activity.isDestroyed())) {
            return T(cls);
        }
        a.e("Vending.Presenter", "Activity %s is finished! This is invalid!", new Object[]{activity});
        return null;
    }

    public final void GM(int i) {
        this.uQa = i;
        b bVar = this.uPX;
        a aVar = (a) bVar.uPT.get(this);
        if (aVar != null) {
            switch (i) {
                case 1:
                    a.i("Vending.InteractorManager", "onCreate interactor %s presenter %s %s %s", new Object[]{aVar, this, Integer.valueOf(hashCode()), Looper.myLooper()});
                    break;
                case 2:
                case 3:
                    break;
                case 4:
                    a.i("Vending.InteractorManager", "onDestroy interactor %s activity %s %s %s", new Object[]{aVar, this, Integer.valueOf(hashCode()), Looper.myLooper()});
                    bVar.uPT.remove(this);
                    break;
                default:
                    a.i("Vending.InteractorManager", "Unknow phase %s, interactor %s activity %s %s %s", new Object[]{Integer.valueOf(i), aVar, this, Integer.valueOf(hashCode()), Looper.myLooper()});
                    return;
            }
            bVar.uPV.sendMessage(bVar.uPV.obtainMessage(i, aVar));
        }
        bVar.uPU.put(hashCode(), i);
    }

    public final void A(Intent intent, Context context) {
        z(intent, context);
        GM(1);
    }

    public final void keep(com.tencent.mm.vending.e.a aVar) {
        Assert.assertTrue("target must be a ILifeCycle", aVar instanceof com.tencent.mm.vending.e.a);
        this.uPF.keep(aVar);
    }

    public final void onDestroy() {
        this.uPF.dead();
        GM(4);
    }
}
