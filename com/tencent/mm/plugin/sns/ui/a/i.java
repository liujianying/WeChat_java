package com.tencent.mm.plugin.sns.ui.a;

import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public final class i extends a {
    private int mScreenHeight;
    private int mScreenWidth;
    private e okp = new 1(this);

    public final void c(c cVar) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.mActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.mScreenWidth = displayMetrics.widthPixels;
        this.mScreenHeight = displayMetrics.heightPixels;
        if (cVar.oiQ != null) {
            cVar.oiQ.setLayoutResource(g.sns_media_sight_item);
            cVar.ojF = (ViewStub) cVar.jEz.findViewById(f.images_keeper_li);
            if (!cVar.ojG) {
                cVar.ojH.nRB = cVar.ojF.inflate();
                cVar.ojG = true;
            }
        } else {
            cVar.ojH.nRB = cVar.jEz.findViewById(f.sns_media_sight_item);
            cVar.ojG = true;
        }
        cVar.ojH.nRC = cVar.ojH.nRB.findViewById(f.chatting_click_area);
        cVar.ojH.neL = (a) cVar.ojH.nRB.findViewById(f.image);
        cVar.ojH.nRC.setOnClickListener(this.nuc.ntw.okS);
        cVar.ojH.nEI = (ImageView) cVar.ojH.nRB.findViewById(f.status_btn);
        cVar.ojH.nRD = (MMPinProgressBtn) cVar.ojH.nRB.findViewById(f.progress);
        cVar.ojH.nRE = (TextView) cVar.ojH.nRB.findViewById(f.endtv);
        cVar.ojH.nEJ = (TextView) cVar.ojH.nRB.findViewById(f.errorTv);
        com.tencent.mm.kernel.g.Ek();
        if (((Boolean) com.tencent.mm.kernel.g.Ei().DT().get(344065, Boolean.valueOf(false))).booleanValue()) {
            cVar.ojH.neL.setSightInfoView((TextView) ((ViewStub) cVar.ojH.nRB.findViewById(f.sight_info_viewstub)).inflate());
        }
    }

    public final void a(c cVar, int i, ay ayVar, bsu bsu, int i2, av avVar) {
        ate ate;
        if (bsu.sqc == null || bsu.sqc.ruA.size() <= 0) {
            ate = null;
        } else {
            ate = (ate) bsu.sqc.ruA.get(0);
        }
        x.v("MicroMsg.VideoTimeLineItem", "videoTImeline %d ", new Object[]{Integer.valueOf(i)});
        n Nk = af.byo().Nk(cVar.bSZ);
        if (!ayVar.nLv || ate == null) {
            cVar.ojH.nRE.setVisibility(8);
            cVar.ojH.neL.setOnSightCompletionAction(null);
            cVar.ojH.neL.setOnCompletionListener(null);
            cVar.ojH.neL.setOnDecodeDurationListener(null);
        } else {
            long j = ayVar.oew;
            cVar.ojH.neL.setOnCompletionListener(new 2(this, avVar, j));
            if (!avVar.obV.nLJ.ey(j)) {
                cVar.ojH.neL.setOnDecodeDurationListener(new 3(this, avVar, j, cVar));
            }
        }
        cVar.ojH.a(bsu, i, ayVar.nMU, ayVar.nLv);
        cVar.ojH.nEJ.setVisibility(8);
        com.tencent.mm.plugin.sns.model.g byl = af.byl();
        if (bsu.sqc == null || bsu.sqc.ruA.size() <= 0) {
            a aVar = cVar.ojH.neL;
            byl.a(aVar, "", -1, this.mActivity.hashCode());
            aVar.setThumbBmp(null);
            aVar.aO(null, false);
        } else {
            int fromDPToPix;
            Pair create;
            int intValue;
            LayoutParams layoutParams;
            a aVar2;
            int hashCode;
            com.tencent.mm.storage.av clT;
            boolean z;
            long nanoTime = System.nanoTime() - System.nanoTime();
            x.i("MicroMsg.VideoTimeLineItem", "isMediaSightExist %b duration %s", new Object[]{Boolean.valueOf(com.tencent.mm.plugin.sns.model.g.t(ate)), Long.valueOf(nanoTime)});
            if (com.tencent.mm.plugin.sns.model.g.t(ate)) {
                if (byl.u(ate)) {
                    cVar.ojH.nEI.setVisibility(0);
                    cVar.ojH.nRD.setVisibility(8);
                    cVar.ojH.nEI.setImageDrawable(com.tencent.mm.bp.a.f(this.mActivity, com.tencent.mm.plugin.sns.i.i.shortvideo_play_btn));
                    cVar.ojH.nEI.setContentDescription(this.mActivity.getString(j.play_sight_desc));
                } else if (byl.v(ate)) {
                    cVar.ojH.nEI.setVisibility(8);
                    cVar.ojH.nRD.setVisibility(8);
                } else if (!ayVar.nLv || byl.b(Nk, null) > 5) {
                    byl.y(ate);
                    cVar.ojH.nEI.setVisibility(0);
                    cVar.ojH.nRD.setVisibility(8);
                    cVar.ojH.nEI.setImageDrawable(com.tencent.mm.bp.a.f(this.mActivity, com.tencent.mm.plugin.sns.i.i.shortvideo_play_btn));
                    cVar.ojH.nEI.setContentDescription(this.mActivity.getString(j.play_sight_desc));
                } else {
                    cVar.ojH.nEI.setVisibility(8);
                    cVar.ojH.nRD.setVisibility(8);
                }
                if (cVar.ojH.neL.bvF()) {
                    x.d("MicroMsg.VideoTimeLineItem", "play video error " + ate.ksA + " " + ate.jPK + " " + ate.rVE + " " + i);
                    byl.y(ate);
                    cVar.ojH.nEI.setVisibility(0);
                    cVar.ojH.nRD.setVisibility(8);
                    cVar.ojH.nEI.setImageDrawable(com.tencent.mm.bp.a.f(this.mActivity, com.tencent.mm.plugin.sns.i.i.shortvideo_play_btn));
                    cVar.ojH.nEI.setContentDescription(this.mActivity.getString(j.play_sight_desc));
                }
            } else if (byl.w(ate)) {
                cVar.ojH.nEI.setVisibility(8);
                cVar.ojH.nRD.setVisibility(0);
                cVar.ojH.nRD.cAt();
            } else if (ayVar.nLv && byl.b(Nk, null) == 5) {
                byl.A(ate);
                cVar.ojH.nEI.setVisibility(8);
                cVar.ojH.nRD.setVisibility(0);
                cVar.ojH.nRD.cAt();
            } else if (byl.x(ate)) {
                cVar.ojH.nRD.setVisibility(8);
                cVar.ojH.nEI.setImageResource(com.tencent.mm.plugin.sns.i.e.sight_chat_error);
                cVar.ojH.nEI.setVisibility(0);
            } else {
                byl.y(ate);
                cVar.ojH.nEI.setVisibility(0);
                cVar.ojH.nRD.setVisibility(8);
                cVar.ojH.nEI.setImageDrawable(com.tencent.mm.bp.a.f(this.mActivity, com.tencent.mm.plugin.sns.i.i.shortvideo_play_btn));
                cVar.ojH.nEI.setContentDescription(this.mActivity.getString(j.play_sight_desc));
                if (!ayVar.nLv && byl.a(Nk, null) == 4) {
                    cVar.ojH.nEJ.setVisibility(0);
                } else if (ayVar.nLv && byl.b(Nk, null) == 4) {
                    cVar.ojH.nEJ.setVisibility(0);
                }
            }
            Pair a = com.tencent.mm.modelsns.e.a(cVar.ojM, cVar.ojH.neL.getUIContext(), ayVar.nLv);
            if (ayVar.nLv) {
                b bAF = ayVar.nhc.bAF();
                int width = ((WindowManager) this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth();
                if (bAF != null && bAF.nzp == 1 && cVar.ojG) {
                    fromDPToPix = (((width - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 28);
                    create = Pair.create(Integer.valueOf(fromDPToPix), Integer.valueOf((int) ((((float) fromDPToPix) * ate.rVH.rWv) / ate.rVH.rWu)));
                    intValue = ((Integer) create.first).intValue();
                    fromDPToPix = ((Integer) create.second).intValue();
                    cVar.ojH.neL.dt(intValue, fromDPToPix);
                    layoutParams = cVar.ojH.nRE.getLayoutParams();
                    layoutParams.width = intValue;
                    layoutParams.height = fromDPToPix;
                    cVar.ojH.nRE.setLayoutParams(layoutParams);
                    cVar.ojH.neL.setTagObject(cVar.ojH);
                    aVar2 = cVar.ojH.neL;
                    hashCode = this.mActivity.hashCode();
                    clT = com.tencent.mm.storage.av.clT();
                    clT.time = bsu.lOH;
                    byl.a(Nk, ate, aVar2, hashCode, i, clT, ayVar.nLv);
                    cVar.ojH.nRC.setTag(cVar.ojH);
                    cVar.ojX.setTag(cVar.ojH);
                    cVar.ojY.setTag(cVar.ojH);
                    if (FileOp.cn(an.s(af.getAccSnsPath(), ate.ksA) + com.tencent.mm.plugin.sns.data.i.j(ate))) {
                        avVar.obV.nLJ.p(ayVar.oew, false);
                    } else {
                        avVar.obV.nLJ.p(ayVar.oew, true);
                    }
                    if (ayVar.nLv) {
                    }
                    avVar.obV.nLJ.a(ayVar.oew, z, false);
                } else if (bAF != null && bAF.nzf > 0.0f && bAF.nzg > 0.0f) {
                    float a2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) bAF.nzf, 1, bAF.nzh, bAF.nzi);
                    float a3 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) bAF.nzg, 1, bAF.nzh, bAF.nzi);
                    int fromDPToPix2;
                    Pair create2;
                    if (bAF.nze == 0) {
                        if (a2 >= ((float) (((width - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 12)))) {
                            a2 = (float) (((width - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 12));
                            a3 = (float) ((int) ((bAF.nzg * a2) / bAF.nzf));
                        }
                        create = Pair.create(Integer.valueOf((int) a2), Integer.valueOf((int) a3));
                    } else if (bAF.nze == 1) {
                        fromDPToPix2 = (((width - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 12);
                        create2 = Pair.create(Integer.valueOf(fromDPToPix2), Integer.valueOf((int) ((((float) fromDPToPix2) * bAF.nzg) / bAF.nzf)));
                        cVar.oiK.setLayoutParams(new LinearLayout.LayoutParams(fromDPToPix2, -2));
                        create = create2;
                    } else if (bAF.nze == 2) {
                        fromDPToPix2 = ((width - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 12);
                        create2 = Pair.create(Integer.valueOf(fromDPToPix2), Integer.valueOf((int) ((((float) fromDPToPix2) * bAF.nzg) / bAF.nzf)));
                        cVar.oiK.setLayoutParams(new LinearLayout.LayoutParams(fromDPToPix2, -2));
                        create = create2;
                    }
                    intValue = ((Integer) create.first).intValue();
                    fromDPToPix = ((Integer) create.second).intValue();
                    cVar.ojH.neL.dt(intValue, fromDPToPix);
                    layoutParams = cVar.ojH.nRE.getLayoutParams();
                    layoutParams.width = intValue;
                    layoutParams.height = fromDPToPix;
                    cVar.ojH.nRE.setLayoutParams(layoutParams);
                    cVar.ojH.neL.setTagObject(cVar.ojH);
                    aVar2 = cVar.ojH.neL;
                    hashCode = this.mActivity.hashCode();
                    clT = com.tencent.mm.storage.av.clT();
                    clT.time = bsu.lOH;
                    byl.a(Nk, ate, aVar2, hashCode, i, clT, ayVar.nLv);
                    cVar.ojH.nRC.setTag(cVar.ojH);
                    cVar.ojX.setTag(cVar.ojH);
                    cVar.ojY.setTag(cVar.ojH);
                    if (FileOp.cn(an.s(af.getAccSnsPath(), ate.ksA) + com.tencent.mm.plugin.sns.data.i.j(ate))) {
                        avVar.obV.nLJ.p(ayVar.oew, true);
                    } else {
                        avVar.obV.nLJ.p(ayVar.oew, false);
                    }
                    z = ayVar.nLv ? af.byl().b(Nk, null) == 5 : af.byl().a(Nk, null) == 5;
                    avVar.obV.nLJ.a(ayVar.oew, z, false);
                }
            }
            create = a;
            intValue = ((Integer) create.first).intValue();
            fromDPToPix = ((Integer) create.second).intValue();
            cVar.ojH.neL.dt(intValue, fromDPToPix);
            layoutParams = cVar.ojH.nRE.getLayoutParams();
            layoutParams.width = intValue;
            layoutParams.height = fromDPToPix;
            cVar.ojH.nRE.setLayoutParams(layoutParams);
            cVar.ojH.neL.setTagObject(cVar.ojH);
            aVar2 = cVar.ojH.neL;
            hashCode = this.mActivity.hashCode();
            clT = com.tencent.mm.storage.av.clT();
            clT.time = bsu.lOH;
            byl.a(Nk, ate, aVar2, hashCode, i, clT, ayVar.nLv);
            cVar.ojH.nRC.setTag(cVar.ojH);
            cVar.ojX.setTag(cVar.ojH);
            cVar.ojY.setTag(cVar.ojH);
            if (FileOp.cn(an.s(af.getAccSnsPath(), ate.ksA) + com.tencent.mm.plugin.sns.data.i.j(ate))) {
                avVar.obV.nLJ.p(ayVar.oew, true);
            } else {
                avVar.obV.nLJ.p(ayVar.oew, false);
            }
            if (ayVar.nLv) {
            }
            avVar.obV.nLJ.a(ayVar.oew, z, false);
        }
        if (Nk == null || Nk.bzr()) {
            avVar.hql.c(cVar.ojH.nRC, avVar.ntw.okN, avVar.ntw.okv);
        } else {
            avVar.hql.c(cVar.ojH.nRC, avVar.ntw.okL, avVar.ntw.okv);
        }
    }
}
