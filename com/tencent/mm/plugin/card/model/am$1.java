package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mm.g.a.gz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;

class am$1 extends c<gz> {
    final /* synthetic */ am hxV;

    am$1(am amVar) {
        this.hxV = amVar;
        this.sFo = gz.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        final gz gzVar = (gz) bVar;
        x.i("MicroMsg.SubCoreCard.cardGetCountListener", "deal with card notify event GetCardCountEvent");
        if (gzVar instanceof gz) {
            am.a(this.hxV).postDelayed(new Runnable() {
                public final void run() {
                    if (g.Eg().Dx()) {
                        boolean z = gzVar.bQj.bQk;
                        x.i("MicroMsg.SubCoreCard.cardGetCountListener", "GetCardCountEvent isForceGet is " + z);
                        boolean azR = l.azR();
                        boolean azT = l.azT();
                        if (azR && azT) {
                            x.i("MicroMsg.SubCoreCard.cardGetCountListener", "card entrance and share card entrance is open");
                            return;
                        }
                        if (z) {
                            g.Eh().dpP.a(new y(), 0);
                        } else {
                            int intValue;
                            Integer num = (Integer) g.Ei().DT().get(282882, null);
                            if (num != null) {
                                intValue = num.intValue();
                            } else {
                                intValue = 0;
                            }
                            if (((int) (System.currentTimeMillis() / 1000)) - intValue >= 7200) {
                                g.Eh().dpP.a(new y(), 0);
                            }
                        }
                        if (azT) {
                            Long l = (Long) g.Ei().DT().get(a.sQb, Long.valueOf(0));
                            if (l != null && l.longValue() == 0) {
                                am.axp().axD();
                            }
                        }
                        if (azR && TextUtils.isEmpty((String) g.Ei().DT().get(a.sPR, null))) {
                            am.axh();
                            com.tencent.mm.plugin.card.b.b.nG(1);
                        }
                    }
                }
            }, 10000);
        }
        return false;
    }
}
