package com.tencent.mm.plugin.hp.d;

import com.tencent.mm.a.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.b;
import com.tencent.mm.network.u;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;

public final class a implements Runnable {
    public String bKg;
    public boolean dHC = true;
    public boolean erb = true;
    public String ewp;
    public String url;

    public a(String str, String str2, String str3) {
        this.url = str;
        this.ewp = str2;
        this.bKg = str3;
        this.erb = true;
    }

    public final void run() {
        Throwable e;
        InputStream inputStream;
        OutputStream outputStream;
        u uVar;
        u uVar2 = null;
        OutputStream outputStream2 = null;
        try {
            uVar2 = b.a(this.url, null);
            try {
                uVar2.setRequestMethod("GET");
                uVar2.setConnectTimeout(15000);
                uVar2.setReadTimeout(20000);
                if (b.a(uVar2) != 0) {
                    x.e("Tinker.TinkerDownloadTask", "checkHttpConnection failed! url:%s", new Object[]{this.url});
                    return;
                }
                InputStream inputStream2 = uVar2.getInputStream();
                if (inputStream2 == null) {
                    try {
                        x.d("Tinker.TinkerDownloadTask", "getInputStream failed. url:%s", new Object[]{this.url});
                        return;
                    } catch (InterruptedException e2) {
                        e = e2;
                        inputStream = inputStream2;
                        outputStream = outputStream2;
                        uVar = uVar2;
                    } catch (UnknownHostException e3) {
                        e = e3;
                        inputStream = inputStream2;
                        outputStream = outputStream2;
                        uVar = uVar2;
                        this.dHC = true;
                        h.mEJ.a(614, 33, 1, false);
                        x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bi.i(e)});
                        if (uVar != null) {
                            try {
                                uVar.aBv.disconnect();
                            } catch (Throwable e4) {
                                x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e4)});
                                x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e4.getMessage()});
                                return;
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream == null) {
                            outputStream.close();
                        }
                    } catch (SSLHandshakeException e5) {
                        e4 = e5;
                        inputStream = inputStream2;
                        outputStream = outputStream2;
                        uVar = uVar2;
                        this.dHC = true;
                        h.mEJ.a(614, 34, 1, false);
                        x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bi.i(e4)});
                        if (uVar != null) {
                            try {
                                uVar.aBv.disconnect();
                            } catch (Throwable e42) {
                                x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e42)});
                                x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e42.getMessage()});
                                return;
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream == null) {
                            outputStream.close();
                        }
                    } catch (SocketException e6) {
                        e42 = e6;
                        inputStream = inputStream2;
                        outputStream = outputStream2;
                        uVar = uVar2;
                        this.dHC = true;
                        h.mEJ.a(614, 35, 1, false);
                        x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bi.i(e42)});
                        if (uVar != null) {
                            try {
                                uVar.aBv.disconnect();
                            } catch (Throwable e422) {
                                x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e422)});
                                x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e422.getMessage()});
                                return;
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream == null) {
                            outputStream.close();
                        }
                    } catch (SocketTimeoutException e7) {
                        e422 = e7;
                        inputStream = inputStream2;
                        outputStream = outputStream2;
                        uVar = uVar2;
                        this.dHC = true;
                        h.mEJ.a(614, 36, 1, false);
                        x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bi.i(e422)});
                        if (uVar != null) {
                            try {
                                uVar.aBv.disconnect();
                            } catch (Throwable e4222) {
                                x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e4222)});
                                x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e4222.getMessage()});
                                return;
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream == null) {
                            outputStream.close();
                        }
                    } catch (IOException e8) {
                        e4222 = e8;
                        inputStream = inputStream2;
                        outputStream = outputStream2;
                        uVar = uVar2;
                        this.dHC = true;
                        h.mEJ.a(614, 37, 1, false);
                        x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bi.i(e4222)});
                        if (uVar != null) {
                            try {
                                uVar.aBv.disconnect();
                            } catch (Throwable e42222) {
                                x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e42222)});
                                x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e42222.getMessage()});
                                return;
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream == null) {
                            outputStream.close();
                        }
                    } catch (Exception e9) {
                        e42222 = e9;
                        inputStream = inputStream2;
                        outputStream = outputStream2;
                        uVar = uVar2;
                        this.dHC = true;
                        h.mEJ.a(614, 38, 1, false);
                        x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e42222)});
                        if (uVar != null) {
                            try {
                                uVar.aBv.disconnect();
                            } catch (Throwable e422222) {
                                x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e422222)});
                                x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e422222.getMessage()});
                                return;
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream == null) {
                            outputStream.close();
                        }
                    }
                }
                byte[] bArr = new byte[1024];
                outputStream2 = FileOp.jx(this.ewp);
                while (true) {
                    try {
                        int read = inputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        outputStream2.write(bArr, 0, read);
                    } catch (InterruptedException e10) {
                        e422222 = e10;
                        inputStream = inputStream2;
                        outputStream = outputStream2;
                        uVar = uVar2;
                        this.dHC = true;
                        h.mEJ.a(614, 32, 1, false);
                        x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bi.i(e422222)});
                        if (uVar != null) {
                            try {
                                uVar.aBv.disconnect();
                            } catch (Throwable e4222222) {
                                x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e4222222)});
                                x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e4222222.getMessage()});
                                return;
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream == null) {
                            outputStream.close();
                        }
                    } catch (UnknownHostException e11) {
                        e4222222 = e11;
                        inputStream = inputStream2;
                        outputStream = outputStream2;
                        uVar = uVar2;
                        this.dHC = true;
                        h.mEJ.a(614, 33, 1, false);
                        x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bi.i(e4222222)});
                        if (uVar != null) {
                            try {
                                uVar.aBv.disconnect();
                            } catch (Throwable e42222222) {
                                x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e42222222)});
                                x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e42222222.getMessage()});
                                return;
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream == null) {
                            outputStream.close();
                        }
                    } catch (SSLHandshakeException e12) {
                        e42222222 = e12;
                        inputStream = inputStream2;
                        outputStream = outputStream2;
                        uVar = uVar2;
                        this.dHC = true;
                        h.mEJ.a(614, 34, 1, false);
                        x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bi.i(e42222222)});
                        if (uVar != null) {
                            try {
                                uVar.aBv.disconnect();
                            } catch (Throwable e422222222) {
                                x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e422222222)});
                                x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e422222222.getMessage()});
                                return;
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream == null) {
                            outputStream.close();
                        }
                    } catch (SocketException e13) {
                        e422222222 = e13;
                        inputStream = inputStream2;
                        outputStream = outputStream2;
                        uVar = uVar2;
                        this.dHC = true;
                        h.mEJ.a(614, 35, 1, false);
                        x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bi.i(e422222222)});
                        if (uVar != null) {
                            try {
                                uVar.aBv.disconnect();
                            } catch (Throwable e4222222222) {
                                x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e4222222222)});
                                x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e4222222222.getMessage()});
                                return;
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream == null) {
                            outputStream.close();
                        }
                    } catch (SocketTimeoutException e14) {
                        e4222222222 = e14;
                        inputStream = inputStream2;
                        outputStream = outputStream2;
                        uVar = uVar2;
                        this.dHC = true;
                        h.mEJ.a(614, 36, 1, false);
                        x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bi.i(e4222222222)});
                        if (uVar != null) {
                            try {
                                uVar.aBv.disconnect();
                            } catch (Throwable e42222222222) {
                                x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e42222222222)});
                                x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e42222222222.getMessage()});
                                return;
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream == null) {
                            outputStream.close();
                        }
                    } catch (IOException e15) {
                        e42222222222 = e15;
                        inputStream = inputStream2;
                        outputStream = outputStream2;
                        uVar = uVar2;
                        this.dHC = true;
                        h.mEJ.a(614, 37, 1, false);
                        x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bi.i(e42222222222)});
                        if (uVar != null) {
                            try {
                                uVar.aBv.disconnect();
                            } catch (Throwable e422222222222) {
                                x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e422222222222)});
                                x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e422222222222.getMessage()});
                                return;
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream == null) {
                            outputStream.close();
                        }
                    } catch (Exception e16) {
                        e422222222222 = e16;
                        inputStream = inputStream2;
                        outputStream = outputStream2;
                        uVar = uVar2;
                        this.dHC = true;
                        h.mEJ.a(614, 38, 1, false);
                        x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e422222222222)});
                        if (uVar != null) {
                            try {
                                uVar.aBv.disconnect();
                            } catch (Throwable e4222222222222) {
                                x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e4222222222222)});
                                x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e4222222222222.getMessage()});
                                return;
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream == null) {
                            outputStream.close();
                        }
                    }
                }
                this.dHC = false;
                outputStream2.close();
                outputStream = null;
                try {
                    uVar2.aBv.disconnect();
                    uVar = null;
                } catch (InterruptedException e17) {
                    e4222222222222 = e17;
                    inputStream = inputStream2;
                    uVar = uVar2;
                    this.dHC = true;
                    h.mEJ.a(614, 32, 1, false);
                    x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bi.i(e4222222222222)});
                    if (uVar != null) {
                        try {
                            uVar.aBv.disconnect();
                        } catch (Throwable e42222222222222) {
                            x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e42222222222222)});
                            x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e42222222222222.getMessage()});
                            return;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream == null) {
                        outputStream.close();
                    }
                } catch (UnknownHostException e18) {
                    e42222222222222 = e18;
                    inputStream = inputStream2;
                    uVar = uVar2;
                    this.dHC = true;
                    h.mEJ.a(614, 33, 1, false);
                    x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bi.i(e42222222222222)});
                    if (uVar != null) {
                        try {
                            uVar.aBv.disconnect();
                        } catch (Throwable e422222222222222) {
                            x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e422222222222222)});
                            x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e422222222222222.getMessage()});
                            return;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream == null) {
                        outputStream.close();
                    }
                } catch (SSLHandshakeException e19) {
                    e422222222222222 = e19;
                    inputStream = inputStream2;
                    uVar = uVar2;
                    this.dHC = true;
                    h.mEJ.a(614, 34, 1, false);
                    x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bi.i(e422222222222222)});
                    if (uVar != null) {
                        try {
                            uVar.aBv.disconnect();
                        } catch (Throwable e4222222222222222) {
                            x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e4222222222222222)});
                            x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e4222222222222222.getMessage()});
                            return;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream == null) {
                        outputStream.close();
                    }
                } catch (SocketException e20) {
                    e4222222222222222 = e20;
                    inputStream = inputStream2;
                    uVar = uVar2;
                    this.dHC = true;
                    h.mEJ.a(614, 35, 1, false);
                    x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bi.i(e4222222222222222)});
                    if (uVar != null) {
                        try {
                            uVar.aBv.disconnect();
                        } catch (Throwable e42222222222222222) {
                            x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e42222222222222222)});
                            x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e42222222222222222.getMessage()});
                            return;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream == null) {
                        outputStream.close();
                    }
                } catch (SocketTimeoutException e21) {
                    e42222222222222222 = e21;
                    inputStream = inputStream2;
                    uVar = uVar2;
                    this.dHC = true;
                    h.mEJ.a(614, 36, 1, false);
                    x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bi.i(e42222222222222222)});
                    if (uVar != null) {
                        try {
                            uVar.aBv.disconnect();
                        } catch (Throwable e422222222222222222) {
                            x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e422222222222222222)});
                            x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e422222222222222222.getMessage()});
                            return;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream == null) {
                        outputStream.close();
                    }
                } catch (IOException e22) {
                    e422222222222222222 = e22;
                    inputStream = inputStream2;
                    uVar = uVar2;
                    this.dHC = true;
                    h.mEJ.a(614, 37, 1, false);
                    x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bi.i(e422222222222222222)});
                    if (uVar != null) {
                        try {
                            uVar.aBv.disconnect();
                        } catch (Throwable e4222222222222222222) {
                            x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e4222222222222222222)});
                            x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e4222222222222222222.getMessage()});
                            return;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream == null) {
                        outputStream.close();
                    }
                } catch (Exception e23) {
                    e4222222222222222222 = e23;
                    inputStream = inputStream2;
                    uVar = uVar2;
                    this.dHC = true;
                    h.mEJ.a(614, 38, 1, false);
                    x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e4222222222222222222)});
                    if (uVar != null) {
                        try {
                            uVar.aBv.disconnect();
                        } catch (Throwable e42222222222222222222) {
                            x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e42222222222222222222)});
                            x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e42222222222222222222.getMessage()});
                            return;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream == null) {
                        outputStream.close();
                    }
                }
                try {
                    inputStream2.close();
                    inputStream = null;
                    try {
                        if (!g.cu(this.ewp).equalsIgnoreCase(this.bKg)) {
                            x.d("Tinker.TinkerDownloadTask", "hp_apply md5 mismatched, ignored");
                            h.mEJ.a(614, 30, 1, false);
                            this.dHC = true;
                        }
                    } catch (InterruptedException e24) {
                        e42222222222222222222 = e24;
                        this.dHC = true;
                        h.mEJ.a(614, 32, 1, false);
                        x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bi.i(e42222222222222222222)});
                        if (uVar != null) {
                            try {
                                uVar.aBv.disconnect();
                            } catch (Throwable e422222222222222222222) {
                                x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e422222222222222222222)});
                                x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e422222222222222222222.getMessage()});
                                return;
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream == null) {
                            outputStream.close();
                        }
                    } catch (UnknownHostException e25) {
                        e422222222222222222222 = e25;
                        this.dHC = true;
                        h.mEJ.a(614, 33, 1, false);
                        x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bi.i(e422222222222222222222)});
                        if (uVar != null) {
                            try {
                                uVar.aBv.disconnect();
                            } catch (Throwable e4222222222222222222222) {
                                x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e4222222222222222222222)});
                                x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e4222222222222222222222.getMessage()});
                                return;
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream == null) {
                            outputStream.close();
                        }
                    } catch (SSLHandshakeException e26) {
                        e4222222222222222222222 = e26;
                        this.dHC = true;
                        h.mEJ.a(614, 34, 1, false);
                        x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bi.i(e4222222222222222222222)});
                        if (uVar != null) {
                            try {
                                uVar.aBv.disconnect();
                            } catch (Throwable e42222222222222222222222) {
                                x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e42222222222222222222222)});
                                x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e42222222222222222222222.getMessage()});
                                return;
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream == null) {
                            outputStream.close();
                        }
                    } catch (SocketException e27) {
                        e42222222222222222222222 = e27;
                        this.dHC = true;
                        h.mEJ.a(614, 35, 1, false);
                        x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bi.i(e42222222222222222222222)});
                        if (uVar != null) {
                            try {
                                uVar.aBv.disconnect();
                            } catch (Throwable e422222222222222222222222) {
                                x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e422222222222222222222222)});
                                x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e422222222222222222222222.getMessage()});
                                return;
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream == null) {
                            outputStream.close();
                        }
                    } catch (SocketTimeoutException e28) {
                        e422222222222222222222222 = e28;
                        this.dHC = true;
                        h.mEJ.a(614, 36, 1, false);
                        x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bi.i(e422222222222222222222222)});
                        if (uVar != null) {
                            try {
                                uVar.aBv.disconnect();
                            } catch (Throwable e4222222222222222222222222) {
                                x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e4222222222222222222222222)});
                                x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e4222222222222222222222222.getMessage()});
                                return;
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream == null) {
                            outputStream.close();
                        }
                    } catch (IOException e29) {
                        e4222222222222222222222222 = e29;
                        this.dHC = true;
                        h.mEJ.a(614, 37, 1, false);
                        x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bi.i(e4222222222222222222222222)});
                        if (uVar != null) {
                            try {
                                uVar.aBv.disconnect();
                            } catch (Throwable e42222222222222222222222222) {
                                x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e42222222222222222222222222)});
                                x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e42222222222222222222222222.getMessage()});
                                return;
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream == null) {
                            outputStream.close();
                        }
                    } catch (Exception e30) {
                        e42222222222222222222222222 = e30;
                        this.dHC = true;
                        h.mEJ.a(614, 38, 1, false);
                        x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e42222222222222222222222222)});
                        if (uVar != null) {
                            try {
                                uVar.aBv.disconnect();
                            } catch (Throwable e422222222222222222222222222) {
                                x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e422222222222222222222222222)});
                                x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e422222222222222222222222222.getMessage()});
                                return;
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream == null) {
                            outputStream.close();
                        }
                    }
                } catch (InterruptedException e31) {
                    e422222222222222222222222222 = e31;
                    inputStream = inputStream2;
                    this.dHC = true;
                    h.mEJ.a(614, 32, 1, false);
                    x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bi.i(e422222222222222222222222222)});
                    if (uVar != null) {
                        try {
                            uVar.aBv.disconnect();
                        } catch (Throwable e4222222222222222222222222222) {
                            x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e4222222222222222222222222222)});
                            x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e4222222222222222222222222222.getMessage()});
                            return;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream == null) {
                        outputStream.close();
                    }
                } catch (UnknownHostException e32) {
                    e4222222222222222222222222222 = e32;
                    inputStream = inputStream2;
                    this.dHC = true;
                    h.mEJ.a(614, 33, 1, false);
                    x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bi.i(e4222222222222222222222222222)});
                    if (uVar != null) {
                        try {
                            uVar.aBv.disconnect();
                        } catch (Throwable e42222222222222222222222222222) {
                            x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e42222222222222222222222222222)});
                            x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e42222222222222222222222222222.getMessage()});
                            return;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream == null) {
                        outputStream.close();
                    }
                } catch (SSLHandshakeException e33) {
                    e42222222222222222222222222222 = e33;
                    inputStream = inputStream2;
                    this.dHC = true;
                    h.mEJ.a(614, 34, 1, false);
                    x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bi.i(e42222222222222222222222222222)});
                    if (uVar != null) {
                        try {
                            uVar.aBv.disconnect();
                        } catch (Throwable e422222222222222222222222222222) {
                            x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e422222222222222222222222222222)});
                            x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e422222222222222222222222222222.getMessage()});
                            return;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream == null) {
                        outputStream.close();
                    }
                } catch (SocketException e34) {
                    e422222222222222222222222222222 = e34;
                    inputStream = inputStream2;
                    this.dHC = true;
                    h.mEJ.a(614, 35, 1, false);
                    x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bi.i(e422222222222222222222222222222)});
                    if (uVar != null) {
                        try {
                            uVar.aBv.disconnect();
                        } catch (Throwable e4222222222222222222222222222222) {
                            x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e4222222222222222222222222222222)});
                            x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e4222222222222222222222222222222.getMessage()});
                            return;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream == null) {
                        outputStream.close();
                    }
                } catch (SocketTimeoutException e35) {
                    e4222222222222222222222222222222 = e35;
                    inputStream = inputStream2;
                    this.dHC = true;
                    h.mEJ.a(614, 36, 1, false);
                    x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bi.i(e4222222222222222222222222222222)});
                    if (uVar != null) {
                        try {
                            uVar.aBv.disconnect();
                        } catch (Throwable e42222222222222222222222222222222) {
                            x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e42222222222222222222222222222222)});
                            x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e42222222222222222222222222222222.getMessage()});
                            return;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream == null) {
                        outputStream.close();
                    }
                } catch (IOException e36) {
                    e42222222222222222222222222222222 = e36;
                    inputStream = inputStream2;
                    this.dHC = true;
                    h.mEJ.a(614, 37, 1, false);
                    x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bi.i(e42222222222222222222222222222222)});
                    if (uVar != null) {
                        try {
                            uVar.aBv.disconnect();
                        } catch (Throwable e422222222222222222222222222222222) {
                            x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e422222222222222222222222222222222)});
                            x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e422222222222222222222222222222222.getMessage()});
                            return;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream == null) {
                        outputStream.close();
                    }
                } catch (Exception e37) {
                    e422222222222222222222222222222222 = e37;
                    inputStream = inputStream2;
                    this.dHC = true;
                    h.mEJ.a(614, 38, 1, false);
                    x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e422222222222222222222222222222222)});
                    if (uVar != null) {
                        try {
                            uVar.aBv.disconnect();
                        } catch (Throwable e4222222222222222222222222222222222) {
                            x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e4222222222222222222222222222222222)});
                            x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e4222222222222222222222222222222222.getMessage()});
                            return;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream == null) {
                        outputStream.close();
                    }
                }
                if (uVar != null) {
                    try {
                        uVar.aBv.disconnect();
                    } catch (Throwable e42222222222222222222222222222222222) {
                        x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e42222222222222222222222222222222222)});
                        x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e42222222222222222222222222222222222.getMessage()});
                        return;
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream == null) {
                    outputStream.close();
                }
            } catch (InterruptedException e38) {
                e42222222222222222222222222222222222 = e38;
                inputStream = null;
                outputStream = outputStream2;
                uVar = uVar2;
                this.dHC = true;
                h.mEJ.a(614, 32, 1, false);
                x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bi.i(e42222222222222222222222222222222222)});
                if (uVar != null) {
                    try {
                        uVar.aBv.disconnect();
                    } catch (Throwable e422222222222222222222222222222222222) {
                        x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e422222222222222222222222222222222222)});
                        x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e422222222222222222222222222222222222.getMessage()});
                        return;
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream == null) {
                    outputStream.close();
                }
            } catch (UnknownHostException e39) {
                e422222222222222222222222222222222222 = e39;
                inputStream = null;
                outputStream = outputStream2;
                uVar = uVar2;
                this.dHC = true;
                h.mEJ.a(614, 33, 1, false);
                x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bi.i(e422222222222222222222222222222222222)});
                if (uVar != null) {
                    try {
                        uVar.aBv.disconnect();
                    } catch (Throwable e4222222222222222222222222222222222222) {
                        x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e4222222222222222222222222222222222222)});
                        x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e4222222222222222222222222222222222222.getMessage()});
                        return;
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream == null) {
                    outputStream.close();
                }
            } catch (SSLHandshakeException e40) {
                e4222222222222222222222222222222222222 = e40;
                inputStream = null;
                outputStream = outputStream2;
                uVar = uVar2;
                this.dHC = true;
                h.mEJ.a(614, 34, 1, false);
                x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bi.i(e4222222222222222222222222222222222222)});
                if (uVar != null) {
                    try {
                        uVar.aBv.disconnect();
                    } catch (Throwable e42222222222222222222222222222222222222) {
                        x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e42222222222222222222222222222222222222)});
                        x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e42222222222222222222222222222222222222.getMessage()});
                        return;
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream == null) {
                    outputStream.close();
                }
            } catch (SocketException e41) {
                e42222222222222222222222222222222222222 = e41;
                inputStream = null;
                outputStream = outputStream2;
                uVar = uVar2;
                this.dHC = true;
                h.mEJ.a(614, 35, 1, false);
                x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bi.i(e42222222222222222222222222222222222222)});
                if (uVar != null) {
                    try {
                        uVar.aBv.disconnect();
                    } catch (Throwable e422222222222222222222222222222222222222) {
                        x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e422222222222222222222222222222222222222)});
                        x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e422222222222222222222222222222222222222.getMessage()});
                        return;
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream == null) {
                    outputStream.close();
                }
            } catch (SocketTimeoutException e43) {
                e422222222222222222222222222222222222222 = e43;
                inputStream = null;
                outputStream = outputStream2;
                uVar = uVar2;
                this.dHC = true;
                h.mEJ.a(614, 36, 1, false);
                x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bi.i(e422222222222222222222222222222222222222)});
                if (uVar != null) {
                    try {
                        uVar.aBv.disconnect();
                    } catch (Throwable e4222222222222222222222222222222222222222) {
                        x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e4222222222222222222222222222222222222222)});
                        x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e4222222222222222222222222222222222222222.getMessage()});
                        return;
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream == null) {
                    outputStream.close();
                }
            } catch (IOException e44) {
                e4222222222222222222222222222222222222222 = e44;
                inputStream = null;
                outputStream = outputStream2;
                uVar = uVar2;
                this.dHC = true;
                h.mEJ.a(614, 37, 1, false);
                x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bi.i(e4222222222222222222222222222222222222222)});
                if (uVar != null) {
                    try {
                        uVar.aBv.disconnect();
                    } catch (Throwable e42222222222222222222222222222222222222222) {
                        x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e42222222222222222222222222222222222222222)});
                        x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e42222222222222222222222222222222222222222.getMessage()});
                        return;
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream == null) {
                    outputStream.close();
                }
            } catch (Exception e45) {
                e42222222222222222222222222222222222222222 = e45;
                inputStream = null;
                outputStream = outputStream2;
                uVar = uVar2;
                this.dHC = true;
                h.mEJ.a(614, 38, 1, false);
                x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e42222222222222222222222222222222222222222)});
                if (uVar != null) {
                    try {
                        uVar.aBv.disconnect();
                    } catch (Throwable e422222222222222222222222222222222222222222) {
                        x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e422222222222222222222222222222222222222222)});
                        x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e422222222222222222222222222222222222222222.getMessage()});
                        return;
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream == null) {
                    outputStream.close();
                }
            }
        } catch (InterruptedException e46) {
            e422222222222222222222222222222222222222222 = e46;
            inputStream = null;
            outputStream = outputStream2;
            uVar = uVar2;
        } catch (UnknownHostException e47) {
            e422222222222222222222222222222222222222222 = e47;
            inputStream = null;
            outputStream = outputStream2;
            uVar = uVar2;
            this.dHC = true;
            h.mEJ.a(614, 33, 1, false);
            x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bi.i(e422222222222222222222222222222222222222222)});
            if (uVar != null) {
                try {
                    uVar.aBv.disconnect();
                } catch (Throwable e4222222222222222222222222222222222222222222) {
                    x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e4222222222222222222222222222222222222222222)});
                    x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e4222222222222222222222222222222222222222222.getMessage()});
                    return;
                }
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream == null) {
                outputStream.close();
            }
        } catch (SSLHandshakeException e48) {
            e4222222222222222222222222222222222222222222 = e48;
            inputStream = null;
            outputStream = outputStream2;
            uVar = uVar2;
            this.dHC = true;
            h.mEJ.a(614, 34, 1, false);
            x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bi.i(e4222222222222222222222222222222222222222222)});
            if (uVar != null) {
                try {
                    uVar.aBv.disconnect();
                } catch (Throwable e42222222222222222222222222222222222222222222) {
                    x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e42222222222222222222222222222222222222222222)});
                    x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e42222222222222222222222222222222222222222222.getMessage()});
                    return;
                }
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream == null) {
                outputStream.close();
            }
        } catch (SocketException e49) {
            e42222222222222222222222222222222222222222222 = e49;
            inputStream = null;
            outputStream = outputStream2;
            uVar = uVar2;
            this.dHC = true;
            h.mEJ.a(614, 35, 1, false);
            x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bi.i(e42222222222222222222222222222222222222222222)});
            if (uVar != null) {
                try {
                    uVar.aBv.disconnect();
                } catch (Throwable e422222222222222222222222222222222222222222222) {
                    x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e422222222222222222222222222222222222222222222)});
                    x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e422222222222222222222222222222222222222222222.getMessage()});
                    return;
                }
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream == null) {
                outputStream.close();
            }
        } catch (SocketTimeoutException e50) {
            e422222222222222222222222222222222222222222222 = e50;
            inputStream = null;
            outputStream = outputStream2;
            uVar = uVar2;
            this.dHC = true;
            h.mEJ.a(614, 36, 1, false);
            x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bi.i(e422222222222222222222222222222222222222222222)});
            if (uVar != null) {
                try {
                    uVar.aBv.disconnect();
                } catch (Throwable e4222222222222222222222222222222222222222222222) {
                    x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e4222222222222222222222222222222222222222222222)});
                    x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e4222222222222222222222222222222222222222222222.getMessage()});
                    return;
                }
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream == null) {
                outputStream.close();
            }
        } catch (IOException e51) {
            e4222222222222222222222222222222222222222222222 = e51;
            inputStream = null;
            outputStream = outputStream2;
            uVar = uVar2;
            this.dHC = true;
            h.mEJ.a(614, 37, 1, false);
            x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bi.i(e4222222222222222222222222222222222222222222222)});
            if (uVar != null) {
                try {
                    uVar.aBv.disconnect();
                } catch (Throwable e42222222222222222222222222222222222222222222222) {
                    x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e42222222222222222222222222222222222222222222222)});
                    x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e42222222222222222222222222222222222222222222222.getMessage()});
                    return;
                }
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream == null) {
                outputStream.close();
            }
        } catch (Exception e52) {
            e42222222222222222222222222222222222222222222222 = e52;
            inputStream = null;
            outputStream = outputStream2;
            uVar = uVar2;
            this.dHC = true;
            h.mEJ.a(614, 38, 1, false);
            x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e42222222222222222222222222222222222222222222222)});
            if (uVar != null) {
                try {
                    uVar.aBv.disconnect();
                } catch (Throwable e422222222222222222222222222222222222222222222222) {
                    x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bi.i(e422222222222222222222222222222222222222222222222)});
                    x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e422222222222222222222222222222222222222222222222.getMessage()});
                    return;
                }
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream == null) {
                outputStream.close();
            }
        }
    }
}
