package com.tencent.mm.plugin.sns.ui.a;

import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.plugin.sns.ui.r;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.platformtools.bi;

public final class e extends a {
    public final void c(c cVar) {
        if (cVar.oiQ == null || cVar.oiQ.getParent() == null) {
            cVar.ojC = cVar.jEz.findViewById(f.media_content_rl);
            cVar.ojB = true;
        } else {
            cVar.oiQ.setLayoutResource(g.sns_media_sub_item2);
            if (!cVar.ojB) {
                cVar.ojC = cVar.oiQ.inflate();
                cVar.ojB = true;
            }
        }
        cVar.oaa = cVar.ojC;
        cVar.oiT = (TagImageView) cVar.oaa.findViewById(f.image_left);
        cVar.nLz = (ImageView) cVar.oaa.findViewById(f.state);
        cVar.oiU = (TextView) cVar.oaa.findViewById(f.righttext);
        cVar.eBO = (TextView) cVar.oaa.findViewById(f.titletext);
        cVar.eBO.setTextColor(this.mActivity.getResources().getColor(i.c.black));
        com.tencent.mm.plugin.sns.data.i.b(cVar.oiT, this.mActivity);
    }

    public final void a(c cVar, int i, ay ayVar, bsu bsu, int i2, av avVar) {
        Object obj;
        Object obj2;
        String Oa;
        CharSequence charSequence;
        CharSequence charSequence2;
        cVar.oiT.setPosition(i);
        String str = ayVar.nMU;
        n nVar = ayVar.nhc;
        Object obj3 = null;
        if (ayVar.nLv) {
            if (nVar.bAF().nzp == 2) {
                obj3 = 1;
                cVar.oaa.setTag(cVar);
                cVar.oaa.setOnClickListener(avVar.ntw.ole);
            }
            obj = obj3;
            obj2 = null;
        } else {
            if (bsu.sqc.ruz == 9) {
                if (bsu.sqc.ruA.size() > 0) {
                    cVar.oaa.setTag(new r(bsu, str));
                    cVar.oaa.setOnClickListener(avVar.nUk.ohx);
                    obj = null;
                    obj2 = null;
                }
            } else if (bsu.sqc.ruz == 10) {
                if (bsu.sqc.ruA.size() > 0) {
                    cVar.oaa.setTag(new r(bsu, str));
                    cVar.oaa.setOnClickListener(avVar.nUk.ohz);
                    obj = null;
                    obj2 = null;
                }
            } else if (bsu.sqc.ruz == 17) {
                if (bsu.sqc.ruA.size() > 0) {
                    cVar.oaa.setTag(new r(bsu, str));
                    cVar.oaa.setOnClickListener(avVar.nUk.ohA);
                    obj = null;
                    obj2 = null;
                }
            } else if (bsu.sqc.ruz == 22) {
                if (bsu.sqc.ruA.size() > 0) {
                    cVar.oaa.setTag(new r(bsu, str));
                    cVar.oaa.setOnClickListener(avVar.nUk.ohB);
                    obj = null;
                    obj2 = null;
                }
            } else if (bsu.sqc.ruz == 23) {
                if (bsu.sqc.ruA.size() > 0) {
                    cVar.oaa.setTag(new r(bsu, str));
                    cVar.oaa.setOnClickListener(avVar.nUk.ohC);
                    obj = null;
                    obj2 = null;
                }
            } else if (bsu.sqc.ruz == 14) {
                if (bsu.sqc.ruA.size() > 0) {
                    cVar.oaa.setTag(new r(bsu, str));
                    cVar.oaa.setOnClickListener(avVar.nUk.ohy);
                    obj = null;
                    obj2 = null;
                }
            } else if (bsu.sqc.ruz == 12) {
                if (bsu.sqc.ruA.size() > 0) {
                    cVar.oaa.setTag(new r(bsu, str));
                    cVar.oaa.setOnClickListener(avVar.nUk.ohG);
                    obj = null;
                    obj2 = null;
                }
            } else if (bsu.sqc.ruz == 13) {
                if (bsu.sqc.ruA.size() > 0) {
                    cVar.oaa.setTag(new r(bsu, str));
                    cVar.oaa.setOnClickListener(avVar.nUk.ohH);
                    obj = null;
                    obj2 = null;
                } else {
                    cVar.oaa.setOnClickListener(null);
                    obj = null;
                    obj2 = null;
                }
            } else if (bsu.sqc.ruz == 26) {
                cVar.oaa.setTag(new r(bsu, str));
                cVar.oaa.setOnClickListener(avVar.nUk.ohI);
                obj = null;
                obj2 = null;
            } else {
                cVar.oaa.setTag(new r(bsu, str));
                cVar.oaa.setOnClickListener(avVar.nUk.nZN);
                if ((bsu.dwt & 1) > 0) {
                    obj = null;
                    int obj22 = 1;
                }
            }
            obj = null;
            obj22 = null;
        }
        if (obj != null) {
            avVar.hql.c(cVar.oaa, avVar.ntw.okO, avVar.ntw.okv);
        } else {
            avVar.hql.c(cVar.oaa, avVar.ntw.okK, avVar.ntw.okv);
        }
        obj3 = bsu.sqc.ruz == 9 ? 1 : (a.byN() & 1) <= 0 ? 1 : null;
        if (obj3 != null) {
            Oa = av.Oa(bsu.sqc.jPK);
        } else {
            Oa = "";
        }
        if (bsu.sqc.ruz == 9 || bsu.sqc.ruz == 14 || bsu.sqc.ruz == 12 || bsu.sqc.ruz == 13 || obj != null) {
            charSequence = bsu.sqc.jOS;
        } else {
            Object charSequence3 = Oa;
        }
        Oa = bsu.sqc.bHD;
        if (Oa == null || Oa.length() <= 40) {
            Object charSequence22 = Oa;
        } else {
            charSequence22 = Oa.substring(0, 40) + "...";
        }
        cVar.nLz.setVisibility(8);
        if (!bsu.sqc.ruA.isEmpty()) {
            cVar.oiT.setVisibility(0);
            ate ate = (ate) bsu.sqc.ruA.get(0);
            com.tencent.mm.plugin.sns.model.g byl;
            TagImageView tagImageView;
            int i3;
            int hashCode;
            com.tencent.mm.storage.av clT;
            if (bsu.sqc.ruz == 5) {
                charSequence22 = ate.bHD;
                cVar.nLz.setImageResource(com.tencent.mm.plugin.sns.i.e.video_playicon_normal);
                cVar.nLz.setVisibility(0);
                byl = af.byl();
                tagImageView = cVar.oiT;
                i3 = i.i.app_attach_file_icon_video;
                hashCode = this.mActivity.hashCode();
                clT = com.tencent.mm.storage.av.clT();
                clT.time = bsu.lOH;
                byl.b(ate, tagImageView, i3, hashCode, clT);
            } else if (bsu.sqc.ruz == 18) {
                cVar.nLz.setVisibility(0);
                cVar.nLz.setImageResource(com.tencent.mm.plugin.sns.i.e.video_playicon_normal);
                cVar.oiT.setVisibility(0);
                byl = af.byl();
                tagImageView = cVar.oiT;
                i3 = i.i.app_attach_file_icon_video;
                hashCode = this.mActivity.hashCode();
                clT = com.tencent.mm.storage.av.clT();
                clT.time = bsu.lOH;
                byl.b(ate, tagImageView, i3, hashCode, clT);
            } else {
                if (!(bsu.nsD == null || bi.oW(bsu.nsD.pLr))) {
                    cVar.nLz.setImageResource(com.tencent.mm.plugin.sns.i.e.video_playicon_normal);
                    cVar.nLz.setVisibility(0);
                }
                byl = af.byl();
                tagImageView = cVar.oiT;
                i3 = this.mActivity.hashCode();
                com.tencent.mm.storage.av clT2 = com.tencent.mm.storage.av.clT();
                clT2.time = bsu.lOH;
                byl.b(ate, tagImageView, i3, clT2);
            }
        } else if (bsu.sqc.ruz == 18) {
            cVar.nLz.setVisibility(0);
            cVar.nLz.setImageResource(com.tencent.mm.plugin.sns.i.e.video_playicon_normal);
            cVar.oiT.setVisibility(0);
            af.byl().a(cVar.oiT, -1, i.i.app_attach_file_icon_video, this.mActivity.hashCode());
        } else if (bsu.sqc.ruz == 26) {
            cVar.oiT.setVisibility(0);
            af.byl().a(cVar.oiT, -1, i.i.note_sns_link_default, this.mActivity.hashCode());
        } else {
            cVar.oiT.setVisibility(0);
            af.byl().a(cVar.oiT, -1, i.i.app_attach_file_icon_webpage, this.mActivity.hashCode());
        }
        if (bi.oW(charSequence3)) {
            cVar.oiU.setVisibility(8);
        } else {
            cVar.oiU.setVisibility(0);
            cVar.oiU.setText(charSequence3);
        }
        if (!bi.oW(charSequence22)) {
            if (cVar.oiU.getVisibility() == 8) {
                if (cVar.oiV != 2) {
                    cVar.eBO.setMaxLines(2);
                }
                cVar.oiV = 2;
            } else {
                if (cVar.oiV != 1) {
                    cVar.eBO.setMaxLines(1);
                }
                cVar.oiV = 1;
            }
            cVar.eBO.setVisibility(0);
            if (obj22 != null) {
                cVar.eBO.setText(com.tencent.mm.plugin.sns.data.i.a(charSequence22, this.mActivity, cVar.eBO));
            } else {
                cVar.eBO.setText(charSequence22);
            }
        } else if (i2 == 1) {
            cVar.eBO.setText(av.Oa(bsu.sqc.jPK));
            cVar.eBO.setVisibility(0);
        } else {
            cVar.eBO.setVisibility(8);
        }
    }
}
