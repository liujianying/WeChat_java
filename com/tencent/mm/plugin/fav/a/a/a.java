package com.tencent.mm.plugin.fav.a.a;

import com.tencent.mm.protocal.c.vv;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.vy;
import com.tencent.mm.protocal.c.vz;
import com.tencent.mm.protocal.c.wa;
import com.tencent.mm.protocal.c.we;
import com.tencent.mm.protocal.c.wk;
import com.tencent.mm.protocal.c.wu;
import com.tencent.mm.protocal.c.xa;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class a {
    public static String bc(List<vx> list) {
        if (list == null || list.size() == 0) {
            x.v("MicroMsg.FavDataItemParser", "klem toXml data list empty");
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
                stringBuffer.append(" htmlid='").append(bi.WS(vxVar.rAq)).append("'");
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
                stringBuffer.append("<cdn_thumburl>").append(bi.WS(vxVar.dwE)).append("</cdn_thumburl>");
            }
            if (vxVar.rzm) {
                stringBuffer.append("<thumb_width>").append(vxVar.dwJ).append("</thumb_width>");
            }
            if (vxVar.rzn) {
                stringBuffer.append("<thumb_height>").append(vxVar.dwI).append("</thumb_height>");
            }
            if (vxVar.rzp) {
                stringBuffer.append("<cdn_dataurl>").append(bi.WS(vxVar.rzo)).append("</cdn_dataurl>");
            }
            if (vxVar.rzl) {
                stringBuffer.append("<cdn_thumbkey>").append(bi.WS(vxVar.rzk)).append("</cdn_thumbkey>");
            }
            if (vxVar.rzr) {
                stringBuffer.append("<cdn_datakey>").append(bi.WS(vxVar.rzq)).append("</cdn_datakey>");
            }
            if (vxVar.rzt) {
                stringBuffer.append("<cdn_encryver>").append(vxVar.rzs).append("</cdn_encryver>");
            }
            if (vxVar.rzu) {
                stringBuffer.append("<duration>").append(vxVar.duration).append("</duration>");
            }
            if (vxVar.rzw) {
                stringBuffer.append("<stream_weburl>").append(bi.WS(vxVar.rzv)).append("</stream_weburl>");
            }
            if (vxVar.rzy) {
                stringBuffer.append("<stream_dataurl>").append(bi.WS(vxVar.rzx)).append("</stream_dataurl>");
            }
            if (vxVar.rzA) {
                stringBuffer.append("<stream_lowbandurl>").append(bi.WS(vxVar.rzz)).append("</stream_lowbandurl>");
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
                stringBuffer.append("<fullsize>").append(vxVar.rzJ).append("</fullsize>");
            }
            if (vxVar.rzR) {
                stringBuffer.append("<thumbfullmd5>").append(vxVar.rzQ).append("</thumbfullmd5>");
            }
            if (vxVar.rzT) {
                stringBuffer.append("<thumbhead256md5>").append(vxVar.rzS).append("</thumbhead256md5>");
            }
            if (vxVar.rzV) {
                stringBuffer.append("<thumbfullsize>").append(vxVar.rzU).append("</thumbfullsize>");
            }
            if (vxVar.rzZ) {
                stringBuffer.append("<stream_videoid>").append(bi.WS(vxVar.rzY)).append("</stream_videoid>");
            }
            if (vxVar.rAh) {
                stringBuffer.append("<datasrctitle>").append(bi.WS(vxVar.rAg)).append("</datasrctitle>");
            }
            if (vxVar.rAl) {
                stringBuffer.append("<datasrcname>").append(bi.WS(vxVar.rAk)).append("</datasrcname>");
            }
            if (vxVar.rAn) {
                stringBuffer.append("<datasrctime>").append(bi.WS(vxVar.rAm)).append("</datasrctime>");
            }
            if (vxVar.rAt && (vxVar.rAi == null || vxVar.rAi.rAN == null || vxVar.rAi.rAN.boi() == 0)) {
                stringBuffer.append("<canvasPageXml>").append(bi.WS(vxVar.canvasPageXml)).append("</canvasPageXml>");
            }
            if (vxVar.rAs) {
                stringBuffer.append("<statextstr>").append(bi.WS(vxVar.bZN)).append("</statextstr>");
            }
            if (vxVar.rAz) {
                stringBuffer.append("<recordxml>").append(vxVar.rAy).append("</recordxml>");
            }
            wa waVar = vxVar.rAo;
            if (waVar != null) {
                stringBuffer.append("<streamvideo>");
                stringBuffer.append("<streamvideourl>").append(bi.WS(waVar.dyJ)).append("</streamvideourl>");
                stringBuffer.append("<streamvideototaltime>").append(waVar.rBq).append("</streamvideototaltime>");
                stringBuffer.append("<streamvideotitle>").append(bi.WS(waVar.dyL)).append("</streamvideotitle>");
                stringBuffer.append("<streamvideowording>").append(bi.WS(waVar.dyM)).append("</streamvideowording>");
                stringBuffer.append("<streamvideoweburl>").append(bi.WS(waVar.dyN)).append("</streamvideoweburl>");
                stringBuffer.append("<streamvideoaduxinfo>").append(bi.WS(waVar.dyP)).append("</streamvideoaduxinfo>");
                stringBuffer.append("<streamvideopublishid>").append(bi.WS(waVar.dyQ)).append("</streamvideopublishid>");
                stringBuffer.append("</streamvideo>");
            }
            vy vyVar = vxVar.rAi;
            if (vyVar == null || vyVar.rAJ == null || vyVar.rAJ.boi() == 0) {
                x.v("MicroMsg.FavDataItemParser", "klem toXml, data source item empty");
            } else {
                vz vzVar = vyVar.rAJ;
                stringBuffer.append("<dataitemsource");
                if (vzVar.rBc) {
                    stringBuffer.append(" sourcetype='").append(vzVar.bJt).append("'");
                }
                if (vzVar.rBg) {
                    stringBuffer.append(" sourceid='").append(vzVar.rBf).append("'");
                }
                stringBuffer.append(">");
                if (vzVar.rBd) {
                    stringBuffer.append("<fromusr>").append(bi.WS(vzVar.bSS)).append("</fromusr>");
                }
                if (vzVar.rBe) {
                    stringBuffer.append("<tousr>").append(bi.WS(vzVar.toUser)).append("</tousr>");
                }
                if (vzVar.rBi) {
                    stringBuffer.append("<realchatname>").append(bi.WS(vzVar.rBh)).append("</realchatname>");
                }
                if (vzVar.rBj) {
                    stringBuffer.append("<msgid>").append(vzVar.bWQ).append("</msgid>");
                }
                if (vzVar.rBk) {
                    stringBuffer.append("<eventid>").append(vzVar.cca).append("</eventid>");
                }
                if (vzVar.rBl) {
                    stringBuffer.append("<appid>").append(vzVar.appId).append("</appid>");
                }
                if (vzVar.rBm) {
                    stringBuffer.append("<link>").append(bi.WS(vzVar.egr)).append("</link>");
                }
                if (vzVar.rBp) {
                    stringBuffer.append("<brandid>").append(bi.WS(vzVar.bGy)).append("</brandid>");
                }
                stringBuffer.append("</dataitemsource>");
            }
            vyVar = vxVar.rAi;
            if (vyVar == null || vyVar.rAL == null || vyVar.rAL.boi() == 0) {
                x.v("MicroMsg.FavDataItemParser", "klem toXml, loc item empty");
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
                x.v("MicroMsg.FavDataItemParser", "klem toXml, url item empty");
            } else {
                xa xaVar = vyVar.rAN;
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
                    stringBuffer.append("<canvasPageXml>").append(bi.WS(xaVar.canvasPageXml)).append("</canvasPageXml>");
                }
                stringBuffer.append("</weburlitem>");
            }
            vyVar = vxVar.rAi;
            if (vyVar == null || vyVar.rAP == null || vyVar.rAP.boi() == 0) {
                x.v("MicroMsg.FavDataItemParser", "klem toXml, product item empty");
            } else {
                wk wkVar = vyVar.rAP;
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
            }
            vyVar = vxVar.rAi;
            if (vyVar == null || vyVar.rAR == null || vyVar.rAR.boi() == 0) {
                x.v("MicroMsg.FavDataItemParser", "klem toXml, product item empty");
            } else {
                wu wuVar = vyVar.rAR;
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
            }
            vy vyVar2 = vxVar.rAi;
            if (vyVar2 == null || vyVar2.rBa == null) {
                x.e("MicroMsg.FavDataItemParser", "setAppBrandXml toXml, item empty");
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
