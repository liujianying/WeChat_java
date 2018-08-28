package android.support.v4.widget;

import android.database.ContentObserver;
import android.os.Handler;

class e$a extends ContentObserver {
    final /* synthetic */ e zb;

    public e$a(e eVar) {
        this.zb = eVar;
        super(new Handler());
    }

    public final boolean deliverSelfNotifications() {
        return true;
    }

    public final void onChange(boolean z) {
        this.zb.onContentChanged();
    }
}
