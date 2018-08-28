package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.a.e;
import com.tencent.mm.g.a.cp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.n.a.b;
import com.tencent.mm.plugin.n.a.c;
import com.tencent.mm.plugin.n.a.d;
import com.tencent.mm.plugin.n.a.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.lang.ref.WeakReference;

public class RTChattingEmojiView extends FrameLayout {
    private EmojiInfo ild;
    private int mStatus = -1;
    private TextView oFV;
    private int qOe;
    private int qOf;
    private int qOg;
    private int qOh;
    private int qOi;
    public ChattingEmojiView qOj;
    private ProgressBar qOk;
    private LayoutParams qOl;
    LayoutParams qOm;

    public RTChattingEmojiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RTChattingEmojiView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void initView() {
        this.qOe = getContext().getResources().getDimensionPixelSize(c.emoji_view_image_size);
        this.qOf = getContext().getResources().getDimensionPixelSize(c.emoji_view_chatting_min_size);
        this.qOh = getContext().getResources().getDimensionPixelSize(c.emoji_view_refresh_size);
        this.qOi = getContext().getResources().getDimensionPixelSize(c.emoji_view_refresh_min_size);
        this.qOj = new ChattingEmojiView(getContext());
        this.qOk = new ProgressBar(getContext());
        this.qOk.setIndeterminateDrawable(getResources().getDrawable(d.progress_small_holo));
        this.oFV = new TextView(getContext());
        this.oFV.setText(h.emoji_retry_download);
        this.oFV.setTextColor(getResources().getColor(b.emoji_load_text_color));
        this.qOl = new LayoutParams(-2, -2);
        this.qOm = new LayoutParams(-2, -2);
        this.qOl.gravity = 17;
        addView(this.qOk, this.qOl);
        addView(this.oFV, this.qOl);
    }

    public final void a(EmojiInfo emojiInfo, long j) {
        a(emojiInfo, j, new an(""));
    }

    public final void a(EmojiInfo emojiInfo, long j, an anVar) {
        x.d("MicroMsg.emoji.RTChattingEmojiView", "setEmojiInfo");
        this.ild = emojiInfo;
        if (this.ild.aaq()) {
            Cr(2);
            bd dW = ((i) g.l(i.class)).bcY().dW(j);
            boolean z = dW.field_status == 2 || dW.field_status == 3 || dW.field_status == 5;
            ChattingEmojiView chattingEmojiView = this.qOj;
            boolean z2 = !anVar.enG;
            int e = ((PluginEmoji) g.n(PluginEmoji.class)).getEmojiMgr().e(emojiInfo);
            int[] f = ((PluginEmoji) g.n(PluginEmoji.class)).getEmojiMgr().f(emojiInfo);
            String name = emojiInfo.getName();
            String valueOf = String.valueOf(j + emojiInfo.getName());
            com.tencent.mm.plugin.gif.d dVar;
            if (bi.oW(valueOf)) {
                dVar = new com.tencent.mm.plugin.gif.d(chattingEmojiView.getContext(), z2, z, e, f, name);
                dVar.start();
                chattingEmojiView.setImageDrawable(dVar);
                return;
            }
            chattingEmojiView.setCacheKey(valueOf);
            com.tencent.mm.plugin.gif.b aVQ = com.tencent.mm.plugin.gif.b.aVQ();
            Context context = chattingEmojiView.getContext();
            if (TextUtils.isEmpty(name)) {
                dVar = null;
            } else {
                if (aVQ.khx.get(valueOf) == null || ((WeakReference) aVQ.khx.get(valueOf)).get() == null) {
                    dVar = null;
                } else {
                    dVar = (com.tencent.mm.plugin.gif.d) ((WeakReference) aVQ.khx.get(valueOf)).get();
                }
                if (dVar == null) {
                    dVar = new com.tencent.mm.plugin.gif.d(context, z2, z, e, f, name);
                    aVQ.khx.put(valueOf, new WeakReference(dVar));
                }
            }
            if (dVar != null) {
                dVar.kil = z;
                if (z2 == dVar.mIsPlaying) {
                    dVar.start();
                } else {
                    dVar.irJ = 0;
                    dVar.kin = 0;
                    dVar.mIsPlaying = true;
                    dVar.start();
                }
                chattingEmojiView.setImageDrawable(dVar);
                return;
            }
            x.e("MicroMsg.GIF.MMGIFImageView", "can not get drawable.");
        } else if (this.ild.cny()) {
            Cr(2);
            this.qOj.a(EmojiInfo.bt(getContext(), emojiInfo.getName()), String.valueOf(j));
        } else {
            String cnF = this.ild.cnF();
            if (e.cm(cnF) > 0) {
                Cr(2);
                byte[] e2 = e.e(cnF, 0, 10);
                if (e2 == null || o.bw(e2)) {
                    this.qOj.dk(cnF, String.valueOf(j));
                    return;
                } else {
                    this.qOj.a(this.ild, ((PluginEmoji) g.n(PluginEmoji.class)).getEmojiMgr().a(this.ild), String.valueOf(j));
                    return;
                }
            }
            x.d("MicroMsg.emoji.RTChattingEmojiView", "try download emoji %s, state %d", new Object[]{emojiInfo.Xh(), Integer.valueOf(emojiInfo.field_state)});
            if (emojiInfo.field_state == EmojiInfo.tcR) {
                Cr(0);
                ceZ();
            } else {
                Cr(3);
            }
            this.qOj.setImageBitmap(null);
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        Cr(2);
        if (this.qOj != null && bitmap != null && !bitmap.isRecycled()) {
            bitmap.setDensity(this.qOj.getEmojiDensity());
            this.qOj.setImageBitmap(bitmap);
        }
    }

    public boolean performClick() {
        if (this.mStatus == 3) {
            Cr(1);
            ceZ();
            return true;
        } else if (this.mStatus == 2) {
            return super.performClick();
        } else {
            x.d("MicroMsg.emoji.RTChattingEmojiView", "do nothing when loading");
            return true;
        }
    }

    private void ceZ() {
        cp cpVar = new cp();
        cpVar.bKa.bKb = this.ild;
        cpVar.bKa.scene = 0;
        a.sFg.m(cpVar);
    }

    private void Cr(int i) {
        this.mStatus = i;
        switch (i) {
            case 0:
                this.qOk.setVisibility(0);
                this.oFV.setVisibility(4);
                this.qOj.setVisibility(4);
                setBackgroundResource(d.transparent_background);
                return;
            case 1:
                this.qOk.setVisibility(0);
                this.oFV.setVisibility(4);
                this.qOj.setVisibility(4);
                setBackgroundResource(d.chatting_item_emoji_bg);
                return;
            case 2:
                this.qOj.setVisibility(0);
                this.qOk.setVisibility(4);
                this.oFV.setVisibility(4);
                setBackgroundResource(d.transparent_background);
                return;
            case 3:
                Drawable drawable = getResources().getDrawable(d.emoji_download_icon_samll);
                drawable.setBounds(0, 0, this.qOg, this.qOg);
                x.d("MicroMsg.emoji.RTChattingEmojiView", "iconSize:%d hashcode:%d", new Object[]{Integer.valueOf(this.qOg), Integer.valueOf(hashCode())});
                this.oFV.setCompoundDrawables(null, drawable, null, null);
                this.oFV.setText(h.emoji_retry_download);
                this.oFV.setVisibility(0);
                this.qOk.setVisibility(4);
                this.qOj.setVisibility(4);
                setBackgroundResource(d.chatting_item_emoji_bg);
                return;
            default:
                return;
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.mStatus == 0 || this.mStatus == 1 || this.mStatus == 3) {
            int i3;
            if (this.ild == null || this.ild.field_height == 0) {
                i3 = this.qOf;
            } else {
                i3 = (int) (((float) this.ild.field_height) * this.qOj.getEmojiDensityScale());
                if (i3 < this.qOf) {
                    i3 = this.qOf;
                }
            }
            if (i3 > this.qOe) {
                i3 = this.qOe;
            }
            this.qOg = this.qOh;
            if (i3 >= this.qOf && i3 < this.qOf + (this.qOh - this.qOi)) {
                this.qOg = this.qOi + (i3 - this.qOf);
            }
            int i4 = this.qOe;
            setMeasuredDimension(i4, i3);
            super.onMeasure(MeasureSpec.makeMeasureSpec(i4, 1073741824), MeasureSpec.makeMeasureSpec(i3, 1073741824));
            Cr(this.mStatus);
            return;
        }
        super.onMeasure(i, i2);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
