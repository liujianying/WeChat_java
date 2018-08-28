package com.tencent.mm.plugin.fav.a.a;

import com.tencent.mm.protocal.c.vv;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.vy;
import com.tencent.mm.protocal.c.vz;
import com.tencent.mm.protocal.c.wa;
import com.tencent.mm.protocal.c.we;
import com.tencent.mm.protocal.c.wk;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.protocal.c.wu;
import com.tencent.mm.protocal.c.xa;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayInputStream;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class b {
    public static void a(String str, wl wlVar) {
        wlVar.rBI.clear();
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(str.getBytes())));
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("datalist");
            if (elementsByTagName != null) {
                NodeList childNodes = elementsByTagName.item(0).getChildNodes();
                if (childNodes != null && childNodes.getLength() > 0) {
                    int length = childNodes.getLength();
                    for (int i = 0; i < length; i++) {
                        String str2;
                        Map z;
                        Node item = childNodes.item(i);
                        String b = bl.b(item);
                        NodeList elementsByTagName2 = ((Element) item).getElementsByTagName("recordxml");
                        if (elementsByTagName2 == null || elementsByTagName2.getLength() <= 0) {
                            str2 = null;
                        } else {
                            str2 = bl.b(elementsByTagName2.item(0).getFirstChild());
                        }
                        if (b.trim().startsWith("<dataitem")) {
                            z = bl.z(b, "dataitem");
                        } else {
                            z = null;
                        }
                        if (z != null) {
                            vx vxVar = new vx();
                            String str3 = ".dataitem";
                            vxVar.CF(bi.getInt((String) z.get(str3 + ".$datatype"), 0));
                            vxVar.UT((String) z.get(str3 + ".$datasourceid"));
                            vxVar.CG(bi.getInt((String) z.get(str3 + ".$datastatus"), 0));
                            vxVar.UL((String) z.get(str3 + ".datafmt"));
                            vxVar.UB((String) z.get(str3 + ".datatitle"));
                            vxVar.UC((String) z.get(str3 + ".datadesc"));
                            vxVar.UD((String) z.get(str3 + ".cdn_thumburl"));
                            vxVar.UE((String) z.get(str3 + ".cdn_thumbkey"));
                            vxVar.CC(bi.getInt((String) z.get(str3 + ".thumb_width"), 0));
                            vxVar.CD(bi.getInt((String) z.get(str3 + ".thumb_height"), 0));
                            vxVar.UF((String) z.get(str3 + ".cdn_dataurl"));
                            vxVar.UG((String) z.get(str3 + ".cdn_datakey"));
                            String str4 = (String) z.get(str3 + ".duration");
                            if (str4 != null && str4.length() > 0) {
                                vxVar.CE(bi.getInt(str4, 0));
                            }
                            vxVar.UI((String) z.get(str3 + ".stream_dataurl"));
                            vxVar.UJ((String) z.get(str3 + ".stream_lowbandurl"));
                            vxVar.UH((String) z.get(str3 + ".stream_weburl"));
                            vxVar.Va((String) z.get(str3 + ".canvasPageXml"));
                            vxVar.UM((String) z.get(str3 + ".fullmd5"));
                            vxVar.UN((String) z.get(str3 + ".head256md5"));
                            str4 = (String) z.get(str3 + ".fullsize");
                            if (!bi.oW(str4)) {
                                vxVar.fO((long) bi.getInt(str4, 0));
                            }
                            vxVar.UK((String) z.get(str3 + ".dataext"));
                            vxVar.UR((String) z.get(str3 + ".thumbfullmd5"));
                            vxVar.US((String) z.get(str3 + ".thumbhead256md5"));
                            str4 = (String) z.get(str3 + ".thumbfullsize");
                            if (!bi.oW(str4)) {
                                vxVar.fP((long) bi.getInt(str4, 0));
                            }
                            vxVar.UU((String) z.get(str3 + ".stream_videoid"));
                            str4 = (String) z.get(str3 + ".$dataid");
                            if (bi.oW(str4) || str4.length() < 32) {
                                str4 = com.tencent.mm.plugin.fav.a.b.bm(vxVar.toString(), vxVar.bjS);
                            }
                            vxVar.UO(str4);
                            vxVar.UV((String) z.get(str3 + ".datasrctitle"));
                            vxVar.UW((String) z.get(str3 + ".datasrcname"));
                            vxVar.UX((String) z.get(str3 + ".datasrctime"));
                            vxVar.UZ((String) z.get(str3 + ".statextstr"));
                            vxVar.UY((String) z.get(str3 + ".$htmlid"));
                            vxVar.CH(bi.getInt((String) z.get(str3 + ".$dataillegaltype"), 0));
                            if (str2 != null) {
                                vxVar.Vb(str2);
                            }
                            wa waVar = new wa();
                            waVar.dyJ = bi.aG((String) z.get(str3 + ".streamvideo.streamvideourl"), "");
                            waVar.rBq = bi.WU((String) z.get(str3 + ".streamvideo.streamvideototaltime"));
                            waVar.dyL = bi.aG((String) z.get(str3 + ".streamvideo.streamvideotitle"), "");
                            waVar.dyM = bi.aG((String) z.get(str3 + ".streamvideo.streamvideowording"), "");
                            waVar.dyN = bi.aG((String) z.get(str3 + ".streamvideo.streamvideoweburl"), "");
                            waVar.dyP = bi.aG((String) z.get(str3 + ".streamvideo.streamvideoaduxinfo"), "");
                            waVar.dyQ = bi.aG((String) z.get(str3 + ".streamvideo.streamvideopublishid"), "");
                            vxVar.a(waVar);
                            vy vyVar = new vy();
                            String str5 = str3 + ".dataitemsource";
                            if (z.containsKey(str5)) {
                                vz vzVar = new vz();
                                vzVar.CJ(bi.getInt((String) z.get(str5 + ".$sourcetype"), 0));
                                vzVar.Vh((String) z.get(str5 + ".$sourceid"));
                                vzVar.Vf((String) z.get(str5 + ".fromusr"));
                                vzVar.Vg((String) z.get(str5 + ".tousr"));
                                vzVar.Vi((String) z.get(str5 + ".realchatname"));
                                vzVar.fR(bi.getLong((String) z.get(str5 + ".createtime"), 0));
                                vzVar.Vj((String) z.get(str5 + ".msgid"));
                                vzVar.cca = (String) z.get(str5 + ".eventid");
                                vzVar.rBk = true;
                                vzVar.Vk((String) z.get(str5 + ".appid"));
                                vzVar.Vl((String) z.get(str5 + ".link"));
                                vzVar.Vm((String) z.get(str5 + ".brandid"));
                                vyVar.c(vzVar);
                            } else {
                                x.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[]{str5});
                            }
                            str5 = str3 + ".locitem";
                            if (z.containsKey(str5)) {
                                we weVar = new we();
                                if (!bi.oW((String) z.get(str5 + ".label"))) {
                                    weVar.Vn((String) z.get(str5 + ".label"));
                                }
                                if (!bi.oW((String) z.get(str5 + ".poiname"))) {
                                    weVar.Vo((String) z.get(str5 + ".poiname"));
                                }
                                str4 = (String) z.get(str5 + ".lng");
                                if (!bi.oW(str4)) {
                                    weVar.y(bi.getDouble(str4, 0.0d));
                                }
                                str4 = (String) z.get(str5 + ".lat");
                                if (!bi.oW(str4)) {
                                    weVar.z(bi.getDouble(str4, 0.0d));
                                }
                                str4 = (String) z.get(str5 + ".scale");
                                if (!bi.oW(str4)) {
                                    if (str4.indexOf(46) != -1) {
                                        weVar.CK(bi.getInt(str4.substring(0, str4.indexOf(46)), -1));
                                    } else {
                                        weVar.CK(bi.getInt(str4, -1));
                                    }
                                }
                                vyVar.a(weVar);
                            } else {
                                x.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[]{str5});
                            }
                            str5 = str3 + ".weburlitem";
                            if (z.containsKey(str5)) {
                                xa xaVar = new xa();
                                xaVar.VL((String) z.get(str5 + ".clean_url"));
                                xaVar.VK((String) z.get(str5 + ".pagedesc"));
                                xaVar.VM((String) z.get(str5 + ".pagethumb_url"));
                                xaVar.VJ((String) z.get(str5 + ".pagetitle"));
                                xaVar.CP(bi.getInt((String) z.get(str5 + ".opencache"), 0));
                                xaVar.CQ(bi.getInt((String) z.get(str5 + ".contentattr"), 0));
                                xaVar.VN((String) z.get(str5 + ".canvasPageXml"));
                                vyVar.a(xaVar);
                            } else {
                                x.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[]{str5});
                            }
                            str5 = str3 + ".productitem";
                            if (z.containsKey(str5)) {
                                wk wkVar = new wk();
                                wkVar.Vp((String) z.get(str5 + ".producttitle"));
                                wkVar.Vq((String) z.get(str5 + ".productdesc"));
                                wkVar.Vr((String) z.get(str5 + ".productthumb_url"));
                                wkVar.Vs((String) z.get(str5 + ".productinfo"));
                                wkVar.CL(bi.getInt((String) z.get(str5 + ".$type"), 0));
                                vyVar.a(wkVar);
                            } else {
                                x.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[]{str5});
                            }
                            str5 = str3 + ".tvitem";
                            if (z.containsKey(str5)) {
                                wu wuVar = new wu();
                                wuVar.VF((String) z.get(str5 + ".tvtitle"));
                                wuVar.VG((String) z.get(str5 + ".tvdesc"));
                                wuVar.VH((String) z.get(str5 + ".tvthumb_url"));
                                wuVar.VI((String) z.get(str5 + ".tvinfo"));
                                vyVar.a(wuVar);
                            } else {
                                x.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[]{str5});
                            }
                            str3 = str3 + ".appbranditem";
                            if (z.containsKey(str3)) {
                                vv vvVar = new vv();
                                vvVar.username = (String) z.get(str3 + ".username");
                                vvVar.appId = (String) z.get(str3 + ".appid");
                                vvVar.bPh = bi.getInt((String) z.get(str3 + ".pkgtype"), 0);
                                vvVar.iconUrl = (String) z.get(str3 + ".iconurl");
                                vvVar.type = bi.getInt((String) z.get(str3 + ".type"), 0);
                                vvVar.bGH = (String) z.get(str3 + ".pagepath");
                                vvVar.rzd = (String) z.get(str3 + ".sourcedisplayname");
                                vyVar.a(vvVar);
                            } else {
                                x.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[]{str3});
                            }
                            vxVar.a(vyVar);
                            wlVar.rBI.add(vxVar);
                        }
                    }
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.FavProtoItemParser", "[parser] parseXML exception:%s", new Object[]{e.toString()});
        }
    }
}
