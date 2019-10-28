package com.epam.springadvanced.parsers;

import com.epam.springadvanced.dto.SubscriberData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
public class SubscriberParser {

    public SubscriberData parseToObject(MultipartFile file) throws IOException {
        InputStream is = file.getInputStream();
        BufferedReader buf = new BufferedReader(new InputStreamReader(is));

        String line = buf.readLine();
        StringBuilder sb = new StringBuilder();

        while(line != null){
            sb.append(line).append("\n");
            line = buf.readLine();
        }

        String fileAsString = sb.toString();
        SubscriberData subscriberData = new ObjectMapper().readValue(fileAsString, SubscriberData.class);
        return subscriberData;
    }
}
