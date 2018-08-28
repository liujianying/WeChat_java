package com.tencent.mm.pluginsdk.ui.chat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.n.a.f;
import com.tencent.mm.plugin.n.a.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;

class m$b extends BaseAdapter {
    ArrayList<EmojiInfo> mData;
    final /* synthetic */ m qNl;

    m$b(m mVar) {
        this.qNl = mVar;
    }

    public final int getCount() {
        return this.mData == null ? 0 : this.mData.size();
    }

    /* renamed from: oO */
    public final EmojiInfo getItem(int i) {
        if (this.mData == null || this.mData.size() <= i) {
            return null;
        }
        return (EmojiInfo) this.mData.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        m$c m_c;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.qNl.mContext).inflate(f.chatting_footer_suggest_emoticon_bubble_item, null);
            m$c m_c2 = new m$c(this.qNl, view);
            view.setTag(m_c2);
            m_c = m_c2;
        } else {
            m_c = (m$c) view.getTag();
        }
        EmojiInfo oO = getItem(i);
        m_c.ika.setSize(this.qNl.qMY);
        m_c.ika.setScaleType(ScaleType.CENTER_INSIDE);
        CharSequence charSequence = "";
        if (oO != null) {
            charSequence = ((PluginEmoji) g.n(PluginEmoji.class)).getEmojiMgr().zf(oO.Xh());
        }
        if (bi.oW(charSequence)) {
            m_c.ika.setContentDescription(this.qNl.mContext.getString(h.emoji_store_title));
        } else {
            m_c.ika.setContentDescription(charSequence);
        }
        if (oO == null) {
            x.w("MicroMsg.emoji.SuggestEmoticonBubble", "emoji info is null.");
        } else if (oO.cny()) {
            m_c.ika.a(EmojiInfo.bt(this.qNl.mContext, oO.getName()), oO.getName());
        } else {
            m_c.ika.a(oO, "");
        }
        return view;
    }
}
