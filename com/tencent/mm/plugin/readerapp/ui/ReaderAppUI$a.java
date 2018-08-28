package com.tencent.mm.plugin.readerapp.ui;

import android.content.Context;
import android.database.Cursor;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ak.o;
import com.tencent.mm.ak.q;
import com.tencent.mm.bp.a;
import com.tencent.mm.model.bi;
import com.tencent.mm.plugin.readerapp.a$a;
import com.tencent.mm.plugin.readerapp.a.b;
import com.tencent.mm.plugin.readerapp.a.c;
import com.tencent.mm.plugin.readerapp.a.d;
import com.tencent.mm.plugin.readerapp.a.e;
import com.tencent.mm.plugin.readerapp.c.g;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.ui.applet.f;
import com.tencent.mm.ui.widget.MMNeatTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ReaderAppUI$a extends a<Long> {
    private Context context;
    private int edl;
    private int hFO;
    private int hqE;
    private int hqF = 0;
    private int hqG = 0;
    final /* synthetic */ ReaderAppUI mnQ;
    private ImageGetter mnU = new 1(this);
    private int mnV = 0;
    private int mnW = 0;
    private int mnX = 0;
    private int mnY;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        return Long.valueOf(cursor.getLong(0));
    }

    public ReaderAppUI$a(ReaderAppUI readerAppUI, Context context, Long l) {
        this.mnQ = readerAppUI;
        super(context, l);
        this.context = context;
        this.hFO = 3;
        this.edl = g.bpT().hg(ReaderAppUI.a(readerAppUI));
        this.hqG = context.getResources().getDimensionPixelSize(b.SmallPadding);
        this.hqF = context.getResources().getDimensionPixelSize(b.LargePadding);
        this.mnV = context.getResources().getDimensionPixelSize(b.BasicPaddingSize);
        this.mnW = context.getResources().getDimensionPixelSize(b.MiddlePadding);
        this.hqE = context.getResources().getDimensionPixelSize(b.chatting_item_biz_sub_item_pic_size);
        this.mnY = context.getResources().getDimensionPixelSize(b.chatting_item_biz_line_big_padding);
        int fk = a.fk(context);
        int fl = a.fl(context);
        if (fk >= fl) {
            fk = fl;
        }
        this.mnX = ((fk - ((int) (ReaderAppUI.bpl() * 32.0f))) * 9) / 16;
    }

    protected final void WS() {
        WT();
    }

    public final boolean ayQ() {
        return this.hFO >= this.edl;
    }

    public final int bpU() {
        return this.hFO;
    }

    public final int ayR() {
        if (ayQ()) {
            return 0;
        }
        this.hFO += 3;
        if (this.hFO <= this.edl) {
            return 3;
        }
        this.hFO = this.edl;
        return this.edl % 3;
    }

    public final void WT() {
        this.edl = g.bpT().hg(20);
        setCursor(g.bpT().bb(this.hFO, 20));
        super.notifyDataSetChanged();
    }

    private Long vf(int i) {
        return (Long) super.getItem(i);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        a aVar;
        if (view == null) {
            b bVar2 = new b(this);
            view = View.inflate(this.context, e.reader_app_list_item, null);
            bVar2.jWm = (TextView) view.findViewById(d.reader_app_item_time_tv);
            bVar2.mod = (ViewGroup) view.findViewById(d.reader_app_content_ll);
            bVar2.eSd = view.findViewById(d.bottom_container);
            bVar2.hrL = view.findViewById(d.cover_container);
            bVar2.mog = (ImageView) view.findViewById(d.press_mask_iv);
            bVar2.mof = (ImageView) view.findViewById(d.cover_shadow_mask_iv);
            bVar2.eGX = (TextView) view.findViewById(d.reader_app_item_title_tv);
            bVar2.mob = (ImageView) view.findViewById(d.reader_app_item_photo_iv);
            bVar2.laT = (TextView) view.findViewById(d.reader_app_item_content_tv);
            bVar2.moc = view.findViewById(d.topSlot);
            bVar2.moe = (MMNeatTextView) view.findViewById(d.title_textview_in_image);
            bVar2.hrz = new ArrayList();
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        for (a aVar2 : bVar.hrz) {
            bVar.mod.removeView(aVar2.hri);
        }
        bVar.hrz.clear();
        List c = g.bpT().c(vf(i).longValue(), 20);
        if (c.size() > 0) {
            int i2;
            int size = c.size();
            bi biVar = (bi) c.get(0);
            bVar.jWm.setText(h.c(this.context, biVar.time, false));
            if (ReaderAppUI.h(this.mnQ) != null) {
                bVar.jWm.setTextColor(ReaderAppUI.h(this.mnQ).qER);
                if (ReaderAppUI.h(this.mnQ).qES) {
                    bVar.jWm.setShadowLayer(2.0f, 1.2f, 1.2f, ReaderAppUI.h(this.mnQ).qET);
                } else {
                    bVar.jWm.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                }
                if (ReaderAppUI.h(this.mnQ).qEU) {
                    bVar.jWm.setBackgroundResource(c.chat_tips_bg);
                    bVar.jWm.setPadding(this.hqG, this.mnV, this.hqG, this.mnV);
                } else {
                    bVar.jWm.setBackgroundColor(0);
                }
            }
            bVar.moc.setOnClickListener(this.mnQ.a(biVar, ReaderAppUI.a(this.mnQ), 0, biVar.getTitle()));
            Object obj = size == 1 ? 1 : null;
            bVar.eGX.setText(biVar.getTitle());
            bVar.laT.setText(biVar.IA());
            Object obj2 = !com.tencent.mm.sdk.platformtools.bi.oW(biVar.Iz()) ? 1 : null;
            if (biVar.Iu()) {
                bVar.moe.Q(Html.fromHtml(biVar.getTitle() + "<img src='" + c.reader_news_video_big + "'/>", this.mnU, null));
            } else {
                bVar.moe.Q(biVar.getTitle());
            }
            TextView textView = bVar.laT;
            int i3 = (obj == null || com.tencent.mm.sdk.platformtools.bi.oW(biVar.IA())) ? 8 : 0;
            textView.setVisibility(i3);
            bVar.mof.setVisibility(8);
            if (obj != null) {
                bVar.mog.setBackgroundResource(c.chatting_share_reader_mask);
                bVar.eSd.setVisibility(0);
                bVar.moe.setVisibility(8);
                bVar.eGX.setVisibility(0);
            } else {
                bVar.mog.setBackgroundResource(c.chatting_share_reader_mask_top_round);
                bVar.eSd.setVisibility(obj2 != null ? 8 : 0);
                bVar.eGX.setVisibility(8);
                bVar.moe.setVisibility(0);
                bVar.moe.setTextColor(this.mnQ.mController.tml.getResources().getColor(a$a.light_grey_text_color));
                bVar.moe.setBackgroundResource(c.mm_trans);
            }
            cm(bVar.mog);
            cm(bVar.hrL);
            if (obj2 != null) {
                bVar.hrL.setVisibility(0);
                String Iz = biVar.Iz();
                ImageView imageView = bVar.mob;
                int i4 = biVar.type;
                int i5 = this.mnX;
                2 2 = new 2(this, bVar);
                if (q.Pn()) {
                    Iz = q.lX(Iz);
                }
                int i6 = c.biz_bg_top_rounded_mask;
                i2 = c.biz_item_cover_top_round_bg;
                int fk = a.fk(imageView.getContext()) - ((int) (ReaderAppUI.bpl() * 32.0f));
                com.tencent.mm.ak.a.a Pj = o.Pj();
                com.tencent.mm.ak.a.a.c.a aVar3 = new com.tencent.mm.ak.a.a.c.a();
                aVar3.dXR = i2;
                aVar3.dXy = true;
                aVar3.dXT = String.valueOf(i6);
                com.tencent.mm.ak.a.a.c.a bg = aVar3.bg(fk, i5);
                bg.dXn = new f();
                bg.dXA = com.tencent.mm.pluginsdk.model.q.v(Iz, i4, "@T");
                Pj.a(Iz, imageView, bg.Pt(), null, new com.tencent.mm.pluginsdk.ui.applet.e(i6, fk, i5, 2));
                bVar.eSd.setBackgroundResource(c.chatting_item_multbg_bottom_normal);
                bVar.eSd.setPadding(this.hqF, this.mnW, this.hqF, this.hqF);
                bVar.mog.setVisibility(0);
            } else {
                bVar.hrL.setVisibility(8);
                bVar.eGX.setVisibility(0);
                bVar.laT.setVisibility(com.tencent.mm.sdk.platformtools.bi.oW(biVar.IA()) ? 8 : 0);
                if (obj != null) {
                    bVar.eSd.setBackgroundResource(c.chatting_item_one_item);
                } else {
                    bVar.eSd.setBackgroundResource(c.chatting_item_multi_top);
                }
                bVar.eSd.setPadding(this.hqF, this.hqF, this.hqF, this.hqF);
                bVar.mog.setVisibility(8);
            }
            if (size > 1) {
                for (i2 = 1; i2 < size - 1; i2++) {
                    a(bVar, c, e.reader_news_item_slot_middle, i2, biVar.getTitle());
                }
                a(bVar, c, e.reader_news_item_slot_bottom, size - 1, biVar.getTitle());
            }
        }
        bVar.moc.setTag(Integer.valueOf(i));
        bVar.moc.setTag(d.reader_msgindex, Integer.valueOf(0));
        ReaderAppUI.i(this.mnQ).c(bVar.moc, ReaderAppUI.a(this.mnQ, c.size() == 1), ReaderAppUI.g(this.mnQ));
        int i7 = 1;
        Iterator it = bVar.hrz.iterator();
        while (true) {
            int i8 = i7;
            if (!it.hasNext()) {
                return view;
            }
            aVar2 = (a) it.next();
            aVar2.hri.setTag(Integer.valueOf(i));
            ReaderAppUI.i(this.mnQ).c(aVar2.hri, ReaderAppUI.a(this.mnQ, c.size() == 1), ReaderAppUI.g(this.mnQ));
            i7 = i8 + 1;
            aVar2.hri.setTag(d.reader_msgindex, Integer.valueOf(i8));
        }
    }

    private void a(b bVar, List<bi> list, int i, int i2, String str) {
        a aVar = new a(this);
        aVar.hri = View.inflate(this.context, i, null);
        aVar.eGX = (TextView) aVar.hri.findViewById(d.title);
        aVar.hro = (ImageView) aVar.hri.findViewById(d.cover);
        aVar.hrn = aVar.hri.findViewById(d.cover_area);
        aVar.hrj = aVar.hri.findViewById(d.top_line);
        aVar.hrk = aVar.hri.findViewById(d.content_ll);
        if (bVar != null) {
            bVar.mod.addView(aVar.hri);
            bVar.hrz.add(aVar);
        }
        bi biVar = (bi) list.get(i2);
        int size = list.size();
        if (i2 != 1) {
            aVar.hrj.setVisibility(0);
            bi biVar2 = (bi) list.get(i2);
            if (com.tencent.mm.sdk.platformtools.bi.oW(((bi) list.get(i2 - 1)).Iz()) || com.tencent.mm.sdk.platformtools.bi.oW(biVar2.Iz())) {
                E(aVar.hrj, this.hqF);
            } else {
                E(aVar.hrj, this.mnY);
            }
        } else if (com.tencent.mm.sdk.platformtools.bi.oW(((bi) list.get(0)).Iz())) {
            aVar.hrj.setVisibility(0);
            E(aVar.hrj, this.hqF);
        } else {
            aVar.hrj.setVisibility(8);
        }
        if (i2 == 1) {
            if (i2 == size - 1) {
                aVar.hrk.setPadding(0, this.hqF, 0, this.hqF);
            } else {
                aVar.hrk.setPadding(0, this.hqF, 0, this.hqG);
            }
        } else if (i2 == size - 1) {
            aVar.hrk.setPadding(0, this.hqG, 0, this.hqF);
        } else {
            aVar.hrk.setPadding(0, this.hqG, 0, this.hqG);
        }
        aVar.eGX.setText(biVar.getTitle());
        if (biVar.Iu()) {
            aVar.eGX.setText(Html.fromHtml(biVar.getTitle() + "<img src='" + c.reader_news_video_small + "'/>", this.mnU, null));
        } else {
            aVar.eGX.setText(biVar.getTitle());
        }
        if (com.tencent.mm.sdk.platformtools.bi.oW(biVar.Iz())) {
            aVar.hrn.setVisibility(8);
        } else {
            aVar.hro.setVisibility(0);
            String Iz = biVar.Iz();
            ImageView imageView = aVar.hro;
            int i3 = biVar.type;
            int i4 = this.hqE;
            int i5 = this.hqE;
            String str2 = "@S";
            if (q.Pn()) {
                Iz = q.lX(Iz);
            }
            com.tencent.mm.ak.a.a Pj = o.Pj();
            com.tencent.mm.ak.a.a.c.a aVar2 = new com.tencent.mm.ak.a.a.c.a();
            aVar2.dXR = a$a.chatting_item_biz_default_bg;
            aVar2.dXy = true;
            com.tencent.mm.ak.a.a.c.a bg = aVar2.bg(i4, i5);
            bg.dXn = new f();
            bg.dXA = com.tencent.mm.pluginsdk.model.q.v(Iz, i3, str2);
            Pj.a(Iz, imageView, bg.Pt(), null, new com.tencent.mm.pluginsdk.ui.applet.e(0, 0, 0, null));
        }
        aVar.hri.setOnClickListener(this.mnQ.a(biVar, ReaderAppUI.a(this.mnQ), i2, str));
    }

    private void cm(View view) {
        LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = this.mnX;
        view.setLayoutParams(layoutParams);
    }

    private static void E(View view, int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        layoutParams.rightMargin = i;
        view.setLayoutParams(layoutParams);
    }
}
