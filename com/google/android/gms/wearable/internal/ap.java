package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.a$a;
import com.google.android.gms.wearable.b$a;
import com.google.android.gms.wearable.c.b;
import com.google.android.gms.wearable.e;
import com.google.android.gms.wearable.k;
import com.google.android.gms.wearable.n;
import com.google.android.gms.wearable.n.c;
import com.google.android.gms.wearable.q.a;
import com.google.android.gms.wearable.r;
import java.util.List;

final class ap<T> extends w$a {
    a bfh;
    r.a bfi;
    b bfj;
    k.a bfk;
    n.b bfl;
    c bfm;
    b$a bfn;
    a$a bfo;
    final IntentFilter[] bfp;
    final String bfq;
    final String bfr;

    public final void a(DataHolder dataHolder) {
        if (this.bfj != null) {
            try {
                this.bfj.a(new e(dataHolder));
            } finally {
                dataHolder.close();
            }
        } else {
            dataHolder.close();
        }
    }

    public final void a(AmsEntityUpdateParcelable amsEntityUpdateParcelable) {
    }

    public final void a(AncsNotificationParcelable ancsNotificationParcelable) {
    }

    public final void a(CapabilityInfoParcelable capabilityInfoParcelable) {
    }

    public final void a(ChannelEventParcelable channelEventParcelable) {
        if (this.bfn != null) {
            channelEventParcelable.a(this.bfn);
        }
    }

    public final void a(MessageEventParcelable messageEventParcelable) {
        if (this.bfk != null) {
            this.bfk.a(messageEventParcelable);
        }
    }

    public final void a(NodeParcelable nodeParcelable) {
        if (this.bfl != null) {
            this.bfl.a(nodeParcelable);
        }
    }

    public final void b(NodeParcelable nodeParcelable) {
        if (this.bfl != null) {
            this.bfl.b(nodeParcelable);
        }
    }

    public final void w(List<NodeParcelable> list) {
    }
}
