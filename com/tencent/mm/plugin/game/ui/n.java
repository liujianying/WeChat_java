package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.a.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.d;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.plugin.game.model.s.h;
import com.tencent.mm.plugin.game.model.t;
import com.tencent.mm.plugin.game.model.t$a;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.r;
import java.util.LinkedList;

public final class n extends r<s> {
    private static w kap;
    private int bGz = 0;
    int edl = 0;
    int hFO = 15;
    private int jNv = 0;
    private OnClickListener kaq;
    private OnClickListener kar;
    private v kas;
    private v kat;
    private long kau = 0;
    private int kav = 0;
    private t kaw;
    private f<String, Bitmap> kax;
    private Context mContext;

    static class a {
        public TextView eTm;
        public TextView gmo;
        public ImageView kaA;
        public LinearLayout kaB;
        public ImageView kaC;
        public TextView kaD;
        public LinearLayout kaE;
        public TextView kaF;
        public ImageView kaG;
        public ImageView kaH;
        public TextView kaI;
        public TextView kaJ;
        public LinearLayout kaK;
        public GameMessageListContainerView kaL;
        public LinearLayout kaz;

        a() {
        }
    }

    protected final /* bridge */ /* synthetic */ Object aVa() {
        return (s) this.tlE;
    }

    public n(Context context, s sVar, int i) {
        int i2 = 0;
        super(context, sVar);
        this.mContext = context;
        this.jNv = i;
        Cursor rawQuery = ((c) g.l(c.class)).aSj().rawQuery("select count(*) from GameRawMessage where " + w.m(new int[]{2, 5, 6, 10, 11, 100}) + " and showInMsgList = 1 and isHidden = 0", new String[0]);
        if (rawQuery != null) {
            int i3 = rawQuery.moveToFirst() ? rawQuery.getInt(0) : 0;
            rawQuery.close();
            i2 = i3;
        }
        this.edl = i2;
        this.bGz = ((c) g.l(c.class)).aSj().aUf();
        kap = new w();
        this.kaq = new o(context, i);
        this.kar = new p(context, i);
        this.kas = new v(context);
        this.kas.cI(i, 1);
        this.kat = new v(context);
        this.kat.cI(i, 2);
        this.kaw = new t(context, this.jNv);
        this.kav = com.tencent.mm.bp.a.ag(this.mContext, ((com.tencent.mm.plugin.game.e.c.getScreenWidth(this.mContext) - (this.mContext.getResources().getDimensionPixelSize(com.tencent.mm.plugin.game.f.c.BiggerPadding) * 2)) - this.mContext.getResources().getDimensionPixelSize(com.tencent.mm.plugin.game.f.c.GameRankIconSize)) - this.mContext.getResources().getDimensionPixelSize(com.tencent.mm.plugin.game.f.c.MiddlePadding)) / 34;
        this.kax = new f(30);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            a aVar2 = new a();
            view = View.inflate(this.context, com.tencent.mm.plugin.game.f.f.game_message_item, null);
            aVar2.kaA = (ImageView) view.findViewById(e.icon_iv);
            aVar2.kaz = (LinearLayout) view.findViewById(e.msg);
            aVar2.kaB = (LinearLayout) view.findViewById(e.msg_content);
            aVar2.eTm = (TextView) view.findViewById(e.nickname_tv);
            aVar2.kaC = (ImageView) view.findViewById(e.badge_icon);
            aVar2.gmo = (TextView) view.findViewById(e.tips_tv);
            aVar2.kaD = (TextView) view.findViewById(e.msg_first_line_text);
            aVar2.kaE = (LinearLayout) view.findViewById(e.msg_second_line);
            aVar2.kaF = (TextView) view.findViewById(e.msg_second_line_text);
            aVar2.kaG = (ImageView) view.findViewById(e.msg_second_line_icon);
            aVar2.kaH = (ImageView) view.findViewById(e.msg_img_iv);
            aVar2.kaI = (TextView) view.findViewById(e.msg_time_tv);
            aVar2.kaJ = (TextView) view.findViewById(e.msg_sourcename_tv);
            aVar2.kaL = (GameMessageListContainerView) view.findViewById(e.msg_user_icon_view);
            aVar2.kaK = (LinearLayout) view.findViewById(e.msg_dividing);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        s qZ = qZ(i);
        if (qZ == null || !qZ.jNe) {
            if (qZ != null) {
                qZ.aTW();
                aVar.kaz.setVisibility(0);
                aVar.kaK.setVisibility(8);
                aVar.kaI.setText(b.g(this.context, qZ.field_createTime * 1000));
                CharSequence charSequence;
                h hVar;
                ab Yg;
                if (qZ.field_msgType != 100) {
                    Object obj;
                    aVar.gmo.setVisibility(8);
                    aVar.kaD.setVisibility(8);
                    aVar.kaE.setVisibility(8);
                    aVar.kaG.setVisibility(8);
                    aVar.kaH.setVisibility(8);
                    aVar.kaJ.setVisibility(8);
                    aVar.kaJ.setEnabled(false);
                    aVar.kaH.setEnabled(false);
                    aVar.kaA.setEnabled(false);
                    aVar.eTm.setEnabled(false);
                    aVar.kaL.setVisibility(8);
                    aVar.kaC.setVisibility(8);
                    if (bi.cX(qZ.jMr)) {
                        obj = null;
                        charSequence = null;
                    } else {
                        hVar = (h) qZ.jMr.get(0);
                        Yg = ((i) g.l(i.class)).FR().Yg(hVar.userName);
                        if (Yg != null) {
                            charSequence = Yg.BL();
                        } else {
                            Object obj2 = null;
                        }
                        if (bi.oW(charSequence)) {
                            charSequence = hVar.bgn;
                        }
                        obj = !bi.oW(hVar.jNq) ? 1 : null;
                    }
                    int size = qZ.jMr.size();
                    if (!bi.oW(qZ.jMp) && (qZ.jMF & 1) == 0) {
                        aVar.kaJ.setText(qZ.jMp);
                        aVar.kaJ.setVisibility(0);
                        if ((qZ.jMF & 2) > 0) {
                            aVar.kaJ.setTextColor(this.context.getResources().getColor(com.tencent.mm.plugin.game.f.b.gc_link_color));
                            aVar.kaJ.setBackgroundResource(d.game_click_change_bg_selector);
                            aVar.kaJ.setOnClickListener(this.kaq);
                            aVar.kaJ.setTag(qZ);
                            aVar.kaJ.setEnabled(true);
                        } else {
                            aVar.kaJ.setTextColor(this.context.getResources().getColor(com.tencent.mm.plugin.game.f.b.game_msg_text_color));
                            aVar.kaJ.setBackgroundResource(0);
                            aVar.kaJ.setOnClickListener(null);
                            aVar.kaJ.setEnabled(false);
                        }
                    }
                    if (qZ.field_msgType == 10 || qZ.field_msgType == 11) {
                        if (!bi.oW(qZ.mAppName)) {
                            aVar.eTm.setText(j.a(this.context, qZ.mAppName, aVar.eTm.getTextSize()), BufferType.SPANNABLE);
                            aVar.eTm.setVisibility(0);
                        } else if (bi.oW(charSequence)) {
                            aVar.eTm.setVisibility(8);
                        } else {
                            aVar.eTm.setText(j.a(this.context, charSequence, aVar.eTm.getTextSize()));
                            aVar.eTm.setVisibility(0);
                        }
                    } else if (bi.oW(charSequence)) {
                        aVar.eTm.setVisibility(8);
                    } else {
                        aVar.eTm.setText(j.a(this.context, charSequence, aVar.eTm.getTextSize()));
                        aVar.eTm.setVisibility(0);
                        if (obj != null) {
                            aVar.eTm.setOnClickListener(this.kas);
                            aVar.eTm.setTag(qZ);
                            aVar.eTm.setEnabled(true);
                        }
                    }
                    switch (qZ.field_msgType) {
                        case 2:
                            e(aVar.kaA, qZ.jMl);
                            String str = "礼物";
                            if (qZ.jMC.contains("爱心")) {
                                str = "爱心";
                            } else if (qZ.jMC.contains("体力")) {
                                str = "体力";
                            }
                            if (size > 1) {
                                aVar.gmo.setText(this.context.getResources().getString(com.tencent.mm.plugin.game.f.i.game_msg_share_more, new Object[]{String.valueOf(size), str}));
                            } else {
                                aVar.gmo.setText(this.context.getResources().getString(com.tencent.mm.plugin.game.f.i.game_msg_share_one, new Object[]{str}));
                            }
                            aVar.gmo.setVisibility(0);
                            a(qZ, aVar);
                            break;
                        case 5:
                            if (bi.cX(qZ.jMr)) {
                                aVar.kaA.setVisibility(8);
                            } else {
                                aVar.kaA.setVisibility(0);
                                if (bi.oW(((h) qZ.jMr.get(0)).jNp)) {
                                    c(aVar.kaA, ((h) qZ.jMr.get(0)).userName);
                                } else {
                                    e(aVar.kaA, ((h) qZ.jMr.get(0)).jNp);
                                }
                                if (!bi.oW(((h) qZ.jMr.get(0)).jNq)) {
                                    aVar.kaA.setOnClickListener(this.kat);
                                    aVar.kaA.setTag(qZ);
                                    aVar.kaA.setEnabled(true);
                                }
                            }
                            if (size > 1) {
                                aVar.gmo.setText(this.context.getResources().getString(com.tencent.mm.plugin.game.f.i.game_msg_like_more, new Object[]{String.valueOf(size)}));
                                a(qZ, aVar);
                            } else {
                                aVar.gmo.setText(this.context.getResources().getString(com.tencent.mm.plugin.game.f.i.game_msg_like_one));
                            }
                            aVar.kaE.setVisibility(0);
                            aVar.gmo.setVisibility(0);
                            aVar.kaF.setText(qZ.jMN);
                            aVar.kaE.setOnClickListener(this.kar);
                            aVar.kaE.setTag(Long.valueOf(qZ.field_msgId));
                            if (!bi.oW(qZ.jMP)) {
                                aVar.kaG.setVisibility(0);
                                e(aVar.kaG, qZ.jMP);
                                break;
                            }
                            break;
                        case 6:
                            if (bi.cX(qZ.jMr)) {
                                aVar.kaA.setVisibility(8);
                            } else {
                                aVar.kaA.setVisibility(0);
                                if (bi.oW(((h) qZ.jMr.get(0)).jNp)) {
                                    c(aVar.kaA, ((h) qZ.jMr.get(0)).userName);
                                } else {
                                    e(aVar.kaA, ((h) qZ.jMr.get(0)).jNp);
                                }
                                if (!bi.oW(((h) qZ.jMr.get(0)).jNq)) {
                                    aVar.kaA.setOnClickListener(this.kat);
                                    aVar.kaA.setTag(qZ);
                                    aVar.kaA.setEnabled(true);
                                }
                            }
                            aVar.kaE.setVisibility(0);
                            aVar.kaE.setOnClickListener(this.kar);
                            aVar.kaE.setTag(Long.valueOf(qZ.field_msgId));
                            if (qZ.jMZ != 1) {
                                if (qZ.jMZ != 2) {
                                    if (qZ.jMZ == 3) {
                                        aVar.gmo.setVisibility(0);
                                        if (size > 1) {
                                            aVar.gmo.setText(this.context.getResources().getString(com.tencent.mm.plugin.game.f.i.game_msg_group_like_more, new Object[]{String.valueOf(size)}));
                                            a(qZ, aVar);
                                        } else {
                                            aVar.gmo.setText(this.context.getResources().getString(com.tencent.mm.plugin.game.f.i.game_msg_group_like_one));
                                        }
                                        aVar.kaF.setText(qZ.jMM);
                                        break;
                                    }
                                }
                                aVar.kaD.setVisibility(0);
                                aVar.kaD.setText(j.a(this.context, qZ.jMJ, aVar.kaD.getTextSize()));
                                aVar.kaF.setText(qZ.jMK);
                                break;
                            }
                            aVar.kaD.setVisibility(0);
                            aVar.kaD.setText(j.a(this.context, qZ.jMJ, aVar.kaD.getTextSize()));
                            aVar.kaF.setText(qZ.jMM);
                            break;
                            break;
                        case 10:
                        case 11:
                            if (bi.oW(qZ.jMl)) {
                                x.e("MicroMsg.GameMessageAdapter", "mAppIcon is null");
                                aVar.kaA.setVisibility(8);
                            } else {
                                e(aVar.kaA, qZ.jMl);
                                aVar.kaA.setVisibility(0);
                            }
                            if (!bi.oW(qZ.ikW)) {
                                if (bi.oW(qZ.jMx)) {
                                    aVar.kaE.setVisibility(0);
                                    aVar.kaF.setText(qZ.ikW);
                                    aVar.kaE.setOnClickListener(this.kar);
                                    aVar.kaE.setTag(Long.valueOf(qZ.field_msgId));
                                } else {
                                    aVar.kaD.setText(qZ.ikW);
                                    aVar.kaD.setVisibility(0);
                                }
                            }
                            if (!bi.oW(qZ.jMx)) {
                                e(aVar.kaH, qZ.jMx);
                                aVar.kaH.setTag(Long.valueOf(qZ.field_msgId));
                                aVar.kaH.setOnTouchListener(kap);
                                aVar.kaH.setOnClickListener(this.kar);
                                aVar.kaH.setVisibility(0);
                                aVar.kaH.setEnabled(true);
                                break;
                            }
                            break;
                        default:
                            x.e("MicroMsg.GameMessageAdapter", "error msgtype: " + qZ.field_msgType);
                            break;
                    }
                }
                if (qZ.jMV != null) {
                    e(aVar.kaA, qZ.jMV.jNm);
                    aVar.kaA.setVisibility(0);
                    if (bi.oW(qZ.jMV.jNl)) {
                        aVar.eTm.setVisibility(8);
                    } else {
                        aVar.eTm.setText(qZ.jMV.jNl);
                        aVar.eTm.setVisibility(0);
                    }
                    if (bi.oW(qZ.jMV.jNn)) {
                        aVar.kaC.setVisibility(8);
                    } else {
                        e(aVar.kaC, qZ.jMV.jNn);
                        aVar.kaC.setVisibility(0);
                    }
                    if (bi.oW(qZ.jMV.jNh)) {
                        aVar.eTm.setEnabled(false);
                        aVar.kaA.setEnabled(false);
                    } else {
                        aVar.eTm.setEnabled(true);
                        aVar.kaA.setEnabled(true);
                        t$a t_a = new t$a(qZ, qZ.jMV.jNh, 1);
                        t$a t_a2 = new t$a(qZ, qZ.jMV.jNh, 2);
                        aVar.eTm.setTag(t_a);
                        aVar.eTm.setOnClickListener(this.kaw);
                        aVar.kaA.setTag(t_a2);
                        aVar.kaA.setOnClickListener(this.kaw);
                    }
                } else if (bi.cX(qZ.jMr)) {
                    aVar.kaA.setVisibility(8);
                    aVar.eTm.setVisibility(8);
                    aVar.kaC.setVisibility(8);
                } else {
                    hVar = (h) qZ.jMr.get(0);
                    if (bi.oW(hVar.bgn)) {
                        Yg = ((i) g.l(i.class)).FR().Yg(hVar.userName);
                        charSequence = (Yg == null || bi.oW(Yg.BL())) ? hVar.userName : Yg.BL();
                    } else {
                        charSequence = hVar.bgn;
                    }
                    if (bi.oW(hVar.jNs)) {
                        aVar.eTm.setEnabled(false);
                        aVar.kaA.setEnabled(false);
                    } else {
                        aVar.eTm.setEnabled(true);
                        aVar.kaA.setEnabled(true);
                        t$a t_a3 = new t$a(qZ, hVar.jNs, 1);
                        t$a t_a4 = new t$a(qZ, hVar.jNs, 2);
                        aVar.eTm.setTag(t_a3);
                        aVar.eTm.setOnClickListener(this.kaw);
                        aVar.kaA.setTag(t_a4);
                        aVar.kaA.setOnClickListener(this.kaw);
                    }
                    if (bi.oW(charSequence)) {
                        aVar.eTm.setVisibility(8);
                    } else {
                        aVar.eTm.setText(j.a(this.context, charSequence, aVar.eTm.getTextSize()), BufferType.SPANNABLE);
                        aVar.eTm.setVisibility(0);
                    }
                    aVar.kaA.setVisibility(0);
                    if (bi.oW(hVar.jNp)) {
                        c(aVar.kaA, hVar.userName);
                    } else {
                        e(aVar.kaA, hVar.jNp);
                    }
                    if (bi.oW(hVar.jNr)) {
                        aVar.kaC.setVisibility(8);
                    } else {
                        e(aVar.kaC, hVar.jNr);
                        aVar.kaC.setVisibility(0);
                    }
                }
                if (bi.oW(qZ.jMR)) {
                    aVar.gmo.setVisibility(8);
                } else {
                    if (qZ.jMr.size() > 1) {
                        aVar.gmo.setText(this.context.getResources().getString(com.tencent.mm.plugin.game.f.i.game_msg_user_count, new Object[]{Integer.valueOf(qZ.jMr.size())}) + qZ.jMR);
                    } else {
                        aVar.gmo.setText(qZ.jMR);
                    }
                    aVar.gmo.setVisibility(0);
                }
                if (bi.oW(qZ.jMS)) {
                    aVar.kaD.setVisibility(8);
                } else {
                    aVar.kaD.setText(j.a(this.context, qZ.jMS, aVar.kaD.getTextSize()));
                    aVar.kaD.setVisibility(0);
                }
                a(qZ, aVar);
                if (bi.oW(qZ.jMW.jNk)) {
                    aVar.kaE.setVisibility(8);
                } else {
                    aVar.kaE.setVisibility(0);
                    if (bi.oW(qZ.jMW.jNh)) {
                        aVar.kaE.setEnabled(false);
                    } else {
                        aVar.kaE.setTag(new t$a(qZ, qZ.jMW.jNh, 3));
                        aVar.kaE.setOnClickListener(this.kaw);
                        aVar.kaE.setEnabled(true);
                    }
                    aVar.kaF.setText(j.a(this.context, qZ.jMW.jNk, aVar.kaF.getTextSize()));
                    if (bi.oW(qZ.jMW.jNg)) {
                        aVar.kaG.setVisibility(8);
                    } else {
                        e(aVar.kaG, qZ.jMW.jNg);
                        aVar.kaG.setVisibility(0);
                    }
                }
                if (bi.oW(qZ.jMT)) {
                    aVar.kaH.setVisibility(8);
                } else {
                    e(aVar.kaH, qZ.jMT);
                    aVar.kaH.setVisibility(0);
                    if (bi.oW(qZ.jMU)) {
                        aVar.kaH.setEnabled(false);
                    } else {
                        aVar.kaH.setTag(new t$a(qZ, qZ.jMU, 3));
                        aVar.kaH.setOnClickListener(this.kaw);
                        aVar.kaH.setEnabled(true);
                    }
                }
                if (bi.oW(qZ.jMX.mName)) {
                    aVar.kaJ.setVisibility(8);
                } else {
                    aVar.kaJ.setText(qZ.jMX.mName);
                    aVar.kaJ.setVisibility(0);
                    if (bi.oW(qZ.jMX.jNh)) {
                        aVar.kaJ.setEnabled(false);
                    } else {
                        aVar.kaJ.setTag(new t$a(qZ, qZ.jMX.jNh, 5));
                        aVar.kaJ.setOnClickListener(this.kaw);
                        aVar.kaJ.setEnabled(true);
                    }
                }
            }
        } else {
            aVar.kaz.setVisibility(8);
            aVar.kaK.setVisibility(0);
        }
        return view;
    }

    private void a(s sVar, a aVar) {
        LinkedList linkedList = new LinkedList();
        for (int i = 1; i < sVar.jMr.size(); i++) {
            linkedList.add(sVar.jMr.get(i));
        }
        aVar.kaL.a(sVar, linkedList, this.kav, this.jNv, this.kax);
    }

    private void c(ImageView imageView, String str) {
        if (bi.oW(str)) {
            com.tencent.mm.pluginsdk.ui.a.b.a(imageView, str);
        } else if (this.kax.bb(str)) {
            Bitmap bitmap = (Bitmap) this.kax.get(str);
            if (bitmap == null || bitmap.isRecycled()) {
                d(imageView, str);
            } else {
                imageView.setImageBitmap(bitmap);
            }
        } else {
            d(imageView, str);
        }
    }

    private void d(ImageView imageView, String str) {
        Bitmap h = com.tencent.mm.plugin.game.e.e.aVj().h(imageView, str);
        if (h != null) {
            this.kax.put(str, h);
        }
    }

    private void e(ImageView imageView, String str) {
        if (this.kax.bb(str)) {
            Bitmap bitmap = (Bitmap) this.kax.get(str);
            if (bitmap == null || bitmap.isRecycled()) {
                f(imageView, str);
                return;
            } else {
                imageView.setImageBitmap(bitmap);
                return;
            }
        }
        f(imageView, str);
    }

    private void f(ImageView imageView, String str) {
        com.tencent.mm.plugin.game.e.e.a.a aVar = new com.tencent.mm.plugin.game.e.e.a.a();
        aVar.dXw = false;
        com.tencent.mm.plugin.game.e.e.aVj().a(imageView, str, aVar.aVk(), new 1(this, str));
    }

    public final void WT() {
        setCursor(((c) g.l(c.class)).aSj().rawQuery("select * from GameRawMessage where " + w.m(new int[]{2, 5, 6, 10, 11, 100}) + " and showInMsgList = 1 and isHidden = 0 order by isRead, createTime desc limit " + this.hFO, new String[0]));
        this.hFO = getCount();
        if (this.tlG != null) {
            this.tlG.Xb();
        }
        super.notifyDataSetChanged();
    }

    protected final void WS() {
        aYc();
        WT();
    }

    private static s a(s sVar, Cursor cursor) {
        if (sVar == null) {
            sVar = new s();
        }
        sVar.d(cursor);
        return sVar;
    }

    public final boolean ayQ() {
        return this.hFO >= this.edl;
    }

    public final int getCount() {
        if (this.count < 0) {
            this.count = getCursor().getCount();
        }
        if (this.count <= 0) {
            return 0;
        }
        return this.count + aUZ();
    }

    public final boolean qY(int i) {
        return this.edl > this.bGz && this.bGz > 0 && i == this.bGz;
    }

    protected final int aUZ() {
        return (this.edl <= this.bGz || this.bGz <= 0) ? 0 : 1;
    }

    private s qZ(int i) {
        if (qY(i)) {
            return (s) this.tlE;
        }
        s sVar;
        if (this.tlF != null) {
            sVar = (s) this.tlF.get(Integer.valueOf(i));
            if (sVar != null) {
                return sVar;
            }
        }
        Object obj = (this.edl <= this.bGz || this.bGz <= 0 || i <= this.bGz) ? null : 1;
        int i2;
        if (obj != null) {
            i2 = i - 1;
        } else {
            i2 = i;
        }
        if (i < 0 || !getCursor().moveToPosition(i2)) {
            return null;
        }
        if (this.tlF == null) {
            return a((s) this.tlE, getCursor());
        }
        sVar = a(null, getCursor());
        this.tlF.put(Integer.valueOf(i), sVar);
        return sVar;
    }
}
