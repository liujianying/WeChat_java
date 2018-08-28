package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.g.a.fs;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bd.a;
import com.tencent.mm.storage.bd.d;
import com.tencent.mm.storage.bo;
import junit.framework.Assert;

public final class b {
    public boolean ceW;
    public String dzA;
    public String eHT;
    public long id;
    public int mZZ;
    public String nickname;
    public String qOI;
    public String username;

    public static b a(Context context, at atVar) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        long j = atVar.sKx;
        boolean clS = atVar.clS();
        String str7 = atVar.field_talker;
        String str8 = atVar.field_msgContent;
        int i = atVar.field_type;
        int i2 = 0;
        if (i == 0) {
            a YV = a.YV(str8);
            str = YV.otZ;
            str2 = YV.nickname;
            str3 = YV.tbE;
            str4 = YV.tbF;
            i2 = YV.scene;
            str5 = null;
            str6 = null;
        } else if (clS) {
            d YY = d.YY(str8);
            str = YY.otZ;
            str2 = YY.nickname;
            str6 = YY.content;
            if (YY.tbU == 1) {
                str5 = YY.tbW;
                str4 = null;
                str3 = null;
            } else {
                str5 = null;
                str4 = null;
                str3 = null;
            }
        } else {
            str5 = null;
            str6 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        b a = a(context, j, clS, str7, str8, i, str, str2, str3, str4, str6, i2);
        a.qOI = str5;
        return a;
    }

    public static b a(Context context, long j, boolean z, String str, String str2, int i, String str3, String str4, String str5, String str6, String str7, int i2) {
        b bVar = new b();
        bVar.id = j;
        bVar.ceW = !z;
        x.d("MicroMsg.FMessageProvider", "build, fmsgInfo.type:%d, fmsgInfo.talker:%s, scene:%d  ", new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)});
        if (i == 0) {
            if (str2 != null) {
                bVar.username = str3;
                bVar.nickname = str4;
                switch (i2) {
                    case 4:
                        bVar.dzA = context.getString(R.l.chatting_from_QQ_friends_content);
                        break;
                    case 10:
                    case 11:
                        fs fsVar = new fs();
                        fsVar.bOn.bOk = str5;
                        fsVar.bOn.bOl = str6;
                        com.tencent.mm.sdk.b.a.sFg.m(fsVar);
                        bVar.dzA = context.getString(R.l.chatting_from_mobile_friends_content, new Object[]{bi.aG(fsVar.bOo.bOp, "")});
                        break;
                    case s$l.AppCompatTheme_actionModeCloseDrawable /*31*/:
                        bVar.dzA = context.getString(R.l.chatting_from_verify_facebook_content);
                        break;
                    case 32:
                        bVar.dzA = context.getString(R.l.chatting_from_sns_add_now);
                        break;
                    case s$l.AppCompatTheme_toolbarStyle /*58*/:
                    case s$l.AppCompatTheme_toolbarNavigationButtonStyle /*59*/:
                    case s$l.AppCompatTheme_popupMenuStyle /*60*/:
                        bVar.eHT = a.YV(str2).eHT;
                        bVar.dzA = context.getString(R.l.chatting_from_google_contact);
                        break;
                    default:
                        bVar.dzA = context.getString(R.l.chatting_from_possible_friends_content);
                        break;
                }
            }
            x.e("MicroMsg.FMessageProvider", "build fail, fmsgInfo msgContent is null, fmsgInfo.talker = " + str);
            return null;
        } else if (z) {
            bVar.username = str3;
            bVar.nickname = str4;
            if (str7 == null || str7.trim().equals("")) {
                bVar.dzA = context.getString(R.l.fmessage_from_verify_digest_tip);
            } else {
                bVar.dzA = str7;
            }
        } else {
            bVar.username = str;
            bVar.dzA = str2;
        }
        return bVar;
    }

    public static b a(Context context, ch chVar) {
        x.d("MicroMsg.FMessageProvider", "build lbs, talker = " + chVar.field_sayhiuser + ", scene = " + chVar.field_scene);
        b bVar = new b();
        bVar.id = chVar.sKx;
        bVar.ceW = chVar.field_isSend == 1;
        bVar.username = chVar.field_sayhiuser;
        bVar.mZZ = chVar.field_scene;
        if (chVar.field_isSend == 1) {
            bVar.dzA = chVar.field_content;
        } else {
            d YY = d.YY(chVar.field_content);
            if (YY.content == null || YY.content.trim().equals("")) {
                bVar.dzA = context.getString(R.l.chatting_from_verify_lbs_tip);
            } else {
                bVar.dzA = YY.content;
            }
            bVar.nickname = YY.nickname;
        }
        return bVar;
    }

    public static b a(Context context, bo boVar) {
        x.d("MicroMsg.FMessageProvider", "build shake, talker = " + boVar.field_talker + ", scene = " + boVar.field_scene);
        b bVar = new b();
        bVar.id = boVar.sKx;
        bVar.ceW = boVar.field_isSend == 1;
        bVar.username = boVar.field_sayhiuser;
        bVar.mZZ = boVar.field_scene;
        if (boVar.field_isSend == 1) {
            bVar.dzA = boVar.field_content;
        } else {
            d YY = d.YY(boVar.field_content);
            if (YY.content == null || YY.content.trim().equals("")) {
                bVar.dzA = context.getString(R.l.chatting_from_verify_lbs_tip);
            } else {
                bVar.dzA = YY.content;
            }
            bVar.nickname = YY.nickname;
        }
        return bVar;
    }

    public static b[] a(Context context, at[] atVarArr) {
        String str = "MicroMsg.FMessageProvider";
        StringBuilder stringBuilder = new StringBuilder("convert fmsgList, talker = ");
        String str2 = (atVarArr == null || atVarArr.length == 0 || atVarArr[0] == null) ? "null" : atVarArr[0].field_talker;
        x.d(str, stringBuilder.append(str2).toString());
        if (atVarArr == null || atVarArr.length == 0) {
            x.e("MicroMsg.FMessageProvider", "convert fmsg fail, fmsgList is null");
            return null;
        }
        b[] bVarArr = new b[atVarArr.length];
        for (int i = 0; i < bVarArr.length; i++) {
            bVarArr[i] = a(context, atVarArr[i]);
        }
        return bVarArr;
    }

    public static b[] a(Context context, ch[] chVarArr) {
        String str = "MicroMsg.FMessageProvider";
        StringBuilder stringBuilder = new StringBuilder("convert lbsList, talker = ");
        String str2 = (chVarArr == null || chVarArr.length == 0 || chVarArr[0] == null) ? "null" : chVarArr[0].field_sayhiuser;
        x.d(str, stringBuilder.append(str2).toString());
        if (chVarArr == null || chVarArr.length == 0) {
            x.e("MicroMsg.FMessageProvider", "convert lbs fail, lbsList is null");
            return null;
        }
        b[] bVarArr = new b[chVarArr.length];
        for (int i = 0; i < bVarArr.length; i++) {
            bVarArr[i] = a(context, chVarArr[i]);
        }
        return bVarArr;
    }

    public static b[] a(Context context, bo[] boVarArr) {
        String str = "MicroMsg.FMessageProvider";
        StringBuilder stringBuilder = new StringBuilder("convert shakeList, talker = ");
        String str2 = (boVarArr == null || boVarArr.length == 0 || boVarArr[0] == null) ? "null" : boVarArr[0].field_sayhiuser;
        x.d(str, stringBuilder.append(str2).toString());
        if (boVarArr == null || boVarArr.length == 0) {
            x.e("MicroMsg.FMessageProvider", "convert shake fail, shakeList is null");
            return null;
        }
        b[] bVarArr = new b[boVarArr.length];
        for (int i = 0; i < bVarArr.length; i++) {
            bVarArr[i] = a(context, boVarArr[i]);
        }
        return bVarArr;
    }

    public static void aU(String str, int i) {
        b[] a;
        bo[] boVarArr;
        at[] atVarArr;
        ba[] baVarArr;
        if (i == 26 || i == 27 || i == 28 || i == 29) {
            x.d("MicroMsg.FMessageProvider", "initAddContent, scene is shake");
            bo[] Zp = com.tencent.mm.az.d.SH().Zp(str);
            a = a(ad.getContext(), Zp);
            boVarArr = Zp;
            atVarArr = null;
            baVarArr = null;
        } else if (i == 18) {
            x.d("MicroMsg.FMessageProvider", "initAddContent, scene is lbs");
            ch[] YR = com.tencent.mm.az.d.SG().YR(str);
            a = a(ad.getContext(), YR);
            boVarArr = null;
            atVarArr = null;
            baVarArr = YR;
        } else {
            at[] YM = com.tencent.mm.az.d.SE().YM(str);
            a = a(ad.getContext(), YM);
            boVarArr = null;
            atVarArr = YM;
            baVarArr = null;
        }
        if (a != null) {
            int i2 = 0;
            int length = a.length;
            int i3 = 0;
            while (i3 < length) {
                int i4;
                b bVar = a[i3];
                bd bdVar = new bd();
                bdVar.setContent(bVar.dzA);
                int hQ = s.hQ(bVar.username);
                if (atVarArr != null) {
                    i4 = i2 + 1;
                    bdVar.ay(atVarArr[i2].field_createTime);
                } else if (baVarArr != null) {
                    i4 = i2 + 1;
                    bdVar.ay(baVarArr[i2].field_createtime * 1000);
                } else if (boVarArr != null) {
                    i4 = i2 + 1;
                    bdVar.ay(boVarArr[i2].field_createtime * 1000);
                } else {
                    i4 = i2;
                }
                bdVar.ep(bVar.username);
                bdVar.setType(hQ);
                if (bVar.ceW) {
                    bdVar.setStatus(2);
                    bdVar.eX(1);
                } else {
                    bdVar.setStatus(6);
                    bdVar.eX(0);
                }
                au.HU();
                long T = c.FT().T(bdVar);
                Assert.assertTrue(T != -1);
                x.i("MicroMsg.FMessageProvider", "new msg inserted to db , local id = " + T);
                i3++;
                i2 = i4;
            }
            bd bdVar2 = new bd();
            if (atVarArr != null) {
                bdVar2.ay(atVarArr[atVarArr.length - 1].field_createTime + 1);
            } else if (baVarArr != null) {
                bdVar2.ay((baVarArr[baVarArr.length - 1].field_createtime * 1000) + 1);
            } else if (boVarArr != null) {
                bdVar2.ay((boVarArr[boVarArr.length - 1].field_createtime * 1000) + 1);
            }
            bdVar2.ep(str);
            bdVar2.setContent(ad.getContext().getString(R.l.transfer_greet_msg_tip));
            bdVar2.setType(10000);
            bdVar2.setStatus(6);
            bdVar2.eX(0);
            au.HU();
            x.i("MicroMsg.FMessageProvider", "new msg inserted to db , local id = " + c.FT().T(bdVar2));
        }
    }

    public static ab a(at atVar) {
        ab abVar = new ab();
        if (atVar == null) {
            return abVar;
        }
        if (atVar.field_type == 0) {
            a YV = a.YV(atVar.field_msgContent);
            abVar = new ab();
            abVar.setUsername(YV.otZ);
            abVar.du(YV.cCR);
            abVar.dx(YV.getDisplayName());
            abVar.dy(YV.eLz);
            abVar.dz(YV.eLA);
            abVar.eJ(YV.sex);
            abVar.dN(YV.getProvince());
            abVar.dO(YV.getCity());
            abVar.dM(YV.signature);
            abVar.eF(YV.pOR);
            abVar.dR(YV.csP);
            abVar.ea(YV.qOy);
            return abVar;
        }
        d YY = d.YY(atVar.field_msgContent);
        abVar = new ab();
        abVar.setUsername(YY.otZ);
        abVar.du(YY.cCR);
        abVar.dx(YY.nickname);
        abVar.dy(YY.eLz);
        abVar.dz(YY.eLA);
        abVar.eJ(YY.sex);
        abVar.dM(YY.signature);
        abVar.dN(YY.getProvince());
        abVar.dO(YY.getCity());
        return abVar;
    }
}
