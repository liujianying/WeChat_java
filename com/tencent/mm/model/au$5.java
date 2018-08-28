package com.tencent.mm.model;

import com.tencent.mm.g.c.am;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.az.a;
import com.tencent.mm.storage.az.b;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.s;

class au$5 implements a {
    final /* synthetic */ au dBL;

    au$5(au auVar) {
        this.dBL = auVar;
    }

    public final void a(ai aiVar, az azVar) {
        if (aiVar != null) {
            if (!ab.XO(aiVar.field_username) && !ab.XQ(aiVar.field_username) && !ab.gY(aiVar.field_username) && !s.hf(aiVar.field_username) && !ab.XR(aiVar.field_username)) {
                return;
            }
            bd GG;
            b vu;
            PString pString;
            PString pString2;
            PInt pInt;
            if (ab.gY(aiVar.field_username)) {
                ai aiVar2;
                Object obj;
                ai Yq = azVar.Yq("floatbottle");
                if (Yq == null) {
                    aiVar2 = new ai("floatbottle");
                    obj = 1;
                } else {
                    aiVar2 = Yq;
                    obj = null;
                }
                aiVar2.eW(1);
                aiVar2.eV(k.GB());
                au.HU();
                GG = c.FT().GG(" and not ( type = 10000 and isSend != 2 ) ");
                if (GG == null || GG.field_msgId <= 0) {
                    aiVar2.clx();
                } else {
                    aiVar2.aj(GG);
                    aiVar2.setContent(ab.XV(GG.field_talker) + ":" + GG.field_content);
                    aiVar2.ec(Integer.toString(GG.getType()));
                    vu = azVar.vu();
                    if (vu != null) {
                        pString = new PString();
                        pString2 = new PString();
                        pInt = new PInt();
                        GG.ep("floatbottle");
                        GG.setContent(aiVar2.field_content);
                        vu.a(GG, pString, pString2, pInt, false);
                        aiVar2.ed(pString.value);
                        aiVar2.ee(pString2.value);
                        aiVar2.eY(pInt.value);
                    }
                }
                if (obj != null) {
                    azVar.d(aiVar2);
                } else {
                    azVar.a(aiVar2, aiVar2.field_username);
                }
            } else if (!ab.XO(aiVar.field_username) && !ab.XQ(aiVar.field_username)) {
                if (s.hf(aiVar.field_username) && !bi.oW(aiVar.field_parentRef)) {
                    if (!s.hE(aiVar.field_parentRef) || !s.auK()) {
                        Object obj2;
                        Object obj3;
                        am amVar;
                        ai Yq2 = azVar.Yq(aiVar.field_parentRef);
                        x.v("MicroMsg.MMCore", "postConvExt, username = %s, parentRef = %s", new Object[]{aiVar.field_username, aiVar.field_parentRef});
                        if (aiVar.field_parentRef.equals("officialaccounts")) {
                            obj2 = null;
                        } else {
                            obj2 = 1;
                        }
                        if (Yq2 == null) {
                            Yq2 = new ai(aiVar.field_parentRef);
                            if (obj2 != null) {
                                Yq2.gf(2097152);
                            }
                            obj3 = 1;
                            amVar = Yq2;
                        } else {
                            obj3 = null;
                            amVar = Yq2;
                        }
                        x.i("MicroMsg.MMCore", "enterprise cvs count is %d", new Object[]{Integer.valueOf(amVar.field_unReadCount)});
                        au.HU();
                        String YD = c.FW().YD(aiVar.field_parentRef);
                        au.HU();
                        GG = c.FT().GE(YD);
                        if (GG == null || GG.field_msgId <= 0) {
                            amVar.clx();
                            x.i("MicroMsg.MMCore", "lastOfMsg is null or MsgId <= 0, lastConvBiz is %s", new Object[]{YD});
                        } else {
                            amVar.aj(GG);
                            amVar.setContent(GG.field_talker + ":" + GG.field_content);
                            amVar.ec(Integer.toString(GG.getType()));
                            vu = azVar.vu();
                            if (vu != null) {
                                pString = new PString();
                                pString2 = new PString();
                                pInt = new PInt();
                                GG.ep(aiVar.field_parentRef);
                                GG.setContent(amVar.field_content);
                                vu.a(GG, pString, pString2, pInt, true);
                                amVar.ed(pString.value);
                                amVar.ee(pString2.value);
                                amVar.eY(pInt.value);
                            }
                        }
                        Object obj4 = null;
                        if (obj2 != null) {
                            au.HU();
                            if (c.FW().YC(amVar.field_username) <= 0) {
                                obj4 = 1;
                            }
                        }
                        if (obj4 != null) {
                            azVar.Yp(amVar.field_username);
                        } else if (obj3 != null) {
                            azVar.d(amVar);
                        } else {
                            azVar.a(amVar, amVar.field_username);
                        }
                    } else {
                        return;
                    }
                }
                if ("@blacklist".equals(aiVar.field_parentRef)) {
                    au.HU();
                    ab Yg = c.FR().Yg(aiVar.field_username);
                    if (Yg != null && !bi.oW(Yg.field_username) && !Yg.BA()) {
                        au.HU();
                        c.FW().d(new String[]{aiVar.field_username}, "");
                    }
                }
            }
        }
    }
}
