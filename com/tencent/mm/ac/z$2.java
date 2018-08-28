package com.tencent.mm.ac;

import com.tencent.mm.ac.e.a;
import com.tencent.mm.ac.e.a.b;
import com.tencent.mm.g.c.ai;
import com.tencent.mm.g.c.am;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;

class z$2 implements a {
    final /* synthetic */ z dMY;

    z$2(z zVar) {
        this.dMY = zVar;
    }

    public final void a(b bVar) {
        if ((bVar.dMb == a.a.dLX || bVar.dMb == a.a.dLZ) && bVar.dMc != null) {
            ai Yg = ((i) g.l(i.class)).FR().Yg(bVar.dKF);
            if (Yg == null) {
                return;
            }
            if (!Yg.ckW()) {
                z.h(bVar.dMc);
            } else if (!s.hr(Yg.field_username)) {
                com.tencent.mm.storage.ai Yq = ((i) g.l(i.class)).FW().Yq(bVar.dKF);
                x.v("MicroMsg.SubCoreBiz", "hakon onEvent bizName = %s", bVar.dKF);
                if (!(!bVar.dMc.LZ() || bVar.dMc.bG(false) == null || bVar.dMc.bG(false).MB() == null || bi.oW(bVar.dMc.Mg()) || !bi.oW(bVar.dMc.field_enterpriseFather))) {
                    bVar.dMc.field_enterpriseFather = bVar.dMc.Mg();
                    z.MY().e(bVar.dMc);
                    x.i("MicroMsg.SubCoreBiz", "hakon bizStgExt, %s set enterpriseFather %s", bVar.dKF, bVar.dMc.field_enterpriseFather);
                }
                if (Yq != null) {
                    int i;
                    boolean i2;
                    if (bVar.dMc.LZ()) {
                        if (bVar.dMc.bG(false) == null) {
                            x.e("MicroMsg.SubCoreBiz", "getExtInfo() == null");
                            return;
                        } else if (bVar.dMc.bG(false).MB() == null) {
                            x.e("MicroMsg.SubCoreBiz", "enterpriseBizInfo == null");
                            return;
                        } else {
                            String str = Yq.field_parentRef;
                            if (bVar.dMc.Ma()) {
                                Yq.ef(null);
                            } else {
                                x.i("MicroMsg.SubCoreBiz", "Enterprise belong %s, userName: %s", bVar.dMc.Mg(), bVar.dKF);
                                Yq.ef(bi.oV(bVar.dMc.Mg()));
                            }
                            if (str != null && Yq.field_parentRef != null && !str.equals(Yq.field_parentRef)) {
                                i2 = 1;
                            } else if (str == null && Yq.field_parentRef != null) {
                                i2 = 1;
                            } else if (str == null || Yq.field_parentRef != null) {
                                i2 = false;
                            } else {
                                i2 = 1;
                            }
                            x.v("MicroMsg.SubCoreBiz", "hakon isEnterpriseChildType, %s, %s", bVar.dKF, Yq.field_parentRef);
                        }
                    } else if (bVar.dMc.LY()) {
                        x.v("MicroMsg.SubCoreBiz", "hakon isEnterpriseFatherType, %s", bVar.dKF);
                        i2 = 1;
                    } else if (!bVar.dMc.LV() && !s.hM(Yg.field_username) && !"officialaccounts".equals(Yq.field_parentRef)) {
                        Yq.ef("officialaccounts");
                        i2 = 1;
                    } else if (!bVar.dMc.LV() || Yq.field_parentRef == null) {
                        i2 = false;
                    } else {
                        Yq.ef(null);
                        i2 = 1;
                    }
                    if (i2 != 0) {
                        ((i) g.l(i.class)).FW().a(Yq, Yq.field_username);
                        if (!bi.oW(Yq.field_parentRef)) {
                            am Yq2;
                            String clI;
                            bd GE;
                            if ("officialaccounts".equals(Yq.field_parentRef)) {
                                Yq2 = ((i) g.l(i.class)).FW().Yq("officialaccounts");
                                if (Yq2 == null) {
                                    am aiVar = new com.tencent.mm.storage.ai("officialaccounts");
                                    aiVar.clx();
                                    ((i) g.l(i.class)).FW().d(aiVar);
                                    Yq2 = aiVar;
                                }
                                if (bi.oW(Yq2.field_content)) {
                                    x.i("MicroMsg.SubCoreBiz", "conv content is null");
                                    clI = ((i) g.l(i.class)).FW().clI();
                                    if (bi.oW(clI)) {
                                        x.w("MicroMsg.SubCoreBiz", "last convBiz is null");
                                        return;
                                    }
                                    GE = ((i) g.l(i.class)).bcY().GE(clI);
                                    if (GE == null || GE.field_msgId == 0) {
                                        x.w("MicroMsg.SubCoreBiz", "last biz msg is error");
                                        return;
                                    } else {
                                        ((i) g.l(i.class)).bcY().a(GE.field_msgId, GE);
                                        return;
                                    }
                                }
                                return;
                            }
                            x.i("MicroMsg.SubCoreBiz", "hakon username = %s, parentRef = %s", bVar.dKF, Yq.field_parentRef);
                            Yq2 = ((i) g.l(i.class)).FW().Yq(Yq.field_parentRef);
                            if (Yq2 != null && bi.oW(Yq2.field_content)) {
                                x.i("MicroMsg.SubCoreBiz", "conv content is null");
                                clI = ((i) g.l(i.class)).FW().YD(Yq.field_parentRef);
                                if (bi.oW(clI)) {
                                    x.w("MicroMsg.SubCoreBiz", "last enterprise convBiz is null");
                                    return;
                                }
                                GE = ((i) g.l(i.class)).bcY().GE(clI);
                                if (GE == null || GE.field_msgId == 0) {
                                    x.w("MicroMsg.SubCoreBiz", "last enterprise biz msg is error");
                                } else {
                                    ((i) g.l(i.class)).bcY().a(GE.field_msgId, GE);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
