//package com.shoes.customer.JSON;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.Reader;
//import java.net.URL;
//import java.nio.charset.Charset;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.JSONValue;
//
//public class JsonReader {
//    private static String readAll(Reader rd) throws IOException {
//        StringBuilder sb = new StringBuilder();
//        int cp;
//        while ((cp = rd.read()) != -1) {
//            sb.append((char) cp);
//        }
//        return sb.toString();
//    }
//
//    public static JSONArray readJsonFromUrl(String url) throws IOException {
//        InputStream is = new URL(url).openStream();
//        try {
//            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
//            String jsonText = readAll(rd);
//
//            Object obj = JSONValue.parse(jsonText);
//            JSONArray jsonArray = (JSONArray) obj;
//
//            return jsonArray;
//        } finally {
//            is.close();
//        }
//    }
//
//    public List<JSONObject> listSuggest(int uid) throws IOException {
//        JSONArray jsonArray = new JSONArray();
//        try {
//            jsonArray = readJsonFromUrl("http://127.0.0.1:5000/api/collab-filtering/"+uid);
//        }catch (Exception e){
//            return null;
//        }
//        ArrayList<String> list = new ArrayList<String>();
//        List<JSONObject> suggest = new ArrayList<>();
//        if (jsonArray != null) {
//            int len = jsonArray.size();
//            for (int i=0;i<len;i++){
//                list.add(jsonArray.get(i).toString());
//                suggest.add((JSONObject) jsonArray.get(i));
//            }
//        }
//        return suggest;
//    }
//    public static void main(String[] args) throws IOException {
//        JsonReader j = new JsonReader();
//        List<JSONObject> list = j.listSuggest(1);
//        if (list!=null){
//            for (JSONObject item:list){
//                System.out.println(item.get("id"));
//            }
//        }else {
//            System.out.println("rỗng");
//        }
//
//    }
//}
