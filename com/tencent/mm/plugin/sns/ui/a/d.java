package com.tencent.mm.plugin.sns.ui.a;

import android.text.SpannableString;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.an.b;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i$f;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.i$i;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.plugin.sns.ui.r;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.platformtools.bi;

public final class d extends a {
    public final void c(c cVar) {
        if (cVar.oiQ != null) {
            cVar.oiQ.setLayoutResource(i$g.sns_media_sub_item2);
            cVar.ojA = (ViewStub) cVar.jEz.findViewById(i$f.images_keeper_li);
            if (!(cVar.ojB || cVar.ojA == null)) {
                cVar.ojC = cVar.ojA.inflate();
                cVar.ojB = true;
            }
        } else {
            cVar.ojC = cVar.jEz.findViewById(i$f.media_content_rl);
            cVar.ojB = true;
        }
        cVar.oaa = cVar.ojC;
        cVar.oaa.findViewById(i$f.state).setOnTouchListener(this.nuc.nNj);
        cVar.oiT = (TagImageView) cVar.oaa.findViewById(i$f.image_left);
        cVar.nLz = (ImageView) cVar.oaa.findViewById(i$f.state);
        cVar.oiU = (TextView) cVar.oaa.findViewById(i$f.righttext);
        cVar.eBO = (TextView) cVar.oaa.findViewById(i$f.titletext);
        cVar.eBO.setTextColor(this.mActivity.getResources().getColor(i.c.sns_link_color));
        cVar.eBO.setMaxLines(1);
        com.tencent.mm.plugin.sns.data.i.b(cVar.oiT, this.mActivity);
    }

    public final void a(c cVar, int i, ay ayVar, bsu bsu, int i2, av avVar) {
        String str = ayVar.nMU;
        if (bsu.sqc.ruA.isEmpty()) {
            cVar.oaa.setVisibility(8);
            return;
        }
        Object obj;
        CharSequence charSequence;
        cVar.oiT.setPosition(i);
        cVar.oaa.setVisibility(0);
        ate ate = (ate) bsu.sqc.ruA.get(0);
        g byl = af.byl();
        TagImageView tagImageView = cVar.oiT;
        int i3 = i$i.app_attach_file_icon_music;
        int hashCode = this.mActivity.hashCode();
        com.tencent.mm.storage.av clT = com.tencent.mm.storage.av.clT();
        clT.time = bsu.lOH;
        byl.b(ate, tagImageView, i3, hashCode, clT);
        cVar.nLz.setPressed(false);
        String str2 = bsu.ksA;
        if (b.PY()) {
            avq Qa = b.Qa();
            if (Qa != null && b.d(Qa) && str2.equals(Qa.rsp)) {
                obj = 1;
                if (obj == null) {
                    cVar.nLz.setImageResource(e.music_pauseicon);
                } else {
                    cVar.nLz.setImageResource(e.music_playicon);
                }
                cVar.oiT.setTag(new r(bsu, str));
                cVar.oiT.setOnClickListener(avVar.nUk.ohD);
                cVar.oaa.setTag(new r(bsu, str));
                avVar.hql.c(cVar.oaa, avVar.ntw.okK, avVar.ntw.okv);
                cVar.oaa.setOnClickListener(avVar.nUk.nZN);
                charSequence = ate.jOS;
                if (bi.oW(charSequence)) {
                    cVar.oiU.setVisibility(0);
                    cVar.oiU.setText(charSequence);
                } else {
                    cVar.oiU.setVisibility(4);
                }
                charSequence = ate.bHD;
                if (bi.oW(charSequence)) {
                    cVar.eBO.setVisibility(0);
                    cVar.eBO.setText(new SpannableString(charSequence), BufferType.SPANNABLE);
                }
                cVar.eBO.setVisibility(8);
                return;
            }
        }
        obj = null;
        if (obj == null) {
            cVar.nLz.setImageResource(e.music_playicon);
        } else {
            cVar.nLz.setImageResource(e.music_pauseicon);
        }
        cVar.oiT.setTag(new r(bsu, str));
        cVar.oiT.setOnClickListener(avVar.nUk.ohD);
        cVar.oaa.setTag(new r(bsu, str));
        avVar.hql.c(cVar.oaa, avVar.ntw.okK, avVar.ntw.okv);
        cVar.oaa.setOnClickListener(avVar.nUk.nZN);
        charSequence = ate.jOS;
        if (bi.oW(charSequence)) {
            cVar.oiU.setVisibility(4);
        } else {
            cVar.oiU.setVisibility(0);
            cVar.oiU.setText(charSequence);
        }
        charSequence = ate.bHD;
        if (bi.oW(charSequence)) {
            cVar.eBO.setVisibility(8);
            return;
        }
        cVar.eBO.setVisibility(0);
        cVar.eBO.setText(new SpannableString(charSequence), BufferType.SPANNABLE);
    }
}
