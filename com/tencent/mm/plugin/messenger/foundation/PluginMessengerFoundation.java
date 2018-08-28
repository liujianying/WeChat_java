package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.e;
import com.tencent.mm.modelmulti.n;
import com.tencent.mm.plugin.chatroom.b;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.protocal.c.aue;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import junit.framework.Assert;

public class PluginMessengerFoundation extends f implements a, c, d, ai, o {
    private e dBE = new e();
    private d lcf;
    private e lcg;
    private bv lch = new bv();
    private b lci = new b();
    private ai lcj;
    private com.tencent.mm.plugin.messenger.foundation.a.b lck;

    public void installed() {
        alias(o.class);
    }

    public void dependency() {
        dependsOn(PluginZero.class);
    }

    public void configure(g gVar) {
        x.i("MicroMsg.TAG", "init thread pool[%s] current tid[%d] priority[%d] process[%s]", new Object[]{com.tencent.mm.sdk.f.e.cjw(), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(Thread.currentThread().getPriority()), ((h) com.tencent.mm.kernel.g.Ef().DM()).dox});
        com.tencent.mm.plugin.zero.c.qxT = new com.tencent.mm.by.c<com.tencent.mm.plugin.zero.a.f>() {
            public final /* synthetic */ Object get() {
                return new f();
            }
        };
        q aVar = new a();
        q.a.a(2, aVar);
        q.a.a(17, aVar);
        q.a.a(4, aVar);
        q.a.a(7, new b());
        c cVar = new c();
        q.a.a(5, cVar);
        q.a.a(8, cVar);
        q.a.a(9, cVar);
        q.a.a(1, new g());
        com.tencent.mm.kernel.g.Ee().a(p.class, new com.tencent.mm.kernel.c.e(new n()));
        com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.zero.a.d.class);
        if (gVar.ES()) {
            new com.tencent.mm.plugin.zero.tasks.b().before(this);
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.messenger.foundation.a.d.class, new com.tencent.mm.plugin.messenger.foundation.a.d() {
                public final void a(aue aue, String str) {
                    a.a(aue, str, null, true, false);
                }

                public final com.tencent.mm.vending.b.b a(com.tencent.mm.plugin.messenger.foundation.a.c cVar) {
                    return a.a(cVar);
                }
            });
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.messenger.foundation.a.h.class, new 9(this));
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.chatroom.b.b.class, this.lci);
        }
    }

    public void execute(g gVar) {
        if (gVar.ES()) {
            this.lcf = new d();
            com.tencent.mm.kernel.g.a(i.class, new com.tencent.mm.kernel.c.e(this.lcf));
            this.lcg = new e();
            com.tencent.mm.kernel.g.a(j.class, new com.tencent.mm.kernel.c.e(this.lcg));
        }
    }

    public String toString() {
        return "plugin-messenger-foundation";
    }

    public HashMap<Integer, com.tencent.mm.bt.h.d> collectDatabaseFactory() {
        HashMap<Integer, com.tencent.mm.bt.h.d> hashMap = new HashMap();
        hashMap.put(Integer.valueOf("MESSAGE_TABLE".hashCode()), new 10(this));
        hashMap.put(Integer.valueOf("CONTACT_TABLE".hashCode()), new com.tencent.mm.bt.h.d() {
            public final String[] xb() {
                return ah.diD;
            }
        });
        hashMap.put(Integer.valueOf("OPLOG_TABLE".hashCode()), new 12(this));
        hashMap.put(Integer.valueOf("CONVERSATION_TABLE".hashCode()), new 13(this));
        hashMap.put(Integer.valueOf("ROLEINFO_TABLE".hashCode()), new 14(this));
        hashMap.put(Integer.valueOf("STRANGER_TABLE".hashCode()), new 15(this));
        hashMap.put(Integer.valueOf("DeletedConversationInfo".hashCode()), new 2(this));
        hashMap.put(Integer.valueOf("LBSVERIFYMESSAGE_TABLE".hashCode()), new com.tencent.mm.bt.h.d() {
            public final String[] xb() {
                return bb.diD;
            }
        });
        hashMap.put(Integer.valueOf("SHAKEVERIFYMESSAGE_TABLE".hashCode()), new com.tencent.mm.bt.h.d() {
            public final String[] xb() {
                return bp.diD;
            }
        });
        hashMap.put(Integer.valueOf("VERIFY_CONTACT_TABLE".hashCode()), new 5(this));
        hashMap.put(Integer.valueOf("FMESSAGE_MSGINFO_TABLE".hashCode()), new com.tencent.mm.bt.h.d() {
            public final String[] xb() {
                return au.diD;
            }
        });
        hashMap.put(Integer.valueOf("FMESSAGE_CONVERSATION_TABLE".hashCode()), new 7(this));
        return hashMap;
    }

    public void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        com.tencent.mm.ab.d.c.a(Integer.valueOf(10000), this.dBE);
        com.tencent.mm.ab.d.c.a(Integer.valueOf(1), this.dBE);
        com.tencent.mm.ab.d.c.a(Integer.valueOf(10001), this.lch);
        com.tencent.mm.ab.d.c.a(Integer.valueOf(10002), this.lch);
    }

    public void onAccountRelease() {
        com.tencent.mm.ab.d.c.b(Integer.valueOf(10000), this.dBE);
        com.tencent.mm.ab.d.c.b(Integer.valueOf(1), this.dBE);
        com.tencent.mm.ab.d.c.b(Integer.valueOf(10001), this.lch);
        com.tencent.mm.ab.d.c.b(Integer.valueOf(10002), this.lch);
    }

    public void onDataBaseOpened(com.tencent.mm.bt.h hVar, com.tencent.mm.bt.h hVar2) {
        com.tencent.mm.model.p.GD();
        d dVar = this.lcf;
        com.tencent.mm.bt.h hVar3 = com.tencent.mm.kernel.g.Ei().dqq;
        com.tencent.mm.bt.h hVar4 = com.tencent.mm.kernel.g.Ei().dqr;
        dVar.lbX = new com.tencent.mm.aq.p(new com.tencent.mm.aq.i(hVar3));
        dVar.lbT = new ah(hVar3);
        dVar.lbU = new br(hVar3);
        dVar.lbW = new aj(hVar3);
        dVar.lbV = new be(hVar3, dVar.lbT, dVar.lbW);
        dVar.lbY = new bm(hVar3);
        dVar.lbZ = new am(hVar3);
        dVar.lca = new au(hVar3);
        dVar.lcb = new as(hVar3);
        dVar.lcc = new bb(hVar3);
        dVar.lcd = new bp(hVar3);
        dVar.lce = new bw(hVar3);
    }

    public void onDataBaseClosed(com.tencent.mm.bt.h hVar, com.tencent.mm.bt.h hVar2) {
    }

    public bv getSysCmdMsgExtension() {
        return this.lch;
    }

    public void setIDataTransferFactoryDelegate(ai aiVar) {
        this.lcj = aiVar;
    }

    public List<com.tencent.mm.model.ah> getDataTransferList() {
        if (this.lcj == null) {
            return new ArrayList();
        }
        List<com.tencent.mm.model.ah> dataTransferList = this.lcj.getDataTransferList();
        if (dataTransferList.size() <= 7) {
            return dataTransferList;
        }
        Assert.assertTrue("Do not add more IDataTransfer from mIDataTransferFactoryDelegate!!!!!!!!!!!", false);
        return dataTransferList;
    }

    public void setBizTimeLineCallback(com.tencent.mm.plugin.messenger.foundation.a.b bVar) {
        this.lck = bVar;
    }

    public com.tencent.mm.plugin.messenger.foundation.a.b getBizTimeLineCallback() {
        return this.lck;
    }
}
