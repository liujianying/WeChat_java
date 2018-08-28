package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.r;

public class c extends r<CardInfo> {
    private final String TAG = "MicroMsg.CardAdapter";
    private int count = 0;
    private int hBp;
    private com.tencent.mm.plugin.card.base.c hzI;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        CardInfo cardInfo = (CardInfo) obj;
        if (cardInfo == null) {
            cardInfo = new CardInfo();
        }
        if (cursor.isClosed()) {
            x.e("MicroMsg.CardAdapter", "cursor is closed!");
        } else {
            cardInfo.d(cursor);
        }
        return cardInfo;
    }

    public c(Context context, int i) {
        super(context, new CardInfo());
        this.hBp = i;
        lB(true);
        this.hzI = new l(context, this);
    }

    public void WT() {
        x.v("MicroMsg.CardAdapter", "resetCursor");
        Cursor nH = am.axi().nH(this.hBp);
        if (nH != null) {
            this.count = nH.getCount();
            x.v("MicroMsg.CardAdapter", "card count:" + this.count);
        }
        setCursor(nH);
        notifyDataSetChanged();
    }

    protected void WS() {
        aYc();
        WT();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return this.hzI.a(i, view, (CardInfo) getItem(i));
    }

    public void release() {
        aYc();
        this.hzI.release();
        this.hzI = null;
    }
}
