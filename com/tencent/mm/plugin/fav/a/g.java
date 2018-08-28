package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.g.c.bg;
import com.tencent.mm.plugin.fav.a.a.b;
import com.tencent.mm.plugin.fav.a.a.c;
import com.tencent.mm.protocal.c.vv;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.vz;
import com.tencent.mm.protocal.c.we;
import com.tencent.mm.protocal.c.wf;
import com.tencent.mm.protocal.c.wk;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.protocal.c.wr;
import com.tencent.mm.protocal.c.wu;
import com.tencent.mm.protocal.c.wy;
import com.tencent.mm.protocal.c.xa;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.Map;

public final class g extends bg {
    public static a dhO = bg.wI();
    private static a iVD = new 1();
    private static a iVE = new 2();

    public g() {
        this.field_flag = -1;
        this.field_fromUser = "";
        this.field_toUser = "";
        this.field_id = -1;
        this.field_realChatName = "";
        this.field_sourceType = -1;
        this.field_updateTime = -1;
        this.field_type = -1;
        this.field_updateSeq = -1;
        this.field_xml = "";
        this.field_itemStatus = 0;
        aLc();
    }

    private void aLc() {
        this.field_favProto = new wl();
        wr wrVar = new wr();
        wrVar.CO(1);
        this.field_favProto.a(wrVar);
        this.field_favProto.b(new xa());
        this.field_favProto.b(new we());
        this.field_favProto.b(new wk());
        this.field_favProto.b(new wu());
        this.field_favProto.CM(-1);
        this.field_tagProto = new wy();
        this.field_favProto.a(new wf());
    }

    protected final a AX() {
        return dhO;
    }

    public final boolean aLd() {
        return (this.field_favProto.rAW & 1) != 0;
    }

    public final boolean aLe() {
        return (this.field_favProto.rAW & 2) != 0;
    }

    public final boolean aLf() {
        if (this.field_itemStatus == 1 || this.field_itemStatus == 4 || this.field_itemStatus == 9 || this.field_itemStatus == 12 || this.field_itemStatus == 13 || this.field_itemStatus == 15 || this.field_itemStatus == 17) {
            return true;
        }
        return false;
    }

    public final boolean aLg() {
        if (this.field_itemStatus == 3 || this.field_itemStatus == 6 || this.field_itemStatus == 11 || this.field_itemStatus == 14 || this.field_itemStatus == 16 || this.field_itemStatus == 18) {
            return true;
        }
        return false;
    }

    public final boolean isDownloading() {
        return this.field_itemStatus == 7;
    }

    public final boolean aLh() {
        return this.field_itemStatus == 8;
    }

    public final boolean isDone() {
        return this.field_itemStatus == 10;
    }

    public final boolean aLi() {
        if (this.field_itemStatus == 15 || this.field_itemStatus == 16) {
            return true;
        }
        return false;
    }

    public final boolean aLj() {
        if (this.field_itemStatus == 12 || this.field_itemStatus == 13 || this.field_itemStatus == 14) {
            return true;
        }
        return false;
    }

    public final g Bh(String str) {
        if (str == null || str.equals("")) {
            x.e("MicroMsg.FavItemInfo", "klem, FavItemInfo xml null");
        } else {
            Map z = bl.z(str, "favitem");
            if (z == null) {
                x.e("MicroMsg.FavItemInfo", "klem, FavItemInfo maps null");
            } else {
                try {
                    aLc();
                    wl wlVar = this.field_favProto;
                    wlVar.Vu((String) z.get(".favitem.title"));
                    wlVar.Vv((String) z.get(".favitem.desc"));
                    wlVar.Vt((String) z.get(".favitem.remark"));
                    wlVar.fS(bi.getLong((String) z.get(".favitem.remark.$time"), 0));
                    String str2 = (String) z.get(".favitem.edittime");
                    wlVar.CN(bi.getInt((String) z.get(".favitem.version"), 0));
                    wlVar.fT(bi.getLong(str2, 0));
                    wlVar.CM(bi.getInt((String) z.get(".favitem.ctrlflag"), -1));
                    String str3 = ".favitem.source";
                    wr wrVar = wlVar.rBG;
                    wrVar.CO(bi.getInt((String) z.get(str3 + ".$sourcetype"), 0));
                    wrVar.Vy((String) z.get(str3 + ".$sourceid"));
                    wrVar.Vw((String) z.get(str3 + ".fromusr"));
                    wrVar.Vx((String) z.get(str3 + ".tousr"));
                    wrVar.Vz((String) z.get(str3 + ".realchatname"));
                    wrVar.fU(bi.getLong((String) z.get(str3 + ".createtime"), 0));
                    wrVar.VA((String) z.get(str3 + ".msgid"));
                    wrVar.VB((String) z.get(str3 + ".eventid"));
                    wrVar.VC((String) z.get(str3 + ".appid"));
                    wrVar.VD((String) z.get(str3 + ".link"));
                    wrVar.VE((String) z.get(str3 + ".brandid"));
                    b.a(str, wlVar);
                    str3 = ".favitem.locitem";
                    we weVar = wlVar.rAL;
                    if (!bi.oW((String) z.get(str3 + ".label"))) {
                        weVar.Vn((String) z.get(str3 + ".label"));
                    }
                    if (!bi.oW((String) z.get(str3 + ".poiname"))) {
                        weVar.Vo((String) z.get(str3 + ".poiname"));
                    }
                    str2 = (String) z.get(str3 + ".lng");
                    if (!bi.oW(str2)) {
                        weVar.y(bi.getDouble(str2, 0.0d));
                    }
                    str2 = (String) z.get(str3 + ".lat");
                    if (!bi.oW(str2)) {
                        weVar.z(bi.getDouble(str2, 0.0d));
                    }
                    str2 = (String) z.get(str3 + ".scale");
                    if (!bi.oW(str2)) {
                        if (str2.indexOf(46) != -1) {
                            weVar.CK(bi.getInt(str2.substring(0, str2.indexOf(46)), -1));
                        } else {
                            weVar.CK(bi.getInt(str2, -1));
                        }
                    }
                    str3 = ".favitem.weburlitem";
                    xa xaVar = wlVar.rAN;
                    xaVar.VL((String) z.get(str3 + ".clean_url"));
                    xaVar.VK((String) z.get(str3 + ".pagedesc"));
                    xaVar.VM((String) z.get(str3 + ".pagethumb_url"));
                    xaVar.VJ((String) z.get(str3 + ".pagetitle"));
                    xaVar.CP(bi.getInt((String) z.get(str3 + ".opencache"), 0));
                    xaVar.CQ(bi.getInt((String) z.get(str3 + ".contentattr"), 0));
                    xaVar.VN((String) z.get(str3 + ".canvasPageXml"));
                    str3 = ".favitem.productitem";
                    wk wkVar = wlVar.rAP;
                    wkVar.Vp((String) z.get(str3 + ".producttitle"));
                    wkVar.Vq((String) z.get(str3 + ".productdesc"));
                    wkVar.Vr((String) z.get(str3 + ".productthumb_url"));
                    wkVar.Vs((String) z.get(str3 + ".productinfo"));
                    wkVar.CL(bi.getInt((String) z.get(str3 + ".$type"), 0));
                    str3 = ".favitem.tvitem";
                    wu wuVar = wlVar.rAR;
                    wuVar.VF((String) z.get(str3 + ".tvtitle"));
                    wuVar.VG((String) z.get(str3 + ".tvdesc"));
                    wuVar.VH((String) z.get(str3 + ".tvthumb_url"));
                    wuVar.VI((String) z.get(str3 + ".tvinfo"));
                    str3 = ".favitem.noteinfo";
                    wf wfVar = wlVar.qYa;
                    wfVar.rBz = (String) z.get(str3 + ".noteauthor");
                    wfVar.rBA = (String) z.get(str3 + ".noteeditor");
                    str3 = ".favitem.appbranditem";
                    vv vvVar = wlVar.rBa;
                    if (vvVar != null) {
                        vvVar.username = (String) z.get(str3 + ".username");
                        vvVar.appId = (String) z.get(str3 + ".appid");
                        vvVar.bPh = bi.getInt((String) z.get(str3 + ".pkgtype"), 0);
                        vvVar.iconUrl = (String) z.get(str3 + ".iconurl");
                        vvVar.type = bi.getInt((String) z.get(str3 + ".type"), 0);
                        vvVar.bGH = (String) z.get(str3 + ".pagepath");
                        vvVar.rzd = (String) z.get(str3 + ".sourcedisplayname");
                    }
                    if (this.field_favProto.rBG != null) {
                        wr wrVar2 = this.field_favProto.rBG;
                        this.field_sourceId = wrVar2.rBQ;
                        this.field_sourceType = wrVar2.bJt;
                        this.field_fromUser = wrVar2.bSS;
                        this.field_toUser = wrVar2.toUser;
                    }
                    this.field_edittime = this.field_favProto.qYb;
                    c.a(z, this.field_tagProto);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.FavItemInfo", e, "", new Object[0]);
                    x.e("MicroMsg.FavItemInfo", "klem , FavItemInfo exception:+%s", new Object[]{e.toString()});
                }
            }
        }
        return this;
    }

    public final void Bi(String str) {
        a aVar = iVD;
        aVar.sL("----dump favitem from[" + str + "] beg----");
        aVar.sL("type: " + this.field_type);
        aVar.sL("favId: " + this.field_id);
        aVar.sL("localId: " + this.field_localId);
        aVar.sL("itemStatus: " + this.field_itemStatus);
        aVar.sL("localSeq: " + this.field_localSeq);
        aVar.sL("updateSeq: " + this.field_updateSeq);
        aVar.sL("ctrlFlag: " + this.field_flag);
        aVar.sL("sourceId: " + this.field_sourceId);
        aVar.sL("sourceType: " + this.field_sourceType);
        aVar.sL("sourceCreateTime: " + this.field_sourceCreateTime);
        aVar.sL("updateTime: " + this.field_updateTime);
        aVar.sL("editTime: " + this.field_edittime);
        aVar.sL("fromuser: " + this.field_fromUser);
        aVar.sL("toUser: " + this.field_toUser);
        aVar.sL("realChatName: " + this.field_realChatName);
        if (this.field_favProto != null) {
            aVar.sL("remarktime: " + this.field_favProto.rAU);
            aVar.sL("dataitemCount: " + this.field_favProto.rBI.size());
            if (this.field_favProto.rBG != null) {
                aVar.sL(" ----source item----");
                wr wrVar = this.field_favProto.rBG;
                aVar.sL("  sourceType: " + wrVar.bJt);
                aVar.sL("  fromUser: " + wrVar.bSS);
                aVar.sL("  toUser: " + wrVar.toUser);
                aVar.sL("  sourceId: " + wrVar.rBQ);
                aVar.sL("  realChatName: " + wrVar.rBh);
                aVar.sL("  createTime: " + wrVar.createTime);
                aVar.sL("  msgId: " + wrVar.bWQ);
                aVar.sL("  eventId: " + wrVar.cca);
                aVar.sL("  appId: " + wrVar.appId);
                aVar.sL("  link: " + wrVar.egr);
                aVar.sL("  mediaId: " + wrVar.rBn);
                aVar.sL("  brandId: " + wrVar.bGy);
            }
            Iterator it = this.field_favProto.rBI.iterator();
            int i = 0;
            while (it.hasNext()) {
                vx vxVar = (vx) it.next();
                int i2 = i + 1;
                aVar.sL(" ----data item " + i + "----");
                aVar.sL("  dataId: " + vxVar.jdM);
                aVar.sL("  dataType: " + vxVar.bjS);
                aVar.sL("  dataSouceId: " + vxVar.rzW);
                aVar.sL("  svrDataStatus: " + vxVar.rAe);
                aVar.sL("  cdnThumbUrl: " + vxVar.dwE);
                aVar.sL("  cdnThumbKey: " + vxVar.rzk);
                aVar.sL("  cdnDataUrl: " + vxVar.rzo);
                aVar.sL("  cdnDataKey: " + vxVar.rzq);
                aVar.sL("  cdnEncryVer: " + vxVar.rzs);
                aVar.sL("  fullmd5: " + vxVar.rzF);
                aVar.sL("  head256md5: " + vxVar.rzH);
                aVar.sL("  fullsize: " + vxVar.rzJ);
                aVar.sL("  thumbMd5: " + vxVar.rzQ);
                aVar.sL("  thumbHead256md5: " + vxVar.rzS);
                aVar.sL("  thumbfullsize: " + vxVar.rzU);
                aVar.sL("  duration: " + vxVar.duration);
                aVar.sL("  datafmt: " + vxVar.rzD);
                aVar.sL("  streamWebUrl: " + vxVar.rzv);
                aVar.sL("  streamDataUrl: " + vxVar.rzx);
                aVar.sL("  streamLowBandUrl: " + vxVar.rzz);
                aVar.sL("  ext: " + vxVar.bJv);
                if (vxVar.rAi != null) {
                    aVar.sL("  remarktime: " + vxVar.rAi.rAU);
                    aVar.sL("  ctrlflag: " + vxVar.rAi.rAW);
                    aVar.sL("  edittime: " + vxVar.rAi.qYb);
                    if (vxVar.rAi.rAJ != null) {
                        aVar.sL("   ----data source item----");
                        vz vzVar = vxVar.rAi.rAJ;
                        aVar.sL("    sourceType: " + vzVar.bJt);
                        aVar.sL("    fromUser: " + vzVar.bSS);
                        aVar.sL("    toUser: " + vzVar.toUser);
                        aVar.sL("    realChatName: " + vzVar.rBh);
                        aVar.sL("    createTime: " + vzVar.createTime);
                        aVar.sL("    msgId: " + vzVar.bWQ);
                        aVar.sL("    eventId: " + vzVar.cca);
                        aVar.sL("    appId: " + vzVar.appId);
                        aVar.sL("    link: " + vzVar.egr);
                        aVar.sL("    mediaId: " + vzVar.rBn);
                        aVar.sL("    brandId: " + vzVar.bGy);
                    }
                    a("  ", aVar, vxVar.rAi.rAL);
                    a("  ", aVar, vxVar.rAi.rAN);
                    a("  ", aVar, vxVar.rAi.rAP);
                    a("  ", aVar, vxVar.rAi.rAR);
                    a("  ", aVar, vxVar.rAi.qYa);
                }
                i = i2;
            }
            a("", aVar, this.field_favProto.rAL);
            a("", aVar, this.field_favProto.rAN);
            a("", aVar, this.field_favProto.rAP);
            a("", aVar, this.field_favProto.rAR);
            a("  ", aVar, this.field_favProto.qYa);
        }
        aVar.sL("----dump favitem end----");
    }

    private static void a(String str, a aVar, wu wuVar) {
        if (wuVar != null) {
            aVar.sL(str + " ----tv item----");
            aVar.sL(str + "  title: " + wuVar.title);
            aVar.sL(str + "  desc: " + wuVar.desc);
            aVar.sL(str + "  thumbUrl: " + wuVar.thumbUrl);
        }
    }

    private static void a(String str, a aVar, wf wfVar) {
        if (wfVar != null) {
            aVar.sL(str + " ----noteInfoItem item----");
            aVar.sL(str + "  author: " + wfVar.rBz);
            aVar.sL(str + "  editor: " + wfVar.rBA);
        }
    }

    private static void a(String str, a aVar, wk wkVar) {
        if (wkVar != null) {
            aVar.sL(str + " ----product item----");
            aVar.sL(str + "  title: " + wkVar.title);
            aVar.sL(str + "  desc: " + wkVar.desc);
            aVar.sL(str + "  thumbUrl: " + wkVar.thumbUrl);
            aVar.sL(str + "  type: " + wkVar.type);
        }
    }

    private static void a(String str, a aVar, we weVar) {
        if (weVar != null) {
            aVar.sL(str + " ----loc item----");
            aVar.sL(str + "  lng: " + weVar.lng);
            aVar.sL(str + "  lat: " + weVar.lat);
            aVar.sL(str + "  scale: " + weVar.bSz);
            aVar.sL(str + "  label: " + weVar.label);
            aVar.sL(str + "  poiname: " + weVar.bWB);
        }
    }

    private static void a(String str, a aVar, xa xaVar) {
        if (xaVar != null) {
            aVar.sL(str + " ----url item----");
            aVar.sL(str + "  title: " + xaVar.title);
            aVar.sL(str + "  desc: " + xaVar.desc);
            aVar.sL(str + "  cleanUrl: " + xaVar.rCn);
            aVar.sL(str + "  thumbUrl: " + xaVar.thumbUrl);
            aVar.sL(str + "  opencache: " + xaVar.rCp);
        }
    }

    public final boolean Bj(String str) {
        if (bi.oW(str)) {
            return false;
        }
        Iterator it = this.field_tagProto.rBX.iterator();
        while (it.hasNext()) {
            if (str.equals((String) it.next())) {
                return false;
            }
        }
        this.field_tagProto.rBX.add(str);
        return true;
    }

    public static String s(g gVar) {
        String str;
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("<favitem");
        stringBuffer2.append(" type='").append(gVar.field_type).append("'");
        stringBuffer2.append(">");
        wl wlVar = gVar.field_favProto;
        StringBuilder stringBuilder = new StringBuilder();
        if (!bi.oW(wlVar.title)) {
            stringBuilder.append("<title>").append(bi.WS(wlVar.title)).append("</title>");
        }
        if (!bi.oW(wlVar.desc)) {
            stringBuilder.append("<desc>").append(bi.WS(wlVar.desc)).append("</desc>");
        }
        if (wlVar.qYb > 0) {
            stringBuilder.append("<edittime>").append(wlVar.qYb).append("</edittime>");
        }
        if (!bi.oW(wlVar.fky)) {
            stringBuilder.append("<remark ");
            if (wlVar.rAU > 0) {
                stringBuilder.append(" time ='").append(wlVar.rAU).append("'");
            }
            stringBuilder.append(">").append(bi.WS(wlVar.fky)).append("</remark>");
        }
        if (wlVar.rAX) {
            stringBuilder.append("<ctrlflag>").append(wlVar.rAW).append("</ctrlflag>");
        }
        if (wlVar.rBK) {
            stringBuilder.append("<version>").append(wlVar.version).append("</version>");
        } else if (gVar.field_type == 18) {
            stringBuilder.append("<version>1</version>");
        }
        wr wrVar = wlVar.rBG;
        if (wrVar == null || wrVar.boi() == 0) {
            x.w("MicroMsg.FavSourceItemParser", "klem toXml, source item empty");
            str = "";
        } else {
            stringBuffer = new StringBuffer();
            stringBuffer.append("<source");
            if (wrVar.rBc) {
                stringBuffer.append(" sourcetype='").append(wrVar.bJt).append("'");
            }
            if (wrVar.rBR) {
                stringBuffer.append(" sourceid='").append(wrVar.rBQ).append("'");
            }
            stringBuffer.append(">");
            if (wrVar.rBd) {
                stringBuffer.append("<fromusr>").append(bi.WS(wrVar.bSS)).append("</fromusr>");
            }
            if (wrVar.rBe) {
                stringBuffer.append("<tousr>").append(bi.WS(wrVar.toUser)).append("</tousr>");
            }
            if (wrVar.rBi) {
                stringBuffer.append("<realchatname>").append(bi.WS(wrVar.rBh)).append("</realchatname>");
            }
            if (wrVar.rBj) {
                stringBuffer.append("<msgid>").append(wrVar.bWQ).append("</msgid>");
            }
            if (wrVar.rBk) {
                stringBuffer.append("<eventid>").append(wrVar.cca).append("</eventid>");
            }
            if (wrVar.rBl) {
                stringBuffer.append("<appid>").append(wrVar.appId).append("</appid>");
            }
            if (wrVar.rBm) {
                stringBuffer.append("<link>").append(bi.WS(wrVar.egr)).append("</link>");
            }
            if (wrVar.rBp) {
                stringBuffer.append("<brandid>").append(bi.WS(wrVar.bGy)).append("</brandid>");
            }
            stringBuffer.append("</source>");
            str = stringBuffer.toString();
        }
        stringBuilder.append(str);
        stringBuilder.append(com.tencent.mm.plugin.fav.a.a.a.bc(wlVar.rBI));
        we weVar = gVar.field_favProto.rAL;
        if (weVar == null || weVar.boi() == 0) {
            x.d("MicroMsg.FavLocItemParser", "klem toXml, loc item empty");
            str = "";
        } else {
            stringBuffer = new StringBuffer();
            stringBuffer.append("<locitem>");
            if (weVar.rBx) {
                stringBuffer.append("<label>").append(bi.WS(weVar.label)).append("</label>");
            }
            if (weVar.rBv) {
                stringBuffer.append("<lat>").append(weVar.lat).append("</lat>");
            }
            if (weVar.rBu) {
                stringBuffer.append("<lng>").append(weVar.lng).append("</lng>");
            }
            if (weVar.rBw) {
                stringBuffer.append("<scale>").append(weVar.bSz).append("</scale>");
            }
            if (weVar.rBy) {
                stringBuffer.append("<poiname>").append(weVar.bWB).append("</poiname>");
            }
            stringBuffer.append("</locitem>");
            str = stringBuffer.toString();
        }
        stringBuilder.append(str);
        xa xaVar = gVar.field_favProto.rAN;
        if (xaVar == null || xaVar.boi() == 0) {
            x.d("MicroMsg.FavUrlItemParser", "klem toXml, url item empty");
            str = "";
        } else {
            stringBuffer = new StringBuffer();
            stringBuffer.append("<weburlitem>");
            if (xaVar.rCo) {
                stringBuffer.append("<clean_url>").append(bi.WS(xaVar.rCn)).append("</clean_url>");
            }
            if (xaVar.rzi) {
                stringBuffer.append("<pagedesc>").append(bi.WS(xaVar.desc)).append("</pagedesc>");
            }
            if (xaVar.rBD) {
                stringBuffer.append("<pagethumb_url>").append(bi.WS(xaVar.thumbUrl)).append("</pagethumb_url>");
            }
            if (xaVar.rzh) {
                stringBuffer.append("<pagetitle>").append(bi.WS(xaVar.title)).append("</pagetitle>");
            }
            if (xaVar.rCq) {
                stringBuffer.append("<opencache>").append(xaVar.rCp).append("</opencache>");
            }
            if (xaVar.rCr) {
                stringBuffer.append("<contentattr>").append(xaVar.dwt).append("</contentattr>");
            }
            if (xaVar.rAt) {
                stringBuffer.append("<canvasPageXml>").append(xaVar.canvasPageXml).append("</canvasPageXml>");
            }
            stringBuffer.append("</weburlitem>");
            str = stringBuffer.toString();
        }
        stringBuilder.append(str);
        wk wkVar = gVar.field_favProto.rAP;
        if (wkVar == null || wkVar.boi() == 0) {
            x.d("MicroMsg.FavProductItemParser", "klem toXml, product item empty");
            str = "";
        } else {
            stringBuffer = new StringBuffer();
            stringBuffer.append("<productitem");
            if (wkVar.rBF) {
                stringBuffer.append(" type='").append(wkVar.type).append("'");
            }
            stringBuffer.append(">");
            if (wkVar.rzh) {
                stringBuffer.append("<producttitle>").append(bi.WS(wkVar.title)).append("</producttitle>");
            }
            if (wkVar.rzi) {
                stringBuffer.append("<productdesc>").append(bi.WS(wkVar.desc)).append("</productdesc>");
            }
            if (wkVar.rBD) {
                stringBuffer.append("<productthumb_url>").append(bi.WS(wkVar.thumbUrl)).append("</productthumb_url>");
            }
            if (wkVar.rBE) {
                stringBuffer.append("<productinfo>").append(bi.WS(wkVar.info)).append("</productinfo>");
            }
            stringBuffer.append("</productitem>");
            str = stringBuffer.toString();
        }
        stringBuilder.append(str);
        wu wuVar = gVar.field_favProto.rAR;
        if (wuVar == null || wuVar.boi() == 0) {
            x.d("MicroMsg.FavTVItemParser", "klem toXml, product item empty");
            str = "";
        } else {
            stringBuffer = new StringBuffer();
            stringBuffer.append("<tvitem>");
            if (wuVar.rzh) {
                stringBuffer.append("<tvtitle>").append(bi.WS(wuVar.title)).append("</tvtitle>");
            }
            if (wuVar.rzi) {
                stringBuffer.append("<tvdesc>").append(bi.WS(wuVar.desc)).append("</tvdesc>");
            }
            if (wuVar.rBD) {
                stringBuffer.append("<tvthumb_url>").append(bi.WS(wuVar.thumbUrl)).append("</tvthumb_url>");
            }
            if (wuVar.rBE) {
                stringBuffer.append("<tvinfo>").append(bi.WS(wuVar.info)).append("</tvinfo>");
            }
            stringBuffer.append("</tvitem>");
            str = stringBuffer.toString();
        }
        stringBuilder.append(str);
        wf wfVar = wlVar.qYa;
        if (wfVar == null || wfVar.boi() == 0) {
            x.w("MicroMsg.FavNoteInfoItemParser", "klem toXml, source item empty");
            str = "";
        } else {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("<noteinfo>");
            stringBuffer3.append("<noteauthor>").append(bi.WS(wfVar.rBz)).append("</noteauthor>");
            stringBuffer3.append("<noteeditor>").append(bi.WS(wfVar.rBA)).append("</noteeditor>");
            stringBuffer3.append("</noteinfo>");
            str = stringBuffer3.toString();
        }
        stringBuilder.append(str);
        stringBuffer2.append(stringBuilder.toString());
        stringBuffer2.append(c.a(gVar.field_tagProto));
        stringBuffer2.append("</favitem>");
        return stringBuffer2.toString();
    }

    /* renamed from: aLk */
    public final g clone() {
        g gVar = new g();
        gVar.field_favProto = this.field_favProto;
        gVar.field_sourceId = this.field_sourceId;
        gVar.field_edittime = this.field_edittime;
        gVar.field_ext = this.field_ext;
        gVar.field_flag = this.field_flag;
        gVar.field_fromUser = this.field_fromUser;
        gVar.field_id = this.field_id;
        gVar.field_itemStatus = this.field_itemStatus;
        gVar.field_localId = this.field_localId;
        gVar.field_localSeq = this.field_localSeq;
        gVar.field_realChatName = this.field_realChatName;
        gVar.field_tagProto = this.field_tagProto;
        gVar.field_sourceCreateTime = this.field_sourceCreateTime;
        gVar.field_updateSeq = this.field_updateSeq;
        gVar.field_toUser = this.field_toUser;
        gVar.field_updateTime = this.field_updateTime;
        gVar.field_type = this.field_type;
        gVar.field_xml = this.field_xml;
        gVar.field_datatotalsize = this.field_datatotalsize;
        return gVar;
    }

    public final boolean aLl() {
        Iterator it = this.field_favProto.rBI.iterator();
        while (it.hasNext()) {
            if (((vx) it.next()).rAA != 0) {
                return true;
            }
        }
        return false;
    }
}
