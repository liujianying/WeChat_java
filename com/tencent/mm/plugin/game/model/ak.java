package com.tencent.mm.plugin.game.model;

import com.tencent.mm.bk.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.b;
import com.tencent.mm.plugin.game.d.ap;
import com.tencent.mm.plugin.game.d.aq;
import com.tencent.mm.plugin.game.d.as;
import com.tencent.mm.plugin.game.d.bj;
import com.tencent.mm.plugin.game.d.cc;
import com.tencent.mm.plugin.game.e.d;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class ak extends ac {
    public bj jNZ;
    private boolean jOa;
    public LinkedList<d> jOb;
    public HashMap<String, Integer> jOc;

    public ak(a aVar) {
        this.jOc = new HashMap();
        if (aVar == null) {
            this.jNZ = new bj();
            return;
        }
        this.jNZ = (bj) aVar;
        this.jOa = true;
        Wj();
    }

    public ak(byte[] bArr) {
        this.jOc = new HashMap();
        this.jNZ = new bj();
        if (bArr != null && bArr.length != 0) {
            try {
                this.jNZ.aG(bArr);
            } catch (IOException e) {
                x.e("MicroMsg.GamePBDataOverSea", "Parsing Failed: %s", e.getMessage());
            }
            this.jOa = false;
            Wj();
        }
    }

    private void Wj() {
        LinkedList linkedList;
        LinkedList linkedList2 = new LinkedList();
        if (this.jNZ.jRX == null || this.jNZ.jRX.jPz == null) {
            linkedList = linkedList2;
        } else {
            Iterator it = this.jNZ.jRX.jPz.iterator();
            int i = 1;
            while (it.hasNext()) {
                ap apVar = (ap) it.next();
                if (apVar.jOV != null) {
                    d a = a(apVar.jOV);
                    if (a != null) {
                        if (apVar.jOV.jPq == null) {
                            a.jLt = an.Dx(apVar.jPA);
                        } else if (apVar.jOV.jPq.jPe == null || apVar.jOV.jPq.jSH == null) {
                            a.jLt = an.Dx(apVar.jPA);
                        } else {
                            a.jLp = apVar.jOV.jPq.jPe;
                            a.jLq = apVar.jOV.jPq.jSH;
                            a.jLt = an.Q(apVar.jPA, "label", a.jLp);
                        }
                        if (apVar.jQX != null) {
                            Iterator it2 = apVar.jQX.iterator();
                            while (it2.hasNext()) {
                                aq aqVar = (aq) it2.next();
                                if (aqVar != null) {
                                    if (aqVar.jQY == null || aqVar.jQY.size() == 0) {
                                        a.jLk.add("");
                                    } else {
                                        StringBuilder stringBuilder = new StringBuilder();
                                        int i2 = 0;
                                        while (true) {
                                            int i3 = i2;
                                            if (i3 >= aqVar.jQY.size()) {
                                                break;
                                            }
                                            ab Yg = ((i) g.l(i.class)).FR().Yg((String) aqVar.jQY.get(i3));
                                            if (Yg == null || Yg.dhP == 0) {
                                                stringBuilder.append((String) aqVar.jQY.get(i3));
                                            } else {
                                                stringBuilder.append(Yg.BL());
                                            }
                                            if (i3 < aqVar.jQY.size() - 1) {
                                                stringBuilder.append("、");
                                            }
                                            i2 = i3 + 1;
                                        }
                                        stringBuilder.append(" ");
                                        a.jLk.add(stringBuilder.toString());
                                    }
                                    a.jLk.add(aqVar.jQf);
                                }
                            }
                        }
                        a.scene = 10;
                        a.bYq = 1004;
                        int i4 = i + 1;
                        a.position = i;
                        linkedList2.add(a);
                        i = i4;
                    }
                }
            }
            linkedList = linkedList2;
        }
        this.jOb = linkedList;
        if (this.jOa) {
            d.S(this.jOb);
            aUx();
            ((b) g.l(b.class)).aSf().init(ad.getContext());
        }
    }

    private void aUx() {
        this.jOc = new HashMap();
        if (this.jNZ.jRY != null && this.jNZ.jRY.jSD != null) {
            Iterator it = this.jNZ.jRY.jSD.iterator();
            while (it.hasNext()) {
                cc ccVar = (cc) it.next();
                d a = a(ccVar.jOV);
                if (a != null) {
                    this.jOc.put(a.field_appId, Integer.valueOf(a.versionCode));
                    f SW = com.tencent.mm.plugin.ac.a.bmf().SW(a.field_appId);
                    if (SW != null) {
                        SW.dk(ccVar.jSF);
                        if (!com.tencent.mm.plugin.ac.a.bmf().a(SW, new String[0])) {
                            x.e("MicroMsg.GamePBDataOverSea", "Store rank info failed, AppID: %s", SW.field_appId);
                        }
                    }
                }
            }
        }
    }

    public final as aUy() {
        return this.jNZ != null ? this.jNZ.jRV : null;
    }
}
