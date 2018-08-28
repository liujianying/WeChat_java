package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.mm.bg.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class GameProcessActivityTask implements Parcelable {
    private static Map<String, WeakReference<GameProcessActivityTask>> fDJ = new ConcurrentHashMap();
    static final Set<Object> fEi = new HashSet();
    private int fEj = -1;
    private a fEk = new 1(this);
    private String fEl = (Process.myPid() + hashCode());
    Context mContext;

    public abstract void a(Context context, a aVar);

    static /* synthetic */ GameProcessActivityTask Dd(String str) {
        if (fDJ.containsKey(str)) {
            return ((WeakReference) fDJ.get(str)).get() == null ? null : (GameProcessActivityTask) ((WeakReference) fDJ.get(str)).get();
        } else {
            return null;
        }
    }

    public GameProcessActivityTask(Context context) {
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

    public final void aNI() {
        if (this.mContext != null) {
            fDJ.put(this.fEl, new WeakReference(this));
            Intent intent = new Intent();
            intent.putExtra("task_object", this);
            intent.putExtra("task_id", this.fEl);
            intent.putExtra("orientation", this.fEj);
            if (this.mContext instanceof MMActivity) {
                fEi.add(this);
                ((MMActivity) this.mContext).geJ = this.fEk;
                d.b(this.mContext, "game", ".gamewebview.ui.GameIpcProxyUI", intent, hashCode() & 65535);
                return;
            }
            intent.addFlags(268435456);
            d.b(this.mContext, "game", ".gamewebview.ui.GameIpcProxyUI", intent);
        }
    }
}
