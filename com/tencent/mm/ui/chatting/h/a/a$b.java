package com.tencent.mm.ui.chatting.h.a;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.Spannable;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.d.n;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.bd;
import java.util.ArrayList;
import java.util.Iterator;

class a$b implements Runnable {
    private bd bGS;
    private int scene;
    private CharSequence text;

    a$b(CharSequence charSequence, bd bdVar, int i) {
        this.text = charSequence;
        this.bGS = bdVar;
        this.scene = i;
    }

    public final void run() {
        if (this.text instanceof Spannable) {
            try {
                Spannable spannable = (Spannable) this.text;
                System.nanoTime();
                Object[] spans = spannable.getSpans(0, spannable.length(), Object.class);
                ArrayList arrayList = new ArrayList(1);
                if (spans == null || spans.length == 0) {
                    arrayList = null;
                } else {
                    for (Object obj : spans) {
                        if (obj != null && b.lFJ.c(obj, n.class)) {
                            arrayList.add(new a((byte) 0).a(obj, spannable));
                        }
                    }
                }
                if (arrayList != null && arrayList.size() != 0) {
                    this.bGS = ((i) g.l(i.class)).bcY().dW(this.bGS.field_msgId);
                    if (!(this.bGS == null || bi.oW(this.bGS.field_talker))) {
                        this.bGS.fg(this.bGS.field_flag | 16);
                        ((i) g.l(i.class)).bcY().a(this.bGS.field_msgId, this.bGS);
                    }
                    au.HU().Gv().Ji();
                    au.HU().Gv().b(com.tencent.mm.model.b.b.b.dDZ);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        String str = ((c) it.next()).extInfo;
                        h.mEJ.h(14237, new Object[]{"msg", Long.valueOf(this.bGS.field_msgId), Build.MANUFACTURER, Build.MODEL, VERSION.RELEASE, VERSION.INCREMENTAL, Build.DISPLAY, Integer.valueOf(this.scene), str});
                        h.mEJ.a(587, 0, 1, false);
                    }
                }
            } catch (Exception e) {
            }
        }
    }
}
