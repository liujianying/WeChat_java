package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.card.base.c;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.ui.view.aa;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class k extends c {
    private final String TAG = "MicroMsg.CardTicketAdapter";
    private int count = 0;
    private int hBp;
    private final String hGC = "PRIVATE_TICKET_TITLE";
    private final String hGD = "PRIVATE_INVOICE_TITLE";
    private ArrayList<CardInfo> hGE;
    private ArrayList<CardInfo> hGF;
    private ArrayList<CardInfo> hGG;
    private c hzI;

    public k(Context context, int i) {
        super(context, i);
        this.hBp = i;
        this.hzI = new aa(context, this);
        this.hGE = new ArrayList();
        this.hGF = new ArrayList();
        this.hGG = new ArrayList();
    }

    private void ayZ() {
        CardInfo cardInfo;
        int i = 0;
        this.hGE.clear();
        this.hGF.clear();
        this.hGG.clear();
        while (true) {
            int i2 = i;
            if (i2 >= this.count) {
                break;
            }
            cardInfo = (CardInfo) super.getItem(i2);
            if (cardInfo != null) {
                if (cardInfo.avX()) {
                    this.hGG.add(cardInfo);
                } else {
                    this.hGF.add(cardInfo);
                }
            }
            i = i2 + 1;
        }
        if (!this.hGF.isEmpty()) {
            cardInfo = new CardInfo();
            cardInfo.field_card_id = "PRIVATE_TICKET_TITLE";
            this.hGE.add(cardInfo);
            this.hGE.addAll(this.hGF);
        }
        if (!this.hGG.isEmpty()) {
            cardInfo = new CardInfo();
            cardInfo.field_card_id = "PRIVATE_INVOICE_TITLE";
            this.hGE.add(cardInfo);
            this.hGE.addAll(this.hGG);
        }
        this.count = this.hGE.size();
    }

    public final void WT() {
        x.v("MicroMsg.CardTicketAdapter", "resetCursor");
        Cursor nH = am.axi().nH(this.hBp);
        if (nH != null) {
            this.count = nH.getCount();
            x.v("MicroMsg.CardTicketAdapter", "card count:" + this.count);
        }
        setCursor(nH);
        ayZ();
        notifyDataSetChanged();
    }

    protected final void WS() {
        aYc();
        WT();
    }

    private CardInfo nQ(int i) {
        return (CardInfo) this.hGE.get(i);
    }

    public final int getItemViewType(int i) {
        CardInfo nQ = nQ(i);
        if (nQ.field_card_id.equals("PRIVATE_TICKET_TITLE") || nQ.field_card_id.equals("PRIVATE_INVOICE_TITLE")) {
            return 0;
        }
        if (nQ.avX()) {
            return 2;
        }
        return 1;
    }

    public final int getCount() {
        if (this.hGE.isEmpty()) {
            return super.getCount();
        }
        return this.hGE.size();
    }

    public final int getViewTypeCount() {
        return 3;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        return this.hzI.a(i, view, nQ(i));
    }

    public final void release() {
        aYc();
        this.hzI.release();
        this.hzI = null;
    }
}
