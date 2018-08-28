package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.dj;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.y.g.a;
import java.util.List;

class e$24 extends c<dj> {
    final /* synthetic */ e iup;

    e$24(e eVar) {
        this.iup = eVar;
        this.sFo = dj.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        dj djVar = (dj) bVar;
        long j = djVar.bLf.bJC;
        String str = djVar.bLf.bKW;
        List<com.tencent.mm.plugin.exdevice.h.b> aHI = ad.aHe().aHI();
        if (aHI.size() > 0) {
            boolean z;
            if (j == -1 || j == Long.MIN_VALUE) {
                z = false;
            } else {
                au.HU();
                bd dW = com.tencent.mm.model.c.FT().dW(j);
                if (dW.field_msgId == 0) {
                    z = false;
                } else {
                    int type = dW.getType();
                    String str2 = dW.field_content;
                    String str3;
                    if (dW.aQm()) {
                        a gp = a.gp(str2);
                        if (gp == null) {
                            x.e("MicroMsg.exdevice.ExdeviceEventManager", "get content is null");
                            z = false;
                        } else if (gp.type == 3) {
                            for (com.tencent.mm.plugin.exdevice.h.b bVar2 : aHI) {
                                str3 = bVar2.cCX;
                                if (str3 != null && str3.contains("wxmsg_music")) {
                                    z = true;
                                    break;
                                }
                            }
                            z = false;
                        } else if (gp.type == 4) {
                            z = false;
                        } else if (gp.type == 6) {
                            for (com.tencent.mm.plugin.exdevice.h.b bVar22 : aHI) {
                                str3 = bVar22.cCX;
                                if (str3 != null && str3.contains("wxmsg_file")) {
                                    z = true;
                                    break;
                                }
                            }
                            z = false;
                        } else if (gp.type == 5) {
                            z = e.f(gp.url, aHI);
                        } else {
                            if (gp.type == 2) {
                                for (com.tencent.mm.plugin.exdevice.h.b bVar222 : aHI) {
                                    str3 = bVar222.cCX;
                                    if (str3 != null && str3.contains("wxmsg_image")) {
                                        z = true;
                                        break;
                                    }
                                }
                                z = false;
                            }
                            z = false;
                        }
                    } else if (type == 3) {
                        for (com.tencent.mm.plugin.exdevice.h.b bVar2222 : aHI) {
                            str3 = bVar2222.cCX;
                            if (str3 != null && str3.contains("wxmsg_image")) {
                                z = true;
                                break;
                            }
                        }
                        z = false;
                    } else if (type == 48) {
                        for (com.tencent.mm.plugin.exdevice.h.b bVar22222 : aHI) {
                            str3 = bVar22222.cCX;
                            if (str3 != null && str3.contains("wxmsg_poi")) {
                                z = true;
                                break;
                            }
                        }
                        z = false;
                    } else {
                        if (type == 62) {
                            for (com.tencent.mm.plugin.exdevice.h.b bVar222222 : aHI) {
                                str3 = bVar222222.cCX;
                                if (str3 != null && str3.contains("wxmsg_video")) {
                                    z = true;
                                    break;
                                }
                            }
                        }
                        z = false;
                    }
                    x.i("MicroMsg.exdevice.ExdeviceEventManager", "isSupportsMsgType = " + z + ", msgType = " + type);
                }
            }
            if (z || e.g(str, aHI)) {
                djVar.bLg.bKE = true;
                return true;
            }
        }
        djVar.bLg.bKE = false;
        return true;
    }
}
