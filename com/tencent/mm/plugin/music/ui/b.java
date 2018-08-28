package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;
import android.graphics.drawable.shapes.RectShape;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.music.b.c;
import com.tencent.mm.plugin.music.model.d.a;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.d;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public final class b extends d implements a {
    int count;
    final int lAA = com.tencent.mm.bp.a.fromDPToPix(ad.getContext(), 260);
    HashMap<Integer, View> lAB = new HashMap();
    com.tencent.mm.plugin.music.model.d lAC = new com.tencent.mm.plugin.music.model.d();
    int lAD;
    final int lAz = com.tencent.mm.bp.a.fromDPToPix(ad.getContext(), 26);
    ag lxW = new ag(Looper.getMainLooper());
    boolean lzc;
    int scene;

    public b(Context context, int i, boolean z) {
        super(context);
        this.scene = i;
        this.lzc = z;
    }

    public final int getCount() {
        return this.count;
    }

    public final View a(View view, ViewGroup viewGroup, int i) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(com.tencent.mm.plugin.music.b.d.music_item, viewGroup, false);
            aVar = new a(this);
            aVar.lAG = (MusicItemLayout) view.findViewById(c.music_item_bg);
            aVar.lAL = (TextView) view.findViewById(c.music_name_tv);
            aVar.lAN = (LyricView) view.findViewById(c.lyric_view);
            aVar.lAH = view.findViewById(c.album_bg_area);
            aVar.lAI = view.findViewById(c.album_bg_mask1);
            aVar.lAJ = view.findViewById(c.album_bg_mask2);
            aVar.lAK = (CdnImageView) view.findViewById(c.album_bg);
            aVar.lAM = (TextView) view.findViewById(c.music_singer_tv);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        List list = h.bic().lyb;
        int size = (i - 100000) % list.size();
        if (size < 0) {
            size += list.size();
        }
        x.d("MicroMsg.Music.MusicMainAdapter", "play music index %d", new Object[]{Integer.valueOf(size)});
        com.tencent.mm.an.a IC = h.bid().IC((String) list.get(size));
        this.lAB.put(Integer.valueOf(i), view);
        aVar.f(IC, false);
        return view;
    }

    public final void tO(int i) {
        this.lAB.remove(Integer.valueOf(i));
    }

    public final int biD() {
        return h.bic().lyb.size();
    }

    public final void D(final int i, final long j) {
        ah.A(new Runnable() {
            public final void run() {
                View view = (View) b.this.lAB.get(Integer.valueOf(i));
                if (view != null) {
                    ((a) view.getTag()).lAN.setCurrentTime(j);
                }
            }
        });
    }

    public final void a(com.tencent.mm.an.a aVar, int[] iArr) {
        for (Entry value : this.lAB.entrySet()) {
            a aVar2 = (a) ((View) value.getValue()).getTag();
            if (aVar2.bTF.field_musicId.equals(aVar.field_musicId)) {
                x.i("MicroMsg.Music.MusicMainAdapter", "onColorReady: %s", new Object[]{aVar2.bTF.field_songName});
                int i = iArr[0];
                int i2 = iArr[1];
                aVar2.lAG.setBackgroundColor(i);
                aVar2.lAN.setLyricColor(i2);
                aVar2.lAK.setBackgroundColor(i);
                ShaderFactory b_a_1 = new b$a$1(aVar2, i);
                Drawable paintDrawable = new PaintDrawable();
                paintDrawable.setShape(new RectShape());
                paintDrawable.setShaderFactory(b_a_1);
                aVar2.lAI.setBackgroundDrawable(paintDrawable);
                2 2 = new 2(aVar2, (i & 16777215) | 1426063360);
                Drawable paintDrawable2 = new PaintDrawable();
                paintDrawable2.setShape(new RectShape());
                paintDrawable2.setShaderFactory(2);
                aVar2.lAJ.setBackgroundDrawable(paintDrawable2);
                aVar2.lAL.setTextColor(i2);
                aVar2.lAM.setTextColor(i2);
                ((MusicMainUI) this.context).q(aVar);
            }
        }
    }
}
