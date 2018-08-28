package com.tencent.mm.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.Toast;
import com.tencent.mm.bg.d;
import com.tencent.mm.br.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.u;

public class SmileyGrid extends GridView {
    public static int uSB = 1;
    public ListAdapter Do;
    private int fdx = ChatFooterPanel.qFd;
    private int gKK;
    public int gKM;
    private OnItemClickListener hpE = new 1(this);
    private j qNc;
    private int uSC = 20;
    public int uSD = 0;
    private int uSE = 0;
    private a uSF;
    private boolean uSG;
    public OnItemClickListener uSH = new OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Object item = adapterView.getAdapter().getItem(i);
            if (item instanceof u) {
                int i2 = ((u) item).position;
                ((c) g.n(c.class)).getProvider().bg(e.cjH().mi(i2), i2);
                if (SmileyGrid.this.uSF != null) {
                    String mh;
                    if (SmileyGrid.this.uSG) {
                        mh = e.cjH().mh(i2);
                    } else {
                        mh = e.cjH().getText(i2);
                    }
                    SmileyGrid.this.uSF.append(mh);
                    h.mEJ.h(13470, new Object[]{mh.replaceAll(",", " "), Integer.valueOf(SmileyGrid.this.fdx), Integer.valueOf(1)});
                }
            }
        }
    };

    static /* synthetic */ void a(SmileyGrid smileyGrid, EmojiInfo emojiInfo) {
        if (smileyGrid.qNc == null || emojiInfo == null) {
            x.e("MicroMsg.emoji.SmileyGrid", "jacks npe dealCustomEmojiClick");
        } else if (uSB != 2) {
            if (!smileyGrid.qNc.bcP()) {
                com.tencent.mm.ui.base.h.a(smileyGrid.getContext(), com.tencent.mm.plugin.n.a.h.chatting_msg_type_not_support_send, 0, new 3(smileyGrid));
            } else if (emojiInfo == null) {
            } else {
                if (emojiInfo.field_type != EmojiInfo.tcL && emojiInfo.field_type != EmojiInfo.tcM) {
                    x.i("MicroMsg.emoji.SmileyGrid", "cpan send dealcustom emoji click emoji:%s", new Object[]{emojiInfo.Xh()});
                    EmojiInfo c = ((c) g.n(c.class)).getProvider().c(emojiInfo);
                    if (c != null) {
                        smileyGrid.qNc.l(c);
                        x.d("MicroMsg.emoji.SmileyGrid", "onSendCustomEmoji emoji md5 is [%s]", new Object[]{c.Xh()});
                        return;
                    }
                    x.w("MicroMsg.emoji.SmileyGrid", "onSendCustomEmoji error, emoji is null");
                } else if (smileyGrid.qNc.bcO()) {
                    smileyGrid.qNc.m(emojiInfo);
                    x.d("MicroMsg.emoji.SmileyGrid", "onSendAppMsgCustomEmoji emoji md5 is [%s]", new Object[]{emojiInfo.Xh()});
                } else {
                    Toast.makeText(smileyGrid.getContext(), smileyGrid.getContext().getString(com.tencent.mm.plugin.n.a.h.chatting_msg_type_not_support), 0).show();
                }
            }
        } else if (emojiInfo.field_catalog == EmojiGroupInfo.tcz) {
            com.tencent.mm.ui.base.h.i(smileyGrid.getContext(), com.tencent.mm.plugin.n.a.h.chatting_can_not_del_sys_smiley, com.tencent.mm.plugin.n.a.h.chatting_can_not_del_sys_smiley).show();
        }
    }

    static /* synthetic */ void c(SmileyGrid smileyGrid) {
        h.mEJ.h(11594, new Object[]{Integer.valueOf(1)});
        String value = com.tencent.mm.k.g.AT().getValue("ShowDesignerEmoji");
        x.i("MicroMsg.emoji.SmileyGrid", "get dynamic Designer_Emoji_Store_Show config value:%s", new Object[]{value});
        d.b(smileyGrid.getContext(), "emoji", ".ui.EmojiCustomUI", new Intent());
    }

    public void setCallback(j jVar) {
        this.qNc = jVar;
    }

    public SmileyGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    @TargetApi(8)
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public final void cCb() {
        setOnItemClickListener(this.hpE);
    }

    public final void i(int i, int i2, int i3, int i4, int i5) {
        x.v("MicroMsg.emoji.SmileyGrid", "type:" + i + " itemsPerPage:" + i4 + " totalPage:" + i5 + " curPage:" + this.gKM);
        setOnItemClickListener(this.hpE);
        this.uSC = i;
        this.gKM = i2;
        this.gKK = i3;
        this.uSD = i4;
        this.uSE = i5;
    }

    public void release() {
        this.uSF = null;
        this.qNc = null;
    }

    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        this.Do = listAdapter;
    }

    public void setOnTextOperationListener(a aVar) {
        this.uSF = aVar;
    }

    public int getSmileyType() {
        return this.uSC;
    }

    public void setScene(int i) {
        this.fdx = i;
    }
}
