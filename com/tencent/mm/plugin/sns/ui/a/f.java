package com.tencent.mm.plugin.sns.ui.a;

import android.annotation.TargetApi;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.i$f;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.plugin.sns.ui.ar;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.atg;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.QImageView;
import java.util.LinkedList;
import java.util.List;

public final class f extends a {
    private int nUm;
    private int nUn = s$l.AppCompatTheme_checkedTextViewStyle;
    MaskImageView okd;

    public final void c(c cVar) {
        this.mActivity.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        x.i("MiroMsg.PhotoTimeLineItem", "viewtype " + this.hER);
        this.nUm = af.byw();
        if (cVar.oiQ != null) {
            if (this.hER == 2) {
                cVar.oiQ.setLayoutResource(i$g.sns_timeline_imagesline_one);
            } else if (this.hER == 3) {
                cVar.oiQ.setLayoutResource(i$g.sns_timeline_imagesline1);
            } else if (this.hER == 4) {
                cVar.oiQ.setLayoutResource(i$g.sns_timeline_imagesline2);
            } else if (this.hER == 5) {
                cVar.oiQ.setLayoutResource(i$g.sns_timeline_imagesline3);
            } else {
                x.e("MiroMsg.PhotoTimeLineItem", "error viewtyoe in photo item  " + this.hER);
            }
            if (!cVar.oiR) {
                cVar.oji = (PhotosContent) cVar.oiQ.inflate();
                cVar.oiR = true;
            }
        } else {
            cVar.oji = (PhotosContent) cVar.jEz.findViewById(i$f.photo_content);
            cVar.oiR = true;
        }
        cVar.oji.nPW.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < ar.nYx[this.hER]) {
                TagImageView tagImageView = (TagImageView) cVar.oji.findViewById(ar.nYB[i2]);
                cVar.oji.a(tagImageView);
                tagImageView.setOnClickListener(this.nuc.ntw.nNR);
                this.nuc.hql.c(tagImageView, this.nuc.ntw.okJ, this.nuc.ntw.okv);
                i = i2 + 1;
            } else {
                cVar.oji.setImageViewWidth(this.nUm);
                return;
            }
        }
    }

    @TargetApi(16)
    public final void a(c cVar, int i, ay ayVar, bsu bsu, int i2, av avVar) {
        int i3;
        cVar.oji.setVisibility(0);
        String str = bsu.sqb == null ? null : bsu.sqb.ksA;
        if (!bi.oW(str)) {
            boolean booleanValue;
            if (avVar.och.containsKey(str)) {
                booleanValue = ((Boolean) avVar.och.get(str)).booleanValue();
            } else {
                avVar.och.put(str, Boolean.valueOf(a.ezo.cU(str)));
                booleanValue = true;
            }
            if (booleanValue) {
                a.ezo.a(str, bsu.hbL, bsu.sqg, ayVar.oew);
            }
        }
        List linkedList = new LinkedList();
        int width = ((WindowManager) this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth();
        if (ayVar.nLv && i2 == 2) {
            b bAF = ayVar.nhc.bAF();
            if (bAF != null && bAF.nzp == 1 && cVar.oji.xm(0) != null) {
                ate ate;
                if (bsu.sqc == null || bsu.sqc.ruA.size() <= 0) {
                    ate = null;
                } else {
                    ate = (ate) bsu.sqc.ruA.get(0);
                }
                width = (((width - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 28);
                int i4 = (int) ((ate.rVH.rWv * ((float) width)) / ate.rVH.rWu);
                atg atg = new atg();
                atg.rWu = (float) width;
                atg.rWv = (float) i4;
                atg.rWw = atg.rWu * atg.rWv;
                linkedList.add(atg);
                i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= ar.nYx[i2]) {
                        break;
                    }
                    avVar.hql.c((TagImageView) cVar.oji.findViewById(ar.nYB[i5]), avVar.ntw.okN, avVar.ntw.okv);
                    i4 = i5 + 1;
                }
            } else if (bAF != null && bAF.nzf > 0.0f && bAF.nzg > 0.0f) {
                float a = e.a((double) bAF.nzf, 1, bAF.nzh, bAF.nzi);
                float a2 = e.a((double) bAF.nzg, 1, bAF.nzh, bAF.nzi);
                atg atg2;
                if (bAF.nze == 0) {
                    atg atg3 = new atg();
                    atg3.rWu = a;
                    atg3.rWv = a2;
                    if (a >= ((float) (((width - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 12)))) {
                        atg3.rWu = (float) (((width - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 12));
                        atg3.rWv = (float) ((int) ((atg3.rWu * bAF.nzg) / bAF.nzf));
                    }
                    atg3.rWw = atg3.rWu * atg3.rWv;
                    linkedList.add(atg3);
                } else if (bAF.nze == 1) {
                    width = (((width - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 12);
                    i3 = (int) ((((float) width) * bAF.nzg) / bAF.nzf);
                    atg2 = new atg();
                    if (width > 0) {
                        a = (float) width;
                    }
                    atg2.rWu = a;
                    if (i3 > 0) {
                        a = (float) i3;
                    } else {
                        a = a2;
                    }
                    atg2.rWv = a;
                    atg2.rWw = atg2.rWu * atg2.rWv;
                    linkedList.add(atg2);
                } else if (bAF.nze == 2) {
                    width = ((width - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 12);
                    i3 = (int) ((((float) width) * bAF.nzg) / bAF.nzf);
                    atg2 = new atg();
                    if (width > 0) {
                        a = (float) width;
                    }
                    atg2.rWu = a;
                    if (i3 > 0) {
                        a2 = (float) i3;
                    }
                    atg2.rWv = a2;
                    atg2.rWw = atg2.rWu * atg2.rWv;
                    linkedList.add(atg2);
                }
            }
            if (!bi.oW(bAF.nzk)) {
                d.b("adId", bAF.nzk, false, 41, new 1(this, cVar.oji, bAF, cVar.oji.xm(0)));
            }
        }
        ar arVar = avVar.nUc;
        PhotosContent photosContent = cVar.oji;
        String str2 = ayVar.nMU;
        i3 = this.mActivity.hashCode();
        boolean z = this.nTx;
        com.tencent.mm.storage.av clT = com.tencent.mm.storage.av.clT();
        clT.time = bsu.lOH;
        arVar.a(photosContent, bsu, str2, i3, i2, i, z, clT, linkedList);
        cVar.oji.xm(0).setScaleType(QImageView.a.uHR);
        cVar.ojX.setTag(cVar.oji.xm(0));
        cVar.ojY.setTag(cVar.oji.xm(0));
    }
}
