/**
 * 
 */
package org.rta.coverfox.cfxapi;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @author arun.verma
 *
 */
public class APICaller {

    private static final Logger logger = Logger.getLogger(APICaller.class);
    private static final RestTemplate restTemplate = new RestTemplate();

    public static ResponseEntity<?> callAPIPost(String apiPath, String sendData, String authorization, String DATE_VALUE,
            String contentType) throws RuntimeException {
        logger.info("Date => " + DATE_VALUE + " api path => " + apiPath);
        logger.debug("Sent Data for Coverfox=> " + sendData);
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", contentType);
        headers.set("Authorization", authorization);
        headers.set("Date", DATE_VALUE);
        HttpEntity<String> entity = new HttpEntity<String>(sendData, headers);
        return restTemplate.exchange(apiPath, HttpMethod.POST, entity, String.class);
    }

    public static ResponseEntity<?> callAPIGet(String apiPath, String authorization, String DATE_VALUE) throws RuntimeException {
        logger.info("Date => " + DATE_VALUE + " api path => " + apiPath);
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", authorization);
        headers.set("Date", DATE_VALUE);
        HttpEntity<String> entity = new HttpEntity<String>("", headers);
        return restTemplate.exchange(apiPath, HttpMethod.GET, entity, String.class);
    }
}
