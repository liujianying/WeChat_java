package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a;
import java.lang.ref.WeakReference;

class a$1 implements l {
    final /* synthetic */ a nzN;

    a$1(a aVar) {
        this.nzN = aVar;
    }

    public final void onTaskStarted(long j, String str) {
        this.nzN.I(1, j);
    }

    public final void b(long j, String str, boolean z) {
        WeakReference weakReference = (WeakReference) this.nzN.nzL.get(Long.valueOf(j));
        if (weakReference != null) {
            a aVar = (a) weakReference.get();
            if (aVar != null) {
                aVar.bxl();
                this.nzN.nzL.remove(Long.valueOf(j));
            }
            this.nzN.I(3, j);
        }
    }

    public final void b(long j, int i, boolean z) {
        WeakReference weakReference = (WeakReference) this.nzN.nzL.get(Long.valueOf(j));
        if (weakReference != null) {
            a aVar = (a) weakReference.get();
            if (aVar != null) {
                aVar.bxm();
                this.nzN.nzL.remove(Long.valueOf(j));
            }
            this.nzN.I(8, j);
        }
    }

    public final void onTaskRemoved(long j) {
        WeakReference weakReference = (WeakReference) this.nzN.nzL.get(Long.valueOf(j));
        if (weakReference != null) {
            a aVar = (a) weakReference.get();
            if (aVar != null) {
                aVar.bxk();
                this.nzN.nzL.remove(Long.valueOf(j));
            }
            this.nzN.I(2, j);
        }
    }

    public final void onTaskPaused(long j) {
        WeakReference weakReference = (WeakReference) this.nzN.nzL.get(Long.valueOf(j));
        if (weakReference != null) {
            a aVar = (a) weakReference.get();
            if (aVar != null) {
                aVar.bxj();
            }
            this.nzN.I(6, j);
        }
    }

    public final void bP(long j) {
        WeakReference weakReference = (WeakReference) this.nzN.nzL.get(Long.valueOf(j));
        if (weakReference != null) {
            a aVar = (a) weakReference.get();
            if (aVar != null) {
                FileDownloadTaskInfo cm = d.aCU().cm(j);
                if (cm.icq >= 0 && cm.gTK > 0) {
                    aVar.wo((int) ((cm.icq * 100) / cm.gTK));
                }
            }
        }
    }

    public final void h(long j, String str) {
        WeakReference weakReference = (WeakReference) this.nzN.nzL.get(Long.valueOf(j));
        if (weakReference != null) {
            a aVar = (a) weakReference.get();
            if (aVar != null) {
                aVar.bxn();
            }
            this.nzN.I(7, j);
        }
    }
}
