package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.c.boy;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ah;

public final class s extends LinearLayout implements v {
    private String bNH = "";
    private boolean bNu = false;
    private int bNv;
    private String cXR = "";
    private Context context;
    private int hER = 0;
    b nNg = new b(this);
    private n nNh = null;
    private a nNi;
    private OnTouchListener nNj = bi.cjb();
    private boolean nNk = true;

    public final void setVisibility(int i) {
        boolean z = false;
        if (this.hER == 2 || this.hER == 3) {
            super.setVisibility(i);
            if (i != 8) {
                z = true;
            }
            this.nNk = z;
        } else if (this.nNh != null && !this.nNh.bBd()) {
        } else {
            if (i == 8) {
                this.nNg.nNn.setVisibility(8);
                this.nNk = false;
            } else if (i == 0) {
                this.nNg.nNn.setVisibility(0);
                this.nNk = true;
            }
        }
    }

    public s(Context context, int i, boolean z) {
        super(context);
        this.hER = i;
        this.bNu = z;
        init(context);
    }

    public final void setSnsSource(int i) {
        this.bNv = i;
    }

    public final void setType(int i) {
        this.hER = i;
        init(this.context);
    }

    public final void setCallBack(a aVar) {
        this.nNi = aVar;
    }

    private void init(final Context context) {
        this.context = context;
        if (this.hER != -1) {
            this.cXR = q.GF();
            View inflate = LayoutInflater.from(context).inflate(g.sns_gallery_footer, this, true);
            this.nNg.nNn = (LinearLayout) inflate.findViewById(f.state_ll);
            this.nNg.nNx = (LinearLayout) inflate.findViewById(f.view_media);
            this.nNg.nNq = (LinearLayout) inflate.findViewById(f.like_ll);
            this.nNg.nNq.setOnTouchListener(this.nNj);
            this.nNg.nNr = (ImageView) inflate.findViewById(f.img_button_like);
            this.nNg.nNs = (LinearLayout) inflate.findViewById(f.comment_ll);
            this.nNg.nNs.setOnTouchListener(this.nNj);
            this.nNg.nNt = (LinearLayout) inflate.findViewById(f.content_info);
            this.nNg.nNv = (TextView) inflate.findViewById(f.sns_cm1_tv);
            this.nNg.nNw = (TextView) inflate.findViewById(f.sns_cm2_tv);
            this.nNg.nNu = (TextView) inflate.findViewById(f.has_like_tv);
            this.nNg.nNo = (TextView) inflate.findViewById(f.set_bg);
            this.nNg.nNp = (LinearLayout) inflate.findViewById(f.set_bg_ll);
            this.nNg.fAK = (TextView) inflate.findViewById(f.sns_desc);
            this.nNg.fAK.setTextSize(1, (this.nNg.fAK.getTextSize() * ah.fe(context)) / a.getDensity(this.nNg.fAK.getContext()));
            this.nNg.nNB = (LinearLayout) inflate.findViewById(f.info_line);
            ((LinearLayout) inflate.findViewById(f.info_line)).getBackground().setAlpha(50);
            this.nNg.eBM = (ImageView) inflate.findViewById(f.avatar_with);
            this.nNg.nNy = (ImageView) inflate.findViewById(f.lock_icon);
            this.nNg.nNz = (ImageView) inflate.findViewById(f.error_icon);
            this.nNg.nNA = (LinearLayout) inflate.findViewById(f.del_ll);
            this.nNg.nNC = (TextView) inflate.findViewById(f.del_tv);
            if (this.hER == 2) {
                this.nNg.nNx.setVisibility(8);
                this.nNg.nNA.setVisibility(8);
                this.nNg.nNp.setVisibility(0);
            } else if (this.hER == 3) {
                this.nNg.nNx.setVisibility(8);
                this.nNg.nNp.setVisibility(8);
                this.nNg.nNA.setVisibility(0);
            } else {
                this.nNg.nNx.setVisibility(0);
                this.nNg.nNp.setVisibility(8);
                this.nNg.nNA.setVisibility(8);
            }
            this.nNg.nNq.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (s.this.nNh != null) {
                        if (s.this.nNh.field_likeFlag == 0) {
                            if (s.this.nNh.bBd()) {
                                am.a.a(s.this.nNh, 1, "", "", s.this.bNv);
                            } else {
                                am.a.a(s.this.nNh.field_userName, 5, "", s.this.nNh, s.this.bNv);
                            }
                            s.this.nNh.field_likeFlag = 1;
                            af.byo().z(s.this.nNh);
                        } else {
                            s.this.nNh.field_likeFlag = 0;
                            af.byo().z(s.this.nNh);
                            am.a.Mp(s.this.nNh.bAK());
                            s.this.nNh = af.byo().fi(s.this.nNh.field_snsId);
                        }
                        String eF = s.this.nNh.field_snsId == 0 ? "" : i.eF(s.this.nNh.field_snsId);
                        h.mEJ.h(11989, new Object[]{Integer.valueOf(1), eF, Integer.valueOf(0)});
                        new ag().postDelayed(new 1(this), 500);
                    }
                }
            });
            this.nNg.nNs.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    x.d("MicroMsg.GalleryFooter", "comment cmd");
                    if (s.this.nNh != null) {
                        int i = s.this.nNh.nJc;
                        Intent intent = new Intent();
                        intent.putExtra("sns_comment_localId", i);
                        intent.putExtra("sns_source", s.this.bNv);
                        intent.setClass(context, SnsCommentUI.class);
                        String eF = s.this.nNh.field_snsId == 0 ? "" : i.eF(s.this.nNh.field_snsId);
                        h.mEJ.h(11989, new Object[]{Integer.valueOf(2), eF, Integer.valueOf(0)});
                        context.startActivity(intent);
                    }
                }
            });
            this.nNg.nNt.setOnClickListener(new 3(this, context));
            this.nNg.nNo.setOnClickListener(new 4(this));
            this.nNg.nNC.setOnClickListener(new 5(this));
        }
    }

    public final void refresh() {
        if (this.hER != -1) {
            this.nNh = af.byo().Nl(this.bNH);
            if (!bi.oW(this.bNH) && this.nNh != null) {
                this.nNg.nNz.setVisibility(8);
                if (aj.O(this.nNh.field_localPrivate, this.bNu)) {
                    this.nNg.nNs.setVisibility(8);
                    this.nNg.nNq.setVisibility(8);
                } else if (this.nNh.bBd()) {
                    if (this.nNk) {
                        this.nNg.nNn.setVisibility(0);
                    }
                    this.nNg.nNt.setVisibility(0);
                    this.nNg.nNs.setVisibility(0);
                    this.nNg.nNq.setVisibility(0);
                    this.nNg.nNx.setVisibility(0);
                } else {
                    this.nNg.nNB.setVisibility(0);
                    this.nNg.nNx.setVisibility(0);
                    this.nNg.nNn.setVisibility(8);
                    this.nNg.nNt.setVisibility(8);
                    this.nNg.nNs.setVisibility(8);
                    this.nNg.nNq.setVisibility(8);
                }
                boy n = aj.n(this.nNh);
                if (n != null) {
                    if (this.nNh.bBd()) {
                        int i = n.smM;
                        if (i > 0) {
                            this.nNg.nNw.setText(String.valueOf(i));
                            this.nNg.nNw.setVisibility(0);
                        } else {
                            this.nNg.nNw.setVisibility(8);
                        }
                        int i2 = n.smJ;
                        if (i2 > 0) {
                            this.nNg.nNv.setText(String.valueOf(i2));
                            this.nNg.nNv.setVisibility(0);
                        } else {
                            this.nNg.nNv.setVisibility(8);
                        }
                        x.d("MicroMsg.GalleryFooter", "commentCount " + i + " " + i2);
                        if (this.nNh.field_likeFlag == 1) {
                            this.nNg.nNu.setText(getResources().getString(j.sns_gallery_has_like));
                            this.nNg.nNr.setImageResource(com.tencent.mm.plugin.sns.i.i.friendactivity_comment_likeicon_havon);
                        } else {
                            this.nNg.nNu.setText(getResources().getString(j.sns_gallery_like));
                            this.nNg.nNr.setImageResource(com.tencent.mm.plugin.sns.i.i.friendactivity_comment_likeicon_normal);
                        }
                    }
                    if (this.cXR.equals(this.nNh.field_userName) || !this.bNu) {
                        this.nNg.eBM.setVisibility(8);
                    } else {
                        this.nNg.eBM.setVisibility(0);
                        b.a(this.nNg.eBM, this.nNh.field_userName);
                    }
                }
                if (this.nNh.bAJ() == null) {
                    this.nNg.fAK.setVisibility(8);
                    return;
                }
                String str = this.nNh.bAJ().spZ;
                if (str == null || str.equals("")) {
                    this.nNg.fAK.setText("");
                    this.nNg.fAK.setVisibility(8);
                } else {
                    this.nNg.fAK.setText(com.tencent.mm.pluginsdk.ui.d.j.a(getContext(), str + " ", this.nNg.fAK.getTextSize()));
                    this.nNg.fAK.setVisibility(0);
                }
                if (aj.O(this.nNh.field_localPrivate, this.bNu)) {
                    this.nNg.nNy.setVisibility(0);
                    this.nNg.fAK.setVisibility(0);
                } else {
                    this.nNg.nNy.setVisibility(8);
                }
                if (this.bNu && this.nNh.bBg()) {
                    this.nNg.nNt.setVisibility(0);
                    this.nNg.fAK.setVisibility(0);
                    this.nNg.nNz.setVisibility(0);
                }
            }
        }
    }

    public final void setFooter(String str) {
        this.bNH = str;
        refresh();
    }

    public final void NN(String str) {
        setFooter(str);
    }

    public final int getFooterH() {
        if (this.nNg.nNn != null) {
            return this.nNg.nNn.getHeight();
        }
        return 10;
    }
}
