package com.tencent.mm.ui.chatting.gallery;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ak.d$a;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.l;
import com.tencent.mm.ak.o;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.model.au;
import com.tencent.mm.model.br;
import com.tencent.mm.model.m;
import com.tencent.mm.model.q;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.a.d;
import com.tencent.mm.ui.chatting.gallery.j.5;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.y.g;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

@SuppressLint({"UseSparseArrays"})
public final class b extends t {
    public static long hpD = -1;
    public static boolean qIZ = false;
    private String tTA;
    boolean tTB = true;
    public boolean tTC = false;
    public d tTD;
    public i tTE;
    public h tTF;
    public c tTG;
    boolean tTH;
    protected boolean tTI = true;
    private ArrayList<bd> tTJ = new ArrayList();
    public ImageGalleryUI tTy;
    protected a tTz;

    public interface c {
        void iy();
    }

    public b(ImageGalleryUI imageGalleryUI, long j, String str, boolean z, long j2, boolean z2, String str2, Boolean bool) {
        String str3 = "MicroMsg.ImageGalleryAdapter, invalid argument, context = " + imageGalleryUI + ", currentMsgId = " + j + ", talker = " + str + ", stack = " + bi.cjd();
        boolean z3 = imageGalleryUI != null && j > 0 && str != null && str.length() > 0;
        Assert.assertTrue(str3, z3);
        this.tTy = imageGalleryUI;
        qIZ = z;
        hpD = j2;
        this.tTz = new a(j, str, this, bool);
        this.tTC = z2;
        this.tTA = str2;
        this.tTD = new d(this);
        this.tTE = new i(this);
        this.tTF = new h(this);
    }

    public final void O(int i) {
        if (this.tTD != null && bg(ES(i))) {
            this.tTD.tUQ.O(i);
        }
    }

    public final int getCount() {
        a aVar = this.tTz;
        return ((aVar.edl - aVar.tTP) + 100000) + 1;
    }

    public final int aFL() {
        return this.tTz.edl;
    }

    public final bd ES(int i) {
        return this.tTz.Fx(i);
    }

    public final void cwL() {
        this.tTz.cwL();
    }

    public final e h(bd bdVar, boolean z) {
        return this.tTD.h(bdVar, z);
    }

    public static boolean bg(bd bdVar) {
        if (bdVar == null) {
            return false;
        }
        if (bdVar.getType() == 3 || bdVar.getType() == 39 || bdVar.getType() == 13) {
            return true;
        }
        return false;
    }

    public static boolean bh(bd bdVar) {
        if (bdVar == null || bn(bdVar)) {
            return false;
        }
        if (bdVar.getType() == 43 || bdVar.getType() == 44 || bdVar.getType() == 62) {
            return true;
        }
        return false;
    }

    public static boolean bi(bd bdVar) {
        if (bdVar != null && bdVar.getType() == 62) {
            return true;
        }
        return false;
    }

    public static boolean bj(bd bdVar) {
        if (bdVar != null && bdVar.getType() == 49) {
            return true;
        }
        return false;
    }

    public static boolean bk(bd bdVar) {
        if (bdVar != null && bdVar.getType() == 268435505) {
            return true;
        }
        return false;
    }

    public final boolean bl(bd bdVar) {
        if (bdVar == null) {
            return false;
        }
        e h = h(bdVar, false);
        if (h == null) {
            r bA = i.bA(bdVar);
            if (bA == null || bA == null) {
                return false;
            }
            int i = bA.status;
            boolean z = (i == 112 || i == 122) && com.tencent.mm.modelvideo.t.f(bA) < 100;
            x.i("MicroMsg.ImageGalleryAdapter", "it is video downloading %b, status %d, download progress %d", new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(r2)});
            return z;
        } else if (bdVar == null || h == null) {
            return false;
        } else {
            if (o.Pg().a(h.dTK, bdVar.field_msgId, 0) || a(bdVar, h)) {
                return true;
            }
            return false;
        }
    }

    public static boolean a(bd bdVar, e eVar) {
        if (bdVar == null || eVar == null) {
            return false;
        }
        return o.Pg().a(eVar.dTK, bdVar.field_msgId, 1);
    }

    public final void Fn(int i) {
        bd ES = ES(i);
        switch (2.tTN[bm(ES).ordinal()]) {
            case 1:
            case 2:
                bo(ES);
                return;
            case 3:
                String bq = bq(ES);
                Intent intent = new Intent(this.tTy, MsgRetransmitUI.class);
                intent.putExtra("Retr_File_Name", bq);
                intent.putExtra("Retr_Msg_Id", ES.field_msgId);
                intent.putExtra("Retr_Msg_Type", 16);
                intent.putExtra("Retr_Msg_content", ES.field_content);
                intent.putExtra("Retr_Compress_Type", 0);
                this.tTy.startActivity(intent);
                return;
            default:
                bp(ES);
                return;
        }
    }

    public final void Fo(int i) {
        bd ES = ES(i);
        switch (2.tTN[bm(ES).ordinal()]) {
            case 1:
            case 2:
            case 4:
                Intent intent = new Intent(this.tTy, ChattingSendDataToDeviceUI.class);
                intent.putExtra("Retr_Msg_Id", ES.field_msgId);
                this.tTy.startActivity(intent);
                return;
            default:
                return;
        }
    }

    public static b bm(bd bdVar) {
        b bVar = b.tUc;
        if (bdVar == null) {
            bVar = b.tUc;
        }
        if (bk(bdVar)) {
            return b.tUg;
        }
        if (bg(bdVar)) {
            return b.tUd;
        }
        if (bn(bdVar)) {
            return b.tUf;
        }
        if (bh(bdVar)) {
            return b.tUe;
        }
        if (bi(bdVar)) {
            return b.tUe;
        }
        return b.tUc;
    }

    private static boolean bn(bd bdVar) {
        if (bdVar != null) {
            r nW = com.tencent.mm.modelvideo.t.nW(bdVar.field_imgPath);
            if (!(nW == null || nW.enV == null || (bi.oW(nW.enV.dyJ) && nW.enV.rBq <= 0 && bi.oW(nW.enV.dyM) && bi.oW(nW.enV.dyN) && bi.oW(nW.enV.dyL) && bi.oW(nW.enV.dyO) && bi.oW(nW.enV.dyP) && bi.oW(nW.enV.dyQ)))) {
                return true;
            }
        }
        return false;
    }

    public final void bo(bd bdVar) {
        au.HU();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
            r nW = com.tencent.mm.modelvideo.t.nW(bdVar.field_imgPath);
            if (nW == null) {
                x.e("MicroMsg.ImageGalleryAdapter", "videoInfo should not be null");
                return;
            }
            Intent intent = new Intent(this.tTy, MsgRetransmitUI.class);
            intent.putExtra("Retr_length", nW.enM);
            intent.putExtra("Retr_File_Name", bdVar.field_imgPath);
            intent.putExtra("Retr_video_isexport", nW.enQ);
            intent.putExtra("Retr_Msg_Type", bi(bdVar) ? 11 : 1);
            intent.putExtra("Retr_Msg_Id", bdVar.field_msgId);
            intent.putExtra("Retr_From", "gallery");
            this.tTy.startActivity(intent);
            return;
        }
        s.gH(this.tTy);
    }

    public final void bp(bd bdVar) {
        e bv = d.bv(bdVar);
        if (bdVar == null || bdVar.field_msgId == 0 || bv == null || bv.dTK == 0) {
            Object obj;
            String str = "MicroMsg.ImageGalleryAdapter";
            StringBuilder stringBuilder = new StringBuilder("doRestransmitMsg fail, msgLocalId = ");
            if (bdVar == null) {
                obj = "null";
            } else {
                obj = Long.valueOf(bdVar.field_msgId);
            }
            stringBuilder = stringBuilder.append(obj).append(", imgLocalId = ");
            if (bv == null) {
                obj = "null";
            } else {
                obj = Long.valueOf(bv.dTK);
            }
            x.e(str, stringBuilder.append(obj).toString());
            return;
        }
        String d = d.d(bdVar, bv);
        if (d == null || d.length() == 0) {
            x.e("MicroMsg.ImageGalleryAdapter", "doRestransmitMsg fail, bigImgPath is null, msgLocalId = " + bdVar.field_msgId + ", imgLocalId = " + bv.dTK);
        } else if (bi.oW(this.tTA)) {
            x.i("MicroMsg.ImageGalleryAdapter", "directly send user is empty, select one");
            Intent intent = new Intent(this.tTy, MsgRetransmitUI.class);
            intent.putExtra("Retr_File_Name", d);
            intent.putExtra("Retr_Msg_Id", bdVar.field_msgId);
            intent.putExtra("Retr_Msg_Type", 0);
            intent.putExtra("Retr_Compress_Type", b(bdVar, bv));
            this.tTy.startActivity(intent);
        } else {
            int i;
            x.i("MicroMsg.ImageGalleryAdapter", "directly send user %s", new Object[]{this.tTA});
            if (bdVar.field_isSend == 1) {
                if (bv.ON()) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else if (bv.ON()) {
                if (com.tencent.mm.a.e.cn(o.Pf().o(f.a(bv).dTL, "", ""))) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
                i = 0;
            }
            String GF = q.GF();
            String o = o.Pf().o(f.c(bv), "", "");
            if (!bi.oW(o)) {
                x.i("MicroMsg.ImageGalleryAdapter", "connector click[img]: to[%s] fileName[%s]", new Object[]{bv, o});
                au.DF().a(new l(GF, this.tTA, o, i), 0);
                br.IE().c(br.dDm, null);
            }
            if (this.tTB) {
                Intent intent2 = new Intent(this.tTy, ChattingUI.class);
                intent2.addFlags(67108864);
                intent2.putExtra("Chat_User", this.tTA);
                this.tTy.startActivity(intent2);
            } else {
                h.bA(this.tTy, this.tTy.getString(R.l.app_saved));
            }
            com.tencent.mm.plugin.report.service.h.mEJ.h(10424, new Object[]{Integer.valueOf(3), Integer.valueOf(4), this.tTA});
        }
    }

    public static boolean e(Context context, List<bd> list) {
        if (context == null || list == null || list.size() <= 0) {
            return false;
        }
        boolean z = list.size() <= 1;
        boolean z2 = false;
        for (bd bdVar : list) {
            boolean a;
            if (bh(bdVar)) {
                a = a(context, bdVar, z);
            } else {
                a = b(context, bdVar, z);
            }
            if (z2 || !a) {
                a = z2;
            } else {
                a = true;
            }
            z2 = a;
        }
        if (!z2 && !z) {
            Toast.makeText(context, context.getString(R.l.save_image_or_video_err), 1).show();
            return true;
        } else if (!z2 || z) {
            return true;
        } else {
            Toast.makeText(context, context.getString(R.l.exports_file_saved, new Object[]{com.tencent.mm.compatible.util.e.dgl}), 1).show();
            return true;
        }
    }

    public static boolean a(Context context, bd bdVar, boolean z) {
        if (bdVar == null) {
            return false;
        }
        boolean z2;
        r nI = com.tencent.mm.modelvideo.o.Ta().nI(bdVar.field_imgPath);
        if (nI != null) {
            int gK;
            if (com.tencent.mm.model.s.fq(nI.Tj())) {
                gK = m.gK(nI.Tj());
            } else {
                gK = 0;
            }
            boolean Tp = nI.Tp();
            com.tencent.mm.plugin.report.service.h.mEJ.a(106, 216, 1, false);
            com.tencent.mm.plugin.report.service.h.mEJ.h(12084, new Object[]{Integer.valueOf(nI.dHI), Integer.valueOf(nI.enM * 1000), Integer.valueOf(0), Integer.valueOf(2), nI.Tj(), Integer.valueOf(gK), r.nH(nI.Tm()), Long.valueOf(nI.createTime)});
            z2 = Tp;
        } else {
            z2 = false;
        }
        if (z2) {
            com.tencent.mm.modelvideo.o.Ta();
            String nX = com.tencent.mm.modelvideo.t.nX(com.tencent.mm.modelvideo.s.nK(bdVar.field_imgPath));
            if (!bi.oW(nX)) {
                if (z) {
                    Toast.makeText(context, context.getString(R.l.video_file_saved, new Object[]{nX}), 1).show();
                }
                com.tencent.mm.pluginsdk.ui.tools.l.a(nX, context);
                return true;
            } else if (!z) {
                return false;
            } else {
                Toast.makeText(context, context.getString(R.l.video_file_save_failed), 1).show();
                return false;
            }
        }
        x.w("MicroMsg.ImageGalleryAdapter", "do export video but video had not download finish.");
        if (!z) {
            return false;
        }
        Toast.makeText(context, context.getString(R.l.video_file_save_failed), 1).show();
        return false;
    }

    public static boolean b(Context context, bd bdVar, boolean z) {
        String bq;
        if (bk(bdVar)) {
            bq = bq(bdVar);
        } else if (bdVar == null || bdVar.field_msgId == 0) {
            x.e("MicroMsg.ImageGalleryAdapter", "msg is null");
            if (z) {
                Toast.makeText(context, context.getString(R.l.save_image_err), 1).show();
            }
            return false;
        } else {
            e bv = d.bv(bdVar);
            if (bv == null || bv.dTK == 0) {
                x.e("MicroMsg.ImageGalleryAdapter", "doRestransmitMsg fail, msgLocalId = " + (bdVar == null ? "null" : Long.valueOf(bdVar.field_msgId)) + ", imgLocalId = " + (bv == null ? "null" : Long.valueOf(bv.dTK)));
                if (z) {
                    Toast.makeText(context, context.getString(R.l.save_image_err), 1).show();
                }
                return false;
            }
            bq = d.d(bdVar, bv);
        }
        if (bq == null || bq.length() == 0) {
            x.e("MicroMsg.ImageGalleryAdapter", "doRestransmitMsg fail, bigImgPath is null, msgLocalId = " + bdVar.field_msgId);
            if (z) {
                Toast.makeText(context, context.getString(R.l.save_image_err), 1).show();
            }
            return false;
        } else if (com.tencent.mm.platformtools.r.a(bq, context, z, R.l.cropimage_saved)) {
            return true;
        } else {
            if (z) {
                Toast.makeText(context, context.getString(R.l.save_image_err), 1).show();
            }
            return false;
        }
    }

    public final void Fp(int i) {
        bd ES = ES(i);
        ch chVar = new ch();
        com.tencent.mm.pluginsdk.model.e.a(chVar, ES);
        chVar.bJF.activity = this.tTy;
        chVar.bJF.bJM = 44;
        a.sFg.m(chVar);
        if (chVar.bJG.ret == 0) {
            if (ES.cmk()) {
                com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.c.tFU, d.tGa, ES, 0);
            }
            com.tencent.mm.modelstat.b.ehL.x(ES);
        }
    }

    /* renamed from: d */
    public final View c(int i, View view) {
        j jVar;
        bd ES = ES(i);
        if (view == null) {
            view = View.inflate(this.tTy, R.i.image_gallery_item, null);
            jVar = new j(this, view);
            view.setTag(jVar);
        } else {
            jVar = (j) view.getTag();
        }
        b bm = bm(ES);
        jVar.mPosition = i;
        jVar.tWP = bm;
        j.O(jVar.jEz, 0);
        switch (5.tTN[bm.ordinal()]) {
            case 1:
                j.O(jVar.tWX, 8);
                j.O(jVar.tWR, 8);
                break;
            case 2:
                jVar.cxz();
                j.O(jVar.tWX, 0);
                j.O(jVar.tWR, 8);
                if (jVar.tWR != null) {
                    j.O(jVar.tWT, 8);
                    break;
                }
                break;
            case 3:
                jVar.cxy();
                j.O(jVar.tWX, 8);
                j.O(jVar.tWR, 0);
                break;
            case 4:
                j.O(jVar.jEz, 8);
                j.O(jVar.tWX, 8);
                j.O(jVar.tWR, 8);
                break;
        }
        j.O(jVar.tXm, 8);
        j.O(jVar.tXn, 8);
        j.O(jVar.tXd, 8);
        j.O(jVar.tXj, 8);
        j.O(jVar.tXi, 8);
        x.d("MicroMsg.ImageGalleryAdapter", "position:%d, type: %s", new Object[]{Integer.valueOf(i), bm});
        switch (2.tTN[bm.ordinal()]) {
            case 1:
                this.tTE.a(jVar, ES, i);
                break;
            case 2:
                this.tTF.a(jVar, ES, i);
                break;
            case 3:
                Bitmap oR;
                j.O(jVar.tXm, 0);
                j.O(jVar.tXd, 8);
                j.O(jVar.tXi, 8);
                j.O(jVar.tXj, 8);
                j.O(jVar.tXb, 8);
                String bq = bq(ES);
                try {
                    oR = y.oR(bq);
                } catch (OutOfMemoryError e) {
                    x.w("MicroMsg.ImageGalleryAdapter", "[tomys] Oops, app img [%s] is too large, use resample version.", new Object[]{bq});
                    Runtime.getRuntime().gc();
                    Runtime.getRuntime().runFinalization();
                    oR = y.oQ(bq);
                }
                if (oR == null) {
                    oR = y.oQ(o.Pf().E(ES.field_imgPath, true));
                    j.O(jVar.tXi, 0);
                    new ag().post(new 1(this, ES, jVar, bq));
                }
                if (oR != null) {
                    jVar.tXm.setEnableHorLongBmpMode(false);
                    k.k(jVar.tXm, oR.getWidth(), oR.getHeight());
                    jVar.tXm.eT(oR.getWidth(), oR.getHeight());
                    jVar.tXm.setImageBitmap(oR);
                    jVar.tXm.invalidate();
                    break;
                }
                x.w("MicroMsg.ImageGalleryAdapter", "get image fail");
                jVar.tXm.setVisibility(8);
                jVar.cxx().tXj.setVisibility(0);
                jVar.cxx().tXl.setImageResource(R.k.image_download_fail_icon);
                jVar.cxx().tXk.setText(this.tTy.getString(R.l.imgdownload_fail_or_cleaned));
                break;
            case 4:
                this.tTD.a(jVar, ES, i);
                break;
        }
        this.tTI = false;
        return view;
    }

    public static String bq(bd bdVar) {
        g.a gp = g.a.gp(bdVar.field_content);
        if (gp == null || gp.bGP == null || gp.bGP.length() <= 0) {
            return null;
        }
        com.tencent.mm.pluginsdk.model.app.b SR = ao.asF().SR(gp.bGP);
        if (SR != null) {
            return SR.field_fileFullPath;
        }
        return null;
    }

    public final void detach() {
        this.tTD.detach();
        this.tTE.detach();
        this.tTF.detach();
        super.detach();
    }

    public static int b(bd bdVar, e eVar) {
        e a;
        if (bdVar.field_isSend == 1) {
            if (eVar.ON()) {
                a = f.a(eVar);
                if (a != null && a.dTK > 0 && a.OM() && com.tencent.mm.a.e.cn(o.Pf().o(a.dTL, "", ""))) {
                    return 1;
                }
            }
            return 0;
        } else if (!eVar.OM()) {
            return 0;
        } else {
            if (eVar.ON()) {
                a = f.a(eVar);
                if (a != null && a.dTK > 0 && a.OM() && com.tencent.mm.a.e.cn(o.Pf().o(a.dTL, "", ""))) {
                    return 1;
                }
            }
            return 0;
        }
    }

    public final boolean cwM() {
        return this.tTz.adE;
    }

    public final int crV() {
        return 100000 - this.tTz.tTP;
    }

    public final int crW() {
        return ((100000 - this.tTz.tTP) + this.tTz.edl) - 1;
    }

    public final void ao(int i, boolean z) {
        this.tTD.ao(i, z);
    }

    public final MultiTouchImageView qC(int i) {
        View Ep = super.Ep(i);
        if (Ep == null) {
            x.e("MicroMsg.ImageGalleryAdapter", "position : %s getMultiTouchImageViewByPosition is null", new Object[]{Integer.valueOf(i)});
            return null;
        }
        Ep = Ep.findViewById(R.h.image);
        return (Ep == null || Ep.getVisibility() == 8) ? null : (MultiTouchImageView) Ep;
    }

    public final WxImageView qD(int i) {
        View Ep = super.Ep(i);
        if (Ep == null) {
            return null;
        }
        Ep = Ep.findViewById(R.h.wx_image);
        if (Ep == null || Ep.getVisibility() == 8) {
            return null;
        }
        return (WxImageView) Ep;
    }

    public final View Fq(int i) {
        View Ep = super.Ep(i);
        if (Ep == null) {
            x.e("MicroMsg.ImageGalleryAdapter", "position : %s getVideoViewByPosition is null", new Object[]{Integer.valueOf(i)});
            return null;
        }
        View findViewById = Ep.findViewById(R.h.video_containers);
        if (findViewById == null) {
            findViewById = Ep.findViewById(R.h.video_container);
        }
        if (findViewById == null || findViewById.getVisibility() == 8) {
            return null;
        }
        return findViewById;
    }

    public final void Fr(int i) {
        this.tTE.g(ES(i), i);
    }

    public final void Fs(int i) {
        this.tTE.h(ES(i), i);
    }

    public final bd cwN() {
        return ES(this.tTy.getCurrentItem());
    }

    public final j cwO() {
        j Fl = this.tTD.Fl(this.tTy.getCurrentItem());
        if (Fl == null) {
            Fl = this.tTE.Fl(this.tTy.getCurrentItem());
        }
        if (Fl == null) {
            return this.tTF.Fl(this.tTy.getCurrentItem());
        }
        return Fl;
    }

    public final void Ft(int i) {
        this.tTE.Fm(i);
    }

    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public final void cwP() {
        this.tTE.onResume();
    }

    public final void Fu(int i) {
        bd ES = ES(i);
        if (ES != null && bg(ES)) {
            d$a d_a = this.tTD;
            e bv = d.bv(ES);
            if (bv != null && ES != null) {
                if (k.cxA().gL(ES.field_msgId)) {
                    k cxA = k.cxA();
                    cxA.tXv.remove(Long.valueOf(ES.field_msgId));
                    o.Pg().a(bv.dTK, ES.field_msgId, cxA);
                    o.Pg().l(bv.dTK, ES.field_msgId);
                    return;
                }
                o.Pg().a(bv.dTK, ES.field_msgId, d_a);
                o.Pg().l(bv.dTK, ES.field_msgId);
            }
        }
    }

    public final void Fv(int i) {
        this.tTF.FB(i);
    }

    public final void a(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
        super.a(viewGroup, i, obj);
    }
}
