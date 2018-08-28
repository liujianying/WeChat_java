package com.tencent.mm.plugin.traceroute.b;

import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;

class a$f extends ConcurrentHashMap<String, ConcurrentHashMap<Integer, StringBuilder>> {
    final /* synthetic */ a oDo;

    /* renamed from: com.tencent.mm.plugin.traceroute.b.a$f$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ int oDp;
        final /* synthetic */ String oDq;
        final /* synthetic */ PByteArray oDr;

        AnonymousClass1(int i, String str, PByteArray pByteArray) {
            this.oDp = i;
            this.oDq = str;
            this.oDr = pByteArray;
        }

        public final void run() {
            String str = "http://" + ad.getContext().getSharedPreferences("system_config_prefs", 0).getString("support.weixin.qq.com", "support.weixin.qq.com");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str + "/cgi-bin/mmsupport-bin/stackreport?version=");
            stringBuffer.append(Integer.toHexString(d.qVN));
            stringBuffer.append("&devicetype=");
            stringBuffer.append(d.DEVICE_TYPE);
            stringBuffer.append("&filelength=");
            stringBuffer.append(this.oDp);
            stringBuffer.append("&sum=");
            stringBuffer.append(this.oDq);
            stringBuffer.append("&reporttype=");
            stringBuffer.append(4);
            if (!(a$f.this.oDo.userName == null || a$f.this.oDo.userName.equals(""))) {
                stringBuffer.append("&username=");
                stringBuffer.append(a$f.this.oDo.userName);
            }
            x.d("MicroMsg.MMTraceRoute", "traceroute report url:" + stringBuffer.toString());
            a$f.a(a$f.this, stringBuffer.toString(), this.oDr.value);
        }
    }

    private a$f(a aVar) {
        this.oDo = aVar;
    }

    /* synthetic */ a$f(a aVar, byte b) {
        this(aVar);
    }

    static /* synthetic */ void a(a$f a_f, String str, byte[] bArr) {
        int i = 3;
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
                HttpUriRequest httpPost = new HttpPost(str);
                try {
                    HttpEntity byteArrayEntity = new ByteArrayEntity(bArr);
                    byteArrayEntity.setContentType("binary/octet-stream");
                    httpPost.setEntity(byteArrayEntity);
                    x.i("MicroMsg.MMTraceRoute", "http pose returnContent : " + bi.convertStreamToString(defaultHttpClient.execute(httpPost).getEntity().getContent()));
                    a aVar = a_f.oDo;
                    if (aVar.oDl != null) {
                        aVar.oDl.bIO();
                        return;
                    }
                    return;
                } catch (Throwable e) {
                    x.e("MicroMsg.MMTraceRoute", "http post IllegalStateException: " + e.getMessage());
                    x.printErrStackTrace("MicroMsg.MMTraceRoute", e, "", new Object[0]);
                    i = i2;
                } catch (Throwable e2) {
                    x.e("MicroMsg.MMTraceRoute", "http post IOException: " + e2.getMessage());
                    x.printErrStackTrace("MicroMsg.MMTraceRoute", e2, "", new Object[0]);
                    i = i2;
                }
            } else {
                a.a(a_f.oDo);
                return;
            }
        }
    }
}
