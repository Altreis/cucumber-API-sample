package Tools;

import Pojo.Ppet;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectionsTools {

    private String error = "Something went wrong.";

    public String getJson(String urlAPI, String request, boolean exists) throws IOException {
        URL url = new URL(urlAPI);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod(request);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        if (con.getResponseCode() != 200 && exists) throw new Error(error + "Error code '" + String.valueOf(con.getResponseCode()) + "' , with the message '" + con.getResponseMessage() + "'");
        in.close();
        con.disconnect();

        return String.valueOf(con.getResponseCode());
    }

    public Ppet postJson(Ppet pet, String urlAPI,  String request) throws IOException {
        URL url = new URL(urlAPI);
        ObjectMapper mapper = new ObjectMapper();
        StringBuilder response = new StringBuilder();

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod(request);
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);

        String inputString = mapper.writeValueAsString(pet);

        try(OutputStream os = con.getOutputStream()) {
            byte[] input = inputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        if (con.getResponseCode() != 200) throw new Error(error + " Error code '" + String.valueOf(con.getResponseCode()) + "' , with the message '" + con.getResponseMessage() + "'");

        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
        }

        try {
            String jsonInString = response.toString();
            pet = mapper.readValue(jsonInString, Ppet.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
         return pet;
    }

}
