/**
 * 
 */
package org.rta.coverfox.util;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * @author arun.verma
 *
 */
public class HMACSHA1Base64 {

    public static String getHMACSHA1Base64(String key, String value) {
        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes(), "HmacSHA1");
        Mac sha1_HMAC = null;
        try {
            sha1_HMAC = Mac.getInstance("HmacSHA1");
            sha1_HMAC.init(secret_key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String hmacSha1base64 = Base64.encodeBase64String(sha1_HMAC.doFinal(value.getBytes()));
        return hmacSha1base64;
    }
}
