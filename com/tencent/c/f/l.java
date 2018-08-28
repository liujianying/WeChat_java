package com.tencent.c.f;

import com.qq.taf.RequestPacket;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceUtil;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Set;

public final class l {
    static HashMap<String, byte[]> vkR = null;
    protected String vkN;
    protected RequestPacket vkO;
    protected HashMap<String, byte[]> vkP;
    private HashMap<String, Object> vkQ;

    public l() {
        this.vkN = "UTF-8";
        this.vkO = new RequestPacket();
        this.vkP = new HashMap();
        this.vkQ = new HashMap();
        this.vkO.iVersion = (short) 3;
    }

    public final void acv(String str) {
        this.vkN = str;
    }

    public final void acw(String str) {
        this.vkO.sServantName = str;
    }

    public final void acx(String str) {
        this.vkO.sFuncName = str;
    }

    public final void cFy() {
        this.vkO.iRequestId = 3;
    }

    public final <T> void put(String str, T t) {
        if (str.startsWith(".") || t == null || (t instanceof Set)) {
            throw new IllegalArgumentException("wup put err");
        }
        JceOutputStream jceOutputStream = new JceOutputStream();
        jceOutputStream.setServerEncoding(this.vkN);
        jceOutputStream.write(t, 0);
        this.vkP.put(str, JceUtil.getJceBufArray(jceOutputStream.getByteBuffer()));
    }

    public final byte[] uu() {
        if (this.vkO.sServantName == null) {
            this.vkO.sServantName = "";
        }
        if (this.vkO.sFuncName == null) {
            this.vkO.sFuncName = "";
        }
        JceOutputStream jceOutputStream = new JceOutputStream(0);
        jceOutputStream.setServerEncoding(this.vkN);
        jceOutputStream.write(this.vkP, 0);
        this.vkO.sBuffer = JceUtil.getJceBufArray(jceOutputStream.getByteBuffer());
        jceOutputStream = new JceOutputStream(0);
        jceOutputStream.setServerEncoding(this.vkN);
        this.vkO.writeTo(jceOutputStream);
        byte[] jceBufArray = JceUtil.getJceBufArray(jceOutputStream.getByteBuffer());
        int length = jceBufArray.length;
        ByteBuffer allocate = ByteBuffer.allocate(length + 4);
        allocate.putInt(length + 4).put(jceBufArray).flip();
        return allocate.array();
    }
}
