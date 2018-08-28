package com.tencent.mm.ui.chatting.g;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import com.tencent.mm.R;
import com.tencent.mm.ab.l;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.o;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.a$c;
import com.tencent.mm.ui.chatting.a.a.c;
import com.tencent.mm.ui.chatting.d.a$b;
import com.tencent.mm.ui.chatting.gallery.d;
import com.tencent.mm.ui.chatting.gallery.g;
import com.tencent.mm.ui.chatting.gallery.g.b;
import com.tencent.mm.ui.chatting.k;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public final class e implements a, s.a, com.tencent.mm.ui.chatting.d.a.a, b {
    static int count = 0;
    private ArrayList<c> gBc = null;
    private String gBf;
    private int jub = 0;
    private Context mContext;
    private ag mHandler = new ag(Looper.getMainLooper());
    private long tNE;
    private com.tencent.mm.sdk.b.c tQa = new 9(this);
    private int tYk = 0;
    private a$b tYo;
    com.tencent.mm.ui.chatting.a.a tYp;
    private GridLayoutManager tYq;
    boolean tYr = false;
    private int tYs = 0;
    private boolean tYt = false;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ int dO(java.util.List r13) {
        /*
        r3 = 0;
        r12 = 2;
        r11 = 1;
        r2 = 0;
        if (r13 != 0) goto L_0x0007;
    L_0x0006:
        return r2;
    L_0x0007:
        r4 = r13.iterator();
        r1 = r2;
    L_0x000c:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x00fa;
    L_0x0012:
        r0 = r4.next();
        r0 = (com.tencent.mm.storage.bd) r0;
        r5 = r0.cmu();
        if (r5 != 0) goto L_0x0024;
    L_0x001e:
        r5 = com.tencent.mm.model.bf.l(r0);
        if (r5 == 0) goto L_0x0028;
    L_0x0024:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x000c;
    L_0x0028:
        r5 = com.tencent.mm.ui.chatting.gallery.b.bh(r0);
        if (r5 == 0) goto L_0x005d;
    L_0x002e:
        r5 = com.tencent.mm.ui.chatting.gallery.i.bA(r0);
        if (r5 == 0) goto L_0x011d;
    L_0x0034:
        r6 = "MicroMsg.MediaHistoryGalleryPresenter";
        r7 = "[checkLegal] getStatus:%s";
        r8 = new java.lang.Object[r11];
        r9 = r5.status;
        r9 = java.lang.Integer.valueOf(r9);
        r8[r2] = r9;
        com.tencent.mm.sdk.platformtools.x.i(r6, r7, r8);
        r0 = c(r0, r5);
    L_0x004b:
        if (r5 == 0) goto L_0x0059;
    L_0x004d:
        r5 = r5.status;
        r6 = 198; // 0xc6 float:2.77E-43 double:9.8E-322;
        if (r5 == r6) goto L_0x0059;
    L_0x0053:
        r0 = com.tencent.mm.modelsfs.FileOp.cn(r0);
        if (r0 != 0) goto L_0x011a;
    L_0x0059:
        r0 = r1 + 1;
    L_0x005b:
        r1 = r0;
        goto L_0x000c;
    L_0x005d:
        r5 = com.tencent.mm.ui.chatting.gallery.d.bv(r0);
        if (r5 == 0) goto L_0x0076;
    L_0x0063:
        r6 = "MicroMsg.MediaHistoryGalleryPresenter";
        r7 = "[checkLegal] getStatus:%s";
        r8 = new java.lang.Object[r11];
        r9 = r5.status;
        r9 = java.lang.Integer.valueOf(r9);
        r8[r2] = r9;
        com.tencent.mm.sdk.platformtools.x.i(r6, r7, r8);
    L_0x0076:
        r6 = r0.getType();
        r7 = 268435505; // 0x10000031 float:2.5243696E-29 double:1.32624761E-315;
        if (r6 != r7) goto L_0x00ba;
    L_0x007f:
        r0 = com.tencent.mm.ui.chatting.gallery.b.bq(r0);
        r5 = "MicroMsg.MediaHistoryGalleryPresenter";
        r6 = "[checkLegal] is appmsg! null?%s,exists:%s";
        r7 = new java.lang.Object[r12];
        r8 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        r8 = java.lang.Boolean.valueOf(r8);
        r7[r2] = r8;
        r8 = new java.io.File;
        r9 = "";
        r9 = com.tencent.mm.sdk.platformtools.bi.aG(r0, r9);
        r8.<init>(r9);
        r8 = r8.exists();
        r8 = java.lang.Boolean.valueOf(r8);
        r7[r11] = r8;
        com.tencent.mm.sdk.platformtools.x.i(r5, r6, r7);
        r0 = com.tencent.mm.modelsfs.FileOp.cn(r0);
        if (r0 != 0) goto L_0x00f8;
    L_0x00b4:
        r1 = r1 + 1;
        r0 = r1;
    L_0x00b7:
        r1 = r0;
        goto L_0x000c;
    L_0x00ba:
        if (r5 == 0) goto L_0x0118;
    L_0x00bc:
        r0 = com.tencent.mm.ui.chatting.gallery.d.d(r0, r5);
    L_0x00c0:
        r6 = "MicroMsg.MediaHistoryGalleryPresenter";
        r7 = "[checkLegal] null?%s,exists:%s";
        r8 = new java.lang.Object[r12];
        r9 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        r9 = java.lang.Boolean.valueOf(r9);
        r8[r2] = r9;
        r9 = new java.io.File;
        r10 = "";
        r10 = com.tencent.mm.sdk.platformtools.bi.aG(r0, r10);
        r9.<init>(r10);
        r9 = r9.exists();
        r9 = java.lang.Boolean.valueOf(r9);
        r8[r11] = r9;
        com.tencent.mm.sdk.platformtools.x.i(r6, r7, r8);
        if (r5 == 0) goto L_0x00b4;
    L_0x00ed:
        r5 = r5.status;
        r6 = -1;
        if (r5 == r6) goto L_0x00b4;
    L_0x00f2:
        r0 = com.tencent.mm.modelsfs.FileOp.cn(r0);
        if (r0 == 0) goto L_0x00b4;
    L_0x00f8:
        r0 = r1;
        goto L_0x00b7;
    L_0x00fa:
        r0 = "MicroMsg.MediaHistoryGalleryPresenter";
        r3 = "[checkLegal] count:%s size:%s";
        r4 = new java.lang.Object[r12];
        r5 = java.lang.Integer.valueOf(r1);
        r4[r2] = r5;
        r2 = r13.size();
        r2 = java.lang.Integer.valueOf(r2);
        r4[r11] = r2;
        com.tencent.mm.sdk.platformtools.x.i(r0, r3, r4);
        r2 = r1;
        goto L_0x0006;
    L_0x0118:
        r0 = r3;
        goto L_0x00c0;
    L_0x011a:
        r0 = r1;
        goto L_0x005b;
    L_0x011d:
        r0 = r3;
        goto L_0x004b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.g.e.dO(java.util.List):int");
    }

    public final /* bridge */ /* synthetic */ RecyclerView.a cwv() {
        return this.tYp;
    }

    public e(Context context) {
        this.mContext = context;
        this.gBc = new ArrayList();
    }

    public final void onDetach() {
        this.tQa.dead();
        this.tYo.a(null);
        this.tYo = null;
        o.Pg().a(this);
        com.tencent.mm.modelvideo.o.Ta().a(this);
        g.a.cwU().detach();
    }

    public final <T extends h> T cwu() {
        if (this.tYq == null) {
            this.tYq = new GridLayoutManager(4);
            this.tYq.OA = new 1(this);
        }
        return this.tYq;
    }

    public final RecyclerView.g gN(Context context) {
        return new 8(this, context);
    }

    public final RecyclerView.a ay(String str, long j) {
        this.gBf = str;
        this.tNE = j;
        if (j == -1) {
            this.tYp = new com.tencent.mm.ui.chatting.a.a(this.mContext, this.gBc, str);
        } else {
            this.tYp = new com.tencent.mm.ui.chatting.a.a(this.mContext, this.gBc, str, j);
        }
        this.tYp.tNG = new 10(this);
        return this.tYp;
    }

    public final String Wm() {
        return this.mContext.getString(R.l.all_pictures_video);
    }

    public final void Fi(int i) {
        x.i("MicroMsg.MediaHistoryGalleryPresenter", "[handleSelectedItem] type:%s", new Object[]{Integer.valueOf(i)});
        List<bd> list = g.a.cwU().tTJ;
        switch (i) {
            case 0:
                com.tencent.mm.plugin.report.service.h.mEJ.a(219, 19, 1, true);
                k.a(this.mContext, list, this.gBf.toLowerCase().endsWith("@chatroom"), this.gBf, new 6(this));
                this.tYo.cwy();
                return;
            case 1:
                com.tencent.mm.plugin.report.service.h.mEJ.a(219, 18, 1, true);
                ch chVar = new ch();
                if (com.tencent.mm.pluginsdk.model.g.a(this.mContext, chVar, this.gBf, list, false, false)) {
                    b(chVar);
                    dN(list);
                } else if (list.size() > 1) {
                    com.tencent.mm.ui.base.h.a(this.mContext, chVar.bJF.bJL >= 0 ? this.mContext.getString(R.l.favorite_fail_recordtype_error) : this.mContext.getString(R.l.favorite_fail_record_expired_bigfile), "", chVar.bJF.bJL >= 0 ? this.mContext.getString(R.l.confirm_dialog_ok) : this.mContext.getString(R.l.plugin_favorite_opt), this.mContext.getString(R.l.confirm_dialog_cancel), new 4(this, chVar, list), null);
                } else {
                    com.tencent.mm.ui.base.h.i(this.mContext, chVar.bJF.bJL, 0);
                }
                this.tYo.cwy();
                return;
            case 2:
                dM(list);
                return;
            case 3:
                this.tYo.cwB();
                List arrayList = new ArrayList();
                for (bd bdVar : list) {
                    if (!(com.tencent.mm.ui.chatting.gallery.b.bi(bdVar) || com.tencent.mm.ui.chatting.gallery.b.bj(bdVar))) {
                        arrayList.add(bdVar);
                    }
                }
                if (arrayList.size() != list.size()) {
                    com.tencent.mm.ui.base.h.a(this.mContext, R.l.gallery_save_sight_tips, R.l.app_tip, new 15(this, arrayList), null);
                    return;
                } else {
                    dL(arrayList);
                    return;
                }
            default:
                return;
        }
    }

    public final int cww() {
        return g.a.cwU().tTJ.size();
    }

    public final void cwx() {
        this.tYp.tNH = true;
        g.a.cwU().tVs = true;
        GridLayoutManager gridLayoutManager = (GridLayoutManager) cwu();
        int fi = gridLayoutManager.fi();
        this.tYp.b(fi, (gridLayoutManager.fj() - fi) + 1, Integer.valueOf(0));
    }

    public final void cwy() {
        this.tYp.tNH = false;
        g.a.cwU().clear();
        g.a.cwU().tVs = false;
        this.tYp.RR.notifyChanged();
    }

    public final boolean cwz() {
        return g.a.cwU().tVs;
    }

    public final void onResume() {
        if (this.tYr && g.a.cwU().tVs) {
            this.tYo.Fj(g.a.cwU().tTJ.size());
            this.tYp.RR.notifyChanged();
        }
    }

    public final void cwS() {
        this.tYr = true;
    }

    public final void clear() {
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, l lVar) {
        x.d("MicroMsg.MediaHistoryGalleryPresenter", "[onImgTaskProgress] offset:%s totalLen:%s", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)});
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, l lVar) {
        x.i("MicroMsg.MediaHistoryGalleryPresenter", "[onImgTaskEnd] mNeedDownloadCount:%s imgLocalId:%s msgLocalId:%s err[%s:%s:%s]", new Object[]{Integer.valueOf(this.tYs), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(i4), str});
        if (this.tYo.cwD()) {
            this.tYs--;
            au.HU();
            if (!com.tencent.mm.ui.chatting.gallery.b.b(this.mContext, com.tencent.mm.model.c.FT().dW(j2), false)) {
                this.tYt = true;
            }
            if (!cxH()) {
                return;
            }
            if (this.tYt) {
                this.mHandler.post(new 12(this));
            } else {
                this.mHandler.post(new Runnable() {
                    public final void run() {
                        if (e.this.tYo != null) {
                            e.this.tYo.cwC();
                        }
                    }
                });
            }
        }
    }

    public final void a(long j, long j2, int i, int i2, Object obj) {
    }

    public final void cwA() {
        o.Pg().a(this);
        com.tencent.mm.modelvideo.o.Ta().a(this);
        this.tYo.cwA();
    }

    public final void a(s.a.a aVar) {
        if (this.tYo.cwD()) {
            r nW = t.nW(aVar.fileName);
            x.d("MicroMsg.MediaHistoryGalleryPresenter", "[notifyChanged] mNeedDownloadCount:%s statusType:%s %s", new Object[]{Integer.valueOf(this.tYs), aVar.eod, aVar.fileName});
            if (nW == null) {
                x.e("MicroMsg.MediaHistoryGalleryPresenter", "[notifyChanged] videoInfo is null!");
                cwA();
                this.tYo.Fk(0);
            } else if (nW.Tp()) {
                this.tYs--;
                au.HU();
                com.tencent.mm.ui.chatting.gallery.b.a(this.mContext, com.tencent.mm.model.c.FT().dW((long) nW.enN), false);
            }
            if (!cxH()) {
                return;
            }
            if (this.tYt) {
                this.mHandler.post(new 13(this));
            } else {
                this.mHandler.post(new 14(this));
            }
        }
    }

    private void dL(final List<bd> list) {
        com.tencent.mm.sdk.f.e.post(new Runnable() {
            public final void run() {
                int dO = e.dO(list);
                if (list.size() == dO) {
                    e.this.mHandler.post(new 1(this));
                    return;
                }
                e.this.tYt = dO > 0;
                List<bd> b = e.b(e.this, list);
                List<bd> c = e.c(e.this, list);
                x.i("MicroMsg.MediaHistoryGalleryPresenter", "[innerHandleSave] needDownloadImageList size:%s needDownloadVideoList:%s", new Object[]{Integer.valueOf(b.size()), Integer.valueOf(c.size())});
                e.this.tYs = b.size() + c.size();
                if (ao.isWifi(ad.getContext()) || e.this.tYs != list.size()) {
                    for (bd bdVar : b) {
                        e.a(e.this, bdVar, d.bv(bdVar));
                    }
                    for (bd bdVar2 : c) {
                        e.a(e.this, bdVar2);
                    }
                    if (e.this.tYt) {
                        e.this.mHandler.post(new Runnable() {
                            public final void run() {
                                e.this.tYo.Fk(R.l.gallery_selected_save_err_part);
                            }
                        });
                    }
                    if (e.this.cxH() && !e.this.tYt) {
                        e.this.mHandler.post(new 4(this));
                        return;
                    }
                    return;
                }
                e.this.mHandler.post(new 2(this));
            }
        }, "handleSave");
    }

    private boolean cxH() {
        return this.tYs == 0;
    }

    private static String c(bd bdVar, r rVar) {
        String Tl;
        if (rVar.enT == -1) {
            Tl = rVar.Tl();
            if (com.tencent.mm.a.e.cn(Tl)) {
                return Tl;
            }
            com.tencent.mm.modelvideo.o.Ta();
            return s.nK(bdVar.field_imgPath);
        }
        com.tencent.mm.modelvideo.o.Ta();
        Tl = s.nK(bdVar.field_imgPath);
        if (bdVar.field_isSend != 1 || rVar.enW == null || !rVar.enW.rUP) {
            return Tl;
        }
        try {
            String mK = FileOp.mK(Tl);
            if (!mK.endsWith("/")) {
                mK = mK + "/";
            }
            mK = mK + com.tencent.mm.a.e.cq(Tl) + "_hd.mp4";
            x.i("MicroMsg.MediaHistoryGalleryPresenter", "local capture video, hdFilePath: %s, exist: %s", new Object[]{mK, Boolean.valueOf(FileOp.cn(mK))});
            if (!FileOp.cn(mK)) {
                mK = Tl;
            }
            return mK;
        } catch (Exception e) {
            x.e("MicroMsg.MediaHistoryGalleryPresenter", "try to get hd filePath error: %s", new Object[]{e.getMessage()});
            return Tl;
        }
    }

    private void dM(List<bd> list) {
        com.tencent.mm.plugin.report.service.h.mEJ.h(11627, new Object[]{Integer.valueOf(5)});
        Set treeSet = new TreeSet();
        for (bd bdVar : list) {
            treeSet.add(Long.valueOf(bdVar.field_msgId));
        }
        com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(R.l.confirm_delete), "", this.mContext.getString(R.l.delete_message), this.mContext.getString(R.l.app_cancel), new 5(this, treeSet, list), null);
    }

    private static void dN(List<bd> list) {
        for (bd a : list) {
            com.tencent.mm.ui.chatting.a.a(a$c.Fav, com.tencent.mm.ui.chatting.a.d.tFZ, a, 0);
        }
    }

    private void b(ch chVar) {
        chVar.bJF.bJM = 45;
        chVar.bJF.activity = (Activity) this.mContext;
        com.tencent.mm.sdk.b.a.sFg.m(chVar);
        if (chVar.bJG.ret != -2 && chVar.bJG.ret <= 0 && chVar.bJG.ret <= 0) {
            if (14 != chVar.bJF.type) {
                x.d("MicroMsg.MediaHistoryGalleryPresenter", "not record type, do not report");
            } else if (chVar.bJF.bJI == null) {
                x.e("MicroMsg.MediaHistoryGalleryPresenter", "want to report record fav, but type count is null");
            } else {
                com.tencent.mm.plugin.report.service.h.mEJ.h(11142, new Object[]{Integer.valueOf(chVar.bJF.bJI.rBY), Integer.valueOf(chVar.bJF.bJI.rBZ), Integer.valueOf(chVar.bJF.bJI.rCa), Integer.valueOf(chVar.bJF.bJI.rCb), Integer.valueOf(chVar.bJF.bJI.rCc), Integer.valueOf(chVar.bJF.bJI.rCd), Integer.valueOf(chVar.bJF.bJI.rCe), Integer.valueOf(chVar.bJF.bJI.rCf), Integer.valueOf(chVar.bJF.bJI.rCg), Integer.valueOf(chVar.bJF.bJI.rCh), Integer.valueOf(chVar.bJF.bJI.rCi), Integer.valueOf(chVar.bJF.bJI.rCj), Integer.valueOf(chVar.bJF.bJI.rCk), Integer.valueOf(chVar.bJF.bJI.rCl), Integer.valueOf(chVar.bJF.bJI.rCm)});
            }
        }
    }

    public final void x(boolean z, int i) {
        if (z || this.jub + this.tYk != this.gBc.size()) {
            this.tYp.tNF = true;
            this.tYo.ma(z);
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Em().H(new 7(this, z, i));
            return;
        }
        x.i("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] that's all msg :%s offset:%s", new Object[]{Integer.valueOf(this.jub), Integer.valueOf(i)});
    }
}
