package com.tencent.mm.c;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;

class c$a {
    Properties bxw;
    byte[] bxx;

    private c$a() {
        this.bxw = new Properties();
    }

    /* synthetic */ c$a(byte b) {
        this();
    }

    final void A(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            c.us().getBytes();
            byte[] bArr2 = new byte[4];
            wrap.get(bArr2);
            System.out.println("securityPart: " + new k(bArr2).value);
            int i;
            if (c.us().equals(new k(bArr2))) {
                if (bArr.length - 4 <= 2) {
                    System.err.println("data.length - securityMarkLength <= 2");
                    return;
                }
                bArr2 = new byte[2];
                wrap.get(bArr2);
                i = new l(bArr2).value;
                if ((bArr.length - 4) - 2 < i) {
                    System.err.println("data.length - securityMarkLength - 2 < len");
                    System.err.println("exit");
                    return;
                }
                byte[] bArr3 = new byte[i];
                wrap.get(bArr3);
                this.bxw.load(new ByteArrayInputStream(bArr3));
                i = ((bArr.length - 4) - i) - 2;
                if (i > 0) {
                    c.ut().getBytes();
                    bArr3 = new byte[4];
                    wrap.get(bArr3);
                    if (!c.ut().equals(new k(bArr3))) {
                        return;
                    }
                    if (i - 4 <= 2) {
                        System.err.println("data.length - oriMarkLength <= 2");
                        return;
                    }
                    bArr3 = new byte[2];
                    wrap.get(bArr3);
                    int i2 = new l(bArr3).value;
                    if ((i - 4) - 2 < i2) {
                        System.err.println("data.length - oriMarkLength - 2 < len");
                        System.err.println("exit");
                        return;
                    }
                    this.bxx = new byte[i2];
                    wrap.get(this.bxx);
                }
            } else if (c.ut().equals(new k(bArr2))) {
                c.ut().getBytes();
                if (bArr.length - 4 <= 2) {
                    System.err.println("data.length - oriMarkLength <= 2");
                    return;
                }
                bArr2 = new byte[2];
                wrap.get(bArr2);
                i = new l(bArr2).value;
                if ((bArr.length - 4) - 2 < i) {
                    System.err.println("data.length - oriMarkLength - 2 < len");
                    System.err.println("exit");
                    return;
                }
                this.bxx = new byte[i];
                wrap.get(this.bxx);
            } else {
                throw new ProtocolException("unknow protocl [" + Arrays.toString(bArr) + "]");
            }
        }
    }

    final byte[] uu() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (this.bxw.size() > 0) {
            String str;
            byteArrayOutputStream.write(c.us().getBytes());
            String str2 = "";
            Iterator it = this.bxw.keySet().iterator();
            while (true) {
                str = str2;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                str2 = new StringBuilder(String.valueOf(str)).append(next).append("=").append(this.bxw.getProperty((String) next)).append("\r\n").toString();
            }
            byte[] bytes = str.getBytes();
            byteArrayOutputStream.write(new l(bytes.length).getBytes());
            byteArrayOutputStream.write(bytes);
        }
        if (this.bxx != null && this.bxx.length > 0) {
            byteArrayOutputStream.write(c.ut().getBytes());
            byteArrayOutputStream.write(new l(this.bxx.length).getBytes());
            byteArrayOutputStream.write(this.bxx);
        }
        return byteArrayOutputStream.toByteArray();
    }
}
