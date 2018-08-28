package com.tencent.mm.q;

import com.tencent.mm.plugin.account.friend.a.a;

class b$a {
    String bTi;
    String bgn;
    String dia;
    String dib;
    String dic;
    String did;
    String die;
    long id;
    int status;
    int type;
    String userName;

    b$a() {
    }

    b$a(a aVar) {
        this.id = (long) a.pn(aVar.Xh());
        this.dia = aVar.Xj();
        this.dib = aVar.Xl();
        this.dic = aVar.Xk();
        this.bgn = aVar.Xm();
        this.did = aVar.Xo();
        this.die = aVar.Xn();
        this.userName = aVar.getUsername();
        this.bTi = aVar.Xp();
        this.type = aVar.type;
        this.status = aVar.status;
    }
}
