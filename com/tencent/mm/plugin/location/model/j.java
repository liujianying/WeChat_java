package com.tencent.mm.plugin.location.model;

import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mm.ak.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.pluginsdk.location.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bd.b;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;

public final class j implements a {
    int h = TbsListener$ErrorCode.ERROR_CODE_LOAD_BASE;
    HashMap<Long, WeakReference<ImageView>> kCU = new HashMap();
    HashMap<Long, b> kCV = new HashMap();
    HashMap<Long, WeakReference<ProgressBar>> kCW = new HashMap();
    HashMap<Long, WeakReference<ImageView>> kCX = new HashMap();
    HashMap<b, bd> kCY = new HashMap();
    HashMap<Long, Integer> kCZ = new HashMap();
    HashSet<Long> kDa = new HashSet();
    int w = TbsListener$ErrorCode.ERROR_CODE_LOAD_BASE;

    public j() {
        start();
    }

    public final void start() {
        k aZg = l.aZg();
        if (this != null) {
            for (a equals : aZg.cWy) {
                if (equals(equals)) {
                    return;
                }
            }
            aZg.cWy.add(this);
            x.i("MicroMsg.StaticMapServer", "addMapCallBack " + aZg.cWy.size());
            if (aZg.cWy.size() == 1) {
                aZg.start();
            }
        }
    }

    public final void a(String str, com.tencent.mm.pluginsdk.location.b bVar) {
        if (bVar != null && this.kCV.containsKey(Long.valueOf(bVar.qyC))) {
            bd bdVar = (bd) this.kCY.remove((b) this.kCV.get(Long.valueOf(bVar.qyC)));
            if (bdVar != null) {
                WeakReference weakReference = (WeakReference) this.kCU.get(Long.valueOf(bdVar.field_msgId));
                if (weakReference != null && weakReference.get() != null && this.kCZ.containsKey(Long.valueOf(bdVar.field_msgId))) {
                    ((ImageView) weakReference.get()).setImageBitmap(o.Pf().a(bdVar.field_msgId, str, ((Integer) this.kCZ.remove(Long.valueOf(bdVar.field_msgId))).intValue(), this.w, this.h, bdVar.field_isSend == 0));
                    weakReference = (WeakReference) this.kCW.remove(Long.valueOf(bdVar.field_msgId));
                    if (!(weakReference == null || weakReference.get() == null)) {
                        ((ProgressBar) weakReference.get()).setVisibility(8);
                    }
                    WeakReference weakReference2 = (WeakReference) this.kCX.remove(Long.valueOf(bdVar.field_msgId));
                    if (weakReference2 != null && weakReference2.get() != null) {
                        ((ImageView) weakReference2.get()).setVisibility(0);
                    }
                }
            }
        }
    }

    public final void a(com.tencent.mm.pluginsdk.location.b bVar) {
        if (bVar != null && this.kCV.containsKey(Long.valueOf(bVar.qyC))) {
            bd bdVar = (bd) this.kCY.remove((b) this.kCV.get(Long.valueOf(bVar.qyC)));
            if (bdVar != null) {
                this.kCU.get(Long.valueOf(bdVar.field_msgId));
                if (bdVar == null) {
                    return;
                }
                if (bdVar.cGH < 0 || bdVar.cGH > 5) {
                    bdVar.fj(0);
                    bdVar.fj(bdVar.cGH + 1);
                    if (g.Eg().Dx()) {
                        ((i) g.l(i.class)).bcY().a(bdVar.field_msgId, bdVar);
                        x.i("MicroMsg.StaticMapMsgLogic", "on error count %d", new Object[]{Integer.valueOf(bdVar.cGH)});
                    }
                }
            }
        }
    }
}
