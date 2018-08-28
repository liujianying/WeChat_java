package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ac.z;
import com.tencent.mm.ak.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b$e;
import com.tencent.mm.plugin.brandservice.b.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.c.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.c.n;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.r$a;
import com.tencent.mm.storage.r.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.ao;
import com.tencent.mm.ui.widget.MMNeatTextView;
import com.tencent.mm.ui.widget.e;
import com.tencent.mm.y.l;
import com.tencent.mm.y.m;
import java.util.LinkedList;
import java.util.List;

public final class a extends BaseAdapter implements OnCreateContextMenuListener {
    private static int hqD = 0;
    private static int hqE;
    private static int hqF = 0;
    private static int hqG = 0;
    private static Long hqM = null;
    List<q> gxs = new LinkedList();
    c hnE = new 1(this);
    private int hpr = 0;
    private int hps = 0;
    private e hpv;
    private BizTimeLineUI hqC;
    private q hqH;
    private int hqI;
    private int hqJ = 0;
    private boolean hqK = false;
    private long hqL;
    h hqN;
    boolean hqO = false;
    private b hqP;
    g hqQ = new g();
    private OnTouchListener hqR = new 7(this);
    private OnClickListener hqS = new 8(this);
    private OnLongClickListener hqT = new 9(this);
    private OnClickListener hqU = new 10(this);
    private d hqV = new 13(this);
    boolean hqW = false;

    public a(BizTimeLineUI bizTimeLineUI, List<q> list, boolean z) {
        this.hqC = bizTimeLineUI;
        this.hpv = new e(this.hqC);
        if (hqD == 0) {
            hqD = bizTimeLineUI.getResources().getDimensionPixelSize(b.biz_time_line_item_cover_height);
            hqE = bizTimeLineUI.getResources().getDimensionPixelSize(b.chatting_item_biz_sub_item_pic_size);
            hqF = bizTimeLineUI.getResources().getDimensionPixelSize(b.biz_time_line_item_padding);
            hqG = bizTimeLineUI.getResources().getDimensionPixelSize(b.NormalPadding);
            int fk = com.tencent.mm.bp.a.fk(bizTimeLineUI);
            int fl = com.tencent.mm.bp.a.fl(bizTimeLineUI);
            if (fk >= fl) {
                fk = fl;
            }
            hqD = (int) (((float) (fk - ((int) (com.tencent.mm.bp.a.getDensity(bizTimeLineUI) * 48.0f)))) * 0.47f);
        }
        z.Ne().a(this.hnE, Looper.getMainLooper());
        this.gxs = list;
        if (!z) {
            hqM = null;
        }
        this.hqN = new h(this);
        this.hqO = z;
    }

    public final int getCount() {
        return this.gxs.size();
    }

    /* renamed from: nz */
    public final q getItem(int i) {
        if (i >= this.gxs.size() || i < 0) {
            return null;
        }
        return (q) this.gxs.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final int getItemViewType(int i) {
        q nz = getItem(i);
        if (nz == null) {
            x.e("MicroMsg.BizTimeLineAdapter", "getItemViewType info is null");
            return 0;
        }
        switch (nz.field_type) {
            case 1:
                return 2;
            case 3:
                return 4;
            case 34:
                return 3;
            case 285212721:
                return 1;
            default:
                return 0;
        }
    }

    public final int getViewTypeCount() {
        return 5;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        final q nz = getItem(i);
        if (nz != null) {
            g gVar = this.hqQ;
            if (nz != null) {
                com.tencent.mm.plugin.brandservice.ui.timeline.g.a aVar = (com.tencent.mm.plugin.brandservice.ui.timeline.g.a) gVar.hsb.get(Long.valueOf(nz.field_msgId));
                if (aVar == null) {
                    com.tencent.mm.plugin.brandservice.ui.timeline.g.a aVar2 = new com.tencent.mm.plugin.brandservice.ui.timeline.g.a((byte) 0);
                    gVar.hsb.put(Long.valueOf(nz.field_msgId), aVar2);
                    aVar2.rjm = nz.field_talker;
                    aVar2.bIZ = (long) ((int) nz.field_msgSvrId);
                    aVar2.rjo = 1;
                    aVar2.rjx = (int) (System.currentTimeMillis() / 1000);
                    aVar2.pos = i;
                    aVar2.rjq = 0;
                    aVar2.rjs = 0;
                    aVar2.rjt = 0;
                    aVar2.rjw = 0;
                    aVar2.rju = 0;
                    aVar2.rjw = 0;
                    if (((i) g.l(i.class)).FR().Yg(nz.field_talker).BG()) {
                        aVar2.rjv = 1;
                    } else {
                        aVar2.rjv = 0;
                    }
                    if (nz != null && nz.cky()) {
                        l wS = ((com.tencent.mm.plugin.biz.a.a) g.l(com.tencent.mm.plugin.biz.a.a.class)).wS(nz.field_content);
                        if (!(wS == null && bi.cX(wS.dzs))) {
                            try {
                                m mVar = (m) wS.dzs.get(wS.dzs.size() - 1);
                                if (!(mVar == null || bi.oW(mVar.url))) {
                                    Uri parse = Uri.parse(((m) wS.dzs.get(0)).url);
                                    int i2 = bi.getInt(parse.getQueryParameter("idx"), 0);
                                    long j = bi.getLong(parse.getQueryParameter("mid"), 0);
                                    aVar2.rjn.add(Integer.valueOf(i2));
                                    aVar2.bIZ = j;
                                }
                                if (nz.field_isExpand) {
                                    aVar2.rjp = 2;
                                } else if (wS.dzs.size() > 2) {
                                    aVar2.rjp = 1;
                                } else {
                                    aVar2.rjp = 0;
                                }
                            } catch (UnsupportedOperationException e) {
                                x.w("MicroMsg.BizTimeLineReport", "exposeLog exp %s", new Object[]{e.getMessage()});
                            } catch (Exception e2) {
                                x.w("MicroMsg.BizTimeLineReport", "exposeLog exp %s", new Object[]{e2.getMessage()});
                            }
                        }
                    }
                } else {
                    aVar.rjo++;
                    aVar.pos = i;
                    aVar.rjx = (int) (System.currentTimeMillis() / 1000);
                    if (((i) g.l(i.class)).FR().Yg(nz.field_talker).BG()) {
                        aVar.rjv = 1;
                    } else {
                        aVar.rjv = 0;
                    }
                }
            }
            if (i == getCount() - 1 && !this.hqW) {
                final int i3 = i;
                ah.i(new Runnable() {
                    public final void run() {
                        if (i3 == a.this.getCount() - 1 && !a.this.hqW) {
                            boolean z;
                            x.i("MicroMsg.BizTimeLineAdapter", "loadMoreData %d/%d", new Object[]{Integer.valueOf(i3), Integer.valueOf(a.this.getCount())});
                            a aVar = a.this;
                            q avf = aVar.avf();
                            if (avf != null) {
                                r Ne = z.Ne();
                                long j = avf.field_orderFlag;
                                Object n = r.n(Ne.dCZ.query("BizTimeLineInfo", null, "orderFlag<?", new String[]{String.valueOf(j)}, null, null, "orderFlag DESC limit 10"));
                                aVar.gxs.addAll(n);
                                aVar.notifyDataSetChanged();
                                if (n.size() > 0) {
                                    z = true;
                                    if (!z) {
                                        a.this.hqW = true;
                                        a.this.hqC.avm();
                                    }
                                }
                            }
                            z = false;
                            if (!z) {
                                a.this.hqW = true;
                                a.this.hqC.avm();
                            }
                        }
                    }
                }, 500);
            }
            c$c fVar;
            Object obj;
            View view2;
            CharSequence a;
            int cEg;
            switch (nz.field_type) {
                case 1:
                    if (view == null) {
                        fVar = new f();
                        obj = this.hqC;
                        if (fVar.hri != null) {
                            view2 = fVar.hri;
                        } else {
                            fVar.hri = View.inflate(obj, b$e.biz_time_line_text_item, null);
                            fVar.avh();
                            fVar.hrI = (MMNeatTextView) fVar.hri.findViewById(com.tencent.mm.plugin.brandservice.b.d.text_tv);
                            fVar.hrG = (TextView) fVar.hri.findViewById(com.tencent.mm.plugin.brandservice.b.d.show_all_tv);
                            fVar.hrH = fVar.hri.findViewById(com.tencent.mm.plugin.brandservice.b.d.biz_time_line_item_click_area);
                            view2 = fVar.hri;
                        }
                        view2.setTag(fVar);
                        view = view2;
                    } else {
                        fVar = (f) view.getTag();
                    }
                    a = j.a(this.hqC, nz.field_content, (int) fVar.hrI.getTextSize(), null, null);
                    fVar.hrI.setMaxLines(Integer.MAX_VALUE);
                    fVar.hrI.Q(a);
                    cEg = fVar.hrI.Hg(getContentWidth()).cEg();
                    if (nz.field_isExpand || cEg <= 6) {
                        fVar.hrI.setMaxLines(Integer.MAX_VALUE);
                        fVar.hrG.setVisibility(8);
                    } else {
                        fVar.hrI.setMaxLines(6);
                        fVar.hrG.setVisibility(0);
                        fVar.hrG.setOnClickListener(new 15(this, fVar, nz));
                    }
                    a(fVar, nz);
                    a(i, nz, fVar.hrh, fVar.hrg);
                    fVar.hrH.setOnTouchListener(this.hqR);
                    fVar.hrH.setOnLongClickListener(new 16(this, nz));
                    break;
                case 3:
                    if (view == null) {
                        fVar = new c.d();
                        obj = this.hqC;
                        if (fVar.hri != null) {
                            view2 = fVar.hri;
                        } else {
                            fVar.hri = View.inflate(obj, b$e.biz_time_line_img_item, null);
                            fVar.avh();
                            fVar.hru = (ImageView) fVar.hri.findViewById(com.tencent.mm.plugin.brandservice.b.d.pic_iv);
                            fVar.hrv = (ImageView) fVar.hri.findViewById(com.tencent.mm.plugin.brandservice.b.d.pic_iv_pressed);
                            view2 = fVar.hri;
                        }
                        view2.setTag(fVar);
                        view = view2;
                    } else {
                        fVar = (c.d) view.getTag();
                    }
                    cm(fVar.hrv);
                    cm(fVar.hru);
                    if (this.hqP == null) {
                        this.hqP = new b(this.hqC);
                    }
                    b bVar = this.hqP;
                    ImageView imageView = fVar.hru;
                    if (!(bVar.cb(nz.field_msgId) == 2 || bVar.cb(nz.field_msgId) == 3)) {
                        com.tencent.mm.ak.e b = b.b(nz);
                        if (b != null) {
                            String f = b.f(b);
                            if (com.tencent.mm.a.e.cn(f)) {
                                b.a(f, imageView);
                                bVar.j(nz.field_msgId, 1);
                            } else if (o.Pg().a(b.dTK, nz.field_msgId, 0, Integer.valueOf(i), com.tencent.mm.plugin.brandservice.b.c.chat_img_template, bVar, 0) == -2) {
                                x.w("MicroMsg.BizTimeLineImgMsgHandler", "it is already download image finish, but imgInfo is old, search db and repair.");
                                com.tencent.mm.ak.e b2 = b.b(nz);
                                if (b2 == null) {
                                    x.w("MicroMsg.BizTimeLineImgMsgHandler", "get imgInfo by db but it is null.");
                                } else {
                                    f = b.f(b2);
                                    if (com.tencent.mm.a.e.cn(f)) {
                                        b.a(f, imageView);
                                    }
                                }
                            }
                        } else {
                            x.w("MicroMsg.BizTimeLineImgMsgHandler", "showImg img info is null. %d/%d", new Object[]{Long.valueOf(nz.field_msgId), Long.valueOf(nz.field_msgSvrId)});
                        }
                    }
                    fVar.hrv.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            a.a(a.this, view, nz);
                        }
                    });
                    a(fVar, nz);
                    a(i, nz, fVar.hrh, fVar.hrg);
                    fVar.hrv.setOnTouchListener(this.hqR);
                    fVar.hrv.setOnLongClickListener(new 20(this, nz));
                    break;
                case 34:
                    c$c c_c;
                    if (view == null) {
                        n nVar = new n();
                        obj = this.hqC;
                        if (nVar.hri != null) {
                            view2 = nVar.hri;
                        } else {
                            nVar.hri = View.inflate(obj, b$e.biz_time_line_voice_item, null);
                            nVar.avh();
                            nVar.hrI = (MMNeatTextView) nVar.hri.findViewById(com.tencent.mm.plugin.brandservice.b.d.title_tv);
                            nVar.hrQ = (TextView) nVar.hri.findViewById(com.tencent.mm.plugin.brandservice.b.d.play_time_tv);
                            nVar.hrp = (ImageView) nVar.hri.findViewById(com.tencent.mm.plugin.brandservice.b.d.play_icon);
                            nVar.hrH = nVar.hri.findViewById(com.tencent.mm.plugin.brandservice.b.d.chatting_item_biz_voice);
                            view2 = nVar.hri;
                        }
                        view2.setTag(nVar);
                        c_c = nVar;
                        view = view2;
                    } else {
                        c_c = (n) view.getTag();
                    }
                    com.tencent.mm.modelvoice.n nVar2 = new com.tencent.mm.modelvoice.n(nz.field_content);
                    c_c.hrI.Q(h.h("yyyy/MM/dd", System.currentTimeMillis() / 1000));
                    a = com.tencent.mm.y.i.gR((int) (nVar2.time / 1000));
                    if (TextUtils.isEmpty(a)) {
                        c_c.hrQ.setVisibility(4);
                    } else {
                        c_c.hrQ.setVisibility(0);
                        c_c.hrQ.setText(a);
                    }
                    Drawable drawable = c_c.hrp.getDrawable();
                    if ((drawable instanceof AnimationDrawable) && ((AnimationDrawable) drawable).isRunning()) {
                        ((AnimationDrawable) drawable).stop();
                    }
                    if (this.hqN.isPlaying() && nz.field_msgId == this.hqN.hsy) {
                        c_c.hrp.setImageResource(com.tencent.mm.plugin.brandservice.b.c.chatting_item_biz_voice_playing_selector);
                        if (c_c.hrp.getDrawable() instanceof AnimationDrawable) {
                            ((AnimationDrawable) c_c.hrp.getDrawable()).start();
                        }
                    } else {
                        c_c.hrp.setImageResource(com.tencent.mm.plugin.brandservice.b.c.chatting_item_biz_voice_play_selector);
                    }
                    c_c.hrp.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            h g = a.this.hqN;
                            Object b = a.this.hqC;
                            String fullPath = com.tencent.mm.modelvoice.q.getFullPath(nz.field_imgPath);
                            long j = nz.field_msgId;
                            g.avp().a(g);
                            x.d("MicroMsg.FavVoiceLogic", "start play, path[%s]", new Object[]{fullPath});
                            if (g.avp().startPlay(fullPath, -1)) {
                                g.hsy = j;
                                return;
                            }
                            Toast.makeText(b, com.tencent.mm.plugin.brandservice.b.h.biz_time_line_play_voice_fail, 1).show();
                            g.hsy = 0;
                        }
                    });
                    a(c_c, nz);
                    a(i, nz, c_c.hrh, c_c.hrg);
                    c_c.hrH.setOnTouchListener(this.hqR);
                    c_c.hrH.setOnLongClickListener(new 18(this, nz));
                    break;
                case 285212721:
                    c.e eVar;
                    if (view == null) {
                        c.e eVar2 = new c.e();
                        view = View.inflate(this.hqC, b$e.biz_time_line_item, null);
                        eVar2.hrw = (LinearLayout) view.findViewById(com.tencent.mm.plugin.brandservice.b.d.biz_time_line_content_ll);
                        eVar2.hrx = (LinearLayout) view.findViewById(com.tencent.mm.plugin.brandservice.b.d.show_more_article_layout);
                        eVar2.hry = (TextView) view.findViewById(com.tencent.mm.plugin.brandservice.b.d.show_more_article_tv);
                        eVar2.hrg = (LinearLayout) view.findViewById(com.tencent.mm.plugin.brandservice.b.d.biz_time_line_new_tips_layout);
                        eVar2.hrh = (LinearLayout) view.findViewById(com.tencent.mm.plugin.brandservice.b.d.biz_time_line_item_top);
                        view.setTag(eVar2);
                        eVar = eVar2;
                    } else {
                        eVar = (c.e) view.getTag();
                    }
                    for (c.b bVar2 : eVar.hrz) {
                        ao.L(bVar2.hri, 3);
                        eVar.hrw.removeView(bVar2.hri);
                    }
                    eVar.hrz.clear();
                    l wS2 = ((com.tencent.mm.plugin.biz.a.a) g.l(com.tencent.mm.plugin.biz.a.a.class)).wS(nz.field_content);
                    List list = wS2.dzs;
                    int size = list.size();
                    if (size != 0) {
                        eVar.hrw.setVisibility(0);
                        a(eVar, ((m) list.get(0)).type, size);
                        LayoutInflater layoutInflater = this.hqC.getLayoutInflater();
                        cEg = eVar.hrz.size();
                        while (true) {
                            int i4 = cEg;
                            if (i4 >= size) {
                                cEg = 0;
                                while (true) {
                                    int i5 = cEg;
                                    if (i5 >= eVar.hrz.size()) {
                                        m mVar2 = (m) list.get(0);
                                        if (mVar2.type == 5) {
                                            cm(eVar.hrB.hrL);
                                            if (bi.oW(mVar2.title)) {
                                                eVar.hrB.hrI.setVisibility(8);
                                            } else {
                                                eVar.hrB.hrI.Q(mVar2.title);
                                                eVar.hrB.hrI.setVisibility(0);
                                            }
                                            eVar.hrB.hrq.setBackgroundResource(com.tencent.mm.plugin.brandservice.b.c.biz_time_line_mask);
                                            a = com.tencent.mm.y.i.gR(mVar2.dzC);
                                            if (TextUtils.isEmpty(a)) {
                                                eVar.hrB.hrP.setVisibility(8);
                                            } else {
                                                eVar.hrB.hrP.setVisibility(0);
                                                eVar.hrB.hrP.setText(a);
                                                eVar.hrB.hrP.setTextColor(this.hqC.getResources().getColor(com.tencent.mm.plugin.brandservice.b.a.light_grey_text_color));
                                            }
                                            a(eVar.hrB, nz);
                                            a(mVar2, nz, i, wS2, eVar.hrB.hri, size > 1, 0);
                                            eVar.hrB.hrq.setVisibility(8);
                                            a(mVar2.dzy, eVar.hrB.hro, nz.field_type, hqD, new 3(this, eVar));
                                            u(eVar.hrB.hri, size);
                                        } else if (mVar2.type == 8) {
                                            cm(eVar.hrC.hrL);
                                            eVar.hrC.hrM.setText(mVar2.dzO);
                                            eVar.hrC.hrI.Q(mVar2.title);
                                            eVar.hrC.hrq.setBackgroundResource(com.tencent.mm.plugin.brandservice.b.c.biz_time_line_cover_pic_mask);
                                            eVar.hrC.hrq.setVisibility(8);
                                            eVar.hrC.hrM.setTextColor(this.hqC.getResources().getColor(com.tencent.mm.plugin.brandservice.b.a.light_grey_text_color));
                                            eVar.hrC.gwj.setBackgroundResource(com.tencent.mm.plugin.brandservice.b.g.chatting_item_biz_pic_loading_icon);
                                            a(mVar2.dzy, eVar.hrC.hro, nz.field_type, hqD, new 5(this, eVar));
                                            a(eVar.hrC, nz);
                                            a(mVar2, nz, i, wS2, eVar.hrC.hri, size > 1, 0);
                                            u(eVar.hrC.hri, size);
                                        } else if (mVar2.type == 7) {
                                            if (bi.oW(mVar2.title)) {
                                                eVar.hrD.hrI.setVisibility(8);
                                            } else {
                                                eVar.hrD.hrI.setVisibility(0);
                                                eVar.hrD.hrI.Q(mVar2.title);
                                            }
                                            a = com.tencent.mm.y.i.gR(mVar2.dzC);
                                            if (TextUtils.isEmpty(a)) {
                                                eVar.hrD.hrQ.setVisibility(4);
                                            } else {
                                                eVar.hrD.hrQ.setVisibility(0);
                                                eVar.hrD.hrQ.setText(a);
                                            }
                                            Drawable drawable2 = eVar.hrD.hrp.getDrawable();
                                            if ((drawable2 instanceof AnimationDrawable) && ((AnimationDrawable) drawable2).isRunning()) {
                                                ((AnimationDrawable) drawable2).stop();
                                            }
                                            if ((nz.field_msgId + "_0").equals(com.tencent.mm.plugin.brandservice.ui.b.b.avq())) {
                                                eVar.hrD.hrp.setImageResource(com.tencent.mm.plugin.brandservice.b.c.chatting_item_biz_voice_playing_selector);
                                                if (eVar.hrD.hrp.getDrawable() instanceof AnimationDrawable) {
                                                    ((AnimationDrawable) eVar.hrD.hrp.getDrawable()).start();
                                                }
                                            } else {
                                                eVar.hrD.hrp.setImageResource(com.tencent.mm.plugin.brandservice.b.c.chatting_item_biz_voice_play_selector);
                                            }
                                            a(eVar.hrD.hrp, nz, 0, mVar2.dzy);
                                            a(eVar.hrD, nz);
                                            a(mVar2, nz, i, wS2, eVar.hrD.hri, size > 1, 0);
                                            u(eVar.hrD.hri, size);
                                        } else if (mVar2.type == 6) {
                                            mVar2 = (m) list.get(0);
                                            if (bi.oW(mVar2.title)) {
                                                eVar.hrE.hrI.setVisibility(8);
                                            } else {
                                                eVar.hrE.hrI.setVisibility(0);
                                                eVar.hrE.hrI.Q(mVar2.title);
                                            }
                                            if (TextUtils.isEmpty(mVar2.dzM)) {
                                                eVar.hrE.hrJ.setVisibility(8);
                                            } else {
                                                eVar.hrE.hrJ.setVisibility(0);
                                                eVar.hrE.hrJ.setText(mVar2.dzM);
                                            }
                                            if (mVar2.dzN == 2) {
                                                eVar.hrE.hrK.setImageResource(com.tencent.mm.plugin.brandservice.b.g.chatting_item_biz_kugou_music_watermark);
                                            } else {
                                                eVar.hrE.hrK.setImageResource(com.tencent.mm.plugin.brandservice.b.g.chatting_item_biz_qq_music_watermark);
                                            }
                                            a(eVar.hrE.hrp, nz, 0, mVar2.dzy);
                                            a(eVar.hrE, nz);
                                            a(mVar2, nz, i, wS2, eVar.hrE.hri, size > 1, 0);
                                            if ((nz.field_msgId + "_0").equals(com.tencent.mm.plugin.brandservice.ui.b.b.avq())) {
                                                eVar.hrE.hrp.setImageResource(com.tencent.mm.plugin.brandservice.b.g.chatting_item_biz_music_pause_loading_icon);
                                            } else {
                                                eVar.hrE.hrp.setImageResource(com.tencent.mm.plugin.brandservice.b.g.chatting_item_biz_music_play_loading_icon);
                                            }
                                            eVar.hrE.hrq.setVisibility(8);
                                            a(mVar2.dzy, eVar.hrE.hro, nz.field_type, hqE, hqE, "@S", new 4(this, eVar, nz));
                                            u(eVar.hrE.hri, size);
                                        } else if (mVar2.type == 10) {
                                            if (bi.oW(mVar2.title)) {
                                                eVar.hrF.hrI.setVisibility(8);
                                            } else {
                                                eVar.hrF.hrI.setVisibility(0);
                                                eVar.hrF.hrI.Q(mVar2.title);
                                            }
                                            if (size > 1) {
                                                eVar.hrF.hrO.setVisibility(8);
                                                eVar.hrF.hrI.setTextSize(1, 18.0f * com.tencent.mm.bp.a.fe(this.hqC));
                                            } else {
                                                eVar.hrF.hrO.setVisibility(0);
                                                eVar.hrF.hrI.setTextSize(1, 15.0f * com.tencent.mm.bp.a.fe(this.hqC));
                                            }
                                            a(eVar.hrF, nz);
                                            a(mVar2, nz, i, wS2, eVar.hrF.hri, size > 1, 0);
                                            u(eVar.hrF.hri, size);
                                        } else {
                                            cm(eVar.hrA.hro);
                                            eVar.hrA.hrI.Q(mVar2.title);
                                            if (bi.oW(mVar2.dzy)) {
                                                eVar.hrA.hro.setVisibility(8);
                                                if (bi.oW(mVar2.dzA)) {
                                                    eVar.hrA.hrN.setVisibility(8);
                                                } else {
                                                    eVar.hrA.hrN.setVisibility(0);
                                                    eVar.hrA.hrN.setText(mVar2.dzA);
                                                }
                                            } else {
                                                eVar.hrA.hro.setVisibility(0);
                                                eVar.hrA.hrN.setVisibility(8);
                                                a(mVar2.dzy, eVar.hrA.hro, mVar2.type, hqD, null);
                                            }
                                            eVar.hrw.setOnClickListener(new 2(this));
                                            a(eVar.hrA, nz);
                                            a(mVar2, nz, i, wS2, eVar.hrA.hri, size > 1, 0);
                                            u(eVar.hrA.hri, size);
                                        }
                                        if (size <= 2 || nz.field_isExpand) {
                                            eVar.hrx.setVisibility(8);
                                        } else {
                                            eVar.hrx.setVisibility(0);
                                            eVar.hry.setText(this.hqC.getString(com.tencent.mm.plugin.brandservice.b.h.biz_time_line_show_more_article, new Object[]{Integer.valueOf(size - 2)}));
                                            eVar.hrx.setTag(nz);
                                            eVar.hrx.setOnClickListener(this.hqS);
                                        }
                                        int i6 = 1;
                                        while (i6 < size && (nz.field_isExpand || i6 <= 1)) {
                                            m mVar3 = (m) list.get(i6);
                                            c.b bVar3 = (c.b) eVar.hrz.get(i6 - 1);
                                            if (i6 == size - 1) {
                                                bVar3.hrk.setPadding(0, hqG, 0, hqF);
                                            } else {
                                                bVar3.hrk.setPadding(0, hqG, 0, hqG);
                                            }
                                            a(bVar3, mVar3, nz, i6, false);
                                            bVar3.hrl.Q(mVar3.title);
                                            bVar3.hrl.setTextColor(this.hqC.getResources().getColor(com.tencent.mm.plugin.brandservice.b.a.black));
                                            if (mVar3.dzB == 0 || mVar3.dzB == 1) {
                                                bVar3.hrn.setVisibility(0);
                                                bVar3.hrl.setTextColor(this.hqC.getResources().getColor(com.tencent.mm.plugin.brandservice.b.a.black));
                                                if (mVar3.type == 7) {
                                                    a(com.tencent.mm.plugin.brandservice.b.c.chatting_item_biz_play_icon_bg, bVar3.hro, hqE, hqE);
                                                } else if (!bi.oW(mVar3.dzy)) {
                                                    a(mVar3.dzy, bVar3.hro, nz.field_type, hqE, hqE, "@S", (com.tencent.mm.pluginsdk.ui.applet.e.a) new 21(this, eVar, bVar3, mVar3, nz, i6));
                                                } else if (mVar3.type == 5 || mVar3.type == 6) {
                                                    a(com.tencent.mm.plugin.brandservice.b.c.chatting_item_biz_play_icon_bg, bVar3.hro, hqE, hqE);
                                                } else {
                                                    bVar3.hrn.setVisibility(8);
                                                }
                                            } else {
                                                bVar3.hrn.setVisibility(8);
                                                bVar3.hrl.setTextColor(this.hqC.getResources().getColor(com.tencent.mm.plugin.brandservice.b.a.hint_text_color));
                                            }
                                            if (bi.oW(mVar3.dzA) || mVar3.type != 3) {
                                                bVar3.hrm.setVisibility(8);
                                            } else {
                                                bVar3.hrm.setText(mVar3.dzA);
                                                bVar3.hrm.setVisibility(0);
                                            }
                                            bVar3.hri.setVisibility(0);
                                            a(mVar3, nz, i, wS2, bVar3.hri, size > 1, i6);
                                            i6++;
                                        }
                                        a(i, nz, eVar.hrh, eVar.hrg);
                                        break;
                                    }
                                    ((c.b) eVar.hrz.get(i5)).hri.setVisibility(8);
                                    cEg = i5 + 1;
                                }
                            } else {
                                view2 = ao.EX(3);
                                if (view2 == null) {
                                    view2 = layoutInflater.inflate(b$e.biz_time_line_item_comm_slot, null);
                                }
                                View view3 = view2;
                                ViewGroup viewGroup2 = eVar.hrw;
                                c.b bVar4 = new c.b();
                                bVar4.hri = view3;
                                bVar4.hrj = view3.findViewById(com.tencent.mm.plugin.brandservice.b.d.top_line);
                                bVar4.hrk = view3.findViewById(com.tencent.mm.plugin.brandservice.b.d.content_ll);
                                bVar4.hrl = (MMNeatTextView) view3.findViewById(com.tencent.mm.plugin.brandservice.b.d.title_neat_tv);
                                bVar4.hrm = (TextView) view3.findViewById(com.tencent.mm.plugin.brandservice.b.d.summary);
                                bVar4.hrn = view3.findViewById(com.tencent.mm.plugin.brandservice.b.d.cover_area);
                                bVar4.hro = (ImageView) view3.findViewById(com.tencent.mm.plugin.brandservice.b.d.cover_iv);
                                bVar4.hrp = (ImageView) view3.findViewById(com.tencent.mm.plugin.brandservice.b.d.play_icon);
                                viewGroup2.addView(view3, viewGroup2.getChildCount());
                                eVar.hrz.add(bVar4);
                                cEg = i4 + 1;
                            }
                        }
                    } else {
                        eVar.hrw.setVisibility(8);
                        a(eVar, -1, 0);
                        break;
                    }
                    break;
                default:
                    if (view == null) {
                        fVar = new c.m();
                        obj = this.hqC;
                        if (fVar.hri != null) {
                            view2 = fVar.hri;
                        } else {
                            fVar.hri = View.inflate(obj, b$e.biz_time_line_unknown_item, null);
                            fVar.avh();
                            view2 = fVar.hri;
                        }
                        view2.setTag(fVar);
                        view = view2;
                    } else {
                        fVar = (c.m) view.getTag();
                    }
                    a(fVar, nz);
                    a(i, nz, fVar.hrh, fVar.hrg);
                    break;
            }
        }
        x.e("MicroMsg.BizTimeLineAdapter", "getView info is null");
        return view;
    }

    public final void a(q qVar) {
        if (qVar == null) {
            x.w("MicroMsg.BizTimeLineAdapter", "updateGroupId info is null");
            return;
        }
        x.d("MicroMsg.BizTimeLineAdapter", "updateGroupId keep %b, groupId %d, maxGroupId %d", new Object[]{Boolean.valueOf(this.hqO), Long.valueOf(qVar.ckx()), Long.valueOf(z.Ne().ckD())});
        if (!this.hqO && r0 == r2 && z.Ne().gi(qVar.field_orderFlag) > 0) {
            r Ne = z.Ne();
            Ne.dCZ.fV("BizTimeLineInfo", "update BizTimeLineInfo set status = 4 where status != 4");
            r$a r_a = new r$a();
            r_a.sNY = r.b.sOc;
            Ne.b(r_a);
            if (z.Ne().ckx() <= z.Ne().ckD()) {
                z.Ne().ckE();
            }
            this.hqC.avo();
        }
    }

    private int getContentWidth() {
        return com.tencent.mm.bp.a.fk(this.hqC) - ((int) (com.tencent.mm.bp.a.getDensity(this.hqC) * 48.0f));
    }

    private void a(int i, q qVar, View view, View view2) {
        int i2 = 1;
        if (i > 0) {
            view.setVisibility(0);
            if (hqM == null) {
                long ckx = qVar.ckx();
                long j = 0;
                q nz = getItem(i - 1);
                if (nz != null) {
                    j = nz.ckx();
                }
                if (ckx == j || j != z.Ne().ckD()) {
                    i2 = 0;
                } else {
                    hqM = Long.valueOf(qVar.field_msgId);
                }
            } else if (hqM.longValue() != qVar.field_msgId) {
                i2 = 0;
            }
            if (i2 != 0) {
                view2.setVisibility(0);
            } else {
                view2.setVisibility(8);
            }
        } else {
            view.setVisibility(8);
        }
        a(qVar);
        g.Em().H(new 12(this, qVar));
    }

    private void a(m mVar, q qVar, int i, l lVar, View view, boolean z, int i2) {
        ((com.tencent.mm.plugin.brandservice.a.a) g.l(com.tencent.mm.plugin.brandservice.a.a.class)).a(mVar, qVar, i, lVar, view, z);
        view.setOnTouchListener(this.hqR);
        view.setOnLongClickListener(new 6(this, qVar, i2));
    }

    private void a(c$c c_c, q qVar) {
        com.tencent.mm.pluginsdk.ui.a.b.n(c_c.eCl, qVar.field_talker);
        c_c.hrt.setText(j.a(this.hqC, com.tencent.mm.model.r.gT(qVar.field_talker), c_c.hrt.getTextSize()));
        c_c.hrs.setText(com.tencent.mm.plugin.brandservice.ui.b.a.e(this.hqC, qVar.field_createTime));
        c_c.hrr.setOnTouchListener(this.hqR);
        c_c.hrr.setTag(qVar);
        c_c.hrr.setOnLongClickListener(this.hqT);
        c_c.hrr.setOnClickListener(this.hqU);
    }

    private void a(c.b bVar, m mVar, q qVar, int i, boolean z) {
        if (mVar.type == 5) {
            bVar.hrp.setVisibility(0);
            if (z) {
                bVar.hrp.setImageResource(com.tencent.mm.plugin.brandservice.b.g.chatting_item_biz_video_small_icon);
            } else {
                bVar.hrp.setImageResource(com.tencent.mm.plugin.brandservice.b.g.chatting_item_biz_video_small_loading_icon);
            }
            bVar.hrp.setOnClickListener(new 11(this, bVar));
        } else if (mVar.type == 6) {
            bVar.hrp.setVisibility(0);
            if (z) {
                if ((qVar.field_msgId + "_" + i).equals(com.tencent.mm.plugin.brandservice.ui.b.b.avq())) {
                    bVar.hrp.setImageResource(com.tencent.mm.plugin.brandservice.b.c.chatting_item_biz_music_pause_selector);
                } else {
                    bVar.hrp.setImageResource(com.tencent.mm.plugin.brandservice.b.c.chatting_item_biz_music_play_selector);
                }
            } else if ((qVar.field_msgId + "_" + i).equals(com.tencent.mm.plugin.brandservice.ui.b.b.avq())) {
                bVar.hrp.setImageResource(com.tencent.mm.plugin.brandservice.b.g.chatting_item_biz_music_pause_loading_icon);
            } else {
                bVar.hrp.setImageResource(com.tencent.mm.plugin.brandservice.b.g.chatting_item_biz_music_play_loading_icon);
            }
            a(bVar.hrp, qVar, i, mVar.dzy);
        } else if (mVar.type == 7) {
            bVar.hrp.setVisibility(0);
            Drawable drawable = bVar.hrp.getDrawable();
            if ((drawable instanceof AnimationDrawable) && ((AnimationDrawable) drawable).isRunning()) {
                ((AnimationDrawable) drawable).stop();
            }
            if ((qVar.field_msgId + "_" + i).equals(com.tencent.mm.plugin.brandservice.ui.b.b.avq())) {
                bVar.hrp.setImageResource(com.tencent.mm.plugin.brandservice.b.c.chatting_item_biz_voice_playing_selector);
                if (bVar.hrp.getDrawable() instanceof AnimationDrawable) {
                    ((AnimationDrawable) bVar.hrp.getDrawable()).start();
                }
            } else {
                bVar.hrp.setImageResource(com.tencent.mm.plugin.brandservice.b.c.chatting_item_biz_voice_play_selector);
            }
            a(bVar.hrp, qVar, i, mVar.dzy);
        } else {
            bVar.hrp.setVisibility(8);
        }
    }

    private static void a(ImageView imageView, q qVar, int i, String str) {
        ((com.tencent.mm.plugin.brandservice.a.a) g.l(com.tencent.mm.plugin.brandservice.a.a.class)).a(imageView, qVar.field_msgId, str, qVar.field_content, i);
    }

    private static void a(View view, c$c c_c, boolean z) {
        if (z) {
            if (c_c.hri == null) {
                c_c.cn(view);
            }
            if (c_c.hri != null) {
                c_c.hri.setVisibility(0);
            }
        } else if (c_c.hri != null) {
            c_c.hri.setVisibility(8);
        }
    }

    private static void a(c.e eVar, int i, int i2) {
        boolean z;
        boolean z2 = true;
        boolean z3 = i == 5;
        a(eVar.hrw, eVar.hrB, z3);
        if (z3) {
            z = true;
        } else {
            z = false;
        }
        if (i == 8) {
            z3 = true;
        } else {
            z3 = false;
        }
        a(eVar.hrw, eVar.hrC, z3);
        if (z3) {
            z = true;
        }
        if (i == 7) {
            z3 = true;
        } else {
            z3 = false;
        }
        a(eVar.hrw, eVar.hrD, z3);
        if (z3) {
            z = true;
        }
        if (i == 6) {
            z3 = true;
        } else {
            z3 = false;
        }
        a(eVar.hrw, eVar.hrE, z3);
        if (z3) {
            z = true;
        }
        if (i == 10) {
            z3 = true;
        } else {
            z3 = false;
        }
        a(eVar.hrw, eVar.hrF, z3);
        if (z3) {
            z3 = true;
        } else {
            z3 = z;
        }
        View view = eVar.hrw;
        c$c c_c = eVar.hrA;
        if (z3 || i2 <= 0) {
            z2 = false;
        }
        a(view, c_c, z2);
    }

    private void a(String str, ImageView imageView, int i, int i2, com.tencent.mm.pluginsdk.ui.applet.e.a aVar) {
        String lX;
        if (com.tencent.mm.ak.q.Pn()) {
            lX = com.tencent.mm.ak.q.lX(str);
        } else {
            lX = str;
        }
        int i3 = com.tencent.mm.plugin.brandservice.b.c.biz_time_line_cover_default_bg;
        int contentWidth = getContentWidth();
        com.tencent.mm.ak.a.a Pj = o.Pj();
        com.tencent.mm.ak.a.a.c.a aVar2 = new com.tencent.mm.ak.a.a.c.a();
        aVar2.dXR = i3;
        aVar2.dXy = true;
        com.tencent.mm.ak.a.a.c.a bg = aVar2.bg(contentWidth, i2);
        bg.dXn = new com.tencent.mm.pluginsdk.ui.applet.f();
        bg.dXA = com.tencent.mm.pluginsdk.model.q.v(lX, i, "@T");
        Pj.a(lX, imageView, bg.Pt(), null, new com.tencent.mm.pluginsdk.ui.applet.e(0, contentWidth, i2, aVar));
    }

    private static void a(String str, ImageView imageView, int i, int i2, int i3, String str2, com.tencent.mm.pluginsdk.ui.applet.e.a aVar) {
        String lX;
        if (com.tencent.mm.ak.q.Pn()) {
            lX = com.tencent.mm.ak.q.lX(str);
        } else {
            lX = str;
        }
        com.tencent.mm.ak.a.a Pj = o.Pj();
        com.tencent.mm.ak.a.a.c.a aVar2 = new com.tencent.mm.ak.a.a.c.a();
        aVar2.dXR = com.tencent.mm.plugin.brandservice.b.a.chatting_item_biz_default_bg;
        aVar2.dXy = true;
        aVar2 = aVar2.bg(i2, i3);
        aVar2.dXn = new com.tencent.mm.pluginsdk.ui.applet.f();
        aVar2.dXA = com.tencent.mm.pluginsdk.model.q.v(lX, i, str2);
        Pj.a(lX, imageView, aVar2.Pt(), null, new com.tencent.mm.pluginsdk.ui.applet.e(0, 0, 0, aVar));
    }

    private static void a(String str, ImageView imageView, int i, int i2) {
        com.tencent.mm.ak.a.a Pj = o.Pj();
        com.tencent.mm.ak.a.a.c.a aVar = new com.tencent.mm.ak.a.a.c.a();
        aVar.dXw = true;
        aVar.dXN = com.tencent.mm.plugin.brandservice.b.a.chatting_item_biz_default_bg;
        aVar = aVar.bg(i, i2);
        aVar.dXD = 4;
        Pj.a(str, imageView, aVar.Pt(), null, new com.tencent.mm.pluginsdk.ui.applet.e());
    }

    private static void u(View view, int i) {
        if (i > 1) {
            view.setPadding(hqF, hqF, hqF, hqG);
        } else {
            view.setPadding(hqF, hqF, hqF, hqF);
        }
    }

    private static void cm(View view) {
        LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = hqD;
        view.setLayoutParams(layoutParams);
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        if (this.hqH == null) {
            x.w("MicroMsg.BizTimeLineAdapter", "onCreateContextMenu mInfo == null");
        } else if (this.hqJ == 0) {
            ab Yg = ((i) g.l(i.class)).FR().Yg(this.hqH.field_talker);
            if (Yg == null) {
                x.e("MicroMsg.BizTimeLineAdapter", "onCreateContextMenu, contact is null, talker = " + this.hqH.field_talker);
                return;
            }
            contextMenu.setHeaderTitle(j.a(this.hqC, Yg.BL()));
            if (com.tencent.mm.l.a.gd(Yg.field_type)) {
                contextMenu.add(0, 2, 0, com.tencent.mm.plugin.brandservice.b.h.main_conversation_longclick_delete_biz_service);
            }
            contextMenu.add(0, 3, 0, this.hqC.getString(com.tencent.mm.plugin.brandservice.b.h.biz_time_line_longclick_about, new Object[]{r1}));
        } else if (this.hqH.cky()) {
            l wS = ((com.tencent.mm.plugin.biz.a.a) g.l(com.tencent.mm.plugin.biz.a.a.class)).wS(this.hqH.field_content);
            if (wS == null) {
                x.w("MicroMsg.BizTimeLineAdapter", "onCreateContextMenu reader is null");
                return;
            }
            this.hqK = false;
            if (this.hqI >= 0 && this.hqI < wS.dzs.size() && com.tencent.mm.y.i.gr(((m) wS.dzs.get(this.hqI)).dzD)) {
                this.hqK = true;
            }
            if (!com.tencent.mm.y.i.gu(this.hqH.field_content)) {
                contextMenu.add(0, 4, 0, view.getContext().getString(com.tencent.mm.plugin.brandservice.b.h.retransmit));
            }
            if (com.tencent.mm.bg.d.QS("favorite") && !this.hqK) {
                contextMenu.add(0, 5, 0, view.getContext().getString(com.tencent.mm.plugin.brandservice.b.h.plugin_favorite_opt));
            }
        } else if (this.hqH.ckA()) {
            contextMenu.add(0, 6, 0, view.getContext().getString(com.tencent.mm.plugin.brandservice.b.h.retransmit));
            if (com.tencent.mm.bg.d.QS("favorite") && !this.hqK) {
                contextMenu.add(0, 7, 0, view.getContext().getString(com.tencent.mm.plugin.brandservice.b.h.plugin_favorite_opt));
            }
        } else if (this.hqH.isText()) {
            contextMenu.add(0, 9, 0, view.getContext().getString(com.tencent.mm.plugin.brandservice.b.h.app_copy));
            contextMenu.add(0, 8, 0, view.getContext().getString(com.tencent.mm.plugin.brandservice.b.h.retransmit));
            if (com.tencent.mm.bg.d.QS("favorite")) {
                contextMenu.add(0, 7, 0, view.getContext().getString(com.tencent.mm.plugin.brandservice.b.h.plugin_favorite_opt));
            }
        } else if (this.hqH.ckz() && com.tencent.mm.bg.d.QS("favorite")) {
            contextMenu.add(0, 7, 0, view.getContext().getString(com.tencent.mm.plugin.brandservice.b.h.plugin_favorite_opt));
        }
    }

    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public final q avf() {
        if (this.gxs.size() > 0) {
            return (q) this.gxs.get(this.gxs.size() - 1);
        }
        return null;
    }

    public static void avg() {
        hqM = null;
    }
}
