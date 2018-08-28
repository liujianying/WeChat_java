package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.mm.g.a.pq;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiLaunchMiniProgram;
import com.tencent.mm.plugin.sns.g.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.storage.c;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class g {
    private static int[] nlW = new int[]{50, 66, 68, 88, 99, 121, 123, JsApiLaunchMiniProgram.CTRL_INDEX, 168, 188, 199, 233, 266, 268, 288, 299, 369, 419, 520, 666, 1024};
    private static String nlq = "";
    private static g nlr = null;
    private StringBuffer gVP = new StringBuffer();
    public long hcQ = 0;
    public String nlA = "";
    public String nlB = "";
    public String nlC = "";
    public String nlD = "";
    public String nlE = "";
    public String nlF = "";
    public String nlG = "";
    public String nlH = "";
    public String nlI = "";
    public String nlJ = "";
    public String nlK = "";
    public String nlL = "";
    public String nlM = "";
    public String nlN = "";
    public String nlO = "";
    public String nlP = "";
    public String nlQ = "";
    public String nlR = "";
    public int nlS = -1;
    public String nlT = "";
    private List<List<Integer>> nlU = new LinkedList();
    private List<Integer> nlV = new LinkedList();
    private LinkedList<c> nlX = new LinkedList();
    public String nln = "";
    public long nlo = 0;
    public String nls = "";
    public int nlt = 0;
    public int nlu = 0;
    public long nlv = 0;
    public long nlw = 0;
    public String nlx = "";
    public long nly = 0;
    public long nlz = 0;

    public static g bxc() {
        com.tencent.mm.kernel.g.Ek();
        if (!com.tencent.mm.kernel.g.Eg().Dx()) {
            return new g();
        }
        c fJ = com.tencent.mm.model.c.c.Jx().fJ("100068");
        String str = fJ.field_rawXML;
        if (bi.oW(str)) {
            str = "";
        }
        String u = com.tencent.mm.a.g.u(str.getBytes());
        if (nlr == null || !u.equals(nlq)) {
            x.i("MicroMsg.NewYearSnsCtrlV2", "create newYearSnsCtrl");
            nlr = new g();
            try {
                Map ckq = fJ.ckq();
                str = "";
                if (ckq != null) {
                    str = (String) ckq.get("SnsHBConfig");
                }
                if (bi.oW(str)) {
                    str = "";
                }
                str = URLDecoder.decode(str, "UTF-8");
                g gVar = nlr;
                gVar.gVP = new StringBuffer();
                gVar.nlX.clear();
                Map z = bl.z(str, "sysmsg");
                if (z == null) {
                    x.i("MicroMsg.NewYearSnsCtrlV2", "errr for paser %s", new Object[]{str});
                } else {
                    gVar.nlo = bi.WV((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.BeginTime"));
                    gVar.gVP.append("BeginTime:" + gVar.nlo + ";");
                    gVar.hcQ = bi.WV((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.EndTime"));
                    gVar.gVP.append("EndTime:" + gVar.hcQ + ";\n");
                    gVar.nlt = bi.WU((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.SvrDownReqLimitLevelMin"));
                    gVar.nlu = bi.WU((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.SvrDownReqLimitLevelMax"));
                    gVar.gVP.append("SvrDownReqLimitLevelMin:" + gVar.nlt + " SvrDownReqLimitLevelMax: " + gVar.nlu + ";\n");
                    gVar.nly = bi.WV((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.BrowseBeginTime"));
                    gVar.nlz = bi.WV((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.BrowseEndTime"));
                    gVar.nlA = bi.aG((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenTitle"), "");
                    gVar.nlB = bi.aG((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenDescription"), "");
                    gVar.nlC = bi.aG((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenQueryTips"), "");
                    gVar.nlD = bi.aG((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenAcceptButtonText"), "");
                    gVar.nlE = bi.aG((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenRejectButtonText"), "");
                    gVar.nlF = bi.aG((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenTips"), "");
                    gVar.nlH = bi.aG((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenSuccTips"), "");
                    gVar.nlI = bi.aG((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenFailTips"), "");
                    gVar.nlG = bi.aG((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseTips"), "");
                    gVar.nlJ = bi.aG((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseSuccTips"), "");
                    gVar.nlK = bi.aG((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseFailTips"), "");
                    gVar.nlR = bi.aG((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.MaxPostFeedID"), "");
                    gVar.nlS = bi.WU((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.MaxPostFeedCount"));
                    gVar.nlT = bi.aG((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenID"), "");
                    if (gVar.nlS <= 0) {
                        x.i("MicroMsg.NewYearSnsCtrlV2", "svr MaxPostFeedCount error " + gVar.nlS);
                        gVar.nlS = 1;
                    }
                    gVar.gVP.append("FullScreenID:" + gVar.nlT + " BrowseBeginTime:" + gVar.nly + " BrowseEndTime:" + gVar.nlz + " FullScreenTitle:" + gVar.nlA + " FullScreenDescription:" + gVar.nlB + " FullScreenQueryTips:" + gVar.nlC + " FullScreenAcceptButtonText: " + gVar.nlD);
                    gVar.gVP.append("FullScreenRejectButtonText:" + gVar.nlE + " ActionSheetOpenTips:" + gVar.nlF + " ActionSheetOpenSuccTips:" + gVar.nlH + " ActionSheetOpenFailTips:" + gVar.nlI + " ActionSheetCloseTips:" + gVar.nlG + " ActionSheetCloseSuccTips: " + gVar.nlJ + " ActionSheetCloseFailTips: " + gVar.nlK + "MaxPostFeedID: " + gVar.nlR + " MaxPostFeedCount:" + gVar.nlS);
                    gVar.nlL = bi.aG((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForHasUsed"), "");
                    gVar.nlM = bi.aG((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForObtainUsedRight"), "");
                    gVar.nlN = bi.aG((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForClosedBrowseSwitch"), "");
                    gVar.nlO = bi.aG((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertButtonText"), "");
                    gVar.nlP = bi.aG((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.GoldenCameraTip"), "");
                    gVar.nlQ = bi.aG((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.GoldenCameraTipID"), "");
                    gVar.gVP.append("AlertTipForHasUsed:" + gVar.nlL + " AlertTipForObtainUsedRight:" + gVar.nlM + " AlertTipForClosedBrowseSwitch:" + gVar.nlN + " AlertButtonText:" + gVar.nlO + " GoldenCameraTip:" + gVar.nlP + " GoldenCameraTipID:" + gVar.nlQ);
                    int i = 0;
                    while (true) {
                        String str2 = ".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s";
                        Object[] objArr = new Object[2];
                        objArr[0] = i == 0 ? "" : String.valueOf(i);
                        objArr[1] = "RedPointID";
                        gVar.nln = bi.aG((String) z.get(String.format(str2, objArr)), "");
                        gVar.gVP.append("RedPointID:" + gVar.nln + ";");
                        if (bi.oW(gVar.nln)) {
                            break;
                        }
                        str2 = ".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s";
                        objArr = new Object[2];
                        objArr[0] = i == 0 ? "" : String.valueOf(i);
                        objArr[1] = "BeginTime";
                        gVar.nlv = bi.WV((String) z.get(String.format(str2, objArr)));
                        gVar.gVP.append("RedPointID_BeginTime:" + gVar.nlv + ";");
                        str2 = ".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s";
                        objArr = new Object[2];
                        objArr[0] = i == 0 ? "" : String.valueOf(i);
                        objArr[1] = "EndTime";
                        gVar.nlw = bi.WV((String) z.get(String.format(str2, objArr)));
                        gVar.gVP.append("RedPointID_EndTime:" + gVar.nlw + ";\n");
                        c cVar = new c();
                        cVar.nln = gVar.nln;
                        cVar.nlo = gVar.nlv;
                        cVar.hcQ = gVar.nlw;
                        gVar.nlX.add(cVar);
                        i++;
                    }
                    gVar.nlx = bi.aG((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.PostTips"), "");
                    gVar.gVP.append("PostTips:" + gVar.nlx + ";");
                    gVar.nls = bi.aG((String) z.get(".sysmsg.NewYearSNSCtrl2016.Entrance.EntranceTips"), "");
                    gVar.gVP.append("EntranceTips:" + gVar.nls + ";");
                    gVar.nlU.clear();
                    int i2 = 0;
                    while (true) {
                        int WU = bi.WU((String) z.get(".sysmsg.NewYearSNSCtrl2016.AmountLevel" + i2 + ".Count"));
                        gVar.gVP.append("count: " + i2 + " | " + WU + ";\n");
                        if (WU == 0) {
                            break;
                        }
                        List linkedList = new LinkedList();
                        i = 0;
                        while (i < WU) {
                            int WU2 = bi.WU((String) z.get(".sysmsg.NewYearSNSCtrl2016.AmountLevel" + i2 + ".Amount" + (i == 0 ? "" : Integer.valueOf(i))));
                            linkedList.add(Integer.valueOf(WU2));
                            gVar.gVP.append("AmountLevel : " + i2 + " index " + i + " val: " + WU2 + ";");
                            i++;
                        }
                        gVar.nlU.add(linkedList);
                        i2++;
                    }
                    x.i("MicroMsg.NewYearSnsCtrlV2", "dumpinfo " + gVar.gVP.toString());
                }
                nlq = u;
            } catch (Exception e) {
                x.e("MicroMsg.NewYearSnsCtrlV2", "createctrl error " + e.getMessage());
            }
        }
        return nlr;
    }

    public static boolean bxd() {
        com.tencent.mm.kernel.g.Ek();
        return ((Boolean) com.tencent.mm.kernel.g.Ei().DT().get(a.sSw, Boolean.valueOf(true))).booleanValue();
    }

    public final void bxe() {
        i h = k.h(a.sSA);
        if (h.nvf == null || bi.oW(h.nvf.nvc)) {
            h.nvf = new com.tencent.mm.plugin.sns.g.g();
            h.nvf.nvc = this.nlR;
            h.nvf.nvd = 0;
        }
        if (bi.oW(h.nvf.nvc) || !h.nvf.nvc.equals(this.nlR)) {
            h.nvf = new com.tencent.mm.plugin.sns.g.g();
            h.nvf.nvc = this.nlR;
            h.nvf.nvd = 0;
        } else {
            com.tencent.mm.plugin.sns.g.g gVar = h.nvf;
            gVar.nvd--;
            if (h.nvf.nvd < 0) {
                h.nvf.nvd = 0;
            }
        }
        x.i("MicroMsg.NewYearSnsCtrlV2", "minusPostCountV2 " + h.nvf.nvd + " postId: " + this.nlR + " " + bi.cjd().toString());
        try {
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Ei().DT().a(a.sSA, new String(h.toByteArray(), Charset.forName("ISO-8859-1")));
        } catch (IOException e) {
            x.w("MicroMsg.NewYearSnsCtrlV2", "minusPostCountV2 save exception:" + e.getLocalizedMessage());
        }
        com.tencent.mm.sdk.b.a.sFg.m(new pq());
    }
}
