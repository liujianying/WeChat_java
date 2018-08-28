package com.tencent.mm.at;

import com.tencent.mm.a.e;
import com.tencent.mm.a.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.b;
import com.tencent.mm.network.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.at.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

class c$b implements a {
    private String dXA;
    private String edG;
    private c.a edH;
    final /* synthetic */ c edI;
    private boolean success = false;
    private String username;

    public c$b(c cVar, String str, String str2, c.a aVar) {
        this.edI = cVar;
        this.username = str;
        this.edG = str2;
        this.edH = aVar;
    }

    public final boolean Kr() {
        Throwable e;
        OutputStream outputStream;
        if (bi.oW(this.username)) {
            return false;
        }
        this.dXA = c.my(this.username);
        String str = "";
        if (g.Eg().Dx()) {
            r3 = new Object[4];
            g.Eg();
            r3[1] = o.getString(com.tencent.mm.kernel.a.Df());
            r3[2] = Integer.valueOf(ao.getNetTypeForStat(ad.getContext()));
            r3[3] = Integer.valueOf(ao.getStrength(ad.getContext()));
            str = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d", r3);
        }
        x.d("MicroMsg.RemarkImageStorage", "get remark image user: %s referer: %s  url:%s", new Object[]{this.username, str, this.edG});
        this.success = false;
        u a;
        InputStream inputStream;
        try {
            a = b.a(this.edG, null);
            try {
                a.setRequestMethod("GET");
                a.setRequestProperty("referer", str);
                a.setConnectTimeout(5000);
                a.setReadTimeout(5000);
                if (b.a(a) != 0) {
                    x.e("MicroMsg.RemarkImageStorage", "checkHttpConnection failed! url:%s", new Object[]{this.edG});
                    try {
                        a.aBv.disconnect();
                    } catch (Throwable e2) {
                        x.e("MicroMsg.RemarkImageStorage", "exception:%s", new Object[]{bi.i(e2)});
                    }
                    return true;
                }
                inputStream = a.getInputStream();
                if (inputStream == null) {
                    try {
                        x.d("MicroMsg.RemarkImageStorage", "getInputStream failed. url:%s", new Object[]{this.edG});
                        try {
                            a.aBv.disconnect();
                        } catch (Throwable e22) {
                            x.e("MicroMsg.RemarkImageStorage", "exception:%s", new Object[]{bi.i(e22)});
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e222) {
                                x.e("MicroMsg.RemarkImageStorage", "exception:%s", new Object[]{bi.i(e222)});
                            }
                        }
                        return true;
                    } catch (Exception e3) {
                        e222 = e3;
                        outputStream = null;
                        try {
                            x.e("MicroMsg.RemarkImageStorage", "exception:%s", new Object[]{bi.i(e222)});
                            this.success = false;
                            if (a != null) {
                                try {
                                    a.aBv.disconnect();
                                } catch (Throwable e2222) {
                                    x.e("MicroMsg.RemarkImageStorage", "exception:%s", new Object[]{bi.i(e2222)});
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable e22222) {
                                    x.e("MicroMsg.RemarkImageStorage", "exception:%s", new Object[]{bi.i(e22222)});
                                }
                            }
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (Throwable e222222) {
                                    x.e("MicroMsg.RemarkImageStorage", "exception:%s", new Object[]{bi.i(e222222)});
                                }
                            }
                            return true;
                        } catch (Throwable th) {
                            e222222 = th;
                            if (a != null) {
                                try {
                                    a.aBv.disconnect();
                                } catch (Throwable e4) {
                                    x.e("MicroMsg.RemarkImageStorage", "exception:%s", new Object[]{bi.i(e4)});
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable e5) {
                                    x.e("MicroMsg.RemarkImageStorage", "exception:%s", new Object[]{bi.i(e5)});
                                }
                            }
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (Throwable e52) {
                                    x.e("MicroMsg.RemarkImageStorage", "exception:%s", new Object[]{bi.i(e52)});
                                }
                            }
                            throw e222222;
                        }
                    } catch (Throwable th2) {
                        e222222 = th2;
                        outputStream = null;
                        if (a != null) {
                            try {
                                a.aBv.disconnect();
                            } catch (Throwable e42) {
                                x.e("MicroMsg.RemarkImageStorage", "exception:%s", new Object[]{bi.i(e42)});
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e522) {
                                x.e("MicroMsg.RemarkImageStorage", "exception:%s", new Object[]{bi.i(e522)});
                            }
                        }
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Throwable e5222) {
                                x.e("MicroMsg.RemarkImageStorage", "exception:%s", new Object[]{bi.i(e5222)});
                            }
                        }
                        throw e222222;
                    }
                }
                byte[] bArr = new byte[1024];
                outputStream = new FileOutputStream(this.dXA + ".tmp");
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        outputStream.write(bArr, 0, read);
                    } catch (Exception e6) {
                        e222222 = e6;
                        x.e("MicroMsg.RemarkImageStorage", "exception:%s", new Object[]{bi.i(e222222)});
                        this.success = false;
                        if (a != null) {
                            try {
                                a.aBv.disconnect();
                            } catch (Throwable e2222222) {
                                x.e("MicroMsg.RemarkImageStorage", "exception:%s", new Object[]{bi.i(e2222222)});
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e22222222) {
                                x.e("MicroMsg.RemarkImageStorage", "exception:%s", new Object[]{bi.i(e22222222)});
                            }
                        }
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Throwable e222222222) {
                                x.e("MicroMsg.RemarkImageStorage", "exception:%s", new Object[]{bi.i(e222222222)});
                            }
                        }
                        return true;
                    }
                }
                this.success = true;
                try {
                    a.aBv.disconnect();
                } catch (Throwable e2222222222) {
                    x.e("MicroMsg.RemarkImageStorage", "exception:%s", new Object[]{bi.i(e2222222222)});
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e22222222222) {
                        x.e("MicroMsg.RemarkImageStorage", "exception:%s", new Object[]{bi.i(e22222222222)});
                    }
                }
                try {
                    outputStream.close();
                } catch (Throwable e222222222222) {
                    x.e("MicroMsg.RemarkImageStorage", "exception:%s", new Object[]{bi.i(e222222222222)});
                }
                return true;
            } catch (Exception e7) {
                e222222222222 = e7;
                inputStream = null;
                outputStream = null;
            } catch (Throwable th3) {
                e222222222222 = th3;
                inputStream = null;
                outputStream = null;
                if (a != null) {
                    try {
                        a.aBv.disconnect();
                    } catch (Throwable e422) {
                        x.e("MicroMsg.RemarkImageStorage", "exception:%s", new Object[]{bi.i(e422)});
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e52222) {
                        x.e("MicroMsg.RemarkImageStorage", "exception:%s", new Object[]{bi.i(e52222)});
                    }
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable e522222) {
                        x.e("MicroMsg.RemarkImageStorage", "exception:%s", new Object[]{bi.i(e522222)});
                    }
                }
                throw e222222222222;
            }
        } catch (Exception e8) {
            e222222222222 = e8;
            inputStream = null;
            outputStream = null;
            a = null;
        } catch (Throwable th4) {
            e222222222222 = th4;
            inputStream = null;
            outputStream = null;
            a = null;
            if (a != null) {
                try {
                    a.aBv.disconnect();
                } catch (Throwable e4222) {
                    x.e("MicroMsg.RemarkImageStorage", "exception:%s", new Object[]{bi.i(e4222)});
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e5222222) {
                    x.e("MicroMsg.RemarkImageStorage", "exception:%s", new Object[]{bi.i(e5222222)});
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Throwable e52222222) {
                    x.e("MicroMsg.RemarkImageStorage", "exception:%s", new Object[]{bi.i(e52222222)});
                }
            }
            throw e222222222222;
        }
    }

    public final boolean Ks() {
        if (this.success) {
            e.deleteFile(this.dXA);
            new File(this.dXA + ".tmp").renameTo(new File(this.dXA));
            this.edH.bM(true);
            return true;
        }
        this.edH.bM(false);
        return false;
    }
}
