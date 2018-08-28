package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.bp.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.n.a$c;
import com.tencent.mm.plugin.n.a.e;
import com.tencent.mm.plugin.n.a.f;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.HorizontalListView;
import com.tencent.mm.ui.base.HorizontalListView$a;
import com.tencent.mm.ui.base.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public final class m {
    private View FU;
    private OnItemClickListener UD = new 3(this);
    private int gNG = 3;
    ArrayList<EmojiInfo> inB = new ArrayList();
    Context mContext;
    ag mHandler = new 1(this);
    a qLL;
    int qMY;
    int qMZ;
    o qNa;
    View qNb;
    j qNc;
    String qNd;
    public String qNe = "";
    public boolean qNf = true;
    private HorizontalListView qNg;
    b qNh;
    private boolean qNi = true;
    private Comparator qNj = new 2(this);
    private HorizontalListView$a qNk = new 4(this);

    public m(Context context) {
        this.mContext = context;
        this.FU = View.inflate(this.mContext, f.chatting_footer_suggest_emoticon_bubble, null);
        this.qNg = (HorizontalListView) this.FU.findViewById(e.suggest_list_view);
        this.qNh = new b(this);
        this.qNg.setAdapter(this.qNh);
        this.qNg.setOnItemClickListener(this.UD);
        this.qNg.setOnItemSelectedListener(new 5(this));
        this.qNg.setDispatchTouchListener(this.qNk);
        this.qMY = a.ad(this.mContext, a$c.emoji_suggest_image_size);
        this.qMZ = a.ad(this.mContext, a$c.MiddlePadding);
        this.qNa = new o(this.FU, this.qMY + (this.qMZ * 2), this.qMY + (this.qMZ * 2), true);
        this.qNa.setBackgroundDrawable(new ColorDrawable(0));
        this.qNa.setOutsideTouchable(true);
        this.qNa.setFocusable(false);
    }

    public final void ceT() {
        if (this.qNb != null) {
            int[] iArr = new int[2];
            this.qNb.getLocationOnScreen(iArr);
            this.qNa.showAtLocation(this.qNb, 0, iArr[0] - ((this.qNa.getWidth() - this.qNb.getWidth()) / 2), iArr[1] - this.qNa.getHeight());
        }
    }

    public final void hide() {
        if (this.qNa != null && this.qNa.isShowing()) {
            this.qNa.dismiss();
        }
    }

    public final boolean cE(String str) {
        try {
            if (!bi.oW(str)) {
                ArrayList zm = ((PluginEmoji) g.n(PluginEmoji.class)).getEmojiMgr().zm(str);
                if (!(zm == null || zm.isEmpty())) {
                    this.qNd = str.replaceAll(",", "");
                    if (zm == null || zm.isEmpty()) {
                        return false;
                    }
                    EmojiInfo zi;
                    ArrayList arrayList = new ArrayList();
                    this.inB.clear();
                    int size = zm.size();
                    int i = 0;
                    while (i < size && i < 100) {
                        zi = ((PluginEmoji) g.n(PluginEmoji.class)).getEmojiMgr().zi((String) zm.get(i));
                        if (zi != null) {
                            arrayList.add(zi);
                        }
                        i++;
                    }
                    if (arrayList.isEmpty()) {
                        x.i("MicroMsg.emoji.SuggestEmoticonBubble", "sorEmojiList return. empty list.");
                        return false;
                    }
                    if (this.qNi) {
                        zi = (EmojiInfo) Collections.max(arrayList, this.qNj);
                        this.inB.add(zi);
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            EmojiInfo emojiInfo = (EmojiInfo) it.next();
                            if (!(emojiInfo.cl(zi) || this.inB.contains(emojiInfo))) {
                                this.inB.add(emojiInfo);
                            }
                        }
                    } else {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            zi = (EmojiInfo) it2.next();
                            if (!this.inB.contains(zi)) {
                                this.inB.add(zi);
                            }
                        }
                    }
                    return (this.inB == null || this.inB.isEmpty()) ? false : true;
                }
            }
        } catch (Throwable e) {
            x.e("MicroMsg.emoji.SuggestEmoticonBubble", bi.i(e));
        }
        this.qNd = "";
        return false;
    }
}
