package com.briup.product_source;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Hashtable;

/**
 * @author zzx
 * @version 1.0
 * @date 2024-08-31 15:18
 */
public class QrcodeTests {
    @Test
    public void method(){
        String id="1111";
        try {
            // 创建一个包含二维码配置的Hashtable
            Hashtable<EncodeHintType, Object> hints = new Hashtable<>();
            hints.put(EncodeHintType.CHARACTER_SET, StandardCharsets.UTF_8.name());

            // 使用ZXing库的QRCodeWriter生成二维码
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(id, BarcodeFormat.QR_CODE, 200, 200, hints);

            // 将BitMatrix转换为二维码图片
            OutputStream os = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", os);

            // 将二维码图片转换为Base64字符串
            byte[] pngImage = ((ByteArrayOutputStream) os).toByteArray();
            String base64String = Base64.getEncoder().encodeToString(pngImage);

            System.out.println(base64String);
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
