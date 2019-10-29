package com.epam.springadvanced.parsers;

import com.epam.springadvanced.dto.SubscriberData;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class SubscriberParser {

    public List<SubscriberData> parseToObject(MultipartFile file) throws IOException {
        InputStream is = file.getInputStream();
        BufferedReader buf = new BufferedReader(new InputStreamReader(is));

        String line = buf.readLine();
        StringBuilder sb = new StringBuilder();

        while(line != null){
            sb.append(line).append("\n");
            line = buf.readLine();
        }
        String fileAsString = sb.toString();
        Gson gson = new Gson();

        Type subscriberListType = new TypeToken<ArrayList<SubscriberData>>(){}.getType();

        ArrayList<SubscriberData> subscriberData = gson.fromJson(fileAsString, subscriberListType);
        return subscriberData;
    }
}
