package com.tencent.mm.ipcinvoker.d;

import junit.framework.Assert;

public class d {
    public String bHA;
    public com.tencent.mm.ipcinvoker.d dmX;
    private String process;

    public <T extends b> d(String str, Class<T> cls) {
        Assert.assertNotNull(str);
        Assert.assertNotNull(cls);
        this.process = str;
        this.bHA = cls.getName();
        this.dmX = new com.tencent.mm.ipcinvoker.d(str);
    }
}
