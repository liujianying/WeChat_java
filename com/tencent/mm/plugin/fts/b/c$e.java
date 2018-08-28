package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.storage.bd;
import java.util.ArrayList;
import java.util.List;

class c$e extends a {
    private List<bd> juC = new ArrayList();
    private StringBuffer juD;
    final /* synthetic */ c jux;

    public c$e(c cVar, List<bd> list) {
        this.jux = cVar;
        this.juC.addAll(list);
        this.juD = new StringBuffer();
    }

    public final boolean execute() {
        List<c$f> arrayList = new ArrayList();
        for (bd bdVar : this.juC) {
            c$f c_f = new c$f(this.jux, (byte) 0);
            c_f.bJC = bdVar.field_msgId;
            c_f.talker = bdVar.field_talker;
            c_f.createTime = bdVar.field_createTime;
            c_f.content = bdVar.field_content;
            c_f.msgType = bdVar.getType();
            c_f.juF = bdVar.field_isSend;
            if (c.a(c_f)) {
                c_f.aQp();
                if (c_f.isAvailable()) {
                    arrayList.add(c_f);
                }
            }
        }
        this.juD.append("{MsgId: ");
        for (c$f c_f2 : arrayList) {
            this.juD.append(c_f2.bJC);
            this.juD.append(",");
            this.juD.append(c_f2.talker);
            this.juD.append(",");
            this.juD.append(c_f2.createTime);
            this.juD.append(" ");
        }
        this.juD.append("count: ");
        this.juD.append(arrayList.size());
        this.juD.append("}");
        if (arrayList.size() > 0) {
            this.jux.jup.beginTransaction();
            for (c$f c_f3 : arrayList) {
                this.jux.jup.a(c_f3.juE, c_f3.bJC, c_f3.talker, c_f3.createTime, c_f3.juG, c_f3.juH);
            }
            this.jux.jup.commit();
        }
        return true;
    }

    public final String getName() {
        return "InsertMessageTask";
    }

    public final String afC() {
        return this.juD.toString();
    }
}
