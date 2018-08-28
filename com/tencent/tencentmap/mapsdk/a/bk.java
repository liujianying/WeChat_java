package com.tencent.tencentmap.mapsdk.a;

import com.qq.navi.Session;

public class bk extends bj {
    bb b;
    am c;
    Session d;

    public bk(bb bbVar, am amVar, Session session) {
        super(amVar.e().f() + " not send at " + bbVar + " session_id:" + (session == null ? "null" : Integer.valueOf(session.getID())));
        this.b = bbVar;
        this.c = amVar;
        this.d = session;
    }
}
