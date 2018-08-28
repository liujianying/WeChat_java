package com.tencent.mm.plugin.record.b;

import com.tencent.mm.ac.a.e;
import com.tencent.mm.model.s;
import com.tencent.mm.protocal.c.vv;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.vy;
import com.tencent.mm.protocal.c.vz;
import com.tencent.mm.protocal.c.we;
import com.tencent.mm.protocal.c.wk;
import com.tencent.mm.protocal.c.wu;
import com.tencent.mm.protocal.c.xa;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class i {
    public static String bc(List<vx> list) {
        if (list == null || list.size() == 0) {
            x.w("MicroMsg.RecordMsgParser", "klem toXml data list empty");
            return "";
        }
        int size = list.size();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<datalist count='").append(size).append("'>");
        for (int i = 0; i < size; i++) {
            vx vxVar = (vx) list.get(i);
            stringBuffer.append("<dataitem ");
            if (vxVar.rzC) {
                stringBuffer.append("datatype='").append(vxVar.bjS).append("'");
            }
            if (vxVar.rAf) {
                stringBuffer.append(" datastatus='").append(vxVar.rAe).append("'");
            }
            if (vxVar.rzL) {
                stringBuffer.append(" dataid='").append(vxVar.jdM).append("'");
            }
            if (vxVar.rAr) {
                stringBuffer.append(" htmlid='").append(vxVar.rAq).append("'");
            }
            if (vxVar.rAx) {
                stringBuffer.append(" dataillegaltype='").append(vxVar.rAw).append("'");
            }
            if (vxVar.rzX) {
                stringBuffer.append(" datasourceid='").append(vxVar.rzW).append("'");
            }
            stringBuffer.append(">");
            if (vxVar.rzE) {
                stringBuffer.append("<datafmt>").append(vxVar.rzD).append("</datafmt>");
            }
            if (vxVar.rzh) {
                stringBuffer.append("<datatitle>").append(bi.WS(vxVar.title)).append("</datatitle>");
            }
            if (vxVar.rzi) {
                stringBuffer.append("<datadesc>").append(bi.WS(vxVar.desc)).append("</datadesc>");
            }
            if (vxVar.rzj) {
                stringBuffer.append("<cdnthumburl>").append(bi.WS(vxVar.dwE)).append("</cdnthumburl>");
            }
            if (vxVar.rzm) {
                stringBuffer.append("<thumbwidth>").append(vxVar.dwJ).append("</thumbwidth>");
            }
            if (vxVar.rzn) {
                stringBuffer.append("<thumbheight>").append(vxVar.dwI).append("</thumbheight>");
            }
            if (vxVar.rzp) {
                stringBuffer.append("<cdndataurl>").append(bi.WS(vxVar.rzo)).append("</cdndataurl>");
            }
            if (vxVar.rzl) {
                stringBuffer.append("<cdnthumbkey>").append(bi.WS(vxVar.rzk)).append("</cdnthumbkey>");
            }
            if (vxVar.rzr) {
                stringBuffer.append("<cdndatakey>").append(bi.WS(vxVar.rzq)).append("</cdndatakey>");
            }
            if (vxVar.rzt) {
                stringBuffer.append("<cdnencryver>").append(vxVar.rzs).append("</cdnencryver>");
            }
            if (vxVar.rzu) {
                stringBuffer.append("<duration>").append(vxVar.duration).append("</duration>");
            }
            if (vxVar.rzw) {
                stringBuffer.append("<streamweburl>").append(bi.WS(vxVar.rzv)).append("</streamweburl>");
            }
            if (vxVar.rzy) {
                stringBuffer.append("<streamdataurl>").append(bi.WS(vxVar.rzx)).append("</streamdataurl>");
            }
            if (vxVar.rzA) {
                stringBuffer.append("<streamlowbandurl>").append(bi.WS(vxVar.rzz)).append("</streamlowbandurl>");
            }
            if (vxVar.rzB) {
                stringBuffer.append("<dataext>").append(bi.WS(vxVar.bJv)).append("</dataext>");
            }
            if (vxVar.rzG) {
                stringBuffer.append("<fullmd5>").append(vxVar.rzF).append("</fullmd5>");
            }
            if (vxVar.rzI) {
                stringBuffer.append("<head256md5>").append(vxVar.rzH).append("</head256md5>");
            }
            if (vxVar.rzK) {
                stringBuffer.append("<datasize>").append(vxVar.rzJ).append("</datasize>");
            }
            if (vxVar.rzR) {
                stringBuffer.append("<thumbfullmd5>").append(vxVar.rzQ).append("</thumbfullmd5>");
            }
            if (vxVar.rzT) {
                stringBuffer.append("<thumbhead256md5>").append(vxVar.rzS).append("</thumbhead256md5>");
            }
            if (vxVar.rzV) {
                stringBuffer.append("<thumbsize>").append(vxVar.rzU).append("</thumbsize>");
            }
            if (vxVar.rzZ) {
                stringBuffer.append("<streamvideoid>").append(bi.WS(vxVar.rzY)).append("</streamvideoid>");
            }
            if (vxVar.rAh) {
                stringBuffer.append("<sourcetitle>").append(bi.WS(vxVar.rAg)).append("</sourcetitle>");
            }
            if (vxVar.rAl) {
                stringBuffer.append("<sourcename>").append(bi.WS(vxVar.rAk)).append("</sourcename>");
            }
            if (vxVar.rAn) {
                stringBuffer.append("<sourcetime>").append(bi.WS(vxVar.rAm)).append("</sourcetime>");
            }
            if (vxVar.rAs) {
                stringBuffer.append("<statextstr>").append(bi.WS(vxVar.bZN)).append("</statextstr>");
            }
            if (vxVar.rAz) {
                stringBuffer.append("<recordxml>").append(vxVar.rAy).append("</recordxml>");
            }
            vy vyVar = vxVar.rAi;
            if (vyVar == null || vyVar.rAJ == null || vyVar.rAJ.boi() == 0) {
                x.w("MicroMsg.RecordMsgParser", "klem toXml, data source item empty");
            } else {
                vz vzVar = vyVar.rAJ;
                if (vzVar.rBl) {
                    stringBuffer.append("<appid>").append(vzVar.appId).append("</appid>");
                }
                if (vzVar.rBm) {
                    stringBuffer.append("<link>").append(bi.WS(vzVar.egr)).append("</link>");
                }
                if (vzVar.rBp) {
                    stringBuffer.append("<brandid>").append(bi.WS(vzVar.bGy)).append("</brandid>");
                }
                if (vzVar.rBd && vzVar.rBi) {
                    if (vzVar.bSS.equals(vzVar.rBh)) {
                        stringBuffer.append("<dataitemsource><fromusr>").append(bi.WS(vzVar.bSS)).append("</fromusr></dataitemsource>");
                    } else if (s.fq(vzVar.bSS) || e.lb(vzVar.rBh)) {
                        stringBuffer.append("<dataitemsource><realchatname>").append(bi.WS(vzVar.rBh)).append("</realchatname></dataitemsource>");
                    }
                } else if (vzVar.rBd) {
                    stringBuffer.append("<dataitemsource><fromusr>").append(bi.WS(vzVar.bSS)).append("</fromusr></dataitemsource>");
                } else if (vzVar.rBi) {
                    stringBuffer.append("<dataitemsource><realchatname>").append(bi.WS(vzVar.rBh)).append("</realchatname></dataitemsource>");
                }
            }
            vyVar = vxVar.rAi;
            if (vyVar == null || vyVar.rAL == null || vyVar.rAL.boi() == 0) {
                x.w("MicroMsg.RecordMsgParser", "klem toXml, loc item empty");
            } else {
                we weVar = vyVar.rAL;
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
            }
            vyVar = vxVar.rAi;
            if (vyVar == null || vyVar.rAN == null || vyVar.rAN.boi() == 0) {
                x.w("MicroMsg.RecordMsgParser", "klem toXml, url item empty");
            } else {
                xa xaVar = vyVar.rAN;
                stringBuffer.append("<weburlitem>");
                if (xaVar.rCo) {
                    stringBuffer.append("<link>").append(bi.WS(xaVar.rCn)).append("</link>");
                }
                if (xaVar.rzi) {
                    stringBuffer.append("<desc>").append(bi.WS(xaVar.desc)).append("</desc>");
                }
                if (xaVar.rBD) {
                    stringBuffer.append("<thumburl>").append(bi.WS(xaVar.thumbUrl)).append("</thumburl>");
                }
                if (xaVar.rzh) {
                    stringBuffer.append("<title>").append(bi.WS(xaVar.title)).append("</title>");
                }
                if (xaVar.rCq) {
                    stringBuffer.append("<opencache>").append(xaVar.rCp).append("</opencache>");
                }
                if (xaVar.rCr) {
                    stringBuffer.append("<contentattr>").append(xaVar.dwt).append("</contentattr>");
                }
                stringBuffer.append("</weburlitem>");
            }
            vyVar = vxVar.rAi;
            if (vyVar == null || vyVar.rAP == null || vyVar.rAP.boi() == 0) {
                x.w("MicroMsg.RecordMsgParser", "klem toXml, product item empty");
            } else {
                wk wkVar = vyVar.rAP;
                stringBuffer.append("<productitem");
                if (wkVar.rBF) {
                    stringBuffer.append(" type='").append(wkVar.type).append("'");
                }
                stringBuffer.append(">");
                if (wkVar.rzh) {
                    stringBuffer.append("<title>").append(bi.WS(wkVar.title)).append("</title>");
                }
                if (wkVar.rzi) {
                    stringBuffer.append("<desc>").append(bi.WS(wkVar.desc)).append("</desc>");
                }
                if (wkVar.rBD) {
                    stringBuffer.append("<thumburl>").append(bi.WS(wkVar.thumbUrl)).append("</thumburl>");
                }
                if (wkVar.rBE) {
                    stringBuffer.append("<productinfo>").append(bi.WS(wkVar.info)).append("</productinfo>");
                }
                stringBuffer.append("</productitem>");
            }
            vyVar = vxVar.rAi;
            if (vyVar == null || vyVar.rAR == null || vyVar.rAR.boi() == 0) {
                x.w("MicroMsg.RecordMsgParser", "klem toXml, product item empty");
            } else {
                wu wuVar = vyVar.rAR;
                stringBuffer.append("<tvitem>");
                if (wuVar.rzh) {
                    stringBuffer.append("<title>").append(bi.WS(wuVar.title)).append("</title>");
                }
                if (wuVar.rzi) {
                    stringBuffer.append("<desc>").append(bi.WS(wuVar.desc)).append("</desc>");
                }
                if (wuVar.rBD) {
                    stringBuffer.append("<thumburl>").append(bi.WS(wuVar.thumbUrl)).append("</thumburl>");
                }
                if (wuVar.rBE) {
                    stringBuffer.append("<tvinfo>").append(bi.WS(wuVar.info)).append("</tvinfo>");
                }
                stringBuffer.append("</tvitem>");
            }
            vy vyVar2 = vxVar.rAi;
            if (vyVar2 == null || vyVar2.rBa == null) {
                x.e("MicroMsg.RecordMsgParser", "setAppBrandXml toXml, item empty");
            } else {
                vv vvVar = vyVar2.rBa;
                if (vvVar != null) {
                    stringBuffer.append("<appbranditem>");
                    stringBuffer.append("<username>").append(bi.WS(vvVar.username)).append("</username>");
                    stringBuffer.append("<appid>").append(bi.WS(vvVar.appId)).append("</appid>");
                    stringBuffer.append("<pkgtype>").append(vvVar.bPh).append("</pkgtype>");
                    stringBuffer.append("<iconurl>").append(bi.WS(vvVar.iconUrl)).append("</iconurl>");
                    stringBuffer.append("<type>").append(vvVar.type).append("</type>");
                    stringBuffer.append("<pagepath>").append(bi.WS(vvVar.bGH)).append("</pagepath>");
                    stringBuffer.append("<sourcedisplayname>").append(bi.WS(vvVar.rzd)).append("</sourcedisplayname>");
                    stringBuffer.append("</appbranditem>");
                }
            }
            stringBuffer.append("</dataitem>");
        }
        stringBuffer.append("</datalist>");
        return stringBuffer.toString();
    }
}
