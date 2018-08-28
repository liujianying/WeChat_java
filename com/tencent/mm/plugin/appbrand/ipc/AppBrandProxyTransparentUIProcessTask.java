package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.mm.ui.MMActivity.a;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AppBrandProxyTransparentUIProcessTask implements Parcelable {
    public static Map<String, WeakReference<AppBrandProxyTransparentUIProcessTask>> fDJ = new ConcurrentHashMap();
    private static final Set<Object> fEi = new HashSet();
    public int fEj = -1;
    public a fEk = new 1(this);
    public String fEl = (Process.myPid() + hashCode());
    public Context mContext;

    public abstract void a(Context context, a aVar);

    static /* synthetic */ AppBrandProxyTransparentUIProcessTask te(String str) {
        if (fDJ.containsKey(str)) {
            return ((WeakReference) fDJ.get(str)).get() == null ? null : (AppBrandProxyTransparentUIProcessTask) ((WeakReference) fDJ.get(str)).get();
        } else {
            return null;
        }
    }

    public AppBrandProxyTransparentUIProcessTask(Context context) {
        this.mContext = context;
    }

    public void aaj() {
    }

    public void g(Parcel parcel) {
    }

    public void writeToParcel(Parcel parcel, int i) {
    }

    public int describeContents() {
        return 0;
    }

    public final void ahA() {
        fEi.add(this);
    }

    public final void ahB() {
        fEi.remove(this);
    }
}
