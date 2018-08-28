package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.fz;
import com.tencent.mm.g.a.kp;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.fav.a.an;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.wenote.b.b;
import com.tencent.mm.plugin.wenote.b.c;
import com.tencent.mm.plugin.wenote.model.a.e;
import com.tencent.mm.plugin.wenote.model.a.f;
import com.tencent.mm.plugin.wenote.model.a.h;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.a.j;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.a.n;
import com.tencent.mm.plugin.wenote.model.a.q;
import com.tencent.mm.plugin.wenote.model.a.s;
import com.tencent.mm.plugin.wenote.model.a.v;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;

public abstract class d {
    public static String qnL = "";
    public static HashMap<String, JSONArray> qnM = new HashMap();
    public static boolean qnP = false;
    public static String qnQ = (an.aLQ() + "/fav_fileicon_recording.png");
    private static String qnR = (an.aLQ() + "/ofm_file_icon.png");
    private static String qnS = (an.aLQ() + "/app_attach_file_icon_pic.png");
    public static String qnT = (an.aLQ() + "/location_msg.png");
    public static String qnU = (an.aLQ() + "/note_fav_not_support.png");
    public l qnE = null;
    public g qnF;
    public HashMap<String, v> qnG = new HashMap();
    public HashMap<String, String> qnH = new HashMap();
    public HashMap<String, n> qnI = new HashMap();
    public String qnJ = "WeNote_0";
    public String qnK = "";
    public boolean qnN = false;
    public wl qnO = new wl();

    public abstract void a(vx vxVar, String str);

    public abstract void aX(Context context, String str);

    public abstract void aY(Context context, String str);

    public abstract void aZ(Context context, String str);

    public abstract String b(vx vxVar);

    public abstract String c(vx vxVar);

    public abstract void n(vx vxVar);

    public final void cR(List<vx> list) {
        ArrayList So;
        Throwable e;
        v vVar = new v();
        List list2 = null;
        for (vx vxVar : list) {
            n nVar = new n();
            nVar.qpc = vxVar.rAq;
            if (vxVar.bjS == 1) {
                nVar.qpc = "-1";
            }
            String b;
            if (!bi.oW(nVar.qpc)) {
                if (!nVar.qpc.equals("WeNoteHtmlFile")) {
                    if (!nVar.qpc.equals("-1")) {
                        int i = bi.getInt(nVar.qpc.substring(7), 0);
                        int i2 = bi.getInt(this.qnJ.substring(7), 0);
                        this.qnJ = "WeNote_" + (i2 > i ? String.valueOf(i2) : String.valueOf(i));
                    }
                    nVar.jdM = vxVar.jdM;
                    String b2;
                    String str;
                    switch (vxVar.bjS) {
                        case 1:
                            if (!bi.oW(vxVar.desc)) {
                                if (vVar.qpv.size() > 0 && vVar.qpv.get(vVar.qpv.size() - 1) != null && ((n) vVar.qpv.get(vVar.qpv.size() - 1)).qpc.equals("-1")) {
                                    s sVar = (s) vVar.qpv.get(vVar.qpv.size() - 1);
                                    sVar.content += vxVar.desc;
                                    break;
                                }
                                h hVar = new h();
                                hVar.qpc = nVar.qpc;
                                hVar.content = vxVar.desc;
                                vVar.qpv.add(hVar);
                                break;
                            }
                            break;
                            break;
                        case 2:
                            e eVar = new e();
                            eVar.qpc = nVar.qpc;
                            eVar.type = 2;
                            eVar.jdM = nVar.jdM;
                            eVar.qpb = vxVar;
                            b2 = b(vxVar);
                            if (!bi.oW(b2)) {
                                str = b2 + "_bigthumb";
                                String c = c(vxVar);
                                if (!com.tencent.mm.a.e.cn(c)) {
                                    a(vxVar, c);
                                }
                                if (com.tencent.mm.a.e.cn(b2)) {
                                    eVar.qpd = true;
                                    c.fx(b2, str);
                                } else {
                                    n(vxVar);
                                    eVar.qpd = false;
                                    this.qnH.put(vxVar.jdM, nVar.qpc);
                                }
                                eVar.bVd = str;
                                eVar.qpe = b2;
                                vVar.qpv.add(eVar);
                                this.qnI.put(nVar.qpc, eVar);
                                break;
                            }
                            break;
                        case 3:
                            k kVar = new k();
                            kVar.qpc = nVar.qpc;
                            kVar.type = 4;
                            kVar.jdM = nVar.jdM;
                            kVar.qpb = vxVar;
                            b2 = b(vxVar);
                            if (bi.oW(b2) || !com.tencent.mm.a.e.cn(b2)) {
                                n(vxVar);
                                kVar.qpd = false;
                                kVar.qpt = ad.getContext().getString(R.l.favorite_wenote_voice_downloading);
                                this.qnH.put(vxVar.jdM, nVar.qpc);
                            } else {
                                kVar.qpd = true;
                                kVar.fTs = qnQ;
                                kVar.length = vxVar.duration;
                            }
                            kVar.bVd = b2;
                            kVar.qps = f.C(ad.getContext(), (int) f.bD((long) vxVar.duration));
                            kVar.bOT = vxVar.duration;
                            fz fzVar = new fz();
                            fzVar.bOL.type = 17;
                            fzVar.bOL.bON = vxVar;
                            a.sFg.m(fzVar);
                            kVar.bOS = fzVar.bOM.ret;
                            kVar.qoT = vxVar.rzD;
                            vVar.qpv.add(kVar);
                            this.qnI.put(nVar.qpc, kVar);
                            break;
                        case 4:
                            j jVar = new j();
                            jVar.qpc = nVar.qpc;
                            jVar.type = 6;
                            jVar.jdM = nVar.jdM;
                            jVar.qpb = vxVar;
                            if (vxVar != null) {
                                jVar.duration = vxVar.duration;
                            }
                            jVar.bOX = c(vxVar);
                            str = b(vxVar);
                            jVar.bVd = str;
                            if (!(bi.oW(jVar.bOX) || com.tencent.mm.a.e.cn(jVar.bOX))) {
                                if (com.tencent.mm.a.e.cn(str)) {
                                    Bitmap By = com.tencent.mm.plugin.fav.ui.c.By(str);
                                    if (By != null) {
                                        try {
                                            x.i("MicroMsg.WNNoteBase", "add fav service: create thumbpath bitmap, saveBitmapToImage ");
                                            com.tencent.mm.pluginsdk.i.e.a(By, CompressFormat.JPEG, jVar.bOX);
                                        } catch (Throwable e2) {
                                            x.printErrStackTrace("MicroMsg.WNNoteBase", e2, "", new Object[0]);
                                        }
                                    }
                                } else {
                                    a(vxVar, jVar.bOX);
                                    this.qnH.put(vxVar.jdM + "_t", nVar.qpc);
                                }
                            }
                            if (bi.oW(str) || !com.tencent.mm.a.e.cn(str)) {
                                jVar.qpd = false;
                                this.qnH.put(vxVar.jdM, nVar.qpc);
                            } else {
                                jVar.qpd = true;
                            }
                            vVar.qpv.add(jVar);
                            this.qnI.put(nVar.qpc, jVar);
                            break;
                        case 6:
                            q qVar = new q();
                            qVar.bSx = (float) vxVar.rAi.rAL.lat;
                            qVar.dVI = (float) vxVar.rAi.rAL.lng;
                            qVar.bSz = vxVar.rAi.rAL.bSz;
                            qVar.qpn = vxVar.rAi.rAL.label;
                            qVar.qpo = vxVar.rAi.rAL.bWB;
                            qVar.qpp = vxVar.rAq;
                            f fVar = new f();
                            fVar.qpc = nVar.qpc;
                            fVar.type = 3;
                            fVar.jdM = nVar.jdM;
                            fVar.qpb = vxVar;
                            fVar.qpd = true;
                            fVar.kFa = qVar.qpo;
                            fVar.dRH = qVar.qpn;
                            fVar.lat = (double) qVar.bSx;
                            fVar.lng = (double) qVar.dVI;
                            fVar.qpq = (double) qVar.bSz;
                            fVar.bVd = "";
                            vVar.qpv.add(fVar);
                            this.qnI.put(nVar.qpc, fVar);
                            break;
                        case 8:
                            com.tencent.mm.plugin.wenote.model.a.c cVar = new com.tencent.mm.plugin.wenote.model.a.c();
                            cVar.qpc = nVar.qpc;
                            cVar.type = 5;
                            cVar.jdM = nVar.jdM;
                            cVar.qpb = vxVar;
                            b2 = b(vxVar);
                            if (bi.oW(b2) || !com.tencent.mm.a.e.cn(b2)) {
                                cVar.qpd = false;
                                this.qnH.put(vxVar.jdM, nVar.qpc);
                            } else {
                                cVar.qpd = true;
                                cVar.bVd = b2;
                            }
                            cVar.fTs = h.Sj(vxVar.rzD);
                            cVar.title = vxVar.title;
                            cVar.content = vxVar.desc;
                            cVar.qoT = vxVar.rzD;
                            if (bi.oW(cVar.content)) {
                                cVar.content = f.aj((float) vxVar.rzJ);
                            }
                            vVar.qpv.add(cVar);
                            this.qnI.put(nVar.qpc, cVar);
                            break;
                        default:
                            if (vxVar.bjS <= 0) {
                                break;
                            }
                            i iVar = new i();
                            iVar.qpc = nVar.qpc;
                            iVar.type = 0;
                            iVar.jdM = nVar.jdM;
                            iVar.qpb = vxVar;
                            String b3 = b(vxVar);
                            iVar.qpd = true;
                            iVar.bVd = b3;
                            iVar.fTs = qnU;
                            iVar.title = ad.getContext().getResources().getString(R.l.favorite_record_no_support_type);
                            iVar.content = ad.getContext().getResources().getString(R.l.favorite_oldversion_content);
                            vVar.qpv.add(iVar);
                            this.qnI.put(nVar.qpc, iVar);
                            break;
                    }
                }
                b = b(vxVar);
                List So2;
                if (bi.oW(b) || !com.tencent.mm.a.e.cn(b)) {
                    n(vxVar);
                    vVar.qpw = true;
                    x.i("MicroMsg.WNNoteBase", "local html file not exist,download htmlfile,dataid: %s", new Object[]{vxVar.jdM});
                    this.qnH.put(vxVar.jdM, nVar.qpc);
                    So2 = list2;
                } else {
                    try {
                        vVar.qpu = c.Sv(b);
                        So2 = b.So(vVar.qpu);
                        try {
                            x.i("MicroMsg.WNNoteBase", "local html file exist,dataid: %s", new Object[]{vxVar.jdM});
                            qnM.containsKey(vVar.qpu);
                        } catch (Throwable e3) {
                            e = e3;
                            x.printErrStackTrace("MicroMsg.WNNoteBase", e, "", new Object[0]);
                            x.i("MicroMsg.WNNoteBase", "dealWNNoteInfo,WeNoteHtmlFile, cdnurl is null :%B, cdnkey is null : %B ", new Object[]{Boolean.valueOf(bi.oW(vxVar.rzo)), Boolean.valueOf(bi.oW(vxVar.rzq))});
                            list2 = So2;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        So2 = list2;
                    }
                }
                x.i("MicroMsg.WNNoteBase", "dealWNNoteInfo,WeNoteHtmlFile, cdnurl is null :%B, cdnkey is null : %B ", new Object[]{Boolean.valueOf(bi.oW(vxVar.rzo)), Boolean.valueOf(bi.oW(vxVar.rzq))});
                list2 = So2;
            } else {
                x.e("MicroMsg.WNNoteBase", "Note: DataItem.htmlid is null");
                b = b(vxVar);
                if (bi.oW(b) || !com.tencent.mm.a.e.cn(b)) {
                    n(vxVar);
                    return;
                } else {
                    f.t(this.qnE.bVe, b);
                    return;
                }
            }
        }
        if (list2 != null && list2.size() > 0) {
            h.a(vVar.qpv, list2, true);
        }
        if (this.qnE.bJC == -1) {
            this.qnG.put(Long.toString(this.qnE.bVe), vVar);
        } else {
            this.qnG.put(Long.toString(this.qnE.bJC), vVar);
        }
    }

    public final void b(kp kpVar) {
        if (kpVar.bUP == null) {
            x.e("MicroMsg.WNNoteBase", "setWNNativeCallbackOnClick, opertionevent.data is null, retutn");
            return;
        }
        String str = kpVar.bUP.bUR;
        n nVar = (n) this.qnI.get(str);
        if (nVar == null) {
            x.e("MicroMsg.WNNoteBase", "setWNNativeCallbackOnClick, mEditorIdToDataItem.get(localEditorId) is null, retutn");
            return;
        }
        x.i("MicroMsg.WNNoteBase", "setWNNativeCallbackOnClick, mEditorIdToDataItem.get(localEditorId) is %d", new Object[]{Integer.valueOf(nVar.type)});
        switch (nVar.type) {
            case 2:
                aZ(kpVar.bUP.context, str);
                return;
            case 3:
                aY(kpVar.bUP.context, str);
                return;
            case 5:
                aX(kpVar.bUP.context, str);
                return;
            case 6:
                Context context = kpVar.bUP.context;
                j jVar = (j) this.qnI.get(str);
                if (!bi.oW(jVar.bVd)) {
                    if (!com.tencent.mm.a.e.cn(jVar.bVd)) {
                        vx Se = Se(jVar.jdM);
                        if (Se == null) {
                            x.e("MicroMsg.WNNoteBase", "goToVideoPlay, favData is null");
                            return;
                        }
                        n(Se);
                    }
                    Intent intent = new Intent();
                    if (this.qnF == null) {
                        intent.putExtra("key_detail_info_id", 0);
                    } else {
                        intent.putExtra("key_detail_info_id", this.qnF.field_localId);
                    }
                    intent.putExtra("key_detail_fav_path", jVar.bVd);
                    intent.putExtra("key_detail_fav_thumb_path", jVar.bOX);
                    intent.putExtra("key_detail_fav_video_duration", jVar.duration);
                    intent.putExtra("key_detail_data_id", jVar.jdM);
                    intent.putExtra("key_detail_statExtStr", "");
                    intent.putExtra("key_detail_fav_video_show_download_status", true);
                    com.tencent.mm.plugin.fav.a.b.a(context, ".ui.detail.FavoriteVideoPlayUI", intent, 1);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.mm.protocal.c.wl a(java.lang.String r11, java.util.List<com.tencent.mm.plugin.wenote.model.a.n> r12, com.tencent.mm.protocal.c.vx r13) {
        /*
        r7 = new java.util.LinkedList;
        r7.<init>();
        r8 = new com.tencent.mm.protocal.c.wl;
        r8.<init>();
        if (r13 == 0) goto L_0x002b;
    L_0x000c:
        r7.add(r13);
    L_0x000f:
        r9 = r12.iterator();
    L_0x0013:
        r0 = r9.hasNext();
        if (r0 == 0) goto L_0x01f6;
    L_0x0019:
        r6 = r9.next();
        r6 = (com.tencent.mm.plugin.wenote.model.a.n) r6;
        if (r6 == 0) goto L_0x0013;
    L_0x0021:
        r0 = r6.qpb;
        if (r0 == 0) goto L_0x0071;
    L_0x0025:
        r0 = r6.qpb;
        r7.add(r0);
        goto L_0x0013;
    L_0x002b:
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r11);
        if (r0 != 0) goto L_0x000f;
    L_0x0031:
        r0 = r11.length();
        if (r0 <= 0) goto L_0x000f;
    L_0x0037:
        r0 = com.tencent.mm.plugin.fav.a.an.aLT();
        r1 = new com.tencent.mm.protocal.c.vx;
        r1.<init>();
        r2 = 8;
        r1.CF(r2);
        r2 = "WeNoteHtmlFile";
        r1.UY(r2);
        r2 = 1;
        r1.kY(r2);
        r2 = com.tencent.mm.a.e.cm(r0);
        r2 = (long) r2;
        r1.fO(r2);
        r2 = ".htm";
        r1.UL(r2);
        r7.add(r1);
        r2 = com.tencent.mm.plugin.wenote.model.f.o(r1);
        r3 = com.tencent.mm.modelsfs.FileOp.cn(r2);
        if (r3 != 0) goto L_0x006d;
    L_0x006a:
        com.tencent.mm.modelsfs.FileOp.y(r0, r2);
    L_0x006d:
        r1.UP(r2);
        goto L_0x000f;
    L_0x0071:
        r10 = new com.tencent.mm.protocal.c.vx;
        r10.<init>();
        r0 = new com.tencent.mm.protocal.c.vy;
        r0.<init>();
        r1 = new com.tencent.mm.protocal.c.vz;
        r1.<init>();
        r2 = 6;
        r1.CJ(r2);
        r0.c(r1);
        r10.a(r0);
        r0 = r6.type;
        switch(r0) {
            case 1: goto L_0x01a0;
            case 2: goto L_0x0099;
            case 3: goto L_0x00e1;
            case 4: goto L_0x0142;
            case 5: goto L_0x011b;
            case 6: goto L_0x016f;
            default: goto L_0x008f;
        };
    L_0x008f:
        r0 = r6.qpc;
        r10.UY(r0);
        r7.add(r10);
        goto L_0x0013;
    L_0x0099:
        r0 = 2;
        r10.CF(r0);
        r1 = r6;
        r1 = (com.tencent.mm.plugin.wenote.model.a.o) r1;
        r0 = r1.qpe;
        r10.UP(r0);
        r2 = r6;
        r2 = (com.tencent.mm.plugin.wenote.model.a.o) r2;
        r2 = r2.jdM;
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r2 != 0) goto L_0x00bf;
    L_0x00b0:
        r0 = r6.jdM;
        r10.UO(r0);
        r0 = r1.bVd;
        r10.UQ(r0);
    L_0x00ba:
        r0 = 2;
        r10.CF(r0);
        goto L_0x008f;
    L_0x00bf:
        r1 = r1.toString();
        r1 = com.tencent.mm.plugin.wenote.model.f.Sf(r1);
        r10.UO(r1);
        r1 = 150; // 0x96 float:2.1E-43 double:7.4E-322;
        r2 = 150; // 0x96 float:2.1E-43 double:7.4E-322;
        r3 = android.graphics.Bitmap.CompressFormat.JPEG;
        r4 = 90;
        r5 = com.tencent.mm.plugin.wenote.model.f.c(r10);
        com.tencent.mm.sdk.platformtools.c.c(r0, r1, r2, r3, r4, r5);
        r0 = com.tencent.mm.plugin.wenote.model.f.c(r10);
        r10.UQ(r0);
        goto L_0x00ba;
    L_0x00e1:
        r0 = 6;
        r10.CF(r0);
        r0 = r6;
        r0 = (com.tencent.mm.plugin.wenote.model.a.r) r0;
        r1 = r6.jdM;
        r10.UO(r1);
        r1 = new com.tencent.mm.protocal.c.we;
        r1.<init>();
        r2 = r0.dRH;
        r1.Vn(r2);
        r2 = r0.lat;
        r1.z(r2);
        r2 = r0.lng;
        r1.y(r2);
        r2 = r0.qpq;
        r2 = (int) r2;
        r1.CK(r2);
        r0 = r0.kFa;
        r1.Vo(r0);
        r0 = 1;
        r10.kX(r0);
        r0 = 1;
        r10.kY(r0);
        r0 = r10.rAi;
        r0.a(r1);
        goto L_0x008f;
    L_0x011b:
        r0 = 8;
        r10.CF(r0);
        r0 = r6;
        r0 = (com.tencent.mm.plugin.wenote.model.a.t) r0;
        r1 = r6.jdM;
        r10.UO(r1);
        r1 = r0.bVd;
        r10.UP(r1);
        r1 = 1;
        r10.kY(r1);
        r1 = r0.title;
        r10.UB(r1);
        r1 = r0.content;
        r10.UC(r1);
        r0 = r0.qoT;
        r10.UL(r0);
        goto L_0x008f;
    L_0x0142:
        r0 = 3;
        r10.CF(r0);
        r0 = r6;
        r0 = (com.tencent.mm.plugin.wenote.model.a.u) r0;
        r1 = r6.jdM;
        r10.UO(r1);
        r1 = r0.bVd;
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r2 != 0) goto L_0x0013;
    L_0x0156:
        r2 = r1.length();
        if (r2 == 0) goto L_0x0013;
    L_0x015c:
        r10.UP(r1);
        r1 = r0.length;
        r10.CE(r1);
        r1 = 1;
        r10.kY(r1);
        r0 = r0.qoT;
        r10.UL(r0);
        goto L_0x008f;
    L_0x016f:
        r0 = 4;
        r10.CF(r0);
        r0 = r6;
        r0 = (com.tencent.mm.plugin.wenote.model.a.j) r0;
        r1 = r6.jdM;
        r10.UO(r1);
        r1 = r0.bVd;
        r10.UP(r1);
        r1 = r0.bOX;
        r10.UQ(r1);
        r1 = r0.bVd;
        r1 = com.tencent.mm.plugin.sight.base.d.Lo(r1);
        if (r1 == 0) goto L_0x019b;
    L_0x018d:
        r1 = r1.bvB();
        r10.CE(r1);
    L_0x0194:
        r0 = r0.qoT;
        r10.UL(r0);
        goto L_0x008f;
    L_0x019b:
        r1 = 1;
        r10.CE(r1);
        goto L_0x0194;
    L_0x01a0:
        r0 = qnP;
        if (r0 != 0) goto L_0x01b9;
    L_0x01a4:
        r0 = com.tencent.mm.plugin.report.service.h.mEJ;
        r1 = 14547; // 0x38d3 float:2.0385E-41 double:7.187E-320;
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = 6;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r0.h(r1, r2);
        r0 = 1;
        qnP = r0;
    L_0x01b9:
        r0 = 1;
        r10.CF(r0);
        r0 = 1;
        r10.kX(r0);
        r0 = 1;
        r10.kY(r0);
        r0 = r6;
        r0 = (com.tencent.mm.plugin.wenote.model.a.h) r0;
        r1 = r6.jdM;
        r10.UO(r1);
        r0 = r0.content;
        r0 = com.tencent.mm.plugin.wenote.b.b.Sp(r0);
        r10.UC(r0);
        r0 = r10.desc;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 != 0) goto L_0x008f;
    L_0x01de:
        r0 = r10.desc;
        r0 = r0.length();
        r1 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        if (r0 <= r1) goto L_0x008f;
    L_0x01e8:
        r0 = r10.desc;
        r1 = 0;
        r2 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r0 = r0.substring(r1, r2);
        r10.UC(r0);
        goto L_0x008f;
    L_0x01f6:
        a(r7, r12);
        r8.ar(r7);
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.model.d.a(java.lang.String, java.util.List, com.tencent.mm.protocal.c.vx):com.tencent.mm.protocal.c.wl");
    }

    private static void a(LinkedList<vx> linkedList, List<n> list) {
        x.i("MicroMsg.WNNoteBase", "do WNNoteBase.setExtraInfo");
        if (linkedList.size() > 0) {
            int size = linkedList.size();
            int i = 0;
            while (i < size) {
                vx vxVar = (vx) linkedList.get(i);
                if (i > 0 && bi.oW(vxVar.rzo)) {
                    vxVar.UO(f.Sf(vxVar.toString()));
                    n nVar = null;
                    if (i - 1 >= 0 && i - 1 < list.size() && list.size() > 0) {
                        nVar = (n) list.get(i - 1);
                    }
                    if (!(nVar == null || nVar.qpc == null || !nVar.qpc.equals(vxVar.rAq))) {
                        nVar.jdM = vxVar.jdM;
                    }
                }
                if (i <= 0 || bi.oW(vxVar.rzo) || bi.oW(vxVar.rzq)) {
                    String cu;
                    String cv;
                    x.i("MicroMsg.WNNoteBase", "datalist.get[%d].type = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(vxVar.bjS)});
                    String str = vxVar.rzM;
                    if (FileOp.cn(str)) {
                        x.i("MicroMsg.WNNoteBase", "datapath exist,pathname:%s", new Object[]{str});
                        cu = com.tencent.mm.a.g.cu(str);
                        cv = com.tencent.mm.a.g.cv(str);
                        vxVar.UM(cu);
                        vxVar.UN(cv);
                        vxVar.fO(new File(str).length());
                        cu = f.o(vxVar);
                        boolean cn = FileOp.cn(cu);
                        if (!(str.equals(cu) || cn || vxVar.rAq.equals("WeNoteHtmlFile"))) {
                            FileOp.y(str, cu);
                        }
                    } else {
                        x.e("MicroMsg.WNNoteBase", "datapath not exist, %s not exist!", new Object[]{str});
                    }
                    str = vxVar.rzO;
                    if (FileOp.cn(str)) {
                        x.i("MicroMsg.WNNoteBase", "thumbPath exist,pathname:%s", new Object[]{str});
                        cu = com.tencent.mm.a.g.cu(str);
                        cv = com.tencent.mm.a.g.cv(str);
                        vxVar.UR(cu);
                        vxVar.US(cv);
                        vxVar.fP(new File(str).length());
                        String c = f.c(vxVar);
                        if (!(str.equals(c) || FileOp.cn(c))) {
                            FileOp.y(str, c);
                        }
                    } else {
                        x.e("MicroMsg.WNNoteBase", "thumbPath not exist, pathname:%s", new Object[]{str});
                    }
                } else {
                    vxVar.kX(true);
                    vxVar.kY(true);
                }
                i++;
            }
        }
    }

    public void Sd(String str) {
    }

    public final vx Se(String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, dataId is null");
            return null;
        }
        String str2 = (String) this.qnH.get(str);
        if (bi.oW(str2)) {
            x.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, can not find editorId by dataId: %s", new Object[]{str});
            return null;
        }
        n nVar = (n) this.qnI.get(str2);
        if (nVar != null) {
            return nVar.qpb;
        }
        x.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, can not find item by editorId: %s", new Object[]{str2});
        return null;
    }

    public String bZc() {
        return "";
    }
}
