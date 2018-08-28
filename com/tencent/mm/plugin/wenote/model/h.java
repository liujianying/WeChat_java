package com.tencent.mm.plugin.wenote.model;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.g.a.kq;
import com.tencent.mm.g.a.qs;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.fav.a.an;
import com.tencent.mm.plugin.wenote.b.c;
import com.tencent.mm.pluginsdk.location.b;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.wj;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class h {
    private static Map<String, String> iYH;
    public static String qoh = (an.aLQ() + "/fav_fileicon_video.png");
    public static String qoi = (an.aLQ() + "/fav_fileicon_music.png");
    public static String qoj = (an.aLQ() + "/fav_list_img_default.png");
    public static String qok = (an.aLQ() + "/fav_fileicon_zip.png");
    public static String qol = (an.aLQ() + "/fav_fileicon_word.png");
    public static String qom = (an.aLQ() + "/fav_fileicon_ppt.png");
    public static String qon = (an.aLQ() + "/fav_fileicon_xls.png");
    public static String qoo = (an.aLQ() + "/fav_fileicon_txt.png");
    public static String qop = (an.aLQ() + "/fav_fileicon_pdf.png");
    public static String qoq = (an.aLQ() + "/fav_fileicon_unknow.png");
    private static String[] qor = new String[]{"<div>", "<div/>", "<object", "<br", "</"};
    private static String[] qos = new String[]{"＜div>", "＜div/>", "＜object", "＜br", "＜/"};
    private static LinkedList<wj> qot = null;
    private static String qou = "";

    private static void ap(JSONObject jSONObject) {
        kq kqVar = new kq();
        kqVar.bVa.type = 6;
        kqVar.bVa.bVc = jSONObject.toString();
        kqVar.bVa.bUR = "";
        a.sFg.m(kqVar);
    }

    public static void l(Context context, String str, int i) {
        if (!bi.oW(str) && new File(str).exists()) {
            JSONObject jSONObject = new JSONObject();
            try {
                int bD = (int) f.bD((long) i);
                jSONObject.put("type", 4);
                jSONObject.put("downloaded", true);
                jSONObject.put("length", bD);
                jSONObject.put("lengthStr", f.C(context, bD));
                jSONObject.put("iconPath", an.aLQ() + "/fav_fileicon_recording.png");
                ap(jSONObject);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WNNoteLogic", e, "", new Object[0]);
            }
        }
    }

    public static void Sh(String str) {
        if (!bi.oW(str)) {
            File file = new File(str);
            if (file.exists()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", 5);
                    jSONObject.put("downloaded", true);
                    jSONObject.put(SlookSmartClipMetaTag.TAG_TYPE_TITLE, file.getName());
                    jSONObject.put("content", f.aj((float) e.cm(str)));
                    jSONObject.put("iconPath", Sj(e.cp(str)));
                    jSONObject.put("localPath", str);
                    ap(jSONObject);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.WNNoteLogic", e, "", new Object[0]);
                }
            }
        }
    }

    public static void Si(String str) {
        x.i("MicroMsg.WNNoteLogic", "insert location run");
        JSONObject jSONObject = new JSONObject(str);
        x.i("MicroMsg.WNNoteLogic", "insert location run :after invoke");
        Object obj = an.aLS() + "/" + g.u((new b(-1, (float) jSONObject.getDouble("lat"), (float) jSONObject.getDouble("lng"), jSONObject.getInt("scale"), 1).toString()).getBytes()) + ".png";
        x.i("MicroMsg.WNNoteLogic", "insert location run :filepath:%s", new Object[]{obj});
        if (FileOp.cn(obj)) {
            x.i("MicroMsg.WNNoteLogic", "insert location run :filepath:is exsit");
        }
        if (e.cn(obj)) {
            x.i("MicroMsg.WNNoteLogic", "fileExist suc, use getimagelocalpath");
        } else {
            x.e("MicroMsg.WNNoteLogic", "Temp file fileExist fail:%s ,use default file", new Object[]{obj});
            obj = d.qnT;
        }
        jSONObject.put("localPath", obj);
        ap(jSONObject);
    }

    public static void X(ArrayList<String> arrayList) {
        JSONObject jSONObject = new JSONObject();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            try {
                jSONObject.put("type", 2);
                jSONObject.put("downloaded", true);
                String fw = c.fw(str, "");
                str = c.fx(str, "");
                if (!bi.oW(fw) && !bi.oW(str)) {
                    jSONObject.put("bigImagePath", fw);
                    jSONObject.put("localPath", str);
                    ap(jSONObject);
                } else {
                    return;
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WNNoteLogic", e, "", new Object[0]);
            }
        }
    }

    public static void ba(Context context, String str) {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (!bi.oW(str)) {
            i = (int) k.bZe().duration;
            int bD = (int) f.bD((long) i);
            try {
                jSONObject.put("downloaded", true);
                jSONObject.put("length", i);
                jSONObject.put("lengthStr", f.C(context, bD));
                jSONObject.put("iconPath", an.aLQ() + "/fav_fileicon_recording.png");
                jSONObject.put("localPath", str);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WNNoteLogic", e, "", new Object[0]);
            }
        }
        try {
            jSONObject.put("type", 4);
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.WNNoteLogic", e2, "", new Object[0]);
        }
        i = k.bZe().qoC;
        kq kqVar = new kq();
        kqVar.bVa.type = 6;
        kqVar.bVa.bVc = jSONObject.toString();
        kqVar.bVa.bUR = Integer.toString(i);
        a.sFg.m(kqVar);
    }

    static {
        iYH = new HashMap();
        Map hashMap = new HashMap();
        iYH = hashMap;
        hashMap.put("avi", qoh);
        iYH.put("m4v", qoh);
        iYH.put("vob", qoh);
        iYH.put("mpeg", qoh);
        iYH.put("mpe", qoh);
        iYH.put("asx", qoh);
        iYH.put("asf", qoh);
        iYH.put("f4v", qoh);
        iYH.put("flv", qoh);
        iYH.put("mkv", qoh);
        iYH.put("wmv", qoh);
        iYH.put("wm", qoh);
        iYH.put("3gp", qoh);
        iYH.put("mp4", qoh);
        iYH.put("rmvb", qoh);
        iYH.put("rm", qoh);
        iYH.put("ra", qoh);
        iYH.put("ram", qoh);
        iYH.put("mp3pro", qoi);
        iYH.put("vqf", qoi);
        iYH.put("cd", qoi);
        iYH.put("md", qoi);
        iYH.put("mod", qoi);
        iYH.put("vorbis", qoi);
        iYH.put("au", qoi);
        iYH.put("amr", qoi);
        iYH.put("silk", qoi);
        iYH.put("wma", qoi);
        iYH.put("mmf", qoi);
        iYH.put("mid", qoi);
        iYH.put("midi", qoi);
        iYH.put("mp3", qoi);
        iYH.put("aac", qoi);
        iYH.put("ape", qoi);
        iYH.put("aiff", qoi);
        iYH.put("aif", qoi);
        iYH.put("jfif", qoj);
        iYH.put("tiff", qoj);
        iYH.put("tif", qoj);
        iYH.put("jpe", qoj);
        iYH.put("dib", qoj);
        iYH.put("jpeg", qoj);
        iYH.put("jpg", qoj);
        iYH.put("png", qoj);
        iYH.put("bmp", qoj);
        iYH.put("gif", qoj);
        iYH.put("rar", qok);
        iYH.put("zip", qok);
        iYH.put("7z", qok);
        iYH.put("iso", qok);
        iYH.put("cab", qok);
        iYH.put("doc", qol);
        iYH.put("docx", qol);
        iYH.put("ppt", qom);
        iYH.put("pptx", qom);
        iYH.put("xls", qon);
        iYH.put("xlsx", qon);
        iYH.put("txt", qoo);
        iYH.put("rtf", qoo);
        iYH.put("pdf", qop);
        iYH.put("unknown", qoq);
    }

    public static String Sj(String str) {
        String str2 = (String) iYH.get(str);
        if (str2 == null) {
            return (String) iYH.get("unknown");
        }
        return str2;
    }

    public static ArrayList<com.tencent.mm.plugin.wenote.model.a.b> a(Object obj, List<String> list, boolean z) {
        if (obj == null) {
            return null;
        }
        ArrayList arrayList = (ArrayList) obj;
        Collection arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.wenote.model.a.b bVar = (com.tencent.mm.plugin.wenote.model.a.b) it.next();
            if (bVar.getType() != 1) {
                arrayList2.add(bVar);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            String str = (String) list.get(i);
            if (str.trim().equals("<ThisisNoteNodeHrObj>")) {
                com.tencent.mm.plugin.wenote.model.a.g gVar = new com.tencent.mm.plugin.wenote.model.a.g();
                gVar.qoH = false;
                gVar.qoN = false;
                arrayList2.add(i, gVar);
            } else if (!str.trim().equals("<ThisisNoteNodeObj>")) {
                com.tencent.mm.plugin.wenote.model.a.h hVar = new com.tencent.mm.plugin.wenote.model.a.h();
                hVar.content = str;
                hVar.qoH = false;
                hVar.qoN = false;
                hVar.jdM = f.Sf(hVar.toString());
                if (i < arrayList2.size()) {
                    arrayList2.add(i, hVar);
                } else {
                    arrayList2.add(hVar);
                }
            }
        }
        if (z) {
            arrayList.clear();
            arrayList.addAll(arrayList2);
        }
        return arrayList2;
    }

    public static void Bn(int i) {
        LinkedList linkedList;
        qot = null;
        qou = "";
        String bZK = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().bZK();
        qou = bZK;
        LinkedList linkedList2 = new LinkedList();
        wl Sm = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().Sm(bZK);
        if (Sm == null || Sm.rBI.size() <= 1) {
            linkedList = null;
        } else {
            Iterator it = Sm.rBI.iterator();
            while (it.hasNext()) {
                vx vxVar = (vx) it.next();
                String o = f.o(vxVar);
                if (!bi.oW(o) && vxVar.bjS == 2 && e.cn(o)) {
                    wj wjVar = new wj();
                    wjVar.rwk = vxVar.rzF;
                    wjVar.rwn = vxVar.rzq;
                    wjVar.rBC = vxVar.rzo;
                    linkedList2.add(wjVar);
                }
            }
            linkedList = linkedList2;
        }
        qot = linkedList;
        au.DF().a(new b(i, 1, qou, qot, null), 0);
    }

    public static void a(Context context, Bitmap bitmap, boolean z) {
        com.tencent.mm.plugin.report.service.h hVar;
        Object[] objArr;
        String oN = r.oN("jpg");
        if (bitmap != null) {
            try {
                com.tencent.mm.sdk.platformtools.c.a(bitmap, 100, CompressFormat.JPEG, oN, true);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WNNoteLogic", e, "", new Object[0]);
                x.e("MicroMsg.WNNoteLogic", "save image fail, saveBitmapToImage is null");
                hVar = com.tencent.mm.plugin.report.service.h.mEJ;
                objArr = new Object[5];
                objArr[0] = Integer.valueOf(0);
                objArr[1] = Integer.valueOf(0);
                objArr[2] = Integer.valueOf(0);
                objArr[3] = Integer.valueOf(3);
                objArr[4] = Integer.valueOf(z ? 1 : 0);
                hVar.h(14811, objArr);
                oN = "";
            }
        } else {
            x.e("MicroMsg.WNNoteLogic", "save image fail, bigBitmap is null");
            hVar = com.tencent.mm.plugin.report.service.h.mEJ;
            objArr = new Object[5];
            objArr[0] = Integer.valueOf(0);
            objArr[1] = Integer.valueOf(0);
            objArr[2] = Integer.valueOf(0);
            objArr[3] = Integer.valueOf(1);
            objArr[4] = Integer.valueOf(z ? 1 : 0);
            hVar.h(14811, objArr);
            oN = "";
        }
        if (!bi.oW(oN)) {
            r.a(oN, context);
        }
        File file = new File(oN);
        if (file.exists()) {
            long length = file.length() / 1024;
            int i = 0;
            int i2 = 0;
            if (bitmap != null) {
                i = bitmap.getWidth();
                i2 = bitmap.getHeight();
                bitmap.recycle();
            }
            int i3 = i2;
            int i4 = i;
            wj wjVar = new wj();
            wjVar.rwk = g.cu(oN);
            au.DF().a(new b(0, 2, qou, qot, wjVar), 0);
            hVar = com.tencent.mm.plugin.report.service.h.mEJ;
            objArr = new Object[5];
            objArr[0] = Integer.valueOf(i4);
            objArr[1] = Integer.valueOf(i3);
            objArr[2] = Long.valueOf(length);
            objArr[3] = Integer.valueOf(0);
            objArr[4] = Integer.valueOf(z ? 1 : 0);
            hVar.h(14811, objArr);
        }
    }

    public static void bb(Context context, String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.WNNoteLogic", "dofavnotelink , but localid is null or nil");
            return;
        }
        ch chVar = new ch();
        qs qsVar = new qs();
        qsVar.cbk.cbn = str;
        qsVar.cbk.cbo = chVar;
        qsVar.cbk.url = "";
        a.sFg.m(qsVar);
        if (qsVar.cbl.bJm) {
            chVar.bJF.activity = (Activity) context;
            chVar.bJF.bJM = 28;
            a.sFg.m(chVar);
            return;
        }
        if (chVar.bJF.bJL == 0) {
            chVar.bJF.bJL = R.l.favorite_fail_nonsupport;
        }
        com.tencent.mm.ui.base.h.i(context, chVar.bJF.bJL, 0);
    }
}
