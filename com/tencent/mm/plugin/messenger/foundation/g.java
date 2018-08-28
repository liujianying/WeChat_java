package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.mm.model.at;
import com.tencent.mm.model.bl;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.protocal.c.auy;
import com.tencent.mm.protocal.c.pm;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.x;

public final class g implements q {
    public final void a(pm pmVar, byte[] bArr, boolean z, s sVar) {
        switch (pmVar.rtM) {
            case 1:
                auy auy = (auy) new auy().aG(bArr);
                int i = auy.rXT;
                com.tencent.mm.kernel.g.Ei().DT().get(2, null);
                x DT = com.tencent.mm.kernel.g.Ei().DT();
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.UserInfoSyncExtension", "processModUserInfo bitFlag:%d status:%d PluginFlag:%d PluginSwitch:%d", new Object[]{Integer.valueOf(auy.rXT), Integer.valueOf(auy.hcd), Integer.valueOf(auy.raB), Integer.valueOf(auy.rYa)});
                String a = ab.a(auy.rvi);
                String a2 = ab.a(auy.rQz);
                String a3 = ab.a(auy.rXU);
                String a4 = ab.a(auy.rXV);
                int i2 = auy.ray;
                com.tencent.mm.storage.ab Yg = ((i) com.tencent.mm.kernel.g.l(i.class)).FR().Yg(a);
                com.tencent.mm.storage.ab abVar = (Yg == null || Yg.field_username == null || !Yg.field_username.equals(a)) ? new com.tencent.mm.storage.ab(a) : Yg;
                abVar.du(auy.eJM);
                abVar.dx(a2);
                abVar.dS(RegionCodeDecoder.aq(auy.eJQ, auy.eJI, auy.eJJ));
                abVar.eJ(auy.eJH);
                abVar.dM(auy.eJK);
                abVar.eE(auy.rTi);
                abVar.dQ(auy.rTg);
                abVar.dA(auy.rTh);
                abVar.eK(i2);
                ((i) com.tencent.mm.kernel.g.l(i.class)).FR().S(abVar);
                DT.set(2, a);
                DT.set(4, a2);
                DT.set(5, a3);
                DT.set(6, a4);
                DT.set(9, Integer.valueOf(i2));
                String str = "MicroMsg.UserInfoSyncExtension";
                StringBuilder stringBuilder = new StringBuilder("doCmd : status ");
                int i3 = auy.hcd;
                String str2 = "code=" + Integer.toHexString(i3) + ", status = " + i3;
                if ((i3 & 1) != 0) {
                    str2 = str2 + ", open";
                }
                if ((i3 & 2) != 0) {
                    str2 = str2 + ", email-verified";
                }
                if ((i3 & 4) != 0) {
                    str2 = str2 + ", mobile-verified";
                }
                if ((i3 & 8) != 0) {
                    str2 = str2 + ", hide-qq-search";
                }
                if ((i3 & 16) != 0) {
                    str2 = str2 + ", hide-qq-promote";
                }
                if ((i3 & 32) != 0) {
                    str2 = str2 + ", need-verify";
                }
                if ((i3 & 64) != 0) {
                    str2 = str2 + ", has-qq-msg";
                }
                if ((i3 & 128) != 0) {
                    str2 = str2 + ", no-qq-promote";
                }
                if ((i3 & com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab.CTRL_BYTE) != 0) {
                    str2 = str2 + ", no-mobile-promote";
                }
                if ((i3 & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
                    str2 = str2 + ", hide-mobile_search";
                }
                if ((i3 & 4096) != 0) {
                    str2 = str2 + ", open-float-bottle";
                }
                if ((i3 & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0) {
                    str2 = str2 + ", bind but not upload";
                }
                com.tencent.mm.sdk.platformtools.x.d(str, stringBuilder.append(str2).toString());
                DT.set(7, Integer.valueOf(auy.hcd));
                if (auy.eJL != 0) {
                    bl blVar = new bl();
                    blVar.csJ = 1;
                    blVar.sex = auy.eJH;
                    blVar.signature = auy.eJK;
                    blVar.countryCode = auy.eJQ;
                    blVar.dDf = auy.eJI;
                    blVar.dDe = auy.eJJ;
                    blVar.csO = auy.rTg;
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.UserInfoSyncExtension", " getPersonalCard weibo url : " + blVar.csO + " nickName :" + auy.rTh);
                    bl.a(blVar);
                }
                str = "MicroMsg.UserInfoSyncExtension";
                stringBuilder = new StringBuilder("userinfo Plugstate: ");
                i3 = auy.raB;
                str2 = "code=" + Integer.toHexString(i3) + ", pluginFlag = " + i3;
                str2 = (i3 & 1) != 0 ? str2 + ", QQMAIL_UNINSTALL" : str2 + ", QQMAIL_INSTALL";
                str2 = (i3 & 2) != 0 ? str2 + ", PM_UNINSTALL" : str2 + ", PM_INSTALL";
                str2 = (i3 & 4) != 0 ? str2 + ", FM_UNINSTALL" : str2 + ", FM_INSTALL";
                str2 = (i3 & 8) != 0 ? str2 + ", WEIBO_UNINSTALL" : str2 + ", WEIBO_INSTALL";
                str2 = (i3 & 16) != 0 ? str2 + ", MEDIANOTE_UNINSTALL" : str2 + ", MEDIANOTE_INSTALL";
                str2 = (i3 & 32) != 0 ? str2 + ", QMSG_UNINSTALL" : str2 + ", QMSG_INSTALL";
                str2 = (i3 & 64) != 0 ? str2 + ", BOTTLE_UNINSTALL" : str2 + ", BOTTLE_INSTALL";
                str2 = (i3 & 128) != 0 ? str2 + ", QSYNC_UNISTALL" : str2 + ", QSYNC_INSTALL";
                str2 = (i3 & com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab.CTRL_BYTE) != 0 ? str2 + ", SHAKE_UNISTALL" : str2 + ", SHAKE_INSTALL";
                str2 = (i3 & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0 ? str2 + ", LBS_UNISTALL" : str2 + ", LBS_INSTALL";
                str2 = (i3 & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0 ? str2 + ", BOTTLE_CHART_INSTALL" : str2 + ", BOTTLE_CHART_INSTALL";
                str2 = (i3 & 4096) != 0 ? str2 + ",CHECKQQF_UNINSTALL" : str2 + ",CHECKQQF_INSTALL";
                com.tencent.mm.sdk.platformtools.x.i(str, stringBuilder.append((i3 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? str2 + ",MM_FEEDSAPP_UNINSTALL" : str2 + ",MM_FEEDSAPP_INSTALL").toString());
                DT.set(34, Integer.valueOf(auy.raB));
                DT.set(8200, Boolean.valueOf(bi.a(Boolean.valueOf(1 == auy.rXz.rvE), false)));
                DT.set(8201, Integer.valueOf(bi.a(Integer.valueOf(auy.rXz.rvF.rvI), 22)));
                DT.set(8208, Integer.valueOf(bi.a(Integer.valueOf(auy.rXz.rvF.rvJ), 8)));
                DT.set(66049, Integer.valueOf(auy.rTe));
                DT.set(66050, auy.rTf);
                DT.set(40, Integer.valueOf(auy.rYa));
                at.dBv.T("last_login_use_voice", auy.rYa);
                DT.set(41, Integer.valueOf(auy.rTi));
                DT.set(43, auy.rTh);
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.UserInfoSyncExtension", "doCmd PluginSwitch:" + auy.rYa + " WeiboFlag:" + auy.rTi);
                DT.set(868518889, Integer.valueOf(auy.rXL));
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.UserInfoSyncExtension", "doCmd USERINFO_TXNEWSCATEGORY:" + auy.rXL);
                DT.set(42, auy.eJM);
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.UserInfoSyncExtension", "userid:" + auy.ryG + " username:" + auy.ryH);
                DT.set(65825, auy.ryG);
                DT.set(65826, auy.ryH);
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.UserInfoSyncExtension", "getiAlbumFlag " + auy.eJN);
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.UserInfoSyncExtension", "getiAlbumStyle " + auy.eJO);
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.UserInfoSyncExtension", "getPcAlbumBGImgID " + auy.eJP);
                str2 = bi.oV((String) com.tencent.mm.kernel.g.Ei().DT().get(65830, null));
                if (str2 == null || str2.length() == 0) {
                    str2 = auy.rYd;
                    if (str2 != null && str2.length() > 0) {
                        com.tencent.mm.kernel.g.Ei().DT().set(65830, str2);
                    }
                }
                t.b(1, auy);
                return;
            default:
                return;
        }
    }
}
