package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.atg;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.av;
import com.tencent.mm.ui.widget.QFadeImageView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class ar {
    public static int[] nYA = new int[]{f.album_img_0, f.album_img_1, f.album_img_2, f.album_img_3, f.album_img_4, f.album_img_5};
    public static int[] nYB = new int[]{f.album_img_0, f.album_img_1, f.album_img_2, f.album_img_3, f.album_img_4, f.album_img_5, f.album_img_6, f.album_img_7, f.album_img_8};
    static double nYC = -1.0d;
    static double nYD = -1.0d;
    static double nYE = -1.0d;
    static double nYF = -1.0d;
    static double nYG = -1.0d;
    public static int[] nYx = new int[]{0, 0, 1, 3, 6, 9};
    public static int[] nYy = new int[]{f.album_img_0};
    public static int[] nYz = new int[]{f.album_img_0, f.album_img_1, f.album_img_2};
    private Context context;
    private LinkedList<LinearLayout> nYH = new LinkedList();

    public ar(Context context) {
        this.context = context;
    }

    public ar(Context context, byte b) {
        this.context = context;
    }

    public final void a(PhotosContent photosContent, bsu bsu, String str, int i, int i2, int i3, boolean z, av avVar, boolean z2) {
        int[] iArr = nYB;
        if (i2 == 2 || i2 == 11) {
            iArr = nYy;
        } else if (i2 == 3) {
            iArr = nYz;
        } else if (i2 == 4) {
            iArr = nYA;
        } else if (i2 == 5) {
            iArr = nYB;
        }
        List list = bsu.sqc.ruA;
        if (nYC < 0.0d) {
            nYC = (double) b.b(this.context, 160.0f);
            nYD = (double) b.b(this.context, 200.0f);
            nYE = (double) b.b(this.context, 44.0f);
            nYF = (double) b.b(this.context, 66.0f);
            nYG = (double) b.b(this.context, 300.0f);
        }
        int size = list.size();
        if (size == 0) {
            for (size = 0; size < iArr.length; size++) {
                af.byl().cx(photosContent.xm(size));
                photosContent.xm(size).setPosition(i3);
            }
            photosContent.setVisibility(8);
            return;
        }
        photosContent.setVisibility(0);
        if (size == 1) {
            for (size = 1; size < iArr.length; size++) {
                TagImageView xm = photosContent.xm(size);
                xm.setVisibility(8);
                af.byl().cx(xm);
                photosContent.xm(size).setPosition(i3);
            }
            photosContent.xm(0).setVisibility(0);
            a((ate) list.get(0), photosContent.xm(0), str, i, i3, z, avVar, i2, z2);
        }
    }

    public final void a(PhotosContent photosContent, bsu bsu, String str, int i, int i2, int i3, boolean z, av avVar, List<atg> list) {
        int[] iArr = nYB;
        if (i2 == 2 || i2 == 11) {
            iArr = nYy;
        } else if (i2 == 3) {
            iArr = nYz;
        } else if (i2 == 4) {
            iArr = nYA;
        } else if (i2 == 5) {
            iArr = nYB;
        }
        List list2 = bsu.sqc.ruA;
        if (nYC < 0.0d) {
            nYC = (double) b.b(this.context, 160.0f);
            nYD = (double) b.b(this.context, 200.0f);
            nYE = (double) b.b(this.context, 44.0f);
            nYF = (double) b.b(this.context, 66.0f);
            nYG = (double) b.b(this.context, 300.0f);
        }
        int size = list2.size();
        if (size == 0) {
            for (size = 0; size < iArr.length; size++) {
                af.byl().cx(photosContent.xm(size));
                photosContent.xm(size).setPosition(i3);
            }
            photosContent.setVisibility(8);
            return;
        }
        photosContent.setImageViewWidth(af.byw());
        photosContent.setVisibility(0);
        if (size == 1) {
            for (size = 1; size < iArr.length; size++) {
                TagImageView xm = photosContent.xm(size);
                xm.setVisibility(8);
                af.byl().cx(xm);
                photosContent.xm(size).setPosition(i3);
            }
            photosContent.xm(0).setVisibility(0);
            if (list == null || list.size() <= 0) {
                a((ate) list2.get(0), photosContent.xm(0), str, i, i3, z, avVar, i2, false);
                return;
            }
            a((ate) list2.get(0), photosContent.xm(0), str, i, i3, z, avVar, i2, false, (atg) list.get(0));
        } else if (size == 4) {
            List arrayList = new ArrayList();
            int length = iArr.length - 1;
            int i4 = 3;
            while (length >= 0) {
                TagImageView xm2 = photosContent.xm(length);
                xm2.setPosition(i3);
                if (length == 0 || length == 1 || length == 3 || length == 4) {
                    xm2.setVisibility(0);
                    arrayList.add(xm2);
                    ap apVar = new ap();
                    apVar.bNH = str;
                    size = i4 - 1;
                    apVar.index = i4;
                    apVar.nWx = arrayList;
                    apVar.nTx = z;
                    apVar.position = i3;
                    xm2.setTag(apVar);
                    a((ate) list2.get(apVar.index), xm2, i, avVar);
                    i4 = size;
                } else {
                    xm2.setVisibility(8);
                    af.byl().cx(xm2);
                }
                length--;
            }
        } else {
            List arrayList2 = new ArrayList();
            for (size = iArr.length - 1; size >= 0; size--) {
                TagImageView xm3 = photosContent.xm(size);
                xm3.setPosition(i3);
                if (size < list2.size()) {
                    xm3.setVisibility(0);
                    arrayList2.add(xm3);
                    ap apVar2 = new ap();
                    apVar2.bNH = str;
                    apVar2.index = size;
                    apVar2.nWx = arrayList2;
                    apVar2.nTx = z;
                    apVar2.position = i3;
                    xm3.setTag(apVar2);
                    a((ate) list2.get(apVar2.index), xm3, i, avVar);
                } else {
                    xm3.setVisibility(8);
                    af.byl().cx(xm3);
                }
            }
        }
    }

    private static void a(ate ate, QFadeImageView qFadeImageView, int i, av avVar) {
        af.byl().b(ate, qFadeImageView, i, avVar);
    }

    private static void a(ate ate, QFadeImageView qFadeImageView, String str, int i, int i2, boolean z, av avVar, int i3, boolean z2, atg atg) {
        if (qFadeImageView == null) {
            x.e("MicroMsg.SnsMultiLineImageLineMgr", "");
            return;
        }
        double d;
        ap apVar = new ap();
        apVar.bNH = str;
        apVar.index = 0;
        List arrayList = new ArrayList();
        arrayList.add(qFadeImageView);
        apVar.nWx = arrayList;
        apVar.nTx = z;
        apVar.position = i2;
        qFadeImageView.setTag(apVar);
        double d2 = 0.0d;
        double d3 = 0.0d;
        if (i3 == 11 && z2) {
            af.byl().c(ate, qFadeImageView, i, avVar);
        } else {
            af.byl().a(ate, qFadeImageView, i, avVar);
        }
        if (ate.rVH != null) {
            d2 = (double) ate.rVH.rWu;
            d3 = (double) ate.rVH.rWv;
        }
        if (d2 <= 0.0d || d3 <= 0.0d) {
            d = nYC;
            d3 = nYC;
        } else {
            d = Math.min(nYD / d2, nYD / d3);
            d2 *= d;
            d3 *= d;
            if (d2 < nYE) {
                d = (1.0d * nYE) / d2;
                d2 *= d;
                d3 *= d;
            }
            if (d3 < nYE) {
                d = (1.0d * nYE) / d3;
                d2 *= d;
                d3 *= d;
            }
            if (d2 > nYD) {
                d2 = nYD;
            }
            if (d3 > nYD) {
                d3 = nYD;
            }
            d = d2;
        }
        if (d < 1.0d) {
            d = 1.0d;
        }
        if (d3 < 1.0d) {
            d3 = 1.0d;
        }
        if (atg == null || atg.rWu <= 0.0f || atg.rWv <= 0.0f) {
            d2 = d3;
        } else {
            d = (double) atg.rWu;
            d2 = (double) atg.rWv;
        }
        if (qFadeImageView.getLayoutParams() instanceof LayoutParams) {
            LayoutParams layoutParams = (LayoutParams) qFadeImageView.getLayoutParams();
            if (((double) layoutParams.width) != d || ((double) layoutParams.height) != d2) {
                qFadeImageView.setLayoutParams(new LayoutParams((int) d, (int) d2));
            }
        }
    }

    private static void a(ate ate, QFadeImageView qFadeImageView, String str, int i, int i2, boolean z, av avVar, int i3, boolean z2) {
        a(ate, qFadeImageView, str, i, i2, z, avVar, i3, z2, new atg());
    }
}
