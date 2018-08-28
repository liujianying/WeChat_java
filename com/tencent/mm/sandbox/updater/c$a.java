package com.tencent.mm.sandbox.updater;

import android.os.AsyncTask;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.sandbox.b.a;
import com.tencent.mm.sdk.platformtools.x;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

class c$a extends AsyncTask<String, Integer, Integer> {
    private int bmD;
    private HttpClient mcs = null;
    private OutputStream oJl = new 1(this);
    private a sDE;
    final /* synthetic */ c sDP;
    private HttpPost sDR = null;
    private HttpResponse sDS = null;
    private HttpEntity sDT = null;
    private int size;

    protected final /* synthetic */ void onPostExecute(Object obj) {
        this.sDE.a(((Integer) obj).intValue(), 0, null);
    }

    public c$a(c cVar, int i, int i2, a aVar) {
        this.sDP = cVar;
        this.size = i;
        this.bmD = i2;
        this.sDE = aVar;
    }

    private Integer E(String... strArr) {
        String str = strArr[0];
        if (str == null || str.length() == 0) {
            return Integer.valueOf(-1);
        }
        x.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "current download url=" + str + ", range=" + this.bmD);
        this.mcs = new DefaultHttpClient();
        this.mcs.getParams().setIntParameter("http.connection.timeout", 15000);
        this.sDR = new HttpPost(str);
        this.sDR.addHeader("RANGE", "bytes=" + this.bmD + "-" + (this.size - this.bmD > 1048576 ? Integer.valueOf((this.bmD + 1048576) - 1) : ""));
        this.sDE.fV(50);
        this.sDS = this.mcs.execute(this.sDR);
        int statusCode = this.sDS.getStatusLine().getStatusCode();
        Integer valueOf;
        if (statusCode == 200 || statusCode == 206) {
            try {
                if (c.g(this.sDP) && af.exb && Math.random() > 0.2d) {
                    x.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "simulateNetworkFault");
                    valueOf = Integer.valueOf(-1);
                    if (this.sDR != null) {
                        this.sDR.abort();
                    }
                    if (this.sDT != null) {
                        try {
                            this.sDT.consumeContent();
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e, "", new Object[0]);
                        }
                    }
                    if (this.mcs == null) {
                        return valueOf;
                    }
                    this.mcs.getConnectionManager().shutdown();
                    return valueOf;
                }
                this.sDS.getHeaders("Content-Length");
                if (this.bmD > this.size) {
                    x.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "range out of size");
                    valueOf = Integer.valueOf(-2);
                    if (this.sDR != null) {
                        this.sDR.abort();
                    }
                    if (this.sDT != null) {
                        try {
                            this.sDT.consumeContent();
                        } catch (Throwable e2) {
                            x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e2, "", new Object[0]);
                        }
                    }
                    if (this.mcs == null) {
                        return valueOf;
                    }
                    this.mcs.getConnectionManager().shutdown();
                    return valueOf;
                }
                this.sDT = this.sDS.getEntity();
                this.sDT.writeTo(this.oJl);
                this.sDT.consumeContent();
                valueOf = Integer.valueOf(0);
                if (this.sDR != null) {
                    this.sDR.abort();
                }
                if (this.sDT != null) {
                    try {
                        this.sDT.consumeContent();
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e22, "", new Object[0]);
                    }
                }
                if (this.mcs == null) {
                    return valueOf;
                }
                this.mcs.getConnectionManager().shutdown();
                return valueOf;
            } catch (Throwable e3) {
                x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e3, "", new Object[0]);
                x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e3, "exception current in download pack", new Object[0]);
                if (this.sDR != null) {
                    this.sDR.abort();
                }
                if (this.sDT != null) {
                    try {
                        this.sDT.consumeContent();
                    } catch (Throwable e32) {
                        x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e32, "", new Object[0]);
                    }
                }
                if (this.mcs != null) {
                    this.mcs.getConnectionManager().shutdown();
                }
                return Integer.valueOf(-1);
            } catch (Throwable th) {
                if (this.sDR != null) {
                    this.sDR.abort();
                }
                if (this.sDT != null) {
                    try {
                        this.sDT.consumeContent();
                    } catch (Throwable e222) {
                        x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e222, "", new Object[0]);
                    }
                }
                if (this.mcs != null) {
                    this.mcs.getConnectionManager().shutdown();
                }
            }
        } else {
            x.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "HttpClient return code:" + statusCode);
            if (statusCode == 416) {
                valueOf = Integer.valueOf(-2);
                if (this.sDR != null) {
                    this.sDR.abort();
                }
                if (this.sDT != null) {
                    try {
                        this.sDT.consumeContent();
                    } catch (Throwable e2222) {
                        x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e2222, "", new Object[0]);
                    }
                }
                if (this.mcs == null) {
                    return valueOf;
                }
                this.mcs.getConnectionManager().shutdown();
                return valueOf;
            }
            valueOf = Integer.valueOf(-1);
            if (this.sDR != null) {
                this.sDR.abort();
            }
            if (this.sDT != null) {
                try {
                    this.sDT.consumeContent();
                } catch (Throwable e22222) {
                    x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e22222, "", new Object[0]);
                }
            }
            if (this.mcs == null) {
                return valueOf;
            }
            this.mcs.getConnectionManager().shutdown();
            return valueOf;
        }
    }

    protected final void onCancelled() {
        x.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "AsyncTask had been canceled.");
        if (this.sDR != null) {
            this.sDR.abort();
        }
        if (this.sDT != null) {
            try {
                this.sDT.consumeContent();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e, "", new Object[0]);
            }
        }
        if (this.mcs != null) {
            x.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "connection shutdown.");
            this.mcs.getConnectionManager().shutdown();
        }
    }
}
