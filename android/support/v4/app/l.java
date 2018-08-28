package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.e.j;
import android.view.LayoutInflater;
import android.view.View;
import java.io.PrintWriter;

public abstract class l<E> extends j {
    final Activity mActivity;
    boolean mCheckedForLoaderManager;
    final Context mContext;
    final n mFragmentManager;
    final Handler mHandler;
    u mLoaderManager;
    boolean mLoadersStarted;
    final int nD;
    j<String, t> nE;
    boolean nF;

    public abstract E onGetHost();

    l(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, fragmentActivity.mHandler);
    }

    private l(Activity activity, Context context, Handler handler) {
        this.mFragmentManager = new n();
        this.mActivity = activity;
        this.mContext = context;
        this.mHandler = handler;
        this.nD = 0;
    }

    public void a(String str, PrintWriter printWriter, String[] strArr) {
    }

    public boolean bh() {
        return true;
    }

    public LayoutInflater onGetLayoutInflater() {
        return (LayoutInflater) this.mContext.getSystemService("layout_inflater");
    }

    public void bi() {
    }

    public void a(Fragment fragment, Intent intent, int i, Bundle bundle) {
        if (i != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        this.mContext.startActivity(intent);
    }

    public void a(Fragment fragment, String[] strArr, int i) {
    }

    public boolean H(String str) {
        return false;
    }

    public boolean onHasWindowAnimations() {
        return true;
    }

    public int onGetWindowAnimations() {
        return this.nD;
    }

    public View onFindViewById(int i) {
        return null;
    }

    public boolean onHasView() {
        return true;
    }

    final void I(String str) {
        if (this.nE != null) {
            u uVar = (u) this.nE.get(str);
            if (uVar != null && !uVar.mRetaining) {
                uVar.bw();
                this.nE.remove(str);
            }
        }
    }

    void onAttachFragment(Fragment fragment) {
    }

    final u b(String str, boolean z, boolean z2) {
        if (this.nE == null) {
            this.nE = new j();
        }
        u uVar = (u) this.nE.get(str);
        if (uVar != null) {
            uVar.mHost = this;
            return uVar;
        } else if (!z2) {
            return uVar;
        } else {
            uVar = new u(str, this, z);
            this.nE.put(str, uVar);
            return uVar;
        }
    }

    final j<String, t> bj() {
        Object obj;
        if (this.nE != null) {
            int i;
            int size = this.nE.size();
            u[] uVarArr = new u[size];
            for (i = size - 1; i >= 0; i--) {
                uVarArr[i] = (u) this.nE.valueAt(i);
            }
            obj = null;
            for (i = 0; i < size; i++) {
                u uVar = uVarArr[i];
                if (uVar.mRetaining) {
                    obj = 1;
                } else {
                    uVar.bw();
                    this.nE.remove(uVar.mWho);
                }
            }
        } else {
            obj = null;
        }
        if (obj != null) {
            return this.nE;
        }
        return null;
    }
}
